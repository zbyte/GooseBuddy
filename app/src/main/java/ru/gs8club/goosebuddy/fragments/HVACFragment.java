package ru.gs8club.goosebuddy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.yftech.settings.widget.ItemOptionDescribeView;
import com.yftech.settings.widget.ItemSeekBarNumIconView;
import com.yftech.settings.widget.ItemSwitchDescribeView;
import com.yftech.settings.widget.SeekBarNumber;

import ru.gs8club.goosebuddy.BaseFragment;
import ru.gs8club.goosebuddy.R;
import ru.gs8club.goosebuddy.preference.Preference_HVAC;

public class HVACFragment extends BaseFragment {
    private static final String TAG = "HVACFragment";
    private static HVACFragment mInstance;

    private static Preference_HVAC preference;

    private ItemSwitchDescribeView defrostDecreaseWindSpeedSwitch;
    private ItemOptionDescribeView optionWindSpeed;
    private ItemSwitchDescribeView defrostAutoSwitchOffSwitch;
    private ItemSeekBarNumIconView defrostAutoSwitchOffTime;
    private ItemSwitchDescribeView steeringWheelSwitchOff;
    private ItemSeekBarNumIconView steeringWheelSwitchOffTime;
    private ItemSwitchDescribeView seatHeatingSwitchOff;
    private ItemSeekBarNumIconView seatHeatingSwitchOffTime;

    public HVACFragment() {
    }

    public static HVACFragment getInstance() {
        if(mInstance == null) {
            mInstance = new HVACFragment();
        }
        return mInstance;
    }

    private void initView(View view0) {
        defrostDecreaseWindSpeedSwitch = view0.findViewById(R.id.hvac_defrost_decrease_wind_speed_enabled);
        defrostDecreaseWindSpeedSwitch.setOnSwitchListener(z -> {
            preference.putDecreaseSpeed(z);
            optionWindSpeed.setVisibility(z?View.VISIBLE:View.GONE);
        });

        optionWindSpeed = view0.findViewById(R.id.hvac_defrost_decrease_wind_speed);
        optionWindSpeed.setOnSwitchListener((arg1, arg2, arg3, arg4) -> preference.putWindSpeed(arg2));

        defrostAutoSwitchOffSwitch = view0.findViewById(R.id.hvac_defrost_auto_switchoff_enabled);
        defrostAutoSwitchOffSwitch.setOnSwitchListener(z -> {
            preference.putDefrostSwitchoff(z);
            defrostAutoSwitchOffTime.setVisibility(z?View.VISIBLE:View.GONE);
        });

        defrostAutoSwitchOffTime = view0.findViewById(R.id.hvac_defrost_auto_switchoff_time);
        defrostAutoSwitchOffTime.setSeekBarMin(1);
        defrostAutoSwitchOffTime.setSeekBarMax(20);
        defrostAutoSwitchOffTime.setOnSeekBarChangeListener(new SeekBarNumber.OnSeekChangeListener() {
              @Override
              public void onProgressChanged(SeekBarNumber seekBarNumber0, int v) {
                  defrostAutoSwitchOffTime.setContentString(String.valueOf(v));

                  preference.putDefrostTime(v);
              }

              @Override
              public void onStartTrackingTouch(SeekBarNumber seekBarNumber0) {
              }
              @Override
              public void onStopTrackingTouch(SeekBarNumber seekBarNumber0) {
              }
          }
        );

        steeringWheelSwitchOff = view0.findViewById(R.id.steering_wheel_heating_auto_off_switch);
        steeringWheelSwitchOff.setOnSwitchListener(z -> {
            preference.putSteeringWheelSwitchoff(z);

            steeringWheelSwitchOffTime.setVisibility(z?View.VISIBLE:View.GONE);
        });

        steeringWheelSwitchOffTime = view0.findViewById(R.id.steering_wheel_heating_auto_off_time);
        steeringWheelSwitchOffTime.setSeekBarMin(1);
        steeringWheelSwitchOffTime.setSeekBarMax(20);
        steeringWheelSwitchOffTime.setOnSeekBarChangeListener(new SeekBarNumber.OnSeekChangeListener() {
              @Override
              public void onProgressChanged(SeekBarNumber seekBarNumber0, int v) {
                  steeringWheelSwitchOffTime.setContentString(String.valueOf(v));

                  preference.putSteeringWheelTime(v);
              }

              @Override
              public void onStartTrackingTouch(SeekBarNumber seekBarNumber0) {
              }
              @Override
              public void onStopTrackingTouch(SeekBarNumber seekBarNumber0) {
              }
          }
        );

        seatHeatingSwitchOff = view0.findViewById(R.id.seat_heating_auto_off_switch);
        seatHeatingSwitchOff.setOnSwitchListener(z -> {
            preference.putSeatHeatingSwitchoff(z);
            seatHeatingSwitchOffTime.setVisibility(z ? View.VISIBLE : View.GONE);
        });

        seatHeatingSwitchOffTime = view0.findViewById(R.id.seat_heating_auto_off_time);
        seatHeatingSwitchOffTime.setSeekBarMin(1);
        seatHeatingSwitchOffTime.setSeekBarMax(60);
        seatHeatingSwitchOffTime.setOnSeekBarChangeListener(new SeekBarNumber.OnSeekChangeListener() {
              @Override
              public void onProgressChanged(SeekBarNumber seekBarNumber0, int v) {
                  seatHeatingSwitchOffTime.setContentString(String.valueOf(v));

                  preference.putSeatHeatingTime(v);
              }

              @Override
              public void onStartTrackingTouch(SeekBarNumber seekBarNumber0) {
              }
              @Override
              public void onStopTrackingTouch(SeekBarNumber seekBarNumber0) {
              }
          }
        );
    }

