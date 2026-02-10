package com.yftech.vehicle.internal.adapter;

public interface ICarLight extends IBaseApi {
    public static enum AtmosphereLampDriveMode {
        OFF(2),
        OPEN(1),
        __UNKNOWN__(-1);

        public final int value;

        private AtmosphereLampDriveMode(int v1) {
            this.value = v1;
        }

        public static AtmosphereLampDriveMode valueOf(int v) {
            if(v == AtmosphereLampDriveMode.OFF.value) {
                return AtmosphereLampDriveMode.OFF;
            }
            return v == AtmosphereLampDriveMode.OPEN.value ? AtmosphereLampDriveMode.OPEN : AtmosphereLampDriveMode.__UNKNOWN__;
        }
    }

    public static enum AtmosphereLampWorkMode {
        OFF(0),
        COLOR_CHOOSE_MODE(1),
        DRIVER_MODE(2),
        COMBINED_COLOR_MODE1(3),
        COMBINED_COLOR_MODE2(4),
        COMBINED_COLOR_MODE3(5),
        __UNKNOWN__(-1);

        public final int value;

        private AtmosphereLampWorkMode(int v1) {
            this.value = v1;
        }

        public static AtmosphereLampWorkMode valueOf(int v) {
            if(v == AtmosphereLampWorkMode.OFF.value) {
                return AtmosphereLampWorkMode.OFF;
            }
            if(v == AtmosphereLampWorkMode.COLOR_CHOOSE_MODE.value) {
                return AtmosphereLampWorkMode.COLOR_CHOOSE_MODE;
            }
            if(v == AtmosphereLampWorkMode.DRIVER_MODE.value) {
                return AtmosphereLampWorkMode.DRIVER_MODE;
            }
            if(v == AtmosphereLampWorkMode.COMBINED_COLOR_MODE1.value) {
                return AtmosphereLampWorkMode.COMBINED_COLOR_MODE1;
            }
            if(v == AtmosphereLampWorkMode.COMBINED_COLOR_MODE2.value) {
                return AtmosphereLampWorkMode.COMBINED_COLOR_MODE2;
            }
            return v == AtmosphereLampWorkMode.COMBINED_COLOR_MODE3.value ? AtmosphereLampWorkMode.COMBINED_COLOR_MODE3 : AtmosphereLampWorkMode.__UNKNOWN__;
        }
    }

    public static enum HeadLightVirtualSwitch {
        NOT_ACTIVE(0),
        POSITION_LIGHT(1),
        LOW_BEAM(2),
        AUTO_LIGHT(3),
        __UNKNOWN__(-1);

        public final int value;

        private HeadLightVirtualSwitch(int v1) {
            this.value = v1;
        }

        public static HeadLightVirtualSwitch valueOf(int v) {
            if(v == HeadLightVirtualSwitch.NOT_ACTIVE.value) {
                return HeadLightVirtualSwitch.NOT_ACTIVE;
            }
            if(v == HeadLightVirtualSwitch.POSITION_LIGHT.value) {
                return HeadLightVirtualSwitch.POSITION_LIGHT;
            }
            if(v == HeadLightVirtualSwitch.LOW_BEAM.value) {
                return HeadLightVirtualSwitch.LOW_BEAM;
            }
            return v == HeadLightVirtualSwitch.AUTO_LIGHT.value ? HeadLightVirtualSwitch.AUTO_LIGHT : HeadLightVirtualSwitch.__UNKNOWN__;
        }
    }

    public static enum LightShowFunCmd {
        PREPARE(1),
        START(2),
        END(3),
        __UNKNOWN__(-1);

        public final int value;

        private LightShowFunCmd(int v1) {
            this.value = v1;
        }

        public static LightShowFunCmd valueOf(int v) {
            if(v == LightShowFunCmd.PREPARE.value) {
                return LightShowFunCmd.PREPARE;
            }
            if(v == LightShowFunCmd.START.value) {
                return LightShowFunCmd.START;
            }
            return v == LightShowFunCmd.END.value ? LightShowFunCmd.END : LightShowFunCmd.__UNKNOWN__;
        }
    }

    public static enum LightShowMode {
        OFF(0, 0),
        MODLE1(1, 1),
        MODEL2(2, 2),
        MODLE3(3, 3),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private LightShowMode(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static LightShowMode valueOf(int v) {
            if(v == LightShowMode.OFF.rx) {
                return LightShowMode.OFF;
            }
            if(v == LightShowMode.MODLE1.rx) {
                return LightShowMode.MODLE1;
            }
            if(v == LightShowMode.MODEL2.rx) {
                return LightShowMode.MODEL2;
            }
            return v == LightShowMode.MODLE3.rx ? LightShowMode.MODLE3 : LightShowMode.__UNKNOWN__;
        }
    }

    public static enum MainLampSwitchSt {
        OFF(0),
        AUTO(1),
        PARKING_LAMP(2),
        LOW_BEAM(3),
        __UNKNOWN__(-1);

        public final int value;

        private MainLampSwitchSt(int v1) {
            this.value = v1;
        }

