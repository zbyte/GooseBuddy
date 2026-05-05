package com.yftech.settings.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;

public class SwitchCompatButton extends SwitchCompat implements CompoundButton.OnCheckedChangeListener {
    public interface OnSwitchCompatChangeFromUserListener {
        void onCheckedChanged(boolean arg1);
    }

    boolean isTouched;
    private OnSwitchCompatChangeFromUserListener onSwitchCompatChangeListener;

    public SwitchCompatButton(@NonNull Context context0) {
        super(context0);
        this.isTouched = false;
        this.init();
    }

    public SwitchCompatButton(@NonNull Context context0, @Nullable AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.isTouched = false;
        this.init();
    }

    public void init() {
        this.setOnCheckedChangeListener(this);
    }

    @Override  // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(@NonNull CompoundButton compoundButton0, boolean z) {
        if(this.isTouched) {
            Log.i(this.getClass().getSimpleName(), this.getTag() + " >>>  click onCheckedChanged : " + z);
            this.isTouched = false;
            if(this.onSwitchCompatChangeListener != null) {
                this.onSwitchCompatChangeListener.onCheckedChanged(z);
            }
        }
    }

    @Override  // androidx.appcompat.widget.SwitchCompat
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        this.isTouched = true;
        return super.onTouchEvent(motionEvent0);
    }

    public void setOnSwitchCompatChangeFromUserListener(OnSwitchCompatChangeFromUserListener switchCompatButton$OnSwitchCompatChangeFromUserListener0) {
        this.onSwitchCompatChangeListener = switchCompatButton$OnSwitchCompatChangeFromUserListener0;
    }
}

