package com.yftech.vehicle.internal.adapter;

public interface ICarSettings extends IBaseApi {
    public static enum ADASELKStatus {
        OFF(0),
        PASSIVE(1),
        ACTIVE(2),
        FAILURE(3),
        __UNKNOWN__(-1);

        public final int value;

        private ADASELKStatus(int v1) {
            this.value = v1;
        }

        public static ADASELKStatus valueOf(int v) {
            if(v == ADASELKStatus.OFF.value) {
                return ADASELKStatus.OFF;
            }
            if(v == ADASELKStatus.PASSIVE.value) {
                return ADASELKStatus.PASSIVE;
            }
            if(v == ADASELKStatus.ACTIVE.value) {
                return ADASELKStatus.ACTIVE;
            }
            return v == ADASELKStatus.FAILURE.value ? ADASELKStatus.FAILURE : ADASELKStatus.__UNKNOWN__;
        }
    }

    public static enum ADASRAEBStatus {
        OFF(0),
        ENABLE(1),
        ACTIVE(2),
        FAILURE(3),
        __UNKNOWN__(-1);

        public final int value;

        private ADASRAEBStatus(int v1) {
            this.value = v1;
        }

        public static ADASRAEBStatus valueOf(int v) {
            if(v == ADASRAEBStatus.OFF.value) {
                return ADASRAEBStatus.OFF;
            }
            if(v == ADASRAEBStatus.ENABLE.value) {
                return ADASRAEBStatus.ENABLE;
            }
            if(v == ADASRAEBStatus.ACTIVE.value) {
                return ADASRAEBStatus.ACTIVE;
            }
            return v == ADASRAEBStatus.FAILURE.value ? ADASRAEBStatus.FAILURE : ADASRAEBStatus.__UNKNOWN__;
        }
    }

    public static enum ADASWarnType {
        SOUND(0, 1),
        SEAT_VIBRATION(1, 2),
        BOTH(2, 3),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private ADASWarnType(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static ADASWarnType valueOf(int v) {
            if(v == ADASWarnType.SOUND.rx) {
                return ADASWarnType.SOUND;
            }
            if(v == ADASWarnType.SEAT_VIBRATION.rx) {
                return ADASWarnType.SEAT_VIBRATION;
            }
            return v == ADASWarnType.BOTH.rx ? ADASWarnType.BOTH : ADASWarnType.__UNKNOWN__;
        }
    }

    public static enum AutoWiperMode {
        INTERMITTENT(0, 1),
        AUTO(1, 2),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private AutoWiperMode(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static AutoWiperMode valueOf(int v) {
            if(v == AutoWiperMode.INTERMITTENT.rx) {
                return AutoWiperMode.INTERMITTENT;
            }
            return v == AutoWiperMode.AUTO.rx ? AutoWiperMode.AUTO : AutoWiperMode.__UNKNOWN__;
        }
    }

    public static enum BSDMDowCtl {
        ON(1),
        OFF(2),
        __UNKNOWN__(-1);

        public final int value;

        private BSDMDowCtl(int v1) {
            this.value = v1;
        }

        public static BSDMDowCtl valueOf(int v) {
            if(v == BSDMDowCtl.ON.value) {
                return BSDMDowCtl.ON;
            }
            return v == BSDMDowCtl.OFF.value ? BSDMDowCtl.OFF : BSDMDowCtl.__UNKNOWN__;
        }
    }

    public static enum BSDMDowState {
        OFF(0),
        PASSIVE(1),
        ACTIVE(2),
        FAILURE(3),
        __UNKNOWN__(-1);

        public final int value;

        private BSDMDowState(int v1) {
            this.value = v1;
        }

        public static BSDMDowState valueOf(int v) {
            if(v == BSDMDowState.OFF.value) {
                return BSDMDowState.OFF;
            }
            if(v == BSDMDowState.PASSIVE.value) {
                return BSDMDowState.PASSIVE;
            }
            if(v == BSDMDowState.ACTIVE.value) {
                return BSDMDowState.ACTIVE;
            }
            return v == BSDMDowState.FAILURE.value ? BSDMDowState.FAILURE : BSDMDowState.__UNKNOWN__;
        }
    }

    public static enum BSDMLcaCtl {
        ON(1),
        OFF(2),
        __UNKNOWN__(-1);

        public final int value;

        private BSDMLcaCtl(int v1) {
            this.value = v1;
        }

        public static BSDMLcaCtl valueOf(int v) {
            if(v == BSDMLcaCtl.ON.value) {
                return BSDMLcaCtl.ON;
            }
            return v == BSDMLcaCtl.OFF.value ? BSDMLcaCtl.OFF : BSDMLcaCtl.__UNKNOWN__;
        }
    }

    public static enum BSDMLcaState {
        OFF(0),
        PASSIVE(1),
        ACTIVE(2),
        FAILURE(3),
        __UNKNOWN__(-1);

        public final int value;

        private BSDMLcaState(int v1) {
            this.value = v1;
        }

        public static BSDMLcaState valueOf(int v) {
            if(v == BSDMLcaState.OFF.value) {
                return BSDMLcaState.OFF;
            }
            if(v == BSDMLcaState.PASSIVE.value) {
                return BSDMLcaState.PASSIVE;
            }
            if(v == BSDMLcaState.ACTIVE.value) {
                return BSDMLcaState.ACTIVE;
            }
            return v == BSDMLcaState.FAILURE.value ? BSDMLcaState.FAILURE : BSDMLcaState.__UNKNOWN__;
        }
    }

    public static enum BSDMRctaAssistType {
        NO_SELECTED(0),
        BRAKE(1),
        WARNING(2),
        BRAKE_AND_WARNING(3),
        __UNKNOWN__(-1);

        public final int value;

        private BSDMRctaAssistType(int v1) {
            this.value = v1;
        }

        public static BSDMRctaAssistType valueOf(int v) {
            if(v == BSDMRctaAssistType.NO_SELECTED.value) {
                return BSDMRctaAssistType.NO_SELECTED;
            }
            if(v == BSDMRctaAssistType.BRAKE.value) {
                return BSDMRctaAssistType.BRAKE;
            }
            if(v == BSDMRctaAssistType.WARNING.value) {
                return BSDMRctaAssistType.WARNING;
            }
            return v == BSDMRctaAssistType.BRAKE_AND_WARNING.value ? BSDMRctaAssistType.BRAKE_AND_WARNING : BSDMRctaAssistType.__UNKNOWN__;
        }
    }

    public static enum BSDMRctaCtl {
        ON(1),
        OFF(2),
        __UNKNOWN__(-1);

        public final int value;

        private BSDMRctaCtl(int v1) {
            this.value = v1;
        }

        public static BSDMRctaCtl valueOf(int v) {
            if(v == BSDMRctaCtl.ON.value) {
                return BSDMRctaCtl.ON;
            }
            return v == BSDMRctaCtl.OFF.value ? BSDMRctaCtl.OFF : BSDMRctaCtl.__UNKNOWN__;
        }
    }

    public static enum BSDMRctaState {
        OFF(0),
        PASSIVE(1),
        ACTIVE(2),
        FAILURE(3),
        __UNKNOWN__(-1);

        public final int value;

        private BSDMRctaState(int v1) {
            this.value = v1;
        }

