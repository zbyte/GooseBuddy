package com.yftech.car.phonelink;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.ArrayList;

public class PhoneLink implements Parcelable {
    public static final int CALL_STATUS_ACTIVE = 3;
    public static final int CALL_STATUS_CALLING = 2;
    public static final int CALL_STATUS_IDEL = 0;
    public static final int CALL_STATUS_RINGING = 1;
    public static final int CARPLAY_MEDIA_NEXT_TRACK = 4;
    public static final int CARPLAY_MEDIA_NONE = 0;
    public static final int CARPLAY_MEDIA_PALYPAUSE = 3;
    public static final int CARPLAY_MEDIA_PAUSE = 2;
    public static final int CARPLAY_MEDIA_PLAY = 1;
    public static final int CARPLAY_MEDIA_PRE_TRACK = 5;
    public static final int CARPLAY_SIRI_ACTION_BUTTON_DOWN = 2;
    public static final int CARPLAY_SIRI_ACTION_BUTTON_UP = 3;
    public static final int CARPLAY_SIRI_ACTION_NOT_APPLICABLE = 0;
    public static final int CARPLAY_SIRI_ACTION_PREWARE = 1;
    public static final int CARPLAY_TELEPHONY_DELETE = 17;
    public static final int CARPLAY_TELEPHONY_DROP = 3;
    public static final int CARPLAY_TELEPHONY_FALSH = 2;
    public static final int CARPLAY_TELEPHONY_HOOK_SWITCH = 1;
    public static final int CARPLAY_TELEPHONY_MUTE = 4;
    public static final int CARPLAY_TELEPHONY_PHONY_KEY_0 = 5;
    public static final int CARPLAY_TELEPHONY_PHONY_KEY_1 = 6;
    public static final int CARPLAY_TELEPHONY_PHONY_KEY_2 = 7;
    public static final int CARPLAY_TELEPHONY_PHONY_KEY_3 = 8;
    public static final int CARPLAY_TELEPHONY_PHONY_KEY_4 = 9;
    public static final int CARPLAY_TELEPHONY_PHONY_KEY_5 = 10;
    public static final int CARPLAY_TELEPHONY_PHONY_KEY_6 = 11;
    public static final int CARPLAY_TELEPHONY_PHONY_KEY_7 = 12;
    public static final int CARPLAY_TELEPHONY_PHONY_KEY_8 = 13;
    public static final int CARPLAY_TELEPHONY_PHONY_KEY_9 = 14;
    public static final int CARPLAY_TELEPHONY_PHONY_KEY_POUND = 16;
    public static final int CARPLAY_TELEPHONY_PHONY_KEY_STAR = 15;
    public static final int CARPLAY_TELEPHONY_UP = 0;
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public PhoneLink createFromParcel(Parcel in) {
            PhoneLink link = new PhoneLink();
            link.type = in.readInt();
            link.supportList = in.readArrayList(String.class.getClassLoader());
            return link;
        }

        public PhoneLink[] newArray(int size) {
            return new PhoneLink[size];
        }
    };
    public static final int FAIL_CONNECTED_CARPLAY_DISABLE = 10000;
    public static final int FAIL_CONNECTED_CARPLAY_NOSUPPORT = 1;
    public static final int FAIL_CONNECTED_UNKNOW = 0;
    public static final int PAGE_TYPE_CONTACT = 3;
    public static final int PAGE_TYPE_HIDE = 4;
    public static final int PAGE_TYPE_LAUNCHER = 0;
    public static final int PAGE_TYPE_MAP = 1;
    public static final int PAGE_TYPE_MUSIC = 2;
    public static final int PAGE_TYPE_TEL = 5;
    public static final String PHONE_LINK_ANDROID_AUTO = "androidauto";
    public static final String PHONE_LINK_CARLIFE = "carlife";
    public static final String PHONE_LINK_CARLINK = "carlink";
    public static final String PHONE_LINK_CARPLAY = "carplay";
    public static final String PHONE_LINK_EASYCONN = "easyconn";
    public static final String PHONE_LINK_HICAR = "hicar";
    public static final String PHONE_LINK_NONE = "none";
    public static final int PHONE_TYPE_ANDROID = 0;
    public static final int PHONE_TYPE_HUAWEI = 2;
    public static final int PHONE_TYPE_INVALID = -1;
    public static final int PHONE_TYPE_IPHONE = 1;
    public static final int VR_STATUS_ACTIVE = 1;
    public static final int VR_STATUS_IDEL = 0;
    private ArrayList supportList;
    private int type;

    public PhoneLink() {
    }

    public PhoneLink(int type, ArrayList arrayList0) {
        this.type = type;
        this.supportList = arrayList0;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static Parcelable.Creator getCREATOR() {
        return PhoneLink.CREATOR;
    }

    public ArrayList getSupportList() {
        return this.supportList;
    }

    public int getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "PhoneLink{type=" + this.type + ", supportList=" + this.supportList + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.type);
        dest.writeList(this.supportList);
    }
}

