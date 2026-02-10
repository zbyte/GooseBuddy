package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.IBaseApi;
import com.yftech.vehicle.internal.adapter.IBaseApi.EnableState;
import com.yftech.vehicle.internal.adapter.IBaseApi.SwitchStateOp;
import com.yftech.vehicle.internal.adapter.ICarLight.AtmosphereLampDriveMode;
import com.yftech.vehicle.internal.adapter.ICarLight.AtmosphereLampWorkMode;
import com.yftech.vehicle.internal.adapter.ICarLight.HeadLightVirtualSwitch;
import com.yftech.vehicle.internal.adapter.ICarLight.LightShowFunCmd;
import com.yftech.vehicle.internal.adapter.ICarLight.LightShowMode;
import com.yftech.vehicle.internal.adapter.ICarLight.MainLampSwitchSt;
import com.yftech.vehicle.internal.adapter.ICarLight.WelLightMode;
import com.yftech.vehicle.internal.adapter.ICarLight;

public class CarLightManager extends BaseApiManager implements ICarLight {
    public static abstract class CarLightListener {
        @SignalReceiver(signalId = 553)
        public void onADBEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 651)
        public void onAtmosphereDriveModeLampColorChanged(int color) {
        }

        @SignalReceiver(signalId = 275)
        public void onAtmosphereLampBrightnessChanged(int brightness) {
        }

        @SignalReceiver(signalId = 277)
        public void onAtmosphereLampColorChanged(int color) {
        }

