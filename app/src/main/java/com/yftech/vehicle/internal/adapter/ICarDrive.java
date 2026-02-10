package com.yftech.vehicle.internal.adapter;

public interface ICarDrive extends IBaseApi {
    public static enum AutoHoldState {
        OFF(0),
        ON(1),
        STANDBY(2),
        FAILURE(3),
        __UNKNOWN__(-1);

        public final int value;

        private AutoHoldState(int v1) {
            this.value = v1;
        }

        public static AutoHoldState valueOf(int v) {
            if(v == AutoHoldState.OFF.value) {
                return AutoHoldState.OFF;
            }
            if(v == AutoHoldState.ON.value) {
                return AutoHoldState.ON;
            }
            if(v == AutoHoldState.STANDBY.value) {
                return AutoHoldState.STANDBY;
            }
            return v == AutoHoldState.FAILURE.value ? AutoHoldState.FAILURE : AutoHoldState.__UNKNOWN__;
        }
    }

    public static enum AvdcMode {
        INVALID(0),
        MODEST_MODEL(1),
        RADICAL_MODEL(2),
        ON_LOW_ADHESION_ROAD(3),
        ADAPTIVE_MODEL(4),
        OFF(5),
        __UNKNOWN__(-1);

        public final int value;

        private AvdcMode(int v1) {
            this.value = v1;
        }

        public static AvdcMode valueOf(int v) {
            if(v == AvdcMode.INVALID.value) {
                return AvdcMode.INVALID;
            }
            if(v == AvdcMode.MODEST_MODEL.value) {
                return AvdcMode.MODEST_MODEL;
            }
            if(v == AvdcMode.RADICAL_MODEL.value) {
                return AvdcMode.RADICAL_MODEL;
            }
            if(v == AvdcMode.ON_LOW_ADHESION_ROAD.value) {
                return AvdcMode.ON_LOW_ADHESION_ROAD;
            }
            if(v == AvdcMode.ADAPTIVE_MODEL.value) {
                return AvdcMode.ADAPTIVE_MODEL;
            }
            return v == AvdcMode.OFF.value ? AvdcMode.OFF : AvdcMode.__UNKNOWN__;
        }
    }

    public static enum CDCStyleMode {
        NO_COMMAND(0),
        COMFORT_MODE(1),
        SPORT_MODE(3),
        __UNKNOWN__(-1);

        public final int value;

        private CDCStyleMode(int v1) {
            this.value = v1;
        }

        public static CDCStyleMode valueOf(int v) {
            if(v == CDCStyleMode.NO_COMMAND.value) {
                return CDCStyleMode.NO_COMMAND;
            }
            if(v == CDCStyleMode.COMFORT_MODE.value) {
                return CDCStyleMode.COMFORT_MODE;
            }
            return v == CDCStyleMode.SPORT_MODE.value ? CDCStyleMode.SPORT_MODE : CDCStyleMode.__UNKNOWN__;
        }
    }

    public static enum DriveMode {
        NOT_VALID(0),
        ECO_PRO_MODE(1),
        COMFORT_MODE(2),
        SPORT_MODE(3),
        INDIVIDUAL_MODE(4),
        SPORT_PLUS_MODE(5),
        AI_MODE(6),
        OFFROAD_MODE(7),
        ATS_SAND(8),
        ATS_MUD(9),
        ATS_SNOW(10),
        __UNKNOWN__(-1);

        public final int value;

        private DriveMode(int v1) {
            this.value = v1;
        }

