package com.yftech.car.cartrack;

import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.util.Log;

import com.yftech.car.utils.BinderUtils;
import com.yftech.car.utils.MonitorServiceRestartManager.IMonitorCallback;
import com.yftech.car.utils.MonitorServiceRestartManager;
import java.util.Map;

public class CarTrackManager {
    static final class CollectUpManagerGlobal implements IBinder.DeathRecipient, IMonitorCallback {
        private static final CollectUpManagerGlobal intance = new CollectUpManagerGlobal();
        private final Object mLock;
        private static ICarTrackService mService;

        private CollectUpManagerGlobal() {
            this.mLock = new Object();
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("CarTrackManager", "binder died,reconnect service car_track after 1000ms!");
            synchronized(this.mLock) {
                if(CollectUpManagerGlobal.mService != null) {
                    CollectUpManagerGlobal.mService = null;
                }
                CollectUpManagerGlobal.mService = null;
                this.startReconnectThread();
            }
        }

        private boolean connectServiceLocked() {
            if(CollectUpManagerGlobal.mService == null || CollectUpManagerGlobal.mService.asBinder() == null || !CollectUpManagerGlobal.mService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = BinderUtils.getAliveServiceBinder("car_track");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        CollectUpManagerGlobal.mService = ICarTrackService.Stub.asInterface(iBinder0);
                        return true;
                    }
                    Log.e("CarTrackManager", "the car dms service not started!connected service fail!");
                    return false;
                }
                catch(Exception e) {
                    Log.e("CarTrackManager", "link to death error!" + e.getMessage());
                    e.printStackTrace();
                }
            }
            else {
                return true;
            }

            return false;
        }

        public static CollectUpManagerGlobal get() {
            return CollectUpManagerGlobal.intance;
        }

        public ICarTrackService getService() {
            synchronized(this.mLock) {
                if(!this.connectServiceLocked() || CollectUpManagerGlobal.mService == null) {
                    Log.e("CarTrackManager", "car pki service is unavailable");
                    this.startReconnectThread();
                }
                return CollectUpManagerGlobal.mService;
            }
        }

        @Override  // com.yftech.car.utils.MonitorServiceRestartManager$IMonitorCallback
        public void onServiceStart(String serviceName) {
            this.connectServiceLocked();
        }

        private void startReconnectThread() {
            MonitorServiceRestartManager.getInstance().addMonitor("car_track", this);
        }

        public void tracking(String pkgName, String action, Map map0) {
            try {
                this.getService().tracking(pkgName, action, map0);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static final String SERVICE_NAME = "car_track";
    private static final String TAG = "CarTrackManager";
    private static volatile CarTrackManager mInstance;

    // String Decryptor: 4 succeeded, 0 failed
    static String access$000() {
        return "CarTrackManager";
    }

    public static CarTrackManager getInstance() {
        if(CarTrackManager.mInstance == null) {
            Class class0 = CarTrackManager.class;
            synchronized(class0) {
                if(CarTrackManager.mInstance == null) {
                    CarTrackManager.mInstance = new CarTrackManager();
                }
            }
        }
        return CarTrackManager.mInstance;
    }

    public void tracking(String pkgName, String action, Map map0) {
        CollectUpManagerGlobal.get().tracking(pkgName, action, map0);
    }
}

