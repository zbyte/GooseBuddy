package com.yftech.vehicle.internal.config;

public interface Ihu23IHostConfig {
    public static enum CarMode {
        CAR_MODE1(0),
        CAR_MODE2(1),
        CAR_MODE3(2),
        CAR_MODE4(3),
        __UNKNOWN__(-1);

        public final int value;

        private CarMode(int v1) {
            this.value = v1;
        }

        public static CarMode valueOf(int v) {
            if(v == CarMode.CAR_MODE1.value) {
                return CarMode.CAR_MODE1;
            }
            if(v == CarMode.CAR_MODE2.value) {
                return CarMode.CAR_MODE2;
            }
            if(v == CarMode.CAR_MODE3.value) {
                return CarMode.CAR_MODE3;
            }
            return v == CarMode.CAR_MODE4.value ? CarMode.CAR_MODE4 : CarMode.__UNKNOWN__;
        }
    }

    public static enum Config {
        LANGUAGE(0, 0, 3),
        NUMBER_OF_SCREEN(0, 4, 5),
        CAR_MODE(0, 6, 7),
        CARPLAY(1, 0),
        CARLIFE(1, 1),
        IPHONE_DEFAULT_CONNECTING(1, 3),
        ANDROID_AUTO(1, 5),
        WIFI(2, 0, 1),
        BT(2, 2),
        CELLULAR_NETWORK(2, 3),
        AUX(2, 4),
        IPOD(2, 5),
        USB(2, 6, 7),
        ETHERNET_NET(3, 0),
        RADIO_CONFIGURATION(3, 2, 3),
        RADAR_VOLUME_ADJUSTMENT(3, 6, 7),
        RADIO_DAB_RDS_CONFIGURATION(3, 4, 5),
        SDVC_CURVE_CONFIGURATION(4, 0),
        HVAC_DISPLAY_TIME(4, 1, 3),
        RADIO_FREQUENCY(4, 4, 7),
        MEDIA_VOLUME_DELAY(5, 0, 2),
        SCREEN_SWITCH_DELAY(5, 3, 5),
        RADAR_SWITCH(5, 6),
        KEYTONE(7, 4, 5),
        INTERFACE_SOUND(7, 6, 7),
        FACE_ID(8, 0),
        SCREENSAVER(8, 6),
        USER_MANUAL(8, 7),
        ENGINEERING_MODE(9, 0),
        REMINDING_MAINTENANCE_CYCLE(9, 1),
        REMINDING_RESET_CYCLE(9, 2),
        REPEAT_SETTING(9, 3),
        VIDE_APP(9, 4),
        PICTURE_APP(9, 5),
        __UNKNOWN__(-1, -1);

        public final byte bitSize;
        public final byte byteIndex;
        public final byte startBit;

        private Config(int v1, int v2) {
            this.byteIndex = (byte)v1;
            this.startBit = (byte)v2;
            this.bitSize = 1;
        }

        private Config(int v1, int v2, int v3) {
            this.byteIndex = (byte)v1;
            this.startBit = (byte)v2;
            this.bitSize = (byte)(v3 - v2 + 1);
        }
    }

    public static enum EngineeringMode {
        CLOSE(0),
        OPEN(1),
        __UNKNOWN__(-1);

        public final int value;

        private EngineeringMode(int v1) {
            this.value = v1;
        }

        public static EngineeringMode valueOf(int v) {
            if(v == EngineeringMode.CLOSE.value) {
                return EngineeringMode.CLOSE;
            }
            return v == EngineeringMode.OPEN.value ? EngineeringMode.OPEN : EngineeringMode.__UNKNOWN__;
        }
    }

    public static enum HvacDisplayTime {
        NOT_PRESENT(0),
        FIVE_SECOND(1),
        TEN_SECOND(2),
        FIFTEEN_SECOND(3),
        THIRTY_SECOND(4),
        __UNKNOWN__(-1);

        public final int value;

        private HvacDisplayTime(int v1) {
            this.value = v1;
        }

