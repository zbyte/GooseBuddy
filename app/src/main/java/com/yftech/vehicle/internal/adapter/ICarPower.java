package com.yftech.vehicle.internal.adapter;

public interface ICarPower extends IBaseCmd {
    public static enum PowerMode {
        OFF(0),
        ACC(1),
        ON(2),
        CRANK(3),
        __UNKNOWN__(-1);

        public final int value;

        private PowerMode(int value) {
            this.value = value;
        }

        public static PowerMode valueOf(int value) {
            if(value == PowerMode.OFF.value) {
                return PowerMode.OFF;
            }
            if(value == PowerMode.ACC.value) {
                return PowerMode.ACC;
            }
            if(value == PowerMode.ON.value) {
                return PowerMode.ON;
            }
            return value == PowerMode.CRANK.value ? PowerMode.CRANK : PowerMode.__UNKNOWN__;
        }
    }

    public static enum PowerState {
        STANDBY(1),
        SYSTEMON(2),
        SLEEP(3),
        VOLFAULTSTBY(4),
        TEST(5),
        TEN_MIN(6),
        PRE_SLEEP(7),
        __UNKNOWN__(-1);

        public final int value;

        private PowerState(int value) {
            this.value = value;
        }

        public static PowerState valueOf(int value) {
            if(value == PowerState.STANDBY.value) {
                return PowerState.STANDBY;
            }
            if(value == PowerState.SYSTEMON.value) {
                return PowerState.SYSTEMON;
            }
            if(value == PowerState.SLEEP.value) {
                return PowerState.SLEEP;
            }
            if(value == PowerState.VOLFAULTSTBY.value) {
                return PowerState.VOLFAULTSTBY;
            }
            if(value == PowerState.TEST.value) {
                return PowerState.TEST;
            }
            if(value == PowerState.TEN_MIN.value) {
                return PowerState.TEN_MIN;
            }
            return value == PowerState.PRE_SLEEP.value ? PowerState.PRE_SLEEP : PowerState.__UNKNOWN__;
        }
    }

}

