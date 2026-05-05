package com.yftech.settings.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class PriorityCommonDialog extends CommonDialog {
    public PriorityCommonDialog(Context context0) {
        super(context0);
    }

    @Override  // com.yftech.settings.widget.dialog.CommonDialog
    protected void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        Window window0 = this.getWindow();
        if(window0 != null) {
            window0.setType(0x807);
            WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
            windowManager$LayoutParams0.flags = LayoutParams.FLAG_NOT_FOCUSABLE;
            window0.setAttributes(windowManager$LayoutParams0);
        }
    }
}

