package ru.gs8club.goosebuddy;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.core.app.NotificationCompat;

import com.yftech.vehicle.internal.adapter.IAirCondition;
import com.yftech.vehicle.internal.adapter.ICarInfo;
import com.yftech.vehicle.internal.adapter.ICarSeat;
import com.yftech.vehicle.internal.adapter.ICarSwc;
import com.yftech.vehicle.sdk.AirConditionManager;
import com.yftech.vehicle.sdk.CarInfoManager;
import com.yftech.vehicle.sdk.CarMiscManager;
import com.yftech.vehicle.sdk.CarSeatManager;
import com.yftech.vehicle.sdk.CarSwcManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import ru.gs8club.goosebuddy.preference.Preference_HVAC;
import ru.gs8club.goosebuddy.preference.Preference_HeatScenarios;
import ru.gs8club.goosebuddy.preference.Preference_Main;

public class CarService extends Service {
    private static final String TAG = "GooseCarService";
    private static final String CHANNEL_ID = "GooseBackgroundChannel";

    private Preference_HVAC preferenceHvac;

    private Preference_HeatScenarios preferenceHeatScenarios;

    private Preference_Main preferenceMain;

    private AirConditionManager.AirConditionListener mACListener;

    private CarInfoManager.CarInfoListener mCarInfoListener;

    private CarSwcManager.CarSwcListener mCarSwcListener;

    private CarSeatManager.CarSeatListener mCarSeatListener;

    private ScheduledExecutorService scheduler;

    private ScheduledFuture<?> taskSwitchOffSWH = null;
    private ScheduledFuture<?> taskSwitchOffFrontDefrost = null;
    private ScheduledFuture<?> taskSwitchOffSeatFL = null;
    private ScheduledFuture<?> taskSwitchOffSeatFR = null;
    private ScheduledFuture<?> taskSwitchOffSeatRL = null;
    private ScheduledFuture<?> taskSwitchOffSeatRR = null;

    private boolean stateFrontDefrostEnabled = false;
    private boolean stateWindSpeedWasChanged = false;

    private long frontDefrostEnabledTime;