        public static DriveMode valueOf(int v) {
            if(v == DriveMode.NOT_VALID.value) {
                return DriveMode.NOT_VALID;
            }
            if(v == DriveMode.ECO_PRO_MODE.value) {
                return DriveMode.ECO_PRO_MODE;
            }
            if(v == DriveMode.COMFORT_MODE.value) {
                return DriveMode.COMFORT_MODE;
            }
            if(v == DriveMode.SPORT_MODE.value) {
                return DriveMode.SPORT_MODE;
            }
            if(v == DriveMode.INDIVIDUAL_MODE.value) {
                return DriveMode.INDIVIDUAL_MODE;
            }
            if(v == DriveMode.SPORT_PLUS_MODE.value) {
                return DriveMode.SPORT_PLUS_MODE;
            }
            if(v == DriveMode.AI_MODE.value) {
                return DriveMode.AI_MODE;
            }
            if(v == DriveMode.OFFROAD_MODE.value) {
                return DriveMode.OFFROAD_MODE;
            }
            if(v == DriveMode.ATS_SAND.value) {
                return DriveMode.ATS_SAND;
            }
            if(v == DriveMode.ATS_MUD.value) {
                return DriveMode.ATS_MUD;
            }
            return v == DriveMode.ATS_SNOW.value ? DriveMode.ATS_SNOW : DriveMode.__UNKNOWN__;
        }
    }

    public static enum DriveModeHev {
        NORMAL_MODE(0),
        ECO_MODE(1),
        SPORT_MODE(2),
        OFFROAD_MODE(3),
        __UNKNOWN__(-1);

        public final int value;

        private DriveModeHev(int v1) {
            this.value = v1;
        }

        public static DriveModeHev valueOf(int v) {
            if(v == DriveModeHev.NORMAL_MODE.value) {
                return DriveModeHev.NORMAL_MODE;
            }
            if(v == DriveModeHev.ECO_MODE.value) {
                return DriveModeHev.ECO_MODE;
            }
            if(v == DriveModeHev.SPORT_MODE.value) {
                return DriveModeHev.SPORT_MODE;
            }
            return v == DriveModeHev.OFFROAD_MODE.value ? DriveModeHev.OFFROAD_MODE : DriveModeHev.__UNKNOWN__;
        }
    }

    public static enum DriveSystemMode {
        NORMAL(0),
        ECO(1),
        SPORT(2),
        WINTER(3),
        MANUAL(4),
        SPORT_PLUS(5),
        __UNKNOWN__(-1);

        public final int value;

        private DriveSystemMode(int v1) {
            this.value = v1;
        }

        public static DriveSystemMode valueOf(int v) {
            if(v == DriveSystemMode.NORMAL.value) {
                return DriveSystemMode.NORMAL;
            }
            if(v == DriveSystemMode.ECO.value) {
                return DriveSystemMode.ECO;
            }
            if(v == DriveSystemMode.SPORT.value) {
                return DriveSystemMode.SPORT;
            }
            if(v == DriveSystemMode.WINTER.value) {
                return DriveSystemMode.WINTER;
            }
            if(v == DriveSystemMode.MANUAL.value) {
                return DriveSystemMode.MANUAL;
            }
            return v == DriveSystemMode.SPORT_PLUS.value ? DriveSystemMode.SPORT_PLUS : DriveSystemMode.__UNKNOWN__;
        }
    }

    public static enum EPSStyle {
        COMFORT(1),
        LIGHT(2),
        SPORT(3),
        __UNKNOWN__(-1);

        public final int value;

        private EPSStyle(int v1) {
            this.value = v1;
        }

        public static EPSStyle valueOf(int v) {
            if(v == EPSStyle.COMFORT.value) {
                return EPSStyle.COMFORT;
            }
            if(v == EPSStyle.LIGHT.value) {
                return EPSStyle.LIGHT;
            }
            return v == EPSStyle.SPORT.value ? EPSStyle.SPORT : EPSStyle.__UNKNOWN__;
        }
    }

    public static enum EpsModeState {
        NOT_READY(0),
        READY(1),
        IN_TRANSITION(2),
        FAULT(3),
        __UNKNOWN__(-1);

        public final int value;

        private EpsModeState(int v1) {
            this.value = v1;
        }

