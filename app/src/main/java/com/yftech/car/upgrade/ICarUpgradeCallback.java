package com.yftech.car.upgrade;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarUpgradeCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarUpgradeCallback {
        static class Proxy implements ICarUpgradeCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.upgrade.ICarUpgradeCallback";
            }

            @Override  // com.yftech.car.upgrade.ICarUpgradeCallback
            public void onUpgradeProgress(int module, int progress) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.upgrade.ICarUpgradeCallback");
                    parcel0.writeInt(module);
                    parcel0.writeInt(progress);
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.upgrade.ICarUpgradeCallback
            public void onUpgradeState(int module, int state) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.upgrade.ICarUpgradeCallback");
                    parcel0.writeInt(module);
                    parcel0.writeInt(state);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.upgrade.ICarUpgradeCallback";
        static final int TRANSACTION_onUpgradeProgress = 1;
        static final int TRANSACTION_onUpgradeState = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.upgrade.ICarUpgradeCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarUpgradeCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.upgrade.ICarUpgradeCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarUpgradeCallback) ? ((ICarUpgradeCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.upgrade.ICarUpgradeCallback");
                    this.onUpgradeProgress(data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.upgrade.ICarUpgradeCallback");
                    this.onUpgradeState(data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.upgrade.ICarUpgradeCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onUpgradeProgress(int arg1, int arg2) throws RemoteException;

    void onUpgradeState(int arg1, int arg2) throws RemoteException;
}