        @SignalReceiver(signalId = 619)
        public void onAtmosphereLampDriveModeChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 281)
        public void onAtmosphereLampMusicModeEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 279)
        public void onAtmosphereLampWorkModeChanged(ICarLight.AtmosphereLampWorkMode mode) {
        }

        @SignalReceiver(signalId = 0x1EF)
        public void onAutoHoldLightEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 609)
        public void onAutoWelLightEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0xC6, valueToEnabledState = true)
        public void onBrakeLampStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 699)
        public void onDRLLightEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 701)
        public void onDRLLightValidStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 657)
        public void onDriverModeMusicModeCfgChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0xB2)
        public void onHeadLightDelayEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0xB1)
        public void onIHBCEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0xC7, valueToEnabledState = true)
        public void onILBCStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 0x1FF)
        public void onLightShowMainLampSwitchStChanged(ICarLight.MainLampSwitchSt state) {
        }

        @SignalReceiver(signalId = 508)
        public void onLightShowModeChanged(ICarLight.LightShowMode mode) {
        }

        @SignalReceiver(signalId = 209, valueToEnabledState = true)
        public void onLowLightStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 0x106, valueToEnabledState = true)
        public void onSmallLightStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 659)
        public void onTechGlassLightChooseChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 220, valueToEnabledState = true)
        public void onTopLightStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 0x1F1)
        public void onWelLightEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x1F3)
        public void onWelLightModeChanged(ICarLight.WelLightMode mode) {
        }
    }

    private static final String TAG = "CarLightManager";
    private static CarLightManager sMe;

    public static CarLightManager get() {
        CarLightManager carLightManager0;
        synchronized(CarLightManager.class) {
            if(CarLightManager.sMe == null) {
                carLightManager0 = new CarLightManager();
                CarLightManager.sMe = carLightManager0;
            }
            else {
                carLightManager0 = CarLightManager.sMe;
            }
            return carLightManager0;
        }
    }

    public IBaseApi.EnableState getADBEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(553).intValue());
    }

    public int getAtmosphereDriveModeLampColor() {
        return this.getSignalValue(651).intValue();
    }

    public int getAtmosphereLampBrightness() {
        return this.getSignalValue(275).intValue();
    }

    public int getAtmosphereLampColor() {
        return this.getSignalValue(277).intValue();
    }

    public IBaseApi.EnableState getAtmosphereLampDriveMode() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(619).intValue());
    }

    public IBaseApi.EnableState getAtmosphereLampMusicModeEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(281).intValue());
    }

    public ICarLight.AtmosphereLampWorkMode getAtmosphereLampWorkMode() {
        return ICarLight.AtmosphereLampWorkMode.valueOf(this.getSignalValue(279).intValue());
    }

    public IBaseApi.EnableState getAutoHoldLightEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0x1EF).intValue());
    }

    public IBaseApi.EnableState getAutoWelLightEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(609).intValue());
    }

    public IBaseApi.EnableState getDRLLightEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(699).intValue());
    }

    public IBaseApi.EnableState getDRLLightValidState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(701).intValue());
    }

    public IBaseApi.EnableState getDriverModeMusicModeCfg() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(657).intValue());
    }

    public IBaseApi.EnableState getHeadLightDelayEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0xB2).intValue());
    }

    public IBaseApi.EnableState getIHBCEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0xB1).intValue());
    }

    public ICarLight.MainLampSwitchSt getLightShowMainLampSwitchSt() {
        return ICarLight.MainLampSwitchSt.valueOf(this.getSignalValue(0x1FF).intValue());
    }

    public ICarLight.LightShowMode getLightShowMode() {
        return ICarLight.LightShowMode.valueOf(this.getSignalValue(508).intValue());
    }

    public IBaseApi.EnableState getTechGlassLightChoose() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(659).intValue());
    }

    public IBaseApi.EnableState getWelLightEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0x1F1).intValue());
    }

    public ICarLight.WelLightMode getWelLightMode() {
        return ICarLight.WelLightMode.valueOf(this.getSignalValue(0x1F3).intValue());
    }

    public boolean isBrakeLampEnabled() {
        return this.getSignalValue(0xC6).byteValue() == 1;
    }

    public boolean isILBCEnabled() {
        return this.getSignalValue(0xC7).byteValue() == 1;
    }

    public boolean isLowLightEnabled() {
        return this.getSignalValue(209).byteValue() == 1;
    }

    public boolean isSmallLightEnabled() {
        return this.getSignalValue(0x106).byteValue() == 1;
    }

    public boolean isTopLightEnabled() {
        return this.getSignalValue(220).byteValue() == 1;
    }

    public void registerListener(CarLightListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setADBEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(554, 2) : this.setSignalValue(554, 1);
    }

    public boolean setAtmosphereDriveModeLampColor(int color) {
        return this.setSignalValue(652, color);
    }

    public boolean setAtmosphereLampBrightness(int brightness) {
        return this.setSignalValue(276, brightness);
    }

    public boolean setAtmosphereLampColor(int color) {
        return this.setSignalValue(278, color);
    }

    public boolean setAtmosphereLampDriveMode(ICarLight.AtmosphereLampDriveMode mode) {
        return this.setSignalValue(0x26F, mode.value);
    }

    public boolean setAtmosphereLampDriveModeEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(280, 2) : this.setSignalValue(280, 1);
    }

    public boolean setAtmosphereLampMusicMode(IBaseApi.SwitchStateOp enabled) {
        return this.setSignalValue(661, enabled.value);
    }

    public boolean setAtmosphereLampMusicModeEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(282, 1) : this.setSignalValue(282, 2);
    }

    public boolean setAtmosphereLampStateEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(274, 1) : this.setSignalValue(274, 2);
    }

    public boolean setAtmosphereLampWorkMode(ICarLight.AtmosphereLampWorkMode mode) {
        return this.setSignalValue(0x15F, mode.value);
    }

    public boolean setAutoHoldLightFunCfgEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(0x1F0, 2) : this.setSignalValue(0x1F0, 1);
    }

    public boolean setAutoWelLightEnableStateEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(608, 2) : this.setSignalValue(608, 1);
    }

    public boolean setDRLLightFunCfgEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(700, 2) : this.setSignalValue(700, 1);
    }

    public boolean setDriverModeMusicModeCfg(IBaseApi.SwitchStateOp enabled) {
        return this.setSignalValue(658, enabled.value);
    }

    public boolean setFrontFogLightSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(728, 1) : this.setSignalValue(728, 0);
    }

    public boolean setHeadLightDelayEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(70, 2) : this.setSignalValue(70, 1);
    }

    public boolean setHeadLightVirtualSwitch(ICarLight.HeadLightVirtualSwitch option) {
        return this.setSignalValue(718, option.value);
    }

    public boolean setIHBCEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(69, 2) : this.setSignalValue(69, 1);
    }

    public boolean setILBCEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(200, 2) : this.setSignalValue(200, 1);
    }

    public boolean setLightShowFunCmd(ICarLight.LightShowFunCmd cmd) {
        return this.setSignalValue(507, cmd.value);
    }

    public boolean setLightShowMode(ICarLight.LightShowMode mode) {
        return this.setSignalValue(509, mode.value);
    }

    public boolean setLightShowTime(int second) {
        return this.setSignalValue(510, second);
    }

    public boolean setRearFogLightSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(729, 1) : this.setSignalValue(729, 0);
    }

    public boolean setTechGlassLightChoose(IBaseApi.SwitchStateOp enabled) {
        return this.setSignalValue(660, enabled.value);
    }

    public boolean setTopLightAllCtrlEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(0x23F, 2) : this.setSignalValue(0x23F, 1);
    }

    public boolean setTopLightEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(0xDD, 2) : this.setSignalValue(0xDD, 1);
    }

    public boolean setWelLightFunCfgEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(0x1F2, 2) : this.setSignalValue(0x1F2, 1);
    }

    public boolean setWelLightMode(ICarLight.WelLightMode mode) {
        return this.setSignalValue(500, mode.value);
    }

    public void unregisterListener(CarLightListener listener) {
        this.unregisterReceiver(listener);
    }
}

