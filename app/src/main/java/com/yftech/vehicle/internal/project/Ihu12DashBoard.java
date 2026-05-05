package com.yftech.vehicle.internal.project;

import android.text.TextUtils;
import android.util.Log;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.AbsDashBoardInfo;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.BtInfo;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.DABInfo;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.MediaInfo;
import com.yftech.vehicle.internal.adapter.ICarDashBoard.RadioInfo;
import java.nio.charset.StandardCharsets;

public class Ihu12DashBoard {
    public static enum CaculationState {
        IN_CACULATION(0),
        CACULATION_DONE(1),
        NOT_IN_NAVI(2),
        __UNKNOWN__(-1);

        public final int value;

        private CaculationState(int value) {
            this.value = value;
        }

        public static CaculationState valueOf(int value) {
            if(value == CaculationState.IN_CACULATION.value) {
                return CaculationState.IN_CACULATION;
            }
            if(value == CaculationState.CACULATION_DONE.value) {
                return CaculationState.CACULATION_DONE;
            }
            return value == CaculationState.NOT_IN_NAVI.value ? CaculationState.NOT_IN_NAVI : CaculationState.__UNKNOWN__;
        }
    }

    public static enum CompassGuide {
        N(1),
        NE(2),
        E(3),
        SE(4),
        S(5),
        SW(6),
        W(7),
        NW(8),
        __UNKNOWN__(-1);

        public final int value;

        private CompassGuide(int value) {
            this.value = value;
        }

        public static CompassGuide valueOf(int value) {
            if(value == CompassGuide.N.ordinal()) {
                return CompassGuide.N;
            }
            if(value == CompassGuide.NE.ordinal()) {
                return CompassGuide.NE;
            }
            if(value == CompassGuide.E.ordinal()) {
                return CompassGuide.E;
            }
            if(value == CompassGuide.SE.ordinal()) {
                return CompassGuide.SE;
            }
            if(value == CompassGuide.S.ordinal()) {
                return CompassGuide.S;
            }
            if(value == CompassGuide.SW.ordinal()) {
                return CompassGuide.SW;
            }
            if(value == CompassGuide.W.ordinal()) {
                return CompassGuide.W;
            }
            return value == CompassGuide.NW.ordinal() ? CompassGuide.NW : CompassGuide.__UNKNOWN__;
        }
    }

    public static enum GpsSignal {
        NO_SIGNAL(0),
        HAVE_SIGNAL(1),
        __UNKNOWN__(-1);

        public final int value;

        private GpsSignal(int value) {
            this.value = value;
        }

        public static GpsSignal valueOf(int value) {
            if(value == GpsSignal.NO_SIGNAL.value) {
                return GpsSignal.NO_SIGNAL;
            }
            return value == GpsSignal.HAVE_SIGNAL.value ? GpsSignal.HAVE_SIGNAL : GpsSignal.__UNKNOWN__;
        }
    }

    public static enum NaviDistUnit {
        METER(1),
        KILOMETER(2),
        MILE(3),
        __UNKNOWN__(-1);

        public final int value;

        private NaviDistUnit(int value) {
            this.value = value;
        }

        public static NaviDistUnit valueOf(int value) {
            if(value == NaviDistUnit.METER.value) {
                return NaviDistUnit.METER;
            }
            if(value == NaviDistUnit.KILOMETER.value) {
                return NaviDistUnit.KILOMETER;
            }
            return value == NaviDistUnit.MILE.value ? NaviDistUnit.MILE : NaviDistUnit.__UNKNOWN__;
        }
    }

    public static class NaviGuideBaseInfo {
        public int azimuthInfo;
        public CaculationState caculationState;
        public CompassGuide compass;
        public GpsSignal gpsSignal;
        public int naviIcon_RC;
        public int naviIcon_TBT;
        public int naviIcon_WS;
        public NaviState naviState;
        public String nextRoadName;
        public String roadName;
        public SeaLevel seaLevel;

