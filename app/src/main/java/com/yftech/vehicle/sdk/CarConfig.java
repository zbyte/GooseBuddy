package com.yftech.vehicle.sdk;

import android.util.Log;
import com.yftech.vehicle.internal.BaseApiManager;
import com.yftech.vehicle.internal.adapter.ICarConfig.AirConditionType;
import com.yftech.vehicle.internal.adapter.ICarConfig.AirConditioningZones;
import com.yftech.vehicle.internal.adapter.ICarConfig.Avdc;
import com.yftech.vehicle.internal.adapter.ICarConfig.CameraNumber;
import com.yftech.vehicle.internal.adapter.ICarConfig.Config;
import com.yftech.vehicle.internal.adapter.ICarConfig.ConfigPm25;
import com.yftech.vehicle.internal.adapter.ICarConfig.DmsConnectionMode;
import com.yftech.vehicle.internal.adapter.ICarConfig.DriveType;
import com.yftech.vehicle.internal.adapter.ICarConfig.DriverSeatControl;
import com.yftech.vehicle.internal.adapter.ICarConfig.FeezeMode;
import com.yftech.vehicle.internal.adapter.ICarConfig.GearboxType;
import com.yftech.vehicle.internal.adapter.ICarConfig.HeatingAndVentilationFl;
import com.yftech.vehicle.internal.adapter.ICarConfig.HeatingAndVentilationFr;
import com.yftech.vehicle.internal.adapter.ICarConfig.HeatingAndVentilationRl;
import com.yftech.vehicle.internal.adapter.ICarConfig.HeatingAndVentilationRr;
import com.yftech.vehicle.internal.adapter.ICarConfig.LaneChangeAssist;
import com.yftech.vehicle.internal.adapter.ICarConfig.LeftRightHandDriveVehicles;
import com.yftech.vehicle.internal.adapter.ICarConfig.LimitSecondRowSeatsWelcomeFunction;
import com.yftech.vehicle.internal.adapter.ICarConfig.LoudspeakerNumber;
import com.yftech.vehicle.internal.adapter.ICarConfig.LoudspeakerSupplier;
import com.yftech.vehicle.internal.adapter.ICarConfig.NapMode;
import com.yftech.vehicle.internal.adapter.ICarConfig.PromptType;
import com.yftech.vehicle.internal.adapter.ICarConfig.RadarNumber;
import com.yftech.vehicle.internal.adapter.ICarConfig.RearDefrostAndRearviewMirrorHeating;
import com.yftech.vehicle.internal.adapter.ICarConfig.SeatLayout;
import com.yftech.vehicle.internal.adapter.ICarConfig.SecondRowSeatsControl;
import com.yftech.vehicle.internal.adapter.ICarConfig.SecondRowSeatsWelcome;
import com.yftech.vehicle.internal.adapter.ICarConfig.StandardAndHdCameraConfiguration;
import com.yftech.vehicle.internal.adapter.ICarConfig.TboxConnectionMode;
import com.yftech.vehicle.internal.adapter.ICarConfig.Tiktok;
import com.yftech.vehicle.internal.adapter.ICarConfig.VehiclePlatform;
import com.yftech.vehicle.internal.adapter.ICarConfig.VehicleType;
import com.yftech.vehicle.internal.adapter.ICarConfig.VrControl;
import com.yftech.vehicle.internal.adapter.ICarConfig.VrControlCarwindow;
import com.yftech.vehicle.internal.adapter.ICarConfig.VrControlHvac;
import com.yftech.vehicle.internal.adapter.ICarConfig.VrControlIal;
import com.yftech.vehicle.internal.adapter.ICarConfig.VrControlParking;
import com.yftech.vehicle.internal.adapter.ICarConfig.VrControlRoof;
import com.yftech.vehicle.internal.adapter.ICarConfig.VrControlRoofposition;
import com.yftech.vehicle.internal.adapter.ICarConfig.VrControlWindowposition;
import com.yftech.vehicle.internal.adapter.ICarConfig.VrControlWiperAndCleaning;
import com.yftech.vehicle.internal.adapter.ICarConfig.WalAndApu;
import com.yftech.vehicle.internal.adapter.ICarConfig.WindowControl;
import com.yftech.vehicle.internal.adapter.ICarConfig;
import java.util.Arrays;

public class CarConfig implements ICarConfig {
    private static final String TAG = "CarConfig";
    private BaseApiManager mApi;
    private byte[] mData;
    private static CarConfig sMe;

    private CarConfig() {
        this.mApi = new BaseApiManager() {
        };
    }

    private byte[] configData() {
        if(this.mData == null || this.mData.length < 1) {
            this.mData = this.mApi.getSignalDataValue(0x270B);
            Log.i("CarConfig", "configData() mData=" + (this.mData == null ? "[]" : Arrays.toString(this.mData)));
        }
        return this.mData;
    }

    private int configValue(ICarConfig.Config config) {
        byte[] arr_b = this.configData();
        return arr_b == null || config.byteIndex < 0 || config.byteIndex >= arr_b.length ? -1 : (arr_b[config.byteIndex] & 0xFF & (1 << config.bitSize) - 1 << config.startBit) >> config.startBit;
    }

