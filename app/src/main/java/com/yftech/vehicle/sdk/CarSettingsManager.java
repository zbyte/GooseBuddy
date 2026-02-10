package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.IBaseApi;
import com.yftech.vehicle.internal.adapter.IBaseApi.EnableState;
import com.yftech.vehicle.internal.adapter.IBaseApi.EnableStateOp;
import com.yftech.vehicle.internal.adapter.ICarSettings.ADASELKStatus;
import com.yftech.vehicle.internal.adapter.ICarSettings.ADASRAEBStatus;
import com.yftech.vehicle.internal.adapter.ICarSettings.ADASWarnType;
import com.yftech.vehicle.internal.adapter.ICarSettings.AutoWiperMode;
import com.yftech.vehicle.internal.adapter.ICarSettings.BSDMDowCtl;
import com.yftech.vehicle.internal.adapter.ICarSettings.BSDMDowState;
import com.yftech.vehicle.internal.adapter.ICarSettings.BSDMLcaCtl;
import com.yftech.vehicle.internal.adapter.ICarSettings.BSDMLcaState;
import com.yftech.vehicle.internal.adapter.ICarSettings.BSDMRctaAssistType;
import com.yftech.vehicle.internal.adapter.ICarSettings.BSDMRctaCtl;
import com.yftech.vehicle.internal.adapter.ICarSettings.BSDMRctaState;
import com.yftech.vehicle.internal.adapter.ICarSettings.BSDMRcwCtl;
import com.yftech.vehicle.internal.adapter.ICarSettings.BSDMRcwState;
import com.yftech.vehicle.internal.adapter.ICarSettings.ComfortParkState;
import com.yftech.vehicle.internal.adapter.ICarSettings.CruiseAssistMode;
import com.yftech.vehicle.internal.adapter.ICarSettings.DragMode;
import com.yftech.vehicle.internal.adapter.ICarSettings.EMSEngWaveStatus;
import com.yftech.vehicle.internal.adapter.ICarSettings.EPBSystemMsg;
import com.yftech.vehicle.internal.adapter.ICarSettings.EPBSystemSetState;
import com.yftech.vehicle.internal.adapter.ICarSettings.EPBSystemState;
import com.yftech.vehicle.internal.adapter.ICarSettings.ExhibitionHallMode;
import com.yftech.vehicle.internal.adapter.ICarSettings.FCTAConfig;
import com.yftech.vehicle.internal.adapter.ICarSettings.FCTASwitchStatus;
import com.yftech.vehicle.internal.adapter.ICarSettings.FCWSwitchEnableState;
import com.yftech.vehicle.internal.adapter.ICarSettings.FCWWarningDistance;
import com.yftech.vehicle.internal.adapter.ICarSettings.FaultStatus;
import com.yftech.vehicle.internal.adapter.ICarSettings.FrontWiperLevel;
import com.yftech.vehicle.internal.adapter.ICarSettings.FrontWiperMode;
import com.yftech.vehicle.internal.adapter.ICarSettings.HudMode;
import com.yftech.vehicle.internal.adapter.ICarSettings.HudOffState;
import com.yftech.vehicle.internal.adapter.ICarSettings.IMRCtrlErrorStatus;
import com.yftech.vehicle.internal.adapter.ICarSettings.IMRCtrlStatus;
import com.yftech.vehicle.internal.adapter.ICarSettings.LksMode;
import com.yftech.vehicle.internal.adapter.ICarSettings.LksState;
import com.yftech.vehicle.internal.adapter.ICarSettings.NapSettingSave;
import com.yftech.vehicle.internal.adapter.ICarSettings.OSRMRAngleCmd;
import com.yftech.vehicle.internal.adapter.ICarSettings.OSRMRAngleSaveCmd;
import com.yftech.vehicle.internal.adapter.ICarSettings.ParkAutoUnlockState;
import com.yftech.vehicle.internal.adapter.ICarSettings.RainstormMode;
import com.yftech.vehicle.internal.adapter.ICarSettings.RearSeatShortcutmode;
import com.yftech.vehicle.internal.adapter.ICarSettings.RearviewMirrorCmd;
import com.yftech.vehicle.internal.adapter.ICarSettings.RearviewMirrorCmdForReverse;
import com.yftech.vehicle.internal.adapter.ICarSettings.RearviewMirrorSettingCmd;
import com.yftech.vehicle.internal.adapter.ICarSettings.RearviewMirrorState;
import com.yftech.vehicle.internal.adapter.ICarSettings.SeatNapModeState;
import com.yftech.vehicle.internal.adapter.ICarSettings.SeatNapPosSaveReq;
import com.yftech.vehicle.internal.adapter.ICarSettings.SeatSpaModeState;
import com.yftech.vehicle.internal.adapter.ICarSettings.ShortcutMode;
import com.yftech.vehicle.internal.adapter.ICarSettings.StpOnBrkToRelParkBrkIndOnState;
import com.yftech.vehicle.internal.adapter.ICarSettings.WCLCMWorkMode;
import com.yftech.vehicle.internal.adapter.ICarSettings.WCLCMWorkModeCtl;
import com.yftech.vehicle.internal.adapter.ICarSettings.WCMCtl;
import com.yftech.vehicle.internal.adapter.ICarSettings.WCMCtlChargingState;
import com.yftech.vehicle.internal.adapter.ICarSettings.WCMCtlFailureState;
import com.yftech.vehicle.internal.adapter.ICarSettings.WCMCtlResult;
import com.yftech.vehicle.internal.adapter.ICarSettings;

