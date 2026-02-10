package com.yftech.vehicle.internal.adapter;

public interface IAirCondition extends IBaseApi {
    public static enum AcDisplayPopup {
        CHECK_REAR_AC_FREEZEN_STATE(17),
        DUALCIRCU_OFF(16),
        DUALCIRCU_ON(15),
        SYNC(13),
        ION(12),
        ACMAX(11),
        WIND_MODE_FRONT(10),
        RDEFROST(9),
        FDEFROST(8),
        CIRCULATION_MODE(7),
        ACST(6),
        AUTO_FRONT(5),
        WIND_FRONT(4),
        PASSENGER_TEMPERATURE(3),
        DRIVER_TEMPERATURE(2),
        ON_OFF(1),
        NOT_REQUEST(0),
        __UNKNOWN__(-1);

        public final int value;

        private AcDisplayPopup(int v1) {
            this.value = v1;
        }

        public static AcDisplayPopup valueOf(int v) {
            if(v == AcDisplayPopup.CHECK_REAR_AC_FREEZEN_STATE.value) {
                return AcDisplayPopup.CHECK_REAR_AC_FREEZEN_STATE;
            }
            if(v == AcDisplayPopup.DUALCIRCU_OFF.value) {
                return AcDisplayPopup.DUALCIRCU_OFF;
            }
            if(v == AcDisplayPopup.DUALCIRCU_ON.value) {
                return AcDisplayPopup.DUALCIRCU_ON;
            }
            if(v == AcDisplayPopup.SYNC.value) {
                return AcDisplayPopup.SYNC;
            }
            if(v == AcDisplayPopup.ION.value) {
                return AcDisplayPopup.ION;
            }
            if(v == AcDisplayPopup.ACMAX.value) {
                return AcDisplayPopup.ACMAX;
            }
            if(v == AcDisplayPopup.WIND_MODE_FRONT.value) {
                return AcDisplayPopup.WIND_MODE_FRONT;
            }
            if(v == AcDisplayPopup.RDEFROST.value) {
                return AcDisplayPopup.RDEFROST;
            }
            if(v == AcDisplayPopup.FDEFROST.value) {
                return AcDisplayPopup.FDEFROST;
            }
            if(v == AcDisplayPopup.CIRCULATION_MODE.value) {
                return AcDisplayPopup.CIRCULATION_MODE;
            }
            if(v == AcDisplayPopup.ACST.value) {
                return AcDisplayPopup.ACST;
            }
            if(v == AcDisplayPopup.AUTO_FRONT.value) {
                return AcDisplayPopup.AUTO_FRONT;
            }
            if(v == AcDisplayPopup.WIND_FRONT.value) {
                return AcDisplayPopup.WIND_FRONT;
            }
            if(v == AcDisplayPopup.PASSENGER_TEMPERATURE.value) {
                return AcDisplayPopup.PASSENGER_TEMPERATURE;
            }
            if(v == AcDisplayPopup.DRIVER_TEMPERATURE.value) {
                return AcDisplayPopup.DRIVER_TEMPERATURE;
            }
            if(v == AcDisplayPopup.ON_OFF.value) {
                return AcDisplayPopup.ON_OFF;
            }
            return v == AcDisplayPopup.NOT_REQUEST.value ? AcDisplayPopup.NOT_REQUEST : AcDisplayPopup.__UNKNOWN__;
        }
    }

    public static enum AirCirculationMode {
        AUTO(0, 1),
        MANUAL(1, 2),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private AirCirculationMode(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static AirCirculationMode valueOf(int v) {
            if(v == AirCirculationMode.AUTO.rx) {
                return AirCirculationMode.AUTO;
            }
            return v == AirCirculationMode.MANUAL.rx ? AirCirculationMode.MANUAL : AirCirculationMode.__UNKNOWN__;
        }
    }

    public static enum AirCirculationState {
        INNER_AIR_CIRCULATION(1),
        OUTSIDE_AIR_CIRCULATION(2),
        AUTO_INNER_AIR_CIRCULATION(3),
        INVALID(0),
        AUTO_OUT_AIR_CIRCULATION(4),
        __UNKNOWN__(-1);

        public final int value;

        private AirCirculationState(int v1) {
            this.value = v1;
        }

