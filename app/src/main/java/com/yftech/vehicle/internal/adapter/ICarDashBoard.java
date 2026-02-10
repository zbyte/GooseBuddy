package com.yftech.vehicle.internal.adapter;

import android.util.Log;
import com.yftech.vehicle.internal.utils.StringFormart;
import java.nio.charset.StandardCharsets;

public interface ICarDashBoard {
    public static abstract class AbsDashBoardInfo {
        private int dashBoardSource;

        public AbsDashBoardInfo(int v) {
            this.dashBoardSource = v;
        }

        public int getDashBoardSource() {
            return this.dashBoardSource;
        }

        public void setDashBoardSource(int v) {
            this.dashBoardSource = v;
        }

        public abstract byte[] toBytes();

        @Override
        public abstract String toString();
    }

    public static abstract class AbsDashBoardMsg {
    }

    public static class AudioSourceEnableInfo {
        public static final byte STATE_DISABLE = 0;
        public static final byte STATE_ENABLE = 1;
        public byte mBtState;
        public byte mCarLifeState;
        public byte mCarPlayState;
        public byte mUsb1State;
        public byte mUsb2State;

        public AudioSourceEnableInfo() {
            this.mUsb1State = 0;
            this.mUsb2State = 0;
            this.mCarLifeState = 0;
            this.mCarPlayState = 0;
            this.mBtState = 0;
        }

        // String Decryptor: 1 succeeded, 0 failed
        public byte[] getDataArray() {
            return new byte[]{this.mUsb1State, this.mCarLifeState, this.mCarPlayState, this.mBtState, this.mUsb2State};
        }

        @Override
        public String toString() {
            return "AudioSourceEnableInfo{mUsb1State=" + ((int)this.mUsb1State) + "mUsb2State=" + ((int)this.mUsb2State) + ", mCarLifeState=" + ((int)this.mCarLifeState) + ", mCarPlayState=" + ((int)this.mCarPlayState) + ", mBtState=" + ((int)this.mBtState) + '}';
        }
    }

    public static class BtInfo extends AbsDashBoardInfo {
        public static final byte PHONE_SOURCE_TYPE_BCALL = 5;
        public static final byte PHONE_SOURCE_TYPE_BT = 0;
        public static final byte PHONE_SOURCE_TYPE_CARLIFE = 1;
        public static final byte PHONE_SOURCE_TYPE_CARPLAY = 2;
        public static final byte PHONE_SOURCE_TYPE_ECALL = 4;
        public static final byte PHONE_SOURCE_TYPE_HICAR = 3;
        public static final byte STATUS_CALL_ONLINE = 4;
        public static final byte STATUS_CALL_ONLINE_TIME = 7;
        public static final byte STATUS_CONNECTED = 1;
        public static final byte STATUS_ENDING_CALL = 5;
        public static final byte STATUS_INCOMING_CALL = 2;
        public static final byte STATUS_MISS_CALL = 6;
        public static final byte STATUS_NOT_CONNECT = 0;
        public static final byte STATUS_OUTGOING_CALL = 3;
        public static final byte STATUS_UNKNOW = -1;
        public String mBtCallNumber;
        public String mBtName;
        public byte mBtStatus;
        public boolean mIsMute;
        public byte mPhoneSourceType;
        public int talkTimes;

        public BtInfo() {
            super(4);
            this.mBtName = "";
            this.mBtCallNumber = "";
            this.mPhoneSourceType = 0;
            this.talkTimes = 0;
        }

        public boolean isInfoDiff(BtInfo iCarDashBoard$BtInfo0) {
            return iCarDashBoard$BtInfo0 == null ? true : this.mBtCallNumber != iCarDashBoard$BtInfo0.mBtCallNumber;
        }

        public void setInfoDiff(BtInfo iCarDashBoard$BtInfo0) {
            this.mBtCallNumber = iCarDashBoard$BtInfo0.mBtCallNumber;
        }

        @Override  // com.yftech.vehicle.internal.adapter.ICarDashBoard$AbsDashBoardInfo
        public byte[] toBytes() {
            return new byte[0];
        }

        @Override  // com.yftech.vehicle.internal.adapter.ICarDashBoard$AbsDashBoardInfo
        public String toString() {
            return "BtInfo{mBtStatus=" + ((int)this.mBtStatus) + ", mIsMute=" + this.mIsMute + ", mBtName=\'" + this.mBtName + '\'' + ", mBtCallNumber=\'" + this.mBtCallNumber + '\'' + ", mPhoneSourceType=" + ((int)this.mPhoneSourceType) + ", talkTimes=" + this.talkTimes + '}';
        }
    }

    public static class DABInfo extends AbsDashBoardInfo {
        public String mDabProgramName;

        public DABInfo() {
            super(15);
            this.mDabProgramName = "";
        }

        public DABInfo(String s) {
            super(15);
            this.mDabProgramName = "";
            this.mDabProgramName = s;
        }

        @Override  // com.yftech.vehicle.internal.adapter.ICarDashBoard$AbsDashBoardInfo
        public byte[] toBytes() {
            return new byte[0];
        }

        @Override  // com.yftech.vehicle.internal.adapter.ICarDashBoard$AbsDashBoardInfo
        public String toString() {
            return "DABInfo{dabProgramName=" + this.mDabProgramName + '}';
        }
    }

