package com.yftech.car.utils;

public class PlatformProjectDescribe {
    public static enum Platform {
        UNKNOWN,
        ATC8015,
        XINCHI,
        QTI8155,
        QTI8295;

    }

    public static enum Project {
        UNKNOWN,
        CBIHU12,
        CA1105,
        CAR015,
        CAR011,
        PT025,
        CBIHU12_C1,
        CBIHU19,
        CBIHU23,
        CBIHU18,
        CBIHU17,
        CBIHU21,
        CBIHU17_B1,
        CDC003_A1,
        CDC003_B1,
        CDC006,
        CDC010_A1,
        CBIHU23_C1,
        CDC005_A1,
        CDC007_A1,
        CDC010_B1,
        CDC003_A5,
        CDC003_B2,
        CDC003_C1,
        CB_IHU12_C7,
        CDC006_B1,
        CAR049;

    }

    public static enum VehicleType {
        UNKNOWN,
        CBIHU12_A58,
        CBIHU12_A88,
        CBIHU12_A79,
        CA1105_GMMC5A45,
        CBIHU19_G06,
        CBIHU12_A58_G,
        CDC003_A1_G08,
        CDC010_A1_G05,
        CDC005_A1_RT6,
        CDC007_A1_ES601,
        CBIHU12_T58_X,
        CDC003_C1_G08_A,
        CBIHU12C7_T79_G;

    }

    private static final String PLATFORM_NAME_ATC8015 = "ac8x";
    private static final String PLATFORM_NAME_QTI8155 = "msmnile";
    private static final String PLATFORM_NAME_QTI8295 = "msmnile8295";
    private static final String PLATFORM_NAME_XINCHI = "x9";
    private static final String PROJECT_NAME_CA1105 = "CA1105";
    private static final String PROJECT_NAME_CAR011 = "car011";
    private static final String PROJECT_NAME_CAR015 = "qti";
    private static final String PROJECT_NAME_CAR049 = "CAR049";
    private static final String PROJECT_NAME_CBIHU12 = "CBIHU12";
    private static final String PROJECT_NAME_CBIHU12_C1 = "CB_IHU12_C1";
    private static final String PROJECT_NAME_CBIHU17 = "CB_IHU17";
    private static final String PROJECT_NAME_CBIHU17_B1 = "CB_IHU17-B1";
    private static final String PROJECT_NAME_CBIHU18 = "CB_IHU18";
    private static final String PROJECT_NAME_CBIHU19 = "CB_IHU19";
    private static final String PROJECT_NAME_CBIHU21 = "CB_IHU21";
    private static final String PROJECT_NAME_CBIHU23 = "CB_IHU23";
    private static final String PROJECT_NAME_CBIHU23C1 = "CB_IHU23_C1";
    private static final String PROJECT_NAME_CB_IHU12_C7 = "CB_IHU12_C7";
    private static final String PROJECT_NAME_CDC003_A1 = "CDC003_A1";
    private static final String PROJECT_NAME_CDC003_A5 = "CDC003_A5";
    private static final String PROJECT_NAME_CDC003_B1 = "CDC003_B1";
    private static final String PROJECT_NAME_CDC003_B2 = "CDC003_B2";
    private static final String PROJECT_NAME_CDC003_C1 = "CDC003_C1";
    private static final String PROJECT_NAME_CDC005_A1 = "CDC005-A1";
    private static final String PROJECT_NAME_CDC006 = "CDC006";
    private static final String PROJECT_NAME_CDC006_B1 = "CDC006_B1";
    private static final String PROJECT_NAME_CDC007_A1 = "CDC007_A1";
    private static final String PROJECT_NAME_CDC010_A1 = "CDC010_A1";
    private static final String PROJECT_NAME_CDC010_B1 = "CDC010_B1";
    private static final String PROJECT_NAME_PT025 = "pt025";
    private static final String VEHICLE_TYPE_CA1105_GMMC5A45 = "GMMC 5A45";
    private static final String VEHICLE_TYPE_CBIHU12C7_T79_G = "T79_G";
    private static final String VEHICLE_TYPE_CBIHU12_A58 = "A58";
    private static final String VEHICLE_TYPE_CBIHU12_A58_G = "A58_G";
    private static final String VEHICLE_TYPE_CBIHU12_A79 = "A79";
    private static final String VEHICLE_TYPE_CBIHU12_A88 = "A88";
    private static final String VEHICLE_TYPE_CBIHU12_T58_X = "T58_X";
    private static final String VEHICLE_TYPE_CBIHU19_G06 = "G06";
    private static final String VEHICLE_TYPE_CDC003_A1_G08 = "G08";
    private static final String VEHICLE_TYPE_CDC003_C1_G08_A = "G08_A";
    private static final String VEHICLE_TYPE_CDC005_A1_RT6 = "RT6";
    private static final String VEHICLE_TYPE_CDC007_A1_ES601 = "ES601";
    private static final String VEHICLE_TYPE_CDC010_A1_G05 = "G05";
    private static final String VEHICLE_TYPE_PT025 = "yfve";

