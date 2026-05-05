package com.yftech.car.audio;

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

public class CarSoundEffectManager {
    public static abstract class CarSoundEffectCallback {
        public void onChangedBalance(float lr, float fr) {
        }

        public void onChangedBalanceValue(float fl, float fr, float rl, float rr) {
        }

        public void onChangedBandValue(float[] values, float[] qs) {
        }

        public void onChangedDTSEnable(boolean enable) {
        }

        public void onChangedDTSSoundPosition(int position) {
        }

        public void onChangedDTSType(int type) {
        }

        public void onChangedDelayValue(float fl, float fr, float rl, float rr) {
        }

        public void onChangedEQType(int type, float[] values, float[] qs) {
        }

        public void onChangedEnable(boolean enable) {
        }

        public void onChangedLoudnessEnable(boolean enable) {
        }

        public void onChangedSceneSoundEffectType(int type) {
        }
    }

    static final class CarSoundEffectManagerGlobal extends ICarSoundEffectCallback.Stub implements IBinder.DeathRecipient, IMonitorCallback {
        private static final CarSoundEffectManagerGlobal CAR_SOUND_EFFECT_MANAGER_GLOBAL = new CarSoundEffectManagerGlobal();
        private final ArrayMap mCallbackMap;
        private static ICarSoundEffectService mCarSoundEffectService;
        private final Object mLock;

        private CarSoundEffectManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
        }

        @Override  // com.yftech.car.audio.ICarSoundEffectCallback$Stub
        public IBinder asBinder() {
            return this;
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("CarSoundEffectManager", "binder died,reconnect service car_sound_effect after 1000ms!");
            synchronized(this.mLock) {
                if(CarSoundEffectManagerGlobal.mCarSoundEffectService == null) {
                    return;
                }
                CarSoundEffectManagerGlobal.mCarSoundEffectService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        private boolean connectCarSoundEffectServiceLocked() {
            if(CarSoundEffectManagerGlobal.mCarSoundEffectService == null || CarSoundEffectManagerGlobal.mCarSoundEffectService.asBinder() == null || !CarSoundEffectManagerGlobal.mCarSoundEffectService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = BinderUtils.getAliveServiceBinder("car_sound_effect");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        CarSoundEffectManagerGlobal.mCarSoundEffectService = com.yftech.car.audio.ICarSoundEffectService.Stub.asInterface(iBinder0);
                        CarSoundEffectManagerGlobal.mCarSoundEffectService.registerCarSoundEffectCallback(this);
                        return true;
                    }
                    Log.e("CarSoundEffectManager", "the car sound effect service not started!connected service fail!");
                    return false;
                }
                catch(Exception e) {
                    Log.e("CarSoundEffectManager", "link to death error!" + e.getMessage());
                    e.printStackTrace();
                }
            }
            else {
                return true;
            }
            return false;
        }

        public static CarSoundEffectManagerGlobal get() {
            return CarSoundEffectManagerGlobal.CAR_SOUND_EFFECT_MANAGER_GLOBAL;
        }

