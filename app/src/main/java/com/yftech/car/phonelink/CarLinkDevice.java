package com.yftech.car.phonelink;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class CarLinkDevice implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CarLinkDevice createFromParcel(Parcel in) {
            CarLinkDevice link = new CarLinkDevice();
            link.phoneType = in.readString();
            link.deviceName = in.readString();
            link.deviceId = in.readString();
            link.connectedStatus = in.readInt();
            link.connectedType = in.readInt();
            link.macAddress = in.readString();
            link.status = in.readInt();
            return link;
        }

        public CarLinkDevice[] newArray(int size) {
            return new CarLinkDevice[size];
        }
    };
    public static final int STATUS_CONNECTED_CONNECTED = 1;
    public static final int STATUS_CONNECTED_DISCONNECTED = 0;
    public static final int STATUS_DEVICE_DISABLE = 0;
    public static final int STATUS_DEVICE_ENABLE = 1;
    public static final int TYPE_CONNECTED_UNKNOW = 2;
    public static final int TYPE_CONNECTED_USB = 1;
    public static final int TYPE_CONNECTED_WIRELESS = 0;
    private int connectedStatus;
    private int connectedType;
    private String deviceId;
    private String deviceName;
    private String macAddress;
    private String phoneType;
    private int status;

    public CarLinkDevice() {
        this.status = 1;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static Parcelable.Creator getCREATOR() {
        return CarLinkDevice.CREATOR;
    }

    public int getConnectedStatus() {
        return this.connectedStatus;
    }

    public int getConnectedType() {
        return this.connectedType;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public String getPhoneType() {
        return this.phoneType;
    }

    public int getStatus() {
        return this.status;
    }

    public void setConnectedStatus(int connectedStatus) {
        this.connectedStatus = connectedStatus;
    }

    public void setConnectedType(int connectedType) {
        this.connectedType = connectedType;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CarLinkDevice{phoneType=\'" + this.phoneType + '\'' + ", deviceName=\'" + this.deviceName + '\'' + ", deviceId=\'" + this.deviceId + '\'' + ", connectedStatus=" + this.connectedStatus + ", connectedType=" + this.connectedType + ", macAddress=\'" + this.macAddress + '\'' + ", status=" + this.status + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.phoneType);
        dest.writeString(this.deviceName);
        dest.writeString(this.deviceId);
        dest.writeInt(this.connectedStatus);
        dest.writeInt(this.connectedType);
        dest.writeString(this.macAddress);
        dest.writeInt(this.status);
    }
}