    private static CarConfig get() {
        CarConfig carConfig0;
        synchronized(CarConfig.class) {
            if(CarConfig.sMe == null) {
                carConfig0 = new CarConfig();
                CarConfig.sMe = carConfig0;
            }
            else {
                carConfig0 = CarConfig.sMe;
            }
            return carConfig0;
        }
    }

    public static ICarConfig.AirConditionType getAirConditionType() {
        return ICarConfig.AirConditionType.valueOf(CarConfig.getConfigValue(ICarConfig.Config.AIR_CONDITION_TYPE));
    }

    public static ICarConfig.AirConditioningZones getAirConditioningZones() {
        return ICarConfig.AirConditioningZones.valueOf(CarConfig.getConfigValue(ICarConfig.Config.AIR_CONDITIONING_ZONES));
    }

    public static int getApaAlarmDelayedTime() {
        return CarConfig.getConfigValue(ICarConfig.Config.APA_ALARM_DELAYED_TIME);
    }

    public static ICarConfig.Avdc getAvdc() {
        return ICarConfig.Avdc.valueOf(CarConfig.getConfigValue(ICarConfig.Config.AVDC));
    }

    public static ICarConfig.CameraNumber getCameraNumber() {
        return ICarConfig.CameraNumber.valueOf(CarConfig.getConfigValue(ICarConfig.Config.CAMERA_NUMBER));
    }

    public static byte[] getConfigData() {
        return CarConfig.get().configData();
    }

    public static ICarConfig.ConfigPm25 getConfigPm25() {
        return ICarConfig.ConfigPm25.valueOf(CarConfig.getConfigValue(ICarConfig.Config.CONFIG_PM2_5));
    }

    private static int getConfigValue(ICarConfig.Config config) {
        return CarConfig.get().configValue(config);
    }

    public static int getDistractedAlarmIntervalTime() {
        return CarConfig.getConfigValue(ICarConfig.Config.DISTRACTED_ALARM_INTERVAL_TIME);
    }

    public static ICarConfig.DmsConnectionMode getDmsConnectionMode() {
        return ICarConfig.DmsConnectionMode.valueOf(CarConfig.getConfigValue(ICarConfig.Config.DMS_CONNECTION_MODE));
    }

    public static ICarConfig.DriveType getDriveType() {
        return ICarConfig.DriveType.valueOf(CarConfig.getConfigValue(ICarConfig.Config.DRIVE_TYPE));
    }

    public static ICarConfig.DriverSeatControl getDriverSeatControlPresentFunction() {
        return ICarConfig.DriverSeatControl.valueOf(CarConfig.getConfigValue(ICarConfig.Config.DRIVER_SEAT_CONTROL));
    }

    public static ICarConfig.FeezeMode getFeezeMode() {
        return ICarConfig.FeezeMode.valueOf(CarConfig.getConfigValue(ICarConfig.Config.FEEZE_MODE));
    }

    public static ICarConfig.GearboxType getGearboxType() {
        return ICarConfig.GearboxType.valueOf(CarConfig.getConfigValue(ICarConfig.Config.GEARBOX_TYPE));
    }

    public static ICarConfig.HeatingAndVentilationFl getHeatingAndVentilationFl() {
        return ICarConfig.HeatingAndVentilationFl.valueOf(CarConfig.getConfigValue(ICarConfig.Config.HEATING_AND_VENTILATION_FL));
    }

    public static ICarConfig.HeatingAndVentilationFr getHeatingAndVentilationFr() {
        return ICarConfig.HeatingAndVentilationFr.valueOf(CarConfig.getConfigValue(ICarConfig.Config.HEATING_AND_VENTILATION_FR));
    }

    public static ICarConfig.HeatingAndVentilationRl getHeatingAndVentilationRl() {
        return ICarConfig.HeatingAndVentilationRl.valueOf(CarConfig.getConfigValue(ICarConfig.Config.HEATING_AND_VENTILATION_RL));
    }

    public static ICarConfig.HeatingAndVentilationRr getHeatingAndVentilationRr() {
        return ICarConfig.HeatingAndVentilationRr.valueOf(CarConfig.getConfigValue(ICarConfig.Config.HEATING_AND_VENTILATION_RR));
    }

    public static ICarConfig.LaneChangeAssist getLaneChangeAssist() {
        return ICarConfig.LaneChangeAssist.valueOf(CarConfig.getConfigValue(ICarConfig.Config.LANE_CHANGE_ASSIST));
    }

    public static ICarConfig.LeftRightHandDriveVehicles getLeftRightHandDriveVehicles() {
        return ICarConfig.LeftRightHandDriveVehicles.valueOf(CarConfig.getConfigValue(ICarConfig.Config.LEFT_RIGHT_HAND_DRIVE_VEHICLES));
    }

    public static ICarConfig.LimitSecondRowSeatsWelcomeFunction getLimitSecondRowSeatsWelcomeFunction() {
        return ICarConfig.LimitSecondRowSeatsWelcomeFunction.valueOf(CarConfig.getConfigValue(ICarConfig.Config.LIMIT_SECOND_ROW_SEATS_WELCOME_FUNCTION));
    }

