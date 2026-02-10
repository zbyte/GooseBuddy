package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.IBaseApi;
import com.yftech.vehicle.internal.adapter.IBaseApi.EnableState;
import com.yftech.vehicle.internal.adapter.ICarParking.PASErrorFlag;
import com.yftech.vehicle.internal.adapter.ICarParking.PASSystemFailureFlag;
import com.yftech.vehicle.internal.adapter.ICarParking.PASSystemType;
import com.yftech.vehicle.internal.adapter.ICarParking.PASWarnTone;
import com.yftech.vehicle.internal.adapter.ICarParking;

public class CarParkingManager extends BaseApiManager implements ICarParking {
    public static abstract class CarParkingListener {
        @SignalReceiver(signalId = 0x88)
        public void onPASDistanceFLChanged(int cm) {
        }

        @SignalReceiver(signalId = 0x83)
        public void onPASDistanceFLMiddleChanged(int cm) {
        }

        @SignalReceiver(signalId = 140)
        public void onPASDistanceFLSideChanged(int cm) {
        }

        @SignalReceiver(signalId = 0x87)
        public void onPASDistanceFRChanged(int cm) {
        }

        @SignalReceiver(signalId = 0x84)
        public void onPASDistanceFRMiddleChanged(int cm) {
        }

        @SignalReceiver(signalId = 0x8B)
        public void onPASDistanceFRSideChanged(int cm) {
        }

        @SignalReceiver(signalId = 0x86)
        public void onPASDistanceRLChanged(int cm) {
        }

        @SignalReceiver(signalId = 0x81)
        public void onPASDistanceRLMiddleChanged(int cm) {
        }

        @SignalReceiver(signalId = 0x8A)
        public void onPASDistanceRLSideChanged(int cm) {
        }

        @SignalReceiver(signalId = 0x85)
        public void onPASDistanceRRChanged(int cm) {
        }

        @SignalReceiver(signalId = 130)
        public void onPASDistanceRRMiddleChanged(int cm) {
        }

        @SignalReceiver(signalId = 0x89)
        public void onPASDistanceRRSideChanged(int cm) {
        }

        @SignalReceiver(signalId = 0x91)
        public void onPASErrorFlagOfEEPROMChanged(ICarParking.PASErrorFlag error) {
        }

        @SignalReceiver(signalId = 0x92)
        public void onPASErrorFlagOfIGNVoltageChanged(ICarParking.PASErrorFlag error) {
        }

        @SignalReceiver(signalId = 0x90)
        public void onPASErrorFlagRLChanged(ICarParking.PASErrorFlag error) {
        }

        @SignalReceiver(signalId = 0x8E)
        public void onPASErrorFlagRLMiddleChanged(ICarParking.PASErrorFlag error) {
        }

        @SignalReceiver(signalId = 0x8F)
        public void onPASErrorFlagRRChanged(ICarParking.PASErrorFlag error) {
        }

        @SignalReceiver(signalId = 0x8D)
        public void onPASErrorFlagRRMiddleChanged(ICarParking.PASErrorFlag error) {
        }

        @SignalReceiver(signalId = 0x7F)
        public void onPASSystemFailureFlagChanged(ICarParking.PASSystemFailureFlag flag) {
        }

        @SignalReceiver(signalId = 0x7E)
        public void onPASSystemTypeChanged(ICarParking.PASSystemType type) {
        }

        @SignalReceiver(signalId = 0x80)
        public void onPASWarnToneChanged(ICarParking.PASWarnTone tone) {
        }

        @SignalReceiver(signalId = 0xFE)
        public void onParkingRadarAlarmEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x100)
        public void onParkingVoiceSwitchEnableStateChanged(IBaseApi.EnableState state) {
        }
    }

    private static final String TAG = "CarParkingManager";
    private static CarParkingManager sMe;

    public static CarParkingManager get() {
        CarParkingManager carParkingManager0;
        synchronized(CarParkingManager.class) {
            if(CarParkingManager.sMe == null) {
                carParkingManager0 = new CarParkingManager();
                CarParkingManager.sMe = carParkingManager0;
            }
            else {
                carParkingManager0 = CarParkingManager.sMe;
            }
            return carParkingManager0;
        }
    }

    public int getPASDistanceFL() {
        return this.getSignalValue(0x88).intValue();
    }

    public int getPASDistanceFLMiddle() {
        return this.getSignalValue(0x83).intValue();
    }

    public int getPASDistanceFLSide() {
        return this.getSignalValue(140).intValue();
    }

    public int getPASDistanceFR() {
        return this.getSignalValue(0x87).intValue();
    }

    public int getPASDistanceFRMiddle() {
        return this.getSignalValue(0x84).intValue();
    }

    public int getPASDistanceFRSide() {
        return this.getSignalValue(0x8B).intValue();
    }

    public int getPASDistanceRL() {
        return this.getSignalValue(0x86).intValue();
    }

    public int getPASDistanceRLMiddle() {
        return this.getSignalValue(0x81).intValue();
    }

    public int getPASDistanceRLSide() {
        return this.getSignalValue(0x8A).intValue();
    }

    public int getPASDistanceRR() {
        return this.getSignalValue(0x85).intValue();
    }

    public int getPASDistanceRRMiddle() {
        return this.getSignalValue(130).intValue();
    }

    public int getPASDistanceRRSide() {
        return this.getSignalValue(0x89).intValue();
    }

    public ICarParking.PASErrorFlag getPASErrorFlagOfEEPROM() {
        return ICarParking.PASErrorFlag.valueOf(this.getSignalValue(0x91).intValue());
    }

    public ICarParking.PASErrorFlag getPASErrorFlagOfIGNVoltage() {
        return ICarParking.PASErrorFlag.valueOf(this.getSignalValue(0x92).intValue());
    }

    public ICarParking.PASErrorFlag getPASErrorFlagRL() {
        return ICarParking.PASErrorFlag.valueOf(this.getSignalValue(0x90).intValue());
    }

    public ICarParking.PASErrorFlag getPASErrorFlagRLMiddle() {
        return ICarParking.PASErrorFlag.valueOf(this.getSignalValue(0x8E).intValue());
    }

    public ICarParking.PASErrorFlag getPASErrorFlagRR() {
        return ICarParking.PASErrorFlag.valueOf(this.getSignalValue(0x8F).intValue());
    }

    public ICarParking.PASErrorFlag getPASErrorFlagRRMiddle() {
        return ICarParking.PASErrorFlag.valueOf(this.getSignalValue(0x8D).intValue());
    }

    public ICarParking.PASSystemFailureFlag getPASSystemFailureFlag() {
        return ICarParking.PASSystemFailureFlag.valueOf(this.getSignalValue(0x7F).intValue());
    }

    public ICarParking.PASSystemType getPASSystemType() {
        return ICarParking.PASSystemType.valueOf(this.getSignalValue(0x7E).intValue());
    }

    public ICarParking.PASWarnTone getPASWarnTone() {
        return ICarParking.PASWarnTone.valueOf(this.getSignalValue(0x80).intValue());
    }

    public IBaseApi.EnableState getParkingRadarAlarmEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0xFE).intValue());
    }

    public IBaseApi.EnableState getParkingVoiceSwitchEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0x100).intValue());
    }

    public boolean performParkingRadarAlarmButtonClick() {
        return this.setSignalValue(0xFF, 1);
    }

    public void registerListener(CarParkingListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setParkingVoiceSwitchEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(0x101, 2) : this.setSignalValue(0x101, 1);
    }

    public void unregisterListener(CarParkingListener listener) {
        this.unregisterReceiver(listener);
    }
}

