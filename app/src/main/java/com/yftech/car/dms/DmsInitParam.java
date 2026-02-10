package com.yftech.car.dms;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class DmsInitParam implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private int mCameraImageFormat;
    private int mCameraImageProcessType;
    private int mCameraImageSizeImageHeight;
    private int mCameraImageSizeImageWidth;
    private int mCameraImageSizeProcessType;

    static {
        DmsInitParam.CREATOR = new Parcelable.Creator() {
            public DmsInitParam createFromParcel(Parcel in) {
                DmsInitParam mParam = new DmsInitParam(in);
                mParam.mCameraImageProcessType = in.readInt();
                mParam.mCameraImageFormat = in.readInt();
                mParam.mCameraImageSizeProcessType = in.readInt();
                mParam.mCameraImageSizeImageWidth = in.readInt();
                mParam.mCameraImageSizeImageHeight = in.readInt();
                return mParam;
            }

            public DmsInitParam[] newArray(int size) {
                return new DmsInitParam[size];
            }
        };
    }

    public DmsInitParam(int mCameraImageProcessType, int mCameraImageFormat, int mCameraImageSizeProcessType, int mCameraImageSizeImageWidth, int mCameraImageSizeImageHeight) {
        this.mCameraImageProcessType = mCameraImageProcessType;
        this.mCameraImageFormat = mCameraImageFormat;
        this.mCameraImageSizeProcessType = mCameraImageSizeProcessType;
        this.mCameraImageSizeImageWidth = mCameraImageSizeImageWidth;
        this.mCameraImageSizeImageHeight = mCameraImageSizeImageHeight;
    }

    protected DmsInitParam(Parcel in) {
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static Parcelable.Creator getCREATOR() {
        return DmsInitParam.CREATOR;
    }

    public int getCameraImageFormat() {
        return this.mCameraImageFormat;
    }

    public int getCameraImageProcessType() {
        return this.mCameraImageProcessType;
    }

    public int getCameraImageSizeImageHeight() {
        return this.mCameraImageSizeImageHeight;
    }

    public int getCameraImageSizeImageWidth() {
        return this.mCameraImageSizeImageWidth;
    }

    public int getCameraImageSizeProcessType() {
        return this.mCameraImageSizeProcessType;
    }

    @Override
    public String toString() {
        return "DmsInitParam{mCameraImageProcessType=" + this.mCameraImageProcessType + ", mCameraImageFormat=" + this.mCameraImageFormat + ", mCameraImageSizeProcessType=" + this.mCameraImageSizeProcessType + ", mCameraImageSizeImageWidth=" + this.mCameraImageSizeImageWidth + ", mCameraImageSizeImageHeight=" + this.mCameraImageSizeImageHeight + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mCameraImageProcessType);
        dest.writeInt(this.mCameraImageFormat);
        dest.writeInt(this.mCameraImageSizeProcessType);
        dest.writeInt(this.mCameraImageSizeImageWidth);
        dest.writeInt(this.mCameraImageSizeImageHeight);
    }
}

