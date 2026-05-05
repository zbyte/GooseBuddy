package com.yftech.settings.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class LoadingDialog extends Dialog {
    private String text;

    public LoadingDialog(Context context0) {
        super(context0, 0x7F1002CF);  // style:dialog_normal
    }

    @Override  // android.app.Dialog
    protected void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.setContentView(0x7F0C0034);  // layout:dialog_loading
        Window window0 = this.getWindow();
        if(window0 != null) {
            WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
            windowManager$LayoutParams0.flags = LayoutParams.FLAG_NOT_FOCUSABLE;
            windowManager$LayoutParams0.width = -1;
            windowManager$LayoutParams0.height = -1;
            windowManager$LayoutParams0.type = 0x807;
            window0.setAttributes(windowManager$LayoutParams0);
        }
        ImageView imageView0 = (ImageView)this.findViewById(0x7F09017D);  // id:iv_recover_loading
        if(this.text != null) {
            ((TextView)this.findViewById(0x7F0900F4)).setText(this.text);  // id:content
        }
        RotateAnimation rotateAnimation0 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation0.setDuration(2000L);
        rotateAnimation0.setRepeatCount(-1);
        rotateAnimation0.setInterpolator(new LinearInterpolator());
        imageView0.startAnimation(rotateAnimation0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LoadingDialog.this.dismiss();
            }
        }, 500L);
    }

    public void setTextViewContent(String s) {
        this.text = s;
    }
}

