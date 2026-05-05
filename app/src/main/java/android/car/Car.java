package android.car;


import android.car.drivingstate.CarDrivingStateManager;
import android.car.drivingstate.CarUxRestrictionsManager;
import android.car.hardware.CarSensorManager;
import android.car.hardware.CarVendorExtensionManager;
import android.car.hardware.cabin.CarCabinManager;
import android.car.hardware.hvac.CarHvacManager;
import android.car.hardware.power.CarPowerManager;
import android.car.hardware.property.CarPropertyManager;
import android.car.settings.CarConfigurationManager;
import android.car.test.CarTestManagerBinderWrapper;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Log;

import androidx.annotation.GuardedBy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

public final class Car {
    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionType {
    }

    public static final String APP_FOCUS_SERVICE = "app_focus";
    public static final String AUDIO_SERVICE = "audio";
    public static final String BLUETOOTH_SERVICE = "car_bluetooth";
    public static final String CABIN_SERVICE = "cabin";
    public static final String CAR_CONFIGURATION_SERVICE = "configuration";

    public static final String CAR_DRIVING_STATE_SERVICE = "drivingstate";
    public static final String CAR_EXTRA_MEDIA_PACKAGE = "android.car.intent.extra.MEDIA_PACKAGE";
    public static final String CAR_INSTRUMENT_CLUSTER_SERVICE = "cluster_service";
    public static final String CAR_INTENT_ACTION_MEDIA_TEMPLATE = "android.car.intent.action.MEDIA_TEMPLATE";
    public static final String CAR_NAVIGATION_SERVICE = "car_navigation_service";
    public static final String CAR_NOT_CONNECTED_EXCEPTION_MSG = "CarNotConnected";
    private static final long CAR_SERVICE_BIND_MAX_RETRY = 20L;
    private static final long CAR_SERVICE_BIND_RETRY_INTERVAL_MS = 500L;
    private static final String CAR_SERVICE_CLASS = "com.android.car.CarService";
    public static final String CAR_SERVICE_INTERFACE_NAME = "android.car.ICar";
    private static final String CAR_SERVICE_PACKAGE = "com.android.car";
    public static final String CAR_UX_RESTRICTION_SERVICE = "uxrestriction";
    public static final int CONNECTION_TYPE_EMBEDDED = 5;
    
    public static final String DIAGNOSTIC_SERVICE = "diagnostic";
    
    public static final String HVAC_SERVICE = "hvac";
    public static final String INFO_SERVICE = "info";
    public static final String PACKAGE_SERVICE = "package";
    
    public static final String PERMISSION_ADJUST_CAR_CABIN = "android.car.permission.ADJUST_CAR_CABIN";
    public static final String PERMISSION_CAR_CONTROL_AUDIO_SETTINGS = "android.car.permission.CAR_CONTROL_AUDIO_SETTINGS";
    public static final String PERMISSION_CAR_CONTROL_AUDIO_VOLUME = "android.car.permission.CAR_CONTROL_AUDIO_VOLUME";
    
    public static final String PERMISSION_CAR_DIAGNOSTIC_CLEAR = "android.car.permission.CLEAR_CAR_DIAGNOSTICS";
    
    public static final String PERMISSION_CAR_DIAGNOSTIC_READ_ALL = "android.car.permission.CAR_DIAGNOSTICS";
    public static final String PERMISSION_CAR_DISPLAY_IN_CLUSTER = "android.car.permission.CAR_DISPLAY_IN_CLUSTER";
    
    public static final String PERMISSION_CAR_DRIVING_STATE = "android.car.permission.CAR_DRIVING_STATE";
    
    public static final String PERMISSION_CAR_DYNAMICS_STATE = "android.car.permission.CAR_DYNAMICS_STATE";
    
    public static final String PERMISSION_CAR_ENGINE_DETAILED = "android.car.permission.CAR_ENGINE_DETAILED";
    public static final String PERMISSION_CAR_INFO = "android.car.permission.CAR_INFO";
    
