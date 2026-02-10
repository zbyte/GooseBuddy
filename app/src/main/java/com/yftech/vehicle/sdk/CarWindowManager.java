package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.IBaseApi;
import com.yftech.vehicle.internal.adapter.IBaseApi.EnableState;
import com.yftech.vehicle.internal.adapter.ICarWindow.WindowOpenPercent;
import com.yftech.vehicle.internal.adapter.ICarWindow.WindowOperationState;
import com.yftech.vehicle.internal.adapter.ICarWindow.WindowRoofOpenOpertion;
import com.yftech.vehicle.internal.adapter.ICarWindow.WindowRoofOpenState;
import com.yftech.vehicle.internal.adapter.ICarWindow.WindowRoofShadeOpenOpertion;
import com.yftech.vehicle.internal.adapter.ICarWindow.WindowRoofShadeOpenState;
import com.yftech.vehicle.internal.adapter.ICarWindow.WindowState;
import com.yftech.vehicle.internal.adapter.ICarWindow;

public class CarWindowManager extends BaseApiManager implements ICarWindow {
    public static abstract class CarWindowListener {
        @SignalReceiver(signalId = 0xA0)
        public void onSunroofWindowAutoCloseEnableStateChanged(IBaseApi.EnableState state) {
        }

        @SignalReceiver(signalId = 0xA2)
        public void onWindowOpenPercentFLChanged(int percent) {
        }

        @SignalReceiver(signalId = 0xA6)
        public void onWindowOpenPercentFRChanged(int percent) {
        }

        @SignalReceiver(signalId = 170)
        public void onWindowOpenPercentRLChanged(int percent) {
        }

        @SignalReceiver(signalId = 0xAE)
        public void onWindowOpenPercentRRChanged(int percent) {
        }

        @SignalReceiver(signalId = 707)
        public void onWindowOpenPrecisePercentFLChanged(float percent) {
        }

        @SignalReceiver(signalId = 708)
        public void onWindowOpenPrecisePercentFRChanged(float percent) {
        }

        @SignalReceiver(signalId = 709)
        public void onWindowOpenPrecisePercentRLChanged(float percent) {
        }

        @SignalReceiver(signalId = 710)
        public void onWindowOpenPrecisePercentRRChanged(float percent) {
        }

        @SignalReceiver(signalId = 0xA3)
        public void onWindowOperationStateFLChanged(ICarWindow.WindowOperationState state) {
        }

        @SignalReceiver(signalId = 0xA7)
        public void onWindowOperationStateFRChanged(ICarWindow.WindowOperationState state) {
        }

        @SignalReceiver(signalId = 0xAB)
        public void onWindowOperationStateRLChanged(ICarWindow.WindowOperationState state) {
        }

        @SignalReceiver(signalId = 0xAF)
        public void onWindowOperationStateRRChanged(ICarWindow.WindowOperationState state) {
        }

        @SignalReceiver(signalId = 0xA4)
        public void onWindowOverheatStateFLChanged(boolean isOverheat) {
        }

        @SignalReceiver(signalId = 0xA8)
        public void onWindowOverheatStateFRChanged(boolean isOverheat) {
        }

        @SignalReceiver(signalId = 0xAC)
        public void onWindowOverheatStateRLChanged(boolean isOverheat) {
        }

        @SignalReceiver(signalId = 0xB0)
        public void onWindowOverheatStateRRChanged(boolean isOverheat) {
        }

        @SignalReceiver(signalId = 0xF7)
        public void onWindowRoofOpenOpertionChanged(ICarWindow.WindowRoofOpenOpertion operation) {
        }

        @SignalReceiver(signalId = 0xF6)
        public void onWindowRoofOpenPercentChanged(int percent) {
        }

        @SignalReceiver(signalId = 0xFA)
        public void onWindowRoofShadeOpenOpertionChanged(ICarWindow.WindowRoofShadeOpenOpertion operation) {
        }

        @SignalReceiver(signalId = 0xF9)
        public void onWindowRoofShadeOpenPercentChanged(int percent) {
        }

        @SignalReceiver(signalId = 0xA1)
        public void onWindowStateFLChanged(ICarWindow.WindowState state) {
        }

        @SignalReceiver(signalId = 0xA5)
        public void onWindowStateFRChanged(ICarWindow.WindowState state) {
        }

        @SignalReceiver(signalId = 0xA9)
        public void onWindowStateRLChanged(ICarWindow.WindowState state) {
        }

        @SignalReceiver(signalId = 0xAD)
        public void onWindowStateRRChanged(ICarWindow.WindowState state) {
        }
    }

    private static final String TAG = "CarWindowManager";
    private static CarWindowManager sMe;

    public static CarWindowManager get() {
        CarWindowManager carWindowManager0;
        synchronized(CarWindowManager.class) {
            if(CarWindowManager.sMe == null) {
                carWindowManager0 = new CarWindowManager();
                CarWindowManager.sMe = carWindowManager0;
            }
            else {
                carWindowManager0 = CarWindowManager.sMe;
            }
            return carWindowManager0;
        }
    }

    public IBaseApi.EnableState getSunroofWindowAutoCloseEnableState() {
        return IBaseApi.EnableState.valueOf(this.getSignalValue(0xA0).intValue());
    }

    public int getWindowOpenPercentFL() {
        return this.getSignalValue(0xA2).intValue();
    }

    public int getWindowOpenPercentFR() {
        return this.getSignalValue(0xA6).intValue();
    }

    public int getWindowOpenPercentRL() {
        return this.getSignalValue(170).intValue();
    }

