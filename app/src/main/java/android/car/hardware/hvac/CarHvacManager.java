package android.car.hardware.hvac;


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
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;


public final class CarHvacManager implements CarManagerBase {
    public interface CarHvacEventCallback {
        void onChangeEvent(CarPropertyValue arg1);

        void onErrorEvent(int arg1, int arg2);
    }

    static class CarPropertyEventListenerToBase implements CarPropertyEventListener {
        private final WeakReference mManager;

        public CarPropertyEventListenerToBase(CarHvacManager manager) {
            this.mManager = new WeakReference(manager);
        }

        @Override  // android.car.hardware.property.CarPropertyManager$CarPropertyEventListener
        public void onChangeEvent(CarPropertyValue value) {
            CarHvacManager manager = (CarHvacManager)this.mManager.get();
            if(manager != null) {
                manager.handleOnChangeEvent(value);
            }
        }

        @Override  // android.car.hardware.property.CarPropertyManager$CarPropertyEventListener
        public void onErrorEvent(int propertyId, int zone) {
            CarHvacManager manager = (CarHvacManager)this.mManager.get();
            if(manager != null) {
                manager.handleOnErrorEvent(propertyId, zone);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PropertyId {
    }

    private static final boolean DBG = false;
    public static final int FAN_DIRECTION_DEFROST = 4;
    public static final int FAN_DIRECTION_FACE = 1;
    public static final int FAN_DIRECTION_FLOOR = 2;
    public static final int ID_MIRROR_DEFROSTER_ON = 0x1440050C;
    public static final int ID_OUTSIDE_AIR_TEMP = 0x11600703;
    public static final int ID_STEERING_WHEEL_HEAT = 0x1140050D;
    public static final int ID_TEMPERATURE_DISPLAY_UNITS = 0x1140050E;
    public static final int ID_WINDOW_DEFROSTER_ON = 0x13200504;
    public static final int ID_ZONED_AC_ON = 0x15200505;
    public static final int ID_ZONED_AIR_RECIRCULATION_ON = 0x15200508;
    public static final int ID_ZONED_AUTOMATIC_MODE_ON = 0x1520050A;
    public static final int ID_ZONED_DUAL_ZONE_ON = 0x15200509;
    public static final int ID_ZONED_FAN_DIRECTION = 0x15400501;
    public static final int ID_ZONED_FAN_DIRECTION_AVAILABLE = 0x15410511;
    public static final int ID_ZONED_FAN_SPEED_RPM = 0x1540050F;
    public static final int ID_ZONED_FAN_SPEED_SETPOINT = 0x15400500;
    public static final int ID_ZONED_HVAC_AUTO_RECIRC_ON = 0x15200512;
    public static final int ID_ZONED_HVAC_POWER_ON = 0x15200510;
    public static final int ID_ZONED_MAX_AC_ON = 0x15200506;
    public static final int ID_ZONED_MAX_DEFROST_ON = 0x15200507;
    public static final int ID_ZONED_SEAT_TEMP = 0x1540050B;
    public static final int ID_ZONED_TEMP_ACTUAL = 0x15600502;
    public static final int ID_ZONED_TEMP_SETPOINT = 0x15600503;
    private static final String TAG = "CarHvacManager";
    private final ArraySet mCallbacks;
    private final CarPropertyManager mCarPropertyMgr;
    private final ArraySet mHvacPropertyIds;
    private CarPropertyEventListenerToBase mListenerToBase;

    public CarHvacManager(IBinder service, Context context, Handler handler) {
        this.mCallbacks = new ArraySet();
        this.mListenerToBase = null;
        this.mHvacPropertyIds = new ArraySet(Arrays.asList(new Integer[]{((int)0x1440050C), ((int)0x1140050D), ((int)0x11600703), ((int)0x1140050E), ((int)0x15600503), ((int)0x15600502), ((int)0x15400500), ((int)0x1540050F), ((int)0x15410511), ((int)0x15400501), ((int)0x1540050B), ((int)0x15200505), ((int)0x1520050A), ((int)0x15200508), ((int)0x15200506), ((int)0x15200509), ((int)0x15200507), ((int)0x15200510), ((int)0x15200512), ((int)0x13200504)}));
        this.mCarPropertyMgr = new CarPropertyManager(service, handler, false, "CarHvacManager");
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
        return this.mCarPropertyMgr.getPropertyList(this.mHvacPropertyIds);
    }

    private void handleOnChangeEvent(CarPropertyValue value) {
        ArraySet callbacks;
        synchronized (this) {
            callbacks = new ArraySet(this.mCallbacks);
        }
        if (!callbacks.isEmpty()) {
            for (Object object0 : callbacks) {
                ((CarHvacEventCallback) object0).onChangeEvent(value);
            }
        }
    }

    private void handleOnErrorEvent(int propertyId, int zone) {
        ArraySet callbacks;
        synchronized (this) {
            callbacks = new ArraySet(this.mCallbacks);
        }
        if (!callbacks.isEmpty()) {
            for (Object object0 : callbacks) {
                ((CarHvacEventCallback) object0).onErrorEvent(propertyId, zone);
            }
        }
    }

    public boolean isPropertyAvailable(int propertyId, int area) throws CarNotConnectedException {
        return this.mCarPropertyMgr.isPropertyAvailable(propertyId, area);
    }

    @Override  // android.car.CarManagerBase
    public void onCarDisconnected() {
        this.mCarPropertyMgr.onCarDisconnected();
    }

    public void registerCallback(CarHvacEventCallback callback) throws CarNotConnectedException {
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
        if(this.mHvacPropertyIds.contains(Integer.valueOf(propertyId))) {
            this.mCarPropertyMgr.setBooleanProperty(propertyId, area, val);
        }
    }

    public void setFloatProperty(int propertyId, int area, float val) throws CarNotConnectedException {
        if(this.mHvacPropertyIds.contains(Integer.valueOf(propertyId))) {
            this.mCarPropertyMgr.setFloatProperty(propertyId, area, val);
        }
    }

    public void setIntProperty(int propertyId, int area, int val) throws CarNotConnectedException {
        if(this.mHvacPropertyIds.contains(Integer.valueOf(propertyId))) {
            this.mCarPropertyMgr.setIntProperty(propertyId, area, val);
        }
    }

    public void unregisterCallback(CarHvacEventCallback callback) {
        synchronized(this) {
            this.mCallbacks.remove(callback);
            try {
                for(Object object0: this.getPropertyList()) {
                    this.mCarPropertyMgr.unregisterListener(this.mListenerToBase, ((CarPropertyConfig)object0).getPropertyId());
                }
            }
            catch(Exception e) {
                Log.e("CarHvacManager", "getPropertyList exception ", e);
            }
            if(this.mCallbacks.isEmpty()) {
                this.mCarPropertyMgr.unregisterListener(this.mListenerToBase);
                this.mListenerToBase = null;
            }
        }
    }
}

