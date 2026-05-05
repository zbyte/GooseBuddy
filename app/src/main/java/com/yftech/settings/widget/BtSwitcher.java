package com.yftech.settings.widget;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class BtSwitcher extends Switcher {
    private static final String TAG = "BtSwitcher";
    private boolean isInterceptEvent;
    private long mLastTimeClick;
    private long mSpaceTimeClick;

    public BtSwitcher(Context context0) {
        super(context0);
        this.isInterceptEvent = false;
        this.mLastTimeClick = 0L;
        this.mSpaceTimeClick = 1500L;
    }

    public BtSwitcher(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.isInterceptEvent = false;
        this.mLastTimeClick = 0L;
        this.mSpaceTimeClick = 1500L;
    }

    public BtSwitcher(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.isInterceptEvent = false;
        this.mLastTimeClick = 0L;
        this.mSpaceTimeClick = 1500L;
    }

    public BtSwitcher(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.isInterceptEvent = false;
        this.mLastTimeClick = 0L;
        this.mSpaceTimeClick = 1500L;
    }

    @Override  // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        Log.d("BtSwitcher", "dispatchTouchEvent: " + motionEvent0);
        long v = SystemClock.elapsedRealtime();
        long v1 = Math.abs(v - this.mLastTimeClick);
        switch(motionEvent0.getAction()) {
            case 0: {
                Log.d("BtSwitcher", "dispatchTouchEvent spaceTime:" + v1);
                if(v1 < this.mSpaceTimeClick) {
                    Log.d("BtSwitcher", "dispatchTouchEvent quickly");
                    this.isInterceptEvent = true;
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent0);
            }
            case 2: {
                return this.isInterceptEvent ? true : super.dispatchTouchEvent(motionEvent0);
            }
            case 1: 
            case 3: {
                if(this.isInterceptEvent) {
                    this.isInterceptEvent = false;
                    return true;
                }
                this.isInterceptEvent = false;
                this.mLastTimeClick = v;
                return super.dispatchTouchEvent(motionEvent0);
            }
            default: {
                return super.dispatchTouchEvent(motionEvent0);
            }
        }
    }
}

