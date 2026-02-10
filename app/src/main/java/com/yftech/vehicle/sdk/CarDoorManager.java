package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.IBaseApi;
import com.yftech.vehicle.internal.adapter.IBaseApi.EnableState;
import com.yftech.vehicle.internal.adapter.ICarDoor.AutoUnlockState;
import com.yftech.vehicle.internal.adapter.ICarDoor.DoorLockBuzzerRequest;
import com.yftech.vehicle.internal.adapter.ICarDoor.DoorLockState;
import com.yftech.vehicle.internal.adapter.ICarDoor.DoorState;
import com.yftech.vehicle.internal.adapter.ICarDoor.EngineHoodState;
import com.yftech.vehicle.internal.adapter.ICarDoor.PEPSAutoTrunkOpenState;
import com.yftech.vehicle.internal.adapter.ICarDoor.PLGMControl;
import com.yftech.vehicle.internal.adapter.ICarDoor.PLGMFunction;
import com.yftech.vehicle.internal.adapter.ICarDoor.PLGMMaxLevel;
import com.yftech.vehicle.internal.adapter.ICarDoor.PSDDoorSpeed;
import com.yftech.vehicle.internal.adapter.ICarDoor.RemoteUnlockMode;
import com.yftech.vehicle.internal.adapter.ICarDoor.SlidingDoorCmd;
import com.yftech.vehicle.internal.adapter.ICarDoor.SlidingDoorOperation;
import com.yftech.vehicle.internal.adapter.ICarDoor.SlidingDoorState;
import com.yftech.vehicle.internal.adapter.ICarDoor.TailDoorCmd;
import com.yftech.vehicle.internal.adapter.ICarDoor.TailDoorState;
import com.yftech.vehicle.internal.adapter.ICarDoor;

public class CarDoorManager extends BaseApiManager implements ICarDoor {
    public static abstract class CarDoorListener {
        @SignalReceiver(signalId = 0x94)
        public void onAutoUnlockChanged(ICarDoor.AutoUnlockState state) {
        }

        @SignalReceiver(signalId = 694)
        public void onDoorLockBuzzerRequestChanged(ICarDoor.DoorLockBuzzerRequest state) {
        }

        @SignalReceiver(signalId = 697)
        public void onDoorRightLockBuzzerRequestChanged(ICarDoor.DoorLockBuzzerRequest state) {
        }

        @SignalReceiver(signalId = 402)
        public void onDriverDoorLockChanged(ICarDoor.DoorLockState state) {
        }

        @SignalReceiver(signalId = 0xBC)
        public void onDriverDoorStateChanged(ICarDoor.DoorState state) {
        }

        @SignalReceiver(signalId = 283)
        public void onEngineHoodStateChanged(ICarDoor.EngineHoodState state) {
        }

        @SignalReceiver(signalId = 210)
        public void onHoodDoorStateChanged(ICarDoor.DoorState state) {
        }

        @SignalReceiver(signalId = 150)
        public void onLockUnlockSoundEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x99)
        public void onPEPSAutoTrunkOpenChanged(ICarDoor.PEPSAutoTrunkOpenState state) {
        }