        public NaviGuideBaseInfo(SeaLevel seaLevel, GpsSignal gpsSignal, int azimuthInfo, NaviState naviState, int naviIcon_TBT, int naviIcon_RC, int naviIcon_WS, CompassGuide compass, String roadName, String nextRoadName, CaculationState caculationState) {
            this.seaLevel = SeaLevel.__UNKNOWN__;
            this.gpsSignal = GpsSignal.__UNKNOWN__;
            this.naviState = NaviState.__UNKNOWN__;
            this.compass = CompassGuide.__UNKNOWN__;
            this.roadName = "";
            this.nextRoadName = "";
            this.caculationState = CaculationState.__UNKNOWN__;
            this.seaLevel = seaLevel;
            this.gpsSignal = gpsSignal;
            this.azimuthInfo = azimuthInfo;
            this.naviState = naviState;
            this.naviIcon_TBT = naviIcon_TBT;
            this.naviIcon_RC = naviIcon_RC;
            this.naviIcon_WS = naviIcon_WS;
            this.compass = compass;
            this.roadName = roadName;
            this.nextRoadName = nextRoadName;
            this.caculationState = caculationState;
        }
    }

    public static enum NaviState {
        NOT_NAVIGATED(0),
        NAV_PLANNING(1),
        NAV_START(2),
        NAVIGATING(3),
        NAV_OVER(4),
        __UNKNOWN__(-1);

        public final int value;

        private NaviState(int value) {
            this.value = value;
        }

        public static NaviState valueOf(int value) {
            if(value == NaviState.NOT_NAVIGATED.value) {
                return NaviState.NOT_NAVIGATED;
            }
            if(value == NaviState.NAV_PLANNING.value) {
                return NaviState.NAV_PLANNING;
            }
            if(value == NaviState.NAV_START.value) {
                return NaviState.NAV_START;
            }
            if(value == NaviState.NAVIGATING.value) {
                return NaviState.NAVIGATING;
            }
            return value == NaviState.NAV_OVER.value ? NaviState.NAV_OVER : NaviState.__UNKNOWN__;
        }
    }

    public static class NaviUpdateData {
        public int NaviDestDistInfo;
        public int NaviDist;
        public int NaviDistBar;
        public int NaviHour;
        public int NaviMinitue;
        public NaviDistUnit naviDistUnit;
        public NaviDistUnit naviSumDistUnit;

        public NaviUpdateData(NaviDistUnit naviDistUnit, int naviDist, int naviDistBar, NaviDistUnit naviSumDistUnit, int naviMinitue, int naviHour, int naviDestDistInfo) {
            this.naviDistUnit = NaviDistUnit.__UNKNOWN__;
            this.naviSumDistUnit = NaviDistUnit.__UNKNOWN__;
            this.naviDistUnit = naviDistUnit;
            this.NaviDist = naviDist;
            this.NaviDistBar = naviDistBar;
            this.naviSumDistUnit = naviSumDistUnit;
            this.NaviMinitue = naviMinitue;
            this.NaviHour = naviHour;
            this.NaviDestDistInfo = naviDestDistInfo;
        }
    }

    public static enum SeaLevel {
        BELOW_SEA(0),
        ABOVE_SEA(1),
        __UNKNOWN__(-1);

        public final int value;

        private SeaLevel(int value) {
            this.value = value;
        }

        public static SeaLevel valueOf(int value) {
            if(value == SeaLevel.BELOW_SEA.value) {
                return SeaLevel.BELOW_SEA;
            }
            return value == SeaLevel.ABOVE_SEA.value ? SeaLevel.ABOVE_SEA : SeaLevel.__UNKNOWN__;
        }
    }

    public static final byte INFO_TYPE_NAVI_BASE_INFO = 7;
    public static final byte INFO_TYPE_NAVI_GUIDE_COMPASS = 8;
    public static final byte INFO_TYPE_NAVI_GUIDE_CURR_LOAD_NAME = 9;
    public static final byte INFO_TYPE_NAVI_GUIDE_NEXT_LOAD_NAME = 10;
    public static final byte INFO_TYPE_NAVI_GUIDE_NEXT_PATH_CALCULATION = 11;
    public static final byte INFO_TYPE_PHONE_INFO = 3;
    public static final byte INFO_TYPE_PHONE_NAME = 5;
    public static final byte INFO_TYPE_PHONE_NUMBER = 4;
    public static final byte INFO_TYPE_PHONE_TIMES = 6;
    public static final byte INFO_TYPE_SONG_ARTIST = 2;
    public static final byte INFO_TYPE_SONG_TITLE = 1;
    private static final String TAG = "Ihu12DashBoard";
    static AbsDashBoardInfo mAbsInfo;
    private static byte[] mDashBoardInfoDataByteArrayForIhu12;
    private static int mLastSource;

