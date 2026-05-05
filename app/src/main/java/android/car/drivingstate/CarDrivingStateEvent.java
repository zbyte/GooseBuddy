package android.car.drivingstate;


import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public class CarDrivingStateEvent implements Parcelable {
    @Retention(RetentionPolicy.SOURCE)
    public @interface CarDrivingState {
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CarDrivingStateEvent createFromParcel(Parcel in) {
            return new CarDrivingStateEvent(in);
        }

        public CarDrivingStateEvent[] newArray(int size) {
            return new CarDrivingStateEvent[size];
        }
    };
    public static final int DRIVING_STATE_IDLING = 1;
    public static final int DRIVING_STATE_MOVING = 2;
    public static final int DRIVING_STATE_PARKED = 0;
    public static final int DRIVING_STATE_UNKNOWN = -1;
    public final int eventValue;
    public final long timeStamp;

    public CarDrivingStateEvent(int value, long time) {
        this.eventValue = value;
        this.timeStamp = time;
    }

    private CarDrivingStateEvent(Parcel in) {
        this.eventValue = in.readInt();
        this.timeStamp = in.readLong();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return this.eventValue + " " + this.timeStamp;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.eventValue);
        dest.writeLong(this.timeStamp);
    }
}

