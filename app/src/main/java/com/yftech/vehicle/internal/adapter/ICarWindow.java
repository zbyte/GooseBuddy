package com.yftech.vehicle.internal.adapter;

public interface ICarWindow extends IBaseApi {
    public static enum WindowOpenPercent {
        STOP(1),
        FULLY_OPEN(2),
        FULLY_CLOSE(3),
        TEN_PERCENT_OPEN(4),
        TWENTY_PERCENT_OPEN(5),
        THIRTY_PERCENT_OPEN(6),
        FORTY_PERCENT_OPEN(7),
        FIFTY_PERCENT_OPEN(8),
        SIXTY_PERCENT_OPEN(9),
        SEVENTY_PERCENT_OPEN(10),
        EIGHTY_PERCENT_OPEN(11),
        NINETY_PERCENT_OPEN(12),
        CHANGE_OPEN(13),
        CHANGE_CLOSE(14),
        __UNKNOWN__(-1);

        public final int value;

        private WindowOpenPercent(int value) {
            this.value = value;
        }

        public static WindowOpenPercent valueOf(int value) {
            if(value == WindowOpenPercent.STOP.value) {
                return WindowOpenPercent.STOP;
            }
            if(value == WindowOpenPercent.FULLY_OPEN.value) {
                return WindowOpenPercent.FULLY_OPEN;
            }
            if(value == WindowOpenPercent.FULLY_CLOSE.value) {
                return WindowOpenPercent.FULLY_CLOSE;
            }
            if(value == WindowOpenPercent.TEN_PERCENT_OPEN.value) {
                return WindowOpenPercent.TEN_PERCENT_OPEN;
            }
            if(value == WindowOpenPercent.TWENTY_PERCENT_OPEN.value) {
                return WindowOpenPercent.TWENTY_PERCENT_OPEN;
            }
            if(value == WindowOpenPercent.THIRTY_PERCENT_OPEN.value) {
                return WindowOpenPercent.THIRTY_PERCENT_OPEN;
            }
            if(value == WindowOpenPercent.FORTY_PERCENT_OPEN.value) {
                return WindowOpenPercent.FORTY_PERCENT_OPEN;
            }
            if(value == WindowOpenPercent.FIFTY_PERCENT_OPEN.value) {
                return WindowOpenPercent.FIFTY_PERCENT_OPEN;
            }
            if(value == WindowOpenPercent.SIXTY_PERCENT_OPEN.value) {
                return WindowOpenPercent.SIXTY_PERCENT_OPEN;
            }
            if(value == WindowOpenPercent.SEVENTY_PERCENT_OPEN.value) {
                return WindowOpenPercent.SEVENTY_PERCENT_OPEN;
            }
            if(value == WindowOpenPercent.EIGHTY_PERCENT_OPEN.value) {
                return WindowOpenPercent.EIGHTY_PERCENT_OPEN;
            }
            if(value == WindowOpenPercent.NINETY_PERCENT_OPEN.value) {
                return WindowOpenPercent.NINETY_PERCENT_OPEN;
            }
            if(value == WindowOpenPercent.CHANGE_OPEN.value) {
                return WindowOpenPercent.CHANGE_OPEN;
            }
            return value == WindowOpenPercent.CHANGE_CLOSE.value ? WindowOpenPercent.CHANGE_CLOSE : WindowOpenPercent.__UNKNOWN__;
        }
    }

    public static enum WindowOperationState {
        STOPED(0),
        CLOSING(1),
        OPENING(2),
        ANTIPINCH_REVERSING(3),
        __UNKNOWN__(-1);

        public final int value;

        private WindowOperationState(int value) {
            this.value = value;
        }

        public static WindowOperationState valueOf(int value) {
            if(value == WindowOperationState.STOPED.value) {
                return WindowOperationState.STOPED;
            }
            if(value == WindowOperationState.CLOSING.value) {
                return WindowOperationState.CLOSING;
            }
            if(value == WindowOperationState.OPENING.value) {
                return WindowOperationState.OPENING;
            }
            return value == WindowOperationState.ANTIPINCH_REVERSING.value ? WindowOperationState.ANTIPINCH_REVERSING : WindowOperationState.__UNKNOWN__;
        }
    }

    public static enum WindowRoofOpenOpertion {
        FULLY_CLOSED(0),
        SLIDE_OPEN(1),
        TILT_UP(2),
        OPENING(3),
        CLOSING(4),
        REVERSING(5),
        POSITION_NOT_TRUSTED(6),
        FULLY_OPENED(7),
        COMFORT_POSITION(8),
        EXPANDED_SLIDE_OPEN(9),
        __UNKNOWN__(-1);