    static {
        Ihu12DashBoard.mLastSource = 0;
        Ihu12DashBoard.mDashBoardInfoDataByteArrayForIhu12 = new byte[18];
    }

    public static byte[] getDabProgramInfo(AbsDashBoardInfo info) {
        if(!(info instanceof DABInfo)) {
            Log.w("Ihu12DashBoard", "getDabProgramInfo() - info is not DABInfo");
            return new byte[8];
        }
        String mTitle = ((DABInfo)info).mDabProgramName == null ? "" : ((DABInfo)info).mDabProgramName + " ";
        int titleLen = mTitle == null ? 0 : mTitle.getBytes(StandardCharsets.UTF_16BE).length;
        if(mTitle.length() > 27) {
            mTitle = mTitle.substring(0, 24) + "...";
            titleLen = mTitle == null ? 0 : mTitle.getBytes(StandardCharsets.UTF_16BE).length;
        }
        byte[] byteArray = new byte[titleLen + 5];
        byteArray[0] = (byte)0x84;
        byteArray[1] = 16;
        byteArray[2] = 2;
        byteArray[3] = (byte)titleLen;
        byteArray[4] = 0;
        if(titleLen != 0) {
            System.arraycopy(mTitle.getBytes(StandardCharsets.UTF_16BE), 0, byteArray, 5, titleLen);
        }
        return byteArray;
    }

    public static byte[] getDashBoardInfoDataByteArrayForIhu12(AbsDashBoardInfo info) {
        byte[] byteArray = Ihu12DashBoard.mDashBoardInfoDataByteArrayForIhu12;
        byteArray[0] = (byte)0x84;
        byteArray[1] = 16;
        byteArray[2] = 1;
        byteArray[3] = 0;
        switch(info.getDashBoardSource()) {
            case 3: {
                byteArray[3] = 4;
                break;
            }
            case 4: {
                byteArray[3] = 22;
                break;
            }
            case 5: {
                byteArray[3] = 6;
                break;
            }
            case 2: 
            case 9: {
                byteArray[3] = 3;
                break;
            }
            case 12: {
                byteArray[3] = 33;
                break;
            }
            case 13: {
                byteArray[3] = 0x20;
                break;
            }
            case 14: {
                byteArray[3] = 20;
                break;
            }
            case 15: {
                byteArray[3] = 36;
                break;
            }
            case 16: {
                byteArray[3] = 37;
            }
        }
        switch(info.getDashBoardSource()) {
            case 1: {
                if(!(info instanceof RadioInfo)) {
                    Log.w("Ihu12DashBoard", "formartDashBoardInfoDataBytes() AbsDashBoardInfo is not RadioInfo");
                    return byteArray;
                }
                switch(((RadioInfo)info).mBandType) {
                    case 0: 
                    case 1: 
                    case 2: {
                        byteArray[3] = 15;
                        break;
                    }
                    case 3: 
                    case 4: {
                        byteArray[3] = 14;
                    }
                }
                byteArray[13] = ((RadioInfo)info).scanMode == 1 ? 0 : ((RadioInfo)info).scanMode;
                switch(((RadioInfo)info).mBandType) {
                    case 0: 
                    case 1: 
                    case 2: {
                        int fmFrequency = ((RadioInfo)info).mFrequency / 10 - 6500;
                        if(fmFrequency < 0) {
                            fmFrequency = 0;
                        }
                        byteArray[14] = (byte)(fmFrequency >> 8 & 0xFF);
                        byteArray[15] = (byte)(fmFrequency & 0xFF);
                        return byteArray;
                    }
                    case 3: 
                    case 4: {
                        int amFrequency = ((RadioInfo)info).mFrequency - 0x90;
                        if(amFrequency < 0) {
                            amFrequency = 0;
                        }
                        byteArray[16] = (byte)(amFrequency >> 8 & 0xFF);
                        byteArray[17] = (byte)(amFrequency & 0xFF);
                        return byteArray;
                    }
                    default: {
                        return byteArray;
                    }
                }
            }
            case 2: 
            case 3: 
            case 5: 
            case 9: 
            case 12: 
            case 13: 
            case 14: 
            case 16: {
                if(!(info instanceof MediaInfo)) {
                    Log.w("Ihu12DashBoard", "getDashBoardInfoDataByteArrayForIhu12() AbsDashBoardInfo is not MediaInfo");
                    return byteArray;
                }
                switch(((MediaInfo)info).status) {
                    case 1: {
                        byteArray[4] = 2;
                        break;
                    }
                    case 2: {
                        byteArray[4] = 1;
                    }
                }
                byteArray[5] = (byte)((MediaInfo)info).playType;
                int timeUnit = info.getDashBoardSource() == 16 ? 1 : 1000;
                int totalHours = ((MediaInfo)info).total % (timeUnit * 60 * 60 * 24) / (timeUnit * 60 * 60);
                int totalMinutes = ((MediaInfo)info).total % (timeUnit * 60 * 60) / (timeUnit * 60);
                int totalSeconds = ((MediaInfo)info).total % (timeUnit * 60) / timeUnit;
                Log.w("Ihu12DashBoard", "ihu12: totalHours " + totalHours + "  totalMinutes" + totalMinutes + "  totalSeconds" + totalSeconds);
                int currHours = ((MediaInfo)info).current % (timeUnit * 60 * 60 * 24) / (timeUnit * 60 * 60);
                int currMinutes = ((MediaInfo)info).current % (timeUnit * 60 * 60) / (timeUnit * 60);
                int currSeconds = ((MediaInfo)info).current % (timeUnit * 60) / timeUnit;
                Log.w("Ihu12DashBoard", "ihu12: currHours " + currHours + "  currMinutes " + totalMinutes + "  currSeconds " + totalSeconds);
                byteArray[6] = (byte)totalHours;
                byteArray[7] = (byte)totalMinutes;
                byteArray[8] = (byte)totalSeconds;
                byteArray[9] = (byte)currHours;
                byteArray[10] = (byte)currMinutes;
                byteArray[11] = (byte)currSeconds;
                byteArray[12] = (byte)(((MediaInfo)info).isMute ? 0 : 1);
                return byteArray;
            }
            default: {
                return byteArray;
            }
        }
    }

