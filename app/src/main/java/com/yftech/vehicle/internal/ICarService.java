package com.yftech.vehicle.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarService extends IInterface {
    public static abstract class Stub extends Binder implements ICarService {
        static class Proxy implements ICarService {
            private IBinder mRemote;

            Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.vehicle.internal.ICarService";
            }

            @Override  // com.yftech.vehicle.internal.ICarService
            public byte[] getSignalValue(int v) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.vehicle.internal.ICarService");
                    parcel0.writeInt(v);
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createByteArray();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.vehicle.internal.ICarService
            public byte[] getSignalsValue(int[] arr_v) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.vehicle.internal.ICarService");
                    parcel0.writeIntArray(arr_v);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createByteArray();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.vehicle.internal.ICarService
            public void registerSignalCallback(ISignalCallback iSignalCallback0, int[] arr_v) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.vehicle.internal.ICarService");
                    parcel0.writeStrongBinder((iSignalCallback0 == null ? null : iSignalCallback0.asBinder()));
                    parcel0.writeIntArray(arr_v);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.vehicle.internal.ICarService
            public boolean setSignalValue(int v, byte[] arr_b) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.vehicle.internal.ICarService");
                    parcel0.writeInt(v);
                    parcel0.writeByteArray(arr_b);
                    boolean z = false;
                    this.mRemote.transact(3, parcel0, parcel1, 0);
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

            @Override  // com.yftech.vehicle.internal.ICarService
            public void unregisterSignalCallback(ISignalCallback iSignalCallback0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.vehicle.internal.ICarService");
                    parcel0.writeStrongBinder((iSignalCallback0 == null ? null : iSignalCallback0.asBinder()));
                    this.mRemote.transact(5, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.vehicle.internal.ICarService";
        static final int TRANSACTION_getSignalValue = 1;
        static final int TRANSACTION_getSignalsValue = 2;
        static final int TRANSACTION_registerSignalCallback = 4;
        static final int TRANSACTION_setSignalValue = 3;
        static final int TRANSACTION_unregisterSignalCallback = 5;

        public Stub() {
            this.attachInterface(this, "com.yftech.vehicle.internal.ICarService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarService asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.yftech.vehicle.internal.ICarService");
            return iInterface0 != null && (iInterface0 instanceof ICarService) ? ((ICarService)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
            if(v != 0x5F4E5446) {
                switch(v) {
                    case 1: {
                        parcel0.enforceInterface("com.yftech.vehicle.internal.ICarService");
                        byte[] arr_b = this.getSignalValue(parcel0.readInt());
                        parcel1.writeNoException();
                        parcel1.writeByteArray(arr_b);
                        return true;
                    }
                    case 2: {
                        parcel0.enforceInterface("com.yftech.vehicle.internal.ICarService");
                        byte[] arr_b1 = this.getSignalsValue(parcel0.createIntArray());
                        parcel1.writeNoException();
                        parcel1.writeByteArray(arr_b1);
                        return true;
                    }
                    case 3: {
                        parcel0.enforceInterface("com.yftech.vehicle.internal.ICarService");
                        boolean z = this.setSignalValue(parcel0.readInt(), parcel0.createByteArray());
                        parcel1.writeNoException();
                        parcel1.writeInt(((int)z));
                        return true;
                    }
                    case 4: {
                        parcel0.enforceInterface("com.yftech.vehicle.internal.ICarService");
                        this.registerSignalCallback(com.yftech.vehicle.internal.ISignalCallback.Stub.asInterface(parcel0.readStrongBinder()), parcel0.createIntArray());
                        return true;
                    }
                    case 5: {
                        parcel0.enforceInterface("com.yftech.vehicle.internal.ICarService");
                        this.unregisterSignalCallback(com.yftech.vehicle.internal.ISignalCallback.Stub.asInterface(parcel0.readStrongBinder()));
                        return true;
                    }
                    default: {
                        return super.onTransact(v, parcel0, parcel1, v1);
                    }
                }
            }
            parcel1.writeString("com.yftech.vehicle.internal.ICarService");
            return true;
        }
    }

    byte[] getSignalValue(int arg1) throws RemoteException;

    byte[] getSignalsValue(int[] arg1) throws RemoteException;

    void registerSignalCallback(ISignalCallback arg1, int[] arg2) throws RemoteException;

    boolean setSignalValue(int arg1, byte[] arg2) throws RemoteException;

    void unregisterSignalCallback(ISignalCallback arg1) throws RemoteException;
}

