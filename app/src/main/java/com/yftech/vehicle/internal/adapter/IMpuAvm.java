package com.yftech.vehicle.internal.adapter;

public interface IMpuAvm extends IBaseCmd {
    public static enum AvmCalibrationState {
        NONE(0),
        CLAIBRATING(1),
        SUCCESS(1),
        FAILURE(1),
        PARTIALLY(1),
        __UNKNOWN__(-1);

        public final int value;

        private AvmCalibrationState(int v1) {
            this.value = v1;
        }

        public static AvmCalibrationState valueOf(int v) {
            if(v == AvmCalibrationState.NONE.value) {
                return AvmCalibrationState.NONE;
            }
            if(v == AvmCalibrationState.CLAIBRATING.value) {
                return AvmCalibrationState.CLAIBRATING;
            }
            if(v == AvmCalibrationState.SUCCESS.value) {
                return AvmCalibrationState.SUCCESS;
            }
            if(v == AvmCalibrationState.FAILURE.value) {
                return AvmCalibrationState.FAILURE;
            }
            return v == AvmCalibrationState.PARTIALLY.value ? AvmCalibrationState.PARTIALLY : AvmCalibrationState.__UNKNOWN__;
        }
    }

    public static class AvmCameraState {
        public boolean frontFault;
        public boolean leftFault;
        public boolean rearFault;
        public boolean rightFault;

    }

    public static enum AvmDisplayState {
        OFF(0),
        FULL_SCREEN(1),
        __UNKNOWN__(-1);

        public final int value;

        private AvmDisplayState(int v1) {
            this.value = v1;
        }

        public static AvmDisplayState valueOf(int v) {
            if(v == AvmDisplayState.OFF.value) {
                return AvmDisplayState.OFF;
            }
            return v == AvmDisplayState.FULL_SCREEN.value ? AvmDisplayState.FULL_SCREEN : AvmDisplayState.__UNKNOWN__;
        }
    }

    public static enum AvmFullScreenSwtich {
        DISABLE(0),
        ENABLE(1),
        __UNKNOWN__(-1);

        public final int value;

        private AvmFullScreenSwtich(int v1) {
            this.value = v1;
        }

        public static AvmFullScreenSwtich valueOf(int v) {
            if(v == AvmFullScreenSwtich.DISABLE.value) {
                return AvmFullScreenSwtich.DISABLE;
            }
            return v == AvmFullScreenSwtich.ENABLE.value ? AvmFullScreenSwtich.ENABLE : AvmFullScreenSwtich.__UNKNOWN__;
        }
    }

    public static enum AvmHeartState {
        FAULT(0),
        NORMAL(1),
        __UNKNOWN__(-1);

        public final int value;

        private AvmHeartState(int v1) {
            this.value = v1;
        }

        public static AvmHeartState valueOf(int v) {
            if(v == AvmHeartState.FAULT.value) {
                return AvmHeartState.FAULT;
            }
            return v == AvmHeartState.NORMAL.value ? AvmHeartState.NORMAL : AvmHeartState.__UNKNOWN__;
        }
    }

    public static enum AvmWorkMode {
        INVALID(0),
        UPGRADING(1),
        DEBUG(1),
        NORMAL(1),
        __UNKNOWN__(-1);

        public final int value;

        private AvmWorkMode(int v1) {
            this.value = v1;
        }

        public static AvmWorkMode valueOf(int v) {
            if(v == AvmWorkMode.INVALID.value) {
                return AvmWorkMode.INVALID;
            }
            if(v == AvmWorkMode.UPGRADING.value) {
                return AvmWorkMode.UPGRADING;
            }
            if(v == AvmWorkMode.DEBUG.value) {
                return AvmWorkMode.DEBUG;
            }
            return v == AvmWorkMode.NORMAL.value ? AvmWorkMode.NORMAL : AvmWorkMode.__UNKNOWN__;
        }
    }

    public static enum Language {
        CHINESE(0),
        ENGLISH(1),
        ARABIC_RESERVED(2),
        RUSSIAN_RESERVED(3),
        CHINESE_PLUSENGLISH(4),
        SPANISH(5),
        INDONESIAN(6),
        PORTUGUESE(7),
        CHINESE_TRADITIONAL(8),
        VIETNAMENSE(9),
        THAI(10),
        MALAY(11),
        FRENCH(12),
        ITALIAN(13),
        __UNKNOWN__(-1);

        public final int value;

        private Language(int v1) {
            this.value = v1;
        }

        public static Language valueOf(int v) {
            if(v == Language.CHINESE.value) {
                return Language.CHINESE;
            }
            if(v == Language.ENGLISH.value) {
                return Language.ENGLISH;
            }
            if(v == Language.ARABIC_RESERVED.value) {
                return Language.ARABIC_RESERVED;
            }
            if(v == Language.RUSSIAN_RESERVED.value) {
                return Language.RUSSIAN_RESERVED;
            }
            if(v == Language.CHINESE_PLUSENGLISH.value) {
                return Language.CHINESE_PLUSENGLISH;
            }
            if(v == Language.SPANISH.value) {
                return Language.SPANISH;
            }
            if(v == Language.INDONESIAN.value) {
                return Language.INDONESIAN;
            }
            if(v == Language.PORTUGUESE.value) {
                return Language.PORTUGUESE;
            }
            if(v == Language.CHINESE_TRADITIONAL.value) {
                return Language.CHINESE_TRADITIONAL;
            }
            if(v == Language.VIETNAMENSE.value) {
                return Language.VIETNAMENSE;
            }
            if(v == Language.THAI.value) {
                return Language.THAI;
            }
            if(v == Language.MALAY.value) {
                return Language.MALAY;
            }
            if(v == Language.FRENCH.value) {
                return Language.FRENCH;
            }
            return v == Language.ITALIAN.value ? Language.ITALIAN : Language.__UNKNOWN__;
        }
    }

}