    public static byte[] getDashBoardSourceDataByteArray(int source, AbsDashBoardInfo info) {
        byte[] byteArray = new byte[18];
        byteArray[0] = (byte)0x84;
        byteArray[1] = 16;
        byteArray[2] = 1;
        byteArray[3] = 0;
        if(source != -1 && source != 0) {
            byteArray = null;
        }
        else {
            byteArray[3] = 0;
        }
        if(info == null) {
            Log.d("Ihu12DashBoard", "MCU_IHU12  getDashBoardSourceDataByteArray->source=" + source + ",info is null continue");
        }
        return byteArray;
    }

    public static byte[] getMediaInfo(byte infoType, AbsDashBoardInfo info) {
        byte[] byteArray = new byte[8];
        switch(infoType) {
            case 1: {
                if(!(info instanceof MediaInfo)) {
                    Log.w("Ihu12DashBoard", "getMediaInfo() - SONG_TITLE info is not MediaInfo");
                    return byteArray;
                }
                String mTitle = ((MediaInfo)info).title == null ? "" : ((MediaInfo)info).title + " ";
                int titleLen = mTitle == null ? 0 : mTitle.getBytes(StandardCharsets.UTF_16BE).length;
                if(mTitle.length() > 27) {
                    mTitle = mTitle.substring(0, 24) + "...";
                    titleLen = mTitle == null ? 0 : mTitle.getBytes(StandardCharsets.UTF_16BE).length;
                }
                byteArray = new byte[titleLen + 5];
                byteArray[0] = (byte)0x84;
                byteArray[1] = 16;
                byteArray[2] = 2;
                byteArray[3] = (byte)titleLen;
                byteArray[4] = 0;
                if(titleLen != 0) {
                    System.arraycopy(mTitle.getBytes(StandardCharsets.UTF_16BE), 0, byteArray, 5, titleLen);
                    return byteArray;
                }
                break;
            }
            case 2: {
                if(!(info instanceof MediaInfo)) {
                    Log.w("Ihu12DashBoard", "getMediaInfo() - SONG_ARTIST info is not MediaInfo");
                    return byteArray;
                }
                String mArtist = ((MediaInfo)info).artist == null ? "" : ((MediaInfo)info).artist + " ";
                int artistLen = mArtist == null ? 0 : mArtist.getBytes(StandardCharsets.UTF_16BE).length;
                if(mArtist.length() > 27) {
                    mArtist = mArtist.substring(0, 24) + "...";
                    artistLen = mArtist == null ? 0 : mArtist.getBytes(StandardCharsets.UTF_16BE).length;
                }
                byteArray = new byte[artistLen + 5];
                byteArray[0] = (byte)0x84;
                byteArray[1] = 16;
                byteArray[2] = 3;
                byteArray[3] = (byte)artistLen;
                byteArray[4] = 0;
                if(artistLen != 0) {
                    System.arraycopy(mArtist.getBytes(StandardCharsets.UTF_16BE), 0, byteArray, 5, artistLen);
                    return byteArray;
                }
                break;
            }
            case 3: {
                if(!(info instanceof BtInfo)) {
                    Log.w("Ihu12DashBoard", "getMediaInfo() - PHONE_INFO info is not BtInfo");
                    return byteArray;
                }
                byteArray = new byte[8];
                byteArray[0] = (byte)0x84;
                byteArray[1] = 17;
                byteArray[2] = 1;
                byteArray[3] = (byte) (((BtInfo)info).mBtStatus == 0 ? 0 : 1);
                byteArray[4] = 0;
                byteArray[5] = 0;
                switch(((BtInfo)info).mBtStatus) {
                    case 0: {
                        byteArray[6] = 0;
                        break;
                    }
                    case 2: {
                        byteArray[6] = 1;
                        break;
                    }
                    case 3: {
                        byteArray[6] = 2;
                        break;
                    }
                    case 5: {
                        byteArray[6] = 4;
                        break;
                    }
                    case 6: {
                        byteArray[6] = 5;
                        break;
                    }
                    case 4: 
                    case 7: {
                        byteArray[6] = 3;
                        break;
                    }
                    default: {
                        byteArray[6] = 0;
                    }
                }
                byteArray[7] = 1;
                if(((BtInfo)info).mPhoneSourceType == 4) {
                    byteArray[7] = 2;
                }
                if(((BtInfo)info).mPhoneSourceType == 5) {
                    byteArray[7] = 3;
                    return byteArray;
                }
                break;
            }
            case 4: {
                if(!(info instanceof BtInfo)) {
                    Log.w("Ihu12DashBoard", "getMediaInfo() - PHONE_NUMBER info is not BtInfo");
                    return byteArray;
                }
                String mBtNum = ((BtInfo)info).mBtCallNumber == null ? "" : ((BtInfo)info).mBtCallNumber + " ";
                int btNumLen = mBtNum == null ? 0 : mBtNum.getBytes(StandardCharsets.UTF_16BE).length;
                if(mBtNum.length() > 27) {
                    mBtNum = mBtNum.substring(0, 24) + "...";
                    btNumLen = mBtNum == null ? 0 : mBtNum.getBytes(StandardCharsets.UTF_16BE).length;
                }
                byteArray = new byte[btNumLen + 5];
                byteArray[0] = (byte)0x84;
                byteArray[1] = 17;
                byteArray[2] = 2;
                byteArray[3] = (byte)btNumLen;
                byteArray[4] = 0;
                if(btNumLen != 0) {
                    System.arraycopy(mBtNum.getBytes(StandardCharsets.UTF_16BE), 0, byteArray, 5, btNumLen);
                    return byteArray;
                }
                break;
            }
            case 5: {
                if(!(info instanceof BtInfo)) {
                    Log.w("Ihu12DashBoard", "getMediaInfo() - PHONE_NAME info is not BtInfo");
                    return byteArray;
                }
                String mBtName = ((BtInfo)info).mBtName == null ? "" : ((BtInfo)info).mBtName + " ";
                int btNameLen = mBtName == null ? 0 : mBtName.getBytes(StandardCharsets.UTF_16BE).length;
                if(mBtName.length() > 27) {
                    mBtName = mBtName.substring(0, 24) + "...";
                    btNameLen = mBtName == null ? 0 : mBtName.getBytes(StandardCharsets.UTF_16BE).length;
                }
                byteArray = new byte[btNameLen + 5];
                byteArray[0] = (byte)0x84;
                byteArray[1] = 17;
                byteArray[2] = 3;
                byteArray[3] = (byte)btNameLen;
                byteArray[4] = 0;
                if(btNameLen != 0) {
                    System.arraycopy(mBtName.getBytes(StandardCharsets.UTF_16BE), 0, byteArray, 5, btNameLen);
                    return byteArray;
                }
                break;
            }
            case 6: {
                if(!(info instanceof BtInfo)) {
                    Log.w("Ihu12DashBoard", "getMediaInfo() - PHONE_TIMES info is not btInfo");
                    return byteArray;
                }
                int btHours = ((BtInfo)info).talkTimes % 86400000 / 3600000;
                int btMinutes = ((BtInfo)info).talkTimes % 3600000 / 60000;
                int btSeconds = ((BtInfo)info).talkTimes % 60000 / 1000;
                Log.w("Ihu12DashBoard", "INFO_TYPE_PHONE_TIMES: " + btHours + " currHours " + btMinutes + " currMinutes " + btSeconds + " currSeconds ");
                return new byte[]{(byte)0x84, 17, 4, ((byte)(btHours >> 8 & 0xFF)), ((byte)(btHours & 0xFF)), ((byte)btMinutes), ((byte)btSeconds), 0};
            }
            default: {
                return byteArray;
            }
        }
        return byteArray;
    }

