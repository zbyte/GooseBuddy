package com.yftech.vehicle.internal.adapter;

public interface ICarDrive extends IBaseApi {
    public static enum AutoHoldState {
        OFF(0),
        ON(1),
        STANDBY(2),
        FAILURE(3),
        __UNKNOWN__(-1);

        public final int value;

        private AutoHoldState(int value) {
            this.value = value;
        }

        public static AutoHoldState valueOf(int value) {
            if(value == AutoHoldState.OFF.value) {
                return AutoHoldState.OFF;
            }
            if(value == AutoHoldState.ON.value) {
                return AutoHoldState.ON;
            }
            if(value == AutoHoldState.STANDBY.value) {
                return AutoHoldState.STANDBY;
            }
            return value == AutoHoldState.FAILURE.value ? AutoHoldState.FAILURE : AutoHoldState.__UNKNOWN__;
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

    public static enum CDCStyleMode {
        NO_COMMAND(0),
        COMFORT_MODE(1),
        SPORT_MODE(3),
        __UNKNOWN__(-1);

        public final int value;

        private CDCStyleMode(int value) {
            this.value = value;
        }

        public static CDCStyleMode valueOf(int value) {
            if(value == CDCStyleMode.NO_COMMAND.value) {
                return CDCStyleMode.NO_COMMAND;
            }
            if(value == CDCStyleMode.COMFORT_MODE.value) {
                return CDCStyleMode.COMFORT_MODE;
            }
            return value == CDCStyleMode.SPORT_MODE.value ? CDCStyleMode.SPORT_MODE : CDCStyleMode.__UNKNOWN__;
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

        private DriveMode(int value) {
            this.value = value;
        }

        public static DriveMode valueOf(int value) {
            if(value == DriveMode.NOT_VALID.value) {
                return DriveMode.NOT_VALID;
            }
            if(value == DriveMode.ECO_PRO_MODE.value) {
                return DriveMode.ECO_PRO_MODE;
            }
            if(value == DriveMode.COMFORT_MODE.value) {
                return DriveMode.COMFORT_MODE;
            }
            if(value == DriveMode.SPORT_MODE.value) {
                return DriveMode.SPORT_MODE;
            }
            if(value == DriveMode.INDIVIDUAL_MODE.value) {
                return DriveMode.INDIVIDUAL_MODE;
            }
            if(value == DriveMode.SPORT_PLUS_MODE.value) {
                return DriveMode.SPORT_PLUS_MODE;
            }
            if(value == DriveMode.AI_MODE.value) {
                return DriveMode.AI_MODE;
            }
            if(value == DriveMode.OFFROAD_MODE.value) {
                return DriveMode.OFFROAD_MODE;
            }
            if(value == DriveMode.ATS_SAND.value) {
                return DriveMode.ATS_SAND;
            }
            if(value == DriveMode.ATS_MUD.value) {
                return DriveMode.ATS_MUD;
            }
            return value == DriveMode.ATS_SNOW.value ? DriveMode.ATS_SNOW : DriveMode.__UNKNOWN__;
        }
    }

    public static enum DriveModeHev {
        NORMAL_MODE(0),
        ECO_MODE(1),
        SPORT_MODE(2),
        __UNKNOWN__(-1);

        public final int value;

        private DriveModeHev(int value) {
            this.value = value;
        }

        public static DriveModeHev valueOf(int value) {
            if(value == DriveModeHev.NORMAL_MODE.value) {
                return DriveModeHev.NORMAL_MODE;
            }
            if(value == DriveModeHev.ECO_MODE.value) {
                return DriveModeHev.ECO_MODE;
            }
            return value == DriveModeHev.SPORT_MODE.value ? DriveModeHev.SPORT_MODE : DriveModeHev.__UNKNOWN__;
        }
    }

    public static enum DriveSystemMode {
        NORMAL(0),
        ECO(1),
        SPORT(2),
        SPORT_PLUS(3),
        __UNKNOWN__(-1);

        public final int value;

        private DriveSystemMode(int value) {
            this.value = value;
        }

        public static DriveSystemMode valueOf(int value) {
            if(value == DriveSystemMode.NORMAL.value) {
                return DriveSystemMode.NORMAL;
            }
            if(value == DriveSystemMode.ECO.value) {
                return DriveSystemMode.ECO;
            }
            if(value == DriveSystemMode.SPORT.value) {
                return DriveSystemMode.SPORT;
            }
            return value == DriveSystemMode.SPORT_PLUS.value ? DriveSystemMode.SPORT_PLUS : DriveSystemMode.__UNKNOWN__;
        }
    }

    public static enum EPSStyle {
        COMFORT(1),
        LIGHT(2),
        SPORT(3),
        __UNKNOWN__(-1);

        public final int value;

        private EPSStyle(int value) {
            this.value = value;
        }

        public static EPSStyle valueOf(int value) {
            if(value == EPSStyle.COMFORT.value) {
                return EPSStyle.COMFORT;
            }
            if(value == EPSStyle.LIGHT.value) {
                return EPSStyle.LIGHT;
            }
            return value == EPSStyle.SPORT.value ? EPSStyle.SPORT : EPSStyle.__UNKNOWN__;
        }
    }

    public static enum EpsModeState {
        NOT_READY(0),
        READY(1),
        IN_TRANSITION(2),
        FAULT(3),
        __UNKNOWN__(-1);

        public final int value;

        private EpsModeState(int value) {
            this.value = value;
        }

        public static EpsModeState valueOf(int value) {
            if(value == EpsModeState.NOT_READY.value) {
                return EpsModeState.NOT_READY;
            }
            if(value == EpsModeState.READY.value) {
                return EpsModeState.READY;
            }
            if(value == EpsModeState.IN_TRANSITION.value) {
                return EpsModeState.IN_TRANSITION;
            }
            return value == EpsModeState.FAULT.value ? EpsModeState.FAULT : EpsModeState.__UNKNOWN__;
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

        private EspState(int rx, int tx) {
            this.rx = rx;
            this.tx = tx;
            this.value = this.tx;
        }

        public static EspState valueOf(int value) {
            if(value == EspState.ESP_ON.rx) {
                return EspState.ESP_ON;
            }
            if(value == EspState.TCS_OFF.rx) {
                return EspState.TCS_OFF;
            }
            if(value == EspState.ESP_OFF.rx) {
                return EspState.ESP_OFF;
            }
            if(value == EspState.ESP_FAILURE.rx) {
                return EspState.ESP_FAILURE;
            }
            return value == EspState.TCS_OFF_VDC_OFF.rx ? EspState.TCS_OFF_VDC_OFF : EspState.__UNKNOWN__;
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

        private EspStyle(int value) {
            this.value = value;
        }

        public static EspStyle valueOf(int value) {
            if(value == EspStyle.NORMAL.value) {
                return EspStyle.NORMAL;
            }
            if(value == EspStyle.SNOW.value) {
                return EspStyle.SNOW;
            }
            if(value == EspStyle.MUD.value) {
                return EspStyle.MUD;
            }
            if(value == EspStyle.SAND.value) {
                return EspStyle.SAND;
            }
            return value == EspStyle.SPORT.value ? EspStyle.SPORT : EspStyle.__UNKNOWN__;
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

    public static enum HdcState {
        HDC_OFF(0, 1),
        HDC_ON(1, 2),
        HDC_FAILURE(2, -1),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private HdcState(int rx, int tx) {
            this.rx = rx;
            this.tx = tx;
            this.value = this.tx;
        }

        public static HdcState valueOf(int value) {
            if(value == HdcState.HDC_OFF.rx) {
                return HdcState.HDC_OFF;
            }
            if(value == HdcState.HDC_ON.rx) {
                return HdcState.HDC_ON;
            }
            return value == HdcState.HDC_FAILURE.rx ? HdcState.HDC_FAILURE : HdcState.__UNKNOWN__;
        }
    }

    public static enum MemoryDriveMode {
        MEMORY(1, 2),
        NOT_MEMORY(0, 1),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private MemoryDriveMode(int rx, int tx) {
            this.rx = rx;
            this.tx = tx;
            this.value = this.tx;
        }

        public static MemoryDriveMode valueOf(int value) {
            if(value == MemoryDriveMode.MEMORY.rx) {
                return MemoryDriveMode.MEMORY;
            }
            return value == MemoryDriveMode.NOT_MEMORY.rx ? MemoryDriveMode.NOT_MEMORY : MemoryDriveMode.__UNKNOWN__;
        }
    }

    public static enum MemoryDriveMode_A9E {
        MEMORY(2, 2),
        NOT_MEMORY(1, 1),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private MemoryDriveMode_A9E(int rx, int tx) {
            this.rx = rx;
            this.tx = tx;
            this.value = this.tx;
        }

        public static MemoryDriveMode_A9E valueOf(int value) {
            if(value == MemoryDriveMode_A9E.MEMORY.rx) {
                return MemoryDriveMode_A9E.MEMORY;
            }
            return value == MemoryDriveMode_A9E.NOT_MEMORY.rx ? MemoryDriveMode_A9E.NOT_MEMORY : MemoryDriveMode_A9E.__UNKNOWN__;
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

        private MrrAccMode(int value) {
            this.value = value;
        }

        public static MrrAccMode valueOf(int value) {
            if(value == MrrAccMode.OFF.value) {
                return MrrAccMode.OFF;
            }
            if(value == MrrAccMode.PASSIVE.value) {
                return MrrAccMode.PASSIVE;
            }
            if(value == MrrAccMode.STANDBY.value) {
                return MrrAccMode.STANDBY;
            }
            if(value == MrrAccMode.ACTIVE_CONTROL.value) {
                return MrrAccMode.ACTIVE_CONTROL;
            }
            if(value == MrrAccMode.BRAKE_ONLY.value) {
                return MrrAccMode.BRAKE_ONLY;
            }
            if(value == MrrAccMode.OVER_RIDE.value) {
                return MrrAccMode.OVER_RIDE;
            }
            if(value == MrrAccMode.STAND_WAIT.value) {
                return MrrAccMode.STAND_WAIT;
            }
            return value == MrrAccMode.FAILURE.value ? MrrAccMode.FAILURE : MrrAccMode.__UNKNOWN__;
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

        private TcuDriveMode(int value) {
            this.value = value;
        }

        public static TcuDriveMode valueOf(int value) {
            if(value == TcuDriveMode.NORMAL.value) {
                return TcuDriveMode.NORMAL;
            }
            if(value == TcuDriveMode.SPORT.value) {
                return TcuDriveMode.SPORT;
            }
            if(value == TcuDriveMode.WINTER.value) {
                return TcuDriveMode.WINTER;
            }
            if(value == TcuDriveMode.UPSLOPE_ONE.value) {
                return TcuDriveMode.UPSLOPE_ONE;
            }
            if(value == TcuDriveMode.HOT_ONE.value) {
                return TcuDriveMode.HOT_ONE;
            }
            if(value == TcuDriveMode.UPSLOPE_TWO.value) {
                return TcuDriveMode.UPSLOPE_TWO;
            }
            if(value == TcuDriveMode.HOT_TWO.value) {
                return TcuDriveMode.HOT_TWO;
            }
            if(value == TcuDriveMode.WUSP.value) {
                return TcuDriveMode.WUSP;
            }
            if(value == TcuDriveMode.CRUISE.value) {
                return TcuDriveMode.CRUISE;
            }
            if(value == TcuDriveMode.TIPTRONIC.value) {
                return TcuDriveMode.TIPTRONIC;
            }
            if(value == TcuDriveMode.ECO.value) {
                return TcuDriveMode.ECO;
            }
            if(value == TcuDriveMode.HIGH_ALTITUDE.value) {
                return TcuDriveMode.HIGH_ALTITUDE;
            }
            if(value == TcuDriveMode.SPORT_PLUS.value) {
                return TcuDriveMode.SPORT_PLUS;
            }
            return value == TcuDriveMode.OFF_ROAD.value ? TcuDriveMode.OFF_ROAD : TcuDriveMode.__UNKNOWN__;
        }
    }

    public static enum VdcOffState {
        OFF(1),
        ON(0),
        __UNKNOWN__(-1);

        public final int value;

        private VdcOffState(int value) {
            this.value = value;
        }

        public static VdcOffState valueOf(int value) {
            if(value == VdcOffState.OFF.value) {
                return VdcOffState.OFF;
            }
            return value == VdcOffState.ON.value ? VdcOffState.ON : VdcOffState.__UNKNOWN__;
        }
    }

    public static enum XDriveMode {
        NORMAL_MODE(0, 1),
        ECO_MODE(1, 2),
        SPORT_MODE(2, 3),
        SPORT_PLUS_MODE(3, 4),
        WINTER_MODE(4, 5),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private XDriveMode(int rx, int tx) {
            this.rx = rx;
            this.tx = tx;
            this.value = this.tx;
        }

        public static XDriveMode valueOf(int value) {
            if(value == XDriveMode.NORMAL_MODE.rx) {
                return XDriveMode.NORMAL_MODE;
            }
            if(value == XDriveMode.ECO_MODE.rx) {
                return XDriveMode.ECO_MODE;
            }
            if(value == XDriveMode.SPORT_MODE.rx) {
                return XDriveMode.SPORT_MODE;
            }
            if(value == XDriveMode.SPORT_PLUS_MODE.rx) {
                return XDriveMode.SPORT_PLUS_MODE;
            }
            return value == XDriveMode.WINTER_MODE.rx ? XDriveMode.WINTER_MODE : XDriveMode.__UNKNOWN__;
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
    public static final int DRIVE_SYSTEM_MODE = 0xB3;
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

