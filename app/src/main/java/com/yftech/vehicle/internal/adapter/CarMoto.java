package com.yftech.vehicle.internal.adapter;

public interface CarMoto extends IBaseApi {
    public static enum Gears {
        N_GEAR(2),
        LEVEL_1(1),
        LEVEL_2(4),
        LEVEL_3(7),
        LEVEL_4(8),
        LEVEL_5(11),
        LEVEL_6(13),
        LEVEL_ERRO(15),
        __UNKNOWN__(-1);

        public final int value;

        private Gears(int value) {
            this.value = value;
        }

        public static Gears valueOf(int value) {
            if(value == Gears.N_GEAR.value) {
                return Gears.N_GEAR;
            }
            if(value == Gears.LEVEL_1.value) {
                return Gears.LEVEL_1;
            }
            if(value == Gears.LEVEL_2.value) {
                return Gears.LEVEL_2;
            }
            if(value == Gears.LEVEL_3.value) {
                return Gears.LEVEL_3;
            }
            if(value == Gears.LEVEL_4.value) {
                return Gears.LEVEL_4;
            }
            if(value == Gears.LEVEL_5.value) {
                return Gears.LEVEL_5;
            }
            if(value == Gears.LEVEL_6.value) {
                return Gears.LEVEL_6;
            }
            return value == Gears.LEVEL_ERRO.value ? Gears.LEVEL_ERRO : Gears.__UNKNOWN__;
        }
    }

    public static enum HandlebarKeyHeat {
        OFF(0),
        LEVEL_1(1),
        LEVEL_2(2),
        LEVEL_3(3),
        __UNKNOWN__(-1);

        public final int value;

        private HandlebarKeyHeat(int value) {
            this.value = value;
        }

        public static HandlebarKeyHeat valueOf(int value) {
            if(value == HandlebarKeyHeat.OFF.value) {
                return HandlebarKeyHeat.OFF;
            }
            if(value == HandlebarKeyHeat.LEVEL_1.value) {
                return HandlebarKeyHeat.LEVEL_1;
            }
            if(value == HandlebarKeyHeat.LEVEL_2.value) {
                return HandlebarKeyHeat.LEVEL_2;
            }
            return value == HandlebarKeyHeat.LEVEL_3.value ? HandlebarKeyHeat.LEVEL_3 : HandlebarKeyHeat.__UNKNOWN__;
        }
    }

    public static enum KnobLeftRightKey {
        RELEASE(0),
        RIGHT_PRESS(1),
        LEFT_PRESS(2),
        __UNKNOWN__(-1);

        public final int value;

        private KnobLeftRightKey(int value) {
            this.value = value;
        }

        public static KnobLeftRightKey valueOf(int value) {
            if(value == KnobLeftRightKey.RELEASE.value) {
                return KnobLeftRightKey.RELEASE;
            }
            if(value == KnobLeftRightKey.RIGHT_PRESS.value) {
                return KnobLeftRightKey.RIGHT_PRESS;
            }
            return value == KnobLeftRightKey.LEFT_PRESS.value ? KnobLeftRightKey.LEFT_PRESS : KnobLeftRightKey.__UNKNOWN__;
        }
    }

    public static enum KnobUpDownKey {
        RELEASE(0),
        GOUP_PRESS(1),
        GODOWN_PRESS(2),
        __UNKNOWN__(-1);

        public final int value;

        private KnobUpDownKey(int value) {
            this.value = value;
        }

        public static KnobUpDownKey valueOf(int value) {
            if(value == KnobUpDownKey.RELEASE.value) {
                return KnobUpDownKey.RELEASE;
            }
            if(value == KnobUpDownKey.GOUP_PRESS.value) {
                return KnobUpDownKey.GOUP_PRESS;
            }
            return value == KnobUpDownKey.GODOWN_PRESS.value ? KnobUpDownKey.GODOWN_PRESS : KnobUpDownKey.__UNKNOWN__;
        }
    }

