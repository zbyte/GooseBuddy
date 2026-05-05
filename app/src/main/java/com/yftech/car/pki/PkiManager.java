package com.yftech.car.pki;

import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.util.Log;

import com.yftech.car.utils.BinderUtils;
import com.yftech.car.utils.MonitorServiceRestartManager.IMonitorCallback;
import com.yftech.car.utils.MonitorServiceRestartManager;

public class PkiManager {
    static final class PkiManagerGlobal implements IBinder.DeathRecipient, IMonitorCallback {
        private static final PkiManagerGlobal intance  = new PkiManagerGlobal();
        private final Object mLock;
        private static IPkiService mService;

        private PkiManagerGlobal() {
            this.mLock = new Object();
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("PkiManager", "binder died,reconnect service car_pki after 1000ms!");
            synchronized(this.mLock) {
                if(PkiManagerGlobal.mService == null) {
                    return;
                }
                PkiManagerGlobal.mService = null;
            }
        }

        private boolean connectPkiServiceLocked() {
            if(PkiManagerGlobal.mService == null || PkiManagerGlobal.mService.asBinder() == null || !PkiManagerGlobal.mService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = BinderUtils.getAliveServiceBinder("car_pki");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        PkiManagerGlobal.mService = IPkiService.Stub.asInterface(iBinder0);
                        return true;
                    }
                    Log.e("PkiManager", "the car pki service not started!connected service fail!");
                    return false;
                }
                catch(Exception e) {
                    Log.e("PkiManager", "link to death error!" + e.getMessage());
                    e.printStackTrace();
                }
            }
            else {
                return true;
            }

