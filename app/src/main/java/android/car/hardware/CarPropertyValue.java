package android.car.hardware;


import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;


public class CarPropertyValue implements Parcelable {
    @Retention(RetentionPolicy.SOURCE)
    public @interface PropertyStatus {
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CarPropertyValue createFromParcel(Parcel in) {
            return new CarPropertyValue(in);
        }

        public CarPropertyValue[] newArray(int size) {
            return new CarPropertyValue[size];
        }
    };
    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    public static final int STATUS_AVAILABLE = 0;
    public static final int STATUS_ERROR = 2;
    public static final int STATUS_UNAVAILABLE = 1;
    private final int mAreaId;
    private final int mPropertyId;
    private final int mStatus;
    private final long mTimestamp;
    private final Object mValue;

    public CarPropertyValue(int propertyId, int areaId, int status, long timestamp, Object object0) {
        this.mPropertyId = propertyId;
        this.mAreaId = areaId;
        this.mStatus = status;
        this.mTimestamp = timestamp;
        this.mValue = object0;
    }

    public CarPropertyValue(int propertyId, int areaId, Object object0) {
        this(propertyId, areaId, 0, 0L, object0);
    }

    public CarPropertyValue(Parcel in) {
        Class class0;
        this.mPropertyId = in.readInt();
        this.mAreaId = in.readInt();
        this.mStatus = in.readInt();
        this.mTimestamp = in.readLong();
        String s = in.readString();
        try {
            class0 = Class.forName(s);
        }
        catch(ClassNotFoundException unused_ex) {
            throw new IllegalArgumentException("Class not found: " + s);
        }
        if(String.class.equals(class0)) {
            this.mValue = new String(in.readBlob(), CarPropertyValue.DEFAULT_CHARSET);
            return;
        }
        if(byte[].class.equals(class0)) {
            this.mValue = in.readBlob();
            return;
        }
        this.mValue = in.readValue(class0.getClassLoader());
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAreaId() {
        return this.mAreaId;
    }

    public int getPropertyId() {
        return this.mPropertyId;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public Object getValue() {
        return this.mValue;
    }

    @Override
    public String toString() {
        return "CarPropertyValue{mPropertyId=0x" + Integer.toHexString(this.mPropertyId) + ", mAreaId=0x" + Integer.toHexString(this.mAreaId) + ", mStatus=" + this.mStatus + ", mTimestamp=" + this.mTimestamp + ", mValue=" + this.mValue + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mPropertyId);
        dest.writeInt(this.mAreaId);
        dest.writeInt(this.mStatus);
        dest.writeLong(this.mTimestamp);
        String s = null;
        Class class0 = this.mValue == null ? null : this.mValue.getClass();
        if(class0 != null) {
            s = class0.getName();
        }
        dest.writeString(s);
        if(String.class.equals(class0)) {
            dest.writeBlob(((String)this.mValue).getBytes(CarPropertyValue.DEFAULT_CHARSET));
            return;
        }
        if(byte[].class.equals(class0)) {
            dest.writeBlob(((byte[])this.mValue));
            return;
        }
        dest.writeValue(this.mValue);
    }
}