    public static ICarConfig.LoudspeakerNumber getLoudspeakerNumber() {
        return ICarConfig.LoudspeakerNumber.valueOf(CarConfig.getConfigValue(ICarConfig.Config.LOUDSPEAKER_NUMBER));
    }

    public static ICarConfig.LoudspeakerSupplier getLoudspeakerSupplier() {
        return ICarConfig.LoudspeakerSupplier.valueOf(CarConfig.getConfigValue(ICarConfig.Config.LOUDSPEAKER_SUPPLIER));
    }

    public static ICarConfig.NapMode getNapMode() {
        return ICarConfig.NapMode.valueOf(CarConfig.getConfigValue(ICarConfig.Config.NAP_MODE));
    }

    public static ICarConfig.PromptType getPromptType() {
        return ICarConfig.PromptType.valueOf(CarConfig.getConfigValue(ICarConfig.Config.PROMPT_TYPE));
    }

    public static ICarConfig.RadarNumber getRadarNumber() {
        return ICarConfig.RadarNumber.valueOf(CarConfig.getConfigValue(ICarConfig.Config.RADAR_NUMBER));
    }

    public static ICarConfig.RearDefrostAndRearviewMirrorHeating getRearDefrostAndRearviewMirrorHeating() {
        return ICarConfig.RearDefrostAndRearviewMirrorHeating.valueOf(CarConfig.getConfigValue(ICarConfig.Config.REAR_DEFROST_AND_REARVIEW_MIRROR_HEATING));
    }

    public static int getReserced() {
        return CarConfig.getConfigValue(ICarConfig.Config.RESERCED);
    }

    public static ICarConfig.DriverSeatControl getSeatAdjustmentPresentFunction() {
        return ICarConfig.DriverSeatControl.valueOf(CarConfig.getConfigValue(ICarConfig.Config.PASSENGER_SEAT_ADJUSTMENT));
    }

    public static ICarConfig.SeatLayout getSeatLayout() {
        return ICarConfig.SeatLayout.valueOf(CarConfig.getConfigValue(ICarConfig.Config.SEAT_LAYOUT_NEW));
    }

    public static ICarConfig.SecondRowSeatsControl getSecondRowSeatAdjustmentPresent() {
        return ICarConfig.SecondRowSeatsControl.valueOf(CarConfig.getConfigValue(ICarConfig.Config.SECOND_ROW_SEAT_ADJUSTMENT));
    }

    public static ICarConfig.SecondRowSeatsWelcome getSecondRowSeatsWelcome() {
        return ICarConfig.SecondRowSeatsWelcome.valueOf(CarConfig.getConfigValue(ICarConfig.Config.SECOND_ROW_SEATS_WELCOME));
    }

    public static ICarConfig.StandardAndHdCameraConfiguration getStandardAndHdCameraConfiguration() {
        return ICarConfig.StandardAndHdCameraConfiguration.valueOf(CarConfig.getConfigValue(ICarConfig.Config.STANDARD_AND_HD_CAMERA_CONFIGURATION));
    }

    public static ICarConfig.TboxConnectionMode getTboxConnectionMode() {
        return ICarConfig.TboxConnectionMode.valueOf(CarConfig.getConfigValue(ICarConfig.Config.TBOX_CONNECTION_MODE));
    }

    public static ICarConfig.Tiktok getTiktok() {
        return ICarConfig.Tiktok.valueOf(CarConfig.getConfigValue(ICarConfig.Config.TIKTOK));
    }

    public static int getTiredAlarmIntervalTime() {
        return CarConfig.getConfigValue(ICarConfig.Config.TIRED_ALARM_INTERVAL_TIME);
    }

    public static ICarConfig.VehiclePlatform getVehiclePlatform() {
        return ICarConfig.VehiclePlatform.valueOf(CarConfig.getConfigValue(ICarConfig.Config.VEHICLE_PLATFORM));
    }

    public static ICarConfig.VehicleType getVehicleType() {
        return ICarConfig.VehicleType.valueOf(CarConfig.getConfigValue(ICarConfig.Config.VEHICLE_TYPE));
    }

