package com.yftech.vehicle.internal.adapter;

public interface ICarEvDevice extends IBaseApi {
    public static enum AvdcMode {
        INVALID(0),
        MODEST_MODEL(1),
        RADICAL_MODEL(2),
        ON_LOW_ADHESION_ROAD(3),
        ADAPTIVE_MODEL(4),
        OFF(5),
        __UNKNOWN__(-1);

        public final int value;

        private AvdcMode(int value) {
            this.value = value;
        }

        public static AvdcMode valueOf(int value) {
            if(value == AvdcMode.INVALID.value) {
                return AvdcMode.INVALID;
            }
            if(value == AvdcMode.MODEST_MODEL.value) {
                return AvdcMode.MODEST_MODEL;
            }
            if(value == AvdcMode.RADICAL_MODEL.value) {
                return AvdcMode.RADICAL_MODEL;
            }
            if(value == AvdcMode.ON_LOW_ADHESION_ROAD.value) {
                return AvdcMode.ON_LOW_ADHESION_ROAD;
            }
            if(value == AvdcMode.ADAPTIVE_MODEL.value) {
                return AvdcMode.ADAPTIVE_MODEL;
            }
            return value == AvdcMode.OFF.value ? AvdcMode.OFF : AvdcMode.__UNKNOWN__;
        }
    }

    public static enum ChargActive {
        NOT_CHARGING(0),
        CHARGING(1),
        __UNKNOWN__(-1);

        public final int value;

        private ChargActive(int value) {
            this.value = value;
        }

        public static ChargActive valueOf(int value) {
            if(value == ChargActive.NOT_CHARGING.value) {
                return ChargActive.NOT_CHARGING;
            }
            return value == ChargActive.CHARGING.value ? ChargActive.CHARGING : ChargActive.__UNKNOWN__;
        }
    }

    public static enum ChargEnd {
        NO_COMMAND(0),
        END_CHARGE(1),
        __UNKNOWN__(-1);

        public final int value;

        private ChargEnd(int value) {
            this.value = value;
        }

        public static ChargEnd valueOf(int value) {
            if(value == ChargEnd.NO_COMMAND.value) {
                return ChargEnd.NO_COMMAND;
            }
            return value == ChargEnd.END_CHARGE.value ? ChargEnd.END_CHARGE : ChargEnd.__UNKNOWN__;
        }
    }

    public static enum ChargState {
        CHARGE_CURRENT_VOLTAGE_INTERFACE(0),
        BLANK_MODULE_INTERFACE(1),
        __UNKNOWN__(-1);

        public final int value;

        private ChargState(int value) {
            this.value = value;
        }

        public static ChargState valueOf(int value) {
            if(value == ChargState.CHARGE_CURRENT_VOLTAGE_INTERFACE.value) {
                return ChargState.CHARGE_CURRENT_VOLTAGE_INTERFACE;
            }
            return value == ChargState.BLANK_MODULE_INTERFACE.value ? ChargState.BLANK_MODULE_INTERFACE : ChargState.__UNKNOWN__;
        }
    }

    public static enum ChargeFullNoticeLevel {
        NO_NOTICE(0),
        LEVEL_2(1),
        LEVEL_3(2),
        __UNKNOWN__(-1);

        public final int value;

        private ChargeFullNoticeLevel(int value) {
            this.value = value;
        }

        public static ChargeFullNoticeLevel valueOf(int value) {
            if(value == ChargeFullNoticeLevel.NO_NOTICE.value) {
                return ChargeFullNoticeLevel.NO_NOTICE;
            }
            if(value == ChargeFullNoticeLevel.LEVEL_2.value) {
                return ChargeFullNoticeLevel.LEVEL_2;
            }
            return value == ChargeFullNoticeLevel.LEVEL_3.value ? ChargeFullNoticeLevel.LEVEL_3 : ChargeFullNoticeLevel.__UNKNOWN__;
        }
    }

