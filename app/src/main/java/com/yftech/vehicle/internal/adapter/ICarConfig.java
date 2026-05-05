package com.yftech.vehicle.internal.adapter;

public interface ICarConfig {
    public static enum AirConditionType {
        MANUAL(0),
        AUTO(1),
        __UNKNOWN__(-1);

        public final int value;

        private AirConditionType(int value) {
            this.value = value;
        }

        public static AirConditionType valueOf(int value) {
            if(value == AirConditionType.MANUAL.value) {
                return AirConditionType.MANUAL;
            }
            return value == AirConditionType.AUTO.value ? AirConditionType.AUTO : AirConditionType.__UNKNOWN__;
        }
    }

    public static enum AirConditioningZones {
        SINGLE_ZONE(0),
        DUAL_ZONES(1),
        THREE_ZONES(2),
        __UNKNOWN__(-1);

        public final int value;

        private AirConditioningZones(int value) {
            this.value = value;
        }

        public static AirConditioningZones valueOf(int value) {
            if(value == AirConditioningZones.SINGLE_ZONE.value) {
                return AirConditioningZones.SINGLE_ZONE;
            }
            if(value == AirConditioningZones.DUAL_ZONES.value) {
                return AirConditioningZones.DUAL_ZONES;
            }
            return value == AirConditioningZones.THREE_ZONES.value ? AirConditioningZones.THREE_ZONES : AirConditioningZones.__UNKNOWN__;
        }
    }

    public static enum Avdc {
        NOT_PRESENT(0),
        ECO_PLUSCOMFORT_PLUSSPORT(1),
        __UNKNOWN__(-1);

        public final int value;

        private Avdc(int value) {
            this.value = value;
        }

        public static Avdc valueOf(int value) {
            if(value == Avdc.NOT_PRESENT.value) {
                return Avdc.NOT_PRESENT;
            }
            return value == Avdc.ECO_PLUSCOMFORT_PLUSSPORT.value ? Avdc.ECO_PLUSCOMFORT_PLUSSPORT : Avdc.__UNKNOWN__;
        }
    }

    public static enum CameraNumber {
        NONE(0),
        RVC(1),
        SVM(2),
        SVM_PLUSAPA(3),
        SVM_PLUSFAPA(4),
        SVM_PLUSAVP(5),
        EXTERNAL_AVM(6),
        __UNKNOWN__(-1);

        public final int value;

        private CameraNumber(int value) {
            this.value = value;
        }

        public static CameraNumber valueOf(int value) {
            if(value == CameraNumber.NONE.value) {
                return CameraNumber.NONE;
            }
            if(value == CameraNumber.RVC.value) {
                return CameraNumber.RVC;
            }
            if(value == CameraNumber.SVM.value) {
                return CameraNumber.SVM;
            }
            if(value == CameraNumber.SVM_PLUSAPA.value) {
                return CameraNumber.SVM_PLUSAPA;
            }
            if(value == CameraNumber.SVM_PLUSFAPA.value) {
                return CameraNumber.SVM_PLUSFAPA;
            }
            if(value == CameraNumber.SVM_PLUSAVP.value) {
                return CameraNumber.SVM_PLUSAVP;
            }
            return value == CameraNumber.EXTERNAL_AVM.value ? CameraNumber.EXTERNAL_AVM : CameraNumber.__UNKNOWN__;
        }
    }

