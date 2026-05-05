package android.car.hardware.cabin;


import android.car.CarManagerBase;
import android.car.CarNotConnectedException;
import android.car.hardware.CarPropertyConfig;
import android.car.hardware.CarPropertyValue;
import android.car.hardware.property.CarPropertyManager.CarPropertyEventListener;
import android.car.hardware.property.CarPropertyManager;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.util.ArraySet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;


public final class CarCabinManager implements CarManagerBase {
    public interface CarCabinEventCallback {
        void onChangeEvent(CarPropertyValue arg1);

        void onErrorEvent(int arg1, int arg2);
    }

    static class CarPropertyEventListenerToBase implements CarPropertyEventListener {
        private final WeakReference mManager;

        public CarPropertyEventListenerToBase(CarCabinManager manager) {
            this.mManager = new WeakReference(manager);
        }

        @Override  // android.car.hardware.property.CarPropertyManager$CarPropertyEventListener
        public void onChangeEvent(CarPropertyValue value) {
            CarCabinManager manager = (CarCabinManager)this.mManager.get();
            if(manager != null) {
                manager.handleOnChangeEvent(value);
            }
        }

        @Override  // android.car.hardware.property.CarPropertyManager$CarPropertyEventListener
        public void onErrorEvent(int propertyId, int zone) {
            CarCabinManager manager = (CarCabinManager)this.mManager.get();
            if(manager != null) {
                manager.handleOnErrorEvent(propertyId, zone);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PropertyId {
    }

    private static final boolean DBG = false;
    public static final int ID_DOOR_LOCK = 0x16200B02;
    public static final int ID_DOOR_MOVE = 0x16400B01;
    public static final int ID_DOOR_POS = 0x16400B00;
    public static final int ID_MIRROR_FOLD = 0x11200B45;
    public static final int ID_MIRROR_LOCK = 0x11200B44;
    public static final int ID_MIRROR_Y_MOVE = 0x14400B43;
    public static final int ID_MIRROR_Y_POS = 0x14400B42;
    public static final int ID_MIRROR_Z_MOVE = 0x14400B41;
    public static final int ID_MIRROR_Z_POS = 0x14400B40;
    public static final int ID_SEAT_BACKREST_ANGLE_1_MOVE = 0x15400B88;
    public static final int ID_SEAT_BACKREST_ANGLE_1_POS = 0x15400B87;
    public static final int ID_SEAT_BACKREST_ANGLE_2_MOVE = 0x15400B8A;
    public static final int ID_SEAT_BACKREST_ANGLE_2_POS = 0x15400B89;
    public static final int ID_SEAT_BELT_BUCKLED = 0x15200B82;
    public static final int ID_SEAT_BELT_HEIGHT_MOVE = 0x15400B84;
    public static final int ID_SEAT_BELT_HEIGHT_POS = 0x15400B83;
    public static final int ID_SEAT_DEPTH_MOVE = 0x15400B8E;
    public static final int ID_SEAT_DEPTH_POS = 0x15400B8D;
    public static final int ID_SEAT_FORE_AFT_MOVE = 0x15400B86;
    public static final int ID_SEAT_FORE_AFT_POS = 0x15400B85;
    public static final int ID_SEAT_HEADREST_ANGLE_MOVE = 0x15400B98;
    public static final int ID_SEAT_HEADREST_ANGLE_POS = 0x15400B97;
    public static final int ID_SEAT_HEADREST_FORE_AFT_MOVE = 0x15400B9A;
    public static final int ID_SEAT_HEADREST_FORE_AFT_POS = 0x15400B99;
    public static final int ID_SEAT_HEADREST_HEIGHT_MOVE = 0x15400B96;
    public static final int ID_SEAT_HEADREST_HEIGHT_POS = 0x15400B95;
    public static final int ID_SEAT_HEIGHT_MOVE = 0x15400B8C;
    public static final int ID_SEAT_HEIGHT_POS = 0x15400B8B;
    public static final int ID_SEAT_LUMBAR_FORE_AFT_MOVE = 0x15400B92;
    public static final int ID_SEAT_LUMBAR_FORE_AFT_POS = 0x15400B91;
    public static final int ID_SEAT_LUMBAR_SIDE_SUPPORT_MOVE = 0x15400B94;
    public static final int ID_SEAT_LUMBAR_SIDE_SUPPORT_POS = 0x15400B93;
    public static final int ID_SEAT_MEMORY_SELECT = 0x15400B80;
    public static final int ID_SEAT_MEMORY_SET = 0x15400B81;
    public static final int ID_SEAT_TILT_MOVE = 0x15400B90;
    public static final int ID_SEAT_TILT_POS = 0x15400B8F;
    public static final int ID_WINDOW_LOCK = 0x13400BC4;
    public static final int ID_WINDOW_MOVE = 0x13400BC1;
    public static final int ID_WINDOW_POS = 0x13400BC0;
    private static final String TAG = "CarCabinManager";
    private final ArraySet mCabinPropertyIds;
    private final ArraySet mCallbacks;
    private final CarPropertyManager mCarPropertyMgr;
    private CarPropertyEventListenerToBase mListenerToBase;

    public CarCabinManager(IBinder service, Context context, Handler handler) {
        this.mCallbacks = new ArraySet();
        this.mListenerToBase = null;
        this.mCabinPropertyIds = new ArraySet(Arrays.asList(new Integer[]{((int)0x16400B00), ((int)0x16400B01), ((int)0x16200B02), ((int)0x14400B40), ((int)0x14400B41), ((int)0x14400B42), ((int)0x14400B43), ((int)0x11200B44), ((int)0x11200B45), ((int)0x15400B80), ((int)0x15400B81), ((int)0x15200B82), ((int)0x15400B83), ((int)0x15400B84), ((int)0x15400B85), ((int)0x15400B86), ((int)0x15400B87), ((int)0x15400B88), ((int)0x15400B89), ((int)0x15400B8A), ((int)0x15400B8B), ((int)0x15400B8C), ((int)0x15400B8D), ((int)0x15400B8E), ((int)0x15400B8F), ((int)0x15400B90), ((int)0x15400B91), ((int)0x15400B92), ((int)0x15400B93), ((int)0x15400B94), ((int)0x15400B95), ((int)0x15400B96), ((int)0x15400B97), ((int)0x15400B98), ((int)0x15400B99), ((int)0x15400B9A), ((int)0x13400BC0), ((int)0x13400BC1), ((int)0x13400BC4)}));
        this.mCarPropertyMgr = new CarPropertyManager(service, handler, false, "CarCabinManager");
    }

    public boolean getBooleanProperty(int propertyId, int area) throws CarNotConnectedException {
        return this.mCarPropertyMgr.getBooleanProperty(propertyId, area);
    }

    public float getFloatProperty(int propertyId, int area) throws CarNotConnectedException {
        return this.mCarPropertyMgr.getFloatProperty(propertyId, area);
    }

    public int getIntProperty(int propertyId, int area) throws CarNotConnectedException {
        return this.mCarPropertyMgr.getIntProperty(propertyId, area);
    }

    public List getPropertyList() throws CarNotConnectedException {
        return this.mCarPropertyMgr.getPropertyList(this.mCabinPropertyIds);
    }

    private void handleOnChangeEvent(CarPropertyValue value) {
        ArraySet callbacks;
        synchronized (this) {
            callbacks = new ArraySet(this.mCallbacks);
        }
        for (Object object0 : callbacks) {
            ((CarCabinEventCallback) object0).onChangeEvent(value);
        }
    }

    private void handleOnErrorEvent(int propertyId, int zone) {
        ArraySet listeners;
        synchronized (this) {
            listeners = new ArraySet(this.mCallbacks);
        }
        if (!listeners.isEmpty()) {
            for (Object object0 : listeners) {
                ((CarCabinEventCallback) object0).onErrorEvent(propertyId, zone);
            }
        }
    }

    public static boolean isZonedProperty(int propertyId) {
        return true;
    }

    @Override  // android.car.CarManagerBase
    public void onCarDisconnected() {
        this.mCarPropertyMgr.onCarDisconnected();
    }

    public void registerCallback(CarCabinEventCallback callback) throws CarNotConnectedException {
        synchronized(this) {
            if(this.mCallbacks.isEmpty()) {
                this.mListenerToBase = new CarPropertyEventListenerToBase(this);
            }
            for(Object object0: this.getPropertyList()) {
                this.mCarPropertyMgr.registerListener(this.mListenerToBase, ((CarPropertyConfig)object0).getPropertyId(), 0.0f);
            }
            this.mCallbacks.add(callback);
        }
    }

    public void setBooleanProperty(int propertyId, int area, boolean val) throws CarNotConnectedException {
        if(this.mCabinPropertyIds.contains(Integer.valueOf(propertyId))) {
            this.mCarPropertyMgr.setBooleanProperty(propertyId, area, val);
        }
    }

    public void setFloatProperty(int propertyId, int area, float val) throws CarNotConnectedException {
        if(this.mCabinPropertyIds.contains(Integer.valueOf(propertyId))) {
            this.mCarPropertyMgr.setFloatProperty(propertyId, area, val);
        }
    }

    public void setIntProperty(int propertyId, int area, int val) throws CarNotConnectedException {
        if(this.mCabinPropertyIds.contains(Integer.valueOf(propertyId))) {
            this.mCarPropertyMgr.setIntProperty(propertyId, area, val);
        }
    }

    public void unregisterCallback(CarCabinEventCallback callback) throws CarNotConnectedException {
        synchronized(this) {
            this.mCallbacks.remove(callback);
            for(Object object0: this.getPropertyList()) {
                this.mCarPropertyMgr.unregisterListener(this.mListenerToBase, ((CarPropertyConfig)object0).getPropertyId());
            }
            if(this.mCallbacks.isEmpty()) {
                this.mListenerToBase = null;
            }
        }
    }
}

