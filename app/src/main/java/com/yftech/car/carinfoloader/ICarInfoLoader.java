package com.yftech.car.carinfoloader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarInfoLoader extends IInterface {
    public static abstract class Stub extends Binder implements ICarInfoLoader {
        static class Proxy implements ICarInfoLoader {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // com.yftech.car.carinfoloader.ICarInfoLoader
            public String getCarInfoByCpuId(String cpuid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.carinfoloader.ICarInfoLoader");
                    parcel0.writeString(cpuid);
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.carinfoloader.ICarInfoLoader
            public String getCarInfoByVin(String vin) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.carinfoloader.ICarInfoLoader");
                    parcel0.writeString(vin);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.carinfoloader.ICarInfoLoader";
            }

            @Override  // com.yftech.car.carinfoloader.ICarInfoLoader
            public void registerCarInfoLoaderCallBack(ICarInfoLoaderCallBack callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.carinfoloader.ICarInfoLoader");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.carinfoloader.ICarInfoLoader
            public void unregisterCarInfoLoaderCallBack(ICarInfoLoaderCallBack callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.carinfoloader.ICarInfoLoader");
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

        private static final String DESCRIPTOR = "com.yftech.car.carinfoloader.ICarInfoLoader";
        static final int TRANSACTION_getCarInfoByCpuId = 1;
        static final int TRANSACTION_getCarInfoByVin = 2;
        static final int TRANSACTION_registerCarInfoLoaderCallBack = 3;
        static final int TRANSACTION_unregisterCarInfoLoaderCallBack = 4;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.carinfoloader.ICarInfoLoader");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarInfoLoader asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.carinfoloader.ICarInfoLoader");
            return iInterface0 != null && (iInterface0 instanceof ICarInfoLoader) ? ((ICarInfoLoader)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.carinfoloader.ICarInfoLoader");
                    String s = this.getCarInfoByCpuId(data.readString());
                    reply.writeNoException();
                    reply.writeString(s);
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.carinfoloader.ICarInfoLoader");
                    String s1 = this.getCarInfoByVin(data.readString());
                    reply.writeNoException();
                    reply.writeString(s1);
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.carinfoloader.ICarInfoLoader");
                    this.registerCarInfoLoaderCallBack(com.yftech.car.carinfoloader.ICarInfoLoaderCallBack.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.carinfoloader.ICarInfoLoader");
                    this.unregisterCarInfoLoaderCallBack(com.yftech.car.carinfoloader.ICarInfoLoaderCallBack.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.carinfoloader.ICarInfoLoader");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    String getCarInfoByCpuId(String arg1) throws RemoteException;

    String getCarInfoByVin(String arg1) throws RemoteException;

    void registerCarInfoLoaderCallBack(ICarInfoLoaderCallBack arg1) throws RemoteException;

    void unregisterCarInfoLoaderCallBack(ICarInfoLoaderCallBack arg1) throws RemoteException;
}