    public static Platform getPlatform() {
        if("msmnile8295".equals(SystemPropertiesHelper.get("ro.yftech.product.platform", null))) {
            return Platform.QTI8295;
        }
        String s = SystemPropertiesHelper.get("ro.board.platform", null);
        if("ac8x".equals(s)) {
            return Platform.ATC8015;
        }
        if("x9".equals(s)) {
            return Platform.XINCHI;
        }
        return "msmnile".equals(s) ? Platform.QTI8155 : Platform.UNKNOWN;
    }

    public static Project getProject() {
        if("CAR049".equals(SystemPropertiesHelper.get("ro.yf.build.product", null))) {
            return Project.CAR049;
        }
        String s = SystemPropertiesHelper.get("ro.build.product", null);
        if("CBIHU12".equals(s)) {
            return Project.CBIHU12;
        }
        if("CA1105".equals(s)) {
            return Project.CA1105;
        }
        if("qti".equals(s)) {
            return Project.CAR015;
        }
        if("car011".equals(s)) {
            return Project.CAR011;
        }
        if("pt025".equals(s)) {
            return Project.PT025;
        }
        if("CB_IHU12_C1".equals(s)) {
            return Project.CBIHU12_C1;
        }
        if("CB_IHU19".equals(s)) {
            return Project.CBIHU19;
        }
        if("CB_IHU23".equals(s)) {
            return Project.CBIHU23;
        }
        if("CB_IHU18".equals(s)) {
            return Project.CBIHU18;
        }
        if("CB_IHU17".equals(s)) {
            return Project.CBIHU17;
        }
        if("CB_IHU21".equals(s)) {
            return Project.CBIHU21;
        }
        if("CB_IHU17-B1".equals(s)) {
            return Project.CBIHU17_B1;
        }
        if("CDC003_A1".equals(s)) {
            return Project.CDC003_A1;
        }
        if("CDC003_B1".equals(s)) {
            return Project.CDC003_B1;
        }
        if("CDC006".equals(s)) {
            return Project.CDC006;
        }
        if("CDC010_A1".equals(s)) {
            return Project.CDC010_A1;
        }
        if("CB_IHU23_C1".equals(s)) {
            return Project.CBIHU23_C1;
        }
        if("CDC005-A1".equals(s)) {
            return Project.CDC005_A1;
        }
        if("CDC007_A1".equals(s)) {
            return Project.CDC007_A1;
        }
        if("CDC010_B1".equals(s)) {
            return Project.CDC010_B1;
        }
        if("CDC003_A5".equals(s)) {
            return Project.CDC003_A5;
        }
        if("CDC003_B2".equals(s)) {
            return Project.CDC003_B2;
        }
        if("CDC003_C1".equals(s)) {
            return Project.CDC003_C1;
        }
        if("CB_IHU12_C7".equals(s)) {
            return Project.CB_IHU12_C7;
        }
        return "CDC006_B1".equals(s) ? Project.CDC006_B1 : Project.UNKNOWN;
    }

