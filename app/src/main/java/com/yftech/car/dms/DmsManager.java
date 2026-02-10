package com.yftech.car.dms;

import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.os.ServiceManager;
import android.util.ArrayMap;
import android.util.Log;
import com.yftech.car.utils.MonitorServiceRestartManager.IMonitorCallback;
import com.yftech.car.utils.MonitorServiceRestartManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class DmsManager {
    public static abstract class DmsCallBack {
        public void onAlarmStateChanged(boolean isOn) {
        }

        public void onDmsErrorState(int code, String reason) {
        }

        public void onRecognitionResult(DmsRecognitionResult result) {
        }

        public void onRegisterResult(DmsRegisterResult result) {
        }
    }

    static final class DmsManagerGlobal extends Stub implements IBinder.DeathRecipient, IMonitorCallback {
        private static final DmsManagerGlobal intance;
        private final ArrayMap mCallbackMap;
        private final Object mLock;
        private static IDmsService mService;

        static {
            DmsManagerGlobal.intance = new DmsManagerGlobal();
        }

        private DmsManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("DmsManager", "binder died,reconnect service car_dms after 1000ms!");
            synchronized(this.mLock) {
                if(DmsManagerGlobal.mService == null) {
                    return;
                }
                DmsManagerGlobal.mService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        private boolean connectServiceLocked() {
            if(DmsManagerGlobal.mService == null || DmsManagerGlobal.mService.asBinder() == null || !DmsManagerGlobal.mService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = ServiceManager.getService("car_dms");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        DmsManagerGlobal.mService = com.yftech.car.dms.IDmsService.Stub.asInterface(iBinder0);
                        DmsManagerGlobal.mService.registerCallBack(this);
                        return true;
                    }
                    Log.e("DmsManager", "the car dms service not started!connected service fail!");
                    return false;
                }
                catch(Exception e) {
                }
            }
            else {
                return true;
            }
            Log.e("DmsManager", "link to death error!" + e.getMessage());
            e.printStackTrace();
            return false;
        }

        public static DmsManagerGlobal get() {
            return DmsManagerGlobal.intance;
        }

        public IDmsService getDmsService() {
            synchronized(this.mLock) {
                if(!this.connectServiceLocked() || DmsManagerGlobal.mService == null) {
                    Log.e("DmsManager", "car pki service is unavailable");
                    this.startReconnectThread();
                }
                return DmsManagerGlobal.mService;
            }
        }

        @Override  // com.yftech.car.dms.IDmsCallback
        public void onAlarmStateChanged(boolean isOn) {
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

        @Override  // com.yftech.car.dms.IDmsCallback
        public void onDmsErrorState(int code, String reason) {
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

        @Override  // com.yftech.car.dms.IDmsCallback
        public void onRecognitionResult(DmsRecognitionResult result) {
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

        @Override  // com.yftech.car.dms.IDmsCallback
        public void onRegisterResult(DmsRegisterResult result) {
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
            this.connectServiceLocked();
        }

        public void registerCallback(DmsCallBack callback, Handler handler) {
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
            MonitorServiceRestartManager.getInstance().addMonitor("car_dms", this);
        }

        public void unregisterCallback(DmsCallBack callback) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.remove(callback);
                }
            }
        }
    }

    public static final String SERVICE_NAME = "car_dms";
    private static final String TAG;
    private static volatile DmsManager mInstance;

    static {
        DmsManager.TAG = "DmsManager";
    }

    // String Decryptor: 4 succeeded, 0 failed
    static String access$000() {
        return "DmsManager";
    }

    public void cancelFaceRecognition() {
        try {
            DmsManagerGlobal.get().getDmsService().cancelFaceRecognition();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelFaceRegistration() {
        try {
            DmsManagerGlobal.get().getDmsService().cancelFaceRegistration();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelFaceSession(long sessionId) {
        try {
            DmsManagerGlobal.get().getDmsService().cancelFaceSession(sessionId);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void confirmFaceRegister(long faceId) {
        try {
            DmsManagerGlobal.get().getDmsService().confirmFaceRegister(faceId);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAllFace() {
        try {
            DmsManagerGlobal.get().getDmsService().deleteAllFace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteFace(long faceId) {
        try {
            DmsManagerGlobal.get().getDmsService().deleteFace(faceId);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteFaceData(String name) {
        try {
            DmsManagerGlobal.get().getDmsService().deleteFaceData(name);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disable() {
        try {
            DmsManagerGlobal.get().getDmsService().disable();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableCalling() {
        try {
            DmsManagerGlobal.get().getDmsService().disableCalling();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableDistraction() {
        try {
            DmsManagerGlobal.get().getDmsService().disableDistraction();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableFaceID() {
        try {
            DmsManagerGlobal.get().getDmsService().disableFaceID();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableFatigue() {
        try {
            DmsManagerGlobal.get().getDmsService().disableFatigue();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableGaze() {
        try {
            DmsManagerGlobal.get().getDmsService().disableGaze();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableImageAnomaly() {
        try {
            DmsManagerGlobal.get().getDmsService().disableImageAnomaly();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableSmoking() {
        try {
            DmsManagerGlobal.get().getDmsService().disableSmoking();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enable() {
        try {
            DmsManagerGlobal.get().getDmsService().enable();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableCalling() {
        try {
            DmsManagerGlobal.get().getDmsService().enableCalling();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableDistraction() {
        try {
            DmsManagerGlobal.get().getDmsService().enableDistraction();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableFaceID() {
        try {
            DmsManagerGlobal.get().getDmsService().enableFaceID();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableFatigue() {
        try {
            DmsManagerGlobal.get().getDmsService().enableFatigue();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableGaze() {
        try {
            DmsManagerGlobal.get().getDmsService().enableGaze();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableImageAnomaly() {
        try {
            DmsManagerGlobal.get().getDmsService().enableImageAnomaly();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableSmoking() {
        try {
            DmsManagerGlobal.get().getDmsService().enableSmoking();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public long[] getAllFaceIdList() {
        try {
            return DmsManagerGlobal.get().getDmsService().getAllFaceIdList();
        }
        catch(Exception e) {
            e.printStackTrace();
            return new long[0];
        }
    }

    public int getDmsErrorCode() {
        try {
            return DmsManagerGlobal.get().getDmsService().getDmsErrorCode();
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static DmsManager getInstance() {
        if(DmsManager.mInstance == null) {
            Class class0 = DmsManager.class;
            synchronized(class0) {
                if(DmsManager.mInstance == null) {
                    DmsManager.mInstance = new DmsManager();
                }
            }
        }
        return DmsManager.mInstance;
    }

    public List getRegisteredNameList() {
        try {
            return DmsManagerGlobal.get().getDmsService().getRegisteredNameList();
        }
        catch(Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public boolean isEnable() {
        try {
            return DmsManagerGlobal.get().getDmsService().isEnable();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableDistraction() {
        try {
            return DmsManagerGlobal.get().getDmsService().isEnableDistraction();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableFaceID() {
        try {
            return DmsManagerGlobal.get().getDmsService().isEnableFaceID();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableFatigue() {
        try {
            return DmsManagerGlobal.get().getDmsService().isEnableFatigue();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableGaze() {
        try {
            return DmsManagerGlobal.get().getDmsService().isEnableGaze();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableImageAnomaly() {
        try {
            return DmsManagerGlobal.get().getDmsService().isEnableImageAnomaly();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public DmsResult processDmsImage(byte[] imageData, long timestamp) {
        try {
            return DmsManagerGlobal.get().getDmsService().processDmsImage(imageData, timestamp);
        }
        catch(Exception e) {
            e.printStackTrace();
            return new DmsResult(-1, -1, "");
        }
    }

    public void processFrImage(byte[] imageData, long timestamp) {
        try {
            DmsManagerGlobal.get().getDmsService().processFrImage(imageData, timestamp);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void registerCallback(DmsCallBack callback, Handler handler) {
        DmsManagerGlobal.get().registerCallback(callback, handler);
    }

    public void setAlarmOff() {
        try {
            DmsManagerGlobal.get().getDmsService().setAlarmOff();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void setAlarmOn() {
        try {
            DmsManagerGlobal.get().getDmsService().setAlarmOn();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public long startFaceRecognition(long timeout) {
        try {
            return DmsManagerGlobal.get().getDmsService().startFaceRecognition(timeout);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public long startFaceRegister(long timeout) {
        try {
            return DmsManagerGlobal.get().getDmsService().startFaceRegister(timeout);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public void startFaceRegistration(String name) {
        try {
            DmsManagerGlobal.get().getDmsService().startFaceRegistration(name);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void unregisterCallback(DmsCallBack callback) {
        DmsManagerGlobal.get().unregisterCallback(callback);
    }
}