        public static AirCirculationState valueOf(int v) {
            if(v == AirCirculationState.INNER_AIR_CIRCULATION.value) {
                return AirCirculationState.INNER_AIR_CIRCULATION;
            }
            if(v == AirCirculationState.OUTSIDE_AIR_CIRCULATION.value) {
                return AirCirculationState.OUTSIDE_AIR_CIRCULATION;
            }
            if(v == AirCirculationState.AUTO_INNER_AIR_CIRCULATION.value) {
                return AirCirculationState.AUTO_INNER_AIR_CIRCULATION;
            }
            if(v == AirCirculationState.INVALID.value) {
                return AirCirculationState.INVALID;
            }
            return v == AirCirculationState.AUTO_OUT_AIR_CIRCULATION.value ? AirCirculationState.AUTO_OUT_AIR_CIRCULATION : AirCirculationState.__UNKNOWN__;
        }
    }

    public static enum AirQualitySnsConfig {
        HIGH(0, 1),
        NORMAL(1, 2),
        LOW(2, 3),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private AirQualitySnsConfig(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static AirQualitySnsConfig valueOf(int v) {
            if(v == AirQualitySnsConfig.HIGH.rx) {
                return AirQualitySnsConfig.HIGH;
            }
            if(v == AirQualitySnsConfig.NORMAL.rx) {
                return AirQualitySnsConfig.NORMAL;
            }
            return v == AirQualitySnsConfig.LOW.rx ? AirQualitySnsConfig.LOW : AirQualitySnsConfig.__UNKNOWN__;
        }
    }

    public static enum AutoMode {
        MANUAL_MODE(0),
        AUTO_MODE(1),
        __UNKNOWN__(-1);

        public final int value;

        private AutoMode(int v1) {
            this.value = v1;
        }

        public static AutoMode valueOf(int v) {
            if(v == AutoMode.MANUAL_MODE.value) {
                return AutoMode.MANUAL_MODE;
            }
            return v == AutoMode.AUTO_MODE.value ? AutoMode.AUTO_MODE : AutoMode.__UNKNOWN__;
        }
    }

    public static enum ComfortCurveMode {
        SOFT(0, 1),
        NORMAL(1, 2),
        FAST(2, 3),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private ComfortCurveMode(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static ComfortCurveMode valueOf(int v) {
            if(v == ComfortCurveMode.SOFT.rx) {
                return ComfortCurveMode.SOFT;
            }
            if(v == ComfortCurveMode.NORMAL.rx) {
                return ComfortCurveMode.NORMAL;
            }
            return v == ComfortCurveMode.FAST.rx ? ComfortCurveMode.FAST : ComfortCurveMode.__UNKNOWN__;
        }
    }

    public static enum CupholderAutoMode {
        AUTO_MODE_OFF(0),
        AUTO_MODE_ON(1),
        __UNKNOWN__(-1);

        public final int value;

        private CupholderAutoMode(int v1) {
            this.value = v1;
        }

        public static CupholderAutoMode valueOf(int v) {
            if(v == CupholderAutoMode.AUTO_MODE_OFF.value) {
                return CupholderAutoMode.AUTO_MODE_OFF;
            }
            return v == CupholderAutoMode.AUTO_MODE_ON.value ? CupholderAutoMode.AUTO_MODE_ON : CupholderAutoMode.__UNKNOWN__;
        }
    }

    public static enum CupholderHeatCoolMode {
        OFF(0),
        HEAT_MODE(1),
        COOL_MODE(2),
        NO_COMMAND(3),
        __UNKNOWN__(-1);

        public final int value;

        private CupholderHeatCoolMode(int v1) {
            this.value = v1;
        }

        public static CupholderHeatCoolMode valueOf(int v) {
            if(v == CupholderHeatCoolMode.OFF.value) {
                return CupholderHeatCoolMode.OFF;
            }
            if(v == CupholderHeatCoolMode.HEAT_MODE.value) {
                return CupholderHeatCoolMode.HEAT_MODE;
            }
            if(v == CupholderHeatCoolMode.COOL_MODE.value) {
                return CupholderHeatCoolMode.COOL_MODE;
            }
            return v == CupholderHeatCoolMode.NO_COMMAND.value ? CupholderHeatCoolMode.NO_COMMAND : CupholderHeatCoolMode.__UNKNOWN__;
        }
    }

    public static enum EcoMode {
        COMFORT(0, 1),
        ECONOMY(1, 2),
        VENT(2, 3),
        INVALID(3, -1),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private EcoMode(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static EcoMode valueOf(int v) {
            if(v == EcoMode.COMFORT.rx) {
                return EcoMode.COMFORT;
            }
            if(v == EcoMode.ECONOMY.rx) {
                return EcoMode.ECONOMY;
            }
            if(v == EcoMode.VENT.rx) {
                return EcoMode.VENT;
            }
            return v == EcoMode.INVALID.rx ? EcoMode.INVALID : EcoMode.__UNKNOWN__;
        }
    }