        public static MainLampSwitchSt valueOf(int v) {
            if(v == MainLampSwitchSt.OFF.value) {
                return MainLampSwitchSt.OFF;
            }
            if(v == MainLampSwitchSt.AUTO.value) {
                return MainLampSwitchSt.AUTO;
            }
            if(v == MainLampSwitchSt.PARKING_LAMP.value) {
                return MainLampSwitchSt.PARKING_LAMP;
            }
            return v == MainLampSwitchSt.LOW_BEAM.value ? MainLampSwitchSt.LOW_BEAM : MainLampSwitchSt.__UNKNOWN__;
        }
    }

    public static enum WelLightMode {
        DISABLE(0, 1),
        MODLE1(1, 2),
        MODEL2(2, 3),
        MODLE3(3, 4),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private WelLightMode(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static WelLightMode valueOf(int v) {
            if(v == WelLightMode.DISABLE.rx) {
                return WelLightMode.DISABLE;
            }
            if(v == WelLightMode.MODLE1.rx) {
                return WelLightMode.MODLE1;
            }
            if(v == WelLightMode.MODEL2.rx) {
                return WelLightMode.MODEL2;
            }
            return v == WelLightMode.MODLE3.rx ? WelLightMode.MODLE3 : WelLightMode.__UNKNOWN__;
        }
    }

    public static final int ADB_SATE = 553;
    public static final int ADB_SETTING = 554;
    public static final int ATMOSPHERE_LAMP_BRIGHTNESS = 275;
    public static final int ATMOSPHERE_LAMP_BRIGHTNESS_SETTING = 276;
    public static final int ATMOSPHERE_LAMP_COLOR = 277;
    public static final int ATMOSPHERE_LAMP_COLOR_SETTING = 278;
    public static final int ATMOSPHERE_LAMP_DRIVE_MODE_COLOR_STATUS = 651;
    public static final int ATMOSPHERE_LAMP_DRIVE_MODE_COLOR_STETTING = 652;
    public static final int ATMOSPHERE_LAMP_DRIVE_MODE_SETTING = 280;
    public static final int ATMOSPHERE_LAMP_DRIVE_MODE_STATUS = 619;
    public static final int ATMOSPHERE_LAMP_DRIVE_MODE_SWITCH_SETTING = 0x26F;
    public static final int ATMOSPHERE_LAMP_MUSIC_MODE = 281;
    public static final int ATMOSPHERE_LAMP_MUSIC_MODE_SETTING = 282;
    public static final int ATMOSPHERE_LAMP_MUSIC_MODE_SETTINGOP = 661;
    public static final int ATMOSPHERE_LAMP_SETTING = 274;
    public static final int ATMOSPHERE_LAMP_WORK_MODE = 279;
    public static final int ATMOSPHERE_LAMP_WORK_MODE_SETTING = 0x15F;
    public static final int AUTO_HOLD_LIGHT_ENABLE_SETTING = 0x1F0;
    public static final int AUTO_HOLD_LIGHT_ENABLE_STATE = 0x1EF;
    public static final int AUTO_WEL_LIGHT_ENABLE_SETTING = 608;
    public static final int AUTO_WEL_LIGHT_ENABLE_STATE = 609;
    public static final int BRAKE_LAMP_STATE = 0xC6;
    public static final int DRIVER_MODE_MUSIC_MODE_SETTING = 658;
    public static final int DRIVER_MODE_MUSIC_MODE_STATE = 657;
    public static final int DRL_LIGHT_ENABLE_SETTING = 700;
    public static final int DRL_LIGHT_ENABLE_STATE = 699;
    public static final int DRL_LIGHT_VALID_STATE = 701;
    public static final int FRONT_FOG_LIGHT_BUTTON_SETTING = 728;
    public static final int HEAD_LIGHT_DELAY_SETTING = 70;
    public static final int HEAD_LIGHT_DELAY_STATE = 0xB2;
    public static final int HEAD_LIGHT_VIRTUAL_SWITCH_SETTING = 718;
    public static final int IHBC_SETTING = 69;
    public static final int IHBC_STATE = 0xB1;
    public static final int ILBC_SETTING = 200;
    public static final int ILBC_STATE = 0xC7;
    public static final int LIGHT_SHOW_FUN_CMD_SETTING = 507;
    public static final int LIGHT_SHOW_MAIN_LAMP_SWITCH_STATE = 0x1FF;
    public static final int LIGHT_SHOW_MODE_SETTING = 509;
    public static final int LIGHT_SHOW_MODE_STATE = 508;
    public static final int LIGHT_SHOW_TIME_FLAG_SETTING = 510;
    public static final int LOW_LIGHT_STATE = 209;
    public static final int REAL_FOG_LIGHT_BUTTON_SETTING = 729;
    public static final int SMALL_LIGHT_STATE = 0x106;
    public static final int TECH_GLASS_LIGHT_CHOOSE_SETTING = 660;
    public static final int TECH_GLASS_LIGHT_CHOOSE_STATE = 659;
    public static final int TOPLIGHT_All_SETTING = 0x23F;
    public static final int TOPLIGHT_SETTING = 0xDD;
    public static final int TOPLIGHT_STATE = 220;
    public static final int WEL_LIGHT_ENABLE_SETTING = 0x1F2;
    public static final int WEL_LIGHT_ENABLE_STATE = 0x1F1;
    public static final int WEL_LIGHT_MODE = 0x1F3;
    public static final int WEL_LIGHT_MODE_SETTING = 500;

}

