package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.IBaseApi;
import com.yftech.vehicle.internal.adapter.IBaseApi.EnableState;
import com.yftech.vehicle.internal.adapter.ICarSeat.AccountDelete;
import com.yftech.vehicle.internal.adapter.ICarSeat.CurrAccountCfg;
import com.yftech.vehicle.internal.adapter.ICarSeat.CurrAccountSeat;
import com.yftech.vehicle.internal.adapter.ICarSeat.CurrPepsPuid;
import com.yftech.vehicle.internal.adapter.ICarSeat.DriverSeatPostionCmd;
import com.yftech.vehicle.internal.adapter.ICarSeat.HeatLevel;
import com.yftech.vehicle.internal.adapter.ICarSeat.HeatVentMode;
import com.yftech.vehicle.internal.adapter.ICarSeat.MemSysOperationReqCmd;
import com.yftech.vehicle.internal.adapter.ICarSeat.SSWOperation;
import com.yftech.vehicle.internal.adapter.ICarSeat.SeatMassageLevel;
import com.yftech.vehicle.internal.adapter.ICarSeat.SeatMassageMode;
import com.yftech.vehicle.internal.adapter.ICarSeat.SeatOperationState;
import com.yftech.vehicle.internal.adapter.ICarSeat.SeatSteeringWheelFR;
import com.yftech.vehicle.internal.adapter.ICarSeat.SeatSteeringWheelRear;
import com.yftech.vehicle.internal.adapter.ICarSeat.VentLevel;
import com.yftech.vehicle.internal.adapter.ICarSeat;