    private long lastStartTimestamp = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        scheduler = Executors.newScheduledThreadPool(10);
        startInForeground();
        preferenceMain = Preference_Main.getInstance(this);
        preferenceHvac = Preference_HVAC.getInstance(this);
        preferenceHeatScenarios = Preference_HeatScenarios.getInstance(this);
        Log.d(TAG, "Service created");
    }

    private void startInForeground() {
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,  "Background Service", NotificationManager.IMPORTANCE_LOW);

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.createNotificationChannel(channel);
        } else {
            Log.d(TAG, "startInForeground: can`t get notification service");
        }

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Service running")
                .setContentText("Background processing active")
                .setSmallIcon(R.drawable.ic_menu_slideshow)
                .build();

        startForeground(1, notification);

        Log.d(TAG, "Service started in foreground");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        CarMiscManager.get().setFactoryModeDevelopModeEnabled(true, false);
        Log.d(TAG, "Wheel " + String.valueOf(CarSwcManager.get().getSwcAngle()));
        mCarInfoListener = new CarInfoManager.CarInfoListener() {
            @Override
            public void onTemperatureOfIntakeAirChanged(float value) {
                Log.d(TAG, "Temperature Of Intake Air Changed: " + value);
            }

            public void onPowerModeChanged(ICarInfo.PowerMode powerMode) {
                Log.d(TAG,"onPowerModeChanged:" + powerMode);
            }

            @Override
            public void onBatteryVoltageChanged(float voltage) {
//                Log.d(TAG, "Battery voltage: " + voltage);
            }

            @Override
            public void onPressureOfAtmosphericChanged(int value) {
                Log.d(TAG, "onPressureOfAtmosphericChanged: " + value);
            }

            @Override
            public void onPressureOfOilChanged(int value) {
                Log.d(TAG, "onPressureOfOilChanged: " + value);
            }

            @Override
            public void onTemperatureOfEngineWaterChanged(int value) {
                Log.d(TAG, "onTemperatureOfEngineWaterChanged: " + value);
            }

            @Override
            public void onTemperatureOfTransmissionOilChanged(int value) {
                Log.d(TAG, "onTemperatureOfTransmissionOilChanged: " + value);
            }

            @Override
            public void onTemperatureOfExhaustChanged(int value) {
                Log.d(TAG, "onTemperatureOfExhaustChanged " + value);
            }

            @Override
            public void onCarReadyIndicatorChanged(ICarInfo.CarReadyIndicator indicator) {
                Log.d(TAG, "onCarReadyIndicatorChanged: " + indicator);
            }

            @Override
            public void onPressureOfTurbineChanged(int value) {
                Log.d(TAG, "onPressureOfTurbineChanged: " + value);
            }

            @Override
            public void onVehicleStateChanged(ICarInfo.VehicleState state) {
                Log.d(TAG, "onVehicleStateChanged: " + state);
            }

            @Override
            public void onGearPositionChanged(ICarInfo.GearPosition gear) {
                Log.d(TAG, "onGearPositionChanged: " + gear);
            }

            @Override
            public void onVehicleSpeedChanged(int speed) {
                Log.d(TAG, "onVehicleSpeedChanged: " + speed);
            }

            @Override
            public void onTotalOdometerChanged(int total) {
                Log.d(TAG, "onTotalOdometerChanged " + total);
            }
        };
        Log.i(TAG, "Register car info listener");
        CarInfoManager.get().registerListener(mCarInfoListener);

        mACListener = new AirConditionManager.AirConditionListener() {
            @Override
            public void onEnvironmentTemperatureChanged(float temp) {
                Log.d(TAG, "onEnvironmentTemperatureChanged: " + temp);
            }

            @Override
            public void onFrontDefrostStateChanged(boolean isEnabled) {
                Log.d(TAG, "FrontDefrostStateChanged: " + isEnabled);
            }

            @Override
            public void onWindModeChanged(IAirCondition.WindMode mode) {
                Log.d(TAG, "Wind mode changed to " + mode);

                stateFrontDefrostEnabled = mode == IAirCondition.WindMode.DEFROST;
                boolean decreaseSpeedEnabledInSettings = preferenceHvac.getDecreaseSpeed();
                if (stateFrontDefrostEnabled) {
                    if (decreaseSpeedEnabledInSettings) {
                        stateWindSpeedWasChanged = false;
                        frontDefrostEnabledTime = System.currentTimeMillis();
                    }

                    if (preferenceHvac.getDefrostSwitchoff()) {
                        int switchOffTime = preferenceHvac.getDefrostTime();
                        Log.d(TAG, "Auto switch off front defrost enabled. Set timer to " + switchOffTime + " minutes.");
                        taskSwitchOffFrontDefrost = scheduler.schedule(() -> {
                            taskSwitchOffFrontDefrost = null;
                            Log.d(TAG, "Switch off front defrost timer raised");
                            if (AirConditionManager.get().getWindMode() == IAirCondition.WindMode.DEFROST) {
                                AirConditionManager.get().performFrontDefrostButtonClick();
                                Log.d(TAG, "Front defrost switched off");
                            } else {
                                Log.d(TAG, "Front defrost already switch off. Nothing to do.");
                            }
                        }, switchOffTime, TimeUnit.MINUTES);
                    }
                } else {
                    if (taskSwitchOffFrontDefrost != null) {
                        taskSwitchOffFrontDefrost.cancel(false);
                        taskSwitchOffFrontDefrost = null;
                    }
                    frontDefrostEnabledTime = 0;
                }
            }

            @Override
            public void onWindSpeedChanged(IAirCondition.WindSpeed speed) {
                Log.d(TAG, "Wind speed changed to " + speed.value);

                if (preferenceHvac.getDecreaseSpeed() &&
                        stateFrontDefrostEnabled &&
                        speed == IAirCondition.WindSpeed.LEVEL_6 &&
                        (System.currentTimeMillis() - frontDefrostEnabledTime) < 5000 &&
                        !stateWindSpeedWasChanged)  {
                    int decreaseSpeed = preferenceHvac.getWindSpeed();
                    AirConditionManager.get().setWindSpeed(IAirCondition.WindSpeed.valueOf(decreaseSpeed + 1));
                    stateWindSpeedWasChanged = true;
                    frontDefrostEnabledTime = 0;

                    Log.d(TAG, "Decrease speed to " + (decreaseSpeed + 1));
                }
            }
        };
        Log.i(TAG, "Register air conditioner listener");
        AirConditionManager.get().registerListener(mACListener);

        mCarSwcListener = new CarSwcManager.CarSwcListener() {
            @Override
            public void onSwcHeatStateChanged(ICarSwc.SwcHeatState state) {
                Log.d(TAG, "Steering wheel heating state changed to: " + state);
                if (state == ICarSwc.SwcHeatState.HEATING) {
                    if (taskSwitchOffSWH == null) {
                        if (preferenceHvac.getSteeringWheelSwitchoff()) {
                            int switchTime = preferenceHvac.getSteeringWheelTime();

                            taskSwitchOffSWH = scheduler.schedule(() -> {
                                taskSwitchOffSWH = null;
                                CarSwcManager.get().setSwcHeatStateEnabled(false);
                            }, switchTime, TimeUnit.MINUTES);
                        }
                    } else {
                        Log.w(TAG, "Somethings wrong. Scheduler not null");
                    }
                } else if (state == ICarSwc.SwcHeatState.OFF) {
                    if (taskSwitchOffSWH != null) {
                        taskSwitchOffSWH.cancel(false);
                        taskSwitchOffSWH = null;
                    }
                }
            }
        };
        CarSwcManager.get().registerListener(mCarSwcListener);

        mCarSeatListener = new CarSeatManager.CarSeatListener() {
            @Override
            public void onHeatLevelFLChanged(ICarSeat.HeatLevel level) {
                taskSwitchOffSeatFL = handleSeatHeatChange("FL", level, taskSwitchOffSeatFL,
                        () -> switchOffSeat("FL",
                                CarSeatManager.get()::setHeatLevelFL,
                                CarSeatManager.get()::setHeatVentModeFL));
            }

            @Override
            public void onHeatLevelFRChanged(ICarSeat.HeatLevel level) {
                taskSwitchOffSeatFR = handleSeatHeatChange("FR", level, taskSwitchOffSeatFR,
                        () -> switchOffSeat("FR",
                                CarSeatManager.get()::setHeatLevelFR,
                                CarSeatManager.get()::setHeatVentModeFR));
            }

            @Override
            public void onHeatLevelRLChanged(ICarSeat.HeatLevel level) {
                taskSwitchOffSeatRL = handleSeatHeatChange("RL", level, taskSwitchOffSeatRL,
                        () -> switchOffSeat("RL",
                                CarSeatManager.get()::setHeatLevelRL,
                                CarSeatManager.get()::setHeatVentModeRL));
            }

            @Override
            public void onHeatLevelRRChanged(ICarSeat.HeatLevel level) {
                taskSwitchOffSeatRR = handleSeatHeatChange("RR", level, taskSwitchOffSeatRR,
                        () -> switchOffSeat("RR",
                                CarSeatManager.get()::setHeatLevelRR,
                                CarSeatManager.get()::setHeatVentModeRR));
            }
        };
        CarSeatManager.get().registerListener(mCarSeatListener);

        scheduler.schedule(this::StartHeatScenarios, 30, TimeUnit.SECONDS);

        return START_STICKY;
    }

    private ScheduledFuture<?> handleSeatHeatChange(String tag, ICarSeat.HeatLevel level,
                                                   ScheduledFuture<?> currentTask, Runnable switchOff) {
        Log.d(TAG, "Seat " + tag + " heat level changed to: " + level);
        boolean heating = level == ICarSeat.HeatLevel.LEVEL_1
                || level == ICarSeat.HeatLevel.LEVEL_2
                || level == ICarSeat.HeatLevel.LEVEL_3;

        if (currentTask != null) {
            currentTask.cancel(false);
            currentTask = null;
        }

        if (heating && preferenceHvac.getSeatHeatingSwitchoff()) {
            int switchTime = preferenceHvac.getSeatHeatingTime();
            Log.d(TAG, "Schedule seat " + tag + " auto off in " + switchTime + " min");
            currentTask = scheduler.schedule(switchOff, switchTime, TimeUnit.MINUTES);
        }
        return currentTask;
    }

    private void switchOffSeat(String tag,
                               java.util.function.Function<ICarSeat.HeatLevel, Boolean> setLevel,
                               java.util.function.Function<ICarSeat.HeatVentMode, Boolean> setMode) {
        Log.d(TAG, "Auto switch off seat " + tag);
        setLevel.apply(ICarSeat.HeatLevel.OFF);
        setMode.apply(ICarSeat.HeatVentMode.OFF);
    }

    private void StartHeatScenarios() {
        float environmentTemperature = AirConditionManager.get().getEnvironmentTemperature();
        double tftTemperature = readTFTTemperature();

        int minTemperature = preferenceHeatScenarios.getMinTemperature();
        Log.d(TAG, "Temperature Of Environment: " + environmentTemperature + ". TFT temperature " + tftTemperature +". Min temperature to heat: " + minTemperature);

        if (lastStartTimestamp == 0) {
            lastStartTimestamp = preferenceMain.getLastRun();
        }

        long currentTimestamp = java.time.Instant.now().getEpochSecond();
        long diff = currentTimestamp - lastStartTimestamp;
        long delay = preferenceHeatScenarios.getDelay() * 60L;
        Log.d(TAG, "Last run: " + lastStartTimestamp + ", current time: " + currentTimestamp + ", diff: " + diff + ", delay: " + delay);

        if (preferenceHeatScenarios.getSwitchOn() &&
                (minTemperature >= environmentTemperature) &&
                (diff >= delay)) {
            Log.d(TAG, "Start heat scenarios");
            if (preferenceHeatScenarios.getFrontDefrost()) {
                if (AirConditionManager.get().getWindMode() != IAirCondition.WindMode.DEFROST) {
                    AirConditionManager.get().performFrontDefrostButtonClick();
                    Log.d(TAG, "Front defrost switched on");
                }
            }

            if (preferenceHeatScenarios.getRearDefrost() && !(AirConditionManager.get().isRearDefrostEnabled())) {
                AirConditionManager.get().performRearDefrostButtonClick();
                Log.d(TAG, "Rear defrost switched on");
            }

            if (preferenceHeatScenarios.getSteeringWheel()) {
                CarSwcManager.get().setSwcHeatStateEnabled(true);
                Log.d(TAG, "Steering Wheel heating switched on");
            }

            CarSeatManager seatManager = CarSeatManager.get();
            if (preferenceHeatScenarios.getFrontLeftHeating() > 0) {
                seatManager.setHeatVentModeFL(ICarSeat.HeatVentMode.HEAT_MODE);
                seatManager.setHeatLevelFL(ICarSeat.HeatLevel.valueOf(preferenceHeatScenarios.getFrontLeftHeating()));
            }

            if (preferenceHeatScenarios.getFrontRightHeating() > 0) {
                seatManager.setHeatVentModeFR(ICarSeat.HeatVentMode.HEAT_MODE);
                seatManager.setHeatLevelFR(ICarSeat.HeatLevel.valueOf(preferenceHeatScenarios.getFrontRightHeating()));
            }

            if (preferenceHeatScenarios.getRearLeftHeating() > 0) {
                seatManager.setHeatVentModeRL(ICarSeat.HeatVentMode.HEAT_MODE);
                seatManager.setHeatLevelRL(ICarSeat.HeatLevel.valueOf(preferenceHeatScenarios.getRearLeftHeating()));
            }

            if (preferenceHeatScenarios.getRearRightHeating() > 0) {
                seatManager.setHeatVentModeRR(ICarSeat.HeatVentMode.HEAT_MODE);
                seatManager.setHeatLevelRR(ICarSeat.HeatLevel.valueOf(preferenceHeatScenarios.getRearRightHeating()));
            }
        }

        lastStartTimestamp = java.time.Instant.now().getEpochSecond();
        preferenceMain.putLastRun(lastStartTimestamp);
    }

    private double readTFTTemperature() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/sys/bus/iio/devices/iio:device0/in_voltage0_input"));

            String s = reader.readLine();
            if (s == null) {
                Log.d(TAG, "Unable to read data");
                return 0.0;
            }

            double f = Double.parseDouble(s);
            if (f < 0.0) {
                Log.d(TAG, "Invalid TFT temperature value " + f);
                return 0.0;
            }

            double V = (f * 1.8) / 4096.0;

            double T;
            if (V > 1.11385) {
                T = V * -110.43 + 193.08;
            } else {
                T = V * -78.389 + 154.31;
            }
            return Math.round(T * 100.0) / 100.0;

        } catch (IOException | NumberFormatException e) {
            Log.e(TAG, "Can`t read TFT temperature", e);
        }

        return 0.0;
    }

    @Override
    public IBinder onBind(Intent intent) { return null; }

    @Override
    public void onDestroy() {
        super.onDestroy();
        CarInfoManager.get().unregisterListener(mCarInfoListener);
        AirConditionManager.get().unregisterListener(mACListener);
        CarSwcManager.get().unregisterListener(mCarSwcListener);
        CarSeatManager.get().unregisterListener(mCarSeatListener);

        scheduler.shutdownNow();

        Log.d(TAG, "Service destroyed");
    }
}

