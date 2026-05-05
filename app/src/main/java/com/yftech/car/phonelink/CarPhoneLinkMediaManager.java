package com.yftech.car.phonelink;

import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.os.Looper;
import android.util.ArrayMap;
import android.util.Log;

import com.yftech.car.utils.BinderUtils;
import com.yftech.car.utils.MonitorServiceRestartManager.IMonitorCallback;
import com.yftech.car.utils.MonitorServiceRestartManager;

import java.util.Map;
import java.util.Map.Entry;

public class CarPhoneLinkMediaManager {
    public static abstract class CarPhoneLinkMediaCallback {
        public void onMediaInfoChanged(PhoneLinkMediaInfo info) {
        }
    }

    static final class CarPhoneLinkMediaManagerGlobal extends ICarPhoneLinkMediaCallback.Stub implements IBinder.DeathRecipient, IMonitorCallback {
        private static final CarPhoneLinkMediaManagerGlobal gCarPhoneLinkMediaManager = new CarPhoneLinkMediaManagerGlobal();
        private final ArrayMap mCallbackMap;
        private static ICarPhoneLinkMediaService mCarPhoneLinkMediaService;
        private final Object mLock;

        private CarPhoneLinkMediaManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
        }

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkMediaCallback$Stub
        public IBinder asBinder() {
            return this;
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("CarPhoneLinkMediaManager", "binder died,reconnect service car_phonelinkmedia after 1000ms!");
            synchronized(this.mLock) {
                if(CarPhoneLinkMediaManagerGlobal.mCarPhoneLinkMediaService == null) {
                    return;
                }
                CarPhoneLinkMediaManagerGlobal.mCarPhoneLinkMediaService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        private boolean connectCarPhoneLinkServiceLocked() {
            if(CarPhoneLinkMediaManagerGlobal.mCarPhoneLinkMediaService == null || CarPhoneLinkMediaManagerGlobal.mCarPhoneLinkMediaService.asBinder() == null || !CarPhoneLinkMediaManagerGlobal.mCarPhoneLinkMediaService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = BinderUtils.getAliveServiceBinder("car_phonelinkmedia");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        CarPhoneLinkMediaManagerGlobal.mCarPhoneLinkMediaService = com.yftech.car.phonelink.ICarPhoneLinkMediaService.Stub.asInterface(iBinder0);
                        Log.i("CarPhoneLinkMediaManager", "mCarPhoneLinkMediaService:" + CarPhoneLinkMediaManagerGlobal.mCarPhoneLinkMediaService);
                        CarPhoneLinkMediaManagerGlobal.mCarPhoneLinkMediaService.registerCarPhoneLinkMediaCallback(this);
                        return true;
                    }
                    Log.e("CarPhoneLinkMediaManager", "the car phoneLink service not started!connected service fail!");
                    return false;
                }
                catch(Exception e) {
                    Log.e("CarPhoneLinkMediaManager", "link to death error!" + e.getMessage());
                    e.printStackTrace();
                }
            }
            else {
                return true;
            }

            return false;
        }

        public static CarPhoneLinkMediaManagerGlobal get() {
            return CarPhoneLinkMediaManagerGlobal.gCarPhoneLinkMediaManager;
        }

        public ICarPhoneLinkMediaService getCarPhoneLinkMediaService() {
            synchronized(this.mLock) {
                if(!this.connectCarPhoneLinkServiceLocked() || CarPhoneLinkMediaManagerGlobal.mCarPhoneLinkMediaService == null) {
                    Log.e("CarPhoneLinkMediaManager", "car phoneLink service is unavailable");
                    this.startReconnectThread();
                }
                Log.i("CarPhoneLinkMediaManager", "getCarPhoneLinkMediaService:" + CarPhoneLinkMediaManagerGlobal.mCarPhoneLinkMediaService);
                return CarPhoneLinkMediaManagerGlobal.mCarPhoneLinkMediaService;
            }
        }