        public static BSDMRctaState valueOf(int v) {
            if(v == BSDMRctaState.OFF.value) {
                return BSDMRctaState.OFF;
            }
            if(v == BSDMRctaState.PASSIVE.value) {
                return BSDMRctaState.PASSIVE;
            }
            if(v == BSDMRctaState.ACTIVE.value) {
                return BSDMRctaState.ACTIVE;
            }
            return v == BSDMRctaState.FAILURE.value ? BSDMRctaState.FAILURE : BSDMRctaState.__UNKNOWN__;
        }
    }

    public static enum BSDMRcwCtl {
        NOT_ACTIVE(1),
        ACTIVE(2),
        __UNKNOWN__(-1);

        public final int value;

        private BSDMRcwCtl(int v1) {
            this.value = v1;
        }

        public static BSDMRcwCtl valueOf(int v) {
            if(v == BSDMRcwCtl.NOT_ACTIVE.value) {
                return BSDMRcwCtl.NOT_ACTIVE;
            }
            return v == BSDMRcwCtl.ACTIVE.value ? BSDMRcwCtl.ACTIVE : BSDMRcwCtl.__UNKNOWN__;
        }
    }

    public static enum BSDMRcwState {
        OFF(0),
        PASSIVE(1),
        ACTIVE(2),
        FAILURE(3),
        __UNKNOWN__(-1);

        public final int value;

        private BSDMRcwState(int v1) {
            this.value = v1;
        }

        public static BSDMRcwState valueOf(int v) {
            if(v == BSDMRcwState.OFF.value) {
                return BSDMRcwState.OFF;
            }
            if(v == BSDMRcwState.PASSIVE.value) {
                return BSDMRcwState.PASSIVE;
            }
            if(v == BSDMRcwState.ACTIVE.value) {
                return BSDMRcwState.ACTIVE;
            }
            return v == BSDMRcwState.FAILURE.value ? BSDMRcwState.FAILURE : BSDMRcwState.__UNKNOWN__;
        }
    }

    public static enum ComfortParkState {
        CST_DISABLED(0),
        CST_STANDBY(1),
        CST_ACTIVE(2),
        CST_FAILURE(3),
        CST_LEVEL_4(4),
        __UNKNOWN__(-1);

        public final int value;

        private ComfortParkState(int v1) {
            this.value = v1;
        }

        public static ComfortParkState valueOf(int v) {
            if(v == ComfortParkState.CST_DISABLED.value) {
                return ComfortParkState.CST_DISABLED;
            }
            if(v == ComfortParkState.CST_STANDBY.value) {
                return ComfortParkState.CST_STANDBY;
            }
            if(v == ComfortParkState.CST_ACTIVE.value) {
                return ComfortParkState.CST_ACTIVE;
            }
            if(v == ComfortParkState.CST_FAILURE.value) {
                return ComfortParkState.CST_FAILURE;
            }
            return v == ComfortParkState.CST_LEVEL_4.value ? ComfortParkState.CST_LEVEL_4 : ComfortParkState.__UNKNOWN__;
        }
    }

    public static enum CruiseAssistMode {
        ACC_MODE(1),
        TJA_ICA_MODE(2),
        __UNKNOWN__(-1);

        public final int value;

        private CruiseAssistMode(int v1) {
            this.value = v1;
        }

        public static CruiseAssistMode valueOf(int v) {
            if(v == CruiseAssistMode.ACC_MODE.value) {
                return CruiseAssistMode.ACC_MODE;
            }
            return v == CruiseAssistMode.TJA_ICA_MODE.value ? CruiseAssistMode.TJA_ICA_MODE : CruiseAssistMode.__UNKNOWN__;
        }
    }

    public static enum DragMode {
        OFF(0),
        OPEN(1),
        DEEPPUSHBRKPEDAL_TO_N(2),
        FAILURE(3),
        __UNKNOWN__(-1);

        public final int value;

        private DragMode(int v1) {
            this.value = v1;
        }

        public static DragMode valueOf(int v) {
            if(v == DragMode.OFF.value) {
                return DragMode.OFF;
            }
            if(v == DragMode.OPEN.value) {
                return DragMode.OPEN;
            }
            if(v == DragMode.DEEPPUSHBRKPEDAL_TO_N.value) {
                return DragMode.DEEPPUSHBRKPEDAL_TO_N;
            }
            return v == DragMode.FAILURE.value ? DragMode.FAILURE : DragMode.__UNKNOWN__;
        }
    }

    public static enum EMSEngWaveStatus {
        INVALID(0),
        OFF(1),
        ON(2),
        EAV_BLOCK_ERROR(3),
        __UNKNOWN__(-1);

        public final int value;

        private EMSEngWaveStatus(int v1) {
            this.value = v1;
        }

        public static EMSEngWaveStatus valueOf(int v) {
            if(v == EMSEngWaveStatus.INVALID.value) {
                return EMSEngWaveStatus.INVALID;
            }
            if(v == EMSEngWaveStatus.OFF.value) {
                return EMSEngWaveStatus.OFF;
            }
            if(v == EMSEngWaveStatus.ON.value) {
                return EMSEngWaveStatus.ON;
            }
            return v == EMSEngWaveStatus.EAV_BLOCK_ERROR.value ? EMSEngWaveStatus.EAV_BLOCK_ERROR : EMSEngWaveStatus.__UNKNOWN__;
        }
    }

    public static enum EPBSystemMsg {
        OFF(0),
        FASTEN_SEATBELT(1),
        RELEASE_PARK_BRAKE(2),
        CHECK_PARK_BRAKE_LOW_GRADIENT(3),
        PARK_BRAKE_SET(4),
        PARK_BRAKE_RELEASED(5),
        PARK_BRAKE_TESTING(6),
        CLAMPFORCE_NOT_ENOUGH(7),
        NON_P_TO_RELEASE_PARK_BRAKE(8),
        __UNKNOWN__(-1);

        public final int value;

        private EPBSystemMsg(int v1) {
            this.value = v1;
        }

        public static EPBSystemMsg valueOf(int v) {
            if(v == EPBSystemMsg.OFF.value) {
                return EPBSystemMsg.OFF;
            }
            if(v == EPBSystemMsg.FASTEN_SEATBELT.value) {
                return EPBSystemMsg.FASTEN_SEATBELT;
            }
            if(v == EPBSystemMsg.RELEASE_PARK_BRAKE.value) {
                return EPBSystemMsg.RELEASE_PARK_BRAKE;
            }
            if(v == EPBSystemMsg.CHECK_PARK_BRAKE_LOW_GRADIENT.value) {
                return EPBSystemMsg.CHECK_PARK_BRAKE_LOW_GRADIENT;
            }
            if(v == EPBSystemMsg.PARK_BRAKE_SET.value) {
                return EPBSystemMsg.PARK_BRAKE_SET;
            }
            if(v == EPBSystemMsg.PARK_BRAKE_RELEASED.value) {
                return EPBSystemMsg.PARK_BRAKE_RELEASED;
            }
            if(v == EPBSystemMsg.PARK_BRAKE_TESTING.value) {
                return EPBSystemMsg.PARK_BRAKE_TESTING;
            }
            if(v == EPBSystemMsg.CLAMPFORCE_NOT_ENOUGH.value) {
                return EPBSystemMsg.CLAMPFORCE_NOT_ENOUGH;
            }
            return v == EPBSystemMsg.NON_P_TO_RELEASE_PARK_BRAKE.value ? EPBSystemMsg.NON_P_TO_RELEASE_PARK_BRAKE : EPBSystemMsg.__UNKNOWN__;
        }
    }

