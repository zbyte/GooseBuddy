package com.yftech.vehicle.internal.adapter;

public interface ICarIcm extends IBaseApi {
    public static enum BackLightLevel {
        LEVEL_1(0, 1),
        LEVEL_2(1, 2),
        LEVEL_3(2, 3),
        LEVEL_4(3, 4),
        LEVEL_5(4, 5),
        LEVEL_6(5, 6),
        LEVEL_7(6, 7),
        LEVEL_8(7, 8),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private BackLightLevel(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static BackLightLevel valueOf(int v) {
            if(v == BackLightLevel.LEVEL_1.rx) {
                return BackLightLevel.LEVEL_1;
            }
            if(v == BackLightLevel.LEVEL_2.rx) {
                return BackLightLevel.LEVEL_2;
            }
            if(v == BackLightLevel.LEVEL_3.rx) {
                return BackLightLevel.LEVEL_3;
            }
            if(v == BackLightLevel.LEVEL_4.rx) {
                return BackLightLevel.LEVEL_4;
            }
            if(v == BackLightLevel.LEVEL_5.rx) {
                return BackLightLevel.LEVEL_5;
            }
            if(v == BackLightLevel.LEVEL_6.rx) {
                return BackLightLevel.LEVEL_6;
            }
            if(v == BackLightLevel.LEVEL_7.rx) {
                return BackLightLevel.LEVEL_7;
            }
            return v == BackLightLevel.LEVEL_8.rx ? BackLightLevel.LEVEL_8 : BackLightLevel.__UNKNOWN__;
        }
    }

    public static enum CurrentSource {
        OFF(0),
        USB_MUSIC(2),
        BT_MUSIC(6),
        CARPLAY_MUSIC(21),
        __UNKNOWN__(-1);

        public final int value;

        private CurrentSource(int v1) {
            this.value = v1;
        }

        public static CurrentSource valueOf(int v) {
            if(v == CurrentSource.OFF.value) {
                return CurrentSource.OFF;
            }
            if(v == CurrentSource.USB_MUSIC.value) {
                return CurrentSource.USB_MUSIC;
            }
            if(v == CurrentSource.BT_MUSIC.value) {
                return CurrentSource.BT_MUSIC;
            }
            return v == CurrentSource.CARPLAY_MUSIC.value ? CurrentSource.CARPLAY_MUSIC : CurrentSource.__UNKNOWN__;
        }
    }

    public static enum FuelEconomyAndDistanceUnit {
        L_PER_100KM_AND_KM(0, 1),
        MPG_GB_AND_M(1, 2),
        MPG_US_AND_M(2, 3),
        KM_L_AND_KM(3, 4),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private FuelEconomyAndDistanceUnit(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static FuelEconomyAndDistanceUnit valueOf(int v) {
            if(v == FuelEconomyAndDistanceUnit.L_PER_100KM_AND_KM.rx) {
                return FuelEconomyAndDistanceUnit.L_PER_100KM_AND_KM;
            }
            if(v == FuelEconomyAndDistanceUnit.MPG_GB_AND_M.rx) {
                return FuelEconomyAndDistanceUnit.MPG_GB_AND_M;
            }
            if(v == FuelEconomyAndDistanceUnit.MPG_US_AND_M.rx) {
                return FuelEconomyAndDistanceUnit.MPG_US_AND_M;
            }
            return v == FuelEconomyAndDistanceUnit.KM_L_AND_KM.rx ? FuelEconomyAndDistanceUnit.KM_L_AND_KM : FuelEconomyAndDistanceUnit.__UNKNOWN__;
        }
    }

    public static enum ICMCurrentShowPage {
        NO_LVDS(0),
        MAINDISPLAYZONE_ON(1),
        SLAVEDISPLAYZONE_ON(2),
        ALLDISPLAYZONE_ON(3),
        STOPWATCH_DISPLAY(4),
        POWER_DISPLAY(5),
        NAVI_DISPLAY(6),
        MEDIA_DISPLAY(7),
        FACE_ID_DISPLAY(8),
        __UNKNOWN__(-1);

        public final int value;

        private ICMCurrentShowPage(int v1) {
            this.value = v1;
        }

