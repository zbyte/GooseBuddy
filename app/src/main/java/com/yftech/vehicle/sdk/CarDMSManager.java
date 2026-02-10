package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.CarDMS.DMSDistrWarn;
import com.yftech.vehicle.internal.adapter.CarDMS.DMSFatigWarn;
import com.yftech.vehicle.internal.adapter.CarDMS.DMSMode;
import com.yftech.vehicle.internal.adapter.CarDMS.DMSSwitch;
import com.yftech.vehicle.internal.adapter.CarDMS.DMSSysErrStatus;
import com.yftech.vehicle.internal.adapter.CarDMS;

public class CarDMSManager extends BaseApiManager implements CarDMS {
    public static abstract class CarDMSListener {
        @SignalReceiver(signalId = 616)
        public void onDMSDistrWarnChanged(CarDMS.DMSDistrWarn warn) {
        }

        @SignalReceiver(signalId = 615)
        public void onDMSFatigWarnChanged(CarDMS.DMSFatigWarn warn) {
        }

        @SignalReceiver(signalId = 614)
        public void onDMSModeChanged(CarDMS.DMSMode mode) {
        }

        @SignalReceiver(signalId = 612)
        public void onDMSSwitchChanged(CarDMS.DMSSwitch status) {
        }

        @SignalReceiver(signalId = 610)
        public void onDMSSysErrStatusChanged(CarDMS.DMSSysErrStatus status) {
        }
    }

    private static final String TAG = "CarDMSManager";
    private static CarDMSManager sMe;

    public static CarDMSManager get() {
        CarDMSManager carDMSManager0;
        synchronized(CarDMSManager.class) {
            if(CarDMSManager.sMe == null) {
                carDMSManager0 = new CarDMSManager();
                CarDMSManager.sMe = carDMSManager0;
            }
            else {
                carDMSManager0 = CarDMSManager.sMe;
            }
            return carDMSManager0;
        }
    }

    public CarDMS.DMSDistrWarn getDMSDistrWarn() {
        return CarDMS.DMSDistrWarn.valueOf(this.getSignalValue(616).intValue());
    }

    public CarDMS.DMSFatigWarn getDMSFatigWarn() {
        return CarDMS.DMSFatigWarn.valueOf(this.getSignalValue(615).intValue());
    }

    public CarDMS.DMSMode getDMSMode() {
        return CarDMS.DMSMode.valueOf(this.getSignalValue(614).intValue());
    }

    public CarDMS.DMSSwitch getDMSSwitch() {
        return CarDMS.DMSSwitch.valueOf(this.getSignalValue(612).intValue());
    }

    public CarDMS.DMSSysErrStatus getDMSSysErrStatus() {
        return CarDMS.DMSSysErrStatus.valueOf(this.getSignalValue(610).intValue());
    }

    public void registerListener(CarDMSListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setDMSMode(CarDMS.DMSMode mode) {
        return this.setSignalValue(613, mode.value);
    }

    public boolean setDMSSwitchEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(611, 2) : this.setSignalValue(611, 1);
    }

    public void unregisterListener(CarDMSListener listener) {
        this.unregisterReceiver(listener);
    }
}

