package com.yftech.car.input;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class CarKnob implements Parcelable {
    public static final Parcelable.Creator CREATOR = null;
    public static final int POSITION_BACKWARD = 1;
    public static final int POSITION_FORWARD = 0;
    public static final int TYPE_HMI = 2;
    public static final int TYPE_POWER = 7;
    public int position;
    public int type;
    public int value;

    static {
        CarKnob.CREATOR = new Parcelable.Creator() {
            public CarKnob createFromParcel(Parcel in) {
                return new CarKnob(in);
            }

            public CarKnob[] newArray(int size) {
                return new CarKnob[size];
            }
        };
    }

    public CarKnob() {
    }

    public CarKnob(int type, int position, int value) {
        this.type = type;
        this.position = position;
        this.value = value;
    }

    public CarKnob(Parcel in) {
        this.type = in.readInt();
        this.position = in.readInt();
        this.value = in.readInt();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPosition() {
        return this.position;
    }

    public int getType() {
        return this.type;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "CarKnob{position=" + this.position + ", type=" + this.type + ", value=" + this.value + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeInt(this.position);
        parcel.writeInt(this.value);
    }
}

