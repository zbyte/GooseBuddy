package com.yftech.vehicle.internal.adapter;

public interface IHostConfig {
    public static enum CarMode {
        CAR_MODE1(0),
        CAR_MODE2(1),
        CAR_MODE3(2),
        CAR_MODE4(3),
        __UNKNOWN__(-1);

        public final int value;

        private CarMode(int value) {
            this.value = value;
        }

        public static CarMode valueOf(int value) {
            if(value == CarMode.CAR_MODE1.value) {
                return CarMode.CAR_MODE1;
            }
            if(value == CarMode.CAR_MODE2.value) {
                return CarMode.CAR_MODE2;
            }
            if(value == CarMode.CAR_MODE3.value) {
                return CarMode.CAR_MODE3;
            }
            return value == CarMode.CAR_MODE4.value ? CarMode.CAR_MODE4 : CarMode.__UNKNOWN__;
        }
    }

    public static enum Config {
        LANGUAGE(0, 0, 3),
        NUMBER_OF_SCREEN(0, 4, 5),
        CAR_MODE(0, 6, 7),
        CARPLAY(1, 0),
        CARLIFE(1, 1),
        HICAR(1, 2),
        IPHONE_DEFAULT_CONNECTING(1, 3),
        EASY_CONNECT(1, 4),
        ANDROID_AUTO(1, 5),
        CAR_LINK(1, 6),
        WIFI(2, 0, 1),
        BT(2, 2),
        CELLULAR_NETWORK(2, 3),
        AUX(2, 4),
        IPOD(2, 5),
        USB(2, 6, 7),
        ETHERNET_NET(3, 0),
        RADIO_CONFIGURATION(3, 2, 3),
        RADIO_DAB(3, 4),
        RADIO_RDS(3, 5),
        RADIO_DAB_RDS_CONFIGURATION(3, 4, 5),
        RADAR_VOLUME_ADJUSTMENT(3, 6, 7),
        SDVC_CURVE_CONFIGURATION(4, 0),
        HVAC_DISPLAY_TIME(4, 1, 3),
        RADIO_FREQUENCY(4, 4, 7),
        MEDIA_VOLUME_DELAY(5, 0, 2),
        SCREEN_SWITCH_DELAY(5, 3, 5),
        RADAR_SWITCH(5, 6),
        WALLPAPER(6, 0),
        AUTO_PARKING_BACKGROUND_PUSH(6, 1),
        MESSAGE_NOTIFICATION(6, 2, 3),
        EXPRESS_MESSAGE(6, 4, 5),
        MAP_PREFERENCES(6, 6, 7),
        NAVIGATION_SIGNAL_MODE(7, 0, 3),
        KEYTONE(7, 4, 5),
        INTERFACE_SOUND(7, 6, 7),
        FACE_ID(8, 0),
        SHIFT_SOUND(8, 1),
        SCENE_SWITCH(8, 2),
        TRAFFIC_DISPLAY(8, 3),
        PHOTOS_AND_VIDEOS(8, 4),
        SCREENSAVER(8, 6),
        USER_MANUAL(8, 7),
        ENGINEERING_MODE(9, 0),
        REMINDING_MAINTENANCE_CYCLE(9, 1),
        REMINDING_RESET_CYCLE(9, 2),
        REPEAT_SETTING(9, 3),
        LEFT_RIGHT_HAND_DRIVE_VEHICLES(9, 4),
        __UNKNOWN__(-1, -1);

        public final byte bitSize;
        public final byte byteIndex;
        public final byte startBit;

        private Config(int byteIndex, int startBit) {
            this.byteIndex = (byte)byteIndex;
            this.startBit = (byte)startBit;
            this.bitSize = 1;
        }

        private Config(int byteIndex, int startBit, int endBit) {
            this.byteIndex = (byte)byteIndex;
            this.startBit = (byte)startBit;
            this.bitSize = (byte)(endBit - startBit + 1);
        }
    }

    public static enum EngineeringMode {
        CLOSE(0),
        OPEN(1),
        __UNKNOWN__(-1);

        public final int value;

        private EngineeringMode(int value) {
            this.value = value;
        }