    public static byte[] getNaviGuideBaseInfoDataProtocol(byte infoType, NaviGuideBaseInfo info) {
        byte[] byteArray = new byte[8];
        if(info == null) {
            Log.w("Ihu12DashBoard", "getNaviGuideInfoDataProtocol() - PHONE_NUMBER info is null");
            return byteArray;
        }
        switch(infoType) {
            case 7: {
                return new byte[]{(byte)0x84, 18, 1, ((byte)info.seaLevel.ordinal()), ((byte)info.gpsSignal.ordinal()), ((byte)(info.azimuthInfo >> 8 & 0xFF)), ((byte)(info.azimuthInfo & 0xFF)), ((byte)info.naviState.value), ((byte)info.naviIcon_TBT), ((byte)info.naviIcon_RC), ((byte)info.naviIcon_WS)};
            }
            case 8: {
                return new byte[]{(byte)0x84, 18, 2, ((byte)info.compass.ordinal()), 0, 0, 0, 0};
            }
            case 9: {
                if(!(info instanceof NaviGuideBaseInfo)) {
                    Log.w("Ihu12DashBoard", "getNaviGuideBaseInfoDataProtocol() - INFO_TYPE_NAVI_GUIDE_CURR_LOAD_NAME info is not NaviGuideBaseInfo");
                    return byteArray;
                }
                if(info.roadName == null || "".equals(info.roadName)) {
                    Log.w("Ihu12DashBoard", "getNaviGuideInfoDataProtocol() - info.roadName is null");
                    return byteArray;
                }
                String mRoadName = info.roadName == null ? "" : info.roadName + " ";
                int roadNameLen = mRoadName == null ? 0 : mRoadName.getBytes(StandardCharsets.UTF_16BE).length;
                if(mRoadName.length() > 27) {
                    mRoadName = mRoadName.substring(0, 24) + "...";
                    roadNameLen = mRoadName == null ? 0 : mRoadName.getBytes(StandardCharsets.UTF_16BE).length;
                }
                byteArray = new byte[roadNameLen + 5];
                byteArray[0] = (byte)0x84;
                byteArray[1] = 18;
                byteArray[2] = 3;
                byteArray[3] = (byte)roadNameLen;
                byteArray[4] = 0;
                if(roadNameLen != 0) {
                    System.arraycopy(mRoadName.getBytes(StandardCharsets.UTF_16BE), 0, byteArray, 5, roadNameLen);
                    return byteArray;
                }
                break;
            }
            case 10: {
                if(!(info instanceof NaviGuideBaseInfo)) {
                    Log.w("Ihu12DashBoard", "getNaviGuideBaseInfoDataProtocol() - INFO_TYPE_NAVI_GUIDE_CURR_LOAD_NAME info is not NaviGuideBaseInfo");
                    return byteArray;
                }
                if(info.nextRoadName == null || "".equals(info.nextRoadName)) {
                    Log.w("Ihu12DashBoard", "getNaviGuideInfoDataProtocol() - info.nextRoadName is null");
                    return byteArray;
                }
                String mNextRoadName = info.nextRoadName == null ? "" : info.nextRoadName + " ";
                int nextRoadNameLen = mNextRoadName == null ? 0 : mNextRoadName.getBytes(StandardCharsets.UTF_16BE).length;
                if(mNextRoadName.length() > 27) {
                    mNextRoadName = mNextRoadName.substring(0, 24) + "...";
                    nextRoadNameLen = mNextRoadName == null ? 0 : mNextRoadName.getBytes(StandardCharsets.UTF_16BE).length;
                }
                byteArray = new byte[nextRoadNameLen + 5];
                byteArray[0] = (byte)0x84;
                byteArray[1] = 18;
                byteArray[2] = 4;
                byteArray[3] = (byte)nextRoadNameLen;
                byteArray[4] = 0;
                if(nextRoadNameLen != 0) {
                    System.arraycopy(mNextRoadName.getBytes(StandardCharsets.UTF_16BE), 0, byteArray, 5, nextRoadNameLen);
                    return byteArray;
                }
                break;
            }
            case 11: {
                if(info.caculationState == null) {
                    Log.w("Ihu12DashBoard", "getNaviGuideInfoDataProtocol() - info.caculationState is null");
                    return byteArray;
                }
                return new byte[]{(byte)0x84, 18, 5, ((byte)info.caculationState.ordinal()), 0, 0, 0, 0};
            }
            default: {
                return byteArray;
            }
        }
        return byteArray;
    }

