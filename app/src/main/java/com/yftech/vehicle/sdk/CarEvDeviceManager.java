package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.IBaseApi;
import com.yftech.vehicle.internal.adapter.IBaseApi.EnableState;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.AvdcMode;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.ChargActive;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.ChargEnd;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.ChargState;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.ChargeFullNoticeLevel;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.ChargeMode;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.ChargeSocPercent;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.ChargeWarmTime;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.DischgSetInfo;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.DriveModeEv;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.EcoPlusMode;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.EnergyModel;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.EngStartCfg;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.GasPedalLevel;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.HealCheckNotice;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.ObcConnState;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.PlugAutoUnlockCfg;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.PowerFlowMode;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.RecpLevelAvail;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.RecuperationLevel;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.RecuperationLevelA9E;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.RepeatBookMode;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.SocProgress;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.XDriveMode;
import com.yftech.vehicle.internal.adapter.ICarEvDevice;

public class CarEvDeviceManager extends BaseApiManager implements ICarEvDevice {
    public static abstract class CarEvDeviceListener {
        @SignalReceiver(signalId = 0x2CF)
        public void onAvdcModeChanged(ICarEvDevice.AvdcMode mode) {
        }

        @SignalReceiver(signalId = 314)
        public void onBatteryQuantityPercentChanged(float percent) {
        }

        @SignalReceiver(signalId = 385)
        public void onBookChrgStartDayChanged(int day) {
        }

        @SignalReceiver(signalId = 386)
        public void onBookChrgStartHourChanged(int hour) {
        }

        @SignalReceiver(signalId = 387)
        public void onBookChrgStartMinChanged(int min) {
        }

        @SignalReceiver(signalId = 0x180)
        public void onBookChrgStartMonChanged(int mon) {
        }

        @SignalReceiver(signalId = 380)
        public void onBookChrgStartRemainingDayChanged(int day) {
        }

        @SignalReceiver(signalId = 381)
        public void onBookChrgStartRemainingHourChanged(int hour) {
        }

        @SignalReceiver(signalId = 382)
        public void onBookChrgStartRemainingMinChanged(int min) {
        }

        @SignalReceiver(signalId = 0x17F)
        public void onBookChrgStartYearChanged(int year) {
        }

        @SignalReceiver(signalId = 390)
        public void onBookChrgStopDayChanged(int day) {
        }

        @SignalReceiver(signalId = 391)
        public void onBookChrgStopHourChanged(int hour) {
        }

        @SignalReceiver(signalId = 392)
        public void onBookChrgStopMinChanged(int min) {
        }

        @SignalReceiver(signalId = 389)
        public void onBookChrgStopMonChanged(int mon) {
        }

        @SignalReceiver(signalId = 388)
        public void onBookChrgStopYearChanged(int year) {
        }

        @SignalReceiver(signalId = 490)
        public void onChargActiveChanged(ICarEvDevice.ChargActive state) {
        }

        @SignalReceiver(signalId = 492)
        public void onChargCurrentChanged(int val) {
        }

        @SignalReceiver(signalId = 489)
        public void onChargStateChanged(ICarEvDevice.ChargState state) {
        }

        @SignalReceiver(signalId = 324)
        public void onChargeFullNoticeLevelChanged(ICarEvDevice.ChargeFullNoticeLevel notice) {
        }

        @SignalReceiver(signalId = 393)
        public void onChargeModeChanged(ICarEvDevice.ChargeMode mode) {
        }

        @SignalReceiver(signalId = 318)
        public void onChargeSocPercentChanged(ICarEvDevice.ChargeSocPercent percent) {
        }

        @SignalReceiver(signalId = 320)
        public void onChargeSocPercentValidEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 321)
        public void onChargeWarmTimeChanged(ICarEvDevice.ChargeWarmTime time) {
        }