public class CarSeatManager extends BaseApiManager implements ICarSeat {
    public static abstract class CarSeatListener {
        @SignalReceiver(signalId = 347)
        public void onChildLockRLChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 349)
        public void onChildLockRRChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 501)
        public void onCurrPepsPuidChanged(ICarSeat.CurrPepsPuid puid) {
        }

        @SignalReceiver(signalId = 87)
        public void onHeatLevelFLChanged(ICarSeat.HeatLevel level) {
        }

        @SignalReceiver(signalId = 88)
        public void onHeatLevelFRChanged(ICarSeat.HeatLevel level) {
        }

        @SignalReceiver(signalId = 89)
        public void onHeatLevelRLChanged(ICarSeat.HeatLevel level) {
        }

        @SignalReceiver(signalId = 90)
        public void onHeatLevelRRChanged(ICarSeat.HeatLevel level) {
        }

        @SignalReceiver(signalId = 0x5F, valueToEnabledState = true)
        public void onHeatVentAutoModeFLStateChanged(boolean enabled) {
        }

        @SignalReceiver(signalId = 0x60, valueToEnabledState = true)
        public void onHeatVentAutoModeFRStateChanged(boolean enabled) {
        }

        @SignalReceiver(signalId = 97, valueToEnabledState = true)
        public void onHeatVentAutoModeRLStateChanged(boolean enabled) {
        }

        @SignalReceiver(signalId = 98, valueToEnabledState = true)
        public void onHeatVentAutoModeRRStateChanged(boolean enabled) {
        }

        @SignalReceiver(signalId = 506)
        public void onMemSysOperationReqCmdChanged(ICarSeat.MemSysOperationReqCmd cmd) {
        }

        @SignalReceiver(signalId = 686)
        public void onSeatMassageLevelFLChanged(ICarSeat.SeatMassageLevel level) {
        }

        @SignalReceiver(signalId = 692)
        public void onSeatMassageLevelFRChanged(ICarSeat.SeatMassageLevel level) {
        }

        @SignalReceiver(signalId = 296)
        public void onSeatMassageLevelRLChanged(ICarSeat.SeatMassageLevel level) {
        }

        @SignalReceiver(signalId = 302)
        public void onSeatMassageLevelRRChanged(ICarSeat.SeatMassageLevel level) {
        }

        @SignalReceiver(signalId = 684)
        public void onSeatMassageModeFLChanged(ICarSeat.SeatMassageMode mode) {
        }

        @SignalReceiver(signalId = 690)
        public void onSeatMassageModeFRChanged(ICarSeat.SeatMassageMode mode) {
        }

        @SignalReceiver(signalId = 294)
        public void onSeatMassageModeRLChanged(ICarSeat.SeatMassageMode mode) {
        }

        @SignalReceiver(signalId = 300)
        public void onSeatMassageModeRRChanged(ICarSeat.SeatMassageMode mode) {
        }

        @SignalReceiver(signalId = 682)
        public void onSeatMassageOnOffFLChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x2B0)
        public void onSeatMassageOnOffFRChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 292)
        public void onSeatMassageOnOffRLChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 298)
        public void onSeatMassageOnOffRRChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 505)
        public void onSeatOperationStateChanged(ICarSeat.SeatOperationState state) {
        }

        @SignalReceiver(signalId = 91)
        public void onVentLevelFLChanged(ICarSeat.VentLevel level) {
        }

        @SignalReceiver(signalId = 92)
        public void onVentLevelFRChanged(ICarSeat.VentLevel level) {
        }

        @SignalReceiver(signalId = 93)
        public void onVentLevelRLChanged(ICarSeat.VentLevel level) {
        }

        @SignalReceiver(signalId = 94)
        public void onVentLevelRRChanged(ICarSeat.VentLevel level) {
        }
    }

    private static final String TAG = "CarSeatManager";
    private static CarSeatManager sMe;

    public static CarSeatManager get() {
        CarSeatManager carSeatManager0;
        synchronized(CarSeatManager.class) {
            if(CarSeatManager.sMe == null) {
                carSeatManager0 = new CarSeatManager();
                CarSeatManager.sMe = carSeatManager0;
            }
            else {
                carSeatManager0 = CarSeatManager.sMe;
            }
            return carSeatManager0;
        }
    }

    public IBaseApi.EnableState getChildLockRL() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(347).intValue());
    }

    public IBaseApi.EnableState getChildLockRR() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(349).intValue());
    }

    public ICarSeat.CurrPepsPuid getCurrPepsPuid() {
        return ICarSeat.CurrPepsPuid.valueOf(this.getSignalValue(501).intValue());
    }

    public ICarSeat.HeatLevel getHeatLevelFL() {
        return ICarSeat.HeatLevel.valueOf(this.getSignalValue(87).intValue());
    }

    public ICarSeat.HeatLevel getHeatLevelFR() {
        return ICarSeat.HeatLevel.valueOf(this.getSignalValue(88).intValue());
    }

    public ICarSeat.HeatLevel getHeatLevelRL() {
        return ICarSeat.HeatLevel.valueOf(this.getSignalValue(89).intValue());
    }

    public ICarSeat.HeatLevel getHeatLevelRR() {
        return ICarSeat.HeatLevel.valueOf(this.getSignalValue(90).intValue());
    }

    public ICarSeat.MemSysOperationReqCmd getMemSysOperationReqCmd() {
        return ICarSeat.MemSysOperationReqCmd.valueOf(this.getSignalValue(506).intValue());
    }

    public ICarSeat.SeatMassageLevel getSeatMassageLevelFL() {
        return ICarSeat.SeatMassageLevel.valueOf(this.getSignalValue(686).intValue());
    }

    public ICarSeat.SeatMassageLevel getSeatMassageLevelFR() {
        return ICarSeat.SeatMassageLevel.valueOf(this.getSignalValue(692).intValue());
    }

    public ICarSeat.SeatMassageLevel getSeatMassageLevelRL() {
        return ICarSeat.SeatMassageLevel.valueOf(this.getSignalValue(296).intValue());
    }

    public ICarSeat.SeatMassageLevel getSeatMassageLevelRR() {
        return ICarSeat.SeatMassageLevel.valueOf(this.getSignalValue(302).intValue());
    }

    public ICarSeat.SeatMassageMode getSeatMassageModeFL() {
        return ICarSeat.SeatMassageMode.valueOf(this.getSignalValue(684).intValue());
    }

    public ICarSeat.SeatMassageMode getSeatMassageModeFR() {
        return ICarSeat.SeatMassageMode.valueOf(this.getSignalValue(690).intValue());
    }

    public ICarSeat.SeatMassageMode getSeatMassageModeRL() {
        return ICarSeat.SeatMassageMode.valueOf(this.getSignalValue(294).intValue());
    }

    public ICarSeat.SeatMassageMode getSeatMassageModeRR() {
        return ICarSeat.SeatMassageMode.valueOf(this.getSignalValue(300).intValue());
    }

    public IBaseApi.EnableState getSeatMassageOnOffFL() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(682).intValue());
    }

    public IBaseApi.EnableState getSeatMassageOnOffFR() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0x2B0).intValue());
    }

    public IBaseApi.EnableState getSeatMassageOnOffRL() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(292).intValue());
    }

    public IBaseApi.EnableState getSeatMassageOnOffRR() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(298).intValue());
    }

    public ICarSeat.SeatOperationState getSeatOperationState() {
        return ICarSeat.SeatOperationState.valueOf(this.getSignalValue(505).intValue());
    }

    public ICarSeat.VentLevel getVentLevelFL() {
        return ICarSeat.VentLevel.valueOf(this.getSignalValue(91).intValue());
    }

    public ICarSeat.VentLevel getVentLevelFR() {
        return ICarSeat.VentLevel.valueOf(this.getSignalValue(92).intValue());
    }

    public ICarSeat.VentLevel getVentLevelRL() {
        return ICarSeat.VentLevel.valueOf(this.getSignalValue(93).intValue());
    }

    public ICarSeat.VentLevel getVentLevelRR() {
        return ICarSeat.VentLevel.valueOf(this.getSignalValue(94).intValue());
    }

    public boolean isHeatVentAutoModeFLEnabled() {
        return this.getSignalValue(0x5F).byteValue() == 1;
    }

    public boolean isHeatVentAutoModeFREnabled() {
        return this.getSignalValue(0x60).byteValue() == 1;
    }

    public boolean isHeatVentAutoModeRLEnabled() {
        return this.getSignalValue(97).byteValue() == 1;
    }

    public boolean isHeatVentAutoModeRREnabled() {
        return this.getSignalValue(98).byteValue() == 1;
    }

    public void registerListener(CarSeatListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setAccountDelete(ICarSeat.AccountDelete account) {
        return this.setSignalValue(503, account.value);
    }

    public boolean setChildLockRLEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(348, 2) : this.setSignalValue(348, 1);
    }

    public boolean setChildLockRREnabled(boolean enabled) {
        return enabled ? this.setSignalValue(350, 2) : this.setSignalValue(350, 1);
    }

    public boolean setCurrAccountCfg(ICarSeat.CurrAccountCfg cfg) {
        return this.setSignalValue(502, cfg.value);
    }

    public boolean setCurrAccountSeatPosition(ICarSeat.CurrAccountSeat cfg) {
        return this.setSignalValue(667, cfg.value);
    }

    public boolean setDriverSeatPostionCmd(ICarSeat.DriverSeatPostionCmd cmd) {
        return this.setSignalValue(504, cmd.value);
    }

    public boolean setHeatLevelFL(ICarSeat.HeatLevel level) {
        return this.setSignalValue(15, level.value);
    }

    public boolean setHeatLevelFR(ICarSeat.HeatLevel level) {
        return this.setSignalValue(16, level.value);
    }

    public boolean setHeatLevelRL(ICarSeat.HeatLevel level) {
        return this.setSignalValue(17, level.value);
    }

    public boolean setHeatLevelRR(ICarSeat.HeatLevel level) {
        return this.setSignalValue(18, level.value);
    }

    public boolean setHeatVentAutoModeFLEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(27, 2) : this.setSignalValue(27, 1);
    }

    public boolean setHeatVentAutoModeFREnabled(boolean enabled) {
        return enabled ? this.setSignalValue(28, 2) : this.setSignalValue(28, 1);
    }

    public boolean setHeatVentAutoModeRLEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(29, 2) : this.setSignalValue(29, 1);
    }

    public boolean setHeatVentAutoModeRREnabled(boolean enabled) {
        return enabled ? this.setSignalValue(30, 2) : this.setSignalValue(30, 1);
    }

    public boolean setHeatVentModeFL(ICarSeat.HeatVentMode mode) {
        return this.setSignalValue(23, mode.value);
    }

    public boolean setHeatVentModeFR(ICarSeat.HeatVentMode mode) {
        return this.setSignalValue(24, mode.value);
    }

    public boolean setHeatVentModeRL(ICarSeat.HeatVentMode mode) {
        return this.setSignalValue(25, mode.value);
    }

    public boolean setHeatVentModeRR(ICarSeat.HeatVentMode mode) {
        return this.setSignalValue(26, mode.value);
    }

    public boolean setSeatMassageLevelFL(ICarSeat.SeatMassageLevel level) {
        return this.setSignalValue(0x2AF, level.value);
    }

    public boolean setSeatMassageLevelFR(ICarSeat.SeatMassageLevel level) {
        return this.setSignalValue(693, level.value);
    }

    public boolean setSeatMassageLevelRL(ICarSeat.SeatMassageLevel level) {
        return this.setSignalValue(297, level.value);
    }

    public boolean setSeatMassageLevelRR(ICarSeat.SeatMassageLevel level) {
        return this.setSignalValue(303, level.value);
    }

    public boolean setSeatMassageModeFL(ICarSeat.SeatMassageMode mode) {
        return this.setSignalValue(685, mode.value);
    }

    public boolean setSeatMassageModeFR(ICarSeat.SeatMassageMode mode) {
        return this.setSignalValue(691, mode.value);
    }

    public boolean setSeatMassageModeRL(ICarSeat.SeatMassageMode mode) {
        return this.setSignalValue(295, mode.value);
    }

    public boolean setSeatMassageModeRR(ICarSeat.SeatMassageMode mode) {
        return this.setSignalValue(301, mode.value);
    }

    public boolean setSeatMassageOnOffFLEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(683, 2) : this.setSignalValue(683, 1);
    }

    public boolean setSeatMassageOnOffFLSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(696, 1) : this.setSignalValue(696, 0);
    }

    public boolean setSeatMassageOnOffFREnabled(boolean enabled) {
        return enabled ? this.setSignalValue(689, 2) : this.setSignalValue(689, 1);
    }

    public boolean setSeatMassageOnOffFRSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(695, 1) : this.setSignalValue(695, 0);
    }

    public boolean setSeatMassageOnOffRLEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(293, 2) : this.setSignalValue(293, 1);
    }

    public boolean setSeatMassageOnOffRLSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(668, 1) : this.setSignalValue(668, 0);
    }

    public boolean setSeatMassageOnOffRREnabled(boolean enabled) {
        return enabled ? this.setSignalValue(299, 2) : this.setSignalValue(299, 1);
    }

    public boolean setSeatMassageOnOffRRSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(669, 1) : this.setSignalValue(669, 0);
    }

    public boolean setSeatSteeringWheel(ICarSeat.SSWOperation operation) {
        return this.setSignalValue(0x1F, operation.value);
    }

    public boolean setSeatSteeringWheelFR(ICarSeat.SeatSteeringWheelFR operation) {
        return this.setSignalValue(665, operation.value);
    }

    public boolean setSeatSteeringWheelRearLeft(ICarSeat.SeatSteeringWheelRear cfg) {
        return this.setSignalValue(670, cfg.value);
    }

    public boolean setSeatSteeringWheelRearRight(ICarSeat.SeatSteeringWheelRear cfg) {
        return this.setSignalValue(0x29F, cfg.value);
    }

    public boolean setVentLevelFL(ICarSeat.VentLevel level) {
        return this.setSignalValue(19, level.value);
    }

    public boolean setVentLevelFR(ICarSeat.VentLevel level) {
        return this.setSignalValue(20, level.value);
    }

    public boolean setVentLevelRL(ICarSeat.VentLevel level) {
        return this.setSignalValue(21, level.value);
    }

    public boolean setVentLevelRR(ICarSeat.VentLevel level) {
        return this.setSignalValue(22, level.value);
    }

    public void unregisterListener(CarSeatListener listener) {
        this.unregisterReceiver(listener);
    }
}

