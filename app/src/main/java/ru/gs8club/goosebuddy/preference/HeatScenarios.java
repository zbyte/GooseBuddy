package ru.gs8club.goosebuddy.preference;

import com.skydoves.preferenceroom.KeyName;
import com.skydoves.preferenceroom.PreferenceEntity;

@PreferenceEntity("HeatScenarios")
public class HeatScenarios {
    @KeyName("switchOn") protected final boolean switchOn = false;
    @KeyName("minTemperature") protected final int minTemp = -5;
    @KeyName("delay") protected final int delay = 60;

    @KeyName("frontDefrost")  protected final boolean frontDefrost = true;
    @KeyName("rearDefrost")  protected final boolean rearDefrost = true;
    @KeyName("steeringWheel")  protected final boolean steeringWheel = true;
    @KeyName("frontLeftHeating") protected final int flHeating = 3;
    @KeyName("frontRightHeating") protected final int frHeating = 3;
    @KeyName("rearLeftHeating") protected final int rlHeating = 0;
    @KeyName("rearRightHeating") protected final int rrHeating = 0;
}