    public static enum EPBSystemSetState {
        RELEASE(1),
        APPLY(2),
        UNUSABLE(3),
        __UNKNOWN__(-1);

        public final int value;

        private EPBSystemSetState(int v1) {
            this.value = v1;
        }

        public static EPBSystemSetState valueOf(int v) {
            if(v == EPBSystemSetState.RELEASE.value) {
                return EPBSystemSetState.RELEASE;
            }
            if(v == EPBSystemSetState.APPLY.value) {
                return EPBSystemSetState.APPLY;
            }
            return v == EPBSystemSetState.UNUSABLE.value ? EPBSystemSetState.UNUSABLE : EPBSystemSetState.__UNKNOWN__;
        }
    }

    public static enum EPBSystemState {
        RELEASE(0),
        APPLY(1),
        RELEASING(2),
        APPLYING(3),
        DISENGAGED(4),
        FAULT(7),
        __UNKNOWN__(-1);

        public final int value;

        private EPBSystemState(int v1) {
            this.value = v1;
        }

        public static EPBSystemState valueOf(int v) {
            if(v == EPBSystemState.RELEASE.value) {
                return EPBSystemState.RELEASE;
            }
            if(v == EPBSystemState.APPLY.value) {
                return EPBSystemState.APPLY;
            }
            if(v == EPBSystemState.RELEASING.value) {
                return EPBSystemState.RELEASING;
            }
            if(v == EPBSystemState.APPLYING.value) {
                return EPBSystemState.APPLYING;
            }
            if(v == EPBSystemState.DISENGAGED.value) {
                return EPBSystemState.DISENGAGED;
            }
            return v == EPBSystemState.FAULT.value ? EPBSystemState.FAULT : EPBSystemState.__UNKNOWN__;
        }
    }

    public static enum ExhibitionHallMode {
        DEFAULT(0),
        NORMAL_MODE(1),
        TRANSPORT_MODE(2),
        SHOWROOM_MODE(3),
        __UNKNOWN__(-1);

        public final int value;

        private ExhibitionHallMode(int v1) {
            this.value = v1;
        }

        public static ExhibitionHallMode valueOf(int v) {
            if(v == ExhibitionHallMode.DEFAULT.value) {
                return ExhibitionHallMode.DEFAULT;
            }
            if(v == ExhibitionHallMode.NORMAL_MODE.value) {
                return ExhibitionHallMode.NORMAL_MODE;
            }
            if(v == ExhibitionHallMode.TRANSPORT_MODE.value) {
                return ExhibitionHallMode.TRANSPORT_MODE;
            }
            return v == ExhibitionHallMode.SHOWROOM_MODE.value ? ExhibitionHallMode.SHOWROOM_MODE : ExhibitionHallMode.__UNKNOWN__;
        }
    }

    public static enum FCTAConfig {
        NO_SELECTED(0),
        BRAKE(1),
        WARNING(2),
        BRAKE_AND_WARNING(3),
        __UNKNOWN__(-1);

        public final int value;

        private FCTAConfig(int v1) {
            this.value = v1;
        }

        public static FCTAConfig valueOf(int v) {
            if(v == FCTAConfig.NO_SELECTED.value) {
                return FCTAConfig.NO_SELECTED;
            }
            if(v == FCTAConfig.BRAKE.value) {
                return FCTAConfig.BRAKE;
            }
            if(v == FCTAConfig.WARNING.value) {
                return FCTAConfig.WARNING;
            }
            return v == FCTAConfig.BRAKE_AND_WARNING.value ? FCTAConfig.BRAKE_AND_WARNING : FCTAConfig.__UNKNOWN__;
        }
    }

    public static enum FCTASwitchStatus {
        OFF(0),
        PASSIVE_ON_INACTIVE(1),
        ACTIVE(2),
        FAILURE(3),
        __UNKNOWN__(-1);

        public final int value;

        private FCTASwitchStatus(int v1) {
            this.value = v1;
        }

        public static FCTASwitchStatus valueOf(int v) {
            if(v == FCTASwitchStatus.OFF.value) {
                return FCTASwitchStatus.OFF;
            }
            if(v == FCTASwitchStatus.PASSIVE_ON_INACTIVE.value) {
                return FCTASwitchStatus.PASSIVE_ON_INACTIVE;
            }
            if(v == FCTASwitchStatus.ACTIVE.value) {
                return FCTASwitchStatus.ACTIVE;
            }
            return v == FCTASwitchStatus.FAILURE.value ? FCTASwitchStatus.FAILURE : FCTASwitchStatus.__UNKNOWN__;
        }
    }

    public static enum FCWSwitchEnableState {
        NO_LOCK(0),
        LOCK(1),
        __UNKNOWN__(-1);

        public final int value;

        private FCWSwitchEnableState(int v1) {
            this.value = v1;
        }

        public static FCWSwitchEnableState valueOf(int v) {
            if(v == FCWSwitchEnableState.NO_LOCK.value) {
                return FCWSwitchEnableState.NO_LOCK;
            }
            return v == FCWSwitchEnableState.LOCK.value ? FCWSwitchEnableState.LOCK : FCWSwitchEnableState.__UNKNOWN__;
        }
    }

    public static enum FCWWarningDistance {
        NORMAL(0, 1),
        CLOSE(1, 2),
        FAR(2, 3),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private FCWWarningDistance(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static FCWWarningDistance valueOf(int v) {
            if(v == FCWWarningDistance.NORMAL.rx) {
                return FCWWarningDistance.NORMAL;
            }
            if(v == FCWWarningDistance.CLOSE.rx) {
                return FCWWarningDistance.CLOSE;
            }
            return v == FCWWarningDistance.FAR.rx ? FCWWarningDistance.FAR : FCWWarningDistance.__UNKNOWN__;
        }
    }

    public static enum FaultStatus {
        NOT_FAULT(0),
        FAULT(1),
        __UNKNOWN__(-1);

        public final int value;

        private FaultStatus(int v1) {
            this.value = v1;
        }

        public static FaultStatus valueOf(int v) {
            if(v == FaultStatus.NOT_FAULT.value) {
                return FaultStatus.NOT_FAULT;
            }
            return v == FaultStatus.FAULT.value ? FaultStatus.FAULT : FaultStatus.__UNKNOWN__;
        }
    }

    public static enum FrontWiperLevel {
        NOT_ACTIVE(0),
        LEVEL_1(1),
        LEVEL_2(2),
        LEVEL_3(3),
        LEVEL_4(4),
        LEVEL_5(5),
        LEVEL_6(6),
        LEVEL_7(7),
        __UNKNOWN__(-1);

        public final int value;

        private FrontWiperLevel(int v1) {
            this.value = v1;
        }

        public static FrontWiperLevel valueOf(int v) {
            if(v == FrontWiperLevel.NOT_ACTIVE.value) {
                return FrontWiperLevel.NOT_ACTIVE;
            }
            if(v == FrontWiperLevel.LEVEL_1.value) {
                return FrontWiperLevel.LEVEL_1;
            }
            if(v == FrontWiperLevel.LEVEL_2.value) {
                return FrontWiperLevel.LEVEL_2;
            }
            if(v == FrontWiperLevel.LEVEL_3.value) {
                return FrontWiperLevel.LEVEL_3;
            }
            if(v == FrontWiperLevel.LEVEL_4.value) {
                return FrontWiperLevel.LEVEL_4;
            }
            if(v == FrontWiperLevel.LEVEL_5.value) {
                return FrontWiperLevel.LEVEL_5;
            }
            if(v == FrontWiperLevel.LEVEL_6.value) {
                return FrontWiperLevel.LEVEL_6;
            }
            return v == FrontWiperLevel.LEVEL_7.value ? FrontWiperLevel.LEVEL_7 : FrontWiperLevel.__UNKNOWN__;
        }
    }

