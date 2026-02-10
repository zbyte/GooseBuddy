package com.yftech.car.dms;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class DmsResult implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private int mAlarmType;
    private int mDistractLevel;
    private int mDrowsyLevel;
    private int mDrowsyMask;
    private String mResult;

    static {
        DmsResult.CREATOR = new Parcelable.Creator() {
            public DmsResult createFromParcel(Parcel in) {
                DmsResult link = new DmsResult();
                link.mAlarmType = in.readInt();
                link.mDistractLevel = in.readInt();
                link.mDrowsyLevel = in.readInt();
                link.mDrowsyMask = in.readInt();
                link.mResult = in.readString();
                return link;
            }

            public DmsResult[] newArray(int size) {
                return new DmsResult[size];
            }
        };
    }

    public DmsResult() {
    }

    public DmsResult(int mAlarmType, int mDistractLevel, int mDrowsyLevel, int mDrowsyMask, String mResult) {
        this.mAlarmType = mAlarmType;
        this.mDistractLevel = mDistractLevel;
        this.mDrowsyLevel = mDrowsyLevel;
        this.mDrowsyMask = mDrowsyMask;
        this.mResult = mResult;
    }

    public DmsResult(int mAlarmType, int mDrowsyMask, String mResult) {
        this.mAlarmType = mAlarmType;
        this.mDrowsyMask = mDrowsyMask;
        this.mResult = mResult;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAlarmType() {
        return this.mAlarmType;
    }

    public static Parcelable.Creator getCREATOR() {
        return DmsResult.CREATOR;
    }

    public int getDistractLevel() {
        return this.mDistractLevel;
    }

    public int getDrowsyLevel() {
        return this.mDrowsyLevel;
    }

    public int getDrowsyMask() {
        return this.mDrowsyMask;
    }

    public String getResult() {
        return this.mResult;
    }

    @Override
    public String toString() {
        return "DmsResult{mAlarmType=" + this.mAlarmType + ", mDistractLevel=" + this.mDistractLevel + ", mDrowsyLevel=" + this.mDrowsyLevel + ", mDrowsyMask=" + this.mDrowsyMask + ", mResult=\'" + this.mResult + '\'' + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mAlarmType);
        dest.writeInt(this.mDrowsyMask);
        dest.writeInt(this.mDistractLevel);
        dest.writeInt(this.mDrowsyLevel);
        dest.writeString(this.mResult);
    }
}