    private void initViewData() {
        boolean decreaseSpeedEnabled = preference.getDecreaseSpeed();
        defrostDecreaseWindSpeedSwitch.setChecked(decreaseSpeedEnabled);

        int speedFromPrefs = preference.getWindSpeed();
        if (speedFromPrefs < 0 || speedFromPrefs > 6) {
            speedFromPrefs = 2;
            preference.putWindSpeed(speedFromPrefs);
        }
        optionWindSpeed.setSelectedTab(speedFromPrefs);
        optionWindSpeed.setVisibility(decreaseSpeedEnabled?View.VISIBLE:View.GONE);

        boolean defrostSwitchOff = preference.getDefrostSwitchoff();
        defrostAutoSwitchOffSwitch.setChecked(defrostSwitchOff);
        int defrostSwitchOffTime = preference.getDefrostTime();
        defrostAutoSwitchOffTime.setProgress(defrostSwitchOffTime);
        defrostAutoSwitchOffTime.setContentString(String.valueOf(defrostSwitchOffTime));
        defrostAutoSwitchOffTime.setVisibility(defrostSwitchOff?View.VISIBLE:View.GONE);

        boolean steeringWheelSwitchOffEnabled = preference.getSteeringWheelSwitchoff();
        steeringWheelSwitchOff.setChecked(steeringWheelSwitchOffEnabled);

        int switchOfftime = preference.getSteeringWheelTime();
        steeringWheelSwitchOffTime.setProgress(switchOfftime);
        steeringWheelSwitchOffTime.setContentString(String.valueOf(switchOfftime));

        steeringWheelSwitchOffTime.setVisibility(steeringWheelSwitchOffEnabled?View.VISIBLE:View.GONE);

        boolean seatHeatingSwitchOffEnabled = preference.getSeatHeatingSwitchoff();
        seatHeatingSwitchOff.setChecked(seatHeatingSwitchOffEnabled);

        int seatSwitchOffTime = preference.getSeatHeatingTime();
        seatHeatingSwitchOffTime.setProgress(seatSwitchOffTime);
        seatHeatingSwitchOffTime.setContentString(String.valueOf(seatSwitchOffTime));

        seatHeatingSwitchOffTime.setVisibility(seatHeatingSwitchOffEnabled?View.VISIBLE:View.GONE);
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, Bundle bundle0) {
        View root = layoutInflater0.inflate(R.layout.fragment_achelpers, viewGroup0, false);
        preference = Preference_HVAC.getInstance(requireContext());

        this.initView(root);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.initViewData();
    }
}

