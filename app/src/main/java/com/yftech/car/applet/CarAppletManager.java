package com.yftech.car.applet;

import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.ArrayMap;
import android.util.Log;
import com.yftech.car.utils.MonitorServiceRestartManager.IMonitorCallback;
import com.yftech.car.utils.MonitorServiceRestartManager;
import java.util.ArrayList;
import java.util.List;

public class CarAppletManager {
    static final class CarAppletManagerGlobal extends Stub implements IBinder.DeathRecipient, IMonitorCallback {
        private static final CarAppletManagerGlobal CAR_APPLET_MANAGER_GLOBAL = new CarAppletManagerGlobal();
        private final ArrayMap mCallbackMap;
        private ICarAppletService mCarAppletService;
        private final Object mLock;
        private final List mServiceStartRunnable;

        private CarAppletManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
            this.mServiceStartRunnable = new ArrayList();
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("CarAppletManager", "binder died,reconnect service car_applet after 1000ms!");
            synchronized(this.mLock) {
                if(this.mCarAppletService == null) {
                    return;
                }
                this.mCarAppletService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        public boolean canMossAppOpen(String platformType, String appId) {
            try {
                return this.getAppletService() == null ? false : this.getAppletService().canMossAppOpen(platformType, appId);
            }
            catch(RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }

        private boolean connectCarAppletServiceLocked() {
            if(this.mCarAppletService == null || this.mCarAppletService.asBinder() == null || !this.mCarAppletService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = ServiceManager.getService("car_applet");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        this.mCarAppletService = com.yftech.car.applet.ICarAppletService.Stub.asInterface(iBinder0);
                        this.mCarAppletService.registerCarAppletRequestCallback(this);
                        return true;
                    }
                    Log.e("CarAppletManager", "the car applet service not started!connected service fail!");
                    return false;
                }
                catch(RemoteException e) {
                }
            }
            else {
                return true;
            }
            Log.e("CarAppletManager", "link to death error!" + e.getMessage());
            e.printStackTrace();
            return false;
        }

        public static CarAppletManagerGlobal get() {
            return CarAppletManagerGlobal.CAR_APPLET_MANAGER_GLOBAL;
        }

        public ICarAppletService getAppletService() {
            synchronized(this.mLock) {
                if(!this.connectCarAppletServiceLocked() || this.mCarAppletService == null) {
                    Log.e("CarAppletManager", "car applet service is unavailable");
                    this.startReconnectThread();
                }
                return this.mCarAppletService;
            }
        }

