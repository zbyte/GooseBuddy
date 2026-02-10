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

        public ChargeInfo(int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8, int v9, ChargeMode ihu23Project$ChargeMode0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            this.bookChrgMode = ChargeMode.__UNKNOWN__;
            this.bookStartYear = v;
            this.bookStopYear = v1;
            this.bookStartMon = v2;
            this.bookStartDay = v3;
            this.bookStartHour = v4;
            this.bookStartMin = v5;
            this.bookStopMon = v6;
            this.bookStopDay = v7;
            this.bookStopHour = v8;
            this.bookStopMin = v9;
            this.bookChrgMode = ihu23Project$ChargeMode0;
            this.repeatBookChrgDay1 = z;
            this.repeatBookChrgDay2 = z1;
            this.repeatBookChrgDay3 = z2;
            this.repeatBookChrgDay4 = z3;
            this.repeatBookChrgDay5 = z4;
            this.repeatBookChrgDay6 = z5;
            this.repeatBookChrgDay7 = z6;
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

        private ChargeMode(int v1) {
            this.value = v1;
        }

        public static ChargeMode valueOf(int v) {
            if(v == ChargeMode.BOOKING.value) {
                return ChargeMode.BOOKING;
            }
            return v == ChargeMode.IMMEDIATELY.value ? ChargeMode.IMMEDIATELY : ChargeMode.__UNKNOWN__;
        }
    }

    public static byte[] formartChargeInfoByteArray(ChargeInfo ihu23Project$ChargeInfo0) {
        byte[] arr_b = new byte[20];
        if(ihu23Project$ChargeInfo0 == null) {
            return arr_b;
        }
        arr_b[0] = -104;
        arr_b[1] = 1;
        arr_b[2] = (byte)ihu23Project$ChargeInfo0.bookStartMon;
        arr_b[3] = (byte)ihu23Project$ChargeInfo0.bookStartDay;
        arr_b[4] = (byte)ihu23Project$ChargeInfo0.bookStartHour;
        arr_b[5] = (byte)ihu23Project$ChargeInfo0.bookStartMin;
        arr_b[6] = (byte)ihu23Project$ChargeInfo0.bookStopMon;
        arr_b[7] = (byte)ihu23Project$ChargeInfo0.bookStopDay;
        arr_b[8] = (byte)ihu23Project$ChargeInfo0.bookStopHour;
        arr_b[9] = (byte)ihu23Project$ChargeInfo0.bookStopMin;
        arr_b[10] = (byte)ihu23Project$ChargeInfo0.bookChrgMode.value;
        arr_b[11] = (byte)ihu23Project$ChargeInfo0.repeatBookChrgDay1;
        arr_b[12] = (byte)ihu23Project$ChargeInfo0.repeatBookChrgDay2;
        arr_b[13] = (byte)ihu23Project$ChargeInfo0.repeatBookChrgDay3;
        arr_b[14] = (byte)ihu23Project$ChargeInfo0.repeatBookChrgDay4;
        arr_b[15] = (byte)ihu23Project$ChargeInfo0.repeatBookChrgDay5;
        arr_b[16] = (byte)ihu23Project$ChargeInfo0.repeatBookChrgDay6;
        arr_b[17] = (byte)ihu23Project$ChargeInfo0.repeatBookChrgDay7;
        if(ihu23Project$ChargeInfo0.bookStartYear >= 2000) {
            ihu23Project$ChargeInfo0.bookStartYear -= 2000;
        }
        if(ihu23Project$ChargeInfo0.bookStopYear >= 2000) {
            ihu23Project$ChargeInfo0.bookStopYear -= 2000;
        }
        arr_b[18] = (byte)ihu23Project$ChargeInfo0.bookStartYear;
        arr_b[19] = (byte)ihu23Project$ChargeInfo0.bookStopYear;
        return arr_b;
    }
}

