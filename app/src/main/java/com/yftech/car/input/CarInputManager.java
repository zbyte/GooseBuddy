package com.yftech.car.input;

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

public class CarInputManager {
    public static abstract class CarInputCallback {
        public void onChangedCustomKeyFunction(int function) {
        }

        public void onChangedCustomKeyFunctions(CarKeyCustomFunction function) {
        }

        public void onInputKey(CarKey key) {
        }

        public void onInputKeyCustomFunction(CarKeyCustomFunction function) {
        }

        public void onInputKnob(CarKnob knob) {
        }
    }

    static final class CarInputManagerGlobal extends Stub implements IBinder.DeathRecipient, IMonitorCallback {
        private static final String SERVICE_NAME = "car_input";
        private static final CarInputManagerGlobal gCarInputManager;
        private final ArrayMap mCallbackMap;
        private static ICarInputService mCarInputService;
        private final Object mLock;

        static {
            CarInputManagerGlobal.gCarInputManager = new CarInputManagerGlobal();
        }

        private CarInputManagerGlobal() {
            this.mLock = new Object();
            this.mCallbackMap = new ArrayMap();
        }

        @Override  // com.yftech.car.input.ICarInputCallback$Stub
        public IBinder asBinder() {
            return this;
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            Log.w("CarInputManager", "binder died,reconnect service car_input after 1000ms!");
            synchronized(this.mLock) {
                if(CarInputManagerGlobal.mCarInputService == null) {
                    return;
                }
                CarInputManagerGlobal.mCarInputService = null;
                if(!this.mCallbackMap.isEmpty()) {
                    this.startReconnectThread();
                }
            }
        }

        private boolean connectCarInputServiceLocked() {
            if(CarInputManagerGlobal.mCarInputService == null || CarInputManagerGlobal.mCarInputService.asBinder() == null || !CarInputManagerGlobal.mCarInputService.asBinder().isBinderAlive()) {
                IBinder iBinder0 = ServiceManager.getService("car_input");
                try {
                    if(iBinder0 != null) {
                        iBinder0.linkToDeath(this, 0);
                        CarInputManagerGlobal.mCarInputService = com.yftech.car.input.ICarInputService.Stub.asInterface(iBinder0);
                        CarInputManagerGlobal.mCarInputService.registerCarInputCallback(this);
                        return true;
                    }
                    Log.e("CarInputManager", "the car input service not started!connected service fail!");
                    return false;
                }
                catch(RemoteException e) {
                }
            }
            else {
                return true;
            }
            Log.e("CarInputManager", "link to death error!" + e.getMessage());
            e.printStackTrace();
            return false;
        }

        public static CarInputManagerGlobal get() {
            return CarInputManagerGlobal.gCarInputManager;
        }

        public ICarInputService getCarInputService() {
            synchronized(this.mLock) {
                if(!this.connectCarInputServiceLocked() || CarInputManagerGlobal.mCarInputService == null) {
                    Log.e("CarInputManager", "car input service is unavailable");
                    this.startReconnectThread();
                }
                return CarInputManagerGlobal.mCarInputService;
            }
        }

        int getCustomKeyFunction() {
            try {
                return this.getCarInputService().getCustomKeyFunction();
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return -1;
            }
        }

        CarKeyCustomFunction getCustomKeyFunctions() {
            try {
                return this.getCarInputService().getCustomKeyFunctions();
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
                return new CarKeyCustomFunction(-1, -1, 0);
            }
        }

        @Override  // com.yftech.car.input.ICarInputCallback
        public void onChangedCustomKeyFunction(int function) throws RemoteException {
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

        @Override  // com.yftech.car.input.ICarInputCallback
        public void onChangedCustomKeyFunctions(CarKeyCustomFunction function) throws RemoteException {
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

        @Override  // com.yftech.car.input.ICarInputCallback
        public void onInputKeyCustomFunction(CarKeyCustomFunction function) throws RemoteException {
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

        @Override  // com.yftech.car.input.ICarInputCallback
        public void onInputKeyEvent(CarKey event) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.input.ICarInputCallback
        public void onInputKnobEvent(CarKnob event) throws RemoteException {
            int v = this.mCallbackMap.size();
            for(int i = 0; i < v; ++i) {
                ((Handler)this.mCallbackMap.valueAt(i)).post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }

        @Override  // com.yftech.car.utils.MonitorServiceRestartManager$IMonitorCallback
        public void onServiceStart(String serviceName) {
            this.connectCarInputServiceLocked();
        }

        public void registerCarInputCallback(CarInputCallback callback, Handler handler) {
            synchronized(this.mLock) {
                if(!this.connectCarInputServiceLocked()) {
                    this.startReconnectThread();
                }
                if(!this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.put(callback, handler);
                }
            }
        }

        void responseCarKeyAction(CarKey event) {
            try {
                this.getCarInputService().responseCarKeyAction(event);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
            }
        }

        void setCustomKeyFunction(int function) {
            try {
                this.getCarInputService().setCustomKeyFunction(function);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
            }
        }

        void setCustomKeyFunctions(CarKeyCustomFunction function) {
            try {
                this.getCarInputService().setCustomKeyFunctions(function);
            }
            catch(RemoteException | NullPointerException e) {
                e.printStackTrace();
            }
        }

        private void startReconnectThread() {
            MonitorServiceRestartManager.getInstance().addMonitor("car_input", this);
        }

        public void unregisterCarInputCallback(CarInputCallback callback) {
            synchronized(this.mLock) {
                if(this.mCallbackMap.containsKey(callback)) {
                    this.mCallbackMap.remove(callback);
                }
            }
        }
    }

    public static final String SERVICE_NAME = "car_input";
    private static final String TAG;
    private static volatile CarInputManager mInstance;

    static {
        CarInputManager.TAG = "CarInputManager";
    }

    // String Decryptor: 4 succeeded, 0 failed
    static String access$000() {
        return "CarInputManager";
    }

    public int getCustomKeyFunction() {
        return CarInputManagerGlobal.get().getCustomKeyFunction();
    }

    public CarKeyCustomFunction getCustomKeyFunctions() {
        return CarInputManagerGlobal.get().getCustomKeyFunctions();
    }

    public static CarInputManager getInstance() {
        if(CarInputManager.mInstance == null) {
            Class class0 = CarInputManager.class;
            synchronized(class0) {
                if(CarInputManager.mInstance == null) {
                    CarInputManager.mInstance = new CarInputManager();
                }
            }
        }
        return CarInputManager.mInstance;
    }

    public void registerCarInputCallback(CarInputCallback callback, Handler handler) {
        if(handler == null) {
            Looper looper0 = Looper.myLooper();
            if(looper0 == null) {
                throw new IllegalArgumentException("No handler given, and current thread has no looper!");
            }
            handler = new Handler(looper0);
        }
        CarInputManagerGlobal.get().registerCarInputCallback(callback, handler);
    }

    public void responseCarKeyAction(CarKey event) {
        CarInputManagerGlobal.get().responseCarKeyAction(event);
    }

    public void setCustomKeyFunction(int function) {
        CarInputManagerGlobal.get().setCustomKeyFunction(function);
    }

    public void setCustomKeyFunctions(CarKeyCustomFunction key) {
        CarInputManagerGlobal.get().setCustomKeyFunctions(key);
    }

    public void unregisterCarInputCallback(CarInputCallback callback) {
        CarInputManagerGlobal.get().unregisterCarInputCallback(callback);
    }
}

