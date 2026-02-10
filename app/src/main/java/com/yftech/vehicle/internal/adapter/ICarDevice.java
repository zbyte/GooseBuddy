package com.yftech.vehicle.internal.adapter;

public interface ICarDevice extends IBaseApi {
    public static enum BsvFunctionCmd {
        REQ_CANCEL(15),
        REQ_ENTER(14),
        RVM_VERTICAL_PARKING_VIEW(13),
        RVM_PARALLEL_PARKING_VIEW(12),
        RVM_REAR_VIEW(11),
        BSV_VERTICAL_PARKING_VIEW(10),
        BSV_PARALLEL_PARKING_VIEW(9),
        BSV_PARKING_GUIDANCE_VIEW(8),
        BSV_RIGHT_BLIND_SPOT_VIEW(7),
        BSV_LEFT_BLIND_SPOT_VIEW(6),
        BSV_ENLARGE_REAR_VIEW(5),
        BSV_SURROUND_VIEW_AND_REAR_VIEW(4),
        BSV_ENLARGE_FRONT_VIEW(3),
        BSV_SURROUND_VIEW_AND_FRONT_VIEW(2),
        BSV_HMI_IN_TRANSITION(1),
        __UNKNOWN__(-1);

        public final int value;

        private BsvFunctionCmd(int v1) {
            this.value = v1;
        }

        public static BsvFunctionCmd valueOf(int v) {
            if(v == BsvFunctionCmd.REQ_CANCEL.value) {
                return BsvFunctionCmd.REQ_CANCEL;
            }
            if(v == BsvFunctionCmd.REQ_ENTER.value) {
                return BsvFunctionCmd.REQ_ENTER;
            }
            if(v == BsvFunctionCmd.RVM_VERTICAL_PARKING_VIEW.value) {
                return BsvFunctionCmd.RVM_VERTICAL_PARKING_VIEW;
            }
            if(v == BsvFunctionCmd.RVM_PARALLEL_PARKING_VIEW.value) {
                return BsvFunctionCmd.RVM_PARALLEL_PARKING_VIEW;
            }
            if(v == BsvFunctionCmd.RVM_REAR_VIEW.value) {
                return BsvFunctionCmd.RVM_REAR_VIEW;
            }
            if(v == BsvFunctionCmd.BSV_VERTICAL_PARKING_VIEW.value) {
                return BsvFunctionCmd.BSV_VERTICAL_PARKING_VIEW;
            }
            if(v == BsvFunctionCmd.BSV_PARALLEL_PARKING_VIEW.value) {
                return BsvFunctionCmd.BSV_PARALLEL_PARKING_VIEW;
            }
            if(v == BsvFunctionCmd.BSV_PARKING_GUIDANCE_VIEW.value) {
                return BsvFunctionCmd.BSV_PARKING_GUIDANCE_VIEW;
            }
            if(v == BsvFunctionCmd.BSV_RIGHT_BLIND_SPOT_VIEW.value) {
                return BsvFunctionCmd.BSV_RIGHT_BLIND_SPOT_VIEW;
            }
            if(v == BsvFunctionCmd.BSV_LEFT_BLIND_SPOT_VIEW.value) {
                return BsvFunctionCmd.BSV_LEFT_BLIND_SPOT_VIEW;
            }
            if(v == BsvFunctionCmd.BSV_ENLARGE_REAR_VIEW.value) {
                return BsvFunctionCmd.BSV_ENLARGE_REAR_VIEW;
            }
            if(v == BsvFunctionCmd.BSV_SURROUND_VIEW_AND_REAR_VIEW.value) {
                return BsvFunctionCmd.BSV_SURROUND_VIEW_AND_REAR_VIEW;
            }
            if(v == BsvFunctionCmd.BSV_ENLARGE_FRONT_VIEW.value) {
                return BsvFunctionCmd.BSV_ENLARGE_FRONT_VIEW;
            }
            if(v == BsvFunctionCmd.BSV_SURROUND_VIEW_AND_FRONT_VIEW.value) {
                return BsvFunctionCmd.BSV_SURROUND_VIEW_AND_FRONT_VIEW;
            }
            return v == BsvFunctionCmd.BSV_HMI_IN_TRANSITION.value ? BsvFunctionCmd.BSV_HMI_IN_TRANSITION : BsvFunctionCmd.__UNKNOWN__;
        }
    }

