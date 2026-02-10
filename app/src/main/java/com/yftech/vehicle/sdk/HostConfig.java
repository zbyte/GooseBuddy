package com.yftech.vehicle.sdk;

import android.util.Log;
import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.adapter.IHostConfig.CarMode;
import com.yftech.vehicle.internal.adapter.IHostConfig.Config;
import com.yftech.vehicle.internal.adapter.IHostConfig.EngineeringMode;
import com.yftech.vehicle.internal.adapter.IHostConfig.ExpressMessage;
import com.yftech.vehicle.internal.adapter.IHostConfig.HvacDisplayTime;
import com.yftech.vehicle.internal.adapter.IHostConfig.InterfaceSound;
import com.yftech.vehicle.internal.adapter.IHostConfig.Keytone;
import com.yftech.vehicle.internal.adapter.IHostConfig.Language;
import com.yftech.vehicle.internal.adapter.IHostConfig.LeftRightHandDriveVehicles;
import com.yftech.vehicle.internal.adapter.IHostConfig.MapPreferences;
import com.yftech.vehicle.internal.adapter.IHostConfig.MediaVolumeDelay;
import com.yftech.vehicle.internal.adapter.IHostConfig.MessageNotification;
import com.yftech.vehicle.internal.adapter.IHostConfig.NavigationSignalMode;
import com.yftech.vehicle.internal.adapter.IHostConfig.NumberOfScreen;
import com.yftech.vehicle.internal.adapter.IHostConfig.RadarVolumeAdjustment;
import com.yftech.vehicle.internal.adapter.IHostConfig.RadioConfiguration;
import com.yftech.vehicle.internal.adapter.IHostConfig.RadioDABAndRDSConfig;
import com.yftech.vehicle.internal.adapter.IHostConfig.RadioFrequency;
import com.yftech.vehicle.internal.adapter.IHostConfig.RemindingMaintenanceCycle;
import com.yftech.vehicle.internal.adapter.IHostConfig.RemindingResetCycle;
import com.yftech.vehicle.internal.adapter.IHostConfig.RepeatSetting;
import com.yftech.vehicle.internal.adapter.IHostConfig.ScreenSwitchDelay;
import com.yftech.vehicle.internal.adapter.IHostConfig.SdvcCurveConfiguration;
import com.yftech.vehicle.internal.adapter.IHostConfig.Usb;
import com.yftech.vehicle.internal.adapter.IHostConfig.Wifi;
import com.yftech.vehicle.internal.adapter.IHostConfig;
import java.util.Arrays;

public class HostConfig implements IHostConfig {
    private static final String TAG = "HostConfig";
    private BaseApiManager mApi;
    private byte[] mData;
    private static HostConfig sMe;

    private HostConfig() {
        this.mApi = new BaseApiManager() {
        };
    }

    private byte[] configData() {
        if(this.mData == null || this.mData.length < 1) {
            this.mData = this.mApi.getSignalDataValue(9943);
            Log.i("HostConfig", "configData() mData=" + (this.mData == null ? "[]" : Arrays.toString(this.mData)));
        }
        return this.mData;
    }

    private int configValue(IHostConfig.Config config) {
        byte[] arr_b = this.configData();
        return arr_b == null || config.byteIndex < 0 || config.byteIndex >= arr_b.length ? -1 : (arr_b[config.byteIndex] & 0xFF & (1 << config.bitSize) - 1 << config.startBit) >> config.startBit;
    }

    private static HostConfig get() {
        HostConfig hostConfig0;
        synchronized(HostConfig.class) {
            if(HostConfig.sMe == null) {
                hostConfig0 = new HostConfig();
                HostConfig.sMe = hostConfig0;
            }
            else {
                hostConfig0 = HostConfig.sMe;
            }
            return hostConfig0;
        }
    }

    public static IHostConfig.CarMode getCarMode() {
        return IHostConfig.CarMode.valueOf(HostConfig.getConfigValue(IHostConfig.Config.CAR_MODE));
    }

