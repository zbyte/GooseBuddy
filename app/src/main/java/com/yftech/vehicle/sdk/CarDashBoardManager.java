package com.yftech.vehicle.sdk;

import android.util.Log;

import com.yftech.car.utils.SystemPropertiesHelper;
import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.SignalReceiver;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.AbsDashBoardInfo;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.AbsDashBoardMsg;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.AudioSourceEnableInfo;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.BtInfo;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.DashBoardDataFormater;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.DashBoardType;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.MediaInfo;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.PhoneAction;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.SetItemUnitInfo;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.TimeFormatMode;
import com.yftech.vehicle.internal.adapter.ICarDashBoard;
import com.yftech.vehicle.internal.project.Ihu12DashBoard.NaviGuideBaseInfo;
import com.yftech.vehicle.internal.project.Ihu12DashBoard.NaviUpdateData;
import com.yftech.vehicle.internal.project.Ihu12DashBoard;
import com.yftech.vehicle.internal.utils.StringFormart;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

public class CarDashBoardManager extends BaseApiManager implements ICarDashBoard {
    public static abstract class CarDashBoardListener {
        @SignalReceiver(signalId = 9947)
        public void onDashBoardPhoneActionMsgChanged(ICarDashBoard.PhoneAction action) {
        }

        @SignalReceiver(signalId = 0x26F9)
        public void onDashBoardSettingItemInfoChanged(ICarDashBoard.SetItemUnitInfo info) {
        }

        @SignalReceiver(signalId = 0x26F8)
        public void onDashBoardSettingItemLanguageChanged(int language) {
        }

        @SignalReceiver(signalId = 0x26FA)
        public void onDashBoardSourceChanged(int source) {
        }

        @SignalReceiver(signalId = 9945)
        public void onDashBoardTimeFormatChanged(ICarDashBoard.TimeFormatMode mode) {
        }
    }

    private static final String TAG = "CarDashBoardManager";
    private ICarDashBoard.DashBoardType mDashBoardType;
    private static CarDashBoardManager sMe;

    private CarDashBoardManager(ICarDashBoard.DashBoardType type) {
        this.mDashBoardType = ICarDashBoard.DashBoardType.MCU_CA1105;
        this.mDashBoardType = type;
    }

    public static CarDashBoardManager get() {
        synchronized(CarDashBoardManager.class) {
            try {
                String s = SystemPropertiesHelper.get("ro.product.name");
                if(CarDashBoardManager.sMe == null) {
                    CarDashBoardManager.sMe = s != null && (s.startsWith("CBIHU") || s.startsWith("CB_IHU")) ? new CarDashBoardManager(ICarDashBoard.DashBoardType.MCU_IHU12) : new CarDashBoardManager(ICarDashBoard.DashBoardType.MCU_CA1105);
                }
            }
            catch(Exception unused_ex) {
            }
        }
        return CarDashBoardManager.sMe;
    }

    public int getDashBoardLanguage() {
        return this.getSignalValue(0x26F8).intValue();
    }

    public int getDashBoardSource() {
        return this.getSignalValue(0x26FA).intValue();
    }

    public ICarDashBoard.SetItemUnitInfo getSetItemUnitInfo() {
        return ICarDashBoard.SetItemUnitInfo.valueOf(this.getSignalDataValue(0x26F9));
    }

    public void registerListener(CarDashBoardListener listener) {
        this.registerReceiver(listener);
    }

    public boolean setDashBoardAudioSourceEnableInfo(ICarDashBoard.AudioSourceEnableInfo info) {
        try {
            if(info == null) {
                Log.e("CarDashBoardManager", "setDashBoardAudioSourceEnableInfo()  info is null ");
                return false;
            }
            return this.setSignalValue(9948, info.getDataArray());
        }
        catch(Exception e) {
            Log.e("CarDashBoardManager", "setDashBoardAudioSourceEnableInfo() Exception ", e);
            return false;
        }
    }

    public boolean setDashBoardFMFreqInfo(int freq) {
        switch(freq) {
            case 50: {
                return this.setSignalValue(533, 1);
            }
            case 100: {
                return this.setSignalValue(533, 0);
            }
            default: {
                Log.i("CarDashBoardManager", "setDashBoardFMFreqInfo: illegality freq");
                return false;
            }
        }
    }