    public static VehicleType getVehicleType() {
        SystemPropertiesHelper.get("ro.yf.product.brand", null);
        String s = SystemPropertiesHelper.get("ro.product.vendor.brand", null);
        if("A58".equals(s)) {
            return VehicleType.CBIHU12_A58;
        }
        if("A88".equals(s)) {
            return VehicleType.CBIHU12_A88;
        }
        if("A79".equals(s)) {
            return VehicleType.CBIHU12_A79;
        }
        if("GMMC 5A45".equals(s)) {
            return VehicleType.CA1105_GMMC5A45;
        }
        if("G06".equals(s)) {
            return VehicleType.CBIHU19_G06;
        }
        if("A58_G".equals(s)) {
            return VehicleType.CBIHU12_A58_G;
        }
        if("G08".equals(s)) {
            return VehicleType.CDC003_A1_G08;
        }
        if("G05".equals(s)) {
            return VehicleType.CDC010_A1_G05;
        }
        if("RT6".equals(s)) {
            return VehicleType.CDC005_A1_RT6;
        }
        if("ES601".equals(s)) {
            return VehicleType.CDC007_A1_ES601;
        }
        if("T58_X".equals(s)) {
            return VehicleType.CBIHU12_T58_X;
        }
        if("G08_A".equals(s)) {
            return VehicleType.CDC003_C1_G08_A;
        }
        return "T79_G".equals(s) ? VehicleType.CBIHU12C7_T79_G : VehicleType.UNKNOWN;
    }

    public static boolean isATC8015Platform() {
        Platform platformProjectDescribe$Platform0 = PlatformProjectDescribe.getPlatform();
        return Platform.ATC8015 == platformProjectDescribe$Platform0;
    }

    public static boolean isCA1105GMMC5A445Vehicle() {
        VehicleType platformProjectDescribe$VehicleType0 = PlatformProjectDescribe.getVehicleType();
        return VehicleType.CA1105_GMMC5A45 == platformProjectDescribe$VehicleType0;
    }

