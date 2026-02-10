package com.yftech.car.oms;

import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.os.ServiceManager;
import android.util.ArrayMap;
import android.util.Log;
import com.yftech.car.utils.MonitorServiceRestartManager.IMonitorCallback;
import com.yftech.car.utils.MonitorServiceRestartManager;
import java.util.List;
import java.util.Map.Entry;

public class OmsManager {
    public static abstract class OmsCallback {
        public void onDetectEnableChanged() {
        }

        public void onInfo(String json) {
        }

        public void onSwitchChanged(boolean isStart, boolean isEnableSmoking, boolean isEnableCalling, boolean isEnableLipMoving, boolean isEnableStaticGesture, boolean isEnableDynamicGesture, boolean isEnableImageAnomaly) {
        }
    }

    static final class OmsManagerGlobal extends Stub implements IBinder.DeathRecipient, IMonitorCallback {
        private static final OmsManagerGlobal intance;
        private final ArrayMap mCallbackMap;
        private final Object mLock;
        private static IOmsService mService;

        static {
            OmsManagerGlobal.intance = new OmsManagerGlobal();
        }

        private OmsManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("OmsManager", "binder died,reconnect service car_oms after 1000ms!");
            synchronized(this.mLock) {
                if(OmsManagerGlobal.mService == null) {
                    return;
                }
                OmsManagerGlobal.mService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        private boolean connectServiceLocked() {
            if(OmsManagerGlobal.mService == null || OmsManagerGlobal.mService.asBinder() == null || !OmsManagerGlobal.mService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = ServiceManager.getService("car_oms");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        OmsManagerGlobal.mService = com.yftech.car.oms.IOmsService.Stub.asInterface(iBinder0);
                        OmsManagerGlobal.mService.registerCallback(this);
                        return true;
                    }
                    Log.e("OmsManager", "the car oms service not started!connected service fail!");
                    return false;
                }
                catch(Exception e) {
                }
            }
            else {
                return true;
            }
            Log.e("OmsManager", "link to death error!" + e.getMessage());
            e.printStackTrace();
            return false;
        }

        public static OmsManagerGlobal get() {
            return OmsManagerGlobal.intance;
        }

        public IOmsService getOmsService() {
            synchronized(this.mLock) {
                if(!this.connectServiceLocked() || OmsManagerGlobal.mService == null) {
                    Log.e("OmsManager", "car pki service is unavailable");
                    this.startReconnectThread();
                }
                return OmsManagerGlobal.mService;
            }
        }