        float[] getBalance() {
            try {
                return this.getCarSoundEffectService().getBalanceXY();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        float getBalanceMaxValue() {
            try {
                return this.getCarSoundEffectService().getBalanceMaxValue();
            }
            catch(Exception e) {
                e.printStackTrace();
                return 3.402823E+38f;
            }
        }

        float getBalanceMinValue() {
            try {
                return this.getCarSoundEffectService().getBalanceMinValue();
            }
            catch(Exception e) {
                e.printStackTrace();
                return 3.402823E+38f;
            }
        }

        float getBalanceValueFL() {
            try {
                return this.getCarSoundEffectService().getBalanceValueFL();
            }
            catch(Exception e) {
                e.printStackTrace();
                return 3.402823E+38f;
            }
        }

        float getBalanceValueFR() {
            try {
                return this.getCarSoundEffectService().getBalanceValueFR();
            }
            catch(Exception e) {
                e.printStackTrace();
                return 3.402823E+38f;
            }
        }

        float getBalanceValueRL() {
            try {
                return this.getCarSoundEffectService().getBalanceValueRL();
            }
            catch(Exception e) {
                e.printStackTrace();
                return 3.402823E+38f;
            }
        }

        float getBalanceValueRR() {
            try {
                return this.getCarSoundEffectService().getBalanceValueRR();
            }
            catch(Exception e) {
                e.printStackTrace();
                return 3.402823E+38f;
            }
        }

        float[] getBandCurQ() {
            try {
                return this.getCarSoundEffectService().getBandCurQ();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        float[] getBandCurValue() {
            try {
                return this.getCarSoundEffectService().getBandCurValue();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        float[] getBandMaxQ() {
            try {
                return this.getCarSoundEffectService().getBandMaxQ();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        float[] getBandMaxValue() {
            try {
                return this.getCarSoundEffectService().getBandMaxValue();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        float[] getBandMinQ() {
            try {
                return this.getCarSoundEffectService().getBandMinQ();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        float[] getBandMinValue() {
            try {
                return this.getCarSoundEffectService().getBandMinValue();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        int[] getBandsHz() {
            try {
                return this.getCarSoundEffectService().getBandsHz();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public ICarSoundEffectService getCarSoundEffectService() {
            synchronized(this.mLock) {
                if(!this.connectCarSoundEffectServiceLocked() || CarSoundEffectManagerGlobal.mCarSoundEffectService == null) {
                    Log.e("CarSoundEffectManager", "car sound effect service is unavailable");
                    this.startReconnectThread();
                }
                return CarSoundEffectManagerGlobal.mCarSoundEffectService;
            }
        }

        int getDTSSoundPosition() {
            try {
                return this.getCarSoundEffectService().getDTSSoundPosition();
            }
            catch(Exception e) {
                e.printStackTrace();
                return -1;
            }
        }

        int getDTSType() {
            try {
                return this.getCarSoundEffectService().getDTSType();
            }
            catch(Exception e) {
                e.printStackTrace();
                return -1;
            }
        }

        float getDelayMaxValue() {
            try {
                return this.getCarSoundEffectService().getDelayMaxValue();
            }
            catch(Exception e) {
                e.printStackTrace();
                return 3.402823E+38f;
            }
        }

        float getDelayMinValue() {
            try {
                return this.getCarSoundEffectService().getDelayMinValue();
            }
            catch(Exception e) {
                e.printStackTrace();
                return 3.402823E+38f;
            }
        }

        float getDelayValueFL() {
            try {
                return this.getCarSoundEffectService().getDelayValueFL();
            }
            catch(Exception e) {
                e.printStackTrace();
                return 3.402823E+38f;
            }
        }

        float getDelayValueFR() {
            try {
                return this.getCarSoundEffectService().getDelayValueFR();
            }
            catch(Exception e) {
                e.printStackTrace();
                return 3.402823E+38f;
            }
        }

        float getDelayValueRL() {
            try {
                return this.getCarSoundEffectService().getDelayValueRL();
            }
            catch(Exception e) {
                e.printStackTrace();
                return 3.402823E+38f;
            }
        }

        float getDelayValueRR() {
            try {
                return this.getCarSoundEffectService().getDelayValueRR();
            }
            catch(Exception e) {
                e.printStackTrace();
                return 3.402823E+38f;
            }
        }

        int getEQType() {
            try {
                return this.getCarSoundEffectService().getEQType();
            }
            catch(Exception e) {
                e.printStackTrace();
                return -1;
            }
        }

        int getSceneSoundEffectType() {
            try {
                return this.getCarSoundEffectService().getSceneSoundEffectType();
            }
            catch(Exception e) {
                e.printStackTrace();
                return -1;
            }
        }

        boolean isDTSEnable() {
            try {
                return this.getCarSoundEffectService().isDTSEnable();
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean isEQEnable() {
            try {
                return this.getCarSoundEffectService().isEQEnable();
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean isLoudnessEnable() {
            try {
                return this.getCarSoundEffectService().isLoudnessEnable();
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override  // com.yftech.car.audio.ICarSoundEffectCallback
        public void onChangedBalanceValue(float fl, float fr, float rl, float rr) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.audio.ICarSoundEffectCallback
        public void onChangedBalanceXY(float lr, float fr) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.audio.ICarSoundEffectCallback
        public void onChangedBandValue(float[] values, float[] qs) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.audio.ICarSoundEffectCallback
        public void onChangedDTSEnable(boolean enable) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.audio.ICarSoundEffectCallback
        public void onChangedDTSSoundPosition(int position) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.audio.ICarSoundEffectCallback
        public void onChangedDTSType(int type) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.audio.ICarSoundEffectCallback
        public void onChangedDelayValue(float fl, float fr, float rl, float rr) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.audio.ICarSoundEffectCallback
        public void onChangedEQType(int type, float[] values, float[] qs) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.audio.ICarSoundEffectCallback
        public void onChangedEnable(boolean enable) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.audio.ICarSoundEffectCallback
        public void onChangedLoudnessEnable(boolean enable) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.audio.ICarSoundEffectCallback
        public void onChangedSceneSoundEffectType(int type) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.utils.MonitorServiceRestartManager$IMonitorCallback
        public void onServiceStart(String serviceName) {
            this.connectCarSoundEffectServiceLocked();
        }

        public void registerCarSoundEffectCallback(CarSoundEffectCallback callback, Handler handler) {
            synchronized(this.mLock) {
                if(!this.connectCarSoundEffectServiceLocked()) {
                    this.startReconnectThread();
                }
                if(!this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.put(callback, handler);
                }
            }
        }

        boolean setBalance(float lr, float fr) {
            try {
                return this.getCarSoundEffectService().setBalanceXY(lr, fr);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean setBalance(float fl, float fr, float rl, float rr) {
            try {
                return this.getCarSoundEffectService().setBalance(fl, fr, rl, rr);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean setBandValue(float[] values, float[] qs) {
            try {
                return this.getCarSoundEffectService().setBandValue(values, qs);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean setDTSEnable(boolean enable) {
            try {
                return this.getCarSoundEffectService().setDTSEnable(enable);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean setDTSSoundPosition(int position) {
            try {
                return this.getCarSoundEffectService().setDTSSoundPosition(position);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean setDTSType(int type) {
            try {
                return this.getCarSoundEffectService().setDTSType(type);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean setDelayValue(float fl, float fr, float rl, float rr) {
            try {
                return this.getCarSoundEffectService().setDelayValue(fl, fr, rl, rr);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean setEQEnable(boolean enable) {
            try {
                return this.getCarSoundEffectService().setEQEnable(enable);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean setEQType(int type) {
            try {
                return this.getCarSoundEffectService().setEQType(type);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean setLoudnessEnable(boolean enable) {
            try {
                return this.getCarSoundEffectService().setLoudnessEnable(enable);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        boolean setSceneSoundEffectType(int type) {
            try {
                return this.getCarSoundEffectService().setSceneSoundEffectType(type);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        private void startReconnectThread() {
            MonitorServiceRestartManager.getInstance().addMonitor("car_sound_effect", this);
        }

        public void unregisterCarSoundEffectCallback(CarSoundEffectCallback callback) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.remove(callback);
                }
            }
        }
    }

    public static final int DTS_SOUND_POSITION_ALL = 2;
    public static final int DTS_SOUND_POSITION_FRONT = 0;
    public static final int DTS_SOUND_POSITION_NONE = -1;
    public static final int DTS_SOUND_POSITION_REAR = 1;
    public static final int DTS_TYPE_DEFAULT = 0;
    public static final int DTS_TYPE_NONE = -1;
    public static final int DTS_TYPE_SOOTHING = 3;
    public static final int DTS_TYPE_STAGE = 4;
    public static final int DTS_TYPE_SUPER_BASS = 2;
    public static final int DTS_TYPE_VOICE = 1;
    public static final int EQ_TYPE_BASS_BOOST = 10;
    public static final int EQ_TYPE_CLASSIC = 8;
    public static final int EQ_TYPE_CUSTOM = 1;
    public static final int EQ_TYPE_DANCE = 7;
    public static final int EQ_TYPE_DEFAULT = 0;
    public static final int EQ_TYPE_FOLK = 3;
    public static final int EQ_TYPE_INTELLIGENCE = 14;
    public static final int EQ_TYPE_JAZZ = 5;
    public static final int EQ_TYPE_NATURAL = 13;
    public static final int EQ_TYPE_NONE = -1;
    public static final int EQ_TYPE_POP = 6;
    public static final int EQ_TYPE_ROCK = 4;
    public static final int EQ_TYPE_STAGE = 12;
    public static final int EQ_TYPE_THEATER = 11;
    public static final int EQ_TYPE_TREBLE_BOOST = 9;
    public static final int EQ_TYPE_VOICE = 2;
    public static final int SCENE_SOUND_EFFECT_KTV = 1;
    public static final int SCENE_SOUND_EFFECT_MOVIE = 0;
    public static final int SCENE_SOUND_EFFECT_NONE = -1;
    public static final String SERVICE_NAME = "car_sound_effect";
    private static final String TAG = "CarSoundEffectManager";
    private static volatile CarSoundEffectManager mInstance;

    static String access$000() {
        return "CarSoundEffectManager";
    }

    public float[] getBalance() {
        return CarSoundEffectManagerGlobal.get().getBalance();
    }

    public float getBalanceMaxValue() {
        return CarSoundEffectManagerGlobal.get().getBalanceMaxValue();
    }

    public float getBalanceMinValue() {
        return CarSoundEffectManagerGlobal.get().getBalanceMinValue();
    }

    public float getBalanceValueFL() {
        return CarSoundEffectManagerGlobal.get().getBalanceValueFL();
    }

    public float getBalanceValueFR() {
        return CarSoundEffectManagerGlobal.get().getBalanceValueFR();
    }

    public float getBalanceValueRL() {
        return CarSoundEffectManagerGlobal.get().getBalanceValueRL();
    }

    public float getBalanceValueRR() {
        return CarSoundEffectManagerGlobal.get().getBalanceValueRR();
    }

    public float[] getBandCurQ() {
        return CarSoundEffectManagerGlobal.get().getBandCurQ();
    }

    public float[] getBandCurValue() {
        return CarSoundEffectManagerGlobal.get().getBandCurValue();
    }

    public float[] getBandMaxQ() {
        return CarSoundEffectManagerGlobal.get().getBandMaxQ();
    }

    public float[] getBandMaxValue() {
        return CarSoundEffectManagerGlobal.get().getBandMaxValue();
    }

    public float[] getBandMinQ() {
        return CarSoundEffectManagerGlobal.get().getBandMinQ();
    }

    public float[] getBandMinValue() {
        return CarSoundEffectManagerGlobal.get().getBandMinValue();
    }

    public int[] getBandsHz() {
        return CarSoundEffectManagerGlobal.get().getBandsHz();
    }

    public int getDTSSoundPosition() {
        return CarSoundEffectManagerGlobal.get().getDTSSoundPosition();
    }

    public int getDTSType() {
        return CarSoundEffectManagerGlobal.get().getDTSType();
    }

    public float getDelayMaxValue() {
        return CarSoundEffectManagerGlobal.get().getDelayMaxValue();
    }

    public float getDelayMinValue() {
        return CarSoundEffectManagerGlobal.get().getDelayMinValue();
    }

    public float getDelayValueFL() {
        return CarSoundEffectManagerGlobal.get().getDelayValueFL();
    }

    public float getDelayValueFR() {
        return CarSoundEffectManagerGlobal.get().getDelayValueFR();
    }

    public float getDelayValueRL() {
        return CarSoundEffectManagerGlobal.get().getDelayValueRL();
    }

    public float getDelayValueRR() {
        return CarSoundEffectManagerGlobal.get().getDelayValueRR();
    }

    public int getEQType() {
        return CarSoundEffectManagerGlobal.get().getEQType();
    }

    public static CarSoundEffectManager getInstance() {
        if(CarSoundEffectManager.mInstance == null) {
            Class class0 = CarSoundEffectManager.class;
            synchronized(class0) {
                if(CarSoundEffectManager.mInstance == null) {
                    CarSoundEffectManager.mInstance = new CarSoundEffectManager();
                }
            }
        }
        return CarSoundEffectManager.mInstance;
    }

    public int getSceneSoundEffectType() {
        return CarSoundEffectManagerGlobal.get().getSceneSoundEffectType();
    }

    public boolean isDTSEnable() {
        return CarSoundEffectManagerGlobal.get().isDTSEnable();
    }

    public boolean isEQEnable() {
        return CarSoundEffectManagerGlobal.get().isEQEnable();
    }

    public boolean isLoudnessEnable() {
        return CarSoundEffectManagerGlobal.get().isLoudnessEnable();
    }

    public void registerCarSoundEffectCallback(CarSoundEffectCallback callback, Handler handler) {
        if(handler == null) {
            Looper looper0 = Looper.myLooper();
            if(looper0 == null) {
                throw new IllegalArgumentException("No handler given, and current thread has no looper!");
            }
            handler = new Handler(looper0);
        }
        CarSoundEffectManagerGlobal.get().registerCarSoundEffectCallback(callback, handler);
    }

    public boolean setBalance(float lr, float fr) {
        return CarSoundEffectManagerGlobal.get().setBalance(lr, fr);
    }

    public boolean setBalance(float fl, float fr, float rl, float rr) {
        return CarSoundEffectManagerGlobal.get().setBalance(fl, fr, rl, rr);
    }

    public boolean setBandValue(float[] values) {
        return this.setBandValue(values, null);
    }

    public boolean setBandValue(float[] values, float[] qs) {
        return CarSoundEffectManagerGlobal.get().setBandValue(values, qs);
    }

    public boolean setDTSEnable(boolean enable) {
        return CarSoundEffectManagerGlobal.get().setDTSEnable(enable);
    }

    public boolean setDTSSoundPosition(int position) {
        return CarSoundEffectManagerGlobal.get().setDTSSoundPosition(position);
    }

    public boolean setDTSType(int type) {
        return CarSoundEffectManagerGlobal.get().setDTSType(type);
    }

    public boolean setDelayValue(float fl, float fr, float rl, float rr) {
        return CarSoundEffectManagerGlobal.get().setDelayValue(fl, fr, rl, rr);
    }

    public boolean setEQEnable(boolean enable) {
        return CarSoundEffectManagerGlobal.get().setEQEnable(enable);
    }

    public boolean setEQType(int type) {
        return CarSoundEffectManagerGlobal.get().setEQType(type);
    }

    public boolean setLoudnessEnable(boolean enable) {
        return CarSoundEffectManagerGlobal.get().setLoudnessEnable(enable);
    }

    public boolean setSceneSoundEffectType(int type) {
        return CarSoundEffectManagerGlobal.get().setSceneSoundEffectType(type);
    }

    public void unregisterCarSoundEffectCallback(CarSoundEffectCallback callback) {
        CarSoundEffectManagerGlobal.get().unregisterCarSoundEffectCallback(callback);
    }
}

