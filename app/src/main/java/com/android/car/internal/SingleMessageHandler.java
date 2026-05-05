package com.android.car.internal;

import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;
import java.util.function.Consumer;

public abstract class SingleMessageHandler<T> implements Handler.Callback {
    private final int mHandledMessageWhat;
    private final Handler mHandler;

    public SingleMessageHandler(Handler handler, int handledMessage) {
        this(handler.getLooper(), handledMessage);
    }

    public SingleMessageHandler(Looper looper, int handledMessage) {
        this.mHandledMessageWhat = handledMessage;
        this.mHandler = new Handler(looper, this);
    }

    // Detected as a lambda impl.
    protected abstract void handleEvent(T arg1);

    @Override  // android.os.Handler$Callback
    public boolean handleMessage(Message msg) {
        if(msg.what == this.mHandledMessageWhat) {
            List<T> list = (List<T>) msg.obj;

            list.forEach(this::handleEvent);
        }
        return true;
    }

    public void sendEvents(List<T> list0) {
        Message message0 = this.mHandler.obtainMessage(this.mHandledMessageWhat, list0);
        this.mHandler.sendMessage(message0);
    }
}