        public PhoneLinkMediaInfo getCurPhoneLinkMediaInfo() {
            try {
                return this.getCarPhoneLinkMediaService().getCurPhoneLinkMediaInfo();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public boolean next() {
            try {
                return this.getCarPhoneLinkMediaService().next();
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkMediaCallback
        public void onMediaInfoChanged(PhoneLinkMediaInfo info) {
            Log.i("CarPhoneLinkMediaManager", "onMediaInfoChanged:" + info);
            synchronized(this.mCallbackMap) {
                for(Object object0: this.mCallbackMap.entrySet()) {
                    ((Handler)((Map.Entry)object0).getValue()).post(new Runnable() {
                        @Override
                        public void run() {
                        }
                    });
                }
            }
        }

        @Override  // com.yftech.car.utils.MonitorServiceRestartManager$IMonitorCallback
        public void onServiceStart(String serviceName) {
            this.connectCarPhoneLinkServiceLocked();
        }

        public boolean play() {
            try {
                return this.getCarPhoneLinkMediaService().play();
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean previous() {
            try {
                return this.getCarPhoneLinkMediaService().previous();
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public void registerCarPhoneLinkMediaCallback(CarPhoneLinkMediaCallback callback, Handler handler) {
            synchronized(this.mLock) {
                if(!this.connectCarPhoneLinkServiceLocked()) {
                    this.startReconnectThread();
                }
                if(!this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.put(callback, handler);
                }
            }
        }

        private void startReconnectThread() {
            MonitorServiceRestartManager.getInstance().addMonitor("car_phonelinkmedia", this);
        }

        public boolean stop() {
            try {
                return this.getCarPhoneLinkMediaService().stop();
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public void unregisterCarPhoneLinkMediaCallback(CarPhoneLinkMediaCallback callback) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.remove(callback);
                }
            }
        }
    }

    public static final String SERVICE_NAME = "car_phonelinkmedia";
    private static final String TAG = "CarPhoneLinkMediaManager";
    private static volatile CarPhoneLinkMediaManager mInstance;

    // String Decryptor: 7 succeeded, 0 failed
    static String access$000() {
        return "CarPhoneLinkMediaManager";
    }

    public PhoneLinkMediaInfo getCurPhoneLinkMediaInfo() {
        return CarPhoneLinkMediaManagerGlobal.get().getCurPhoneLinkMediaInfo();
    }

    public static CarPhoneLinkMediaManager getInstance() {
        if(CarPhoneLinkMediaManager.mInstance == null) {
            Class class0 = CarPhoneLinkMediaManager.class;
            synchronized(class0) {
                if(CarPhoneLinkMediaManager.mInstance == null) {
                    CarPhoneLinkMediaManager.mInstance = new CarPhoneLinkMediaManager();
                }
            }
        }
        return CarPhoneLinkMediaManager.mInstance;
    }

    public boolean next() {
        return CarPhoneLinkMediaManagerGlobal.get().next();
    }

    public boolean play() {
        return CarPhoneLinkMediaManagerGlobal.get().play();
    }

    public boolean previous() {
        return CarPhoneLinkMediaManagerGlobal.get().previous();
    }

    public void registerCarPhoneLinkMediaCallback(CarPhoneLinkMediaCallback callback, Handler handler) {
        if(handler == null) {
            Looper looper0 = Looper.myLooper();
            if(looper0 == null) {
                throw new IllegalArgumentException("No handler given, and current thread has no looper!");
            }
            handler = new Handler(looper0);
        }
        CarPhoneLinkMediaManagerGlobal.get().registerCarPhoneLinkMediaCallback(callback, handler);
    }

    public boolean stop() {
        return CarPhoneLinkMediaManagerGlobal.get().stop();
    }

    public void unregisterCarPhoneLinkCallback(CarPhoneLinkMediaCallback callback) {
        CarPhoneLinkMediaManagerGlobal.get().unregisterCarPhoneLinkMediaCallback(callback);
    }
}