    public static boolean isCA1105Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CA1105 == platformProjectDescribe$Project0;
    }

    public static boolean isCBIHU12A58GVehicle() {
        VehicleType platformProjectDescribe$VehicleType0 = PlatformProjectDescribe.getVehicleType();
        return VehicleType.CBIHU12_A58_G == platformProjectDescribe$VehicleType0;
    }

    public static boolean isCBIHU12A58Vehicle() {
        VehicleType platformProjectDescribe$VehicleType0 = PlatformProjectDescribe.getVehicleType();
        return VehicleType.CBIHU12_A58 == platformProjectDescribe$VehicleType0;
    }

    public static boolean isCBIHU12A79Vehicle() {
        VehicleType platformProjectDescribe$VehicleType0 = PlatformProjectDescribe.getVehicleType();
        return VehicleType.CBIHU12_A79 == platformProjectDescribe$VehicleType0;
    }

    public static boolean isCBIHU12A88Vehicle() {
        VehicleType platformProjectDescribe$VehicleType0 = PlatformProjectDescribe.getVehicleType();
        return VehicleType.CBIHU12_A88 == platformProjectDescribe$VehicleType0;
    }

    public static boolean isCBIHU12C1Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CBIHU12_C1 == platformProjectDescribe$Project0;
    }

    public static boolean isCBIHU12C7Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CB_IHU12_C7 == platformProjectDescribe$Project0;
    }

    public static boolean isCBIHU12C7T79GAVehicle() {
        VehicleType platformProjectDescribe$VehicleType0 = PlatformProjectDescribe.getVehicleType();
        return VehicleType.CBIHU12C7_T79_G == platformProjectDescribe$VehicleType0;
    }

    public static boolean isCBIHU12Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CBIHU12 == platformProjectDescribe$Project0;
    }

    public static boolean isCBIHU12T58XVehicle() {
        VehicleType platformProjectDescribe$VehicleType0 = PlatformProjectDescribe.getVehicleType();
        return VehicleType.CBIHU12_T58_X == platformProjectDescribe$VehicleType0;
    }

    public static boolean isCBIHU17B1Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CBIHU17_B1 == platformProjectDescribe$Project0;
    }

    public static boolean isCBIHU17Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CBIHU17 == platformProjectDescribe$Project0;
    }

    public static boolean isCBIHU18Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CBIHU18 == platformProjectDescribe$Project0;
    }

    public static boolean isCBIHU19G06Vehicle() {
        VehicleType platformProjectDescribe$VehicleType0 = PlatformProjectDescribe.getVehicleType();
        return VehicleType.CBIHU19_G06 == platformProjectDescribe$VehicleType0;
    }

    public static boolean isCBIHU19Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CBIHU19 == platformProjectDescribe$Project0;
    }

    public static boolean isCBIHU21Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CBIHU21 == platformProjectDescribe$Project0;
    }

    public static boolean isCBIHU23C1Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CBIHU23_C1 == platformProjectDescribe$Project0;
    }

    public static boolean isCBIHU23Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CBIHU23 == platformProjectDescribe$Project0;
    }

    public static boolean isCDC003A1G08Vehicle() {
        VehicleType platformProjectDescribe$VehicleType0 = PlatformProjectDescribe.getVehicleType();
        return VehicleType.CDC003_A1_G08 == platformProjectDescribe$VehicleType0;
    }

    public static boolean isCDC003A1Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CDC003_A1 == platformProjectDescribe$Project0;
    }

    public static boolean isCDC003A5Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CDC003_A5 == platformProjectDescribe$Project0;
    }

    public static boolean isCDC003B1Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CDC003_B1 == platformProjectDescribe$Project0;
    }

    public static boolean isCDC003B2Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CDC003_B2 == platformProjectDescribe$Project0;
    }

    public static boolean isCDC003C1G08AVehicle() {
        VehicleType platformProjectDescribe$VehicleType0 = PlatformProjectDescribe.getVehicleType();
        return VehicleType.CDC003_C1_G08_A == platformProjectDescribe$VehicleType0;
    }

    public static boolean isCDC003C1Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CDC003_C1 == platformProjectDescribe$Project0;
    }

    public static boolean isCDC005A1Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CDC005_A1 == platformProjectDescribe$Project0;
    }

    public static boolean isCDC005A1RT6Vehicle() {
        VehicleType platformProjectDescribe$VehicleType0 = PlatformProjectDescribe.getVehicleType();
        return VehicleType.CDC005_A1_RT6 == platformProjectDescribe$VehicleType0;
    }

    public static boolean isCDC006B1Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CDC006_B1 == platformProjectDescribe$Project0;
    }

    public static boolean isCDC006Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CDC006 == platformProjectDescribe$Project0;
    }

    public static boolean isCDC007A1ES601Vehicle() {
        VehicleType platformProjectDescribe$VehicleType0 = PlatformProjectDescribe.getVehicleType();
        return VehicleType.CDC007_A1_ES601 == platformProjectDescribe$VehicleType0;
    }

    public static boolean isCDC007A1Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CDC007_A1 == platformProjectDescribe$Project0;
    }

    public static boolean isCDC010A1G05Vehicle() {
        VehicleType platformProjectDescribe$VehicleType0 = PlatformProjectDescribe.getVehicleType();
        return VehicleType.CDC010_A1_G05 == platformProjectDescribe$VehicleType0;
    }

    public static boolean isCDC010A1Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CDC010_A1 == platformProjectDescribe$Project0;
    }

    public static boolean isCDC010B1Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CDC010_B1 == platformProjectDescribe$Project0;
    }

    public static boolean isCar011Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CAR011 == platformProjectDescribe$Project0;
    }

    public static boolean isCar015Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.CAR015 == platformProjectDescribe$Project0;
    }

    public static boolean isPT025Project() {
        Project platformProjectDescribe$Project0 = PlatformProjectDescribe.getProject();
        return Project.PT025 == platformProjectDescribe$Project0;
    }

    public static boolean isQTI8155Platform() {
        Platform platformProjectDescribe$Platform0 = PlatformProjectDescribe.getPlatform();
        return Platform.QTI8155 == platformProjectDescribe$Platform0;
    }

    public static boolean isXinChiPlatform() {
        Platform platformProjectDescribe$Platform0 = PlatformProjectDescribe.getPlatform();
        return Platform.XINCHI == platformProjectDescribe$Platform0;
    }
}

