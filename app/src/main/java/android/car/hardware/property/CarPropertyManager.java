package android.car.hardware.property;

import android.car.CarApiUtil;
import android.car.CarManagerBase;
import android.car.CarNotConnectedException;
import android.car.hardware.CarPropertyConfig;
import android.car.hardware.CarPropertyValue;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Log;
import android.util.SparseArray;
import com.android.car.internal.CarRatedFloatListeners;
import com.android.car.internal.SingleMessageHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CarPropertyManager implements CarManagerBase {
    public interface CarPropertyEventListener {
        void onChangeEvent(CarPropertyValue arg1);

        void onErrorEvent(int arg1, int arg2);
    }

    class CarPropertyEventListenerToService extends ICarPropertyEventListener.Stub {
        private final WeakReference mMgr;

        CarPropertyEventListenerToService(CarPropertyManager mgr) {
            this.mMgr = new WeakReference(mgr);
        }

        @Override  // android.car.hardware.property.ICarPropertyEventListener
        public void onEvent(List list0) throws RemoteException {
            CarPropertyManager manager = (CarPropertyManager)this.mMgr.get();
            if(manager != null) {
                manager.handleEvent(list0);
            }
        }
    }

    class CarPropertyListeners extends CarRatedFloatListeners {
        CarPropertyListeners(float rate) {
            super(rate);
        }

        void onErrorEvent(CarPropertyEvent event) {
            ArrayList<CarPropertyEventListener> listeners;
            synchronized(CarPropertyManager.this.mActivePropertyListener) {
                listeners = new ArrayList(this.getListeners());
            }
            listeners.forEach(new Consumer<CarPropertyEventListener>() {
                public void accept(CarPropertyEventListener listener) {
                    int v = event.getCarPropertyValue().getAreaId();
                    listener.onErrorEvent(event.getCarPropertyValue().getPropertyId(), v);
                }
            });
        }

        void onPropertyChanged(CarPropertyEvent event) {
            ArrayList<CarPropertyEventListener> listeners;
            long v = event.getCarPropertyValue().getTimestamp();
            if(v < this.mLastUpdateTime) {
                Log.w(CarPropertyManager.this.mTag, "dropping old property data");
                return;
            }
            this.mLastUpdateTime = v;
            synchronized(CarPropertyManager.this.mActivePropertyListener) {
                listeners = new ArrayList(this.getListeners());
            }
            listeners.forEach(new Consumer<CarPropertyEventListener>() {
                public void accept(CarPropertyEventListener listener) {
                    listener.onChangeEvent(event.getCarPropertyValue());
                }
            });
        }
    }

    private static final int MSG_GENERIC_EVENT = 0;
    private final SparseArray mActivePropertyListener;
    private CarPropertyEventListenerToService mCarPropertyEventToService;
    private final boolean mDbg;
    private final SingleMessageHandler mHandler;
    private final ICarProperty mService;
    private final String mTag;

    public CarPropertyManager(IBinder service, Handler handler, boolean dbg, String tag) {
        this.mActivePropertyListener = new SparseArray();
        this.mDbg = dbg;
        this.mTag = tag;
        this.mService = android.car.hardware.property.ICarProperty.Stub.asInterface(service);
        this.mHandler = new SingleMessageHandler<CarPropertyEvent>(handler.getLooper(), 0) {
            protected void handleEvent(CarPropertyEvent event) {
                CarPropertyListeners listeners;
                synchronized(CarPropertyManager.this.mActivePropertyListener) {
                    listeners = (CarPropertyListeners)CarPropertyManager.this.mActivePropertyListener.get(event.getCarPropertyValue().getPropertyId());
                }
                if(listeners != null) {
                    switch(event.getEventType()) {
                        case 0: {
                            listeners.onPropertyChanged(event);
                            break;
                        }
                        case 1: {
                            listeners.onErrorEvent(event);
                            return;
                        }
                        default: {
                            throw new IllegalArgumentException();
                        }
                    }
                }
            }
        };
    }

    private void doUnregisterListenerLocked(CarPropertyEventListener listener, int propertyId) {
        boolean needsServerUpdate = false;
        CarPropertyListeners listeners = (CarPropertyListeners)this.mActivePropertyListener.get(propertyId);
        if(listeners != null) {
            if(listeners.contains(listener)) {
                needsServerUpdate = listeners.remove(listener);
            }
            if(listeners.isEmpty()) {
                try {
                    this.mService.unregisterListener(propertyId, this.mCarPropertyEventToService);
                }
                catch(RemoteException unused_ex) {
                }
                this.mActivePropertyListener.remove(propertyId);
                return;
            }
            if(needsServerUpdate) {
                try {
                    this.registerOrUpdatePropertyListener(propertyId, listeners.getRate());
                }
                catch(CarNotConnectedException unused_ex) {
                }
            }
        }
    }

    public boolean getBooleanProperty(int prop, int area) throws CarNotConnectedException {
        CarPropertyValue carPropertyValue0 = this.getProperty(Boolean.class, prop, area);
        return carPropertyValue0 == null ? false : ((Boolean)carPropertyValue0.getValue()).booleanValue();
    }

    public float getFloatProperty(int prop, int area) throws CarNotConnectedException {
        CarPropertyValue carPropertyValue0 = this.getProperty(Float.class, prop, area);
        return carPropertyValue0 == null ? 0.0f : ((float)(((Float)carPropertyValue0.getValue())));
    }

    public int getIntProperty(int prop, int area) throws CarNotConnectedException {
        CarPropertyValue carPropertyValue0 = this.getProperty(Integer.class, prop, area);
        return carPropertyValue0 == null ? 0 : ((int)(((Integer)carPropertyValue0.getValue())));
    }

    public CarPropertyValue getProperty(int propId, int area) throws CarNotConnectedException {
        try {
            return this.mService.getProperty(propId, area);
        }
        catch(RemoteException e) {
            Log.e(this.mTag, "getProperty failed with " + e.toString() + ", propId: 0x" + Integer.toHexString(propId) + ", area: 0x" + Integer.toHexString(area), e);
            throw new CarNotConnectedException(e);
        }
    }

    public CarPropertyValue getProperty(Class class0, int propId, int area) throws CarNotConnectedException {
        if(this.mDbg) {
            Log.d(this.mTag, "getProperty, propId: 0x" + Integer.toHexString(propId) + ", area: 0x" + Integer.toHexString(area) + ", class: " + class0);
        }
        try {
            CarPropertyValue carPropertyValue0 = this.mService.getProperty(propId, area);
            if(carPropertyValue0 != null && carPropertyValue0.getValue() != null) {
                Class class1 = carPropertyValue0.getValue().getClass();
                if(class1 != class0) {
                    throw new IllegalArgumentException("Invalid property type. Expected: " + class0 + ", but was: " + class1);
                }
            }
            return carPropertyValue0;
        }
        catch(RemoteException e) {
            Log.e(this.mTag, "getProperty failed with " + e.toString() + ", propId: 0x" + Integer.toHexString(propId) + ", area: 0x" + Integer.toHexString(area), e);
            throw new CarNotConnectedException(e);
        }
    }

    public List getPropertyList() throws CarNotConnectedException {
        try {
            return this.mService.getPropertyList();
        }
        catch(RemoteException e) {
            Log.e(this.mTag, "getPropertyList exception ", e);
            throw new CarNotConnectedException(e);
        }
    }

    public List getPropertyList(ArraySet arraySet0) throws CarNotConnectedException {
        try {
            List configs = new ArrayList();
            for(Object object0: this.mService.getPropertyList()) {
                CarPropertyConfig c = (CarPropertyConfig)object0;
                if(arraySet0.contains(Integer.valueOf(c.getPropertyId()))) {
                    configs.add(c);
                }
            }
            return configs;
        }
        catch(RemoteException e) {
            Log.e(this.mTag, "getPropertyList exception ", e);
            throw new CarNotConnectedException(e);
        }
    }

    private void handleEvent(List list0) {
        this.mHandler.sendEvents(list0);
    }

    public boolean isPropertyAvailable(int propId, int area) throws CarNotConnectedException {
        try {
            CarPropertyValue carPropertyValue0 = this.mService.getProperty(propId, area);
            return carPropertyValue0 == null ? false : carPropertyValue0.getStatus() == 0;
        }
        catch(RemoteException e) {
            Log.e(this.mTag, "isPropertyAvailable failed with " + e.toString() + ", propId: 0x" + Integer.toHexString(propId) + ", area: 0x" + Integer.toHexString(area), e);
            throw new CarNotConnectedException(e);
        }
    }

    @Override  // android.car.CarManagerBase
    public void onCarDisconnected() {
        synchronized(this.mActivePropertyListener) {
            this.mActivePropertyListener.clear();
            this.mCarPropertyEventToService = null;
        }
    }

    public boolean registerListener(CarPropertyEventListener listener, int propertyId, float rate) throws CarNotConnectedException {
        synchronized(this.mActivePropertyListener) {
            if(this.mCarPropertyEventToService == null) {
                this.mCarPropertyEventToService = new CarPropertyEventListenerToService(this);
            }
            boolean needsServerUpdate = false;
            CarPropertyListeners listeners = (CarPropertyListeners)this.mActivePropertyListener.get(propertyId);
            if(listeners == null) {
                listeners = new CarPropertyListeners(rate);
                this.mActivePropertyListener.put(propertyId, listeners);
                needsServerUpdate = true;
            }
            if(listeners.addAndUpdateRate(listener, rate)) {
                needsServerUpdate = true;
            }
            return !needsServerUpdate || this.registerOrUpdatePropertyListener(propertyId, rate);
        }
    }

    private boolean registerOrUpdatePropertyListener(int propertyId, float rate) throws CarNotConnectedException {
        try {
            this.mService.registerListener(propertyId, rate, this.mCarPropertyEventToService);
            return true;
        }
        catch(IllegalStateException e) {
            CarApiUtil.checkCarNotConnectedExceptionFromCarService(e);
            return true;
        }
        catch(RemoteException e) {
            throw new CarNotConnectedException(e);
        }
    }

    public void setBooleanProperty(int prop, int area, boolean val) throws CarNotConnectedException {
        this.setProperty(Boolean.class, prop, area, Boolean.valueOf(val));
    }

    public void setFloatProperty(int prop, int area, float val) throws CarNotConnectedException {
        this.setProperty(Float.class, prop, area, Float.valueOf(val));
    }

    public void setIntProperty(int prop, int area, int val) throws CarNotConnectedException {
        this.setProperty(Integer.class, prop, area, Integer.valueOf(val));
    }

    public void setProperty(Class class0, int propId, int area, Object object0) throws CarNotConnectedException {
        if(this.mDbg) {
            Log.d(this.mTag, "setProperty, propId: 0x" + Integer.toHexString(propId) + ", area: 0x" + Integer.toHexString(area) + ", class: " + class0 + ", val: " + object0);
        }
        try {
            CarPropertyValue carPropertyValue0 = new CarPropertyValue(propId, area, object0);
            this.mService.setProperty(carPropertyValue0);
        }
        catch(RemoteException e) {
            Log.e(this.mTag, "setProperty failed with " + e.toString(), e);
            throw new CarNotConnectedException(e);
        }
    }

    public void unregisterListener(CarPropertyEventListener listener) {
        synchronized(this.mActivePropertyListener) {
            for(int i = 0; i < this.mActivePropertyListener.size(); ++i) {
                this.doUnregisterListenerLocked(listener, this.mActivePropertyListener.keyAt(i));
            }
        }
    }

    public void unregisterListener(CarPropertyEventListener listener, int propertyId) {
        synchronized(this.mActivePropertyListener) {
            this.doUnregisterListenerLocked(listener, propertyId);
        }
    }
}