    public boolean setDashBoardItemUnit(ICarDashBoard.SetItemUnitInfo unitItem) {
        if(unitItem == null) {
            return false;
        }
        try {
            byte[] arr_b = ICarDashBoard.DashBoardDataFormater.get(this.mDashBoardType).getDashBoardItemUnitByteArray(unitItem);
            Log.d("CarDashBoardManager", StringFormart.byte2hex(arr_b));
            if(arr_b == null) {
                Log.w("CarDashBoardManager", "setDashBoardItem() format data error ! ");
                return false;
            }
            return this.setSignalValue(0x26F9, arr_b);
        }
        catch(Exception e) {
            Log.e("CarDashBoardManager", "setDashBoardItemUnit()  Exception ", e);
            return false;
        }
    }

    public boolean setDashBoardLanguage(int language) {
        try {
            if(language == 0) {
                Log.w("CarDashBoardManager", "setDashBoardLanguage() language ==0 unknown ! ");
                return false;
            }
            byte[] arr_b = ICarDashBoard.DashBoardDataFormater.get(this.mDashBoardType).getDashBoardLanguageByteArray(language);
            Log.d("CarDashBoardManager", StringFormart.byte2hex(arr_b));
            return this.setSignalValue(0x26F8, arr_b);
        }
        catch(Exception e) {
            Log.e("CarDashBoardManager", "setDashBoardLanguage()  Exception ", e);
            return false;
        }
    }

    public boolean setDashBoardMsgNotify(ICarDashBoard.AbsDashBoardMsg msg) {
        byte[] arr_b = ICarDashBoard.DashBoardDataFormater.get(this.mDashBoardType).getDashBoardMsgDataByteArray(msg);
        if(arr_b == null) {
            Log.w("CarDashBoardManager", "setDashBoardMsgNotify() byteArr is null");
            return false;
        }
        Log.d("CarDashBoardManager", "setDashBoardMsgNotify-> [" + StringFormart.byte2hex(arr_b) + " ]");
        return this.setSignalValue(9961, arr_b);
    }

    public boolean setDashBoardSyncSystemTime(Calendar c, boolean isHour24) {
        int v = isHour24 ? 1 : 0;
        int hourVal = (byte)(isHour24 ? c.get(11) : c.get(10));
        Log.i("CarDashBoardManager", "setDashBoardSyncSystemTime() isHour24Val=" + ((int)(((byte)v))) + ", hourVal =" + hourVal);
        if(!isHour24) {
            boolean isAm = c.get(9) == 0;
            Log.i("CarDashBoardManager", "setDashBoardSyncSystemTime() isAm=" + isAm + ", am_pm=" + c.get(9));
            if(hourVal == 0) {
                return isAm ? this.setSignalValue(9946, new byte[]{((byte)(c.get(1) - 2000)), ((byte)(c.get(2) + 1)), ((byte)c.get(5)), 0, ((byte)c.get(12)), ((byte)c.get(13)), ((byte)v)}) : this.setSignalValue(9946, new byte[]{((byte)(c.get(1) - 2000)), ((byte)(c.get(2) + 1)), ((byte)c.get(5)), 12, ((byte)c.get(12)), ((byte)c.get(13)), ((byte)v)});
            }
            return isAm ? this.setSignalValue(9946, new byte[]{((byte)(c.get(1) - 2000)), ((byte)(c.get(2) + 1)), ((byte)c.get(5)), ((byte)hourVal), ((byte)c.get(12)), ((byte)c.get(13)), ((byte)v)}) : this.setSignalValue(9946, new byte[]{((byte)(c.get(1) - 2000)), ((byte)(c.get(2) + 1)), ((byte)c.get(5)), ((byte)(hourVal + 12)), ((byte)c.get(12)), ((byte)c.get(13)), ((byte)v)});
        }
        return this.setSignalValue(9946, new byte[]{((byte)(c.get(1) - 2000)), ((byte)(c.get(2) + 1)), ((byte)c.get(5)), ((byte)hourVal), ((byte)c.get(12)), ((byte)c.get(13)), ((byte)v)});
    }

