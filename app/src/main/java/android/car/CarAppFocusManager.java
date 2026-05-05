package android.car;

import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class CarAppFocusManager implements CarManagerBase {
    @Retention(RetentionPolicy.SOURCE)
    public @interface AppFocusRequestResult {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AppFocusType {
    }

    static class IAppFocusListenerImpl extends IAppFocusListener.Stub {
        private final Set mAppTypes;
        private final WeakReference mListener;
        private final WeakReference mManager;

        private IAppFocusListenerImpl(CarAppFocusManager manager, OnAppFocusChangedListener listener) {
            this.mAppTypes = new HashSet();
            this.mManager = new WeakReference(manager);
            this.mListener = new WeakReference(listener);
        }

        public void addAppType(int appType) {
            this.mAppTypes.add(Integer.valueOf(appType));
        }

        public Set getAppTypes() {
            return this.mAppTypes;
        }

        public boolean hasAppTypes() {
            return !this.mAppTypes.isEmpty();
        }

        @Override  // android.car.IAppFocusListener
        public void onAppFocusChanged(int appType, boolean active) {
            CarAppFocusManager manager = (CarAppFocusManager)this.mManager.get();
            OnAppFocusChangedListener listener = (OnAppFocusChangedListener)this.mListener.get();
            if(manager != null && listener != null) {
                manager.mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        listener.onAppFocusChanged(appType, active);
                    }
                });
            }
        }

        public void removeAppType(int appType) {
            this.mAppTypes.remove(Integer.valueOf(appType));
        }
    }

    static class IAppFocusOwnershipCallbackImpl extends android.car.IAppFocusOwnershipCallback.Stub {
        private final Set mAppTypes;
        private final WeakReference mCallback;
        private final WeakReference mManager;

        private IAppFocusOwnershipCallbackImpl(CarAppFocusManager manager, OnAppFocusOwnershipCallback callback) {
            this.mAppTypes = new HashSet();
            this.mManager = new WeakReference(manager);
            this.mCallback = new WeakReference(callback);
        }

        public void addAppType(int appType) {
            this.mAppTypes.add(Integer.valueOf(appType));
        }

        public Set getAppTypes() {
            return this.mAppTypes;
        }

        public boolean hasAppTypes() {
            return !this.mAppTypes.isEmpty();
        }

        @Override  // android.car.IAppFocusOwnershipCallback
        public void onAppFocusOwnershipGranted(int appType) {
            CarAppFocusManager manager = (CarAppFocusManager)this.mManager.get();
            OnAppFocusOwnershipCallback callback = (OnAppFocusOwnershipCallback)this.mCallback.get();
            if(manager != null && callback != null) {
                manager.mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onAppFocusOwnershipGranted(appType);
                    }
                });
            }
        }

        @Override  // android.car.IAppFocusOwnershipCallback
        public void onAppFocusOwnershipLost(int appType) {
            CarAppFocusManager manager = (CarAppFocusManager)this.mManager.get();
            OnAppFocusOwnershipCallback callback = (OnAppFocusOwnershipCallback)this.mCallback.get();
            if(manager != null && callback != null) {
                manager.mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onAppFocusOwnershipLost(appType);
                    }
                });
            }
        }

        public void removeAppType(int appType) {
            this.mAppTypes.remove(Integer.valueOf(appType));
        }
    }

    public interface OnAppFocusChangedListener {
        void onAppFocusChanged(int arg1, boolean arg2);
    }

    public interface OnAppFocusOwnershipCallback {
        void onAppFocusOwnershipGranted(int arg1);

        void onAppFocusOwnershipLost(int arg1);
    }

    public static final int APP_FOCUS_MAX = 2;
    public static final int APP_FOCUS_REQUEST_FAILED = 0;
    public static final int APP_FOCUS_REQUEST_SUCCEEDED = 1;
    public static final int APP_FOCUS_TYPE_NAVIGATION = 1;
    public static final int APP_FOCUS_TYPE_VOICE_COMMAND = 2;
    private final Map mChangeBinders;
    private final Handler mHandler;
    private final Map mOwnershipBinders;
    private final IAppFocus mService;

    CarAppFocusManager(IBinder service, Handler handler) {
        this.mChangeBinders = new HashMap();
        this.mOwnershipBinders = new HashMap();
        this.mService = android.car.IAppFocus.Stub.asInterface(service);
        this.mHandler = handler;
    }

    public void abandonAppFocus(OnAppFocusOwnershipCallback ownershipCallback) {
        IAppFocusOwnershipCallbackImpl binder;
        synchronized(this) {
            binder = (IAppFocusOwnershipCallbackImpl)this.mOwnershipBinders.remove(ownershipCallback);
            if(binder == null) {
                return;
            }
        }
        try {
            for(Object object0: binder.getAppTypes()) {
                this.mService.abandonAppFocus(binder, ((Integer)object0).intValue());
            }
        }
        catch(RemoteException unused_ex) {
        }
    }

    public void abandonAppFocus(OnAppFocusOwnershipCallback ownershipCallback, int appType) {
        IAppFocusOwnershipCallbackImpl binder;
        if(ownershipCallback == null) {
            throw new IllegalArgumentException("null callback");
        }
        synchronized(this) {
            binder = (IAppFocusOwnershipCallbackImpl)this.mOwnershipBinders.get(ownershipCallback);
        }
        if(binder == null) {
            return;
        }
        try {
            this.mService.abandonAppFocus(binder, appType);
        }
        catch(RemoteException unused_ex) {
        }
        synchronized(this) {
            binder.removeAppType(appType);
            if(!binder.hasAppTypes()) {
                this.mOwnershipBinders.remove(ownershipCallback);
            }
        }
    }

    public void addFocusListener(OnAppFocusChangedListener listener, int appType) throws CarNotConnectedException {
        IAppFocusListenerImpl binder;
        if(listener == null) {
            throw new IllegalArgumentException("null listener");
        }
        synchronized(this) {
            binder = (IAppFocusListenerImpl)this.mChangeBinders.get(listener);
            if(binder == null) {
                binder = new IAppFocusListenerImpl(this, listener);
                this.mChangeBinders.put(listener, binder);
            }
            binder.addAppType(appType);
        }
        try {
            this.mService.registerFocusListener(binder, appType);
        }
        catch(RemoteException e) {
            throw new CarNotConnectedException(e);
        }
    }

    public int[] getActiveAppTypes() throws CarNotConnectedException {
        try {
            return this.mService.getActiveAppTypes();
        }
        catch(RemoteException e) {
            throw new CarNotConnectedException(e);
        }
    }

    public boolean isOwningFocus(OnAppFocusOwnershipCallback callback, int appType) throws CarNotConnectedException {
        IAppFocusOwnershipCallbackImpl binder;
        synchronized(this) {
            binder = (IAppFocusOwnershipCallbackImpl)this.mOwnershipBinders.get(callback);
            if(binder == null) {
                return false;
            }
        }
        try {
            return this.mService.isOwningFocus(binder, appType);
        }
        catch(RemoteException e) {
            throw new CarNotConnectedException(e);
        }
    }

    @Override  // android.car.CarManagerBase
    public void onCarDisconnected() {
    }

    public void removeFocusListener(OnAppFocusChangedListener listener) {
        IAppFocusListenerImpl binder;
        synchronized(this) {
            binder = (IAppFocusListenerImpl)this.mChangeBinders.remove(listener);
            if(binder == null) {
                return;
            }
        }
        try {
            for(Object object0: binder.getAppTypes()) {
                this.mService.unregisterFocusListener(binder, ((Integer)object0).intValue());
            }
        }
        catch(RemoteException unused_ex) {
        }
    }

    public void removeFocusListener(OnAppFocusChangedListener listener, int appType) {
        IAppFocusListenerImpl binder;
        synchronized(this) {
            binder = (IAppFocusListenerImpl)this.mChangeBinders.get(listener);
        }
        if(binder == null) {
            return;
        }
        try {
            this.mService.unregisterFocusListener(binder, appType);
        }
        catch(RemoteException unused_ex) {
        }
        synchronized(this) {
            binder.removeAppType(appType);
            if(!binder.hasAppTypes()) {
                this.mChangeBinders.remove(listener);
            }
        }
    }

    public int requestAppFocus(int appType, OnAppFocusOwnershipCallback ownershipCallback) throws SecurityException, CarNotConnectedException {
        IAppFocusOwnershipCallbackImpl binder;
        if(ownershipCallback == null) {
            throw new IllegalArgumentException("null listener");
        }
        synchronized(this) {
            binder = (IAppFocusOwnershipCallbackImpl)this.mOwnershipBinders.get(ownershipCallback);
            if(binder == null) {
                binder = new IAppFocusOwnershipCallbackImpl(this, ownershipCallback);
                this.mOwnershipBinders.put(ownershipCallback, binder);
            }
            binder.addAppType(appType);
        }
        try {
            return this.mService.requestAppFocus(binder, appType);
        }
        catch(RemoteException e) {
            throw new CarNotConnectedException(e);
        }
    }
}

