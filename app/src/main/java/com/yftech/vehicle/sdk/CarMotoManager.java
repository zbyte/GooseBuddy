package com.yftech.vehicle.sdk;

import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.CarMoto.Gears;
import com.yftech.vehicle.internal.adapter.CarMoto.HandlebarKeyHeat;
import com.yftech.vehicle.internal.adapter.CarMoto.KnobLeftRightKey;
import com.yftech.vehicle.internal.adapter.CarMoto.KnobUpDownKey;
import com.yftech.vehicle.internal.adapter.CarMoto.MOTOIGNStatus;
import com.yftech.vehicle.internal.adapter.CarMoto.PreviewModeKey;
import com.yftech.vehicle.internal.adapter.CarMoto.RightModeKey;
import com.yftech.vehicle.internal.adapter.CarMoto.TurnLightInfo;
import com.yftech.vehicle.internal.adapter.CarMoto;

public class CarMotoManager extends BaseApiManager implements CarMoto {
    public static abstract class CarMotoListener {
        @SignalReceiver(signalId = 640)
        public void onGearsLevelStatusChanged(int level) {
        }

        @SignalReceiver(signalId = 629)
        public void onGearsStatusChanged(CarMoto.Gears gear) {
        }

        @SignalReceiver(signalId = 628)
        public void onHandlebarKeyHeatChanged(CarMoto.HandlebarKeyHeat info) {
        }

        @SignalReceiver(signalId = 641)
        public void onIgnitionStatusChanged(int value) {
        }

        @SignalReceiver(signalId = 633)
        public void onKnobLeftRightKeyChanged(CarMoto.KnobLeftRightKey info) {
        }

        @SignalReceiver(signalId = 638)
        public void onKnobStepNumKeyChanged(int stepNum) {
        }

        @SignalReceiver(signalId = 632)
        public void onKnobUpDownKeyChanged(CarMoto.KnobUpDownKey info) {
        }

        @SignalReceiver(signalId = 636)
        public void onMOTOEngineSpeedChanged(int speed) {
        }

        @SignalReceiver(signalId = 637)
        public void onMOTOFullLightChanged(boolean open) {
        }

        @SignalReceiver(signalId = 634)
        public void onMOTOIGNKeyStatusChanged(CarMoto.MOTOIGNStatus info) {
        }

        @SignalReceiver(signalId = 635)
        public void onMOTOSpeedChanged(int speed) {
        }

        @SignalReceiver(signalId = 631)
        public void onPreviewModeKeyChanged(CarMoto.PreviewModeKey info) {
        }

        @SignalReceiver(signalId = 630)
        public void onRightModeKeyChanged(CarMoto.RightModeKey info) {
        }

        @SignalReceiver(signalId = 627)
        public void onTurnLightInfoChanged(CarMoto.TurnLightInfo info) {
        }
    }

    private static final String TAG = "CarMotoManager";
    private static CarMotoManager sMe;

    public static CarMotoManager get() {
        CarMotoManager carMotoManager0;
        synchronized(CarMotoManager.class) {
            if(CarMotoManager.sMe == null) {
                carMotoManager0 = new CarMotoManager();
                CarMotoManager.sMe = carMotoManager0;
            }
            else {
                carMotoManager0 = CarMotoManager.sMe;
            }
            return carMotoManager0;
        }
    }

    public int getGearsLevelStatus() {
        return this.getSignalValue(640).intValue();
    }

    public CarMoto.Gears getGearsStatus() {
        return CarMoto.Gears.valueOf(this.getSignalValue(629).intValue());
    }

    public CarMoto.HandlebarKeyHeat getHandlebarKeyHeat() {
        return CarMoto.HandlebarKeyHeat.valueOf(this.getSignalValue(628).intValue());
    }

    public int getIgnitionStatus() {
        return this.getSignalValue(641).intValue();
    }

    public CarMoto.KnobLeftRightKey getKnobLeftRightKey() {
        return CarMoto.KnobLeftRightKey.valueOf(this.getSignalValue(633).intValue());
    }

    public int getKnobStepNumKey() {
        return this.getSignalValue(638).intValue();
    }

    public CarMoto.KnobUpDownKey getKnobUpDownKey() {
        return CarMoto.KnobUpDownKey.valueOf(this.getSignalValue(632).intValue());
    }

    public int getMOTOEngineSpeed() {
        return this.getSignalValue(636).intValue();
    }

    public boolean getMOTOFullLight() {
        return this.getSignalValue(637).byteValue() != 0;
    }

    public CarMoto.MOTOIGNStatus getMOTOIGNKeyStatus() {
        return CarMoto.MOTOIGNStatus.valueOf(this.getSignalValue(634).intValue());
    }

    public int getMOTOSpeed() {
        return this.getSignalValue(635).intValue();
    }

    public CarMoto.PreviewModeKey getPreviewModeKey() {
        return CarMoto.PreviewModeKey.valueOf(this.getSignalValue(631).intValue());
    }

    public CarMoto.RightModeKey getRightModeKey() {
        return CarMoto.RightModeKey.valueOf(this.getSignalValue(630).intValue());
    }

    public CarMoto.TurnLightInfo getTurnLightInfo() {
        return CarMoto.TurnLightInfo.valueOf(this.getSignalValue(627).intValue());
    }

    public void registerListener(CarMotoListener listener) {
        this.registerReceiver(listener);
    }

    public void unregisterListener(CarMotoListener listener) {
        this.unregisterReceiver(listener);
    }
}

