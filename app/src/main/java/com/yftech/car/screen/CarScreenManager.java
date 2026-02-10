package com.yftech.car.screen;

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

public class CarScreenManager {
    public static enum BrightnessReason {
        USER,
        AUTO;

    }

    public static abstract class CarScreenCallback {
        public void onChangedDayNightMode(int mode) {
        }

        public void onChangedDayNightMode(int displayId, int mode) {
        }

        public void onChangedScreenBrightness(int displayId, boolean open, int brightness) {
        }

        public void onChangedScreenBrightness(int displayId, boolean open, int brightness, BrightnessReason reason) {
        }

        public void onChangedScreenBrightness(boolean open, int brightness) {
        }

        public void onChangedScreenFold(int displayId, boolean isFold) {
        }
    }

    static final class CarScreenManagerGlobal extends Stub implements IBinder.DeathRecipient, IMonitorCallback {
        private static final CarScreenManagerGlobal CAR_SCREEN_MANAGER_GLOBAL;
        private final ArrayMap mCallbackMap;
        private static ICarScreenService mCarScreenService;
        private final Object mLock;

        static {
            CarScreenManagerGlobal.CAR_SCREEN_MANAGER_GLOBAL = new CarScreenManagerGlobal();
        }

        private CarScreenManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
        }

        @Override  // com.yftech.car.screen.ICarScreenCallback$Stub
        public IBinder asBinder() {
            return this;
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("CarScreenManager", "binder died,reconnect service car_screen after 1000ms!");
            synchronized(this.mLock) {
                if(CarScreenManagerGlobal.mCarScreenService == null) {
                    return;
                }
                CarScreenManagerGlobal.mCarScreenService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        boolean closeScreenBrightness(int displayId, int type) {
            try {
                return this.getCarScreenService().closeScreenBrightness(displayId, type);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return false;
            }
        }

        private boolean connectCarScreenServiceLocked() {
            if(CarScreenManagerGlobal.mCarScreenService == null || CarScreenManagerGlobal.mCarScreenService.asBinder() == null || !CarScreenManagerGlobal.mCarScreenService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = ServiceManager.getService("car_screen");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        CarScreenManagerGlobal.mCarScreenService = com.yftech.car.screen.ICarScreenService.Stub.asInterface(iBinder0);
                        CarScreenManagerGlobal.mCarScreenService.registerCarScreenCallback(this);
                        return true;
                    }
                    Log.e("CarScreenManager", "the car screen service not started!connected service fail!");
                    return false;
                }
                catch(RemoteException e) {
                }
            }
            else {
                return true;
            }
            Log.e("CarScreenManager", "link to death error!" + e.getMessage());
            e.printStackTrace();
            return false;
        }

        boolean foldScreen(int displayId) {
            try {
                return this.getCarScreenService().foldScreen(displayId);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return false;
            }
        }

        public static CarScreenManagerGlobal get() {
            return CarScreenManagerGlobal.CAR_SCREEN_MANAGER_GLOBAL;
        }

        int getBrightness(int displayId) {
            try {
                return this.getCarScreenService().getBrightness(displayId);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return -1;
            }
        }

        int getBrightnessMaxValue(int displayId) {
            try {
                return this.getCarScreenService().getBrightnessMaxValue(displayId);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return -1;
            }
        }

        public ICarScreenService getCarScreenService() {
            synchronized(this.mLock) {
                if(!this.connectCarScreenServiceLocked() || CarScreenManagerGlobal.mCarScreenService == null) {
                    Log.e("CarScreenManager", "car screen service is unavailable");
                    this.startReconnectThread();
                }
                return CarScreenManagerGlobal.mCarScreenService;
            }
        }

        int getDayNightMode(int displayId) {
            try {
                return this.getCarScreenService().getDayNightMode(displayId);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return -1;
            }
        }

        boolean isOpenScreenBrightness(int displayId) {
            try {
                return this.getCarScreenService().isOpenScreenBrightness(displayId);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return true;
            }
        }

        boolean isScreenFold(int displayId) {
            try {
                return this.getCarScreenService().isScreenFold(displayId);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override  // com.yftech.car.screen.ICarScreenCallback
        public void onChangedDayNightMode(int displayId, int mode) throws RemoteException {
            synchronized(this.mLock) {
                int v3 = this.mCallbackMap.size();
                for(int i = 0; i < v3; ++i) {
                    ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                        @Override
                        public void run() {
                        }
                    });
                }
            }
        }

