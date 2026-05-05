package android.car.hardware;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class CarSensorEvent implements Parcelable {
    public static class CarAbsActiveData {
        public boolean absIsActive;
        public long timestamp;

        private CarAbsActiveData() {
        }
    }

    public static class CarEngineOilLevelData {
        public int engineOilLevel;
        public long timestamp;

        private CarEngineOilLevelData() {
        }
    }

    public static class CarEvBatteryChargeRateData {
        public float evChargeRate;
        public long timestamp;

        private CarEvBatteryChargeRateData() {
        }
    }

    public static class CarEvBatteryLevelData {
        public float evBatteryLevel;
        public long timestamp;

        private CarEvBatteryLevelData() {
        }
    }

    public static class CarEvChargePortConnectedData {
        public boolean evChargePortIsConnected;
        public long timestamp;

        private CarEvChargePortConnectedData() {
        }
    }

    public static class CarEvChargePortOpenData {
        public boolean evChargePortIsOpen;
        public long timestamp;

        private CarEvChargePortOpenData() {
        }
    }

    public static class CarFuelDoorOpenData {
        public boolean fuelDoorIsOpen;
        public long timestamp;

        private CarFuelDoorOpenData() {
        }
    }

    public static class CarSpeedData {
        public float carSpeed;
        public long timestamp;

        private CarSpeedData() {
        }
    }

    public static class CarTractionControlActiveData {
        public long timestamp;
        public boolean tractionControlIsActive;

        private CarTractionControlActiveData() {
        }
    }

    public static class CarWheelTickDistanceData {
        public long frontLeftWheelDistanceMm;
        public long frontRightWheelDistanceMm;
        public long rearLeftWheelDistanceMm;
        public long rearRightWheelDistanceMm;
        public long sensorResetCount;
        public long timestamp;

        private CarWheelTickDistanceData() {
        }
    }

    public static class EnvironmentData {
        public float pressure;
        public float temperature;
        public long timestamp;

        private EnvironmentData() {
        }
    }

    public static class FuelLevelData {
        public float level;
        public long timestamp;

        private FuelLevelData() {
        }
    }

    public static class GearData {
        public int gear;
        public long timestamp;

        private GearData() {
        }
    }

    public static class NightData {
        public boolean isNightMode;
        public long timestamp;

        private NightData() {
        }
    }

    public static class OdometerData {
        public float kms;
        public long timestamp;

        private OdometerData() {
        }
    }

    public static class ParkingBrakeData {
        public boolean isEngaged;
        public long timestamp;

        private ParkingBrakeData() {
        }
    }

    public static class RpmData {
        public float rpm;
        public long timestamp;

        private RpmData() {
        }
    }

    public static final Parcelable.Creator CREATOR  = new Parcelable.Creator() {
        public CarSensorEvent createFromParcel(Parcel in) {
            return new CarSensorEvent(in);
        }

        public CarSensorEvent[] newArray(int size) {
            return new CarSensorEvent[size];
        }
    };
    public static final int GEAR_DRIVE = 8;
    public static final int GEAR_EIGHTH = 0x800;
    public static final int GEAR_FIFTH = 0x100;
    public static final int GEAR_FIRST = 16;
    public static final int GEAR_FOURTH = 0x80;
    public static final int GEAR_NEUTRAL = 1;
    public static final int GEAR_NINTH = 0x1000;
    public static final int GEAR_PARK = 4;
    public static final int GEAR_REVERSE = 2;
    public static final int GEAR_SECOND = 0x20;
    public static final int GEAR_SEVENTH = 0x400;
    public static final int GEAR_SIXTH = 0x200;
    public static final int GEAR_TENTH = 0x2000;
    public static final int GEAR_THIRD = 0x40;
    public static final int IGNITION_STATE_ACC = 3;
    public static final int IGNITION_STATE_LOCK = 1;
    public static final int IGNITION_STATE_OFF = 2;
    public static final int IGNITION_STATE_ON = 4;
    public static final int IGNITION_STATE_START = 5;
    public static final int IGNITION_STATE_UNDEFINED = 0;
    public static final int INDEX_ENVIRONMENT_PRESSURE = 1;
    public static final int INDEX_ENVIRONMENT_TEMPERATURE = 0;
    public static final int INDEX_WHEEL_DISTANCE_FRONT_LEFT = 1;
    public static final int INDEX_WHEEL_DISTANCE_FRONT_RIGHT = 2;
    public static final int INDEX_WHEEL_DISTANCE_REAR_LEFT = 4;
    public static final int INDEX_WHEEL_DISTANCE_REAR_RIGHT = 3;
    public static final int INDEX_WHEEL_DISTANCE_RESET_COUNT = 0;
    private static final long MILLI_IN_NANOS = 1000000L;
    public final float[] floatValues;
    public final int[] intValues;
    public final long[] longValues;
    public int sensorType;
    public long timestamp;

    public CarSensorEvent(int sensorType, long timestamp, int floatValueSize, int intValueSize, int longValueSize) {
        this.sensorType = sensorType;
        this.timestamp = timestamp;
        this.floatValues = new float[floatValueSize];
        this.intValues = new int[intValueSize];
        this.longValues = new long[longValueSize];
    }

    CarSensorEvent(int sensorType, long timestamp, float[] floatValues, int[] intValues, long[] longValues) {
        this.sensorType = sensorType;
        this.timestamp = timestamp;
        this.floatValues = floatValues;
        this.intValues = intValues;
        this.longValues = longValues;
    }

    public CarSensorEvent(Parcel in) {
        this.sensorType = in.readInt();
        this.timestamp = in.readLong();
        this.floatValues = new float[in.readInt()];
        in.readFloatArray(this.floatValues);
        this.intValues = new int[in.readInt()];
        in.readIntArray(this.intValues);
        this.longValues = new long[in.readInt()];
        in.readLongArray(this.longValues);
    }

    private void checkType(int type) {
        if(this.sensorType != type) {
            throw new UnsupportedOperationException(String.format("Invalid sensor type: expected %d, got %d", type, ((int)this.sensorType)));
        }
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CarAbsActiveData getCarAbsActiveData(CarAbsActiveData data) {
        this.checkType(0x1120040A);
        if(data == null) {
            data = new CarAbsActiveData();
        }
        data.timestamp = this.timestamp;
        data.absIsActive = this.intValues[0] == 1;
        return data;
    }

    public CarEngineOilLevelData getCarEngineOilLevelData(CarEngineOilLevelData data) {
        this.checkType(0x11400303);
        if(data == null) {
            data = new CarEngineOilLevelData();
        }
        data.timestamp = this.timestamp;
        data.engineOilLevel = this.intValues[0];
        return data;
    }

    public CarEvBatteryChargeRateData getCarEvBatteryChargeRateData(CarEvBatteryChargeRateData data) {
        this.checkType(0x1160030C);
        if(data == null) {
            data = new CarEvBatteryChargeRateData();
        }
        data.timestamp = this.timestamp;
        data.evChargeRate = this.floatValues[0];
        return data;
    }

    public CarEvBatteryLevelData getCarEvBatteryLevelData(CarEvBatteryLevelData data) {
        this.checkType(0x11600309);
        if(data == null) {
            data = new CarEvBatteryLevelData();
        }
        data.timestamp = this.timestamp;
        if(this.floatValues == null) {
            data.evBatteryLevel = -1.0f;
            return data;
        }
        if((this.floatValues[0] < 0.0f)) {
            data.evBatteryLevel = -1.0f;
            return data;
        }
        data.evBatteryLevel = this.floatValues[0];
        return data;
    }

    public CarEvChargePortConnectedData getCarEvChargePortConnectedData(CarEvChargePortConnectedData data) {
        this.checkType(0x1120030B);
        if(data == null) {
            data = new CarEvChargePortConnectedData();
        }
        data.timestamp = this.timestamp;
        data.evChargePortIsConnected = this.intValues[0] == 1;
        return data;
    }

    public CarEvChargePortOpenData getCarEvChargePortOpenData(CarEvChargePortOpenData data) {
        this.checkType(0x1120030A);
        if(data == null) {
            data = new CarEvChargePortOpenData();
        }
        data.timestamp = this.timestamp;
        data.evChargePortIsOpen = this.intValues[0] == 1;
        return data;
    }

    public CarFuelDoorOpenData getCarFuelDoorOpenData(CarFuelDoorOpenData data) {
        this.checkType(0x11200308);
        if(data == null) {
            data = new CarFuelDoorOpenData();
        }
        data.timestamp = this.timestamp;
        data.fuelDoorIsOpen = this.intValues[0] == 1;
        return data;
    }

    public CarSpeedData getCarSpeedData(CarSpeedData data) {
        this.checkType(0x11600207);
        if(data == null) {
            data = new CarSpeedData();
        }
        data.timestamp = this.timestamp;
        data.carSpeed = this.floatValues[0];
        return data;
    }

    public CarTractionControlActiveData getCarTractionControlActiveData(CarTractionControlActiveData data) {
        this.checkType(0x1120040B);
        if(data == null) {
            data = new CarTractionControlActiveData();
        }
        data.timestamp = this.timestamp;
        data.tractionControlIsActive = this.intValues[0] == 1;
        return data;
    }

    public CarWheelTickDistanceData getCarWheelTickDistanceData(CarWheelTickDistanceData data) {
        this.checkType(0x11510306);
        if(data == null) {
            data = new CarWheelTickDistanceData();
        }
        data.timestamp = this.timestamp;
        data.sensorResetCount = this.longValues[0];
        data.frontLeftWheelDistanceMm = this.longValues[1];
        data.frontRightWheelDistanceMm = this.longValues[2];
        data.rearRightWheelDistanceMm = this.longValues[3];
        data.rearLeftWheelDistanceMm = this.longValues[4];
        return data;
    }

    public EnvironmentData getEnvironmentData(EnvironmentData data) {
        this.checkType(12);
        if(data == null) {
            data = new EnvironmentData();
        }
        data.timestamp = this.timestamp;
        data.temperature = this.floatValues[0];
        data.pressure = this.floatValues[1];
        return data;
    }

    public FuelLevelData getFuelLevelData(FuelLevelData data) {
        this.checkType(0x11600307);
        if(data == null) {
            data = new FuelLevelData();
        }
        data.timestamp = this.timestamp;
        if(this.floatValues == null) {
            data.level = -1.0f;
            return data;
        }
        if((this.floatValues[0] < 0.0f)) {
            data.level = -1.0f;
            return data;
        }
        data.level = this.floatValues[0];
        return data;
    }

    public GearData getGearData(GearData data) {
        this.checkType(0x11400400);
        if(data == null) {
            data = new GearData();
        }
        data.timestamp = this.timestamp;
        data.gear = this.intValues[0];
        return data;
    }

    public NightData getNightData(NightData data) {
        this.checkType(0x11200407);
        if(data == null) {
            data = new NightData();
        }
        data.timestamp = this.timestamp;
        data.isNightMode = this.intValues[0] == 1;
        return data;
    }

    public OdometerData getOdometerData(OdometerData data) {
        this.checkType(0x11600204);
        if(data == null) {
            data = new OdometerData();
        }
        data.timestamp = this.timestamp;
        data.kms = this.floatValues[0];
        return data;
    }

    public ParkingBrakeData getParkingBrakeData(ParkingBrakeData data) {
        this.checkType(0x11200402);
        if(data == null) {
            data = new ParkingBrakeData();
        }
        data.timestamp = this.timestamp;
        data.isEngaged = this.intValues[0] == 1;
        return data;
    }

    public RpmData getRpmData(RpmData data) {
        this.checkType(0x11600305);
        if(data == null) {
            data = new RpmData();
        }
        data.timestamp = this.timestamp;
        data.rpm = this.floatValues[0];
        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getName() + "[");
        sb.append("type:" + Integer.toHexString(this.sensorType));
        if(this.floatValues != null && this.floatValues.length > 0) {
            sb.append(" float values:");
            float[] arr_f = this.floatValues;
            for(int v1 = 0; v1 < arr_f.length; ++v1) {
                sb.append(" " + arr_f[v1]);
            }
        }
        if(this.intValues != null && this.intValues.length > 0) {
            sb.append(" int values:");
            int[] arr_v = this.intValues;
            for(int v2 = 0; v2 < arr_v.length; ++v2) {
                sb.append(" " + arr_v[v2]);
            }
        }
        if(this.longValues != null && this.longValues.length > 0) {
            sb.append(" long values:");
            long[] arr_v1 = this.longValues;
            for(int v = 0; v < arr_v1.length; ++v) {
                sb.append(" " + arr_v1[v]);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.sensorType);
        dest.writeLong(this.timestamp);
        dest.writeInt(this.floatValues.length);
        dest.writeFloatArray(this.floatValues);
        dest.writeInt(this.intValues.length);
        dest.writeIntArray(this.intValues);
        dest.writeInt(this.longValues.length);
        dest.writeLongArray(this.longValues);
    }
}

