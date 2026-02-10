package com.yftech.vehicle.sdk.config;

import android.util.Log;
import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.CarMode;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.Config;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.EngineeringMode;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.HvacDisplayTime;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.InterfaceSound;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.Keytone;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.Language;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.NumberOfScreen;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.RadarVolumeAdjustment;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.RadioConfiguration;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.RadioDABAndRDSConfig;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.RadioFrequency;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.RemindingMaintenanceCycle;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.RemindingResetCycle;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.RepeatSetting;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.SdvcCurveConfiguration;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.Usb;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig.Wifi;
import com.yftech.vehicle.internal.config.Ihu23IHostConfig;
import java.util.Arrays;

public class Ihu23HostConfig implements Ihu23IHostConfig {
    private static final String TAG = "HostConfig";
    private BaseApiManager mApi;
    private byte[] mData;
    private static Ihu23HostConfig sMe;

    private Ihu23HostConfig() {
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

    private int configValue(Ihu23IHostConfig.Config config) {
        byte[] arr_b = this.configData();
        return arr_b == null || config.byteIndex < 0 || config.byteIndex >= arr_b.length ? -1 : (arr_b[config.byteIndex] & 0xFF & (1 << config.bitSize) - 1 << config.startBit) >> config.startBit;
    }

    private static Ihu23HostConfig get() {
        Ihu23HostConfig ihu23HostConfig0;
        synchronized(Ihu23HostConfig.class) {
            if(Ihu23HostConfig.sMe == null) {
                ihu23HostConfig0 = new Ihu23HostConfig();
                Ihu23HostConfig.sMe = ihu23HostConfig0;
            }
            else {
                ihu23HostConfig0 = Ihu23HostConfig.sMe;
            }
            return ihu23HostConfig0;
        }
    }

    public static Ihu23IHostConfig.CarMode getCarMode() {
        return Ihu23IHostConfig.CarMode.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.CAR_MODE));
    }

    public static byte[] getConfigData() {
        return Ihu23HostConfig.get().configData();
    }

    private static int getConfigValue(Ihu23IHostConfig.Config config) {
        return Ihu23HostConfig.get().configValue(config);
    }

    public static Ihu23IHostConfig.EngineeringMode getEngineeringMode() {
        return Ihu23IHostConfig.EngineeringMode.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.ENGINEERING_MODE));
    }

    public static Ihu23IHostConfig.HvacDisplayTime getHvacDisplayTime() {
        return Ihu23IHostConfig.HvacDisplayTime.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.HVAC_DISPLAY_TIME));
    }

    public static Ihu23IHostConfig.InterfaceSound getInterfaceSound() {
        return Ihu23IHostConfig.InterfaceSound.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.INTERFACE_SOUND));
    }

    public static Ihu23IHostConfig.Keytone getKeytone() {
        return Ihu23IHostConfig.Keytone.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.KEYTONE));
    }

    public static Ihu23IHostConfig.Language getLanguage() {
        return Ihu23IHostConfig.Language.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.LANGUAGE));
    }

    public static int getMediaVolumeDelay() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.MEDIA_VOLUME_DELAY);
    }

    public static Ihu23IHostConfig.NumberOfScreen getNumberOfScreen() {
        return Ihu23IHostConfig.NumberOfScreen.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.NUMBER_OF_SCREEN));
    }

    public static Ihu23IHostConfig.RadarVolumeAdjustment getRadarVolumeAdjustment() {
        return Ihu23IHostConfig.RadarVolumeAdjustment.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.RADAR_VOLUME_ADJUSTMENT));
    }

    public static Ihu23IHostConfig.RadioConfiguration getRadioConfiguration() {
        return Ihu23IHostConfig.RadioConfiguration.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.RADIO_CONFIGURATION));
    }

    public static Ihu23IHostConfig.RadioDABAndRDSConfig getRadioDABAndRDSConfiguration() {
        return Ihu23IHostConfig.RadioDABAndRDSConfig.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.RADIO_DAB_RDS_CONFIGURATION));
    }

    public static Ihu23IHostConfig.RadioFrequency getRadioFrequency() {
        return Ihu23IHostConfig.RadioFrequency.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.RADIO_FREQUENCY));
    }

    public static Ihu23IHostConfig.RemindingMaintenanceCycle getRemindingMaintenanceCycle() {
        return Ihu23IHostConfig.RemindingMaintenanceCycle.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.REMINDING_MAINTENANCE_CYCLE));
    }

    public static Ihu23IHostConfig.RemindingResetCycle getRemindingResetCycle() {
        return Ihu23IHostConfig.RemindingResetCycle.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.REMINDING_RESET_CYCLE));
    }

    public static Ihu23IHostConfig.RepeatSetting getRepeatSetting() {
        return Ihu23IHostConfig.RepeatSetting.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.REPEAT_SETTING));
    }

    public static int getScreenSwitchDelay() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.SCREEN_SWITCH_DELAY);
    }

    public static Ihu23IHostConfig.SdvcCurveConfiguration getSdvcCurveConfiguration() {
        return Ihu23IHostConfig.SdvcCurveConfiguration.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.SDVC_CURVE_CONFIGURATION));
    }

    public static Ihu23IHostConfig.Usb getUsb() {
        return Ihu23IHostConfig.Usb.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.USB));
    }

    public static Ihu23IHostConfig.Wifi getWifi() {
        return Ihu23IHostConfig.Wifi.valueOf(Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.WIFI));
    }

    public static boolean isAndroidAutoPresent() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.ANDROID_AUTO) != 0;
    }

    public static boolean isAuxPresent() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.AUX) != 0;
    }

    public static boolean isBtPresent() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.BT) != 0;
    }

    public static boolean isCarlifePresent() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.CARLIFE) != 0;
    }

    public static boolean isCarplayPresent() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.CARPLAY) != 0;
    }

    public static boolean isCellularNetworkPresent() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.CELLULAR_NETWORK) != 0;
    }

    public static boolean isEthernetNetPresent() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.ETHERNET_NET) != 0;
    }

    public static boolean isFaceIdPresent() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.FACE_ID) != 0;
    }

    public static boolean isIphoneDefaultConnectingPresent() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.IPHONE_DEFAULT_CONNECTING) != 0;
    }

    public static boolean isIpodPresent() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.IPOD) != 0;
    }

    public static boolean isPictureAppPresent() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.PICTURE_APP) != 0;
    }

    public static boolean isRadarSwitchPresent() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.RADAR_SWITCH) != 0;
    }

    public static boolean isScreensaverPresent() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.SCREENSAVER) != 0;
    }

    public static boolean isUserManualPresent() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.USER_MANUAL) != 0;
    }

    public static boolean isVideoAppPresent() {
        return Ihu23HostConfig.getConfigValue(Ihu23IHostConfig.Config.VIDE_APP) != 0;
    }

    public static boolean setConfigData(byte[] data) {
        return Ihu23HostConfig.get().mApi.setSignalValue(9943, data);
    }
}

