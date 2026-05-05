package com.yftech.car.utils;

import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.Method;

public class BinderUtils {
    public static IBinder getServiceBinder(String serviceName) {
        try {
            Class<?> serviceManagerClass = Class.forName("android.os.ServiceManager");
            Method getServiceMethod = serviceManagerClass.getMethod("getService", String.class);
            return (IBinder) getServiceMethod.invoke(null, serviceName);
        } catch (Exception e) {
            Log.e("ServiceHelper", "Failed to get service " + serviceName + ": " + e.getMessage());
            return null;
        }
    }

    public static IBinder getAliveServiceBinder(String serviceName) {
        IBinder binder = getServiceBinder(serviceName);
        if (binder != null && !binder.isBinderAlive()) {
            Log.w("ServiceHelper", "Service " + serviceName + " binder is dead");
            return null;
        }
        return binder;
    }
}