    public static enum ChargeMode {
        IMMEDIATELY(0),
        BOOKING(1),
        __UNKNOWN__(-1);

        public final int value;

        private ChargeMode(int value) {
            this.value = value;
        }

        public static ChargeMode valueOf(int value) {
            if(value == ChargeMode.IMMEDIATELY.value) {
                return ChargeMode.IMMEDIATELY;
            }
            return value == ChargeMode.BOOKING.value ? ChargeMode.BOOKING : ChargeMode.__UNKNOWN__;
        }
    }

    public static enum ChargeSocPercent {
        NO_COMMAND(0),
        PERC_50(1),
        PERC_55(2),
        PERC_60(3),
        PERC_65(4),
        PERC_70(5),
        PERC_75(6),
        PERC_80(7),
        PERC_85(8),
        PERC_90(9),
        PERC_95(10),
        PERC_100(11),
        __UNKNOWN__(-1);

        public final int value;

        private ChargeSocPercent(int value) {
            this.value = value;
        }

        public static ChargeSocPercent valueOf(int value) {
            if(value == ChargeSocPercent.NO_COMMAND.value) {
                return ChargeSocPercent.NO_COMMAND;
            }
            if(value == ChargeSocPercent.PERC_50.value) {
                return ChargeSocPercent.PERC_50;
            }
            if(value == ChargeSocPercent.PERC_55.value) {
                return ChargeSocPercent.PERC_55;
            }
            if(value == ChargeSocPercent.PERC_60.value) {
                return ChargeSocPercent.PERC_60;
            }
            if(value == ChargeSocPercent.PERC_65.value) {
                return ChargeSocPercent.PERC_65;
            }
            if(value == ChargeSocPercent.PERC_70.value) {
                return ChargeSocPercent.PERC_70;
            }
            if(value == ChargeSocPercent.PERC_75.value) {
                return ChargeSocPercent.PERC_75;
            }
            if(value == ChargeSocPercent.PERC_80.value) {
                return ChargeSocPercent.PERC_80;
            }
            if(value == ChargeSocPercent.PERC_85.value) {
                return ChargeSocPercent.PERC_85;
            }
            if(value == ChargeSocPercent.PERC_90.value) {
                return ChargeSocPercent.PERC_90;
            }
            if(value == ChargeSocPercent.PERC_95.value) {
                return ChargeSocPercent.PERC_95;
            }
            return value == ChargeSocPercent.PERC_100.value ? ChargeSocPercent.PERC_100 : ChargeSocPercent.__UNKNOWN__;
        }
    }

    public static enum ChargeWarmTime {
        HOUR_1(1),
        HOUR_2(2),
        HOUR_3(3),
        HOUR_4(4),
        HOUR_5(5),
        HOUR_6(6),
        HOUR_7(7),
        HOUR_8(8),
        HOUR_9(9),
        HOUR_10(10),
        HOUR_11(11),
        ON(12),
        OFF(15),
        __UNKNOWN__(-1);

        public final int value;

        private ChargeWarmTime(int value) {
            this.value = value;
        }

        public static ChargeWarmTime valueOf(int value) {
            if(value == ChargeWarmTime.HOUR_1.value) {
                return ChargeWarmTime.HOUR_1;
            }
            if(value == ChargeWarmTime.HOUR_2.value) {
                return ChargeWarmTime.HOUR_2;
            }
            if(value == ChargeWarmTime.HOUR_3.value) {
                return ChargeWarmTime.HOUR_3;
            }
            if(value == ChargeWarmTime.HOUR_4.value) {
                return ChargeWarmTime.HOUR_4;
            }
            if(value == ChargeWarmTime.HOUR_5.value) {
                return ChargeWarmTime.HOUR_5;
            }
            if(value == ChargeWarmTime.HOUR_6.value) {
                return ChargeWarmTime.HOUR_6;
            }
            if(value == ChargeWarmTime.HOUR_7.value) {
                return ChargeWarmTime.HOUR_7;
            }
            if(value == ChargeWarmTime.HOUR_8.value) {
                return ChargeWarmTime.HOUR_8;
            }
            if(value == ChargeWarmTime.HOUR_9.value) {
                return ChargeWarmTime.HOUR_9;
            }
            if(value == ChargeWarmTime.HOUR_10.value) {
                return ChargeWarmTime.HOUR_10;
            }
            if(value == ChargeWarmTime.HOUR_11.value) {
                return ChargeWarmTime.HOUR_11;
            }
            if(value == ChargeWarmTime.ON.value) {
                return ChargeWarmTime.ON;
            }
            return value == ChargeWarmTime.OFF.value ? ChargeWarmTime.OFF : ChargeWarmTime.__UNKNOWN__;
        }
    }

