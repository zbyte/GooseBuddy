package ru.zbyte.goosebuddy.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.yftech.vehicle.internal.adapter.IAirCondition;
import com.yftech.vehicle.sdk.AirConditionManager;

import ru.zbyte.goosebuddy.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    protected Handler mHandler;

    private AirConditionManager.AirConditionListener listener;

    private int mDefrostStatus = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.defrostStatus;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        this.mHandler = new Handler(Looper.getMainLooper());

        boolean frontDefrost = AirConditionManager.get().isFrontDefrostEnabled();
        binding.defrostStatus.setText("Front defrost status: " + frontDefrost);

        int windSpeed = AirConditionManager.get().getWindSpeed().value;
        binding.windSpeed.setText("Wind speed: " + windSpeed);

        AirConditionManager.get().registerListener(this.listener);

        this.listener = new AirConditionManager.AirConditionListener() {
            @Override
            public void onFrontDefrostStateChanged(boolean isEnabled) {
                Log.d("Buddy", "FrontDefrostStateChanged: " + isEnabled);
                HomeFragment.this.mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        binding.defrostStatus.setText("Front defrost status: " + isEnabled);
                    }
                });
            }

            @Override
            public void onWindSpeedChanged(IAirCondition.WindSpeed speed) {
                Log.d("Buddy", "Wind speed changed to " + speed.value);
                HomeFragment.this.mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        binding.windSpeed.setText("Wind speed: " + speed.value);
                    }
                });
            }
        };

        binding.switchFrontDefrost.setOnClickListener(v -> {
            AirConditionManager.get().performFrontDefrostButtonClick();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}