        public static HvacDisplayTime valueOf(int v) {
            if(v == HvacDisplayTime.NOT_PRESENT.value) {
                return HvacDisplayTime.NOT_PRESENT;
            }
            if(v == HvacDisplayTime.FIVE_SECOND.value) {
                return HvacDisplayTime.FIVE_SECOND;
            }
            if(v == HvacDisplayTime.TEN_SECOND.value) {
                return HvacDisplayTime.TEN_SECOND;
            }
            if(v == HvacDisplayTime.FIFTEEN_SECOND.value) {
                return HvacDisplayTime.FIFTEEN_SECOND;
            }
            return v == HvacDisplayTime.THIRTY_SECOND.value ? HvacDisplayTime.THIRTY_SECOND : HvacDisplayTime.__UNKNOWN__;
        }
    }

    public static enum InterfaceSound {
        NOT_PRESENT(0),
        ON(1),
        OFF(2),
        __UNKNOWN__(-1);

        public final int value;

        private InterfaceSound(int v1) {
            this.value = v1;
        }

        public static InterfaceSound valueOf(int v) {
            if(v == InterfaceSound.NOT_PRESENT.value) {
                return InterfaceSound.NOT_PRESENT;
            }
            if(v == InterfaceSound.ON.value) {
                return InterfaceSound.ON;
            }
            return v == InterfaceSound.OFF.value ? InterfaceSound.OFF : InterfaceSound.__UNKNOWN__;
        }
    }

    public static enum Keytone {
        NOT_PRESENT(0),
        MODERN(1),
        VINTAGE(2),
        NO_KEYTONE(3),
        __UNKNOWN__(-1);

        public final int value;

        private Keytone(int v1) {
            this.value = v1;
        }

        public static Keytone valueOf(int v) {
            if(v == Keytone.NOT_PRESENT.value) {
                return Keytone.NOT_PRESENT;
            }
            if(v == Keytone.MODERN.value) {
                return Keytone.MODERN;
            }
            if(v == Keytone.VINTAGE.value) {
                return Keytone.VINTAGE;
            }
            return v == Keytone.NO_KEYTONE.value ? Keytone.NO_KEYTONE : Keytone.__UNKNOWN__;
        }
    }

    public static enum Language {
        CHINESE(0),
        ENGLISH(1),
        ARABIC_RESERVED(2),
        RUSSIAN_RESERVED(3),
        CHINESE_PLUSENGLISH(4),
        SPANISH(5),
        INDONESIAN(6),
        THAI(7),
        MALAY(8),
        VIETNAMESE(9),
        TRADITIONAL_CHINESE(10),
        PORTUGUESE(11),
        __UNKNOWN__(-1);

        public final int value;

        private Language(int v1) {
            this.value = v1;
        }

        public static Language valueOf(int v) {
            if(v == Language.CHINESE.value) {
                return Language.CHINESE;
            }
            if(v == Language.ENGLISH.value) {
                return Language.ENGLISH;
            }
            if(v == Language.ARABIC_RESERVED.value) {
                return Language.ARABIC_RESERVED;
            }
            if(v == Language.RUSSIAN_RESERVED.value) {
                return Language.RUSSIAN_RESERVED;
            }
            if(v == Language.CHINESE_PLUSENGLISH.value) {
                return Language.CHINESE_PLUSENGLISH;
            }
            if(v == Language.SPANISH.value) {
                return Language.SPANISH;
            }
            if(v == Language.INDONESIAN.value) {
                return Language.INDONESIAN;
            }
            if(v == Language.THAI.value) {
                return Language.THAI;
            }
            if(v == Language.MALAY.value) {
                return Language.MALAY;
            }
            if(v == Language.VIETNAMESE.value) {
                return Language.VIETNAMESE;
            }
            if(v == Language.TRADITIONAL_CHINESE.value) {
                return Language.TRADITIONAL_CHINESE;
            }
            return v == Language.PORTUGUESE.value ? Language.PORTUGUESE : Language.__UNKNOWN__;
        }
    }

    public static enum NumberOfScreen {
        TOW(0),
        THREE(1),
        ONE(2),
        __UNKNOWN__(-1);

        public final int value;

        private NumberOfScreen(int v1) {
            this.value = v1;
        }

        public static NumberOfScreen valueOf(int v) {
            if(v == NumberOfScreen.TOW.value) {
                return NumberOfScreen.TOW;
            }
            if(v == NumberOfScreen.THREE.value) {
                return NumberOfScreen.THREE;
            }
            return v == NumberOfScreen.ONE.value ? NumberOfScreen.ONE : NumberOfScreen.__UNKNOWN__;
        }
    }

