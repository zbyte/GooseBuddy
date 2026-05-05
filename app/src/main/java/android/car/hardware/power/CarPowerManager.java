package android.car.hardware.power;


import android.car.Car;
import android.car.CarManagerBase;
import android.car.CarNotConnectedException;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.GuardedBy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;


public class CarPowerManager implements CarManagerBase {
    @Retention(RetentionPolicy.SOURCE)
    public @interface BootReason {
    }

    public interface CarPowerStateListener {
        public static final int SHUTDOWN_CANCELLED = 0;
        public static final int SHUTDOWN_ENTER = 1;
        public static final int SUSPEND_ENTER = 2;
        public static final int SUSPEND_EXIT = 3;

        void onStateChanged(int arg1);
    }

    public static final int BOOT_REASON_DOOR_OPEN = 4;
    public static final int BOOT_REASON_DOOR_UNLOCK = 2;
    public static final int BOOT_REASON_REMOTE_START = 5;
    public static final int BOOT_REASON_TIMER = 3;
    public static final int BOOT_REASON_USER_POWER_ON = 1;
    private static final boolean DBG = false;
    private static final String TAG = "CarPowerManager";
    private Executor mExecutor;
    private CarPowerStateListener mListener;
    @GuardedBy("mLock")
    private ICarPowerStateListener mListenerToService;
    private final Object mLock;
    private final ICarPower mService;

    public CarPowerManager(IBinder service, Context context, Handler handler) {
        this.mLock = new Object();
        this.mService = ICarPower.Stub.asInterface(service);
    }

    public void clearListener() {
        ICarPowerStateListener listenerToService;
        synchronized(this.mLock) {
            listenerToService = this.mListenerToService;
            this.mListenerToService = null;
            this.mListener = null;
            this.mExecutor = null;
        }
        if(listenerToService == null) {
            Log.w("CarPowerManager", "unregisterListener: listener was not registered");
            return;
        }
        try {
            this.mService.unregisterListener(listenerToService);
        }
        catch(RemoteException ex) {
            Log.e("CarPowerManager", "Failed to unregister listener", ex);
        }
        catch(IllegalStateException ex) {
            Car.hideCarNotConnectedExceptionFromCarService(ex);
        }
    }

    public int getBootReason() throws CarNotConnectedException {
        try {
            return this.mService.getBootReason();
        }
        catch(RemoteException e) {
            Log.e("CarPowerManager", "Exception in getBootReason", e);
            throw new CarNotConnectedException(e);
        }
    }

    private void handleEvent(int state, int token) {
        Executor executor;
        synchronized(this.mLock) {
            executor = this.mExecutor;
        }
        if(executor != null) {
            executor.execute(() -> this.handleEventInternal(state, token));
            return;
        }
        this.handleEventInternal(state, token);
    }

    private void handleEventInternal(int state, int token) {
        this.mListener.onStateChanged(state);
        if(state == 1 || state == 2) {
            try {
                this.mService.finished(this.mListenerToService, token);
            }
            catch(RemoteException e) {
                Log.e("CarPowerManager", "Exception in finished", e);
            }
        }
    }

    @Override  // android.car.CarManagerBase
    public void onCarDisconnected() {
        synchronized(this.mLock) {
        }
        if(this.mListenerToService != null) {
            this.clearListener();
        }
    }

    public void requestShutdownOnNextSuspend() throws CarNotConnectedException {
        try {
            this.mService.requestShutdownOnNextSuspend();
        }
        catch(RemoteException e) {
            Log.e("CarPowerManager", "Exception in requestShutdownOnNextSuspend", e);
            throw new CarNotConnectedException(e);
        }
    }

    public void setListener(CarPowerStateListener listener, Executor executor) throws CarNotConnectedException, IllegalStateException {
        synchronized(this.mLock) {
            if(this.mListenerToService == null) {
                android.car.hardware.power.ICarPowerStateListener listenerToService = new android.car.hardware.power.ICarPowerStateListener.Stub() {
                    @Override  // android.car.hardware.power.ICarPowerStateListener
                    public void onStateChanged(int state, int token) throws RemoteException {
                        CarPowerManager.this.handleEvent(state, token);
                    }
                };
                try {
                    this.mService.registerListener(listenerToService);
                    this.mListenerToService = listenerToService;
                }
                catch(RemoteException ex) {
                    Log.e("CarPowerManager", "Could not connect: ", ex);
                    throw new CarNotConnectedException(ex);
                }
                catch(IllegalStateException ex) {
                    Car.checkCarNotConnectedExceptionFromCarService(ex);
                }
            }
            if(this.mExecutor == null && this.mListener == null) {
                this.mExecutor = executor;
                this.mListener = listener;
                return;
            }
        }
        throw new IllegalStateException("Listener must be cleared first");
    }
}

