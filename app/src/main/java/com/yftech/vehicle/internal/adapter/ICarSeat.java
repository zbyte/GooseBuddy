package com.yftech.vehicle.internal.adapter;

public interface ICarSeat extends IBaseApi {
    public static enum AccountDelete {
        ACCOUNT_1(1),
        ACCOUNT_2(2),
        ACCOUNT_3(4),
        ACCOUNT_4(8),
        ACCOUNT_5(10),
        ACCOUNT_6(0x20),
        ACCOUNT_7(0x40),
        ACCOUNT_8(80),
        __UNKNOWN__(-1);

        public final int value;

        private AccountDelete(int value) {
            this.value = value;
        }

        public static AccountDelete valueOf(int value) {
            if(value == AccountDelete.ACCOUNT_1.value) {
                return AccountDelete.ACCOUNT_1;
            }
            if(value == AccountDelete.ACCOUNT_2.value) {
                return AccountDelete.ACCOUNT_2;
            }
            if(value == AccountDelete.ACCOUNT_3.value) {
                return AccountDelete.ACCOUNT_3;
            }
            if(value == AccountDelete.ACCOUNT_4.value) {
                return AccountDelete.ACCOUNT_4;
            }
            if(value == AccountDelete.ACCOUNT_5.value) {
                return AccountDelete.ACCOUNT_5;
            }
            if(value == AccountDelete.ACCOUNT_6.value) {
                return AccountDelete.ACCOUNT_6;
            }
            if(value == AccountDelete.ACCOUNT_7.value) {
                return AccountDelete.ACCOUNT_7;
            }
            return value == AccountDelete.ACCOUNT_8.value ? AccountDelete.ACCOUNT_8 : AccountDelete.__UNKNOWN__;
        }
    }

    public static enum CurrAccountCfg {
        DEFAULT(0),
        ACCOUNT_1(1),
        ACCOUNT_2(2),
        ACCOUNT_3(3),
        ACCOUNT_4(4),
        ACCOUNT_5(5),
        ACCOUNT_6(6),
        ACCOUNT_7(7),
        ACCOUNT_8(8),
        __UNKNOWN__(-1);

        public final int value;

        private CurrAccountCfg(int value) {
            this.value = value;
        }

        public static CurrAccountCfg valueOf(int value) {
            if(value == CurrAccountCfg.DEFAULT.value) {
                return CurrAccountCfg.DEFAULT;
            }
            if(value == CurrAccountCfg.ACCOUNT_1.value) {
                return CurrAccountCfg.ACCOUNT_1;
            }
            if(value == CurrAccountCfg.ACCOUNT_2.value) {
                return CurrAccountCfg.ACCOUNT_2;
            }
            if(value == CurrAccountCfg.ACCOUNT_3.value) {
                return CurrAccountCfg.ACCOUNT_3;
            }
            if(value == CurrAccountCfg.ACCOUNT_4.value) {
                return CurrAccountCfg.ACCOUNT_4;
            }
            if(value == CurrAccountCfg.ACCOUNT_5.value) {
                return CurrAccountCfg.ACCOUNT_5;
            }
            if(value == CurrAccountCfg.ACCOUNT_6.value) {
                return CurrAccountCfg.ACCOUNT_6;
            }
            if(value == CurrAccountCfg.ACCOUNT_7.value) {
                return CurrAccountCfg.ACCOUNT_7;
            }
            return value == CurrAccountCfg.ACCOUNT_8.value ? CurrAccountCfg.ACCOUNT_8 : CurrAccountCfg.__UNKNOWN__;
        }
    }

    public static enum CurrAccountSeat {
        DEFAULT(0),
        ACCOUNT_1(1),
        ACCOUNT_2(2),
        ACCOUNT_3(3),
        ACCOUNT_4(4),
        ACCOUNT_5(5),
        ACCOUNT_6(6),
        ACCOUNT_7(7),
        ACCOUNT_8(8),
        __UNKNOWN__(-1);

        public final int value;

        private CurrAccountSeat(int value) {
            this.value = value;
        }

