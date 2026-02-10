package com.yftech.vehicle.internal;

public abstract class BaseApiManager {
    public byte[] getSignalDataValue(int v) {
        synchronized(this) {
            return CarManager.get().getSignalDataValue(v);
        }
    }

    public Number getSignalValue(int v) {
        synchronized(this) {
            return CarManager.get().getSignalValue(v);
        }
    }

    public Number[] getSignalsValue(int[] arr_v) {
        synchronized(this) {
            return CarManager.get().getSignalsValue(arr_v);
        }
    }

    public void registerReceiver(Object object0) {
        synchronized(this) {
            CarManager.get().registerReceiver(object0);
        }
    }

    public boolean setSignalValue(int v, byte b) {
        synchronized(this) {
            return CarManager.get().setSignalValue(v, b);
        }
    }

    public boolean setSignalValue(int v, double f) {
        synchronized(this) {
            return CarManager.get().setSignalValue(v, f);
        }
    }

    public boolean setSignalValue(int v, float f) {
        synchronized(this) {
            return CarManager.get().setSignalValue(v, f);
        }
    }

    public boolean setSignalValue(int v, int v1) {
        synchronized(this) {
            return CarManager.get().setSignalValue(v, v1);
        }
    }

    public boolean setSignalValue(int v, long v1) {
        synchronized(this) {
            return CarManager.get().setSignalValue(v, v1);
        }
    }

    public boolean setSignalValue(int v, short v1) {
        synchronized(this) {
            return CarManager.get().setSignalValue(v, v1);
        }
    }

    public boolean setSignalValue(int v, boolean z) {
        synchronized(this) {
            return CarManager.get().setSignalValue(v, z);
        }
    }

    public boolean setSignalValue(int v, byte[] arr_b) {
        synchronized(this) {
            return CarManager.get().setSignalValue(v, arr_b);
        }
    }

    public void unregisterReceiver(Object object0) {
        synchronized(this) {
            CarManager.get().unregisterReceiver(object0);
        }
    }
}