        public static EngineeringMode valueOf(int value) {
            if(value == EngineeringMode.CLOSE.value) {
                return EngineeringMode.CLOSE;
            }
            return value == EngineeringMode.OPEN.value ? EngineeringMode.OPEN : EngineeringMode.__UNKNOWN__;
        }
    }

    public static enum ExpressMessage {
        NOT_PRESENT(0),
        ON(1),
        OFF(2),
        __UNKNOWN__(-1);

        public final int value;

        private ExpressMessage(int value) {
            this.value = value;
        }

        public static ExpressMessage valueOf(int value) {
            if(value == ExpressMessage.NOT_PRESENT.value) {
                return ExpressMessage.NOT_PRESENT;
            }
            if(value == ExpressMessage.ON.value) {
                return ExpressMessage.ON;
            }
            return value == ExpressMessage.OFF.value ? ExpressMessage.OFF : ExpressMessage.__UNKNOWN__;
        }
    }

    public static enum HvacDisplayTime {
        NOT_PRESENT(0),
        FIVES_SEC(1),
        TEN_SEC(2),
        FIFTEEN_SEC(3),
        THIRTY_SEC(4),
        __UNKNOWN__(-1);

        public final int value;

        private HvacDisplayTime(int value) {
            this.value = value;
        }

        public static HvacDisplayTime valueOf(int value) {
            if(value == HvacDisplayTime.NOT_PRESENT.value) {
                return HvacDisplayTime.NOT_PRESENT;
            }
            if(value == HvacDisplayTime.FIVES_SEC.value) {
                return HvacDisplayTime.FIVES_SEC;
            }
            if(value == HvacDisplayTime.TEN_SEC.value) {
                return HvacDisplayTime.TEN_SEC;
            }
            if(value == HvacDisplayTime.FIFTEEN_SEC.value) {
                return HvacDisplayTime.FIFTEEN_SEC;
            }
            return value == HvacDisplayTime.THIRTY_SEC.value ? HvacDisplayTime.THIRTY_SEC : HvacDisplayTime.__UNKNOWN__;
        }
    }

    public static enum InterfaceSound {
        NOT_PRESENT(0),
        ON(1),
        OFF(2),
        __UNKNOWN__(-1);

        public final int value;

        private InterfaceSound(int value) {
            this.value = value;
        }

        public static InterfaceSound valueOf(int value) {
            if(value == InterfaceSound.NOT_PRESENT.value) {
                return InterfaceSound.NOT_PRESENT;
            }
            if(value == InterfaceSound.ON.value) {
                return InterfaceSound.ON;
            }
            return value == InterfaceSound.OFF.value ? InterfaceSound.OFF : InterfaceSound.__UNKNOWN__;
        }
    }

    public static enum Keytone {
        NOT_PRESENT(0),
        MODERN(1),
        VINTAGE(2),
        NO_KEYTONE(3),
        __UNKNOWN__(-1);

        public final int value;

        private Keytone(int value) {
            this.value = value;
        }

        public static Keytone valueOf(int value) {
            if(value == Keytone.NOT_PRESENT.value) {
                return Keytone.NOT_PRESENT;
            }
            if(value == Keytone.MODERN.value) {
                return Keytone.MODERN;
            }
            if(value == Keytone.VINTAGE.value) {
                return Keytone.VINTAGE;
            }
            return value == Keytone.NO_KEYTONE.value ? Keytone.NO_KEYTONE : Keytone.__UNKNOWN__;
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
        CHINESE_TRADITIONAL(10),
        PORTUGUESE(11),
        ITALY(12),
        __UNKNOWN__(-1);

        public final int value;

        private Language(int value) {
            this.value = value;
        }

        public static Language valueOf(int value) {
            if(value == Language.CHINESE.value) {
                return Language.CHINESE;
            }
            if(value == Language.ENGLISH.value) {
                return Language.ENGLISH;
            }
            if(value == Language.ARABIC_RESERVED.value) {
                return Language.ARABIC_RESERVED;
            }
            if(value == Language.RUSSIAN_RESERVED.value) {
                return Language.RUSSIAN_RESERVED;
            }
            if(value == Language.CHINESE_PLUSENGLISH.value) {
                return Language.CHINESE_PLUSENGLISH;
            }
            if(value == Language.SPANISH.value) {
                return Language.SPANISH;
            }
            if(value == Language.INDONESIAN.value) {
                return Language.INDONESIAN;
            }
            if(value == Language.THAI.value) {
                return Language.THAI;
            }
            if(value == Language.MALAY.value) {
                return Language.MALAY;
            }
            if(value == Language.VIETNAMESE.value) {
                return Language.VIETNAMESE;
            }
            if(value == Language.CHINESE_TRADITIONAL.value) {
                return Language.CHINESE_TRADITIONAL;
            }
            if(value == Language.PORTUGUESE.value) {
                return Language.PORTUGUESE;
            }
            return value == Language.ITALY.value ? Language.ITALY : Language.__UNKNOWN__;
        }
    }

