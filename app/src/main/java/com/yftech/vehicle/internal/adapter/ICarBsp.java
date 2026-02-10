package com.yftech.vehicle.internal.adapter;

public interface ICarBsp extends IBaseCmd {
    public interface BspInfoQueryCmd {
        public static final byte DISPLAY_CREATE_DATE = 3;
        public static final byte DISPLAY_DTC = 1;
        public static final byte DISPLAY_LIGHT_BAR_ENABLE = 10;
        public static final byte DISPLAY_LIGHT_BAR_LEVEL = 9;
        public static final byte DISPLAY_PN = 8;
        public static final byte DISPLAY_SN = 2;
        public static final byte DISPLAY_VER_HARDWARE = 5;
        public static final byte DISPLAY_VER_SOFTWARE = 4;
        public static final byte DISPLAY_VER_SUPPLIER_HARDWARE = 7;
        public static final byte DISPLAY_VER_SUPPLIER_SOFTWARE = 6;

    }

    public static class DisplayDtc {
        public boolean IICCommunicationFailure;
        public boolean backLightFault;
        public boolean notReceievdBacklight;
        public boolean notSetBacklightOnOffModule;
        public boolean temperatureExcption;
        public boolean tftFailure;
        public boolean touchPanelFailure;
        public boolean videoSignalConnectFailure;
        public boolean voltageHigh;
        public boolean voltageLow;

        private DisplayDtc(boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
            this.voltageHigh = z;
            this.voltageLow = z1;
            this.notReceievdBacklight = z2;
            this.notSetBacklightOnOffModule = z3;
            this.tftFailure = z4;
            this.videoSignalConnectFailure = z5;
            this.touchPanelFailure = z6;
            this.IICCommunicationFailure = z7;
            this.temperatureExcption = z8;
            this.backLightFault = z9;
        }

        @Override
        public String toString() {
            return "DisplayDtc{voltageHigh=" + this.voltageHigh + ", voltageLow=" + this.voltageLow + ", notReceievdBacklight=" + this.notReceievdBacklight + ", notSetBacklightOnOffModule=" + this.notSetBacklightOnOffModule + ", tftFailure=" + this.tftFailure + ", videoSignalConnectFailure=" + this.videoSignalConnectFailure + ", touchPanelFailure=" + this.touchPanelFailure + ", IICCommunicationFailure=" + this.IICCommunicationFailure + ", temperatureExcption=" + this.temperatureExcption + ", backLightFault=" + this.backLightFault + '}';
        }

        public static DisplayDtc valueOf(int v) {
            boolean z = (v & 1) == 1;
            boolean z1 = (v >> 1 & 1) == 1;
            boolean z2 = (v >> 2 & 1) == 1;
            boolean z3 = (v >> 3 & 1) == 1;
            boolean z4 = (v >> 4 & 1) == 1;
            boolean z5 = (v >> 5 & 1) == 1;
            boolean z6 = (v >> 6 & 1) == 1;
            boolean z7 = (v >> 7 & 1) == 1;
            boolean z8 = (v >> 8 & 1) == 1;
            return (v >> 9 & 1) == 1 ? new DisplayDtc(z, z1, z2, z3, z4, z5, z6, z7, z8, true) : new DisplayDtc(z, z1, z2, z3, z4, z5, z6, z7, z8, false);
        }
    }

}

