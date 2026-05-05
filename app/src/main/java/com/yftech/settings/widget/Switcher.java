package com.yftech.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Switch;
import java.lang.reflect.Field;

public class Switcher extends Switch {
    public Switcher(Context context0) {
        super(context0);
    }

    public Switcher(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public Switcher(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    public Switcher(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
    }

    @Override  // android.widget.Switch
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        boolean z = super.onTouchEvent(motionEvent0);
        switch(motionEvent0.getAction()) {
            case 1: 
            case 3: {
                try {
                    Field field0 = Switch.class.getDeclaredField("mThumbPosition");
                    field0.setAccessible(true);
                    if((field0.getFloat(this) < 0.5f)) {
                        this.setChecked(false);
                        return z;
                    }
                    this.setChecked(true);
                }
                catch(NoSuchFieldException noSuchFieldException0) {
                    noSuchFieldException0.printStackTrace();
                }
                catch(IllegalAccessException illegalAccessException0) {
                    illegalAccessException0.printStackTrace();
                }
                return z;
            }
            default: {
                return z;
            }
        }
    }
}