        public static EpsModeState valueOf(int v) {
            if(v == EpsModeState.NOT_READY.value) {
                return EpsModeState.NOT_READY;
            }
            if(v == EpsModeState.READY.value) {
                return EpsModeState.READY;
            }
            if(v == EpsModeState.IN_TRANSITION.value) {
                return EpsModeState.IN_TRANSITION;
            }
            return v == EpsModeState.FAULT.value ? EpsModeState.FAULT : EpsModeState.__UNKNOWN__;
        }
    }

    public static enum EspState {
        ESP_ON(0, 1),
        TCS_OFF(1, 2),
        ESP_OFF(2, -1),
        ESP_FAILURE(3, -1),
        TCS_OFF_VDC_OFF(-2, 3),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private EspState(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static EspState valueOf(int v) {
            if(v == EspState.ESP_ON.rx) {
                return EspState.ESP_ON;
            }
            if(v == EspState.TCS_OFF.rx) {
                return EspState.TCS_OFF;
            }
            if(v == EspState.ESP_OFF.rx) {
                return EspState.ESP_OFF;
            }
            if(v == EspState.ESP_FAILURE.rx) {
                return EspState.ESP_FAILURE;
            }
            return v == EspState.TCS_OFF_VDC_OFF.rx ? EspState.TCS_OFF_VDC_OFF : EspState.__UNKNOWN__;
        }
    }

    public static enum EspStyle {
        NORMAL(0),
        SNOW(1),
        MUD(2),
        SAND(3),
        SPORT(4),
        __UNKNOWN__(-1);

        public final int value;

        private EspStyle(int v1) {
            this.value = v1;
        }

        public static EspStyle valueOf(int v) {
            if(v == EspStyle.NORMAL.value) {
                return EspStyle.NORMAL;
            }
            if(v == EspStyle.SNOW.value) {
                return EspStyle.SNOW;
            }
            if(v == EspStyle.MUD.value) {
                return EspStyle.MUD;
            }
            if(v == EspStyle.SAND.value) {
                return EspStyle.SAND;
            }
            return v == EspStyle.SPORT.value ? EspStyle.SPORT : EspStyle.__UNKNOWN__;
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

        private GasPedalLevel(int v1) {
            this.value = v1;
        }

        public static GasPedalLevel valueOf(int v) {
            if(v == GasPedalLevel.INVALID.value) {
                return GasPedalLevel.INVALID;
            }
            if(v == GasPedalLevel.LEVEL_1.value) {
                return GasPedalLevel.LEVEL_1;
            }
            if(v == GasPedalLevel.LEVEL_2.value) {
                return GasPedalLevel.LEVEL_2;
            }
            if(v == GasPedalLevel.LEVEL_3.value) {
                return GasPedalLevel.LEVEL_3;
            }
            if(v == GasPedalLevel.LEVEL_4.value) {
                return GasPedalLevel.LEVEL_4;
            }
            return v == GasPedalLevel.LEVEL_5.value ? GasPedalLevel.LEVEL_5 : GasPedalLevel.__UNKNOWN__;
        }
    }

    public static enum HdcState {
        HDC_OFF(0, 1),
        HDC_ON(1, 2),
        HDC_FAILURE(2, -1),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private HdcState(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static HdcState valueOf(int v) {
            if(v == HdcState.HDC_OFF.rx) {
                return HdcState.HDC_OFF;
            }
            if(v == HdcState.HDC_ON.rx) {
                return HdcState.HDC_ON;
            }
            return v == HdcState.HDC_FAILURE.rx ? HdcState.HDC_FAILURE : HdcState.__UNKNOWN__;
        }
    }

    public static enum MemoryDriveMode {
        NOT_MEMORY(1, 0),
        MEMORY(2, 1),
        NOT_USED(3, -1),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private MemoryDriveMode(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static MemoryDriveMode valueOf(int v) {
            if(v == MemoryDriveMode.NOT_MEMORY.rx) {
                return MemoryDriveMode.NOT_MEMORY;
            }
            if(v == MemoryDriveMode.MEMORY.rx) {
                return MemoryDriveMode.MEMORY;
            }
            return v == MemoryDriveMode.NOT_USED.rx ? MemoryDriveMode.NOT_USED : MemoryDriveMode.__UNKNOWN__;
        }
    }