    public static enum FanSpeed {
        LOW(0, 1),
        NORMAL(1, 2),
        HIGH(2, 3),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private FanSpeed(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static FanSpeed valueOf(int v) {
            if(v == FanSpeed.LOW.rx) {
                return FanSpeed.LOW;
            }
            if(v == FanSpeed.NORMAL.rx) {
                return FanSpeed.NORMAL;
            }
            return v == FanSpeed.HIGH.rx ? FanSpeed.HIGH : FanSpeed.__UNKNOWN__;
        }
    }

    public static enum HumiditySnsDefAutoConfig {
        OFF(0, 1),
        HIGH(1, 2),
        NORMAL(2, 3),
        LOW(3, 4),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private HumiditySnsDefAutoConfig(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static HumiditySnsDefAutoConfig valueOf(int v) {
            if(v == HumiditySnsDefAutoConfig.OFF.rx) {
                return HumiditySnsDefAutoConfig.OFF;
            }
            if(v == HumiditySnsDefAutoConfig.HIGH.rx) {
                return HumiditySnsDefAutoConfig.HIGH;
            }
            if(v == HumiditySnsDefAutoConfig.NORMAL.rx) {
                return HumiditySnsDefAutoConfig.NORMAL;
            }
            return v == HumiditySnsDefAutoConfig.LOW.rx ? HumiditySnsDefAutoConfig.LOW : HumiditySnsDefAutoConfig.__UNKNOWN__;
        }
    }

    public static enum IonPopReqDisplay {
        NOT_ACTIVE(0),
        ACTIVE(1),
        __UNKNOWN__(-1);

        public final int value;

        private IonPopReqDisplay(int v1) {
            this.value = v1;
        }

        public static IonPopReqDisplay valueOf(int v) {
            if(v == IonPopReqDisplay.NOT_ACTIVE.value) {
                return IonPopReqDisplay.NOT_ACTIVE;
            }
            return v == IonPopReqDisplay.ACTIVE.value ? IonPopReqDisplay.ACTIVE : IonPopReqDisplay.__UNKNOWN__;
        }
    }

    public static enum OnOffByVrState {
        ON(2),
        OFF(1),
        __UNKNOWN__(-1);

        public final int value;

        private OnOffByVrState(int v1) {
            this.value = v1;
        }

        public static OnOffByVrState valueOf(int v) {
            if(v == OnOffByVrState.ON.value) {
                return OnOffByVrState.ON;
            }
            return v == OnOffByVrState.OFF.value ? OnOffByVrState.OFF : OnOffByVrState.__UNKNOWN__;
        }
    }

    public static enum PM25CleanReqCfg {
        NO_COMMAND(0),
        REQ(1),
        NOT_REQ(2),
        __UNKNOWN__(-1);

        public final int value;

        private PM25CleanReqCfg(int v1) {
            this.value = v1;
        }

        public static PM25CleanReqCfg valueOf(int v) {
            if(v == PM25CleanReqCfg.NO_COMMAND.value) {
                return PM25CleanReqCfg.NO_COMMAND;
            }
            if(v == PM25CleanReqCfg.REQ.value) {
                return PM25CleanReqCfg.REQ;
            }
            return v == PM25CleanReqCfg.NOT_REQ.value ? PM25CleanReqCfg.NOT_REQ : PM25CleanReqCfg.__UNKNOWN__;
        }
    }

    public static enum PM25CleanReqDisplay {
        NOT_ACTIVE(0),
        ACTIVE(1),
        __UNKNOWN__(-1);

        public final int value;

        private PM25CleanReqDisplay(int v1) {
            this.value = v1;
        }

        public static PM25CleanReqDisplay valueOf(int v) {
            if(v == PM25CleanReqDisplay.NOT_ACTIVE.value) {
                return PM25CleanReqDisplay.NOT_ACTIVE;
            }
            return v == PM25CleanReqDisplay.ACTIVE.value ? PM25CleanReqDisplay.ACTIVE : PM25CleanReqDisplay.__UNKNOWN__;
        }
    }

    public static enum SceneDisplay {
        COMFORTSCENE(0),
        FAST_COOLING_SCENE(1),
        FAST_WARMING_SCENE(2),
        __UNKNOWN__(-1);

        public final int value;

        private SceneDisplay(int v1) {
            this.value = v1;
        }

