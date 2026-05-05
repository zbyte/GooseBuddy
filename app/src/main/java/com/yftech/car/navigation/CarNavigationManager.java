package com.yftech.car.navigation;

import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.Log;

import com.yftech.car.utils.BinderUtils;
import com.yftech.car.utils.MonitorServiceRestartManager.IMonitorCallback;
import com.yftech.car.utils.MonitorServiceRestartManager;
import java.util.ArrayList;
import java.util.List;

public class CarNavigationManager {
    public static abstract class CarNavigationCallback {
        public void onArriveDestination() {
        }

        public void onDayNightChanged(int dayNightMode) {
        }

        public void onManeuverChanged(CarNavigationManeuver maneuver) {
        }

        public void onQuitNavigation() {
        }

        public void onRoadConditionChanged(boolean isOpen) {
        }

        public void onServiceStart() {
        }

        public void onServiceStop() {
        }

        public void onStartNavigation() {
        }

        public void onVoiceChanged(boolean isOpen) {
        }
    }

    static final class CarNavigationManagerGlobal extends ICarNavigationCallback.Stub implements IBinder.DeathRecipient, IMonitorCallback {
        private static final CarNavigationManagerGlobal CAR_NAVIGATION_MANAGER_GLOBAL = new CarNavigationManagerGlobal();
        private final ArrayMap mCallbackMap;
        private ICarNavigationService mCarNavigationService;
        private final Object mLock;
        private final List mServiceStartRunnable;

        private CarNavigationManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
            this.mServiceStartRunnable = new ArrayList();
        }

        @Override  // com.yftech.car.navigation.ICarNavigationCallback$Stub
        public IBinder asBinder() {
            return this;
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("CarNavigationManager", "binder died,reconnect service car_navigation after 1000ms!");
            synchronized(this.mLock) {
                if(this.mCarNavigationService == null) {
                    return;
                }
                this.mCarNavigationService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        private boolean connectCarAudioServiceLocked() {
            if(this.mCarNavigationService == null || this.mCarNavigationService.asBinder() == null || !this.mCarNavigationService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = BinderUtils.getAliveServiceBinder("car_navigation");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        this.mCarNavigationService = com.yftech.car.navigation.ICarNavigationService.Stub.asInterface(iBinder0);
                        this.mCarNavigationService.registerCarNavigationCallback(this);
                        return true;
                    }
                    Log.e("CarNavigationManager", "the car navigation service not started!connected service fail!");
                    return false;
                }
                catch(RemoteException e) {
                    Log.e("CarNavigationManager", "link to death error!" + e.getMessage());
                    e.printStackTrace();
                }
            }
            else {
                return true;
            }

            return false;
        }

        public static CarNavigationManagerGlobal get() {
            return CarNavigationManagerGlobal.CAR_NAVIGATION_MANAGER_GLOBAL;
        }

        public ICarNavigationService getCarNavigationService() {
            synchronized(this.mLock) {
                if(!this.connectCarAudioServiceLocked() || this.mCarNavigationService == null) {
                    Log.e("CarNavigationManager", "car navigation service is unavailable");
                    this.startReconnectThread();
                }
                return this.mCarNavigationService;
            }
        }

        public void goCompany() {
            try {
                this.getCarNavigationService().goCompany();
            }
            catch(RemoteException e) {
                e.printStackTrace();
            }
        }

        public void goHome() {
            try {
                this.getCarNavigationService().goHome();
            }
            catch(RemoteException e) {
                e.printStackTrace();
            }
        }