    public static enum FrontWiperMode {
        NO_COMMAND(-1, 0),
        OFF(0, 1),
        CONTINUOUS_SLOW(2, 2),
        CONTINUOUS_FAST(3, 3),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private FrontWiperMode(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static FrontWiperMode valueOf(int v) {
            if(v == FrontWiperMode.NO_COMMAND.rx) {
                return FrontWiperMode.NO_COMMAND;
            }
            if(v == FrontWiperMode.OFF.rx) {
                return FrontWiperMode.OFF;
            }
            if(v == FrontWiperMode.CONTINUOUS_SLOW.rx) {
                return FrontWiperMode.CONTINUOUS_SLOW;
            }
            return v == FrontWiperMode.CONTINUOUS_FAST.rx ? FrontWiperMode.CONTINUOUS_FAST : FrontWiperMode.__UNKNOWN__;
        }
    }

    public static enum HudMode {
        STANDARD(1),
        SNOW(2),
        __UNKNOWN__(-1);

        public final int value;

        private HudMode(int v1) {
            this.value = v1;
        }

        public static HudMode valueOf(int v) {
            if(v == HudMode.STANDARD.value) {
                return HudMode.STANDARD;
            }
            return v == HudMode.SNOW.value ? HudMode.SNOW : HudMode.__UNKNOWN__;
        }
    }

    public static enum HudOffState {
        NOT_ACTIVE(1),
        ACTIVE(2),
        __UNKNOWN__(-1);

        public final int value;

        private HudOffState(int v1) {
            this.value = v1;
        }

        public static HudOffState valueOf(int v) {
            if(v == HudOffState.NOT_ACTIVE.value) {
                return HudOffState.NOT_ACTIVE;
            }
            return v == HudOffState.ACTIVE.value ? HudOffState.ACTIVE : HudOffState.__UNKNOWN__;
        }
    }

    public static enum IMRCtrlErrorStatus {
        SYSTEM_NO_ERROR(0),
        SYSTEM_ERROR(1),
        __UNKNOWN__(-1);

        public final int value;

        private IMRCtrlErrorStatus(int v1) {
            this.value = v1;
        }

        public static IMRCtrlErrorStatus valueOf(int v) {
            if(v == IMRCtrlErrorStatus.SYSTEM_NO_ERROR.value) {
                return IMRCtrlErrorStatus.SYSTEM_NO_ERROR;
            }
            return v == IMRCtrlErrorStatus.SYSTEM_ERROR.value ? IMRCtrlErrorStatus.SYSTEM_ERROR : IMRCtrlErrorStatus.__UNKNOWN__;
        }
    }

    public static enum IMRCtrlStatus {
        NO_COMMAND(3, 0),
        OFF(2, 1),
        STANDBY(1, -1),
        ON(0, 2),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private IMRCtrlStatus(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static IMRCtrlStatus valueOf(int v) {
            if(v == IMRCtrlStatus.NO_COMMAND.rx) {
                return IMRCtrlStatus.NO_COMMAND;
            }
            if(v == IMRCtrlStatus.OFF.rx) {
                return IMRCtrlStatus.OFF;
            }
            if(v == IMRCtrlStatus.STANDBY.rx) {
                return IMRCtrlStatus.STANDBY;
            }
            return v == IMRCtrlStatus.ON.rx ? IMRCtrlStatus.ON : IMRCtrlStatus.__UNKNOWN__;
        }
    }

    public static enum LksMode {
        NOT_SELECTED(0),
        STEERING(1),
        WARNING(2),
        STEERING_AND_WARNING(3),
        __UNKNOWN__(-1);

        public final int value;

        private LksMode(int v1) {
            this.value = v1;
        }

        public static LksMode valueOf(int v) {
            if(v == LksMode.NOT_SELECTED.value) {
                return LksMode.NOT_SELECTED;
            }
            if(v == LksMode.STEERING.value) {
                return LksMode.STEERING;
            }
            if(v == LksMode.WARNING.value) {
                return LksMode.WARNING;
            }
            return v == LksMode.STEERING_AND_WARNING.value ? LksMode.STEERING_AND_WARNING : LksMode.__UNKNOWN__;
        }
    }

    public static enum LksState {
        LKS_OFF(0),
        LKS_STANDBY(1),
        LKS_ACTIVE(2),
        LKS_FAILURE(3),
        CAMERA_BLOCKED(4),
        __UNKNOWN__(-1);

        public final int value;

        private LksState(int v1) {
            this.value = v1;
        }

        public static LksState valueOf(int v) {
            if(v == LksState.LKS_OFF.value) {
                return LksState.LKS_OFF;
            }
            if(v == LksState.LKS_STANDBY.value) {
                return LksState.LKS_STANDBY;
            }
            if(v == LksState.LKS_ACTIVE.value) {
                return LksState.LKS_ACTIVE;
            }
            if(v == LksState.LKS_FAILURE.value) {
                return LksState.LKS_FAILURE;
            }
            return v == LksState.CAMERA_BLOCKED.value ? LksState.CAMERA_BLOCKED : LksState.__UNKNOWN__;
        }
    }

    public static enum NapSettingSave {
        NO_COMMAND(0),
        CANCEL(1),
        SAVE(2),
        START(3),
        __UNKNOWN__(-1);

        public final int value;

        private NapSettingSave(int v1) {
            this.value = v1;
        }

        public static NapSettingSave valueOf(int v) {
            if(v == NapSettingSave.NO_COMMAND.value) {
                return NapSettingSave.NO_COMMAND;
            }
            if(v == NapSettingSave.CANCEL.value) {
                return NapSettingSave.CANCEL;
            }
            if(v == NapSettingSave.SAVE.value) {
                return NapSettingSave.SAVE;
            }
            return v == NapSettingSave.START.value ? NapSettingSave.START : NapSettingSave.__UNKNOWN__;
        }
    }

    public static enum OSRMRAngleCmd {
        OFF(0, 1),
        LEFT_MIRROR_DIP(1, 2),
        RIGHT_MIRROR_DIP(2, 3),
        BOTH_MIRROR_DIP(3, 4),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private OSRMRAngleCmd(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static OSRMRAngleCmd valueOf(int v) {
            if(v == OSRMRAngleCmd.OFF.rx) {
                return OSRMRAngleCmd.OFF;
            }
            if(v == OSRMRAngleCmd.LEFT_MIRROR_DIP.rx) {
                return OSRMRAngleCmd.LEFT_MIRROR_DIP;
            }
            if(v == OSRMRAngleCmd.RIGHT_MIRROR_DIP.rx) {
                return OSRMRAngleCmd.RIGHT_MIRROR_DIP;
            }
            return v == OSRMRAngleCmd.BOTH_MIRROR_DIP.rx ? OSRMRAngleCmd.BOTH_MIRROR_DIP : OSRMRAngleCmd.__UNKNOWN__;
        }
    }

    public static enum OSRMRAngleSaveCmd {
        NONE(0),
        START(1),
        SAVE(2),
        CANCEL(3),
        __UNKNOWN__(-1);

        public final int value;

