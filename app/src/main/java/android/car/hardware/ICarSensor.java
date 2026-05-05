package android.car.hardware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface ICarSensor extends IInterface {
    public static abstract class Stub extends Binder implements ICarSensor {
        static class Proxy implements ICarSensor {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.hardware.ICarSensor";
            }

            @Override  // android.car.hardware.ICarSensor
            public CarSensorEvent getLatestSensorEvent(int sensorType) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.ICarSensor");
                    parcel0.writeInt(sensorType);
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((CarSensorEvent)CarSensorEvent.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.hardware.ICarSensor
            public CarSensorConfig getSensorConfig(int sensorType) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.ICarSensor");
                    parcel0.writeInt(sensorType);
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((CarSensorConfig)CarSensorConfig.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.hardware.ICarSensor
            public int[] getSupportedSensors() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.ICarSensor");
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createIntArray();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.hardware.ICarSensor
            public boolean registerOrUpdateSensorListener(int sensorType, int rate, ICarSensorEventListener callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.ICarSensor");
                    parcel0.writeInt(sensorType);
                    parcel0.writeInt(rate);
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    boolean z = false;
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        z = true;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.hardware.ICarSensor
            public void unregisterSensorListener(int sensorType, ICarSensorEventListener callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.ICarSensor");
                    parcel0.writeInt(sensorType);
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.hardware.ICarSensor";
        static final int TRANSACTION_getLatestSensorEvent = 3;
        static final int TRANSACTION_getSensorConfig = 5;
        static final int TRANSACTION_getSupportedSensors = 1;
        static final int TRANSACTION_registerOrUpdateSensorListener = 2;
        static final int TRANSACTION_unregisterSensorListener = 4;

        public Stub() {
            this.attachInterface(this, "android.car.hardware.ICarSensor");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarSensor asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.hardware.ICarSensor");
            return iInterface0 != null && (iInterface0 instanceof ICarSensor) ? ((ICarSensor)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code != 0x5F4E5446) {
                switch(code) {
                    case 1: {
                        data.enforceInterface("android.car.hardware.ICarSensor");
                        int[] arr_v = this.getSupportedSensors();
                        reply.writeNoException();
                        reply.writeIntArray(arr_v);
                        return true;
                    }
                    case 2: {
                        data.enforceInterface("android.car.hardware.ICarSensor");
                        boolean z = this.registerOrUpdateSensorListener(data.readInt(), data.readInt(), android.car.hardware.ICarSensorEventListener.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        reply.writeInt((z?1:0));
                        return true;
                    }
                    case 3: {
                        data.enforceInterface("android.car.hardware.ICarSensor");
                        CarSensorEvent carSensorEvent0 = this.getLatestSensorEvent(data.readInt());
                        reply.writeNoException();
                        if(carSensorEvent0 != null) {
                            reply.writeInt(1);
                            carSensorEvent0.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                            return true;
                        }
                        reply.writeInt(0);
                        return true;
                    }
                    case 4: {
                        data.enforceInterface("android.car.hardware.ICarSensor");
                        this.unregisterSensorListener(data.readInt(), android.car.hardware.ICarSensorEventListener.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 5: {
                        data.enforceInterface("android.car.hardware.ICarSensor");
                        CarSensorConfig carSensorConfig0 = this.getSensorConfig(data.readInt());
                        reply.writeNoException();
                        if(carSensorConfig0 != null) {
                            reply.writeInt(1);
                            carSensorConfig0.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                            return true;
                        }
                        reply.writeInt(0);
                        return true;
                    }
                    default: {
                        return super.onTransact(code, data, reply, flags);
                    }
                }
            }
            reply.writeString("android.car.hardware.ICarSensor");
            return true;
        }
    }

    CarSensorEvent getLatestSensorEvent(int arg1) throws RemoteException;

    CarSensorConfig getSensorConfig(int arg1) throws RemoteException;

    int[] getSupportedSensors() throws RemoteException;

    boolean registerOrUpdateSensorListener(int arg1, int arg2, ICarSensorEventListener arg3) throws RemoteException;

    void unregisterSensorListener(int arg1, ICarSensorEventListener arg2) throws RemoteException;
}

