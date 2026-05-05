package android.car.drivingstate;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CarUxRestrictions implements Parcelable {
    public static class Builder {
        private final int mActiveRestrictions;
        private int mMaxContentDepth;
        private int mMaxCumulativeContentItems;
        private int mMaxStringLength;
        private final boolean mRequiresDistractionOptimization;
        private final long mTimeStamp;

        public Builder(boolean reqOpt, int restrictions, long time) {
            this.mMaxStringLength = 120;
            this.mMaxCumulativeContentItems = 21;
            this.mMaxContentDepth = 3;
            this.mRequiresDistractionOptimization = reqOpt;
            this.mActiveRestrictions = restrictions;
            this.mTimeStamp = time;
        }

        public CarUxRestrictions build() {
            return new CarUxRestrictions(this);
        }

        public Builder setMaxContentDepth(int depth) {
            this.mMaxContentDepth = depth;
            return this;
        }

        public Builder setMaxCumulativeContentItems(int number) {
            this.mMaxCumulativeContentItems = number;
            return this;
        }

        public Builder setMaxStringLength(int length) {
            this.mMaxStringLength = length;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CarUxRestrictionsInfo {
    }

    public static final Parcelable.Creator CREATOR  = new Parcelable.Creator() {
        public CarUxRestrictions createFromParcel(Parcel in) {
            return new CarUxRestrictions(in);
        }

        public CarUxRestrictions[] newArray(int size) {
            return new CarUxRestrictions[size];
        }
    };
    private static final int DEFAULT_MAX_CONTENT_DEPTH = 3;
    private static final int DEFAULT_MAX_CUMULATIVE_ITEMS = 21;
    private static final int DEFAULT_MAX_LENGTH = 120;
    public static final int UX_RESTRICTIONS_BASELINE = 0;
    public static final int UX_RESTRICTIONS_FULLY_RESTRICTED = 0x1FF;
    public static final int UX_RESTRICTIONS_LIMIT_CONTENT = 0x20;
    public static final int UX_RESTRICTIONS_LIMIT_STRING_LENGTH = 4;
    public static final int UX_RESTRICTIONS_NO_DIALPAD = 1;
    public static final int UX_RESTRICTIONS_NO_FILTERING = 2;
    public static final int UX_RESTRICTIONS_NO_KEYBOARD = 8;
    public static final int UX_RESTRICTIONS_NO_SETUP = 0x40;
    public static final int UX_RESTRICTIONS_NO_TEXT_MESSAGE = 0x80;
    public static final int UX_RESTRICTIONS_NO_VIDEO = 16;
    public static final int UX_RESTRICTIONS_NO_VOICE_TRANSCRIPTION = 0x100;
    private final int mActiveRestrictions;
    private final int mMaxContentDepth;
    private final int mMaxCumulativeContentItems;
    private final int mMaxStringLength;
    private final boolean mRequiresDistractionOptimization;
    private final long mTimeStamp;

    private CarUxRestrictions(Builder builder) {
        this.mTimeStamp = builder.mTimeStamp;
        this.mActiveRestrictions = builder.mActiveRestrictions;
        this.mRequiresDistractionOptimization = builder.mRequiresDistractionOptimization;
        this.mMaxStringLength = builder.mMaxStringLength;
        this.mMaxCumulativeContentItems = builder.mMaxCumulativeContentItems;
        this.mMaxContentDepth = builder.mMaxContentDepth;
    }

    public CarUxRestrictions(CarUxRestrictions uxRestrictions) {
        this.mTimeStamp = uxRestrictions.getTimeStamp();
        this.mRequiresDistractionOptimization = uxRestrictions.isRequiresDistractionOptimization();
        this.mActiveRestrictions = uxRestrictions.getActiveRestrictions();
        this.mMaxStringLength = uxRestrictions.mMaxStringLength;
        this.mMaxCumulativeContentItems = uxRestrictions.mMaxCumulativeContentItems;
        this.mMaxContentDepth = uxRestrictions.mMaxContentDepth;
    }

    private CarUxRestrictions(Parcel in) {
        this.mActiveRestrictions = in.readInt();
        this.mTimeStamp = in.readLong();
        this.mRequiresDistractionOptimization = in.readInt() != 0;
        this.mMaxStringLength = in.readInt();
        this.mMaxCumulativeContentItems = in.readInt();
        this.mMaxContentDepth = in.readInt();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActiveRestrictions() {
        return this.mActiveRestrictions;
    }

    public int getMaxContentDepth() {
        return this.mMaxContentDepth;
    }

    public int getMaxCumulativeContentItems() {
        return this.mMaxCumulativeContentItems;
    }

    public int getMaxRestrictedStringLength() {
        return this.mMaxStringLength;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public boolean isRequiresDistractionOptimization() {
        return this.mRequiresDistractionOptimization;
    }

    public boolean isSameRestrictions(CarUxRestrictions other) {
        if(other == null) {
            return false;
        }
        return other == this ? true : other.mRequiresDistractionOptimization == this.mRequiresDistractionOptimization && other.mActiveRestrictions == this.mActiveRestrictions;
    }

    @Override
    public String toString() {
        return "DO: " + this.mRequiresDistractionOptimization + " UxR: " + this.mActiveRestrictions + " time: " + this.mTimeStamp;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mActiveRestrictions);
        dest.writeLong(this.mTimeStamp);
        dest.writeInt(this.mRequiresDistractionOptimization?1:0);
        dest.writeInt(this.mMaxStringLength);
        dest.writeInt(this.mMaxCumulativeContentItems);
        dest.writeInt(this.mMaxContentDepth);
    }
}