    public static enum LeftRightHandDriveVehicles {
        LEFT(0),
        RIGHT(1),
        __UNKNOWN__(-1);

        public final int value;

        private LeftRightHandDriveVehicles(int value) {
            this.value = value;
        }

        public static LeftRightHandDriveVehicles valueOf(int value) {
            if(value == LeftRightHandDriveVehicles.LEFT.value) {
                return LeftRightHandDriveVehicles.LEFT;
            }
            return value == LeftRightHandDriveVehicles.RIGHT.value ? LeftRightHandDriveVehicles.RIGHT : LeftRightHandDriveVehicles.__UNKNOWN__;
        }
    }

    public static enum MapPreferences {
        NOT_PRESENT(0),
        GAODE(1),
        TENCENT(2),
        __UNKNOWN__(-1);

        public final int value;

        private MapPreferences(int value) {
            this.value = value;
        }

        public static MapPreferences valueOf(int value) {
            if(value == MapPreferences.NOT_PRESENT.value) {
                return MapPreferences.NOT_PRESENT;
            }
            if(value == MapPreferences.GAODE.value) {
                return MapPreferences.GAODE;
            }
            return value == MapPreferences.TENCENT.value ? MapPreferences.TENCENT : MapPreferences.__UNKNOWN__;
        }
    }

    public static enum MediaVolumeDelay {
        THE_0MS(0),
        TWO_HUNDRED_MS(1),
        THREE_HUNDRED_MS(2),
        FOUR_HUNDRED_MS(3),
        FIVE_HUNDRED_MS(4),
        SIX_HUNDRED_MS(5),
        SEVEN_HUNDRED_MS(6),
        EIGHT_HUNDRED_MS(7),
        __UNKNOWN__(-1);

        public final int value;

        private MediaVolumeDelay(int value) {
            this.value = value;
        }

        public static MediaVolumeDelay valueOf(int value) {
            if(value == MediaVolumeDelay.THE_0MS.value) {
                return MediaVolumeDelay.THE_0MS;
            }
            if(value == MediaVolumeDelay.TWO_HUNDRED_MS.value) {
                return MediaVolumeDelay.TWO_HUNDRED_MS;
            }
            if(value == MediaVolumeDelay.THREE_HUNDRED_MS.value) {
                return MediaVolumeDelay.THREE_HUNDRED_MS;
            }
            if(value == MediaVolumeDelay.FOUR_HUNDRED_MS.value) {
                return MediaVolumeDelay.FOUR_HUNDRED_MS;
            }
            if(value == MediaVolumeDelay.FIVE_HUNDRED_MS.value) {
                return MediaVolumeDelay.FIVE_HUNDRED_MS;
            }
            if(value == MediaVolumeDelay.SIX_HUNDRED_MS.value) {
                return MediaVolumeDelay.SIX_HUNDRED_MS;
            }
            if(value == MediaVolumeDelay.SEVEN_HUNDRED_MS.value) {
                return MediaVolumeDelay.SEVEN_HUNDRED_MS;
            }
            return value == MediaVolumeDelay.EIGHT_HUNDRED_MS.value ? MediaVolumeDelay.EIGHT_HUNDRED_MS : MediaVolumeDelay.__UNKNOWN__;
        }
    }