    public static enum Config {
        VEHICLE_TYPE(0, 0, 1),
        DRIVE_TYPE(0, 2, 3),
        GEARBOX_TYPE(0, 4, 6),
        VEHICLE_PLATFORM(1, 0, 7),
        A_CAN(2, 0),
        B_CAN(2, 1),
        GPS(2, 2),
        ANTENNA(2, 3),
        MIC(2, 4),
        BCM(2, 5),
        HVAC(2, 6),
        ICM(2, 7),
        PAS(3, 0),
        GWM(3, 1),
        FCP(3, 2),
        PCS(3, 3),
        TBOX(3, 4),
        VCU(3, 5),
        AVAS(3, 6),
        RVC(3, 7),
        SVM(4, 0),
        FL_SPEAKER(4, 1),
        FR_SPEAKER(4, 2),
        RL_SPEAKER(4, 3),
        RR_SPEAKER(4, 4),
        STEERING_WHEEL_KEY(4, 5),
        FAPA(4, 6),
        HUD_SET(4, 7),
        EXTERNAL_SVM(5, 0),
        OMS(5, 1),
        GAC_LOGO(5, 7),
        TBOX_CONNECTION_MODE(6, 0, 1),
        DMS_CONNECTION_MODE(6, 2, 3),
        B_CALL_SWITCH(6, 4),
        E_CALL_SWITCH(6, 5),
        CALL_BACK(6, 6),
        RESTART_VEHICLE_COMMUNICATION_MODULE(6, 7),
        LOUDSPEAKER_NUMBER(7, 0, 3),
        LOUDSPEAKER_SUPPLIER(7, 4, 6),
        EXT_AMPLIFIERS(7, 7),
        AVAS_SOUND(8, 0),
        AVAS_SWITCH(8, 1),
        STORAGE_BOX_AUTOMATICALLY_FLIP_DOWN(8, 2),
        HIDDEN_DOOR_HANDLE(8, 3),
        WINTER_LONG_DISTANCE(8, 4),
        CHARGING_INSULATION(8, 5),
        INTELLIGENT_INSULATION_NOTIFICATION(8, 6),
        ENERGY_RECOVERY_MODE(8, 7),
        ELECTRO_DISCHARGE(9, 0),
        ECO_PLUS_MODE(9, 1),
        EPEDAL_MODE(9, 2),
        CREEP_MODE(9, 3),
        ENERGY_CONSUMPTION(9, 4),
        MONSTER_MODE_SWITCH(9, 5),
        HEALTH_CHARGE_SETTING(9, 6),
        DRIVING_MODE(9, 7),
        AUTO_MODE_OF_FRS_AND_REC_CONTROL(10, 0),
        COMFORT_CURVE(10, 1),
        QUALITY_SENSOR(10, 2),
        AUTO_DEFORST(10, 3),
        FAN_SPEED_OF_AUTO_MODE(10, 4),
        SOLAR_FEATURES(10, 5),
        FRAGRANCE(10, 6),
        ANION(10, 7),
        HEAT_PUMP_AIR_CONDITIONING(11, 0),
        AIR_CONDITIONING_ZONES(11, 1, 2),
        REAR_DEFROST_AND_REARVIEW_MIRROR_HEATING(11, 3, 4),
        CONFIG_PM2_5(11, 5, 6),
        AIR_CONDITION_TYPE(11, 7),
        CAMERA_NUMBER(12, 0, 2),
        RADAR_NUMBER(12, 3, 5),
        STANDARD_AND_HD_CAMERA_CONFIGURATION(12, 6),
        FOLLOW_TRACKING_LINE(12, 7),
        LOOK_AROUND_TO_DETECT_THE_DOOR(13, 0),
        REMOTE_FINDING_CAR(13, 1),
        CONTROL_DAYTIME_RUNNIG_LAMP(13, 2),
        SEAT_LAYOUT(13, 3),
        BACK_ROW_DISPLAY(13, 4),
        HEAD_ACOUSTICS(13, 5),
        DVR(13, 6),
        AR(13, 7),
        TIKTOK(14, 0, 1),
        CEILING_SCREEN(14, 2),
        ADAPTIVE_HIGH_BEAM(14, 3),
        CONTROL_HIGH_BEAM_ASSISTANT(14, 4),
        CLOSE_WINDOW_WHILE_LOCK(14, 5),
        DOME_LIGHT_IN_DOOR_GEAR_POSITION(14, 6),
        CONTROL_SMART_WELCOME_LIGHT(14, 7),
        KEY_IDENTIFICATION(15, 0),
        FOLLOW_MUSIC_MODE(15, 1),
        EASY_OPEN_TAILGATE(15, 2),
        SMART_TAILGATE(15, 3),
        WIRELESS_CHARGING(15, 4),
        ACCESSORY_SMART_SCREEN(15, 5),
        PLGMFUNCCFG(15, 6),
        NFC(15, 7),
        WAL_AND_APU(16, 0, 1),
        REMOTE_UNLOCK(16, 2),
        SPEED_LOCK(16, 3),
        AUTO_UNLOCKING(16, 4),
        EXTERIOR_REAR_VIEW_MIRROR_AUTO_FOLDING_AND_UNFOLDING(16, 5),
        EXTERIOR_REARVIEW_MIRROR_DIP(16, 6),
        REARVIEW_MIRROR_ADJUSTMENT(16, 7),
        STEERING_WHEEL_STEERING_HAND_FORCE(17, 0),
        ETC_SETTING(17, 1),
        WIPER_MAINTANENCE(17, 2),
        AUTO_WIPER(17, 3),
        LOCK_AND_UNLOCK_WHISTLE_NOTE(17, 4),
        LIGHT_TURNED_OFF_DELAY(17, 5),
        AMBIENCE_LIGHTS_CONTROL(17, 6),
        IAL(17, 7),
        DRIVER_EASY_ENTRY_AND_EXIT_FUNCTION(18, 0),
        SEAT_CONTROL(18, 1),
        ROOF_CONTROL(18, 2),
        STEERING_WHEEL_CONTROL(18, 3),
        SLIDING_DOOR_CONTROL(18, 4),
        WINDOW_CONTROL(18, 5, 6),
        STEERING_WHEEL_CUSTOM_BUTTON(18, 7),
        LOCK_CONTROL(19, 0),
        SLIDING_DOOR_SPEED_ADJUSTMENT(19, 1),
        SLIDING_DOOR_CONTROL_MANUAL_AND_AUTOMATIC(19, 2),
        NAP_MODE(19, 3, 4),
        RAINSTORM_MODE(19, 5),
        QISHI_MODE(19, 6),
        PARTY_MODE(19, 7),
        WAKE_UP_MODE(20, 0),
        STEERING_WHEEL_HEATING(20, 1),
        LIGHT_SHOW(20, 2),
        AMBIENCE_LIGHTS_COMNINATION(20, 3),
        PROMPT_TYPE(20, 4, 5),
        HIGH_WAY_ASSIST(20, 6),
        NAVIGATION_DRIVING_ASSIST(20, 7),
        CLUSTER_VOLUME_SETTING(21, 0),
        CLUSTER_LANGUAGE_SETTING(21, 1),
        CLUSTER_MILEAGE_RESET(21, 2),
        CLUSTER_SPEED_UNIT(21, 3),
        CLUSTER_TEMPERATURE_UNIT(21, 4),
        CLUSTER_PRESSURE_UNIT(21, 5),
        REAR_SEAT_BELT_NOTIFICATION(21, 6),
        CLUSTER_DEFAULT_SETTING(21, 7),
        CLUSTER_FUEL_CONSUMPTION_UNIT(22, 0),
        CLUSTER_BACK_LIGHT(22, 1),
        TIME_IN_CLUSTER(22, 2),
        LANE_AUXILIARY_SWITCH(23, 0),
        LANE_ASSIST(23, 1),
        AUTO_EMERGENCY_BRAKING_BRAKING(23, 2),
        FRONT_COLLISION_WARNING(23, 3),
        IFC_CRUISEMODE(23, 4),
        BSD(23, 5),
        IMR(23, 6),
        DOOR_OPEN_WARNING(23, 7),
        OVERSPEED_WARNING(24, 0),
        SPEED_LIMTED_SIGN_RECOGNITION(24, 1),
        STEERING_MODE(24, 2),
        DRIVING_RECORDER(24, 3),
        EVENT_RECORD_FUNCTION_SWITCH(24, 4),
        LCA_CARD(24, 5),
        LANE_CHANGE_ASSIST(24, 6, 7),
        DRIVER_STATE_OF_ALERT(25, 0),
        EMERGENCY_STEERING_MODE(25, 1),
        RAEB(25, 2),
        ALERT_MODE(25, 3),
        EMERGENCY_LANE_KEEPING_ASSIST(25, 4),
        REAR_CROSS_TRAFFIC_ALERT(25, 5),
        REAR_CROSS_TRAFFIC_ALERT_MODE(25, 6),
        REAR_APPROACHING_WARNING(25, 7),
        FRONT_CROSS_TRAFFIC_ALERT(26, 0),
        FRONT_CROSS_TRAFFIC_ALERT_MODE(26, 1),
        APA_VOICE_PROMPT_BUTTON(26, 2),
        FORWARD_COLLISION_WARNING_DISTANCE(26, 3),
        INDICATED_LANE_CHANGE(26, 4),
        OVERSPEED_ALARM_OF_TSR(26, 5),
        INTELLIGENT_SPEED_LIMIT_CONTROL(26, 6),
        DRIVER_ASSISTANCE_WARNING(26, 7),
        DISTRACTED_ALARM_INTERVAL_TIME(27, 0, 2),
        TIRED_ALARM_INTERVAL_TIME(27, 3, 7),
        APA_ALARM_DELAYED_TIME(28, 0, 3),
        ESP_OFF_SWITCH(28, 4),
        HDC_SWITCH(28, 5),
        EBOOSTER_MODE(28, 6),
        DRIVER_MODE(28, 7),
        DRIVE_MODE_MEMORY_SWITCH(29, 0),
        ENGINE_WAVE_SWITCH(29, 1),
        SUSPENSION_DAMPING(29, 2),
        THROTTLE_SENSITIVITY(29, 3),
        AVDC(29, 4, 6),
        ENERGY_RECOVERY(29, 7),
        VR_CONTROL_CRUISE(30, 0),
        VR_CONTROL_TURNLAMP(30, 1),
        VR_CONTROL_SUNSHADE(30, 2),
        VR_CONTROL_CARWINDOW(30, 3, 4),
        VR_CONTROL_IAL(30, 5, 6),
        VR_CONTROL_EXTLIGHT(30, 7),
        VR_CONTROL_TOPLIGHT(0x1F, 0),
        VR_CONTROL_WIPER_AND_CLEANING(0x1F, 1, 2),
        VR_CONTROL_CHARGING_AND_FUEL_TANK_CAP(0x1F, 3),
        VR_CONTROL_ENGINE_AND_MOTOR(0x1F, 4),
        VR_CONTROL_INSTRUMENT_BACKLIGHT(0x1F, 5),
        VR_CONTROL_HVAC(0x1F, 6, 7),
        SMART_HVAC(0x20, 0),
        SPORT_PLUS(0x20, 1),
        VR_CONTROL_SEAT_ADJUSTMENT(0x20, 2, 3),
        VR_CONTROL_ROOF(0x20, 4, 5),
        VR_CONTROL_PLGM(0x20, 6),
        VR_CONTROL_DMS_NOTIFICATION(0x20, 7),
        VR_CONTROL_WINDOWPOSITION(33, 0, 1),
        VR_CONTROL_ROOFPOSITION(33, 2, 3),
        VR_CONTROL(33, 4, 5),
        VR_CONTROL_CHARGING_INSULATION_NOTIFICATION(33, 6),
        VR_CONTROL_CHARGING_INSULATION_MENU_SWITCH(33, 7),
        VR_CONTROL_CHARGING_BOOKING_MENU_SWITCH(34, 0),
        VR_CONTROL_CONTROL_DRIVER_MODE(34, 1),
        VR_CONTROL_ENERGY_RECOVERY(34, 2),
        VR_CONTROL_APA_CONTROL(34, 3),
        VR_CONTROL_PARKING(34, 4, 6),
        DRIVER_DIRECT_VOICE_WAKE_UP(34, 7),
        COLD_AND_WARM_CUP_HOLDER(35, 0),
        AUTOHOLD(35, 1),
        TECHNOLOGY_SKYLIGHT(35, 2),
        ICC(35, 3),
        ANC(35, 4),
        REAR_APPROACHING_WARNING_MODE(35, 5),
        LEFT_RIGHT_HAND_DRIVE_VEHICLES(35, 6),
        ONE_CLICK_TO_TURN_ON_OFF_THE_CELLING_LIGHT(35, 7),
        RESERCED(35, 7),
        HEATING_AND_VENTILATION_FL(36, 0, 1),
        HEATING_AND_VENTILATION_FR(36, 2, 3),
        HEATING_AND_VENTILATION_RL(36, 4, 5),
        HEATING_AND_VENTILATION_RR(36, 6, 7),
        SECOND_ROW_SEATS_WELCOME(37, 0, 1),
        LIMIT_SECOND_ROW_SEATS_WELCOME_FUNCTION(37, 2, 3),
        SECOND_ROW_SEAT_MASSAGE(37, 4),
        SECOND_ROW_SEAT_ADJUSTMENT(37, 5, 6),
        SECOND_ROW_CHILD_LOCK(37, 7),
        PASSENGER_SEAT_ADJUSTMENT(38, 0, 1),
        DRIVER_SEAT_CONTROL(38, 2, 3),
        SECOND_ROW_SEAT_REST(38, 4),
        FL_SEAT_MASSAGE(38, 6),
        FR_SEAT_MASSAGE(38, 7),
        SPA(38, 5),
        ULTRAVIOLET_RAY(39, 0),
        UNLOCK_VENTILATION(39, 1),
        EVAPORATOR_SELF_DRYING(39, 2),
        AIR_CONDITIONING_BLIND_EXERCISE(39, 3),
        AIR_CONDITIONING_QUICK_START(39, 4),
        RAPID_VENTILATION(39, 5),
        HOSPITALITY_LAMP_SIGNALS(39, 6),
        TEMPORARY_PARKING_LAMP_SIGNALS(39, 7),
        LANE_CHANGE_DRIVER_CONFIRMATION(40, 0),
        LANE_CHANGE_STYLE(40, 1),
        INDICATED_LANE_CHANGING(40, 2),
        FRONT_DISTANCE_DISPLAY(40, 3),
        INTELLIGENT_COLLISION_AVOIDANCE(40, 4),
        SEAT_LAYOUT_NEW(40, 5, 6),
        FEEZE_MODE(41, 0, 3),
        CLUSTER_DISTANCE_SETTING(41, 4),
        ENERGY_FLOW_MODE(41, 5),
        ENERGY_FLOW_DISPLAY(41, 6),
        EV_SWITCH_DISPLAY(41, 7),
        THE_3D_CHIME_BOOT_SOUND(42, 0),
        THE_3D_CHIME_INDICATOR(42, 1),
        THE_3D_CHIME_LANE_CHANGE_ASSIT_AND_REAR_APPROACHING_WARNING(42, 2),
        THE_3D_CHIME_FRONT_COLLISION_WARNING_SOUND(42, 3),
        THE_3D_CHIME_REVERSING_RADAR_SOUND(42, 4),
        THE_3D_CHIME_IAL_SOUND(42, 5),
        THE_3D_CHIME_DRIVER_MODE_SOUND(42, 6),
        ENERGY_CONSUMPTION_APP(43, 1),
        SMART_NAVI_DRIVE(43, 2),
        SMART_COMMUT_DRIVE(43, 3),
        COMFORTABLE_STOP(43, 4),
        GUIDANCE_OF_STARTING_VHICLE(43, 6),
        __UNKNOWN__(-1, -1);

