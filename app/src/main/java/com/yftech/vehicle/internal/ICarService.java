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

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.vehicle.internal.ICarService";
            }

            @Override  // com.yftech.vehicle.internal.ICarService
            public byte[] getSignalValue(int signal_id) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.vehicle.internal.ICarService");
                    parcel0.writeInt(signal_id);
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
            public byte[] getSignalsValue(int[] signals_id) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.vehicle.internal.ICarService");
                    parcel0.writeIntArray(signals_id);
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
            public void registerSignalCallback(ISignalCallback callback, int[] signals_id) throws RemoteException {
                IBinder iBinder0 = null;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.vehicle.internal.ICarService");
                    if(callback != null) {
                        iBinder0 = callback.asBinder();
                    }
                    parcel0.writeStrongBinder(iBinder0);
                    parcel0.writeIntArray(signals_id);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.vehicle.internal.ICarService
            public boolean setSignalValue(int signal_id, byte[] value) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.vehicle.internal.ICarService");
                    parcel0.writeInt(signal_id);
                    parcel0.writeByteArray(value);
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        _result = true;
                    }
                    return _result;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.vehicle.internal.ICarService
            public void unregisterSignalCallback(ISignalCallback callback) throws RemoteException {
                IBinder iBinder0 = null;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.vehicle.internal.ICarService");
                    if(callback != null) {
                        iBinder0 = callback.asBinder();
                    }
                    parcel0.writeStrongBinder(iBinder0);
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
        static final int TRANSACTION_setSignalValue = 3;
        static final int TRANSACTION_registerSignalCallback = 4;
        static final int TRANSACTION_unregisterSignalCallback = 5;

        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface(DESCRIPTOR);
            return iInterface0 != null && (iInterface0 instanceof ICarService) ? ((ICarService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case TRANSACTION_getSignalValue: {
                    data.enforceInterface(DESCRIPTOR);
                    byte[] arr_b = this.getSignalValue(data.readInt());
                    reply.writeNoException();
                    reply.writeByteArray(arr_b);
                    return true;
                }
                case TRANSACTION_getSignalsValue: {
                    data.enforceInterface(DESCRIPTOR);
                    byte[] arr_b1 = this.getSignalsValue(data.createIntArray());
                    reply.writeNoException();
                    reply.writeByteArray(arr_b1);
                    return true;
                }
                case TRANSACTION_setSignalValue: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean z = this.setSignalValue(data.readInt(), data.createByteArray());
                    reply.writeNoException();
                    reply.writeInt((z ? 1 : 0));
                    return true;
                }
                case TRANSACTION_registerSignalCallback: {
                    data.enforceInterface(DESCRIPTOR);
                    this.registerSignalCallback(com.yftech.vehicle.internal.ISignalCallback.Stub.asInterface(data.readStrongBinder()), data.createIntArray());
                    return true;
                }
                case TRANSACTION_unregisterSignalCallback: {
                    data.enforceInterface(DESCRIPTOR);
                    this.unregisterSignalCallback(com.yftech.vehicle.internal.ISignalCallback.Stub.asInterface(data.readStrongBinder()));
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    byte[] getSignalValue(int arg1) throws RemoteException;

    byte[] getSignalsValue(int[] arg1) throws RemoteException;

    void registerSignalCallback(ISignalCallback arg1, int[] arg2) throws RemoteException;

    boolean setSignalValue(int arg1, byte[] arg2) throws RemoteException;

    void unregisterSignalCallback(ISignalCallback arg1) throws RemoteException;
}