    public static byte[] getConfigData() {
        return HostConfig.get().configData();
    }

    private static int getConfigValue(IHostConfig.Config config) {
        return HostConfig.get().configValue(config);
    }

    public static IHostConfig.EngineeringMode getEngineeringMode() {
        return IHostConfig.EngineeringMode.valueOf(HostConfig.getConfigValue(IHostConfig.Config.ENGINEERING_MODE));
    }

    public static IHostConfig.ExpressMessage getExpressMessage() {
        return IHostConfig.ExpressMessage.valueOf(HostConfig.getConfigValue(IHostConfig.Config.EXPRESS_MESSAGE));
    }

    public static IHostConfig.HvacDisplayTime getHvacDisplayTime() {
        return IHostConfig.HvacDisplayTime.valueOf(HostConfig.getConfigValue(IHostConfig.Config.HVAC_DISPLAY_TIME));
    }

    public static IHostConfig.InterfaceSound getInterfaceSound() {
        return IHostConfig.InterfaceSound.valueOf(HostConfig.getConfigValue(IHostConfig.Config.INTERFACE_SOUND));
    }

    public static IHostConfig.Keytone getKeytone() {
        return IHostConfig.Keytone.valueOf(HostConfig.getConfigValue(IHostConfig.Config.KEYTONE));
    }

    public static IHostConfig.Language getLanguage() {
        return IHostConfig.Language.valueOf(HostConfig.getConfigValue(IHostConfig.Config.LANGUAGE));
    }

    public static IHostConfig.LeftRightHandDriveVehicles getLeftRightHandDriveVehicles() {
        return IHostConfig.LeftRightHandDriveVehicles.valueOf(HostConfig.getConfigValue(IHostConfig.Config.LEFT_RIGHT_HAND_DRIVE_VEHICLES));
    }

    public static IHostConfig.MapPreferences getMapPreferences() {
        return IHostConfig.MapPreferences.valueOf(HostConfig.getConfigValue(IHostConfig.Config.MAP_PREFERENCES));
    }

    public static IHostConfig.MediaVolumeDelay getMediaVolumeDelay() {
        return IHostConfig.MediaVolumeDelay.valueOf(HostConfig.getConfigValue(IHostConfig.Config.MEDIA_VOLUME_DELAY));
    }

    public static IHostConfig.MessageNotification getMessageNotification() {
        return IHostConfig.MessageNotification.valueOf(HostConfig.getConfigValue(IHostConfig.Config.MESSAGE_NOTIFICATION));
    }

    public static IHostConfig.NavigationSignalMode getNavigationSignalMode() {
        return IHostConfig.NavigationSignalMode.valueOf(HostConfig.getConfigValue(IHostConfig.Config.NAVIGATION_SIGNAL_MODE));
    }

    public static IHostConfig.NumberOfScreen getNumberOfScreen() {
        return IHostConfig.NumberOfScreen.valueOf(HostConfig.getConfigValue(IHostConfig.Config.NUMBER_OF_SCREEN));
    }

    public static IHostConfig.RadarVolumeAdjustment getRadarVolumeAdjustment() {
        return IHostConfig.RadarVolumeAdjustment.valueOf(HostConfig.getConfigValue(IHostConfig.Config.RADAR_VOLUME_ADJUSTMENT));
    }

    public static IHostConfig.RadioConfiguration getRadioConfiguration() {
        return IHostConfig.RadioConfiguration.valueOf(HostConfig.getConfigValue(IHostConfig.Config.RADIO_CONFIGURATION));
    }

    public static IHostConfig.RadioDABAndRDSConfig getRadioDABAndRDSConfiguration() {
        return IHostConfig.RadioDABAndRDSConfig.valueOf(HostConfig.getConfigValue(IHostConfig.Config.RADIO_DAB_RDS_CONFIGURATION));
    }

    public static IHostConfig.RadioFrequency getRadioFrequency() {
        return IHostConfig.RadioFrequency.valueOf(HostConfig.getConfigValue(IHostConfig.Config.RADIO_FREQUENCY));
    }