    public static enum DischgSetInfo {
        NO_INFORMATION(0),
        SET_SUCCEED_DISCHARGE_ALLOW(1),
        LOWER_THAN_SET_DISCHARGE_NOT_ALLOW(2),
        LOWER_OIL_SET_ENGINE_NOT_ALLOW(3),
        __UNKNOWN__(-1);

        public final int value;

        private DischgSetInfo(int value) {
            this.value = value;
        }

        public static DischgSetInfo valueOf(int value) {
            if(value == DischgSetInfo.NO_INFORMATION.value) {
                return DischgSetInfo.NO_INFORMATION;
            }
            if(value == DischgSetInfo.SET_SUCCEED_DISCHARGE_ALLOW.value) {
                return DischgSetInfo.SET_SUCCEED_DISCHARGE_ALLOW;
            }
            if(value == DischgSetInfo.LOWER_THAN_SET_DISCHARGE_NOT_ALLOW.value) {
                return DischgSetInfo.LOWER_THAN_SET_DISCHARGE_NOT_ALLOW;
            }
            return value == DischgSetInfo.LOWER_OIL_SET_ENGINE_NOT_ALLOW.value ? DischgSetInfo.LOWER_OIL_SET_ENGINE_NOT_ALLOW : DischgSetInfo.__UNKNOWN__;
        }
    }

    public static enum DriveModeEv {
        INVALID(0),
        ECO_PLUS_MODE(1),
        ECO_MODE(2),
        NORMAL_MODE(3),
        DRIVING_MODE(4),
        SPORT_MODE(5),
        IPEDAL_ON(6),
        IPEDAL_OFF(7),
        __UNKNOWN__(-1);

        public final int value;

        private DriveModeEv(int value) {
            this.value = value;
        }

        public static DriveModeEv valueOf(int value) {
            if(value == DriveModeEv.INVALID.value) {
                return DriveModeEv.INVALID;
            }
            if(value == DriveModeEv.ECO_PLUS_MODE.value) {
                return DriveModeEv.ECO_PLUS_MODE;
            }
            if(value == DriveModeEv.ECO_MODE.value) {
                return DriveModeEv.ECO_MODE;
            }
            if(value == DriveModeEv.NORMAL_MODE.value) {
                return DriveModeEv.NORMAL_MODE;
            }
            if(value == DriveModeEv.DRIVING_MODE.value) {
                return DriveModeEv.DRIVING_MODE;
            }
            if(value == DriveModeEv.SPORT_MODE.value) {
                return DriveModeEv.SPORT_MODE;
            }
            if(value == DriveModeEv.IPEDAL_ON.value) {
                return DriveModeEv.IPEDAL_ON;
            }
            return value == DriveModeEv.IPEDAL_OFF.value ? DriveModeEv.IPEDAL_OFF : DriveModeEv.__UNKNOWN__;
        }
    }

    public static enum EcoPlusMode {
        ON(1),
        OFF(2),
        __UNKNOWN__(-1);

        public final int value;

        private EcoPlusMode(int value) {
            this.value = value;
        }

        public static EcoPlusMode valueOf(int value) {
            if(value == EcoPlusMode.ON.value) {
                return EcoPlusMode.ON;
            }
            return value == EcoPlusMode.OFF.value ? EcoPlusMode.OFF : EcoPlusMode.__UNKNOWN__;
        }
    }

