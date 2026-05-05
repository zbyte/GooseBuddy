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

        private AvmCalibrationState(int value) {
            this.value = value;
        }

        public static AvmCalibrationState valueOf(int value) {
            if(value == AvmCalibrationState.NONE.value) {
                return AvmCalibrationState.NONE;
            }
            if(value == AvmCalibrationState.CLAIBRATING.value) {
                return AvmCalibrationState.CLAIBRATING;
            }
            if(value == AvmCalibrationState.SUCCESS.value) {
                return AvmCalibrationState.SUCCESS;
            }
            if(value == AvmCalibrationState.FAILURE.value) {
                return AvmCalibrationState.FAILURE;
            }
            return value == AvmCalibrationState.PARTIALLY.value ? AvmCalibrationState.PARTIALLY : AvmCalibrationState.__UNKNOWN__;
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

        private AvmDisplayState(int value) {
            this.value = value;
        }

        public static AvmDisplayState valueOf(int value) {
            if(value == AvmDisplayState.OFF.value) {
                return AvmDisplayState.OFF;
            }
            return value == AvmDisplayState.FULL_SCREEN.value ? AvmDisplayState.FULL_SCREEN : AvmDisplayState.__UNKNOWN__;
        }
    }

    public static enum AvmFullScreenSwtich {
        DISABLE(0),
        ENABLE(1),
        __UNKNOWN__(-1);

        public final int value;

        private AvmFullScreenSwtich(int value) {
            this.value = value;
        }

        public static AvmFullScreenSwtich valueOf(int value) {
            if(value == AvmFullScreenSwtich.DISABLE.value) {
                return AvmFullScreenSwtich.DISABLE;
            }
            return value == AvmFullScreenSwtich.ENABLE.value ? AvmFullScreenSwtich.ENABLE : AvmFullScreenSwtich.__UNKNOWN__;
        }
    }

    public static enum AvmHeartState {
        FAULT(0),
        NORMAL(1),
        __UNKNOWN__(-1);

        public final int value;

        private AvmHeartState(int value) {
            this.value = value;
        }

        public static AvmHeartState valueOf(int value) {
            if(value == AvmHeartState.FAULT.value) {
                return AvmHeartState.FAULT;
            }
            return value == AvmHeartState.NORMAL.value ? AvmHeartState.NORMAL : AvmHeartState.__UNKNOWN__;
        }
    }

    public static enum AvmWorkMode {
        INVALID(0),
        UPGRADING(1),
        DEBUG(1),
        NORMAL(1),
        __UNKNOWN__(-1);

        public final int value;

        private AvmWorkMode(int value) {
            this.value = value;
        }

        public static AvmWorkMode valueOf(int value) {
            if(value == AvmWorkMode.INVALID.value) {
                return AvmWorkMode.INVALID;
            }
            if(value == AvmWorkMode.UPGRADING.value) {
                return AvmWorkMode.UPGRADING;
            }
            if(value == AvmWorkMode.DEBUG.value) {
                return AvmWorkMode.DEBUG;
            }
            return value == AvmWorkMode.NORMAL.value ? AvmWorkMode.NORMAL : AvmWorkMode.__UNKNOWN__;
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

        private Language(int value) {
            this.value = value;
        }

        public static Language valueOf(int value) {
            if(value == Language.CHINESE.value) {
                return Language.CHINESE;
            }
            if(value == Language.ENGLISH.value) {
                return Language.ENGLISH;
            }
            if(value == Language.ARABIC_RESERVED.value) {
                return Language.ARABIC_RESERVED;
            }
            if(value == Language.RUSSIAN_RESERVED.value) {
                return Language.RUSSIAN_RESERVED;
            }
            if(value == Language.CHINESE_PLUSENGLISH.value) {
                return Language.CHINESE_PLUSENGLISH;
            }
            if(value == Language.SPANISH.value) {
                return Language.SPANISH;
            }
            if(value == Language.INDONESIAN.value) {
                return Language.INDONESIAN;
            }
            if(value == Language.PORTUGUESE.value) {
                return Language.PORTUGUESE;
            }
            if(value == Language.CHINESE_TRADITIONAL.value) {
                return Language.CHINESE_TRADITIONAL;
            }
            if(value == Language.VIETNAMENSE.value) {
                return Language.VIETNAMENSE;
            }
            if(value == Language.THAI.value) {
                return Language.THAI;
            }
            if(value == Language.MALAY.value) {
                return Language.MALAY;
            }
            if(value == Language.FRENCH.value) {
                return Language.FRENCH;
            }
            return value == Language.ITALIAN.value ? Language.ITALIAN : Language.__UNKNOWN__;
        }
    }

}

