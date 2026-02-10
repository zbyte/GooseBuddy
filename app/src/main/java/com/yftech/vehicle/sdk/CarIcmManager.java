package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.IBaseApi;
import com.yftech.vehicle.internal.adapter.IBaseApi.EnableState;
import com.yftech.vehicle.internal.adapter.IBaseApi.SwitchStateOp;
import com.yftech.vehicle.internal.adapter.ICarIcm.BackLightLevel;
import com.yftech.vehicle.internal.adapter.ICarIcm.CurrentSource;
import com.yftech.vehicle.internal.adapter.ICarIcm.FuelEconomyAndDistanceUnit;
import com.yftech.vehicle.internal.adapter.ICarIcm.ICMCurrentShowPage;
import com.yftech.vehicle.internal.adapter.ICarIcm.ICMShowPageSetting;
import com.yftech.vehicle.internal.adapter.ICarIcm.Language;
import com.yftech.vehicle.internal.adapter.ICarIcm.MeterVolumeMode;
import com.yftech.vehicle.internal.adapter.ICarIcm.PressureUnit;
import com.yftech.vehicle.internal.adapter.ICarIcm.TemperatureUnit;
import com.yftech.vehicle.internal.adapter.ICarIcm;

public class CarIcmManager extends BaseApiManager implements ICarIcm {
    public static abstract class CarIcmListener {
        @SignalReceiver(signalId = 0x72)
        public void onBackLightLevelChanged(ICarIcm.BackLightLevel level) {
        }

        @SignalReceiver(signalId = 713)
        public void onDriveDistanceChanged(int distance) {
        }

        @SignalReceiver(signalId = 0x77)
        public void onFuelEconomyAndDistanceUnitChanged(ICarIcm.FuelEconomyAndDistanceUnit unit) {
        }

        @SignalReceiver(signalId = 0x28F)
        public void onICMCurrentShowPageChanged(ICarIcm.ICMCurrentShowPage page) {
        }

        @SignalReceiver(signalId = 711)
        public void onICMFuelLevelChanged(float percent) {
        }

        @SignalReceiver(signalId = 712)
        public void onICMFuelLevelLowChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 120, valueToEnabledState = true)
        public void onKeepMuteWarningStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 0xE2)
        public void onKeyBoardBackLightChanged(int percent) {
        }

        @SignalReceiver(signalId = 0x76)
        public void onLanguageChanged(ICarIcm.Language lang) {
        }

        @SignalReceiver(signalId = 0x102)
        public void onMeterVolumeModeChanged(ICarIcm.MeterVolumeMode mode) {
        }

        @SignalReceiver(signalId = 0x74)
        public void onPressureUnitChanged(ICarIcm.PressureUnit unit) {
        }

        @SignalReceiver(signalId = 606)
        public void onRearSeatBeltWarnChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0x75)
        public void onSpeedWarningChanged(int speed) {
        }

        @SignalReceiver(signalId = 0x73)
        public void onTemperatureUnitChanged(ICarIcm.TemperatureUnit unit) {
        }
    }

    private static final String TAG = "CarIcmManager";
    private static CarIcmManager sMe;

    public static CarIcmManager get() {
        CarIcmManager carIcmManager0;
        synchronized(CarIcmManager.class) {
            if(CarIcmManager.sMe == null) {
                carIcmManager0 = new CarIcmManager();
                CarIcmManager.sMe = carIcmManager0;
            }
            else {
                carIcmManager0 = CarIcmManager.sMe;
            }
            return carIcmManager0;
        }
    }

    public ICarIcm.BackLightLevel getBackLightLevel() {
        return ICarIcm.BackLightLevel.valueOf(this.getSignalValue(0x72).intValue());
    }

    public int getDriveDistance() {
        return this.getSignalValue(713).intValue();
    }

    public ICarIcm.FuelEconomyAndDistanceUnit getFuelEconomyAndDistanceUnit() {
        return ICarIcm.FuelEconomyAndDistanceUnit.valueOf(this.getSignalValue(0x77).intValue());
    }

    public ICarIcm.ICMCurrentShowPage getICMCurrentShowPage() {
        return ICarIcm.ICMCurrentShowPage.valueOf(this.getSignalValue(0x28F).intValue());
    }

    public float getICMFuelLevel() {
        return this.getSignalValue(711).floatValue();
    }

    public IBaseApi.EnableState getICMFuelLevelLow() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(712).intValue());
    }

    public int getKeyBoardBackLight() {
        return this.getSignalValue(0xE2).intValue();
    }

    public ICarIcm.Language getLanguage() {
        return ICarIcm.Language.valueOf(this.getSignalValue(0x76).intValue());
    }

    public ICarIcm.MeterVolumeMode getMeterVolumeMode() {
        return ICarIcm.MeterVolumeMode.valueOf(this.getSignalValue(0x102).intValue());
    }

    public ICarIcm.PressureUnit getPressureUnit() {
        return ICarIcm.PressureUnit.valueOf(this.getSignalValue(0x74).intValue());
    }

    public IBaseApi.EnableState getRearSeatBeltWarn() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(606).intValue());
    }

    public int getSpeedWarning() {
        return this.getSignalValue(0x75).intValue();
    }

    public ICarIcm.TemperatureUnit getTemperatureUnit() {
        return ICarIcm.TemperatureUnit.valueOf(this.getSignalValue(0x73).intValue());
    }

    public boolean isKeepMuteWarningEnabled() {
        return this.getSignalValue(120).byteValue() == 1;
    }

    public void registerListener(CarIcmListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setBackLightLevel(ICarIcm.BackLightLevel level) {
        return this.setSignalValue(0xDB, level.value);
    }

    public boolean setCurrentSource(ICarIcm.CurrentSource source) {
        return this.setSignalValue(626, source.value);
    }

    public boolean setFMFreqSymbol(int symbol) {
        return this.setSignalValue(533, symbol);
    }

    public boolean setFuelEconomyAndDistanceUnit(ICarIcm.FuelEconomyAndDistanceUnit unit) {
        return this.setSignalValue(51, unit.value);
    }

    public boolean setICMShowPage(ICarIcm.ICMShowPageSetting page) {
        return this.setSignalValue(0x290, page.value);
    }

    public boolean setLanguage(ICarIcm.Language lang) {
        return this.setSignalValue(50, lang.value);
    }

    public boolean setMeterVolumeMode(ICarIcm.MeterVolumeMode mode) {
        return this.setSignalValue(0x103, mode.value);
    }

    public boolean setPressureUnit(ICarIcm.PressureUnit unit) {
        return this.setSignalValue(0x30, unit.value);
    }

    public boolean setRearSeatBeltWarn(IBaseApi.SwitchStateOp enabled) {
        return this.setSignalValue(663, enabled.value);
    }

    public boolean setRearSeatBeltWarnEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(607, 2) : this.setSignalValue(607, 1);
    }

    public boolean setSpeedWarning(int speed) {
        return this.setSignalValue(49, speed);
    }

    public boolean setTemperatureUnit(ICarIcm.TemperatureUnit unit) {
        return this.setSignalValue(0x2F, unit.value);
    }

    public void unregisterListener(CarIcmListener listener) {
        this.unregisterReceiver(listener);
    }
}