        private OSRMRAngleSaveCmd(int v1) {
            this.value = v1;
        }

        public static OSRMRAngleSaveCmd valueOf(int v) {
            if(v == OSRMRAngleSaveCmd.NONE.value) {
                return OSRMRAngleSaveCmd.NONE;
            }
            if(v == OSRMRAngleSaveCmd.START.value) {
                return OSRMRAngleSaveCmd.START;
            }
            if(v == OSRMRAngleSaveCmd.SAVE.value) {
                return OSRMRAngleSaveCmd.SAVE;
            }
            return v == OSRMRAngleSaveCmd.CANCEL.value ? OSRMRAngleSaveCmd.CANCEL : OSRMRAngleSaveCmd.__UNKNOWN__;
        }
    }

    public static enum ParkAutoUnlockState {
        NOT_ACTIVE(0, 1),
        ACTIVE(1, 2),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private ParkAutoUnlockState(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static ParkAutoUnlockState valueOf(int v) {
            if(v == ParkAutoUnlockState.NOT_ACTIVE.rx) {
                return ParkAutoUnlockState.NOT_ACTIVE;
            }
            return v == ParkAutoUnlockState.ACTIVE.rx ? ParkAutoUnlockState.ACTIVE : ParkAutoUnlockState.__UNKNOWN__;
        }
    }

    public static enum RainstormMode {
        ENTER_REMIND(1),
        AUTO_QUIT(2),
        __UNKNOWN__(-1);

        public final int value;

        private RainstormMode(int v1) {
            this.value = v1;
        }

        public static RainstormMode valueOf(int v) {
            if(v == RainstormMode.ENTER_REMIND.value) {
                return RainstormMode.ENTER_REMIND;
            }
            return v == RainstormMode.AUTO_QUIT.value ? RainstormMode.AUTO_QUIT : RainstormMode.__UNKNOWN__;
        }
    }

    public static enum RearSeatShortcutmode {
        NO_COMMAND(0),
        QUIT(1),
        LH_MEMORY_MODE(2),
        RH_MEMORY_MODE(3),
        LH_POSITION_RECOVERY_MODE(4),
        RH_POSITION_RECOVERY_MODE(5),
        __UNKNOWN__(-1);

        public final int value;

        private RearSeatShortcutmode(int v1) {
            this.value = v1;
        }

        public static RearSeatShortcutmode valueOf(int v) {
            if(v == RearSeatShortcutmode.NO_COMMAND.value) {
                return RearSeatShortcutmode.NO_COMMAND;
            }
            if(v == RearSeatShortcutmode.QUIT.value) {
                return RearSeatShortcutmode.QUIT;
            }
            if(v == RearSeatShortcutmode.LH_MEMORY_MODE.value) {
                return RearSeatShortcutmode.LH_MEMORY_MODE;
            }
            if(v == RearSeatShortcutmode.RH_MEMORY_MODE.value) {
                return RearSeatShortcutmode.RH_MEMORY_MODE;
            }
            if(v == RearSeatShortcutmode.LH_POSITION_RECOVERY_MODE.value) {
                return RearSeatShortcutmode.LH_POSITION_RECOVERY_MODE;
            }
            return v == RearSeatShortcutmode.RH_POSITION_RECOVERY_MODE.value ? RearSeatShortcutmode.RH_POSITION_RECOVERY_MODE : RearSeatShortcutmode.__UNKNOWN__;
        }
    }

    public static enum RearviewMirrorCmd {
        STOP(0),
        FL_MIRROR_UP(1),
        FL_MIRROR_DOWN(2),
        FL_MIRROR_LEFT(3),
        FL_MIRROR_RIGHT(4),
        FR_MIRROR_UP(5),
        FR_MIRROR_DOWN(6),
        FR_MIRROR_LEFT(7),
        FR_MIRROR_RIGHT(8),
        FOLD(9),
        UNFOLD(10),
        __UNKNOWN__(-1);

        public final int value;

        private RearviewMirrorCmd(int v1) {
            this.value = v1;
        }

        public static RearviewMirrorCmd valueOf(int v) {
            if(v == RearviewMirrorCmd.STOP.value) {
                return RearviewMirrorCmd.STOP;
            }
            if(v == RearviewMirrorCmd.FL_MIRROR_UP.value) {
                return RearviewMirrorCmd.FL_MIRROR_UP;
            }
            if(v == RearviewMirrorCmd.FL_MIRROR_DOWN.value) {
                return RearviewMirrorCmd.FL_MIRROR_DOWN;
            }
            if(v == RearviewMirrorCmd.FL_MIRROR_LEFT.value) {
                return RearviewMirrorCmd.FL_MIRROR_LEFT;
            }
            if(v == RearviewMirrorCmd.FL_MIRROR_RIGHT.value) {
                return RearviewMirrorCmd.FL_MIRROR_RIGHT;
            }
            if(v == RearviewMirrorCmd.FR_MIRROR_UP.value) {
                return RearviewMirrorCmd.FR_MIRROR_UP;
            }
            if(v == RearviewMirrorCmd.FR_MIRROR_DOWN.value) {
                return RearviewMirrorCmd.FR_MIRROR_DOWN;
            }
            if(v == RearviewMirrorCmd.FR_MIRROR_LEFT.value) {
                return RearviewMirrorCmd.FR_MIRROR_LEFT;
            }
            if(v == RearviewMirrorCmd.FR_MIRROR_RIGHT.value) {
                return RearviewMirrorCmd.FR_MIRROR_RIGHT;
            }
            if(v == RearviewMirrorCmd.FOLD.value) {
                return RearviewMirrorCmd.FOLD;
            }
            return v == RearviewMirrorCmd.UNFOLD.value ? RearviewMirrorCmd.UNFOLD : RearviewMirrorCmd.__UNKNOWN__;
        }
    }

    public static enum RearviewMirrorCmdForReverse {
        OFF(0, 1),
        LEFT_DOWN(1, 2),
        RIGHT_DOWN(2, 3),
        BOTH_DOWN(3, 4),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private RearviewMirrorCmdForReverse(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static RearviewMirrorCmdForReverse valueOf(int v) {
            if(v == RearviewMirrorCmdForReverse.OFF.rx) {
                return RearviewMirrorCmdForReverse.OFF;
            }
            if(v == RearviewMirrorCmdForReverse.LEFT_DOWN.rx) {
                return RearviewMirrorCmdForReverse.LEFT_DOWN;
            }
            if(v == RearviewMirrorCmdForReverse.RIGHT_DOWN.rx) {
                return RearviewMirrorCmdForReverse.RIGHT_DOWN;
            }
            return v == RearviewMirrorCmdForReverse.BOTH_DOWN.rx ? RearviewMirrorCmdForReverse.BOTH_DOWN : RearviewMirrorCmdForReverse.__UNKNOWN__;
        }
    }

    public static enum RearviewMirrorSettingCmd {
        START(1),
        SAVE(2),
        CANCEL(3),
        __UNKNOWN__(-1);

        public final int value;

        private RearviewMirrorSettingCmd(int v1) {
            this.value = v1;
        }

        public static RearviewMirrorSettingCmd valueOf(int v) {
            if(v == RearviewMirrorSettingCmd.START.value) {
                return RearviewMirrorSettingCmd.START;
            }
            if(v == RearviewMirrorSettingCmd.SAVE.value) {
                return RearviewMirrorSettingCmd.SAVE;
            }
            return v == RearviewMirrorSettingCmd.CANCEL.value ? RearviewMirrorSettingCmd.CANCEL : RearviewMirrorSettingCmd.__UNKNOWN__;
        }
    }

