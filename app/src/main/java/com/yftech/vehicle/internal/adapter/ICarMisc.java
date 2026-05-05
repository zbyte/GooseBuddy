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

        private AteCarType(int value) {
            this.value = value;
        }

        public static AteCarType valueOf(int value) {
            if(value == AteCarType.IHU12_A88_A1.value) {
                return AteCarType.IHU12_A88_A1;
            }
            if(value == AteCarType.IHU12_A58_B1.value) {
                return AteCarType.IHU12_A58_B1;
            }
            if(value == AteCarType.IHU12_A79_C1.value) {
                return AteCarType.IHU12_A79_C1;
            }
            if(value == AteCarType.IHU12_A79_C2.value) {
                return AteCarType.IHU12_A79_C2;
            }
            if(value == AteCarType.IHU12_A58G_B2.value) {
                return AteCarType.IHU12_A58G_B2;
            }
            if(value == AteCarType.IHU12_A8E_A2.value) {
                return AteCarType.IHU12_A8E_A2;
            }
            if(value == AteCarType.IHU12_A79G_C3C4.value) {
                return AteCarType.IHU12_A79G_C3C4;
            }
            if(value == AteCarType.IHU12_A60_D1.value) {
                return AteCarType.IHU12_A60_D1;
            }
            if(value == AteCarType.IHU12_A60_D2.value) {
                return AteCarType.IHU12_A60_D2;
            }
            if(value == AteCarType.IHU12_A60_E1.value) {
                return AteCarType.IHU12_A60_E1;
            }
            return value == AteCarType.IHU12_A60_E2.value ? AteCarType.IHU12_A60_E2 : AteCarType.__UNKNOWN__;
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
        public boolean ESPConn;
        public boolean GWT_ECTConn;
        public boolean WCMConn;
        public boolean apaConn;
        public boolean avmConn;
        public boolean hvAcConn;

        private DeviceNode(boolean isHvAc, boolean avmConn, boolean apaConn, boolean WCMConn, boolean GWT_ECTConn, boolean ESPConn) {
            this.hvAcConn = isHvAc;
            this.avmConn = avmConn;
            this.apaConn = apaConn;
            this.WCMConn = WCMConn;
            this.GWT_ECTConn = GWT_ECTConn;
            this.ESPConn = ESPConn;
        }

        @Override
        public String toString() {
            return "DeviceNode{hvAcConn=" + this.hvAcConn + "avmConn=" + this.avmConn + "apaConn=" + this.apaConn + "WCMConn=" + this.WCMConn + "GWT_ECTConn=" + this.GWT_ECTConn + "ESPConn=" + this.ESPConn + '}';
        }

        public static DeviceNode valueOf(int value) {
            boolean isHvAc = (value & 1) == 0;
            boolean isAvm = (value & 2) == 0;
            boolean isAPA = (value & 4) == 0;
            boolean WCMConn = (value & 8) == 0;
            if((value & 16) == 0) {
                return (value & 0x20) == 0 ? new DeviceNode(isHvAc, isAvm, isAPA, WCMConn, true, true) : new DeviceNode(isHvAc, isAvm, isAPA, WCMConn, true, false);
            }
            return (value & 0x20) == 0 ? new DeviceNode(isHvAc, isAvm, isAPA, WCMConn, false, true) : new DeviceNode(isHvAc, isAvm, isAPA, WCMConn, false, false);
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

        private ECallState(int value) {
            this.value = value;
        }

        public static ECallState valueOf(int value) {
            if(value == ECallState.NO_MESSAGE.value) {
                return ECallState.NO_MESSAGE;
            }
            if(value == ECallState.CALL_LAUNCH.value) {
                return ECallState.CALL_LAUNCH;
            }
            if(value == ECallState.CALL_GOING.value) {
                return ECallState.CALL_GOING;
            }
            if(value == ECallState.CALL_END.value) {
                return ECallState.CALL_END;
            }
            if(value == ECallState.FAILURE.value) {
                return ECallState.FAILURE;
            }
            return value == ECallState.MALFUNCTION.value ? ECallState.MALFUNCTION : ECallState.__UNKNOWN__;
        }
    }

    public static enum EngineerMode {
        START(1),
        STOP(2),
        RESULT(3),
        __UNKNOWN__(-1);

        public final int value;

        private EngineerMode(int value) {
            this.value = value;
        }

        public static EngineerMode valueOf(int value) {
            if(value == EngineerMode.START.value) {
                return EngineerMode.START;
            }
            if(value == EngineerMode.STOP.value) {
                return EngineerMode.STOP;
            }
            return value == EngineerMode.RESULT.value ? EngineerMode.RESULT : EngineerMode.__UNKNOWN__;
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

        private ErrorCodeInfo(int dtc_index, int dtc_state, int vehicleSpeed, int motorSpeed, int voltage, int odoMeter, int year, int month, int day, int hour, int minute, int sec) {
            this.dtc_index = dtc_index;
            this.dtc_state = dtc_state;
            this.vehicleSpeed = vehicleSpeed;
            this.motorSpeed = motorSpeed;
            this.voltage = voltage;
            this.odoMeter = odoMeter;
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = hour;
            this.minute = minute;
            this.sec = sec;
        }

        @Override
        public String toString() {
            return "ErrorCodeInfo{dtc_index=" + this.dtc_index + ", dtc_state=" + this.dtc_state + ", vehicleSpeed=" + this.vehicleSpeed + ", motorSpeed=" + this.motorSpeed + ", voltage=" + this.voltage + ", odoMeter=" + this.odoMeter + ", year=" + this.year + ", month=" + this.month + ", day=" + this.day + ", hour=" + this.hour + ", minute=" + this.minute + ", sec=" + this.sec + '}';
        }

        public static ErrorCodeInfo valueOf(byte[] value) {
            return new ErrorCodeInfo(((int)value[0]), ((int)value[1]), value[2] << 8 | value[3] & 0xFF, value[4] << 8 | value[5] & 0xFF, value[6] & 0xFF, value[7] << 16 | value[8] << 8 | value[9], value[10] & 0xFF, value[11] & 0xFF, value[12] & 0xFF, value[13] & 0xFF, value[14] & 0xFF, value[15] & 0xFF);
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

        private HmiMode(int value) {
            this.value = value;
        }

        public static HmiMode valueOf(int value) {
            if(value == HmiMode.ALL_OFF.value) {
                return HmiMode.ALL_OFF;
            }
            if(value == HmiMode.VR.value) {
                return HmiMode.VR;
            }
            if(value == HmiMode.PHONE.value) {
                return HmiMode.PHONE;
            }
            if(value == HmiMode.NAVI.value) {
                return HmiMode.NAVI;
            }
            if(value == HmiMode.VEHICLE_SETTING.value) {
                return HmiMode.VEHICLE_SETTING;
            }
            if(value == HmiMode.SYSTEM_SETTING.value) {
                return HmiMode.SYSTEM_SETTING;
            }
            if(value == HmiMode.DRIVING_RECORDER.value) {
                return HmiMode.DRIVING_RECORDER;
            }
            if(value == HmiMode.CARPLAY.value) {
                return HmiMode.CARPLAY;
            }
            return value == HmiMode.CARLIFE.value ? HmiMode.CARLIFE : HmiMode.__UNKNOWN__;
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

        private KeyTestEvent(int keyCode, int action) {
            this.action = action;
            this.keyCode = keyCode;
        }

        public static KeyTestEvent valueOf(int value) {
            return new KeyTestEvent(value >> 8 & 0xFF, value & 0xFF);
        }
    }

    public static enum McuWorkMode {
        NORMAL(0),
        FATORY_RESET(1),
        OTA_STATE(2),
        DELAY_OFF_STATE(3),
        __UNKNOWN__(-1);

        public final int value;

        private McuWorkMode(int value) {
            this.value = value;
        }

        public static McuWorkMode valueOf(int value) {
            if(value == McuWorkMode.NORMAL.value) {
                return McuWorkMode.NORMAL;
            }
            if(value == McuWorkMode.FATORY_RESET.value) {
                return McuWorkMode.FATORY_RESET;
            }
            if(value == McuWorkMode.OTA_STATE.value) {
                return McuWorkMode.OTA_STATE;
            }
            return value == McuWorkMode.DELAY_OFF_STATE.value ? McuWorkMode.DELAY_OFF_STATE : McuWorkMode.__UNKNOWN__;
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

        private ProgramSource(int value) {
            this.value = value;
        }

        public ProgramSource setRadioHz(int radioHz) {
            this.radioHz = radioHz;
            return this;
        }

        public static ProgramSource valueOf(byte[] value) {
            int source = value[0];
            int radioHz = (value[1] & 0xFF) << 8 | value[2] & 0xFF;
            if(source == ProgramSource.ALL_OFF.value) {
                return ProgramSource.ALL_OFF.setRadioHz(radioHz);
            }
            if(source == ProgramSource.AM.value) {
                return ProgramSource.AM.setRadioHz(radioHz);
            }
            if(source == ProgramSource.FM.value) {
                return ProgramSource.FM.setRadioHz(radioHz);
            }
            if(source == ProgramSource.USB1.value) {
                return ProgramSource.USB1.setRadioHz(radioHz);
            }
            if(source == ProgramSource.USB2.value) {
                return ProgramSource.USB2.setRadioHz(radioHz);
            }
            if(source == ProgramSource.CD.value) {
                return ProgramSource.CD.setRadioHz(radioHz);
            }
            if(source == ProgramSource.SD.value) {
                return ProgramSource.SD.setRadioHz(radioHz);
            }
            if(source == ProgramSource.BT.value) {
                return ProgramSource.BT.setRadioHz(radioHz);
            }
            if(source == ProgramSource.AUX.value) {
                return ProgramSource.AUX.setRadioHz(radioHz);
            }
            if(source == ProgramSource.USB3.value) {
                return ProgramSource.USB3.setRadioHz(radioHz);
            }
            return source == ProgramSource.IPOD.value ? ProgramSource.IPOD.setRadioHz(radioHz) : ProgramSource.__UNKNOWN__;
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

        private SpeakerCmd(int value) {
            this.value = value;
        }

        public static SpeakerCmd valueOf(int value) {
            if(value == SpeakerCmd.ALL_SPEAKER.value) {
                return SpeakerCmd.ALL_SPEAKER;
            }
            if(value == SpeakerCmd.ONLY_FR_SPEAKER.value) {
                return SpeakerCmd.ONLY_FR_SPEAKER;
            }
            if(value == SpeakerCmd.ONLY_FL_SPEAKER.value) {
                return SpeakerCmd.ONLY_FL_SPEAKER;
            }
            if(value == SpeakerCmd.ONLY_RR_SPEAKER.value) {
                return SpeakerCmd.ONLY_RR_SPEAKER;
            }
            if(value == SpeakerCmd.ONLY_RL_SPEAKER.value) {
                return SpeakerCmd.ONLY_RL_SPEAKER;
            }
            return value == SpeakerCmd.STOP_SPEAKER.value ? SpeakerCmd.STOP_SPEAKER : SpeakerCmd.__UNKNOWN__;
        }
    }

    public static enum TftCmd {
        OPEN(0),
        CLOSE(1),
        STOP(2),
        __UNKNOWN__(-1);

        public final int value;

        private TftCmd(int value) {
            this.value = value;
        }

        public static TftCmd valueOf(int value) {
            if(value == TftCmd.OPEN.value) {
                return TftCmd.OPEN;
            }
            if(value == TftCmd.CLOSE.value) {
                return TftCmd.CLOSE;
            }
            return value == TftCmd.STOP.value ? TftCmd.STOP : TftCmd.__UNKNOWN__;
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

        private TftColorState(int value) {
            this.value = value;
        }

        public TftColorState setIsOpened(boolean isOpened) {
            this.isOpened = isOpened;
            return this;
        }

        public static TftColorState valueOf(int value) {
            boolean z = true;
            int color = value >> 8 & 0xFF;
            if((value & 0xFF) != 1) {
                z = false;
            }
            if(color == TftColorState.STOP_CTL.value) {
                return TftColorState.STOP_CTL.setIsOpened(z);
            }
            if(color == TftColorState.RED.value) {
                return TftColorState.RED.setIsOpened(z);
            }
            if(color == TftColorState.GREEN.value) {
                return TftColorState.GREEN.setIsOpened(z);
            }
            if(color == TftColorState.BLUE.value) {
                return TftColorState.BLUE.setIsOpened(z);
            }
            if(color == TftColorState.BLACK.value) {
                return TftColorState.BLACK.setIsOpened(z);
            }
            return color == TftColorState.WHITE.value ? TftColorState.WHITE.setIsOpened(z) : TftColorState.__UNKNOWN__;
        }
    }

    public static enum TransportMode {
        TRANSPORT(1),
        NOT_TRANSPORT(2),
        FAULT(3),
        __UNKNOWN__(-1);

        public final int value;

        private TransportMode(int value) {
            this.value = value;
        }

        public static TransportMode valueOf(int value) {
            if(value == TransportMode.TRANSPORT.value) {
                return TransportMode.TRANSPORT;
            }
            if(value == TransportMode.NOT_TRANSPORT.value) {
                return TransportMode.NOT_TRANSPORT;
            }
            return value == TransportMode.FAULT.value ? TransportMode.FAULT : TransportMode.__UNKNOWN__;
        }
    }

}

