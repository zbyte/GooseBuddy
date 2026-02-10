package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.ICarInfo.CarReadyIndicator;
import com.yftech.vehicle.internal.adapter.ICarInfo.DayNightMode;
import com.yftech.vehicle.internal.adapter.ICarInfo.EngineCrankState;
import com.yftech.vehicle.internal.adapter.ICarInfo.GearPosition;
import com.yftech.vehicle.internal.adapter.ICarInfo.GearPositionA9E;
import com.yftech.vehicle.internal.adapter.ICarInfo.GearPositionHEV;
import com.yftech.vehicle.internal.adapter.ICarInfo.LowBatteryWarningLevel;
import com.yftech.vehicle.internal.adapter.ICarInfo.ParkingBrakeState;
import com.yftech.vehicle.internal.adapter.ICarInfo.PowerMode;
import com.yftech.vehicle.internal.adapter.ICarInfo.RearGearState;
import com.yftech.vehicle.internal.adapter.ICarInfo.SleepWakeUpCommand;
import com.yftech.vehicle.internal.adapter.ICarInfo.VehicleModeBroadcast;
import com.yftech.vehicle.internal.adapter.ICarInfo.VehicleState;
import com.yftech.vehicle.internal.adapter.ICarInfo;

public class CarInfoManager extends BaseApiManager implements ICarInfo {
    public static abstract class CarInfoListener {
        @SignalReceiver(signalId = 0x7C)
        public void onBatteryVoltageChanged(float voltage) {
        }

        @SignalReceiver(signalId = 705)
        public void onCarReadyIndicatorChanged(ICarInfo.CarReadyIndicator indicator) {
        }

        @SignalReceiver(signalId = 0xBB)
        public void onDayNightModeChanged(ICarInfo.DayNightMode mode) {
        }

        @SignalReceiver(signalId = 407)
        public void onEngineCrankStateChanged(ICarInfo.EngineCrankState state) {
        }

        @SignalReceiver(signalId = 443)
        public void onEngineIgnAngleChanged(float value) {
        }

        @SignalReceiver(signalId = 0x79)
        public void onEngineSpeedChanged(int speed) {
        }

        @SignalReceiver(signalId = 0x19F)
        public void onGearPositionA9EChanged(ICarInfo.GearPositionA9E gear) {
        }

        @SignalReceiver(signalId = 0xB9)
        public void onGearPositionChanged(ICarInfo.GearPosition gear) {
        }

        @SignalReceiver(signalId = 664)
        public void onGearPositionHEVChanged(ICarInfo.GearPositionHEV gear) {
        }

        @SignalReceiver(signalId = 0x7D)
        public void onLowBatteryWarningLevelChanged(ICarInfo.LowBatteryWarningLevel level) {
        }

        @SignalReceiver(signalId = 201)
        public void onParkingBrakeStateChanged(ICarInfo.ParkingBrakeState state) {
        }

        @SignalReceiver(signalId = 0xB6)
        public void onPowerModeChanged(ICarInfo.PowerMode mode) {
        }

        @SignalReceiver(signalId = 437)
        public void onPressureOfAtmosphericChanged(int value) {
        }

        @SignalReceiver(signalId = 438)
        public void onPressureOfOilChanged(int value) {
        }

        @SignalReceiver(signalId = 436)
        public void onPressureOfTurbineChanged(int value) {
        }

        @SignalReceiver(signalId = 0xB8)
        public void onRearGearStateChanged(ICarInfo.RearGearState state) {
        }

        @SignalReceiver(signalId = -1)
        public void onSleepWakeUpCommandChanged(ICarInfo.SleepWakeUpCommand cmd) {
        }

        @SignalReceiver(signalId = 439)
        public void onTemperatureOfEngineWaterChanged(int value) {
        }

        @SignalReceiver(signalId = 440)
        public void onTemperatureOfExhaustChanged(int value) {
        }

        @SignalReceiver(signalId = 441)
        public void onTemperatureOfIntakeAirChanged(float value) {
        }

        @SignalReceiver(signalId = 442)
        public void onTemperatureOfTransmissionOilChanged(int value) {
        }

        @SignalReceiver(signalId = 0x7B)
        public void onTotalOdometerChanged(int total) {
        }

        @SignalReceiver(signalId = 369, valueToEnabledState = true)
        public void onTransportationModeStateChanged(boolean isEnabled) {
        }

        @SignalReceiver(signalId = 0x170)
        public void onVehicleModeBroadcastChanged(ICarInfo.VehicleModeBroadcast mode) {
        }

