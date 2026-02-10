package com.yftech.car.phonelink;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.ServiceManager;
import android.util.ArrayMap;
import android.util.Log;
import com.yftech.car.utils.MonitorServiceRestartManager.IMonitorCallback;
import com.yftech.car.utils.MonitorServiceRestartManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class CarPhoneLinkManager {
    public static abstract class CarPhoneLinkCallback {
        public void onAndroidPriorityPhoneLinkChanged(String type) {
        }

        public void onCallStatusChanged(int status) {
        }

        public void onCarLinkDeviceListChanged(String type, List list0) {
        }

        public void onConnectedFail(String type, int reason) {
        }

        public void onConnectedFailWithDevice(String type, int reason, CarLinkDevice device) {
        }

        public void onConnectedStatusChanged(String status) {
        }

        public void onDeviceChanged(PhoneLink link) {
        }

        public void onForegroundChanged(boolean isForeground) {
        }

        public void onHicarReConnectStateChange(boolean isReconnect, String deviceName) {
        }

        public void onIOSPriorityPhoneLinkChanged(String type) {
        }

        public void onMicStatusChanged(boolean isWork) {
        }

        public void onMobilePhoneLowBattery(int batteryLevel) {
        }

        public void onPhoneLinkEnableChanged(boolean isEnable) {
        }

        public void onSecondDeviceAvailable(CarLinkDevice device) {
        }

        public void onShowCarplayConfirmFirstConnectDialog(CarLinkDevice device) {
        }

        public void onShowHuaWeiConnectedDialog() {
        }

        public void onVRStatusChanged(int status) {
        }
    }

    static final class CarPhoneLinkManagerGlobal extends Stub implements IBinder.DeathRecipient, IMonitorCallback {
        private static final CarPhoneLinkManagerGlobal gCarPhoneLinkManager;
        private final ArrayMap mCallbackMap;
        private static ICarPhoneLinkService mCarPhoneLinkService;
        private final Object mLock;

        static {
            CarPhoneLinkManagerGlobal.gCarPhoneLinkManager = new CarPhoneLinkManagerGlobal();
        }

        private CarPhoneLinkManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
        }

        public void accpetPhone() {
            try {
                this.getCarPhoneLinkService().accpetPhone();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback$Stub
        public IBinder asBinder() {
            return this;
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("CarPhoneLinkManager", "binder died,reconnect service car_phonelink after 1000ms!");
            synchronized(this.mLock) {
                if(CarPhoneLinkManagerGlobal.mCarPhoneLinkService == null) {
                    return;
                }
                CarPhoneLinkManagerGlobal.mCarPhoneLinkService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        public void confirmFirstConnect(String address) {
            try {
                this.getCarPhoneLinkService().confirmFirstConnect(address);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void connectByUsb(String type) {
            try {
                this.getCarPhoneLinkService().connectByUsb(type);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void connectByWireless(String type) {
            try {
                this.getCarPhoneLinkService().connectByWireless(type);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void connectCarLinkDevice(CarLinkDevice device) {
            try {
                this.getCarPhoneLinkService().connectCarLinkDevice(device);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        private boolean connectCarPhoneLinkServiceLocked() {
            if(CarPhoneLinkManagerGlobal.mCarPhoneLinkService == null || CarPhoneLinkManagerGlobal.mCarPhoneLinkService.asBinder() == null || !CarPhoneLinkManagerGlobal.mCarPhoneLinkService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = ServiceManager.getService("car_phonelink");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        CarPhoneLinkManagerGlobal.mCarPhoneLinkService = com.yftech.car.phonelink.ICarPhoneLinkService.Stub.asInterface(iBinder0);
                        Log.i("CarPhoneLinkManager", "mCarPhoneLinkService:" + CarPhoneLinkManagerGlobal.mCarPhoneLinkService);
                        CarPhoneLinkManagerGlobal.mCarPhoneLinkService.registerCarPhoneLinkCallback(this);
                        return true;
                    }
                    Log.e("CarPhoneLinkManager", "the car phoneLink service not started!connected service fail!");
                    return false;
                }
                catch(Exception e) {
                }
            }
            else {
                return true;
            }
            Log.e("CarPhoneLinkManager", "link to death error!" + e.getMessage());
            e.printStackTrace();
            return false;
        }

        public void connetCarplayByAddress(String address) {
            try {
                this.getCarPhoneLinkService().connetCarplayByAddress(address);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void disConnect(String type) {
            try {
                this.getCarPhoneLinkService().disConnect(type);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void disConnectByAddress(String address) {
            try {
                this.getCarPhoneLinkService().disConnectByAddress(address);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void disConnectCarLinkDevice(String type, CarLinkDevice device) {
            try {
                this.getCarPhoneLinkService().disConnectCarLinkDevice(type, device);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void disablePhoneLink() {
            try {
                this.getCarPhoneLinkService().disablePhoneLink();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void enablePhoneLink() {
            try {
                this.getCarPhoneLinkService().enablePhoneLink();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void forgetCarLinkDevice(CarLinkDevice device) {
            try {
                this.getCarPhoneLinkService().forgetCarLinkDevice(device);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public static CarPhoneLinkManagerGlobal get() {
            return CarPhoneLinkManagerGlobal.gCarPhoneLinkManager;
        }

        public String getAndroidPriorityLink() {
            try {
                return this.getCarPhoneLinkService().getAndroidPriorityLink();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public List getAvailableCarLinkDeviceList(String type) {
            try {
                return this.getCarPhoneLinkService().getAvailableCarLinkDeviceList(type);
            }
            catch(Exception e) {
                e.printStackTrace();
                return new ArrayList();
            }
        }

        public List getBondedCarLinkDeviceList(String type) {
            try {
                return this.getCarPhoneLinkService().getBondedCarLinkDeviceList(type);
            }
            catch(Exception e) {
                e.printStackTrace();
                return new ArrayList();
            }
        }

        public int getCallStatus() {
            try {
                return this.getCarPhoneLinkService().getCallStatus();
            }
            catch(Exception e) {
                e.printStackTrace();
                return -1;
            }
        }

        public CarLinkDevice getCarLinkDeviceByBlueToothAddress(String address) {
            try {
                return this.getCarPhoneLinkService().getCarLinkDeviceByBlueToothAddress(address);
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public List getCarLinkDeviceList(String type) {
            try {
                return this.getCarPhoneLinkService().getCarLinkDeviceList(type);
            }
            catch(Exception e) {
                e.printStackTrace();
                return new ArrayList();
            }
        }

        public ICarPhoneLinkService getCarPhoneLinkService() {
            synchronized(this.mLock) {
                if(!this.connectCarPhoneLinkServiceLocked() || CarPhoneLinkManagerGlobal.mCarPhoneLinkService == null) {
                    Log.e("CarPhoneLinkManager", "car phoneLink service is unavailable");
                    this.startReconnectThread();
                }
                return CarPhoneLinkManagerGlobal.mCarPhoneLinkService;
            }
        }

        public CarLinkDevice getConnectedCarLinkDevice(String type) {
            try {
                return this.getCarPhoneLinkService().getConnectedCarLinkDevice(type);
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public String getConnectedLinkStatus() {
            try {
                return this.getCarPhoneLinkService().getConnectedLinkStatus();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public PhoneLink getConnectedPhoneLink() {
            try {
                return this.getCarPhoneLinkService().getConnectedPhoneLink();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public String getIOSPriorityLink() {
            try {
                return this.getCarPhoneLinkService().getIOSPriorityLink();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int getMobilePhoneLowBattery() {
            try {
                return this.getCarPhoneLinkService().getMobilePhoneLowBattery();
            }
            catch(Exception e) {
                e.printStackTrace();
                return -1;
            }
        }

        // String Decryptor: 1 succeeded, 0 failed
        public String getPhoneName() {
            try {
                return this.getCarPhoneLinkService().getPhoneName();
            }
            catch(Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        public List getSupportPhoneLinks() {
            try {
                return this.getCarPhoneLinkService().getSupportPhoneLinks();
            }
            catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int getVRStatus() {
            try {
                return this.getCarPhoneLinkService().getVRStatus();
            }
            catch(Exception e) {
                e.printStackTrace();
                return -1;
            }
        }

        public int getVersion() {
            try {
                return this.getCarPhoneLinkService().version();
            }
            catch(Exception e) {
                e.printStackTrace();
                return -1;
            }
        }

        public boolean hadBeenConnected(String type) {
            try {
                return this.getCarPhoneLinkService().hadBeenConnected(type);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean isBlueToothDeviceConnected(String address) {
            try {
                return this.getCarPhoneLinkService().isBlueToothDeviceConnected(address);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean isCarplayCertificate() {
            try {
                return this.getCarPhoneLinkService().isCarplayCertificate();
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean isForeground() {
            try {
                return this.getCarPhoneLinkService().isForeground();
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean isMicWork() {
            try {
                return this.getCarPhoneLinkService().isMicWork();
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean isPhoneLinkEnable() {
            try {
                return this.getCarPhoneLinkService().isPhoneLinkEnable();
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean isSupportAndroidAuto(String address) {
            try {
                return this.getCarPhoneLinkService().isSupportAndroidAuto(address);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onAndroidPriorityPhoneLinkChanged(String type) {
            Log.i("CarPhoneLinkManager", "onAndroidPriorityPhoneLinkChanged:" + type);
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

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onCallStatusChanged(int status) {
            Log.i("CarPhoneLinkManager", "onCallStatusChanged:" + status);
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

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onCarLinkDeviceListChanged(String type, List list0) {
            Log.i("CarPhoneLinkManager", "onCarLinkDeviceListChanged:" + list0);
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

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onConnectedFail(String type, int reason) {
            Log.i("CarPhoneLinkManager", "onConnectedFail:" + type + "," + reason);
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

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onConnectedFailWithDevice(String type, int reason, CarLinkDevice device) {
            Log.i("CarPhoneLinkManager", "onConnectedFailWithDevice:" + type + "," + reason + "," + device);
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

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onConnectedStatusChanged(String status) {
            Log.i("CarPhoneLinkManager", "onConnectedStatusChanged:" + status);
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

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onDeviceChanged(PhoneLink link) {
            Log.i("CarPhoneLinkManager", "onDeviceChanged:" + link);
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

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onForegroundChanged(boolean isForeground) {
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

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onHicarReConnectStateChange(boolean isReconnect, String deviceName) {
            Log.i("CarPhoneLinkManager", "onHicarReConnectStateChange isReconnect:" + isReconnect + ",deviceName:" + deviceName);
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

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onIOSPriorityPhoneLinkChanged(String type) {
            Log.i("CarPhoneLinkManager", "onIOSPriorityPhoneLinkChanged:" + type);
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

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onMicStatusChanged(boolean isWork) {
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

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onMobilePhoneLowBattery(int batteryLevel) {
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

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onPhoneLinkEnableChanged(boolean isEnable) {
            Log.i("CarPhoneLinkManager", "onPhoneLinkEnableChanged:" + isEnable);
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

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onSecondDeviceAvailable(CarLinkDevice device) {
            Log.i("CarPhoneLinkManager", "onSecondDeviceAvailable device:" + device);
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
            this.connectCarPhoneLinkServiceLocked();
        }

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onShowCarplayConfirmFirstConnectDialog(CarLinkDevice device) {
            Log.i("CarPhoneLinkManager", "onShowCarplayConfirmFirstConnectDialog device:" + device);
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

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onShowHuaWeiConnectedDialog() {
            Log.i("CarPhoneLinkManager", "onShowHuaWeiConnectedDialog");
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

        @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
        public void onVRStatusChanged(int status) {
            Log.i("CarPhoneLinkManager", "onVRStatusChanged:" + status);
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

        public void pickAndroidPriorityLink(String type) {
            try {
                this.getCarPhoneLinkService().pickAndroidPriorityLink(type);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void pickCarLifeWhenHuaWei() {
            try {
                this.getCarPhoneLinkService().pickCarLifeWhenHuaWei();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void pickHiCarWhenHuaWei() {
            try {
                this.getCarPhoneLinkService().pickHiCarWhenHuaWei();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void pickIOSPriorityLink(String type) {
            try {
                this.getCarPhoneLinkService().pickIOSPriorityLink(type);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void reConnectPreDevice(String type) {
            try {
                this.getCarPhoneLinkService().reConnectPreDevice(type);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void registerCarPhoneLinkCallback(CarPhoneLinkCallback callback, Handler handler) {
            synchronized(this.mLock) {
                if(!this.connectCarPhoneLinkServiceLocked()) {
                    this.startReconnectThread();
                }
                if(!this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.put(callback, handler);
                }
            }
        }

        public void rejectPhone() {
            try {
                this.getCarPhoneLinkService().rejectPhone();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void requestCarPlaySiri(int action) {
            try {
                this.getCarPhoneLinkService().requestCarPlaySiri(action);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public boolean requestNewConnect() {
            try {
                return this.getCarPhoneLinkService().requestNewConnect();
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean requestReConnect(String address) {
            try {
                return this.getCarPhoneLinkService().requestReConnect(address);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean requestShowFirstConnectDialog(String address) {
            try {
                return this.getCarPhoneLinkService().requestShowFirstConnectDialog(address);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean requestShowTheFirstConnectDialog(String phonelink, String address) {
            try {
                return this.getCarPhoneLinkService().requestShowTheFirstConnectDialog(phonelink, address);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public void sendLongPressKeyEvent(int keycode) {
            try {
                this.getCarPhoneLinkService().sendLongPressKeyEvent(keycode);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void sendShortPressKeyEvent(int keycode) {
            try {
                this.getCarPhoneLinkService().sendShortPressKeyEvent(keycode);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void startCallPage() {
            try {
                this.getCarPhoneLinkService().startCallPage();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void startDiscovery() {
            try {
                this.getCarPhoneLinkService().startDiscovery();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void startPage(int type) {
            try {
                this.getCarPhoneLinkService().startPage(type);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void startPriorityLinkAction() {
            try {
                this.getCarPhoneLinkService().startPriorityLinkAction();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        private void startReconnectThread() {
            MonitorServiceRestartManager.getInstance().addMonitor("car_phonelink", this);
        }

        public void startVR() {
            try {
                this.getCarPhoneLinkService().startVR();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void stopDiscovery() {
            try {
                this.getCarPhoneLinkService().stopDiscovery();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public boolean supportWireless() {
            try {
                return this.getCarPhoneLinkService().supportWireless();
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public void tel(String phone) {
            try {
                this.getCarPhoneLinkService().tel(phone);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void unregisterCarPhoneLinkCallback(CarPhoneLinkCallback callback) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.remove(callback);
                }
            }
        }

        public void updateCarPlayMedia(int action) {
            try {
                this.getCarPhoneLinkService().updateCarPlayMedia(action);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void updateCarPlayTelehony(int action) {
            try {
                this.getCarPhoneLinkService().updateCarPlayTelehony(action);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static final String SERVICE_NAME = "car_phonelink";
    private static final String TAG = null;
    private static final int TYPE_CONNECT_BY_USB = 0;
    private static final int TYPE_CONNECT_BY_WIRELESS = 1;
    private static final int TYPE_CONNECT_CARLINK_DEVICE = 5;
    private static final int TYPE_CONNECT_CARPLAY_BY_ADDRESS = 2;
    private static final int TYPE_DISCONNECT = 3;
    private static final int TYPE_DISCONNECT_BY_ADDRESS = 4;
    private static final int TYPE_REQUEST_NEW_CONNECT = 6;
    private static final int TYPE_REQUEST_RECONNECT = 7;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private static volatile CarPhoneLinkManager mInstance;

    static {
        CarPhoneLinkManager.TAG = "CarPhoneLinkManager";
    }

    private CarPhoneLinkManager() {
        this.mHandlerThread = new HandlerThread("phoneLinkThread");
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) {
            @Override  // android.os.Handler
            public void handleMessage(Message msg) {
                if(msg == null) {
                    return;
                }
                switch(msg.what) {
                    case 0: {
                        try {
                            CarPhoneLinkManagerGlobal.get().connectByUsb(((String)msg.obj));
                        }
                        catch(Exception e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    case 1: {
                        try {
                            CarPhoneLinkManagerGlobal.get().connectByWireless(((String)msg.obj));
                        }
                        catch(Exception e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    case 2: {
                        try {
                            CarPhoneLinkManagerGlobal.get().connetCarplayByAddress(((String)msg.obj));
                        }
                        catch(Exception e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    case 3: {
                        try {
                            CarPhoneLinkManagerGlobal.get().disConnect(((String)msg.obj));
                        }
                        catch(Exception e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    case 4: {
                        try {
                            CarPhoneLinkManagerGlobal.get().disConnectByAddress(((String)msg.obj));
                        }
                        catch(Exception e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    case 5: {
                        try {
                            CarPhoneLinkManagerGlobal.get().connectCarLinkDevice(((CarLinkDevice)msg.obj));
                        }
                        catch(Exception e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    case 6: {
                        try {
                            CarPhoneLinkManagerGlobal.get().requestNewConnect();
                        }
                        catch(Exception e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    case 7: {
                        try {
                            CarPhoneLinkManagerGlobal.get().requestReConnect(((String)msg.obj));
                        }
                        catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
    }

    // String Decryptor: 19 succeeded, 0 failed
    static String access$000() {
        return "CarPhoneLinkManager";
    }

    public void accpetPhone() {
        try {
            CarPhoneLinkManagerGlobal.get().accpetPhone();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void confirmFirstConnect(String address) {
        try {
            CarPhoneLinkManagerGlobal.get().confirmFirstConnect(address);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void connectByUsb(String type) {
        this.mHandler.removeMessages(0);
        Message message0 = Message.obtain();
        message0.what = 0;
        message0.obj = type;
        this.mHandler.sendMessage(message0);
    }

    public void connectByWireless(String type) {
        this.mHandler.removeMessages(1);
        Message message0 = Message.obtain();
        message0.what = 1;
        message0.obj = type;
        this.mHandler.sendMessage(message0);
    }

    public void connectCarLinkDevice(CarLinkDevice device) {
        this.mHandler.removeMessages(5);
        Message message0 = Message.obtain();
        message0.what = 5;
        message0.obj = device;
        this.mHandler.sendMessage(message0);
    }

    public void connetCarplayByAddress(String address) {
        this.mHandler.removeMessages(2);
        Message message0 = Message.obtain();
        message0.what = 2;
        message0.obj = address;
        this.mHandler.sendMessage(message0);
    }

    public void disConnect(String type) {
        if(this.mHandler.hasMessages(3, type)) {
            return;
        }
        Message message0 = Message.obtain();
        message0.what = 3;
        message0.obj = type;
        this.mHandler.sendMessage(message0);
    }

    public void disConnectByAddress(String address) {
        if(this.mHandler.hasMessages(4, address)) {
            return;
        }
        Message message0 = Message.obtain();
        message0.what = 4;
        message0.obj = address;
        this.mHandler.sendMessage(message0);
    }

    public void disConnectCarLinkDevice(String type, CarLinkDevice device) {
        try {
            CarPhoneLinkManagerGlobal.get().disConnectCarLinkDevice(type, device);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void disablePhoneLink() {
        try {
            CarPhoneLinkManagerGlobal.get().disablePhoneLink();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enablePhoneLink() {
        try {
            CarPhoneLinkManagerGlobal.get().enablePhoneLink();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void forgetCarLinkDevice(CarLinkDevice device) {
        try {
            CarPhoneLinkManagerGlobal.get().forgetCarLinkDevice(device);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String getAndroidPriorityLink() {
        try {
            return CarPhoneLinkManagerGlobal.get().getAndroidPriorityLink();
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List getAvailableCarLinkDeviceList(String type) {
        try {
            return CarPhoneLinkManagerGlobal.get().getAvailableCarLinkDeviceList(type);
        }
        catch(Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List getBondedCarLinkDeviceList(String type) {
        try {
            return CarPhoneLinkManagerGlobal.get().getBondedCarLinkDeviceList(type);
        }
        catch(Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public int getCallStatus() {
        try {
            return CarPhoneLinkManagerGlobal.get().getCallStatus();
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public CarLinkDevice getCarLinkDeviceByBlueToothAddress(String address) {
        try {
            return CarPhoneLinkManagerGlobal.get().getCarLinkDeviceByBlueToothAddress(address);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List getCarLinkDeviceList(String type) {
        try {
            return CarPhoneLinkManagerGlobal.get().getCarLinkDeviceList(type);
        }
        catch(Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public CarLinkDevice getConnectedCarLinkDevice(String type) {
        try {
            return CarPhoneLinkManagerGlobal.get().getConnectedCarLinkDevice(type);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getConnectedLinkStatus() {
        return CarPhoneLinkManagerGlobal.get().getConnectedLinkStatus();
    }

    public PhoneLink getConnectedPhoneLink() {
        return CarPhoneLinkManagerGlobal.get().getConnectedPhoneLink();
    }

    public String getIOSPriorityLink() {
        try {
            return CarPhoneLinkManagerGlobal.get().getIOSPriorityLink();
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static CarPhoneLinkManager getInstance() {
        if(CarPhoneLinkManager.mInstance == null) {
            Class class0 = CarPhoneLinkManager.class;
            synchronized(class0) {
                if(CarPhoneLinkManager.mInstance == null) {
                    CarPhoneLinkManager.mInstance = new CarPhoneLinkManager();
                }
            }
        }
        return CarPhoneLinkManager.mInstance;
    }

    public int getMobilePhoneLowBattery() {
        try {
            return CarPhoneLinkManagerGlobal.get().getMobilePhoneLowBattery();
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String getPhoneName() {
        return "";
    }

    List getSupportPhoneLinks() {
        try {
            return CarPhoneLinkManagerGlobal.get().getSupportPhoneLinks();
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getVRStatus() {
        try {
            return CarPhoneLinkManagerGlobal.get().getVRStatus();
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getVersion() {
        return CarPhoneLinkManagerGlobal.get().getVersion();
    }

    public boolean hadBeenConnected(String type) {
        try {
            return CarPhoneLinkManagerGlobal.get().hadBeenConnected(type);
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isBlueToothDeviceConnected(String address) {
        try {
            return CarPhoneLinkManagerGlobal.get().isBlueToothDeviceConnected(address);
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isCarplayCertificate() {
        try {
            return CarPhoneLinkManagerGlobal.get().isCarplayCertificate();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isForeground() {
        try {
            return CarPhoneLinkManagerGlobal.get().isForeground();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isMicWork() {
        try {
            return CarPhoneLinkManagerGlobal.get().isMicWork();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isPhoneLinkEnable() {
        try {
            return CarPhoneLinkManagerGlobal.get().isPhoneLinkEnable();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isSupportAndroidAuto(String address) {
        try {
            return CarPhoneLinkManagerGlobal.get().isSupportAndroidAuto(address);
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void pickAndroidPriorityLink(String type) {
        try {
            CarPhoneLinkManagerGlobal.get().pickAndroidPriorityLink(type);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void pickCarLifeWhenHuaWei() {
        try {
            CarPhoneLinkManagerGlobal.get().pickCarLifeWhenHuaWei();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void pickHiCarWhenHuaWei() {
        try {
            CarPhoneLinkManagerGlobal.get().pickHiCarWhenHuaWei();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void pickIOSPriorityLink(String type) {
        try {
            CarPhoneLinkManagerGlobal.get().pickIOSPriorityLink(type);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void reConnectPreDevice(String type) {
        try {
            CarPhoneLinkManagerGlobal.get().reConnectPreDevice(type);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void registerCarPhoneLinkCallback(CarPhoneLinkCallback callback, Handler handler) {
        if(handler == null) {
            Looper looper0 = Looper.myLooper();
            if(looper0 == null) {
                throw new IllegalArgumentException("No handler given, and current thread has no looper!");
            }
            handler = new Handler(looper0);
        }
        CarPhoneLinkManagerGlobal.get().registerCarPhoneLinkCallback(callback, handler);
    }

    public void rejectPhone() {
        try {
            CarPhoneLinkManagerGlobal.get().rejectPhone();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void requestCarPlaySiri(int action) {
        try {
            CarPhoneLinkManagerGlobal.get().requestCarPlaySiri(action);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public boolean requestNewConnect() {
        this.mHandler.removeMessages(6);
        Message message0 = Message.obtain();
        message0.what = 6;
        this.mHandler.sendMessage(message0);
        return true;
    }

    public boolean requestReConnect(String address) {
        this.mHandler.removeMessages(7);
        Message message0 = Message.obtain();
        message0.what = 7;
        message0.obj = address;
        this.mHandler.sendMessage(message0);
        return true;
    }

    public boolean requestShowFirstConnectDialog(String address) {
        try {
            return CarPhoneLinkManagerGlobal.get().requestShowFirstConnectDialog(address);
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean requestShowFirstConnectDialog(String phonelink, String address) {
        try {
            return CarPhoneLinkManagerGlobal.get().requestShowTheFirstConnectDialog(phonelink, address);
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void sendLongPressKeyEvent(int keycode) {
        try {
            CarPhoneLinkManagerGlobal.get().sendLongPressKeyEvent(keycode);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void sendShortPressKeyEvent(int keycode) {
        try {
            CarPhoneLinkManagerGlobal.get().sendShortPressKeyEvent(keycode);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void startCallPage() {
        try {
            CarPhoneLinkManagerGlobal.get().startCallPage();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void startDiscovery() {
        try {
            CarPhoneLinkManagerGlobal.get().startDiscovery();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void startPage(int type) {
        try {
            CarPhoneLinkManagerGlobal.get().startPage(type);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void startPriorityLinkAction() {
        try {
            CarPhoneLinkManagerGlobal.get().startPriorityLinkAction();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void startVR() {
        try {
            CarPhoneLinkManagerGlobal.get().startVR();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void stopDiscovery() {
        try {
            CarPhoneLinkManagerGlobal.get().stopDiscovery();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public boolean supportWireless() {
        try {
            return CarPhoneLinkManagerGlobal.get().supportWireless();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void tel(String phone) {
        try {
            CarPhoneLinkManagerGlobal.get().tel(phone);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void unregisterCarPhoneLinkCallback(CarPhoneLinkCallback callback) {
        CarPhoneLinkManagerGlobal.get().unregisterCarPhoneLinkCallback(callback);
    }

    public void updateCarPlayMedia(int action) {
        try {
            CarPhoneLinkManagerGlobal.get().updateCarPlayMedia(action);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCarPlayTelehony(int action) {
        try {
            CarPhoneLinkManagerGlobal.get().updateCarPlayTelehony(action);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