        public static SceneDisplay valueOf(int v) {
            if(v == SceneDisplay.COMFORTSCENE.value) {
                return SceneDisplay.COMFORTSCENE;
            }
            if(v == SceneDisplay.FAST_COOLING_SCENE.value) {
                return SceneDisplay.FAST_COOLING_SCENE;
            }
            return v == SceneDisplay.FAST_WARMING_SCENE.value ? SceneDisplay.FAST_WARMING_SCENE : SceneDisplay.__UNKNOWN__;
        }
    }

    public static enum WindMode {
        FACE(1),
        FACE_FOOT(2),
        FOOT(3),
        FOOT_DEFROST(4),
        DEFROST(5),
        INVALID(0),
        __UNKNOWN__(-1);

        public final int value;

        private WindMode(int v1) {
            this.value = v1;
        }

        public static WindMode valueOf(int v) {
            if(v == WindMode.FACE.value) {
                return WindMode.FACE;
            }
            if(v == WindMode.FACE_FOOT.value) {
                return WindMode.FACE_FOOT;
            }
            if(v == WindMode.FOOT.value) {
                return WindMode.FOOT;
            }
            if(v == WindMode.FOOT_DEFROST.value) {
                return WindMode.FOOT_DEFROST;
            }
            if(v == WindMode.DEFROST.value) {
                return WindMode.DEFROST;
            }
            return v == WindMode.INVALID.value ? WindMode.INVALID : WindMode.__UNKNOWN__;
        }
    }

    public static enum WindSpeed {
        LEVEL_1(1),
        LEVEL_2(2),
        LEVEL_3(3),
        LEVEL_4(4),
        LEVEL_5(5),
        LEVEL_6(6),
        LEVEL_7(7),
        OFF(0),
        __UNKNOWN__(-1);

        public final int value;

        private WindSpeed(int v1) {
            this.value = v1;
        }

        public static WindSpeed valueOf(int v) {
            if(v == WindSpeed.LEVEL_1.value) {
                return WindSpeed.LEVEL_1;
            }
            if(v == WindSpeed.LEVEL_2.value) {
                return WindSpeed.LEVEL_2;
            }
            if(v == WindSpeed.LEVEL_3.value) {
                return WindSpeed.LEVEL_3;
            }
            if(v == WindSpeed.LEVEL_4.value) {
                return WindSpeed.LEVEL_4;
            }
            if(v == WindSpeed.LEVEL_5.value) {
                return WindSpeed.LEVEL_5;
            }
            if(v == WindSpeed.LEVEL_6.value) {
                return WindSpeed.LEVEL_6;
            }
            if(v == WindSpeed.LEVEL_7.value) {
                return WindSpeed.LEVEL_7;
            }
            return v == WindSpeed.OFF.value ? WindSpeed.OFF : WindSpeed.__UNKNOWN__;
        }
    }

