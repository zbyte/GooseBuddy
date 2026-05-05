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


public final class CarDrivingStateManager implements CarManagerBase {
    static class CarDrivingStateChangeListenerToService extends ICarDrivingStateChangeListener.Stub {
        private final WeakReference mDrvStateMgr;

        public CarDrivingStateChangeListenerToService(CarDrivingStateManager manager) {
            this.mDrvStateMgr = new WeakReference(manager);
        }

        @Override  // android.car.drivingstate.ICarDrivingStateChangeListener
        public void onDrivingStateChanged(CarDrivingStateEvent event) {
            CarDrivingStateManager manager = (CarDrivingStateManager)this.mDrvStateMgr.get();
            if(manager != null) {
                manager.handleDrivingStateChanged(event);
            }
        }
    }

    public interface CarDrivingStateEventListener {
        void onDrivingStateChanged(CarDrivingStateEvent arg1);
    }

    static final class EventCallbackHandler extends Handler {
        private final WeakReference mDrvStateMgr;

        public EventCallbackHandler(CarDrivingStateManager manager, Looper looper) {
            super(looper);
            this.mDrvStateMgr = new WeakReference(manager);
        }

        @Override  // android.os.Handler
        public void handleMessage(Message msg) {
            CarDrivingStateManager mgr = (CarDrivingStateManager)this.mDrvStateMgr.get();
            if(mgr != null) {
                mgr.dispatchDrivingStateChangeToClient(((CarDrivingStateEvent)msg.obj));
            }
        }
    }

    private static final boolean DBG = false;
    private static final int MSG_HANDLE_DRIVING_STATE_CHANGE = 0;
    private static final String TAG = "CarDrivingStateMgr";
    private static final boolean VDBG = false;
    private final Context mContext;
    private final ICarDrivingState mDrivingService;
    private CarDrivingStateEventListener mDrvStateEventListener;
    private final EventCallbackHandler mEventCallbackHandler;
    private CarDrivingStateChangeListenerToService mListenerToService;

    public CarDrivingStateManager(IBinder service, Context context, Handler handler) {
        this.mContext = context;
        this.mDrivingService = android.car.drivingstate.ICarDrivingState.Stub.asInterface(service);
        this.mEventCallbackHandler = new EventCallbackHandler(this, handler.getLooper());
    }

    private void dispatchDrivingStateChangeToClient(CarDrivingStateEvent event) {
        CarDrivingStateEventListener listener;
        if(event == null) {
            return;
        }
        synchronized(this) {
            listener = this.mDrvStateEventListener;
        }
        if(listener != null) {
            listener.onDrivingStateChanged(event);
        }
    }

    public CarDrivingStateEvent getCurrentCarDrivingState() throws CarNotConnectedException {
        try {
            return this.mDrivingService.getCurrentDrivingState();
        }
        catch(RemoteException e) {
            Log.e("CarDrivingStateMgr", "Could not get current driving state " + e);
            throw new CarNotConnectedException(e);
        }
    }

    private void handleDrivingStateChanged(CarDrivingStateEvent event) {
        Message message0 = this.mEventCallbackHandler.obtainMessage(0, event);
        this.mEventCallbackHandler.sendMessage(message0);
    }

    @Override  // android.car.CarManagerBase
    public void onCarDisconnected() {
        synchronized(this) {
            this.mListenerToService = null;
            this.mDrvStateEventListener = null;
        }
    }

    public void registerListener(CarDrivingStateEventListener listener) throws CarNotConnectedException, IllegalArgumentException {
        synchronized(this) {
            if(listener == null) {
                throw new IllegalArgumentException("Listener is null");
            }
        }
        if(this.mDrvStateEventListener != null) {
            return;
        }

        this.mDrvStateEventListener = listener;
        try {
            if(this.mListenerToService == null) {
                this.mListenerToService = new CarDrivingStateChangeListenerToService(this);
            }
            this.mDrivingService.registerDrivingStateChangeListener(this.mListenerToService);
            return;
        }
        catch(RemoteException e) {
            Log.e("CarDrivingStateMgr", "Could not register a listener to Driving State Service " + e);
            throw new CarNotConnectedException(e);
        }
        catch(IllegalStateException e) {
            Log.e("CarDrivingStateMgr", "Could not register a listener to Driving State Service " + e);
            Car.checkCarNotConnectedExceptionFromCarService(e);
            return;
        }
    }

    public void unregisterListener() throws CarNotConnectedException {
        synchronized (this) {
            if (this.mDrvStateEventListener == null) {
                return;
            }

            try {
                this.mDrivingService.unregisterDrivingStateChangeListener(
                        this.mListenerToService);

                this.mDrvStateEventListener = null;
                this.mListenerToService = null;

            } catch (RemoteException e) {
                Log.e(
                        "CarDrivingStateMgr",
                        "Could not unregister listener from Driving State Service " + e);

                throw new CarNotConnectedException(e);
            }
        }
    }
}