    public static final String PERMISSION_CAR_INSTRUMENT_CLUSTER_CONTROL = "android.car.permission.CAR_INSTRUMENT_CLUSTER_CONTROL";
    public static final String PERMISSION_CAR_NAVIGATION_MANAGER = "android.car.permission.CAR_NAVIGATION_MANAGER";
    
    public static final String PERMISSION_CAR_POWER = "android.car.permission.CAR_POWER";
    
    public static final String PERMISSION_CAR_PROJECTION = "android.car.permission.CAR_PROJECTION";
    
    public static final String PERMISSION_CAR_TEST_SERVICE = "android.car.permission.CAR_TEST_SERVICE";
    
    public static final String PERMISSION_CONTROL_APP_BLOCKING = "android.car.permission.CONTROL_APP_BLOCKING";
    
    public static final String PERMISSION_CONTROL_CAR_CLIMATE = "android.car.permission.CONTROL_CAR_CLIMATE";
    
    public static final String PERMISSION_CONTROL_CAR_DOORS = "android.car.permission.CONTROL_CAR_DOORS";
    
    public static final String PERMISSION_CONTROL_CAR_MIRRORS = "android.car.permission.CONTROL_CAR_MIRRORS";
    
    public static final String PERMISSION_CONTROL_CAR_SEATS = "android.car.permission.CONTROL_CAR_SEATS";
    
    public static final String PERMISSION_CONTROL_CAR_WINDOWS = "android.car.permission.CONTROL_CAR_WINDOWS";
    
    public static final String PERMISSION_CONTROL_EXTERIOR_LIGHTS = "android.car.permission.CONTROL_CAR_EXTERIOR_LIGHTS";
    public static final String PERMISSION_ENERGY = "android.car.permission.CAR_ENERGY";
    public static final String PERMISSION_ENERGY_PORTS = "android.car.permission.CAR_ENERGY_PORTS";
    public static final String PERMISSION_EXTERIOR_ENVIRONMENT = "android.car.permission.CAR_EXTERIOR_ENVIRONMENT";
    
    public static final String PERMISSION_EXTERIOR_LIGHTS = "android.car.permission.CAR_EXTERIOR_LIGHTS";
    public static final String PERMISSION_IDENTIFICATION = "android.car.permission.CAR_IDENTIFICATION";
    
    public static final String PERMISSION_MILEAGE = "android.car.permission.CAR_MILEAGE";
    
    public static final String PERMISSION_MOCK_VEHICLE_HAL = "android.car.permission.CAR_MOCK_VEHICLE_HAL";
    public static final String PERMISSION_POWERTRAIN = "android.car.permission.CAR_POWERTRAIN";
    public static final String PERMISSION_SPEED = "android.car.permission.CAR_SPEED";
    
    public static final String PERMISSION_STORAGE_MONITORING = "android.car.permission.STORAGE_MONITORING";
    
    public static final String PERMISSION_TIRES = "android.car.permission.CAR_TIRES";
    
    public static final String PERMISSION_VENDOR_EXTENSION = "android.car.permission.CAR_VENDOR_EXTENSION";
    
    public static final String PERMISSION_VMS_PUBLISHER = "android.car.permission.VMS_PUBLISHER";
    
    public static final String PERMISSION_VMS_SUBSCRIBER = "android.car.permission.VMS_SUBSCRIBER";
    
    public static final String POWER_SERVICE = "power";
    
    public static final String PROJECTION_SERVICE = "projection";
    
    public static final String PROPERTY_SERVICE = "property";
    public static final String SENSOR_SERVICE = "sensor";
    private static final int STATE_CONNECTED = 2;
    private static final int STATE_CONNECTING = 1;
    private static final int STATE_DISCONNECTED = 0;
    
    public static final String STORAGE_MONITORING_SERVICE = "storage_monitoring";
    
    public static final String TEST_SERVICE = "car-service-test";
    
    public static final String VENDOR_EXTENSION_SERVICE = "vendor_extension";
    public static final int VERSION = 3;
    
