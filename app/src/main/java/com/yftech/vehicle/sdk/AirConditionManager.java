package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.IAirCondition.AcDisplayPopup;
import com.yftech.vehicle.internal.adapter.IAirCondition.AirCirculationMode;
import com.yftech.vehicle.internal.adapter.IAirCondition.AirCirculationState;
import com.yftech.vehicle.internal.adapter.IAirCondition.AirQualitySnsConfig;
import com.yftech.vehicle.internal.adapter.IAirCondition.AutoMode;
import com.yftech.vehicle.internal.adapter.IAirCondition.ComfortCurveMode;
import com.yftech.vehicle.internal.adapter.IAirCondition.CupholderAutoMode;
import com.yftech.vehicle.internal.adapter.IAirCondition.CupholderHeatCoolMode;
import com.yftech.vehicle.internal.adapter.IAirCondition.EcoMode;
import com.yftech.vehicle.internal.adapter.IAirCondition.FanSpeed;
import com.yftech.vehicle.internal.adapter.IAirCondition.HumiditySnsDefAutoConfig;
import com.yftech.vehicle.internal.adapter.IAirCondition.IonPopReqDisplay;
import com.yftech.vehicle.internal.adapter.IAirCondition.OnOffByVrState;
import com.yftech.vehicle.internal.adapter.IAirCondition.PM25CleanReqCfg;
import com.yftech.vehicle.internal.adapter.IAirCondition.PM25CleanReqDisplay;
import com.yftech.vehicle.internal.adapter.IAirCondition.SceneDisplay;
import com.yftech.vehicle.internal.adapter.IAirCondition.WindMode;
import com.yftech.vehicle.internal.adapter.IAirCondition.WindSpeed;
import com.yftech.vehicle.internal.adapter.IAirCondition;
import com.yftech.vehicle.internal.adapter.IBaseApi;
import com.yftech.vehicle.internal.adapter.IBaseApi.EnableState;

public class AirConditionManager extends BaseApiManager implements IAirCondition {
    public static abstract class AirConditionListener {
        @SignalReceiver(signalId = 78, valueToEnabledState = true)
        public void onACStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 401)
        public void onAcDisplayPopupChanged(IAirCondition.AcDisplayPopup info) {
        }

        @SignalReceiver(signalId = 85)
        public void onAirCirculationModeOfAutoModeChanged(IAirCondition.AirCirculationMode mode) {
        }

        @SignalReceiver(signalId = 82)
        public void onAirCirculationStateChanged(IAirCondition.AirCirculationState state) {
        }

        @SignalReceiver(signalId = 589)
        public void onAirQualitySnsConfigChanged(IAirCondition.AirQualitySnsConfig config) {
        }

