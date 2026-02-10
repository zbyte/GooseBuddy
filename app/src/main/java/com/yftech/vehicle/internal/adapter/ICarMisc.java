package com.yftech.vehicle.internal.adapter;

public interface ICarMisc extends IBaseCmd {
    public static enum AteCarType {
        IHU12_A88_A1(0),
        IHU12_A58_B1(1),
        IHU12_A79_C1(2),
        IHU12_A79_C2(3),
        IHU12_A58G_B2(4),
        IHU12_A8E_A2(5),
        IHU12_A79G_C3C4(6),
        IHU12_A60_D1(7),
        IHU12_A60_D2(8),
        IHU12_A60_E1(9),
        IHU12_A60_E2(10),
        __UNKNOWN__(-1);

        public final int value;

        private AteCarType(int v1) {
            this.value = v1;
        }

        public static AteCarType valueOf(int v) {
            if(v == AteCarType.IHU12_A88_A1.value) {
                return AteCarType.IHU12_A88_A1;
            }
            if(v == AteCarType.IHU12_A58_B1.value) {
                return AteCarType.IHU12_A58_B1;
            }
            if(v == AteCarType.IHU12_A79_C1.value) {
                return AteCarType.IHU12_A79_C1;
            }
            if(v == AteCarType.IHU12_A79_C2.value) {
                return AteCarType.IHU12_A79_C2;
            }
            if(v == AteCarType.IHU12_A58G_B2.value) {
                return AteCarType.IHU12_A58G_B2;
            }
            if(v == AteCarType.IHU12_A8E_A2.value) {
                return AteCarType.IHU12_A8E_A2;
            }
            if(v == AteCarType.IHU12_A79G_C3C4.value) {
                return AteCarType.IHU12_A79G_C3C4;
            }
            if(v == AteCarType.IHU12_A60_D1.value) {
                return AteCarType.IHU12_A60_D1;
            }
            if(v == AteCarType.IHU12_A60_D2.value) {
                return AteCarType.IHU12_A60_D2;
            }
            if(v == AteCarType.IHU12_A60_E1.value) {
                return AteCarType.IHU12_A60_E1;
            }
            return v == AteCarType.IHU12_A60_E2.value ? AteCarType.IHU12_A60_E2 : AteCarType.__UNKNOWN__;
        }
    }

    public interface CarDtcParam {
        public static final byte DTC_INDEX_AMP_TEMP_HEIGH = 4;
        public static final byte DTC_INDEX_CAMERA_FRONT_SIGNAL_FAULT = 6;
        public static final byte DTC_INDEX_CAMERA_LEFT_SIGNAL_FAULT = 8;
        public static final byte DTC_INDEX_CAMERA_REAR_SIGNAL_FAULT = 7;
        public static final byte DTC_INDEX_CAMERA_RIGHT_LVDS_FAULT = 10;
        public static final byte DTC_INDEX_CAMERA_RIGHT_SIGNAL_FAULT = 9;
        public static final byte DTC_INDEX_FRONT_SCREEN_CONN_FAULT = 1;
        public static final byte DTC_INDEX_MAIN_BOARD_TEMP_HEIGH = 3;
        public static final byte DTC_INDEX_MAIN_BOARD_TEMP_LOW = 2;
        public static final byte DTC_INDEX_REAR_VIEW_CONN_FAULT = 0;
        public static final byte DTC_STATE_VALUE_FAULT = 0;
        public static final byte DTC_STATE_VALUE_NORMAL = 1;

    }

    public static class DeviceNode {
        public boolean GWT_ECTConn;
        public boolean WCMConn;
        public boolean apaConn;
        public boolean avmConn;
        public boolean hvAcConn;

        private DeviceNode(boolean z, boolean z1, boolean z2, boolean z3, boolean z4) {
            this.hvAcConn = z;
            this.avmConn = z1;
            this.apaConn = z2;
            this.WCMConn = z3;
            this.GWT_ECTConn = z4;
        }

        @Override
        public String toString() {
            return "DeviceNode{hvAcConn=" + this.hvAcConn + "avmConn=" + this.avmConn + "apaConn=" + this.apaConn + "WCMConn=" + this.WCMConn + "GWT_ECTConn=" + this.GWT_ECTConn + '}';
        }