    public static byte[] getNaviGuideUpdateDataProtocol(NaviUpdateData updateData) {
        if(updateData == null) {
            Log.w("Ihu12DashBoard", "getNaviGuideUpdateDataProtocol() - updateData is null");
            return new byte[8];
        }
        return new byte[]{(byte)0x84, 18, 6, ((byte)updateData.naviDistUnit.ordinal()), ((byte)(updateData.NaviDist >> 16 & 0xFF)), ((byte)(updateData.NaviDist >> 8 & 0xFF)), ((byte)(updateData.NaviDist & 0xFF)), ((byte)(updateData.NaviDistBar >> 16 & 0xFF)), ((byte)(updateData.NaviDistBar >> 8 & 0xFF)), ((byte)(updateData.NaviDistBar & 0xFF)), ((byte)updateData.naviSumDistUnit.ordinal()), ((byte)updateData.NaviMinitue), ((byte)(updateData.NaviHour >> 8 & 0xFF)), ((byte)(updateData.NaviHour & 0xFF)), ((byte)(updateData.NaviDestDistInfo >> 24 & 0xFF)), ((byte)(updateData.NaviDestDistInfo >> 16 & 0xFF)), ((byte)(updateData.NaviDestDistInfo >> 8 & 0xFF)), ((byte)(updateData.NaviDestDistInfo & 0xFF))};
    }