    public static final String VMS_SUBSCRIBER_SERVICE = "vehicle_map_subscriber_service";
    private final Object mCarManagerLock;
    @GuardedBy("this")
    private int mConnectionRetryCount;
    private final Runnable mConnectionRetryFailedRunnable;
    private final Runnable mConnectionRetryRunnable;
    @GuardedBy("this")
    private int mConnectionState;
    private final Context mContext;
    private final Handler mEventHandler;
    private final Handler mMainThreadEventHandler;
    private final boolean mOwnsService;
    @GuardedBy("this")
    private ICar mService;
    private final ServiceConnection mServiceConnectionListener;
    private final ServiceConnection mServiceConnectionListenerClient;
    @GuardedBy("mCarManagerLock")
    private final HashMap mServiceMap;

    public Car(Context context, ICar service, Handler handler) {
        this.mConnectionRetryRunnable = () -> {
            Intent intent = new Intent();
            intent.setPackage("com.android.car");
            intent.setAction("android.car.ICar");
            if(!Car.this.mContext.bindService(intent, Car.this.mServiceConnectionListener, Context.BIND_AUTO_CREATE)) {
                ++Car.this.mConnectionRetryCount;
                if(((long)Car.this.mConnectionRetryCount) > 20L) {
                    Log.w("CAR.L", "cannot bind to car service after max retry");
                    Car.this.mMainThreadEventHandler.post(Car.this.mConnectionRetryFailedRunnable);
                    return;
                }
                Car.this.mEventHandler.postDelayed(Car.this.mConnectionRetryRunnable, 500L);
                return;
            }
            Car.this.mConnectionRetryCount = 0;
        };
        this.mConnectionRetryFailedRunnable = new Runnable() {
            @Override
            public void run() {
                Car.this.mServiceConnectionListener.onServiceDisconnected(new ComponentName("com.android.car", "com.android.car.CarService"));
            }
        };
        this.mServiceConnectionListener = new ServiceConnection() {
            @Override  // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                synchronized(Car.this) {
                    ICar iCar0 = ICar.Stub.asInterface(service);
                    Car.this.mService = iCar0;
                    Car.this.mConnectionState = 2;
                }
                Car.this.mServiceConnectionListenerClient.onServiceConnected(name, service);
            }

