package ru.gs8club.goosebuddy;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import ru.gs8club.goosebuddy.fragments.AutomationFragment;
import ru.gs8club.goosebuddy.fragments.HVACFragment;
import ru.gs8club.goosebuddy.fragments.SystemFragment;
import ru.gs8club.goosebuddy.preference.Preference_Main;

public class SettingsActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "SettingsActivity";
    private static final int TAB_ACHELPERS = 0;
    private static final int TAB_AUTOMATION = 1;
    private static final int TAB_SYSTEM = 2;
    private static final String TAG_ACHELPERS = "achelpers";
    private static final String TAG_AUTOMATION = "automation";
    private static final String TAG_SYSTEM = "system";
    private RelativeLayout mCheckTab;
    private int mTabId;
    private RelativeLayout tabAutomation;
    private RelativeLayout tabACHelpers;
    private RelativeLayout tabSystem;

    private static Preference_Main preference;

    public SettingsActivity() {
    }

    @Override
    public void onClick(View view0) {
        if(Utils.isTabQuickClick()) {
            Log.i(TAG, "onClick, isTabQuickClick");
            return;
        }
        if (view0.getId() == R.id.tabAutomation) {
                if(mCheckTab != tabAutomation) {
                    showTabFragment(TAB_AUTOMATION);
                    mCheckTab.setSelected(false);
                    tabAutomation.setSelected(true);
                    mCheckTab = tabAutomation;
                    mTabId = TAB_AUTOMATION;
                }
            }
        else if (view0.getId() == R.id.tabACHelpers) {
                if(mCheckTab != tabACHelpers) {
                    showTabFragment(TAB_ACHELPERS);
                    mCheckTab.setSelected(false);
                    tabACHelpers.setSelected(true);
                    mCheckTab = tabACHelpers;
                    mTabId = TAB_ACHELPERS;
                }
            }
        else if (view0.getId() == R.id.tabSystem)  {
                if(mCheckTab != tabSystem) {
                    showTabFragment(TAB_SYSTEM);
                    mCheckTab.setSelected(false);
                    tabSystem.setSelected(true);
                    mCheckTab = tabSystem;
                    mTabId = TAB_SYSTEM;
                }
            }
        else {
            Log.e(TAG, "Unknow tab click");
            return;
        }
        preference.putSelectedTab(mTabId);
    }

    @Override
    protected void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);

        setContentView(R.layout.activity_settings);

        tabACHelpers = findViewById(R.id.tabACHelpers);
        tabACHelpers.setOnClickListener(this);

        tabAutomation = findViewById(R.id.tabAutomation);
        tabAutomation.setOnClickListener(this);

        tabSystem = findViewById(R.id.tabSystem);
        tabSystem.setOnClickListener(this);

        preference = Preference_Main.getInstance(this);

        mTabId = preference.getSelectedTab();
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
//            SettingsApp.getInstance().clearActivityList();
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
        Log.i(TAG, "onResume, tabId:" + mTabId);
        mTabId = preference.getSelectedTab();
        setChooseTab(mTabId);
        showTabFragment(mTabId);
    }

    private void setChooseTab(int tab) {
        RelativeLayout relativeLayout0 = null;

        switch(tab) {
            case TAB_ACHELPERS: {
                relativeLayout0 = tabACHelpers;
                mTabId = TAB_ACHELPERS;
                break;
            }
            case TAB_AUTOMATION: {
                relativeLayout0 = tabAutomation;
                mTabId = TAB_AUTOMATION;
                break;
            }
            case TAB_SYSTEM: {
                relativeLayout0 = tabSystem;
                mTabId = TAB_SYSTEM;
                break;
            }
            default: {
                relativeLayout0 = tabACHelpers;
                mTabId = TAB_ACHELPERS;
            }
        }

        if(mCheckTab != null) {
            mCheckTab.setSelected(false);
        }
        mCheckTab = relativeLayout0;
        mCheckTab.setSelected(true);
    }

    public void showTabFragment(int v) {
        String s;
        Fragment fragmentToShow = null;
        switch(v) {
            case TAB_ACHELPERS: {
                fragmentToShow = HVACFragment.getInstance();
                s = TAG_ACHELPERS;
                break;
            }
            case TAB_AUTOMATION: {
                fragmentToShow = AutomationFragment.getInstance();
                s = TAG_AUTOMATION;
                break;
            }
            case TAB_SYSTEM: {
                fragmentToShow = SystemFragment.getInstance();
                s = TAG_SYSTEM;
                break;
            }
            default: {
                s = null;
            }
        }
        if (fragmentToShow != null) {
            FragmentManager fragmentManager0 =  getSupportFragmentManager();
            Log.i(TAG, "showTabFragment, tabId:" + v + ", tag:" + s + ", exist:" + (fragmentManager0.findFragmentByTag(s) != null) + ", count:" + fragmentManager0.getBackStackEntryCount() + ", destroy:" + fragmentManager0.isDestroyed());
            fragmentManager0.beginTransaction().replace(R.id.container, fragmentToShow, s).commit();
        }
    }
}

