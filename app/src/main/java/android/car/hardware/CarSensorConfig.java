package android.car.hardware;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class CarSensorConfig implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CarSensorConfig createFromParcel(Parcel in) {
            return new CarSensorConfig(in);
        }

        public CarSensorConfig[] newArray(int size) {
            return new CarSensorConfig[size];
        }
    };
    public static final String WHEEL_TICK_DISTANCE_FRONT_LEFT_UM_PER_TICK = "android.car.wheelTickDistanceFrontLeftUmPerTick";
    public static final String WHEEL_TICK_DISTANCE_FRONT_RIGHT_UM_PER_TICK = "android.car.wheelTickDistanceFrontRightUmPerTick";
    public static final String WHEEL_TICK_DISTANCE_REAR_LEFT_UM_PER_TICK = "android.car.wheelTickDistanceRearLeftUmPerTick";
    public static final String WHEEL_TICK_DISTANCE_REAR_RIGHT_UM_PER_TICK = "android.car.wheelTickDistanceRearRightUmPerTick";
    public static final String WHEEL_TICK_DISTANCE_SUPPORTED_WHEELS = "android.car.wheelTickDistanceSupportedWheels";
    private final Bundle mConfig;
    private final int mType;

    public CarSensorConfig(int type, Bundle b) {
        this.mType = type;
        this.mConfig = b.deepCopy();
    }

    public CarSensorConfig(Parcel in) {
        this.mType = in.readInt();
        this.mConfig = in.readBundle();
    }

    private void checkType(int type) {
        if(this.mType != type) {
            throw new UnsupportedOperationException(String.format("Invalid sensor type: expected %d, got %d", type, ((int)this.mType)));
        }
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getBundle() {
        return this.mConfig;
    }

    public int getInt(String key) {
        if(!this.mConfig.containsKey(key)) {
            throw new IllegalArgumentException("SensorType " + this.mType + " does not contain key: " + key);
        }
        return this.mConfig.getInt(key);
    }

    public int getType() {
        return this.mType;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[" + ("mType: " + this.mType) + ("mConfig: " + this.mConfig.toString()) + "]";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mType);
        dest.writeBundle(this.mConfig);
    }
}