    public static enum RadarVolumeAdjustment {
        NOT_PRESENT(0),
        LOW(1),
        MIDDLE(2),
        HIGH(3),
        __UNKNOWN__(-1);

        public final int value;

        private RadarVolumeAdjustment(int v1) {
            this.value = v1;
        }

        public static RadarVolumeAdjustment valueOf(int v) {
            if(v == RadarVolumeAdjustment.NOT_PRESENT.value) {
                return RadarVolumeAdjustment.NOT_PRESENT;
            }
            if(v == RadarVolumeAdjustment.LOW.value) {
                return RadarVolumeAdjustment.LOW;
            }
            if(v == RadarVolumeAdjustment.MIDDLE.value) {
                return RadarVolumeAdjustment.MIDDLE;
            }
            return v == RadarVolumeAdjustment.HIGH.value ? RadarVolumeAdjustment.HIGH : RadarVolumeAdjustment.__UNKNOWN__;
        }
    }

    public static enum RadioConfiguration {
        NOT_PRESENT(0),
        FM(1),
        AM(2),
        FM_PLUSAM(3),
        __UNKNOWN__(-1);

        public final int value;

        private RadioConfiguration(int v1) {
            this.value = v1;
        }

        public static RadioConfiguration valueOf(int v) {
            if(v == RadioConfiguration.NOT_PRESENT.value) {
                return RadioConfiguration.NOT_PRESENT;
            }
            if(v == RadioConfiguration.FM.value) {
                return RadioConfiguration.FM;
            }
            if(v == RadioConfiguration.AM.value) {
                return RadioConfiguration.AM;
            }
            return v == RadioConfiguration.FM_PLUSAM.value ? RadioConfiguration.FM_PLUSAM : RadioConfiguration.__UNKNOWN__;
        }
    }

    public static enum RadioDABAndRDSConfig {
        RDS(0),
        DAB_RDS(1),
        DAB(2),
        NOT_PRESENT(3),
        __UNKNOWN__(-1);

        public final int value;

        private RadioDABAndRDSConfig(int v1) {
            this.value = v1;
        }

        public static RadioDABAndRDSConfig valueOf(int v) {
            if(v == RadioDABAndRDSConfig.NOT_PRESENT.value) {
                return RadioDABAndRDSConfig.NOT_PRESENT;
            }
            if(v == RadioDABAndRDSConfig.DAB_RDS.value) {
                return RadioDABAndRDSConfig.DAB_RDS;
            }
            if(v == RadioDABAndRDSConfig.DAB.value) {
                return RadioDABAndRDSConfig.DAB;
            }
            return v == RadioDABAndRDSConfig.RDS.value ? RadioDABAndRDSConfig.RDS : RadioDABAndRDSConfig.__UNKNOWN__;
        }
    }

    public static enum RadioFrequency {
        CHINA_MIDDLEEAST_AFRICA(0),
        EUROPE1(1),
        EUROPE2(2),
        EASTERN_EUROPE1(3),
        EASTERN_EUROPE2(4),
        AUSTRALIA(5),
        USA(6),
        LATIN_AMERICA(7),
        SOUTHEAST_ASIA(8),
        JAPAN(9),
        __UNKNOWN__(-1);

        public final int value;

        private RadioFrequency(int v1) {
            this.value = v1;
        }

        public static RadioFrequency valueOf(int v) {
            if(v == RadioFrequency.CHINA_MIDDLEEAST_AFRICA.value) {
                return RadioFrequency.CHINA_MIDDLEEAST_AFRICA;
            }
            if(v == RadioFrequency.EUROPE1.value) {
                return RadioFrequency.EUROPE1;
            }
            if(v == RadioFrequency.EUROPE2.value) {
                return RadioFrequency.EUROPE2;
            }
            if(v == RadioFrequency.EASTERN_EUROPE1.value) {
                return RadioFrequency.EASTERN_EUROPE1;
            }
            if(v == RadioFrequency.EASTERN_EUROPE2.value) {
                return RadioFrequency.EASTERN_EUROPE2;
            }
            if(v == RadioFrequency.AUSTRALIA.value) {
                return RadioFrequency.AUSTRALIA;
            }
            if(v == RadioFrequency.USA.value) {
                return RadioFrequency.USA;
            }
            if(v == RadioFrequency.LATIN_AMERICA.value) {
                return RadioFrequency.LATIN_AMERICA;
            }
            if(v == RadioFrequency.SOUTHEAST_ASIA.value) {
                return RadioFrequency.SOUTHEAST_ASIA;
            }
            return v == RadioFrequency.JAPAN.value ? RadioFrequency.JAPAN : RadioFrequency.__UNKNOWN__;
        }
    }

