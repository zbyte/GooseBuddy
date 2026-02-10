package com.yftech.car.tts;

import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.ArrayMap;
import android.util.Log;
import com.yftech.car.utils.MonitorServiceRestartManager.IMonitorCallback;
import com.yftech.car.utils.MonitorServiceRestartManager;

import java.util.Map;
import java.util.Map.Entry;

public class TtsManager {
    public static abstract class TtsCallBack {
        public void onPlayBegin() {
        }

        public void onPlayCompleted() {
        }

        public void onPlayInterrupted() {
        }

        public void onProgressReturn(int current, int total) {
        }

        public void onTtsInit(boolean isInit, int code) {
        }
    }

    static final class TtsManagerGlobal extends Stub implements IBinder.DeathRecipient, IMonitorCallback {
        private static final TtsManagerGlobal intance;
        private final ArrayMap mCallbackMap;
        private final Object mLock;
        private static ITtsService mService;

        static {
            TtsManagerGlobal.intance = new TtsManagerGlobal();
        }

        private TtsManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("TtsManager", "binder died,reconnect service car_tts after 1000ms!");
            synchronized(this.mLock) {
                if(TtsManagerGlobal.mService == null) {
                    return;
                }
                TtsManagerGlobal.mService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        private boolean connectServiceLocked() {
            if(TtsManagerGlobal.mService == null || TtsManagerGlobal.mService.asBinder() == null || !TtsManagerGlobal.mService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = ServiceManager.getService("car_tts");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        TtsManagerGlobal.mService = com.yftech.car.tts.ITtsService.Stub.asInterface(iBinder0);
                        TtsManagerGlobal.mService.registerCallBack(this);
                        return true;
                    }
                    Log.e("TtsManager", "the car dms service not started!connected service fail!");
                    return false;
                }
                catch(Exception e) {
                    Log.e("TtsManager", "link to death error!" + e.getMessage());
                    e.printStackTrace();
                }
            }
            else {
                return true;
            }
            return false;
        }

        public static TtsManagerGlobal get() {
            return TtsManagerGlobal.intance;
        }

        public ITtsService getTtsService() {
            synchronized(this.mLock) {
                if(!this.connectServiceLocked() || TtsManagerGlobal.mService == null) {
                    Log.e("TtsManager", "car pki service is unavailable");
                    this.startReconnectThread();
                }
                return TtsManagerGlobal.mService;
            }
        }

        @Override  // com.yftech.car.tts.ITtsCallback
        public void onPlayBegin() throws RemoteException {
            synchronized(this.mCallbackMap) {
                for(Object object0: this.mCallbackMap.entrySet()) {
                    Handler handler = (Handler)((Map.Entry)object0).getValue();
                    TtsCallBack callback = (TtsCallBack)((Map.Entry)object0).getKey();
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

        @Override  // com.yftech.car.tts.ITtsCallback
        public void onPlayCompleted() throws RemoteException {
            synchronized(this.mCallbackMap) {
                for(Object object0: this.mCallbackMap.entrySet()) {
                    Handler handler = (Handler)((Map.Entry)object0).getValue();
                    TtsCallBack callback = (TtsCallBack)((Map.Entry)object0).getKey();
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

        @Override  // com.yftech.car.tts.ITtsCallback
        public void onPlayInterrupted() throws RemoteException {
            synchronized(this.mCallbackMap) {
                for(Object object0: this.mCallbackMap.entrySet()) {
                    Handler handler = (Handler)((Map.Entry)object0).getValue();
                    TtsCallBack callback = (TtsCallBack)((Map.Entry)object0).getKey();
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

        @Override  // com.yftech.car.tts.ITtsCallback
        public void onProgressReturn(int current, int total) throws RemoteException {
            synchronized(this.mCallbackMap) {
                for(Object object0: this.mCallbackMap.entrySet()) {
                    Handler handler = (Handler)((Map.Entry)object0).getValue();
                    TtsCallBack callback = (TtsCallBack)((Map.Entry)object0).getKey();
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

        @Override  // com.yftech.car.tts.ITtsCallback
        public void onTtsInit(boolean isInit, int code) throws RemoteException {
            synchronized(this.mCallbackMap) {
                for(Object object0: this.mCallbackMap.entrySet()) {
                    Handler handler = (Handler)((Map.Entry)object0).getValue();
                    TtsCallBack callback = (TtsCallBack)((Map.Entry)object0).getKey();
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

        public void registerCallback(TtsCallBack callback, Handler handler) {
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
            MonitorServiceRestartManager.getInstance().addMonitor("car_tts", this);
        }

        public void unregisterCallback(TtsCallBack callback) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.remove(callback);
                }
            }
        }
    }

    public static final String SERVICE_NAME = "car_tts";
    private static final String TAG = "TtsManager";
    private static volatile TtsManager mInstance;

    // String Decryptor: 4 succeeded, 0 failed
    static String access$000() {
        return "TtsManager";
    }

    public static TtsManager getInstance() {
        if(TtsManager.mInstance == null) {
            Class class0 = TtsManager.class;
            synchronized(class0) {
                if(TtsManager.mInstance == null) {
                    TtsManager.mInstance = new TtsManager();
                }
            }
        }
        return TtsManager.mInstance;
    }

    public void registerCallback(TtsCallBack callback, Handler handler) {
        TtsManagerGlobal.get().registerCallback(callback, handler);
    }

    public void speak(String msg) {
        try {
            TtsManagerGlobal.get().getTtsService().speak(msg);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void stopSpeaking() {
        try {
            TtsManagerGlobal.get().getTtsService().stopSpeaking();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void unregisterCallback(TtsCallBack callback) {
        TtsManagerGlobal.get().unregisterCallback(callback);
    }
}

