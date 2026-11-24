package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.IBaseApi;
import com.yftech.vehicle.internal.adapter.IBaseApi.EnableState;
import com.yftech.vehicle.internal.adapter.ICarTire;

public class CarTireManager extends BaseApiManager implements ICarTire {
    public static abstract class CarTireListener {
        @SignalReceiver(signalId = 339)
        public void onWheelSpeedFLChanged(float speed) {
        }

        @SignalReceiver(signalId = 340)
        public void onWheelSpeedFLEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 341)
        public void onWheelSpeedFRChanged(float speed) {
        }

        @SignalReceiver(signalId = 342)
        public void onWheelSpeedFREnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 343)
        public void onWheelSpeedRLChanged(float speed) {
        }

        @SignalReceiver(signalId = 344)
        public void onWheelSpeedRLEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 345)
        public void onWheelSpeedRRChanged(float speed) {
        }

        @SignalReceiver(signalId = 346)
        public void onWheelSpeedRREnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 1208)
        public void onTyrePressureFLChanged(float pressure) {
        }

        @SignalReceiver(signalId = 1207)
        public void onTyrePressureFRChanged(float pressure) {
        }

        @SignalReceiver(signalId = 1206)
        public void onTyrePressureRLChanged(float pressure) {
        }

        @SignalReceiver(signalId = 1205)
        public void onTyrePressureRRChanged(float pressure) {
        }

        @SignalReceiver(signalId = 1204)
        public void onTyreTemperatureFLChanged(int temperature) {
        }

        @SignalReceiver(signalId = 1203)
        public void onTyreTemperatureFRChanged(int temperature) {
        }

        @SignalReceiver(signalId = 1202)
        public void onTyreTemperatureRLChanged(int temperature) {
        }

        @SignalReceiver(signalId = 1201)
        public void onTyreTemperatureRRChanged(int temperature) {
        }
    }

    private static final String TAG = "CarTireManager";
    private static CarTireManager sMe;

    public static CarTireManager get() {
        CarTireManager carTireManager0;
        synchronized(CarTireManager.class) {
            if(CarTireManager.sMe == null) {
                carTireManager0 = new CarTireManager();
                CarTireManager.sMe = carTireManager0;
            }
            else {
                carTireManager0 = CarTireManager.sMe;
            }
            return carTireManager0;
        }
    }

    public float getWheelSpeedFL() {
        return this.getSignalValue(339).floatValue();
    }

    public IBaseApi.EnableState getWheelSpeedFLEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(340).intValue());
    }

    public float getWheelSpeedFR() {
        return this.getSignalValue(341).floatValue();
    }

    public IBaseApi.EnableState getWheelSpeedFREnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(342).intValue());
    }

    public float getWheelSpeedRL() {
        return this.getSignalValue(343).floatValue();
    }

    public IBaseApi.EnableState getWheelSpeedRLEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(344).intValue());
    }

    public float getWheelSpeedRR() {
        return this.getSignalValue(345).floatValue();
    }

    public IBaseApi.EnableState getWheelSpeedRREnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(346).intValue());
    }

    public float getTyrePressureFL() {
        return this.getSignalValue(1208).floatValue();
    }

    public float getTyrePressureFR() {
        return this.getSignalValue(1207).floatValue();
    }

    public float getTyrePressureRL() {
        return this.getSignalValue(1206).floatValue();
    }

    public float getTyrePressureRR() {
        return this.getSignalValue(1205).floatValue();
    }

    public int getTyreTemperatureFL() {
        return this.getSignalValue(1204).intValue();
    }

    public int getTyreTemperatureFR() {
        return this.getSignalValue(1203).intValue();
    }

    public int getTyreTemperatureRL() {
        return this.getSignalValue(1202).intValue();
    }

    public int getTyreTemperatureRR() {
        return this.getSignalValue(1201).intValue();
    }

    public void registerListener(CarTireListener listener) {
        this.registerReceiver(listener);
    }

    public void unregisterListener(CarTireListener listener) {
        this.unregisterReceiver(listener);
    }
}

