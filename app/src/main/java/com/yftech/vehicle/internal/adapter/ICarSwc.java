package com.yftech.vehicle.internal.adapter;

public interface ICarSwc extends IBaseApi {
    public static enum SwcHeatState {
        OFF(0),
        HEATING(1),
        PRESERVATION(2),
        __UNKNOWN__(-1);

        public final int value;

        private SwcHeatState(int v1) {
            this.value = v1;
        }

        public static SwcHeatState valueOf(int v) {
            if(v == SwcHeatState.OFF.value) {
                return SwcHeatState.OFF;
            }
            if(v == SwcHeatState.HEATING.value) {
                return SwcHeatState.HEATING;
            }
            return v == SwcHeatState.PRESERVATION.value ? SwcHeatState.PRESERVATION : SwcHeatState.__UNKNOWN__;
        }
    }

    public static final int SWC_ANGLE_STATE = 306;
    public static final int SWC_ANGLE_VD_STATE = 338;
    public static final int SWC_HEAT_STATE = 304;
    public static final int SWC_HEAT_STATE_SETTING = 305;
    public static final int SWC_HEAT_STATE_SWITCH_SWITCH = 698;
    public static final int SWC_STAR_KEY_SETTING = 284;
    public static final int SWC_STAR_KEY_VD_SETTING = 285;

}

