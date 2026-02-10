package com.yftech.vehicle.internal.adapter;

public interface CarDMS extends IBaseApi {
    public static enum DMSDistrWarn {
        UNAVAILABLE(0),
        UNKNOWN(1),
        DISTRACTIVE(2),
        NO_DISTRACTIVE(3),
        SUSPECTED_DISTRACTIVE(4),
        __UNKNOWN__(-1);

        public final int value;

        private DMSDistrWarn(int v1) {
            this.value = v1;
        }

        public static DMSDistrWarn valueOf(int v) {
            if(v == DMSDistrWarn.UNAVAILABLE.value) {
                return DMSDistrWarn.UNAVAILABLE;
            }
            if(v == DMSDistrWarn.UNKNOWN.value) {
                return DMSDistrWarn.UNKNOWN;
            }
            if(v == DMSDistrWarn.DISTRACTIVE.value) {
                return DMSDistrWarn.DISTRACTIVE;
            }
            if(v == DMSDistrWarn.NO_DISTRACTIVE.value) {
                return DMSDistrWarn.NO_DISTRACTIVE;
            }
            return v == DMSDistrWarn.SUSPECTED_DISTRACTIVE.value ? DMSDistrWarn.SUSPECTED_DISTRACTIVE : DMSDistrWarn.__UNKNOWN__;
        }
    }

    public static enum DMSFatigWarn {
        UNAVAILABLE(0),
        UNKNOWN(1),
        ATTENTIVE(2),
        CAUTIONARY(3),
        SEVERE(4),
        MICROSLEEP(5),
        __UNKNOWN__(-1);

        public final int value;

        private DMSFatigWarn(int v1) {
            this.value = v1;
        }

        public static DMSFatigWarn valueOf(int v) {
            if(v == DMSFatigWarn.UNAVAILABLE.value) {
                return DMSFatigWarn.UNAVAILABLE;
            }
            if(v == DMSFatigWarn.UNKNOWN.value) {
                return DMSFatigWarn.UNKNOWN;
            }
            if(v == DMSFatigWarn.ATTENTIVE.value) {
                return DMSFatigWarn.ATTENTIVE;
            }
            if(v == DMSFatigWarn.CAUTIONARY.value) {
                return DMSFatigWarn.CAUTIONARY;
            }
            if(v == DMSFatigWarn.SEVERE.value) {
                return DMSFatigWarn.SEVERE;
            }
            return v == DMSFatigWarn.MICROSLEEP.value ? DMSFatigWarn.MICROSLEEP : DMSFatigWarn.__UNKNOWN__;
        }
    }

    public static enum DMSMode {
        NO_COMMAND(-1, 0),
        FATIGUE(0, 1),
        DISTRACTION(1, 2),
        FATIGUE_AND_DISTRACTION(2, 3),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private DMSMode(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static DMSMode valueOf(int v) {
            if(v == DMSMode.NO_COMMAND.rx) {
                return DMSMode.NO_COMMAND;
            }
            if(v == DMSMode.FATIGUE.rx) {
                return DMSMode.FATIGUE;
            }
            if(v == DMSMode.DISTRACTION.rx) {
                return DMSMode.DISTRACTION;
            }
            return v == DMSMode.FATIGUE_AND_DISTRACTION.rx ? DMSMode.FATIGUE_AND_DISTRACTION : DMSMode.__UNKNOWN__;
        }
    }

    public static enum DMSSwitch {
        OFF(0),
        PASSIVE(1),
        ACTIVE(2),
        FAILURE(3),
        __UNKNOWN__(-1);

        public final int value;

        private DMSSwitch(int v1) {
            this.value = v1;
        }

        public static DMSSwitch valueOf(int v) {
            if(v == DMSSwitch.OFF.value) {
                return DMSSwitch.OFF;
            }
            if(v == DMSSwitch.PASSIVE.value) {
                return DMSSwitch.PASSIVE;
            }
            if(v == DMSSwitch.ACTIVE.value) {
                return DMSSwitch.ACTIVE;
            }
            return v == DMSSwitch.FAILURE.value ? DMSSwitch.FAILURE : DMSSwitch.__UNKNOWN__;
        }
    }

    public static enum DMSSysErrStatus {
        UNAVAILABLE(0),
        DRIVER_MONITOR_CAMERA_BLOCKED_BY_STEERINGWHEEL(1),
        DRIVER_MONITOR_CAMERA_BLOCKED(2),
        DMS_SYS_ERRO(3),
        FF_LOSE_TEMPLATES(4),
        IR_PROOF_SUNGLASS_DETECTED(5),
        __UNKNOWN__(-1);

        public final int value;

        private DMSSysErrStatus(int v1) {
            this.value = v1;
        }

        public static DMSSysErrStatus valueOf(int v) {
            if(v == DMSSysErrStatus.UNAVAILABLE.value) {
                return DMSSysErrStatus.UNAVAILABLE;
            }
            if(v == DMSSysErrStatus.DRIVER_MONITOR_CAMERA_BLOCKED_BY_STEERINGWHEEL.value) {
                return DMSSysErrStatus.DRIVER_MONITOR_CAMERA_BLOCKED_BY_STEERINGWHEEL;
            }
            if(v == DMSSysErrStatus.DRIVER_MONITOR_CAMERA_BLOCKED.value) {
                return DMSSysErrStatus.DRIVER_MONITOR_CAMERA_BLOCKED;
            }
            if(v == DMSSysErrStatus.DMS_SYS_ERRO.value) {
                return DMSSysErrStatus.DMS_SYS_ERRO;
            }
            if(v == DMSSysErrStatus.FF_LOSE_TEMPLATES.value) {
                return DMSSysErrStatus.FF_LOSE_TEMPLATES;
            }
            return v == DMSSysErrStatus.IR_PROOF_SUNGLASS_DETECTED.value ? DMSSysErrStatus.IR_PROOF_SUNGLASS_DETECTED : DMSSysErrStatus.__UNKNOWN__;
        }
    }

    public static final int DMS_DISTR_WARN_SATUS = 616;
    public static final int DMS_FATIG_WARN_SATUS = 615;
    public static final int DMS_MODE_SATUS = 614;
    public static final int DMS_MODE_SETTING = 613;
    public static final int DMS_SWITCH_SATUS = 612;
    public static final int DMS_SWITCH_SETTING = 611;
    public static final int DMS_SYS_WORK_SATUS = 610;

}

