package com.yftech.car.navigation;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class CarNavigationManeuver implements Parcelable {
    public static enum LaneSign {
        UNKNOWN,
        CROSS2_LEFT_STRAIGHT,
        CROSS2_LEFT_STRAIGHT_GRAY,
        CROSS2_RIGHT_STRAIGHT,
        CROSS2_RIGHT_STRAIGHT_GRAY,
        CROSS2_TURN_LEFT,
        CROSS2_TURN_RIGHT,
        CROSS3_GRAY,
        CROSS3_STRAIGHT,
        CROSS3_TURN_LEFT,
        CROSS3_TURN_RIGHT,
        AROUND_AND_LEFT,
        AROUND_AND_LEFT_GRAY,
        AROUND_AND_RIGHT,
        AROUND_AND_RIGHT_GRAY,
        AROUND_AND_STRAIGHT,
        AROUND_AND_STRAIGHT_GRAY,
        AROUND_LEFT_RIGHT,
        AROUND_LEFT_RIGHT_GRAY,
        AROUND_LEFT_RIGHT_STRAIGHT,
        AROUND_LEFT_RIGHT_STRAIGHT_GRAY,
        AROUND_LEFT_STRAIGHT,
        AROUND_LEFT_STRAIGHT_GRAY,
        AROUND_RIGHT_STRAIGHT,
        AROUND_RIGHT_STRAIGHT_GRAY,
        LEFT_AND_AROUND,
        LEFT_AND_RIGHT,
        LEFT_AND_RIGHT_GRAY,
        LEFT_AROUND_RIGHT,
        LEFT_AROUND_RIGHT_STRAIGHT,
        LEFT_AROUND_STRAIGHT,
        RIGHT_AND_AROUND,
        RIGHT_AND_LEFT,
        RIGHT_AROUND_LEFT,
        RIGHT_AROUND_LEFT_STRAIGHT,
        RIGHT_AROUND_STRAIGHT,
        STRAIGHT,
        STRAIGHT_AND_AROUND,
        STRAIGHT_AROUND_LEFT_RIGHT,
        STRAIGHT_GRAY,
        STRAIGHT_LEFT_AROUND,
        STRAIGHT_RIGHT_AROUND,
        TURN_AROUND_LEFT,
        TURN_AROUND_LEFT_GRAY,
        TURN_LEFT_90,
        TURN_LEFT_90_GRAY,
        TURN_RIGHT_90,
        TURN_RIGHT_90_GRAY;

    }

    public static enum TurnInfo {
        UNKNOWN,
        TURN_BACK,
        TURN_FRONT,
        TURN_RIGHT_FRONT,
        TURN_RIGHT,
        TURN_RIGHT_BACK,
        TURN_LEFT_BACK,
        TURN_LEFT,
        TURN_LEFT_FRONT,
        TURN_RING,
        TURN_LEFT_SIDE,
        TURN_RIGHT_SIDE,
        TURN_LEFT_SIDE_MAIN,
        TURN_BRANCH_LEFT_STRAIGHT,
        TURN_RIGHT_SIDE_MAIN,
        TURN_BRANCH_RIGHT_STRAIGHT,
        TURN_BRANCH_CENTER,
        TURN_LEFT_SIDE_IC,
        TURN_RIGHT_SIDE_IC,
        TURN_BRANCH_LEFT,
        TURN_BRANCH_RIGHT,
        TURN_DEST,
        TURN_VIA_1,
        TURN_INFERRY,
        TURN_TOLLGATE,
        TURN_LF_2BRANCH_LEFT,
        TURN_LF_2BRANCH_RIGHT,
        TURN_RF_2BRANCH_LEFT,
        TURN_RF_2BRANCH_RIGHT,
        TURN_LF_3BRANCH_LEFT,
        TURN_LF_3BRANCH_CENTER,
        TURN_LF_3BRANCH_RIGHT,
        TURN_RF_3BRANCH_LEFT,
        TURN_RF_3BRANCH_CENTER,
        TURN_RF_3BRANCH_RIGHT,
        TURN_RING_FRONT,
        TURN_RING_LEFT,
        TURN_RING_LEFTBACK,
        TURN_RING_LEFTFRONT,
        TURN_RING_RIGHT,
        TURN_RING_RIGHTBACK,
        TURN_RING_RIGHTFRONT,
        TURN_RING_TURNBACK,
        TURN_TUNNEL,
        TURN_BRANCH_FOUR_MOST_LEFT,
        TURN_BRANCH_FOUR_LEFT_SECOND,
        TURN_BRANCH_FOUR_MOST_RIGHT,
        TURN_BRANCH_FOUR_RIGHT_SECOND,
        TURN_LEFT_BACK_LEFT_SIDE,
        TURN_LEFT_BACK_RIGHT_SIDE,
        TURN_RIGHT_BACK_LEFT_SIDE,
        TURN_RIGHT_BACK_RIGHT_SIDE;

    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CarNavigationManeuver createFromParcel(Parcel in) {
            return new CarNavigationManeuver(in);
        }

        public CarNavigationManeuver[] newArray(int size) {
            return new CarNavigationManeuver[size];
        }
    };
    private String mCurRoadName;
    private String mDestinationName;
    private int mDistance;
    private int mLaneCount;
    private LaneSign[] mLaneSignArray;
    private double mLatitude;
    private double mLongitude;
    private String mNextRoadIcon;
    private String mNextRoadName;
    private int mRemainDistance;
    private int mRemainTime;
    private TurnInfo mTurnInfo;
    private int mViaRemainDistance;
    private int mViaRemainTime;

    public CarNavigationManeuver() {
        this.mTurnInfo = TurnInfo.UNKNOWN;
    }

    protected CarNavigationManeuver(Parcel in) {
        this.mCurRoadName = in.readString();
        this.mNextRoadName = in.readString();
        this.mDistance = in.readInt();
        this.mLongitude = in.readDouble();
        this.mLatitude = in.readDouble();
        this.mLaneCount = in.readInt();
        int v = in.readInt();
        if(v == -1) {
            this.mLaneSignArray = null;
        }
        else {
            this.mLaneSignArray = new LaneSign[v];
            for(int i = 0; i < v; ++i) {
                LaneSign[] arr_carNavigationManeuver$LaneSign = this.mLaneSignArray;
                LaneSign[] arr_carNavigationManeuver$LaneSign1 = LaneSign.values();
                arr_carNavigationManeuver$LaneSign[i] = arr_carNavigationManeuver$LaneSign1[in.readInt()];
            }
        }
        TurnInfo[] arr_carNavigationManeuver$TurnInfo = TurnInfo.values();
        this.mTurnInfo = arr_carNavigationManeuver$TurnInfo[in.readInt()];
        this.mNextRoadIcon = in.readString();
        this.mRemainDistance = in.readInt();
        this.mRemainTime = in.readInt();
        this.mViaRemainDistance = in.readInt();
        this.mViaRemainTime = in.readInt();
        this.mDestinationName = in.readString();
    }

    public CarNavigationManeuver(String curRoadName, String nextRoadName, int distance, double longitude, double latitude, int laneCount, LaneSign[] laneSignArray, TurnInfo rgDirection) {
        this.mCurRoadName = curRoadName;
        this.mNextRoadName = nextRoadName;
        this.mDistance = distance;
        this.mLongitude = longitude;
        this.mLatitude = latitude;
        this.mLaneCount = laneCount;
        this.mLaneSignArray = laneSignArray;
        this.mTurnInfo = rgDirection;
    }

    public CarNavigationManeuver(String mCurRoadName, String mNextRoadName, int mDistance, double mLongitude, double mLatitude, int mLaneCount, LaneSign[] mLaneSignArray, TurnInfo mTurnInfo, String mNextRoadIcon, int mRemainDistance, int mRemainTime, int mViaRemainDistance, int mViaRemainTime) {
        this.mCurRoadName = mCurRoadName;
        this.mNextRoadName = mNextRoadName;
        this.mDistance = mDistance;
        this.mLongitude = mLongitude;
        this.mLatitude = mLatitude;
        this.mLaneCount = mLaneCount;
        this.mLaneSignArray = mLaneSignArray;
        this.mTurnInfo = mTurnInfo;
        this.mNextRoadIcon = mNextRoadIcon;
        this.mRemainDistance = mRemainDistance;
        this.mRemainTime = mRemainTime;
        this.mViaRemainDistance = mViaRemainDistance;
        this.mViaRemainTime = mViaRemainTime;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCurrentRoadName() {
        return this.mCurRoadName;
    }

    public String getDestinationName() {
        return this.mDestinationName;
    }

    public int getDistance() {
        return this.mDistance;
    }

    public int getLaneCount() {
        return this.mLaneCount;
    }

    public LaneSign[] getLaneSignArray() {
        return this.mLaneSignArray;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public String getNextRoadIcon() {
        return this.mNextRoadIcon;
    }

    public String getNextRoadName() {
        return this.mNextRoadName;
    }

    public int getRemainDistance() {
        return this.mRemainDistance;
    }

    public int getRemainTime() {
        return this.mRemainTime;
    }

    public TurnInfo getTurnInfo() {
        return this.mTurnInfo;
    }

    public int getViaRemainDistance() {
        return this.mViaRemainDistance;
    }

    public int getViaRemainTime() {
        return this.mViaRemainTime;
    }

    public CarNavigationManeuver setCurrentRoadName(String roadName) {
        this.mCurRoadName = roadName;
        return this;
    }

    public void setDestinationName(String mDestinationName) {
        this.mDestinationName = mDestinationName;
    }

    public CarNavigationManeuver setDistance(int distance) {
        this.mDistance = distance;
        return this;
    }

    public CarNavigationManeuver setLaneCount(int laneCount) {
        this.mLaneCount = laneCount;
        return this;
    }

    public CarNavigationManeuver setLaneSignArray(LaneSign[] laneSignArray) {
        this.mLaneSignArray = laneSignArray;
        return this;
    }

    public CarNavigationManeuver setLatitude(double latitude) {
        this.mLatitude = latitude;
        return this;
    }

    public CarNavigationManeuver setLongitude(double longitude) {
        this.mLongitude = longitude;
        return this;
    }

    public void setNextRoadIcon(String mNextRoadIcon) {
        this.mNextRoadIcon = mNextRoadIcon;
    }

    public CarNavigationManeuver setNextRoadName(String roadName) {
        this.mNextRoadName = roadName;
        return this;
    }

    public void setRemainDistance(int remainDistance) {
        this.mRemainDistance = remainDistance;
    }

    public void setRemainTime(int remainTime) {
        this.mRemainTime = remainTime;
    }

    public CarNavigationManeuver setTurnInfo(TurnInfo turnInfo) {
        this.mTurnInfo = turnInfo;
        return this;
    }

    public void setViaRemainDistance(int viaRemainDistance) {
        this.mViaRemainDistance = viaRemainDistance;
    }

    public void setViaRemainTime(int viaRemainTime) {
        this.mViaRemainTime = viaRemainTime;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Maneuver:[").append("currentRoadName=").append(this.mCurRoadName).append(", nextRoadName=").append(this.mNextRoadName).append(", distance=").append(this.mDistance).append(", longitude=").append(this.mDistance).append(", latitude=").append(this.mLatitude).append(", laneCount=").append(this.mLaneCount).append(", turnInfo=").append(this.mTurnInfo).append(", nextRoadIcon=").append(this.mNextRoadIcon).append(", remainDistance=").append(this.mRemainDistance).append(", remainTime=").append(this.mRemainTime).append(", viaRemainDistance=").append(this.mViaRemainDistance).append(", viaRemainTime=").append(this.mViaRemainTime).append(", destinationName=").append(this.mDestinationName);
        stringBuilder.append(", laneSignArray=");
        if(this.mLaneSignArray == null) {
            stringBuilder.append("null");
            return stringBuilder.toString();
        }
        stringBuilder.append("[");
        for(int i = 0; i < this.mLaneSignArray.length; ++i) {
            if(i != 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(this.mLaneSignArray[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mCurRoadName);
        dest.writeString(this.mNextRoadName);
        dest.writeInt(this.mDistance);
        dest.writeDouble(this.mLongitude);
        dest.writeDouble(this.mLatitude);
        dest.writeInt(this.mLaneCount);
        if(this.mLaneSignArray == null) {
            dest.writeInt(-1);
        }
        else {
            dest.writeInt(this.mLaneSignArray.length);
            LaneSign[] arr_carNavigationManeuver$LaneSign = this.mLaneSignArray;
            for(int v1 = 0; v1 < arr_carNavigationManeuver$LaneSign.length; ++v1) {
                dest.writeInt(arr_carNavigationManeuver$LaneSign[v1].ordinal());
            }
        }
        dest.writeInt(this.mTurnInfo.ordinal());
        dest.writeString(this.mNextRoadIcon);
        dest.writeInt(this.mRemainDistance);
        dest.writeInt(this.mRemainTime);
        dest.writeInt(this.mViaRemainDistance);
        dest.writeInt(this.mViaRemainTime);
        dest.writeString(this.mDestinationName);
    }
}