        public final byte bitSize;
        public final byte byteIndex;
        public final byte startBit;

        private Config(int byteIndex, int startBit) {
            this.byteIndex = (byte)byteIndex;
            this.startBit = (byte)startBit;
            this.bitSize = 1;
        }

        private Config(int byteIndex, int startBit, int endBit) {
            this.byteIndex = (byte)byteIndex;
            this.startBit = (byte)startBit;
            this.bitSize = (byte)(endBit - startBit + 1);
        }
    }

    public static enum ConfigPm25 {
        NOT_PRESENT(0),
        PRESENT_PM2_5_FILTER(1),
        PRESENT_PM2_5_FILTER_AND_SENSOR(2),
        __UNKNOWN__(-1);

        public final int value;

        private ConfigPm25(int value) {
            this.value = value;
        }

        public static ConfigPm25 valueOf(int value) {
            if(value == ConfigPm25.NOT_PRESENT.value) {
                return ConfigPm25.NOT_PRESENT;
            }
            if(value == ConfigPm25.PRESENT_PM2_5_FILTER.value) {
                return ConfigPm25.PRESENT_PM2_5_FILTER;
            }
            return value == ConfigPm25.PRESENT_PM2_5_FILTER_AND_SENSOR.value ? ConfigPm25.PRESENT_PM2_5_FILTER_AND_SENSOR : ConfigPm25.__UNKNOWN__;
        }
    }

    public static enum DmsConnectionMode {
        NO_CONNECTION(0),
        GWM_TO_DMS(1),
        ETH_TO_DMS(2),
        INTEGRATED_DMS(3),
        __UNKNOWN__(-1);

        public final int value;

        private DmsConnectionMode(int value) {
            this.value = value;
        }

        public static DmsConnectionMode valueOf(int value) {
            if(value == DmsConnectionMode.NO_CONNECTION.value) {
                return DmsConnectionMode.NO_CONNECTION;
            }
            if(value == DmsConnectionMode.GWM_TO_DMS.value) {
                return DmsConnectionMode.GWM_TO_DMS;
            }
            if(value == DmsConnectionMode.ETH_TO_DMS.value) {
                return DmsConnectionMode.ETH_TO_DMS;
            }
            return value == DmsConnectionMode.INTEGRATED_DMS.value ? DmsConnectionMode.INTEGRATED_DMS : DmsConnectionMode.__UNKNOWN__;
        }
    }

