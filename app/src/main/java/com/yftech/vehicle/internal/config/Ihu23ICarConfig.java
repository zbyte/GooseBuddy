package com.yftech.vehicle.internal.config;

public interface Ihu23ICarConfig {
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

    public static enum CameraNumber {
        NONE(0),
        RVC(1),
        SVM(2),
        SVM_PLUSAPA(3),
        SVM_PLUSFAPA(4),
        SVM_PLUSAVP(5),
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
            return value == CameraNumber.SVM_PLUSAVP.value ? CameraNumber.SVM_PLUSAVP : CameraNumber.__UNKNOWN__;
        }
    }

    public static enum Config {
        VEHICLE_TYPE(0, 0, 1),
        DRIVE_TYPE(0, 2, 3),
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
        IBCM(3, 6),
        FL_SPEAKER(4, 1),
        FR_SPEAKER(4, 2),
        RL_SPEAKER(4, 3),
        RR_SPEAKER(4, 4),
        STEERING_WHEEL_KEY(4, 5),
        OTA_SWITCH(5, 7),
        TBOX_CONNECTION_MODE(6, 0, 1),
        B_CALL_SWITCH(6, 4),
        E_CALL_SWITCH(6, 5),
        CALL_BACK(6, 6),
        RESTART_VEHICLE_COMMUNICATION_MODULE(6, 7),
        LOUDSPEAKER_NUMBER(7, 0, 3),
        LOUDSPEAKER_SUPPLIER(7, 4, 6),
        EXT_AMPLIFIERS(7, 7),
        AVAS(8, 0),
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
        CHARGING_THRESHOLD(10, 5),
        HEAT_PUMP_AIR_CONDITIONING(11, 0),
        AIR_CONDITIONING_ZONES(11, 1, 2),
        REAR_DEFROST_AND_REARVIEW_MIRROR_HEATING(11, 3, 4),
        AIR_CONDITION_TYPE(11, 7),
        CAMERA_NUMBER(12, 0, 2),
        RADAR_NUMBER(12, 3, 5),
        AUTOHOLD(12, 7),
        STANDARD_AND_HD_CAMERA_CONFIGURATION(12, 6),
        FRONT_FOG_LAMP(14, 2),
        ADAPTIVE_HIGH_BEAM(14, 3),
        CONTROL_HIGH_BEAM_ASSISTANT(14, 4),
        CLOSE_WINDOW_WHILE_LOCK(14, 5),
        DOME_LIGHT_IN_DOOR_GEAR_POSITION(14, 6),
        CONTROL_SMART_WELCOME_LIGHT(14, 7),
        KEY_IDENTIFICATION(15, 0),
        SMART_TAILGATE(15, 3),
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
        RAINSTORM_MODE(19, 5),
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
        CHARGING_MODE(22, 3),
        LANE_AUXILIARY_SWITCH(23, 0),
        LANE_ASSIST(23, 1),
        AUTO_EMERGENCY_BRAKING_BRAKING(23, 2),
        FRONT_COLLISION_WARNING(23, 3),
        IFC_CRUISEMODE(23, 4),
        BSD(23, 5),
        DOOR_OPEN_WARNING(23, 7),
        OVERSPEED_WARNING(24, 0),
        SPEED_LIMTED_SIGN_RECOGNITION(24, 1),
        STEERING_MODE(24, 2),
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
        DRIVING_MODE_TYPE(29, 4, 6),
        LEFT_RIGHT_HAND_DRIVE_VEHICLES(35, 6),
        ULTRAVIOLET_RAY(39, 0),
        UNLOCK_VENTILATION(39, 1),
        EVAPORATOR_SELF_DRYING(39, 2),
        AIR_CONDITIONING_BLIND_EXERCISE(39, 3),
        AIR_CONDITIONING_QUICK_START(39, 4),
        HOSPITALITY_LAMP_SIGNALS(39, 6),
        TEMPORARY_PARKING_LAMP_SIGNALS(39, 7),
        LANE_CHANGE_DRIVER_CONFIRMATION(40, 0),
        LANE_CHANGE_STYLE(40, 1),
        INDICATED_LANE_CHANGING(40, 2),
        FRONT_DISTANCE_DISPLAY(40, 3),
        INTELLIGENT_COLLISION_AVOIDANCE(40, 4),
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

    public static enum DrivingModeType {
        ECO_NORMAL_SPORT(0),
        ECO_IPEDAL(1),
        __UNKNOWN__(-1);

        public final int value;

        private DrivingModeType(int value) {
            this.value = value;
        }

        public static DrivingModeType valueOf(int value) {
            if(value == DrivingModeType.ECO_NORMAL_SPORT.value) {
                return DrivingModeType.ECO_NORMAL_SPORT;
            }
            return value == DrivingModeType.ECO_IPEDAL.value ? DrivingModeType.ECO_IPEDAL : DrivingModeType.__UNKNOWN__;
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
            return value == LoudspeakerSupplier.HARMAN.value ? LoudspeakerSupplier.HARMAN : LoudspeakerSupplier.__UNKNOWN__;
        }
    }

    public static enum RadarNumber {
        NONE(0),
        FRONT_0_REAR_3(1),
        FRONT_0_REAR_4(2),
        FRONT_2_REAR_3(3),
        FRONT_2_REAR_4(3),
        FRONT_4_REAR_4(4),
        FRONT_4_MID_4_REAR_4(5),
        FRONT_6_REAR_6(6),
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

    public static enum VehiclePlatform {
        NONE(0),
        A29_Y(42),
        __UNKNOWN__(-1);

        public final int value;

        private VehiclePlatform(int value) {
            this.value = value;
        }

        public static VehiclePlatform valueOf(int value) {
            if(value == VehiclePlatform.NONE.value) {
                return VehiclePlatform.NONE;
            }
            if(value == VehiclePlatform.A29_Y.value) {
                return VehiclePlatform.A29_Y;
            }
            return value == 77 ? VehiclePlatform.A29_Y : VehiclePlatform.__UNKNOWN__;
        }
    }

    public static enum VehicleType {
        TRADITIONAL_CAR(0),
        EV(1),
        HEV(2),
        TRADITIONAL_CAR_MASTER(3),
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
            return value == VehicleType.TRADITIONAL_CAR_MASTER.value ? VehicleType.TRADITIONAL_CAR_MASTER : VehicleType.__UNKNOWN__;
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

    public static final int CAR_CONFIG = 0x270B;

}