    public static enum MessageNotification {
        NOT_PRESENT(0),
        ON(1),
        OFF(2),
        __UNKNOWN__(-1);

        public final int value;

        private MessageNotification(int value) {
            this.value = value;
        }

        public static MessageNotification valueOf(int value) {
            if(value == MessageNotification.NOT_PRESENT.value) {
                return MessageNotification.NOT_PRESENT;
            }
            if(value == MessageNotification.ON.value) {
                return MessageNotification.ON;
            }
            return value == MessageNotification.OFF.value ? MessageNotification.OFF : MessageNotification.__UNKNOWN__;
        }
    }

    public static enum NavigationSignalMode {
        NOT_PRESENT(0),
        GPS(1),
        BEIDOU(2),
        GPS_BEIDOU(3),
        __UNKNOWN__(-1);

        public final int value;

        private NavigationSignalMode(int value) {
            this.value = value;
        }

        public static NavigationSignalMode valueOf(int value) {
            if(value == NavigationSignalMode.NOT_PRESENT.value) {
                return NavigationSignalMode.NOT_PRESENT;
            }
            if(value == NavigationSignalMode.GPS.value) {
                return NavigationSignalMode.GPS;
            }
            if(value == NavigationSignalMode.BEIDOU.value) {
                return NavigationSignalMode.BEIDOU;
            }
            return value == NavigationSignalMode.GPS_BEIDOU.value ? NavigationSignalMode.GPS_BEIDOU : NavigationSignalMode.__UNKNOWN__;
        }
    }

    public static enum NumberOfScreen {
        TOW(0),
        THREE(1),
        ONE(2),
        __UNKNOWN__(-1);

        public final int value;

        private NumberOfScreen(int value) {
            this.value = value;
        }

        public static NumberOfScreen valueOf(int value) {
            if(value == NumberOfScreen.TOW.value) {
                return NumberOfScreen.TOW;
            }
            if(value == NumberOfScreen.THREE.value) {
                return NumberOfScreen.THREE;
            }
            return value == NumberOfScreen.ONE.value ? NumberOfScreen.ONE : NumberOfScreen.__UNKNOWN__;
        }
    }

    public static enum RadarVolumeAdjustment {
        NOT_PRESENT(0),
        LOW(1),
        MIDDLE(2),
        HIGH(3),
        __UNKNOWN__(-1);

        public final int value;

        private RadarVolumeAdjustment(int value) {
            this.value = value;
        }

        public static RadarVolumeAdjustment valueOf(int value) {
            if(value == RadarVolumeAdjustment.NOT_PRESENT.value) {
                return RadarVolumeAdjustment.NOT_PRESENT;
            }
            if(value == RadarVolumeAdjustment.LOW.value) {
                return RadarVolumeAdjustment.LOW;
            }
            if(value == RadarVolumeAdjustment.MIDDLE.value) {
                return RadarVolumeAdjustment.MIDDLE;
            }
            return value == RadarVolumeAdjustment.HIGH.value ? RadarVolumeAdjustment.HIGH : RadarVolumeAdjustment.__UNKNOWN__;
        }
    }

    public static enum RadioConfiguration {
        NOT_PRESENT(0),
        FM(1),
        AM(2),
        FM_PLUSAM(3),
        __UNKNOWN__(-1);

        public final int value;

        private RadioConfiguration(int value) {
            this.value = value;
        }

        public static RadioConfiguration valueOf(int value) {
            if(value == RadioConfiguration.NOT_PRESENT.value) {
                return RadioConfiguration.NOT_PRESENT;
            }
            if(value == RadioConfiguration.FM.value) {
                return RadioConfiguration.FM;
            }
            if(value == RadioConfiguration.AM.value) {
                return RadioConfiguration.AM;
            }
            return value == RadioConfiguration.FM_PLUSAM.value ? RadioConfiguration.FM_PLUSAM : RadioConfiguration.__UNKNOWN__;
        }
    }

    public static enum RadioDABAndRDSConfig {
        RDS(0),
        DAB_RDS(1),
        DAB(2),
        NOT_PRESENT(3),
        __UNKNOWN__(-1);