    public static enum EnergyModel {
        NORMAL(0),
        INTELLIGENT_HYBRID(1),
        ELECTICITY_DRIVE_FIRST(2),
        ELECTICITY_CONSERVATION(3),
        __UNKNOWN__(-1);

        public final int value;

        private EnergyModel(int value) {
            this.value = value;
        }

        public static EnergyModel valueOf(int value) {
            if(value == EnergyModel.NORMAL.value) {
                return EnergyModel.NORMAL;
            }
            if(value == EnergyModel.INTELLIGENT_HYBRID.value) {
                return EnergyModel.INTELLIGENT_HYBRID;
            }
            if(value == EnergyModel.ELECTICITY_DRIVE_FIRST.value) {
                return EnergyModel.ELECTICITY_DRIVE_FIRST;
            }
            return value == EnergyModel.ELECTICITY_CONSERVATION.value ? EnergyModel.ELECTICITY_CONSERVATION : EnergyModel.__UNKNOWN__;
        }
    }

    public static enum EngStartCfg {
        NO_REQUEST(0),
        ENGINE_START_ENABLE(1),
        ENGINE_START_DISABLE(2),
        __UNKNOWN__(-1);

        public final int value;

        private EngStartCfg(int value) {
            this.value = value;
        }

        public static EngStartCfg valueOf(int value) {
            if(value == EngStartCfg.NO_REQUEST.value) {
                return EngStartCfg.NO_REQUEST;
            }
            if(value == EngStartCfg.ENGINE_START_ENABLE.value) {
                return EngStartCfg.ENGINE_START_ENABLE;
            }
            return value == EngStartCfg.ENGINE_START_DISABLE.value ? EngStartCfg.ENGINE_START_DISABLE : EngStartCfg.__UNKNOWN__;
        }
    }

    public static enum GasPedalLevel {
        INVALID(0),
        LEVEL_1(1),
        LEVEL_2(2),
        LEVEL_3(3),
        LEVEL_4(4),
        LEVEL_5(5),
        __UNKNOWN__(-1);

        public final int value;

        private GasPedalLevel(int value) {
            this.value = value;
        }

        public static GasPedalLevel valueOf(int value) {
            if(value == GasPedalLevel.INVALID.value) {
                return GasPedalLevel.INVALID;
            }
            if(value == GasPedalLevel.LEVEL_1.value) {
                return GasPedalLevel.LEVEL_1;
            }
            if(value == GasPedalLevel.LEVEL_2.value) {
                return GasPedalLevel.LEVEL_2;
            }
            if(value == GasPedalLevel.LEVEL_3.value) {
                return GasPedalLevel.LEVEL_3;
            }
            if(value == GasPedalLevel.LEVEL_4.value) {
                return GasPedalLevel.LEVEL_4;
            }
            return value == GasPedalLevel.LEVEL_5.value ? GasPedalLevel.LEVEL_5 : GasPedalLevel.__UNKNOWN__;
        }
    }

    public static enum HealCheckNotice {
        NO_NOTICE(0),
        NOTICE(1),
        __UNKNOWN__(-1);

        public final int value;

        private HealCheckNotice(int value) {
            this.value = value;
        }

        public static HealCheckNotice valueOf(int value) {
            if(value == HealCheckNotice.NO_NOTICE.value) {
                return HealCheckNotice.NO_NOTICE;
            }
            return value == HealCheckNotice.NOTICE.value ? HealCheckNotice.NOTICE : HealCheckNotice.__UNKNOWN__;
        }
    }

    public static enum ObcConnState {
        DISCONNECTED(0),
        HALF_CONNECTED_CHARGING_V2V_V2L(1),
        CONNECTED_CHARGING_V2V(2),
        CONNECTED_V2L(4),
        __UNKNOWN__(-1);

        public final int value;

