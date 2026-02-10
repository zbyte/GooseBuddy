package com.yftech.car.applet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class AppletInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public AppletInfo createFromParcel(Parcel in) {
            return new AppletInfo(in);
        }

        public AppletInfo[] newArray(int size) {
            return new AppletInfo[size];
        }
    };

    public String appId;
    public String cnName;
    public int id;
    public String logoUrl;
    public String mossUrl;
    public String pagePath;
    public String pkgName;
    public String platformType;
    public String version;

    public AppletInfo() {
    }

    protected AppletInfo(Parcel in) {
        this.platformType = in.readString();
        this.id = in.readInt();
        this.appId = in.readString();
        this.pkgName = in.readString();
        this.cnName = in.readString();
        this.mossUrl = in.readString();
        this.logoUrl = in.readString();
        this.version = in.readString();
        this.pagePath = in.readString();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "AppletInfo{platformType= " + this.platformType + '\'' + ", id=" + this.id + ", appId=\'" + this.appId + '\'' + ", pkgName=\'" + this.pkgName + '\'' + ", cnName=\'" + this.cnName + '\'' + ", mossUrl=\'" + this.mossUrl + '\'' + ", logoUrl=\'" + this.logoUrl + '\'' + ", version=\'" + this.version + '\'' + '\'' + ", pagePath=\'" + this.pagePath + '\'' + ", lastUsedTime=\'" + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.platformType);
        parcel.writeInt(this.id);
        parcel.writeString(this.appId);
        parcel.writeString(this.pkgName);
        parcel.writeString(this.cnName);
        parcel.writeString(this.mossUrl);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.version);
        parcel.writeString(this.pagePath);
    }
}

