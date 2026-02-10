package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.ICarPower.PowerMode;
import com.yftech.vehicle.internal.adapter.ICarPower.PowerState;
import com.yftech.vehicle.internal.adapter.ICarPower;

public class CarPowerManager extends BaseApiManager implements ICarPower {
    public static abstract class CarPowerListener {
        @SignalReceiver(signalId = 0x270C)
        public void onPowerModeChanged(ICarPower.PowerMode mode) {
        }

        @SignalReceiver(signalId = 0x270D)
        public void onPowerStateChanged(ICarPower.PowerState state) {
        }
    }

    private static final String TAG = "CarPowerManager";
    private static CarPowerManager sMe;

    public static CarPowerManager get() {
        CarPowerManager carPowerManager0;
        synchronized(CarPowerManager.class) {
            if(CarPowerManager.sMe == null) {
                carPowerManager0 = new CarPowerManager();
                CarPowerManager.sMe = carPowerManager0;
            }
            else {
                carPowerManager0 = CarPowerManager.sMe;
            }
            return carPowerManager0;
        }
    }

    public ICarPower.PowerMode getPowerMode() {
        return ICarPower.PowerMode.valueOf(this.getSignalValue(0x270C).intValue());
    }

    public ICarPower.PowerState getPowerState() {
        return ICarPower.PowerState.valueOf(this.getSignalValue(0x270D).intValue());
    }

    public void registerListener(CarPowerListener listener) {
        this.registerReceiver(listener);
    }

    public void unregisterListener(CarPowerListener listener) {
        this.unregisterReceiver(listener);
    }
}

