package com.yftech.car.data;

import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;

import com.yftech.car.utils.BinderUtils;

public class CarDataManager {
    public static abstract class CarDataCallback {
        public void onCarDataChanged(CarData data) {
        }
    }

    static final class CarDataManagerGlobal extends com.yftech.car.data.ICarDataCallback.Stub implements IBinder.DeathRecipient, Runnable {
        private static final CarDataManagerGlobal CAR_DATA_MANAGER_GLOBAL = new CarDataManagerGlobal();
        private final ArrayMap mCallbackMap;
        private static ICarDataService mCarDataService;
        private Thread mConnectingThread;
        private final Object mLock;

        private CarDataManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
        }

        @Override  // com.yftech.car.data.ICarDataCallback$Stub
        public IBinder asBinder() {
            return this;
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("CarDataManager", "binder died,reconnect service car_data after 1000ms!");
            synchronized(this.mLock) {
                if(CarDataManagerGlobal.mCarDataService == null) {
                    return;
                }
                CarDataManagerGlobal.mCarDataService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        private boolean connectCarDataServiceLocked() {
            if(CarDataManagerGlobal.mCarDataService == null || CarDataManagerGlobal.mCarDataService.asBinder() == null || !CarDataManagerGlobal.mCarDataService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = BinderUtils.getAliveServiceBinder("car_data");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        CarDataManagerGlobal.mCarDataService = com.yftech.car.data.ICarDataService.Stub.asInterface(iBinder0);
                        CarDataManagerGlobal.mCarDataService.registerCarDataCallback(this);
                        return true;
                    }
                    Log.e("CarDataManager", "the car data service not started!connected service fail!");
                    return false;
                }
                catch(RemoteException e) {
                    Log.e("CarDataManager", "link to death error!" + e.getMessage());
                    e.printStackTrace();
                }
            }
            else {
                return true;
            }
            return false;
        }

        public static CarDataManagerGlobal get() {
            return CarDataManagerGlobal.CAR_DATA_MANAGER_GLOBAL;
        }

        public CarData get(CarData data) {
            synchronized(this.mLock) {
                try {
                    CarDataManagerGlobal.mCarDataService = this.getCarDataService();
                    return CarDataManagerGlobal.mCarDataService.get(data);
                }
                catch(RemoteException remoteException0) {
                    remoteException0.printStackTrace();
                }
                catch(NullPointerException nullPointerException0) {
                    nullPointerException0.printStackTrace();;
                }
            }
            return null;
        }

        public ICarDataService getCarDataService() {
            synchronized(this.mLock) {
                if(!this.connectCarDataServiceLocked() || CarDataManagerGlobal.mCarDataService == null) {
                    Log.e("CarDataManager", "car data service is unavailable");
                    this.startReconnectThread();
                }
                return CarDataManagerGlobal.mCarDataService;
            }
        }

        @Override  // com.yftech.car.data.ICarDataCallback
        public void onCarDataChanged(CarData data) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        public void registerCarDataCallback(CarDataCallback callback, Handler handler) {
            synchronized(this.mLock) {
                if(this.connectCarDataServiceLocked()) {
                    this.startReconnectThread();
                }
                if(!this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.put(callback, handler);
                }
            }
        }