    public static boolean isBtInfoChange(AbsDashBoardInfo info) {
        boolean isBtUpdate = false;
        if(info == null) {
            Log.w("Ihu12DashBoard", "isBtInfoChange()  BtInfo is null)");
            return false;
        }
        if(((BtInfo)info).mBtCallNumber == null) {
            Log.w("Ihu12DashBoard", "isBtInfoChange()  BtInfo.mBtCallNumber is null)");
            return false;
        }
        if(Ihu12DashBoard.mAbsInfo == null || !(Ihu12DashBoard.mAbsInfo instanceof BtInfo)) {
            Ihu12DashBoard.mAbsInfo = new BtInfo();
            isBtUpdate = true;
        }
        else {
            BtInfo mBtInfoTemp = (BtInfo)Ihu12DashBoard.mAbsInfo;
            if(mBtInfoTemp != null && mBtInfoTemp.isInfoDiff(((BtInfo)info))) {
                mBtInfoTemp.setInfoDiff(((BtInfo)info));
                isBtUpdate = true;
            }
        }
        Log.d("Ihu12DashBoard", "isBtInfoChange() isBtInfoChange =" + isBtUpdate);
        return isBtUpdate;
    }

    public static boolean isCurrentSource(int currentSource) {
        return Ihu12DashBoard.mLastSource != currentSource;
    }

