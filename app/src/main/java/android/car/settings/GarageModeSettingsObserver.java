package android.car.settings;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import java.lang.ref.WeakReference;

public abstract class GarageModeSettingsObserver extends ContentObserver {
    public static final Uri GARAGE_MODE_ENABLED_URI = Settings.Global.getUriFor("android.car.GARAGE_MODE_ENABLED");
    public static final Uri GARAGE_MODE_MAINTENANCE_WINDOW_URI = Settings.Global.getUriFor("android.car.GARAGE_MODE_MAINTENANCE_WINDOW");
    public static final Uri GARAGE_MODE_WAKE_UP_TIME_URI = Settings.Global.getUriFor("android.car.GARAGE_MODE_WAKE_UP_TIME");
    public static final Uri[] GARAGE_SETTING_URIS = new Uri[]{GarageModeSettingsObserver.GARAGE_MODE_ENABLED_URI, GarageModeSettingsObserver.GARAGE_MODE_WAKE_UP_TIME_URI, GarageModeSettingsObserver.GARAGE_MODE_MAINTENANCE_WINDOW_URI};
    private final WeakReference mContext;

    public GarageModeSettingsObserver(Context context, Handler handler) {
        super(handler);
        this.mContext = new WeakReference(context);
    }

    public void register() {
        if(this.mContext.get() == null) {
            return;
        }
        Uri[] arr_uri = GarageModeSettingsObserver.GARAGE_SETTING_URIS;
        for(int v = 0; v < arr_uri.length; ++v) {
            Uri uri = arr_uri[v];
            ((Context)this.mContext.get()).getContentResolver().registerContentObserver(uri, false, this);
        }
    }

    public void unregister() {
        if(this.mContext.get() == null) {
            return;
        }
        ((Context)this.mContext.get()).getContentResolver().unregisterContentObserver(this);
    }
}