    public static enum MemoryDriveMode_A9E {
        MEMORY(2, 2),
        NOT_MEMORY(1, 1),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private MemoryDriveMode_A9E(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static MemoryDriveMode_A9E valueOf(int v) {
            if(v == MemoryDriveMode_A9E.MEMORY.rx) {
                return MemoryDriveMode_A9E.MEMORY;
            }
            return v == MemoryDriveMode_A9E.NOT_MEMORY.rx ? MemoryDriveMode_A9E.NOT_MEMORY : MemoryDriveMode_A9E.__UNKNOWN__;
        }
    }

    public static enum MrrAccMode {
        OFF(0),
        PASSIVE(1),
        STANDBY(2),
        ACTIVE_CONTROL(3),
        BRAKE_ONLY(4),
        OVER_RIDE(5),
        STAND_WAIT(6),
        FAILURE(7),
        __UNKNOWN__(-1);

        public final int value;

        private MrrAccMode(int v1) {
            this.value = v1;
        }

        public static MrrAccMode valueOf(int v) {
            if(v == MrrAccMode.OFF.value) {
                return MrrAccMode.OFF;
            }
            if(v == MrrAccMode.PASSIVE.value) {
                return MrrAccMode.PASSIVE;
            }
            if(v == MrrAccMode.STANDBY.value) {
                return MrrAccMode.STANDBY;
            }
            if(v == MrrAccMode.ACTIVE_CONTROL.value) {
                return MrrAccMode.ACTIVE_CONTROL;
            }
            if(v == MrrAccMode.BRAKE_ONLY.value) {
                return MrrAccMode.BRAKE_ONLY;
            }
            if(v == MrrAccMode.OVER_RIDE.value) {
                return MrrAccMode.OVER_RIDE;
            }
            if(v == MrrAccMode.STAND_WAIT.value) {
                return MrrAccMode.STAND_WAIT;
            }
            return v == MrrAccMode.FAILURE.value ? MrrAccMode.FAILURE : MrrAccMode.__UNKNOWN__;
        }
    }

    public static enum TcuDriveMode {
        NORMAL(0),
        SPORT(1),
        WINTER(2),
        UPSLOPE_ONE(3),
        HOT_ONE(4),
        UPSLOPE_TWO(5),
        HOT_TWO(6),
        WUSP(7),
        CRUISE(8),
        TIPTRONIC(9),
        ECO(10),
        HIGH_ALTITUDE(11),
        SPORT_PLUS(12),
        OFF_ROAD(13),
        __UNKNOWN__(-1);

        public final int value;

        private TcuDriveMode(int v1) {
            this.value = v1;
        }

        public static TcuDriveMode valueOf(int v) {
            if(v == TcuDriveMode.NORMAL.value) {
                return TcuDriveMode.NORMAL;
            }
            if(v == TcuDriveMode.SPORT.value) {
                return TcuDriveMode.SPORT;
            }
            if(v == TcuDriveMode.WINTER.value) {
                return TcuDriveMode.WINTER;
            }
            if(v == TcuDriveMode.UPSLOPE_ONE.value) {
                return TcuDriveMode.UPSLOPE_ONE;
            }
            if(v == TcuDriveMode.HOT_ONE.value) {
                return TcuDriveMode.HOT_ONE;
            }
            if(v == TcuDriveMode.UPSLOPE_TWO.value) {
                return TcuDriveMode.UPSLOPE_TWO;
            }
            if(v == TcuDriveMode.HOT_TWO.value) {
                return TcuDriveMode.HOT_TWO;
            }
            if(v == TcuDriveMode.WUSP.value) {
                return TcuDriveMode.WUSP;
            }
            if(v == TcuDriveMode.CRUISE.value) {
                return TcuDriveMode.CRUISE;
            }
            if(v == TcuDriveMode.TIPTRONIC.value) {
                return TcuDriveMode.TIPTRONIC;
            }
            if(v == TcuDriveMode.ECO.value) {
                return TcuDriveMode.ECO;
            }
            if(v == TcuDriveMode.HIGH_ALTITUDE.value) {
                return TcuDriveMode.HIGH_ALTITUDE;
            }
            if(v == TcuDriveMode.SPORT_PLUS.value) {
                return TcuDriveMode.SPORT_PLUS;
            }
            return v == TcuDriveMode.OFF_ROAD.value ? TcuDriveMode.OFF_ROAD : TcuDriveMode.__UNKNOWN__;
        }
    }

