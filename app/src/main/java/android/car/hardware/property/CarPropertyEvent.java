package android.car.hardware.property;

import android.car.hardware.CarPropertyValue;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class CarPropertyEvent implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CarPropertyEvent createFromParcel(Parcel in) {
            return new CarPropertyEvent(in);
        }

        public CarPropertyEvent[] newArray(int size) {
            return new CarPropertyEvent[size];
        }
    };
    public static final int PROPERTY_EVENT_ERROR = 1;
    public static final int PROPERTY_EVENT_PROPERTY_CHANGE = 0;
    private final CarPropertyValue mCarPropertyValue;
    private final int mEventType;

    public CarPropertyEvent(int eventType, CarPropertyValue carPropertyValue0) {
        this.mEventType = eventType;
        this.mCarPropertyValue = carPropertyValue0;
    }

    private CarPropertyEvent(Parcel in) {
        this.mEventType = in.readInt();
        this.mCarPropertyValue = (CarPropertyValue)in.readParcelable(CarPropertyValue.class.getClassLoader());
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CarPropertyValue getCarPropertyValue() {
        return this.mCarPropertyValue;
    }

    public int getEventType() {
        return this.mEventType;
    }

    @Override
    public String toString() {
        return "CarPropertyEvent{mEventType=" + this.mEventType + ", mCarPropertyValue=" + this.mCarPropertyValue + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mEventType);
        dest.writeParcelable(this.mCarPropertyValue, flags);
    }
}