        @Override  // com.yftech.car.oms.IOmsCallback
        public void onDetectEnableChanged() {
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

        @Override  // com.yftech.car.oms.IOmsCallback
        public void onInfo(String json) {
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

        @Override  // com.yftech.car.oms.IOmsCallback
        public void onSwitchChanged(boolean isStart, boolean isEnableSmoking, boolean isEnableCalling, boolean isEnableLipMoving, boolean isEnableStaticGesture, boolean isEnableDynamicGesture, boolean isEnableImageAnomaly) {
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

        public void registerCallback(OmsCallback callback, Handler handler) {
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
            MonitorServiceRestartManager.getInstance().addMonitor("car_oms", this);
        }

        public void unregisterCallback(OmsCallback callback) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.remove(callback);
                }
            }
        }
    }

    public static final String SERVICE_NAME = "car_oms";
    private static final String TAG;
    private static volatile OmsManager mInstance;

    static {
        OmsManager.TAG = "OmsManager";
    }

    // String Decryptor: 4 succeeded, 0 failed
    static String access$000() {
        return "OmsManager";
    }

    public boolean deleteFaceData(String name) {
        try {
            return OmsManagerGlobal.get().getOmsService().deleteFaceData(name);
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void disableCalling() {
        try {
            OmsManagerGlobal.get().getOmsService().disableCalling();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableDetectChildElder() {
        try {
            OmsManagerGlobal.get().getOmsService().disableDetectChildElder();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableDistraction() {
        try {
            OmsManagerGlobal.get().getOmsService().disableDistraction();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableDynamicGesture() {
        try {
            OmsManagerGlobal.get().getOmsService().disableDynamicGesture();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableFaceId() {
        try {
            OmsManagerGlobal.get().getOmsService().disableFaceId();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableFatigue() {
        try {
            OmsManagerGlobal.get().getOmsService().disableFatigue();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableForgottenItem() {
        try {
            OmsManagerGlobal.get().getOmsService().disableForgottenItem();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableForgotternChild() {
        try {
            OmsManagerGlobal.get().getOmsService().disableForgotternChild();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableGaze() {
        try {
            OmsManagerGlobal.get().getOmsService().disableGaze();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableImageAnomaly() {
        try {
            OmsManagerGlobal.get().getOmsService().disableImageAnomaly();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableLipMoving() {
        try {
            OmsManagerGlobal.get().getOmsService().disableLipMoving();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableSmoking() {
        try {
            OmsManagerGlobal.get().getOmsService().disableSmoking();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disableStaticGesture() {
        try {
            OmsManagerGlobal.get().getOmsService().disableStaticGesture();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableCalling() {
        try {
            OmsManagerGlobal.get().getOmsService().enableCalling();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableDetectChildElder() {
        try {
            OmsManagerGlobal.get().getOmsService().enableDetectChildElder();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableDistraction() {
        try {
            OmsManagerGlobal.get().getOmsService().enableDistraction();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableDynamicGesture() {
        try {
            OmsManagerGlobal.get().getOmsService().enableDynamicGesture();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableFaceId() {
        try {
            OmsManagerGlobal.get().getOmsService().enableFaceId();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableFatigue() {
        try {
            OmsManagerGlobal.get().getOmsService().enableFatigue();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableForgottenItem() {
        try {
            OmsManagerGlobal.get().getOmsService().enableForgottenItem();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableForgotternChild() {
        try {
            OmsManagerGlobal.get().getOmsService().enableForgotternChild();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableGaze() {
        try {
            OmsManagerGlobal.get().getOmsService().enableGaze();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableImageAnomaly() {
        try {
            OmsManagerGlobal.get().getOmsService().enableImageAnomaly();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableLipMoving() {
        try {
            OmsManagerGlobal.get().getOmsService().enableLipMoving();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableSmoking() {
        try {
            OmsManagerGlobal.get().getOmsService().enableSmoking();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enableStaticGesture() {
        try {
            OmsManagerGlobal.get().getOmsService().enableStaticGesture();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static OmsManager getInstance() {
        if(OmsManager.mInstance == null) {
            Class class0 = OmsManager.class;
            synchronized(class0) {
                if(OmsManager.mInstance == null) {
                    OmsManager.mInstance = new OmsManager();
                }
            }
        }
        return OmsManager.mInstance;
    }

    public List getRegisteredNameList() {
        try {
            return OmsManagerGlobal.get().getOmsService().getRegisteredNameList();
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getVersion() {
        try {
            return OmsManagerGlobal.get().getOmsService().getVersion();
        }
        catch(Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean isEnableCalling() {
        try {
            return OmsManagerGlobal.get().getOmsService().isEnableCalling();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableDetectChildElder() {
        try {
            return OmsManagerGlobal.get().getOmsService().isEnableDetectChildElder();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableDistraction() {
        try {
            return OmsManagerGlobal.get().getOmsService().isEnableDistraction();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableDynamicGesture() {
        try {
            return OmsManagerGlobal.get().getOmsService().isEnableDynamicGesture();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableFaceId() {
        try {
            return OmsManagerGlobal.get().getOmsService().isEnableFaceId();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableFatigue() {
        try {
            return OmsManagerGlobal.get().getOmsService().isEnableFatigue();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableForgottenItem() {
        try {
            return OmsManagerGlobal.get().getOmsService().isEnableForgottenItem();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableForgotternChild() {
        try {
            return OmsManagerGlobal.get().getOmsService().isEnableForgotternChild();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableGaze() {
        try {
            return OmsManagerGlobal.get().getOmsService().isEnableGaze();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableImageAnomaly() {
        try {
            return OmsManagerGlobal.get().getOmsService().isEnableImageAnomaly();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableLipMoving() {
        try {
            return OmsManagerGlobal.get().getOmsService().isEnableLipMoving();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableSmoking() {
        try {
            return OmsManagerGlobal.get().getOmsService().isEnableSmoking();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnableStaticGesture() {
        try {
            return OmsManagerGlobal.get().getOmsService().isEnableStaticGesture();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isStart() {
        try {
            return OmsManagerGlobal.get().getOmsService().isStart();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void registerCallback(OmsCallback callback, Handler handler) {
        try {
            OmsManagerGlobal.get().registerCallback(callback, handler);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void setImage(byte[] buff, int width, int height) {
        try {
            OmsManagerGlobal.get().getOmsService().setImage(buff, width, height);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public boolean start() {
        try {
            return OmsManagerGlobal.get().getOmsService().start();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void startFaceRecognition() {
        try {
            OmsManagerGlobal.get().getOmsService().startFaceRecognition();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void startFaceRegistration(String name) {
        try {
            OmsManagerGlobal.get().getOmsService().startFaceRegistration(name);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public boolean stop() {
        try {
            return OmsManagerGlobal.get().getOmsService().stop();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void unregisterCallback(OmsCallback callback) {
        try {
            OmsManagerGlobal.get().unregisterCallback(callback);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

