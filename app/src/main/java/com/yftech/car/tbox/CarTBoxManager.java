package com.yftech.car.tbox;

import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;

import com.yftech.car.utils.BinderUtils;

import java.util.ArrayList;
import java.util.List;

public class CarTBoxManager {
    static final class CarTboxManagerGlobal extends ICarTBoxCallback.Stub implements IBinder.DeathRecipient, Runnable {
        private static final CarTboxManagerGlobal CAR_TBOX_MANAGER_GLOBAL = new CarTboxManagerGlobal();
        private static final String SERVICE_NAME = "car_tbox";
        private final ArrayMap mCallbackMap;
        private static ICarTBoxService mCarTBoxService;
        private Thread mConnectingThread;
        private final Object mLock;

        private CarTboxManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback$Stub
        public IBinder asBinder() {
            return this;
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("CarTBoxManager", "binder died,reconnect service car_tbox after 1000ms!");
            synchronized(this.mLock) {
                if(CarTboxManagerGlobal.mCarTBoxService == null) {
                    return;
                }
                CarTboxManagerGlobal.mCarTBoxService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        private boolean connectCarTboxServiceLocked() {
            if(CarTboxManagerGlobal.mCarTBoxService == null || CarTboxManagerGlobal.mCarTBoxService.asBinder() == null || !CarTboxManagerGlobal.mCarTBoxService.asBinder().isBinderAlive()) {
                CarTboxManagerGlobal.mCarTBoxService = null;
                IBinder iBinder0 = BinderUtils.getAliveServiceBinder("car_tbox");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        CarTboxManagerGlobal.mCarTBoxService = com.yftech.car.tbox.ICarTBoxService.Stub.asInterface(iBinder0);
                        CarTboxManagerGlobal.mCarTBoxService.registerCallback(((long)Process.myPid()), this);
                        return true;
                    }
                    Log.e("CarTBoxManager", "the car tbox service not started!connected service fail!");
                    return false;
                }
                catch(RemoteException e) {
                    Log.e("CarTBoxManager", "link to death error!" + e.getMessage());
                    e.printStackTrace();
                }
            }
            else {
                return true;
            }

            return false;
        }

        public static CarTboxManagerGlobal get() {
            return CarTboxManagerGlobal.CAR_TBOX_MANAGER_GLOBAL;
        }

