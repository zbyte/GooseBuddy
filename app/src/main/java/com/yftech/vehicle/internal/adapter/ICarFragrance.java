package com.yftech.vehicle.internal.adapter;

public interface ICarFragrance extends IBaseApi {
    public static enum FragranceConcentration {
        OFF(0),
        LOW(1),
        MID(2),
        HIGH(3),
        __UNKNOWN__(-1);

        public final int value;

        private FragranceConcentration(int v1) {
            this.value = v1;
        }

        public static FragranceConcentration valueOf(int v) {
            if(v == FragranceConcentration.OFF.value) {
                return FragranceConcentration.OFF;
            }
            if(v == FragranceConcentration.LOW.value) {
                return FragranceConcentration.LOW;
            }
            if(v == FragranceConcentration.MID.value) {
                return FragranceConcentration.MID;
            }
            return v == FragranceConcentration.HIGH.value ? FragranceConcentration.HIGH : FragranceConcentration.__UNKNOWN__;
        }
    }

    public static enum FragranceTaste {
        NO_COMMAND(0),
        TASTE_A(1),
        TASTE_B(2),
        TASTE_C(3),
        __UNKNOWN__(-1);

        public final int value;

        private FragranceTaste(int v1) {
            this.value = v1;
        }

        public static FragranceTaste valueOf(int v) {
            if(v == FragranceTaste.NO_COMMAND.value) {
                return FragranceTaste.NO_COMMAND;
            }
            if(v == FragranceTaste.TASTE_A.value) {
                return FragranceTaste.TASTE_A;
            }
            if(v == FragranceTaste.TASTE_B.value) {
                return FragranceTaste.TASTE_B;
            }
            return v == FragranceTaste.TASTE_C.value ? FragranceTaste.TASTE_C : FragranceTaste.__UNKNOWN__;
        }
    }

    public static enum FragranceWorkState {
        RUN(0),
        NOT_RUN(1),
        __UNKNOWN__(-1);

        public final int value;

        private FragranceWorkState(int v1) {
            this.value = v1;
        }

        public static FragranceWorkState valueOf(int v) {
            if(v == FragranceWorkState.RUN.value) {
                return FragranceWorkState.RUN;
            }
            return v == FragranceWorkState.NOT_RUN.value ? FragranceWorkState.NOT_RUN : FragranceWorkState.__UNKNOWN__;
        }
    }

    public static enum FragranceWorkWarn {
        NO_COMMAND(0),
        RATIO_NEARLY_USE_UP_WARNING(1),
        RATIO_USE_UP_WARNING(2),
        __UNKNOWN__(-1);

        public final int value;

        private FragranceWorkWarn(int v1) {
            this.value = v1;
        }

        public static FragranceWorkWarn valueOf(int v) {
            if(v == FragranceWorkWarn.NO_COMMAND.value) {
                return FragranceWorkWarn.NO_COMMAND;
            }
            if(v == FragranceWorkWarn.RATIO_NEARLY_USE_UP_WARNING.value) {
                return FragranceWorkWarn.RATIO_NEARLY_USE_UP_WARNING;
            }
            return v == FragranceWorkWarn.RATIO_USE_UP_WARNING.value ? FragranceWorkWarn.RATIO_USE_UP_WARNING : FragranceWorkWarn.__UNKNOWN__;
        }
    }

    public static final int FRAGRANCE1_WORKSTATE = 547;
    public static final int FRAGRANCE2_WORKSTATE = 548;
    public static final int FRAGRANCE3_WORKSTATE = 549;
    public static final int FRAGRANCE_CONCENTRATION = 0x21F;
    public static final int FRAGRANCE_CONCENTRATION_STATUS = 565;
    public static final int FRAGRANCE_TASTE1_FRAG = 550;
    public static final int FRAGRANCE_TASTE1_PERCENT = 0x220;
    public static final int FRAGRANCE_TASTE2_FRAG = 551;
    public static final int FRAGRANCE_TASTE2_PERCENT = 545;
    public static final int FRAGRANCE_TASTE3_FRAG = 552;
    public static final int FRAGRANCE_TASTE3_PERCENT = 546;
    public static final int FRAGRANCE_TASTE_BOX_ID = 573;
    public static final int FRAGRANCE_TASTE_STATE = 542;
    public static final int FRAGRANCE_TASTE_WORKING_BOX_ID = 574;
    public static final int FRAGRANCE_TASTE_WORKING_WARN = 673;

}