        @SignalReceiver(signalId = 588, valueToEnabledState = true)
        public void onAirQualitySnsStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 0x107)
        public void onAirSelfDryingEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x109)
        public void onAirUnlockVentilationEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = -1, valueToEnabledState = true)
        public void onAutoDeforstPresentStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 83)
        public void onAutoModeChanged(IAirCondition.AutoMode mode) {
        }

        @SignalReceiver(signalId = 0xC2)
        public void onBatCoolStateChanged(float temp) {
        }

        @SignalReceiver(signalId = 0xC0)
        public void onBatFhWorkStateChanged(float temp) {
        }

        @SignalReceiver(signalId = 0xC1)
        public void onBatPtcWorkStateChanged(float temp) {
        }

        @SignalReceiver(signalId = 0xBF, valueToEnabledState = true)
        public void onBodyDisalarmVentStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 86)
        public void onComfortCurveModeChanged(IAirCondition.ComfortCurveMode mode) {
        }

        @SignalReceiver(signalId = 557)
        public void onCupholderAutoModeChanged(IAirCondition.CupholderAutoMode mode) {
        }

        @SignalReceiver(signalId = 555)
        public void onCupholderHeatCoolModeChanged(IAirCondition.CupholderHeatCoolMode mode) {
        }

        @SignalReceiver(signalId = 74)
        public void onDriverTemperatureChanged(float temp) {
        }

        @SignalReceiver(signalId = 680)
        public void onDualCircuStChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 80, valueToEnabledState = true)
        public void onDualSyncStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = -1)
        public void onEcoModeChanged(IAirCondition.EcoMode mode) {
        }

        @SignalReceiver(signalId = 0xC4)
        public void onEnvironmentTemperatureChanged(float temp) {
        }

        @SignalReceiver(signalId = 84)
        public void onFanSpeedOfAutoModeChanged(IAirCondition.FanSpeed speed) {
        }

        @SignalReceiver(signalId = 404, valueToEnabledState = true)
        public void onFrontDefrostStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 0x250)
        public void onHumiditySnsDefAutoConfigChanged(IAirCondition.HumiditySnsDefAutoConfig config) {
        }

        @SignalReceiver(signalId = 0x24F, valueToEnabledState = true)
        public void onHumiditySnsStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 679)
        public void onIonPopReqDisplayChanged(IAirCondition.IonPopReqDisplay display) {
        }

        @SignalReceiver(signalId = 81, valueToEnabledState = true)
        public void onIonStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 419, valueToEnabledState = true)
        public void onOneBtnVentlaionStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 0xC3)
        public void onOutAirQualityLevelChanged(float temp) {
        }

        @SignalReceiver(signalId = 676)
        public void onPM25CleanReqDisplayChanged(IAirCondition.PM25CleanReqDisplay display) {
        }

        @SignalReceiver(signalId = 677, valueToEnabledState = true)
        public void onPM25SnsStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 564)
        public void onPM25ValueChanged(int pm25) {
        }

        @SignalReceiver(signalId = 675, valueToEnabledState = true)
        public void onPM25ValueStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 75)
        public void onPassengerTemperatureChanged(float temp) {
        }

        @SignalReceiver(signalId = -1, valueToEnabledState = true)
        public void onPowerStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 647, valueToEnabledState = true)
        public void onRearACFreezenStateStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 0xE7, valueToEnabledState = true)
        public void onRearAcAutoModeStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 0xEC)
        public void onRearAcTemperatureChanged(float temp) {
        }

        @SignalReceiver(signalId = 0xEE)
        public void onRearAcWindModeChanged(IAirCondition.WindMode mode) {
        }

        @SignalReceiver(signalId = 0xE9)
        public void onRearAcWindSpeedChanged(IAirCondition.WindSpeed speed) {
        }

        @SignalReceiver(signalId = 0x4F, valueToEnabledState = true)
        public void onRearDefrostStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 666)
        public void onSceneDisplayStateChanged(IAirCondition.SceneDisplay scene) {
        }

        @SignalReceiver(signalId = -1)
        public void onWORKINGPOWERChanged(float temp) {
        }

        @SignalReceiver(signalId = 77)
        public void onWindModeChanged(IAirCondition.WindMode mode) {
        }

        @SignalReceiver(signalId = 76)
        public void onWindSpeedChanged(IAirCondition.WindSpeed speed) {
        }
    }

    private static final String TAG = "AirConditionManager";
    private static AirConditionManager sMe;

    public static AirConditionManager get() {
        AirConditionManager airConditionManager0;
        synchronized(AirConditionManager.class) {
            if(AirConditionManager.sMe == null) {
                airConditionManager0 = new AirConditionManager();
                AirConditionManager.sMe = airConditionManager0;
            }
            else {
                airConditionManager0 = AirConditionManager.sMe;
            }
            return airConditionManager0;
        }
    }

    public IAirCondition.AcDisplayPopup getAcDisplayPopup() {
        return IAirCondition.AcDisplayPopup.valueOf(this.getSignalValue(401).intValue());
    }

    public IAirCondition.AirCirculationMode getAirCirculationModeOfAutoMode() {
        return IAirCondition.AirCirculationMode.valueOf(this.getSignalValue(85).intValue());
    }

    public IAirCondition.AirCirculationState getAirCirculationState() {
        return IAirCondition.AirCirculationState.valueOf(this.getSignalValue(82).intValue());
    }

    public IAirCondition.AirQualitySnsConfig getAirQualitySnsConfig() {
        return IAirCondition.AirQualitySnsConfig.valueOf(this.getSignalValue(589).intValue());
    }

    public IBaseApi.EnableState getAirSelfDryingEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0x107).intValue());
    }

    public IBaseApi.EnableState getAirUnlockVentilationEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0x109).intValue());
    }

    public IAirCondition.AutoMode getAutoMode() {
        return IAirCondition.AutoMode.valueOf(this.getSignalValue(83).intValue());
    }

    public float getBatCoolState() {
        return this.getSignalValue(0xC2).floatValue();
    }

    public float getBatFhWorkState() {
        return this.getSignalValue(0xC0).floatValue();
    }

    public float getBatPtcWorkState() {
        return this.getSignalValue(0xC1).floatValue();
    }

    public IAirCondition.ComfortCurveMode getComfortCurveMode() {
        return IAirCondition.ComfortCurveMode.valueOf(this.getSignalValue(86).intValue());
    }

    public IAirCondition.CupholderAutoMode getCupholderAutoMode() {
        return IAirCondition.CupholderAutoMode.valueOf(this.getSignalValue(557).intValue());
    }

    public IAirCondition.CupholderHeatCoolMode getCupholderHeatCoolMode() {
        return IAirCondition.CupholderHeatCoolMode.valueOf(this.getSignalValue(555).intValue());
    }

    public float getDriverTemperature() {
        return this.getSignalValue(74).floatValue();
    }

    public IBaseApi.EnableState getDualCircuSt() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(680).intValue());
    }

    public IAirCondition.EcoMode getEcoMode() {
        return IAirCondition.EcoMode.valueOf(this.getSignalValue(-1).intValue());
    }

    public float getEnvironmentTemperature() {
        return this.getSignalValue(0xC4).floatValue();
    }

    public IAirCondition.FanSpeed getFanSpeedOfAutoMode() {
        return IAirCondition.FanSpeed.valueOf(this.getSignalValue(84).intValue());
    }

    public IAirCondition.HumiditySnsDefAutoConfig getHumiditySnsDefAutoConfig() {
        return IAirCondition.HumiditySnsDefAutoConfig.valueOf(this.getSignalValue(0x250).intValue());
    }

    public IAirCondition.IonPopReqDisplay getIonPopReqDisplay() {
        return IAirCondition.IonPopReqDisplay.valueOf(this.getSignalValue(679).intValue());
    }

    public float getOutAirQualityLevel() {
        return this.getSignalValue(0xC3).floatValue();
    }

    public IAirCondition.PM25CleanReqDisplay getPM25CleanReqDisplay() {
        return IAirCondition.PM25CleanReqDisplay.valueOf(this.getSignalValue(676).intValue());
    }

    public int getPM25Value() {
        return this.getSignalValue(564).intValue();
    }

    public float getPassengerTemperature() {
        return this.getSignalValue(75).floatValue();
    }

    public float getRearAcTemperature() {
        return this.getSignalValue(0xEC).floatValue();
    }

    public IAirCondition.WindMode getRearAcWindMode() {
        return IAirCondition.WindMode.valueOf(this.getSignalValue(0xEE).intValue());
    }

    public IAirCondition.WindSpeed getRearAcWindSpeed() {
        return IAirCondition.WindSpeed.valueOf(this.getSignalValue(0xE9).intValue());
    }

    public IAirCondition.SceneDisplay getSceneDisplayState() {
        return IAirCondition.SceneDisplay.valueOf(this.getSignalValue(666).intValue());
    }

    public float getWORKINGPOWER() {
        return this.getSignalValue(-1).floatValue();
    }

    public IAirCondition.WindMode getWindMode() {
        return IAirCondition.WindMode.valueOf(this.getSignalValue(77).intValue());
    }

    public IAirCondition.WindSpeed getWindSpeed() {
        return IAirCondition.WindSpeed.valueOf(this.getSignalValue(76).intValue());
    }

    public boolean isACEnabled() {
        return this.getSignalValue(78).byteValue() == 1;
    }

    public boolean isAirQualitySnsEnabled() {
        return this.getSignalValue(588).byteValue() == 1;
    }

    public boolean isAutoDeforstPresentEnabled() {
        return this.getSignalValue(-1).byteValue() == 1;
    }

    public boolean isBodyDisalarmVentEnabled() {
        return this.getSignalValue(0xBF).byteValue() == 1;
    }

    public boolean isDualSyncEnabled() {
        return this.getSignalValue(80).byteValue() == 1;
    }

    public boolean isFrontDefrostEnabled() {
        return this.getSignalValue(404).byteValue() == 1;
    }

    public boolean isHumiditySnsEnabled() {
        return this.getSignalValue(0x24F).byteValue() == 1;
    }

    public boolean isIonEnabled() {
        return this.getSignalValue(81).byteValue() == 1;
    }

    public boolean isOneBtnVentlaionEnabled() {
        return this.getSignalValue(419).byteValue() == 1;
    }

    public boolean isPM25SnsEnabled() {
        return this.getSignalValue(677).byteValue() == 1;
    }

    public boolean isPM25ValueEnabled() {
        return this.getSignalValue(675).byteValue() == 1;
    }

    public boolean isPowerEnabled() {
        return this.getSignalValue(-1).byteValue() == 1;
    }

    public boolean isRearACFreezenStateEnabled() {
        return this.getSignalValue(647).byteValue() == 1;
    }

    public boolean isRearAcAutoModeEnabled() {
        return this.getSignalValue(0xE7).byteValue() == 1;
    }

    public boolean isRearDefrostEnabled() {
        return this.getSignalValue(0x4F).byteValue() == 1;
    }

    public boolean performACButtonClick() {
        return this.setSignalValue(6, 1);
    }

    public boolean performAutoButtonClick() {
        return this.setSignalValue(11, 1);
    }

    public boolean performAutoDeforstPresentButtonClick() {
        return this.setSignalValue(-1, 1);
    }

    public boolean performBodyDisalarmVentButtonClick() {
        return this.setSignalValue(-1, 1);
    }

    public boolean performCirculationButtonClick() {
        return this.setSignalValue(10, 1);
    }

    public boolean performDualSyncButtonClick() {
        return this.setSignalValue(8, 1);
    }

    public boolean performFrontDefrostButtonClick() {
        return this.setSignalValue(5, 1);
    }

    public boolean performIonButtonClick() {
        return this.setSignalValue(9, 1);
    }

    public boolean performOffButtonClick() {
        return this.setSignalValue(3, 1);
    }

    public boolean performPowerButtonClick() {
        return this.setSignalValue(-1, 1);
    }

    public boolean performRearAcAutoModeButtonClick() {
        return this.setSignalValue(0xE8, 1);
    }

    public boolean performRearAcOffButtonClick() {
        return this.setSignalValue(0xEB, 1);
    }

    public boolean performRearDefrostButtonClick() {
        return this.setSignalValue(7, 1);
    }

    public boolean performTemperatureDecButtonClick() {
        return this.setSignalValue(434, 1);
    }

    public boolean performTemperatureFRDecButtonClick() {
        return this.setSignalValue(0x20C, 1);
    }

    public boolean performTemperatureFRIncButtonClick() {
        return this.setSignalValue(0x20A, 1);
    }

    public boolean performTemperatureIncButtonClick() {
        return this.setSignalValue(0x1B0, 1);
    }

    public boolean performWindModeButtonClick() {
        return this.setSignalValue(534, 1);
    }

    public boolean performWindSpeedDecButtonClick() {
        return this.setSignalValue(537, 1);
    }

    public boolean performWindSpeedIncButtonClick() {
        return this.setSignalValue(536, 1);
    }

    public void registerListener(AirConditionListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setAirCirculationModeOfAutoMode(IAirCondition.AirCirculationMode mode) {
        return this.setSignalValue(13, mode.value);
    }

    public boolean setAirQualitySnsConfig(IAirCondition.AirQualitySnsConfig config) {
        return this.setSignalValue(590, config.value);
    }

    public boolean setAirSelfDryingEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(0x108, 2) : this.setSignalValue(0x108, 1);
    }

    public boolean setAirUnlockVentilationEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(0x10A, 2) : this.setSignalValue(0x10A, 1);
    }

    public boolean setComfortCurveMode(IAirCondition.ComfortCurveMode mode) {
        return this.setSignalValue(14, mode.value);
    }

    public boolean setCupholderAutoMode(IAirCondition.CupholderAutoMode mode) {
        return this.setSignalValue(558, mode.value);
    }

    public boolean setCupholderHeatCoolMode(IAirCondition.CupholderHeatCoolMode mode) {
        return this.setSignalValue(556, mode.value);
    }

    public boolean setDriverTemperature(float temp) {
        return this.setSignalValue(0, temp);
    }

    public boolean setEcoMode(IAirCondition.EcoMode mode) {
        return this.setSignalValue(-1, mode.value);
    }

    public boolean setFanSpeedOfAutoMode(IAirCondition.FanSpeed speed) {
        return this.setSignalValue(12, speed.value);
    }

    public boolean setHumiditySnsDefAutoConfig(IAirCondition.HumiditySnsDefAutoConfig config) {
        return this.setSignalValue(593, config.value);
    }

    public boolean setOnOffByVrState(IAirCondition.OnOffByVrState state) {
        return this.setSignalValue(445, state.value);
    }

    public boolean setOneBtnVentlaionEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(420, 2) : this.setSignalValue(420, 1);
    }

    public boolean setPM25CleanReqCfg(IAirCondition.PM25CleanReqCfg cfg) {
        return this.setSignalValue(678, cfg.value);
    }

    public boolean setPassengerTemperature(float temp) {
        return this.setSignalValue(1, temp);
    }

    public boolean setRearACFreezenStateEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(648, 2) : this.setSignalValue(648, 1);
    }

    public boolean setRearAcTemperature(float temp) {
        return this.setSignalValue(0xED, temp);
    }

    public boolean setRearAcWindMode(IAirCondition.WindMode mode) {
        return this.setSignalValue(0xEF, mode.value);
    }

    public boolean setRearAcWindSpeed(IAirCondition.WindSpeed speed) {
        return this.setSignalValue(0xEA, speed.value);
    }

    public boolean setTemperatureDecBtnStVDSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(435, 1) : this.setSignalValue(435, 0);
    }

    public boolean setTemperatureFRDecBtnStVDSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(0x20D, 1) : this.setSignalValue(0x20D, 0);
    }

    public boolean setTemperatureFRIncBtnStVDSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(0x20B, 1) : this.setSignalValue(0x20B, 0);
    }

    public boolean setTemperatureIncBtnStVDSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(433, 1) : this.setSignalValue(433, 0);
    }

    public boolean setWindMode(IAirCondition.WindMode mode) {
        return this.setSignalValue(4, mode.value);
    }

    public boolean setWindSpeed(IAirCondition.WindSpeed speed) {
        return this.setSignalValue(2, speed.value);
    }

    public void unregisterListener(AirConditionListener listener) {
        this.unregisterReceiver(listener);
    }
}

