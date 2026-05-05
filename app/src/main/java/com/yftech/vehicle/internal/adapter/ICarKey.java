package com.yftech.vehicle.internal.adapter;

public interface ICarKey extends IBaseCmd {
    public static class CarKeyEvent {
        public static final int ACTION_KNOB_BACKWARD = 4;
        public static final int ACTION_KNOB_FORWARD = 3;
        public static final int ACTION_LONG_PRESS = 2;
        public static final int ACTION_PRESS = 0;
        public static final int ACTION_RELEASED = 1;
        public static final int KEYCODE_BACK = 17;
        public static final int KEYCODE_CAN_AC_WIND_SPEED_DOWN = 65;
        public static final int KEYCODE_CAN_AC_WIND_SPEED_UP = 0x40;
        public static final int KEYCODE_CUSTOM_MULTIPLEX = 0x80;
        public static final int KEYCODE_CUSTOM_RADAR = 0x81;
        public static final int KEYCODE_DOWN = 33;
        public static final int KEYCODE_ENTER = 10;
        public static final int KEYCODE_HOME = 18;
        public static final int KEYCODE_LEFT = 34;
        public static final int KEYCODE_LEFT_DOWN = 37;
        public static final int KEYCODE_LEFT_UP = 36;
        public static final int KEYCODE_MEDIA = 21;
        public static final int KEYCODE_MENU = 16;
        public static final int KEYCODE_MODE = 5;
        public static final int KEYCODE_MUTE = 11;
        public static final int KEYCODE_NAVI = 20;
        public static final int KEYCODE_NONE = 0;
        public static final int KEYCODE_PHONE = 9;
        public static final int KEYCODE_PHONE_ACCEPT = 7;
        public static final int KEYCODE_PHONE_CANCEL = 8;
        public static final int KEYCODE_POWER = 22;
        public static final int KEYCODE_RADIO = 19;
        public static final int KEYCODE_RIGHT = 35;
        public static final int KEYCODE_RIGHT_DOWN = 39;
        public static final int KEYCODE_RIGHT_UP = 38;
        public static final int KEYCODE_SEEK_DOWN = 1;
        public static final int KEYCODE_SEEK_UP = 2;
        public static final int KEYCODE_UP = 0x20;
        public static final int KEYCODE_VOICE = 6;
        public static final int KEYCODE_VOLUME_DOWN = 4;
        public static final int KEYCODE_VOLUME_UP = 3;
        public static final int KEYCODE_WECHAT = 23;
        public final int action;
        public final int keyCode;
        public final int stepNum;

        public CarKeyEvent(int keyCode, int action, int stepNum) {
            this.action = action;
            this.keyCode = keyCode;
            this.stepNum = stepNum;
        }

        @Override
        public String toString() {
            return "CarKeyEvent{action=" + this.action + ", keyCode=" + this.keyCode + ", stepNum=" + this.stepNum + '}';
        }

        public static CarKeyEvent valueOf(int value) {
            return new CarKeyEvent(value >> 8 & 0xFF, value & 0xFF, value >> 16 & 0xFF);
        }
    }

}