        public static DeviceNode valueOf(int v) {
            boolean z = (v & 1) == 0;
            boolean z1 = (v & 2) == 0;
            boolean z2 = (v & 4) == 0;
            boolean z3 = (v & 8) == 0;
            return (v & 16) == 0 ? new DeviceNode(z, z1, z2, z3, true) : new DeviceNode(z, z1, z2, z3, false);
        }
    }

    public static enum ECallState {
        NO_MESSAGE(0),
        CALL_LAUNCH(1),
        CALL_GOING(2),
        CALL_END(4),
        FAILURE(8),
        MALFUNCTION(16),
        __UNKNOWN__(-1);

        public final int value;

        private ECallState(int v1) {
            this.value = v1;
        }

        public static ECallState valueOf(int v) {
            if(v == ECallState.NO_MESSAGE.value) {
                return ECallState.NO_MESSAGE;
            }
            if(v == ECallState.CALL_LAUNCH.value) {
                return ECallState.CALL_LAUNCH;
            }
            if(v == ECallState.CALL_GOING.value) {
                return ECallState.CALL_GOING;
            }
            if(v == ECallState.CALL_END.value) {
                return ECallState.CALL_END;
            }
            if(v == ECallState.FAILURE.value) {
                return ECallState.FAILURE;
            }
            return v == ECallState.MALFUNCTION.value ? ECallState.MALFUNCTION : ECallState.__UNKNOWN__;
        }
    }

    public static enum EngineerMode {
        START(1),
        STOP(2),
        RESULT(3),
        __UNKNOWN__(-1);

        public final int value;

        private EngineerMode(int v1) {
            this.value = v1;
        }

        public static EngineerMode valueOf(int v) {
            if(v == EngineerMode.START.value) {
                return EngineerMode.START;
            }
            if(v == EngineerMode.STOP.value) {
                return EngineerMode.STOP;
            }
            return v == EngineerMode.RESULT.value ? EngineerMode.RESULT : EngineerMode.__UNKNOWN__;
        }
    }

    public static class ErrorCodeInfo {
        public int day;
        public int dtc_index;
        public int dtc_state;
        public int hour;
        public int minute;
        public int month;
        public int motorSpeed;
        public int odoMeter;
        public int sec;
        public int vehicleSpeed;
        public int voltage;
        public int year;

        private ErrorCodeInfo(int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8, int v9, int v10, int v11) {
            this.dtc_index = v;
            this.dtc_state = v1;
            this.vehicleSpeed = v2;
            this.motorSpeed = v3;
            this.voltage = v4;
            this.odoMeter = v5;
            this.year = v6;
            this.month = v7;
            this.day = v8;
            this.hour = v9;
            this.minute = v10;
            this.sec = v11;
        }

        @Override
        public String toString() {
            return "ErrorCodeInfo{dtc_index=" + this.dtc_index + ", dtc_state=" + this.dtc_state + ", vehicleSpeed=" + this.vehicleSpeed + ", motorSpeed=" + this.motorSpeed + ", voltage=" + this.voltage + ", odoMeter=" + this.odoMeter + ", year=" + this.year + ", month=" + this.month + ", day=" + this.day + ", hour=" + this.hour + ", minute=" + this.minute + ", sec=" + this.sec + '}';
        }

        public static ErrorCodeInfo valueOf(byte[] arr_b) {
            return new ErrorCodeInfo(((int)arr_b[0]), ((int)arr_b[1]), arr_b[3] & 0xFF | arr_b[2] << 8, arr_b[5] & 0xFF | arr_b[4] << 8, arr_b[6] & 0xFF, arr_b[7] << 16 | arr_b[8] << 8 | arr_b[9], arr_b[10] & 0xFF, arr_b[11] & 0xFF, arr_b[12] & 0xFF, arr_b[13] & 0xFF, arr_b[14] & 0xFF, arr_b[15] & 0xFF);
        }
    }

    public static enum HmiMode {
        ALL_OFF(0),
        VR(1),
        PHONE(2),
        NAVI(3),
        VEHICLE_SETTING(4),
        SYSTEM_SETTING(5),
        DRIVING_RECORDER(6),
        CARPLAY(7),
        CARLIFE(8),
        __UNKNOWN__(-1);

        public final int value;

        private HmiMode(int v1) {
            this.value = v1;
        }

