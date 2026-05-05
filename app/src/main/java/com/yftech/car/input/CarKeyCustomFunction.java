package com.yftech.car.input;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class CarKeyCustomFunction implements Parcelable {
    public static final int ACTION_DOWN = 0;
    public static final int ACTION_LONG_CLICK = 2;
    public static final int ACTION_UP = 1;
    public static final int ADAS = 11;
    public static final int AIR_CONDITION_AUTO_MODE = 1;
    public static final int AVM = 10;
    public static final int BACK = 4;
    public static final Parcelable.Creator CREATOR  = new Parcelable.Creator() {
        public CarKeyCustomFunction createFromParcel(Parcel in) {
            return new CarKeyCustomFunction(in);
        }

        public CarKeyCustomFunction[] newArray(int size) {
            return new CarKeyCustomFunction[size];
        }
    };
    public static final int CUSTOM_KEY_SET = 24;
    public static final int EFFICIENCY = 29;
    public static final int FRAGRANCE = 8;
    public static final int FRONT_BROADCAST = 21;
    public static final int HOME = 3;
    public static final int HUD = 25;
    public static final int ILLEGAL_PHOTOGRAPH = 16;
    public static final int INVALID = -1;
    public static final int MUSIC = 20;
    public static final int MUTE = 14;
    public static final int NAVI = 9;
    public static final int NAVI_COMPANY = 23;
    public static final int NAVI_HOME = 22;
    public static final int PARK_IMAGE = 12;
    public static final int PHONE = 7;
    public static final int PLAY_FAVORITE_RADIO = 2;
    public static final int PLAY_PAUSE = 0;
    public static final int RACE = 27;
    public static final int SCREEN = 19;
    public static final int SMART_PARK_IMAGE = 13;
    public static final int SOURCE = 6;
    public static final int SPORT = 18;
    public static final int STEERING_WHEEL_HEAT = 26;
    public static final int STOPWATCH = 28;
    public static final int UNLOCK_TRUNK = 15;
    public static final int VIDEO_RECORD = 17;
    public static final int WECHAT = 5;
    public int action;
    public int code;
    public int longCode;

    public CarKeyCustomFunction() {
    }

    public CarKeyCustomFunction(int code, int action) {
        this.code = code;
        this.action = action;
        this.longCode = -1;
    }

    public CarKeyCustomFunction(int code, int longCode, int action) {
        this.code = code;
        this.longCode = longCode;
        this.action = action;
    }

    protected CarKeyCustomFunction(Parcel in) {
        this.code = in.readInt();
        this.action = in.readInt();
        this.longCode = in.readInt();
    }

    public CarKeyCustomFunction(CarKeyCustomFunction function) {
        this(function.code, function.longCode, function.action);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAction() {
        return this.action;
    }

    public int getCode() {
        return this.code;
    }

    public int getLongCode() {
        return this.longCode;
    }

    public void reset(CarKeyCustomFunction function) {
        if(function == null) {
            this.code = -1;
            this.longCode = -1;
            this.action = 0;
            return;
        }
        this.code = function.code;
        this.longCode = function.longCode;
        this.action = function.action;
    }

    @Override
    public String toString() {
        return "CarKeyCustomFunction{code=" + this.code + "longCode=" + this.longCode + ", action=" + this.action + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeInt(this.action);
        dest.writeInt(this.longCode);
    }
}

