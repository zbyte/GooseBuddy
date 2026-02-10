package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.ICarKey.CarKeyEvent;
import com.yftech.vehicle.internal.adapter.ICarKey;

public class CarKeyManager extends BaseApiManager implements ICarKey {
    public static abstract class CarKeyListener {
        @SignalReceiver(signalId = 0x270E)
        public void onKnobKeyEvent(ICarKey.CarKeyEvent event) {
        }

        @SignalReceiver(signalId = 0x2704)
        public void onPanelKeyEvent(ICarKey.CarKeyEvent event) {
        }

        @SignalReceiver(signalId = 0x270F)
        public void onSteeringWheelKeyEvent(ICarKey.CarKeyEvent event) {
        }
    }

    private static final String TAG = "CarKeyManager";
    private static CarKeyManager sMe;

    public static CarKeyManager get() {
        CarKeyManager carKeyManager0;
        synchronized(CarKeyManager.class) {
            if(CarKeyManager.sMe == null) {
                carKeyManager0 = new CarKeyManager();
                CarKeyManager.sMe = carKeyManager0;
            }
            else {
                carKeyManager0 = CarKeyManager.sMe;
            }
            return carKeyManager0;
        }
    }

    public void registerListener(CarKeyListener listener) {
        this.registerReceiver(listener);
    }

    public void unregisterListener(CarKeyListener listener) {
        this.unregisterReceiver(listener);
    }
}