        @SignalReceiver(signalId = 323)
        public void onChargeWarmTimeValidEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 482, valueToEnabledState = true)
        public void onDischgActiveStateStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 484)
        public void onDischgEndVehRngChanged(int val) {
        }

        @SignalReceiver(signalId = 478, valueToEnabledState = true)
        public void onDischgEngStartCfgStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 494)
        public void onDischgSetInfoChanged(ICarEvDevice.DischgSetInfo info) {
        }

        @SignalReceiver(signalId = 480)
        public void onDischgSocCfgChanged(int val) {
        }

        @SignalReceiver(signalId = 485)
        public void onDischgTimeCfgChanged(int val) {
        }

        @SignalReceiver(signalId = 355)
        public void onDriveModeEvChanged(ICarEvDevice.DriveModeEv mode) {
        }

        @SignalReceiver(signalId = 476)
        public void onDrvTargetSOEChanged(int val) {
        }

        @SignalReceiver(signalId = 359)
        public void onEcoModeEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 361)
        public void onEcoNormalSportModeEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 358)
        public void onEcoPlusModeEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 474)
        public void onEnergyModelChanged(ICarEvDevice.EnergyModel mode) {
        }

        @SignalReceiver(signalId = 473, valueToEnabledState = true)
        public void onEngSelfMaintDispStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 721)
        public void onGasPedalLevelChanged(ICarEvDevice.GasPedalLevel level) {
        }

        @SignalReceiver(signalId = 643)
        public void onHVEMPowerFlowStateChanged(int state) {
        }

        @SignalReceiver(signalId = 642)
        public void onHVEPPowerFlowStateChanged(int state) {
        }

        @SignalReceiver(signalId = 646)
        public void onHVM2BPowerFlowStateChanged(int state) {
        }

        @SignalReceiver(signalId = 645)
        public void onHVMBPowerFlowStateChanged(int state) {
        }

        @SignalReceiver(signalId = 644)
        public void onHVMPPowerFlowStateChanged(int state) {
        }

        @SignalReceiver(signalId = 325)
        public void onHealCheckNoticeChanged(ICarEvDevice.HealCheckNotice notice) {
        }

        @SignalReceiver(signalId = 315, valueToEnabledState = true)
        public void onIpedalCreepStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 317)
        public void onIpedalCreepValidEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 360)
        public void onIpedalModeEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x201)
        public void onObcConnStateChanged(ICarEvDevice.ObcConnState state) {
        }

        @SignalReceiver(signalId = 487)
        public void onPlugAutoUnlockCfgChanged(ICarEvDevice.PlugAutoUnlockCfg cfg) {
        }

        @SignalReceiver(signalId = 313)
        public void onPowerFlowModeChanged(ICarEvDevice.PowerFlowMode mode) {
        }

        @SignalReceiver(signalId = 354)
        public void onRecpLevelAvailChanged(ICarEvDevice.RecpLevelAvail avail) {
        }

        @SignalReceiver(signalId = 412)
        public void onRecuperationLevelA9EChanged(ICarEvDevice.RecuperationLevelA9E level) {
        }

        @SignalReceiver(signalId = 0x160)
        public void onRecuperationLevelChanged(ICarEvDevice.RecuperationLevel level) {
        }

        @SignalReceiver(signalId = 394)
        public void onRepeatBookChrgDay1Changed(ICarEvDevice.RepeatBookMode mode) {
        }

        @SignalReceiver(signalId = 395)
        public void onRepeatBookChrgDay2Changed(ICarEvDevice.RepeatBookMode mode) {
        }

        @SignalReceiver(signalId = 396)
        public void onRepeatBookChrgDay3Changed(ICarEvDevice.RepeatBookMode mode) {
        }

        @SignalReceiver(signalId = 397)
        public void onRepeatBookChrgDay4Changed(ICarEvDevice.RepeatBookMode mode) {
        }

        @SignalReceiver(signalId = 398)
        public void onRepeatBookChrgDay5Changed(ICarEvDevice.RepeatBookMode mode) {
        }

        @SignalReceiver(signalId = 0x18F)
        public void onRepeatBookChrgDay6Changed(ICarEvDevice.RepeatBookMode mode) {
        }

        @SignalReceiver(signalId = 400)
        public void onRepeatBookChrgDay7Changed(ICarEvDevice.RepeatBookMode mode) {
        }

        @SignalReceiver(signalId = -1)
        public void onSocProgressChanged(ICarEvDevice.SocProgress progress) {
        }

        @SignalReceiver(signalId = 472, valueToEnabledState = true)
        public void onVehRdyStateStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 726)
        public void onXDriveModeChanged(ICarEvDevice.XDriveMode mode) {
        }
    }

    private static final String TAG = "CarEvDeviceManager";
    private static CarEvDeviceManager sMe;

    public static CarEvDeviceManager get() {
        CarEvDeviceManager carEvDeviceManager0;
        synchronized(CarEvDeviceManager.class) {
            if(CarEvDeviceManager.sMe == null) {
                carEvDeviceManager0 = new CarEvDeviceManager();
                CarEvDeviceManager.sMe = carEvDeviceManager0;
            }
            else {
                carEvDeviceManager0 = CarEvDeviceManager.sMe;
            }
            return carEvDeviceManager0;
        }
    }

    public ICarEvDevice.AvdcMode getAvdcMode() {
        return ICarEvDevice.AvdcMode.valueOf(this.getSignalValue(0x2CF).intValue());
    }

    public float getBatteryQuantityPercent() {
        return this.getSignalValue(314).floatValue();
    }

    public int getBookChrgStartDay() {
        return this.getSignalValue(385).intValue();
    }

    public int getBookChrgStartHour() {
        return this.getSignalValue(386).intValue();
    }

    public int getBookChrgStartMin() {
        return this.getSignalValue(387).intValue();
    }

    public int getBookChrgStartMon() {
        return this.getSignalValue(0x180).intValue();
    }

    public int getBookChrgStartRemainingDay() {
        return this.getSignalValue(380).intValue();
    }

    public int getBookChrgStartRemainingHour() {
        return this.getSignalValue(381).intValue();
    }

    public int getBookChrgStartRemainingMin() {
        return this.getSignalValue(382).intValue();
    }

    public int getBookChrgStartYear() {
        return this.getSignalValue(0x17F).intValue();
    }

    public int getBookChrgStopDay() {
        return this.getSignalValue(390).intValue();
    }

    public int getBookChrgStopHour() {
        return this.getSignalValue(391).intValue();
    }

    public int getBookChrgStopMin() {
        return this.getSignalValue(392).intValue();
    }

    public int getBookChrgStopMon() {
        return this.getSignalValue(389).intValue();
    }

    public int getBookChrgStopYear() {
        return this.getSignalValue(388).intValue();
    }

    public ICarEvDevice.ChargActive getChargActive() {
        return ICarEvDevice.ChargActive.valueOf(this.getSignalValue(490).intValue());
    }

    public int getChargCurrent() {
        return this.getSignalValue(492).intValue();
    }

    public ICarEvDevice.ChargState getChargState() {
        return ICarEvDevice.ChargState.valueOf(this.getSignalValue(489).intValue());
    }

    public ICarEvDevice.ChargeFullNoticeLevel getChargeFullNoticeLevel() {
        return ICarEvDevice.ChargeFullNoticeLevel.valueOf(this.getSignalValue(324).intValue());
    }

    public ICarEvDevice.ChargeMode getChargeMode() {
        return ICarEvDevice.ChargeMode.valueOf(this.getSignalValue(393).intValue());
    }

    public ICarEvDevice.ChargeSocPercent getChargeSocPercent() {
        return ICarEvDevice.ChargeSocPercent.valueOf(this.getSignalValue(318).intValue());
    }

    public IBaseApi.EnableState getChargeSocPercentValidEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(320).intValue());
    }

    public ICarEvDevice.ChargeWarmTime getChargeWarmTime() {
        return ICarEvDevice.ChargeWarmTime.valueOf(this.getSignalValue(321).intValue());
    }

    public IBaseApi.EnableState getChargeWarmTimeValidEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(323).intValue());
    }

    public int getDischgEndVehRng() {
        return this.getSignalValue(484).intValue();
    }

    public ICarEvDevice.DischgSetInfo getDischgSetInfo() {
        return ICarEvDevice.DischgSetInfo.valueOf(this.getSignalValue(494).intValue());
    }

    public int getDischgSocCfg() {
        return this.getSignalValue(480).intValue();
    }

    public int getDischgTimeCfg() {
        return this.getSignalValue(485).intValue();
    }

    public ICarEvDevice.DriveModeEv getDriveModeEv() {
        return ICarEvDevice.DriveModeEv.valueOf(this.getSignalValue(355).intValue());
    }

    public int getDrvTargetSOE() {
        return this.getSignalValue(476).intValue();
    }

    public IBaseApi.EnableState getEcoModeEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(359).intValue());
    }

    public IBaseApi.EnableState getEcoNormalSportModeEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(361).intValue());
    }

    public IBaseApi.EnableState getEcoPlusModeEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(358).intValue());
    }

    public ICarEvDevice.EnergyModel getEnergyModel() {
        return ICarEvDevice.EnergyModel.valueOf(this.getSignalValue(474).intValue());
    }

    public ICarEvDevice.GasPedalLevel getGasPedalLevel() {
        return ICarEvDevice.GasPedalLevel.valueOf(this.getSignalValue(721).intValue());
    }

    public int getHVEMPowerFlowState() {
        return this.getSignalValue(643).intValue();
    }

    public int getHVEPPowerFlowState() {
        return this.getSignalValue(642).intValue();
    }

    public int getHVM2BPowerFlowState() {
        return this.getSignalValue(646).intValue();
    }

    public int getHVMBPowerFlowState() {
        return this.getSignalValue(645).intValue();
    }

    public int getHVMPPowerFlowState() {
        return this.getSignalValue(644).intValue();
    }

    public ICarEvDevice.HealCheckNotice getHealCheckNotice() {
        return ICarEvDevice.HealCheckNotice.valueOf(this.getSignalValue(325).intValue());
    }

    public IBaseApi.EnableState getIpedalCreepValidEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(317).intValue());
    }

    public IBaseApi.EnableState getIpedalModeEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(360).intValue());
    }

    public ICarEvDevice.ObcConnState getObcConnState() {
        return ICarEvDevice.ObcConnState.valueOf(this.getSignalValue(0x201).intValue());
    }

    public ICarEvDevice.PlugAutoUnlockCfg getPlugAutoUnlockCfg() {
        return ICarEvDevice.PlugAutoUnlockCfg.valueOf(this.getSignalValue(487).intValue());
    }

    public ICarEvDevice.PowerFlowMode getPowerFlowMode() {
        return ICarEvDevice.PowerFlowMode.valueOf(this.getSignalValue(313).intValue());
    }

    public ICarEvDevice.RecpLevelAvail getRecpLevelAvail() {
        return ICarEvDevice.RecpLevelAvail.valueOf(this.getSignalValue(354).intValue());
    }

    public ICarEvDevice.RecuperationLevel getRecuperationLevel() {
        return ICarEvDevice.RecuperationLevel.valueOf(this.getSignalValue(0x160).intValue());
    }

    public ICarEvDevice.RecuperationLevelA9E getRecuperationLevelA9E() {
        return ICarEvDevice.RecuperationLevelA9E.valueOf(this.getSignalValue(412).intValue());
    }

    public ICarEvDevice.RepeatBookMode getRepeatBookChrgDay1() {
        return ICarEvDevice.RepeatBookMode.valueOf(this.getSignalValue(394).intValue());
    }

    public ICarEvDevice.RepeatBookMode getRepeatBookChrgDay2() {
        return ICarEvDevice.RepeatBookMode.valueOf(this.getSignalValue(395).intValue());
    }

    public ICarEvDevice.RepeatBookMode getRepeatBookChrgDay3() {
        return ICarEvDevice.RepeatBookMode.valueOf(this.getSignalValue(396).intValue());
    }

    public ICarEvDevice.RepeatBookMode getRepeatBookChrgDay4() {
        return ICarEvDevice.RepeatBookMode.valueOf(this.getSignalValue(397).intValue());
    }

    public ICarEvDevice.RepeatBookMode getRepeatBookChrgDay5() {
        return ICarEvDevice.RepeatBookMode.valueOf(this.getSignalValue(398).intValue());
    }

    public ICarEvDevice.RepeatBookMode getRepeatBookChrgDay6() {
        return ICarEvDevice.RepeatBookMode.valueOf(this.getSignalValue(0x18F).intValue());
    }

    public ICarEvDevice.RepeatBookMode getRepeatBookChrgDay7() {
        return ICarEvDevice.RepeatBookMode.valueOf(this.getSignalValue(400).intValue());
    }

    public ICarEvDevice.SocProgress getSocProgress() {
        return ICarEvDevice.SocProgress.valueOf(this.getSignalValue(-1).intValue());
    }

    public ICarEvDevice.XDriveMode getXDriveMode() {
        return ICarEvDevice.XDriveMode.valueOf(this.getSignalValue(726).intValue());
    }

    public boolean isDischgActiveStateEnabled() {
        return this.getSignalValue(482).byteValue() == 1;
    }

    public boolean isDischgEngStartCfgEnabled() {
        return this.getSignalValue(478).byteValue() == 1;
    }

    public boolean isEngSelfMaintDispEnabled() {
        return this.getSignalValue(473).byteValue() == 1;
    }

    public boolean isIpedalCreepEnabled() {
        return this.getSignalValue(315).byteValue() == 1;
    }

    public boolean isVehRdyStateEnabled() {
        return this.getSignalValue(472).byteValue() == 1;
    }

    public void registerListener(CarEvDeviceListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setAvdcMode(ICarEvDevice.AvdcMode mode) {
        return this.setSignalValue(720, mode.value);
    }

    public boolean setChargCurrent(int val) {
        return this.setSignalValue(493, val);
    }

    public boolean setChargEnd(ICarEvDevice.ChargEnd state) {
        return this.setSignalValue(491, state.value);
    }

    public boolean setChargeSocPercent(ICarEvDevice.ChargeSocPercent percent) {
        return this.setSignalValue(0x13F, percent.value);
    }

    public boolean setChargeWarmTime(ICarEvDevice.ChargeWarmTime time) {
        return this.setSignalValue(322, time.value);
    }

    public boolean setDischgActiveStateEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(483, 1) : this.setSignalValue(483, 2);
    }

    public boolean setDischgEngStartCfg(ICarEvDevice.EngStartCfg cfg) {
        return this.setSignalValue(0x1DF, cfg.value);
    }

    public boolean setDischgSocCfg(int val) {
        return this.setSignalValue(481, val);
    }

    public boolean setDischgTimeCfg(int val) {
        return this.setSignalValue(486, val);
    }

    public boolean setDriveModeEv(ICarEvDevice.DriveModeEv mode) {
        return this.setSignalValue(356, mode.value);
    }

    public boolean setDrvTargetSOE(int val) {
        return this.setSignalValue(477, val);
    }

    public boolean setEcoPlusMode(ICarEvDevice.EcoPlusMode mode) {
        return this.setSignalValue(357, mode.value);
    }

    public boolean setEnergyModel(ICarEvDevice.EnergyModel mode) {
        return this.setSignalValue(475, mode.value);
    }

    public boolean setGasPedalLevel(ICarEvDevice.GasPedalLevel level) {
        return this.setSignalValue(722, level.value);
    }

    public boolean setIpedalCreepEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(316, 1) : this.setSignalValue(316, 2);
    }

    public boolean setPlugAutoUnlockCfg(ICarEvDevice.PlugAutoUnlockCfg cfg) {
        return this.setSignalValue(488, cfg.value);
    }

    public boolean setRecuperationLevel(ICarEvDevice.RecuperationLevel level) {
        return this.setSignalValue(353, level.value);
    }

    public boolean setRecuperationLevelA9E(ICarEvDevice.RecuperationLevelA9E level) {
        return this.setSignalValue(413, level.value);
    }

    public boolean setXDriveMode(ICarEvDevice.XDriveMode mode) {
        return this.setSignalValue(727, mode.value);
    }

    public void unregisterListener(CarEvDeviceListener listener) {
        this.unregisterReceiver(listener);
    }
}

