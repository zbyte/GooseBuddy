package com.yftech.vehicle.sdk;

import android.util.Log;
import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.adapter.IBaseCmd;
import com.yftech.vehicle.internal.adapter.ICarEvDevice.RepeatBookMode;
import com.yftech.vehicle.internal.project.Ihu23Project.ChargeInfo;
import com.yftech.vehicle.internal.project.Ihu23Project.ChargeMode;
import com.yftech.vehicle.internal.project.Ihu23Project;
import com.yftech.vehicle.internal.utils.StringFormart;

public class Ihu23ProjectManager extends BaseApiManager implements IBaseCmd {
    public static abstract class ProjectIhu23Listener {
    }

    private static final String TAG = "Ihu23ProjectManager";
    private static Ihu23ProjectManager sMe;

    public static Ihu23ProjectManager get() {
        Ihu23ProjectManager ihu23ProjectManager0;
        synchronized(Ihu23ProjectManager.class) {
            if(Ihu23ProjectManager.sMe == null) {
                ihu23ProjectManager0 = new Ihu23ProjectManager();
                Ihu23ProjectManager.sMe = ihu23ProjectManager0;
            }
            else {
                ihu23ProjectManager0 = Ihu23ProjectManager.sMe;
            }
            return ihu23ProjectManager0;
        }
    }

    public Ihu23Project.ChargeInfo getChargeInfo() {
        boolean z = true;
        Ihu23Project.ChargeInfo info = new Ihu23Project.ChargeInfo();
        info.bookChrgStartRemainingDay = CarEvDeviceManager.get().getBookChrgStartRemainingDay();
        info.bookChrgStartRemainingHour = CarEvDeviceManager.get().getBookChrgStartRemainingHour();
        info.bookChrgStartRemainingMin = CarEvDeviceManager.get().getBookChrgStartRemainingMin();
        info.bookStartYear = CarEvDeviceManager.get().getBookChrgStartYear();
        info.bookStartDay = CarEvDeviceManager.get().getBookChrgStartDay();
        info.bookStartMon = CarEvDeviceManager.get().getBookChrgStartMon();
        info.bookStartHour = CarEvDeviceManager.get().getBookChrgStartHour();
        info.bookStartMin = CarEvDeviceManager.get().getBookChrgStartMin();
        info.bookStopYear = CarEvDeviceManager.get().getBookChrgStopYear();
        info.bookStopDay = CarEvDeviceManager.get().getBookChrgStopDay();
        info.bookStopMon = CarEvDeviceManager.get().getBookChrgStopMon();
        info.bookStopHour = CarEvDeviceManager.get().getBookChrgStopHour();
        info.bookStopMin = CarEvDeviceManager.get().getBookChrgStopMin();
        info.bookChrgMode = Ihu23Project.ChargeMode.valueOf(CarEvDeviceManager.get().getChargeMode().value);
        info.repeatBookChrgDay1 = CarEvDeviceManager.get().getRepeatBookChrgDay1() == ICarEvDevice.RepeatBookMode.BOOKING;
        info.repeatBookChrgDay2 = CarEvDeviceManager.get().getRepeatBookChrgDay2() == ICarEvDevice.RepeatBookMode.BOOKING;
        info.repeatBookChrgDay3 = CarEvDeviceManager.get().getRepeatBookChrgDay3() == ICarEvDevice.RepeatBookMode.BOOKING;
        info.repeatBookChrgDay4 = CarEvDeviceManager.get().getRepeatBookChrgDay4() == ICarEvDevice.RepeatBookMode.BOOKING;
        info.repeatBookChrgDay5 = CarEvDeviceManager.get().getRepeatBookChrgDay5() == ICarEvDevice.RepeatBookMode.BOOKING;
        info.repeatBookChrgDay6 = CarEvDeviceManager.get().getRepeatBookChrgDay6() == ICarEvDevice.RepeatBookMode.BOOKING;
        if(CarEvDeviceManager.get().getRepeatBookChrgDay7() != ICarEvDevice.RepeatBookMode.BOOKING) {
            z = false;
        }
        info.repeatBookChrgDay7 = z;
        return info;
    }

    public void registerListener(ProjectIhu23Listener listener) {
        this.registerReceiver(listener);
    }

    public boolean setChargeInfo(Ihu23Project.ChargeInfo info) {
        if(info == null) {
            Log.w("Ihu23ProjectManager", "setChargeInfo() - info is null ");
            return false;
        }
        if(info.bookStartYear < 2000) {
            Log.w("Ihu23ProjectManager", "setChargeInfo() - info.bookStartYear <2000 ");
            return false;
        }
        if(info.bookStopYear < 2000) {
            Log.w("Ihu23ProjectManager", "setChargeInfo() - info.bookStopYear <2000 ");
            return false;
        }
        byte[] arr_b = Ihu23Project.formartChargeInfoByteArray(info);
        Log.d("Ihu23ProjectManager", "MCU_IHU23 setChargeInfo-> [" + StringFormart.byte2hex(arr_b) + " ]");
        return this.setSignalValue(9939, arr_b);
    }

    public void unregisterListener(ProjectIhu23Listener listener) {
        this.unregisterReceiver(listener);
    }
}