        public static ICMCurrentShowPage valueOf(int v) {
            if(v == ICMCurrentShowPage.NO_LVDS.value) {
                return ICMCurrentShowPage.NO_LVDS;
            }
            if(v == ICMCurrentShowPage.MAINDISPLAYZONE_ON.value) {
                return ICMCurrentShowPage.MAINDISPLAYZONE_ON;
            }
            if(v == ICMCurrentShowPage.SLAVEDISPLAYZONE_ON.value) {
                return ICMCurrentShowPage.SLAVEDISPLAYZONE_ON;
            }
            if(v == ICMCurrentShowPage.ALLDISPLAYZONE_ON.value) {
                return ICMCurrentShowPage.ALLDISPLAYZONE_ON;
            }
            if(v == ICMCurrentShowPage.STOPWATCH_DISPLAY.value) {
                return ICMCurrentShowPage.STOPWATCH_DISPLAY;
            }
            if(v == ICMCurrentShowPage.POWER_DISPLAY.value) {
                return ICMCurrentShowPage.POWER_DISPLAY;
            }
            if(v == ICMCurrentShowPage.NAVI_DISPLAY.value) {
                return ICMCurrentShowPage.NAVI_DISPLAY;
            }
            if(v == ICMCurrentShowPage.MEDIA_DISPLAY.value) {
                return ICMCurrentShowPage.MEDIA_DISPLAY;
            }
            return v == ICMCurrentShowPage.FACE_ID_DISPLAY.value ? ICMCurrentShowPage.FACE_ID_DISPLAY : ICMCurrentShowPage.__UNKNOWN__;
        }
    }

    public static enum ICMShowPageSetting {
        NO_COMMAND(0),
        STOPWATCH_START(1),
        STOPWATCH_STOP(2),
        POWER_START(3),
        POWER_STOP(4),
        NAV_START(5),
        NAV_STOP(6),
        MEDIA_START(7),
        MEDIA_STOP(8),
        __UNKNOWN__(-1);

        public final int value;

        private ICMShowPageSetting(int v1) {
            this.value = v1;
        }

        public static ICMShowPageSetting valueOf(int v) {
            if(v == ICMShowPageSetting.NO_COMMAND.value) {
                return ICMShowPageSetting.NO_COMMAND;
            }
            if(v == ICMShowPageSetting.STOPWATCH_START.value) {
                return ICMShowPageSetting.STOPWATCH_START;
            }
            if(v == ICMShowPageSetting.STOPWATCH_STOP.value) {
                return ICMShowPageSetting.STOPWATCH_STOP;
            }
            if(v == ICMShowPageSetting.POWER_START.value) {
                return ICMShowPageSetting.POWER_START;
            }
            if(v == ICMShowPageSetting.POWER_STOP.value) {
                return ICMShowPageSetting.POWER_STOP;
            }
            if(v == ICMShowPageSetting.NAV_START.value) {
                return ICMShowPageSetting.NAV_START;
            }
            if(v == ICMShowPageSetting.NAV_STOP.value) {
                return ICMShowPageSetting.NAV_STOP;
            }
            if(v == ICMShowPageSetting.MEDIA_START.value) {
                return ICMShowPageSetting.MEDIA_START;
            }
            return v == ICMShowPageSetting.MEDIA_STOP.value ? ICMShowPageSetting.MEDIA_STOP : ICMShowPageSetting.__UNKNOWN__;
        }
    }

    public static enum Language {
        CHINESE(1, 1),
        ENGLISH(2, 2),
        RUSSIAN(3, 3),
        ARABIC(4, 4),
        SPANISH(5, 5),
        PORTUGUESE(6, 6),
        INDONESIAN(7, 7),
        CHINESE_TRADITIONAL(8, 8),
        VIETNAMENSE(9, 9),
        THAI(10, 10),
        MALAY(11, 11),
        FRENCH(12, 12),
        ITALY(13, 13),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private Language(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static Language valueOf(int v) {
            if(v == Language.CHINESE.rx) {
                return Language.CHINESE;
            }
            if(v == Language.ENGLISH.rx) {
                return Language.ENGLISH;
            }
            if(v == Language.RUSSIAN.rx) {
                return Language.RUSSIAN;
            }
            if(v == Language.ARABIC.rx) {
                return Language.ARABIC;
            }
            if(v == Language.SPANISH.rx) {
                return Language.SPANISH;
            }
            if(v == Language.PORTUGUESE.rx) {
                return Language.PORTUGUESE;
            }
            if(v == Language.INDONESIAN.rx) {
                return Language.INDONESIAN;
            }
            if(v == Language.CHINESE_TRADITIONAL.rx) {
                return Language.CHINESE_TRADITIONAL;
            }
            if(v == Language.VIETNAMENSE.rx) {
                return Language.VIETNAMENSE;
            }
            if(v == Language.THAI.rx) {
                return Language.THAI;
            }
            if(v == Language.MALAY.rx) {
                return Language.MALAY;
            }
            if(v == Language.FRENCH.rx) {
                return Language.FRENCH;
            }
            return v == Language.ITALY.rx ? Language.ITALY : Language.__UNKNOWN__;
        }
    }