    public static enum DriveType {
        TWO_WHEEL_DRIVE(0),
        FOUR_WHEEL_DRIVE(1),
        __UNKNOWN__(-1);

        public final int value;

        private DriveType(int value) {
            this.value = value;
        }

        public static DriveType valueOf(int value) {
            if(value == DriveType.TWO_WHEEL_DRIVE.value) {
                return DriveType.TWO_WHEEL_DRIVE;
            }
            return value == DriveType.FOUR_WHEEL_DRIVE.value ? DriveType.FOUR_WHEEL_DRIVE : DriveType.__UNKNOWN__;
        }
    }

    public static enum DriverSeatControl {
        NONE(0),
        EIGHT_CONTROL(1),
        SIX_CONTROL(2),
        __UNKNOWN__(-1);

        public final int value;

        private DriverSeatControl(int value) {
            this.value = value;
        }

        public static DriverSeatControl valueOf(int value) {
            if(value == DriverSeatControl.NONE.value) {
                return DriverSeatControl.NONE;
            }
            if(value == DriverSeatControl.EIGHT_CONTROL.value) {
                return DriverSeatControl.EIGHT_CONTROL;
            }
            return value == DriverSeatControl.SIX_CONTROL.value ? DriverSeatControl.SIX_CONTROL : DriverSeatControl.__UNKNOWN__;
        }
    }

    public static enum FeezeMode {
        ONE_MIN(0),
        FIVE_MIN(1),
        TEN_MIN(2),
        FIFTEEN_MIN(3),
        TWENTY_MIN(4),
        TWENTY_FIVE_MIN(5),
        THIRTY_MIN(6),
        RESERVE(7),
        __UNKNOWN__(-1);

        public final int value;

        private FeezeMode(int value) {
            this.value = value;
        }

        public static FeezeMode valueOf(int value) {
            if(value == FeezeMode.ONE_MIN.value) {
                return FeezeMode.ONE_MIN;
            }
            if(value == FeezeMode.FIVE_MIN.value) {
                return FeezeMode.FIVE_MIN;
            }
            if(value == FeezeMode.TEN_MIN.value) {
                return FeezeMode.TEN_MIN;
            }
            if(value == FeezeMode.FIFTEEN_MIN.value) {
                return FeezeMode.FIFTEEN_MIN;
            }
            if(value == FeezeMode.TWENTY_MIN.value) {
                return FeezeMode.TWENTY_MIN;
            }
            if(value == FeezeMode.TWENTY_FIVE_MIN.value) {
                return FeezeMode.TWENTY_FIVE_MIN;
            }
            if(value == FeezeMode.THIRTY_MIN.value) {
                return FeezeMode.THIRTY_MIN;
            }
            return value == FeezeMode.RESERVE.value ? FeezeMode.RESERVE : FeezeMode.__UNKNOWN__;
        }
    }

    public static enum GearboxType {
        MT(0),
        AT(1),
        WDCT(2),
        DDCT(3),
        THS(4),
        GMC(5),
        __UNKNOWN__(-1);

        public final int value;

        private GearboxType(int value) {
            this.value = value;
        }

        public static GearboxType valueOf(int value) {
            if(value == GearboxType.MT.value) {
                return GearboxType.MT;
            }
            if(value == GearboxType.AT.value) {
                return GearboxType.AT;
            }
            if(value == GearboxType.WDCT.value) {
                return GearboxType.WDCT;
            }
            if(value == GearboxType.DDCT.value) {
                return GearboxType.DDCT;
            }
            if(value == GearboxType.THS.value) {
                return GearboxType.THS;
            }
            return value == GearboxType.GMC.value ? GearboxType.GMC : GearboxType.__UNKNOWN__;
        }
    }

    public static enum HeatingAndVentilationFl {
        NOT_PRESENT(0),
        VENTILATION_HEATING(1),
        VENTILATION(2),
        HEATING(3),
        __UNKNOWN__(-1);

        public final int value;

        private HeatingAndVentilationFl(int value) {
            this.value = value;
        }

        public static HeatingAndVentilationFl valueOf(int value) {
            if(value == HeatingAndVentilationFl.NOT_PRESENT.value) {
                return HeatingAndVentilationFl.NOT_PRESENT;
            }
            if(value == HeatingAndVentilationFl.VENTILATION_HEATING.value) {
                return HeatingAndVentilationFl.VENTILATION_HEATING;
            }
            if(value == HeatingAndVentilationFl.VENTILATION.value) {
                return HeatingAndVentilationFl.VENTILATION;
            }
            return value == HeatingAndVentilationFl.HEATING.value ? HeatingAndVentilationFl.HEATING : HeatingAndVentilationFl.__UNKNOWN__;
        }
    }

    public static enum HeatingAndVentilationFr {
        NOT_PRESENT(0),
        VENTILATION_HEATING(1),
        VENTILATION(2),
        HEATING(3),
        __UNKNOWN__(-1);

        public final int value;

        private HeatingAndVentilationFr(int value) {
            this.value = value;
        }

        public static HeatingAndVentilationFr valueOf(int value) {
            if(value == HeatingAndVentilationFr.NOT_PRESENT.value) {
                return HeatingAndVentilationFr.NOT_PRESENT;
            }
            if(value == HeatingAndVentilationFr.VENTILATION_HEATING.value) {
                return HeatingAndVentilationFr.VENTILATION_HEATING;
            }
            if(value == HeatingAndVentilationFr.VENTILATION.value) {
                return HeatingAndVentilationFr.VENTILATION;
            }
            return value == HeatingAndVentilationFr.HEATING.value ? HeatingAndVentilationFr.HEATING : HeatingAndVentilationFr.__UNKNOWN__;
        }
    }

    public static enum HeatingAndVentilationRl {
        NOT_PRESENT(0),
        VENTILATION_HEATING(1),
        VENTILATION(2),
        HEATING(3),
        __UNKNOWN__(-1);

        public final int value;

        private HeatingAndVentilationRl(int value) {
            this.value = value;
        }

        public static HeatingAndVentilationRl valueOf(int value) {
            if(value == HeatingAndVentilationRl.NOT_PRESENT.value) {
                return HeatingAndVentilationRl.NOT_PRESENT;
            }
            if(value == HeatingAndVentilationRl.VENTILATION_HEATING.value) {
                return HeatingAndVentilationRl.VENTILATION_HEATING;
            }
            if(value == HeatingAndVentilationRl.VENTILATION.value) {
                return HeatingAndVentilationRl.VENTILATION;
            }
            return value == HeatingAndVentilationRl.HEATING.value ? HeatingAndVentilationRl.HEATING : HeatingAndVentilationRl.__UNKNOWN__;
        }
    }

    public static enum HeatingAndVentilationRr {
        NOT_PRESENT(0),
        VENTILATION_HEATING(1),
        VENTILATION(2),
        HEATING(3),
        __UNKNOWN__(-1);

        public final int value;

        private HeatingAndVentilationRr(int value) {
            this.value = value;
        }