        public final int value;

        private WindowRoofOpenOpertion(int value) {
            this.value = value;
        }

        public static WindowRoofOpenOpertion valueOf(int value) {
            if(value == WindowRoofOpenOpertion.FULLY_CLOSED.value) {
                return WindowRoofOpenOpertion.FULLY_CLOSED;
            }
            if(value == WindowRoofOpenOpertion.SLIDE_OPEN.value) {
                return WindowRoofOpenOpertion.SLIDE_OPEN;
            }
            if(value == WindowRoofOpenOpertion.TILT_UP.value) {
                return WindowRoofOpenOpertion.TILT_UP;
            }
            if(value == WindowRoofOpenOpertion.OPENING.value) {
                return WindowRoofOpenOpertion.OPENING;
            }
            if(value == WindowRoofOpenOpertion.CLOSING.value) {
                return WindowRoofOpenOpertion.CLOSING;
            }
            if(value == WindowRoofOpenOpertion.REVERSING.value) {
                return WindowRoofOpenOpertion.REVERSING;
            }
            if(value == WindowRoofOpenOpertion.POSITION_NOT_TRUSTED.value) {
                return WindowRoofOpenOpertion.POSITION_NOT_TRUSTED;
            }
            if(value == WindowRoofOpenOpertion.FULLY_OPENED.value) {
                return WindowRoofOpenOpertion.FULLY_OPENED;
            }
            if(value == WindowRoofOpenOpertion.COMFORT_POSITION.value) {
                return WindowRoofOpenOpertion.COMFORT_POSITION;
            }
            return value == WindowRoofOpenOpertion.EXPANDED_SLIDE_OPEN.value ? WindowRoofOpenOpertion.EXPANDED_SLIDE_OPEN : WindowRoofOpenOpertion.__UNKNOWN__;
        }
    }

    public static enum WindowRoofOpenState {
        STOP(1),
        FULLY_OPEN(2),
        FULLY_CLOSE(3),
        TILT_UP(4),
        SHADE_OPEN(5),
        SHADE_CLOS(6),
        TWENTY_PERCENT_OPEN(7),
        FORTY_PERCENT_OPEN(8),
        SIXTY_PERCENT_OPEN(9),
        EIGHTY_PERCENT_OPEN(10),
        ONE_HUNDRED_PERCENT_OPEN(11),
        CHANGE_OPEN(12),
        CHANGE_CLOSE(13),
        __UNKNOWN__(-1);

        public final int value;

        private WindowRoofOpenState(int value) {
            this.value = value;
        }

        public static WindowRoofOpenState valueOf(int value) {
            if(value == WindowRoofOpenState.STOP.value) {
                return WindowRoofOpenState.STOP;
            }
            if(value == WindowRoofOpenState.FULLY_OPEN.value) {
                return WindowRoofOpenState.FULLY_OPEN;
            }
            if(value == WindowRoofOpenState.FULLY_CLOSE.value) {
                return WindowRoofOpenState.FULLY_CLOSE;
            }
            if(value == WindowRoofOpenState.TILT_UP.value) {
                return WindowRoofOpenState.TILT_UP;
            }
            if(value == WindowRoofOpenState.SHADE_OPEN.value) {
                return WindowRoofOpenState.SHADE_OPEN;
            }
            if(value == WindowRoofOpenState.SHADE_CLOS.value) {
                return WindowRoofOpenState.SHADE_CLOS;
            }
            if(value == WindowRoofOpenState.TWENTY_PERCENT_OPEN.value) {
                return WindowRoofOpenState.TWENTY_PERCENT_OPEN;
            }
            if(value == WindowRoofOpenState.FORTY_PERCENT_OPEN.value) {
                return WindowRoofOpenState.FORTY_PERCENT_OPEN;
            }
            if(value == WindowRoofOpenState.SIXTY_PERCENT_OPEN.value) {
                return WindowRoofOpenState.SIXTY_PERCENT_OPEN;
            }
            if(value == WindowRoofOpenState.EIGHTY_PERCENT_OPEN.value) {
                return WindowRoofOpenState.EIGHTY_PERCENT_OPEN;
            }
            if(value == WindowRoofOpenState.ONE_HUNDRED_PERCENT_OPEN.value) {
                return WindowRoofOpenState.ONE_HUNDRED_PERCENT_OPEN;
            }
            if(value == WindowRoofOpenState.CHANGE_OPEN.value) {
                return WindowRoofOpenState.CHANGE_OPEN;
            }
            return value == WindowRoofOpenState.CHANGE_CLOSE.value ? WindowRoofOpenState.CHANGE_CLOSE : WindowRoofOpenState.__UNKNOWN__;
        }
    }

