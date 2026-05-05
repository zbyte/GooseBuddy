package ru.gs8club.goosebuddy.preference;

import com.skydoves.preferenceroom.KeyName;
import com.skydoves.preferenceroom.PreferenceEntity;

@PreferenceEntity("HVAC")
public class Hvac {
    @KeyName("decreaseSpeed") protected final boolean decreaseSpeed = true;
    @KeyName("windSpeed") protected final int minTemp = 2;

    @KeyName("defrostSwitchoff") protected final boolean defrostSwitchoff = true;

    @KeyName("defrostTime") protected final int defrostTime = 5;

    @KeyName("steeringWheelSwitchoff") protected final boolean steeringWheelSwitchoff = true;

    @KeyName("steeringWheelTime") protected final int steeringWheelTime = 5;

    @KeyName("seatHeatingSwitchoff") protected final boolean seatHeatingSwitchoff = true;

    @KeyName("seatHeatingTime") protected final int seatHeatingTime = 10;
}
