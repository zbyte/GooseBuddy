package com.yftech.car.carinfoloader;

import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.os.Looper;
import android.util.ArrayMap;
import android.util.Log;

import com.yftech.car.utils.BinderUtils;
import com.yftech.car.utils.MonitorServiceRestartManager.IMonitorCallback;
import com.yftech.car.utils.MonitorServiceRestartManager;

public class CarInfoLoaderManager {
    public static abstract class CarInfoLoaderCallback {
        public void onInfo(String cpuId, String uuid, String sn, String vin) {
        }
    }

    static final class CarInfoLoaderGlobal extends ICarInfoLoaderCallBack.Stub implements IBinder.DeathRecipient, IMonitorCallback {
        private static final CarInfoLoaderGlobal intance = new CarInfoLoaderGlobal();
        private final ArrayMap mCallbackMap;
        private final Object mLock;
        private static ICarInfoLoader mService;

        private CarInfoLoaderGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("CarInfoLoaderManager", "binder died,reconnect service car_carinfoloader after 1000ms!");
            synchronized(this.mLock) {
                if(CarInfoLoaderGlobal.mService != null) {
                    CarInfoLoaderGlobal.mService = null;
                }
                CarInfoLoaderGlobal.mService = null;
                this.startReconnectThread();
            }
        }

        private boolean connectServiceLocked() {
            if(CarInfoLoaderGlobal.mService == null || CarInfoLoaderGlobal.mService.asBinder() == null || !CarInfoLoaderGlobal.mService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = BinderUtils.getAliveServiceBinder("car_carinfoloader");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        CarInfoLoaderGlobal.mService = com.yftech.car.carinfoloader.ICarInfoLoader.Stub.asInterface(iBinder0);
                        CarInfoLoaderGlobal.mService.registerCarInfoLoaderCallBack(this);
                        return true;
                    }
                    Log.e("CarInfoLoaderManager", "the carinfoloader service not started!connected service fail!");
                    return false;
                }
                catch(Exception e) {
                    Log.e("CarInfoLoaderManager", "link to death error!" + e.getMessage());
                    e.printStackTrace();
                }
            }
            else {
                return true;
            }

            return false;
        }

        public static CarInfoLoaderGlobal get() {
            return CarInfoLoaderGlobal.intance;
        }

        public String getCarInfoByCpuId(String cpuId) {
            try {
                return this.getService().getCarInfoByCpuId(cpuId);
            }
            catch(Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        public String getCarInfoByVin(String vin) {
            try {
                return this.getService().getCarInfoByVin(vin);
            }
            catch(Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        public ICarInfoLoader getService() {
            synchronized(this.mLock) {
                if(!this.connectServiceLocked() || CarInfoLoaderGlobal.mService == null) {
                    Log.e("CarInfoLoaderManager", "car carinfoloader service is unavailable");
                    this.startReconnectThread();
                }
                return CarInfoLoaderGlobal.mService;
            }
        }

        @Override  // com.yftech.car.carinfoloader.ICarInfoLoaderCallBack
        public void onInfo(String cpuId, String uuid, String sn, String vin) {
            synchronized(this.mLock) {
                int v1 = this.mCallbackMap.size();
                for(int i = 0; i < v1; ++i) {
                    ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                        @Override
                        public void run() {
                        }
                    });
                }
            }
        }

        @Override  // com.yftech.car.utils.MonitorServiceRestartManager$IMonitorCallback
        public void onServiceStart(String serviceName) {
            this.connectServiceLocked();
        }

        public void registerCarInfoLoaderCallback(CarInfoLoaderCallback callback, Handler handler) {
            synchronized(this.mLock) {
                if(!this.connectServiceLocked()) {
                    this.startReconnectThread();
                }
                if(!this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.put(callback, handler);
                }
            }
        }

        private void startReconnectThread() {
            MonitorServiceRestartManager.getInstance().addMonitor("car_carinfoloader", this);
        }

        public void unregisterCarInfoLoaderCallback(CarInfoLoaderCallback callback) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.remove(callback);
                }
            }
        }
    }

    public static final int ERRORCODE_FAIL = 1;
    public static final int ERRORCODE_SUCCESS = 0;
    public static final String SERVICE_NAME = "car_carinfoloader";
    private static final String TAG = "CarInfoLoaderManager";
    private static volatile CarInfoLoaderManager mInstance;

    // String Decryptor: 4 succeeded, 0 failed
    static String access$000() {
        return "CarInfoLoaderManager";
    }

    public void getCarInfoByCpuId(String cpuId) {
        CarInfoLoaderGlobal.get().getCarInfoByCpuId(cpuId);
    }

    public void getCarInfoByVin(String vin) {
        CarInfoLoaderGlobal.get().getCarInfoByVin(vin);
    }

    public static CarInfoLoaderManager getInstance() {
        if(CarInfoLoaderManager.mInstance == null) {
            Class class0 = CarInfoLoaderManager.class;
            synchronized(class0) {
                if(CarInfoLoaderManager.mInstance == null) {
                    CarInfoLoaderManager.mInstance = new CarInfoLoaderManager();
                }
            }
        }
        return CarInfoLoaderManager.mInstance;
    }

    public void registerCarInfoLoaderCallback(CarInfoLoaderCallback callback, Handler handler) {
        if(handler == null) {
            Looper looper0 = Looper.myLooper();
            if(looper0 == null) {
                throw new IllegalArgumentException("No handler given, and current thread has no looper!");
            }
            handler = new Handler(looper0);
        }
        CarInfoLoaderGlobal.get().registerCarInfoLoaderCallback(callback, handler);
    }

    public void unregisterCarInfoLoaderCallback(CarInfoLoaderCallback callback) {
        CarInfoLoaderGlobal.get().unregisterCarInfoLoaderCallback(callback);
    }
}