        public final int value;

        private RadioDABAndRDSConfig(int value) {
            this.value = value;
        }

        public static RadioDABAndRDSConfig valueOf(int value) {
            if(value == RadioDABAndRDSConfig.NOT_PRESENT.value) {
                return RadioDABAndRDSConfig.NOT_PRESENT;
            }
            if(value == RadioDABAndRDSConfig.DAB_RDS.value) {
                return RadioDABAndRDSConfig.DAB_RDS;
            }
            if(value == RadioDABAndRDSConfig.DAB.value) {
                return RadioDABAndRDSConfig.DAB;
            }
            return value == RadioDABAndRDSConfig.RDS.value ? RadioDABAndRDSConfig.RDS : RadioDABAndRDSConfig.__UNKNOWN__;
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
        AFRICA_2(10),
        __UNKNOWN__(-1);

        public final int value;

        private RadioFrequency(int value) {
            this.value = value;
        }

        public static RadioFrequency valueOf(int value) {
            if(value == RadioFrequency.CHINA_MIDDLEEAST_AFRICA.value) {
                return RadioFrequency.CHINA_MIDDLEEAST_AFRICA;
            }
            if(value == RadioFrequency.EUROPE1.value) {
                return RadioFrequency.EUROPE1;
            }
            if(value == RadioFrequency.EUROPE2.value) {
                return RadioFrequency.EUROPE2;
            }
            if(value == RadioFrequency.EASTERN_EUROPE1.value) {
                return RadioFrequency.EASTERN_EUROPE1;
            }
            if(value == RadioFrequency.EASTERN_EUROPE2.value) {
                return RadioFrequency.EASTERN_EUROPE2;
            }
            if(value == RadioFrequency.AUSTRALIA.value) {
                return RadioFrequency.AUSTRALIA;
            }
            if(value == RadioFrequency.USA.value) {
                return RadioFrequency.USA;
            }
            if(value == RadioFrequency.LATIN_AMERICA.value) {
                return RadioFrequency.LATIN_AMERICA;
            }
            if(value == RadioFrequency.SOUTHEAST_ASIA.value) {
                return RadioFrequency.SOUTHEAST_ASIA;
            }
            if(value == RadioFrequency.JAPAN.value) {
                return RadioFrequency.JAPAN;
            }
            return value == RadioFrequency.AFRICA_2.value ? RadioFrequency.AFRICA_2 : RadioFrequency.__UNKNOWN__;
        }
    }

    public static enum RemindingMaintenanceCycle {
        CLOSE(0),
        OPEN(1),
        __UNKNOWN__(-1);

        public final int value;

        private RemindingMaintenanceCycle(int value) {
            this.value = value;
        }

        public static RemindingMaintenanceCycle valueOf(int value) {
            if(value == RemindingMaintenanceCycle.CLOSE.value) {
                return RemindingMaintenanceCycle.CLOSE;
            }
            return value == RemindingMaintenanceCycle.OPEN.value ? RemindingMaintenanceCycle.OPEN : RemindingMaintenanceCycle.__UNKNOWN__;
        }
    }

    public static enum RemindingResetCycle {
        CLOSE(0),
        OPEN(1),
        __UNKNOWN__(-1);

        public final int value;

        private RemindingResetCycle(int value) {
            this.value = value;
        }

        public static RemindingResetCycle valueOf(int value) {
            if(value == RemindingResetCycle.CLOSE.value) {
                return RemindingResetCycle.CLOSE;
            }
            return value == RemindingResetCycle.OPEN.value ? RemindingResetCycle.OPEN : RemindingResetCycle.__UNKNOWN__;
        }
    }

    public static enum RepeatSetting {
        CLOSE(0),
        OPEN(1),
        __UNKNOWN__(-1);

        public final int value;

        private RepeatSetting(int value) {
            this.value = value;
        }

        public static RepeatSetting valueOf(int value) {
            if(value == RepeatSetting.CLOSE.value) {
                return RepeatSetting.CLOSE;
            }
            return value == RepeatSetting.OPEN.value ? RepeatSetting.OPEN : RepeatSetting.__UNKNOWN__;
        }
    }

