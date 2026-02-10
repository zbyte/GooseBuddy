package com.yftech.car.data;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarDataService extends IInterface {
    public static abstract class Stub extends Binder implements ICarDataService {
        static class Proxy implements ICarDataService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // com.yftech.car.data.ICarDataService
            public CarData get(CarData data) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.data.ICarDataService");
                    if(data == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        data.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((CarData)CarData.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.data.ICarDataService";
            }

            @Override  // com.yftech.car.data.ICarDataService
            public void registerCarDataCallback(ICarDataCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.data.ICarDataService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.data.ICarDataService
            public boolean set(CarData data, boolean save) throws RemoteException {
                boolean z1 = true;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.data.ICarDataService");
                    if(data == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        data.writeToParcel(parcel0, 0);
                    }
                    parcel0.writeInt((save ? 1 : 0));
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() == 0) {
                        z1 = false;
                    }
                    return z1;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.data.ICarDataService
            public void unregisterCarDataCallback(ICarDataCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.data.ICarDataService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.data.ICarDataService";
        static final int TRANSACTION_get = 4;
        static final int TRANSACTION_registerCarDataCallback = 1;
        static final int TRANSACTION_set = 3;
        static final int TRANSACTION_unregisterCarDataCallback = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.data.ICarDataService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarDataService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.data.ICarDataService");
            return iInterface0 != null && (iInterface0 instanceof ICarDataService) ? ((ICarDataService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int v2 = 0;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.data.ICarDataService");
                    this.registerCarDataCallback(com.yftech.car.data.ICarDataCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.data.ICarDataService");
                    this.unregisterCarDataCallback(com.yftech.car.data.ICarDataCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.data.ICarDataService");
                    boolean z = this.set((data.readInt() == 0 ? null : ((CarData)CarData.CREATOR.createFromParcel(data))), data.readInt() != 0);
                    reply.writeNoException();
                    if(z) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.data.ICarDataService");
                    CarData carData0 = this.get((data.readInt() == 0 ? null : ((CarData)CarData.CREATOR.createFromParcel(data))));
                    reply.writeNoException();
                    if(carData0 != null) {
                        reply.writeInt(1);
                        carData0.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.data.ICarDataService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    CarData get(CarData arg1) throws RemoteException;

    void registerCarDataCallback(ICarDataCallback arg1) throws RemoteException;

    boolean set(CarData arg1, boolean arg2) throws RemoteException;

    void unregisterCarDataCallback(ICarDataCallback arg1) throws RemoteException;
}

