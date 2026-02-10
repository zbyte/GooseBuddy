package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.ICarFragrance.FragranceConcentration;
import com.yftech.vehicle.internal.adapter.ICarFragrance.FragranceTaste;
import com.yftech.vehicle.internal.adapter.ICarFragrance.FragranceWorkState;
import com.yftech.vehicle.internal.adapter.ICarFragrance.FragranceWorkWarn;
import com.yftech.vehicle.internal.adapter.ICarFragrance;

public class CarFragranceManager extends BaseApiManager implements ICarFragrance {
    public static abstract class CarFragranceListener {
        @SignalReceiver(signalId = 547)
        public void onFragrance1WorkStateChanged(ICarFragrance.FragranceWorkState workState) {
        }

        @SignalReceiver(signalId = 548)
        public void onFragrance2WorkStateChanged(ICarFragrance.FragranceWorkState workState) {
        }

        @SignalReceiver(signalId = 549)
        public void onFragrance3WorkStateChanged(ICarFragrance.FragranceWorkState workState) {
        }

        @SignalReceiver(signalId = 565)
        public void onFragranceConcentrationChanged(ICarFragrance.FragranceConcentration concentration) {
        }

        @SignalReceiver(signalId = 550)
        public void onFragranceTaste1FragChanged(int percent) {
        }

        @SignalReceiver(signalId = 0x220)
        public void onFragranceTaste1PercentChanged(int percent) {
        }

        @SignalReceiver(signalId = 551)
        public void onFragranceTaste2FragChanged(int percent) {
        }

        @SignalReceiver(signalId = 545)
        public void onFragranceTaste2PercentChanged(int percent) {
        }

        @SignalReceiver(signalId = 552)
        public void onFragranceTaste3FragChanged(int percent) {
        }

        @SignalReceiver(signalId = 546)
        public void onFragranceTaste3PercentChanged(int percent) {
        }

        @SignalReceiver(signalId = 573)
        public void onFragranceTasteBoxIdChanged(int boxId) {
        }

        @SignalReceiver(signalId = 574)
        public void onFragranceTasteWorkingBoxIdChanged(int boxid) {
        }

        @SignalReceiver(signalId = 673)
        public void onFragranceWorkWarnChanged(ICarFragrance.FragranceWorkWarn warn) {
        }
    }

    private static final String TAG = "CarFragranceManager";
    private static CarFragranceManager sMe;

    public static CarFragranceManager get() {
        CarFragranceManager carFragranceManager0;
        synchronized(CarFragranceManager.class) {
            if(CarFragranceManager.sMe == null) {
                carFragranceManager0 = new CarFragranceManager();
                CarFragranceManager.sMe = carFragranceManager0;
            }
            else {
                carFragranceManager0 = CarFragranceManager.sMe;
            }
            return carFragranceManager0;
        }
    }

    public ICarFragrance.FragranceWorkState getFragrance1WorkState() {
        return ICarFragrance.FragranceWorkState.valueOf(this.getSignalValue(547).intValue());
    }

    public ICarFragrance.FragranceWorkState getFragrance2WorkState() {
        return ICarFragrance.FragranceWorkState.valueOf(this.getSignalValue(548).intValue());
    }

    public ICarFragrance.FragranceWorkState getFragrance3WorkState() {
        return ICarFragrance.FragranceWorkState.valueOf(this.getSignalValue(549).intValue());
    }

    public ICarFragrance.FragranceConcentration getFragranceConcentration() {
        return ICarFragrance.FragranceConcentration.valueOf(this.getSignalValue(565).intValue());
    }

    public int getFragranceTaste1Frag() {
        return this.getSignalValue(550).intValue();
    }

    public int getFragranceTaste1Percent() {
        return this.getSignalValue(0x220).intValue();
    }

    public int getFragranceTaste2Frag() {
        return this.getSignalValue(551).intValue();
    }

    public int getFragranceTaste2Percent() {
        return this.getSignalValue(545).intValue();
    }

    public int getFragranceTaste3Frag() {
        return this.getSignalValue(552).intValue();
    }

    public int getFragranceTaste3Percent() {
        return this.getSignalValue(546).intValue();
    }

    public int getFragranceTasteBoxId() {
        return this.getSignalValue(573).intValue();
    }

    public int getFragranceTasteWorkingBoxId() {
        return this.getSignalValue(574).intValue();
    }

    public ICarFragrance.FragranceWorkWarn getFragranceWorkWarn() {
        return ICarFragrance.FragranceWorkWarn.valueOf(this.getSignalValue(673).intValue());
    }

    public void registerListener(CarFragranceListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setFragranceConcentration(ICarFragrance.FragranceConcentration concentration) {
        return this.setSignalValue(0x21F, concentration.value);
    }

    public boolean setFragranceTaste(ICarFragrance.FragranceTaste taste) {
        return this.setSignalValue(542, taste.value);
    }

    public void unregisterListener(CarFragranceListener listener) {
        this.unregisterReceiver(listener);
    }
}

