package com.yftech.car.upgrade;

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
import java.util.HashSet;
import java.util.Set;

public class CarUpgradeManager {
    public static abstract class CarUpgradeCallback {
        private static final int DSP = 8;
        private static final int MCU = 2;
        private static final int MCU_BOOT = 0x20;
        private static final int OS = 1;
        private static final int SCREEN = 4;
        private static final int SCREEN_MCU = 16;
        private int mUpgradeType;

        public CarUpgradeCallback() {
            this.mUpgradeType = 0;
        }

        private boolean addUpgradeType(int type) {
            switch(type) {
                case 1: {
                    this.mUpgradeType |= 1;
                    return true;
                }
                case 2: {
                    this.mUpgradeType |= 2;
                    return true;
                }
                case 3: {
                    this.mUpgradeType |= 4;
                    return true;
                }
                case 4: {
                    this.mUpgradeType |= 8;
                    return true;
                }
                case 5: {
                    this.mUpgradeType |= 16;
                    return true;
                }
                case 6: {
                    this.mUpgradeType |= 0x20;
                    return true;
                }
                default: {
                    return false;
                }
            }
        }

        private boolean delUpgradeType(int type) {
            switch(type) {
                case 1: {
                    this.mUpgradeType &= -2;
                    return true;
                }
                case 2: {
                    this.mUpgradeType &= -3;
                    return true;
                }
                case 3: {
                    this.mUpgradeType &= -5;
                    return true;
                }
                case 4: {
                    this.mUpgradeType &= -9;
                    return true;
                }
                case 5: {
                    this.mUpgradeType &= -17;
                    return true;
                }
                case 6: {
                    this.mUpgradeType &= -33;
                    return true;
                }
                default: {
                    return false;
                }
            }
        }

        private boolean isThisUpgradeType(int type) {
            switch(type) {
                case 1: {
                    return (this.mUpgradeType & 1) != 0;
                }
                case 2: {
                    return (this.mUpgradeType & 2) != 0;
                }
                case 3: {
                    return (this.mUpgradeType & 4) != 0;
                }
                case 4: {
                    return (this.mUpgradeType & 8) != 0;
                }
                case 5: {
                    return (this.mUpgradeType & 16) != 0;
                }
                case 6: {
                    return (this.mUpgradeType & 0x20) != 0;
                }
                default: {
                    return false;
                }
            }
        }

        public void onUpgradeProgress(int module, int progress) {
        }

        public void onUpgradeState(int module, int state) {
        }
    }

    static final class CarUpgradeManagerGlobal extends ICarUpgradeCallback.Stub implements IBinder.DeathRecipient, IMonitorCallback {
        private static final CarUpgradeManagerGlobal CAR_UPGRADE_MANAGER_GLOBAL = new CarUpgradeManagerGlobal();
        private Set mAddUpgradeModuleList;
        private Set mAddUpgradeModuleListWhenStart;
        private final ArrayMap mCallbackMap;
        private static ICarUpgradeService mCarUpgradeService;
        private boolean mIsStartUpgrade;
        private final Object mLock;

        private CarUpgradeManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
            this.mAddUpgradeModuleList = new HashSet();
            this.mIsStartUpgrade = false;
        }

        int addUpgradeModule(int module, String[] pathList) {
            try {
                int v1 = this.getCarUpgradeService().addUpgradeModule(module, pathList);
                if(v1 == 1 && !this.mAddUpgradeModuleList.contains(Integer.valueOf(module))) {
                    this.mAddUpgradeModuleList.add(Integer.valueOf(module));
                }
                return v1;
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return 2;
            }
        }

