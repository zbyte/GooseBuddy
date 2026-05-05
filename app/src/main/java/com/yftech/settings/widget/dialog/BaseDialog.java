package com.yftech.settings.widget.dialog;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;

public class BaseDialog extends Dialog {
    class CarplayShowUIReceiver extends BroadcastReceiver {
        private CarplayShowUIReceiver() {
        }

        CarplayShowUIReceiver(BaseDialog ptr) {
        }

        @Override  // android.content.BroadcastReceiver
        public void onReceive(Context context0, Intent intent0) {
            if("com.autochips.carplay.event.show_ui".equals(intent0.getAction())) {
                boolean z = intent0.getBooleanExtra("ui_show", true);
                Log.i("BaseDialog", "onReceive() ACTION_CARPLAY_EVENT_SHOW_UI isShow:" + z);
                if(z) {
                    BaseDialog.this.dismiss();
                }
            }
        }
    }

    private static final String ACTION_CARPLAY_EVENT_SHOW_UI = "com.autochips.carplay.event.show_ui";
    private static final String KEY_CARPLAY_EVENT_SHOW_UI = "ui_show";
    private static final String TAG = "BaseDialog";
    private CarplayShowUIReceiver mCarplayShowUIReceiver;
    private IntentFilter mIntentFilter;
    private Handler mMainHandler;

    public BaseDialog(@NonNull Context context0, int v) {
        super(context0, v);
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    @Override  // android.app.Dialog
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i("BaseDialog", "onAttachedToWindow()");
        this.getContext().registerReceiver(this.mCarplayShowUIReceiver, this.mIntentFilter);
    }

    @Override  // android.app.Dialog
    protected void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        Log.i("BaseDialog", "onCreate()");
        if(this.mIntentFilter == null) {
            this.mIntentFilter = new IntentFilter();
            this.mIntentFilter.addAction("com.autochips.carplay.event.show_ui");
        }
        if(this.mCarplayShowUIReceiver == null) {
            this.mCarplayShowUIReceiver = new CarplayShowUIReceiver(this);
        }
    }

    @Override  // android.app.Dialog
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("BaseDialog", "onDetachedFromWindow()");
        this.getContext().unregisterReceiver(this.mCarplayShowUIReceiver);
    }
}