    public static enum PAAMode {
        APA(1),
        RPA(2),
        HAVP(3),
        PAVP(4),
        RA(5),
        CUSTOM_SLOT(6),
        PAA(7),
        APA_OFF(8),
        PAA_OFF(9),
        RA_OFF(10),
        __UNKNOWN__(-1);

        public final int value;

        private PAAMode(int v1) {
            this.value = v1;
        }

        public static PAAMode valueOf(int v) {
            if(v == PAAMode.APA.value) {
                return PAAMode.APA;
            }
            if(v == PAAMode.RPA.value) {
                return PAAMode.RPA;
            }
            if(v == PAAMode.HAVP.value) {
                return PAAMode.HAVP;
            }
            if(v == PAAMode.PAVP.value) {
                return PAAMode.PAVP;
            }
            if(v == PAAMode.RA.value) {
                return PAAMode.RA;
            }
            if(v == PAAMode.CUSTOM_SLOT.value) {
                return PAAMode.CUSTOM_SLOT;
            }
            if(v == PAAMode.PAA.value) {
                return PAAMode.PAA;
            }
            if(v == PAAMode.APA_OFF.value) {
                return PAAMode.APA_OFF;
            }
            if(v == PAAMode.PAA_OFF.value) {
                return PAAMode.PAA_OFF;
            }
            return v == PAAMode.RA_OFF.value ? PAAMode.RA_OFF : PAAMode.__UNKNOWN__;
        }
    }

    public static enum PASBackParkDisplayState {
        NONE(0),
        IMAGE_PARKING(1),
        SPACE_PARKING(2),
        __UNKNOWN__(-1);

        public final int value;

        private PASBackParkDisplayState(int v1) {
            this.value = v1;
        }

        public static PASBackParkDisplayState valueOf(int v) {
            if(v == PASBackParkDisplayState.NONE.value) {
                return PASBackParkDisplayState.NONE;
            }
            if(v == PASBackParkDisplayState.IMAGE_PARKING.value) {
                return PASBackParkDisplayState.IMAGE_PARKING;
            }
            return v == PASBackParkDisplayState.SPACE_PARKING.value ? PASBackParkDisplayState.SPACE_PARKING : PASBackParkDisplayState.__UNKNOWN__;
        }
    }

    public static enum RecorderEnterCmd {
        COMMAND(1),
        NO_COMMAND(0),
        __UNKNOWN__(-1);

        public final int value;

        private RecorderEnterCmd(int v1) {
            this.value = v1;
        }

        public static RecorderEnterCmd valueOf(int v) {
            if(v == RecorderEnterCmd.COMMAND.value) {
                return RecorderEnterCmd.COMMAND;
            }
            return v == RecorderEnterCmd.NO_COMMAND.value ? RecorderEnterCmd.NO_COMMAND : RecorderEnterCmd.__UNKNOWN__;
        }
    }

    public static enum SvmFunctionCmd {
        REQ_CANCEL(15),
        REQ_ENTER(14),
        RVM_VERTICAL_PARKING_VIEW(13),
        RVM_PARALLEL_PARKING_VIEW(12),
        RVM_REAR_VIEW(11),
        SVM_VERTICAL_PARKING_VIEW(10),
        SVM_PARALLEL_PARKING_VIEW(9),
        SVM_PARKING_GUIDANCE_VIEW(8),
        SVM_RIGHT_BLIND_SPOT_VIEW(7),
        SVM_LEFT_BLIND_SPOT_VIEW(6),
        SVM_ENLARGE_REAR_VIEW(5),
        SVM_SURROUND_VIEW_AND_REAR_VIEW(4),
        SVM_ENLARGE_FRONT_VIEW(3),
        SVM_SURROUND_VIEW_AND_FRONT_VIEW(2),
        SVM_HMI_IN_TRANSITION(1),
        __UNKNOWN__(-1);

        public final int value;

        private SvmFunctionCmd(int v1) {
            this.value = v1;
        }