        public static CurrAccountSeat valueOf(int value) {
            if(value == CurrAccountSeat.DEFAULT.value) {
                return CurrAccountSeat.DEFAULT;
            }
            if(value == CurrAccountSeat.ACCOUNT_1.value) {
                return CurrAccountSeat.ACCOUNT_1;
            }
            if(value == CurrAccountSeat.ACCOUNT_2.value) {
                return CurrAccountSeat.ACCOUNT_2;
            }
            if(value == CurrAccountSeat.ACCOUNT_3.value) {
                return CurrAccountSeat.ACCOUNT_3;
            }
            if(value == CurrAccountSeat.ACCOUNT_4.value) {
                return CurrAccountSeat.ACCOUNT_4;
            }
            if(value == CurrAccountSeat.ACCOUNT_5.value) {
                return CurrAccountSeat.ACCOUNT_5;
            }
            if(value == CurrAccountSeat.ACCOUNT_6.value) {
                return CurrAccountSeat.ACCOUNT_6;
            }
            if(value == CurrAccountSeat.ACCOUNT_7.value) {
                return CurrAccountSeat.ACCOUNT_7;
            }
            return value == CurrAccountSeat.ACCOUNT_8.value ? CurrAccountSeat.ACCOUNT_8 : CurrAccountSeat.__UNKNOWN__;
        }
    }

    public static enum CurrPepsPuid {
        DEFAULT(0),
        FOB_ID1(1),
        FOB_ID2(2),
        FOB_ID3(3),
        NFC_ID1(4),
        NFC_ID2(5),
        NFC_ID3(6),
        NFC_ID4(7),
        FINGER_PRINT1(8),
        FINGER_PRINT2(9),
        FINGER_PRINT3(10),
        FINGER_PRINT4(11),
        FINGER_PRINT5(12),
        __UNKNOWN__(-1);

        public final int value;

        private CurrPepsPuid(int value) {
            this.value = value;
        }

        public static CurrPepsPuid valueOf(int value) {
            if(value == CurrPepsPuid.DEFAULT.value) {
                return CurrPepsPuid.DEFAULT;
            }
            if(value == CurrPepsPuid.FOB_ID1.value) {
                return CurrPepsPuid.FOB_ID1;
            }
            if(value == CurrPepsPuid.FOB_ID2.value) {
                return CurrPepsPuid.FOB_ID2;
            }
            if(value == CurrPepsPuid.FOB_ID3.value) {
                return CurrPepsPuid.FOB_ID3;
            }
            if(value == CurrPepsPuid.NFC_ID1.value) {
                return CurrPepsPuid.NFC_ID1;
            }
            if(value == CurrPepsPuid.NFC_ID2.value) {
                return CurrPepsPuid.NFC_ID2;
            }
            if(value == CurrPepsPuid.NFC_ID3.value) {
                return CurrPepsPuid.NFC_ID3;
            }
            if(value == CurrPepsPuid.NFC_ID4.value) {
                return CurrPepsPuid.NFC_ID4;
            }
            if(value == CurrPepsPuid.FINGER_PRINT1.value) {
                return CurrPepsPuid.FINGER_PRINT1;
            }
            if(value == CurrPepsPuid.FINGER_PRINT2.value) {
                return CurrPepsPuid.FINGER_PRINT2;
            }
            if(value == CurrPepsPuid.FINGER_PRINT3.value) {
                return CurrPepsPuid.FINGER_PRINT3;
            }
            if(value == CurrPepsPuid.FINGER_PRINT4.value) {
                return CurrPepsPuid.FINGER_PRINT4;
            }
            return value == CurrPepsPuid.FINGER_PRINT5.value ? CurrPepsPuid.FINGER_PRINT5 : CurrPepsPuid.__UNKNOWN__;
        }
    }

    public static enum DriverSeatPostionCmd {
        SAVE(1),
        RECALL(2),
        __UNKNOWN__(-1);

        public final int value;

        private DriverSeatPostionCmd(int value) {
            this.value = value;
        }

        public static DriverSeatPostionCmd valueOf(int value) {
            if(value == DriverSeatPostionCmd.SAVE.value) {
                return DriverSeatPostionCmd.SAVE;
            }
            return value == DriverSeatPostionCmd.RECALL.value ? DriverSeatPostionCmd.RECALL : DriverSeatPostionCmd.__UNKNOWN__;
        }
    }

    public static enum HeatLevel {
        LEVEL_1(1),
        LEVEL_2(2),
        LEVEL_3(3),
        ERROR(7),
        OFF(0),
        __UNKNOWN__(-1);