        public static HeatingAndVentilationRr valueOf(int value) {
            if(value == HeatingAndVentilationRr.NOT_PRESENT.value) {
                return HeatingAndVentilationRr.NOT_PRESENT;
            }
            if(value == HeatingAndVentilationRr.VENTILATION_HEATING.value) {
                return HeatingAndVentilationRr.VENTILATION_HEATING;
            }
            if(value == HeatingAndVentilationRr.VENTILATION.value) {
                return HeatingAndVentilationRr.VENTILATION;
            }
            return value == HeatingAndVentilationRr.HEATING.value ? HeatingAndVentilationRr.HEATING : HeatingAndVentilationRr.__UNKNOWN__;
        }
    }

    public static enum LaneChangeAssist {
        NOT_PRESENT(0),
        LEFT(1),
        RIGHT(2),
        LEFT_AND_RIGHT(3),
        __UNKNOWN__(-1);

        public final int value;

        private LaneChangeAssist(int value) {
            this.value = value;
        }

        public static LaneChangeAssist valueOf(int value) {
            if(value == LaneChangeAssist.NOT_PRESENT.value) {
                return LaneChangeAssist.NOT_PRESENT;
            }
            if(value == LaneChangeAssist.LEFT.value) {
                return LaneChangeAssist.LEFT;
            }
            if(value == LaneChangeAssist.RIGHT.value) {
                return LaneChangeAssist.RIGHT;
            }
            return value == LaneChangeAssist.LEFT_AND_RIGHT.value ? LaneChangeAssist.LEFT_AND_RIGHT : LaneChangeAssist.__UNKNOWN__;
        }
    }

    public static enum LeftRightHandDriveVehicles {
        LEFT(0),
        RIGHT(1),
        __UNKNOWN__(-1);

        public final int value;

        private LeftRightHandDriveVehicles(int value) {
            this.value = value;
        }

        public static LeftRightHandDriveVehicles valueOf(int value) {
            if(value == LeftRightHandDriveVehicles.LEFT.value) {
                return LeftRightHandDriveVehicles.LEFT;
            }
            return value == LeftRightHandDriveVehicles.RIGHT.value ? LeftRightHandDriveVehicles.RIGHT : LeftRightHandDriveVehicles.__UNKNOWN__;
        }
    }

    public static enum LimitSecondRowSeatsWelcomeFunction {
        NONE(0),
        RL(1),
        RR(2),
        RL_PLUSRR(3),
        __UNKNOWN__(-1);

        public final int value;

        private LimitSecondRowSeatsWelcomeFunction(int value) {
            this.value = value;
        }

        public static LimitSecondRowSeatsWelcomeFunction valueOf(int value) {
            if(value == LimitSecondRowSeatsWelcomeFunction.NONE.value) {
                return LimitSecondRowSeatsWelcomeFunction.NONE;
            }
            if(value == LimitSecondRowSeatsWelcomeFunction.RL.value) {
                return LimitSecondRowSeatsWelcomeFunction.RL;
            }
            if(value == LimitSecondRowSeatsWelcomeFunction.RR.value) {
                return LimitSecondRowSeatsWelcomeFunction.RR;
            }
            return value == LimitSecondRowSeatsWelcomeFunction.RL_PLUSRR.value ? LimitSecondRowSeatsWelcomeFunction.RL_PLUSRR : LimitSecondRowSeatsWelcomeFunction.__UNKNOWN__;
        }
    }

    public static enum LoudspeakerNumber {
        FOUR(0),
        SIX(1),
        EIGHT(2),
        TEN(3),
        THIRTEEN(4),
        TWO(5),
        __UNKNOWN__(-1);

        public final int value;

        private LoudspeakerNumber(int value) {
            this.value = value;
        }

        public static LoudspeakerNumber valueOf(int value) {
            if(value == LoudspeakerNumber.FOUR.value) {
                return LoudspeakerNumber.FOUR;
            }
            if(value == LoudspeakerNumber.SIX.value) {
                return LoudspeakerNumber.SIX;
            }
            if(value == LoudspeakerNumber.EIGHT.value) {
                return LoudspeakerNumber.EIGHT;
            }
            if(value == LoudspeakerNumber.TEN.value) {
                return LoudspeakerNumber.TEN;
            }
            if(value == LoudspeakerNumber.THIRTEEN.value) {
                return LoudspeakerNumber.THIRTEEN;
            }
            return value == LoudspeakerNumber.TWO.value ? LoudspeakerNumber.TWO : LoudspeakerNumber.__UNKNOWN__;
        }
    }

    public static enum LoudspeakerSupplier {
        LONGDA(0),
        FOSTER(1),
        ALPINE(2),
        HARMAN(3),
        YAMAHA(4),
        __UNKNOWN__(-1);

        public final int value;

        private LoudspeakerSupplier(int value) {
            this.value = value;
        }

        public static LoudspeakerSupplier valueOf(int value) {
            if(value == LoudspeakerSupplier.LONGDA.value) {
                return LoudspeakerSupplier.LONGDA;
            }
            if(value == LoudspeakerSupplier.FOSTER.value) {
                return LoudspeakerSupplier.FOSTER;
            }
            if(value == LoudspeakerSupplier.ALPINE.value) {
                return LoudspeakerSupplier.ALPINE;
            }
            if(value == LoudspeakerSupplier.HARMAN.value) {
                return LoudspeakerSupplier.HARMAN;
            }
            return value == LoudspeakerSupplier.YAMAHA.value ? LoudspeakerSupplier.YAMAHA : LoudspeakerSupplier.__UNKNOWN__;
        }
    }

    public static enum NapMode {
        NOT_PRESENT(0),
        DRIVER_AND_PASSENGER(1),
        DRIVER(2),
        PASSENGER(3),
        __UNKNOWN__(-1);

        public final int value;

        private NapMode(int value) {
            this.value = value;
        }

        public static NapMode valueOf(int value) {
            if(value == NapMode.NOT_PRESENT.value) {
                return NapMode.NOT_PRESENT;
            }
            if(value == NapMode.DRIVER_AND_PASSENGER.value) {
                return NapMode.DRIVER_AND_PASSENGER;
            }
            if(value == NapMode.DRIVER.value) {
                return NapMode.DRIVER;
            }
            return value == NapMode.PASSENGER.value ? NapMode.PASSENGER : NapMode.__UNKNOWN__;
        }
    }

    public static enum PromptType {
        NOT_PRESENT(0),
        SOUND_AND_VOICE(1),
        SOUND_AND_VOICE_AND_SEAT_VIBRATION(2),
        ALARM_AND_SEAT_VIBRATION_AND_ALARM_AND_SEAT_VIBRATION(3),
        __UNKNOWN__(-1);

        public final int value;

        private PromptType(int value) {
            this.value = value;
        }

        public static PromptType valueOf(int value) {
            if(value == PromptType.NOT_PRESENT.value) {
                return PromptType.NOT_PRESENT;
            }
            if(value == PromptType.SOUND_AND_VOICE.value) {
                return PromptType.SOUND_AND_VOICE;
            }
            if(value == PromptType.SOUND_AND_VOICE_AND_SEAT_VIBRATION.value) {
                return PromptType.SOUND_AND_VOICE_AND_SEAT_VIBRATION;
            }
            return value == PromptType.ALARM_AND_SEAT_VIBRATION_AND_ALARM_AND_SEAT_VIBRATION.value ? PromptType.ALARM_AND_SEAT_VIBRATION_AND_ALARM_AND_SEAT_VIBRATION : PromptType.__UNKNOWN__;
        }
    }