    public static enum RearviewMirrorState {
        FOLD(1),
        UNFOLD(2),
        __UNKNOWN__(-1);

        public final int value;

        private RearviewMirrorState(int v1) {
            this.value = v1;
        }

        public static RearviewMirrorState valueOf(int v) {
            if(v == RearviewMirrorState.FOLD.value) {
                return RearviewMirrorState.FOLD;
            }
            return v == RearviewMirrorState.UNFOLD.value ? RearviewMirrorState.UNFOLD : RearviewMirrorState.__UNKNOWN__;
        }
    }

    public static enum SeatNapModeState {
        NO_IN_SNAPMODE(0),
        SNAP_SETTING_MODE(1),
        SNAP_MODE(2),
        __UNKNOWN__(-1);

        public final int value;

        private SeatNapModeState(int v1) {
            this.value = v1;
        }

        public static SeatNapModeState valueOf(int v) {
            if(v == SeatNapModeState.NO_IN_SNAPMODE.value) {
                return SeatNapModeState.NO_IN_SNAPMODE;
            }
            if(v == SeatNapModeState.SNAP_SETTING_MODE.value) {
                return SeatNapModeState.SNAP_SETTING_MODE;
            }
            return v == SeatNapModeState.SNAP_MODE.value ? SeatNapModeState.SNAP_MODE : SeatNapModeState.__UNKNOWN__;
        }
    }

    public static enum SeatNapPosSaveReq {
        NO_COMMAND(0),
        ACTIVE_POP_UP_WINDOW(1),
        __UNKNOWN__(-1);

        public final int value;

        private SeatNapPosSaveReq(int v1) {
            this.value = v1;
        }

        public static SeatNapPosSaveReq valueOf(int v) {
            if(v == SeatNapPosSaveReq.NO_COMMAND.value) {
                return SeatNapPosSaveReq.NO_COMMAND;
            }
            return v == SeatNapPosSaveReq.ACTIVE_POP_UP_WINDOW.value ? SeatNapPosSaveReq.ACTIVE_POP_UP_WINDOW : SeatNapPosSaveReq.__UNKNOWN__;
        }
    }

    public static enum SeatSpaModeState {
        NO_IN_SPAMODE(0),
        SPA_SETTING_MODE(1),
        SPA_MODE(2),
        __UNKNOWN__(-1);

        public final int value;

        private SeatSpaModeState(int v1) {
            this.value = v1;
        }

        public static SeatSpaModeState valueOf(int v) {
            if(v == SeatSpaModeState.NO_IN_SPAMODE.value) {
                return SeatSpaModeState.NO_IN_SPAMODE;
            }
            if(v == SeatSpaModeState.SPA_SETTING_MODE.value) {
                return SeatSpaModeState.SPA_SETTING_MODE;
            }
            return v == SeatSpaModeState.SPA_MODE.value ? SeatSpaModeState.SPA_MODE : SeatSpaModeState.__UNKNOWN__;
        }
    }

    public static enum ShortcutMode {
        QUIT(1),
        RAINSTORM_MODE(2),
        NAP_MODE(3),
        WAKE_UP_MODE(4),
        PARTY_MODE(5),
        LH_SPA_MODE(6),
        RH_SPA_MODE(7),
        BOTH_SPA_MODE(8),
        __UNKNOWN__(-1);

        public final int value;

        private ShortcutMode(int v1) {
            this.value = v1;
        }

        public static ShortcutMode valueOf(int v) {
            if(v == ShortcutMode.QUIT.value) {
                return ShortcutMode.QUIT;
            }
            if(v == ShortcutMode.RAINSTORM_MODE.value) {
                return ShortcutMode.RAINSTORM_MODE;
            }
            if(v == ShortcutMode.NAP_MODE.value) {
                return ShortcutMode.NAP_MODE;
            }
            if(v == ShortcutMode.WAKE_UP_MODE.value) {
                return ShortcutMode.WAKE_UP_MODE;
            }
            if(v == ShortcutMode.PARTY_MODE.value) {
                return ShortcutMode.PARTY_MODE;
            }
            if(v == ShortcutMode.LH_SPA_MODE.value) {
                return ShortcutMode.LH_SPA_MODE;
            }
            if(v == ShortcutMode.RH_SPA_MODE.value) {
                return ShortcutMode.RH_SPA_MODE;
            }
            return v == ShortcutMode.BOTH_SPA_MODE.value ? ShortcutMode.BOTH_SPA_MODE : ShortcutMode.__UNKNOWN__;
        }
    }

    public static enum StpOnBrkToRelParkBrkIndOnState {
        OFF(0),
        ON(1),
        DEEP_PUSH_BRK_PEDAL(2),
        __UNKNOWN__(-1);

        public final int value;

        private StpOnBrkToRelParkBrkIndOnState(int v1) {
            this.value = v1;
        }

        public static StpOnBrkToRelParkBrkIndOnState valueOf(int v) {
            if(v == StpOnBrkToRelParkBrkIndOnState.OFF.value) {
                return StpOnBrkToRelParkBrkIndOnState.OFF;
            }
            if(v == StpOnBrkToRelParkBrkIndOnState.ON.value) {
                return StpOnBrkToRelParkBrkIndOnState.ON;
            }
            return v == StpOnBrkToRelParkBrkIndOnState.DEEP_PUSH_BRK_PEDAL.value ? StpOnBrkToRelParkBrkIndOnState.DEEP_PUSH_BRK_PEDAL : StpOnBrkToRelParkBrkIndOnState.__UNKNOWN__;
        }
    }

    public static enum WCLCMWorkMode {
        AUTO(0),
        MANUAL(1),
        __UNKNOWN__(-1);

        public final int value;

        private WCLCMWorkMode(int v1) {
            this.value = v1;
        }

        public static WCLCMWorkMode valueOf(int v) {
            if(v == WCLCMWorkMode.AUTO.value) {
                return WCLCMWorkMode.AUTO;
            }
            return v == WCLCMWorkMode.MANUAL.value ? WCLCMWorkMode.MANUAL : WCLCMWorkMode.__UNKNOWN__;
        }
    }

    public static enum WCLCMWorkModeCtl {
        NOT_ACTIVE(1),
        ACTIVE(2),
        __UNKNOWN__(-1);

        public final int value;

        private WCLCMWorkModeCtl(int v1) {
            this.value = v1;
        }

        public static WCLCMWorkModeCtl valueOf(int v) {
            if(v == WCLCMWorkModeCtl.NOT_ACTIVE.value) {
                return WCLCMWorkModeCtl.NOT_ACTIVE;
            }
            return v == WCLCMWorkModeCtl.ACTIVE.value ? WCLCMWorkModeCtl.ACTIVE : WCLCMWorkModeCtl.__UNKNOWN__;
        }
    }

    public static enum WCMCtl {
        NOT_ACTIVE(1),
        ACTIVE(2),
        __UNKNOWN__(-1);

        public final int value;

        private WCMCtl(int v1) {
            this.value = v1;
        }

        public static WCMCtl valueOf(int v) {
            if(v == WCMCtl.NOT_ACTIVE.value) {
                return WCMCtl.NOT_ACTIVE;
            }
            return v == WCMCtl.ACTIVE.value ? WCMCtl.ACTIVE : WCMCtl.__UNKNOWN__;
        }
    }

