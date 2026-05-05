package com.yftech.vehicle.internal;

public abstract class BaseApiManager {
    public byte[] getSignalDataValue(int signalId) {
        synchronized(this) {
            return CarManager.get().getSignalDataValue(signalId);
        }
    }

    public Number getSignalValue(int signalId) {
        synchronized(this) {
            return CarManager.get().getSignalValue(signalId);
        }
    }

    public Number[] getSignalsValue(int[] signalsId) {
        synchronized(this) {
            return CarManager.get().getSignalsValue(signalsId);
        }
    }

    public void registerReceiver(Object receiver) {
        synchronized(this) {
            CarManager.get().registerReceiver(receiver);
        }
    }

    public boolean setSignalValue(int signalId, byte value) {
        synchronized(this) {
            return CarManager.get().setSignalValue(signalId, value);
        }
    }

    public boolean setSignalValue(int signalId, double value) {
        synchronized(this) {
            return CarManager.get().setSignalValue(signalId, value);
        }
    }

    public boolean setSignalValue(int signalId, float value) {
        synchronized(this) {
            return CarManager.get().setSignalValue(signalId, value);
        }
    }

    public boolean setSignalValue(int signalId, int value) {
        synchronized(this) {
            return CarManager.get().setSignalValue(signalId, value);
        }
    }

    public boolean setSignalValue(int signalId, long value) {
        synchronized(this) {
            return CarManager.get().setSignalValue(signalId, value);
        }
    }

    public boolean setSignalValue(int signalId, short value) {
        synchronized(this) {
            return CarManager.get().setSignalValue(signalId, value);
        }
    }

    public boolean setSignalValue(int signalId, boolean value) {
        synchronized(this) {
            return CarManager.get().setSignalValue(signalId, value);
        }
    }

    public boolean setSignalValue(int signalId, byte[] value) {
        synchronized(this) {
            return CarManager.get().setSignalValue(signalId, value);
        }
    }

    public void unregisterReceiver(Object receiver) {
        synchronized(this) {
            CarManager.get().unregisterReceiver(receiver);
        }
    }
}

