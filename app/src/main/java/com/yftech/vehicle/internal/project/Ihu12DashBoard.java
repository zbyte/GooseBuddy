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

        private CaculationState(int v1) {
            this.value = v1;
        }

        public static CaculationState valueOf(int v) {
            if(v == CaculationState.IN_CACULATION.value) {
                return CaculationState.IN_CACULATION;
            }
            if(v == CaculationState.CACULATION_DONE.value) {
                return CaculationState.CACULATION_DONE;
            }
            return v == CaculationState.NOT_IN_NAVI.value ? CaculationState.NOT_IN_NAVI : CaculationState.__UNKNOWN__;
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

        private CompassGuide(int v1) {
            this.value = v1;
        }

        public static CompassGuide valueOf(int v) {
            if(v == CompassGuide.N.ordinal()) {
                return CompassGuide.N;
            }
            if(v == CompassGuide.NE.ordinal()) {
                return CompassGuide.NE;
            }
            if(v == CompassGuide.E.ordinal()) {
                return CompassGuide.E;
            }
            if(v == CompassGuide.SE.ordinal()) {
                return CompassGuide.SE;
            }
            if(v == CompassGuide.S.ordinal()) {
                return CompassGuide.S;
            }
            if(v == CompassGuide.SW.ordinal()) {
                return CompassGuide.SW;
            }
            if(v == CompassGuide.W.ordinal()) {
                return CompassGuide.W;
            }
            return v == CompassGuide.NW.ordinal() ? CompassGuide.NW : CompassGuide.__UNKNOWN__;
        }
    }

    public static enum GpsSignal {
        NO_SIGNAL(0),
        HAVE_SIGNAL(1),
        __UNKNOWN__(-1);

        public final int value;

        private GpsSignal(int v1) {
            this.value = v1;
        }

        public static GpsSignal valueOf(int v) {
            if(v == GpsSignal.NO_SIGNAL.value) {
                return GpsSignal.NO_SIGNAL;
            }
            return v == GpsSignal.HAVE_SIGNAL.value ? GpsSignal.HAVE_SIGNAL : GpsSignal.__UNKNOWN__;
        }
    }

    public static enum NaviDistUnit {
        METER(1),
        KILOMETER(2),
        MILE(3),
        __UNKNOWN__(-1);

        public final int value;

        private NaviDistUnit(int v1) {
            this.value = v1;
        }

        public static NaviDistUnit valueOf(int v) {
            if(v == NaviDistUnit.METER.value) {
                return NaviDistUnit.METER;
            }
            if(v == NaviDistUnit.KILOMETER.value) {
                return NaviDistUnit.KILOMETER;
            }
            return v == NaviDistUnit.MILE.value ? NaviDistUnit.MILE : NaviDistUnit.__UNKNOWN__;
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

        public NaviGuideBaseInfo(SeaLevel ihu12DashBoard$SeaLevel0, GpsSignal ihu12DashBoard$GpsSignal0, int v, NaviState ihu12DashBoard$NaviState0, int v1, int v2, int v3, CompassGuide ihu12DashBoard$CompassGuide0, String s, String s1, CaculationState ihu12DashBoard$CaculationState0) {
            this.seaLevel = SeaLevel.__UNKNOWN__;
            this.gpsSignal = GpsSignal.__UNKNOWN__;
            this.naviState = NaviState.__UNKNOWN__;
            this.compass = CompassGuide.__UNKNOWN__;
            this.roadName = "";
            this.nextRoadName = "";
            this.caculationState = CaculationState.__UNKNOWN__;
            this.seaLevel = ihu12DashBoard$SeaLevel0;
            this.gpsSignal = ihu12DashBoard$GpsSignal0;
            this.azimuthInfo = v;
            this.naviState = ihu12DashBoard$NaviState0;
            this.naviIcon_TBT = v1;
            this.naviIcon_RC = v2;
            this.naviIcon_WS = v3;
            this.compass = ihu12DashBoard$CompassGuide0;
            this.roadName = s;
            this.nextRoadName = s1;
            this.caculationState = ihu12DashBoard$CaculationState0;
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

        private NaviState(int v1) {
            this.value = v1;
        }

        public static NaviState valueOf(int v) {
            if(v == NaviState.NOT_NAVIGATED.value) {
                return NaviState.NOT_NAVIGATED;
            }
            if(v == NaviState.NAV_PLANNING.value) {
                return NaviState.NAV_PLANNING;
            }
            if(v == NaviState.NAV_START.value) {
                return NaviState.NAV_START;
            }
            if(v == NaviState.NAVIGATING.value) {
                return NaviState.NAVIGATING;
            }
            return v == NaviState.NAV_OVER.value ? NaviState.NAV_OVER : NaviState.__UNKNOWN__;
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

        public NaviUpdateData(NaviDistUnit ihu12DashBoard$NaviDistUnit0, int v, int v1, NaviDistUnit ihu12DashBoard$NaviDistUnit1, int v2, int v3, int v4) {
            this.naviDistUnit = NaviDistUnit.__UNKNOWN__;
            this.naviSumDistUnit = NaviDistUnit.__UNKNOWN__;
            this.naviDistUnit = ihu12DashBoard$NaviDistUnit0;
            this.NaviDist = v;
            this.NaviDistBar = v1;
            this.naviSumDistUnit = ihu12DashBoard$NaviDistUnit1;
            this.NaviMinitue = v2;
            this.NaviHour = v3;
            this.NaviDestDistInfo = v4;
        }
    }

    public static enum SeaLevel {
        BELOW_SEA(0),
        ABOVE_SEA(1),
        __UNKNOWN__(-1);

        public final int value;

        private SeaLevel(int v1) {
            this.value = v1;
        }

        public static SeaLevel valueOf(int v) {
            if(v == SeaLevel.BELOW_SEA.value) {
                return SeaLevel.BELOW_SEA;
            }
            return v == SeaLevel.ABOVE_SEA.value ? SeaLevel.ABOVE_SEA : SeaLevel.__UNKNOWN__;
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
        Ihu12DashBoard.mDashBoardInfoDataByteArrayForIhu12 = new byte[18];
    }

    public static byte[] getDabProgramInfo(AbsDashBoardInfo iCarDashBoard$AbsDashBoardInfo0) {
        if(!(iCarDashBoard$AbsDashBoardInfo0 instanceof DABInfo)) {
            Log.w("Ihu12DashBoard", "getDabProgramInfo() - info is not DABInfo");
            return new byte[8];
        }
        String s = ((DABInfo)iCarDashBoard$AbsDashBoardInfo0).mDabProgramName == null ? "" : ((DABInfo)iCarDashBoard$AbsDashBoardInfo0).mDabProgramName + " ";
        int v = s == null ? 0 : s.getBytes(StandardCharsets.UTF_16BE).length;
        if(s.length() > 27) {
            s = s.substring(0, 24) + "...";
            v = s == null ? 0 : s.getBytes(StandardCharsets.UTF_16BE).length;
        }
        byte[] arr_b = new byte[v + 5];
        arr_b[0] = (byte)0x84;
        arr_b[1] = 16;
        arr_b[2] = 2;
        arr_b[3] = (byte)v;
        arr_b[4] = 0;
        if(v != 0) {
            System.arraycopy(s.getBytes(StandardCharsets.UTF_16BE), 0, arr_b, 5, v);
        }
        return arr_b;
    }

    public static byte[] getDashBoardInfoDataByteArrayForIhu12(AbsDashBoardInfo iCarDashBoard$AbsDashBoardInfo0) {
        byte[] arr_b = Ihu12DashBoard.mDashBoardInfoDataByteArrayForIhu12;
        arr_b[0] = (byte)0x84;
        arr_b[1] = 16;
        arr_b[2] = 1;
        arr_b[3] = 0;
        int v = iCarDashBoard$AbsDashBoardInfo0.getDashBoardSource();
        if(v == 9) {
            arr_b[3] = 3;
        }
        else {
            switch(v) {
                case 2: {
                    arr_b[3] = 3;
                    break;
                }
                case 3: {
                    arr_b[3] = 4;
                    break;
                }
                case 4: {
                    arr_b[3] = 22;
                    break;
                }
                case 5: {
                    arr_b[3] = 6;
                    break;
                }
                case 12: {
                    arr_b[3] = 33;
                    break;
                }
                case 13: {
                    arr_b[3] = 0x20;
                    break;
                }
                case 14: {
                    arr_b[3] = 20;
                    break;
                }
                case 15: {
                    arr_b[3] = 36;
                    break;
                }
                case 16: {
                    arr_b[3] = 37;
                }
            }
        }
        int v1 = iCarDashBoard$AbsDashBoardInfo0.getDashBoardSource();
        if(v1 != 5 && v1 != 9 && v1 != 16) {
            switch(v1) {
                default:
                case 1: {
                    if(!(iCarDashBoard$AbsDashBoardInfo0 instanceof RadioInfo)) {
                        Log.w("Ihu12DashBoard", "formartDashBoardInfoDataBytes() AbsDashBoardInfo is not RadioInfo");
                        return arr_b;
                    }
                    switch(((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).mBandType) {
                        case 0: 
                        case 1: 
                        case 2: {
                            arr_b[3] = 15;
                            break;
                        }
                        case 3: 
                        case 4: {
                            arr_b[3] = 14;
                        }
                    }
                    arr_b[13] = ((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).scanMode == 1 ? 0 : ((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).scanMode;
                    switch(((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).mBandType) {
                        case 0: 
                        case 1: 
                        case 2: {
                            int v2 = ((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).mFrequency / 10 - 6500;
                            if(v2 < 0) {
                                v2 = 0;
                            }
                            arr_b[14] = (byte)(v2 >> 8 & 0xFF);
                            arr_b[15] = (byte)(v2 & 0xFF);
                            return arr_b;
                        }
                        case 3: 
                        case 4: {
                            int v3 = ((RadioInfo)iCarDashBoard$AbsDashBoardInfo0).mFrequency - 0x90;
                            if(v3 < 0) {
                                v3 = 0;
                            }
                            arr_b[16] = (byte)(v3 >> 8 & 0xFF);
                            arr_b[17] = (byte)(v3 & 0xFF);
                            return arr_b;
                        }
                        default: {
                            return arr_b;
                        }
                    }
                label_55:
                    if(v1 != 12 && v1 != 13 && v1 != 14) {
                        return arr_b;
                    }
                    break;
                }
                case 2: 
                case 3: {
                    break;
                }
            }
        }
        if(!(iCarDashBoard$AbsDashBoardInfo0 instanceof MediaInfo)) {
            Log.w("Ihu12DashBoard", "getDashBoardInfoDataByteArrayForIhu12() AbsDashBoardInfo is not MediaInfo");
            return arr_b;
        }
        switch(((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).status) {
            case 1: {
                arr_b[4] = 2;
                break;
            }
            case 2: {
                arr_b[4] = 1;
            }
        }
        arr_b[5] = (byte)((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).playType;
        int v4 = iCarDashBoard$AbsDashBoardInfo0.getDashBoardSource() == 16 ? 1 : 1000;
        int v5 = v4 * 60 * 60;
        int v6 = ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).total % (v5 * 24) / v5;
        int v7 = ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).total % v5 / (v4 * 60);
        int v8 = ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).total % (v4 * 60) / v4;
        Log.w("Ihu12DashBoard", "ihu12: totalHours " + v6 + "  totalMinutes" + v7 + "  totalSeconds" + v8);
        int v9 = ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).current % (v5 * 24) / v5;
        int v10 = ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).current % v5 / (v4 * 60);
        int v11 = ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).current % (v4 * 60) / v4;
        Log.w("Ihu12DashBoard", "ihu12: currHours " + v9 + "  currMinutes " + v7 + "  currSeconds " + v8);
        arr_b[6] = (byte)v6;
        arr_b[7] = (byte)v7;
        arr_b[8] = (byte)v8;
        arr_b[9] = (byte)v9;
        arr_b[10] = (byte)v10;
        arr_b[11] = (byte)v11;
        arr_b[12] = (byte)(((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).isMute ^ 1);
        return arr_b;
    }

    public static byte[] getDashBoardSourceDataByteArray(int v, AbsDashBoardInfo iCarDashBoard$AbsDashBoardInfo0) {
        byte[] arr_b = new byte[18];
        arr_b[0] = (byte)0x84;
        arr_b[1] = 16;
        arr_b[2] = 1;
        arr_b[3] = 0;
        if(v != -1 && v != 0) {
            arr_b = null;
        }
        else {
            arr_b[3] = 0;
        }
        if(iCarDashBoard$AbsDashBoardInfo0 == null) {
            Log.d("Ihu12DashBoard", "MCU_IHU12  getDashBoardSourceDataByteArray->source=" + v + ",info is null continue");
        }
        return arr_b;
    }

    public static byte[] getMediaInfo(byte b, AbsDashBoardInfo iCarDashBoard$AbsDashBoardInfo0) {
        byte[] arr_b = new byte[8];
        switch(b) {
            case 1: {
                if(!(iCarDashBoard$AbsDashBoardInfo0 instanceof MediaInfo)) {
                    Log.w("Ihu12DashBoard", "getMediaInfo() - SONG_TITLE info is not MediaInfo");
                    return arr_b;
                }
                String s = ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).title == null ? "" : ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).title + " ";
                int v3 = s == null ? 0 : s.getBytes(StandardCharsets.UTF_16BE).length;
                if(s.length() > 27) {
                    s = s.substring(0, 24) + "...";
                    v3 = s == null ? 0 : s.getBytes(StandardCharsets.UTF_16BE).length;
                }
                arr_b = new byte[v3 + 5];
                arr_b[0] = (byte)0x84;
                arr_b[1] = 16;
                arr_b[2] = 2;
                arr_b[3] = (byte)v3;
                arr_b[4] = 0;
                if(v3 != 0) {
                    System.arraycopy(s.getBytes(StandardCharsets.UTF_16BE), 0, arr_b, 5, v3);
                    return arr_b;
                }
                break;
            }
            case 2: {
                if(!(iCarDashBoard$AbsDashBoardInfo0 instanceof MediaInfo)) {
                    Log.w("Ihu12DashBoard", "getMediaInfo() - SONG_ARTIST info is not MediaInfo");
                    return arr_b;
                }
                String s1 = ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).artist == null ? "" : ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).artist + " ";
                int v4 = s1 == null ? 0 : s1.getBytes(StandardCharsets.UTF_16BE).length;
                if(s1.length() > 27) {
                    s1 = s1.substring(0, 24) + "...";
                    v4 = s1 == null ? 0 : s1.getBytes(StandardCharsets.UTF_16BE).length;
                }
                arr_b = new byte[v4 + 5];
                arr_b[0] = (byte)0x84;
                arr_b[1] = 16;
                arr_b[2] = 3;
                arr_b[3] = (byte)v4;
                arr_b[4] = 0;
                if(v4 != 0) {
                    System.arraycopy(s1.getBytes(StandardCharsets.UTF_16BE), 0, arr_b, 5, v4);
                    return arr_b;
                }
                break;
            }
            case 3: {
                if(!(iCarDashBoard$AbsDashBoardInfo0 instanceof BtInfo)) {
                    Log.w("Ihu12DashBoard", "getMediaInfo() - PHONE_INFO info is not BtInfo");
                    return arr_b;
                }
                arr_b = new byte[8];
                arr_b[0] = (byte)0x84;
                arr_b[1] = 17;
                arr_b[2] = 1;
                arr_b[3] = ((BtInfo)iCarDashBoard$AbsDashBoardInfo0).mBtStatus == 0 ? 0 : 1;
                arr_b[4] = 0;
                arr_b[5] = 0;
                int v5 = ((BtInfo)iCarDashBoard$AbsDashBoardInfo0).mBtStatus;
                if(v5 == 0) {
                    arr_b[6] = 0;
                }
                else {
                    switch(v5) {
                        case 2: {
                            arr_b[6] = 1;
                            break;
                        }
                        case 3: {
                            arr_b[6] = 2;
                            break;
                        }
                        case 5: {
                            arr_b[6] = 4;
                            break;
                        }
                        case 6: {
                            arr_b[6] = 5;
                            break;
                        }
                        case 4: 
                        case 7: {
                            arr_b[6] = 3;
                            break;
                        }
                        default: {
                            arr_b[6] = 0;
                        }
                    }
                }
                arr_b[7] = 1;
                if(((BtInfo)iCarDashBoard$AbsDashBoardInfo0).mPhoneSourceType == 4) {
                    arr_b[7] = 2;
                }
                if(((BtInfo)iCarDashBoard$AbsDashBoardInfo0).mPhoneSourceType == 5) {
                    arr_b[7] = 3;
                    return arr_b;
                }
                break;
            }
            case 4: {
                if(!(iCarDashBoard$AbsDashBoardInfo0 instanceof BtInfo)) {
                    Log.w("Ihu12DashBoard", "getMediaInfo() - PHONE_NUMBER info is not BtInfo");
                    return arr_b;
                }
                String s2 = ((BtInfo)iCarDashBoard$AbsDashBoardInfo0).mBtCallNumber == null ? "" : ((BtInfo)iCarDashBoard$AbsDashBoardInfo0).mBtCallNumber + " ";
                int v6 = s2 == null ? 0 : s2.getBytes(StandardCharsets.UTF_16BE).length;
                if(s2.length() > 27) {
                    s2 = s2.substring(0, 24) + "...";
                    v6 = s2 == null ? 0 : s2.getBytes(StandardCharsets.UTF_16BE).length;
                }
                arr_b = new byte[v6 + 5];
                arr_b[0] = (byte)0x84;
                arr_b[1] = 17;
                arr_b[2] = 2;
                arr_b[3] = (byte)v6;
                arr_b[4] = 0;
                if(v6 != 0) {
                    System.arraycopy(s2.getBytes(StandardCharsets.UTF_16BE), 0, arr_b, 5, v6);
                    return arr_b;
                }
                break;
            }
            case 5: {
                if(!(iCarDashBoard$AbsDashBoardInfo0 instanceof BtInfo)) {
                    Log.w("Ihu12DashBoard", "getMediaInfo() - PHONE_NAME info is not BtInfo");
                    return arr_b;
                }
                String s3 = ((BtInfo)iCarDashBoard$AbsDashBoardInfo0).mBtName == null ? "" : ((BtInfo)iCarDashBoard$AbsDashBoardInfo0).mBtName + " ";
                int v7 = s3 == null ? 0 : s3.getBytes(StandardCharsets.UTF_16BE).length;
                if(s3.length() > 27) {
                    s3 = s3.substring(0, 24) + "...";
                    v7 = s3 == null ? 0 : s3.getBytes(StandardCharsets.UTF_16BE).length;
                }
                arr_b = new byte[v7 + 5];
                arr_b[0] = (byte)0x84;
                arr_b[1] = 17;
                arr_b[2] = 3;
                arr_b[3] = (byte)v7;
                arr_b[4] = 0;
                if(v7 != 0) {
                    System.arraycopy(s3.getBytes(StandardCharsets.UTF_16BE), 0, arr_b, 5, v7);
                    return arr_b;
                }
                break;
            }
            case 6: {
                if(!(iCarDashBoard$AbsDashBoardInfo0 instanceof BtInfo)) {
                    Log.w("Ihu12DashBoard", "getMediaInfo() - PHONE_TIMES info is not btInfo");
                    return arr_b;
                }
                int v = ((BtInfo)iCarDashBoard$AbsDashBoardInfo0).talkTimes % 86400000 / 3600000;
                int v1 = ((BtInfo)iCarDashBoard$AbsDashBoardInfo0).talkTimes % 3600000 / 60000;
                int v2 = ((BtInfo)iCarDashBoard$AbsDashBoardInfo0).talkTimes % 60000 / 1000;
                Log.w("Ihu12DashBoard", "INFO_TYPE_PHONE_TIMES: " + v + " currHours " + v1 + " currMinutes " + v2 + " currSeconds ");
                return new byte[]{(byte)0x84, 17, 4, ((byte)(v >> 8 & 0xFF)), ((byte)(v & 0xFF)), ((byte)v1), ((byte)v2), 0};
            }
            default: {
                return arr_b;
            }
        }
        return arr_b;
    }

    public static byte[] getNaviGuideBaseInfoDataProtocol(byte b, NaviGuideBaseInfo ihu12DashBoard$NaviGuideBaseInfo0) {
        byte[] arr_b = new byte[8];
        if(ihu12DashBoard$NaviGuideBaseInfo0 == null) {
            Log.w("Ihu12DashBoard", "getNaviGuideInfoDataProtocol() - PHONE_NUMBER info is null");
            return arr_b;
        }
        switch(b) {
            case 7: {
                return new byte[]{(byte)0x84, 18, 1, ((byte)ihu12DashBoard$NaviGuideBaseInfo0.seaLevel.ordinal()), ((byte)ihu12DashBoard$NaviGuideBaseInfo0.gpsSignal.ordinal()), ((byte)(ihu12DashBoard$NaviGuideBaseInfo0.azimuthInfo >> 8 & 0xFF)), ((byte)(ihu12DashBoard$NaviGuideBaseInfo0.azimuthInfo & 0xFF)), ((byte)ihu12DashBoard$NaviGuideBaseInfo0.naviState.value), ((byte)ihu12DashBoard$NaviGuideBaseInfo0.naviIcon_TBT), ((byte)ihu12DashBoard$NaviGuideBaseInfo0.naviIcon_RC), ((byte)ihu12DashBoard$NaviGuideBaseInfo0.naviIcon_WS)};
            }
            case 8: {
                return new byte[]{(byte)0x84, 18, 2, ((byte)ihu12DashBoard$NaviGuideBaseInfo0.compass.ordinal()), 0, 0, 0, 0};
            }
            case 9: {
                if(!(ihu12DashBoard$NaviGuideBaseInfo0 instanceof NaviGuideBaseInfo)) {
                    Log.w("Ihu12DashBoard", "getNaviGuideBaseInfoDataProtocol() - INFO_TYPE_NAVI_GUIDE_CURR_LOAD_NAME info is not NaviGuideBaseInfo");
                    return arr_b;
                }
                if(ihu12DashBoard$NaviGuideBaseInfo0.roadName != null && !"".equals(ihu12DashBoard$NaviGuideBaseInfo0.roadName)) {
                    String s = ihu12DashBoard$NaviGuideBaseInfo0.roadName == null ? "" : ihu12DashBoard$NaviGuideBaseInfo0.roadName + " ";
                    int v = s == null ? 0 : s.getBytes(StandardCharsets.UTF_16BE).length;
                    if(s.length() > 27) {
                        s = s.substring(0, 24) + "...";
                        v = s == null ? 0 : s.getBytes(StandardCharsets.UTF_16BE).length;
                    }
                    arr_b = new byte[v + 5];
                    arr_b[0] = (byte)0x84;
                    arr_b[1] = 18;
                    arr_b[2] = 3;
                    arr_b[3] = (byte)v;
                    arr_b[4] = 0;
                    if(v == 0) {
                        return arr_b;
                    }
                    System.arraycopy(s.getBytes(StandardCharsets.UTF_16BE), 0, arr_b, 5, v);
                    return arr_b;
                }
                Log.w("Ihu12DashBoard", "getNaviGuideInfoDataProtocol() - info.roadName is null");
                return arr_b;
            }
            case 10: {
                if(!(ihu12DashBoard$NaviGuideBaseInfo0 instanceof NaviGuideBaseInfo)) {
                    Log.w("Ihu12DashBoard", "getNaviGuideBaseInfoDataProtocol() - INFO_TYPE_NAVI_GUIDE_CURR_LOAD_NAME info is not NaviGuideBaseInfo");
                    return arr_b;
                }
                if(ihu12DashBoard$NaviGuideBaseInfo0.nextRoadName != null && !"".equals(ihu12DashBoard$NaviGuideBaseInfo0.nextRoadName)) {
                    String s1 = ihu12DashBoard$NaviGuideBaseInfo0.nextRoadName == null ? "" : ihu12DashBoard$NaviGuideBaseInfo0.nextRoadName + " ";
                    int v1 = s1 == null ? 0 : s1.getBytes(StandardCharsets.UTF_16BE).length;
                    if(s1.length() > 27) {
                        s1 = s1.substring(0, 24) + "...";
                        v1 = s1 == null ? 0 : s1.getBytes(StandardCharsets.UTF_16BE).length;
                    }
                    arr_b = new byte[v1 + 5];
                    arr_b[0] = (byte)0x84;
                    arr_b[1] = 18;
                    arr_b[2] = 4;
                    arr_b[3] = (byte)v1;
                    arr_b[4] = 0;
                    if(v1 != 0) {
                        System.arraycopy(s1.getBytes(StandardCharsets.UTF_16BE), 0, arr_b, 5, v1);
                        return arr_b;
                    }
                    return arr_b;
                }
                Log.w("Ihu12DashBoard", "getNaviGuideInfoDataProtocol() - info.nextRoadName is null");
                return arr_b;
            }
            case 11: {
                if(ihu12DashBoard$NaviGuideBaseInfo0.caculationState == null) {
                    Log.w("Ihu12DashBoard", "getNaviGuideInfoDataProtocol() - info.caculationState is null");
                    return arr_b;
                }
                return new byte[]{(byte)0x84, 18, 5, ((byte)ihu12DashBoard$NaviGuideBaseInfo0.caculationState.ordinal()), 0, 0, 0, 0};
            }
            default: {
                return arr_b;
            }
        }
    }

    public static byte[] getNaviGuideUpdateDataProtocol(NaviUpdateData ihu12DashBoard$NaviUpdateData0) {
        if(ihu12DashBoard$NaviUpdateData0 == null) {
            Log.w("Ihu12DashBoard", "getNaviGuideUpdateDataProtocol() - updateData is null");
            return new byte[8];
        }
        return new byte[]{(byte)0x84, 18, 6, ((byte)ihu12DashBoard$NaviUpdateData0.naviDistUnit.ordinal()), ((byte)(ihu12DashBoard$NaviUpdateData0.NaviDist >> 16 & 0xFF)), ((byte)(ihu12DashBoard$NaviUpdateData0.NaviDist >> 8 & 0xFF)), ((byte)(ihu12DashBoard$NaviUpdateData0.NaviDist & 0xFF)), ((byte)(ihu12DashBoard$NaviUpdateData0.NaviDistBar >> 16 & 0xFF)), ((byte)(ihu12DashBoard$NaviUpdateData0.NaviDistBar >> 8 & 0xFF)), ((byte)(ihu12DashBoard$NaviUpdateData0.NaviDistBar & 0xFF)), ((byte)ihu12DashBoard$NaviUpdateData0.naviSumDistUnit.ordinal()), ((byte)ihu12DashBoard$NaviUpdateData0.NaviMinitue), ((byte)(ihu12DashBoard$NaviUpdateData0.NaviHour >> 8 & 0xFF)), ((byte)(ihu12DashBoard$NaviUpdateData0.NaviHour & 0xFF)), ((byte)(ihu12DashBoard$NaviUpdateData0.NaviDestDistInfo >> 24 & 0xFF)), ((byte)(ihu12DashBoard$NaviUpdateData0.NaviDestDistInfo >> 16 & 0xFF)), ((byte)(ihu12DashBoard$NaviUpdateData0.NaviDestDistInfo >> 8 & 0xFF)), ((byte)(ihu12DashBoard$NaviUpdateData0.NaviDestDistInfo & 0xFF))};
    }

    public static boolean isBtInfoChange(AbsDashBoardInfo iCarDashBoard$AbsDashBoardInfo0) {
        boolean z = true;
        if(iCarDashBoard$AbsDashBoardInfo0 == null) {
            Log.w("Ihu12DashBoard", "isBtInfoChange()  BtInfo is null)");
            return false;
        }
        if(((BtInfo)iCarDashBoard$AbsDashBoardInfo0).mBtCallNumber == null) {
            Log.w("Ihu12DashBoard", "isBtInfoChange()  BtInfo.mBtCallNumber is null)");
            return false;
        }
        if(Ihu12DashBoard.mAbsInfo != null && (Ihu12DashBoard.mAbsInfo instanceof BtInfo)) {
            BtInfo iCarDashBoard$BtInfo0 = (BtInfo)Ihu12DashBoard.mAbsInfo;
            if(iCarDashBoard$BtInfo0 != null && iCarDashBoard$BtInfo0.isInfoDiff(((BtInfo)iCarDashBoard$AbsDashBoardInfo0))) {
                iCarDashBoard$BtInfo0.setInfoDiff(((BtInfo)iCarDashBoard$AbsDashBoardInfo0));
            }
            else {
                z = false;
            }
        }
        else {
            Ihu12DashBoard.mAbsInfo = new BtInfo();
        }
        Log.d("Ihu12DashBoard", "isBtInfoChange() isBtInfoChange =" + z);
        return z;
    }

    public static boolean isCurrentSource(int v) {
        return Ihu12DashBoard.mLastSource != v;
    }

    public static boolean isDabProgramInfoChange(AbsDashBoardInfo iCarDashBoard$AbsDashBoardInfo0) {
        boolean z = true;
        if(iCarDashBoard$AbsDashBoardInfo0 == null) {
            Log.w("Ihu12DashBoard", "isDabProgramInfoChange()  DABInfo is null)");
            return false;
        }
        if(Ihu12DashBoard.mAbsInfo != null && (Ihu12DashBoard.mAbsInfo instanceof DABInfo)) {
            DABInfo iCarDashBoard$DABInfo0 = (DABInfo)Ihu12DashBoard.mAbsInfo;
            Log.i("Ihu12DashBoard", "isDabProgramInfoChange: old info:" + iCarDashBoard$DABInfo0 + " new info:" + iCarDashBoard$AbsDashBoardInfo0);
            if(iCarDashBoard$DABInfo0 != null && !TextUtils.equals(iCarDashBoard$DABInfo0.mDabProgramName, ((DABInfo)iCarDashBoard$AbsDashBoardInfo0).mDabProgramName)) {
                Ihu12DashBoard.mAbsInfo = new DABInfo(((DABInfo)iCarDashBoard$AbsDashBoardInfo0).mDabProgramName);
            }
            else {
                z = false;
            }
        }
        else {
            Ihu12DashBoard.mAbsInfo = new DABInfo(((DABInfo)iCarDashBoard$AbsDashBoardInfo0).mDabProgramName);
        }
        Log.d("Ihu12DashBoard", "isDabProgramInfoChange() isDabProgramInfoChange =" + z);
        return z;
    }

    public static boolean isMediaChange(AbsDashBoardInfo iCarDashBoard$AbsDashBoardInfo0) {
        boolean z = true;
        if(((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).title != null && ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).artist != null) {
            if(Ihu12DashBoard.mAbsInfo == null || !(Ihu12DashBoard.mAbsInfo instanceof MediaInfo)) {
                Ihu12DashBoard.mAbsInfo = new MediaInfo(iCarDashBoard$AbsDashBoardInfo0.getDashBoardSource());
                ((MediaInfo)Ihu12DashBoard.mAbsInfo).setInfoDiff(((MediaInfo)iCarDashBoard$AbsDashBoardInfo0));
                if(Ihu12DashBoard.mLastSource == 0) {
                    Log.i("Ihu12DashBoard", "isMediaChange: mLastSource= 0 , update source: " + ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).getDashBoardSource());
                    Ihu12DashBoard.mLastSource = ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).getDashBoardSource();
                }
            }
            else if(Ihu12DashBoard.mLastSource != Ihu12DashBoard.mAbsInfo.getDashBoardSource()) {
                Ihu12DashBoard.mAbsInfo.setDashBoardSource(((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).getDashBoardSource());
                if(Ihu12DashBoard.mLastSource == 0) {
                    Log.i("Ihu12DashBoard", "isMediaChange: mLastSource= 0 , update source: " + ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).getDashBoardSource());
                    Ihu12DashBoard.mLastSource = ((MediaInfo)iCarDashBoard$AbsDashBoardInfo0).getDashBoardSource();
                }
            }
            else {
                MediaInfo iCarDashBoard$MediaInfo0 = (MediaInfo)Ihu12DashBoard.mAbsInfo;
                if(iCarDashBoard$MediaInfo0 != null && iCarDashBoard$MediaInfo0.isInfoDiff(((MediaInfo)iCarDashBoard$AbsDashBoardInfo0))) {
                    iCarDashBoard$MediaInfo0.setInfoDiff(((MediaInfo)iCarDashBoard$AbsDashBoardInfo0));
                }
                else {
                    z = false;
                }
            }
            Log.d("Ihu12DashBoard", "isMediaChange()-3 mLastSource=" + Ihu12DashBoard.mLastSource + " mAbsInfo.getDashBoardSource()=" + Ihu12DashBoard.mAbsInfo.getDashBoardSource() + ", isMediaUpdate =" + z);
            return z;
        }
        Log.w("Ihu12DashBoard", "isMediaChange() USB MediaInfo.title is null or AbsDashBoardInfo is not MediaInfo");
        return false;
    }

    public static void setCurrentSource(int v) {
        Ihu12DashBoard.mLastSource = v;
    }
}