    public static final int AC_BUTTON_SETTING = 6;
    public static final int AC_DISPLAY_POPUP_STATE = 401;
    public static final int AC_ENVIRONMENT_TEMPERATURE = 0xC4;
    public static final int AC_OUT_AIRQUALITY_LEVEL = 0xC3;
    public static final int AC_STATE = 78;
    public static final int AC_VR_ON_OFF_SETTING = 445;
    public static final int AC_WORKING_POWER = -1;
    public static final int AIR_CIRCULATION_MODE_OF_AUTO_MODE = 85;
    public static final int AIR_CIRCULATION_MODE_OF_AUTO_MODE_SETTING = 13;
    public static final int AIR_CIRCULATION_STATE = 82;
    public static final int AIR_DUAL_CIRCUST_STATE = 680;
    public static final int AIR_QUALITY_SNS_CONFIG_SETTING = 590;
    public static final int AIR_QUALITY_SNS_CONFIG_STATUS = 589;
    public static final int AIR_QUALITY_SNS_STATE = 588;
    public static final int AIR_SELF_DRYING = 0x107;
    public static final int AIR_SELF_DRYING_SETTING = 0x108;
    public static final int AIR_UNLOCK_VENTILATION = 0x109;
    public static final int AIR_UNLOCK_VENTILATION_SETTING = 0x10A;
    public static final int AUTO_BUTTON_SETTING = 11;
    public static final int AUTO_DEFORST = -1;
    public static final int AUTO_DEFORST_BUTTON_SETTING = -1;
    public static final int AUTO_MODE = 83;
    public static final int BATTERY_COOL_STATE = 0xC2;
    public static final int BATTERY_FH_STATE = 0xC0;
    public static final int BATTERY_PTC_STATE = 0xC1;
    public static final int BODYDISALARM_VENT_BUTTON_STATE = -1;
    public static final int BODYDISALARM_VENT_STATE = 0xBF;
    public static final int CIRCULATION_BUTTON_SETTING = 10;
    public static final int COMFORT_CURVE_MODE = 86;
    public static final int COMFORT_CURVE_SETTING = 14;
    public static final int CUP_HOLDER_AUTO_MODE = 557;
    public static final int CUP_HOLDER_AUTO_MODE_SETTING = 558;
    public static final int CUP_HOLDER_HEAT_COOL_MODE = 555;
    public static final int CUP_HOLDER_HEAT_COOL_MODE_SETTING = 556;
    public static final int DRIVER_TEMPERATURE = 74;
    public static final int DRIVER_TEMPERATURE_SETTING = 0;
    public static final int DUAL_SYNC_BUTTON_SETTING = 8;
    public static final int DUAL_SYNC_STATE = 80;
    public static final int EcoMode_SETTING = -1;
    public static final int EcoMode_STATE = -1;
    public static final int FAN_SPEED_OF_AUTO_MODE = 84;
    public static final int FAN_SPEED_OF_AUTO_MODE_SETTING = 12;
    public static final int FRONT_DEFROST_BUTTON_SETTING = 5;
    public static final int FRONT_EFROST_STATE = 404;
    public static final int HUMI_DITY_SNS_CONFIG_SETTING = 593;
    public static final int HUMI_DITY_SNS_CONFIG_STATUS = 0x250;
    public static final int HUMI_DITY_SNS_STATE = 0x24F;
    public static final int ION_BUTTON_SETTING = 9;
    public static final int ION_POP_DISPLAYSTATE = 679;
    public static final int ION_STATE = 81;
    public static final int OFF_BUTTON_SETTING = 3;
    public static final int ONE_BUTTON_VENTLAION_SETTING = 420;
    public static final int ONE_BUTTON_VENTLAION_STATE = 419;
    public static final int PASSENGER_TEMPERATURE = 75;
    public static final int PASSENGER_TEMPERATURE_SETTING = 1;
    public static final int PM_25_CLEAN_REQ_SETTING = 678;
    public static final int PM_25_REQ_DISPLAYH = 676;
    public static final int PM_25_SNS_ENABLED = 677;
    public static final int PM_25_VALUE = 564;
    public static final int PM_25_VALUE_VD = 675;
    public static final int POWER_BUTTON_STATE = -1;
    public static final int POWER_STATE = -1;
    public static final int REAR_AC_AUTO_MODE = 0xE7;
    public static final int REAR_AC_AUTO_MODE_SETTING = 0xE8;
    public static final int REAR_AC_FREEZEN_SETTING = 648;
    public static final int REAR_AC_FREEZEN_STATE = 647;
    public static final int REAR_AC_OFF_BUTTON_SETTING = 0xEB;
    public static final int REAR_AC_TEMPERATURE = 0xEC;
    public static final int REAR_AC_TEMPERATURE_SETTING = 0xED;
    public static final int REAR_AC_WIND_MODE = 0xEE;
    public static final int REAR_AC_WIND_MODE_SETTING = 0xEF;
    public static final int REAR_AC_WIND_SPEED = 0xE9;
    public static final int REAR_AC_WIND_SPEED_SETTING = 0xEA;
    public static final int REAR_DEFROST_BUTTON_SETTING = 7;
    public static final int REAR_DEFROST_STATE = 0x4F;
    public static final int SCENE_DISPLAY_STATE = 666;
    public static final int TEMPERATURE_DEC_BUTTON_SETTING = 434;
    public static final int TEMPERATURE_DEC_VD_SETTING = 435;
    public static final int TEMPERATURE_FR_DEC_BUTTON_SETTING = 0x20C;
    public static final int TEMPERATURE_FR_DEC_VD_SETTING = 0x20D;
    public static final int TEMPERATURE_FR_INC_BUTTON_SETTING = 0x20A;
    public static final int TEMPERATURE_FR_INC_VD_SETTING = 0x20B;
    public static final int TEMPERATURE_INC_BUTTON_SETTING = 0x1B0;
    public static final int TEMPERATURE_INC_VD_SETTING = 433;
    public static final int WINDMODE_BUTTON_SETTING = 534;
    public static final int WINDSPEED_DEC_BUTTON_SETTING = 537;
    public static final int WINDSPEED_INC_BUTTON_SETTING = 536;
    public static final int WIND_MODE = 77;
    public static final int WIND_MODE_SETTING = 4;
    public static final int WIND_SPEED = 76;
    public static final int WIND_SPEED_SETTING = 2;

}