        public final int value;

        private HeatLevel(int value) {
            this.value = value;
        }

        public static HeatLevel valueOf(int value) {
            if(value == HeatLevel.LEVEL_1.value) {
                return HeatLevel.LEVEL_1;
            }
            if(value == HeatLevel.LEVEL_2.value) {
                return HeatLevel.LEVEL_2;
            }
            if(value == HeatLevel.LEVEL_3.value) {
                return HeatLevel.LEVEL_3;
            }
            if(value == HeatLevel.ERROR.value) {
                return HeatLevel.ERROR;
            }
            return value == HeatLevel.OFF.value ? HeatLevel.OFF : HeatLevel.__UNKNOWN__;
        }
    }

    public static enum HeatVentMode {
        VENT_MODE(1),
        HEAT_MODE(2),
        OFF(0),
        __UNKNOWN__(-1);

        public final int value;

        private HeatVentMode(int value) {
            this.value = value;
        }

        public static HeatVentMode valueOf(int value) {
            if(value == HeatVentMode.VENT_MODE.value) {
                return HeatVentMode.VENT_MODE;
            }
            if(value == HeatVentMode.HEAT_MODE.value) {
                return HeatVentMode.HEAT_MODE;
            }
            return value == HeatVentMode.OFF.value ? HeatVentMode.OFF : HeatVentMode.__UNKNOWN__;
        }
    }

    public static enum MemSysOperationReqCmd {
        NO_COMMAND(0),
        ACTIVE_POP_UP_WINDOW(1),
        __UNKNOWN__(-1);

        public final int value;

        private MemSysOperationReqCmd(int value) {
            this.value = value;
        }

        public static MemSysOperationReqCmd valueOf(int value) {
            if(value == MemSysOperationReqCmd.NO_COMMAND.value) {
                return MemSysOperationReqCmd.NO_COMMAND;
            }
            return value == MemSysOperationReqCmd.ACTIVE_POP_UP_WINDOW.value ? MemSysOperationReqCmd.ACTIVE_POP_UP_WINDOW : MemSysOperationReqCmd.__UNKNOWN__;
        }
    }

    public static enum SSWOperation {
        SLIDE_FORWARD(1),
        SLIDE_BACKWARD(2),
        CUSHION_RISE(3),
        CUSHION_DOWN(4),
        BACKREST_FORWARD(5),
        BACKREST_BACKWARD(6),
        TILT_RISE(7),
        TILT_DOWN(8),
        STEERING_WHEEL_UP(9),
        STEERING_WHEEL_DOWN(10),
        STEERING_WHEEL_OUT(11),
        STEERING_WHEEL_IN(12),
        CUSHION_FORWARD(13),
        CUSHION_BACKWARD(14),
        __UNKNOWN__(-1);

        public final int value;

        private SSWOperation(int value) {
            this.value = value;
        }

        public static SSWOperation valueOf(int value) {
            if(value == SSWOperation.SLIDE_FORWARD.value) {
                return SSWOperation.SLIDE_FORWARD;
            }
            if(value == SSWOperation.SLIDE_BACKWARD.value) {
                return SSWOperation.SLIDE_BACKWARD;
            }
            if(value == SSWOperation.CUSHION_RISE.value) {
                return SSWOperation.CUSHION_RISE;
            }
            if(value == SSWOperation.CUSHION_DOWN.value) {
                return SSWOperation.CUSHION_DOWN;
            }
            if(value == SSWOperation.BACKREST_FORWARD.value) {
                return SSWOperation.BACKREST_FORWARD;
            }
            if(value == SSWOperation.BACKREST_BACKWARD.value) {
                return SSWOperation.BACKREST_BACKWARD;
            }
            if(value == SSWOperation.TILT_RISE.value) {
                return SSWOperation.TILT_RISE;
            }
            if(value == SSWOperation.TILT_DOWN.value) {
                return SSWOperation.TILT_DOWN;
            }
            if(value == SSWOperation.STEERING_WHEEL_UP.value) {
                return SSWOperation.STEERING_WHEEL_UP;
            }
            if(value == SSWOperation.STEERING_WHEEL_DOWN.value) {
                return SSWOperation.STEERING_WHEEL_DOWN;
            }
            if(value == SSWOperation.STEERING_WHEEL_OUT.value) {
                return SSWOperation.STEERING_WHEEL_OUT;
            }
            if(value == SSWOperation.STEERING_WHEEL_IN.value) {
                return SSWOperation.STEERING_WHEEL_IN;
            }
            if(value == SSWOperation.CUSHION_FORWARD.value) {
                return SSWOperation.CUSHION_FORWARD;
            }
            return value == SSWOperation.CUSHION_BACKWARD.value ? SSWOperation.CUSHION_BACKWARD : SSWOperation.__UNKNOWN__;
        }
    }