            @Override  // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                synchronized(Car.this) {
                    Car.this.mService = null;
                    if(Car.this.mConnectionState == 0) {
                        return;
                    }
                    Car.this.mConnectionState = 0;
                }
                Car.this.disconnect();
                Car.this.mServiceConnectionListenerClient.onServiceDisconnected(name);
            }
        };
        this.mCarManagerLock = new Object();
        this.mServiceMap = new HashMap();
        this.mContext = context;
        this.mEventHandler = Car.determineEventHandler(handler);
        this.mMainThreadEventHandler = Car.determineMainThreadEventHandler(this.mEventHandler);
        this.mService = service;
        this.mOwnsService = false;
        this.mConnectionState = 2;
        this.mServiceConnectionListenerClient = null;
    }

    private Car(Context context, ServiceConnection serviceConnectionListener, Handler handler) {
        this.mConnectionRetryRunnable = () -> {
            Intent intent = new Intent();
            intent.setPackage("com.android.car");
            intent.setAction("android.car.ICar");
            if(!Car.this.mContext.bindService(intent, Car.this.mServiceConnectionListener, Context.BIND_AUTO_CREATE)) {
                ++Car.this.mConnectionRetryCount;
                if(((long)Car.this.mConnectionRetryCount) > 20L) {
                    Log.w("CAR.L", "cannot bind to car service after max retry");
                    Car.this.mMainThreadEventHandler.post(Car.this.mConnectionRetryFailedRunnable);
                    return;
                }
                Car.this.mEventHandler.postDelayed(Car.this.mConnectionRetryRunnable, 500L);
                return;
            }
            Car.this.mConnectionRetryCount = 0;
        };
        this.mConnectionRetryFailedRunnable = new Runnable() {
            @Override
            public void run() {
                Car.this.mServiceConnectionListener.onServiceDisconnected(new ComponentName("com.android.car", "com.android.car.CarService"));
            }
        };
        this.mServiceConnectionListener = new ServiceConnection() {
            @Override  // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                synchronized(Car.this) {
                    ICar iCar0 = ICar.Stub.asInterface(service);
                    Car.this.mService = iCar0;
                    Car.this.mConnectionState = 2;
                }
                Car.this.mServiceConnectionListenerClient.onServiceConnected(name, service);
            }

            @Override  // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                synchronized(Car.this) {
                    Car.this.mService = null;
                    if(Car.this.mConnectionState == 0) {
                        return;
                    }
                    Car.this.mConnectionState = 0;
                }
                Car.this.disconnect();
                Car.this.mServiceConnectionListenerClient.onServiceDisconnected(name);
            }
        };
        this.mCarManagerLock = new Object();
        this.mServiceMap = new HashMap();
        this.mContext = context;
        this.mEventHandler = Car.determineEventHandler(handler);
        this.mMainThreadEventHandler = Car.determineMainThreadEventHandler(this.mEventHandler);
        this.mService = null;
        this.mOwnsService = true;
        this.mServiceConnectionListenerClient = serviceConnectionListener;
    }

    public static void checkCarNotConnectedExceptionFromCarService(IllegalStateException e) throws CarNotConnectedException, IllegalStateException {
        if(!"CarNotConnected".equals(e.getMessage())) {
            throw e;
        }
        throw new CarNotConnectedException();
    }

    public void connect() throws IllegalStateException {
        synchronized(this) {
            if(this.mConnectionState != 0) {
                throw new IllegalStateException("already connected or connecting");
            }
            this.mConnectionState = 1;
            this.startCarService();
        }
    }

    public static Car createCar(Context context, ServiceConnection serviceConnectionListener) {
        return Car.createCar(context, serviceConnectionListener, null);
    }

    public static Car createCar(Context context, ServiceConnection serviceConnectionListener, Handler handler) {
        if(!context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            Log.e("CAR.L", "FEATURE_AUTOMOTIVE not declared while android.car is used");
            return null;
        }
        try {
            return new Car(context, serviceConnectionListener, handler);
        }
        catch(IllegalArgumentException unused_ex) {
            return null;
        }
    }

    private CarManagerBase createCarManager(String serviceName, IBinder binder) throws CarNotConnectedException {
        switch(serviceName) {
            case "app_focus": {
                return new CarAppFocusManager(binder, this.mEventHandler);
            }
            case "cabin": {
                return new CarCabinManager(binder, this.mContext, this.mEventHandler);
            }
            case "car-service-test": {
                return new CarTestManagerBinderWrapper(binder);
            }
            /*case "car_navigation_service": {
                return new CarNavigationStatusManager(binder);
            }
            case "cluster_service": {
                return new CarInstrumentClusterManager(binder, this.mEventHandler);
            }*/
            case "configuration": {
                return new CarConfigurationManager(binder);
            }
            /*case "diagnostic": {
                return new CarDiagnosticManager(binder, this.mContext, this.mEventHandler);
            }*/
            case "drivingstate": {
                return new CarDrivingStateManager(binder, this.mContext, this.mEventHandler);
            }
            case "hvac": {
                return new CarHvacManager(binder, this.mContext, this.mEventHandler);
            }
            case "info": {
                return new CarInfoManager(binder);
            }
            /*case "package": {
                return new CarPackageManager(binder, this.mContext);
            }*/
            case "power": {
                return new CarPowerManager(binder, this.mContext, this.mEventHandler);
            }
            case "projection": {
                return new CarProjectionManager(binder, this.mEventHandler);
            }
            case "property": {
                return new CarPropertyManager(binder, this.mEventHandler, false, "CarPropertyManager");
            }
            case "sensor": {
                return new CarSensorManager(binder, this.mContext, this.mEventHandler);
            }
            /*case "storage_monitoring": {
                return new CarStorageMonitoringManager(binder, this.mEventHandler);
            }*/
            case "uxrestriction": {
                return new CarUxRestrictionsManager(binder, this.mContext, this.mEventHandler);
            }
            case "vendor_extension": {
                return new CarVendorExtensionManager(binder, this.mEventHandler);
            }
            default: {
                return null;
            }
        }
    }

    private static Handler determineEventHandler(Handler handler) {
        return handler == null ? new Handler(Looper.getMainLooper()) : handler;
    }

    private static Handler determineMainThreadEventHandler(Handler eventHandler) {
        Looper looper0 = Looper.getMainLooper();
        return eventHandler.getLooper() == looper0 ? eventHandler : new Handler(looper0);
    }

    public void disconnect() {
        synchronized(this) {
            if(this.mConnectionState == 0) {
                return;
            }
            this.mEventHandler.removeCallbacks(this.mConnectionRetryRunnable);
            this.mMainThreadEventHandler.removeCallbacks(this.mConnectionRetryFailedRunnable);
            this.mConnectionRetryCount = 0;
            this.tearDownCarManagers();
            this.mService = null;
            this.mConnectionState = 0;
            if(this.mOwnsService) {
                this.mContext.unbindService(this.mServiceConnectionListener);
            }
        }
    }

    public int getCarConnectionType() {
        return 5;
    }

    public Object getCarManager(String serviceName) throws CarNotConnectedException {
        ICar iCar0 = this.getICarOrThrow();
        synchronized(this.mCarManagerLock) {
            CarManagerBase manager = (CarManagerBase)this.mServiceMap.get(serviceName);
            if(manager == null) {
                try {
                    IBinder iBinder0 = iCar0.getCarService(serviceName);
                    if(iBinder0 == null) {
                        Log.w("CAR.L", "getCarManager could not get binder for service:" + serviceName);
                        return null;
                    }
                    manager = this.createCarManager(serviceName, iBinder0);
                    if(manager == null) {
                        Log.w("CAR.L", "getCarManager could not create manager for service:" + serviceName);
                        return null;
                    }
                    this.mServiceMap.put(serviceName, manager);
                }
                catch(RemoteException e) {
                    this.handleRemoteException(e);
                }
            }
            return manager;
        }
    }

    private ICar getICarOrThrow() throws IllegalStateException {
        synchronized(this) {
            if(this.mService == null) {
                throw new IllegalStateException("not connected");
            }
            return this.mService;
        }
    }

    private void handleRemoteException(RemoteException e) {
        Log.w("CAR.L", "RemoteException", e);
        this.disconnect();
    }

    public static void hideCarNotConnectedExceptionFromCarService(IllegalStateException e) throws IllegalStateException {
        if(!"CarNotConnected".equals(e.getMessage())) {
            throw e;
        }
    }

    public boolean isConnected() {
        synchronized(this) {
        }
        return this.mService != null;
    }

    public boolean isConnecting() {
        boolean z = true;
        synchronized(this) {
            if(this.mConnectionState != 1) {
                z = false;
            }
        }
        return z;
    }

    // Detected as a lambda impl.
    private void startCarService() {
        Intent intent = new Intent();
        intent.setPackage("com.android.car");
        intent.setAction("android.car.ICar");
        if(!this.mContext.bindService(intent, this.mServiceConnectionListener, Context.BIND_AUTO_CREATE)) {
            ++this.mConnectionRetryCount;
            if(((long)this.mConnectionRetryCount) > 20L) {
                Log.w("CAR.L", "cannot bind to car service after max retry");
                this.mMainThreadEventHandler.post(this.mConnectionRetryFailedRunnable);
                return;
            }
            this.mEventHandler.postDelayed(this.mConnectionRetryRunnable, 500L);
            return;
        }
        this.mConnectionRetryCount = 0;
    }

    private void tearDownCarManagers() {
        synchronized(this.mCarManagerLock) {
            for(Object object1: this.mServiceMap.values()) {
                ((CarManagerBase)object1).onCarDisconnected();
            }
            this.mServiceMap.clear();
        }
    }
}

