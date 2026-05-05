package ru.gs8club.goosebuddy;

import android.content.Context;
import android.media.AudioManager;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;

import com.yftech.vehicle.sdk.CarMiscManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

public class Utils {
    private static final int MIN_CLICK_DELAY_TIME = 500;
    private static final int MIN_CLICK_DELAY_TIME1 = 400;
    private static final int MIN_CLICK_DELAY_TIME_TAB = 100;
    private static final int PR0GRESS_MIN_DELAY_TIME = 100;
    private static final String TAG = "Utils";
    private static long lastClickTime;
    private static long lastClickTime1;
    private static long lastTabClickTime;
    private static boolean mIsShowSteeringWheelButtonView;
    private static boolean mIsSteeringWheelButtonPhoneNumberSettingView;
    private static long mLastSetDateTime;

    static {
    }

    public static int dip2px(Context context0, float f) {
        return (int)(f * context0.getResources().getDisplayMetrics().density + 0.5f);
    }

    public static int dp2px(Context context0, float f) {
        return (int)(f * context0.getResources().getDisplayMetrics().density + 0.5f);
    }

    public static long getAvailableSpace(File file0) {
        try {
            StatFs statFs0 = new StatFs(file0.getPath());
            long v = (long)statFs0.getBlockSize();
            return statFs0.getAvailableBlocksLong() * v;
        }
        catch(Exception unused_ex) {
            return -1L;
        }
    }

    public static long getTotalSpace(File file0) {
        try {
            StatFs statFs0 = new StatFs(file0.getPath());
            long v = (long)statFs0.getBlockSize();
            return ((long)statFs0.getBlockCount()) * v;
        }
        catch(Exception unused_ex) {
            return -1L;
        }
    }


    public static boolean isQuickClick() {
        synchronized(Utils.class) {
            long v1 = SystemClock.elapsedRealtime();
            if(Math.abs(v1 - Utils.lastClickTime) < 500L) {
                return true;
            }
            Utils.lastClickTime = v1;
            return false;
        }
    }

    public static boolean isQuickClick1() {
        synchronized(Utils.class) {
            long v1 = SystemClock.elapsedRealtime();
            if(Math.abs(v1 - Utils.lastClickTime1) < 400L) {
                return true;
            }
            Utils.lastClickTime1 = v1;
            return false;
        }
    }

    // String Decryptor: 1 succeeded, 0 failed
    public static boolean isShowSteeringWheelButtonView() {
        return Utils.mIsShowSteeringWheelButtonView;
    }

    // String Decryptor: 1 succeeded, 0 failed
    public static boolean isSteeringWheelButtonPhoneNumberSettingView() {
        return Utils.mIsSteeringWheelButtonPhoneNumberSettingView;
    }

    public static boolean isTabQuickClick() {
        synchronized(Utils.class) {
            long v1 = SystemClock.elapsedRealtime();
            if(Math.abs(v1 - Utils.lastTabClickTime) < 100L) {
                return true;
            }
            Utils.lastTabClickTime = v1;
            return false;
        }
    }

    public static void playKeySoundEffect(Context context0) {
        if(Settings.System.getInt(context0.getContentResolver(), "sound_effects_enabled", 0) == 1) {
            ((AudioManager)context0.getSystemService(Context.AUDIO_SERVICE)).playSoundEffect(AudioManager.FX_KEY_CLICK);
        }
    }

    public static boolean progressChangedEnable(long v) {
        return Math.abs(SystemClock.elapsedRealtime() - v) > 100L;
    }

    public static int px2dp(Context context0, float f) {
        return (int)(f / context0.getResources().getDisplayMetrics().density + 0.5f);
    }

    public static void setDateTime(Context context0, int v, int v1, int v2, int v3, int v4, int v5, int v6, boolean z) {
        Calendar calendar0 = Calendar.getInstance();
        calendar0.set(1, v);
        calendar0.set(2, v1 - 1);
        calendar0.set(5, v2);
        boolean z1 = DateFormat.is24HourFormat(context0.getApplicationContext());
        int v7 = v3 < 12 ? v3 : v3 - 12;
        if(z1) {
            calendar0.set(11, v3);
        }
        else {
            calendar0.set(9, v6);
            calendar0.set(10, v7);
        }
        calendar0.set(12, v4);
        calendar0.set(13, v5);
        long v8 = calendar0.getTime().getTime();
        Log.i("Utils", "setDateTime() " + v + "-" + v1 + "-" + v2 + " " + v3 + ":" + v4 + ":" + v5 + " is24HourFormat:" + z1 + " ampm:" + v6 + " hour(12):" + v7 + " isDirectSet:" + z + " curSetDateTime:" + v8 + " lastSetDateTime:" + Utils.mLastSetDateTime);
        if(!z && Math.abs(v8 - Utils.mLastSetDateTime) < 3000L) {
            Log.i("Utils", "setDateTime() Time interval < 3000ms, no set.");
            return;
        }
        boolean z2 = CarMiscManager.get().setSystemTime(calendar0, z1);
        if(z2) {
            Utils.mLastSetDateTime = v8;
        }
        Log.i("Utils", "setDateTime() result:" + z2);
    }

    public static void setShowSteeringWheelButtonView(boolean z) {
        Log.i("Utils", "setShowSteeringWheelButtonView() isShowSteeringWheelButtonView:" + z);
        Utils.mIsShowSteeringWheelButtonView = z;
    }

    public static void setSteeringWheelButtonPhoneNumberSettingView(boolean z) {
        Log.i("Utils", "setSteeringWheelButtonPhoneNumberSettingView() isSteeringWheelButtonPhoneNumberSettingView:" + z);
        Utils.mIsSteeringWheelButtonPhoneNumberSettingView = z;
    }

    public static int sp2px(Context context0, float f) {
        return (int)(f * context0.getResources().getDisplayMetrics().scaledDensity + 0.5f);
    }

    public static String subStr(String s, int v, String s1) throws UnsupportedEncodingException {
        if(TextUtils.isEmpty(s)) {
            return "";
        }
        String s2 = s.substring(0, s.length());
        int v1 = s2.getBytes("UTF-8").length;
        boolean z = v1 > v;
        String s3 = s2;
        int v2 = v;
        while(v1 > v) {
            --v2;
            s3 = s.substring(0, (v2 <= s.length() ? v2 : s.length()));
            v1 = s3.getBytes("UTF-8").length;
        }
        return z ? s3 + s1 : s3;
    }
}

