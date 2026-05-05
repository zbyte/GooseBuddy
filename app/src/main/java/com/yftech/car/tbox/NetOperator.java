package com.yftech.car.tbox;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class NetOperator implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public NetOperator createFromParcel(Parcel in) {
            return new NetOperator(in);
        }

        public NetOperator[] newArray(int size) {
            return new NetOperator[size];
        }
    };
    private int mMcc;
    private int mMnc;
    private String mOperatorName;

    public NetOperator() {
        this(0, 0, "");
    }

    public NetOperator(int mcc, int mnc, String operatorName) {
        this.mMcc = mcc;
        this.mMnc = mnc;
        this.mOperatorName = operatorName;
    }

    protected NetOperator(Parcel in) {
        this.readFromParcel(in);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getMcc() {
        return this.mMcc;
    }

    public int getMnc() {
        return this.mMnc;
    }

    public String getOperatorName() {
        return this.mOperatorName;
    }

    public void readFromParcel(Parcel source) {
        this.mMcc = source.readInt();
        this.mMnc = source.readInt();
        this.mOperatorName = source.readString();
    }

    public void setMcc(int mcc) {
        this.mMcc = mcc;
    }

    public void setMnc(int mnc) {
        this.mMnc = mnc;
    }

    public void setOperatorName(String operatorName) {
        this.mOperatorName = operatorName;
    }

    @Override
    public String toString() {
        return "(" + this.mMcc + ", " + this.mMnc + ", " + this.mOperatorName + ")" + super.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mMcc);
        parcel.writeInt(this.mMnc);
        parcel.writeString(this.mOperatorName);
    }
}