    public static enum WCMCtlChargingState {
        STANDBY(0),
        CHARGING(1),
        COMPLETED(2),
        NOT_STANDBY(3),
        __UNKNOWN__(-1);

        public final int value;

        private WCMCtlChargingState(int v1) {
            this.value = v1;
        }

        public static WCMCtlChargingState valueOf(int v) {
            if(v == WCMCtlChargingState.STANDBY.value) {
                return WCMCtlChargingState.STANDBY;
            }
            if(v == WCMCtlChargingState.CHARGING.value) {
                return WCMCtlChargingState.CHARGING;
            }
            if(v == WCMCtlChargingState.COMPLETED.value) {
                return WCMCtlChargingState.COMPLETED;
            }
            return v == WCMCtlChargingState.NOT_STANDBY.value ? WCMCtlChargingState.NOT_STANDBY : WCMCtlChargingState.__UNKNOWN__;
        }
    }

    public static enum WCMCtlFailureState {
        NO_FAILURE(0),
        OVER_TEMPERATURE(1),
        RFOD(2),
        VOLTAGE_PROTECTED(3),
        OVER_POWER_PROTECTED(4),
        INTERNAL_FAILURE(5),
        SMARTPHONE_NO_RESPONSE(6),
        OFOD(7),
        NFC_CARD_DETECTED(8),
        __UNKNOWN__(-1);

        public final int value;

        private WCMCtlFailureState(int v1) {
            this.value = v1;
        }

        public static WCMCtlFailureState valueOf(int v) {
            if(v == WCMCtlFailureState.NO_FAILURE.value) {
                return WCMCtlFailureState.NO_FAILURE;
            }
            if(v == WCMCtlFailureState.OVER_TEMPERATURE.value) {
                return WCMCtlFailureState.OVER_TEMPERATURE;
            }
            if(v == WCMCtlFailureState.RFOD.value) {
                return WCMCtlFailureState.RFOD;
            }
            if(v == WCMCtlFailureState.VOLTAGE_PROTECTED.value) {
                return WCMCtlFailureState.VOLTAGE_PROTECTED;
            }
            if(v == WCMCtlFailureState.OVER_POWER_PROTECTED.value) {
                return WCMCtlFailureState.OVER_POWER_PROTECTED;
            }
            if(v == WCMCtlFailureState.INTERNAL_FAILURE.value) {
                return WCMCtlFailureState.INTERNAL_FAILURE;
            }
            if(v == WCMCtlFailureState.SMARTPHONE_NO_RESPONSE.value) {
                return WCMCtlFailureState.SMARTPHONE_NO_RESPONSE;
            }
            if(v == WCMCtlFailureState.OFOD.value) {
                return WCMCtlFailureState.OFOD;
            }
            return v == WCMCtlFailureState.NFC_CARD_DETECTED.value ? WCMCtlFailureState.NFC_CARD_DETECTED : WCMCtlFailureState.__UNKNOWN__;
        }
    }

    public static enum WCMCtlResult {
        ENABLED(0),
        DISABLED_BY_PEPS(1),
        SHUTDOWN_BY_SWITCH_CAN(2),
        __UNKNOWN__(-1);

        public final int value;

        private WCMCtlResult(int v1) {
            this.value = v1;
        }

        public static WCMCtlResult valueOf(int v) {
            if(v == WCMCtlResult.ENABLED.value) {
                return WCMCtlResult.ENABLED;
            }
            if(v == WCMCtlResult.DISABLED_BY_PEPS.value) {
                return WCMCtlResult.DISABLED_BY_PEPS;
            }
            return v == WCMCtlResult.SHUTDOWN_BY_SWITCH_CAN.value ? WCMCtlResult.SHUTDOWN_BY_SWITCH_CAN : WCMCtlResult.__UNKNOWN__;
        }
    }