        private ObcConnState(int value) {
            this.value = value;
        }

        public static ObcConnState valueOf(int value) {
            if(value == ObcConnState.DISCONNECTED.value) {
                return ObcConnState.DISCONNECTED;
            }
            if(value == ObcConnState.HALF_CONNECTED_CHARGING_V2V_V2L.value) {
                return ObcConnState.HALF_CONNECTED_CHARGING_V2V_V2L;
            }
            if(value == ObcConnState.CONNECTED_CHARGING_V2V.value) {
                return ObcConnState.CONNECTED_CHARGING_V2V;
            }
            return value == ObcConnState.CONNECTED_V2L.value ? ObcConnState.CONNECTED_V2L : ObcConnState.__UNKNOWN__;
        }
    }

    public static enum PlugAutoUnlockCfg {
        NOT_AUTO_UNLOCK(0),
        AUTO_UNLOCK(1),
        __UNKNOWN__(-1);

        public final int value;

        private PlugAutoUnlockCfg(int value) {
            this.value = value;
        }

        public static PlugAutoUnlockCfg valueOf(int value) {
            if(value == PlugAutoUnlockCfg.NOT_AUTO_UNLOCK.value) {
                return PlugAutoUnlockCfg.NOT_AUTO_UNLOCK;
            }
            return value == PlugAutoUnlockCfg.AUTO_UNLOCK.value ? PlugAutoUnlockCfg.AUTO_UNLOCK : PlugAutoUnlockCfg.__UNKNOWN__;
        }
    }

    public static enum PowerFlowMode {
        VEHICLE_INITIAL(0),
        VEHICLE_STANDBY(1),
        IDLE_CHARGE(2),
        EV(3),
        RANGE_EXTEND_MODE1(4),
        RANGE_EXTEND_MODE2(5),
        ENGINE_MODE(7),
        HEV_MODE(8),
        REGENERATION_MODE(10),
        RANGE_EXTEND_MODE3(6),
        HEV_MODE2(9),
        __UNKNOWN__(-1);

        public final int value;

        private PowerFlowMode(int value) {
            this.value = value;
        }

        public static PowerFlowMode valueOf(int value) {
            if(value == PowerFlowMode.VEHICLE_INITIAL.value) {
                return PowerFlowMode.VEHICLE_INITIAL;
            }
            if(value == PowerFlowMode.VEHICLE_STANDBY.value) {
                return PowerFlowMode.VEHICLE_STANDBY;
            }
            if(value == PowerFlowMode.IDLE_CHARGE.value) {
                return PowerFlowMode.IDLE_CHARGE;
            }
            if(value == PowerFlowMode.EV.value) {
                return PowerFlowMode.EV;
            }
            if(value == PowerFlowMode.RANGE_EXTEND_MODE1.value) {
                return PowerFlowMode.RANGE_EXTEND_MODE1;
            }
            if(value == PowerFlowMode.RANGE_EXTEND_MODE2.value) {
                return PowerFlowMode.RANGE_EXTEND_MODE2;
            }
            if(value == PowerFlowMode.ENGINE_MODE.value) {
                return PowerFlowMode.ENGINE_MODE;
            }
            if(value == PowerFlowMode.HEV_MODE.value) {
                return PowerFlowMode.HEV_MODE;
            }
            if(value == PowerFlowMode.REGENERATION_MODE.value) {
                return PowerFlowMode.REGENERATION_MODE;
            }
            if(value == PowerFlowMode.RANGE_EXTEND_MODE3.value) {
                return PowerFlowMode.RANGE_EXTEND_MODE3;
            }
            return value == PowerFlowMode.HEV_MODE2.value ? PowerFlowMode.HEV_MODE2 : PowerFlowMode.__UNKNOWN__;
        }
    }

    public static enum RecpLevelAvail {
        L0_L3(0),
        L0_L1_AND_L2(1),
        L0(2),
        ALL_AVAILABLE(3),
        __UNKNOWN__(-1);

        public final int value;

