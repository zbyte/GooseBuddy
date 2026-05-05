package com.yftech.car.utils;

import android.util.Log;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

public class MonitorServiceRestartManager {
    public interface IMonitorCallback {
        void onServiceStart(String arg1);
    }

    class MonitorThread extends Thread {
        private boolean mExit;

        MonitorThread() {
            super("service.restart");
            this.mExit = false;
        }

        void exit() {
            this.mExit = true;
            synchronized(MonitorServiceRestartManager.this.mMonitorTaskQueue) {
                MonitorServiceRestartManager.this.mMonitorTaskQueue.notifyAll();
            }
        }

        private boolean isServiceStart(String serviceName) {
            try {
                Class<?> serviceManagerClass = Class.forName("android.os.ServiceManager");
                Method getServiceMethod = serviceManagerClass.getMethod("getService", String.class);
                Object service = getServiceMethod.invoke(null, serviceName);
                return service != null;
            } catch (Exception e) {
                return false;
            }
        }

        @Override
        public void run() {
            while(!this.mExit) {
                Map map0 = MonitorServiceRestartManager.this.mMonitorTaskQueue;
                synchronized(map0) {
                    if(MonitorServiceRestartManager.this.mMonitorTaskQueue.isEmpty()) {
                        try {
                            MonitorServiceRestartManager.this.mMonitorTaskQueue.wait();
                        }
                        catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                        continue;
                    }
                }
                List hasStartServiceList = null;
                for(Object object0: new HashMap(MonitorServiceRestartManager.this.mMonitorTaskQueue).entrySet()) {
                    Map.Entry entry = (Map.Entry)object0;
                    if(this.isServiceStart(((String)entry.getKey()))) {
                        if(hasStartServiceList == null) {
                            hasStartServiceList = new ArrayList();
                        }
                        hasStartServiceList.add(entry.getKey());
                        for(Object object1: ((List)entry.getValue())) {
                            IMonitorCallback callback = (IMonitorCallback)object1;
                            if(callback != null) {
                                try {
                                    Log.i("MonitorServiceRestartManager", "service(" + ((String)entry.getKey()) + ") start");
                                    callback.onServiceStart(((String)entry.getKey()));
                                }
                                catch(Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
                if(hasStartServiceList != null && !hasStartServiceList.isEmpty()) {
                    Map map1 = MonitorServiceRestartManager.this.mMonitorTaskQueue;
                    synchronized(map1) {
                        for(Object object2: hasStartServiceList) {
                            MonitorServiceRestartManager.this.mMonitorTaskQueue.remove(((String)object2));
                        }
                    }
                }
                try {
                    Thread.sleep(500L);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static final String TAG = "MonitorServiceRestartManager";
    private static volatile MonitorServiceRestartManager mInstance;
    private final Map mMonitorTaskQueue;
    private MonitorThread mMonitorThread;

    private MonitorServiceRestartManager() {
        this.mMonitorTaskQueue = new HashMap();
    }

    // String Decryptor: 1 succeeded, 0 failed
    static String access$100() {
        return "MonitorServiceRestartManager";
    }

    public void addMonitor(String serviceName, IMonitorCallback callback) {
        synchronized(this.mMonitorTaskQueue) {
            if(this.mMonitorThread == null || !this.mMonitorThread.isAlive()) {
                if(this.mMonitorThread != null) {
                    this.mMonitorThread.exit();
                }
                this.mMonitorThread = new MonitorThread();
                this.mMonitorThread.start();
            }
            if(this.mMonitorTaskQueue.containsKey(serviceName)) {
                if(callback != null && !((List)this.mMonitorTaskQueue.get(serviceName)).contains(callback)) {
                    ((List)this.mMonitorTaskQueue.get(serviceName)).add(callback);
                }
                Log.v("MonitorServiceRestartManager", "service(" + serviceName + ") has add to monitor queue");
                return;
            }
            ArrayList list = new ArrayList();
            list.add(callback);
            this.mMonitorTaskQueue.put(serviceName, list);
            if(this.mMonitorTaskQueue.size() == 1) {
                this.mMonitorTaskQueue.notifyAll();
            }
        }
    }

    public static MonitorServiceRestartManager getInstance() {
        if(MonitorServiceRestartManager.mInstance == null) {
            Class class0 = MonitorServiceRestartManager.class;
            synchronized(class0) {
                if(MonitorServiceRestartManager.mInstance == null) {
                    MonitorServiceRestartManager.mInstance = new MonitorServiceRestartManager();
                }
            }
        }
        return MonitorServiceRestartManager.mInstance;
    }
}

