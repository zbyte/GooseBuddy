package com.yftech.car.upgrade;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.Arrays;

public class CarUpgradeInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CarUpgradeInfo createFromParcel(Parcel in) {
            return new CarUpgradeInfo(in);
        }

        public CarUpgradeInfo[] newArray(int size) {
            return new CarUpgradeInfo[size];
        }
    };
    private final int mModule;
    private final String[] mPath;
    private int mProgress;
    private int mState;

    public CarUpgradeInfo(int module, String[] path) {
        this.mModule = module;
        if(path != null) {
            this.mPath = new String[path.length];
            System.arraycopy(path, 0, this.mPath, 0, path.length);
            return;
        }
        this.mPath = null;
    }

    protected CarUpgradeInfo(Parcel in) {
        this.mModule = in.readInt();
        this.mState = in.readInt();
        this.mProgress = in.readInt();
        int v = in.readInt();
        if(v > 0) {
            this.mPath = new String[v];
            in.readStringArray(this.mPath);
            return;
        }
        this.mPath = null;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getModule() {
        return this.mModule;
    }

    public String[] getPath() {
        return this.mPath;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getState() {
        return this.mState;
    }

    public void setProgress(int progress) {
        this.mProgress = progress;
    }

    public void setState(int state) {
        this.mState = state;
    }

    @Override
    public String toString() {
        return "UpgradeInfo{module=" + this.mModule + ", state=" + this.mState + ", progress=" + this.mProgress + ", path=" + Arrays.toString(this.mPath) + "}";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mModule);
        dest.writeInt(this.mState);
        dest.writeInt(this.mProgress);
        if(this.mPath == null) {
            dest.writeInt(0);
            return;
        }
        dest.writeInt(this.mPath.length);
        dest.writeStringArray(this.mPath);
    }
}