    public static enum RadarNumber {
        NONE(0),
        FRONT_0_REAR_3(1),
        FRONT_0_REAR_4(2),
        FRONT_2_REAR_3(3),
        FRONT_2_REAR_4(4),
        FRONT_4_REAR_4(5),
        FRONT_4_MID_4_REAR_4(6),
        FRONT_6_REAR_6(7),
        __UNKNOWN__(-1);

        public final int value;

        private RadarNumber(int value) {
            this.value = value;
        }

        public static RadarNumber valueOf(int value) {
            if(value == RadarNumber.NONE.value) {
                return RadarNumber.NONE;
            }
            if(value == RadarNumber.FRONT_0_REAR_3.value) {
                return RadarNumber.FRONT_0_REAR_3;
            }
            if(value == RadarNumber.FRONT_0_REAR_4.value) {
                return RadarNumber.FRONT_0_REAR_4;
            }
            if(value == RadarNumber.FRONT_2_REAR_3.value) {
                return RadarNumber.FRONT_2_REAR_3;
            }
            if(value == RadarNumber.FRONT_2_REAR_4.value) {
                return RadarNumber.FRONT_2_REAR_4;
            }
            if(value == RadarNumber.FRONT_4_REAR_4.value) {
                return RadarNumber.FRONT_4_REAR_4;
            }
            if(value == RadarNumber.FRONT_4_MID_4_REAR_4.value) {
                return RadarNumber.FRONT_4_MID_4_REAR_4;
            }
            return value == RadarNumber.FRONT_6_REAR_6.value ? RadarNumber.FRONT_6_REAR_6 : RadarNumber.__UNKNOWN__;
        }
    }

    public static enum RearDefrostAndRearviewMirrorHeating {
        NOT_PRESENT(0),
        REAR_DEFROST_AND_REARVIEW_MIRROR_HEATING(1),
        REAR_DEFROS(2),
        REARVIEW_MIRROR_HEATING(3),
        __UNKNOWN__(-1);

        public final int value;

        private RearDefrostAndRearviewMirrorHeating(int value) {
            this.value = value;
        }

        public static RearDefrostAndRearviewMirrorHeating valueOf(int value) {
            if(value == RearDefrostAndRearviewMirrorHeating.NOT_PRESENT.value) {
                return RearDefrostAndRearviewMirrorHeating.NOT_PRESENT;
            }
            if(value == RearDefrostAndRearviewMirrorHeating.REAR_DEFROST_AND_REARVIEW_MIRROR_HEATING.value) {
                return RearDefrostAndRearviewMirrorHeating.REAR_DEFROST_AND_REARVIEW_MIRROR_HEATING;
            }
            if(value == RearDefrostAndRearviewMirrorHeating.REAR_DEFROS.value) {
                return RearDefrostAndRearviewMirrorHeating.REAR_DEFROS;
            }
            return value == RearDefrostAndRearviewMirrorHeating.REARVIEW_MIRROR_HEATING.value ? RearDefrostAndRearviewMirrorHeating.REARVIEW_MIRROR_HEATING : RearDefrostAndRearviewMirrorHeating.__UNKNOWN__;
        }
    }

    public static enum SeatLayout {
        FIVE_LAYOUT(3),
        SIX_LAYOUT(1),
        SEVEN_LAYOUT(2),
        NONE_LAYOUT(0),
        __UNKNOWN__(-1);

        public final int value;

        private SeatLayout(int value) {
            this.value = value;
        }

        public static SeatLayout valueOf(int value) {
            if(value == SeatLayout.FIVE_LAYOUT.value) {
                return SeatLayout.FIVE_LAYOUT;
            }
            if(value == SeatLayout.SIX_LAYOUT.value) {
                return SeatLayout.SIX_LAYOUT;
            }
            if(value == SeatLayout.SEVEN_LAYOUT.value) {
                return SeatLayout.SEVEN_LAYOUT;
            }
            return value == SeatLayout.NONE_LAYOUT.value ? SeatLayout.SEVEN_LAYOUT : SeatLayout.__UNKNOWN__;
        }
    }

    public static enum SecondRowSeatsControl {
        NONE(0),
        EIGHT_CONTROL(1),
        SIX_CONTROL(2),
        __UNKNOWN__(-1);

        public final int value;

        private SecondRowSeatsControl(int value) {
            this.value = value;
        }

        public static SecondRowSeatsControl valueOf(int value) {
            if(value == SecondRowSeatsControl.NONE.value) {
                return SecondRowSeatsControl.NONE;
            }
            if(value == SecondRowSeatsControl.EIGHT_CONTROL.value) {
                return SecondRowSeatsControl.EIGHT_CONTROL;
            }
            return value == SecondRowSeatsControl.SIX_CONTROL.value ? SecondRowSeatsControl.SIX_CONTROL : SecondRowSeatsControl.__UNKNOWN__;
        }
    }

    public static enum SecondRowSeatsWelcome {
        NONE(0),
        RL(1),
        RR(2),
        RL_PLUSRR(3),
        __UNKNOWN__(-1);

        public final int value;

        private SecondRowSeatsWelcome(int value) {
            this.value = value;
        }

        public static SecondRowSeatsWelcome valueOf(int value) {
            if(value == SecondRowSeatsWelcome.NONE.value) {
                return SecondRowSeatsWelcome.NONE;
            }
            if(value == SecondRowSeatsWelcome.RL.value) {
                return SecondRowSeatsWelcome.RL;
            }
            if(value == SecondRowSeatsWelcome.RR.value) {
                return SecondRowSeatsWelcome.RR;
            }
            return value == SecondRowSeatsWelcome.RL_PLUSRR.value ? SecondRowSeatsWelcome.RL_PLUSRR : SecondRowSeatsWelcome.__UNKNOWN__;
        }
    }

    public static enum StandardAndHdCameraConfiguration {
        STANDARD_DEFINITION(0),
        HIGH_DEFINITION(1),
        __UNKNOWN__(-1);

        public final int value;

        private StandardAndHdCameraConfiguration(int value) {
            this.value = value;
        }

        public static StandardAndHdCameraConfiguration valueOf(int value) {
            if(value == StandardAndHdCameraConfiguration.STANDARD_DEFINITION.value) {
                return StandardAndHdCameraConfiguration.STANDARD_DEFINITION;
            }
            return value == StandardAndHdCameraConfiguration.HIGH_DEFINITION.value ? StandardAndHdCameraConfiguration.HIGH_DEFINITION : StandardAndHdCameraConfiguration.__UNKNOWN__;
        }
    }

    public static enum TboxConnectionMode {
        NO_CONNECTION(0),
        USB(1),
        ETH(2),
        __UNKNOWN__(-1);

        public final int value;

        private TboxConnectionMode(int value) {
            this.value = value;
        }

        public static TboxConnectionMode valueOf(int value) {
            if(value == TboxConnectionMode.NO_CONNECTION.value) {
                return TboxConnectionMode.NO_CONNECTION;
            }
            if(value == TboxConnectionMode.USB.value) {
                return TboxConnectionMode.USB;
            }
            return value == TboxConnectionMode.ETH.value ? TboxConnectionMode.ETH : TboxConnectionMode.__UNKNOWN__;
        }
    }

