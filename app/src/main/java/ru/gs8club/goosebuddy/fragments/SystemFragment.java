package ru.gs8club.goosebuddy.fragments;

import android.car.Car;
import android.car.hardware.CarPropertyValue;
import android.car.hardware.CarSensorEvent;
import android.car.hardware.CarSensorManager;
import android.car.hardware.hvac.CarHvacManager;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.yftech.vehicle.sdk.CarInfoManager;

import java.util.List;
import java.util.Objects;

import ru.gs8club.goosebuddy.BaseFragment;
import ru.gs8club.goosebuddy.R;

public class SystemFragment extends BaseFragment {
    private static final String TAG = "SystemFragment";
    private static SystemFragment mInstance;
    private TextView intake;

    private CarHvacManager mHvacManager;
    private CarHvacManager.CarHvacEventCallback mHardwareCallback;

    private CarSensorManager.OnSensorChangedListener mListener;
    private Car mCar;

    public SystemFragment() {
    }

    public static SystemFragment getInstance() {
        if (mInstance == null) {
            mInstance = new SystemFragment();
        }
        return mInstance;
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, Bundle bundle0) {
        View root = layoutInflater0.inflate(R.layout.fragment_system, viewGroup0, false);
        this.initView(root);
        return root;
    }

    private void initView(View view0) {
        intake = view0.findViewById(R.id.intake_air_temp);

    }

    private void initViewData() {
        mListener = new CarSensorManager.OnSensorChangedListener() {
            @Override
            public void onSensorChanged(CarSensorEvent arg1) {
                Log.d(TAG, "onSensorChanged " + arg1.toString());
            }
        };

        ServiceConnection mServiceConnection = new ServiceConnection() {
            @Override  // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                try {
//                    service.linkToDeath(HvacController.this.mRestart, 0);
                    mHvacManager = (CarHvacManager)mCar.getCarManager("hvac");
                    assert mHvacManager != null;
                    mHvacManager.registerCallback(mHardwareCallback);

                    CarSensorManager mSensorManager = (CarSensorManager)mCar.getCarManager("sensor");
                    assert mSensorManager != null;
                    mSensorManager.registerListener(mListener, CarSensorManager.SENSOR_TYPE_ENVIRONMENT, CarSensorManager.SENSOR_RATE_FAST);
                    mSensorManager.registerListener(mListener, CarSensorManager.SENSOR_TYPE_ODOMETER, CarSensorManager.SENSOR_RATE_FAST);
                    mSensorManager.registerListener(mListener, CarSensorManager.SENSOR_TYPE_FUEL_LEVEL, CarSensorManager.SENSOR_RATE_FAST);
                    Log.d(TAG, Objects.requireNonNull(mSensorManager.getLatestSensorEvent(CarSensorManager.SENSOR_TYPE_ENVIRONMENT)).toString());
//                    initComponents();
                }
                catch(Exception e) {
                    Log.e(TAG, "Failed to correctly connect to HVAC", e);
                }
            }

            @Override  // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
            }
        };

        mHardwareCallback = new CarHvacManager.CarHvacEventCallback() {
            @Override  // android.car.hardware.hvac.CarHvacManager$CarHvacEventCallback
            public void onChangeEvent(CarPropertyValue val) {
                try {
                    Log.d(TAG, "onChangeEvent " + val.toString());
                } catch (Exception e) {
                    Log.e(TAG, "Failed handling hvac change event", e);
                }
            }

            @Override
            public void onErrorEvent(int arg1, int arg2) {
                Log.e(TAG, "onErrorEvent arg1=" + arg1 + ", arg2=" + arg2);
            }
        };

        Handler mHandler = new Handler();
        mCar = Car.createCar(requireContext(), mServiceConnection, mHandler);
        if(mCar != null) {
            mCar.connect();
        }

        float intakeAir = CarInfoManager.get().getTemperatureOfIntakeAir();
        float engine = CarInfoManager.get().getTemperatureOfEngineWater();
        intake.setText("Intake temperature: " + intakeAir + "\nEngine: " + engine);
    }

    @Override
    public void onResume() {
        super.onResume();
        this.initViewData();
    }
}