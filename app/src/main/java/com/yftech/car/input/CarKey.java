package com.yftech.car.input;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class CarKey implements Parcelable {
    public static final int ACTION_DOWN = 0;
    public static final int ACTION_LONG_CLICK = 2;
    public static final int ACTION_UP = 1;
    public static final int CODE_BACK = 13;
    public static final int CODE_BACK_MIRROR_DOWN = 34;
    public static final int CODE_BACK_MIRROR_LEFT = 35;
    public static final int CODE_BACK_MIRROR_RIGHT = 36;
    public static final int CODE_BACK_MIRROR_UP = 33;
    public static final int CODE_DASHBOARD_DOWN = 42;
    public static final int CODE_DASHBOARD_ENTER = 45;
    public static final int CODE_DASHBOARD_LEFT = 43;
    public static final int CODE_DASHBOARD_RIGHT = 44;
    public static final int CODE_DASHBOARD_UP = 41;
    public static final int CODE_DASHBOARD_VIEW = 40;
    public static final int CODE_DISP = 39;
    public static final int CODE_DOWN = 19;
    public static final int CODE_DOWN_LEFT = 24;
    public static final int CODE_DOWN_RIGHT = 25;
    public static final int CODE_ENTER = 0x20;
    public static final int CODE_EXIT_TRANSPORT_MODE = 38;
    public static final int CODE_LEFT = 20;
    public static final int CODE_MEDIA = 17;
    public static final int CODE_MENU = 12;
    public static final int CODE_MODE = 5;
    public static final int CODE_MUTE = 11;
    public static final int CODE_NAVI = 14;
    public static final int CODE_NULL = 0;
    public static final int CODE_OFF_HOOK = 7;
    public static final int CODE_ON_HOOK = 8;
    public static final int CODE_PHONE = 16;
    public static final int CODE_PLAY_PAUSE = 37;
    public static final int CODE_POWER = 9;
    public static final int CODE_RADIO = 15;
    public static final int CODE_RIGHT = 21;
    public static final int CODE_SEEK_DEC = 2;
    public static final int CODE_SEEK_INC = 1;
    public static final int CODE_SOUND_WAVE = 46;
    public static final int CODE_UP = 18;
    public static final int CODE_UP_LEFT = 22;
    public static final int CODE_UP_RIGHT = 23;
    public static final int CODE_VOL_DEC = 4;
    public static final int CODE_VOL_INC = 3;
    public static final int CODE_VR = 6;
    public static final int CODE_WECHAT = 10;
    public static final Parcelable.Creator CREATOR = null;
    public static final int FROM_SOURCE_KNOB = 2;
    public static final int FROM_SOURCE_PANEL = 3;
    public static final int FROM_SOURCE_REAR_LEFT_PANEL = 4;
    public static final int FROM_SOURCE_REAR_RIGHT_PANEL = 5;
    public static final int FROM_SOURCE_STEERING_WHEEL = 1;
    public static final int FROM_SOURCE_UNKNOWN;
    public int mAction;
    public int mCode;
    public int mFromSource;

    static {
        CarKey.CREATOR = new Parcelable.Creator() {
            public CarKey createFromParcel(Parcel in) {
                return new CarKey(in);
            }

            public CarKey[] newArray(int size) {
                return new CarKey[size];
            }
        };
    }

    public CarKey() {
        this.mFromSource = 0;
    }

    public CarKey(int code, int action) {
        this.mFromSource = 0;
        this.mCode = code;
        this.mAction = action;
    }

    public CarKey(int code, int action, int fromSource) {
        this.mFromSource = 0;
        this.mCode = code;
        this.mAction = action;
        this.mFromSource = fromSource;
    }

    protected CarKey(Parcel in) {
        this.mFromSource = 0;
        this.mCode = in.readInt();
        this.mAction = in.readInt();
        this.mFromSource = in.readInt();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAction() {
        return this.mAction;
    }

    public int getCode() {
        return this.mCode;
    }

    public int getFromSource() {
        return this.mFromSource;
    }

    @Override
    public String toString() {
        return "CarKey{code=" + this.mCode + ", action=" + this.mAction + ", fromSource=" + this.mFromSource + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mCode);
        dest.writeInt(this.mAction);
        dest.writeInt(this.mFromSource);
    }
}

