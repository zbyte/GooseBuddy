package com.yftech.car.ota;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class ScheduleField implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ScheduleField createFromParcel(Parcel in) {
            ScheduleField field = new ScheduleField();
            field.time = in.readLong();
            field.type = in.readInt();
            field.track = in.readString();
            field.extra = in.readBundle();
            return field;
        }

        public ScheduleField[] newArray(int size) {
            return new ScheduleField[size];
        }
    };
    private Bundle extra;
    private long time;
    private String track;
    private int type;

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static Parcelable.Creator getCREATOR() {
        return ScheduleField.CREATOR;
    }

    public Bundle getExtra() {
        return this.extra;
    }

    public long getTime() {
        return this.time;
    }

    public String getTrack() {
        return this.track;
    }

    public int getType() {
        return this.type;
    }

    public void setExtra(Bundle extra) {
        this.extra = extra;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ScheduleField:[").append("time=").append(this.time).append(", type=").append(this.type).append(", track=").append(this.track).append(", extra={").append(this.extra.toString()).append("}]");
        return stringBuilder.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.time);
        parcel.writeInt(this.type);
        parcel.writeString(this.track);
        parcel.writeBundle(this.extra);
    }
}

