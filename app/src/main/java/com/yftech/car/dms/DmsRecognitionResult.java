package com.yftech.car.dms;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class DmsRecognitionResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public DmsRecognitionResult createFromParcel(Parcel in) {
            DmsRecognitionResult mParam = new DmsRecognitionResult(in);
            mParam.mErrorCode = in.readInt();
            mParam.mFaceId = in.readLong();
            mParam.mResult = in.readString();
            return mParam;
        }

        public DmsRecognitionResult[] newArray(int size) {
            return new DmsRecognitionResult[size];
        }
    };
    private int mErrorCode;
    private long mFaceId;
    private String mResult;

    public DmsRecognitionResult(int mErrorCode, long mFaceId, String mResult) {
        this.mErrorCode = mErrorCode;
        this.mFaceId = mFaceId;
        this.mResult = mResult;
    }

    protected DmsRecognitionResult(Parcel in) {
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static Parcelable.Creator getCREATOR() {
        return DmsRecognitionResult.CREATOR;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public long getFaceId() {
        return this.mFaceId;
    }

    public String getResult() {
        return this.mResult;
    }

    @Override
    public String toString() {
        return "DmsRecognitionResult{mErrorCode=" + this.mErrorCode + ", mFaceId=" + this.mFaceId + ", mResult=\'" + this.mResult + '\'' + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mErrorCode);
        dest.writeLong(this.mFaceId);
        dest.writeString(this.mResult);
    }
}