    public static boolean isDabProgramInfoChange(AbsDashBoardInfo info) {
        boolean isDabUpdate = false;
        if(info == null) {
            Log.w("Ihu12DashBoard", "isDabProgramInfoChange()  DABInfo is null)");
            return false;
        }
        if(Ihu12DashBoard.mAbsInfo == null || !(Ihu12DashBoard.mAbsInfo instanceof DABInfo)) {
            Ihu12DashBoard.mAbsInfo = new DABInfo(((DABInfo)info).mDabProgramName);
            isDabUpdate = true;
        }
        else {
            DABInfo mBtInfoTemp = (DABInfo)Ihu12DashBoard.mAbsInfo;
            Log.i("Ihu12DashBoard", "isDabProgramInfoChange: old info:" + mBtInfoTemp + " new info:" + info);
            if(mBtInfoTemp != null && !TextUtils.equals(mBtInfoTemp.mDabProgramName, ((DABInfo)info).mDabProgramName)) {
                Ihu12DashBoard.mAbsInfo = new DABInfo(((DABInfo)info).mDabProgramName);
                isDabUpdate = true;
            }
        }
        Log.d("Ihu12DashBoard", "isDabProgramInfoChange() isDabProgramInfoChange =" + isDabUpdate);
        return isDabUpdate;
    }

    public static boolean isMediaChange(AbsDashBoardInfo info) {
        boolean isMediaUpdate = false;
        if(((MediaInfo)info).title == null || ((MediaInfo)info).artist == null) {
            Log.w("Ihu12DashBoard", "isMediaChange() USB MediaInfo.title is null or AbsDashBoardInfo is not MediaInfo");
            return false;
        }
        if(Ihu12DashBoard.mAbsInfo == null || !(Ihu12DashBoard.mAbsInfo instanceof MediaInfo)) {
            Ihu12DashBoard.mAbsInfo = new MediaInfo(info.getDashBoardSource());
            ((MediaInfo)Ihu12DashBoard.mAbsInfo).setInfoDiff(((MediaInfo)info));
            isMediaUpdate = true;
            if(Ihu12DashBoard.mLastSource == 0) {
                Log.i("Ihu12DashBoard", "isMediaChange: mLastSource= 0 , update source: " + ((MediaInfo)info).getDashBoardSource());
                Ihu12DashBoard.mLastSource = ((MediaInfo)info).getDashBoardSource();
            }
        }
        else if(Ihu12DashBoard.mLastSource == Ihu12DashBoard.mAbsInfo.getDashBoardSource()) {
            MediaInfo mMediaInfoTemp = (MediaInfo)Ihu12DashBoard.mAbsInfo;
            if(mMediaInfoTemp != null && mMediaInfoTemp.isInfoDiff(((MediaInfo)info))) {
                mMediaInfoTemp.setInfoDiff(((MediaInfo)info));
                isMediaUpdate = true;
            }
        }
        else {
            Ihu12DashBoard.mAbsInfo.setDashBoardSource(((MediaInfo)info).getDashBoardSource());
            isMediaUpdate = true;
            if(Ihu12DashBoard.mLastSource == 0) {
                Log.i("Ihu12DashBoard", "isMediaChange: mLastSource= 0 , update source: " + ((MediaInfo)info).getDashBoardSource());
                Ihu12DashBoard.mLastSource = ((MediaInfo)info).getDashBoardSource();
            }
        }
        Log.d("Ihu12DashBoard", "isMediaChange()-3 mLastSource=" + Ihu12DashBoard.mLastSource + " mAbsInfo.getDashBoardSource()=" + Ihu12DashBoard.mAbsInfo.getDashBoardSource() + ", isMediaUpdate =" + isMediaUpdate);
        return isMediaUpdate;
    }

    public static void setCurrentSource(int currentSource) {
        Ihu12DashBoard.mLastSource = currentSource;
    }
}