public class CarSettingsManager extends BaseApiManager implements ICarSettings {
    public static abstract class CarSettingsListener {
        @SignalReceiver(signalId = 0x20E)
        public void onADASELKStatusChanged(ICarSettings.ADASELKStatus mode) {
        }

        @SignalReceiver(signalId = 618)
        public void onADASRAEBStatusChanged(ICarSettings.ADASRAEBStatus status) {
        }

        @SignalReceiver(signalId = 108)
        public void onADASWarnTypeChanged(ICarSettings.ADASWarnType type) {
        }

        @SignalReceiver(signalId = 103)
        public void onAEBOffEnableStateChanged(IBaseApi.EnableStateOp state) {
        }

        @SignalReceiver(signalId = 650)
        public void onAEBOffFaultStateChanged(ICarSettings.FaultStatus state) {
        }

        @SignalReceiver(signalId = 109)
        public void onAVASEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x1A0)
        public void onAcSmartChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x70)
        public void onAutoWiperModeChanged(ICarSettings.AutoWiperMode mode) {
        }

        @SignalReceiver(signalId = 454)
        public void onBSDMDowStateChanged(ICarSettings.BSDMDowState state) {
        }

        @SignalReceiver(signalId = 452)
        public void onBSDMLcaStateChanged(ICarSettings.BSDMLcaState state) {
        }

        @SignalReceiver(signalId = 458)
        public void onBSDMRctaAssistTypeChanged(ICarSettings.BSDMRctaAssistType type) {
        }

        @SignalReceiver(signalId = 456)
        public void onBSDMRctaStateChanged(ICarSettings.BSDMRctaState state) {
        }

        @SignalReceiver(signalId = 460)
        public void onBSDMRcwStateChanged(ICarSettings.BSDMRcwState state) {
        }

        @SignalReceiver(signalId = 414)
        public void onComfortParkStateChanged(ICarSettings.ComfortParkState state) {
        }

        @SignalReceiver(signalId = 0x10F)
        public void onCruiseAssistModeChanged(ICarSettings.CruiseAssistMode mode) {
        }

        @SignalReceiver(signalId = 423, valueToEnabledState = true)
        public void onDoorHandleElectricHideStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 332)
        public void onDragModeChanged(ICarSettings.DragMode mode) {
        }

        @SignalReceiver(signalId = 446, valueToEnabledState = true)
        public void onDriverEasyEntryAndExitStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 0x210)
        public void onEMSEngWaveStatusChanged(ICarSettings.EMSEngWaveStatus state) {
        }

        @SignalReceiver(signalId = 334)
        public void onEPBSystemMsgChanged(ICarSettings.EPBSystemMsg msg) {
        }

        @SignalReceiver(signalId = 330)
        public void onEPBSystemStateChanged(ICarSettings.EPBSystemState state) {
        }

        @SignalReceiver(signalId = 110)
        public void onETCEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 724)
        public void onExhibitionHallModeChanged(ICarSettings.ExhibitionHallMode mode) {
        }

        @SignalReceiver(signalId = 725, valueToEnabledState = true)
        public void onExhibitionHallModeStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 598)
        public void onFCTAConfigChanged(ICarSettings.FCTAConfig config) {
        }

        @SignalReceiver(signalId = 596)
        public void onFCTASwitchChanged(ICarSettings.FCTASwitchStatus state) {
        }

        @SignalReceiver(signalId = 101)
        public void onFCWOffEnableStateChanged(IBaseApi.EnableStateOp state) {
        }

        @SignalReceiver(signalId = 649)
        public void onFCWOffFaultStateChanged(ICarSettings.FaultStatus state) {
        }

        @SignalReceiver(signalId = 706)
        public void onFCWSwitchEnableStateChanged(ICarSettings.FCWSwitchEnableState state) {
        }

        @SignalReceiver(signalId = 102)
        public void onFCWWarningDistanceChanged(ICarSettings.FCWWarningDistance distance) {
        }

        @SignalReceiver(signalId = 0x10B)
        public void onFrontCarDistanceDisplayEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 717)
        public void onFrontWiperAutoConfigChanged(ICarSettings.FrontWiperLevel level) {
        }

        @SignalReceiver(signalId = 715)
        public void onFrontWiperIntConfigChanged(ICarSettings.FrontWiperLevel level) {
        }

        @SignalReceiver(signalId = 581)
        public void onFrontWiperModeChanged(ICarSettings.FrontWiperMode set) {
        }

        @SignalReceiver(signalId = 0x6F, valueToEnabledState = true)
        public void onFrontWiperServicePositionStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 585)
        public void onFrontWiperWasherChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 601)
        public void onHUDADASCruiseDisChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 603)
        public void onHUDADASTSRDisChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 605)
        public void onHUDNAVInfoChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 468)
        public void onHudAngleStChanged(int level) {
        }

        @SignalReceiver(signalId = 0x1D0)
        public void onHudBrightnessStChanged(int level) {
        }

        @SignalReceiver(signalId = 466)
        public void onHudHeightStChanged(int level) {
        }

        @SignalReceiver(signalId = 470)
        public void onHudModeChanged(ICarSettings.HudMode mode) {
        }

        @SignalReceiver(signalId = 462)
        public void onHudOffStateChanged(ICarSettings.HudOffState state) {
        }

        @SignalReceiver(signalId = 106)
        public void onIAccEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 594)
        public void onILCHWASwitchChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 622)
        public void onIMRCtrlErrorStatusChanged(ICarSettings.IMRCtrlErrorStatus status) {
        }

        @SignalReceiver(signalId = 620)
        public void onIMRCtrlStatusChanged(ICarSettings.IMRCtrlStatus status) {
        }

        @SignalReceiver(signalId = 0x10D)
        public void onIntelligentAvoidEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 362)
        public void onKeyNotforgetWarningEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 100)
        public void onLksModeChanged(ICarSettings.LksMode mode) {
        }

        @SignalReceiver(signalId = 99)
        public void onLksStateChanged(ICarSettings.LksState state) {
        }

        @SignalReceiver(signalId = 107)
        public void onOSRMAutoFoldEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 425)
        public void onOSRMRAngleCmdChanged(ICarSettings.OSRMRAngleCmd cmd) {
        }

        @SignalReceiver(signalId = 429)
        public void onOSRMRAngleHorizontalFLChanged(int percent) {
        }

        @SignalReceiver(signalId = 0x1AF)
        public void onOSRMRAngleHorizontalFRChanged(int percent) {
        }

        @SignalReceiver(signalId = 428)
        public void onOSRMRAngleVerticalFLChanged(int percent) {
        }

        @SignalReceiver(signalId = 430)
        public void onOSRMRAngleVerticalFRChanged(int percent) {
        }

        @SignalReceiver(signalId = 0x150)
        public void onParkAutoUnlockChanged(ICarSettings.ParkAutoUnlockState state) {
        }

        @SignalReceiver(signalId = 375)
        public void onPowerKeepRemindConfChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 374)
        public void onPowerKeepRemindReqChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 370)
        public void onPowerKeepReqChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 372)
        public void onPowerKeepReqVdChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 377)
        public void onPowerOffReqVdChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x22F)
        public void onRLSPABUttonStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 577)
        public void onRLSeatSpaModeStateChanged(ICarSettings.SeatSpaModeState state) {
        }

        @SignalReceiver(signalId = 540)
        public void onRLSeatWelcomeChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 560)
        public void onRRSPABUttonStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 578)
        public void onRRSeatSpaModeStateChanged(ICarSettings.SeatSpaModeState state) {
        }

        @SignalReceiver(signalId = 538)
        public void onRRSeatWelcomeChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x71)
        public void onRainstormModeChanged(ICarSettings.RainstormMode mode) {
        }

        @SignalReceiver(signalId = 583)
        public void onRearWiperChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 587)
        public void onRearWiperWasherChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 310)
        public void onRearviewMirrorCmdForReverseChanged(ICarSettings.RearviewMirrorCmdForReverse cmd) {
        }

        @SignalReceiver(signalId = 0xFC)
        public void onRearviewMirrorStateLChanged(ICarSettings.RearviewMirrorState state) {
        }

        @SignalReceiver(signalId = 0xFD)
        public void onRearviewMirrorStateRChanged(ICarSettings.RearviewMirrorState state) {
        }

        @SignalReceiver(signalId = 563)
        public void onSeatNapModePositionStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x240)
        public void onSeatNapModeStateChanged(ICarSettings.SeatNapModeState state) {
        }

        @SignalReceiver(signalId = 681)
        public void onSeatNapPosSaveReqChanged(ICarSettings.SeatNapPosSaveReq cmd) {
        }

        @SignalReceiver(signalId = 0x14F)
        public void onStpOnBrkToRelParkBrkIndOnStateChanged(ICarSettings.StpOnBrkToRelParkBrkIndOnState state) {
        }

        @SignalReceiver(signalId = 105)
        public void onTSRAudioWarningEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 104)
        public void onTSREnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 450)
        public void onWCLCMWorkModeChanged(ICarSettings.WCLCMWorkMode mode) {
        }

        @SignalReceiver(signalId = 0x203)
        public void onWCMCtlChargingStateChanged(ICarSettings.WCMCtlChargingState state) {
        }

        @SignalReceiver(signalId = 520, valueToEnabledState = true)
        public void onWCMCtlErrorStateStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 0x204)
        public void onWCMCtlFailureStateChanged(ICarSettings.WCMCtlFailureState state) {
        }

        @SignalReceiver(signalId = 0x207, valueToEnabledState = true)
        public void onWCMCtlPromptStateStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 0x1C0)
        public void onWCMCtlResultChanged(ICarSettings.WCMCtlResult res) {
        }

        @SignalReceiver(signalId = 0x27F)
        public void onWarnForcePowerOFFChanged(IBaseApi.EnableState state) {
        }
    }

    private static final String TAG = "CarSettingsManager";
    private static CarSettingsManager sMe;

    public static CarSettingsManager get() {
        CarSettingsManager carSettingsManager0;
        synchronized(CarSettingsManager.class) {
            if(CarSettingsManager.sMe == null) {
                carSettingsManager0 = new CarSettingsManager();
                CarSettingsManager.sMe = carSettingsManager0;
            }
            else {
                carSettingsManager0 = CarSettingsManager.sMe;
            }
            return carSettingsManager0;
        }
    }

    public ICarSettings.ADASELKStatus getADASELKStatus() {
        return ICarSettings.ADASELKStatus.valueOf(this.getSignalValue(0x20E).intValue());
    }

    public ICarSettings.ADASRAEBStatus getADASRAEBStatus() {
        return ICarSettings.ADASRAEBStatus.valueOf(this.getSignalValue(618).intValue());
    }

    public ICarSettings.ADASWarnType getADASWarnType() {
        return ICarSettings.ADASWarnType.valueOf(this.getSignalValue(108).intValue());
    }

    public IBaseApi.EnableStateOp getAEBOffEnableState() {
        return IBaseApi.EnableStateOp.valueOf(this.getSignalValue(103).intValue());
    }

    public ICarSettings.FaultStatus getAEBOffFaultState() {
        return ICarSettings.FaultStatus.valueOf(this.getSignalValue(650).intValue());
    }

    public IBaseApi.EnableState getAVASEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(109).intValue());
    }

    public IBaseApi.EnableState getAcSmart() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0x1A0).intValue());
    }

    public ICarSettings.AutoWiperMode getAutoWiperMode() {
        return ICarSettings.AutoWiperMode.valueOf(this.getSignalValue(0x70).intValue());
    }

    public ICarSettings.BSDMDowState getBSDMDowState() {
        return ICarSettings.BSDMDowState.valueOf(this.getSignalValue(454).intValue());
    }

    public ICarSettings.BSDMLcaState getBSDMLcaState() {
        return ICarSettings.BSDMLcaState.valueOf(this.getSignalValue(452).intValue());
    }

    public ICarSettings.BSDMRctaAssistType getBSDMRctaAssistType() {
        return ICarSettings.BSDMRctaAssistType.valueOf(this.getSignalValue(458).intValue());
    }

    public ICarSettings.BSDMRctaState getBSDMRctaState() {
        return ICarSettings.BSDMRctaState.valueOf(this.getSignalValue(456).intValue());
    }

    public ICarSettings.BSDMRcwState getBSDMRcwState() {
        return ICarSettings.BSDMRcwState.valueOf(this.getSignalValue(460).intValue());
    }

    public ICarSettings.ComfortParkState getComfortParkState() {
        return ICarSettings.ComfortParkState.valueOf(this.getSignalValue(414).intValue());
    }

    public ICarSettings.CruiseAssistMode getCruiseAssistMode() {
        return ICarSettings.CruiseAssistMode.valueOf(this.getSignalValue(0x10F).intValue());
    }

    public ICarSettings.DragMode getDragMode() {
        return ICarSettings.DragMode.valueOf(this.getSignalValue(332).intValue());
    }

    public ICarSettings.EMSEngWaveStatus getEMSEngWaveStatus() {
        return ICarSettings.EMSEngWaveStatus.valueOf(this.getSignalValue(0x210).intValue());
    }

    public ICarSettings.EPBSystemMsg getEPBSystemMsg() {
        return ICarSettings.EPBSystemMsg.valueOf(this.getSignalValue(334).intValue());
    }

    public ICarSettings.EPBSystemState getEPBSystemState() {
        return ICarSettings.EPBSystemState.valueOf(this.getSignalValue(330).intValue());
    }

    public IBaseApi.EnableState getETCEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(110).intValue());
    }

    public ICarSettings.ExhibitionHallMode getExhibitionHallMode() {
        return ICarSettings.ExhibitionHallMode.valueOf(this.getSignalValue(724).intValue());
    }

    public ICarSettings.FCTAConfig getFCTAConfig() {
        return ICarSettings.FCTAConfig.valueOf(this.getSignalValue(598).intValue());
    }

    public ICarSettings.FCTASwitchStatus getFCTASwitch() {
        return ICarSettings.FCTASwitchStatus.valueOf(this.getSignalValue(596).intValue());
    }

    public IBaseApi.EnableStateOp getFCWOffEnableState() {
        return IBaseApi.EnableStateOp.valueOf(this.getSignalValue(101).intValue());
    }

    public ICarSettings.FaultStatus getFCWOffFaultState() {
        return ICarSettings.FaultStatus.valueOf(this.getSignalValue(649).intValue());
    }

    public ICarSettings.FCWSwitchEnableState getFCWSwitchEnableState() {
        return ICarSettings.FCWSwitchEnableState.valueOf(this.getSignalValue(706).intValue());
    }

    public ICarSettings.FCWWarningDistance getFCWWarningDistance() {
        return ICarSettings.FCWWarningDistance.valueOf(this.getSignalValue(102).intValue());
    }

    public IBaseApi.EnableState getFrontCarDistanceDisplayEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0x10B).intValue());
    }

    public ICarSettings.FrontWiperLevel getFrontWiperAutoConfig() {
        return ICarSettings.FrontWiperLevel.valueOf(this.getSignalValue(717).intValue());
    }

    public ICarSettings.FrontWiperLevel getFrontWiperIntConfig() {
        return ICarSettings.FrontWiperLevel.valueOf(this.getSignalValue(715).intValue());
    }

    public ICarSettings.FrontWiperMode getFrontWiperMode() {
        return ICarSettings.FrontWiperMode.valueOf(this.getSignalValue(581).intValue());
    }

    public IBaseApi.EnableState getFrontWiperWasher() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(585).intValue());
    }

    public IBaseApi.EnableState getHUDADASCruiseDis() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(601).intValue());
    }

    public IBaseApi.EnableState getHUDADASTSRDis() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(603).intValue());
    }

    public IBaseApi.EnableState getHUDNAVInfo() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(605).intValue());
    }

    public int getHudAngleSt() {
        return this.getSignalValue(468).intValue();
    }

    public int getHudBrightnessSt() {
        return this.getSignalValue(0x1D0).intValue();
    }

    public int getHudHeightSt() {
        return this.getSignalValue(466).intValue();
    }

    public ICarSettings.HudMode getHudMode() {
        return ICarSettings.HudMode.valueOf(this.getSignalValue(470).intValue());
    }

    public ICarSettings.HudOffState getHudOffState() {
        return ICarSettings.HudOffState.valueOf(this.getSignalValue(462).intValue());
    }

    public IBaseApi.EnableState getIAccEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(106).intValue());
    }

    public IBaseApi.EnableState getILCHWASwitch() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(594).intValue());
    }

    public ICarSettings.IMRCtrlErrorStatus getIMRCtrlErrorStatus() {
        return ICarSettings.IMRCtrlErrorStatus.valueOf(this.getSignalValue(622).intValue());
    }

    public ICarSettings.IMRCtrlStatus getIMRCtrlStatus() {
        return ICarSettings.IMRCtrlStatus.valueOf(this.getSignalValue(620).intValue());
    }

    public IBaseApi.EnableState getIntelligentAvoidEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0x10D).intValue());
    }

    public IBaseApi.EnableState getKeyNotforgetWarningEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(362).intValue());
    }

    public ICarSettings.LksMode getLksMode() {
        return ICarSettings.LksMode.valueOf(this.getSignalValue(100).intValue());
    }

    public ICarSettings.LksState getLksState() {
        return ICarSettings.LksState.valueOf(this.getSignalValue(99).intValue());
    }

    public IBaseApi.EnableState getOSRMAutoFoldEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(107).intValue());
    }

    public ICarSettings.OSRMRAngleCmd getOSRMRAngleCmd() {
        return ICarSettings.OSRMRAngleCmd.valueOf(this.getSignalValue(425).intValue());
    }

    public int getOSRMRAngleHorizontalFL() {
        return this.getSignalValue(429).intValue();
    }

    public int getOSRMRAngleHorizontalFR() {
        return this.getSignalValue(0x1AF).intValue();
    }

    public int getOSRMRAngleVerticalFL() {
        return this.getSignalValue(428).intValue();
    }

    public int getOSRMRAngleVerticalFR() {
        return this.getSignalValue(430).intValue();
    }

    public ICarSettings.ParkAutoUnlockState getParkAutoUnlock() {
        return ICarSettings.ParkAutoUnlockState.valueOf(this.getSignalValue(0x150).intValue());
    }

    public IBaseApi.EnableState getPowerKeepRemindConf() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(375).intValue());
    }

    public IBaseApi.EnableState getPowerKeepRemindReq() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(374).intValue());
    }

    public IBaseApi.EnableState getPowerKeepReq() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(370).intValue());
    }

    public IBaseApi.EnableState getPowerKeepReqVd() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(372).intValue());
    }

    public IBaseApi.EnableState getPowerOffReqVd() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(377).intValue());
    }

    public IBaseApi.EnableState getRLSPABUttonState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0x22F).intValue());
    }

    public ICarSettings.SeatSpaModeState getRLSeatSpaModeState() {
        return ICarSettings.SeatSpaModeState.valueOf(this.getSignalValue(577).intValue());
    }

    public IBaseApi.EnableState getRLSeatWelcome() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(540).intValue());
    }

    public IBaseApi.EnableState getRRSPABUttonState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(560).intValue());
    }

    public ICarSettings.SeatSpaModeState getRRSeatSpaModeState() {
        return ICarSettings.SeatSpaModeState.valueOf(this.getSignalValue(578).intValue());
    }

    public IBaseApi.EnableState getRRSeatWelcome() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(538).intValue());
    }

    public ICarSettings.RainstormMode getRainstormMode() {
        return ICarSettings.RainstormMode.valueOf(this.getSignalValue(0x71).intValue());
    }

    public IBaseApi.EnableState getRearWiper() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(583).intValue());
    }

    public IBaseApi.EnableState getRearWiperWasher() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(587).intValue());
    }

    public ICarSettings.RearviewMirrorCmdForReverse getRearviewMirrorCmdForReverse() {
        return ICarSettings.RearviewMirrorCmdForReverse.valueOf(this.getSignalValue(310).intValue());
    }

    public ICarSettings.RearviewMirrorState getRearviewMirrorStateL() {
        return ICarSettings.RearviewMirrorState.valueOf(this.getSignalValue(0xFC).intValue());
    }

    public ICarSettings.RearviewMirrorState getRearviewMirrorStateR() {
        return ICarSettings.RearviewMirrorState.valueOf(this.getSignalValue(0xFD).intValue());
    }

    public IBaseApi.EnableState getSeatNapModePositionState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(563).intValue());
    }

    public ICarSettings.SeatNapModeState getSeatNapModeState() {
        return ICarSettings.SeatNapModeState.valueOf(this.getSignalValue(0x240).intValue());
    }

    public ICarSettings.SeatNapPosSaveReq getSeatNapPosSaveReq() {
        return ICarSettings.SeatNapPosSaveReq.valueOf(this.getSignalValue(681).intValue());
    }

    public ICarSettings.StpOnBrkToRelParkBrkIndOnState getStpOnBrkToRelParkBrkIndOnState() {
        return ICarSettings.StpOnBrkToRelParkBrkIndOnState.valueOf(this.getSignalValue(0x14F).intValue());
    }

    public IBaseApi.EnableState getTSRAudioWarningEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(105).intValue());
    }

    public IBaseApi.EnableState getTSREnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(104).intValue());
    }

    public ICarSettings.WCLCMWorkMode getWCLCMWorkMode() {
        return ICarSettings.WCLCMWorkMode.valueOf(this.getSignalValue(450).intValue());
    }

    public ICarSettings.WCMCtlChargingState getWCMCtlChargingState() {
        return ICarSettings.WCMCtlChargingState.valueOf(this.getSignalValue(0x203).intValue());
    }

    public ICarSettings.WCMCtlFailureState getWCMCtlFailureState() {
        return ICarSettings.WCMCtlFailureState.valueOf(this.getSignalValue(0x204).intValue());
    }

    public ICarSettings.WCMCtlResult getWCMCtlResult() {
        return ICarSettings.WCMCtlResult.valueOf(this.getSignalValue(0x1C0).intValue());
    }

    public IBaseApi.EnableState getWarnForcePowerOFF() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0x27F).intValue());
    }

    public boolean isDoorHandleElectricHideEnabled() {
        return this.getSignalValue(423).byteValue() == 1;
    }

    public boolean isDriverEasyEntryAndExitEnabled() {
        return this.getSignalValue(446).byteValue() == 1;
    }

    public boolean isExhibitionHallModeEnabled() {
        return this.getSignalValue(725).byteValue() == 1;
    }

    public boolean isFrontWiperServicePositionEnabled() {
        return this.getSignalValue(0x6F).byteValue() == 1;
    }

    public boolean isWCMCtlErrorStateEnabled() {
        return this.getSignalValue(520).byteValue() == 1;
    }

    public boolean isWCMCtlPromptStateEnabled() {
        return this.getSignalValue(0x207).byteValue() == 1;
    }

    public boolean performFrontWiperServicePositionButtonClick() {
        return this.setSignalValue(44, 1);
    }

    public void registerListener(CarSettingsListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setADASELKEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(0x20F, 2) : this.setSignalValue(0x20F, 1);
    }

    public boolean setADASRAEBStatusEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(617, 2) : this.setSignalValue(617, 1);
    }

    public boolean setADASWarnType(ICarSettings.ADASWarnType type) {
        return this.setSignalValue(41, type.value);
    }

    public boolean setAEBOffEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(36, 1) : this.setSignalValue(36, 2);
    }

    public boolean setAVASEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(42, 2) : this.setSignalValue(42, 1);
    }

    public boolean setAcSmartEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(417, 2) : this.setSignalValue(417, 1);
    }

    public boolean setAutoWiperMode(ICarSettings.AutoWiperMode mode) {
        return this.setSignalValue(45, mode.value);
    }

    public boolean setBSDMDowCtl(ICarSettings.BSDMDowCtl ctl) {
        return this.setSignalValue(455, ctl.value);
    }

    public boolean setBSDMLcaCtl(ICarSettings.BSDMLcaCtl ctl) {
        return this.setSignalValue(453, ctl.value);
    }

    public boolean setBSDMRctaAssistType(ICarSettings.BSDMRctaAssistType type) {
        return this.setSignalValue(459, type.value);
    }

    public boolean setBSDMRctaCtl(ICarSettings.BSDMRctaCtl ctl) {
        return this.setSignalValue(457, ctl.value);
    }

    public boolean setBSDMRcwCtl(ICarSettings.BSDMRcwCtl ctl) {
        return this.setSignalValue(461, ctl.value);
    }

    public boolean setComfortParkStateEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(418, 2) : this.setSignalValue(418, 1);
    }

    public boolean setCruiseAssistMode(ICarSettings.CruiseAssistMode mode) {
        return this.setSignalValue(0x110, mode.value);
    }

    public boolean setDoorHandleElectricHideEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(424, 2) : this.setSignalValue(424, 1);
    }

    public boolean setDragModeEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(333, 1) : this.setSignalValue(333, 2);
    }

    public boolean setDriverEasyEntryAndExitEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(0x1BF, 2) : this.setSignalValue(0x1BF, 1);
    }

    public boolean setEMSEngWaveEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(529, 2) : this.setSignalValue(529, 1);
    }

    public boolean setEPBSystemSetState(ICarSettings.EPBSystemSetState state) {
        return this.setSignalValue(331, state.value);
    }

    public boolean setETCEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(43, 2) : this.setSignalValue(43, 1);
    }

    public boolean setExhibitionHallMode(ICarSettings.ExhibitionHallMode mode) {
        return this.setSignalValue(723, mode.value);
    }

    public boolean setFCTAConfig(ICarSettings.FCTAConfig config) {
        return this.setSignalValue(599, config.value);
    }

    public boolean setFCTASwitchEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(597, 2) : this.setSignalValue(597, 1);
    }

    public boolean setFCWOffEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(34, 1) : this.setSignalValue(34, 2);
    }

    public boolean setFCWWarningDistance(ICarSettings.FCWWarningDistance distance) {
        return this.setSignalValue(35, distance.value);
    }

    public boolean setFrontCarDistanceDisplayEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(0x10C, 2) : this.setSignalValue(0x10C, 1);
    }

    public boolean setFrontWiperAutoConfig(ICarSettings.FrontWiperLevel level) {
        return this.setSignalValue(716, level.value);
    }

    public boolean setFrontWiperIntConfig(ICarSettings.FrontWiperLevel level) {
        return this.setSignalValue(714, level.value);
    }

    public boolean setFrontWiperMode(ICarSettings.FrontWiperMode set) {
        return this.setSignalValue(580, set.value);
    }

    public boolean setFrontWiperWasherEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(584, 2) : this.setSignalValue(584, 1);
    }

    public boolean setHUDADASCruiseDisEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(600, 2) : this.setSignalValue(600, 1);
    }

    public boolean setHUDADASTSRDisEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(602, 2) : this.setSignalValue(602, 1);
    }

    public boolean setHUDNAVInfoEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(604, 2) : this.setSignalValue(604, 1);
    }

    public boolean setHudAngleSt(int level) {
        return this.setSignalValue(469, level);
    }

    public boolean setHudBrightnessSt(int level) {
        return this.setSignalValue(465, level);
    }

    public boolean setHudHeightSt(int level) {
        return this.setSignalValue(467, level);
    }

    public boolean setHudMode(ICarSettings.HudMode mode) {
        return this.setSignalValue(471, mode.value);
    }

    public boolean setHudOffState(ICarSettings.HudOffState state) {
        return this.setSignalValue(0x1CF, state.value);
    }

    public boolean setIAccEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(39, 2) : this.setSignalValue(39, 1);
    }

    public boolean setILCHWASwitchEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(595, 2) : this.setSignalValue(595, 1);
    }

    public boolean setIMRCtrlStatus(ICarSettings.IMRCtrlStatus control) {
        return this.setSignalValue(621, control.value);
    }

    public boolean setIMRCtrlStatusA60(ICarSettings.IMRCtrlStatus control) {
        return this.setSignalValue(625, control.value);
    }

    public boolean setIntelligentAvoidEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(270, 2) : this.setSignalValue(270, 1);
    }

    public boolean setKeyNotforgetWarningEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(363, 2) : this.setSignalValue(363, 1);
    }

    public boolean setLdwLkaEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(0x20, 2) : this.setSignalValue(0x20, 1);
    }

    public boolean setLksMode(ICarSettings.LksMode mode) {
        return this.setSignalValue(33, mode.value);
    }

    public boolean setOSRMAutoFoldEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(40, 2) : this.setSignalValue(40, 1);
    }

    public boolean setOSRMRAngleCmd(ICarSettings.OSRMRAngleCmd cmd) {
        return this.setSignalValue(426, cmd.value);
    }

    public boolean setOSRMRAngleSaveCmd(ICarSettings.OSRMRAngleSaveCmd cmd) {
        return this.setSignalValue(427, cmd.value);
    }

    public boolean setParkAutoUnlock(ICarSettings.ParkAutoUnlockState state) {
        return this.setSignalValue(337, state.value);
    }

    public boolean setPowerKeepRemindConfEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(376, 2) : this.setSignalValue(376, 1);
    }

    public boolean setPowerKeepReqEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(371, 2) : this.setSignalValue(371, 1);
    }

    public boolean setPowerKeepReqVdSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(373, 1) : this.setSignalValue(373, 0);
    }

    public boolean setPowerOffReqSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(379, 1) : this.setSignalValue(379, 0);
    }

    public boolean setPowerOffReqVdSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(378, 1) : this.setSignalValue(378, 0);
    }

    public boolean setRLSeatWelcomeEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(541, 2) : this.setSignalValue(541, 1);
    }

    public boolean setRRSeatWelcomeEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(539, 2) : this.setSignalValue(539, 1);
    }

    public boolean setRainstormMode(ICarSettings.ShortcutMode mode) {
        return this.setSignalValue(46, mode.value);
    }

    public boolean setRearWiperEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(582, 2) : this.setSignalValue(582, 1);
    }

    public boolean setRearWiperWasherEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(586, 2) : this.setSignalValue(586, 1);
    }

    public boolean setRearviewMirrorCmd(ICarSettings.RearviewMirrorCmd cmd) {
        return this.setSignalValue(0xFB, cmd.value);
    }

    public boolean setRearviewMirrorCmdForReverse(ICarSettings.RearviewMirrorCmdForReverse cmd) {
        return this.setSignalValue(311, cmd.value);
    }

    public boolean setRearviewMirrorCmdVdSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(309, 1) : this.setSignalValue(309, 0);
    }

    public boolean setRearviewMirrorSettingCmd(ICarSettings.RearviewMirrorSettingCmd cmd) {
        return this.setSignalValue(312, cmd.value);
    }

    public boolean setSCMNapSettingSave(ICarSettings.NapSettingSave set) {
        return this.setSignalValue(562, set.value);
    }

    public boolean setSCMNapSettingSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(561, 1) : this.setSignalValue(561, 0);
    }

    public boolean setSCMRearSeatShortcutmode(ICarSettings.RearSeatShortcutmode set) {
        return this.setSignalValue(579, set.value);
    }

    public boolean setTSRAudioWarningEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(38, 2) : this.setSignalValue(38, 1);
    }

    public boolean setTSREnabled(boolean enabled) {
        return enabled ? this.setSignalValue(37, 2) : this.setSignalValue(37, 1);
    }

    public boolean setWCLCMWorkModeCtl(ICarSettings.WCLCMWorkModeCtl ctl) {
        return this.setSignalValue(451, ctl.value);
    }

    public boolean setWCMCtl(ICarSettings.WCMCtl ctl) {
        return this.setSignalValue(449, ctl.value);
    }

    public void unregisterListener(CarSettingsListener listener) {
        this.unregisterReceiver(listener);
    }
}

