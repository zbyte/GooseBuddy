package com.yftech.vehicle.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ISignalCallback extends IInterface {
    public static abstract class Stub extends Binder implements ISignalCallback {
        static class Proxy implements ISignalCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.vehicle.internal.ISignalCallback";
            }

            @Override  // com.yftech.vehicle.internal.ISignalCallback
            public void onValueChanged(int signal_id, byte[] value) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.vehicle.internal.ISignalCallback");
                    parcel0.writeInt(signal_id);
                    parcel0.writeByteArray(value);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.vehicle.internal.ISignalCallback";
        static final int TRANSACTION_onValueChanged = 1;

        public Stub() {
            this.attachInterface(this, "com.yftech.vehicle.internal.ISignalCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ISignalCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.vehicle.internal.ISignalCallback");
            return iInterface0 != null && (iInterface0 instanceof ISignalCallback) ? ((ISignalCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.vehicle.internal.ISignalCallback");
                    this.onValueChanged(data.readInt(), data.createByteArray());
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.vehicle.internal.ISignalCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onValueChanged(int arg1, byte[] arg2) throws RemoteException;
}

