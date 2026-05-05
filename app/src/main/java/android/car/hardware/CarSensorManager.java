package android.car.hardware;

import android.car.CarApiUtil;
import android.car.CarManagerBase;
import android.car.CarNotConnectedException;
import android.car.hardware.property.CarPropertyManager.CarPropertyEventListener;
import android.car.hardware.property.CarPropertyManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class CarSensorManager implements CarManagerBase {
    static class CarPropertyEventListenerToBase implements CarPropertyEventListener {
        private final OnSensorChangedListener mListener;
        private final WeakReference mManager;

        CarPropertyEventListenerToBase(CarSensorManager manager, OnSensorChangedListener listener) {
            mManager = new WeakReference(manager);
            mListener = listener;
        }

        @Override  // android.car.hardware.property.CarPropertyManager$CarPropertyEventListener
        public void onChangeEvent(CarPropertyValue value) {
            CarSensorManager manager = (CarSensorManager)mManager.get();
            if(manager != null) {
                manager.handleOnChangeEvent(value, mListener);
            }
        }

        @Override  // android.car.hardware.property.CarPropertyManager$CarPropertyEventListener
        public void onErrorEvent(int propertyId, int zone) {
        }
    }

    public interface OnSensorChangedListener {
        void onSensorChanged(CarSensorEvent arg1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SensorRate {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SensorType {
    }

    private static final boolean DBG = false;
    private static final int INDEX_WHEEL_DISTANCE_ENABLE_FLAG = 0;
    private static final int INDEX_WHEEL_DISTANCE_FRONT_LEFT = 1;
    private static final int INDEX_WHEEL_DISTANCE_FRONT_RIGHT = 2;
    private static final int INDEX_WHEEL_DISTANCE_REAR_LEFT = 4;
    private static final int INDEX_WHEEL_DISTANCE_REAR_RIGHT = 3;
    public static final int SENSOR_RATE_FAST = 10;
    public static final int SENSOR_RATE_FASTEST = 100;
    public static final int SENSOR_RATE_NORMAL = 1;
    public static final int SENSOR_RATE_UI = 5;
    public static final int SENSOR_TYPE_ABS_ACTIVE = 0x1120040A;
    public static final int SENSOR_TYPE_CAR_SPEED = 0x11600207;
    public static final int SENSOR_TYPE_ENGINE_OIL_LEVEL = 0x11400303;
    public static final int SENSOR_TYPE_ENVIRONMENT = 12;
    public static final int SENSOR_TYPE_EV_BATTERY_CHARGE_RATE = 0x1160030C;
    public static final int SENSOR_TYPE_EV_BATTERY_LEVEL = 0x11600309;
    public static final int SENSOR_TYPE_EV_CHARGE_PORT_CONNECTED = 0x1120030B;
    public static final int SENSOR_TYPE_EV_CHARGE_PORT_OPEN = 0x1120030A;
    public static final int SENSOR_TYPE_FUEL_DOOR_OPEN = 0x11200308;
    public static final int SENSOR_TYPE_FUEL_LEVEL = 0x11600307;
    public static final int SENSOR_TYPE_GEAR = 0x11400400;
    public static final int SENSOR_TYPE_IGNITION_STATE = 0x11400409;
    public static final int SENSOR_TYPE_NIGHT = 0x11200407;
    public static final int SENSOR_TYPE_ODOMETER = 0x11600204;
    public static final int SENSOR_TYPE_PARKING_BRAKE = 0x11200402;
    public static final int SENSOR_TYPE_RESERVED1 = 1;
    public static final int SENSOR_TYPE_RESERVED10 = 10;
    public static final int SENSOR_TYPE_RESERVED11 = 11;
    public static final int SENSOR_TYPE_RESERVED13 = 13;
    public static final int SENSOR_TYPE_RESERVED14 = 14;
    public static final int SENSOR_TYPE_RESERVED15 = 15;
    public static final int SENSOR_TYPE_RESERVED16 = 16;
    public static final int SENSOR_TYPE_RESERVED17 = 17;
    public static final int SENSOR_TYPE_RESERVED18 = 18;
    public static final int SENSOR_TYPE_RESERVED19 = 19;
    public static final int SENSOR_TYPE_RESERVED20 = 20;
    public static final int SENSOR_TYPE_RESERVED21 = 21;
    public static final int SENSOR_TYPE_RESERVED26 = 26;
    public static final int SENSOR_TYPE_RESERVED8 = 8;
    public static final int SENSOR_TYPE_RPM = 0x11600305;
    public static final int SENSOR_TYPE_TRACTION_CONTROL_ACTIVE = 0x1120040B;
    public static final int SENSOR_TYPE_WHEEL_TICK_DISTANCE = 0x11510306;
    private static final String TAG = "CarSensorManager";
    private static final int WHEEL_TICK_DISTANCE_BUNDLE_SIZE = 6;
    private CarPropertyEventListenerToBase mCarPropertyEventListener;
    private final CarPropertyManager mCarPropertyMgr;
    private final HashMap mListenerMap;
    private final ArraySet mSensorConfigIds;

    public CarSensorManager(IBinder service, Context context, Handler handler) {
        mSensorConfigIds = new ArraySet(Arrays.asList(new Integer[]{((int)0x11600207), ((int)0x11600305), ((int)0x11600204), ((int)0x11600307), ((int)0x11200402), ((int)0x11400400), ((int)0x11200407), ((int)12), ((int)0x11400409), ((int)0x11510306), ((int)0x1120040A), ((int)0x1120040B), ((int)0x11200308), ((int)0x11600309), ((int)0x1120030A), ((int)0x1120030B), ((int)0x1160030C), ((int)0x11400303)}));
        mCarPropertyEventListener = null;
        mListenerMap = new HashMap();
        mCarPropertyMgr = new CarPropertyManager(service, handler, false, "CarSensorManager");
    }

    private CarSensorEvent createCarSensorEvent(CarPropertyValue propertyValue) {
        CarSensorEvent event;
        switch(propertyValue.getPropertyId() & 0xFF0000) {
            case 0x200000: {
                event = new CarSensorEvent(propertyValue.getPropertyId(), propertyValue.getTimestamp(), 0, 1, 0);
                event.intValues[0] = (Boolean) propertyValue.getValue() ?1:0;
                return event;
            }
            case 0x400000: {
                event = new CarSensorEvent(propertyValue.getPropertyId(), propertyValue.getTimestamp(), 0, 1, 0);
                event.intValues[0] = (int)(((Integer)propertyValue.getValue()));
                return event;
            }
            case 0x510000: {
                Object[] value = (Object[])propertyValue.getValue();
                event = new CarSensorEvent(propertyValue.getPropertyId(), propertyValue.getTimestamp(), 0, 0, value.length);
                for(int i = 0; i < value.length; ++i) {
                    event.longValues[i] = (long)(((Long)value[i]));
                }
                return event;
            }
            case 0x600000: {
                event = new CarSensorEvent(propertyValue.getPropertyId(), propertyValue.getTimestamp(), 1, 0, 0);
                event.floatValues[0] = (float)(((Float)propertyValue.getValue()));
                return event;
            }
            default: {
                Log.e(TAG,  "unhandled VehiclePropertyType for propId=" + propertyValue.getPropertyId());
                return null;
            }
        }
    }

    private Bundle createWheelDistanceTickBundle(List list0) {
        Bundle b = new Bundle(6);
        b.putInt("android.car.wheelTickDistanceSupportedWheels", ((Integer)list0.get(0)).intValue());
        b.putInt("android.car.wheelTickDistanceFrontLeftUmPerTick", ((Integer)list0.get(1)).intValue());
        b.putInt("android.car.wheelTickDistanceFrontRightUmPerTick", ((Integer)list0.get(2)).intValue());
        b.putInt("android.car.wheelTickDistanceRearRightUmPerTick", ((Integer)list0.get(3)).intValue());
        b.putInt("android.car.wheelTickDistanceRearLeftUmPerTick", ((Integer)list0.get(4)).intValue());
        return b;
    }

    public CarSensorEvent getLatestSensorEvent(int type) throws CarNotConnectedException {
        try {
            return createCarSensorEvent(mCarPropertyMgr.getProperty(type, 0));
        }
        catch(IllegalStateException e) {
            CarApiUtil.checkCarNotConnectedExceptionFromCarService(e);
            return null;
        }
    }

    public List getPropertyList() throws CarNotConnectedException {
        return mCarPropertyMgr.getPropertyList(mSensorConfigIds);
    }

    public CarSensorConfig getSensorConfig(int type) throws CarNotConnectedException {
        if(type != 0x11510306) {
            return new CarSensorConfig(type, Bundle.EMPTY);
        }
        for(Object object0: mCarPropertyMgr.getPropertyList()) {
            CarPropertyConfig p = (CarPropertyConfig)object0;
            if(p.getPropertyId() == 0x11510306) {
                return new CarSensorConfig(0x11510306, createWheelDistanceTickBundle(p.getConfigArray()));
            }
        }
        return new CarSensorConfig(0x11510306, null);
    }

    public int[] getSupportedSensors() throws CarNotConnectedException {
        try {
            List list0 = getPropertyList();
            int[] supportedSensors = new int[list0.size()];
            for(int i = 0; i < supportedSensors.length; ++i) {
                supportedSensors[i] = ((CarPropertyConfig)list0.get(i)).getPropertyId();
            }
            return supportedSensors;
        }
        catch(IllegalStateException e) {
            CarApiUtil.checkCarNotConnectedExceptionFromCarService(e);
            return new int[0];
        }
    }

    private void handleCarServiceRemoteExceptionAndThrow(RemoteException e) throws CarNotConnectedException {
        if(Log.isLoggable("CAR.L.SENSOR", Log.INFO)) {
            Log.i("CAR.L.SENSOR", "RemoteException from car service:" + e.getMessage());
        }
        throw new CarNotConnectedException();
    }

    private void handleOnChangeEvent(CarPropertyValue value, OnSensorChangedListener listener) {
        synchronized(mListenerMap) {
            listener.onSensorChanged(createCarSensorEvent(value));
        }
    }

    private void handleOnErrorEvent(int propertyId, int zone) {
    }

    public static boolean isSensorSupported(int[] sensorList, int sensorType) {
        for(int v1 = 0; v1 < sensorList.length; ++v1) {
            if(sensorType == sensorList[v1]) {
                return true;
            }
        }
        return false;
    }

    public boolean isSensorSupported(int sensorType) throws CarNotConnectedException {
        int[] arr_v = getSupportedSensors();
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            if(sensorType == arr_v[v1]) {
                return true;
            }
        }
        return false;
    }

    @Override  // android.car.CarManagerBase
    public void onCarDisconnected() {
        synchronized(mListenerMap) {
            mListenerMap.clear();
        }
        mCarPropertyMgr.onCarDisconnected();
    }

    public boolean registerListener(OnSensorChangedListener listener, int sensorType, int rate) throws CarNotConnectedException, IllegalArgumentException {
        if(rate != 1 && rate != 100 && (rate != 5 && rate != 10)) {
            throw new IllegalArgumentException("wrong rate " + rate);
        }
        mCarPropertyEventListener = mListenerMap.get(listener) == null ? new CarPropertyEventListenerToBase(this, listener) : ((CarPropertyEventListenerToBase)mListenerMap.get(listener));
        if(mCarPropertyMgr.registerListener(mCarPropertyEventListener, sensorType, ((float)rate))) {
            mListenerMap.put(listener, mCarPropertyEventListener);
            return true;
        }
        return false;
    }

    public void unregisterListener(OnSensorChangedListener listener) {
        synchronized(mListenerMap) {
            mCarPropertyEventListener = (CarPropertyEventListenerToBase)mListenerMap.get(listener);
            mCarPropertyMgr.unregisterListener(mCarPropertyEventListener);
            mListenerMap.remove(listener);
        }
    }

    public void unregisterListener(OnSensorChangedListener listener, int sensorType) {
        synchronized(mListenerMap) {
            mCarPropertyEventListener = (CarPropertyEventListenerToBase)mListenerMap.get(listener);
        }
        mCarPropertyMgr.unregisterListener(mCarPropertyEventListener, sensorType);
    }
}

