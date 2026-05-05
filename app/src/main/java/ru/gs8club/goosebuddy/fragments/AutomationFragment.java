package ru.gs8club.goosebuddy.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.yftech.settings.widget.ItemOptionDescribeView;
import com.yftech.settings.widget.ItemSeekBarDescribeView;
import com.yftech.settings.widget.ItemSwitchDescribeView;
import com.yftech.settings.widget.SeekBarNumber;

import ru.gs8club.goosebuddy.BaseFragment;
import ru.gs8club.goosebuddy.R;
import ru.gs8club.goosebuddy.preference.Preference_HeatScenarios;

public class AutomationFragment extends BaseFragment {
    private static final String TAG = "AutomationFragment";
    private static AutomationFragment mInstance;

    private static View mRootView;

    private static Preference_HeatScenarios preference;

    private ItemSwitchDescribeView autoHeatingAfterStartSwitch;
    private ItemSeekBarDescribeView minTemperature;
    private ItemSeekBarDescribeView delayBetweenStarts;

    private ItemSwitchDescribeView turnOnFronDefrost;
    private ItemSwitchDescribeView turnOnRearDefrost;
    private ItemSwitchDescribeView turnOnSteeringWheelHeating;

    private ItemOptionDescribeView heatingFrontLeft;
    private ItemOptionDescribeView heatingFrontRight;
    private ItemOptionDescribeView heatingRearLeft;
    private ItemOptionDescribeView heatingRearRight;

    public AutomationFragment() {
    }

    public static AutomationFragment getInstance() {
        if(mInstance == null) {
            mInstance = new AutomationFragment();
        }
        return mInstance;
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, Bundle bundle0) {
        mRootView = layoutInflater0.inflate(R.layout.fragment_automation, viewGroup0, false);
        preference = Preference_HeatScenarios.getInstance(requireContext());

        initView();
        return mRootView;
    }

    private void updateVisibility(boolean visible) {
        int visibility = visible ? View.VISIBLE : View.GONE;
        minTemperature.setVisibility(visibility);
        delayBetweenStarts.setVisibility(visibility);
        mRootView.findViewById(R.id.heating_group).setVisibility(visibility);
        mRootView.findViewById(R.id.seats_group).setVisibility(visibility);
    }

    private void initView() {
        autoHeatingAfterStartSwitch = mRootView.findViewById(R.id.auto_heating_after_start);
        autoHeatingAfterStartSwitch.setOnSwitchListener(z -> {
            preference.putSwitchOn(z);
            updateVisibility(z);
        });

        minTemperature = mRootView.findViewById(R.id.auto_heating_min_temperature);
        minTemperature.setSeekBarMin(-20);
        minTemperature.setSeekBarMax(-1);
        minTemperature.setOnSeekBarChangeListener(new SeekBarNumber.OnSeekChangeListener() {
                @Override
                public void onProgressChanged(SeekBarNumber seekBarNumber0, int v) {
                    minTemperature.setContentString(v + "°");
                    preference.putMinTemperature(v);
                }

                @Override
                public void onStartTrackingTouch(SeekBarNumber seekBarNumber0) {}
                @Override
                public void onStopTrackingTouch(SeekBarNumber seekBarNumber0) {}
            }
        );

        delayBetweenStarts = mRootView.findViewById(R.id.auto_heating_delay);
        delayBetweenStarts.setSeekBarMin(15);
        delayBetweenStarts.setSeekBarMax(90);

        delayBetweenStarts.setOnSeekBarChangeListener(new SeekBarNumber.OnSeekChangeListener() {
                @Override
                public void onProgressChanged(SeekBarNumber seekBarNumber0, int v) {
                    delayBetweenStarts.setContentString(String.valueOf(v));
                    preference.putDelay(v);
                }
                @Override
                public void onStartTrackingTouch(SeekBarNumber seekBarNumber0) {}
                @Override
                public void onStopTrackingTouch(SeekBarNumber seekBarNumber0) {}
            }
        );

        turnOnFronDefrost = mRootView.findViewById(R.id.front_defrost_turn_on);
        turnOnFronDefrost.setOnSwitchListener(z -> preference.putFrontDefrost(z));

        turnOnRearDefrost = mRootView.findViewById(R.id.rear_defrost_turn_on);
        turnOnRearDefrost.setOnSwitchListener(z -> preference.putRearDefrost(z));

        turnOnSteeringWheelHeating = mRootView.findViewById(R.id.steering_wheel_heating_turn_on);
        turnOnSteeringWheelHeating.setOnSwitchListener(z -> preference.putSteeringWheel(z));

        heatingFrontLeft = mRootView.findViewById(R.id.sh_front_left);
        heatingFrontLeft.setOnSwitchListener((arg1, arg2, arg3, arg4) -> preference.putFrontLeftHeating(arg2));
        heatingFrontRight = mRootView.findViewById(R.id.sh_front_right);
        heatingFrontRight.setOnSwitchListener((arg1, arg2, arg3, arg4) -> preference.putFrontRightHeating(arg2));
        heatingRearLeft = mRootView.findViewById(R.id.sh_rear_left);
        heatingRearLeft.setOnSwitchListener((arg1, arg2, arg3, arg4) -> preference.putRearLeftHeating(arg2));
        heatingRearRight = mRootView.findViewById(R.id.sh_rear_right);
        heatingRearRight.setOnSwitchListener((arg1, arg2, arg3, arg4) -> preference.putRearRightHeating(arg2));
    }

    private void initViewData() {
        autoHeatingAfterStartSwitch.setChecked(preference.getSwitchOn());
        updateVisibility(preference.getSwitchOn());

        minTemperature.setProgress(preference.getMinTemperature());
        minTemperature.setContentString(preference.getMinTemperature() + "°");

        delayBetweenStarts.setProgress(preference.getDelay());
        delayBetweenStarts.setContentString(String.valueOf(preference.getDelay()));

        turnOnFronDefrost.setChecked(preference.getFrontDefrost());
        turnOnRearDefrost.setChecked(preference.getRearDefrost());
        turnOnSteeringWheelHeating.setChecked(preference.getSteeringWheel());

        heatingFrontLeft.setSelectedTab(preference.getFrontLeftHeating());
        heatingFrontRight.setSelectedTab(preference.getFrontRightHeating());
        heatingRearLeft.setSelectedTab(preference.getRearLeftHeating());
        heatingRearRight.setSelectedTab(preference.getRearRightHeating());
    }

    @Override
    public void onResume() {
        super.onResume();
        this.initViewData();
    }
}