    public static enum Tiktok {
        NOT_PRESENT(0),
        NO_SHOOTING_FUNCTION(1),
        SHOOTING_FUNCTION_PLUSINDOOR_SHOOTING(2),
        SHOOTING_FUNCTION_PLUSOUTING_AND_INDOOR_SHOOTING(3),
        __UNKNOWN__(-1);

        public final int value;

        private Tiktok(int value) {
            this.value = value;
        }

        public static Tiktok valueOf(int value) {
            if(value == Tiktok.NOT_PRESENT.value) {
                return Tiktok.NOT_PRESENT;
            }
            if(value == Tiktok.NO_SHOOTING_FUNCTION.value) {
                return Tiktok.NO_SHOOTING_FUNCTION;
            }
            if(value == Tiktok.SHOOTING_FUNCTION_PLUSINDOOR_SHOOTING.value) {
                return Tiktok.SHOOTING_FUNCTION_PLUSINDOOR_SHOOTING;
            }
            return value == Tiktok.SHOOTING_FUNCTION_PLUSOUTING_AND_INDOOR_SHOOTING.value ? Tiktok.SHOOTING_FUNCTION_PLUSOUTING_AND_INDOOR_SHOOTING : Tiktok.__UNKNOWN__;
        }
    }

    public static enum VehiclePlatform {
        A75_2_A77(17),
        A12(0x20),
        A12_HIGH(33),
        A18(34),
        A18_HIGH(35),
        A55(36),
        A60(50),
        A13(51),
        A18_Y(52),
        A60_1(0x40),
        A58(65),
        A88(66),
        A9E(67),
        A79(71),
        A8E(74),
        A13_Y(75),
        T60_G1(0x71),
        T60_G1_HEV(0x72),
        T58_G2(0x80),
        T58_G3(0x6F),
        CS108(0xA1),
        CS110(0xA0),
        CS111(0x88),
        CS112(0x94),
        __UNKNOWN__(-1);

        public final int value;

        private VehiclePlatform(int value) {
            this.value = value;
        }

        public static VehiclePlatform valueOf(int value) {
            if(value == VehiclePlatform.A75_2_A77.value) {
                return VehiclePlatform.A75_2_A77;
            }
            if(value == VehiclePlatform.A12.value) {
                return VehiclePlatform.A12;
            }
            if(value == VehiclePlatform.A12_HIGH.value) {
                return VehiclePlatform.A12_HIGH;
            }
            if(value == VehiclePlatform.A18.value) {
                return VehiclePlatform.A18;
            }
            if(value == VehiclePlatform.A18_HIGH.value) {
                return VehiclePlatform.A18_HIGH;
            }
            if(value == VehiclePlatform.A55.value) {
                return VehiclePlatform.A55;
            }
            if(value == VehiclePlatform.A60.value) {
                return VehiclePlatform.A60;
            }
            if(value == VehiclePlatform.A13.value) {
                return VehiclePlatform.A13;
            }
            if(value == VehiclePlatform.A18_Y.value) {
                return VehiclePlatform.A18_Y;
            }
            if(value == VehiclePlatform.A60_1.value) {
                return VehiclePlatform.A60_1;
            }
            if(value == VehiclePlatform.A58.value) {
                return VehiclePlatform.A58;
            }
            if(value == VehiclePlatform.A88.value) {
                return VehiclePlatform.A88;
            }
            if(value == VehiclePlatform.A9E.value) {
                return VehiclePlatform.A9E;
            }
            if(value == VehiclePlatform.A79.value) {
                return VehiclePlatform.A79;
            }
            if(value == VehiclePlatform.A8E.value) {
                return VehiclePlatform.A8E;
            }
            if(value == VehiclePlatform.A13_Y.value) {
                return VehiclePlatform.A13_Y;
            }
            if(value == VehiclePlatform.T60_G1.value) {
                return VehiclePlatform.T60_G1;
            }
            if(value == VehiclePlatform.T60_G1_HEV.value) {
                return VehiclePlatform.T60_G1_HEV;
            }
            if(value == VehiclePlatform.T58_G2.value) {
                return VehiclePlatform.T58_G2;
            }
            if(value == VehiclePlatform.T58_G3.value) {
                return VehiclePlatform.T58_G3;
            }
            if(value == VehiclePlatform.CS108.value) {
                return VehiclePlatform.CS108;
            }
            if(value == VehiclePlatform.CS110.value) {
                return VehiclePlatform.CS110;
            }
            if(value == VehiclePlatform.CS111.value) {
                return VehiclePlatform.CS111;
            }
            return value == VehiclePlatform.CS112.value ? VehiclePlatform.CS112 : VehiclePlatform.__UNKNOWN__;
        }
    }

    public static enum VehicleType {
        TRADITIONAL_CAR(0),
        EV(1),
        HEV(2),
        PHEV(3),
        __UNKNOWN__(-1);

        public final int value;

        private VehicleType(int value) {
            this.value = value;
        }

        public static VehicleType valueOf(int value) {
            if(value == VehicleType.TRADITIONAL_CAR.value) {
                return VehicleType.TRADITIONAL_CAR;
            }
            if(value == VehicleType.EV.value) {
                return VehicleType.EV;
            }
            if(value == VehicleType.HEV.value) {
                return VehicleType.HEV;
            }
            return value == VehicleType.PHEV.value ? VehicleType.PHEV : VehicleType.__UNKNOWN__;
        }
    }

    public static enum VrControl {
        ONE_ZONE(1),
        TWO_ZONE(2),
        THREE_ZONE(3),
        __UNKNOWN__(-1);

        public final int value;

        private VrControl(int value) {
            this.value = value;
        }

        public static VrControl valueOf(int value) {
            if(value == VrControl.ONE_ZONE.value) {
                return VrControl.ONE_ZONE;
            }
            if(value == VrControl.TWO_ZONE.value) {
                return VrControl.TWO_ZONE;
            }
            return value == VrControl.THREE_ZONE.value ? VrControl.THREE_ZONE : VrControl.__UNKNOWN__;
        }
    }

    public static enum VrControlCarwindow {
        NOT_PRESENT(0),
        LEFT_FRONT_WINDOW(1),
        FOUR_DOOR_WINDOWS(2),
        __UNKNOWN__(-1);

        public final int value;

        private VrControlCarwindow(int value) {
            this.value = value;
        }

        public static VrControlCarwindow valueOf(int value) {
            if(value == VrControlCarwindow.NOT_PRESENT.value) {
                return VrControlCarwindow.NOT_PRESENT;
            }
            if(value == VrControlCarwindow.LEFT_FRONT_WINDOW.value) {
                return VrControlCarwindow.LEFT_FRONT_WINDOW;
            }
            return value == VrControlCarwindow.FOUR_DOOR_WINDOWS.value ? VrControlCarwindow.FOUR_DOOR_WINDOWS : VrControlCarwindow.__UNKNOWN__;
        }
    }

    public static enum VrControlHvac {
        NONE(0),
        NON_ANION_MODE(1),
        ANION_MODE(2),
        __UNKNOWN__(-1);

        public final int value;

        private VrControlHvac(int value) {
            this.value = value;
        }