    public static enum MOTOIGNStatus {
        OFF(1),
        ON(2),
        __UNKNOWN__(-1);

        public final int value;

        private MOTOIGNStatus(int value) {
            this.value = value;
        }

        public static MOTOIGNStatus valueOf(int value) {
            if(value == MOTOIGNStatus.OFF.value) {
                return MOTOIGNStatus.OFF;
            }
            return value == MOTOIGNStatus.ON.value ? MOTOIGNStatus.ON : MOTOIGNStatus.__UNKNOWN__;
        }
    }

    public static enum PreviewModeKey {
        ENTER(0),
        MODE1(1),
        MODE2(2),
        MODE3(3),
        __UNKNOWN__(-1);

        public final int value;

        private PreviewModeKey(int value) {
            this.value = value;
        }

        public static PreviewModeKey valueOf(int value) {
            if(value == PreviewModeKey.ENTER.value) {
                return PreviewModeKey.ENTER;
            }
            if(value == PreviewModeKey.MODE1.value) {
                return PreviewModeKey.MODE1;
            }
            if(value == PreviewModeKey.MODE2.value) {
                return PreviewModeKey.MODE2;
            }
            return value == PreviewModeKey.MODE3.value ? PreviewModeKey.MODE3 : PreviewModeKey.__UNKNOWN__;
        }
    }

    public static enum RightModeKey {
        MODE1(1),
        MODE2(2),
        MODE3(3),
        __UNKNOWN__(-1);

        public final int value;

        private RightModeKey(int value) {
            this.value = value;
        }

        public static RightModeKey valueOf(int value) {
            if(value == RightModeKey.MODE1.value) {
                return RightModeKey.MODE1;
            }
            if(value == RightModeKey.MODE2.value) {
                return RightModeKey.MODE2;
            }
            return value == RightModeKey.MODE3.value ? RightModeKey.MODE3 : RightModeKey.__UNKNOWN__;
        }
    }

    public static enum TurnLightInfo {
        OFF(0),
        BLINK(3),
        LEFT_LIGHT(1),
        RIGHT_LIGHT(2),
        __UNKNOWN__(-1);

        public final int value;

        private TurnLightInfo(int value) {
            this.value = value;
        }

        public static TurnLightInfo valueOf(int value) {
            if(value == TurnLightInfo.OFF.value) {
                return TurnLightInfo.OFF;
            }
            if(value == TurnLightInfo.BLINK.value) {
                return TurnLightInfo.BLINK;
            }
            if(value == TurnLightInfo.LEFT_LIGHT.value) {
                return TurnLightInfo.LEFT_LIGHT;
            }
            return value == TurnLightInfo.RIGHT_LIGHT.value ? TurnLightInfo.RIGHT_LIGHT : TurnLightInfo.__UNKNOWN__;
        }
    }

    public static final int MOTO_Engine_SPEED_INFO = 636;
    public static final int MOTO_FULLLIGHT_INFO = 637;
    public static final int MOTO_GEARS_LEVEL_INFO = 640;
    public static final int MOTO_GEARS_SATUS = 629;
    public static final int MOTO_HANDLEBAR_KEY_HEAT_INFO = 628;
    public static final int MOTO_IGNITION_STATUS = 641;
    public static final int MOTO_IGN_KEY_STATUS_INFO = 634;
    public static final int MOTO_KNOB_LEFT_RIGH_KEY_INFO = 633;
    public static final int MOTO_KNOB_LSTEP_NUM_KEY_INFO = 638;
    public static final int MOTO_KNOB_UP_DOWN_KEY_INFO = 632;
    public static final int MOTO_PREVIEW_MODE_KEY_INFO = 631;
    public static final int MOTO_RIGHT_MODE_KEY_INFO = 630;
    public static final int MOTO_SPEED_INFO = 635;
    public static final int MOTO_TURN_LIGHT_INFO = 627;

}