    public static ICarConfig.VrControl getVrControl() {
        return ICarConfig.VrControl.valueOf(CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL));
    }

    public static ICarConfig.VrControlCarwindow getVrControlCarwindow() {
        return ICarConfig.VrControlCarwindow.valueOf(CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_CARWINDOW));
    }

    public static ICarConfig.VrControlHvac getVrControlHvac() {
        return ICarConfig.VrControlHvac.valueOf(CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_HVAC));
    }

    public static ICarConfig.VrControlIal getVrControlIal() {
        return ICarConfig.VrControlIal.valueOf(CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_IAL));
    }

    public static ICarConfig.VrControlParking getVrControlParking() {
        return ICarConfig.VrControlParking.valueOf(CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_PARKING));
    }

    public static ICarConfig.VrControlRoof getVrControlRoof() {
        return ICarConfig.VrControlRoof.valueOf(CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_ROOF));
    }

    public static ICarConfig.VrControlRoofposition getVrControlRoofposition() {
        return ICarConfig.VrControlRoofposition.valueOf(CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_ROOFPOSITION));
    }

    public static ICarConfig.VrControlWindowposition getVrControlWindowposition() {
        return ICarConfig.VrControlWindowposition.valueOf(CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_WINDOWPOSITION));
    }

    public static ICarConfig.VrControlWiperAndCleaning getVrControlWiperAndCleaning() {
        return ICarConfig.VrControlWiperAndCleaning.valueOf(CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_WIPER_AND_CLEANING));
    }

    public static ICarConfig.WalAndApu getWalAndApu() {
        return ICarConfig.WalAndApu.valueOf(CarConfig.getConfigValue(ICarConfig.Config.WAL_AND_APU));
    }

    public static ICarConfig.WindowControl getWindowControl() {
        return ICarConfig.WindowControl.valueOf(CarConfig.getConfigValue(ICarConfig.Config.WINDOW_CONTROL));
    }

    public static boolean isACanPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.A_CAN) != 0;
    }

    public static boolean isAccessorySmartScreenPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ACCESSORY_SMART_SCREEN) != 0;
    }

    public static boolean isAdaptiveHighBeamPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ADAPTIVE_HIGH_BEAM) != 0;
    }

    public static boolean isAirConditioningBlindExercisePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.AIR_CONDITIONING_BLIND_EXERCISE) != 0;
    }

    public static boolean isAirConditioningQuickStartPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.AIR_CONDITIONING_QUICK_START) != 0;
    }

    public static boolean isAlertModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ALERT_MODE) != 0;
    }

    public static boolean isAmbienceLightsComninationPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.AMBIENCE_LIGHTS_COMNINATION) != 0;
    }

    public static boolean isAmbienceLightsControlPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.AMBIENCE_LIGHTS_CONTROL) != 0;
    }

    public static boolean isAncPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ANC) != 0;
    }

    public static boolean isAnionPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ANION) != 0;
    }

    public static boolean isAntennaPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ANTENNA) != 0;
    }

    public static boolean isApaVoicePromptButtonPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.APA_VOICE_PROMPT_BUTTON) != 0;
    }

    public static boolean isArPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.AR) != 0;
    }

    public static boolean isAutoDeforstPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.AUTO_DEFORST) != 0;
    }

    public static boolean isAutoEmergencyBrakingBrakingPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.AUTO_EMERGENCY_BRAKING_BRAKING) != 0;
    }

    public static boolean isAutoModeOfFrsAndRecControlPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.AUTO_MODE_OF_FRS_AND_REC_CONTROL) != 0;
    }

    public static boolean isAutoUnlockingPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.AUTO_UNLOCKING) != 0;
    }

    public static boolean isAutoWiperPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.AUTO_WIPER) != 0;
    }

    public static boolean isAutoholdPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.AUTOHOLD) != 0;
    }

    public static boolean isAvasPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.AVAS) != 0;
    }

    public static boolean isAvasSoundPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.AVAS_SOUND) != 0;
    }

    public static boolean isAvasSwitchPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.AVAS_SWITCH) != 0;
    }

    public static boolean isBCallSwitchPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.B_CALL_SWITCH) != 0;
    }

    public static boolean isBCanPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.B_CAN) != 0;
    }

    public static boolean isBackRowDisplayPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.BACK_ROW_DISPLAY) != 0;
    }

    public static boolean isBcmPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.BCM) != 0;
    }

    public static boolean isBsdPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.BSD) != 0;
    }

    public static boolean isCallBackPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CALL_BACK) != 0;
    }

    public static boolean isCeilingScreenPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CEILING_SCREEN) != 0;
    }

    public static boolean isChargingInsulationPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CHARGING_INSULATION) != 0;
    }

    public static boolean isCloseWindowWhileLockPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CLOSE_WINDOW_WHILE_LOCK) != 0;
    }

    public static boolean isClusterBackLightPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CLUSTER_BACK_LIGHT) != 0;
    }

    public static boolean isClusterDefaultSettingPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CLUSTER_DEFAULT_SETTING) != 0;
    }

    public static boolean isClusterDistanceSettingPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CLUSTER_DISTANCE_SETTING) != 0;
    }

    public static boolean isClusterFuelConsumptionUnitPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CLUSTER_FUEL_CONSUMPTION_UNIT) != 0;
    }

    public static boolean isClusterLanguageSettingPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CLUSTER_LANGUAGE_SETTING) != 0;
    }

    public static boolean isClusterMileageResetPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CLUSTER_MILEAGE_RESET) != 0;
    }

    public static boolean isClusterPressureUnitPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CLUSTER_PRESSURE_UNIT) != 0;
    }

    public static boolean isClusterSpeedUnitPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CLUSTER_SPEED_UNIT) != 0;
    }

    public static boolean isClusterTemperatureUnitPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CLUSTER_TEMPERATURE_UNIT) != 0;
    }

    public static boolean isClusterVolumeSettingPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CLUSTER_VOLUME_SETTING) != 0;
    }

    public static boolean isColdAndWarmCupHolderPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.COLD_AND_WARM_CUP_HOLDER) != 0;
    }

    public static boolean isComfortCurvePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.COMFORT_CURVE) != 0;
    }

    public static boolean isComfortableStopPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.COMFORTABLE_STOP) != 0;
    }

    public static boolean isControlDaytimeRunnigLampPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CONTROL_DAYTIME_RUNNIG_LAMP) != 0;
    }

    public static boolean isControlHighBeamAssistantPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CONTROL_HIGH_BEAM_ASSISTANT) != 0;
    }

    public static boolean isControlSmartWelcomeLightPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CONTROL_SMART_WELCOME_LIGHT) != 0;
    }

    public static boolean isCreepModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.CREEP_MODE) != 0;
    }

    public static boolean isDomeLightInDoorGearPositionPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.DOME_LIGHT_IN_DOOR_GEAR_POSITION) != 0;
    }

    public static boolean isDoorOpenWarningPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.DOOR_OPEN_WARNING) != 0;
    }

    public static boolean isDriveModeMemorySwitchPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.DRIVE_MODE_MEMORY_SWITCH) != 0;
    }

    public static boolean isDriverAssistanceWarningPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.DRIVER_ASSISTANCE_WARNING) != 0;
    }

    public static boolean isDriverDirectVoiceWakeUpPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.DRIVER_DIRECT_VOICE_WAKE_UP) != 0;
    }

    public static boolean isDriverEasyEntryAndExitFunctionPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.DRIVER_EASY_ENTRY_AND_EXIT_FUNCTION) != 0;
    }

    public static boolean isDriverModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.DRIVER_MODE) != 0;
    }

    public static boolean isDriverSeatControlPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.DRIVER_SEAT_CONTROL) != 0;
    }

    public static boolean isDriverStateOfAlertPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.DRIVER_STATE_OF_ALERT) != 0;
    }

    public static boolean isDrivingModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.DRIVING_MODE) != 0;
    }

    public static boolean isDrivingRecorderPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.DRIVING_RECORDER) != 0;
    }

    public static boolean isDvrPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.DVR) != 0;
    }

    public static boolean isECallSwitchPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.E_CALL_SWITCH) != 0;
    }

    public static boolean isEasyOpenTailgatePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.EASY_OPEN_TAILGATE) != 0;
    }

    public static boolean isEboosterModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.EBOOSTER_MODE) != 0;
    }

    public static boolean isEcoPlusModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ECO_PLUS_MODE) != 0;
    }

    public static boolean isElectroDischargePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ELECTRO_DISCHARGE) != 0;
    }

    public static boolean isEmergencyLaneKeepingAssistPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.EMERGENCY_LANE_KEEPING_ASSIST) != 0;
    }

    public static boolean isEmergencySteeringModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.EMERGENCY_STEERING_MODE) != 0;
    }

    public static boolean isEnergyConsumptionAppPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ENERGY_CONSUMPTION_APP) != 0;
    }

    public static boolean isEnergyConsumptionPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ENERGY_CONSUMPTION) != 0;
    }

    public static boolean isEnergyFlowDisplayPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ENERGY_FLOW_DISPLAY) != 0;
    }

    public static boolean isEnergyFlowModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ENERGY_FLOW_MODE) != 0;
    }

    public static boolean isEnergyRecoveryModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ENERGY_RECOVERY_MODE) != 0;
    }

    public static boolean isEnergyRecoveryPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ENERGY_RECOVERY) != 0;
    }

    public static boolean isEngineWaveSwitchPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ENGINE_WAVE_SWITCH) != 0;
    }

    public static boolean isEpedalModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.EPEDAL_MODE) != 0;
    }

    public static boolean isEspOffSwitchPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ESP_OFF_SWITCH) != 0;
    }

    public static boolean isEtcSettingPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ETC_SETTING) != 0;
    }

    public static boolean isEvSwitchDisplayPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.EV_SWITCH_DISPLAY) != 0;
    }

    public static boolean isEvaporatorSelfDryingPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.EVAPORATOR_SELF_DRYING) != 0;
    }

    public static boolean isEventRecordFunctionSwitchPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.EVENT_RECORD_FUNCTION_SWITCH) != 0;
    }

    public static boolean isExtAmplifiersPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.EXT_AMPLIFIERS) != 0;
    }

    public static boolean isExteriorRearViewMirrorAutoFoldingAndUnfoldingPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.EXTERIOR_REAR_VIEW_MIRROR_AUTO_FOLDING_AND_UNFOLDING) != 0;
    }

    public static boolean isExteriorRearviewMirrorDipPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.EXTERIOR_REARVIEW_MIRROR_DIP) != 0;
    }

    public static boolean isExternalSvmPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.EXTERNAL_SVM) != 0;
    }

    public static boolean isFLSeatMessagePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.FL_SEAT_MASSAGE) != 0;
    }

    public static boolean isFRSeatMessagePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.FR_SEAT_MASSAGE) != 0;
    }

    public static boolean isFanSpeedOfAutoModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.FAN_SPEED_OF_AUTO_MODE) != 0;
    }

    public static boolean isFapaPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.FAPA) != 0;
    }

    public static boolean isFcpPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.FCP) != 0;
    }

    public static boolean isFlSpeakerPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.FL_SPEAKER) != 0;
    }

    public static boolean isFollowMusicModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.FOLLOW_MUSIC_MODE) != 0;
    }

    public static boolean isFollowTrackingLinePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.FOLLOW_TRACKING_LINE) != 0;
    }

    public static boolean isForwardCollisionWarningDistancePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.FORWARD_COLLISION_WARNING_DISTANCE) != 0;
    }

    public static boolean isFrSpeakerPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.FR_SPEAKER) != 0;
    }

    public static boolean isFragrancePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.FRAGRANCE) != 0;
    }

    public static boolean isFrontCollisionWarningPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.FRONT_COLLISION_WARNING) != 0;
    }

    public static boolean isFrontCrossTrafficAlertModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.FRONT_CROSS_TRAFFIC_ALERT_MODE) != 0;
    }

    public static boolean isFrontCrossTrafficAlertPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.FRONT_CROSS_TRAFFIC_ALERT) != 0;
    }

    public static boolean isFrontDistanceDisplayPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.FRONT_DISTANCE_DISPLAY) != 0;
    }

    public static boolean isGACLogoPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.GAC_LOGO) != 1;
    }

    public static boolean isGpsPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.GPS) != 0;
    }

    public static boolean isGuidanceOfStartingVhiclePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.GUIDANCE_OF_STARTING_VHICLE) != 0;
    }

    public static boolean isGwmPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.GWM) != 0;
    }

    public static boolean isHdcSwitchPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.HDC_SWITCH) != 0;
    }

    public static boolean isHeadAcousticsPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.HEAD_ACOUSTICS) != 0;
    }

    public static boolean isHealthChargeSettingPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.HEALTH_CHARGE_SETTING) != 0;
    }

    public static boolean isHeatPumpAirConditioningPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.HEAT_PUMP_AIR_CONDITIONING) != 0;
    }

    public static boolean isHiddenDoorHandlePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.HIDDEN_DOOR_HANDLE) != 0;
    }

    public static boolean isHighWayAssistPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.HIGH_WAY_ASSIST) != 0;
    }

    public static boolean isHospitalityLampSignalsPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.HOSPITALITY_LAMP_SIGNALS) != 0;
    }

    public static boolean isHudSetPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.HUD_SET) != 0;
    }

    public static boolean isHvacPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.HVAC) != 0;
    }

    public static boolean isIMRControlPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.IMR) != 0;
    }

    public static boolean isIalPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.IAL) != 0;
    }

    public static boolean isIccPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ICC) != 0;
    }

    public static boolean isIcmPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ICM) != 0;
    }

    public static boolean isIfcCruisemodePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.IFC_CRUISEMODE) != 0;
    }

    public static boolean isIndicatedLaneChangePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.INDICATED_LANE_CHANGE) != 0;
    }

    public static boolean isIndicatedLaneChangingPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.INDICATED_LANE_CHANGING) != 0;
    }

    public static boolean isIntelligentCollisionAvoidancePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.INTELLIGENT_COLLISION_AVOIDANCE) != 0;
    }

    public static boolean isIntelligentInsulationNotificationPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.INTELLIGENT_INSULATION_NOTIFICATION) != 0;
    }

    public static boolean isIntelligentSpeedLimitControlPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.INTELLIGENT_SPEED_LIMIT_CONTROL) != 0;
    }

    public static boolean isKeyIdentificationPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.KEY_IDENTIFICATION) != 0;
    }

    public static boolean isLaneAssistPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.LANE_ASSIST) != 0;
    }

    public static boolean isLaneAuxiliarySwitchPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.LANE_AUXILIARY_SWITCH) != 0;
    }

    public static boolean isLaneChangeDriverConfirmationPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.LANE_CHANGE_DRIVER_CONFIRMATION) != 0;
    }

    public static boolean isLaneChangeStylePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.LANE_CHANGE_STYLE) != 0;
    }

    public static boolean isLcaCardPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.LCA_CARD) != 0;
    }

    public static boolean isLightShowPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.LIGHT_SHOW) != 0;
    }

    public static boolean isLightTurnedOffDelayPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.LIGHT_TURNED_OFF_DELAY) != 0;
    }

    public static boolean isLockAndUnlockWhistleNotePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.LOCK_AND_UNLOCK_WHISTLE_NOTE) != 0;
    }

    public static boolean isLockControlPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.LOCK_CONTROL) != 0;
    }

    public static boolean isLookAroundToDetectTheDoorPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.LOOK_AROUND_TO_DETECT_THE_DOOR) != 0;
    }

    public static boolean isMicPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.MIC) != 0;
    }

    public static boolean isMonsterModeSwitchPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.MONSTER_MODE_SWITCH) != 0;
    }

    public static boolean isNavigationDrivingAssistPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.NAVIGATION_DRIVING_ASSIST) != 0;
    }

    public static boolean isNfcPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.NFC) != 0;
    }

    public static boolean isOmsPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.OMS) != 0;
    }

    public static boolean isOneClickToTurnOnOffTheCellingLightPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ONE_CLICK_TO_TURN_ON_OFF_THE_CELLING_LIGHT) != 0;
    }

    public static boolean isOverspeedAlarmOfTsrPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.OVERSPEED_ALARM_OF_TSR) != 0;
    }

    public static boolean isOverspeedWarningPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.OVERSPEED_WARNING) != 0;
    }

    public static boolean isPartyModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.PARTY_MODE) != 0;
    }

    public static boolean isPasPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.PAS) != 0;
    }

    public static boolean isPassengerSeatAdjustmentPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.PASSENGER_SEAT_ADJUSTMENT) != 0;
    }

    public static boolean isPcsPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.PCS) != 0;
    }

    public static boolean isPlgmfunccfgPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.PLGMFUNCCFG) != 0;
    }

    public static boolean isQishiModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.QISHI_MODE) != 0;
    }

    public static boolean isQualitySensorPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.QUALITY_SENSOR) != 0;
    }

    public static boolean isRaebPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.RAEB) != 0;
    }

    public static boolean isRainstormModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.RAINSTORM_MODE) != 0;
    }

    public static boolean isRapidVentilationPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.RAPID_VENTILATION) != 0;
    }

    public static boolean isRearApproachingWarningModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.REAR_APPROACHING_WARNING_MODE) != 0;
    }

    public static boolean isRearApproachingWarningPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.REAR_APPROACHING_WARNING) != 0;
    }

    public static boolean isRearCrossTrafficAlertModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.REAR_CROSS_TRAFFIC_ALERT_MODE) != 0;
    }

    public static boolean isRearCrossTrafficAlertPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.REAR_CROSS_TRAFFIC_ALERT) != 0;
    }

    public static boolean isRearSeatBeltNotificationPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.REAR_SEAT_BELT_NOTIFICATION) != 0;
    }

    public static boolean isRearviewMirrorAdjustmentPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.REARVIEW_MIRROR_ADJUSTMENT) != 0;
    }

    public static boolean isRemoteFindingCarPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.REMOTE_FINDING_CAR) != 0;
    }

    public static boolean isRemoteUnlockPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.REMOTE_UNLOCK) != 0;
    }

    public static boolean isRestartVehicleCommunicationModulePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.RESTART_VEHICLE_COMMUNICATION_MODULE) != 0;
    }

    public static boolean isRlSpeakerPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.RL_SPEAKER) != 0;
    }

    public static boolean isRoofControlPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ROOF_CONTROL) != 0;
    }

    public static boolean isRrSpeakerPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.RR_SPEAKER) != 0;
    }

    public static boolean isRvcPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.RVC) != 0;
    }

    public static boolean isSeatControlPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SEAT_CONTROL) != 0;
    }

    public static boolean isSecondRowChildLockPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SECOND_ROW_CHILD_LOCK) != 0;
    }

    public static boolean isSecondRowSeatAdjustmentPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SECOND_ROW_SEAT_ADJUSTMENT) != 0;
    }

    public static boolean isSecondRowSeatMassagePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SECOND_ROW_SEAT_MASSAGE) != 0;
    }

    public static boolean isSecondRowSeatRestPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SECOND_ROW_SEAT_REST) != 0;
    }

    public static boolean isSixSeatLayoutPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SEAT_LAYOUT) != 0;
    }

    public static boolean isSlidingDoorControlManualAndAutomaticPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SLIDING_DOOR_CONTROL_MANUAL_AND_AUTOMATIC) != 0;
    }

    public static boolean isSlidingDoorControlPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SLIDING_DOOR_CONTROL) != 0;
    }

    public static boolean isSlidingDoorSpeedAdjustmentPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SLIDING_DOOR_SPEED_ADJUSTMENT) != 0;
    }

    public static boolean isSmartCommutDrivePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SMART_COMMUT_DRIVE) != 0;
    }

    public static boolean isSmartHvacPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SMART_HVAC) != 0;
    }

    public static boolean isSmartNaviDrivePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SMART_NAVI_DRIVE) != 0;
    }

    public static boolean isSmartTailgatePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SMART_TAILGATE) != 0;
    }

    public static boolean isSolarFeaturesPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SOLAR_FEATURES) != 0;
    }

    public static boolean isSpaPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SPA) != 0;
    }

    public static boolean isSpeedLimtedSignRecognitionPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SPEED_LIMTED_SIGN_RECOGNITION) != 0;
    }

    public static boolean isSpeedLockPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SPEED_LOCK) != 0;
    }

    public static boolean isSportPlusPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SPORT_PLUS) != 0;
    }

    public static boolean isSteeringModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.STEERING_MODE) != 0;
    }

    public static boolean isSteeringWheelControlPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.STEERING_WHEEL_CONTROL) != 0;
    }

    public static boolean isSteeringWheelCustomButtonPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.STEERING_WHEEL_CUSTOM_BUTTON) != 0;
    }

    public static boolean isSteeringWheelHeatingPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.STEERING_WHEEL_HEATING) != 0;
    }

    public static boolean isSteeringWheelKeyPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.STEERING_WHEEL_KEY) != 0;
    }

    public static boolean isSteeringWheelSteeringHandForcePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.STEERING_WHEEL_STEERING_HAND_FORCE) != 0;
    }

    public static boolean isStorageBoxAutomaticallyFlipDownPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.STORAGE_BOX_AUTOMATICALLY_FLIP_DOWN) != 0;
    }

    public static boolean isSuspensionDampingPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SUSPENSION_DAMPING) != 0;
    }

    public static boolean isSvmPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.SVM) != 0;
    }

    public static boolean isTboxPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.TBOX) != 0;
    }

    public static boolean isTechnologySkylightPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.TECHNOLOGY_SKYLIGHT) != 0;
    }

    public static boolean isTemporaryParkingLampSignalsPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.TEMPORARY_PARKING_LAMP_SIGNALS) != 0;
    }

    public static boolean isThe3DChimeBootSoundPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.THE_3D_CHIME_BOOT_SOUND) != 0;
    }

    public static boolean isThe3DChimeDriverModeSoundPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.THE_3D_CHIME_DRIVER_MODE_SOUND) != 0;
    }

    public static boolean isThe3DChimeFrontCollisionWarningSoundPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.THE_3D_CHIME_FRONT_COLLISION_WARNING_SOUND) != 0;
    }

    public static boolean isThe3DChimeIalSoundPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.THE_3D_CHIME_IAL_SOUND) != 0;
    }

    public static boolean isThe3DChimeIndicatorPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.THE_3D_CHIME_INDICATOR) != 0;
    }

    public static boolean isThe3DChimeLaneChangeAssitAndRearApproachingWarningPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.THE_3D_CHIME_LANE_CHANGE_ASSIT_AND_REAR_APPROACHING_WARNING) != 0;
    }

    public static boolean isThe3DChimeReversingRadarSoundPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.THE_3D_CHIME_REVERSING_RADAR_SOUND) != 0;
    }

    public static boolean isThrottleSensitivityPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.THROTTLE_SENSITIVITY) != 0;
    }

    public static boolean isTimeInClusterPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.TIME_IN_CLUSTER) != 0;
    }

    public static boolean isUltravioletRayPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.ULTRAVIOLET_RAY) != 0;
    }

    public static boolean isUnlockVentilationPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.UNLOCK_VENTILATION) != 0;
    }

    public static boolean isVcuPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VCU) != 0;
    }

    public static boolean isVrControlApaControlPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_APA_CONTROL) != 0;
    }

    public static boolean isVrControlChargingAndFuelTankCapPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_CHARGING_AND_FUEL_TANK_CAP) != 0;
    }

    public static boolean isVrControlChargingBookingMenuSwitchPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_CHARGING_BOOKING_MENU_SWITCH) != 0;
    }

    public static boolean isVrControlChargingInsulationMenuSwitchPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_CHARGING_INSULATION_MENU_SWITCH) != 0;
    }

    public static boolean isVrControlChargingInsulationNotificationPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_CHARGING_INSULATION_NOTIFICATION) != 0;
    }

    public static boolean isVrControlControlDriverModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_CONTROL_DRIVER_MODE) != 0;
    }

    public static boolean isVrControlCruisePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_CRUISE) != 0;
    }

    public static boolean isVrControlDmsNotificationPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_DMS_NOTIFICATION) != 0;
    }

    public static boolean isVrControlEnergyRecoveryPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_ENERGY_RECOVERY) != 0;
    }

    public static boolean isVrControlEngineAndMotorPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_ENGINE_AND_MOTOR) != 0;
    }

    public static boolean isVrControlExtlightPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_EXTLIGHT) != 0;
    }

    public static boolean isVrControlInstrumentBacklightPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_INSTRUMENT_BACKLIGHT) != 0;
    }

    public static boolean isVrControlPlgmPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_PLGM) != 0;
    }

    public static boolean isVrControlSeatAdjustmentPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_SEAT_ADJUSTMENT) != 0;
    }

    public static boolean isVrControlSunshadePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_SUNSHADE) != 0;
    }

    public static boolean isVrControlToplightPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_TOPLIGHT) != 0;
    }

    public static boolean isVrControlTurnlampPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.VR_CONTROL_TURNLAMP) != 0;
    }

    public static boolean isWakeUpModePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.WAKE_UP_MODE) != 0;
    }

    public static boolean isWinterLongDistancePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.WINTER_LONG_DISTANCE) != 0;
    }

    public static boolean isWiperMaintanencePresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.WIPER_MAINTANENCE) != 0;
    }

    public static boolean isWirelessChargingPresent() {
        return CarConfig.getConfigValue(ICarConfig.Config.WIRELESS_CHARGING) != 0;
    }

    public static boolean setConfigData(byte[] data) {
        return CarConfig.get().mApi.setSignalValue(0x270B, data);
    }
}