        public static SvmFunctionCmd valueOf(int v) {
            if(v == SvmFunctionCmd.REQ_CANCEL.value) {
                return SvmFunctionCmd.REQ_CANCEL;
            }
            if(v == SvmFunctionCmd.REQ_ENTER.value) {
                return SvmFunctionCmd.REQ_ENTER;
            }
            if(v == SvmFunctionCmd.RVM_VERTICAL_PARKING_VIEW.value) {
                return SvmFunctionCmd.RVM_VERTICAL_PARKING_VIEW;
            }
            if(v == SvmFunctionCmd.RVM_PARALLEL_PARKING_VIEW.value) {
                return SvmFunctionCmd.RVM_PARALLEL_PARKING_VIEW;
            }
            if(v == SvmFunctionCmd.RVM_REAR_VIEW.value) {
                return SvmFunctionCmd.RVM_REAR_VIEW;
            }
            if(v == SvmFunctionCmd.SVM_VERTICAL_PARKING_VIEW.value) {
                return SvmFunctionCmd.SVM_VERTICAL_PARKING_VIEW;
            }
            if(v == SvmFunctionCmd.SVM_PARALLEL_PARKING_VIEW.value) {
                return SvmFunctionCmd.SVM_PARALLEL_PARKING_VIEW;
            }
            if(v == SvmFunctionCmd.SVM_PARKING_GUIDANCE_VIEW.value) {
                return SvmFunctionCmd.SVM_PARKING_GUIDANCE_VIEW;
            }
            if(v == SvmFunctionCmd.SVM_RIGHT_BLIND_SPOT_VIEW.value) {
                return SvmFunctionCmd.SVM_RIGHT_BLIND_SPOT_VIEW;
            }
            if(v == SvmFunctionCmd.SVM_LEFT_BLIND_SPOT_VIEW.value) {
                return SvmFunctionCmd.SVM_LEFT_BLIND_SPOT_VIEW;
            }
            if(v == SvmFunctionCmd.SVM_ENLARGE_REAR_VIEW.value) {
                return SvmFunctionCmd.SVM_ENLARGE_REAR_VIEW;
            }
            if(v == SvmFunctionCmd.SVM_SURROUND_VIEW_AND_REAR_VIEW.value) {
                return SvmFunctionCmd.SVM_SURROUND_VIEW_AND_REAR_VIEW;
            }
            if(v == SvmFunctionCmd.SVM_ENLARGE_FRONT_VIEW.value) {
                return SvmFunctionCmd.SVM_ENLARGE_FRONT_VIEW;
            }
            if(v == SvmFunctionCmd.SVM_SURROUND_VIEW_AND_FRONT_VIEW.value) {
                return SvmFunctionCmd.SVM_SURROUND_VIEW_AND_FRONT_VIEW;
            }
            return v == SvmFunctionCmd.SVM_HMI_IN_TRANSITION.value ? SvmFunctionCmd.SVM_HMI_IN_TRANSITION : SvmFunctionCmd.__UNKNOWN__;
        }
    }

    public static final int APA_BUTTON_SETTING = 0x206;
    public static final int AVM_DISPLAY_BUTTON_LIGHT_SETTING = 571;
    public static final int AVM_DISPLAY_BUTTON_STATUS = 570;
    public static final int AVM_PCS_PAS_BUTTON_PRESS = 572;
    public static final int BSV_BUTTON_SETTING = 535;
    public static final int BSV_DISPLAY_STATE = 532;
    public static final int BSV_DISPLAY_SWITCH = 530;
    public static final int BSV_FUNCTION_CMD_SETTING = 531;
    public static final int DVR_BUTTON_SETTING = 0x270;
    public static final int PAA_MODE_SETTING = 0x205;
    public static final int PAS_APA_RecInd_STATE = 703;
    public static final int PAS_APA_STATE = 704;
    public static final int PAS_APA_TIP_STATE = 702;
    public static final int PAS_BACKPARK_DISPLAY_STATE = 0x209;
    public static final int RECORDER_DISPLAY_STATE = 408;
    public static final int RECORDER_ENTER_CMD_SETTING = 410;
    public static final int RECORDER_RECORD_STATE = 409;
    public static final int SVM_BUTTON_SETTING = 308;
    public static final int SVM_FUNCTION_CMD_SETTING = 411;

}

