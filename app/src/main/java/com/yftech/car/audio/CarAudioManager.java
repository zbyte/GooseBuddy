package com.yftech.car.audio;

import android.media.AudioAttributes.Builder;
import android.media.AudioAttributes;
import android.os.Bundle;
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
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CarAudioManager {
    public static abstract class CarAudioCallback {
        public void onAudioFocusAbandon(String packageName, int streamType, String clientId, Bundle data) {
        }

        public void onAudioFocusGrant(String packageName, int streamType, String clientId, Bundle data) {
        }

        public void onAudioFocusLoss(String packageName, int streamType, String clientId, Bundle data, int lossState) {
        }

        public void onAudioFocusRequest(String packageName, int streamType, String clientId, Bundle data, int requestResult) {
        }

        public void onChangedBootVolumeType(int type) {
        }

        public void onChangedMediaSource(int streamType, String packageName, String clientId) {
        }

        public void onChangedNaviMixLevel(int level) {
        }

        public void onChangedScreenSaver(boolean on) {
        }

        public void onChangedSpeedGainLevel(int level) {
        }

        public void onChangedVolume(int streamType, int curValue, int tolValue, boolean mute, int flag) {
        }
    }

    static final class CarAudioManagerGlobal extends Stub implements IBinder.DeathRecipient, IMonitorCallback {
        private static final CarAudioManagerGlobal CAR_AUDIO_MANAGER_GLOBAL = new CarAudioManagerGlobal();
        private final ArrayMap mCallbackMap;
        private static ICarAudioService mCarAudioService;
        private final Object mLock;
        private final List mServiceStartRunnable;

        private CarAudioManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
            this.mServiceStartRunnable = new ArrayList();
        }

        @Override  // com.yftech.car.audio.ICarAudioCallback$Stub
        public IBinder asBinder() {
            return this;
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("CarAudioManager", "binder died,reconnect service car_audio after 1000ms!");
            synchronized(this.mLock) {
                if(CarAudioManagerGlobal.mCarAudioService == null) {
                    return;
                }
                CarAudioManagerGlobal.mCarAudioService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        private boolean connectCarAudioServiceLocked() {
            if(CarAudioManagerGlobal.mCarAudioService == null || CarAudioManagerGlobal.mCarAudioService.asBinder() == null || !CarAudioManagerGlobal.mCarAudioService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = ServiceManager.getService("car_audio");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        CarAudioManagerGlobal.mCarAudioService = com.yftech.car.audio.ICarAudioService.Stub.asInterface(iBinder0);
                        CarAudioManagerGlobal.mCarAudioService.registerCarAudioCallback(this);
                        return true;
                    }
                    Log.e("CarAudioManager", "the car audio service not started!connected service fail!");
                    return false;
                }
                catch(RemoteException e) {
                }
            }
            else {
                return true;
            }
            Log.e("CarAudioManager", "link to death error!" + e.getMessage());
            e.printStackTrace();
            return false;
        }

        public static CarAudioManagerGlobal get() {
            return CarAudioManagerGlobal.CAR_AUDIO_MANAGER_GLOBAL;
        }

        int getBootVolumeType() {
            try {
                return this.getCarAudioService().getBootVolumeType();
            }
            catch(Exception e) {
                e.printStackTrace();
                return 1;
            }
        }

        public ICarAudioService getCarAudioService() {
            synchronized(this.mLock) {
                if(!this.connectCarAudioServiceLocked() || CarAudioManagerGlobal.mCarAudioService == null) {
                    Log.e("CarAudioManager", "car audio service is unavailable");
                    this.startReconnectThread();
                }
                return CarAudioManagerGlobal.mCarAudioService;
            }
        }

        String getCurrentMediaSource() {
            try {
                return this.getCarAudioService().getCurrentMediaSource();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        String getMediaSourceWhenShutdown() {
            try {
                return this.getCarAudioService().getMediaSourceWhenShutdown();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        int getNaviMixLevel() {
            try {
                return this.getCarAudioService().getNaviMixLevel();
            }
            catch(Exception e) {
                e.printStackTrace();
                return -1;
            }
        }

        int getSpeedGainLevel() {
            try {
                return this.getCarAudioService().getSpeedGainLevel();
            }
            catch(Exception e) {
                e.printStackTrace();
                return 0;
            }
        }

        int getSuggestedVolumeStreamType(int displayId) {
            try {
                return this.getCarAudioService().getSuggestedVolumeStreamType(displayId);
            }
            catch(Exception e) {
                e.printStackTrace();
                return 0x80000000;
            }
        }

        int getSuggestedVolumeStreamType(int displayId, int[] filterChannelList) {
            try {
                return this.getCarAudioService().getSuggestedVolumeStreamTypeWithFilter(displayId, filterChannelList);
            }
            catch(Exception e) {
                e.printStackTrace();
                return 0x80000000;
            }
        }

        int[] getVolumeForVolumeCurveTest(int streamType) {
            try {
                return this.getCarAudioService().getVolumeForVolumeCurveTest(streamType);
            }
            catch(RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }

        boolean isOnlyOneStreamMute(int streamType) {
            try {
                return this.getCarAudioService().isOnlyOneStreamMute(streamType);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override  // com.yftech.car.audio.ICarAudioCallback
        public void onAudioFocusAbandon(String packageName, int streamType, String clientId, Bundle data) throws RemoteException {
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

        @Override  // com.yftech.car.audio.ICarAudioCallback
        public void onAudioFocusGrant(String packageName, int streamType, String clientId, Bundle data) throws RemoteException {
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

        @Override  // com.yftech.car.audio.ICarAudioCallback
        public void onAudioFocusLoss(String packageName, int streamType, String clientId, Bundle data, int lossState) throws RemoteException {
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

        @Override  // com.yftech.car.audio.ICarAudioCallback
        public void onAudioFocusRequest(String packageName, int streamType, String clientId, Bundle data, int requestResult) throws RemoteException {
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

        @Override  // com.yftech.car.audio.ICarAudioCallback
        public void onChangedBootVolumeType(int type) throws RemoteException {
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

        @Override  // com.yftech.car.audio.ICarAudioCallback
        public void onChangedMediaSource(int streamType, String packageName, String clientId) throws RemoteException {
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

        @Override  // com.yftech.car.audio.ICarAudioCallback
        public void onChangedNaviMixLevel(int level) throws RemoteException {
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

        @Override  // com.yftech.car.audio.ICarAudioCallback
        public void onChangedScreenSaver(boolean on) throws RemoteException {
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

        @Override  // com.yftech.car.audio.ICarAudioCallback
        public void onChangedSpeedGainLevel(int level) throws RemoteException {
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

        @Override  // com.yftech.car.audio.ICarAudioCallback
        public void onChangedVolume(int[] streamTypes, int curValue, int tolValue, boolean mute, int flag) throws RemoteException {
            synchronized(this.mLock) {
                int v4 = this.mCallbackMap.size();
                for(int i = 0; i < v4; ++i) {
                    ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                        @Override
                        public void run() {
                            if(streamTypes != null) {
                                int[] arr_v = streamTypes;
                                for(int v = 0; v < arr_v.length; ++v) {
                                    int type = arr_v[v];
                                }
                            }
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

        boolean onlyMuteOneStream(int streamType, boolean mute, int flag) {
            try {
                return this.getCarAudioService().onlyMuteOneStream(streamType, mute, flag);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public void registerCarAudioCallback(CarAudioCallback callback, Handler handler) {
            synchronized(this.mLock) {
                if(!this.connectCarAudioServiceLocked()) {
                    this.startReconnectThread();
                }
                if(!this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.put(callback, handler);
                }
            }
        }

        void serviceStartRun(Runnable callback) {
            if(callback == null) {
                return;
            }
            synchronized(this.mServiceStartRunnable) {
                if(this.getCarAudioService() != null) {
                    callback.run();
                }
                else if(!this.mServiceStartRunnable.contains(callback)) {
                    this.mServiceStartRunnable.add(callback);
                }
            }
        }

        boolean setBootVolumeType(int type) {
            try {
                return this.getCarAudioService().setBootVolumeType(type);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean setNaviMixLevel(int level) {
            try {
                return this.getCarAudioService().setNaviMixLevel(level);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean setSpeedGainLevel(int level) {
            try {
                return this.getCarAudioService().setSpeedGainLevel(level);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        void setVolumeForVolumeCurveTest(int streamType, int index, int gain) {
            try {
                this.getCarAudioService().setVolumeForVolumeCurveTest(streamType, index, gain);
            }
            catch(RemoteException e) {
                e.printStackTrace();
            }
        }

        private void startReconnectThread() {
            MonitorServiceRestartManager.getInstance().addMonitor("car_audio", this);
        }

        public void unregisterCarAudioCallback(CarAudioCallback callback) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.remove(callback);
                }
            }
        }
    }

    private static final String AUDIO_ATTRIBUTES_DATA_KEY_DISPLAY_ID = "display";
    public static final int BOOT_VOLUME_TYPE_VOLUME_AUTO = 2;
    public static final int BOOT_VOLUME_TYPE_VOLUME_DEFAULT = 3;
    public static final int BOOT_VOLUME_TYPE_VOLUME_REMEMBER_LAST = 1;
    public static final int NAVI_MIX_LEVEL_HIGH = 3;
    public static final int NAVI_MIX_LEVEL_LOW = 1;
    public static final int NAVI_MIX_LEVEL_MID = 2;
    public static final String SERVICE_NAME = "car_audio";
    public static final int SPEED_AUDIO_GAIN_LEVEL_1 = 1;
    public static final int SPEED_AUDIO_GAIN_LEVEL_2 = 2;
    public static final int SPEED_AUDIO_GAIN_LEVEL_3 = 3;
    public static final int SPEED_AUDIO_GAIN_LEVEL_OFF;
    private static final String TAG;
    private static volatile CarAudioManager mInstance;

    static {
        CarAudioManager.TAG = "CarAudioManager";
    }

    static String access$000() {
        return "CarAudioManager";
    }

    private static Bundle getAudioAttributesData(AudioAttributes aa) {
        if(aa == null) {
            return null;
        }
        try {
            Object object0 = AudioAttributes.class.getDeclaredMethod("getBundle").invoke(aa);
            if(object0 != null) {
                return (Bundle)object0;
            }
        }
        catch(NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getAudioAttributesDisplayId(AudioAttributes aa) {
        return CarAudioManager.getAudioAttributesDisplayId(CarAudioManager.getAudioAttributesData(aa));
    }

    public static int getAudioAttributesDisplayId(Bundle data) {
        return data == null ? -1 : data.getInt("display", -1);
    }

    public int getBootVolumeType() {
        return CarAudioManagerGlobal.get().getBootVolumeType();
    }

    public String getCurrentMediaSource() {
        return CarAudioManagerGlobal.get().getCurrentMediaSource();
    }

    public static CarAudioManager getInstance() {
        if(CarAudioManager.mInstance == null) {
            Class class0 = CarAudioManager.class;
            synchronized(class0) {
                if(CarAudioManager.mInstance == null) {
                    CarAudioManager.mInstance = new CarAudioManager();
                }
            }
        }
        return CarAudioManager.mInstance;
    }

    public String getMediaSourceWhenShutdown() {
        return CarAudioManagerGlobal.get().getMediaSourceWhenShutdown();
    }

    public int getNaviMixLevel() {
        return CarAudioManagerGlobal.get().getNaviMixLevel();
    }

    public int getSpeedGainLevel() {
        return CarAudioManagerGlobal.get().getSpeedGainLevel();
    }

    public int getSuggestedVolumeStreamType(int displayId) {
        return CarAudioManagerGlobal.get().getSuggestedVolumeStreamType(displayId);
    }

    public int getSuggestedVolumeStreamType(int displayId, int[] filterChannelList) {
        return CarAudioManagerGlobal.get().getSuggestedVolumeStreamType(displayId, filterChannelList);
    }

    public int[] getVolumeForVolumeCurveTest(int streamType) {
        return CarAudioManagerGlobal.get().getVolumeForVolumeCurveTest(streamType);
    }

    public boolean isOnlyOneStreamMute(int streamType) {
        return CarAudioManagerGlobal.get().isOnlyOneStreamMute(streamType);
    }

    public boolean onlyMuteOneStream(int streamType, boolean mute, int flag) {
        return CarAudioManagerGlobal.get().onlyMuteOneStream(streamType, mute, flag);
    }

    public void registerCarAudioCallback(CarAudioCallback callback, Handler handler) {
        if(handler == null) {
            Looper looper0 = Looper.myLooper();
            if(looper0 == null) {
                throw new IllegalArgumentException("No handler given, and current thread has no looper!");
            }
            handler = new Handler(looper0);
        }
        CarAudioManagerGlobal.get().registerCarAudioCallback(callback, handler);
    }

    public void serviceStartRun(Runnable callback) {
        CarAudioManagerGlobal.get().serviceStartRun(callback);
    }

    private static boolean setAudioAttributesData(AudioAttributes.Builder builder, Bundle data) {
        if(builder == null) {
            return false;
        }
        try {
            AudioAttributes.Builder.class.getDeclaredMethod("addBundle", Bundle.class).invoke(builder, data);
            return true;
        }
        catch(NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean setAudioAttributesDisplayId(AudioAttributes.Builder builder, int displayId) {
        Bundle data = new Bundle();
        data.putInt("display", displayId);
        return CarAudioManager.setAudioAttributesData(builder, data);
    }

    public boolean setBootVolumeType(int type) {
        return CarAudioManagerGlobal.get().setBootVolumeType(type);
    }

    public boolean setNaviMixLevel(int level) {
        return CarAudioManagerGlobal.get().setNaviMixLevel(level);
    }

    public boolean setSpeedGainLevel(int level) {
        return CarAudioManagerGlobal.get().setSpeedGainLevel(level);
    }

    public void setVolumeForVolumeCurveTest(int streamType, int index, int gain) {
        CarAudioManagerGlobal.get().setVolumeForVolumeCurveTest(streamType, index, gain);
    }

    public void unregisterCarAudioCallback(CarAudioCallback callback) {
        CarAudioManagerGlobal.get().unregisterCarAudioCallback(callback);
    }
}

