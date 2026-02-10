package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.IBaseApi;
import com.yftech.vehicle.internal.adapter.IBaseApi.EnableState;
import com.yftech.vehicle.internal.adapter.IBaseApi.SwitchStateOp;
import com.yftech.vehicle.internal.adapter.ICarSwc.SwcHeatState;
import com.yftech.vehicle.internal.adapter.ICarSwc;

public class CarSwcManager extends BaseApiManager implements ICarSwc {
    public static abstract class CarSwcListener {
        @SignalReceiver(signalId = 306)
        public void onSwcAngleChanged(float angle) {
        }

        @SignalReceiver(signalId = 338)
        public void onSwcAngleVdEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 304)
        public void onSwcHeatStateChanged(ICarSwc.SwcHeatState state) {
        }
    }

    private static final String TAG = "CarSwcManager";
    private static CarSwcManager sMe;

    public static CarSwcManager get() {
        CarSwcManager carSwcManager0;
        synchronized(CarSwcManager.class) {
            if(CarSwcManager.sMe == null) {
                carSwcManager0 = new CarSwcManager();
                CarSwcManager.sMe = carSwcManager0;
            }
            else {
                carSwcManager0 = CarSwcManager.sMe;
            }
            return carSwcManager0;
        }
    }

    public float getSwcAngle() {
        return this.getSignalValue(306).floatValue();
    }

    public IBaseApi.EnableState getSwcAngleVdEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(338).intValue());
    }

    public ICarSwc.SwcHeatState getSwcHeatState() {
        return ICarSwc.SwcHeatState.valueOf(this.getSignalValue(304).intValue());
    }

    public boolean performSwcStarKeyButtonClick() {
        return this.setSignalValue(284, 1);
    }

    public boolean performSwcStarKeyVDButtonClick() {
        return this.setSignalValue(285, 1);
    }

    public void registerListener(CarSwcListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setSwcHeatState(IBaseApi.SwitchStateOp enabled) {
        return this.setSignalValue(698, enabled.value);
    }

    public boolean setSwcHeatStateEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(305, 1) : this.setSignalValue(305, 2);
    }

    public void unregisterListener(CarSwcListener listener) {
        this.unregisterReceiver(listener);
    }
}

