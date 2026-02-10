package com.yftech.car.utils;

import android.util.Log;

public class Loger {
    private static final boolean DEBUG = true;
    private static final String TAG = "CarFramework";
    private static boolean status;

    static {
        Loger.status = true;
    }

    public static void d(String msg) {
        if(Loger.status) {
            Loger.handleLog(3, msg, null);
        }
    }

    public static void d(String head, String msg) {
        Loger.handleLog(3, msg, head);
    }

    public static void e(String msg) {
        Loger.handleLog(6, msg, null);
    }

    public static void e(String head, String msg) {
        Loger.handleLog(6, msg, head);
    }

    private static void handleLog(int level, String msg, String head) {
        StackTraceElement[] arr_stackTraceElement = Thread.currentThread().getStackTrace();
        StackTraceElement tracke = arr_stackTraceElement == null || arr_stackTraceElement.length <= 4 ? null : arr_stackTraceElement[4];
        StringBuilder buffer = new StringBuilder(80);
        if(tracke != null) {
            buffer.append('[');
            buffer.append(tracke.getMethodName());
            String s2 = tracke.getFileName();
            if(s2 == null) {
                buffer.append("(Unknown Source)");
            }
            else {
                int v1 = tracke.getLineNumber();
                buffer.append('(');
                buffer.append(s2);
                if(v1 >= 0) {
                    buffer.append(':');
                    buffer.append(v1);
                }
                buffer.append(')');
            }
            buffer.append(']');
        }
        if(head != null) {
            buffer.append(head);
        }
        if(msg != null) {
            buffer.append(msg);
        }
        switch(level) {
            case 2: {
                Log.v("CarFramework", buffer.toString());
                return;
            }
            case 3: {
                Log.d("CarFramework", buffer.toString());
                return;
            }
            case 4: {
                Log.i("CarFramework", buffer.toString());
                return;
            }
            case 5: {
                Log.w("CarFramework", buffer.toString());
                return;
            }
            case 6: {
                Log.e("CarFramework", buffer.toString());
            }
        }
    }

    public static void i(String msg) {
        Loger.handleLog(4, msg, null);
    }

    public static void i(String head, String msg) {
        Loger.handleLog(4, msg, head);
    }

    public static void v(String msg) {
        Loger.handleLog(2, msg, null);
    }

    public static void v(String head, String msg) {
        Loger.handleLog(2, msg, head);
    }

    public static void w(String msg) {
        Loger.handleLog(5, msg, null);
    }

    public static void w(String head, String msg) {
        Loger.handleLog(5, msg, head);
    }
}

