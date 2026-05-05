package com.android.car.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;

public class CarPermission {
    private final Context mContext;
    private final String mName;

    public CarPermission(Context context, String name) {
        this.mContext = context;
        this.mName = name;
    }

    public void assertGranted() {
        if(!this.checkGranted()) {
            throw new SecurityException("client does not have permission:" + this.mName + " pid:" + Binder.getCallingPid() + " uid:" + Binder.getCallingUid());
        }
    }

    public boolean checkGranted() {
        return this.mName == null || Binder.getCallingUid() == Process.myUid() || this.mContext.checkCallingOrSelfPermission(this.mName) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public String toString() {
        return this.mName;
    }
}

