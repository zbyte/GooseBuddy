package ru.gs8club.goosebuddy;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.yftech.vehicle.internal.adapter.ICarInfo;
import com.yftech.vehicle.internal.adapter.ICarInfo.PowerMode;
import com.yftech.vehicle.sdk.CarInfoManager;

public class BaseActivity extends AppCompatActivity {
    class BaseReceiver extends BroadcastReceiver {
        private BaseReceiver() {
        }

        BaseReceiver(BaseReceiver baseActivity$10) {
        }

        @Override  // android.content.BroadcastReceiver
        public void onReceive(Context context0, Intent intent0) {
            if("com.yftech.intent.action.exit.application".equals(intent0.getAction())) {
                String s = intent0.getStringExtra("exit.package.name");
                Log.i("BaseActivity", "onReceive() EXIT_APPLICATION_BROADCAST_ACTION packageName:" + s);
                if("com.yftech.settings".equals(s)) {
                    Log.i("BaseActivity", "onReceive() finish");
                    BaseActivity.this.finish();
                }
            }
        }
    }

    private BaseReceiver mBaseReceiver;
    private Toast mPowerToast;

    protected String getPowerToastStr() {
        return "??????????";
    }

    public boolean isPower() {
        ICarInfo.PowerMode iCarInfo$PowerMode0 = CarInfoManager.get().getPowerMode();
        return iCarInfo$PowerMode0 == ICarInfo.PowerMode.ON || iCarInfo$PowerMode0 == ICarInfo.PowerMode.CRANK;
    }

    @Override  // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.mBaseReceiver = new BaseReceiver(null);
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("com.yftech.intent.action.exit.application");
        ContextCompat.registerReceiver(this, this.mBaseReceiver, intentFilter0, ContextCompat.RECEIVER_NOT_EXPORTED);
    }

    @Override  // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(this.mBaseReceiver);
    }

    public void showPowerToast() {
        if(this.mPowerToast != null) {
            this.mPowerToast.cancel();
            this.mPowerToast = null;
        }
        this.mPowerToast = Toast.makeText(this, this.getPowerToastStr(), Toast.LENGTH_LONG);
        this.mPowerToast.show();
    }

}

