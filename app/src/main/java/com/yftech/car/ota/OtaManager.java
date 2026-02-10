package com.yftech.car.ota;

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

public class OtaManager {
    static final class OtaManagerGlobal extends Stub implements IBinder.DeathRecipient, IMonitorCallback {
        private static final OtaManagerGlobal OTA_MANAGER_GLOBAL;
        private final ArrayMap mCallbackMap;
        private final Object mLock;
        private IOtaService mOtaService;
        private final List mServiceStartRunnable;

        static {
            OtaManagerGlobal.OTA_MANAGER_GLOBAL = new OtaManagerGlobal();
        }

        private OtaManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
            this.mServiceStartRunnable = new ArrayList();
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("OtaManager", "binder died,reconnect service car_ota after 1000ms!");
            synchronized(this.mLock) {
                if(this.mOtaService == null) {
                    return;
                }
                this.mOtaService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        private boolean connectOtaServiceLocked() {
            if(this.mOtaService == null || this.mOtaService.asBinder() == null || !this.mOtaService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = ServiceManager.getService("car_ota");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        this.mOtaService = com.yftech.car.ota.IOtaService.Stub.asInterface(iBinder0);
                        this.mOtaService.registerOtaStateChangeListener(this);
                        return true;
                    }
                    Log.e("OtaManager", "the ota service not started!connected service fail!");
                    return false;
                }
                catch(RemoteException e) {
                }
            }
            else {
                return true;
            }
            Log.e("OtaManager", "link to death error!" + e.getMessage());
            e.printStackTrace();
            return false;
        }

        public void exitOtaMode() {
            synchronized(this.mLock) {
                this.mOtaService = this.getOtaService();
                if(this.mOtaService != null) {
                    try {
                        this.mOtaService.exitOtaMode();
                    }
                    catch(RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public static OtaManagerGlobal get() {
            return OtaManagerGlobal.OTA_MANAGER_GLOBAL;
        }

        public IOtaService getOtaService() {
            synchronized(this.mLock) {
                if(!this.connectOtaServiceLocked() || this.mOtaService == null) {
                    Log.e("OtaManager", "car ota service is unavailable");
                    this.startReconnectThread();
                }
                return this.mOtaService;
            }
        }

        public ScheduleField getScheduleField() {
            synchronized(this.mLock) {
                this.mOtaService = this.getOtaService();
                if(this.mOtaService != null) {
                    try {
                        return this.mOtaService.getScheduleField();
                    }
                    catch(RemoteException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        }

        public boolean isOtaMode() {
            synchronized(this.mLock) {
                this.mOtaService = this.getOtaService();
                if(this.mOtaService != null) {
                    try {
                        return this.mOtaService.isOtaMode();
                    }
                    catch(RemoteException e) {
                        e.printStackTrace();
                        return false;
                    }
                }
                return false;
            }
        }

        @Override  // com.yftech.car.ota.IOtaStateChangeListener
        public void onOtaStateChanged(boolean isOtaMode) throws RemoteException {
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
            this.connectOtaServiceLocked();
            synchronized(this.mServiceStartRunnable) {
                for(Object object0: this.mServiceStartRunnable) {
                    ((Runnable)object0).run();
                }
                this.mServiceStartRunnable.clear();
            }
        }

        public void openOtaMode() {
            synchronized(this.mLock) {
                this.mOtaService = this.getOtaService();
                if(this.mOtaService != null) {
                    try {
                        this.mOtaService.openOtaMode();
                    }
                    catch(RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void registerOtaStateChangeListener(OtaStateChangeListener listener, Handler handler) {
            synchronized(this.mLock) {
                if(listener == null) {
                    throw new NullPointerException("listener is null,callback Cannot be empty");
                }
                if(!this.connectOtaServiceLocked()) {
                    this.startReconnectThread();
                }
                if(!this.mCallbackMap.containsKey(listener)) {
                    this.mCallbackMap.put(listener, handler);
                }
            }
        }

        public void setScheduleField(ScheduleField field) {
            synchronized(this.mLock) {
                this.mOtaService = this.getOtaService();
                if(this.mOtaService != null) {
                    try {
                        this.mOtaService.setScheduleField(field);
                    }
                    catch(RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void startReconnectThread() {
            MonitorServiceRestartManager.getInstance().addMonitor("car_ota", this);
        }

        public void unregisterOtaStateChangeListener(OtaStateChangeListener listener) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(listener)) {
                    this.mCallbackMap.remove(listener);
                }
            }
        }
    }

    public static abstract class OtaStateChangeListener {
        public void onOtaStateChanged(boolean isOtaMode) {
        }
    }

    public static final String SERVICE_NAME = "car_ota";
    private static final String TAG;
    public static volatile OtaManager mInstance;

    static {
        OtaManager.TAG = "OtaManager";
    }

    // String Decryptor: 4 succeeded, 0 failed
    static String access$100() {
        return "OtaManager";
    }

    public void exitOtaMode() {
        OtaManagerGlobal.get().exitOtaMode();
    }

    public static OtaManager getInstance() {
        if(OtaManager.mInstance == null) {
            Class class0 = OtaManager.class;
            synchronized(class0) {
                if(OtaManager.mInstance == null) {
                    OtaManager.mInstance = new OtaManager();
                }
            }
        }
        return OtaManager.mInstance;
    }

    public ScheduleField getScheduleField() {
        return OtaManagerGlobal.get().getScheduleField();
    }

    public boolean isOtaMode() {
        return OtaManagerGlobal.get().isOtaMode();
    }

    public void openOtaMode() {
        OtaManagerGlobal.get().openOtaMode();
    }

    public void registerOtaStateChangeListener(OtaStateChangeListener listener, Handler handler) {
        if(handler == null) {
            Looper looper0 = Looper.myLooper();
            if(looper0 == null) {
                throw new IllegalArgumentException("No handler given, and current thread has no looper!");
            }
            handler = new Handler(looper0);
        }
        OtaManagerGlobal.get().registerOtaStateChangeListener(listener, handler);
    }

    public void setScheduleField(ScheduleField field) {
        OtaManagerGlobal.get().setScheduleField(field);
    }

    public void unregisterOtaStateChangeListener(OtaStateChangeListener listener) {
        OtaManagerGlobal.get().unregisterOtaStateChangeListener(listener);
    }
}

