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

            Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.vehicle.internal.ISignalCallback";
            }

            @Override  // com.yftech.vehicle.internal.ISignalCallback
            public void onValueChanged(int v, byte[] arr_b) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.vehicle.internal.ISignalCallback");
                    parcel0.writeInt(v);
                    parcel0.writeByteArray(arr_b);
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

        public static ISignalCallback asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.yftech.vehicle.internal.ISignalCallback");
            return iInterface0 != null && (iInterface0 instanceof ISignalCallback) ? ((ISignalCallback)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
            switch(v) {
                case 1: {
                    parcel0.enforceInterface("com.yftech.vehicle.internal.ISignalCallback");
                    this.onValueChanged(parcel0.readInt(), parcel0.createByteArray());
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("com.yftech.vehicle.internal.ISignalCallback");
                    return true;
                }
                default: {
                    return super.onTransact(v, parcel0, parcel1, v1);
                }
            }
        }
    }

    void onValueChanged(int arg1, byte[] arg2) throws RemoteException;
}

