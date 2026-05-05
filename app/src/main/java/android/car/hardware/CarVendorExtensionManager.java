package android.car.hardware;


import android.car.CarManagerBase;
import android.car.CarNotConnectedException;
import android.car.hardware.property.CarPropertyManager.CarPropertyEventListener;
import android.car.hardware.property.CarPropertyManager;
import android.os.Handler;
import android.os.IBinder;
import android.util.ArraySet;

import androidx.annotation.GuardedBy;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


public final class CarVendorExtensionManager implements CarManagerBase {
    static class CarPropertyEventListenerToBase implements CarPropertyEventListener {
        private final WeakReference mManager;

        CarPropertyEventListenerToBase(CarVendorExtensionManager manager) {
            this.mManager = new WeakReference(manager);
        }

        @Override  // android.car.hardware.property.CarPropertyManager$CarPropertyEventListener
        public void onChangeEvent(CarPropertyValue value) {
            CarVendorExtensionManager manager = (CarVendorExtensionManager)this.mManager.get();
            if(manager != null) {
                manager.handleOnChangeEvent(value);
            }
        }

        @Override  // android.car.hardware.property.CarPropertyManager$CarPropertyEventListener
        public void onErrorEvent(int propertyId, int zone) {
            CarVendorExtensionManager manager = (CarVendorExtensionManager)this.mManager.get();
            if(manager != null) {
                manager.handleOnErrorEvent(propertyId, zone);
            }
        }
    }

    public interface CarVendorExtensionCallback {
        void onChangeEvent(CarPropertyValue arg1);

        void onErrorEvent(int arg1, int arg2);
    }

    private static final boolean DBG = false;
    private static final String TAG = "CarVendorExtensionManager";
    @GuardedBy("mLock")
    private final ArraySet mCallbacks;
    @GuardedBy("mLock")
    private CarPropertyEventListenerToBase mListenerToBase;
    private final Object mLock;
    private final CarPropertyManager mPropertyManager;

    public CarVendorExtensionManager(IBinder service, Handler handler) {
        this.mCallbacks = new ArraySet();
        this.mLock = new Object();
        this.mListenerToBase = null;
        this.mPropertyManager = new CarPropertyManager(service, handler, false, "CarVendorExtensionManager");
    }

    public Object getGlobalProperty(Class class0, int propId) throws CarNotConnectedException {
        return this.getProperty(class0, propId, 0);
    }

    public List getProperties() throws CarNotConnectedException {
        return this.mPropertyManager.getPropertyList();
    }

    public Object getProperty(Class class0, int propId, int area) throws CarNotConnectedException {
        return this.mPropertyManager.getProperty(class0, propId, area).getValue();
    }

    private void handleOnChangeEvent(CarPropertyValue value) {
        ArrayList callbacks;
        synchronized (this.mLock) {
            callbacks = new ArrayList(this.mCallbacks);
        }
        for (Object object0 : callbacks) {
            ((CarVendorExtensionCallback) object0).onChangeEvent(value);
        }
    }

    private void handleOnErrorEvent(int propertyId, int zone) {
        ArrayList listeners;
        synchronized (this.mLock) {
            listeners = new ArrayList(this.mCallbacks);
        }
        for (Object object0 : listeners) {
            ((CarVendorExtensionCallback) object0).onErrorEvent(propertyId, zone);
        }
    }

    public boolean isPropertyAvailable(int propertyId, int area) throws CarNotConnectedException {
        return this.mPropertyManager.isPropertyAvailable(propertyId, area);
    }

    @Override  // android.car.CarManagerBase
    public void onCarDisconnected() {
        this.mPropertyManager.onCarDisconnected();
    }

    public void registerCallback(CarVendorExtensionCallback callback) throws CarNotConnectedException {
        synchronized(this.mLock) {
            if(this.mCallbacks.isEmpty()) {
                this.mListenerToBase = new CarPropertyEventListenerToBase(this);
            }
            for(Object object1: this.mPropertyManager.getPropertyList()) {
                this.mPropertyManager.registerListener(this.mListenerToBase, ((CarPropertyConfig)object1).getPropertyId(), 0.0f);
            }
            this.mCallbacks.add(callback);
        }
    }

    public void setGlobalProperty(Class class0, int propId, Object object0) throws CarNotConnectedException {
        this.mPropertyManager.setProperty(class0, propId, 0, object0);
    }

    public void setProperty(Class class0, int propId, int area, Object object0) throws CarNotConnectedException {
        this.mPropertyManager.setProperty(class0, propId, area, object0);
    }

    public void unregisterCallback(CarVendorExtensionCallback callback) throws CarNotConnectedException {
        synchronized(this.mLock) {
            this.mCallbacks.remove(callback);
            for(Object object1: this.mPropertyManager.getPropertyList()) {
                this.mPropertyManager.unregisterListener(this.mListenerToBase, ((CarPropertyConfig)object1).getPropertyId());
            }
            if(this.mCallbacks.isEmpty()) {
                this.mListenerToBase = null;
            }
        }
    }
}

