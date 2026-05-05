package android.car;

import android.car.hardware.CarPropertyValue;
import android.car.hardware.property.ICarProperty.Stub;
import android.car.hardware.property.ICarProperty;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public final class CarInfoManager implements CarManagerBase {
    public static final int BASIC_INFO_EV_BATTERY_CAPACITY = 0x11600106;
    public static final int BASIC_INFO_EV_CONNECTOR_TYPES = 0x11410107;
    public static final int BASIC_INFO_FUEL_CAPACITY = 0x11600104;
    public static final int BASIC_INFO_FUEL_TYPES = 0x11410105;
    public static final int BASIC_INFO_KEY_MANUFACTURER = 0x11100101;
    public static final int BASIC_INFO_KEY_MODEL = 0x11100102;
    public static final int BASIC_INFO_KEY_MODEL_YEAR = 0x11400103;
    public static final String BASIC_INFO_KEY_VEHICLE_ID = "android.car.vehicle-id";
    private static final boolean DBG = false;
    public static final String INFO_KEY_PRODUCT_CONFIGURATION = "android.car.product-config";
    private static final String TAG = "CarInfoManager";
    private final ICarProperty mService;

    CarInfoManager(IBinder service) {
        this.mService = Stub.asInterface(service);
    }

    public float getEvBatteryCapacity() throws CarNotConnectedException {
        CarPropertyValue carPropertyValue0 = this.getProperty(Float.class, 0x11600106, 0);
        return carPropertyValue0 == null ? 0.0f : ((float)(((Float)carPropertyValue0.getValue())));
    }

    public int[] getEvConnectorTypes() throws CarNotConnectedException {
        CarPropertyValue carPropertyValue0 = this.getProperty(int[].class, 0x11410107, 0);
        return carPropertyValue0 == null ? new int[0] : ((int[])carPropertyValue0.getValue());
    }

    public float getFuelCapacity() throws CarNotConnectedException {
        CarPropertyValue carPropertyValue0 = this.getProperty(Float.class, 0x11600104, 0);
        return carPropertyValue0 == null ? 0.0f : ((float)(((Float)carPropertyValue0.getValue())));
    }

    public int[] getFuelTypes() throws CarNotConnectedException {
        CarPropertyValue carPropertyValue0 = this.getProperty(int[].class, 0x11410105, 0);
        return carPropertyValue0 == null ? new int[0] : ((int[])carPropertyValue0.getValue());
    }

    public String getManufacturer() throws CarNotConnectedException {
        CarPropertyValue carPropertyValue0 = this.getProperty(String.class, 0x11100101, 0);
        return carPropertyValue0 == null ? null : ((String)carPropertyValue0.getValue());
    }

    public String getModel() throws CarNotConnectedException {
        CarPropertyValue carPropertyValue0 = this.getProperty(String.class, 0x11100102, 0);
        return carPropertyValue0 == null ? null : ((String)carPropertyValue0.getValue());
    }

    public String getModelYear() throws CarNotConnectedException {
        CarPropertyValue carPropertyValue0 = this.getProperty(String.class, 0x11400103, 0);
        return carPropertyValue0 == null ? null : ((String)carPropertyValue0.getValue());
    }

    private CarPropertyValue getProperty(Class class0, int propId, int area) throws CarNotConnectedException {
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
            Log.e("CarInfoManager", "getProperty failed with " + e.toString() + ", propId: 0x" + Integer.toHexString(propId) + ", area: 0x" + Integer.toHexString(area), e);
            throw new CarNotConnectedException(e);
        }
        catch(IllegalArgumentException unused_ex) {
            return null;
        }
    }

    public String getVehicleId() throws CarNotConnectedException {
        return "";
    }

    @Override  // android.car.CarManagerBase
    public void onCarDisconnected() {
    }
}