    public static class DashBoardDataFormater {
        String TAG;
        static DashBoardDataFormater instance;
        static AbsDashBoardInfo mAbsInfo;
        DashBoardType mDashBoardType;

        private DashBoardDataFormater(DashBoardType iCarDashBoard$DashBoardType0) {
            this.TAG = "DashBoardDataFormater";
            this.mDashBoardType = iCarDashBoard$DashBoardType0;
        }

        public static DashBoardDataFormater get(DashBoardType iCarDashBoard$DashBoardType0) {
            if(DashBoardDataFormater.instance == null) {
                DashBoardDataFormater.instance = new DashBoardDataFormater(iCarDashBoard$DashBoardType0);
            }
            return DashBoardDataFormater.instance;
        }

        public byte[] getDashBoardInfoDataByteArray(AbsDashBoardInfo iCarDashBoard$AbsDashBoardInfo0) {
            String s8;
            String s6;
            int v9;
            byte b;
            int v6;
            int v5;
            int v4;
            boolean z;
            int v;
            if(iCarDashBoard$AbsDashBoardInfo0 == null) {
                Log.w(this.TAG, "formartMediaInfoDataBytes() info is null");
                return null;
            }
            try {
                Log.w(this.TAG, " info:" + iCarDashBoard$AbsDashBoardInfo0.toString());
                if(!DashBoardType.MCU_CA1105.equals(this.mDashBoardType)) {
                    return null;
                }
                switch(iCarDashBoard$AbsDashBoardInfo0.getDashBoardSource()) {
                    case 1: {
                        if(!(iCarDashBoard$AbsDashBoardInfo0 instanceof RadioInfo)) {
                            Log.w(this.TAG, "formartDashBoardInfoDataBytes() AbsDashBoardInfo is not RadioInfo");
                            return null;
                        }
                        if(DashBoardDataFormater.mAbsInfo != null && (DashBoardDataFormater.mAbsInfo instanceof RadioInfo)) {
                            RadioInfo iCarDashBoard$RadioInfo0 = (RadioInfo)DashBoardDataFormater.mAbsInfo;
                            if(iCarDashBoard$RadioInfo0.isInfoDiff(((RadioInfo)iCarDashBoard$AbsDashBoardInfo0))) {
                                iCarDashBoard$RadioInfo0.setInfoDiff(((RadioInfo)iCarDashBoard$AbsDashBoardInfo0));
                                v = 1;
                            }
                            else {
                                v = 0;
                            }
                        } else {
                            DashBoardDataFormater.mAbsInfo = new RadioInfo();
                            v = 1;
                        }
                        Log.d(this.TAG, "formartDashBoardInfoDataBytes() isRadioUpdate =" + ((boolean)v));
                        byte[] arr_b = new byte[20];
                        arr_b[0] = (byte)this.mDashBoardType.ordinal();
                        arr_b[1] = 3;
                        arr_b[2] = 17;
                        arr_b[3] = (byte)v;
                        arr_b[4] = 0;
                        switch(((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).mBandType) {
                            case 3: 
                            case 4: 
                            case 5: {
                                z = true;
                                break;
                            }
                            default: {
                                z = false;
                            }
                        }
                        arr_b[5] = z ? 16 : 1;
                        arr_b[6] = 1;
                        if(((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).isPrefebIndex) {
                            arr_b[7] = 1;
                            arr_b[8] = ((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).mPrefebIndex;
                        }
                        else {
                            arr_b[7] = 0;
                            arr_b[8] = 0;
                        }
                        if(z) {
                            int v1 = 0xF0;
                            int v2 = ((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).mFrequency % 100000 / 1000;
                            int v3 = ((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).mFrequency % 100000 / 100 % 10;
                            if(v2 != 0) {
                                v1 = v2 << 4;
                            }
                            else if(v3 == 0) {
                                v3 = 15;
                            }
                            v4 = v1 | v3;
                            v5 = Integer.parseInt(String.valueOf(((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).mFrequency % 100000 % 100), 16);
                            v6 = Integer.parseInt(String.valueOf(((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).mFrequency % 10000 % 10), 16);
                        }
                        else {
                            int v7 = ((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).mFrequency % 1000000 / 100000;
                            if(v7 == 0) {
                                v7 = 15;
                            }
                            v4 = v7 | 0xF0;
                            v5 = Integer.parseInt(String.valueOf(((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).mFrequency % 1000000 / 1000 % 100), 16);
                            v6 = Integer.parseInt(String.valueOf(((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).mFrequency % 1000000 / 100 % 10 + 10), 16);
                        }
                        arr_b[9] = (byte)v4;
                        arr_b[10] = (byte)v5;
                        arr_b[11] = (byte)v6;
                        arr_b[12] = -16;
                        arr_b[13] = z ? 2 : 1;
                        arr_b[14] = 4;
                        arr_b[15] = 0;
                        arr_b[16] = 0;
                        arr_b[17] = 0;
                        arr_b[18] = 4;
                        arr_b[19] = 0;
                        return arr_b;
                    }
                    case 4: {
                        if(!(iCarDashBoard$AbsDashBoardInfo0 instanceof BtInfo)) {
                            Log.w(this.TAG, "formartDashBoardInfoDataBytes() BT BtInfo is null or AbsDashBoardInfo is not BtInfo");
                            return null;
                        }
                        String s = ((BtInfo)iCarDashBoard$AbsDashBoardInfo0).mBtCallNumber;
                        String s1 = ((BtInfo)iCarDashBoard$AbsDashBoardInfo0).mBtName;
                        if(s != null && !"".equals(s)) {
                            s = s + " ";
                        }
                        byte[] arr_b1 = s == null ? new byte[0] : s.getBytes(StandardCharsets.UTF_16BE);
                        int v8 = arr_b1 == null ? 0 : arr_b1.length;
                        if(v8 >= 50) {
                            String s2 = s.substring(0, 21) + "... ";
                            arr_b1 = s2 == null ? new byte[0] : s2.getBytes(StandardCharsets.UTF_16BE);
                            v8 = arr_b1 == null ? 0 : arr_b1.length;
                        }
                        if(s1 != null && !"".equals(s1)) {
                            arr_b1 = s1 + " " == null ? new byte[0] : (s1 + " ").getBytes(StandardCharsets.UTF_16BE);
                            v8 = arr_b1 == null ? 0 : arr_b1.length;
                            if(v8 >= 50) {
                                String s3 = (s1 + " ").substring(0, 21) + "... ";
                                arr_b1 = s3 == null ? new byte[0] : s3.getBytes(StandardCharsets.UTF_16BE);
                                v8 = arr_b1 == null ? 0 : arr_b1.length;
                            }
                        }
                        Log.d(this.TAG, "callStrLen= " + v8);
                        byte[] arr_b2 = new byte[v8 + 7];
                        arr_b2[0] = (byte)this.mDashBoardType.ordinal();
                        arr_b2[1] = 4;
                        arr_b2[2] = (byte)(v8 + 4);
                    alab1:
                        switch(((BtInfo)iCarDashBoard$AbsDashBoardInfo0).mPhoneSourceType) {
                            case 0: 
                            case 1: {
                                switch(((BtInfo)iCarDashBoard$AbsDashBoardInfo0).mBtStatus) {
                                    case 2: {
                                        b = 11;
                                        break alab1;
                                    }
                                    case 3: {
                                        b = 4;
                                        break alab1;
                                    }
                                    case 4: {
                                        b = 2;
                                        break alab1;
                                    }
                                    default: {
                                        b = 3;
                                        break alab1;
                                    }
                                }
                            }
                            default: {
                                switch(((BtInfo)iCarDashBoard$AbsDashBoardInfo0).mBtStatus) {
                                    case 2: {
                                        b = 1;
                                        break;
                                    }
                                    case 4: {
                                        b = 8;
                                        break;
                                    }
                                    default: {
                                        b = 3;
                                    }
                                }
                            }
                        }
                        arr_b2[3] = b;
                        arr_b2[4] = (byte)((BtInfo)iCarDashBoard$AbsDashBoardInfo0).mIsMute;
                        arr_b2[5] = 4;
                        arr_b2[6] = (byte)v8;
                        if(v8 > 0) {
                            System.arraycopy(arr_b1, 0, arr_b2, 7, v8);
                            return arr_b2;
                        }
                        return arr_b2;
                    }
                    case 5: 
                    case 9: 
                    case 12: 
                    case 13: {
                        if(!(iCarDashBoard$AbsDashBoardInfo0 instanceof MediaInfo)) {
                            Log.w(this.TAG, "formartDashBoardInfoDataBytes() USB  AbsDashBoardInfo is not MediaInfo");
                            return null;
                        }
                        if(((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).title == null || ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).artist == null) {
                            Log.w(this.TAG, "formartDashBoardInfoDataBytes() USB MediaInfo.title is null or AbsDashBoardInfo is not MediaInfo");
                            return null;
                        }
                        if(DashBoardDataFormater.mAbsInfo != null && (DashBoardDataFormater.mAbsInfo instanceof MediaInfo)) {
                            MediaInfo iCarDashBoard$MediaInfo0 = (MediaInfo)DashBoardDataFormater.mAbsInfo;
                            if(iCarDashBoard$MediaInfo0.isInfoDiff(((MediaInfo)iCarDashBoard$AbsDashBoardInfo0))) {
                                iCarDashBoard$MediaInfo0.setInfoDiff(((MediaInfo)iCarDashBoard$AbsDashBoardInfo0));
                                v9 = 1;
                            }
                            else {
                                v9 = 0;
                            }
                        } else {
                            DashBoardDataFormater.mAbsInfo = new MediaInfo(((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).getDashBoardSource());
                            v9 = 1;
                        }
                        Log.d(this.TAG, "formartDashBoardInfoDataBytes() isMediaUpdate =" + ((boolean)v9) + ",so return byte [] null?");
                        if(v9 == 0) {
                            return null;
                        }
                        String s4 = ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).title;
                        String s5 = ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).artist;
                        int v10 = s4 == null ? 0 : s4.getBytes(StandardCharsets.UTF_16BE).length;
                        int v11 = s5 == null ? 0 : s5.getBytes(StandardCharsets.UTF_16BE).length;
                        if(v11 + 2 > 20) {
                            s6 = s5.substring(0, 9);
                        }
                        else {
                            String s7 = s5;
                            int v12 = 0;
                            while(v12 < (18 - v11) / 2) {
                                ++v12;
                                s7 = s7 + " ";
                            }
                            s6 = s7;
                        }
                        int v13 = (s6 == null ? 0 : s6.getBytes(StandardCharsets.UTF_16BE).length) + 2;
                        if(v10 > 18) {
                            s8 = s4.substring(0, 6) + "...";
                            v10 = s8 == null ? 0 : s8.getBytes(StandardCharsets.UTF_16BE).length;
                        }
                        else {
                            s8 = s4;
                        }
                        Log.w(this.TAG, "formartDashBoardInfoDataBytes() USB MediaInfo.mTitle=" + s8 + ",mArtist=" + s6);
                        int v14 = v10 + 16 + v13 + 4;
                        byte[] arr_b3 = new byte[3 + v14];
                        arr_b3[0] = (byte)this.mDashBoardType.ordinal();
                        arr_b3[1] = 2;
                        arr_b3[2] = (byte)v14;
                        arr_b3[3] = (byte)v9;
                        arr_b3[4] = 0;
                        arr_b3[5] = 4;
                        if(iCarDashBoard$AbsDashBoardInfo0.getDashBoardSource() == 5) {
                            arr_b3[5] = 5;
                        }
                        if(iCarDashBoard$AbsDashBoardInfo0.getDashBoardSource() == 12) {
                            arr_b3[5] = 18;
                        }
                        if(iCarDashBoard$AbsDashBoardInfo0.getDashBoardSource() == 13) {
                            arr_b3[5] = 15;
                        }
                        arr_b3[6] = 1;
                        arr_b3[7] = 0;
                        arr_b3[8] = 0;
                        arr_b3[9] = 0;
                        arr_b3[10] = 0;
                        arr_b3[11] = 4;
                        arr_b3[12] = (byte)v10;
                        if(v10 != 0) {
                            System.arraycopy(s8.getBytes(StandardCharsets.UTF_16BE), 0, arr_b3, 13, v10);
                        }
                        arr_b3[13 + v10] = 1;
                        arr_b3[14 + v10] = 1;
                        arr_b3[15 + v10] = 1;
                        arr_b3[16 + v10] = 2;
                        arr_b3[17 + v10] = 4;
                        arr_b3[18 + v10] = 0;
                        arr_b3[19 + v10] = 0;
                        arr_b3[20 + v10] = 0;
                        arr_b3[21 + v10] = 4;
                        arr_b3[22 + v10] = (byte)v13;
                        if(v13 != 0 && v13 != 2) {
                            System.arraycopy(s6.getBytes(StandardCharsets.UTF_16BE), 0, arr_b3, 23 + v10, v13 - 2);
                        }
                        return arr_b3;
                    }
                    default: {
                        return null;
                    }
                }
            }
            catch(Exception exception0) {
                Log.e(this.TAG, "formartDashBoardInfoDataBytes() Exception " + exception0.getMessage());
                return null;
            }
        }

        public byte[] getDashBoardItemUnitByteArray(SetItemUnitInfo iCarDashBoard$SetItemUnitInfo0) {
            try {
                byte[] arr_b = new byte[12];
                if(iCarDashBoard$SetItemUnitInfo0 == null) {
                    return null;
                }
                arr_b[0] = 5;
                arr_b[1] = 4;
                arr_b[2] = (byte)iCarDashBoard$SetItemUnitInfo0.mUnitFuelConsumption;
                arr_b[3] = (byte)iCarDashBoard$SetItemUnitInfo0.mUnitTemperature;
                arr_b[4] = (byte)iCarDashBoard$SetItemUnitInfo0.mUnitPressure;
                arr_b[5] = (byte)iCarDashBoard$SetItemUnitInfo0.mUnitDistance;
                Log.d(this.TAG, StringFormart.byte2hex(arr_b));
                return arr_b;
            }
            catch(Exception exception0) {
                Log.e(this.TAG, "setDashBoardItemUnit()  Exception ", exception0);
                return null;
            }
        }

        public byte[] getDashBoardLanguageByteArray(int v) {
            try {
                if(v == 0) {
                    Log.w(this.TAG, "setDashBoardLanguage() language ==0 unknown ! ");
                    return null;
                }
                byte[] arr_b = new byte[12];
                arr_b[0] = 6;
                arr_b[1] = 1;
                if(v != 1) {
                    switch(v) {
                        case 5: {
                            arr_b[2] = 5;
                            return arr_b;
                        }
                        case 6: {
                            arr_b[2] = 6;
                            return arr_b;
                        }
                        default: {
                            return arr_b;
                        }
                    }
                }
                arr_b[2] = 1;
                return arr_b;
            }
            catch(Exception exception0) {
            }
            Log.e(this.TAG, "setDashBoardLanguage()  Exception ", exception0);
            return null;
        }

        public byte[] getDashBoardMsgDataByteArray(AbsDashBoardMsg iCarDashBoard$AbsDashBoardMsg0) {
            if(iCarDashBoard$AbsDashBoardMsg0 == null) {
                Log.w(this.TAG, "getDashBoardMsgDataByteArray() msg is null");
            }
            try {
                if(DashBoardType.MCU_CA1105.equals(this.mDashBoardType)) {
                    byte[] arr_b = new byte[10];
                    arr_b[0] = (byte)this.mDashBoardType.ordinal();
                    arr_b[1] = (byte)0xE0;
                    arr_b[2] = 1;
                    if((iCarDashBoard$AbsDashBoardMsg0 instanceof DashBoardMsgAudio)) {
                        arr_b[3] = 8;
                        arr_b[4] = 5;
                        arr_b[5] = 0;
                        arr_b[6] = 19;
                        switch(((DashBoardMsgAudio)iCarDashBoard$AbsDashBoardMsg0).audioState) {
                            case 0: {
                                arr_b[6] = 0;
                                arr_b[7] = 0;
                                break;
                            }
                            case 38: {
                                arr_b[7] = 38;
                                break;
                            }
                            case 41: {
                                arr_b[7] = 41;
                                break;
                            }
                            case 55: {
                                arr_b[7] = 55;
                                break;
                            }
                            case 58: {
                                arr_b[7] = 58;
                                break;
                            }
                            default: {
                                arr_b[7] = -1;
                            }
                        }
                        arr_b[8] = 4;
                        arr_b[9] = 0;
                        return arr_b;
                    }
                    if((iCarDashBoard$AbsDashBoardMsg0 instanceof DashBoardMsgVoice)) {
                        arr_b[3] = 9;
                        arr_b[4] = 4;
                        arr_b[5] = ((DashBoardMsgVoice)iCarDashBoard$AbsDashBoardMsg0).voiceAction;
                        arr_b[6] = 8;
                    }
                    return arr_b;
                }
            }
            catch(Exception exception0) {
                Log.e(this.TAG, "getDashBoardMsgDataByteArray()  Exception ", exception0);
            }
            return null;
        }

        public byte[] getDashBoardSourceDataByteArray(int v, AbsDashBoardInfo iCarDashBoard$AbsDashBoardInfo0) {
            if(iCarDashBoard$AbsDashBoardInfo0 == null) {
                Log.w(this.TAG, "getDashBoardSourceDataByteArray() info is null");
            }
            try {
                AbsDashBoardInfo iCarDashBoard$AbsDashBoardInfo1 = this.getDashBoardSourceFormatInfo(v, iCarDashBoard$AbsDashBoardInfo0);
                if(DashBoardType.MCU_CA1105.equals(this.mDashBoardType)) {
                    switch(v) {
                        case 1: 
                        case 4: 
                        case 5: 
                        case 9: {
                            return this.getDashBoardInfoDataByteArray(iCarDashBoard$AbsDashBoardInfo1);
                        }
                        case 12: 
                        case 13: {
                            if((iCarDashBoard$AbsDashBoardInfo1 instanceof MediaInfo)) {
                                ((MediaInfo)iCarDashBoard$AbsDashBoardInfo1).title = "--";
                                ((MediaInfo)iCarDashBoard$AbsDashBoardInfo1).artist = "--";
                                return this.getDashBoardInfoDataByteArray(((MediaInfo)iCarDashBoard$AbsDashBoardInfo1));
                            }
                            break;
                        }
                        default: {
                            byte[] arr_b = new byte[23];
                            arr_b[0] = (byte)this.mDashBoardType.ordinal();
                            arr_b[1] = 2;
                            arr_b[2] = 20;
                            DashBoardDataFormater.mAbsInfo = null;
                            return arr_b;
                        }
                    }
                }
            }
            catch(Exception exception0) {
                Log.e(this.TAG, "getDashBoardSourceDataByteArray() Exception ", exception0);
            }
            return null;
        }

        private AbsDashBoardInfo getDashBoardSourceFormatInfo(int v, AbsDashBoardInfo iCarDashBoard$AbsDashBoardInfo0) {
            if(iCarDashBoard$AbsDashBoardInfo0 == null) {
                switch(v) {
                    case 4: {
                        return new BtInfo();
                    }
                    case 5: 
                    case 9: 
                    case 12: 
                    case 13: {
                        iCarDashBoard$AbsDashBoardInfo0 = new MediaInfo(v);
                        iCarDashBoard$AbsDashBoardInfo0.title = "--";
                        iCarDashBoard$AbsDashBoardInfo0.artist = "--";
                        return iCarDashBoard$AbsDashBoardInfo0;
                    }
                    default: {
                        return null;
                    }
                }
            }
            return iCarDashBoard$AbsDashBoardInfo0;
        }

        public boolean isSendMediaInfoOnly() {
            return DashBoardType.MCU_CA1105.equals(this.mDashBoardType);
        }
    }

    public static class DashBoardMsgAudio extends AbsDashBoardMsg {
        public static final byte AUDIO_STATE_LOADING_AUDIO_FILE_LIST = 55;
        public static final byte AUDIO_STATE_NO_AUDIO_FILE = 41;
        public static final byte AUDIO_STATE_NO_DEVICES_CONNECTED = 58;
        public static final byte AUDIO_STATE_NO_DISPLAY = 0;
        public static final byte AUDIO_STATE_UNPLAYABLE_FILE = 38;
        public int audioState;

    }

    public static class DashBoardMsgVoice extends AbsDashBoardMsg {
        public static final byte VOICE_ACTION_END = 2;
        public static final byte VOICE_ACTION_START;
        public byte voiceAction;

    }

    public interface DashBoardSource {
        public static final int SOURCE_BT = 4;
        public static final int SOURCE_BT_MUSIC = 5;
        public static final int SOURCE_MUSIC = 2;
        public static final int SOURCE_NONE = 0;
        public static final int SOURCE_RADIO = 1;
        public static final int SOURCE_TV = 6;
        public static final int SOURCE_UNKNOWN = -1;
        public static final int SOURCE_VIDEO = 3;
        public static final int SOUREC_ANDROID_AUTO = 16;
        public static final int SOUREC_AUX = 11;
        public static final int SOUREC_CARLIFE = 12;
        public static final int SOUREC_CARPLAY = 13;
        public static final int SOUREC_CD = 7;
        public static final int SOUREC_DAB = 15;
        public static final int SOUREC_DVD = 8;
        public static final int SOUREC_HICAR = 14;
        public static final int SOUREC_IPOD = 10;
        public static final int SOUREC_USB = 9;

    }

    public static enum DashBoardType {
        UNKNOWN,
        MCU_CA1105,
        QNX_SOCKET,
        MCU_IHU12;

        public static DashBoardType valueOf(int v) {
            if(v == DashBoardType.MCU_CA1105.ordinal()) {
                return DashBoardType.MCU_CA1105;
            }
            if(v == DashBoardType.QNX_SOCKET.ordinal()) {
                return DashBoardType.QNX_SOCKET;
            }
            return v == DashBoardType.MCU_IHU12.ordinal() ? DashBoardType.MCU_IHU12 : DashBoardType.UNKNOWN;
        }
    }

    public interface McuDashBoardProtocal {
        public static final byte MSGID_DASHBOARD_INFO_BT = 4;
        public static final byte MSGID_DASHBOARD_INFO_MEDIA = 2;
        public static final byte MSGID_DASHBOARD_INFO_RADIO = 3;
        public static final byte MSGID_DASHBOARD_SOURCE = 1;
        public static final byte MSGID_SET_AUDIO_SOUCE_ENABLE = 7;
        public static final byte MSGID_SET_LANGUAGE = 6;
        public static final byte MSGID_SET_MSG_AUDIO = 8;
        public static final byte MSGID_SET_MSG_VOICE = 9;
        public static final byte MSGID_SET_UNIT = 5;

    }

    public static class MediaInfo extends AbsDashBoardInfo {
        public static final byte PLAY_TYPE_ORDER_LIST = 6;
        public static final byte PLAY_TYPE_RANDOM_ALL = 3;
        public static final byte PLAY_TYPE_RANDOM_LIST = 2;
        public static final byte PLAY_TYPE_RANDOM_ONE = 0;
        public static final byte PLAY_TYPE_REPEAT_ALL = 4;
        public static final byte PLAY_TYPE_REPEAT_LIST = 5;
        public static final byte PLAY_TYPE_REPEAT_ONE = 1;
        public static final byte STATUS_PAUSE = 1;
        public static final byte STATUS_PLAY = 2;
        public static final byte STATUS_STOP;
        public String artist;
        public int current;
        public boolean isMute;
        public int playType;
        public int status;
        public String title;
        public int total;

        public MediaInfo(int v) {
            super(v);
        }

        public MediaInfo(int v, String s, String s1, int v1, int v2, int v3) {
            super(v);
            this.title = s;
            this.artist = s1;
            this.current = v1;
            this.total = v2;
            this.status = v3;
        }

        public MediaInfo(int v, String s, String s1, int v1, int v2, int v3, int v4, boolean z) {
            super(v);
            this.title = s;
            this.artist = s1;
            this.current = v1;
            this.total = v2;
            this.status = v3;
            this.playType = v4;
            this.isMute = z;
        }

        public boolean isInfoDiff(MediaInfo iCarDashBoard$MediaInfo0) {
            if(iCarDashBoard$MediaInfo0 == null) {
                return true;
            }
            return this.getDashBoardSource() == iCarDashBoard$MediaInfo0.getDashBoardSource() ? this.title != null && iCarDashBoard$MediaInfo0.title == null || this.title == null && iCarDashBoard$MediaInfo0.title != null || this.title != null && iCarDashBoard$MediaInfo0.title != null && !this.title.equals(iCarDashBoard$MediaInfo0.title) || this.artist != null && iCarDashBoard$MediaInfo0.artist == null || this.artist == null && iCarDashBoard$MediaInfo0.artist != null || this.artist != null && iCarDashBoard$MediaInfo0.artist != null && !this.artist.equals(iCarDashBoard$MediaInfo0.artist) : true;
        }

        public void setInfoDiff(MediaInfo iCarDashBoard$MediaInfo0) {
            this.title = iCarDashBoard$MediaInfo0.title;
            this.artist = iCarDashBoard$MediaInfo0.artist;
            this.setDashBoardSource(iCarDashBoard$MediaInfo0.getDashBoardSource());
        }

        @Override  // com.yftech.vehicle.internal.adapter.ICarDashBoard$AbsDashBoardInfo
        public byte[] toBytes() {
            byte[] arr_b = new byte[0x109];
            arr_b[0x101] = (byte)(this.current >> 8 & 0xFF);
            arr_b[0x102] = (byte)(this.current & 0xFF);
            arr_b[0x105] = (byte)(this.total >> 8 & 0xFF);
            arr_b[0x106] = (byte)(this.total & 0xFF);
            arr_b[0x109] = (byte)this.status;
            if(this.title != null) {
                System.arraycopy(this.title.getBytes(StandardCharsets.UTF_8), 0, arr_b, 0, this.title.getBytes(StandardCharsets.UTF_8).length);
            }
            if(this.artist != null) {
                System.arraycopy(this.artist.getBytes(StandardCharsets.UTF_8), 0, arr_b, 0x80, this.artist.getBytes(StandardCharsets.UTF_8).length);
            }
            return arr_b;
        }

        @Override  // com.yftech.vehicle.internal.adapter.ICarDashBoard$AbsDashBoardInfo
        public String toString() {
            return "MediaInfo{title=\'" + this.title + '\'' + ", artist=\'" + this.artist + '\'' + ", current=" + this.current + ", total=" + this.total + ", status=" + this.status + '}';
        }
    }

    public interface NaviDirectionIcon {
        public static final int TURN_BACK = 1;
        public static final int TURN_BACK_8DIRECT = 39;
        public static final int TURN_BRANCH_CENTER = 15;
        public static final int TURN_BRANCH_CENTER_FRONT = 27;
        public static final int TURN_BRANCH_LEFT = 18;
        public static final int TURN_BRANCH_LEFT_IC = 29;
        public static final int TURN_BRANCH_LEFT_STRAIGHT = 12;
        public static final int TURN_BRANCH_LEFT_STRAIGHT_FRONT = 26;
        public static final int TURN_BRANCH_RIGHT = 19;
        public static final int TURN_BRANCH_RIGHT_IC = 30;
        public static final int TURN_BRANCH_RIGHT_STRAIGHT = 14;
        public static final int TURN_BRANCH_RIGHT_STRAIGHT_FRONT = 28;
        public static final int TURN_DEST = 20;
        public static final int TURN_FRONT = 2;
        public static final int TURN_INFERRY = 22;
        public static final int TURN_LEFT = 6;
        public static final int TURN_LEFT_BACK = 5;
        public static final int TURN_LEFT_FRONT = 7;
        public static final int TURN_LEFT_SIDE = 9;
        public static final int TURN_LEFT_SIDE_IC = 16;
        public static final int TURN_LEFT_SIDE_MAIN = 11;
        public static final int TURN_LEFT_SIDE_MAIN_FRONT = 0x1F;
        public static final int TURN_LEFT_SIDE_MAIN_FRONT_IC = 24;
        public static final int TURN_LEFT_THEN_LEFT = 33;
        public static final int TURN_LF_2BRANCH_LEFT = 35;
        public static final int TURN_LF_2BRANCH_RIGHT = 36;
        public static final int TURN_RF_2BRANCH_LEFT = 37;
        public static final int TURN_RF_2BRANCH_RIGHT = 38;
        public static final int TURN_RIGHT = 4;
        public static final int TURN_RIGHT_BACK = 4;
        public static final int TURN_RIGHT_FRONT = 3;
        public static final int TURN_RIGHT_SIDE = 10;
        public static final int TURN_RIGHT_SIDE_IC = 17;
        public static final int TURN_RIGHT_SIDE_MAIN = 13;
        public static final int TURN_RIGHT_SIDE_MAIN_FRONT = 0x20;
        public static final int TURN_RIGHT_SIDE_MAIN_FRONT_IC = 25;
        public static final int TURN_RIGHT_THAN_LEFT = 34;
        public static final int TURN_RING = 8;
        public static final int TURN_RING_FRONT = 40;
        public static final int TURN_RING_LEFT = 41;
        public static final int TURN_RING_LEFTBACK = 42;
        public static final int TURN_RING_LEFTFRONT = 43;
        public static final int TURN_RING_RIGHT = 44;
        public static final int TURN_RING_RIGHTBACK = 45;
        public static final int TURN_RING_RIGHTFRONT = 46;
        public static final int TURN_RING_TURNBACK = 0x2F;
        public static final int TURN_TOLLGATE = 23;
        public static final int TURN_VIA_1 = 21;

    }

    public static enum PhoneAction {
        MUTE_MIC(6),
        USE_HANDSET(4),
        ENDING_CALL(3),
        REFUSE_CALL(2),
        ANSWER_CALL(1),
        __UNKNOWN__(-1);

        public final int value;

        private PhoneAction(int v1) {
            this.value = v1;
        }

        public static PhoneAction valueOf(int v) {
            if(v == PhoneAction.MUTE_MIC.value) {
                return PhoneAction.MUTE_MIC;
            }
            if(v == PhoneAction.USE_HANDSET.value) {
                return PhoneAction.USE_HANDSET;
            }
            if(v == PhoneAction.ENDING_CALL.value) {
                return PhoneAction.ENDING_CALL;
            }
            if(v == PhoneAction.REFUSE_CALL.value) {
                return PhoneAction.REFUSE_CALL;
            }
            return v == PhoneAction.ANSWER_CALL.value ? PhoneAction.ANSWER_CALL : PhoneAction.__UNKNOWN__;
        }
    }

    public static class RadioInfo extends AbsDashBoardInfo {
        public static final byte AM1 = 3;
        public static final byte AM2 = 4;
        public static final byte AM3 = 5;
        public static final byte FM1 = 0;
        public static final byte FM2 = 1;
        public static final byte FM3 = 2;
        public static final byte SCAN_MODE_AST = 2;
        public static final byte SCAN_MODE_NORMAL = 1;
        public static final byte SCAN_MODE_SCAN = 3;
        public boolean isPrefebIndex;
        public byte mBandType;
        public int mFrequency;
        public byte mPrefebIndex;
        public byte scanMode;

        public RadioInfo() {
            super(1);
        }

        public RadioInfo(int v, byte b, boolean z, byte b1, int v1) {
            super(v);
            this.mBandType = b;
            this.isPrefebIndex = z;
            this.mPrefebIndex = b1;
            this.mFrequency = v1;
        }

        public RadioInfo(int v, byte b, boolean z, byte b1, int v1, byte b2) {
            super(v);
            this.mBandType = b;
            this.isPrefebIndex = z;
            this.mPrefebIndex = b1;
            this.mFrequency = v1;
            this.scanMode = b2;
        }

        public boolean isInfoDiff(RadioInfo iCarDashBoard$RadioInfo0) {
            return iCarDashBoard$RadioInfo0 == null ? true : this.mBandType != iCarDashBoard$RadioInfo0.mBandType || this.mFrequency != iCarDashBoard$RadioInfo0.mFrequency;
        }

        public void setInfoDiff(RadioInfo iCarDashBoard$RadioInfo0) {
            this.mBandType = iCarDashBoard$RadioInfo0.mBandType;
            this.mFrequency = iCarDashBoard$RadioInfo0.mFrequency;
        }

        @Override  // com.yftech.vehicle.internal.adapter.ICarDashBoard$AbsDashBoardInfo
        public byte[] toBytes() {
            return new byte[0];
        }

        @Override  // com.yftech.vehicle.internal.adapter.ICarDashBoard$AbsDashBoardInfo
        public String toString() {
            return "RadioInfo{mBandType=" + ((int)this.mBandType) + ", isPrefebIndex=" + this.isPrefebIndex + ", mPrefebIndex=" + ((int)this.mPrefebIndex) + ", mFrequency=" + this.mFrequency + '}';
        }
    }

    public interface SetItemLanguageVal {
        public static final byte EN_RUS = 1;
        public static final int UNKNOWN = 0;
        public static final byte ZH_RCN = 5;
        public static final byte ZH_RTW = 6;

    }

    public static class SetItemUnitInfo {
        public static int DISTANCE_M = 1;
        public static int DISTANCE_MILE = 2;
        public static int FUEL_CONSUMPTION_KM_KWH = 81;
        public static int FUEL_CONSUMPTION_KM_L = 1;
        public static int FUEL_CONSUMPTION_KWH_100KM = 82;
        public static int FUEL_CONSUMPTION_KWH_MILE = 84;
        public static int FUEL_CONSUMPTION_L_100KM = 2;
        public static int FUEL_CONSUMPTION_MILES_KWH = 83;
        public static int FUEL_CONSUMPTION_MPG_UK = 4;
        public static int FUEL_CONSUMPTION_MPG_US = 3;
        public static byte PRESSURE_BAR = 3;
        public static byte PRESSURE_KGF_CM2 = 4;
        public static byte PRESSURE_KPA = 1;
        public static byte PRESSURE_PSI = 2;
        public static byte TEMPERATURE_DEG_C = 1;
        public static byte TEMPERATURE_DEG_F = 2;
        public int mUnitDistance;
        public int mUnitFuelConsumption;
        public int mUnitPressure;
        public int mUnitTemperature;

        static {
        }

        public SetItemUnitInfo() {
        }

        private SetItemUnitInfo(int v, int v1, int v2, int v3) {
            this.mUnitPressure = v;
            this.mUnitTemperature = v1;
            this.mUnitDistance = v2;
            this.mUnitFuelConsumption = v3;
        }

        @Override
        public String toString() {
            return "SetItemUnitInfo{mUnitPressure=" + this.mUnitPressure + ", mUnitTemperature=" + this.mUnitTemperature + ", mUnitDistance=" + this.mUnitDistance + ", mUnitFuelConsumption=" + this.mUnitFuelConsumption + '}';
        }

        public static SetItemUnitInfo valueOf(byte[] arr_b) {
            return new SetItemUnitInfo(((int)arr_b[0]), ((int)arr_b[1]), ((int)arr_b[2]), ((int)arr_b[3]));
        }
    }

    public static enum TimeFormatMode {
        MODE_12H(1),
        MODE_24H(2),
        __UNKNOWN__(-1);

        public final int value;

        private TimeFormatMode(int v1) {
            this.value = v1;
        }

        public static TimeFormatMode valueOf(int v) {
            if(v == TimeFormatMode.MODE_12H.value) {
                return TimeFormatMode.MODE_12H;
            }
            return v == TimeFormatMode.MODE_24H.value ? TimeFormatMode.MODE_24H : TimeFormatMode.__UNKNOWN__;
        }
    }

    public static final int COMMON_PROTOCOL_SET = 9939;
    public static final int DASHBOARD_TYPE_SELECTED = 1;
    public static final int DASH_BOARD_AUDIO_SOURCE_ENABLE_SET = 9948;
    public static final int DASH_BOARD_MEDIAINFO = 0x2702;
    public static final int DASH_BOARD_MEDIA_MUSIC_ART_IMAGE = 0x2701;
    public static final int DASH_BOARD_MESSAGE_NOTIFY_SET = 9961;
    public static final int DASH_BOARD_NAVIGUIDEINFO = 0x2700;
    public static final int DASH_BOARD_PHONE_ACTION_MSG_GET = 9947;
    public static final int DASH_BOARD_SETTING_ITEM_LANGUAGE = 0x26F8;
    public static final int DASH_BOARD_SETTING_ITEM_UNIT = 0x26F9;
    public static final int DASH_BOARD_SOURCE_STATE = 0x26FA;
    public static final int DASH_BOARD_SYNC_SYSTEM_TIME_SET = 9946;
    public static final int DASH_BOARD_TIME_FORMAT_GET = 9945;

}