        private RecpLevelAvail(int value) {
            this.value = value;
        }

        public static RecpLevelAvail valueOf(int value) {
            if(value == RecpLevelAvail.L0_L3.value) {
                return RecpLevelAvail.L0_L3;
            }
            if(value == RecpLevelAvail.L0_L1_AND_L2.value) {
                return RecpLevelAvail.L0_L1_AND_L2;
            }
            if(value == RecpLevelAvail.L0.value) {
                return RecpLevelAvail.L0;
            }
            return value == RecpLevelAvail.ALL_AVAILABLE.value ? RecpLevelAvail.ALL_AVAILABLE : RecpLevelAvail.__UNKNOWN__;
        }
    }

    public static enum RecuperationLevel {
        NOT_VALID(0),
        LEVEL_0_OFF(1),
        LEVEL_1_LOW(2),
        LEVEL_2_MIDDLE(3),
        LEVEL_3_HIGH(4),
        __UNKNOWN__(-1);

        public final int value;

        private RecuperationLevel(int value) {
            this.value = value;
        }

        public static RecuperationLevel valueOf(int value) {
            if(value == RecuperationLevel.NOT_VALID.value) {
                return RecuperationLevel.NOT_VALID;
            }
            if(value == RecuperationLevel.LEVEL_0_OFF.value) {
                return RecuperationLevel.LEVEL_0_OFF;
            }
            if(value == RecuperationLevel.LEVEL_1_LOW.value) {
                return RecuperationLevel.LEVEL_1_LOW;
            }
            if(value == RecuperationLevel.LEVEL_2_MIDDLE.value) {
                return RecuperationLevel.LEVEL_2_MIDDLE;
            }
            return value == RecuperationLevel.LEVEL_3_HIGH.value ? RecuperationLevel.LEVEL_3_HIGH : RecuperationLevel.__UNKNOWN__;
        }
    }

    public static enum RecuperationLevelA9E {
        NOT_VALID(0),
        LEVEL_1_OFF(1),
        LEVEL_2_LOW(2),
        LEVEL_3_MIDDLE(3),
        LEVEL_4_HIGH(4),
        __UNKNOWN__(-1);

        public final int value;

        private RecuperationLevelA9E(int value) {
            this.value = value;
        }

        public static RecuperationLevelA9E valueOf(int value) {
            if(value == RecuperationLevelA9E.NOT_VALID.value) {
                return RecuperationLevelA9E.NOT_VALID;
            }
            if(value == RecuperationLevelA9E.LEVEL_1_OFF.value) {
                return RecuperationLevelA9E.LEVEL_1_OFF;
            }
            if(value == RecuperationLevelA9E.LEVEL_2_LOW.value) {
                return RecuperationLevelA9E.LEVEL_2_LOW;
            }
            if(value == RecuperationLevelA9E.LEVEL_3_MIDDLE.value) {
                return RecuperationLevelA9E.LEVEL_3_MIDDLE;
            }
            return value == RecuperationLevelA9E.LEVEL_4_HIGH.value ? RecuperationLevelA9E.LEVEL_4_HIGH : RecuperationLevelA9E.__UNKNOWN__;
        }
    }

    public static enum RepeatBookMode {
        NOT_REPEAT(0),
        BOOKING(1),
        __UNKNOWN__(-1);

        public final int value;

        private RepeatBookMode(int value) {
            this.value = value;
        }

        public static RepeatBookMode valueOf(int value) {
            if(value == RepeatBookMode.NOT_REPEAT.value) {
                return RepeatBookMode.NOT_REPEAT;
            }
            return value == RepeatBookMode.BOOKING.value ? RepeatBookMode.BOOKING : RepeatBookMode.__UNKNOWN__;
        }
    }

    public static enum SocProgress {
        PROGRESS_0(0),
        PROGRESS_1(1),
        PROGRESS_2(2),
        PROGRESS_3(3),
        PROGRESS_4(4),
        PROGRESS_5(5),
        PROGRESS_6(6),
        PROGRESS_7(7),
        PROGRESS_8(8),
        __UNKNOWN__(-1);