    public static enum MeterVolumeMode {
        LOW(0, 1),
        MIDDLE(1, 2),
        HIGH(2, 3),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private MeterVolumeMode(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static MeterVolumeMode valueOf(int v) {
            if(v == MeterVolumeMode.LOW.rx) {
                return MeterVolumeMode.LOW;
            }
            if(v == MeterVolumeMode.MIDDLE.rx) {
                return MeterVolumeMode.MIDDLE;
            }
            return v == MeterVolumeMode.HIGH.rx ? MeterVolumeMode.HIGH : MeterVolumeMode.__UNKNOWN__;
        }
    }

    public static enum PressureUnit {
        K_PA(0, 1),
        BAR(1, 2),
        PSI(2, 3),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private PressureUnit(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static PressureUnit valueOf(int v) {
            if(v == PressureUnit.K_PA.rx) {
                return PressureUnit.K_PA;
            }
            if(v == PressureUnit.BAR.rx) {
                return PressureUnit.BAR;
            }
            return v == PressureUnit.PSI.rx ? PressureUnit.PSI : PressureUnit.__UNKNOWN__;
        }
    }

    public static enum TemperatureUnit {
        CELSIUS(0, 1),
        FAHRENHEIT(1, 2),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private TemperatureUnit(int v1, int v2) {
            this.rx = v1;
            this.tx = v2;
            this.value = this.tx;
        }

        public static TemperatureUnit valueOf(int v) {
            if(v == TemperatureUnit.CELSIUS.rx) {
                return TemperatureUnit.CELSIUS;
            }
            return v == TemperatureUnit.FAHRENHEIT.rx ? TemperatureUnit.FAHRENHEIT : TemperatureUnit.__UNKNOWN__;
        }
    }

    public static final int ACU_CURRENTSOURCE_SETTING = 626;
    public static final int BACK_LIGHT_LEVEL = 0x72;
    public static final int BACK_LIGHT_LEVEL_SETTING = 0xDB;
    public static final int FM_FREQ_SYMBOL_SETTING = 533;
    public static final int FUEL_ECONOMY_AND_DISTANCE_UNIT = 0x77;
    public static final int FUEL_ECONOMY_AND_DISTANCE_UNIT_SETTING = 51;
    public static final int ICM_AVAIBLE_DRIVE_DISTANCE = 713;
    public static final int ICM_FUEL_LEVEL = 711;
    public static final int ICM_FUEL_LEVEL_LOW = 712;
    public static final int KEEP_MUTE_WARNING = 120;
    public static final int KEYBOARD_BACKLIGHT = 0xE2;
    public static final int LANGUAGE = 0x76;
    public static final int LANGUAGE_SETTING = 50;
    public static final int METER_CURRENT_SHOW_PAGE = 0x28F;
    public static final int METER_SHOW_PAGE_SETTING = 0x290;
    public static final int METER_VOLUME_MODE = 0x102;
    public static final int METER_VOLUME_MODE_SETTING = 0x103;
    public static final int PRESSURE_UNIT = 0x74;
    public static final int PRESSURE_UNIT_SETTING = 0x30;
    public static final int REAR_SEAT_BELT_WARN_SETTING = 607;
    public static final int REAR_SEAT_BELT_WARN_STATUS = 606;
    public static final int REAR_SEAT_BELT_WARN_SWITCH_SETTING = 663;
    public static final int SPEED_WARNING = 0x75;
    public static final int SPEED_WARNING_SETTING = 49;
    public static final int TEMPERATURE_UNIT = 0x73;
    public static final int TEMPERATURE_UNIT_SETTING = 0x2F;

}

