package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.IBaseApi;
import com.yftech.vehicle.internal.adapter.IBaseApi.EnableState;
import com.yftech.vehicle.internal.adapter.ICarDevice.BsvFunctionCmd;
import com.yftech.vehicle.internal.adapter.ICarDevice.PAAMode;
import com.yftech.vehicle.internal.adapter.ICarDevice.PASBackParkDisplayState;
import com.yftech.vehicle.internal.adapter.ICarDevice.RecorderEnterCmd;
import com.yftech.vehicle.internal.adapter.ICarDevice.SvmFunctionCmd;
import com.yftech.vehicle.internal.adapter.ICarDevice;

public class CarDeviceManager extends BaseApiManager implements ICarDevice {
    public static abstract class CarDeviceListener {
        @SignalReceiver(signalId = 570)
        public void onAVMDisplayButtonChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 532)
        public void onBSVDisplayStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 702)
        public void onPASAPADrvReqChanged(int state) {
        }

        @SignalReceiver(signalId = 703)
        public void onPASAPARecIndChanged(int state) {
        }

        @SignalReceiver(signalId = 704)
        public void onPASAPAStChanged(int state) {
        }

        @SignalReceiver(signalId = 0x209)
        public void onPASBackParkDisplayStateChanged(ICarDevice.PASBackParkDisplayState state) {
        }

        @SignalReceiver(signalId = 408)
        public void onRecorderDisplayStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 409)
        public void onRecorderRecordStateChanged(IBaseApi.EnableState state) {
        }
    }

    private static final String TAG = "CarDeviceManager";
    private static CarDeviceManager sMe;

    public static CarDeviceManager get() {
        CarDeviceManager carDeviceManager0;
        synchronized(CarDeviceManager.class) {
            if(CarDeviceManager.sMe == null) {
                carDeviceManager0 = new CarDeviceManager();
                CarDeviceManager.sMe = carDeviceManager0;
            }
            else {
                carDeviceManager0 = CarDeviceManager.sMe;
            }
            return carDeviceManager0;
        }
    }

    public IBaseApi.EnableState getAVMDisplayButton() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(570).intValue());
    }

    public IBaseApi.EnableState getBSVDisplayState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(532).intValue());
    }

    public int getPASAPADrvReq() {
        return this.getSignalValue(702).intValue();
    }

    public int getPASAPARecInd() {
        return this.getSignalValue(703).intValue();
    }

    public int getPASAPASt() {
        return this.getSignalValue(704).intValue();
    }

    public ICarDevice.PASBackParkDisplayState getPASBackParkDisplayState() {
        return ICarDevice.PASBackParkDisplayState.valueOf(this.getSignalValue(0x209).intValue());
    }

    public IBaseApi.EnableState getRecorderDisplayState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(408).intValue());
    }

    public IBaseApi.EnableState getRecorderRecordState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(409).intValue());
    }

    public boolean perform360SvmButtonClick() {
        return this.setSignalValue(308, 1);
    }

    public boolean performAPAButtonClick() {
        return this.setSignalValue(0x206, 1);
    }

    public boolean performAVMPasButtonButtonClick() {
        return this.setSignalValue(572, 1);
    }

    public boolean performBSVButtonClick() {
        return this.setSignalValue(535, 1);
    }

    public boolean performDVRButtonButtonClick() {
        return this.setSignalValue(0x270, 1);
    }

    public void registerListener(CarDeviceListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setAVMDisplayButtonLight(IBaseApi.EnableState state) {
        return this.setSignalValue(571, state.value);
    }

    public boolean setBSVDisplaySwitch(boolean enabled) {
        return enabled ? this.setSignalValue(530, 1) : this.setSignalValue(530, 0);
    }

    public boolean setBsvFunctionCmd(ICarDevice.BsvFunctionCmd cmd) {
        return this.setSignalValue(531, cmd.value);
    }

    public boolean setPAAMode(ICarDevice.PAAMode mode) {
        return this.setSignalValue(0x205, mode.value);
    }

    public boolean setRecorderEnterCmd(ICarDevice.RecorderEnterCmd cmd) {
        return this.setSignalValue(410, cmd.value);
    }

    public boolean setSvmFunctionCmd(ICarDevice.SvmFunctionCmd cmd) {
        return this.setSignalValue(411, cmd.value);
    }

    public void unregisterListener(CarDeviceListener listener) {
        this.unregisterReceiver(listener);
    }
}