    public static enum SeatMassageLevel {
        OFF(0),
        LEVEL_ONE(1),
        LEVEL_TW0(2),
        LEVEL_THIRD(3),
        __UNKNOWN__(-1);

        public final int value;

        private SeatMassageLevel(int value) {
            this.value = value;
        }

        public static SeatMassageLevel valueOf(int value) {
            if(value == SeatMassageLevel.OFF.value) {
                return SeatMassageLevel.OFF;
            }
            if(value == SeatMassageLevel.LEVEL_ONE.value) {
                return SeatMassageLevel.LEVEL_ONE;
            }
            if(value == SeatMassageLevel.LEVEL_TW0.value) {
                return SeatMassageLevel.LEVEL_TW0;
            }
            return value == SeatMassageLevel.LEVEL_THIRD.value ? SeatMassageLevel.LEVEL_THIRD : SeatMassageLevel.__UNKNOWN__;
        }
    }

    public static enum SeatMassageMode {
        OFF(0),
        MODE_ONE(1),
        MODE_TW0(2),
        MODE_THIRD(3),
        MODE_FOUR(4),
        MODE_FIVE(5),
        MODE_SIX(6),
        __UNKNOWN__(-1);

        public final int value;

        private SeatMassageMode(int value) {
            this.value = value;
        }

        public static SeatMassageMode valueOf(int value) {
            if(value == SeatMassageMode.OFF.value) {
                return SeatMassageMode.OFF;
            }
            if(value == SeatMassageMode.MODE_ONE.value) {
                return SeatMassageMode.MODE_ONE;
            }
            if(value == SeatMassageMode.MODE_TW0.value) {
                return SeatMassageMode.MODE_TW0;
            }
            if(value == SeatMassageMode.MODE_THIRD.value) {
                return SeatMassageMode.MODE_THIRD;
            }
            if(value == SeatMassageMode.MODE_FOUR.value) {
                return SeatMassageMode.MODE_FOUR;
            }
            if(value == SeatMassageMode.MODE_FIVE.value) {
                return SeatMassageMode.MODE_FIVE;
            }
            return value == SeatMassageMode.MODE_SIX.value ? SeatMassageMode.MODE_SIX : SeatMassageMode.__UNKNOWN__;
        }
    }

    public static enum SeatOperationState {
        NO_OPERATION(0),
        MANUAL_OPERATING(1),
        SAVE_COMPLETED(2),
        SAVE_FAILED(3),
        RECALLING(4),
        RECALL_INTERRUPTED(5),
        RECALL_COMPLETED(6),
        INITIALIZATION_COMPLETED(7),
        RECALL_STUDYING(8),
        STUDY_COMPLETED(9),
        STUDY_FAILED(10),
        __UNKNOWN__(-1);

        public final int value;

        private SeatOperationState(int value) {
            this.value = value;
        }

        public static SeatOperationState valueOf(int value) {
            if(value == SeatOperationState.NO_OPERATION.value) {
                return SeatOperationState.NO_OPERATION;
            }
            if(value == SeatOperationState.MANUAL_OPERATING.value) {
                return SeatOperationState.MANUAL_OPERATING;
            }
            if(value == SeatOperationState.SAVE_COMPLETED.value) {
                return SeatOperationState.SAVE_COMPLETED;
            }
            if(value == SeatOperationState.SAVE_FAILED.value) {
                return SeatOperationState.SAVE_FAILED;
            }
            if(value == SeatOperationState.RECALLING.value) {
                return SeatOperationState.RECALLING;
            }
            if(value == SeatOperationState.RECALL_INTERRUPTED.value) {
                return SeatOperationState.RECALL_INTERRUPTED;
            }
            if(value == SeatOperationState.RECALL_COMPLETED.value) {
                return SeatOperationState.RECALL_COMPLETED;
            }
            if(value == SeatOperationState.INITIALIZATION_COMPLETED.value) {
                return SeatOperationState.INITIALIZATION_COMPLETED;
            }
            if(value == SeatOperationState.RECALL_STUDYING.value) {
                return SeatOperationState.RECALL_STUDYING;
            }
            if(value == SeatOperationState.STUDY_COMPLETED.value) {
                return SeatOperationState.STUDY_COMPLETED;
            }
            return value == SeatOperationState.STUDY_FAILED.value ? SeatOperationState.STUDY_FAILED : SeatOperationState.__UNKNOWN__;
        }
    }

