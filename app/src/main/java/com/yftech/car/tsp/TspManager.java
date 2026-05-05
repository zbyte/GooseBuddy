package com.yftech.car.tsp;

import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.util.ArrayMap;
import android.util.Log;

import com.yftech.car.utils.BinderUtils;
import com.yftech.car.utils.MonitorServiceRestartManager.IMonitorCallback;
import com.yftech.car.utils.MonitorServiceRestartManager;

import java.util.Map;
import java.util.Map.Entry;

public class TspManager {
    public static abstract class TspCallBack {
        public void onFlowPurchaseH5Link(String result) {
        }

        public void onGenerateSharingCodeCallBack(int pid, String result) {
        }

        public void onQuerySharingCodeInfoCallBack(int pid, String result) {
        }
    }

    static final class TspManagerGlobal extends ITspCallback.Stub implements IBinder.DeathRecipient, IMonitorCallback {
        private static final TspManagerGlobal intance = new TspManagerGlobal();
        private final ArrayMap mCallbackMap;
        private final Object mLock;
        private static ITspService mService;

        private TspManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("TspManager", "binder died,reconnect service car_tsp after 1000ms!");
            synchronized(this.mLock) {
                if(TspManagerGlobal.mService == null) {
                    return;
                }
                TspManagerGlobal.mService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        private boolean connectServiceLocked() {
            if(TspManagerGlobal.mService == null || TspManagerGlobal.mService.asBinder() == null || !TspManagerGlobal.mService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = BinderUtils.getAliveServiceBinder("car_tsp");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        TspManagerGlobal.mService = com.yftech.car.tsp.ITspService.Stub.asInterface(iBinder0);
                        TspManagerGlobal.mService.registerCallBack(this);
                        return true;
                    }
                    Log.e("TspManager", "the car dms service not started!connected service fail!");
                    return false;
                }
                catch(Exception e) {
                    Log.e("TspManager", "link to death error!" + e.getMessage());
                    e.printStackTrace();
                }
            }
            else {
                return true;
            }

            return false;
        }

        public static TspManagerGlobal get() {
            return TspManagerGlobal.intance;
        }

        public ITspService getTspService() {
            synchronized(this.mLock) {
                if(!this.connectServiceLocked() || TspManagerGlobal.mService == null) {
                    Log.e("TspManager", "car pki service is unavailable");
                    this.startReconnectThread();
                }
                return TspManagerGlobal.mService;
            }
        }

        @Override  // com.yftech.car.tsp.ITspCallback
        public void onFlowPurchaseH5Link(String result) {
            synchronized(this.mCallbackMap) {
                for(Object object0: this.mCallbackMap.entrySet()) {
                    Handler handler = (Handler)((Map.Entry)object0).getValue();
                    TspCallBack callback = (TspCallBack)((Map.Entry)object0).getKey();
                    if(handler != null) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                            }
                        });
                    }
                }
            }
        }

        @Override  // com.yftech.car.tsp.ITspCallback
        public void onGenerateSharingCodeCallBack(int pid, String result) {
            synchronized(this.mCallbackMap) {
                for(Object object0: this.mCallbackMap.entrySet()) {
                    Handler handler = (Handler)((Map.Entry)object0).getValue();
                    TspCallBack callback = (TspCallBack)((Map.Entry)object0).getKey();
                    if(handler != null) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                            }
                        });
                    }
                }
            }
        }

        @Override  // com.yftech.car.tsp.ITspCallback
        public void onQuerySharingCodeInfoCallBack(int pid, String result) {
            synchronized(this.mCallbackMap) {
                for(Object object0: this.mCallbackMap.entrySet()) {
                    Handler handler = (Handler)((Map.Entry)object0).getValue();
                    TspCallBack callback = (TspCallBack)((Map.Entry)object0).getKey();
                    if(handler != null) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                            }
                        });
                    }
                }
            }
        }

        @Override  // com.yftech.car.utils.MonitorServiceRestartManager$IMonitorCallback
        public void onServiceStart(String serviceName) {
            this.connectServiceLocked();
        }

        public void registerCallback(TspCallBack callback, Handler handler) {
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
            MonitorServiceRestartManager.getInstance().addMonitor("car_tsp", this);
        }

        public void unregisterCallback(TspCallBack callback) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.remove(callback);
                }
            }
        }
    }

    public static final String SERVICE_NAME = "car_tsp";
    private static final String TAG = "TspManager";
    private static volatile TspManager mInstance;

    // String Decryptor: 4 succeeded, 0 failed
    static String access$000() {
        return "TspManager";
    }

    public void generateSharingCode(String data, String vin, String userId) {
        try {
            TspManagerGlobal.get().getTspService().generateSharingCode(data, vin, userId);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void getFlowPurchaseH5Link() {
        try {
            TspManagerGlobal.get().getTspService().getFlowPurchaseH5Link();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static TspManager getInstance() {
        if(TspManager.mInstance == null) {
            Class class0 = TspManager.class;
            synchronized(class0) {
                if(TspManager.mInstance == null) {
                    TspManager.mInstance = new TspManager();
                }
            }
        }
        return TspManager.mInstance;
    }

    public void querySharingCodeInfo(String sharingCode) {
        try {
            TspManagerGlobal.get().getTspService().querySharingCodeInfo(sharingCode);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void registerCallback(TspCallBack callback, Handler handler) {
        TspManagerGlobal.get().registerCallback(callback, handler);
    }

    public void unregisterCallback(TspCallBack callback) {
        TspManagerGlobal.get().unregisterCallback(callback);
    }
}