        public void goPoiDetailPage(String name, String address, double lat, double lon) {
            try {
                this.getCarNavigationService().goPoiDetailPage(name, address, lat, lon);
            }
            catch(RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override  // com.yftech.car.navigation.ICarNavigationCallback
        public void onArriveDestination() throws RemoteException {
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

        @Override  // com.yftech.car.navigation.ICarNavigationCallback
        public void onDayNightChanged(int dayNightMode) throws RemoteException {
            synchronized(this.mLock) {
                int v2 = this.mCallbackMap.size();
                for(int i = 0; i < v2; ++i) {
                    ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                        @Override
                        public void run() {
                        }
                    });
                }
            }
        }

        @Override  // com.yftech.car.navigation.ICarNavigationCallback
        public void onManeuverChanged(CarNavigationManeuver maneuver) throws RemoteException {
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

        @Override  // com.yftech.car.navigation.ICarNavigationCallback
        public void onQuitNavigation() throws RemoteException {
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

        @Override  // com.yftech.car.navigation.ICarNavigationCallback
        public void onRoadConditionChanged(boolean isOpen) throws RemoteException {
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

        @Override  // com.yftech.car.navigation.ICarNavigationCallback
        public void onServiceStart() {
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
            this.connectCarAudioServiceLocked();
            synchronized(this.mServiceStartRunnable) {
                for(Object object0: this.mServiceStartRunnable) {
                    ((Runnable)object0).run();
                }
                this.mServiceStartRunnable.clear();
            }
        }

        @Override  // com.yftech.car.navigation.ICarNavigationCallback
        public void onServiceStop() {
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

        @Override  // com.yftech.car.navigation.ICarNavigationCallback
        public void onStartNavigation() throws RemoteException {
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

        @Override  // com.yftech.car.navigation.ICarNavigationCallback
        public void onVoiceChanged(boolean isOpen) throws RemoteException {
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

        public void openNaviApp() {
            try {
                this.getCarNavigationService().openNaviApp();
            }
            catch(RemoteException e) {
                e.printStackTrace();
            }
        }

        public void registerCarAudioCallback(CarNavigationCallback callback, Handler handler) {
            synchronized(this.mLock) {
                if(!this.connectCarAudioServiceLocked()) {
                    this.startReconnectThread();
                }
                if(!this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.put(callback, handler);
                }
            }
        }

        public void searchKeyword(String str) {
            try {
                this.getCarNavigationService().searchKeyword(str);
            }
            catch(RemoteException e) {
                e.printStackTrace();
            }
        }

        public void setMuteMode(boolean isOpen) {
            try {
                this.getCarNavigationService().setMuteMode(isOpen);
            }
            catch(RemoteException e) {
                e.printStackTrace();
            }
        }

        public void setRoadCondition(boolean isOpen) {
            try {
                this.getCarNavigationService().setRoadCondition(isOpen);
            }
            catch(RemoteException e) {
                e.printStackTrace();
            }
        }

        private void startReconnectThread() {
            MonitorServiceRestartManager.getInstance().addMonitor("car_navigation", this);
        }

        public void unregisterCarAudioCallback(CarNavigationCallback callback) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.remove(callback);
                }
            }
        }
    }

    public static final String SERVICE_NAME = "car_navigation";
    private static final String TAG = "CarNavigationManager";
    private static volatile CarNavigationManager mInstance;

    // String Decryptor: 4 succeeded, 0 failed
    static String access$000() {
        return "CarNavigationManager";
    }

    public static CarNavigationManager getInstance() {
        if(CarNavigationManager.mInstance == null) {
            Class class0 = CarNavigationManager.class;
            synchronized(class0) {
                if(CarNavigationManager.mInstance == null) {
                    CarNavigationManager.mInstance = new CarNavigationManager();
                }
            }
        }
        return CarNavigationManager.mInstance;
    }

    public void goCompany() {
        CarNavigationManagerGlobal.get().goCompany();
    }

    public void goHome() {
        CarNavigationManagerGlobal.get().goHome();
    }

    public void goPoiDetailPage(String name, String address, double lat, double lon) {
        CarNavigationManagerGlobal.get().goPoiDetailPage(name, address, lat, lon);
    }

    public void openNaviApp() {
        CarNavigationManagerGlobal.get().openNaviApp();
    }

    public void registerCarAudioCallback(CarNavigationCallback callback, Handler handler) {
        if(handler == null) {
            Looper looper0 = Looper.myLooper();
            if(looper0 == null) {
                throw new IllegalArgumentException("No handler given, and current thread has no looper!");
            }
            handler = new Handler(looper0);
        }
        CarNavigationManagerGlobal.get().registerCarAudioCallback(callback, handler);
    }

    public void searchKeyword(String str) {
        CarNavigationManagerGlobal.get().searchKeyword(str);
    }

    public void setMuteMode(boolean isOpen) {
        CarNavigationManagerGlobal.get().setMuteMode(isOpen);
    }

    public void setRoadCondition(boolean isOpen) {
        CarNavigationManagerGlobal.get().setRoadCondition(isOpen);
    }

    public void unregisterCarAudioCallback(CarNavigationCallback callback) {
        CarNavigationManagerGlobal.get().unregisterCarAudioCallback(callback);
    }
}

