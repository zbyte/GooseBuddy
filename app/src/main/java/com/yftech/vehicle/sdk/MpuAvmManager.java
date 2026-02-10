package com.yftech.vehicle.sdk;

import android.os.SystemProperties;
import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.IMpuAvm.AvmCalibrationState;
import com.yftech.vehicle.internal.adapter.IMpuAvm.AvmCameraState;
import com.yftech.vehicle.internal.adapter.IMpuAvm.AvmDisplayState;
import com.yftech.vehicle.internal.adapter.IMpuAvm.AvmFullScreenSwtich;
import com.yftech.vehicle.internal.adapter.IMpuAvm.AvmHeartState;
import com.yftech.vehicle.internal.adapter.IMpuAvm.AvmWorkMode;
import com.yftech.vehicle.internal.adapter.IMpuAvm.Language;
import com.yftech.vehicle.internal.adapter.IMpuAvm;

public class MpuAvmManager extends BaseApiManager implements IMpuAvm {
    public static abstract class MpuAvmListener {
        @SignalReceiver(signalId = 9933)
        public void onNotifyAvmCalibrationStateByAvm(IMpuAvm.AvmCalibrationState state) {
        }

        @SignalReceiver(signalId = 9927)
        public void onNotifyAvmCameraStateByAvm(IMpuAvm.AvmCameraState state) {
        }

        @SignalReceiver(signalId = 9934)
        public void onNotifyAvmDisplayStateByAvm(IMpuAvm.AvmDisplayState state) {
        }

        @SignalReceiver(signalId = 9931)
        public void onNotifyAvmFullScreenSwtichByRadarByAvm(IMpuAvm.AvmFullScreenSwtich state) {
        }

        @SignalReceiver(signalId = 9932)
        public void onNotifyAvmFullScreenSwtichByTurnLightByAvm(IMpuAvm.AvmFullScreenSwtich state) {
        }

        @SignalReceiver(signalId = 9928)
        public void onNotifyAvmHeartStateByAvm(IMpuAvm.AvmHeartState state) {
        }

        @SignalReceiver(signalId = 9929)
        public void onNotifyAvmWorkModeByAvm(IMpuAvm.AvmWorkMode mode) {
        }
    }

    private static final String TAG = "MpuAvmManager";
    private static MpuAvmManager sMe;

    public static MpuAvmManager get() {
        MpuAvmManager mpuAvmManager0;
        synchronized(MpuAvmManager.class) {
            if(MpuAvmManager.sMe == null) {
                mpuAvmManager0 = new MpuAvmManager();
                MpuAvmManager.sMe = mpuAvmManager0;
            }
            else {
                mpuAvmManager0 = MpuAvmManager.sMe;
            }
            return mpuAvmManager0;
        }
    }

    public String getAvmVersion() {
        try {
            return SystemProperties.get("persist.version.avm.software ", "20200619V1.0");
        }
        catch(Exception unused_ex) {
            return "20200619V1.0";
        }
    }

    public IMpuAvm.AvmDisplayState getNotifyAvmDisplayStateByAvm() {
        return IMpuAvm.AvmDisplayState.valueOf(this.getSignalValue(9934).intValue());
    }

    public IMpuAvm.AvmHeartState getNotifyAvmHeartStateByAvm() {
        return IMpuAvm.AvmHeartState.valueOf(this.getSignalValue(9928).intValue());
    }

    public void registerListener(MpuAvmListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setAvmDisplayStateByMpuReq(IMpuAvm.AvmDisplayState state) {
        return this.setSignalValue(0x26CF, state.value);
    }

    public boolean setAvmLanguage(IMpuAvm.Language lan) {
        return this.setSignalValue(9926, lan.value);
    }

    public void unregisterListener(MpuAvmListener listener) {
        this.unregisterReceiver(listener);
    }
}