        public final int value;

        private SocProgress(int value) {
            this.value = value;
        }

        public static SocProgress valueOf(int value) {
            if(value == SocProgress.PROGRESS_0.value) {
                return SocProgress.PROGRESS_0;
            }
            if(value == SocProgress.PROGRESS_1.value) {
                return SocProgress.PROGRESS_1;
            }
            if(value == SocProgress.PROGRESS_2.value) {
                return SocProgress.PROGRESS_2;
            }
            if(value == SocProgress.PROGRESS_3.value) {
                return SocProgress.PROGRESS_3;
            }
            if(value == SocProgress.PROGRESS_4.value) {
                return SocProgress.PROGRESS_4;
            }
            if(value == SocProgress.PROGRESS_5.value) {
                return SocProgress.PROGRESS_5;
            }
            if(value == SocProgress.PROGRESS_6.value) {
                return SocProgress.PROGRESS_6;
            }
            if(value == SocProgress.PROGRESS_7.value) {
                return SocProgress.PROGRESS_7;
            }
            return value == SocProgress.PROGRESS_8.value ? SocProgress.PROGRESS_8 : SocProgress.__UNKNOWN__;
        }
    }

    public static enum XDriveMode {
        INVALID_MODE(0),
        ECO_MODE(1),
        NORMAL_MODE(2),
        SPORT_MODE(3),
        __UNKNOWN__(-1);

        public final int value;

        private XDriveMode(int value) {
            this.value = value;
        }

        public static XDriveMode valueOf(int value) {
            if(value == XDriveMode.INVALID_MODE.value) {
                return XDriveMode.INVALID_MODE;
            }
            if(value == XDriveMode.ECO_MODE.value) {
                return XDriveMode.ECO_MODE;
            }
            if(value == XDriveMode.NORMAL_MODE.value) {
                return XDriveMode.NORMAL_MODE;
            }
            return value == XDriveMode.SPORT_MODE.value ? XDriveMode.SPORT_MODE : XDriveMode.__UNKNOWN__;
        }
    }

