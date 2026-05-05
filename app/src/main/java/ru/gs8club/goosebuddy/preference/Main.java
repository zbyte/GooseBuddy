package ru.gs8club.goosebuddy.preference;

import com.skydoves.preferenceroom.KeyName;
import com.skydoves.preferenceroom.PreferenceEntity;

@PreferenceEntity("Main")
public class Main {
    @KeyName("selectedTab") protected final int tabId = 0;

    @KeyName("lastRun") protected final long lastRun = 0;
}
