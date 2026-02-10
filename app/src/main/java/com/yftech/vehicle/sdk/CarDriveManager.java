package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.IBaseApi;
import com.yftech.vehicle.internal.adapter.IBaseApi.EnableState;
import com.yftech.vehicle.internal.adapter.IBaseApi.SwitchState;
import com.yftech.vehicle.internal.adapter.ICarDrive.AutoHoldState;
import com.yftech.vehicle.internal.adapter.ICarDrive.AvdcMode;
import com.yftech.vehicle.internal.adapter.ICarDrive.CDCStyleMode;
import com.yftech.vehicle.internal.adapter.ICarDrive.DriveMode;
import com.yftech.vehicle.internal.adapter.ICarDrive.DriveModeHev;
import com.yftech.vehicle.internal.adapter.ICarDrive.DriveSystemMode;
import com.yftech.vehicle.internal.adapter.ICarDrive.EPSStyle;
import com.yftech.vehicle.internal.adapter.ICarDrive.EpsModeState;
import com.yftech.vehicle.internal.adapter.ICarDrive.EspState;
import com.yftech.vehicle.internal.adapter.ICarDrive.EspStyle;
import com.yftech.vehicle.internal.adapter.ICarDrive.GasPedalLevel;
import com.yftech.vehicle.internal.adapter.ICarDrive.HdcState;
import com.yftech.vehicle.internal.adapter.ICarDrive.MemoryDriveMode;
import com.yftech.vehicle.internal.adapter.ICarDrive.MemoryDriveMode_A9E;
import com.yftech.vehicle.internal.adapter.ICarDrive.MrrAccMode;
import com.yftech.vehicle.internal.adapter.ICarDrive.TcuDriveMode;
import com.yftech.vehicle.internal.adapter.ICarDrive.VdcOffState;
import com.yftech.vehicle.internal.adapter.ICarDrive.XDriveMode;
import com.yftech.vehicle.internal.adapter.ICarDrive;

public class CarDriveManager extends BaseApiManager implements ICarDrive {
    public static abstract class CarDriveListener {
        @SignalReceiver(signalId = 444)
        public void onAssistParaSwitchReqStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x11F)
        public void onAutoHoldChanged(ICarDrive.AutoHoldState state) {
        }

        @SignalReceiver(signalId = 0xDE)
        public void onAvdcModeChanged(ICarDrive.AvdcMode mode) {
        }

        @SignalReceiver(signalId = 405)
        public void onBcsVdcOffStateChanged(ICarDrive.VdcOffState state) {
        }

        @SignalReceiver(signalId = 568)
        public void onCDCStyleModeChanged(ICarDrive.CDCStyleMode mode) {
        }

        @SignalReceiver(signalId = 0xB3)
        public void onDriveModeChanged(ICarDrive.DriveMode mode) {
        }

        @SignalReceiver(signalId = 406)
        public void onDriveModeHevChanged(ICarDrive.DriveModeHev mode) {
        }

        @SignalReceiver(signalId = 0x105)
        public void onDriveSystemModeChanged(ICarDrive.DriveSystemMode mode) {
        }

        @SignalReceiver(signalId = 0xB5)
        public void onEMSEngineWaveSwitchStateChanged(IBaseApi.SwitchState state) {
        }

        @SignalReceiver(signalId = 674)
        public void onEPBIndChanged(int state) {
        }

        @SignalReceiver(signalId = 180)
        public void onEPSStyleChanged(ICarDrive.EPSStyle style) {
        }

        @SignalReceiver(signalId = 291)
        public void onEpsModeStateChanged(ICarDrive.EpsModeState state) {
        }

        @SignalReceiver(signalId = 0xD7)
        public void onEspStateChanged(ICarDrive.EspState state) {
        }

        @SignalReceiver(signalId = 290)
        public void onEspStyleChanged(ICarDrive.EspStyle style) {
        }

        @SignalReceiver(signalId = 0xE0)
        public void onGasPedalLevelChanged(ICarDrive.GasPedalLevel level) {
        }

        @SignalReceiver(signalId = 0xD9)
        public void onHdcStateChanged(ICarDrive.HdcState state) {
        }

        @SignalReceiver(signalId = 422)
        public void onMemoryDriveModeA9EChanged(ICarDrive.MemoryDriveMode_A9E mode) {
        }

        @SignalReceiver(signalId = 0xCF)
        public void onMemoryDriveModeChanged(ICarDrive.MemoryDriveMode mode) {
        }

        @SignalReceiver(signalId = 421)
        public void onMrrAccModeChanged(ICarDrive.MrrAccMode mode) {
        }

        @SignalReceiver(signalId = 260)
        public void onTcuDriveModeChanged(ICarDrive.TcuDriveMode mode) {
        }