    public static final int AVDC_MODE_EV = 0x2CF;
    public static final int AVDC_MODE_EV_SETTING = 720;
    public static final int BATTERY_QUANTITY_PERCENT = 314;
    public static final int BOOK_CHRG_START_DAY = 385;
    public static final int BOOK_CHRG_START_HOUR = 386;
    public static final int BOOK_CHRG_START_MIN = 387;
    public static final int BOOK_CHRG_START_MON = 0x180;
    public static final int BOOK_CHRG_START_REMAINING_DAY = 380;
    public static final int BOOK_CHRG_START_REMAINING_HOUR = 381;
    public static final int BOOK_CHRG_START_REMAINING_MIN = 382;
    public static final int BOOK_CHRG_START_YEAR = 0x17F;
    public static final int BOOK_CHRG_STOP_DAY = 390;
    public static final int BOOK_CHRG_STOP_HOUR = 391;
    public static final int BOOK_CHRG_STOP_MIN = 392;
    public static final int BOOK_CHRG_STOP_MON = 389;
    public static final int BOOK_CHRG_STOP_YEAR = 388;
    public static final int CHARGE_FULL_NOTICE_LEVEL = 324;
    public static final int CHARGE_MODE_STATE = 393;
    public static final int CHARGE_SOC_PERCENT_SETTING = 0x13F;
    public static final int CHARGE_SOC_PERCENT_STATE = 318;
    public static final int CHARGE_SOC_PERCENT_VALID_STATE = 320;
    public static final int CHARGE_WARM_TIME_SETTING = 322;
    public static final int CHARGE_WARM_TIME_STATE = 321;
    public static final int CHARGE_WARM_TIME_VALID_STATE = 323;
    public static final int CHARG_CURRENT_SETTING = 493;
    public static final int CHARG_CURRENT_STATE = 492;
    public static final int CHG_ACTIVE_STATE = 490;
    public static final int CHG_END_REQ_SETTING = 491;
    public static final int DISCHG_ACTIVE_SETTING = 483;
    public static final int DISCHG_ACTIVE_STATE = 482;
    public static final int DISCHG_END_VEHRNG_STATE = 484;
    public static final int DISCHG_ENG_START_CFG_SETTING = 0x1DF;
    public static final int DISCHG_ENG_START_CFG_STATE = 478;
    public static final int DISCHG_SET_INFO = 494;
    public static final int DISCHG_SOC_CFG_SETTING = 481;
    public static final int DISCHG_SOC_CFG_STATE = 480;
    public static final int DISCHG_TIME_CFG_SETTING = 486;
    public static final int DISCHG_TIME_CFG_STATE = 485;
    public static final int DRIVE_MODE_EV = 355;
    public static final int DRIVE_MODE_EV_SETTING = 356;
    public static final int DRV_TARGET_SOE_SETTING = 477;
    public static final int DRV_TARGET_SOE_STATE = 476;
    public static final int DSP_CHG_STATE = 489;
    public static final int ECO_MODE_VALID_STATE = 359;
    public static final int ECO_NORMAL_SPORT_MODE_VALID_STATE = 361;
    public static final int ECO_PLUS_MODE = 357;
    public static final int ECO_PLUS_MODE_VALID_STATE = 358;
    public static final int ENERGY_MODEL = 474;
    public static final int ENERGY_MODEL_SETTING = 475;
    public static final int ENG_SELF_MAINT_DISP_STATE = 473;
    public static final int GAS_PEDAL_LEVEL_EV = 721;
    public static final int GAS_PEDAL_LEVEL_EV_SETTING = 722;
    public static final int HEAL_CHECK_NOTICE_STATE = 325;
    public static final int HV_EM_POWER_FLOW_STATE = 643;
    public static final int HV_EP_POWER_FLOW_STATE = 642;
    public static final int HV_M2B_POWER_FLOW_STATE = 646;
    public static final int HV_MB_POWER_FLOW_STATE = 645;
    public static final int HV_MP_POWER_FLOW_STATE = 644;
    public static final int IPEDAL_CREEP_SETTING = 316;
    public static final int IPEDAL_CREEP_STATE = 315;
    public static final int IPEDAL_CREEP_VALID_STATE = 317;
    public static final int IPEDAL_MODE_VALID_STATE = 360;
    public static final int OBC_CONN_STATE = 0x201;
    public static final int PLUG_AUTO_UNLOCK_CFG = 487;
    public static final int PLUG_AUTO_UNLOCK_CFG_SETTING = 488;
    public static final int POWER_FLOW_MODE = 313;
    public static final int RECUPERATION_LEVEL = 0x160;
    public static final int RECUPERATION_LEVEL_A9E = 412;
    public static final int RECUPERATION_LEVEL_A9E_SETTING = 413;
    public static final int RECUPERATION_LEVEL_SETTING = 353;
    public static final int RECUPERATION_LEVEL_VALID_STATE = 354;
    public static final int REPEAT_BOOK_CHRG_DAY1 = 394;
    public static final int REPEAT_BOOK_CHRG_DAY2 = 395;
    public static final int REPEAT_BOOK_CHRG_DAY3 = 396;
    public static final int REPEAT_BOOK_CHRG_DAY4 = 397;
    public static final int REPEAT_BOOK_CHRG_DAY5 = 398;
    public static final int REPEAT_BOOK_CHRG_DAY6 = 0x18F;
    public static final int REPEAT_BOOK_CHRG_DAY7 = 400;
    public static final int SOC_MON_PROGRESS_STATE = -1;
    public static final int VEH_RDY_STATE = 472;
    public static final int X_DRIVE_MODE_EV = 726;
    public static final int X_DRIVE_MODE_EV_SETTING = 727;

}

