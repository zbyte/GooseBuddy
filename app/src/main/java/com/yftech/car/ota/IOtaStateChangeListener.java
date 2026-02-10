package com.yftech.car.ota;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOtaStateChangeListener extends IInterface {
    public static abstract class Stub extends Binder implements IOtaStateChangeListener {
        static class Proxy implements IOtaStateChangeListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.ota.IOtaStateChangeListener";
            }

            @Override  // com.yftech.car.ota.IOtaStateChangeListener
            public void onOtaStateChanged(boolean isOtaMode) throws RemoteException {
                int v = 1;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.ota.IOtaStateChangeListener");
                    if(!isOtaMode) {
                        v = 0;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.ota.IOtaStateChangeListener";
        static final int TRANSACTION_onOtaStateChanged = 1;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.ota.IOtaStateChangeListener");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IOtaStateChangeListener asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.ota.IOtaStateChangeListener");
            return iInterface0 != null && (iInterface0 instanceof IOtaStateChangeListener) ? ((IOtaStateChangeListener)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.ota.IOtaStateChangeListener");
                    this.onOtaStateChanged(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.ota.IOtaStateChangeListener");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onOtaStateChanged(boolean arg1) throws RemoteException;
}