        public static HmiMode valueOf(int v) {
            if(v == HmiMode.ALL_OFF.value) {
                return HmiMode.ALL_OFF;
            }
            if(v == HmiMode.VR.value) {
                return HmiMode.VR;
            }
            if(v == HmiMode.PHONE.value) {
                return HmiMode.PHONE;
            }
            if(v == HmiMode.NAVI.value) {
                return HmiMode.NAVI;
            }
            if(v == HmiMode.VEHICLE_SETTING.value) {
                return HmiMode.VEHICLE_SETTING;
            }
            if(v == HmiMode.SYSTEM_SETTING.value) {
                return HmiMode.SYSTEM_SETTING;
            }
            if(v == HmiMode.DRIVING_RECORDER.value) {
                return HmiMode.DRIVING_RECORDER;
            }
            if(v == HmiMode.CARPLAY.value) {
                return HmiMode.CARPLAY;
            }
            return v == HmiMode.CARLIFE.value ? HmiMode.CARLIFE : HmiMode.__UNKNOWN__;
        }
    }

    public static class KeyTestEvent {
        public static final int ACTION_LONG_PRESS = 3;
        public static final int ACTION_LONG_RELEASED = 2;
        public static final int ACTION_PRESS = 1;
        public static final int ACTION_RELEASED = 0;
        public static final int KEYCODE_AM_FM = 2;
        public static final int KEYCODE_BACK = 15;
        public static final int KEYCODE_DISPLAY = 19;
        public static final int KEYCODE_EJECT = 1;
        public static final int KEYCODE_FM_ROLLING = 16;
        public static final int KEYCODE_MENU = 7;
        public static final int KEYCODE_MODE = 8;
        public static final int KEYCODE_MUTE = 14;
        public static final int KEYCODE_NAVI = 12;
        public static final int KEYCODE_NEXT = 3;
        public static final int KEYCODE_NONE = -1;
        public static final int KEYCODE_PHONE = 10;
        public static final int KEYCODE_POWER = 0;
        public static final int KEYCODE_PREVIOUS = 4;
        public static final int KEYCODE_RANDOM = 6;
        public static final int KEYCODE_REPEAT = 5;
        public static final int KEYCODE_RESEVE = 9;
        public static final int KEYCODE_SELECT = 17;
        public static final int KEYCODE_SET = 13;
        public static final int KEYCODE_VOLUME = 18;
        public static final int KEYCODE_VR = 11;
        public final int action;
        public final int keyCode;

        private KeyTestEvent(int v, int v1) {
            this.action = v1;
            this.keyCode = v;
        }

        public static KeyTestEvent valueOf(int v) {
            return new KeyTestEvent(v >> 8 & 0xFF, v & 0xFF);
        }
    }

    public static enum ProgramSource {
        ALL_OFF(0),
        AM(1),
        FM(2),
        USB1(3),
        USB2(4),
        CD(5),
        SD(6),
        BT(7),
        AUX(8),
        USB3(9),
        IPOD(10),
        __UNKNOWN__(-1);

        public int radioHz;
        public final int value;

        private ProgramSource(int v1) {
            this.value = v1;
        }

        public ProgramSource setRadioHz(int v) {
            this.radioHz = v;
            return this;
        }

        public static ProgramSource valueOf(byte[] arr_b) {
            int v = arr_b[0];
            int v1 = arr_b[2] & 0xFF | (arr_b[1] & 0xFF) << 8;
            if(v == ProgramSource.ALL_OFF.value) {
                return ProgramSource.ALL_OFF.setRadioHz(v1);
            }
            if(v == ProgramSource.AM.value) {
                return ProgramSource.AM.setRadioHz(v1);
            }
            if(v == ProgramSource.FM.value) {
                return ProgramSource.FM.setRadioHz(v1);
            }
            if(v == ProgramSource.USB1.value) {
                return ProgramSource.USB1.setRadioHz(v1);
            }
            if(v == ProgramSource.USB2.value) {
                return ProgramSource.USB2.setRadioHz(v1);
            }
            if(v == ProgramSource.CD.value) {
                return ProgramSource.CD.setRadioHz(v1);
            }
            if(v == ProgramSource.SD.value) {
                return ProgramSource.SD.setRadioHz(v1);
            }
            if(v == ProgramSource.BT.value) {
                return ProgramSource.BT.setRadioHz(v1);
            }
            if(v == ProgramSource.AUX.value) {
                return ProgramSource.AUX.setRadioHz(v1);
            }
            if(v == ProgramSource.USB3.value) {
                return ProgramSource.USB3.setRadioHz(v1);
            }
            return v == ProgramSource.IPOD.value ? ProgramSource.IPOD.setRadioHz(v1) : ProgramSource.__UNKNOWN__;
        }
    }