    public static enum WindowRoofShadeOpenOpertion {
        FULLY_CLOSE(0),
        SLIDE_OPEN(1),
        NO_USED(2),
        OPENING(3),
        CLOSING(4),
        REVERSING(5),
        POSITION_NOT_TRUSTED(6),
        FULLY_OPEN(7),
        __UNKNOWN__(-1);

        public final int value;

        private WindowRoofShadeOpenOpertion(int value) {
            this.value = value;
        }

        public static WindowRoofShadeOpenOpertion valueOf(int value) {
            if(value == WindowRoofShadeOpenOpertion.FULLY_CLOSE.value) {
                return WindowRoofShadeOpenOpertion.FULLY_CLOSE;
            }
            if(value == WindowRoofShadeOpenOpertion.SLIDE_OPEN.value) {
                return WindowRoofShadeOpenOpertion.SLIDE_OPEN;
            }
            if(value == WindowRoofShadeOpenOpertion.NO_USED.value) {
                return WindowRoofShadeOpenOpertion.NO_USED;
            }
            if(value == WindowRoofShadeOpenOpertion.OPENING.value) {
                return WindowRoofShadeOpenOpertion.OPENING;
            }
            if(value == WindowRoofShadeOpenOpertion.CLOSING.value) {
                return WindowRoofShadeOpenOpertion.CLOSING;
            }
            if(value == WindowRoofShadeOpenOpertion.REVERSING.value) {
                return WindowRoofShadeOpenOpertion.REVERSING;
            }
            if(value == WindowRoofShadeOpenOpertion.POSITION_NOT_TRUSTED.value) {
                return WindowRoofShadeOpenOpertion.POSITION_NOT_TRUSTED;
            }
            return value == WindowRoofShadeOpenOpertion.FULLY_OPEN.value ? WindowRoofShadeOpenOpertion.FULLY_OPEN : WindowRoofShadeOpenOpertion.__UNKNOWN__;
        }
    }

    public static enum WindowRoofShadeOpenState {
        ROOF_FULLY_CLOSE(101),
        ROOF_TILT_UP(102),
        ROOF_COMFORT_POSITION(103),
        ROOF_FULLY_OPEN(104),
        SHADE_CLOSE(105),
        SHADE_OPEN(106),
        CHANGE_OPEN_TWENTY_PERCENT(107),
        CHANGE_CLOSE_TWENTY_PERCENT(108),
        STOP(109),
        __UNKNOWN__(-1);

        public final int value;

        private WindowRoofShadeOpenState(int value) {
            this.value = value;
        }

        public static WindowRoofShadeOpenState valueOf(int value) {
            if(value == WindowRoofShadeOpenState.ROOF_FULLY_CLOSE.value) {
                return WindowRoofShadeOpenState.ROOF_FULLY_CLOSE;
            }
            if(value == WindowRoofShadeOpenState.ROOF_TILT_UP.value) {
                return WindowRoofShadeOpenState.ROOF_TILT_UP;
            }
            if(value == WindowRoofShadeOpenState.ROOF_COMFORT_POSITION.value) {
                return WindowRoofShadeOpenState.ROOF_COMFORT_POSITION;
            }
            if(value == WindowRoofShadeOpenState.ROOF_FULLY_OPEN.value) {
                return WindowRoofShadeOpenState.ROOF_FULLY_OPEN;
            }
            if(value == WindowRoofShadeOpenState.SHADE_CLOSE.value) {
                return WindowRoofShadeOpenState.SHADE_CLOSE;
            }
            if(value == WindowRoofShadeOpenState.SHADE_OPEN.value) {
                return WindowRoofShadeOpenState.SHADE_OPEN;
            }
            if(value == WindowRoofShadeOpenState.CHANGE_OPEN_TWENTY_PERCENT.value) {
                return WindowRoofShadeOpenState.CHANGE_OPEN_TWENTY_PERCENT;
            }
            if(value == WindowRoofShadeOpenState.CHANGE_CLOSE_TWENTY_PERCENT.value) {
                return WindowRoofShadeOpenState.CHANGE_CLOSE_TWENTY_PERCENT;
            }
            return value == WindowRoofShadeOpenState.STOP.value ? WindowRoofShadeOpenState.STOP : WindowRoofShadeOpenState.__UNKNOWN__;
        }
    }

