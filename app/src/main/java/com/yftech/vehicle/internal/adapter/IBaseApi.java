package com.yftech.vehicle.internal.adapter;

public interface IBaseApi {
    public static enum EnableState {
        DISABLED(0),
        ENABLED(1),
        __UNKNOWN__(-1);

        public final int value;

        private EnableState(int v1) {
            this.value = v1;
        }

        public static EnableState valueOf(int v) {
            if(v == EnableState.DISABLED.value) {
                return EnableState.DISABLED;
            }
            return v == EnableState.ENABLED.value ? EnableState.ENABLED : EnableState.__UNKNOWN__;
        }
    }

    public static enum EnableStateOp {
        DISABLED(1),
        ENABLED(0),
        __UNKNOWN__(-1);

        public final int value;

        private EnableStateOp(int v1) {
            this.value = v1;
        }

        public static EnableStateOp valueOf(int v) {
            if(v == EnableStateOp.DISABLED.value) {
                return EnableStateOp.DISABLED;
            }
            return v == EnableStateOp.ENABLED.value ? EnableStateOp.ENABLED : EnableStateOp.__UNKNOWN__;
        }
    }

    public static enum SwitchState {
        TURN_ON(2),
        TURN_OFF(1),
        __UNKNOWN__(-1);

        public final int value;

        private SwitchState(int v1) {
            this.value = v1;
        }

        public static SwitchState valueOf(int v) {
            if(v == SwitchState.TURN_ON.value) {
                return SwitchState.TURN_ON;
            }
            return v == SwitchState.TURN_OFF.value ? SwitchState.TURN_OFF : SwitchState.__UNKNOWN__;
        }
    }

    public static enum SwitchStateOp {
        TURN_ON(1),
        TURN_OFF(2),
        __UNKNOWN__(-1);

        public final int value;

        private SwitchStateOp(int v1) {
            this.value = v1;
        }

        public static SwitchStateOp valueOf(int v) {
            if(v == SwitchStateOp.TURN_ON.value) {
                return SwitchStateOp.TURN_ON;
            }
            return v == SwitchStateOp.TURN_OFF.value ? SwitchStateOp.TURN_OFF : SwitchStateOp.__UNKNOWN__;
        }
    }

    public static final byte BUTTON_ACTION_PRESS = 1;
    public static final byte BUTTON_ACTION_RELEASE = 0;
    public static final byte STATE_DISABLED = 0;
    public static final byte STATE_ENABLED = 1;
    public static final byte SWITCH_TURN_OFF = 1;
    public static final byte SWITCH_TURN_ON = 2;

}