        public ICarTBoxService getCarTBoxService() {
            synchronized(this.mLock) {
                if(!this.connectCarTboxServiceLocked() || CarTboxManagerGlobal.mCarTBoxService == null) {
                    Log.e("CarTBoxManager", "car tbox service is unavailable");
                    this.startReconnectThread();
                }
                return CarTboxManagerGlobal.mCarTBoxService;
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onCallFlagOperatorConfirm(int id, int callFlag, byte result, byte operatorId, boolean closeActivity) throws RemoteException {
            int v2 = this.mCallbackMap.size();
            for(int i = 0; i < v2; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onCallInfo(int callFlag, String phoneNumber, byte callType, byte callState, boolean closeActivity) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onCallWithFlagFail(byte operateId, String phoneNumber) throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onChargeParams(byte current, byte soc, byte mode, float startTime, float endTime, byte dayVaild, int[] goTime) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onChargeParamsUpdate(byte state, byte result, long utc) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onChargeState(byte state, String time) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onConnectedTboxState(boolean state) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onCtrlChargeFail() throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onCurrentCell(int cell) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onCurrentOperator(int operator) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onCurrentSignalRSSI(int rssi) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onCurrentSignalStrength(int signal) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onCurrentSystem(int system) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onFiveCodeInfo(String info) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onGetChargeParamsFail() throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onGetIccidFail() throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onGetImeiFail() throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onGetMoneyFail() throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onGetMoneyNumberFail() throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onGetMoneySmsNumRet(String number) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onGetNetOperatorListFail() throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onGetPublicKeyFail() throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onGetRadioStateFail() throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onGetTboxLogFail(String message) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onGetTboxLogSuccess() throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onGetTboxRebootLogFail() throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onGetTboxVersionFail() throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onIccid(String iccidInfo) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onImei(String imei) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onImsi(String imsi) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onIntrChargeConfigFail() throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onLogin(byte type, byte state) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onNetOperator(NetOperator netOperaor) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onNetOperatorList(List list0) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onNetworkStatus(int status) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onPublicKey(String keyInfo) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onRebootTboxFail() throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onRebootTboxLog(String log) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onRecvConfigFile() throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onResetCallId(int callId) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onResetFailReasonChanged(int value) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onResetStatusChanged(int status) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onResetTboxNetworkDone() throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onSendDtmfFail(byte dtmf) throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onSendTspFail() throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onServiceState(byte state) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onSetChargeParamsFail() throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onSetNetOperatorFail(byte index) throws RemoteException {
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onSetNetOperatorRet(byte index, byte result) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onSignalIntensity(byte type, int intensity) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onSimState(byte simState) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onSms(String message, String phoneNumber) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onSpaFileDownloadCompleted(String filePath) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onTboxVersion(String tboxVersion) throws RemoteException {
            ArrayList versionList = new ArrayList();
            String[] arr_s = tboxVersion.split(",");
            for(int v = 0; v < arr_s.length; ++v) {
                String[] arr_s1 = arr_s[v].replace("\"", "").split(":");
                String[] vers = new String[2];
                for(int i = 0; i < arr_s1.length && i < 2; ++i) {
                    vers[i] = arr_s1[i];
                }
                versionList.add(vers);
            }
            int v2 = this.mCallbackMap.size();
            for(int i = 0; i < v2; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onTsp(byte type, String flag, String content) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onUpdateWifiName(String name) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onUpdateWifiPassword(String password) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onUpgradeProgress(int progress) throws RemoteException {
            int v1 = this.mCallbackMap.size();
            for(int i = 0; i < v1; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onUpgradeState(int stage, int state) throws RemoteException {
            int v2 = this.mCallbackMap.size();
            for(int i = 0; i < v2; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onWifiName(String name) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onWifiPassword(String password) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void onWifiSwitchStatus(boolean open) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.tbox.ICarTBoxCallback
        public void ongetImsiFail() throws RemoteException {
        }

        void registerCarTBoxCallback(CarTBoxCallback callback, Handler handler) {
            synchronized(this.mLock) {
                if(!this.connectCarTboxServiceLocked()) {
                    this.startReconnectThread();
                }
                if(!this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.put(callback, handler);
                }
            }
        }

        @Override
        public void run() {
            Log.i("CarTBoxManager", "connecting service car_tbox!");
            while(!this.connectCarTboxServiceLocked()) {
                try {
                    Thread.sleep(1000L);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i("CarTBoxManager", "reconnecting service car_tbox!");
                this.connectCarTboxServiceLocked();
            }
        }

        private void startReconnectThread() {
            if(this.mConnectingThread == null || !this.mConnectingThread.isAlive()) {
                this.mConnectingThread = new Thread(this);
                this.mConnectingThread.start();
            }
        }

        void unregisterCarTBoxCallback(CarTBoxCallback callback) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.remove(callback);
                }
            }
        }
    }

    public static final byte CALL_FLAG_OPERATE_RET_ERROR = 2;
    public static final byte CALL_FLAG_OPERATE_RET_FAILED = 0;
    public static final byte CALL_FLAG_OPERATE_RET_SUCCESS = 1;
    public static final byte CALL_OPERATE_ID_ANSWER = 2;
    public static final byte CALL_OPERATE_ID_CREATE_OUT = 4;
    public static final byte CALL_OPERATE_ID_DISCONNECTED = 1;
    public static final byte CALL_OPERATE_ID_REFUSE = 3;
    public static final int CHARGING = 0;
    public static final int COMMAND_ERROR = 0xF9;
    public static final int CONFIG_OVER_TIME = 0xF8;
    public static final int DISCONNECTED = 0xF2;
    public static final int ECU_END = 4;
    public static final int ECU_START = 3;
    public static final int FINISH = 1;
    public static final int HCU_ERROR = 0xF4;
    public static final int HU_END = 6;
    public static final int HU_START = 2;
    public static final byte LOGIN_STATE_FAILED = 3;
    public static final byte LOGIN_STATE_OPERATING = 1;
    public static final byte LOGIN_STATE_SUCCESS = 2;
    public static final byte LOGIN_TYPE_IN = 1;
    public static final byte LOGIN_TYPE_OUT = 2;
    public static final int NETWORK_2G = 1;
    public static final int NETWORK_3G = 2;
    public static final int NETWORK_4G = 3;
    public static final int NETWORK_5G = 4;
    public static final int NETWORK_FAIL = 16;
    public static final int NETWORK_UNKNOW = 0;
    public static final int NO_BMS_ANS = 0xF2;
    public static final int NO_BMS_HCU_ANS = 0xF4;
    public static final int NO_BMS_OBC_ANS = 0xF6;
    public static final int NO_HCU_ANS = 0xF3;
    public static final int NO_HCU_OBC_ANS = 0xF5;
    public static final int NO_OBC_ANS = 0xF1;
    public static final int NO_OBC_BMS_HCU_ANS = 0xF7;
    public static final int OPERATOR_CHINA_MOBILE = 2;
    public static final int OPERATOR_CHINA_TELECOM = 3;
    public static final int OPERATOR_CHINA_UNICOM = 1;
    public static final int OPERATOR_FAIL = 4;
    public static final int OPERATOR_UNKONWN = 0;
    public static final int ORDER = 2;
    public static final byte PHONE_STATE_CONNECTED = 3;
    public static final byte PHONE_STATE_DISCONNECTED = 4;
    public static final byte PHONE_STATE_FAILED = 6;
    public static final byte PHONE_STATE_INCOMING = 2;
    public static final byte PHONE_STATE_NONE = 0;
    public static final byte PHONE_STATE_NO_REPONSE = 5;
    public static final byte PHONE_STATE_OUTING = 1;
    public static final byte PHONE_TYPE_B = 3;
    public static final byte PHONE_TYPE_E_AUTO = 1;
    public static final byte PHONE_TYPE_E_MANUAL = 2;
    public static final byte PHONE_TYPE_I = 4;
    public static final byte PHONE_TYPE_INCOMING = 5;
    public static final byte PHONE_TYPE_NONE = 0;
    public static final byte PHONE_TYPE_OUT = 6;
    public static final int POWER_INTR = 0xF1;
    public static final int PROCESSING = 0;
    public static final int PROCESS_SUCCESS = 1;
    public static final byte SERVICE_STATE_ALL = 4;
    public static final byte SERVICE_STATE_FLY = 2;
    public static final byte SERVICE_STATE_LIMIT = 3;
    public static final byte SERVICE_STATE_OUT_RANGE = 0;
    public static final byte SERVICE_STATE_SEARCHING = 1;
    public static final byte SET_NET_OPERATOR_RET_FAILED = 2;
    public static final byte SET_NET_OPERATOR_RET_SUCCESS = 1;
    public static final byte SIGNAL_TYPE_2G = 1;
    public static final byte SIGNAL_TYPE_3G = 2;
    public static final byte SIGNAL_TYPE_4G = 3;
    public static final int SIM_CARD_AVAILABLE_NETWORK_AVAILABLE = 3;
    public static final int SIM_CARD_AVAILABLE_NETWORK_UNAVAILABLE = 1;
    public static final int SIM_CARD_UNAVAILABLE_NETWORK_AVAILABLE = 2;
    public static final int SIM_CARD_UNAVAILABLE_NETWORK_UNAVAILABLE = 0;
    public static final byte SIM_STATE_ERROR = 3;
    public static final byte SIM_STATE_LOCKED = 1;
    public static final byte SIM_STATE_NORMAL = 0;
    public static final byte SIM_STATE_NO_EXIST = 2;
    private static final String TAG = "CarTBoxManager";
    public static final int TSP_END = 5;
    public static final int TSP_START = 1;
    public static final byte TSP_TYPE_HTTP = 2;
    public static final byte TSP_TYPE_POSTBODY = 3;
    public static final byte TSP_TYPE_TCP = 1;
    public static final int USER_STOP = 0xF3;
    private static volatile CarTBoxManager mInstance;

    // String Decryptor: 6 succeeded, 0 failed
    static String access$000() {
        return "CarTBoxManager";
    }

    public boolean callWithFlag(byte operatorId, String phoneNumber) {
        try {
            if(CarTboxManagerGlobal.get().getCarTBoxService().callWithFlag(((long)Process.myPid()), operatorId, phoneNumber) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean ctrlCharge(byte cmd) {
        try {
            if(CarTboxManagerGlobal.get().getCarTBoxService().ctrlCharge(((long)Process.myPid()), cmd) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getChargeParams() {
        try {
            long v = (long)Process.myPid();
            if(CarTboxManagerGlobal.get().getCarTBoxService().getChargeParams(v) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getCurrentNetworkType() {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().getCurrentSystem(v);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getCurrentOperator() {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().getCurrentOperator(v);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getCurrentSignalRSSI() {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().getCurrentSignalRSSI(v);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getCurrentSignalStrength() {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().getCurrentSignalStrength(v);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getFiveCodeInfo() {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().getFiveCodeInfo(v);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getIccid() {
        try {
            long v = (long)Process.myPid();
            if(CarTboxManagerGlobal.get().getCarTBoxService().getIccid(v) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getImei() {
        try {
            long v = (long)Process.myPid();
            if(CarTboxManagerGlobal.get().getCarTBoxService().getImei(v) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getImsi() {
        try {
            long v = (long)Process.myPid();
            if(CarTboxManagerGlobal.get().getCarTBoxService().getImsi(v) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static CarTBoxManager getInstance() {
        if(CarTBoxManager.mInstance == null) {
            Class class0 = CarTBoxManager.class;
            synchronized(class0) {
                if(CarTBoxManager.mInstance == null) {
                    CarTBoxManager.mInstance = new CarTBoxManager();
                }
            }
        }
        return CarTBoxManager.mInstance;
    }

    public boolean getMoney() {
        try {
            long v = (long)Process.myPid();
            if(CarTboxManagerGlobal.get().getCarTBoxService().getMoney(v) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getMoneyNumber() {
        try {
            long v = (long)Process.myPid();
            if(CarTboxManagerGlobal.get().getCarTBoxService().getMoneyNumber(v) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getNetOperatorList() {
        try {
            long v = (long)Process.myPid();
            if(CarTboxManagerGlobal.get().getCarTBoxService().getNetOperatorList(v) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getNetworkStatus() {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().getNetworkStatus(v);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getPublicKey() {
        try {
            long v = (long)Process.myPid();
            if(CarTboxManagerGlobal.get().getCarTBoxService().getPublicKey(v) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getRadioState() {
        try {
            long v = (long)Process.myPid();
            if(CarTboxManagerGlobal.get().getCarTBoxService().getRadioState(v) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getTboxLog(String getLogPath, String saveLogPath) {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().getTboxLog(v, getLogPath, saveLogPath);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getTboxRebootLog() {
        try {
            long v = (long)Process.myPid();
            if(CarTboxManagerGlobal.get().getCarTBoxService().getTboxRebootLog(v) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getTboxVersion() {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().getTboxVersion(v);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getWifiName() {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().getWifiName(v);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getWifiPassword() {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().getWifiPassword(v);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getWifiSwitchStatus() {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().getWifiSwitchStatus(v);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean intrChargeConfig() {
        try {
            long v = (long)Process.myPid();
            if(CarTboxManagerGlobal.get().getCarTBoxService().intrChargeConfig(v) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isConnectedTbox() {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().isConnectedTbox(v);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean rebootTbox() {
        try {
            long v = (long)Process.myPid();
            if(CarTboxManagerGlobal.get().getCarTBoxService().rebootTbox(v) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void registerCarTBoxCallback(CarTBoxCallback callback, Handler handler) {
        if(handler == null) {
            Looper looper0 = Looper.myLooper();
            if(looper0 == null) {
                throw new IllegalArgumentException("No handler given, and current thread has no looper!");
            }
            handler = new Handler(looper0);
        }
        CarTboxManagerGlobal.get().registerCarTBoxCallback(callback, handler);
    }

    public boolean requestDownLoadSpaJsonFile() {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().requestDownLoadSpaJsonFile(v);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int requestUpgrade(String upgradePath) {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().requestUpgrade(v, upgradePath);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return 0;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean resetTbox() {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().resetTbox(v);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean resetTboxNetwork() {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().resetTboxNetwork(v);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendDtmf(byte dtmf) {
        try {
            long v = (long)Process.myPid();
            if(CarTboxManagerGlobal.get().getCarTBoxService().sendDtmf(v, dtmf) == 0) {
                return true;
            }
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean sendTsp(String data) {
        if(!TextUtils.isEmpty(data)) {
            try {
                long v = (long)Process.myPid();
                if(CarTboxManagerGlobal.get().getCarTBoxService().sendTsp(v, data) == 0) {
                    return true;
                }
            }
            catch(RemoteException e) {
                e.printStackTrace();
                return false;
            }
            catch(NullPointerException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean setChargeParams(byte current, byte soc, byte mode, float startTime, float endTime, byte dayVaild, int[] goTime) {
        try {
            long v = (long)Process.myPid();
            if(CarTboxManagerGlobal.get().getCarTBoxService().setChargeParams(v, current, soc, mode, startTime, endTime, dayVaild, goTime) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setNetOperator(byte index) {
        try {
            long v = (long)Process.myPid();
            if(CarTboxManagerGlobal.get().getCarTBoxService().setNetOperator(v, index) == 0) {
                return true;
            }
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setWifiSwitchClick(boolean open) {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().setWifiSwitch(v, open);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean shutdownTbox() {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().shutdownTbox(v);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void unregisterCarTBoxCallback(CarTBoxCallback callback) {
        CarTboxManagerGlobal.get().unregisterCarTBoxCallback(callback);
    }

    public boolean updateWifiName(String name) {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().updateWifiName(v, name);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateWifiPassword(String password) {
        try {
            long v = (long)Process.myPid();
            return CarTboxManagerGlobal.get().getCarTBoxService().updateWifiPassword(v, password);
        }
        catch(RemoteException e) {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}