    public int getWindowOpenPercentRR() {
        return this.getSignalValue(0xAE).intValue();
    }

    public float getWindowOpenPrecisePercentFL() {
        return this.getSignalValue(707).floatValue();
    }

    public float getWindowOpenPrecisePercentFR() {
        return this.getSignalValue(708).floatValue();
    }

    public float getWindowOpenPrecisePercentRL() {
        return this.getSignalValue(709).floatValue();
    }

    public float getWindowOpenPrecisePercentRR() {
        return this.getSignalValue(710).floatValue();
    }

    public ICarWindow.WindowOperationState getWindowOperationStateFL() {
        return ICarWindow.WindowOperationState.valueOf(this.getSignalValue(0xA3).intValue());
    }

    public ICarWindow.WindowOperationState getWindowOperationStateFR() {
        return ICarWindow.WindowOperationState.valueOf(this.getSignalValue(0xA7).intValue());
    }

    public ICarWindow.WindowOperationState getWindowOperationStateRL() {
        return ICarWindow.WindowOperationState.valueOf(this.getSignalValue(0xAB).intValue());
    }

    public ICarWindow.WindowOperationState getWindowOperationStateRR() {
        return ICarWindow.WindowOperationState.valueOf(this.getSignalValue(0xAF).intValue());
    }

    public boolean getWindowOverheatStateFL() {
        return this.getSignalValue(0xA4).byteValue() != 0;
    }

    public boolean getWindowOverheatStateFR() {
        return this.getSignalValue(0xA8).byteValue() != 0;
    }

    public boolean getWindowOverheatStateRL() {
        return this.getSignalValue(0xAC).byteValue() != 0;
    }

    public boolean getWindowOverheatStateRR() {
        return this.getSignalValue(0xB0).byteValue() != 0;
    }

    public ICarWindow.WindowRoofOpenOpertion getWindowRoofOpenOpertion() {
        return ICarWindow.WindowRoofOpenOpertion.valueOf(this.getSignalValue(0xF7).intValue());
    }

    public int getWindowRoofOpenPercent() {
        return this.getSignalValue(0xF6).intValue();
    }

    public ICarWindow.WindowRoofShadeOpenOpertion getWindowRoofShadeOpenOpertion() {
        return ICarWindow.WindowRoofShadeOpenOpertion.valueOf(this.getSignalValue(0xFA).intValue());
    }

    public int getWindowRoofShadeOpenPercent() {
        return this.getSignalValue(0xF9).intValue();
    }

    public ICarWindow.WindowState getWindowStateFL() {
        return ICarWindow.WindowState.valueOf(this.getSignalValue(0xA1).intValue());
    }

    public ICarWindow.WindowState getWindowStateFR() {
        return ICarWindow.WindowState.valueOf(this.getSignalValue(0xA5).intValue());
    }

    public ICarWindow.WindowState getWindowStateRL() {
        return ICarWindow.WindowState.valueOf(this.getSignalValue(0xA9).intValue());
    }

    public ICarWindow.WindowState getWindowStateRR() {
        return ICarWindow.WindowState.valueOf(this.getSignalValue(0xAD).intValue());
    }

    public void registerListener(CarWindowListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setSunroofWindowAutoCloseEnabled(boolean enabled) {
        return enabled ? this.setSignalValue(0x3F, 2) : this.setSignalValue(0x3F, 1);
    }

    public boolean setWindowOpenPercentFL(ICarWindow.WindowOpenPercent percent) {
        return this.setSignalValue(0x40, percent.value);
    }

    public boolean setWindowOpenPercentFLVdSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(364, 1) : this.setSignalValue(364, 0);
    }

    public boolean setWindowOpenPercentFR(ICarWindow.WindowOpenPercent percent) {
        return this.setSignalValue(65, percent.value);
    }

    public boolean setWindowOpenPercentFRVdSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(365, 1) : this.setSignalValue(365, 0);
    }

    public boolean setWindowOpenPercentRL(ICarWindow.WindowOpenPercent percent) {
        return this.setSignalValue(66, percent.value);
    }

    public boolean setWindowOpenPercentRLVdSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(366, 1) : this.setSignalValue(366, 0);
    }

    public boolean setWindowOpenPercentRR(ICarWindow.WindowOpenPercent percent) {
        return this.setSignalValue(67, percent.value);
    }

    public boolean setWindowOpenPercentRRVdSwitch(boolean enabled) {
        return enabled ? this.setSignalValue(0x16F, 1) : this.setSignalValue(0x16F, 0);
    }

    public boolean setWindowRoofOpenState(ICarWindow.WindowRoofOpenState state) {
        return this.setSignalValue(68, state.value);
    }

    public boolean setWindowRoofShadeOpenPercent(int percent) {
        return this.setSignalValue(0xF8, percent);
    }

    public boolean setWindowRoofShadeOpenState(ICarWindow.WindowRoofShadeOpenState state) {
        return this.setSignalValue(0xF8, state.value);
    }

    public boolean setWindowStateFL(ICarWindow.WindowState state) {
        return this.setSignalValue(202, state.value);
    }

    public boolean setWindowStateFR(ICarWindow.WindowState state) {
        return this.setSignalValue(203, state.value);
    }

    public boolean setWindowStateRL(ICarWindow.WindowState state) {
        return this.setSignalValue(204, state.value);
    }

    public boolean setWindowStateRR(ICarWindow.WindowState state) {
        return this.setSignalValue(205, state.value);
    }

    public void unregisterListener(CarWindowListener listener) {
        this.unregisterReceiver(listener);
    }
}

