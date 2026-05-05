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

        private DisplayDtc(boolean voltageHigh, boolean voltageLow, boolean notReceievdBacklight, boolean notSetBacklightOnOffModule, boolean tftFailure, boolean videoSignalConnectFailure, boolean touchPanelFailure, boolean IICCommunicationFailure, boolean temperatureExcption, boolean backLightFault) {
            this.voltageHigh = voltageHigh;
            this.voltageLow = voltageLow;
            this.notReceievdBacklight = notReceievdBacklight;
            this.notSetBacklightOnOffModule = notSetBacklightOnOffModule;
            this.tftFailure = tftFailure;
            this.videoSignalConnectFailure = videoSignalConnectFailure;
            this.touchPanelFailure = touchPanelFailure;
            this.IICCommunicationFailure = IICCommunicationFailure;
            this.temperatureExcption = temperatureExcption;
            this.backLightFault = backLightFault;
        }

        @Override
        public String toString() {
            return "DisplayDtc{voltageHigh=" + this.voltageHigh + ", voltageLow=" + this.voltageLow + ", notReceievdBacklight=" + this.notReceievdBacklight + ", notSetBacklightOnOffModule=" + this.notSetBacklightOnOffModule + ", tftFailure=" + this.tftFailure + ", videoSignalConnectFailure=" + this.videoSignalConnectFailure + ", touchPanelFailure=" + this.touchPanelFailure + ", IICCommunicationFailure=" + this.IICCommunicationFailure + ", temperatureExcption=" + this.temperatureExcption + ", backLightFault=" + this.backLightFault + '}';
        }

        public static DisplayDtc valueOf(int value) {
            boolean voltageHigh = (value & 1) == 1;
            boolean voltageLow = (value >> 1 & 1) == 1;
            boolean notReceievdBacklight = (value >> 2 & 1) == 1;
            boolean notSetBacklightOnOffModule = (value >> 3 & 1) == 1;
            boolean tftFailure = (value >> 4 & 1) == 1;
            boolean videoSignalConnectFailure = (value >> 5 & 1) == 1;
            boolean touchPanelFailure = (value >> 6 & 1) == 1;
            boolean IICCommunicationFailure = (value >> 7 & 1) == 1;
            if((value >> 8 & 1) == 1) {
                return (value >> 9 & 1) == 1 ? new DisplayDtc(voltageHigh, voltageLow, notReceievdBacklight, notSetBacklightOnOffModule, tftFailure, videoSignalConnectFailure, touchPanelFailure, IICCommunicationFailure, true, true) : new DisplayDtc(voltageHigh, voltageLow, notReceievdBacklight, notSetBacklightOnOffModule, tftFailure, videoSignalConnectFailure, touchPanelFailure, IICCommunicationFailure, true, false);
            }
            return (value >> 9 & 1) == 1 ? new DisplayDtc(voltageHigh, voltageLow, notReceievdBacklight, notSetBacklightOnOffModule, tftFailure, videoSignalConnectFailure, touchPanelFailure, IICCommunicationFailure, false, true) : new DisplayDtc(voltageHigh, voltageLow, notReceievdBacklight, notSetBacklightOnOffModule, tftFailure, videoSignalConnectFailure, touchPanelFailure, IICCommunicationFailure, false, false);
        }
    }

}

