package com.yftech.vehicle.internal.adapter;

public interface ICarParking extends IBaseApi {
    public static enum PASErrorFlag {
        NOT_FAULT(0),
        FAULT(1),
        __UNKNOWN__(-1);

        public final int value;

        private PASErrorFlag(int v1) {
            this.value = v1;
        }

        public static PASErrorFlag valueOf(int v) {
            if(v == PASErrorFlag.NOT_FAULT.value) {
                return PASErrorFlag.NOT_FAULT;
            }
            return v == PASErrorFlag.FAULT.value ? PASErrorFlag.FAULT : PASErrorFlag.__UNKNOWN__;
        }
    }

    public static enum PASSystemFailureFlag {
        NOT_FAILURE(0),
        FRONT_FAILURE(1),
        REAR_FAILURE(2),
        SYSTEM_FAILURE(3),
        __UNKNOWN__(-1);

        public final int value;

        private PASSystemFailureFlag(int v1) {
            this.value = v1;
        }

        public static PASSystemFailureFlag valueOf(int v) {
            if(v == PASSystemFailureFlag.NOT_FAILURE.value) {
                return PASSystemFailureFlag.NOT_FAILURE;
            }
            if(v == PASSystemFailureFlag.FRONT_FAILURE.value) {
                return PASSystemFailureFlag.FRONT_FAILURE;
            }
            if(v == PASSystemFailureFlag.REAR_FAILURE.value) {
                return PASSystemFailureFlag.REAR_FAILURE;
            }
            return v == PASSystemFailureFlag.SYSTEM_FAILURE.value ? PASSystemFailureFlag.SYSTEM_FAILURE : PASSystemFailureFlag.__UNKNOWN__;
        }
    }

    public static enum PASSystemType {
        RPA(0),
        APA(1),
        __UNKNOWN__(-1);

        public final int value;

        private PASSystemType(int v1) {
            this.value = v1;
        }

        public static PASSystemType valueOf(int v) {
            if(v == PASSystemType.RPA.value) {
                return PASSystemType.RPA;
            }
            return v == PASSystemType.APA.value ? PASSystemType.APA : PASSystemType.__UNKNOWN__;
        }
    }

    public static enum PASWarnTone {
        NOT_ACTIVE(0),
        CONTINUOUS_TONE(1),
        FAST_INTERMITTENT_TONE(2),
        MEDIUM_SPEED_INTERMITTENT_TONE(3),
        SLOW_INTERMITTENT_TONE(4),
        MUTE(5),
        __UNKNOWN__(-1);

        public final int value;

        private PASWarnTone(int v1) {
            this.value = v1;
        }

        public static PASWarnTone valueOf(int v) {
            if(v == PASWarnTone.NOT_ACTIVE.value) {
                return PASWarnTone.NOT_ACTIVE;
            }
            if(v == PASWarnTone.CONTINUOUS_TONE.value) {
                return PASWarnTone.CONTINUOUS_TONE;
            }
            if(v == PASWarnTone.FAST_INTERMITTENT_TONE.value) {
                return PASWarnTone.FAST_INTERMITTENT_TONE;
            }
            if(v == PASWarnTone.MEDIUM_SPEED_INTERMITTENT_TONE.value) {
                return PASWarnTone.MEDIUM_SPEED_INTERMITTENT_TONE;
            }
            if(v == PASWarnTone.SLOW_INTERMITTENT_TONE.value) {
                return PASWarnTone.SLOW_INTERMITTENT_TONE;
            }
            return v == PASWarnTone.MUTE.value ? PASWarnTone.MUTE : PASWarnTone.__UNKNOWN__;
        }
    }

    public static final int PARKING_RADAR_ALARM = 0xFE;
    public static final int PARKING_RADAR_ALARM_SETTING = 0xFF;
    public static final int PARKING_VOICE_SWITCH = 0x100;
    public static final int PARKING_VOICE_SWITCH_SETTING = 0x101;
    public static final int PAS_DISTANCE_FL = 0x88;
    public static final int PAS_DISTANCE_FLSide = 140;
    public static final int PAS_DISTANCE_FL_MIDDLE = 0x83;
    public static final int PAS_DISTANCE_FR = 0x87;
    public static final int PAS_DISTANCE_FRSide = 0x8B;
    public static final int PAS_DISTANCE_FR_MIDDLE = 0x84;
    public static final int PAS_DISTANCE_RL = 0x86;
    public static final int PAS_DISTANCE_RLSide = 0x8A;
    public static final int PAS_DISTANCE_RL_MIDDLE = 0x81;
    public static final int PAS_DISTANCE_RR = 0x85;
    public static final int PAS_DISTANCE_RRSide = 0x89;
    public static final int PAS_DISTANCE_RR_MIDDLE = 130;
    public static final int PAS_ERROR_FLAG_OF_EEPROM = 0x91;
    public static final int PAS_ERROR_FLAG_OF_IGN_VOLTAGE = 0x92;
    public static final int PAS_ERROR_FLAG_RL = 0x90;
    public static final int PAS_ERROR_FLAG_RL_MIDDLE = 0x8E;
    public static final int PAS_ERROR_FLAG_RR = 0x8F;
    public static final int PAS_ERROR_FLAG_RR_MIDDLE = 0x8D;
    public static final int PAS_SYSTEM_FAILURE_FLAG = 0x7F;
    public static final int PAS_SYSTEM_TYPE = 0x7E;
    public static final int PAS_WARN_TONE = 0x80;

}