        public boolean isMiniProgramOpened(String platformType, String appId) {
            try {
                return this.getAppletService() == null ? false : this.getAppletService().isMiniProgramOpened(platformType, appId);
            }
            catch(RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean isMossAppForeground(String platformType, String appId) {
            try {
                return this.getAppletService() == null ? false : this.getAppletService().isMossAppForeground(platformType, appId);
            }
            catch(RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }

        public void loadAllAppletsFromCache() {
            try {
                if(this.getAppletService() != null) {
                    this.getAppletService().loadAllAppletsFromCache();
                }
            }
            catch(RemoteException e) {
                e.printStackTrace();
            }
        }

        public void loadAllAppletsFromNet() {
            try {
                if(this.getAppletService() != null) {
                    this.getAppletService().loadAllAppletsFromNet();
                }
            }
            catch(RemoteException e) {
                e.printStackTrace();
            }
        }

        public void loadAppletsFromCache(String platformType) {
            try {
                if(this.getAppletService() != null) {
                    this.getAppletService().loadAppletsFromCache(platformType);
                }
            }
            catch(RemoteException e) {
                e.printStackTrace();
            }
        }

        public void loadAppletsFromNet(String platformTyp) {
            try {
                if(this.getAppletService() != null) {
                    this.getAppletService().loadAppletsFromNet(platformTyp);
                }
            }
            catch(RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override  // com.yftech.car.applet.ICarAppletRequestCallback
        public void onFailed(String platformType, String s) throws RemoteException {
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
            this.connectCarAppletServiceLocked();
            synchronized(this.mServiceStartRunnable) {
                for(Object object0: this.mServiceStartRunnable) {
                    ((Runnable)object0).run();
                }
                this.mServiceStartRunnable.clear();
            }
        }

        @Override  // com.yftech.car.applet.ICarAppletRequestCallback
        public void onSucceeded(String platformType, List list0) throws RemoteException {
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

        public void openMossApp(String platformType, String appId, String pagePath, int position) {
            try {
                if(this.getAppletService() != null) {
                    this.getAppletService().openMossApp(platformType, appId, pagePath, position);
                }
            }
            catch(RemoteException e) {
                e.printStackTrace();
            }
        }

        public void registerCarAppletRequestCallback(CarAppletRequestCallback callback, Handler handler) {
            synchronized(this.mLock) {
                if(!this.connectCarAppletServiceLocked()) {
                    this.startReconnectThread();
                }
                if(!this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.put(callback, handler);
                }
            }
        }

        private void startReconnectThread() {
            MonitorServiceRestartManager.getInstance().addMonitor("car_applet", this);
        }

        public void unregisterCarAppletRequestCallback(CarAppletRequestCallback callback) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.remove(callback);
                }
            }
        }
    }

    public static abstract class CarAppletRequestCallback {
        public void onFailed(String platformType, String error) {
        }

        public void onSucceeded(String platformType, List list0) {
        }
    }

    public static final String BAIDU_APPLET = "baidu.applet";
    public static final String SERVICE_NAME = "car_applet";
    private static final String TAG = null;
    public static final String TENCENT_APPLET = "tencent.applet";
    public static volatile CarAppletManager mInstance;

    static {
        CarAppletManager.TAG = "CarAppletManager";
    }

    static String access$000() {
        return "CarAppletManager";
    }

    public boolean canMossAppOpen(String platformType, String appId) {
        return CarAppletManagerGlobal.get().canMossAppOpen(platformType, appId);
    }

    public static CarAppletManager getInstance() {
        if(CarAppletManager.mInstance == null) {
            Class class0 = CarAppletManager.class;
            synchronized(class0) {
                if(CarAppletManager.mInstance == null) {
                    CarAppletManager.mInstance = new CarAppletManager();
                }
            }
        }
        return CarAppletManager.mInstance;
    }

    public boolean isMiniProgramOpened(String platformType, String appId) {
        return CarAppletManagerGlobal.get().isMiniProgramOpened(platformType, appId);
    }

    public boolean isMossAppForeground(String platformType, String appId) {
        return CarAppletManagerGlobal.get().isMossAppForeground(platformType, appId);
    }

    public void loadAllAppletsFromCache() {
        CarAppletManagerGlobal.get().loadAllAppletsFromCache();
    }

    public void loadAllAppletsFromNet() {
        CarAppletManagerGlobal.get().loadAllAppletsFromNet();
    }

    public void loadAppletsFromCache(String platformType) {
        CarAppletManagerGlobal.get().loadAppletsFromCache(platformType);
    }

    public void loadAppletsFromNet(String platformType) {
        CarAppletManagerGlobal.get().loadAppletsFromNet(platformType);
    }

    public void openMossApp(String platformType, String appId, String pagePath) {
        this.openMossApp(platformType, appId, pagePath, 0);
    }

    public void openMossApp(String platformType, String appId, String pagePath, int position) {
        CarAppletManagerGlobal.get().openMossApp(platformType, appId, pagePath, position);
    }

    public void registerCarAppletRequestCallback(CarAppletRequestCallback callback, Handler handler) {
        if(handler == null) {
            Looper looper0 = Looper.myLooper();
            if(looper0 == null) {
                throw new IllegalArgumentException("No handler given, and current thread has no looper!");
            }
            handler = new Handler(looper0);
        }
        CarAppletManagerGlobal.get().registerCarAppletRequestCallback(callback, handler);
    }

    public void unregisterCarAppletRequestCallback(CarAppletRequestCallback callback) {
        CarAppletManagerGlobal.get().unregisterCarAppletRequestCallback(callback);
    }
}