    public static enum SpeakerCmd {
        ALL_SPEAKER(0),
        ONLY_FR_SPEAKER(1),
        ONLY_FL_SPEAKER(2),
        ONLY_RR_SPEAKER(3),
        ONLY_RL_SPEAKER(4),
        STOP_SPEAKER(5),
        __UNKNOWN__(-1);

        public final int value;

        private SpeakerCmd(int v1) {
            this.value = v1;
        }

        public static SpeakerCmd valueOf(int v) {
            if(v == SpeakerCmd.ALL_SPEAKER.value) {
                return SpeakerCmd.ALL_SPEAKER;
            }
            if(v == SpeakerCmd.ONLY_FR_SPEAKER.value) {
                return SpeakerCmd.ONLY_FR_SPEAKER;
            }
            if(v == SpeakerCmd.ONLY_FL_SPEAKER.value) {
                return SpeakerCmd.ONLY_FL_SPEAKER;
            }
            if(v == SpeakerCmd.ONLY_RR_SPEAKER.value) {
                return SpeakerCmd.ONLY_RR_SPEAKER;
            }
            if(v == SpeakerCmd.ONLY_RL_SPEAKER.value) {
                return SpeakerCmd.ONLY_RL_SPEAKER;
            }
            return v == SpeakerCmd.STOP_SPEAKER.value ? SpeakerCmd.STOP_SPEAKER : SpeakerCmd.__UNKNOWN__;
        }
    }

    public static enum TftCmd {
        OPEN(0),
        CLOSE(1),
        STOP(2),
        __UNKNOWN__(-1);

        public final int value;

        private TftCmd(int v1) {
            this.value = v1;
        }

        public static TftCmd valueOf(int v) {
            if(v == TftCmd.OPEN.value) {
                return TftCmd.OPEN;
            }
            if(v == TftCmd.CLOSE.value) {
                return TftCmd.CLOSE;
            }
            return v == TftCmd.STOP.value ? TftCmd.STOP : TftCmd.__UNKNOWN__;
        }
    }

    public static enum TftColorState {
        STOP_CTL(0),
        RED(1),
        GREEN(2),
        BLUE(3),
        BLACK(4),
        WHITE(5),
        __UNKNOWN__(-1);

        public boolean isOpened;
        public final int value;

        private TftColorState(int v1) {
            this.value = v1;
        }

        public TftColorState setIsOpened(boolean z) {
            this.isOpened = z;
            return this;
        }

        public static TftColorState valueOf(int v) {
            int v1 = v >> 8 & 0xFF;
            boolean z = (v & 0xFF) == 1;
            if(v1 == TftColorState.STOP_CTL.value) {
                return TftColorState.STOP_CTL.setIsOpened(z);
            }
            if(v1 == TftColorState.RED.value) {
                return TftColorState.RED.setIsOpened(z);
            }
            if(v1 == TftColorState.GREEN.value) {
                return TftColorState.GREEN.setIsOpened(z);
            }
            if(v1 == TftColorState.BLUE.value) {
                return TftColorState.BLUE.setIsOpened(z);
            }
            if(v1 == TftColorState.BLACK.value) {
                return TftColorState.BLACK.setIsOpened(z);
            }
            return v1 == TftColorState.WHITE.value ? TftColorState.WHITE.setIsOpened(z) : TftColorState.__UNKNOWN__;
        }
    }

    public static enum TransportMode {
        TRANSPORT(1),
        NOT_TRANSPORT(2),
        FAULT(3),
        __UNKNOWN__(-1);

        public final int value;

        private TransportMode(int v1) {
            this.value = v1;
        }

        public static TransportMode valueOf(int v) {
            if(v == TransportMode.TRANSPORT.value) {
                return TransportMode.TRANSPORT;
            }
            if(v == TransportMode.NOT_TRANSPORT.value) {
                return TransportMode.NOT_TRANSPORT;
            }
            return v == TransportMode.FAULT.value ? TransportMode.FAULT : TransportMode.__UNKNOWN__;
        }
    }

}