    public static enum RemindingMaintenanceCycle {
        CLOSE(0),
        OPEN(1),
        __UNKNOWN__(-1);

        public final int value;

        private RemindingMaintenanceCycle(int v1) {
            this.value = v1;
        }

        public static RemindingMaintenanceCycle valueOf(int v) {
            if(v == RemindingMaintenanceCycle.CLOSE.value) {
                return RemindingMaintenanceCycle.CLOSE;
            }
            return v == RemindingMaintenanceCycle.OPEN.value ? RemindingMaintenanceCycle.OPEN : RemindingMaintenanceCycle.__UNKNOWN__;
        }
    }

    public static enum RemindingResetCycle {
        CLOSE(0),
        OPEN(1),
        __UNKNOWN__(-1);

        public final int value;

        private RemindingResetCycle(int v1) {
            this.value = v1;
        }

        public static RemindingResetCycle valueOf(int v) {
            if(v == RemindingResetCycle.CLOSE.value) {
                return RemindingResetCycle.CLOSE;
            }
            return v == RemindingResetCycle.OPEN.value ? RemindingResetCycle.OPEN : RemindingResetCycle.__UNKNOWN__;
        }
    }

    public static enum RepeatSetting {
        CLOSE(0),
        OPEN(1),
        __UNKNOWN__(-1);

        public final int value;

        private RepeatSetting(int v1) {
            this.value = v1;
        }

        public static RepeatSetting valueOf(int v) {
            if(v == RepeatSetting.CLOSE.value) {
                return RepeatSetting.CLOSE;
            }
            return v == RepeatSetting.OPEN.value ? RepeatSetting.OPEN : RepeatSetting.__UNKNOWN__;
        }
    }

    public static enum SdvcCurveConfiguration {
        SVC1(0),
        SVC2(1),
        __UNKNOWN__(-1);

        public final int value;

        private SdvcCurveConfiguration(int v1) {
            this.value = v1;
        }

        public static SdvcCurveConfiguration valueOf(int v) {
            if(v == SdvcCurveConfiguration.SVC1.value) {
                return SdvcCurveConfiguration.SVC1;
            }
            return v == SdvcCurveConfiguration.SVC2.value ? SdvcCurveConfiguration.SVC2 : SdvcCurveConfiguration.__UNKNOWN__;
        }
    }

    public static enum Usb {
        NOT_PRESENT(0),
        ONE(1),
        TWO(2),
        __UNKNOWN__(-1);

        public final int value;

        private Usb(int v1) {
            this.value = v1;
        }

        public static Usb valueOf(int v) {
            if(v == Usb.NOT_PRESENT.value) {
                return Usb.NOT_PRESENT;
            }
            if(v == Usb.ONE.value) {
                return Usb.ONE;
            }
            return v == Usb.TWO.value ? Usb.TWO : Usb.__UNKNOWN__;
        }
    }

    public static enum Wifi {
        NOT_PRESENT(0),
        AP_STA_RESPECTIVELY(1),
        AP_STA_SIMULTANEOUSLY(2),
        __UNKNOWN__(-1);

        public final int value;

        private Wifi(int v1) {
            this.value = v1;
        }

        public static Wifi valueOf(int v) {
            if(v == Wifi.NOT_PRESENT.value) {
                return Wifi.NOT_PRESENT;
            }
            if(v == Wifi.AP_STA_RESPECTIVELY.value) {
                return Wifi.AP_STA_RESPECTIVELY;
            }
            return v == Wifi.AP_STA_SIMULTANEOUSLY.value ? Wifi.AP_STA_SIMULTANEOUSLY : Wifi.__UNKNOWN__;
        }
    }

    public static final int HOST_CONFIG = 9943;

}