    public static enum SeatSteeringWheelFR {
        NO_COMMAND(0),
        SLIDE_FORWARD(1),
        SLIDE_BACKWARD(2),
        CUSHION_RISE(3),
        CUSHION_DOWN(4),
        BACKREST_FORWARD(5),
        BACKREST_BACKWARD(6),
        TILT_RISE(7),
        TILT_DOWN(8),
        __UNKNOWN__(-1);

        public final int value;

        private SeatSteeringWheelFR(int value) {
            this.value = value;
        }

        public static SeatSteeringWheelFR valueOf(int value) {
            if(value == SeatSteeringWheelFR.NO_COMMAND.value) {
                return SeatSteeringWheelFR.NO_COMMAND;
            }
            if(value == SeatSteeringWheelFR.SLIDE_FORWARD.value) {
                return SeatSteeringWheelFR.SLIDE_FORWARD;
            }
            if(value == SeatSteeringWheelFR.SLIDE_BACKWARD.value) {
                return SeatSteeringWheelFR.SLIDE_BACKWARD;
            }
            if(value == SeatSteeringWheelFR.CUSHION_RISE.value) {
                return SeatSteeringWheelFR.CUSHION_RISE;
            }
            if(value == SeatSteeringWheelFR.CUSHION_DOWN.value) {
                return SeatSteeringWheelFR.CUSHION_DOWN;
            }
            if(value == SeatSteeringWheelFR.BACKREST_FORWARD.value) {
                return SeatSteeringWheelFR.BACKREST_FORWARD;
            }
            if(value == SeatSteeringWheelFR.BACKREST_BACKWARD.value) {
                return SeatSteeringWheelFR.BACKREST_BACKWARD;
            }
            if(value == SeatSteeringWheelFR.TILT_RISE.value) {
                return SeatSteeringWheelFR.TILT_RISE;
            }
            return value == SeatSteeringWheelFR.TILT_DOWN.value ? SeatSteeringWheelFR.TILT_DOWN : SeatSteeringWheelFR.__UNKNOWN__;
        }
    }

    public static enum SeatSteeringWheelRear {
        NO_COMMAND(0),
        SLIDE_FORWARD(1),
        SLIDE_BACKWARD(2),
        BACKREST_FORWARD(3),
        BACKREST_BACKWARD(4),
        LIFT_UP(5),
        LIFT_DOWN(6),
        OTTOMAN1_FORWARD(7),
        OTTOMAN1_BACKWARD(8),
        OTTOMAN2_FORWARD(9),
        OTTOMAN2_BACKWARD(10),
        SHOULDER_FORWARD(11),
        SHOULDER_BACKWARD(12),
        __UNKNOWN__(-1);

        public final int value;

        private SeatSteeringWheelRear(int value) {
            this.value = value;
        }

