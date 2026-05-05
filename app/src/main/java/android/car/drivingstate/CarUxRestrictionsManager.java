package android.car.drivingstate;

import android.car.Car;
import android.car.CarManagerBase;
import android.car.CarNotConnectedException;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import java.lang.ref.WeakReference;

public final class CarUxRestrictionsManager implements CarManagerBase {
    static class CarUxRestrictionsChangeListenerToService extends ICarUxRestrictionsChangeListener.Stub {
        private final WeakReference mUxRestrictionsManager;

        public CarUxRestrictionsChangeListenerToService(CarUxRestrictionsManager manager) {
            this.mUxRestrictionsManager = new WeakReference(manager);
        }

        @Override  // android.car.drivingstate.ICarUxRestrictionsChangeListener
        public void onUxRestrictionsChanged(CarUxRestrictions restrictionInfo) {
            CarUxRestrictionsManager manager = (CarUxRestrictionsManager)this.mUxRestrictionsManager.get();
            if(manager != null) {
                manager.handleUxRestrictionsChanged(restrictionInfo);
            }
        }
    }

    static final class EventCallbackHandler extends Handler {
        private final WeakReference mUxRestrictionsManager;

        public EventCallbackHandler(CarUxRestrictionsManager manager, Looper looper) {
            super(looper);
            this.mUxRestrictionsManager = new WeakReference(manager);
        }

        @Override  // android.os.Handler
        public void handleMessage(Message msg) {
            CarUxRestrictionsManager mgr = (CarUxRestrictionsManager)this.mUxRestrictionsManager.get();
            if(mgr != null) {
                mgr.dispatchUxRChangeToClient(((CarUxRestrictions)msg.obj));
            }
        }
    }

    public interface OnUxRestrictionsChangedListener {
        void onUxRestrictionsChanged(CarUxRestrictions arg1);
    }

    private static final boolean DBG = false;
    private static final int MSG_HANDLE_UX_RESTRICTIONS_CHANGE = 0;
    private static final String TAG = "CarUxRManager";
    private static final boolean VDBG = false;
    private final Context mContext;
    private final EventCallbackHandler mEventCallbackHandler;
    private CarUxRestrictionsChangeListenerToService mListenerToService;
    private OnUxRestrictionsChangedListener mUxRListener;
    private final ICarUxRestrictionsManager mUxRService;

    public CarUxRestrictionsManager(IBinder service, Context context, Handler handler) {
        this.mContext = context;
        this.mUxRService = android.car.drivingstate.ICarUxRestrictionsManager.Stub.asInterface(service);
        this.mEventCallbackHandler = new EventCallbackHandler(this, handler.getLooper());
    }

    private void dispatchUxRChangeToClient(CarUxRestrictions restrictionInfo) {
        OnUxRestrictionsChangedListener listener;
        if(restrictionInfo == null) {
            return;
        }
        synchronized(this) {
            listener = this.mUxRListener;
        }
        if(listener != null) {
            listener.onUxRestrictionsChanged(restrictionInfo);
        }
    }

    public CarUxRestrictions getCurrentCarUxRestrictions() throws CarNotConnectedException {
        try {
            return this.mUxRService.getCurrentUxRestrictions();
        }
        catch(RemoteException e) {
            Log.e("CarUxRManager", "Could not get current UX restrictions " + e);
            throw new CarNotConnectedException(e);
        }
    }

    private void handleUxRestrictionsChanged(CarUxRestrictions restrictionInfo) {
        Message message0 = this.mEventCallbackHandler.obtainMessage(0, restrictionInfo);
        this.mEventCallbackHandler.sendMessage(message0);
    }

    @Override  // android.car.CarManagerBase
    public void onCarDisconnected() {
        synchronized(this) {
            this.mListenerToService = null;
            this.mUxRListener = null;
        }
    }

    public void registerListener(OnUxRestrictionsChangedListener listener) throws CarNotConnectedException, IllegalArgumentException {
        synchronized(this) {
            if(listener == null) {
                throw new IllegalArgumentException("Listener is null");
            }
        }
        if(this.mUxRListener != null) {
            return;
        }

        this.mUxRListener = listener;
        try {
            if(this.mListenerToService == null) {
                this.mListenerToService = new CarUxRestrictionsChangeListenerToService(this);
            }
            this.mUxRService.registerUxRestrictionsChangeListener(this.mListenerToService);
            return;
        }
        catch(RemoteException e) {
            Log.e("CarUxRManager", "Could not register a listener to CarUxRestrictionsManagerService " + e);
            throw new CarNotConnectedException(e);
        }
        catch(IllegalStateException e) {
            Log.e("CarUxRManager", "Could not register a listener to CarUxRestrictionsManagerService " + e);
            Car.checkCarNotConnectedExceptionFromCarService(e);
            return;
        }
    }

    public void unregisterListener() throws CarNotConnectedException {
        synchronized (this) {
            if (this.mUxRListener == null) {
                return;
            }
            try {
                this.mUxRService.unregisterUxRestrictionsChangeListener(this.mListenerToService);
                this.mUxRListener = null;

            } catch (RemoteException e) {
                Log.e(
                        "CarUxRManager",
                        "Could not unregister listener from Driving State Service " + e);
                throw new CarNotConnectedException(e);
            }
        }
    }
}

