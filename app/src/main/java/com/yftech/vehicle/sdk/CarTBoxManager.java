package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.ICarTBox.MuteRadioOrder;
import com.yftech.vehicle.internal.adapter.ICarTBox.PhoneCallState;
import com.yftech.vehicle.internal.adapter.ICarTBox.PhoneKeyAction;
import com.yftech.vehicle.internal.adapter.ICarTBox.PhoneMode;
import com.yftech.vehicle.internal.adapter.ICarTBox.PhoneType;
import com.yftech.vehicle.internal.adapter.ICarTBox;

public class CarTBoxManager extends BaseApiManager implements ICarTBox {
    public static abstract class CarTBoxListener {
        @SignalReceiver(signalId = 190)
        public void onMuteRadioOrderChanged(ICarTBox.MuteRadioOrder order) {
        }

        @SignalReceiver(signalId = 329)
        public void onPhoneCallStateChanged(ICarTBox.PhoneCallState state) {
        }

        @SignalReceiver(signalId = 328)
        public void onPhoneModeChanged(ICarTBox.PhoneMode mode) {
        }
    }

    private static final String TAG = "CarTBoxManager";
    private static CarTBoxManager sMe;

    public static CarTBoxManager get() {
        CarTBoxManager carTBoxManager0;
        synchronized(CarTBoxManager.class) {
            if(CarTBoxManager.sMe == null) {
                carTBoxManager0 = new CarTBoxManager();
                CarTBoxManager.sMe = carTBoxManager0;
            }
            else {
                carTBoxManager0 = CarTBoxManager.sMe;
            }
            return carTBoxManager0;
        }
    }

    public ICarTBox.MuteRadioOrder getMuteRadioOrder() {
        return ICarTBox.MuteRadioOrder.valueOf(this.getSignalValue(190).intValue());
    }

    public ICarTBox.PhoneCallState getPhoneCallState() {
        return ICarTBox.PhoneCallState.valueOf(this.getSignalValue(329).intValue());
    }

    public ICarTBox.PhoneMode getPhoneMode() {
        return ICarTBox.PhoneMode.valueOf(this.getSignalValue(328).intValue());
    }

    public void registerListener(CarTBoxListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setPhoneKeyAccept(ICarTBox.PhoneKeyAction action) {
        return this.setSignalValue(326, action.value);
    }

    public boolean setPhoneKeyCancel(ICarTBox.PhoneKeyAction action) {
        return this.setSignalValue(327, action.value);
    }

    public boolean setPhoneType(ICarTBox.PhoneType type) {
        return this.setSignalValue(0x202, type.value);
    }

    public void unregisterListener(CarTBoxListener listener) {
        this.unregisterReceiver(listener);
    }
}