        @SignalReceiver(signalId = 566)
        public void onXDriveModeChanged(ICarDrive.XDriveMode mode) {
        }
    }

    private static final String TAG = "CarDriveManager";
    private static CarDriveManager sMe;

    public static CarDriveManager get() {
        CarDriveManager carDriveManager0;
        synchronized(CarDriveManager.class) {
            if(CarDriveManager.sMe == null) {
                carDriveManager0 = new CarDriveManager();
                CarDriveManager.sMe = carDriveManager0;
            }
            else {
                carDriveManager0 = CarDriveManager.sMe;
            }
            return carDriveManager0;
        }
    }

    public IBaseApi.EnableState getAssistParaSwitchReqState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(444).intValue());
    }

    public ICarDrive.AutoHoldState getAutoHold() {
        return ICarDrive.AutoHoldState.valueOf(this.getSignalValue(0x11F).intValue());
    }

    public ICarDrive.AvdcMode getAvdcMode() {
        return ICarDrive.AvdcMode.valueOf(this.getSignalValue(0xDE).intValue());
    }

    public ICarDrive.VdcOffState getBcsVdcOffState() {
        return ICarDrive.VdcOffState.valueOf(this.getSignalValue(405).intValue());
    }

    public ICarDrive.CDCStyleMode getCDCStyleMode() {
        return ICarDrive.CDCStyleMode.valueOf(this.getSignalValue(568).intValue());
    }

    public ICarDrive.DriveMode getDriveMode() {
        return ICarDrive.DriveMode.valueOf(this.getSignalValue(0xB3).intValue());
    }

    public ICarDrive.DriveModeHev getDriveModeHev() {
        return ICarDrive.DriveModeHev.valueOf(this.getSignalValue(406).intValue());
    }

    public ICarDrive.DriveSystemMode getDriveSystemMode() {
        return ICarDrive.DriveSystemMode.valueOf(this.getSignalValue(0x105).intValue());
    }

    public IBaseApi.SwitchState getEMSEngineWaveSwitchState() {
        return IBaseApi.SwitchState.valueOf(this.getSignalValue(0xB5).intValue());
    }

    public int getEPBInd() {
        return this.getSignalValue(674).intValue();
    }

    public ICarDrive.EPSStyle getEPSStyle() {
        return ICarDrive.EPSStyle.valueOf(this.getSignalValue(180).intValue());
    }

    public ICarDrive.EpsModeState getEpsModeState() {
        return ICarDrive.EpsModeState.valueOf(this.getSignalValue(291).intValue());
    }

    public ICarDrive.EspState getEspState() {
        return ICarDrive.EspState.valueOf(this.getSignalValue(0xD7).intValue());
    }

    public ICarDrive.EspStyle getEspStyle() {
        return ICarDrive.EspStyle.valueOf(this.getSignalValue(290).intValue());
    }

    public ICarDrive.GasPedalLevel getGasPedalLevel() {
        return ICarDrive.GasPedalLevel.valueOf(this.getSignalValue(0xE0).intValue());
    }

    public ICarDrive.HdcState getHdcState() {
        return ICarDrive.HdcState.valueOf(this.getSignalValue(0xD9).intValue());
    }

    public ICarDrive.MemoryDriveMode getMemoryDriveMode() {
        return ICarDrive.MemoryDriveMode.valueOf(this.getSignalValue(0xCF).intValue());
    }

    public ICarDrive.MemoryDriveMode_A9E getMemoryDriveModeA9E() {
        return ICarDrive.MemoryDriveMode_A9E.valueOf(this.getSignalValue(422).intValue());
    }

    public ICarDrive.MrrAccMode getMrrAccMode() {
        return ICarDrive.MrrAccMode.valueOf(this.getSignalValue(421).intValue());
    }

    public ICarDrive.TcuDriveMode getTcuDriveMode() {
        return ICarDrive.TcuDriveMode.valueOf(this.getSignalValue(260).intValue());
    }

    public ICarDrive.XDriveMode getXDriveMode() {
        return ICarDrive.XDriveMode.valueOf(this.getSignalValue(566).intValue());
    }

    public boolean performAutoHoldButtonClick() {
        return this.setSignalValue(0x120, 1);
    }

    public void registerListener(CarDriveListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setAvdcMode(ICarDrive.AvdcMode mode) {
        return this.setSignalValue(0xDF, mode.value);
    }

    public boolean setCDCStyleMode(ICarDrive.CDCStyleMode mode) {
        return this.setSignalValue(569, mode.value);
    }

    public boolean setDriveMode(ICarDrive.DriveMode mode) {
        return this.setSignalValue(71, mode.value);
    }

    public boolean setEMSEngineWaveEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(73, 2) : this.setSignalValue(73, 1);
    }

    public boolean setEPSStyle(ICarDrive.EPSStyle style) {
        return this.setSignalValue(72, style.value);
    }

    public boolean setEspState(ICarDrive.EspState state) {
        return this.setSignalValue(0xD8, state.value);
    }

    public boolean setGasPedalLevel(ICarDrive.GasPedalLevel level) {
        return this.setSignalValue(0xE1, level.value);
    }

    public boolean setHdcState(ICarDrive.HdcState state) {
        return this.setSignalValue(0xDA, state.value);
    }

    public boolean setMemoryDriveMode(ICarDrive.MemoryDriveMode mode) {
        return this.setSignalValue(0xD0, mode.value);
    }

    public boolean setTcuDriveMode(ICarDrive.TcuDriveMode mode) {
        return this.setSignalValue(662, mode.value);
    }

    public boolean setXDriveMode(ICarDrive.XDriveMode mode) {
        return this.setSignalValue(567, mode.value);
    }

    public void unregisterListener(CarDriveListener listener) {
        this.unregisterReceiver(listener);
    }
}