        public static SeatSteeringWheelRear valueOf(int value) {
            if(value == SeatSteeringWheelRear.NO_COMMAND.value) {
                return SeatSteeringWheelRear.NO_COMMAND;
            }
            if(value == SeatSteeringWheelRear.SLIDE_FORWARD.value) {
                return SeatSteeringWheelRear.SLIDE_FORWARD;
            }
            if(value == SeatSteeringWheelRear.SLIDE_BACKWARD.value) {
                return SeatSteeringWheelRear.SLIDE_BACKWARD;
            }
            if(value == SeatSteeringWheelRear.BACKREST_FORWARD.value) {
                return SeatSteeringWheelRear.BACKREST_FORWARD;
            }
            if(value == SeatSteeringWheelRear.BACKREST_BACKWARD.value) {
                return SeatSteeringWheelRear.BACKREST_BACKWARD;
            }
            if(value == SeatSteeringWheelRear.LIFT_UP.value) {
                return SeatSteeringWheelRear.LIFT_UP;
            }
            if(value == SeatSteeringWheelRear.LIFT_DOWN.value) {
                return SeatSteeringWheelRear.LIFT_DOWN;
            }
            if(value == SeatSteeringWheelRear.OTTOMAN1_FORWARD.value) {
                return SeatSteeringWheelRear.OTTOMAN1_FORWARD;
            }
            if(value == SeatSteeringWheelRear.OTTOMAN1_BACKWARD.value) {
                return SeatSteeringWheelRear.OTTOMAN1_BACKWARD;
            }
            if(value == SeatSteeringWheelRear.OTTOMAN2_FORWARD.value) {
                return SeatSteeringWheelRear.OTTOMAN2_FORWARD;
            }
            if(value == SeatSteeringWheelRear.OTTOMAN2_BACKWARD.value) {
                return SeatSteeringWheelRear.OTTOMAN2_BACKWARD;
            }
            if(value == SeatSteeringWheelRear.SHOULDER_FORWARD.value) {
                return SeatSteeringWheelRear.SHOULDER_FORWARD;
            }
            return value == SeatSteeringWheelRear.SHOULDER_BACKWARD.value ? SeatSteeringWheelRear.SHOULDER_BACKWARD : SeatSteeringWheelRear.__UNKNOWN__;
        }
    }

    public static enum SteeringWheelHeatState {
        OFF(0),
        HEATING(1),
        PRESERVATION(2),
        __UNKNOWN__(-1);

        public final int value;

        private SteeringWheelHeatState(int value) {
            this.value = value;
        }

        public static SteeringWheelHeatState valueOf(int value) {
            if(value == SteeringWheelHeatState.OFF.value) {
                return SteeringWheelHeatState.OFF;
            }
            if(value == SteeringWheelHeatState.HEATING.value) {
                return SteeringWheelHeatState.HEATING;
            }
            return value == SteeringWheelHeatState.PRESERVATION.value ? SteeringWheelHeatState.PRESERVATION : SteeringWheelHeatState.__UNKNOWN__;
        }
    }

    public static enum VentLevel {
        LEVEL_1(1),
        LEVEL_2(2),
        LEVEL_3(3),
        ERROR(7),
        OFF(0),
        __UNKNOWN__(-1);

        public final int value;

        private VentLevel(int value) {
            this.value = value;
        }

        public static VentLevel valueOf(int value) {
            if(value == VentLevel.LEVEL_1.value) {
                return VentLevel.LEVEL_1;
            }
            if(value == VentLevel.LEVEL_2.value) {
                return VentLevel.LEVEL_2;
            }
            if(value == VentLevel.LEVEL_3.value) {
                return VentLevel.LEVEL_3;
            }
            if(value == VentLevel.ERROR.value) {
                return VentLevel.ERROR;
            }
            return value == VentLevel.OFF.value ? VentLevel.OFF : VentLevel.__UNKNOWN__;
        }
    }

