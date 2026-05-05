package com.yftech.settings.base;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public abstract class BaseManager {
    protected final String TAG;
    public static final int TIMEOUT = 3000;
    @SuppressLint({"HandlerLeak"})
    public Handler mHandler;

    public BaseManager() {
        this.TAG = this.getClass().getSimpleName();
        this.mHandler = new Handler() {
            @Override  // android.os.Handler
            public void handleMessage(Message message0) {
                super.handleMessage(message0);
                if(message0 != null && (message0.obj instanceof String)) {
                    Enum enum0 = BaseManager.this.buildFunction(((String)message0.obj));
                    BaseManager.this.refresh(enum0);
                    return;
                }
                BaseManager.this.refresh(null);
            }
        };
    }

    public boolean allowRefreshFunction(Enum enum0, Enum enum1) {
        return enum0 == null || enum0 == enum1;
    }

    public abstract Enum buildFunction(String arg1);

    public abstract void refresh(Enum arg1);

    public void startTimeout(Enum enum0) {
        this.stopTimeout(enum0);
        Log.i(this.TAG, "startTimeout >> " + enum0);
        Message message0 = Message.obtain();
        message0.what = enum0.ordinal();
        message0.obj = enum0.name();
        this.mHandler.sendMessageDelayed(message0, 3000L);
    }

    public boolean stopTimeout(Enum enum0) {
        if(enum0 != null) {
            this.mHandler.removeMessages(enum0.ordinal());
            return true;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        return true;
    }
}