        @SignalReceiver(signalId = 0x7A)
        public void onVehicleSpeedChanged(int speed) {
        }

        @SignalReceiver(signalId = 0xBA)
        public void onVehicleStateChanged(ICarInfo.VehicleState state) {
        }
    }

    private static final String TAG = "CarInfoManager";
    private static CarInfoManager sMe;

    public static CarInfoManager get() {
        CarInfoManager carInfoManager0;
        synchronized(CarInfoManager.class) {
            if(CarInfoManager.sMe == null) {
                carInfoManager0 = new CarInfoManager();
                CarInfoManager.sMe = carInfoManager0;
            }
            else {
                carInfoManager0 = CarInfoManager.sMe;
            }
            return carInfoManager0;
        }
    }

    public float getBatteryVoltage() {
        return this.getSignalValue(0x7C).floatValue();
    }

    public ICarInfo.CarReadyIndicator getCarReadyIndicator() {
        return ICarInfo.CarReadyIndicator.valueOf(this.getSignalValue(705).intValue());
    }

    public ICarInfo.DayNightMode getDayNightMode() {
        return ICarInfo.DayNightMode.valueOf(this.getSignalValue(0xBB).intValue());
    }

    public ICarInfo.EngineCrankState getEngineCrankState() {
        return ICarInfo.EngineCrankState.valueOf(this.getSignalValue(407).intValue());
    }

    public float getEngineIgnAngle() {
        return this.getSignalValue(443).floatValue();
    }

    public int getEngineSpeed() {
        return this.getSignalValue(0x79).intValue();
    }

    public ICarInfo.GearPosition getGearPosition() {
        return ICarInfo.GearPosition.valueOf(this.getSignalValue(0xB9).intValue());
    }

    public ICarInfo.GearPositionA9E getGearPositionA9E() {
        return ICarInfo.GearPositionA9E.valueOf(this.getSignalValue(0x19F).intValue());
    }

    public ICarInfo.GearPositionHEV getGearPositionHEV() {
        return ICarInfo.GearPositionHEV.valueOf(this.getSignalValue(664).intValue());
    }

    public ICarInfo.LowBatteryWarningLevel getLowBatteryWarningLevel() {
        return ICarInfo.LowBatteryWarningLevel.valueOf(this.getSignalValue(0x7D).intValue());
    }

    public ICarInfo.ParkingBrakeState getParkingBrakeState() {
        return ICarInfo.ParkingBrakeState.valueOf(this.getSignalValue(201).intValue());
    }

    public ICarInfo.PowerMode getPowerMode() {
        return ICarInfo.PowerMode.valueOf(this.getSignalValue(0xB6).intValue());
    }

    public int getPressureOfAtmospheric() {
        return this.getSignalValue(437).intValue();
    }

    public int getPressureOfOil() {
        return this.getSignalValue(438).intValue();
    }

    public int getPressureOfTurbine() {
        return this.getSignalValue(436).intValue();
    }

    public ICarInfo.RearGearState getRearGearState() {
        return ICarInfo.RearGearState.valueOf(this.getSignalValue(0xB8).intValue());
    }

    public ICarInfo.SleepWakeUpCommand getSleepWakeUpCommand() {
        return ICarInfo.SleepWakeUpCommand.valueOf(this.getSignalValue(-1).intValue());
    }

    public int getTemperatureOfEngineWater() {
        return this.getSignalValue(439).intValue();
    }

    public int getTemperatureOfExhaust() {
        return this.getSignalValue(440).intValue();
    }

    public float getTemperatureOfIntakeAir() {
        return this.getSignalValue(441).floatValue();
    }

    public int getTemperatureOfTransmissionOil() {
        return this.getSignalValue(442).intValue();
    }

    public int getTotalOdometer() {
        return this.getSignalValue(0x7B).intValue();
    }

    public ICarInfo.VehicleModeBroadcast getVehicleModeBroadcast() {
        return ICarInfo.VehicleModeBroadcast.valueOf(this.getSignalValue(0x170).intValue());
    }

    public int getVehicleSpeed() {
        return this.getSignalValue(0x7A).intValue();
    }

    public ICarInfo.VehicleState getVehicleState() {
        return ICarInfo.VehicleState.valueOf(this.getSignalValue(0xBA).intValue());
    }

    public boolean isTransportationModeEnabled() {
        return this.getSignalValue(369).byteValue() == 1;
    }

    public void registerListener(CarInfoListener listener) {
        this.registerReceiver(listener);
    }

    public void unregisterListener(CarInfoListener listener) {
        this.unregisterReceiver(listener);
    }
}