    public static enum VdcOffState {
        OFF(1),
        ON(0),
        __UNKNOWN__(-1);

        public final int value;

        private VdcOffState(int v1) {
            this.value = v1;
        }

        public static VdcOffState valueOf(int v) {
            if(v == VdcOffState.OFF.value) {
                return VdcOffState.OFF;
            }
            return v == VdcOffState.ON.value ? VdcOffState.ON : VdcOffState.__UNKNOWN__;
        }
    }

    public static enum XDriveMode {
        NORMAL_MODE(0, 1),
        ECO_MODE(1, 2),
        SPORT_MODE(2, 3),
        SPORT_PLUS_MODE(3, 4),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private XDriveMode(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static XDriveMode valueOf(int v) {
            if(v == XDriveMode.NORMAL_MODE.rx) {
                return XDriveMode.NORMAL_MODE;
            }
            if(v == XDriveMode.ECO_MODE.rx) {
                return XDriveMode.ECO_MODE;
            }
            if(v == XDriveMode.SPORT_MODE.rx) {
                return XDriveMode.SPORT_MODE;
            }
            return v == XDriveMode.SPORT_PLUS_MODE.rx ? XDriveMode.SPORT_PLUS_MODE : XDriveMode.__UNKNOWN__;
        }
    }

    public static final int ASSIST_PARA_SWITCH_REQ_STATE = 444;
    public static final int AUTO_HOLD_SETTING = 0x120;
    public static final int AUTO_HOLD_STATE = 0x11F;
    public static final int AVDC_MODE = 0xDE;
    public static final int AVDC_MODE_SETTING = 0xDF;
    public static final int BCS_VDC_OFF_STATE = 405;
    public static final int CDCSTYLE_MODE = 568;
    public static final int CDCSTYLE_MODE_SETTING = 569;
    public static final int DRIVE_MODE = 0xB3;
    public static final int DRIVE_MODE_HEV = 406;
    public static final int DRIVE_MODE_SETTING = 71;
    public static final int DRIVE_SYSTEM_MODE = 0x105;
    public static final int EMS_ENGINE_WAVE_SETTING = 73;
    public static final int EMS_ENGINE_WAVE_STATE = 0xB5;
    public static final int EPB_IND_STATE = 674;
    public static final int EPS_MODE_STATE = 291;
    public static final int EPS_STYLE = 180;
    public static final int EPS_STYLE_SETTING = 72;
    public static final int ESP_STATE = 0xD7;
    public static final int ESP_STATE_SETTING = 0xD8;
    public static final int ESP_STYLE = 290;
    public static final int GAS_PEDAL_LEVEL = 0xE0;
    public static final int GAS_PEDAL_LEVEL_SETTING = 0xE1;
    public static final int HDC_STATE = 0xD9;
    public static final int HDC_STATE_SETTING = 0xDA;
    public static final int MEMORY_DRIVE_MODE = 0xCF;
    public static final int MEMORY_DRIVE_MODE_A9E = 422;
    public static final int MEMORY_DRIVE_MODE_SETTING = 0xD0;
    public static final int MRR_ACC_MODE = 421;
    public static final int TCU_DRIVE_MODE = 260;
    public static final int TCU_DRIVE_MODE_SETTING = 662;
    public static final int XDRIVE_MODE = 566;
    public static final int XDRIVE_MODE_SETTING = 567;

}