        @Override
        public void run() {
            Log.i("CarDataManager", "connecting service car_data!");
            while(!this.connectCarDataServiceLocked()) {
                try {
                    Thread.sleep(1000L);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i("CarDataManager", "reconnecting service car_data!");
                this.connectCarDataServiceLocked();
            }
        }

        public boolean set(CarData data, boolean persistence) {
            RemoteException e;
            synchronized(this.mLock) {
                try {
                    CarDataManagerGlobal.mCarDataService = this.getCarDataService();
                    return CarDataManagerGlobal.mCarDataService.set(data, persistence);
                }
                catch(RemoteException remoteException0) {
                    remoteException0.printStackTrace();
                }
                catch(NullPointerException nullPointerException0) {
                    nullPointerException0.printStackTrace();
                }
            }
            return false;
        }

        private void startReconnectThread() {
            if(this.mConnectingThread == null || !this.mConnectingThread.isAlive()) {
                this.mConnectingThread = new Thread(this);
                this.mConnectingThread.start();
            }
        }

        public void unregisterCarDataCallback(CarDataCallback callback) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.remove(callback);
                }
            }
        }
    }

    public static final String SERVICE_NAME = "car_data";
    private static final String TAG = "CarDataManager";

    // String Decryptor: 6 succeeded, 0 failed
    static String access$000() {
        return "CarDataManager";
    }

    public static CarData get(CarData data) {
        return data == null ? null : CarDataManagerGlobal.get().get(data);
    }

    public static String get(String key, String defaultValue) {
        if(TextUtils.isEmpty(key)) {
            return defaultValue;
        }
        CarData carData = CarDataManager.get(new CarData(new CarData.CarDataEntry(key, defaultValue)));
        return carData == null ? defaultValue : carData.getDataEntry(key).getValueString();
    }

    public static boolean getBollean(String key, boolean defaultValue) {
        if(TextUtils.isEmpty(key)) {
            return defaultValue;
        }
        CarData carData = CarDataManager.get(new CarData(new CarData.CarDataEntry(key, defaultValue)));
        return carData == null ? defaultValue : carData.getDataEntry(key).getValueBoolean();
    }

    public static byte getByte(String key, byte defaultValue) {
        if(TextUtils.isEmpty(key)) {
            return defaultValue;
        }
        CarData carData = CarDataManager.get(new CarData(new CarData.CarDataEntry(key, defaultValue)));
        return carData == null ? defaultValue : carData.getDataEntry(key).getValueByte();
    }

    public static double getDouble(String key, double defaultValue) {
        if(TextUtils.isEmpty(key)) {
            return defaultValue;
        }
        CarData carData = CarDataManager.get(new CarData(new CarData.CarDataEntry(key, defaultValue)));
        return carData == null ? defaultValue : carData.getDataEntry(key).getValueDouble();
    }

    public static float getFloat(String key, float defaultValue) {
        if(TextUtils.isEmpty(key)) {
            return defaultValue;
        }
        CarData carData = CarDataManager.get(new CarData(new CarData.CarDataEntry(key, defaultValue)));
        return carData == null ? defaultValue : carData.getDataEntry(key).getValueFloat();
    }

    public static int getInt(String key, int defaultValue) {
        if(TextUtils.isEmpty(key)) {
            return defaultValue;
        }
        CarData carData = CarDataManager.get(new CarData(new CarData.CarDataEntry(key, defaultValue)));
        return carData == null ? defaultValue : carData.getDataEntry(key).getValueInt();
    }

    public static long getLong(String key, long defaultValue) {
        if(TextUtils.isEmpty(key)) {
            return defaultValue;
        }
        CarData carData = CarDataManager.get(new CarData(new CarData.CarDataEntry(key, defaultValue)));
        return carData == null ? defaultValue : carData.getDataEntry(key).getValueLong();
    }

    public static short getShort(String key, short defaultValue) {
        if(TextUtils.isEmpty(key)) {
            return defaultValue;
        }
        CarData carData = CarDataManager.get(new CarData(new CarData.CarDataEntry(key, defaultValue)));
        return carData == null ? defaultValue : carData.getDataEntry(key).getValueShort();
    }

    public static void registerCarDataCallback(CarDataCallback callback, Handler handler) {
        if(handler == null) {
            Looper looper0 = Looper.myLooper();
            if(looper0 == null) {
                throw new IllegalArgumentException("No handler given, and current thread has no looper!");
            }
            handler = new Handler(looper0);
        }
        CarDataManagerGlobal.get().registerCarDataCallback(callback, handler);
    }

    public static boolean set(CarData data, boolean persistence) {
        return data == null ? false : CarDataManagerGlobal.get().set(data, persistence);
    }

    public static boolean set(String key, String value, boolean persistence) {
        return TextUtils.isEmpty(key) ? false : CarDataManager.set(new CarData(new CarData.CarDataEntry(key, value)), persistence);
    }

    public static boolean setBoolean(String key, boolean value, boolean persistence) {
        return TextUtils.isEmpty(key) ? false : CarDataManager.set(new CarData(new CarData.CarDataEntry(key, value)), persistence);
    }

    public static boolean setByte(String key, byte value, boolean persistence) {
        return TextUtils.isEmpty(key) ? false : CarDataManager.set(new CarData(new CarData.CarDataEntry(key, value)), persistence);
    }

    public static boolean setDouble(String key, double value, boolean persistence) {
        return TextUtils.isEmpty(key) ? false : CarDataManager.set(new CarData(new CarData.CarDataEntry(key, value)), persistence);
    }

    public static boolean setFloat(String key, float value, boolean persistence) {
        return TextUtils.isEmpty(key) ? false : CarDataManager.set(new CarData(new CarData.CarDataEntry(key, value)), persistence);
    }

    public static boolean setInt(String key, int value, boolean persistence) {
        return TextUtils.isEmpty(key) ? false : CarDataManager.set(new CarData(new CarData.CarDataEntry(key, value)), persistence);
    }

    public static boolean setLong(String key, long value, boolean persistence) {
        return TextUtils.isEmpty(key) ? false : CarDataManager.set(new CarData(new CarData.CarDataEntry(key, value)), persistence);
    }

    public static boolean setShort(String key, short value, boolean persistence) {
        return TextUtils.isEmpty(key) ? false : CarDataManager.set(new CarData(new CarData.CarDataEntry(key, value)), persistence);
    }

    public static void unregisterCarDataCallback(CarDataCallback callback) {
        CarDataManagerGlobal.get().unregisterCarDataCallback(callback);
    }
}