        @Override  // com.yftech.car.upgrade.ICarUpgradeCallback$Stub
        public IBinder asBinder() {
            return this;
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("CarUpgradeManager", "binder died,reconnect service car_upgrade after 1000ms!");
            synchronized(this.mLock) {
                this.callbackUpgradeFailWhenServiceDieIfNeed();
                if(CarUpgradeManagerGlobal.mCarUpgradeService == null) {
                    return;
                }
                CarUpgradeManagerGlobal.mCarUpgradeService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        private void callbackUpgradeFailWhenServiceDieIfNeed() {
            if(!this.mIsStartUpgrade) {
                return;
            }
            if(this.mAddUpgradeModuleListWhenStart != null) {
                HashSet addUpgradeModuleList = new HashSet(this.mAddUpgradeModuleListWhenStart);
                this.mAddUpgradeModuleListWhenStart = null;
                for(Object object0: addUpgradeModuleList) {
                    Integer module = (Integer)object0;
                    try {
                        this.onUpgradeState(module.intValue(), 0x7FFFFFFF);
                        Log.i("CarUpgradeManager", "callbackUpgradeFailWhenServiceDieIfNeed, module=" + module);
                    }
                    catch(RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.mIsStartUpgrade = false;
        }

        boolean checkUpgradeFile(int module, String[] pathList) {
            try {
                return this.getCarUpgradeService().checkUpgradeFile(module, pathList);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return false;
            }
        }

        private boolean connectCarUpgradeServiceLocked() {
            if(CarUpgradeManagerGlobal.mCarUpgradeService == null || CarUpgradeManagerGlobal.mCarUpgradeService.asBinder() == null || !CarUpgradeManagerGlobal.mCarUpgradeService.asBinder().isBinderAlive()) {
                CarUpgradeManagerGlobal.mCarUpgradeService = null;
                IBinder iBinder0 = BinderUtils.getAliveServiceBinder("car_upgrade");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        CarUpgradeManagerGlobal.mCarUpgradeService = com.yftech.car.upgrade.ICarUpgradeService.Stub.asInterface(iBinder0);
                        CarUpgradeManagerGlobal.mCarUpgradeService.registerListener(this);
                        return true;
                    }
                    Log.e("CarUpgradeManager", "the car tbox service not started!connected service fail!");
                    return false;
                }
                catch(RemoteException e) {
                    Log.e("CarUpgradeManager", "link to death error!" + e.getMessage());
                    e.printStackTrace();
                }
            }
            else {
                return true;
            }

            return false;
        }

        public static CarUpgradeManagerGlobal get() {
            return CarUpgradeManagerGlobal.CAR_UPGRADE_MANAGER_GLOBAL;
        }

        public ICarUpgradeService getCarUpgradeService() {
            synchronized(this.mLock) {
                if(!this.connectCarUpgradeServiceLocked() || CarUpgradeManagerGlobal.mCarUpgradeService == null) {
                    Log.e("CarUpgradeManager", "car upgrade service is unavailable");
                    this.startReconnectThread();
                }
                return CarUpgradeManagerGlobal.mCarUpgradeService;
            }
        }

        CarUpgradeInfo getCurUpgradeingInfo() {
            try {
                return this.getCarUpgradeService().getCurUpgradeingInfo();
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return null;
            }
        }

        int[] getHasAddUpgradeModule() {
            try {
                return this.getCarUpgradeService().getHasAddUpgradeModule();
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return null;
            }
        }

        String getVersion(int module) {
            try {
                return this.getCarUpgradeService().getVersion(module);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return "";
            }
        }

        @Override  // com.yftech.car.utils.MonitorServiceRestartManager$IMonitorCallback
        public void onServiceStart(String serviceName) {
            this.connectCarUpgradeServiceLocked();
        }

        @Override  // com.yftech.car.upgrade.ICarUpgradeCallback
        public void onUpgradeProgress(int type, int progress) throws RemoteException {
            int v2 = this.mCallbackMap.size();
            for(int i = 0; i < v2; ++i) {
                Handler handler = (Handler)this.mCallbackMap.valueAt(i);
                CarUpgradeCallback callback = (CarUpgradeCallback)this.mCallbackMap.keyAt(i);
                if(callback.isThisUpgradeType(type)) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                        }
                    });
                }
            }
        }

        @Override  // com.yftech.car.upgrade.ICarUpgradeCallback
        public void onUpgradeState(int type, int state) throws RemoteException {
            int v2 = this.mCallbackMap.size();
            for(int i = 0; i < v2; ++i) {
                Handler handler = (Handler)this.mCallbackMap.valueAt(i);
                CarUpgradeCallback callback = (CarUpgradeCallback)this.mCallbackMap.keyAt(i);
                if(callback.isThisUpgradeType(type)) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                        }
                    });
                }
            }
            if(this.mIsStartUpgrade) {
                if(this.mAddUpgradeModuleListWhenStart != null && !this.mAddUpgradeModuleListWhenStart.isEmpty()) {
                    switch(type) {
                        case 1: {
                            if(state == 1 || state == 2) {
                                this.mAddUpgradeModuleListWhenStart.remove(Integer.valueOf(1));
                            }
                            break;
                        }
                        case 2: {
                            if(state == 1 || state == 2) {
                                this.mAddUpgradeModuleListWhenStart.remove(Integer.valueOf(2));
                            }
                            break;
                        }
                        case 3: {
                            if(state == 1 || state == 2) {
                                this.mAddUpgradeModuleListWhenStart.remove(Integer.valueOf(3));
                            }
                            break;
                        }
                        case 4: {
                            if(state == 1 || state == 2) {
                                this.mAddUpgradeModuleListWhenStart.remove(Integer.valueOf(4));
                            }
                            break;
                        }
                        case 5: {
                            if(state == 1 || state == 2) {
                                this.mAddUpgradeModuleListWhenStart.remove(Integer.valueOf(5));
                            }
                            break;
                        }
                        case 6: {
                            if(state == 1 || state == 2) {
                                this.mAddUpgradeModuleListWhenStart.remove(Integer.valueOf(6));
                            }
                        }
                    }
                }
                if(this.mAddUpgradeModuleListWhenStart == null || this.mAddUpgradeModuleListWhenStart.isEmpty()) {
                    this.mIsStartUpgrade = false;
                    this.mAddUpgradeModuleListWhenStart = null;
                }
            }
        }

        void registerCarUpgradeCallback(CarUpgradeCallback callback, Handler handler, int upgradeType) {
            synchronized(this.mLock) {
                if(!this.connectCarUpgradeServiceLocked()) {
                    this.startReconnectThread();
                }
                if(!callback.addUpgradeType(upgradeType)) {
                    Log.e("CarUpgradeManager", "registerCarUpgradeCallback: unknow upgrade type");
                }
                else if(!this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.put(callback, handler);
                }
            }
        }

        int removeUpgradeModule(int module) {
            try {
                int v1 = this.getCarUpgradeService().removeUpgradeModule(module);
                if(v1 == 1 && !this.mAddUpgradeModuleList.contains(Integer.valueOf(module))) {
                    this.mAddUpgradeModuleList.add(Integer.valueOf(module));
                }
                return v1;
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return 2;
            }
        }

        private void startReconnectThread() {
            MonitorServiceRestartManager.getInstance().addMonitor("car_upgrade", this);
        }

        boolean startUpgrade() {
            try {
                boolean z = this.getCarUpgradeService().startUpgrade();
                if(z) {
                    this.mAddUpgradeModuleListWhenStart = new HashSet(this.mAddUpgradeModuleList);
                    this.mAddUpgradeModuleList.clear();
                    this.mIsStartUpgrade = true;
                }
                return z;
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return false;
            }
        }

        void unregisterCarUpgradeCallback(CarUpgradeCallback callback, int upgradeType) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    callback.delUpgradeType(upgradeType);
                    if(callback.mUpgradeType == 0) {
                        this.mCallbackMap.remove(callback);
                    }
                }
            }
        }
    }

    public static final int ADD_UPGRADE_RET_FAIL = 2;
    public static final int ADD_UPGRADE_RET_FAIL_EXIST = 3;
    public static final int ADD_UPGRADE_RET_FAIL_PATH_NOT_EXIST = 5;
    public static final int ADD_UPGRADE_RET_FAIL_UPGRADING = 4;
    public static final int ADD_UPGRADE_RET_SUCCESS = 1;
    public static final int DSP_UPGRADE_STATE_CHECKING = 5;
    public static final int DSP_UPGRADE_STATE_COPYING = 4;
    public static final int DSP_UPGRADE_STATE_FAIL = 2;
    public static final int DSP_UPGRADE_STATE_FAIL_COPY = 9;
    public static final int DSP_UPGRADE_STATE_FAIL_FILE_NOT_EXIST = 8;
    public static final int DSP_UPGRADE_STATE_FAIL_MD5 = 10;
    public static final int DSP_UPGRADE_STATE_FAIL_READ_FIRMWARE_FILE = 11;
    public static final int DSP_UPGRADE_STATE_FAIL_REQUEST_UPGRADE = 12;
    public static final int DSP_UPGRADE_STATE_FAIL_UPGRADE_TIMEOUT = 13;
    public static final int DSP_UPGRADE_STATE_REQ_UPGRADE = 6;
    public static final int DSP_UPGRADE_STATE_START = 3;
    public static final int DSP_UPGRADE_STATE_SUCCESS = 1;
    public static final int DSP_UPGRADE_STATE_UPGRADING = 7;
    public static final int MCU_BOOT_UPGRADE_STATE_CHECKING = 5;
    public static final int MCU_BOOT_UPGRADE_STATE_COPYING = 4;
    public static final int MCU_BOOT_UPGRADE_STATE_FAIL = 2;
    public static final int MCU_BOOT_UPGRADE_STATE_FAIL_COPY = 9;
    public static final int MCU_BOOT_UPGRADE_STATE_FAIL_FILE_NOT_EXIST = 8;
    public static final int MCU_BOOT_UPGRADE_STATE_FAIL_MD5 = 10;
    public static final int MCU_BOOT_UPGRADE_STATE_FAIL_READ_FIRMWARE_FILE = 11;
    public static final int MCU_BOOT_UPGRADE_STATE_FAIL_REQUEST_UPGRADE = 12;
    public static final int MCU_BOOT_UPGRADE_STATE_FAIL_UPGRADE_TIMEOUT = 13;
    public static final int MCU_BOOT_UPGRADE_STATE_REQ_UPGRADE = 6;
    public static final int MCU_BOOT_UPGRADE_STATE_START = 3;
    public static final int MCU_BOOT_UPGRADE_STATE_SUCCESS = 1;
    public static final int MCU_BOOT_UPGRADE_STATE_UPGRADING = 7;
    public static final int MCU_UPGRADE_STATE_CHECKING = 5;
    public static final int MCU_UPGRADE_STATE_COPYING = 4;
    public static final int MCU_UPGRADE_STATE_FAIL = 2;
    public static final int MCU_UPGRADE_STATE_FAIL_COPY = 9;
    public static final int MCU_UPGRADE_STATE_FAIL_FILE_NOT_EXIST = 8;
    public static final int MCU_UPGRADE_STATE_FAIL_MD5 = 10;
    public static final int MCU_UPGRADE_STATE_FAIL_READ_FIRMWARE_FILE = 11;
    public static final int MCU_UPGRADE_STATE_FAIL_REQUEST_UPGRADE = 12;
    public static final int MCU_UPGRADE_STATE_FAIL_UPGRADE_TIMEOUT = 13;
    public static final int MCU_UPGRADE_STATE_REQ_UPGRADE = 6;
    public static final int MCU_UPGRADE_STATE_START = 3;
    public static final int MCU_UPGRADE_STATE_SUCCESS = 1;
    public static final int MCU_UPGRADE_STATE_UPGRADING = 7;
    public static final int OS_UPGRADE_STATE_CHECKING = 5;
    public static final int OS_UPGRADE_STATE_COPYING = 4;
    public static final int OS_UPGRADE_STATE_FAIL = 2;
    public static final int OS_UPGRADE_STATE_FAIL_COPY = 8;
    public static final int OS_UPGRADE_STATE_FAIL_ENTER_RECOVERY = 10;
    public static final int OS_UPGRADE_STATE_FAIL_FILE_NOT_EXIST = 7;
    public static final int OS_UPGRADE_STATE_FAIL_MD5 = 9;
    public static final int OS_UPGRADE_STATE_FAIL_UPGRADE_TIMEOUT = 11;
    public static final int OS_UPGRADE_STATE_START = 3;
    public static final int OS_UPGRADE_STATE_SUCCESS = 1;
    public static final int OS_UPGRADE_STATE_UPGRADING = 6;
    public static final int REMOVE_UPGRADE_RET_FAIL = 2;
    public static final int REMOVE_UPGRADE_RET_FAIL_UPGRADING = 3;
    public static final int REMOVE_UPGRADE_RET_SUCCESS = 1;
    public static final int SCREEN_MCU_UPGRADE_STATE_CHECKING = 5;
    public static final int SCREEN_MCU_UPGRADE_STATE_COPYING = 4;
    public static final int SCREEN_MCU_UPGRADE_STATE_FAIL = 2;
    public static final int SCREEN_MCU_UPGRADE_STATE_FAIL_COPY = 9;
    public static final int SCREEN_MCU_UPGRADE_STATE_FAIL_FILE_NOT_EXIST = 8;
    public static final int SCREEN_MCU_UPGRADE_STATE_FAIL_MD5 = 10;
    public static final int SCREEN_MCU_UPGRADE_STATE_FAIL_REQUEST_UPGRADE = 11;
    public static final int SCREEN_MCU_UPGRADE_STATE_FAIL_TIMEOUT = 12;
    public static final int SCREEN_MCU_UPGRADE_STATE_REQ_UPGRADE = 6;
    public static final int SCREEN_MCU_UPGRADE_STATE_START = 3;
    public static final int SCREEN_MCU_UPGRADE_STATE_SUCCESS = 1;
    public static final int SCREEN_MCU_UPGRADE_STATE_UPGRADING = 7;
    public static final int SCREEN_UPGRADE_STATE_CHECKING = 5;
    public static final int SCREEN_UPGRADE_STATE_COPYING = 4;
    public static final int SCREEN_UPGRADE_STATE_FAIL = 2;
    public static final int SCREEN_UPGRADE_STATE_FAIL_COPY = 9;
    public static final int SCREEN_UPGRADE_STATE_FAIL_FILE_NOT_EXIST = 8;
    public static final int SCREEN_UPGRADE_STATE_FAIL_MD5 = 10;
    public static final int SCREEN_UPGRADE_STATE_FAIL_REQUEST_UPGRADE = 11;
    public static final int SCREEN_UPGRADE_STATE_FAIL_UPGRADE_TIMEOUT = 12;
    public static final int SCREEN_UPGRADE_STATE_REQ_UPGRADE = 6;
    public static final int SCREEN_UPGRADE_STATE_START = 3;
    public static final int SCREEN_UPGRADE_STATE_SUCCESS = 1;
    public static final int SCREEN_UPGRADE_STATE_UPGRADING = 7;
    public static final String SERVICE_NAME = "car_upgrade";
    private static final String TAG  = "CarUpgradeManager";
    public static final int UPGRADE_FAIL_SERVER_DIE = 0x7FFFFFFF;
    public static final int UPGRADE_MODULE_DSP = 4;
    public static final int UPGRADE_MODULE_MCU = 2;
    public static final int UPGRADE_MODULE_MCU_BOOT = 6;
    public static final int UPGRADE_MODULE_OS = 1;
    public static final int UPGRADE_MODULE_SCREEN = 3;
    public static final int UPGRADE_MODULE_SCREEN_MCU = 5;
    private static volatile CarUpgradeManager mInstance;

    // String Decryptor: 6 succeeded, 0 failed
    static String access$000() {
        return "CarUpgradeManager";
    }

    public int addDSPUpgradeModule(String path) {
        return this.addUpgradeModule(4, new String[]{path});
    }

    public int addMCUBootUpgradeModule(String path) {
        return this.addUpgradeModule(6, new String[]{path});
    }

    public int addMCUUpgradeModule(String path) {
        return this.addUpgradeModule(2, new String[]{path});
    }

    public int addOSUpgradeModule(String path) {
        return this.addUpgradeModule(1, new String[]{path});
    }

    public int addScreenMcuUpgradeModule(String path) {
        return this.addUpgradeModule(5, new String[]{path});
    }

    public int addScreenUpgradeModule(String path) {
        return this.addUpgradeModule(3, new String[]{path});
    }

    private int addUpgradeModule(int module, String[] pathList) {
        return CarUpgradeManagerGlobal.get().addUpgradeModule(module, pathList);
    }

    public boolean checkDSPUpgradeFile(String path) {
        return this.checkUpgradeFile(new String[]{path}, 4);
    }

    public boolean checkMCUBootUpgradeFile(String path) {
        return this.checkUpgradeFile(new String[]{path}, 6);
    }

    public boolean checkMCUUpgradeFile(String path) {
        return this.checkUpgradeFile(new String[]{path}, 2);
    }

    public boolean checkOSUpgradeFile(String path) {
        return this.checkUpgradeFile(new String[]{path}, 1);
    }

    public boolean checkScreenMcuUpgradeFile(String path) {
        return this.checkUpgradeFile(new String[]{path}, 5);
    }

    public boolean checkScreenUpgradeFile(String path) {
        return this.checkUpgradeFile(new String[]{path}, 3);
    }

    private boolean checkUpgradeFile(String[] pathList, int upgradeType) {
        return CarUpgradeManagerGlobal.get().checkUpgradeFile(upgradeType, pathList);
    }

    public CarUpgradeInfo getCurUpgradingInfo() {
        return CarUpgradeManagerGlobal.get().getCurUpgradeingInfo();
    }

    public int[] getHasAddUpgradeModule() {
        return CarUpgradeManagerGlobal.get().getHasAddUpgradeModule();
    }

    public static CarUpgradeManager getInstance() {
        if(CarUpgradeManager.mInstance == null) {
            Class class0 = CarUpgradeManager.class;
            synchronized(class0) {
                if(CarUpgradeManager.mInstance == null) {
                    CarUpgradeManager.mInstance = new CarUpgradeManager();
                }
            }
        }
        return CarUpgradeManager.mInstance;
    }

    public String getVersion(int module) {
        return CarUpgradeManagerGlobal.get().getVersion(module);
    }

    public void registerCarDSPUpgradeCallback(CarUpgradeCallback callback, Handler handler) {
        this.registerCarUpgradeCallback(callback, handler, 4);
    }

    public void registerCarMCUBootUpgradeCallback(CarUpgradeCallback callback, Handler handler) {
        this.registerCarUpgradeCallback(callback, handler, 6);
    }

    public void registerCarMCUUpgradeCallback(CarUpgradeCallback callback, Handler handler) {
        this.registerCarUpgradeCallback(callback, handler, 2);
    }

    public void registerCarOSUpgradeCallback(CarUpgradeCallback callback, Handler handler) {
        this.registerCarUpgradeCallback(callback, handler, 1);
    }

    public void registerCarScreenMcuUpgradeCallback(CarUpgradeCallback callback, Handler handler) {
        this.registerCarUpgradeCallback(callback, handler, 5);
    }

    public void registerCarScreenUpgradeCallback(CarUpgradeCallback callback, Handler handler) {
        this.registerCarUpgradeCallback(callback, handler, 3);
    }

    private void registerCarUpgradeCallback(CarUpgradeCallback callback, Handler handler, int upgradeType) {
        if(handler == null) {
            Looper looper0 = Looper.myLooper();
            if(looper0 == null) {
                throw new IllegalArgumentException("No handler given, and current thread has no looper!");
            }
            handler = new Handler(looper0);
        }
        CarUpgradeManagerGlobal.get().registerCarUpgradeCallback(callback, handler, upgradeType);
    }

    public int removeDSPUpgradeModule() {
        return this.removeUpgradeModule(4);
    }

    public int removeMCUBootUpgradeModule() {
        return this.removeUpgradeModule(6);
    }

    public int removeMCUUpgradeModule() {
        return this.removeUpgradeModule(2);
    }

    public int removeOSUpgradeModule() {
        return this.removeUpgradeModule(1);
    }

    public int removeScreenMcuUpgradeModule() {
        return this.removeUpgradeModule(5);
    }

    public int removeScreenUpgradeModule() {
        return this.removeUpgradeModule(3);
    }

    private int removeUpgradeModule(int module) {
        return CarUpgradeManagerGlobal.get().removeUpgradeModule(module);
    }

    public boolean startUpgrade() {
        return CarUpgradeManagerGlobal.get().startUpgrade();
    }

    public void unregisterCarDSPUpgradeCallback(CarUpgradeCallback callback) {
        this.unregisterCarUpgradeCallback(callback, 4);
    }

    public void unregisterCarMCUBootUpgradeCallback(CarUpgradeCallback callback) {
        this.unregisterCarUpgradeCallback(callback, 6);
    }

    public void unregisterCarMCUUpgradeCallback(CarUpgradeCallback callback) {
        this.unregisterCarUpgradeCallback(callback, 2);
    }

    public void unregisterCarOSUpgradeCallback(CarUpgradeCallback callback) {
        this.unregisterCarUpgradeCallback(callback, 1);
    }

    public void unregisterCarScreenMcuUpgradeCallback(CarUpgradeCallback callback) {
        this.unregisterCarUpgradeCallback(callback, 5);
    }

    public void unregisterCarScreenUpgradeCallback(CarUpgradeCallback callback) {
        this.unregisterCarUpgradeCallback(callback, 3);
    }

    private void unregisterCarUpgradeCallback(CarUpgradeCallback callback, int upgradeType) {
        CarUpgradeManagerGlobal.get().unregisterCarUpgradeCallback(callback, upgradeType);
    }
}