    public static final int AC_SMART_SETTING = 417;
    public static final int AC_SMART_STATE = 0x1A0;
    public static final int ADASELK_SETTING = 0x20F;
    public static final int ADASELK_STATE = 0x20E;
    public static final int ADAS_RAEB_SETTING = 617;
    public static final int ADAS_RAEB_STATUS = 618;
    public static final int ADAS_WARN_TYPE = 108;
    public static final int ADAS_WARN_TYPE_SETTING = 41;
    public static final int AEB_FAULT_STATE = 650;
    public static final int AEB_OFF_SETTING = 36;
    public static final int AEB_OFF_STATE = 103;
    public static final int AUTO_WIPER_SETTING = 45;
    public static final int AUTO_WIPER_STATE = 0x70;
    public static final int AVAS_SETTING = 42;
    public static final int AVAS_STATE = 109;
    public static final int BSDMDOWCTL_SETTING = 455;
    public static final int BSDMDOWSTATE_STATE = 454;
    public static final int BSDMLCACTL_SETTING = 453;
    public static final int BSDMLCA_STATE = 452;
    public static final int BSDMRCTA_ASSIST_TYPE_SETTING = 459;
    public static final int BSDMRCTA_ASSIST_TYPE_STATE = 458;
    public static final int BSDMRCTA_CTL_SETTING = 457;
    public static final int BSDMRCTA_STATE = 456;
    public static final int BSDMRCWCTL_SETTING = 461;
    public static final int BSDMRCWSTATE_STATE = 460;
    public static final int COMFORT_PARK_SETTING = 418;
    public static final int COMFORT_PARK_STATE = 414;
    public static final int CRUISE_ASSIST_MODE = 0x10F;
    public static final int CRUISE_ASSIST_MODE_SETTING = 0x110;
    public static final int DOOR_HANDLE_ELECTRIC_HIDE_SETTING = 424;
    public static final int DOOR_HANDLE_ELECTRIC_HIDE_STATE = 423;
    public static final int DRAG_MODE_SETTING = 333;
    public static final int DRAG_MODE_STATE = 332;
    public static final int DRIVER_EASY_ENTRY_EXIT_SETTING = 0x1BF;
    public static final int DRIVER_EASY_ENTRY_EXIT_STATE = 446;
    public static final int ENG_WAVE_SWITCH_SETTING = 529;
    public static final int ENG_WAVE_SWITCH_STATE = 0x210;
    public static final int EPB_SYSTEM_MSG_STATE = 334;
    public static final int EPB_SYSTEM_SET_STATE_SETTING = 331;
    public static final int EPB_SYSTEM_STATE = 330;
    public static final int ETC_SETTING = 43;
    public static final int ETC_STATE = 110;
    public static final int EXHIBITION_HALL_MODE_ENABLE = 725;
    public static final int EXHIBITION_HALL_MODE_SETTING = 723;
    public static final int EXHIBITION_HALL_MODE_STATUS = 724;
    public static final int FCTA_CONFIG_SETTING = 599;
    public static final int FCTA_CONFIG_STATUS = 598;
    public static final int FCTA_SWITCH_SETTING = 597;
    public static final int FCTA_SWITCH_STATUS = 596;
    public static final int FCW_FAULT_STATE = 649;
    public static final int FCW_OFF_SETTING = 34;
    public static final int FCW_OFF_STATE = 101;
    public static final int FCW_SWITCH_ENABLE_STATE = 706;
    public static final int FCW_WARNING_DISTANCE = 102;
    public static final int FCW_WARNING_DISTANCE_SETTING = 35;
    public static final int FRONT_CAR_DISTANCE_DISPLAY = 0x10B;
    public static final int FRONT_CAR_DISTANCE_DISPLAY_SETTING = 0x10C;
    public static final int FRONT_WIPER_AUTO_CONFIG_SETTING = 716;
    public static final int FRONT_WIPER_AUTO_CONFIG_STATUS = 717;
    public static final int FRONT_WIPER_INT_CONFIG_SETTING = 714;
    public static final int FRONT_WIPER_INT_CONFIG_STATUS = 715;
    public static final int FRONT_WIPER_MODE_SETTING = 580;
    public static final int FRONT_WIPER_MODE_STATE = 581;
    public static final int FRONT_WIPER_SERVICE_POSITION_SETTING = 44;
    public static final int FRONT_WIPER_SERVICE_POSITION_STATE = 0x6F;
    public static final int FRONT_WIPER_WASHER_SETTING = 584;
    public static final int FRONT_WIPER_WASHER_STATE = 585;
    public static final int HUDBRIGHTNESSST_SETTING = 465;
    public static final int HUDBRIGHTNESSST_STATE = 0x1D0;
    public static final int HUDHEIGHTST_SETTING = 467;
    public static final int HUDHEIGHTST_STATE = 466;
    public static final int HUDOFF_SETTING = 0x1CF;
    public static final int HUDOFF_STATE = 462;
    public static final int HUD_ADAS_CRUISE_DIS_SHOW_SETTING = 600;
    public static final int HUD_ADAS_CRUISE_DIS_SHOW_STATUS = 601;
    public static final int HUD_ADAS_TSR_DIS_SHOW_SETTING = 602;
    public static final int HUD_ADAS_TSR_DIS_SHOW_STATUS = 603;
    public static final int HUD_ANGLEST_SETTING = 469;
    public static final int HUD_ANGLEST_STATE = 468;
    public static final int HUD_MODE_SETTING = 471;
    public static final int HUD_MODE_STATE = 470;
    public static final int HUD_NAV_DIS_SHOW_SETTING = 604;
    public static final int HUD_NAV__DIS_SHOW_STATUS = 605;
    public static final int IACC_SETTING = 39;
    public static final int IACC_STATE = 106;
    public static final int ILC_HWA_SWITCH_SETTING = 595;
    public static final int ILC_HWA_SWITCH_STATUS = 594;
    public static final int IMRCTRL_ERRO_STATUS = 622;
    public static final int IMRCTRL_SETTING = 621;
    public static final int IMRCTRL_SETTING_A60 = 625;
    public static final int IMRCTRL_STATUS = 620;
    public static final int INTELLIGENT_AVOID = 0x10D;
    public static final int INTELLIGENT_AVOID_SETTING = 270;
    public static final int KEY_NOT_FORGET_WARNING = 362;
    public static final int KEY_NOT_FORGET_WARNING_SETTING = 363;
    public static final int LDW_LKA_SETTING = 0x20;
    public static final int LKS_MODE = 100;
    public static final int LKS_MODE_SETTING = 33;
    public static final int LKS_STATE = 99;
    public static final int OSRMR_ANGLE_HORIZONTAL_FL = 429;
    public static final int OSRMR_ANGLE_HORIZONTAL_FR = 0x1AF;
    public static final int OSRMR_ANGLE_VERTICAL_FL = 428;
    public static final int OSRMR_ANGLE_VERTICAL_FR = 430;
    public static final int OSRM_ANGLE_CMD_SETTING = 426;
    public static final int OSRM_ANGLE_CMD_STATE = 425;
    public static final int OSRM_ANGLE_SAVE_CMD_SETTING = 427;
    public static final int OSRM_AUTO_FOLD_SETTING = 40;
    public static final int OSRM_AUTO_FOLD_STATE = 107;
    public static final int PARK_AUTO_UNLOCK_SETTING = 337;
    public static final int PARK_AUTO_UNLOCK_STATE = 0x150;
    public static final int PEPS_WARN_FORCE_POWER_OFF_STATUS = 0x27F;
    public static final int POWER_KEEP_REMIND_CONF = 375;
    public static final int POWER_KEEP_REMIND_CONF_SETTING = 376;
    public static final int POWER_KEEP_REMIND_STATE = 374;
    public static final int POWER_KEEP_REQVD_SETTING = 373;
    public static final int POWER_KEEP_REQVD_STATE = 372;
    public static final int POWER_KEEP_SETTING = 371;
    public static final int POWER_KEEP_STATE = 370;
    public static final int POWER_OFF_REQ_SETTING = 379;
    public static final int POWER_OFF_REQ_VD_SETTING = 378;
    public static final int POWER_OFF_REQ_VD_STATE = 377;
    public static final int RAINSTORM_MODE = 0x71;
    public static final int RAINSTORM_MODE_SETTING = 46;
    public static final int REARVIEW_MIRROR_CMD = 0xFB;
    public static final int REARVIEW_MIRROR_CMD_REVERSE_SETTING = 311;
    public static final int REARVIEW_MIRROR_CMD_REVERSE_STATE = 310;
    public static final int REARVIEW_MIRROR_CMD_VD = 309;
    public static final int REARVIEW_MIRROR_SETTING_CMD_SETTING = 312;
    public static final int REARVIEW_MIRROR_STATE_L = 0xFC;
    public static final int REARVIEW_MIRROR_STATE_R = 0xFD;
    public static final int REAR_WIPER_MODE_SETTING = 582;
    public static final int REAR_WIPER_MODE_STATE = 583;
    public static final int REAR_WIPER_WASHER_SETTING = 586;
    public static final int REAR_WIPER_WASHER_STATE = 587;
    public static final int RLSEATWELCOME = 540;
    public static final int RLSEATWELCOME_SETTING = 541;
    public static final int RL_SPA_BUTTON_STATE = 0x22F;
    public static final int RRSEATWELCOME = 538;
    public static final int RRSEATWELCOME_SETTING = 539;
    public static final int RR_SPA_BUTTON_STATE = 560;
    public static final int SCM_NAP_MODE_SEAT_STATE = 0x240;
    public static final int SCM_NAP_SETTING = 561;
    public static final int SCM_NAP_SETTING_SAVE = 562;
    public static final int SCM_NAP_SETTING_SAVE_STATE = 563;
    public static final int SCM_REAR_NAP_SETTING = 579;
    public static final int SCM_RL_SPA_MODE_SEAT_STATE = 577;
    public static final int SCM_RR_SPA_MODE_SEAT_STATE = 578;
    public static final int SEAT_NAP_POS_SAVE_REQ_STATE = 681;
    public static final int STP_ONBRK_TO_REL_PARKBRK_INDON_STATE = 0x14F;
    public static final int TSR_AUDIO_WARNING_SETTING = 38;
    public static final int TSR_AUDIO_WARNING_STATE = 105;
    public static final int TSR_SETTING = 37;
    public static final int TSR_STATE = 104;
    public static final int WCLCM_WORK_MODE_CTL_SETTING = 451;
    public static final int WCLCM_WORK_MODE_STATE = 450;
    public static final int WCM_CTL_CHARGING_STATE_STATE = 0x203;
    public static final int WCM_CTL_ERROR_STATE = 520;
    public static final int WCM_CTL_FAILURE_STATE_STATE = 0x204;
    public static final int WCM_CTL_PROMPT_STATE = 0x207;
    public static final int WCM_CTL_RESULT_STATE = 0x1C0;
    public static final int WCM_CTL_SETTING = 449;

}

