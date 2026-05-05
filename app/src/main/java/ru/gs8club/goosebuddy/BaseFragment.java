package ru.gs8club.goosebuddy;

import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment /*implements View.OnTouchListener*/ {
    private boolean mIsPower;

    protected void dismissAllDialog() {
    }

    @Override  // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.dismissAllDialog();
    }

    /*@Override
    public boolean onTouch(View view0, MotionEvent motionEvent0) {
        if(motionEvent0.getAction() == 0) {
            this.mIsPower = ((BaseActivity)this.getActivity()).isPower();
            if(!this.mIsPower) {
                ((BaseActivity)this.getActivity()).showPowerToast();
                Utils.playKeySoundEffect(this.getContext());
                return true;
            }
            return false;
        }
        return !this.mIsPower && motionEvent0.getAction() == 2 || !this.mIsPower && motionEvent0.getAction() == 1;
    }*/
}

