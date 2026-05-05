package com.yftech.vehicle.internal.adapter;

import android.util.Log;
import com.yftech.vehicle.internal.utils.StringFormart;
import java.nio.charset.StandardCharsets;

public interface ICarDashBoard {
    public static abstract class AbsDashBoardInfo {
        private int dashBoardSource;

        public AbsDashBoardInfo(int source) {
            this.dashBoardSource = source;
        }

        public int getDashBoardSource() {
            return this.dashBoardSource;
        }

        public void setDashBoardSource(int source) {
            this.dashBoardSource = source;
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

        public boolean isInfoDiff(BtInfo b) {
            return b == null ? true : this.mBtCallNumber != b.mBtCallNumber;
        }

        public void setInfoDiff(BtInfo b) {
            this.mBtCallNumber = b.mBtCallNumber;
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

        public DABInfo(String dabProgramName) {
            super(15);
            this.mDabProgramName = "";
            this.mDabProgramName = dabProgramName;
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

        private DashBoardDataFormater(DashBoardType type) {
            this.TAG = "DashBoardDataFormater";
            this.mDashBoardType = type;
        }

        public static DashBoardDataFormater get(DashBoardType type) {
            if(DashBoardDataFormater.instance == null) {
                DashBoardDataFormater.instance = new DashBoardDataFormater(type);
            }
            return DashBoardDataFormater.instance;
        }

        public byte[] getDashBoardInfoDataByteArray(AbsDashBoardInfo info) {
            int f0;
            int f00;
            int f000;
            boolean isAm;
            if(info == null) {
                Log.w(this.TAG, "formartMediaInfoDataBytes() info is null");
                return null;
            }
            try {
                Log.w(this.TAG, " info:" + info.toString());
                byte[] byteArray = null;
                if(DashBoardType.MCU_CA1105.equals(this.mDashBoardType)) {
                    boolean isMediaUpdate = false;
                    boolean isRadioUpdate = false;
                    switch(info.getDashBoardSource()) {
                        case 1: {
                            if(!(info instanceof RadioInfo)) {
                                Log.w(this.TAG, "formartDashBoardInfoDataBytes() AbsDashBoardInfo is not RadioInfo");
                                return null;
                            }
                            if(DashBoardDataFormater.mAbsInfo == null || !(DashBoardDataFormater.mAbsInfo instanceof RadioInfo)) {
                                DashBoardDataFormater.mAbsInfo = new RadioInfo();
                                isRadioUpdate = true;
                            }
                            else {
                                RadioInfo mRadioInfoTemp = (RadioInfo)DashBoardDataFormater.mAbsInfo;
                                if(mRadioInfoTemp.isInfoDiff(((RadioInfo)info))) {
                                    mRadioInfoTemp.setInfoDiff(((RadioInfo)info));
                                    isRadioUpdate = true;
                                }
                            }
                            Log.d(this.TAG, "formartDashBoardInfoDataBytes() isRadioUpdate =" + isRadioUpdate);
                            byteArray = new byte[20];
                            byteArray[0] = (byte)this.mDashBoardType.ordinal();
                            byteArray[1] = 3;
                            byteArray[2] = 17;
                            byteArray[3] = (byte)(isRadioUpdate ? 1 : 0);
                            byteArray[4] = 0;
                            switch(((RadioInfo)info).mBandType) {
                                case 0: 
                                case 1: 
                                case 2: {
                                    isAm = false;
                                    break;
                                }
                                case 3: 
                                case 4: 
                                case 5: {
                                    isAm = true;
                                    break;
                                }
                                default: {
                                    isAm = false;
                                }
                            }
                            byteArray[5] = (byte) (isAm ? 16 : 1);
                            byteArray[6] = 1;
                            if(((RadioInfo)info).isPrefebIndex) {
                                byteArray[7] = 1;
                                byteArray[8] = ((RadioInfo)info).mPrefebIndex;
                            }
                            else {
                                byteArray[7] = 0;
                                byteArray[8] = 0;
                            }
                            if(isAm) {
                                //int f1000_h = 0xF0;
                                int f1000_h = ((RadioInfo)info).mFrequency % 100000 / 1000;
                                int f1000_l = ((RadioInfo)info).mFrequency % 100000 / 100 % 10;
                                if(f1000_h != 0) {
                                    f1000_h = f1000_h << 4;
                                }
                                else if(f1000_l == 0) {
                                    f1000_l = 15;
                                }
                                f000 = f1000_h | f1000_l;
                                f00 = Integer.parseInt(String.valueOf(((RadioInfo)info).mFrequency % 100000 % 100), 16);
                                f0 = Integer.parseInt(String.valueOf(((RadioInfo)info).mFrequency % 10000 % 10), 16);
                            }
                            else {
                                int f1000_l = ((RadioInfo)info).mFrequency % 1000000 / 100000;
                                if(f1000_l == 0) {
                                    f1000_l = 15;
                                }
                                f000 = 0xF0 | f1000_l;
                                f00 = Integer.parseInt(String.valueOf(((RadioInfo)info).mFrequency % 1000000 / 1000 % 100), 16);
                                f0 = Integer.parseInt(String.valueOf(((RadioInfo)info).mFrequency % 1000000 / 100 % 10 + 10), 16);
                            }
                            byteArray[9] = (byte)f000;
                            byteArray[10] = (byte)f00;
                            byteArray[11] = (byte)f0;
                            byteArray[12] = -16;
                            byteArray[13] = (byte) (isAm ? 2 : 1);
                            byteArray[14] = 4;
                            byteArray[15] = 0;
                            byteArray[16] = 0;
                            byteArray[17] = 0;
                            byteArray[18] = 4;
                            byteArray[19] = 0;
                            return byteArray;
                        }
                        case 4: {
                            if(!(info instanceof BtInfo)) {
                                Log.w(this.TAG, "formartDashBoardInfoDataBytes() BT BtInfo is null or AbsDashBoardInfo is not BtInfo");
                                return null;
                            }
                            String mBtCallNumber = ((BtInfo)info).mBtCallNumber;
                            String mBtName = ((BtInfo)info).mBtName;
                            if(mBtCallNumber != null && !"".equals(mBtCallNumber)) {
                                mBtCallNumber = mBtCallNumber + " ";
                            }
                            byte[] mBtCallStringByteArr = mBtCallNumber == null ? new byte[0] : mBtCallNumber.getBytes(StandardCharsets.UTF_16BE);
                            int callStrLen = mBtCallStringByteArr == null ? 0 : mBtCallStringByteArr.length;
                            if(callStrLen >= 50) {
                                mBtCallNumber = mBtCallNumber.substring(0, 21) + "... ";
                                mBtCallStringByteArr = mBtCallNumber == null ? new byte[0] : mBtCallNumber.getBytes(StandardCharsets.UTF_16BE);
                                callStrLen = mBtCallStringByteArr == null ? 0 : mBtCallStringByteArr.length;
                            }
                            if(mBtName != null && !"".equals(mBtName)) {
                                mBtCallStringByteArr = mBtName + " " == null ? new byte[0] : (mBtName + " ").getBytes(StandardCharsets.UTF_16BE);
                                callStrLen = mBtCallStringByteArr == null ? 0 : mBtCallStringByteArr.length;
                                if(callStrLen >= 50) {
                                    mBtName = (mBtName + " ").substring(0, 21) + "... ";
                                    mBtCallStringByteArr = mBtName == null ? new byte[0] : mBtName.getBytes(StandardCharsets.UTF_16BE);
                                    callStrLen = mBtCallStringByteArr == null ? 0 : mBtCallStringByteArr.length;
                                }
                            }
                            Log.d(this.TAG, "callStrLen= " + callStrLen);
                            byteArray = new byte[callStrLen + 7];
                            byteArray[0] = (byte)this.mDashBoardType.ordinal();
                            byteArray[1] = 4;
                            byteArray[2] = (byte)(callStrLen + 4);
                            byte callState = 3;
                        alab1:
                            switch(((BtInfo)info).mPhoneSourceType) {
                                case 0: 
                                case 1: {
                                    switch(((BtInfo)info).mBtStatus) {
                                        case 2: {
                                            callState = 11;
                                            break alab1;
                                        }
                                        case 3: {
                                            callState = 4;
                                            break alab1;
                                        }
                                        case 4: {
                                            callState = 2;
                                            break alab1;
                                        }
                                        default: {
                                            break alab1;
                                        }
                                    }
                                }
                                default: {
                                    switch(((BtInfo)info).mBtStatus) {
                                        case 2: {
                                            callState = 1;
                                            break;
                                        }
                                        case 4: {
                                            callState = 8;
                                        }
                                    }
                                }
                            }
                            byteArray[3] = callState;
                            byteArray[4] = (byte)(((BtInfo)info).mIsMute ? 1 : 0);
                            byteArray[5] = 4;
                            byteArray[6] = (byte)callStrLen;
                            if(callStrLen > 0) {
                                System.arraycopy(mBtCallStringByteArr, 0, byteArray, 7, callStrLen);
                                return byteArray;
                            }
                            break;
                        }
                        case 5: 
                        case 9: 
                        case 12: 
                        case 13: {
                            if(!(info instanceof MediaInfo)) {
                                Log.w(this.TAG, "formartDashBoardInfoDataBytes() USB  AbsDashBoardInfo is not MediaInfo");
                                return null;
                            }
                            if(((MediaInfo)info).title == null || ((MediaInfo)info).artist == null) {
                                Log.w(this.TAG, "formartDashBoardInfoDataBytes() USB MediaInfo.title is null or AbsDashBoardInfo is not MediaInfo");
                                return null;
                            }
                            if(DashBoardDataFormater.mAbsInfo == null || !(DashBoardDataFormater.mAbsInfo instanceof MediaInfo)) {
                                DashBoardDataFormater.mAbsInfo = new MediaInfo(((MediaInfo)info).getDashBoardSource());
                                isMediaUpdate = true;
                            }
                            else {
                                MediaInfo mMediaInfoTemp = (MediaInfo)DashBoardDataFormater.mAbsInfo;
                                if(mMediaInfoTemp.isInfoDiff(((MediaInfo)info))) {
                                    mMediaInfoTemp.setInfoDiff(((MediaInfo)info));
                                    isMediaUpdate = true;
                                }
                            }
                            Log.d(this.TAG, "formartDashBoardInfoDataBytes() isMediaUpdate =" + isMediaUpdate + ",so return byte [] null?");
                            if(!isMediaUpdate) {
                                return null;
                            }
                            String mTitle = ((MediaInfo)info).title;
                            String mArtist = ((MediaInfo)info).artist;
                            int titleLen = mTitle == null ? 0 : mTitle.getBytes(StandardCharsets.UTF_16BE).length;
                            int artistLen = mArtist == null ? 0 : mArtist.getBytes(StandardCharsets.UTF_16BE).length;
                            if(artistLen + 2 > 20) {
                                mArtist = mArtist.substring(0, 9);
                            }
                            else {
                                for(int i = 0; i < (18 - artistLen) / 2; ++i) {
                                    mArtist = mArtist + " ";
                                }
                            }
                            artistLen = (mArtist == null ? 0 : mArtist.getBytes(StandardCharsets.UTF_16BE).length) + 2;
                            if(titleLen > 18) {
                                mTitle = mTitle.substring(0, 6) + "...";
                                titleLen = mTitle == null ? 0 : mTitle.getBytes(StandardCharsets.UTF_16BE).length;
                            }
                            Log.w(this.TAG, "formartDashBoardInfoDataBytes() USB MediaInfo.mTitle=" + mTitle + ",mArtist=" + mArtist);
                            int dataLen = titleLen + 16 + artistLen + 4;
                            byteArray = new byte[dataLen + 3];
                            byteArray[0] = (byte)this.mDashBoardType.ordinal();
                            byteArray[1] = 2;
                            byteArray[2] = (byte)dataLen;
                            byteArray[3] = (byte)(isMediaUpdate ? 1 : 0);
                            byteArray[4] = 0;
                            byteArray[5] = 4;
                            if(info.getDashBoardSource() == 5) {
                                byteArray[5] = 5;
                            }
                            if(info.getDashBoardSource() == 12) {
                                byteArray[5] = 18;
                            }
                            if(info.getDashBoardSource() == 13) {
                                byteArray[5] = 15;
                            }
                            byteArray[6] = 1;
                            byteArray[7] = 0;
                            byteArray[8] = 0;
                            byteArray[9] = 0;
                            byteArray[10] = 0;
                            byteArray[11] = 4;
                            byteArray[12] = (byte)titleLen;
                            if(titleLen != 0) {
                                System.arraycopy(mTitle.getBytes(StandardCharsets.UTF_16BE), 0, byteArray, 13, titleLen);
                            }
                            byteArray[titleLen + 13] = 1;
                            byteArray[titleLen + 14] = 1;
                            byteArray[titleLen + 15] = 1;
                            byteArray[titleLen + 16] = 2;
                            byteArray[titleLen + 17] = 4;
                            byteArray[titleLen + 18] = 0;
                            byteArray[titleLen + 19] = 0;
                            byteArray[titleLen + 20] = 0;
                            byteArray[titleLen + 21] = 4;
                            byteArray[titleLen + 22] = (byte)artistLen;
                            if(artistLen != 0 && artistLen != 2) {
                                System.arraycopy(mArtist.getBytes(StandardCharsets.UTF_16BE), 0, byteArray, titleLen + 23, artistLen - 2);
                                return byteArray;
                            }
                            break;
                        }
                        default: {
                            return null;
                        }
                    }
                }
                return byteArray;
            }
            catch(Exception e) {
                Log.e(this.TAG, "formartDashBoardInfoDataBytes() Exception " + e.getMessage());
                return null;
            }
        }

        public byte[] getDashBoardItemUnitByteArray(SetItemUnitInfo unitItem) {
            try {
                byte[] byteArray = new byte[12];
                if(unitItem == null) {
                    return null;
                }
                byteArray[0] = 5;
                byteArray[1] = 4;
                byteArray[2] = (byte)unitItem.mUnitFuelConsumption;
                byteArray[3] = (byte)unitItem.mUnitTemperature;
                byteArray[4] = (byte)unitItem.mUnitPressure;
                byteArray[5] = (byte)unitItem.mUnitDistance;
                Log.d(this.TAG, StringFormart.byte2hex(byteArray));
                return byteArray;
            }
            catch(Exception e) {
                Log.e(this.TAG, "setDashBoardItemUnit()  Exception ", e);
                return null;
            }
        }

        public byte[] getDashBoardLanguageByteArray(int language) {
            try {
                if(language == 0) {
                    Log.w(this.TAG, "setDashBoardLanguage() language ==0 unknown ! ");
                    return null;
                }
                byte[] byteArray = new byte[12];
                byteArray[0] = 6;
                byteArray[1] = 1;
                switch(language) {
                    case 1: {
                        byteArray[2] = 1;
                        return byteArray;
                    }
                    case 5: {
                        byteArray[2] = 5;
                        return byteArray;
                    }
                    case 6: {
                        byteArray[2] = 6;
                        return byteArray;
                    }
                    default: {
                        return byteArray;
                    }
                }
            }
            catch(Exception e) {
                Log.e(this.TAG, "setDashBoardLanguage()  Exception ", e);
                return null;
            }
        }

        public byte[] getDashBoardMsgDataByteArray(AbsDashBoardMsg msg) {
            if(msg == null) {
                Log.w(this.TAG, "getDashBoardMsgDataByteArray() msg is null");
            }
            try {
                if(DashBoardType.MCU_CA1105.equals(this.mDashBoardType)) {
                    byte[] data = new byte[10];
                    data[0] = (byte)this.mDashBoardType.ordinal();
                    data[1] = (byte)0xE0;
                    data[2] = 1;
                    if((msg instanceof DashBoardMsgAudio)) {
                        data[3] = 8;
                        data[4] = 5;
                        data[5] = 0;
                        data[6] = 19;
                        switch(((DashBoardMsgAudio)msg).audioState) {
                            case 0: {
                                data[6] = 0;
                                data[7] = 0;
                                break;
                            }
                            case 38: {
                                data[7] = 38;
                                break;
                            }
                            case 41: {
                                data[7] = 41;
                                break;
                            }
                            case 55: {
                                data[7] = 55;
                                break;
                            }
                            case 58: {
                                data[7] = 58;
                                break;
                            }
                            default: {
                                data[7] = -1;
                            }
                        }
                        data[8] = 4;
                        data[9] = 0;
                        return data;
                    }
                    if((msg instanceof DashBoardMsgVoice)) {
                        data[3] = 9;
                        data[4] = 4;
                        data[5] = ((DashBoardMsgVoice)msg).voiceAction;
                        data[6] = 8;
                        return data;
                    }
                    return data;
                }
            }
            catch(Exception e) {
                Log.e(this.TAG, "getDashBoardMsgDataByteArray()  Exception ", e);
            }
            return null;
        }

        public byte[] getDashBoardSourceDataByteArray(int source, AbsDashBoardInfo info) {
            if(info == null) {
                Log.w(this.TAG, "getDashBoardSourceDataByteArray() info is null");
            }
            try {
                AbsDashBoardInfo iCarDashBoard$AbsDashBoardInfo1 = this.getDashBoardSourceFormatInfo(source, info);
                if(DashBoardType.MCU_CA1105.equals(this.mDashBoardType)) {
                    switch(source) {
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
                            byte[] byteArray = new byte[23];
                            byteArray[0] = (byte)this.mDashBoardType.ordinal();
                            byteArray[1] = 2;
                            byteArray[2] = 20;
                            DashBoardDataFormater.mAbsInfo = null;
                            return byteArray;
                        }
                    }
                }
            }
            catch(Exception e) {
                Log.e(this.TAG, "getDashBoardSourceDataByteArray() Exception ", e);
            }
            return null;
        }

        private AbsDashBoardInfo getDashBoardSourceFormatInfo(int source, AbsDashBoardInfo info) {
            if(info == null) {
                switch(source) {
                    case 4: {
                        return new BtInfo();
                    }
                    case 5: 
                    case 9: 
                    case 12: 
                    case 13: {
                        MediaInfo media = new MediaInfo(source);
                        media.title = "--";
                        media.artist = "--";
                        return media;
                    }
                    default: {
                        return null;
                    }
                }
            }
            return info;
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
        public static final byte VOICE_ACTION_START = 1;
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

        public static DashBoardType valueOf(int value) {
            if(value == DashBoardType.MCU_CA1105.ordinal()) {
                return DashBoardType.MCU_CA1105;
            }
            if(value == DashBoardType.QNX_SOCKET.ordinal()) {
                return DashBoardType.QNX_SOCKET;
            }
            return value == DashBoardType.MCU_IHU12.ordinal() ? DashBoardType.MCU_IHU12 : DashBoardType.UNKNOWN;
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
        public static final byte STATUS_STOP = 0;
        public String artist;
        public int current;
        public boolean isMute;
        public int playType;
        public int status;
        public String title;
        public int total;

        public MediaInfo(int source) {
            super(source);
        }

        public MediaInfo(int source, String title, String artist, int current, int total, int status) {
            super(source);
            this.title = title;
            this.artist = artist;
            this.current = current;
            this.total = total;
            this.status = status;
        }

        public MediaInfo(int source, String title, String artist, int current, int total, int status, int playType, boolean isMute) {
            super(source);
            this.title = title;
            this.artist = artist;
            this.current = current;
            this.total = total;
            this.status = status;
            this.playType = playType;
            this.isMute = isMute;
        }

        public boolean isInfoDiff(MediaInfo m) {
            return m == null ? true : this.getDashBoardSource() != m.getDashBoardSource() || this.title != null && m.title == null || this.title == null && m.title != null || this.title != null && m.title != null && !this.title.equals(m.title) || this.artist != null && m.artist == null || this.artist == null && m.artist != null || this.artist != null && m.artist != null && !this.artist.equals(m.artist);
        }

        public void setInfoDiff(MediaInfo m) {
            this.title = m.title;
            this.artist = m.artist;
            this.setDashBoardSource(m.getDashBoardSource());
        }

        @Override  // com.yftech.vehicle.internal.adapter.ICarDashBoard$AbsDashBoardInfo
        public byte[] toBytes() {
            byte[] resultArr = new byte[0x109];
            resultArr[0x101] = (byte)(this.current >> 8 & 0xFF);
            resultArr[0x102] = (byte)(this.current & 0xFF);
            resultArr[0x105] = (byte)(this.total >> 8 & 0xFF);
            resultArr[0x106] = (byte)(this.total & 0xFF);
            resultArr[0x109] = (byte)this.status;
            if(this.title != null) {
                System.arraycopy(this.title.getBytes(StandardCharsets.UTF_8), 0, resultArr, 0, this.title.getBytes(StandardCharsets.UTF_8).length);
            }
            if(this.artist != null) {
                System.arraycopy(this.artist.getBytes(StandardCharsets.UTF_8), 0, resultArr, 0x80, this.artist.getBytes(StandardCharsets.UTF_8).length);
            }
            return resultArr;
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

        private PhoneAction(int value) {
            this.value = value;
        }

        public static PhoneAction valueOf(int value) {
            if(value == PhoneAction.MUTE_MIC.value) {
                return PhoneAction.MUTE_MIC;
            }
            if(value == PhoneAction.USE_HANDSET.value) {
                return PhoneAction.USE_HANDSET;
            }
            if(value == PhoneAction.ENDING_CALL.value) {
                return PhoneAction.ENDING_CALL;
            }
            if(value == PhoneAction.REFUSE_CALL.value) {
                return PhoneAction.REFUSE_CALL;
            }
            return value == PhoneAction.ANSWER_CALL.value ? PhoneAction.ANSWER_CALL : PhoneAction.__UNKNOWN__;
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

        public RadioInfo(int source, byte mBandType, boolean isPrefebIndex, byte mPrefebIndex, int mFrequency) {
            super(source);
            this.mBandType = mBandType;
            this.isPrefebIndex = isPrefebIndex;
            this.mPrefebIndex = mPrefebIndex;
            this.mFrequency = mFrequency;
        }

        public RadioInfo(int source, byte mBandType, boolean isPrefebIndex, byte mPrefebIndex, int mFrequency, byte scanMode) {
            super(source);
            this.mBandType = mBandType;
            this.isPrefebIndex = isPrefebIndex;
            this.mPrefebIndex = mPrefebIndex;
            this.mFrequency = mFrequency;
            this.scanMode = scanMode;
        }

        public boolean isInfoDiff(RadioInfo r) {
            return r == null ? true : this.mBandType != r.mBandType || this.mFrequency != r.mFrequency;
        }

        public void setInfoDiff(RadioInfo r) {
            this.mBandType = r.mBandType;
            this.mFrequency = r.mFrequency;
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
        public static int DISTANCE_M;
        public static int DISTANCE_MILE;
        public static int FUEL_CONSUMPTION_KM_KWH;
        public static int FUEL_CONSUMPTION_KM_L;
        public static int FUEL_CONSUMPTION_KWH_100KM;
        public static int FUEL_CONSUMPTION_KWH_MILE;
        public static int FUEL_CONSUMPTION_L_100KM;
        public static int FUEL_CONSUMPTION_MILES_KWH;
        public static int FUEL_CONSUMPTION_MPG_UK;
        public static int FUEL_CONSUMPTION_MPG_US;
        public static byte PRESSURE_BAR;
        public static byte PRESSURE_KGF_CM2;
        public static byte PRESSURE_KPA;
        public static byte PRESSURE_PSI;
        public static byte TEMPERATURE_DEG_C;
        public static byte TEMPERATURE_DEG_F;
        public int mUnitDistance;
        public int mUnitFuelConsumption;
        public int mUnitPressure;
        public int mUnitTemperature;

        static {
            SetItemUnitInfo.PRESSURE_KGF_CM2 = 4;
            SetItemUnitInfo.PRESSURE_BAR = 3;
            SetItemUnitInfo.PRESSURE_PSI = 2;
            SetItemUnitInfo.PRESSURE_KPA = 1;
            SetItemUnitInfo.TEMPERATURE_DEG_C = 1;
            SetItemUnitInfo.TEMPERATURE_DEG_F = 2;
            SetItemUnitInfo.DISTANCE_MILE = 2;
            SetItemUnitInfo.DISTANCE_M = 1;
            SetItemUnitInfo.FUEL_CONSUMPTION_KWH_MILE = 84;
            SetItemUnitInfo.FUEL_CONSUMPTION_MILES_KWH = 83;
            SetItemUnitInfo.FUEL_CONSUMPTION_KWH_100KM = 82;
            SetItemUnitInfo.FUEL_CONSUMPTION_KM_KWH = 81;
            SetItemUnitInfo.FUEL_CONSUMPTION_MPG_UK = 4;
            SetItemUnitInfo.FUEL_CONSUMPTION_MPG_US = 3;
            SetItemUnitInfo.FUEL_CONSUMPTION_L_100KM = 2;
            SetItemUnitInfo.FUEL_CONSUMPTION_KM_L = 1;
        }

        public SetItemUnitInfo() {
        }

        private SetItemUnitInfo(int unitPressure, int unitTemperature, int unitDistance, int unitFuelConsumption) {
            this.mUnitPressure = unitPressure;
            this.mUnitTemperature = unitTemperature;
            this.mUnitDistance = unitDistance;
            this.mUnitFuelConsumption = unitFuelConsumption;
        }

        @Override
        public String toString() {
            return "SetItemUnitInfo{mUnitPressure=" + this.mUnitPressure + ", mUnitTemperature=" + this.mUnitTemperature + ", mUnitDistance=" + this.mUnitDistance + ", mUnitFuelConsumption=" + this.mUnitFuelConsumption + '}';
        }

        public static SetItemUnitInfo valueOf(byte[] value) {
            return new SetItemUnitInfo(((int)value[0]), ((int)value[1]), ((int)value[2]), ((int)value[3]));
        }
    }

    public static enum TimeFormatMode {
        MODE_12H(1),
        MODE_24H(2),
        __UNKNOWN__(-1);

        public final int value;

        private TimeFormatMode(int value) {
            this.value = value;
        }

        public static TimeFormatMode valueOf(int value) {
            if(value == TimeFormatMode.MODE_12H.value) {
                return TimeFormatMode.MODE_12H;
            }
            return value == TimeFormatMode.MODE_24H.value ? TimeFormatMode.MODE_24H : TimeFormatMode.__UNKNOWN__;
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

