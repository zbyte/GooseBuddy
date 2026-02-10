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

        private Gears(int v1) {
            this.value = v1;
        }

        public static Gears valueOf(int v) {
            if(v == Gears.N_GEAR.value) {
                return Gears.N_GEAR;
            }
            if(v == Gears.LEVEL_1.value) {
                return Gears.LEVEL_1;
            }
            if(v == Gears.LEVEL_2.value) {
                return Gears.LEVEL_2;
            }
            if(v == Gears.LEVEL_3.value) {
                return Gears.LEVEL_3;
            }
            if(v == Gears.LEVEL_4.value) {
                return Gears.LEVEL_4;
            }
            if(v == Gears.LEVEL_5.value) {
                return Gears.LEVEL_5;
            }
            if(v == Gears.LEVEL_6.value) {
                return Gears.LEVEL_6;
            }
            return v == Gears.LEVEL_ERRO.value ? Gears.LEVEL_ERRO : Gears.__UNKNOWN__;
        }
    }

    public static enum HandlebarKeyHeat {
        OFF(0),
        LEVEL_1(1),
        LEVEL_2(2),
        LEVEL_3(3),
        __UNKNOWN__(-1);

        public final int value;

        private HandlebarKeyHeat(int v1) {
            this.value = v1;
        }

        public static HandlebarKeyHeat valueOf(int v) {
            if(v == HandlebarKeyHeat.OFF.value) {
                return HandlebarKeyHeat.OFF;
            }
            if(v == HandlebarKeyHeat.LEVEL_1.value) {
                return HandlebarKeyHeat.LEVEL_1;
            }
            if(v == HandlebarKeyHeat.LEVEL_2.value) {
                return HandlebarKeyHeat.LEVEL_2;
            }
            return v == HandlebarKeyHeat.LEVEL_3.value ? HandlebarKeyHeat.LEVEL_3 : HandlebarKeyHeat.__UNKNOWN__;
        }
    }

    public static enum KnobLeftRightKey {
        RELEASE(0),
        RIGHT_PRESS(1),
        LEFT_PRESS(2),
        __UNKNOWN__(-1);

        public final int value;

        private KnobLeftRightKey(int v1) {
            this.value = v1;
        }

        public static KnobLeftRightKey valueOf(int v) {
            if(v == KnobLeftRightKey.RELEASE.value) {
                return KnobLeftRightKey.RELEASE;
            }
            if(v == KnobLeftRightKey.RIGHT_PRESS.value) {
                return KnobLeftRightKey.RIGHT_PRESS;
            }
            return v == KnobLeftRightKey.LEFT_PRESS.value ? KnobLeftRightKey.LEFT_PRESS : KnobLeftRightKey.__UNKNOWN__;
        }
    }

    public static enum KnobUpDownKey {
        RELEASE(0),
        GOUP_PRESS(1),
        GODOWN_PRESS(2),
        __UNKNOWN__(-1);

        public final int value;

        private KnobUpDownKey(int v1) {
            this.value = v1;
        }

        public static KnobUpDownKey valueOf(int v) {
            if(v == KnobUpDownKey.RELEASE.value) {
                return KnobUpDownKey.RELEASE;
            }
            if(v == KnobUpDownKey.GOUP_PRESS.value) {
                return KnobUpDownKey.GOUP_PRESS;
            }
            return v == KnobUpDownKey.GODOWN_PRESS.value ? KnobUpDownKey.GODOWN_PRESS : KnobUpDownKey.__UNKNOWN__;
        }
    }

    public static enum MOTOIGNStatus {
        OFF(1),
        ON(2),
        __UNKNOWN__(-1);

        public final int value;

        private MOTOIGNStatus(int v1) {
            this.value = v1;
        }

        public static MOTOIGNStatus valueOf(int v) {
            if(v == MOTOIGNStatus.OFF.value) {
                return MOTOIGNStatus.OFF;
            }
            return v == MOTOIGNStatus.ON.value ? MOTOIGNStatus.ON : MOTOIGNStatus.__UNKNOWN__;
        }
    }

    public static enum PreviewModeKey {
        ENTER(0),
        MODE1(1),
        MODE2(2),
        MODE3(3),
        __UNKNOWN__(-1);

        public final int value;

        private PreviewModeKey(int v1) {
            this.value = v1;
        }

        public static PreviewModeKey valueOf(int v) {
            if(v == PreviewModeKey.ENTER.value) {
                return PreviewModeKey.ENTER;
            }
            if(v == PreviewModeKey.MODE1.value) {
                return PreviewModeKey.MODE1;
            }
            if(v == PreviewModeKey.MODE2.value) {
                return PreviewModeKey.MODE2;
            }
            return v == PreviewModeKey.MODE3.value ? PreviewModeKey.MODE3 : PreviewModeKey.__UNKNOWN__;
        }
    }

    public static enum RightModeKey {
        MODE1(1),
        MODE2(2),
        MODE3(3),
        __UNKNOWN__(-1);

        public final int value;

        private RightModeKey(int v1) {
            this.value = v1;
        }

        public static RightModeKey valueOf(int v) {
            if(v == RightModeKey.MODE1.value) {
                return RightModeKey.MODE1;
            }
            if(v == RightModeKey.MODE2.value) {
                return RightModeKey.MODE2;
            }
            return v == RightModeKey.MODE3.value ? RightModeKey.MODE3 : RightModeKey.__UNKNOWN__;
        }
    }

    public static enum TurnLightInfo {
        OFF(0),
        BLINK(3),
        LEFT_LIGHT(1),
        RIGHT_LIGHT(2),
        __UNKNOWN__(-1);

        public final int value;

        private TurnLightInfo(int v1) {
            this.value = v1;
        }

        public static TurnLightInfo valueOf(int v) {
            if(v == TurnLightInfo.OFF.value) {
                return TurnLightInfo.OFF;
            }
            if(v == TurnLightInfo.BLINK.value) {
                return TurnLightInfo.BLINK;
            }
            if(v == TurnLightInfo.LEFT_LIGHT.value) {
                return TurnLightInfo.LEFT_LIGHT;
            }
            return v == TurnLightInfo.RIGHT_LIGHT.value ? TurnLightInfo.RIGHT_LIGHT : TurnLightInfo.__UNKNOWN__;
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

