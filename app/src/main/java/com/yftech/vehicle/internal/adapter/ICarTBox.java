package com.yftech.vehicle.internal.adapter;

public interface ICarTBox extends IBaseApi {
    public static enum MuteRadioOrder {
        NO_MUTE_RADIO_ORDER(0),
        MUTE_RADIO_ORDER(1),
        __UNKNOWN__(-1);

        public final int value;

        private MuteRadioOrder(int v1) {
            this.value = v1;
        }

        public static MuteRadioOrder valueOf(int v) {
            if(v == MuteRadioOrder.NO_MUTE_RADIO_ORDER.value) {
                return MuteRadioOrder.NO_MUTE_RADIO_ORDER;
            }
            return v == MuteRadioOrder.MUTE_RADIO_ORDER.value ? MuteRadioOrder.MUTE_RADIO_ORDER : MuteRadioOrder.__UNKNOWN__;
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

        private PhoneCallState(int v1) {
            this.value = v1;
        }

        public static PhoneCallState valueOf(int v) {
            if(v == PhoneCallState.NOT_ACTIVE.value) {
                return PhoneCallState.NOT_ACTIVE;
            }
            if(v == PhoneCallState.INCOMING_CALL.value) {
                return PhoneCallState.INCOMING_CALL;
            }
            if(v == PhoneCallState.CONNECTING.value) {
                return PhoneCallState.CONNECTING;
            }
            if(v == PhoneCallState.ANSWER.value) {
                return PhoneCallState.ANSWER;
            }
            if(v == PhoneCallState.ON_THE_PHONE.value) {
                return PhoneCallState.ON_THE_PHONE;
            }
            if(v == PhoneCallState.HANG_UP.value) {
                return PhoneCallState.HANG_UP;
            }
            return v == PhoneCallState.CALL_OVER.value ? PhoneCallState.CALL_OVER : PhoneCallState.__UNKNOWN__;
        }
    }

    public static enum PhoneKeyAction {
        NOT_ACTIVE(0),
        SHORT_RELEASE(1),
        LONG_RELEASE(2),
        FAILURE(3),
        __UNKNOWN__(-1);

        public final int value;

        private PhoneKeyAction(int v1) {
            this.value = v1;
        }

        public static PhoneKeyAction valueOf(int v) {
            if(v == PhoneKeyAction.NOT_ACTIVE.value) {
                return PhoneKeyAction.NOT_ACTIVE;
            }
            if(v == PhoneKeyAction.SHORT_RELEASE.value) {
                return PhoneKeyAction.SHORT_RELEASE;
            }
            if(v == PhoneKeyAction.LONG_RELEASE.value) {
                return PhoneKeyAction.LONG_RELEASE;
            }
            return v == PhoneKeyAction.FAILURE.value ? PhoneKeyAction.FAILURE : PhoneKeyAction.__UNKNOWN__;
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

        private PhoneMode(int v1) {
            this.value = v1;
        }

        public static PhoneMode valueOf(int v) {
            if(v == PhoneMode.NOT_ACTIVE.value) {
                return PhoneMode.NOT_ACTIVE;
            }
            if(v == PhoneMode.TBOX_MODE.value) {
                return PhoneMode.TBOX_MODE;
            }
            if(v == PhoneMode.BLUETOOTH_MODE.value) {
                return PhoneMode.BLUETOOTH_MODE;
            }
            if(v == PhoneMode.BCALL_MODE.value) {
                return PhoneMode.BCALL_MODE;
            }
            if(v == PhoneMode.ECALL_MODE.value) {
                return PhoneMode.ECALL_MODE;
            }
            if(v == PhoneMode.CALLBACK_MODE1.value) {
                return PhoneMode.CALLBACK_MODE1;
            }
            return v == PhoneMode.CALLBACK_MODE2.value ? PhoneMode.CALLBACK_MODE2 : PhoneMode.__UNKNOWN__;
        }
    }

    public static enum PhoneType {
        NOT_ACTIVE(0),
        BT_PHONE(1),
        E_CALL(2),
        B_CALL(3),
        __UNKNOWN__(-1);

        public final int value;

        private PhoneType(int v1) {
            this.value = v1;
        }

        public static PhoneType valueOf(int v) {
            if(v == PhoneType.NOT_ACTIVE.value) {
                return PhoneType.NOT_ACTIVE;
            }
            if(v == PhoneType.BT_PHONE.value) {
                return PhoneType.BT_PHONE;
            }
            if(v == PhoneType.E_CALL.value) {
                return PhoneType.E_CALL;
            }
            return v == PhoneType.B_CALL.value ? PhoneType.B_CALL : PhoneType.__UNKNOWN__;
        }
    }

    public static final int PHONE_CALL_STATE = 329;
    public static final int PHONE_KEY_ACCEPT_SETTING = 326;
    public static final int PHONE_KEY_CANCEL_SETTING = 327;
    public static final int PHONE_MODE = 328;
    public static final int PHONE_TYPE_SETTING = 0x202;
    public static final int TCU_MUTE_RADIO_ORDER = 190;

}

