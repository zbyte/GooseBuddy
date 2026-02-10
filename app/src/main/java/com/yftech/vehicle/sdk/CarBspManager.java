package com.yftech.vehicle.sdk;

import android.util.Log;
import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.ICarBsp.DisplayDtc;
import com.yftech.vehicle.internal.adapter.ICarBsp;
import com.yftech.vehicle.internal.utils.StringFormart;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CarBspManager extends BaseApiManager implements ICarBsp {
    public static abstract class CarBspListener {
        @SignalReceiver(signalId = 0x26F6)
        public void onBspInfoSearchCmdStateChanged(int retCmd) {
        }

        @SignalReceiver(signalId = 9963, valueToEnabledState = true)
        public void onDisplayConnectedStateChanged(boolean connected) {
        }

        @SignalReceiver(signalId = 0x26F5)
        public void onDisplayDtcStateChanged(ICarBsp.DisplayDtc cmd) {
        }

        @SignalReceiver(signalId = 0x2707, valueToEnabledState = true)
        public void onDisplayLcdOnOffStateChanged(boolean onOff) {
        }

        @SignalReceiver(signalId = 9950, valueToEnabledState = true)
        public void onDisplayLightBarEnableChanged(boolean enable) {
        }

        @SignalReceiver(signalId = 0x26DF)
        public void onDisplayLightBarLevelChanged(int level) {
        }

        @SignalReceiver(signalId = 9990, valueToEnabledState = true)
        public void onDisplayTouchEnableStateChanged(boolean enable) {
        }
    }

    private static final String TAG = "CarBspManager";
    private static CarBspManager sMe;

    public static CarBspManager get() {
        CarBspManager carBspManager0;
        synchronized(CarBspManager.class) {
            if(CarBspManager.sMe == null) {
                carBspManager0 = new CarBspManager();
                CarBspManager.sMe = carBspManager0;
            }
            else {
                carBspManager0 = CarBspManager.sMe;
            }
            return carBspManager0;
        }
    }

    public ICarBsp.DisplayDtc getDisplayDtcInfo() {
        return ICarBsp.DisplayDtc.valueOf(this.getSignalValue(0x26F5).intValue());
    }

    public boolean getDisplayLightBarEnable() {
        return this.getSignalValue(9950).intValue() == 1;
    }

    public int getDisplayLightBarLevel() {
        return this.getSignalValue(0x26DF).intValue();
    }

    public boolean isDisplayConnected() {
        return this.getSignalValue(9963).byteValue() == 1;
    }

    public boolean queryBspInfoCmd(byte bspCmd) {
        return this.setSignalValue(0x26F6, bspCmd);
    }

    public void registerListener(CarBspListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setBspAMPMute(boolean isMute) {
        return this.setSignalValue(9962, isMute);
    }

    public boolean setDisplayCreateDate(String dateString) {
        Date d;
        if(dateString == null || dateString.length() != 6) {
            Log.e("CarBspManager", "setDisplayCreateDate()  dateString is null or length!=6 error ,date =" + dateString);
            return false;
        }
        try {
            d = new SimpleDateFormat("ddMMyy").parse(dateString);
        }
        catch(Exception e) {
            Log.e("CarBspManager", "setDisplayCreateDate() SimpleDateFormat.parse([ " + dateString + " ]) error ?is not ddMMyy > " + e.getMessage());
            return false;
        }
        try {
            String s1 = new SimpleDateFormat("ddMMyy").format(d);
            Log.i("CarBspManager", StringFormart.byte2hex(s1.getBytes(StandardCharsets.US_ASCII)));
            return this.setSignalValue(9964, s1.getBytes(StandardCharsets.US_ASCII));
        }
        catch(Exception e) {
            Log.e("CarBspManager", "setDisplayCreateDate() error > " + e.getMessage());
            return false;
        }
    }

    public boolean setDisplayLightBarEnable(boolean enable) {
        return this.setSignalValue(9950, enable);
    }

    public boolean setDisplayLightBarLevel(int level) {
        return this.setSignalValue(0x26DF, level);
    }

    public boolean setDisplaySnInfo(String sn) {
        if(sn == null || sn.length() != 10) {
            Log.e("CarBspManager", "setDisplaySnInfo()  sn.length!=10 error ,sn =" + sn);
            return false;
        }
        Log.i("CarBspManager", StringFormart.byte2hex(sn.getBytes(StandardCharsets.US_ASCII)));
        return this.setSignalValue(9965, sn.getBytes(StandardCharsets.US_ASCII));
    }

    public void unregisterListener(CarBspListener listener) {
        this.unregisterReceiver(listener);
    }
}