    public static final int ACCOUNT_DELETE1_SETTING = 503;
    public static final int CHILD_LOCK_RL = 347;
    public static final int CHILD_LOCK_RL_SETTING = 348;
    public static final int CHILD_LOCK_RR = 349;
    public static final int CHILD_LOCK_RR_SETTING = 350;
    public static final int CURR_ACCOUNT_CFG_SETTING = 502;
    public static final int CURR_ACCOUNT_SEAT_POSITION_SETTING = 667;
    public static final int CURR_PEPS_PUID_STATE = 501;
    public static final int DRIVER_SAVE_RECAL_COMD_SETTING = 504;
    public static final int HEAT_LEVEL_FL = 87;
    public static final int HEAT_LEVEL_FL_SETTING = 15;
    public static final int HEAT_LEVEL_FR = 88;
    public static final int HEAT_LEVEL_FR_SETTING = 16;
    public static final int HEAT_LEVEL_RL = 89;
    public static final int HEAT_LEVEL_RL_SETTING = 17;
    public static final int HEAT_LEVEL_RR = 90;
    public static final int HEAT_LEVEL_RR_SETTING = 18;
    public static final int HEAT_VENT_AUTO_MODE_FL = 0x5F;
    public static final int HEAT_VENT_AUTO_MODE_FL_SETTING = 27;
    public static final int HEAT_VENT_AUTO_MODE_FR = 0x60;
    public static final int HEAT_VENT_AUTO_MODE_FR_SETTING = 28;
    public static final int HEAT_VENT_AUTO_MODE_RL = 97;
    public static final int HEAT_VENT_AUTO_MODE_RL_SETTING = 29;
    public static final int HEAT_VENT_AUTO_MODE_RR = 98;
    public static final int HEAT_VENT_AUTO_MODE_RR_SETTING = 30;
    public static final int HEAT_VENT_MODE_FL_SETTING = 23;
    public static final int HEAT_VENT_MODE_FR_SETTING = 24;
    public static final int HEAT_VENT_MODE_RL_SETTING = 25;
    public static final int HEAT_VENT_MODE_RR_SETTING = 26;
    public static final int MEMSYS_OPERATION_REQ_STATE = 506;
    public static final int SEAT_MASSAGE_LEVEL_FL = 686;
    public static final int SEAT_MASSAGE_LEVEL_FL_SETTING = 0x2AF;
    public static final int SEAT_MASSAGE_LEVEL_FR = 692;
    public static final int SEAT_MASSAGE_LEVEL_FR_SETTING = 693;
    public static final int SEAT_MASSAGE_LEVEL_RL = 296;
    public static final int SEAT_MASSAGE_LEVEL_RL_SETTING = 297;
    public static final int SEAT_MASSAGE_LEVEL_RR = 302;
    public static final int SEAT_MASSAGE_LEVEL_RR_SETTING = 303;
    public static final int SEAT_MASSAGE_MODE_FL = 684;
    public static final int SEAT_MASSAGE_MODE_FL_SETTING = 685;
    public static final int SEAT_MASSAGE_MODE_FR = 690;
    public static final int SEAT_MASSAGE_MODE_FR_SETTING = 691;
    public static final int SEAT_MASSAGE_MODE_RL = 294;
    public static final int SEAT_MASSAGE_MODE_RL_SETTING = 295;
    public static final int SEAT_MASSAGE_MODE_RR = 300;
    public static final int SEAT_MASSAGE_MODE_RR_SETTING = 301;
    public static final int SEAT_MASSAGE_ONOFF_FL = 682;
    public static final int SEAT_MASSAGE_ONOFF_FL_SETTING = 683;
    public static final int SEAT_MASSAGE_ONOFF_FL_SWITCH = 696;
    public static final int SEAT_MASSAGE_ONOFF_FR = 0x2B0;
    public static final int SEAT_MASSAGE_ONOFF_FR_SETTING = 689;
    public static final int SEAT_MASSAGE_ONOFF_FR_SWITCH = 695;
    public static final int SEAT_MASSAGE_ONOFF_RL = 292;
    public static final int SEAT_MASSAGE_ONOFF_RL_SETTING = 293;
    public static final int SEAT_MASSAGE_ONOFF_RL_SWITCH = 668;
    public static final int SEAT_MASSAGE_ONOFF_RR = 298;
    public static final int SEAT_MASSAGE_ONOFF_RR_SETTING = 299;
    public static final int SEAT_MASSAGE_ONOFF_RR_SWITCH = 669;
    public static final int SEAT_OPERATION_STATE = 505;
    public static final int SEAT_STEERING_WHEEL_FR_SETTING = 665;
    public static final int SEAT_STEERING_WHEEL_REAR_LEFT = 670;
    public static final int SEAT_STEERING_WHEEL_REAR_RIGHT = 0x29F;
    public static final int SEAT_STEERING_WHEEL_SETTING = 0x1F;
    public static final int VENT_LEVEL_FL = 91;
    public static final int VENT_LEVEL_FL_SETTING = 19;
    public static final int VENT_LEVEL_FR = 92;
    public static final int VENT_LEVEL_FR_SETTING = 20;
    public static final int VENT_LEVEL_RL = 93;
    public static final int VENT_LEVEL_RL_SETTING = 21;
    public static final int VENT_LEVEL_RR = 94;
    public static final int VENT_LEVEL_RR_SETTING = 22;

}

