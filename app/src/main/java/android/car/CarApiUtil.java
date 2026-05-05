package android.car;

import android.car.settings.CarSettings;

public final class CarApiUtil {
    public static final String CAR_NOT_CONNECTED_EXCEPTION_MSG = "CarNotConnected";

    public static void checkCarNotConnectedExceptionFromCarService(IllegalStateException e) throws CarNotConnectedException {
        if(!e.getMessage().equals("CarNotConnected")) {
            throw e;
        }
        throw new CarNotConnectedException();
    }

    public static int[] decodeGarageTimeSetting(String time) {
        int[] result = CarSettings.DEFAULT_GARAGE_MODE_WAKE_UP_TIME;
        if(time == null) {
            return result;
        }
        String[] arr_s = time.split(":");
        if(arr_s.length != 2) {
            return result;
        }
        try {
            result[0] = (int)Integer.valueOf(arr_s[0]);
            result[1] = (int)Integer.valueOf(arr_s[1]);
            return result[0] < 0 || result[0] > 23 || result[1] < 0 || result[1] > 59 ? CarSettings.DEFAULT_GARAGE_MODE_WAKE_UP_TIME : result;
        }
        catch(NumberFormatException unused_ex) {
            return CarSettings.DEFAULT_GARAGE_MODE_WAKE_UP_TIME;
        }
    }

    public static String encodeGarageTimeSetting(int hour, int min) {
        return hour + ":" + min;
    }
}