            return false;
        }

        public static PkiManagerGlobal get() {
            return PkiManagerGlobal.intance;
        }

        public IPkiService getPkiService() {
            synchronized(this.mLock) {
                if(!this.connectPkiServiceLocked() || PkiManagerGlobal.mService == null) {
                    Log.e("PkiManager", "car pki service is unavailable");
                    this.startReconnectThread();
                }
                return PkiManagerGlobal.mService;
            }
        }

        @Override  // com.yftech.car.utils.MonitorServiceRestartManager$IMonitorCallback
        public void onServiceStart(String serviceName) {
            this.connectPkiServiceLocked();
        }

        private void startReconnectThread() {
            MonitorServiceRestartManager.getInstance().addMonitor("car_pki", this);
        }
    }

    public static final int ERROR = 1;
    public static final int ERROR_BINDER_DISCONNECTED = -9;
    public static final int ERROR_CERT_BINDER_DISCONNECTED = -1;
    public static final int ERROR_CERT_EXIST = 0x60;
    public static final int ERROR_CERT_GENER_CLIENT = 102;
    public static final int ERROR_CERT_GENER_CMS = 104;
    public static final int ERROR_CERT_GENER_CONFIG = 93;
    public static final int ERROR_CERT_GENER_SERVER = 103;
    public static final int ERROR_CERT_GENER_SOCKET = 101;
    public static final int ERROR_CERT_INCOMPLETE = 97;
    public static final int ERROR_CERT_INSTALL_PATCH = 92;
    public static final int ERROR_CERT_KEY_COMP = 98;
    public static final int ERROR_CERT_KEY_INCOMPLETE = 99;
    public static final int ERROR_CONNECT = -4;
    public static final int ERROR_JSON = -8;
    public static final int ERROR_PARAM = -1;
    public static final int ERROR_RECV = 0xFFFFFF91;
    public static final int ERROR_SEND = -5;
    public static final int ERROR_SOCKET = -3;
    public static final int ERROR_SUCCESS = 0;
    public static final int ERROR_TIMEOUT = -7;
    public static final int ERRRO_CERT_DEVICE_CKECH = 0x4F;
    public static final String SERVICE_NAME = "car_pki";
    public static final int SYMM_MODE_E_CBC = 1;
    public static final int SYMM_MODE_E_CFB = 2;
    public static final int SYMM_MODE_E_CTR = 4;
    public static final int SYMM_MODE_E_ECB = 0;
    public static final int SYMM_MODE_E_OFB = 3;
    public static final int SYMM_TYPE_E_3DES = 3;
    public static final int SYMM_TYPE_E_AES_128 = 0;
    public static final int SYMM_TYPE_E_AES_256 = 1;
    public static final int SYMM_TYPE_E_DES = 2;
    public static final int SYMM_TYPE_E_RC4 = 4;
    public static final int SYMM_TYPE_E_SM4 = 5;
    private static final String TAG = "PkiManager";
    private static volatile PkiManager mInstance;

    // String Decryptor: 4 succeeded, 0 failed
    static String access$000() {
        return "PkiManager";
    }

    public int did() {
        try {
            return PkiManagerGlobal.get().getPkiService().did();
        }
        catch(Exception e) {
            e.printStackTrace();
            return -9;
        }
    }

    public String getCertFilePath() {
        try {
            return PkiManagerGlobal.get().getPkiService().getCertFilePath();
        }
        catch(Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public int getCertStatus() {
        try {
            return PkiManagerGlobal.get().getPkiService().getCertStatus();
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static PkiManager getInstance() {
        if(PkiManager.mInstance == null) {
            Class class0 = PkiManager.class;
            synchronized(class0) {
                if(PkiManager.mInstance == null) {
                    PkiManager.mInstance = new PkiManager();
                }
            }
        }
        return PkiManager.mInstance;
    }

    public int getSymmProgress() {
        try {
            return PkiManagerGlobal.get().getPkiService().getSymmProgress();
        }
        catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getVersion() {
        try {
            return PkiManagerGlobal.get().getPkiService().getVersion();
        }
        catch(Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public int symmDecryptFile(String path, String key, String iv, int symmType, int symmMode, String desPath) {
        try {
            return PkiManagerGlobal.get().getPkiService().symmDecryptFile(path, key, iv, symmType, symmMode, desPath);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -9;
        }
    }

    public String szitrusCertParse() {
        try {
            return PkiManagerGlobal.get().getPkiService().szitrusCertParse();
        }
        catch(Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public int szitrusCertPass(String pwd) {
        try {
            return PkiManagerGlobal.get().getPkiService().szitrusCertPass(pwd);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int szitrusCertStatus() {
        try {
            return PkiManagerGlobal.get().getPkiService().szitrusCertStatus();
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int szitrusDid() {
        try {
            return PkiManagerGlobal.get().getPkiService().szitrusDid();
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int szitrusSignature() {
        try {
            return PkiManagerGlobal.get().getPkiService().szitrusSignature();
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void szitrusSync(String vin, String sn) {
        try {
            PkiManagerGlobal.get().getPkiService().szitrusSync(vin, sn);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int szitrusSyncCert() {
        try {
            return PkiManagerGlobal.get().getPkiService().szitrusSyncCert();
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int szitrusSyncDevice(String vin, String sn) {
        try {
            return PkiManagerGlobal.get().getPkiService().szitrusSyncDevice(vin, sn);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int szitrusSyncDomain(String ip, int port) {
        try {
            return PkiManagerGlobal.get().getPkiService().szitrusSyncDomain(ip, port);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int szitrusSyncPolicy(int cycleDay, int cycleHour, int cycleMin, int did) {
        try {
            return PkiManagerGlobal.get().getPkiService().szitrusSyncPolicy(cycleDay, cycleHour, cycleMin, did);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int szitrusVerify() {
        try {
            return PkiManagerGlobal.get().getPkiService().szitrusVerify();
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String szitrusgetVersion() {
        try {
            return PkiManagerGlobal.get().getPkiService().szitrusgetVersion();
        }
        catch(Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public int verify(String type, String sign, String src, String dataType, String encode) {
        try {
            return PkiManagerGlobal.get().getPkiService().verify(type, sign, src, dataType, encode);
        }
        catch(Exception e) {
            e.printStackTrace();
            return -9;
        }
    }
}

