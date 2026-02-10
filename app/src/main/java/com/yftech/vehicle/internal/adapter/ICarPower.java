package com.yftech.vehicle.internal.adapter;

public interface ICarPower extends IBaseCmd {
    public static enum PowerMode {
        OFF(0),
        ACC(1),
        ON(2),
        CRANK(3),
        __UNKNOWN__(-1);

        public final int value;

        private PowerMode(int v1) {
            this.value = v1;
        }

        public static PowerMode valueOf(int v) {
            if(v == PowerMode.OFF.value) {
                return PowerMode.OFF;
            }
            if(v == PowerMode.ACC.value) {
                return PowerMode.ACC;
            }
            if(v == PowerMode.ON.value) {
                return PowerMode.ON;
            }
            return v == PowerMode.CRANK.value ? PowerMode.CRANK : PowerMode.__UNKNOWN__;
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

        private PowerState(int v1) {
            this.value = v1;
        }

        public static PowerState valueOf(int v) {
            if(v == PowerState.STANDBY.value) {
                return PowerState.STANDBY;
            }
            if(v == PowerState.SYSTEMON.value) {
                return PowerState.SYSTEMON;
            }
            if(v == PowerState.SLEEP.value) {
                return PowerState.SLEEP;
            }
            if(v == PowerState.VOLFAULTSTBY.value) {
                return PowerState.VOLFAULTSTBY;
            }
            if(v == PowerState.TEST.value) {
                return PowerState.TEST;
            }
            if(v == PowerState.TEN_MIN.value) {
                return PowerState.TEN_MIN;
            }
            return v == PowerState.PRE_SLEEP.value ? PowerState.PRE_SLEEP : PowerState.__UNKNOWN__;
        }
    }

}