    public static enum WindowState {
        UNDEFINED_POSITION(0),
        FULLY_CLOSED(1),
        BETWEEN(2),
        FULLY_OPENED(3),
        __UNKNOWN__(-1);

        public final int value;

        private WindowState(int value) {
            this.value = value;
        }

        public static WindowState valueOf(int value) {
            if(value == WindowState.UNDEFINED_POSITION.value) {
                return WindowState.UNDEFINED_POSITION;
            }
            if(value == WindowState.FULLY_CLOSED.value) {
                return WindowState.FULLY_CLOSED;
            }
            if(value == WindowState.BETWEEN.value) {
                return WindowState.BETWEEN;
            }
            return value == WindowState.FULLY_OPENED.value ? WindowState.FULLY_OPENED : WindowState.__UNKNOWN__;
        }
    }

    public static final int SUNROOF_WINDOW_AUTO_CLOSE_SETTING = 0x3F;
    public static final int SUNROOF_WINDOW_AUTO_CLOSE_STATE = 0xA0;
    public static final int WINDOW_OPEN_PERCENT_FL = 0xA2;
    public static final int WINDOW_OPEN_PERCENT_FL_SETTING = 0x40;
    public static final int WINDOW_OPEN_PERCENT_FL_VD_SETTING = 364;
    public static final int WINDOW_OPEN_PERCENT_FR = 0xA6;
    public static final int WINDOW_OPEN_PERCENT_FR_SETTING = 65;
    public static final int WINDOW_OPEN_PERCENT_FR_VD_SETTING = 365;
    public static final int WINDOW_OPEN_PERCENT_RL = 170;
    public static final int WINDOW_OPEN_PERCENT_RL_SETTING = 66;
    public static final int WINDOW_OPEN_PERCENT_RL_VD_SETTING = 366;
    public static final int WINDOW_OPEN_PERCENT_RR = 0xAE;
    public static final int WINDOW_OPEN_PERCENT_RR_SETTING = 67;
    public static final int WINDOW_OPEN_PERCENT_RR_VD_SETTING = 0x16F;
    public static final int WINDOW_OPEN_PRECISE_PERCENT_FL = 707;
    public static final int WINDOW_OPEN_PRECISE_PERCENT_FR = 708;
    public static final int WINDOW_OPEN_PRECISE_PERCENT_RL = 709;
    public static final int WINDOW_OPEN_PRECISE_PERCENT_RR = 710;
    public static final int WINDOW_OPERATION_STATE_FL = 0xA3;
    public static final int WINDOW_OPERATION_STATE_FR = 0xA7;
    public static final int WINDOW_OPERATION_STATE_RL = 0xAB;
    public static final int WINDOW_OPERATION_STATE_RR = 0xAF;
    public static final int WINDOW_OVERHEAT_STATE_FL = 0xA4;
    public static final int WINDOW_OVERHEAT_STATE_FR = 0xA8;
    public static final int WINDOW_OVERHEAT_STATE_RL = 0xAC;
    public static final int WINDOW_OVERHEAT_STATE_RR = 0xB0;
    public static final int WINDOW_ROOF_OPEN_OPERTION = 0xF7;
    public static final int WINDOW_ROOF_OPEN_PERCENT = 0xF6;
    public static final int WINDOW_ROOF_OPEN_STATE_SETTING = 68;
    public static final int WINDOW_ROOF_SHADE_OPEN_OPERTION = 0xFA;
    public static final int WINDOW_ROOF_SHADE_OPEN_PERCENT = 0xF9;
    public static final int WINDOW_ROOF_SHADE_OPEN_PERCENT_SETTING = 0xF8;
    public static final int WINDOW_ROOF_SHADE_OPEN_STATE_SETTING = 0xF8;
    public static final int WINDOW_STATE_FL = 0xA1;
    public static final int WINDOW_STATE_FL_SETTING = 202;
    public static final int WINDOW_STATE_FR = 0xA5;
    public static final int WINDOW_STATE_FR_SETTING = 203;
    public static final int WINDOW_STATE_RL = 0xA9;
    public static final int WINDOW_STATE_RL_SETTING = 204;
    public static final int WINDOW_STATE_RR = 0xAD;
    public static final int WINDOW_STATE_RR_SETTING = 205;

}

