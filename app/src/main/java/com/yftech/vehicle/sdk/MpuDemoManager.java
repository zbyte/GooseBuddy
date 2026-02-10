package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.IDemo;

public class MpuDemoManager extends BaseApiManager implements IDemo {
    public static abstract class CarDemoListener {
        @SignalReceiver(signalId = 0x26D0)
        public void onGameBrakeCtlPercentChanged(float percent) {
        }

        @SignalReceiver(signalId = 9937)
        public void onGamePedalCtlPercentChanged(float percent) {
        }

        @SignalReceiver(signalId = 9938)
        public void onGameSwcCtlAngleChanged(float angle) {
        }
    }

    private static final String TAG = "CarMiscManager";
    private static MpuDemoManager sMe;

    public static MpuDemoManager get() {
        MpuDemoManager mpuDemoManager0;
        synchronized(MpuDemoManager.class) {
            if(MpuDemoManager.sMe == null) {
                mpuDemoManager0 = new MpuDemoManager();
                MpuDemoManager.sMe = mpuDemoManager0;
            }
            else {
                mpuDemoManager0 = MpuDemoManager.sMe;
            }
            return mpuDemoManager0;
        }
    }

    public float getGameBrakeCtlPercent() {
        return this.getSignalValue(0x26D0).floatValue();
    }

    public float getGamePedalCtlPercent() {
        return this.getSignalValue(9937).floatValue();
    }

    public float getGameSwcCtlAngle() {
        return this.getSignalValue(9938).floatValue();
    }

    public void registerListener(CarDemoListener listener) {
        this.registerReceiver(listener);
    }

    public void unregisterListener(CarDemoListener listener) {
        this.unregisterReceiver(listener);
    }
}