        public static VrControlHvac valueOf(int value) {
            if(value == VrControlHvac.NONE.value) {
                return VrControlHvac.NONE;
            }
            if(value == VrControlHvac.NON_ANION_MODE.value) {
                return VrControlHvac.NON_ANION_MODE;
            }
            return value == VrControlHvac.ANION_MODE.value ? VrControlHvac.ANION_MODE : VrControlHvac.__UNKNOWN__;
        }
    }

    public static enum VrControlIal {
        NOT_PRESENT(0),
        MONOCHROMATIC(1),
        INTELLIGENT(2),
        __UNKNOWN__(-1);

        public final int value;

        private VrControlIal(int value) {
            this.value = value;
        }

        public static VrControlIal valueOf(int value) {
            if(value == VrControlIal.NOT_PRESENT.value) {
                return VrControlIal.NOT_PRESENT;
            }
            if(value == VrControlIal.MONOCHROMATIC.value) {
                return VrControlIal.MONOCHROMATIC;
            }
            return value == VrControlIal.INTELLIGENT.value ? VrControlIal.INTELLIGENT : VrControlIal.__UNKNOWN__;
        }
    }

    public static enum VrControlParking {
        NONE(0),
        SVM(1),
        APA(2),
        FAPA(3),
        AVP(4),
        __UNKNOWN__(-1);

        public final int value;

        private VrControlParking(int value) {
            this.value = value;
        }

        public static VrControlParking valueOf(int value) {
            if(value == VrControlParking.NONE.value) {
                return VrControlParking.NONE;
            }
            if(value == VrControlParking.SVM.value) {
                return VrControlParking.SVM;
            }
            if(value == VrControlParking.APA.value) {
                return VrControlParking.APA;
            }
            if(value == VrControlParking.FAPA.value) {
                return VrControlParking.FAPA;
            }
            return value == VrControlParking.AVP.value ? VrControlParking.AVP : VrControlParking.__UNKNOWN__;
        }
    }

    public static enum VrControlRoof {
        NOT_PRESENT(0),
        PANORAMIC_SUNROOF(1),
        NORMAL_SUNROOF(2),
        __UNKNOWN__(-1);

        public final int value;

        private VrControlRoof(int value) {
            this.value = value;
        }

        public static VrControlRoof valueOf(int value) {
            if(value == VrControlRoof.NOT_PRESENT.value) {
                return VrControlRoof.NOT_PRESENT;
            }
            if(value == VrControlRoof.PANORAMIC_SUNROOF.value) {
                return VrControlRoof.PANORAMIC_SUNROOF;
            }
            return value == VrControlRoof.NORMAL_SUNROOF.value ? VrControlRoof.NORMAL_SUNROOF : VrControlRoof.__UNKNOWN__;
        }
    }

    public static enum VrControlRoofposition {
        NOT_PRESENT(0),
        PANORAMIC_SUNROOF(1),
        NORMAL_SUNROOF(2),
        __UNKNOWN__(-1);

        public final int value;

        private VrControlRoofposition(int value) {
            this.value = value;
        }

        public static VrControlRoofposition valueOf(int value) {
            if(value == VrControlRoofposition.NOT_PRESENT.value) {
                return VrControlRoofposition.NOT_PRESENT;
            }
            if(value == VrControlRoofposition.PANORAMIC_SUNROOF.value) {
                return VrControlRoofposition.PANORAMIC_SUNROOF;
            }
            return value == VrControlRoofposition.NORMAL_SUNROOF.value ? VrControlRoofposition.NORMAL_SUNROOF : VrControlRoofposition.__UNKNOWN__;
        }
    }

    public static enum VrControlWindowposition {
        NOT_PRESENT(0),
        LEFT_FRONT_WINDOW(1),
        FOUR_DOOR_WINDOWS(2),
        __UNKNOWN__(-1);

        public final int value;

        private VrControlWindowposition(int value) {
            this.value = value;
        }

        public static VrControlWindowposition valueOf(int value) {
            if(value == VrControlWindowposition.NOT_PRESENT.value) {
                return VrControlWindowposition.NOT_PRESENT;
            }
            if(value == VrControlWindowposition.LEFT_FRONT_WINDOW.value) {
                return VrControlWindowposition.LEFT_FRONT_WINDOW;
            }
            return value == VrControlWindowposition.FOUR_DOOR_WINDOWS.value ? VrControlWindowposition.FOUR_DOOR_WINDOWS : VrControlWindowposition.__UNKNOWN__;
        }
    }

    public static enum VrControlWiperAndCleaning {
        NOT_PRESENT(0),
        FRONT_WIPER_CLEANING(1),
        FRONT_AND_REAR_WIPER_CLEANING(2),
        __UNKNOWN__(-1);

        public final int value;

        private VrControlWiperAndCleaning(int value) {
            this.value = value;
        }

        public static VrControlWiperAndCleaning valueOf(int value) {
            if(value == VrControlWiperAndCleaning.NOT_PRESENT.value) {
                return VrControlWiperAndCleaning.NOT_PRESENT;
            }
            if(value == VrControlWiperAndCleaning.FRONT_WIPER_CLEANING.value) {
                return VrControlWiperAndCleaning.FRONT_WIPER_CLEANING;
            }
            return value == VrControlWiperAndCleaning.FRONT_AND_REAR_WIPER_CLEANING.value ? VrControlWiperAndCleaning.FRONT_AND_REAR_WIPER_CLEANING : VrControlWiperAndCleaning.__UNKNOWN__;
        }
    }

    public static enum WalAndApu {
        NOT_PRESENT(0),
        WAL(1),
        APU(2),
        WAL_AND_APU(3),
        __UNKNOWN__(-1);

        public final int value;

        private WalAndApu(int value) {
            this.value = value;
        }

        public static WalAndApu valueOf(int value) {
            if(value == WalAndApu.NOT_PRESENT.value) {
                return WalAndApu.NOT_PRESENT;
            }
            if(value == WalAndApu.WAL.value) {
                return WalAndApu.WAL;
            }
            if(value == WalAndApu.APU.value) {
                return WalAndApu.APU;
            }
            return value == WalAndApu.WAL_AND_APU.value ? WalAndApu.WAL_AND_APU : WalAndApu.__UNKNOWN__;
        }
    }

    public static enum WindowControl {
        NOT_PRESENT(0),
        LEFT_FRONT_WINDOW(1),
        FOUR_DOOR_WINDOWS(2),
        LEFT_AND_RIGHT_FRONT_WINDOW(3),
        __UNKNOWN__(-1);

        public final int value;

        private WindowControl(int value) {
            this.value = value;
        }

        public static WindowControl valueOf(int value) {
            if(value == WindowControl.NOT_PRESENT.value) {
                return WindowControl.NOT_PRESENT;
            }
            if(value == WindowControl.LEFT_FRONT_WINDOW.value) {
                return WindowControl.LEFT_FRONT_WINDOW;
            }
            if(value == WindowControl.FOUR_DOOR_WINDOWS.value) {
                return WindowControl.FOUR_DOOR_WINDOWS;
            }
            return value == WindowControl.LEFT_AND_RIGHT_FRONT_WINDOW.value ? WindowControl.LEFT_AND_RIGHT_FRONT_WINDOW : WindowControl.__UNKNOWN__;
        }
    }

    public static final int CAR_CONFIG = 0x270B;

}

