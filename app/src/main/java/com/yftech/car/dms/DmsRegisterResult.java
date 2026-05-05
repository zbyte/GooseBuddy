package com.yftech.car.dms;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class DmsRegisterResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public DmsRegisterResult createFromParcel(Parcel in) {
            DmsRegisterResult mParam = new DmsRegisterResult(in);
            mParam.mErrorCode = in.readInt();
            mParam.mFaceId = in.readLong();
            return mParam;
        }

        public DmsRegisterResult[] newArray(int size) {
            return new DmsRegisterResult[size];
        }
    };
    private int mErrorCode;
    private long mFaceId;

    public DmsRegisterResult(int mErrorCode, long mFaceId) {
        this.mErrorCode = mErrorCode;
        this.mFaceId = mFaceId;
    }

    protected DmsRegisterResult(Parcel in) {
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static Parcelable.Creator getCREATOR() {
        return DmsRegisterResult.CREATOR;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public long getFaceId() {
        return this.mFaceId;
    }

    @Override
    public String toString() {
        return "DmsRegisterResult{mErrorCode=" + this.mErrorCode + ", mFaceId=" + this.mFaceId + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mErrorCode);
        dest.writeLong(this.mFaceId);
    }
}