    public boolean setSendBtInfoToDashBoardForTboxCall(ICarDashBoard.BtInfo bt) {
        if(bt == null) {
            Log.w("CarDashBoardManager", "MCU_IHU12 setSendBtInfoToDashBoardForTboxCall -ECall() byteArr is null");
            return false;
        }
        byte[] arr_b = Ihu12DashBoard.getMediaInfo(((byte)3), ((ICarDashBoard.AbsDashBoardInfo)bt));
        if(bt.mBtStatus == -1 || bt.mBtStatus == 0) {
            arr_b[7] = 0;
        }
        Log.d("CarDashBoardManager", "MCU_IHU12 setSendBtInfoToDashBoardForTboxCall->INFO_TYPE_PHONE_INFO= " + (bt == null ? -1 : bt.getDashBoardSource()) + ",status:" + ((int)bt.mBtStatus) + ",[" + StringFormart.byte2hex(arr_b) + " ]");
        this.setSignalValue(9939, arr_b);
        if(bt != null && bt.mBtStatus == 5) {
            bt.mBtStatus = -1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500L);
                    }
                    catch(InterruptedException unused_ex) {
                    }
                    byte[] arr_b = Ihu12DashBoard.getMediaInfo(((byte)3), ((ICarDashBoard.AbsDashBoardInfo)bt));
                    Log.i("CarDashBoardManager", "MCU_IHU12 setSendDashBoardInfo->STATUS_ENDING_CALL reset call status  ");
                    arr_b[7] = 0;
                    Log.d("CarDashBoardManager", "MCU_IHU12 setSendDashBoardInfo->STATUS_ENDING_CALL= " + (bt == null ? -1 : bt.getDashBoardSource()) + ",[" + StringFormart.byte2hex(arr_b) + " ]");
                    CarDashBoardManager.this.setSignalValue(9939, arr_b);
                }
            }).start();
        }
        return true;
    }

    public boolean setSendDashBoardInfo(ICarDashBoard.AbsDashBoardInfo info) {
        try {
            if(ICarDashBoard.DashBoardType.MCU_IHU12.equals(this.mDashBoardType)) {
                if(info == null) {
                    Log.w("CarDashBoardManager", "MCU_IHU12 setSendDashBoardInfo() byteArr is null");
                    return false;
                }
                byte[] arr_b = Ihu12DashBoard.getDashBoardInfoDataByteArrayForIhu12(info);
                Log.d("CarDashBoardManager", "MCU_IHU12 setSendDashBoardInfo->DashBoardInfo= " + (info == null ? -1 : info.getDashBoardSource()) + ",[" + StringFormart.byte2hex(arr_b) + " ]");
                this.setSignalValue(9939, arr_b);
                switch(info.getDashBoardSource()) {
                    case 4: {
                        if(!(info instanceof ICarDashBoard.BtInfo)) {
                            Log.w("CarDashBoardManager", "getMediaInfo() - PHONE_NUMBER info is not BtInfo");
                            return false;
                        }
                        byte[] byteArr = Ihu12DashBoard.getMediaInfo(((byte)3), info);
                        Log.d("CarDashBoardManager", "MCU_IHU12 setSendDashBoardInfo->INFO_TYPE_PHONE_INFO= " + info.getDashBoardSource() + ",[" + StringFormart.byte2hex(byteArr) + " ]");
                        this.setSignalValue(9939, byteArr);
                        if(Ihu12DashBoard.isBtInfoChange(info)) {
                            byteArr = Ihu12DashBoard.getMediaInfo(((byte)5), info);
                            Log.d("CarDashBoardManager", "MCU_IHU12 setSendDashBoardInfo->INFO_TYPE_PHONE_NAME= " + info.getDashBoardSource() + ",[" + StringFormart.byte2hex(byteArr) + " ]");
                            this.setSignalValue(9939, byteArr);
                            if(((ICarDashBoard.BtInfo)info) != null && ((ICarDashBoard.BtInfo)info).mBtName != null && !((ICarDashBoard.BtInfo)info).mBtName.equals("")) {
                                ((ICarDashBoard.BtInfo)info).mBtCallNumber = "";
                            }
                            byteArr = Ihu12DashBoard.getMediaInfo(((byte)4), ((ICarDashBoard.AbsDashBoardInfo)(((ICarDashBoard.BtInfo)info))));
                            Log.d("CarDashBoardManager", "MCU_IHU12 setSendDashBoardInfo->INFO_TYPE_PHONE_NUMBER= " + (((ICarDashBoard.BtInfo)info) == null ? -1 : ((ICarDashBoard.BtInfo)info).getDashBoardSource()) + ",[" + StringFormart.byte2hex(byteArr) + " ]");
                            this.setSignalValue(9939, byteArr);
                        }
                        if(((ICarDashBoard.BtInfo)info) != null && ((ICarDashBoard.BtInfo)info).mBtStatus == 7) {
                            byteArr = Ihu12DashBoard.getMediaInfo(((byte)6), info);
                            Log.d("CarDashBoardManager", "MCU_IHU12 setSendDashBoardInfo->INFO_TYPE_PHONE_TIMES= " + info.getDashBoardSource() + ",[" + StringFormart.byte2hex(byteArr) + " ]");
                            this.setSignalValue(9939, byteArr);
                        }
                        if(((ICarDashBoard.BtInfo)info) != null && ((ICarDashBoard.BtInfo)info).mBtStatus == 5) {
                            ((ICarDashBoard.BtInfo)info).mBtStatus = -1;
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(500L);
                                    }
                                    catch(InterruptedException unused_ex) {
                                    }
                                    byte[] arr_b = Ihu12DashBoard.getMediaInfo(((byte)3), ((ICarDashBoard.AbsDashBoardInfo)((ICarDashBoard.BtInfo)info)));
                                    Log.i("CarDashBoardManager", "MCU_IHU12 setSendDashBoardInfo->STATUS_ENDING_CALL reset call status  ");
                                    arr_b[7] = 0;
                                    Log.d("CarDashBoardManager", "MCU_IHU12 setSendDashBoardInfo->STATUS_ENDING_CALL= " + (info == null ? -1 : ((ICarDashBoard.BtInfo)info).getDashBoardSource()) + ",[" + StringFormart.byte2hex(arr_b) + " ]");
                                    CarDashBoardManager.this.setSignalValue(9939, arr_b);
                                }
                            }).start();
                        }
                        Ihu12DashBoard.setCurrentSource(info.getDashBoardSource());
                        return true;
                    }
                    case 15: {
                        if(Ihu12DashBoard.isDabProgramInfoChange(info)) {
                            byte[] byteArr = Ihu12DashBoard.getDabProgramInfo(info);
                            Log.d("CarDashBoardManager", "MCU_IHU12 setSendDashBoardInfo->INFO_TYPE_DAB_TITLE= " + info.getDashBoardSource() + ",[" + StringFormart.byte2hex(byteArr) + " ]");
                            this.setSignalValue(9939, byteArr);
                        }
                        Ihu12DashBoard.setCurrentSource(info.getDashBoardSource());
                        return true;
                    }
                    case 2: 
                    case 3: 
                    case 5: 
                    case 9: 
                    case 12: 
                    case 13: 
                    case 14: 
                    case 16: {
                        switch(info.getDashBoardSource()) {
                            case 12: 
                            case 13: {
                                ((ICarDashBoard.MediaInfo)info).title = "";
                                ((ICarDashBoard.MediaInfo)info).artist = "";
                            }
                        }
                        boolean z = Ihu12DashBoard.isMediaChange(info);
                        Log.d("CarDashBoardManager", "MCU_IHU12 setSendDashBoardInfo->isMediaChange-0 = " + z + ",getDashBoardSource=" + info.getDashBoardSource());
                        if(z) {
                            byte[] byteArr = Ihu12DashBoard.getMediaInfo(((byte)1), info);
                            Log.d("CarDashBoardManager", "MCU_IHU12 setSendDashBoardInfo->INFO_TYPE_SONG_TITLE= " + info.getDashBoardSource() + ",[" + StringFormart.byte2hex(byteArr) + " ]");
                            this.setSignalValue(9939, byteArr);
                            byteArr = Ihu12DashBoard.getMediaInfo(((byte)2), info);
                            Log.d("CarDashBoardManager", "MCU_IHU12 setSendDashBoardInfo->INFO_TYPE_SONG_ARTIST= " + info.getDashBoardSource() + ",[" + StringFormart.byte2hex(byteArr) + " ]");
                            this.setSignalValue(9939, byteArr);
                            return true;
                        }
                        return true;
                    }
                    default: {
                        return true;
                    }
                }
            }
            byte[] arr_b8 = ICarDashBoard.DashBoardDataFormater.get(this.mDashBoardType).getDashBoardInfoDataByteArray(info);
            if(arr_b8 == null) {
                Log.w("CarDashBoardManager", "setSendDashBoardInfo() byteArr is null");
                return false;
            }
            Log.d("CarDashBoardManager", "setSendDashBoardInfo->source= " + (info == null ? -1 : info.getDashBoardSource()) + ",[" + StringFormart.byte2hex(arr_b8) + " ]");
            return this.setSignalValue(0x2702, arr_b8);
        }
        catch(Exception e) {
            Log.e("CarDashBoardManager", e.getMessage());
            return false;
        }
    }

    public boolean setSendDashBoardMusicArtImage(byte[] imageBytes) {
        if(imageBytes == null) {
            Log.w("CarDashBoardManager", "setSendDashBoardMusicArtImage() imageBytes is null");
            return false;
        }
        return this.setSignalValue(0x2701, imageBytes);
    }

    public boolean setSendDashBoardNaviGuideBaseInfoForIhu12(Ihu12DashBoard.NaviGuideBaseInfo info) {
        if(info == null) {
            Log.w("CarDashBoardManager", "setSendDashBoardNaviGuideInfoForIhu12() info is null");
            return false;
        }
        try {
            this.setSignalValue(9939, Ihu12DashBoard.getNaviGuideBaseInfoDataProtocol(((byte)7), info));
            this.setSignalValue(9939, Ihu12DashBoard.getNaviGuideBaseInfoDataProtocol(((byte)8), info));
            Ihu12DashBoard.getNaviGuideBaseInfoDataProtocol(((byte)9), info);
            this.setSignalValue(9939, Ihu12DashBoard.getNaviGuideBaseInfoDataProtocol(((byte)10), info));
            return true;
        }
        catch(Exception e) {
            Log.e("CarDashBoardManager", "setSendDashBoardNaviGuideInfo()  Exception ", e);
            return false;
        }
    }

    public boolean setSendDashBoardNaviGuideInfo(int naviDirIcon, int distance, String nextRoadName) {
        if(nextRoadName == null) {
            Log.w("CarDashBoardManager", "setSendDashBoardNaviGuideInfo() nextRoadName is null");
            return false;
        }
        try {
            int len = nextRoadName.getBytes(StandardCharsets.UTF_8).length;
            byte[] resarr = new byte[len + 2];
            resarr[0] = (byte)(naviDirIcon & 0xFF);
            resarr[1] = (byte)(distance & 0xFF);
            System.arraycopy(nextRoadName.getBytes(StandardCharsets.UTF_8), 0, resarr, 2, len);
            return this.setSignalValue(0x2700, resarr);
        }
        catch(Exception e) {
            Log.e("CarDashBoardManager", "setSendDashBoardNaviGuideInfo()  Exception ", e);
            return false;
        }
    }

    public boolean setSendDashBoardNaviGuideUpdateInfoForIhu12(Ihu12DashBoard.NaviUpdateData data) {
        if(data == null) {
            Log.w("CarDashBoardManager", "setSendDashBoardNaviGuideUpdateInfoForIhu12() info is null");
            return false;
        }
        try {
            this.setSignalValue(9939, Ihu12DashBoard.getNaviGuideUpdateDataProtocol(data));
            return true;
        }
        catch(Exception e) {
            Log.e("CarDashBoardManager", "setSendDashBoardNaviGuideUpdateInfoForIhu12()  Exception ", e);
            return false;
        }
    }

    public boolean setSendDashBoardSource(int source, ICarDashBoard.AbsDashBoardInfo info) {
        try {
            if(!ICarDashBoard.DashBoardType.MCU_IHU12.equals(this.mDashBoardType)) {
                byte[] arr_b = ICarDashBoard.DashBoardDataFormater.get(this.mDashBoardType).getDashBoardSourceDataByteArray(source, info);
                if(arr_b == null || arr_b.length <= 1) {
                    Log.w("CarDashBoardManager", "setSendDashBoardSource() byteArr is null info=" + info);
                    return false;
                }
                Log.d("CarDashBoardManager", "setSendDashBoardSource->source=" + source + ",[" + StringFormart.byte2hex(arr_b) + " ]");
                return ICarDashBoard.DashBoardDataFormater.get(this.mDashBoardType).isSendMediaInfoOnly() ? this.setSignalValue(0x2702, arr_b) : this.setSignalValue(0x2702, arr_b);
            }
            Ihu12DashBoard.setCurrentSource(source);
            byte[] arr_b1 = Ihu12DashBoard.getDashBoardSourceDataByteArray(source, info);
            if(arr_b1 == null) {
                Log.d("CarDashBoardManager", "MCU_IHU12  setSendDashBoardSource->source= " + source + ",byteArr=null return!");
            }
            else {
                Log.d("CarDashBoardManager", "MCU_IHU12  setSendDashBoardSource->source= " + (info == null ? -1 : info.getDashBoardSource()) + ",[" + StringFormart.byte2hex(arr_b1) + " ]");
                this.setSignalValue(9939, arr_b1);
            }
            switch(source) {
                case 12: 
                case 13: 
                case 14: {
                    ICarDashBoard.MediaInfo m = new ICarDashBoard.MediaInfo(source);
                    m.title = "";
                    m.artist = "";
                    this.setSendDashBoardInfo(((ICarDashBoard.AbsDashBoardInfo)m));
                    return true;
                }
                case 15: {
                    this.setSendDashBoardInfo(info);
                    return true;
                }
                default: {
                    return true;
                }
            }
        }
        catch(Exception e) {
            Log.e("CarDashBoardManager", e.getMessage());
            return false;
        }
    }

    public void unregisterListener(CarDashBoardListener listener) {
        this.unregisterReceiver(listener);
    }
}

