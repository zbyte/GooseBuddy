package com.yftech.car.dms;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class DmsCode implements Parcelable {
    public static final int CODE_ALARM_CALL = 1;
    public static final int CODE_ALARM_DISTRACT = 5;
    public static final int CODE_ALARM_DRIVER_ABNORMAL = 7;
    public static final int CODE_ALARM_DROWSY = 3;
    public static final int CODE_ALARM_IR_BLOCKING = 9;
    public static final int CODE_ALARM_LENS_COVERED = 10;
    public static final int CODE_ALARM_NONE = 0;
    public static final int CODE_ALARM_SMOKE = 2;
    public static final int CODE_DROWSY_CLOSEEYE = 1;
    public static final int CODE_DROWSY_NONE = 0;
    public static final int CODE_DROWSY_YAWN = 2;
    public static final int CODE_ERROR_EXPIRED = -2;
    public static final int CODE_ERROR_FAILED = -1;
    public static final int CODE_ERROR_FR_BAD_FACE = 0xFFFFF80F;
    public static final int CODE_ERROR_FR_CANCELLED = 0xFFFFF807;
    public static final int CODE_ERROR_FR_EYES_CLOSED = -2007;
    public static final int CODE_ERROR_FR_LARGE_ANGLE_FACE = -2006;
    public static final int CODE_ERROR_FR_LIGHT_DARK = -2005;
    public static final int CODE_ERROR_FR_LOW_QUALITY_FACE = -2014;
    public static final int CODE_ERROR_FR_NOT_ALIVE = -2010;
    public static final int CODE_ERROR_FR_NO_FACE = -2002;
    public static final int CODE_ERROR_FR_NO_REGISTER_FACE = -2008;
    public static final int CODE_ERROR_FR_PART_FACE = -2009;
    public static final int CODE_ERROR_FR_REACH_MAX_REGISTER_FACE = -2001;
    public static final int CODE_ERROR_FR_SHELTER_FACE = -2003;
    public static final int CODE_ERROR_FR_TOO_BRIGHT_FACE = -2013;
    public static final int CODE_ERROR_NOT_ACTIVE = -4;
    public static final int CODE_ERROR_OK = 0;
    public static final int CODE_ERROR_STILLIMAGE_SIZE_NOT_SUPPORT = 0xFFFFF810;
    public static final int CODE_ERROR_VIDEOFRAME_IGNORED = -3;
    public static final int CODE_IMAGE_FORMAT_NV12 = 1;
    public static final int CODE_IMAGE_FORMAT_NV21 = 2;
    public static final int CODE_PROCESS_TYPE_DMS = 0;
    public static final int CODE_PROCESS_TYPE_FR = 30;
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public DmsCode createFromParcel(Parcel in) {
            return new DmsCode();
        }

        public DmsCode[] newArray(int size) {
            return new DmsCode[size];
        }
    };
    public static final int LEVEL_HIGH = 3;
    public static final int LEVEL_LOW = 1;
    public static final int LEVEL_MEDIUM = 2;
    public static final int LEVEL_NONE = 0;

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static Parcelable.Creator getCREATOR() {
        return DmsCode.CREATOR;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
    }
}

