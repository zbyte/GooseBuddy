package com.yftech.settings.base;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public abstract class BaseHandler extends Handler {
    private WeakReference weakReference;

    public BaseHandler(Object object0) {
        this.weakReference = new WeakReference(object0);
    }

    @Override  // android.os.Handler
    public void handleMessage(Message message0) {
        super.handleMessage(message0);
        Object object0 = this.weakReference.get();
        if(object0 == null) {
            return;
        }
        this.handleMessageProcess(message0, object0);
    }

    public abstract void handleMessageProcess(Message arg1, Object arg2);
}