        @SignalReceiver(signalId = 0x97)
        public void onPEPSUnlockEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x98)
        public void onPEPSWalkAwayLockEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x9E)
        public void onPSDDoorSpeedLChanged(ICarDoor.PSDDoorSpeed speed) {
        }

        @SignalReceiver(signalId = 0x9F)
        public void onPSDDoorSpeedRChanged(ICarDoor.PSDDoorSpeed speed) {
        }

        @SignalReceiver(signalId = 403)
        public void onPassengerDoorLockChanged(ICarDoor.DoorLockState state) {
        }

        @SignalReceiver(signalId = 0xD3)
        public void onPassengerDoorStateChanged(ICarDoor.DoorState state) {
        }

        @SignalReceiver(signalId = 0xD4)
        public void onRearLeftDoorStateChanged(ICarDoor.DoorState state) {
        }

        @SignalReceiver(signalId = 0xD5)
        public void onRearRightDoorStateChanged(ICarDoor.DoorState state) {
        }

        @SignalReceiver(signalId = 0x93)
        public void onRemoteUnlockModeChanged(ICarDoor.RemoteUnlockMode mode) {
        }

        @SignalReceiver(signalId = 0x2A0)
        public void onSlidingDoorModeAutoChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0xE3, valueToEnabledState = true)
        public void onSlidingDoorModeAutoStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 0xF3)
        public void onSlidingDoorOperationLChanged(ICarDoor.SlidingDoorOperation operation) {
        }

        @SignalReceiver(signalId = 0xF5)
        public void onSlidingDoorOperationRChanged(ICarDoor.SlidingDoorOperation operation) {
        }

        @SignalReceiver(signalId = 0xF2)
        public void onSlidingDoorStateLChanged(ICarDoor.SlidingDoorState state) {
        }

        @SignalReceiver(signalId = 0xF4)
        public void onSlidingDoorStateRChanged(ICarDoor.SlidingDoorState state) {
        }

        @SignalReceiver(signalId = 0x95)
        public void onSpeedAutoLockEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x9D, valueToEnabledState = true)
        public void onTailDoorModeStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 0x9A)
        public void onTailDoorPercentChanged(int percent) {
        }

        @SignalReceiver(signalId = 0x9C)
        public void onTailDoorStateChanged(ICarDoor.TailDoorState state) {
        }

        @SignalReceiver(signalId = 0x9B)
        public void onTailDoorTravelPercentChanged(int percent) {
        }

        @SignalReceiver(signalId = 0xD6)
        public void onTrunkDoorStateChanged(ICarDoor.DoorState state) {
        }
    }

    private static final String TAG = "CarDoorManager";
    private static CarDoorManager sMe;

    public static CarDoorManager get() {
        CarDoorManager carDoorManager0;
        synchronized(CarDoorManager.class) {
            if(CarDoorManager.sMe == null) {
                carDoorManager0 = new CarDoorManager();
                CarDoorManager.sMe = carDoorManager0;
            }
            else {
                carDoorManager0 = CarDoorManager.sMe;
            }
            return carDoorManager0;
        }
    }

    public ICarDoor.AutoUnlockState getAutoUnlock() {
        return ICarDoor.AutoUnlockState.valueOf(this.getSignalValue(0x94).intValue());
    }

    public ICarDoor.DoorLockBuzzerRequest getDoorLockBuzzerRequest() {
        return ICarDoor.DoorLockBuzzerRequest.valueOf(this.getSignalValue(694).intValue());
    }

    public ICarDoor.DoorLockBuzzerRequest getDoorRightLockBuzzerRequest() {
        return ICarDoor.DoorLockBuzzerRequest.valueOf(this.getSignalValue(697).intValue());
    }

    public ICarDoor.DoorLockState getDriverDoorLock() {
        return ICarDoor.DoorLockState.valueOf(this.getSignalValue(402).intValue());
    }

    public ICarDoor.DoorState getDriverDoorState() {
        return ICarDoor.DoorState.valueOf(this.getSignalValue(0xBC).intValue());
    }

    public ICarDoor.EngineHoodState getEngineHoodState() {
        return ICarDoor.EngineHoodState.valueOf(this.getSignalValue(283).intValue());
    }

    public ICarDoor.DoorState getHoodDoorState() {
        return ICarDoor.DoorState.valueOf(this.getSignalValue(210).intValue());
    }

    public IBaseApi.EnableState getLockUnlockSoundEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(150).intValue());
    }

    public ICarDoor.PEPSAutoTrunkOpenState getPEPSAutoTrunkOpen() {
        return ICarDoor.PEPSAutoTrunkOpenState.valueOf(this.getSignalValue(0x99).intValue());
    }

    public IBaseApi.EnableState getPEPSUnlockEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0x97).intValue());
    }

    public IBaseApi.EnableState getPEPSWalkAwayLockEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0x98).intValue());
    }

    public ICarDoor.PSDDoorSpeed getPSDDoorSpeedL() {
        return ICarDoor.PSDDoorSpeed.valueOf(this.getSignalValue(0x9E).intValue());
    }

    public ICarDoor.PSDDoorSpeed getPSDDoorSpeedR() {
        return ICarDoor.PSDDoorSpeed.valueOf(this.getSignalValue(0x9F).intValue());
    }

    public ICarDoor.DoorLockState getPassengerDoorLock() {
        return ICarDoor.DoorLockState.valueOf(this.getSignalValue(403).intValue());
    }

    public ICarDoor.DoorState getPassengerDoorState() {
        return ICarDoor.DoorState.valueOf(this.getSignalValue(0xD3).intValue());
    }

    public ICarDoor.DoorState getRearLeftDoorState() {
        return ICarDoor.DoorState.valueOf(this.getSignalValue(0xD4).intValue());
    }

    public ICarDoor.DoorState getRearRightDoorState() {
        return ICarDoor.DoorState.valueOf(this.getSignalValue(0xD5).intValue());
    }

    public ICarDoor.RemoteUnlockMode getRemoteUnlockMode() {
        return ICarDoor.RemoteUnlockMode.valueOf(this.getSignalValue(0x93).intValue());
    }

    public IBaseApi.EnableState getSlidingDoorModeAuto() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0x2A0).intValue());
    }

    public ICarDoor.SlidingDoorOperation getSlidingDoorOperationL() {
        return ICarDoor.SlidingDoorOperation.valueOf(this.getSignalValue(0xF3).intValue());
    }

    public ICarDoor.SlidingDoorOperation getSlidingDoorOperationR() {
        return ICarDoor.SlidingDoorOperation.valueOf(this.getSignalValue(0xF5).intValue());
    }

    public ICarDoor.SlidingDoorState getSlidingDoorStateL() {
        return ICarDoor.SlidingDoorState.valueOf(this.getSignalValue(0xF2).intValue());
    }

    public ICarDoor.SlidingDoorState getSlidingDoorStateR() {
        return ICarDoor.SlidingDoorState.valueOf(this.getSignalValue(0xF4).intValue());
    }

    public IBaseApi.EnableState getSpeedAutoLockEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0x95).intValue());
    }

    public int getTailDoorPercent() {
        return this.getSignalValue(0x9A).intValue();
    }

    public ICarDoor.TailDoorState getTailDoorState() {
        return ICarDoor.TailDoorState.valueOf(this.getSignalValue(0x9C).intValue());
    }

    public int getTailDoorTravelPercent() {
        return this.getSignalValue(0x9B).intValue();
    }

    public ICarDoor.DoorState getTrunkDoorState() {
        return ICarDoor.DoorState.valueOf(this.getSignalValue(0xD6).intValue());
    }

    public boolean isSlidingDoorModeAutoEnabled() {
        return this.getSignalValue(0xE3).byteValue() == 1;
    }

    public boolean isTailDoorModeEnabled() {
        return this.getSignalValue(0x9D).byteValue() == 1;
    }

    public boolean performTailDoorMaxPositionMemoryButtonClick() {
        return this.setSignalValue(289, 1);
    }

    public boolean performTailDoorPositionMemoryClearButtonClick() {
        return this.setSignalValue(286, 1);
    }

    public void registerListener(CarDoorListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setAutoUnlock(ICarDoor.AutoUnlockState state) {
        return this.setSignalValue(53, state.value);
    }

    public boolean setLockUnlockSoundEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(55, 2) : this.setSignalValue(55, 1);
    }

    public boolean setPEPSAutoTrunkOpen(ICarDoor.PEPSAutoTrunkOpenState state) {
        return this.setSignalValue(58, state.value);
    }

    public boolean setPEPSUnlockEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(56, 2) : this.setSignalValue(56, 1);
    }

    public boolean setPEPSWalkAwayLockEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(57, 2) : this.setSignalValue(57, 1);
    }

    public boolean setPLGMControl(ICarDoor.PLGMControl control) {
        return this.setSignalValue(-1, control.value);
    }

    public boolean setPLGMFunction(ICarDoor.PLGMFunction fun) {
        return this.setSignalValue(61, fun.value);
    }

    public boolean setPLGMMaxLevel(ICarDoor.PLGMMaxLevel level) {
        return this.setSignalValue(60, level.value);
    }

    public boolean setPSDDoorSpeedL(ICarDoor.PSDDoorSpeed speed) {
        return this.setSignalValue(0xE5, speed.value);
    }

    public boolean setPSDDoorSpeedR(ICarDoor.PSDDoorSpeed speed) {
        return this.setSignalValue(230, speed.value);
    }

    public boolean setRemoteUnlockMode(ICarDoor.RemoteUnlockMode mode) {
        return this.setSignalValue(52, mode.value);
    }

    public boolean setSlidingDoorCmdL(ICarDoor.SlidingDoorCmd cmd) {
        return this.setSignalValue(0xF1, cmd.value);
    }

    public boolean setSlidingDoorCmdR(ICarDoor.SlidingDoorCmd cmd) {
        return this.setSignalValue(0xF0, cmd.value);
    }

    public boolean setSlidingDoorModeAutoEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(0xE4, 2) : this.setSignalValue(0xE4, 1);
    }

    public boolean setSpeedAutoLockEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(54, 2) : this.setSignalValue(54, 1);
    }

    public boolean setTailDoorCmd(ICarDoor.TailDoorCmd cmd) {
        return this.setSignalValue(59, cmd.value);
    }

    public void unregisterListener(CarDoorListener listener) {
        this.unregisterReceiver(listener);
    }
}

