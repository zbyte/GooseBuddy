package android.car;


import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.ref.WeakReference;


public final class CarProjectionManager implements CarManagerBase {
    public interface CarProjectionListener {
        void onVoiceAssistantRequest(boolean arg1);
    }

    static class ICarProjectionCallbackImpl extends ICarProjectionCallback.Stub {
        private final WeakReference mManager;

        private ICarProjectionCallbackImpl(CarProjectionManager manager) {
            this.mManager = new WeakReference(manager);
        }

        @Override  // android.car.ICarProjectionCallback
        public void onVoiceAssistantRequest(boolean fromLongPress) {
            CarProjectionManager manager = (CarProjectionManager)this.mManager.get();
            if(manager == null) {
                return;
            }
            manager.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    manager.handleVoiceAssistantRequest(fromLongPress);
                }
            });
        }
    }

    public static final int PROJECTION_LONG_PRESS_VOICE_SEARCH = 2;
    public static final int PROJECTION_VOICE_SEARCH = 1;
    private final ICarProjectionCallbackImpl mBinderListener;
    private final Handler mHandler;
    private CarProjectionListener mListener;
    private final ICarProjection mService;
    private int mVoiceSearchFilter;

    CarProjectionManager(IBinder service, Handler handler) {
        this.mService = android.car.ICarProjection.Stub.asInterface(service);
        this.mHandler = handler;
        this.mBinderListener = new ICarProjectionCallbackImpl(this);
    }

    private void handleVoiceAssistantRequest(boolean fromLongPress) {
        synchronized(this) {
            if(this.mListener == null) {
                return;
            }
        }
        this.mListener.onVoiceAssistantRequest(fromLongPress);
    }

    @Override  // android.car.CarManagerBase
    public void onCarDisconnected() {
    }

    public void registerProjectionListener(CarProjectionListener listener, int voiceSearchFilter) throws CarNotConnectedException {
        if(listener == null) {
            throw new IllegalArgumentException("null listener");
        }
        synchronized(this) {
            if(this.mListener == null || this.mVoiceSearchFilter != voiceSearchFilter) {
                try {
                    this.mService.registerProjectionListener(this.mBinderListener, voiceSearchFilter);
                }
                catch(RemoteException e) {
                    throw new CarNotConnectedException(e);
                }
            }
            this.mListener = listener;
            this.mVoiceSearchFilter = voiceSearchFilter;
        }
    }

    public void registerProjectionRunner(Intent serviceIntent) throws CarNotConnectedException {
        if(serviceIntent == null) {
            throw new IllegalArgumentException("null serviceIntent");
        }
        synchronized(this) {
            try {
                this.mService.registerProjectionRunner(serviceIntent);
            }
            catch(RemoteException e) {
                throw new CarNotConnectedException(e);
            }
        }
    }

    public void regsiterProjectionListener(CarProjectionListener listener, int voiceSearchFilter) throws CarNotConnectedException {
        this.registerProjectionListener(listener, voiceSearchFilter);
    }

    public void unregisterProjectionListener() {
        synchronized(this) {
            try {
                this.mService.unregisterProjectionListener(this.mBinderListener);
            }
            catch(RemoteException unused_ex) {
            }
        }
        this.mListener = null;
        this.mVoiceSearchFilter = 0;
    }

    public void unregisterProjectionRunner(Intent serviceIntent) {
        if(serviceIntent == null) {
            throw new IllegalArgumentException("null serviceIntent");
        }
        synchronized(this) {
            try {
                this.mService.unregisterProjectionRunner(serviceIntent);
            }
            catch(RemoteException unused_ex) {
            }
        }
    }

    public void unregsiterProjectionListener() {
        this.unregisterProjectionListener();
    }
}

