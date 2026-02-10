package com.yftech.vehicle.sdk;

import android.util.Log;
import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.ICarMisc.AteCarType;
import com.yftech.vehicle.internal.adapter.ICarMisc.DeviceNode;
import com.yftech.vehicle.internal.adapter.ICarMisc.ECallState;
import com.yftech.vehicle.internal.adapter.ICarMisc.EngineerMode;
import com.yftech.vehicle.internal.adapter.ICarMisc.ErrorCodeInfo;
import com.yftech.vehicle.internal.adapter.ICarMisc.HmiMode;
import com.yftech.vehicle.internal.adapter.ICarMisc.KeyTestEvent;
import com.yftech.vehicle.internal.adapter.ICarMisc.ProgramSource;
import com.yftech.vehicle.internal.adapter.ICarMisc.SpeakerCmd;
import com.yftech.vehicle.internal.adapter.ICarMisc.TftCmd;
import com.yftech.vehicle.internal.adapter.ICarMisc.TftColorState;
import com.yftech.vehicle.internal.adapter.ICarMisc.TransportMode;
import com.yftech.vehicle.internal.adapter.ICarMisc;
import com.yftech.vehicle.internal.utils.StringFormart;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CarMiscManager extends BaseApiManager implements ICarMisc {
    public static abstract class CarMiscListener {
        @SignalReceiver(signalId = 9944)
        public void onAteCarTypeStateChanged(ICarMisc.AteCarType carType) {
        }

        @SignalReceiver(signalId = 0x26F1, valueToEnabledState = true)
        public void onCarInfoAvmStateChanged(boolean connected) {
        }

        @SignalReceiver(signalId = 9970, valueToEnabledState = true)
        public void onCarInfoCameraRearViewStateChanged(boolean connected) {
        }

        @SignalReceiver(signalId = 9959, valueToEnabledState = true)
        public void onDeviceExtAvmStateChanged(boolean isOpen) {
        }

        @SignalReceiver(signalId = 9960)
        public void onDeviceNodeStateChanged(ICarMisc.DeviceNode nodes) {
        }

        @SignalReceiver(signalId = 0x2703, valueToEnabledState = true)
        public void onFactoryModeCanStateChanged(boolean isError) {
        }

        @SignalReceiver(signalId = 0x26F7, valueToEnabledState = true)
        public void onFactoryModeDevelopModeChanged(boolean isOpen) {
        }

        @SignalReceiver(signalId = 0x2705)
        public void onFactoryModeErrorCodeChanged(ICarMisc.ErrorCodeInfo code) {
        }

        @SignalReceiver(signalId = 9980)
        public void onFactoryModeStateChanged(int state) {
        }

        @SignalReceiver(signalId = 9941)
        public void onFactoryModeTransportModeChanged(ICarMisc.TransportMode mode) {
        }

        @SignalReceiver(signalId = 9954)
        public void onFactoryModeUds2FHmiModeChanged(ICarMisc.HmiMode mode) {
        }

        @SignalReceiver(signalId = 9953)
        public void onFactoryModeUds2FKeyTestChanged(ICarMisc.KeyTestEvent event) {
        }

        @SignalReceiver(signalId = 9955)
        public void onFactoryModeUds2FProgramSourceInfoChanged(ICarMisc.ProgramSource source) {
        }

        @SignalReceiver(signalId = 0x26FE)
        public void onFactoryModeUds2FSpeakerInfoChanged(ICarMisc.SpeakerCmd cmd) {
        }

        @SignalReceiver(signalId = 9942, valueToEnabledState = true)
        public void onFactoryModeUds2FStateChanged(boolean isOpened) {
        }

        @SignalReceiver(signalId = 9958)
        public void onFactoryModeUds2FTftBackLightLevelChanged(int lightLevel) {
        }

        @SignalReceiver(signalId = 9956)
        public void onFactoryModeUds2FTftColorChanged(ICarMisc.TftColorState state) {
        }

        @SignalReceiver(signalId = 0x26FD)
        public void onFactoryModeUds2FTftInfoChanged(ICarMisc.TftCmd cmd) {
        }

        @SignalReceiver(signalId = 9957)
        public void onFactoryModeUds2FVolumeChanged(int volume) {
        }

        @SignalReceiver(signalId = 0x26FF)
        public void onFactoryModeUds31EngineerInfoChanged(ICarMisc.EngineerMode mode) {
        }

        @SignalReceiver(signalId = 0x2709)
        public void onKeyboardBacklightChanged(int level) {
        }

        @SignalReceiver(signalId = 0x2708)
        public void onScreenBacklightChanged(int level) {
        }

        @SignalReceiver(signalId = 9966, valueToEnabledState = true)
        public void onTBoxBatteryStateChanged(boolean isNormal) {
        }

        @SignalReceiver(signalId = 0x26F0, valueToEnabledState = true)
        public void onTBoxConnectStateChanged(boolean connected) {
        }

        @SignalReceiver(signalId = 0x26EF)
        public void onTBoxEcallStateChanged(ICarMisc.ECallState state) {
        }
    }

    private static final String TAG = "CarMiscManager";
    private static CarMiscManager sMe;

    public static CarMiscManager get() {
        CarMiscManager carMiscManager0;
        synchronized(CarMiscManager.class) {
            if(CarMiscManager.sMe == null) {
                carMiscManager0 = new CarMiscManager();
                CarMiscManager.sMe = carMiscManager0;
            }
            else {
                carMiscManager0 = CarMiscManager.sMe;
            }
            return carMiscManager0;
        }
    }

    public ICarMisc.AteCarType getAteCarType() {
        return ICarMisc.AteCarType.valueOf(this.getSignalValue(9944).intValue());
    }

    public boolean getCarInfoAvmState() {
        return this.getSignalValue(0x26F1).intValue() == 1;
    }

    public boolean getCarInfoCameraRearViewState() {
        return this.getSignalValue(9970).intValue() == 1;
    }

    public boolean getDeviceExtAvmState() {
        return this.getSignalValue(9959).byteValue() == 1;
    }

    public ICarMisc.DeviceNode getDeviceNodeState() {
        return ICarMisc.DeviceNode.valueOf(this.getSignalValue(9960).intValue());
    }

    public boolean getFactoryModeDevelopModeEnabled() {
        return this.getSignalValue(0x26F7).intValue() == 1;
    }

    public ICarMisc.TransportMode getFactoryModeTransportMode() {
        return ICarMisc.TransportMode.valueOf(this.getSignalValue(9941).intValue());
    }

    public int getKeyboardBacklight() {
        return this.getSignalValue(0x2709).intValue();
    }

    public int getScreenBacklight() {
        return this.getSignalValue(0x2708).intValue();
    }

    public boolean getTBoxBatteryState() {
        return this.getSignalValue(9966).intValue() == 1;
    }

    public boolean getTBoxConnectState() {
        return this.getSignalValue(0x26F0).intValue() == 1;
    }

    public ICarMisc.ECallState getTBoxECallState() {
        return ICarMisc.ECallState.valueOf(this.getSignalValue(0x26EF).intValue());
    }

    public void registerListener(CarMiscListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setAteCarType(ICarMisc.AteCarType carType) {
        return this.setSignalValue(9944, carType.value);
    }

    public boolean setCarDtcState(int index, int state) {
        return this.setSignalValue(0x26FB, new byte[]{((byte)index), ((byte)state)});
    }

    public boolean setCheckFactoryModeState() {
        return this.setSignalValue(9980, true);
    }

    public boolean setDeviceExtAvmState(boolean isOpen) {
        return this.setSignalValue(9959, isOpen);
    }

    public boolean setFactoryModeCanStateEnabled(boolean enabled) {
        return this.setSignalValue(0x2703, enabled);
    }

    public boolean setFactoryModeCarKitCreateDate(String dateString) {
        Date d;
        if(dateString == null || dateString.length() != 8) {
            Log.e("CarMiscManager", "setFactoryModeCarKitCreateDate()  dateString is null or length!=8 error ,date =" + dateString);
            return false;
        }
        try {
            d = new SimpleDateFormat("yyyyMMdd").parse(dateString);
        }
        catch(Exception e) {
            Log.e("CarMiscManager", "setFactoryModeCarKitCreateDate() SimpleDateFormat.parse([ " + dateString + " ]) error ?is not yyyyMMdd > " + e.getMessage());
            return false;
        }
        try {
            byte[] dateBytes = {((byte)Integer.parseInt(String.valueOf((d.getYear() + 1900) / 100), 16)), ((byte)Integer.parseInt(((d.getYear() + 1900) % 100 + ""), 16)), ((byte)Integer.parseInt((d.getMonth() + 1 + ""), 16)), ((byte)Integer.parseInt((d.getDate() + ""), 16))};
            Log.i("CarMiscManager", StringFormart.byte2hex(dateBytes));
            return this.setSignalValue(0x26E0, dateBytes);
        }
        catch(Exception e) {
            Log.e("CarMiscManager", "setFactoryModeCarKitCreateDate() error > " + e.getMessage());
            return false;
        }
    }

    public boolean setFactoryModeClearDtc(boolean isClear) {
        return this.setSignalValue(0x26F4, isClear);
    }

    public boolean setFactoryModeDevelopModeEnabled(boolean isOpenDevMode, boolean isAccOn) {
        if(isOpenDevMode) {
            return isAccOn ? this.setSignalValue(0x26F7, 17) : this.setSignalValue(0x26F7, 16);
        }
        return isAccOn ? this.setSignalValue(0x26F7, 1) : this.setSignalValue(0x26F7, 0);
    }

    public boolean setFactoryModeEcuAndProductLineSerial(int ecuSerial, int proLineSerial, String dateString) {
        Date d;
        if(ecuSerial < 0 || ecuSerial > 0xFFFFFF) {
            Log.e("CarMiscManager", "setFactoryModeEcuAndProductLineSerial()  ecuSerial < 0 or > 16777215 error ,ecuSerial =" + ecuSerial);
            return false;
        }
        if(proLineSerial < 0 || proLineSerial > 0xFF) {
            Log.e("CarMiscManager", "setFactoryModeEcuAndProductLineSerial()  ecuSerial < 0 or > 255 error ,proLineSerial =" + proLineSerial);
            return false;
        }
        if(dateString == null || dateString.length() != 6) {
            Log.e("CarMiscManager", "setFactoryModeEcuAndProductLineSerial()  dateString is not ? yyMMdd ? error ,dateString =" + dateString);
            return false;
        }
        try {
            d = new SimpleDateFormat("yyMMdd").parse(dateString);
        }
        catch(Exception e) {
            Log.e("CarMiscManager", "setFactoryModeEcuAndProductLineSerial() SimpleDateFormat.parse([ " + dateString + " ]) error ?is not yyyyMMdd �> " + e.getMessage());
            return false;
        }
        try {
            byte[] data = {((byte)(ecuSerial >> 16 & 0xFF)), ((byte)(ecuSerial >> 8 & 0xFF)), ((byte)(ecuSerial & 0xFF)), ((byte)(proLineSerial >> 8 & 0xFF)), ((byte)(proLineSerial & 0xFF)), ((byte)Integer.parseInt(((d.getYear() + 1900) % 100 + ""), 16)), ((byte)Integer.parseInt((d.getMonth() + 1 + ""), 16)), ((byte)Integer.parseInt((d.getDate() + ""), 16))};
            Log.i("CarMiscManager", StringFormart.byte2hex(data));
            return this.setSignalValue(9949, data);
        }
        catch(Exception e) {
            Log.e("CarMiscManager", "setFactoryModeEcuAndProductLineSerial() error �> " + e.getMessage());
            return false;
        }
    }

    public boolean setFactoryModeErrorCodeEnabled(boolean enabled) {
        return this.setSignalValue(0x2705, enabled);
    }

    public boolean setFactoryModePartNum(String num) {
        Log.i("CarMiscManager", "setFactoryModePartNum() num: " + num);
        int v = num.trim().length();
        if(v == 0) {
            Log.e("CarMiscManager", "setFactoryModePartNum() error �> num is empty");
            return false;
        }
        byte[] arr = new byte[v + 4];
        arr[0] = -107;
        arr[1] = 2;
        arr[2] = 2;
        arr[3] = (byte)num.length();
        System.arraycopy(num.getBytes(StandardCharsets.UTF_8), 0, arr, 4, v);
        return this.setSignalValue(9939, arr);
    }

    public boolean setFactoryModeReSetDashBoardFactorySetting() {
        try {
            return this.setSignalValue(0x26F3, 3);
        }
        catch(Exception unused_ex) {
            return false;
        }
    }

    public boolean setFactoryModeReSetFactorySettingNotify() {
        try {
            return this.setSignalValue(0x26F3, 1);
        }
        catch(Exception unused_ex) {
            return false;
        }
    }

    public boolean setFactoryModeUUID(String uuid) {
        Log.i("CarMiscManager", "setFactoryModeUUID() uuid: " + uuid);
        int v = uuid.trim().length();
        if(v == 0) {
            Log.e("CarMiscManager", "setFactoryModeUUID() error �> uuid is empty");
            return false;
        }
        byte[] arr = new byte[v + 4];
        arr[0] = -107;
        arr[1] = 11;
        arr[2] = 2;
        arr[3] = (byte)uuid.length();
        System.arraycopy(uuid.getBytes(StandardCharsets.UTF_8), 0, arr, 4, v);
        return this.setSignalValue(9939, arr);
    }

    public boolean setFastSleep() {
        return this.setSignalValue(9939, new byte[]{(byte)0x8F, 0, 0, 4});
    }

    public boolean setKeyboardBacklight(int level) {
        return this.setSignalValue(0x2709, ((short)level));
    }

    public boolean setQueryCarInfoAvmState() {
        return this.setSignalValue(0x26F1, true);
    }

    public boolean setQueryCarInfoCameraRearViewState() {
        return this.setSignalValue(9970, true);
    }

    public boolean setScreenBacklight(int level) {
        return this.setSignalValue(0x2708, level);
    }

    public boolean setScreenTouchEnabled(boolean enabled) {
        return this.setSignalValue(9990, enabled);
    }

    public boolean setSystemTime(Calendar c, boolean isHour24) {
        int v = isHour24 ? 1 : 0;
        int hourVal = (byte)(isHour24 ? c.get(11) : c.get(10));
        Log.i("CarMiscManager", "setSystemTime() isHour24Val=" + ((int)(((byte)v))) + ", hourVal =" + hourVal);
        if(!isHour24) {
            boolean isAm = c.get(9) == 0;
            Log.i("CarMiscManager", "setSystemTime() isAm=" + isAm + ", am_pm=" + c.get(9));
            if(hourVal == 0) {
                return isAm ? this.setSignalValue(0x270A, new byte[]{((byte)(c.get(1) - 2000)), ((byte)(c.get(2) + 1)), ((byte)c.get(5)), 0, ((byte)c.get(12)), ((byte)c.get(13)), ((byte)v)}) : this.setSignalValue(0x270A, new byte[]{((byte)(c.get(1) - 2000)), ((byte)(c.get(2) + 1)), ((byte)c.get(5)), 12, ((byte)c.get(12)), ((byte)c.get(13)), ((byte)v)});
            }
            return isAm ? this.setSignalValue(0x270A, new byte[]{((byte)(c.get(1) - 2000)), ((byte)(c.get(2) + 1)), ((byte)c.get(5)), ((byte)hourVal), ((byte)c.get(12)), ((byte)c.get(13)), ((byte)v)}) : this.setSignalValue(0x270A, new byte[]{((byte)(c.get(1) - 2000)), ((byte)(c.get(2) + 1)), ((byte)c.get(5)), ((byte)(hourVal + 12)), ((byte)c.get(12)), ((byte)c.get(13)), ((byte)v)});
        }
        return this.setSignalValue(0x270A, new byte[]{((byte)(c.get(1) - 2000)), ((byte)(c.get(2) + 1)), ((byte)c.get(5)), ((byte)hourVal), ((byte)c.get(12)), ((byte)c.get(13)), ((byte)v)});
    }

    public boolean turnScreenOnOff(boolean onoff) {
        return this.setSignalValue(0x2707, onoff);
    }

    public void unregisterListener(CarMiscListener listener) {
        this.unregisterReceiver(listener);
    }
}

