package com.yftech.vehicle.internal.adapter;

public interface IBaseApi {
    public static enum EnableState {
        DISABLED(0),
        ENABLED(1),
        __UNKNOWN__(-1);

        public final int value;

        private EnableState(int value) {
            this.value = value;
        }

        public static EnableState valueOf(int value) {
            if(value == EnableState.DISABLED.value) {
                return EnableState.DISABLED;
            }
            return value == EnableState.ENABLED.value ? EnableState.ENABLED : EnableState.__UNKNOWN__;
        }
    }

    public static enum EnableStateOp {
        DISABLED(1),
        ENABLED(0),
        __UNKNOWN__(-1);

        public final int value;

        private EnableStateOp(int value) {
            this.value = value;
        }

        public static EnableStateOp valueOf(int value) {
            if(value == EnableStateOp.DISABLED.value) {
                return EnableStateOp.DISABLED;
            }
            return value == EnableStateOp.ENABLED.value ? EnableStateOp.ENABLED : EnableStateOp.__UNKNOWN__;
        }
    }

    public static enum SwitchState {
        TURN_ON(2),
        TURN_OFF(1),
        __UNKNOWN__(-1);

        public final int value;

        private SwitchState(int value) {
            this.value = value;
        }

        public static SwitchState valueOf(int value) {
            if(value == SwitchState.TURN_ON.value) {
                return SwitchState.TURN_ON;
            }
            return value == SwitchState.TURN_OFF.value ? SwitchState.TURN_OFF : SwitchState.__UNKNOWN__;
        }
    }

    public static enum SwitchStateOp {
        TURN_ON(1),
        TURN_OFF(2),
        __UNKNOWN__(-1);

        public final int value;

        private SwitchStateOp(int value) {
            this.value = value;
        }

        public static SwitchStateOp valueOf(int value) {
            if(value == SwitchStateOp.TURN_ON.value) {
                return SwitchStateOp.TURN_ON;
            }
            return value == SwitchStateOp.TURN_OFF.value ? SwitchStateOp.TURN_OFF : SwitchStateOp.__UNKNOWN__;
        }
    }

    public static final byte BUTTON_ACTION_PRESS = 1;
    public static final byte BUTTON_ACTION_RELEASE = 0;
    public static final byte STATE_DISABLED = 0;
    public static final byte STATE_ENABLED = 1;
    public static final byte SWITCH_TURN_OFF = 1;
    public static final byte SWITCH_TURN_ON = 2;

}

