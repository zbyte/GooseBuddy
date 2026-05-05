package android.car.settings;

import android.car.CarManagerBase;
import android.car.CarNotConnectedException;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class CarConfigurationManager implements CarManagerBase {
    private static final String TAG = "CarConfigurationManager";
    private final ICarConfigurationManager mConfigurationService;

    public CarConfigurationManager(IBinder service) {
        this.mConfigurationService = ICarConfigurationManager.Stub.asInterface(service);
    }

    public SpeedBumpConfiguration getSpeedBumpConfiguration() throws CarNotConnectedException {
        try {
            return this.mConfigurationService.getSpeedBumpConfiguration();
        }
        catch(RemoteException e) {
            Log.e("CarConfigurationManager", "Could not retrieve SpeedBumpConfiguration", e);
            throw new CarNotConnectedException(e);
        }
    }

    @Override  // android.car.CarManagerBase
    public void onCarDisconnected() {
    }
}