        @Override  // com.yftech.car.screen.ICarScreenCallback
        public void onChangedScreenBrightness(int displayId, boolean open, int brightness) throws RemoteException {
            synchronized(this.mLock) {
                int v3 = this.mCallbackMap.size();
                for(int i = 0; i < v3; ++i) {
                    ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                        @Override
                        public void run() {
                        }
                    });
                }
            }
        }

        @Override  // com.yftech.car.screen.ICarScreenCallback
        public void onChangedScreenBrightness2(int displayId, boolean open, int brightness, int reason) throws RemoteException {
            synchronized(this.mLock) {
                int v4 = this.mCallbackMap.size();
                for(int i = 0; i < v4; ++i) {
                    ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                        @Override
                        public void run() {
                            BrightnessReason[] arr_carScreenManager$BrightnessReason = BrightnessReason.values();
                            for(int v = 0; v < arr_carScreenManager$BrightnessReason.length && arr_carScreenManager$BrightnessReason[v].ordinal() != reason; ++v) {
                            }
                        }
                    });
                }
            }
        }

        @Override  // com.yftech.car.screen.ICarScreenCallback
        public void onChangedScreenFold(int displayId, boolean isFold) throws RemoteException {
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

        @Override  // com.yftech.car.utils.MonitorServiceRestartManager$IMonitorCallback
        public void onServiceStart(String serviceName) {
            this.connectCarScreenServiceLocked();
        }

        boolean openScreenBrightness(int displayId, int type) {
            try {
                return this.getCarScreenService().openScreenBrightness(displayId, type);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return false;
            }
        }

        public void registerCarScreenCallback(CarScreenCallback callback, Handler handler) {
            synchronized(this.mLock) {
                if(!this.connectCarScreenServiceLocked()) {
                    this.startReconnectThread();
                }
                if(!this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.put(callback, handler);
                }
            }
        }

        boolean setBrightness(int displayId, int brightness) {
            try {
                return this.getCarScreenService().setBrightness(displayId, brightness);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean setBrightness(int displayId, int brightness, BrightnessReason reason) {
            try {
                return this.getCarScreenService().setBrightness2(displayId, brightness, reason.ordinal());
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean setDayNightMode(int displayId, int mode) {
            try {
                return this.getCarScreenService().setDayNightMode(displayId, mode);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return false;
            }
        }

        private void startReconnectThread() {
            MonitorServiceRestartManager.getInstance().addMonitor("car_screen", this);
        }

        boolean unfoldScreen(int displayId) {
            try {
                return this.getCarScreenService().unfoldScreen(displayId);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return false;
            }
        }

        public void unregisterCarScreenCallback(CarScreenCallback callback) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.remove(callback);
                }
            }
        }
    }

    public static final int DISPLAY_ID_DASHBOARD = 2;
    public static final int DISPLAY_ID_HU_AIR = 1;
    public static final int DISPLAY_ID_HU_MAIN = 0;
    public static final int DISPLAY_ID_HU_SECOND = 3;
    public static final int DISPLAY_ID_REAR_SEAT_SCREEN_LEFT = 4;
    public static final int DISPLAY_ID_REAR_SEAT_SCREEN_RIGHT = 5;
    public static final int DISPLAY_ID_REMOTE_DASHBOARD = 0x1000002;
    public static final int DISPLAY_ID_REMOTE_HU_AIR = 0x1000001;
    public static final int DISPLAY_ID_REMOTE_HU_MAIN = 0x1000000;
    public static final int DISPLAY_ID_REMOTE_HU_SECOND = 0x1000003;
    public static final int DISPLAY_ID_REMOTE_REAR_SEAT_SCREEN_LEFT = 0x1000004;
    public static final int DISPLAY_ID_REMOTE_REAR_SEAT_SCREEN_RIGHT = 0x1000005;
    public static final int MODE_AUTO = 2;
    public static final int MODE_DAY = 0;
    public static final int MODE_NIGHT = 1;
    private static final int REMOTE_DISPLAY_ID_MARK = 0x1000000;
    public static final String SERVICE_NAME = "car_screen";
    private static final String TAG = null;
    public static final int TYPE_FORCE = -1;
    public static final int TYPE_FOREVER = 1;
    public static final int TYPE_TRANSIENT;
    private static volatile CarScreenManager mInstance;

    static {
        CarScreenManager.TAG = "CarScreenManager";
    }

    // String Decryptor: 4 succeeded, 0 failed
    static String access$000() {
        return "CarScreenManager";
    }

    public boolean closeScreenBrightness(int type) {
        return this.closeScreenBrightness(0, type);
    }

    public boolean closeScreenBrightness(int displayId, int type) {
        return CarScreenManagerGlobal.get().closeScreenBrightness(displayId, type);
    }

    public static int convertToLocalDisplayIdFromRemoteDisplayId(int remoteDisplayId) {
        return 0xFEFFFFFF & remoteDisplayId;
    }

    public static int convertToRemoteDisplayIdFromLocalDisplayId(int localDisplayId) {
        return 0xFEFFFFFF & localDisplayId | 0x1000000;
    }

    public boolean foldScreen(int displayId) {
        return CarScreenManagerGlobal.get().foldScreen(displayId);
    }

    public int getBrightness() {
        return this.getBrightness(0);
    }

    public int getBrightness(int displayId) {
        return CarScreenManagerGlobal.get().getBrightness(displayId);
    }

    public int getBrightnessMaxValue() {
        return this.getBrightnessMaxValue(0);
    }

    public int getBrightnessMaxValue(int displayId) {
        return CarScreenManagerGlobal.get().getBrightnessMaxValue(displayId);
    }

    public int getDayNightMode() {
        return this.getDayNightMode(0);
    }

    public int getDayNightMode(int displayId) {
        return CarScreenManagerGlobal.get().getDayNightMode(displayId);
    }

    public static CarScreenManager getInstance() {
        if(CarScreenManager.mInstance == null) {
            Class class0 = CarScreenManager.class;
            synchronized(class0) {
                if(CarScreenManager.mInstance == null) {
                    CarScreenManager.mInstance = new CarScreenManager();
                }
            }
        }
        return CarScreenManager.mInstance;
    }

    public boolean isOpenScreenBrightness() {
        return this.isOpenScreenBrightness(0);
    }

    public boolean isOpenScreenBrightness(int displayId) {
        return CarScreenManagerGlobal.get().isOpenScreenBrightness(displayId);
    }

    public static boolean isRemoteDisplay(int displayId) {
        return (displayId & 0x1000000) == 0x1000000;
    }

    public boolean isScreenFold(int displayId) {
        return CarScreenManagerGlobal.get().isScreenFold(displayId);
    }

    public boolean openScreenBrightness(int type) {
        return this.openScreenBrightness(0, type);
    }

    public boolean openScreenBrightness(int display, int type) {
        return CarScreenManagerGlobal.get().openScreenBrightness(display, type);
    }

    public void registerCarScreenCallback(CarScreenCallback callback, Handler handler) {
        if(handler == null) {
            Looper looper0 = Looper.myLooper();
            if(looper0 == null) {
                throw new IllegalArgumentException("No handler given, and current thread has no looper!");
            }
            handler = new Handler(looper0);
        }
        CarScreenManagerGlobal.get().registerCarScreenCallback(callback, handler);
    }

    public boolean setBrightness(int brightness) {
        return this.setBrightness(0, brightness);
    }

    public boolean setBrightness(int displayId, int brightness) {
        return CarScreenManagerGlobal.get().setBrightness(displayId, brightness);
    }

    public boolean setBrightness(int displayId, int brightness, BrightnessReason reason) {
        return CarScreenManagerGlobal.get().setBrightness(displayId, brightness, reason);
    }

    public boolean setDayNightMode(int mode) {
        return this.setDayNightMode(0, mode);
    }

    public boolean setDayNightMode(int displayId, int mode) {
        return CarScreenManagerGlobal.get().setDayNightMode(displayId, mode);
    }

    public boolean unfoldScreen(int displayId) {
        return CarScreenManagerGlobal.get().unfoldScreen(displayId);
    }

    public void unregisterCarScreenCallback(CarScreenCallback callback) {
        CarScreenManagerGlobal.get().unregisterCarScreenCallback(callback);
    }
}