    public static IHostConfig.RemindingMaintenanceCycle getRemindingMaintenanceCycle() {
        return IHostConfig.RemindingMaintenanceCycle.valueOf(HostConfig.getConfigValue(IHostConfig.Config.REMINDING_MAINTENANCE_CYCLE));
    }

    public static IHostConfig.RemindingResetCycle getRemindingResetCycle() {
        return IHostConfig.RemindingResetCycle.valueOf(HostConfig.getConfigValue(IHostConfig.Config.REMINDING_RESET_CYCLE));
    }

    public static IHostConfig.RepeatSetting getRepeatSetting() {
        return IHostConfig.RepeatSetting.valueOf(HostConfig.getConfigValue(IHostConfig.Config.REPEAT_SETTING));
    }

    public static IHostConfig.ScreenSwitchDelay getScreenSwitchDelay() {
        return IHostConfig.ScreenSwitchDelay.valueOf(HostConfig.getConfigValue(IHostConfig.Config.SCREEN_SWITCH_DELAY));
    }

    public static IHostConfig.SdvcCurveConfiguration getSdvcCurveConfiguration() {
        return IHostConfig.SdvcCurveConfiguration.valueOf(HostConfig.getConfigValue(IHostConfig.Config.SDVC_CURVE_CONFIGURATION));
    }

    public static IHostConfig.Usb getUsb() {
        return IHostConfig.Usb.valueOf(HostConfig.getConfigValue(IHostConfig.Config.USB));
    }

    public static IHostConfig.Wifi getWifi() {
        return IHostConfig.Wifi.valueOf(HostConfig.getConfigValue(IHostConfig.Config.WIFI));
    }

    public static boolean isAndroidAutoPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.ANDROID_AUTO) != 0;
    }

    public static boolean isAutoParkingBackgroundPushPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.AUTO_PARKING_BACKGROUND_PUSH) != 0;
    }

    public static boolean isAuxPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.AUX) != 0;
    }

    public static boolean isBtPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.BT) != 0;
    }

    public static boolean isCarLinkPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.CAR_LINK) != 0;
    }

    public static boolean isCarlifePresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.CARLIFE) != 0;
    }

    public static boolean isCarplayPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.CARPLAY) != 0;
    }

    public static boolean isCellularNetworkPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.CELLULAR_NETWORK) != 0;
    }

    public static boolean isEasyConnectPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.EASY_CONNECT) != 0;
    }

    public static boolean isEthernetNetPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.ETHERNET_NET) != 0;
    }

    public static boolean isFaceIdPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.FACE_ID) != 0;
    }

    public static boolean isHicarPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.HICAR) != 0;
    }

    public static boolean isIphoneDefaultConnectingPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.IPHONE_DEFAULT_CONNECTING) != 0;
    }

    public static boolean isIpodPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.IPOD) != 0;
    }

    public static boolean isPhotosAndVideosPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.PHOTOS_AND_VIDEOS) == 0;
    }

    public static boolean isRadarSwitchPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.RADAR_SWITCH) != 0;
    }

    public static boolean isRadioDABPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.RADIO_DAB) != 0;
    }

    public static boolean isRadioRDSPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.RADIO_RDS) != 0;
    }

    public static boolean isSceneSwitchPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.SCENE_SWITCH) != 0;
    }

    public static boolean isScreensaverPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.SCREENSAVER) != 0;
    }

    public static boolean isShiftSoundPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.SHIFT_SOUND) != 0;
    }

    public static boolean isTrafficDisplayPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.TRAFFIC_DISPLAY) != 0;
    }

    public static boolean isUserManualPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.USER_MANUAL) != 0;
    }

    public static boolean isWallpaperPresent() {
        return HostConfig.getConfigValue(IHostConfig.Config.WALLPAPER) != 0;
    }

    public static boolean setConfigData(byte[] data) {
        return HostConfig.get().mApi.setSignalValue(9943, data);
    }
}