    public static enum ScreenSwitchDelay {
        THE_0MS(0),
        TWO_HUNDRED_MS(1),
        THREE_HUNDRED_MS(2),
        FOUR_HUNDRED_MS(3),
        FIVE_HUNDRED_MS(4),
        SIX_HUNDRED_MS(5),
        SEVEN_HUNDRED_MS(6),
        EIGHT_HUNDRED_MS(7),
        __UNKNOWN__(-1);

        public final int value;

        private ScreenSwitchDelay(int value) {
            this.value = value;
        }

        public static ScreenSwitchDelay valueOf(int value) {
            if(value == ScreenSwitchDelay.THE_0MS.value) {
                return ScreenSwitchDelay.THE_0MS;
            }
            if(value == ScreenSwitchDelay.TWO_HUNDRED_MS.value) {
                return ScreenSwitchDelay.TWO_HUNDRED_MS;
            }
            if(value == ScreenSwitchDelay.THREE_HUNDRED_MS.value) {
                return ScreenSwitchDelay.THREE_HUNDRED_MS;
            }
            if(value == ScreenSwitchDelay.FOUR_HUNDRED_MS.value) {
                return ScreenSwitchDelay.FOUR_HUNDRED_MS;
            }
            if(value == ScreenSwitchDelay.FIVE_HUNDRED_MS.value) {
                return ScreenSwitchDelay.FIVE_HUNDRED_MS;
            }
            if(value == ScreenSwitchDelay.SIX_HUNDRED_MS.value) {
                return ScreenSwitchDelay.SIX_HUNDRED_MS;
            }
            if(value == ScreenSwitchDelay.SEVEN_HUNDRED_MS.value) {
                return ScreenSwitchDelay.SEVEN_HUNDRED_MS;
            }
            return value == ScreenSwitchDelay.EIGHT_HUNDRED_MS.value ? ScreenSwitchDelay.EIGHT_HUNDRED_MS : ScreenSwitchDelay.__UNKNOWN__;
        }
    }

    public static enum SdvcCurveConfiguration {
        SVC1(0),
        SVC2(1),
        __UNKNOWN__(-1);

        public final int value;

        private SdvcCurveConfiguration(int value) {
            this.value = value;
        }

        public static SdvcCurveConfiguration valueOf(int value) {
            if(value == SdvcCurveConfiguration.SVC1.value) {
                return SdvcCurveConfiguration.SVC1;
            }
            return value == SdvcCurveConfiguration.SVC2.value ? SdvcCurveConfiguration.SVC2 : SdvcCurveConfiguration.__UNKNOWN__;
        }
    }

    public static enum Usb {
        NOT_PRESENT(0),
        ONE(1),
        TWO(2),
        __UNKNOWN__(-1);

        public final int value;

        private Usb(int value) {
            this.value = value;
        }

        public static Usb valueOf(int value) {
            if(value == Usb.NOT_PRESENT.value) {
                return Usb.NOT_PRESENT;
            }
            if(value == Usb.ONE.value) {
                return Usb.ONE;
            }
            return value == Usb.TWO.value ? Usb.TWO : Usb.__UNKNOWN__;
        }
    }

    public static enum Wifi {
        NOT_PRESENT(0),
        AP_STA_RESPECTIVELY(1),
        AP_STA_SIMULTANEOUSLY(2),
        __UNKNOWN__(-1);

        public final int value;

        private Wifi(int value) {
            this.value = value;
        }

        public static Wifi valueOf(int value) {
            if(value == Wifi.NOT_PRESENT.value) {
                return Wifi.NOT_PRESENT;
            }
            if(value == Wifi.AP_STA_RESPECTIVELY.value) {
                return Wifi.AP_STA_RESPECTIVELY;
            }
            return value == Wifi.AP_STA_SIMULTANEOUSLY.value ? Wifi.AP_STA_SIMULTANEOUSLY : Wifi.__UNKNOWN__;
        }
    }

    public static final int HOST_CONFIG = 9943;

}

