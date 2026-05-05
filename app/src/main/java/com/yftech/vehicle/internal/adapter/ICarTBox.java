package com.yftech.vehicle.internal.adapter;

public interface ICarTBox extends IBaseApi {
    public static enum MuteRadioOrder {
        NO_MUTE_RADIO_ORDER(0),
        MUTE_RADIO_ORDER(1),
        __UNKNOWN__(-1);

        public final int value;

        private MuteRadioOrder(int value) {
            this.value = value;
        }

        public static MuteRadioOrder valueOf(int value) {
            if(value == MuteRadioOrder.NO_MUTE_RADIO_ORDER.value) {
                return MuteRadioOrder.NO_MUTE_RADIO_ORDER;
            }
            return value == MuteRadioOrder.MUTE_RADIO_ORDER.value ? MuteRadioOrder.MUTE_RADIO_ORDER : MuteRadioOrder.__UNKNOWN__;
        }
    }

    public static enum PhoneCallState {
        NOT_ACTIVE(0),
        INCOMING_CALL(1),
        CONNECTING(2),
        ANSWER(3),
        ON_THE_PHONE(4),
        HANG_UP(5),
        CALL_OVER(6),
        __UNKNOWN__(-1);

        public final int value;

        private PhoneCallState(int value) {
            this.value = value;
        }

        public static PhoneCallState valueOf(int value) {
            if(value == PhoneCallState.NOT_ACTIVE.value) {
                return PhoneCallState.NOT_ACTIVE;
            }
            if(value == PhoneCallState.INCOMING_CALL.value) {
                return PhoneCallState.INCOMING_CALL;
            }
            if(value == PhoneCallState.CONNECTING.value) {
                return PhoneCallState.CONNECTING;
            }
            if(value == PhoneCallState.ANSWER.value) {
                return PhoneCallState.ANSWER;
            }
            if(value == PhoneCallState.ON_THE_PHONE.value) {
                return PhoneCallState.ON_THE_PHONE;
            }
            if(value == PhoneCallState.HANG_UP.value) {
                return PhoneCallState.HANG_UP;
            }
            return value == PhoneCallState.CALL_OVER.value ? PhoneCallState.CALL_OVER : PhoneCallState.__UNKNOWN__;
        }
    }

    public static enum PhoneKeyAction {
        NOT_ACTIVE(0),
        SHORT_RELEASE(1),
        LONG_RELEASE(2),
        FAILURE(3),
        __UNKNOWN__(-1);

        public final int value;

        private PhoneKeyAction(int value) {
            this.value = value;
        }

        public static PhoneKeyAction valueOf(int value) {
            if(value == PhoneKeyAction.NOT_ACTIVE.value) {
                return PhoneKeyAction.NOT_ACTIVE;
            }
            if(value == PhoneKeyAction.SHORT_RELEASE.value) {
                return PhoneKeyAction.SHORT_RELEASE;
            }
            if(value == PhoneKeyAction.LONG_RELEASE.value) {
                return PhoneKeyAction.LONG_RELEASE;
            }
            return value == PhoneKeyAction.FAILURE.value ? PhoneKeyAction.FAILURE : PhoneKeyAction.__UNKNOWN__;
        }
    }

    public static enum PhoneMode {
        NOT_ACTIVE(0),
        TBOX_MODE(1),
        BLUETOOTH_MODE(2),
        BCALL_MODE(3),
        ECALL_MODE(4),
        CALLBACK_MODE1(5),
        CALLBACK_MODE2(6),
        __UNKNOWN__(-1);

        public final int value;

        private PhoneMode(int value) {
            this.value = value;
        }

        public static PhoneMode valueOf(int value) {
            if(value == PhoneMode.NOT_ACTIVE.value) {
                return PhoneMode.NOT_ACTIVE;
            }
            if(value == PhoneMode.TBOX_MODE.value) {
                return PhoneMode.TBOX_MODE;
            }
            if(value == PhoneMode.BLUETOOTH_MODE.value) {
                return PhoneMode.BLUETOOTH_MODE;
            }
            if(value == PhoneMode.BCALL_MODE.value) {
                return PhoneMode.BCALL_MODE;
            }
            if(value == PhoneMode.ECALL_MODE.value) {
                return PhoneMode.ECALL_MODE;
            }
            if(value == PhoneMode.CALLBACK_MODE1.value) {
                return PhoneMode.CALLBACK_MODE1;
            }
            return value == PhoneMode.CALLBACK_MODE2.value ? PhoneMode.CALLBACK_MODE2 : PhoneMode.__UNKNOWN__;
        }
    }

    public static enum PhoneType {
        NOT_ACTIVE(0),
        BT_PHONE(1),
        E_CALL(2),
        B_CALL(3),
        __UNKNOWN__(-1);

        public final int value;

        private PhoneType(int value) {
            this.value = value;
        }

        public static PhoneType valueOf(int value) {
            if(value == PhoneType.NOT_ACTIVE.value) {
                return PhoneType.NOT_ACTIVE;
            }
            if(value == PhoneType.BT_PHONE.value) {
                return PhoneType.BT_PHONE;
            }
            if(value == PhoneType.E_CALL.value) {
                return PhoneType.E_CALL;
            }
            return value == PhoneType.B_CALL.value ? PhoneType.B_CALL : PhoneType.__UNKNOWN__;
        }
    }

    public static final int PHONE_CALL_STATE = 329;
    public static final int PHONE_KEY_ACCEPT_SETTING = 326;
    public static final int PHONE_KEY_CANCEL_SETTING = 327;
    public static final int PHONE_MODE = 328;
    public static final int PHONE_TYPE_SETTING = 0x202;
    public static final int TCU_MUTE_RADIO_ORDER = 190;

}

