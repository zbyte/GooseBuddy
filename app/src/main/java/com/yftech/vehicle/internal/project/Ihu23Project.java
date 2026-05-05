package com.yftech.vehicle.internal.project;

public class Ihu23Project {
    public static class ChargeInfo {
        public ChargeMode bookChrgMode;
        public int bookChrgStartRemainingDay;
        public int bookChrgStartRemainingHour;
        public int bookChrgStartRemainingMin;
        public int bookStartDay;
        public int bookStartHour;
        public int bookStartMin;
        public int bookStartMon;
        public int bookStartYear;
        public int bookStopDay;
        public int bookStopHour;
        public int bookStopMin;
        public int bookStopMon;
        public int bookStopYear;
        public boolean repeatBookChrgDay1;
        public boolean repeatBookChrgDay2;
        public boolean repeatBookChrgDay3;
        public boolean repeatBookChrgDay4;
        public boolean repeatBookChrgDay5;
        public boolean repeatBookChrgDay6;
        public boolean repeatBookChrgDay7;

        public ChargeInfo() {
            this.bookChrgMode = ChargeMode.__UNKNOWN__;
        }

        public ChargeInfo(int bookStartYear, int bookStopYear, int bookStartMon, int bookStartDay, int bookStartHour, int bookStartMin, int bookStopMon, int bookStopDay, int bookStopHour, int bookStopMin, ChargeMode bookChrgMode, boolean repeatBookChrgDay1, boolean repeatBookChrgDay2, boolean repeatBookChrgDay3, boolean repeatBookChrgDay4, boolean repeatBookChrgDay5, boolean repeatBookChrgDay6, boolean repeatBookChrgDay7) {
            this.bookChrgMode = ChargeMode.__UNKNOWN__;
            this.bookStartYear = bookStartYear;
            this.bookStopYear = bookStopYear;
            this.bookStartMon = bookStartMon;
            this.bookStartDay = bookStartDay;
            this.bookStartHour = bookStartHour;
            this.bookStartMin = bookStartMin;
            this.bookStopMon = bookStopMon;
            this.bookStopDay = bookStopDay;
            this.bookStopHour = bookStopHour;
            this.bookStopMin = bookStopMin;
            this.bookChrgMode = bookChrgMode;
            this.repeatBookChrgDay1 = repeatBookChrgDay1;
            this.repeatBookChrgDay2 = repeatBookChrgDay2;
            this.repeatBookChrgDay3 = repeatBookChrgDay3;
            this.repeatBookChrgDay4 = repeatBookChrgDay4;
            this.repeatBookChrgDay5 = repeatBookChrgDay5;
            this.repeatBookChrgDay6 = repeatBookChrgDay6;
            this.repeatBookChrgDay7 = repeatBookChrgDay7;
        }

        @Override
        public String toString() {
            return "ChargeInfo{bookChrgStartRemainingDay=" + this.bookChrgStartRemainingDay + ", bookChrgStartRemainingHour=" + this.bookChrgStartRemainingHour + ", bookChrgStartRemainingMin=" + this.bookChrgStartRemainingMin + ", bookStartYear=" + this.bookStartYear + ", bookStopYear=" + this.bookStopYear + ", bookStartMon=" + this.bookStartMon + ", bookStartDay=" + this.bookStartDay + ", bookStartHour=" + this.bookStartHour + ", bookStartMin=" + this.bookStartMin + ", bookStopMon=" + this.bookStopMon + ", bookStopDay=" + this.bookStopDay + ", bookStopHour=" + this.bookStopHour + ", bookStopMin=" + this.bookStopMin + ", bookChrgMode=" + this.bookChrgMode + ", repeatBookChrgDay1=" + this.repeatBookChrgDay1 + ", repeatBookChrgDay2=" + this.repeatBookChrgDay2 + ", repeatBookChrgDay3=" + this.repeatBookChrgDay3 + ", repeatBookChrgDay4=" + this.repeatBookChrgDay4 + ", repeatBookChrgDay5=" + this.repeatBookChrgDay5 + ", repeatBookChrgDay6=" + this.repeatBookChrgDay6 + ", repeatBookChrgDay7=" + this.repeatBookChrgDay7 + '}';
        }
    }

    public static enum ChargeMode {
        BOOKING(1),
        IMMEDIATELY(0),
        __UNKNOWN__(-1);

        public final int value;

        private ChargeMode(int value) {
            this.value = value;
        }

        public static ChargeMode valueOf(int value) {
            if(value == ChargeMode.BOOKING.value) {
                return ChargeMode.BOOKING;
            }
            return value == ChargeMode.IMMEDIATELY.value ? ChargeMode.IMMEDIATELY : ChargeMode.__UNKNOWN__;
        }
    }

    public static byte[] formartChargeInfoByteArray(ChargeInfo info) {
        int v = 1;
        byte[] byteArr = new byte[20];
        if(info == null) {
            return byteArr;
        }
        byteArr[0] = -104;
        byteArr[1] = 1;
        byteArr[2] = (byte)info.bookStartMon;
        byteArr[3] = (byte)info.bookStartDay;
        byteArr[4] = (byte)info.bookStartHour;
        byteArr[5] = (byte)info.bookStartMin;
        byteArr[6] = (byte)info.bookStopMon;
        byteArr[7] = (byte)info.bookStopDay;
        byteArr[8] = (byte)info.bookStopHour;
        byteArr[9] = (byte)info.bookStopMin;
        byteArr[10] = (byte)info.bookChrgMode.value;
        byteArr[11] = (byte)(info.repeatBookChrgDay1 ? 1 : 0);
        byteArr[12] = (byte)(info.repeatBookChrgDay2 ? 1 : 0);
        byteArr[13] = (byte)(info.repeatBookChrgDay3 ? 1 : 0);
        byteArr[14] = (byte)(info.repeatBookChrgDay4 ? 1 : 0);
        byteArr[15] = (byte)(info.repeatBookChrgDay5 ? 1 : 0);
        byteArr[16] = (byte)(info.repeatBookChrgDay6 ? 1 : 0);
        if(!info.repeatBookChrgDay7) {
            v = 0;
        }
        byteArr[17] = (byte)v;
        if(info.bookStartYear >= 2000) {
            info.bookStartYear += -2000;
        }
        if(info.bookStopYear >= 2000) {
            info.bookStopYear += -2000;
        }
        byteArr[18] = (byte)info.bookStartYear;
        byteArr[19] = (byte)info.bookStopYear;
        return byteArr;
    }
}

