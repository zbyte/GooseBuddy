package com.yftech.car.tsp;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITspCallback extends IInterface {
    public static abstract class Stub extends Binder implements ITspCallback {
        static class Proxy implements ITspCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.tsp.ITspCallback";
            }

            @Override  // com.yftech.car.tsp.ITspCallback
            public void onFlowPurchaseH5Link(String result) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tsp.ITspCallback");
                    parcel0.writeString(result);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tsp.ITspCallback
            public void onGenerateSharingCodeCallBack(int pid, String result) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tsp.ITspCallback");
                    parcel0.writeInt(pid);
                    parcel0.writeString(result);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tsp.ITspCallback
            public void onQuerySharingCodeInfoCallBack(int pid, String result) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tsp.ITspCallback");
                    parcel0.writeInt(pid);
                    parcel0.writeString(result);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.tsp.ITspCallback";
        static final int TRANSACTION_onFlowPurchaseH5Link = 1;
        static final int TRANSACTION_onGenerateSharingCodeCallBack = 2;
        static final int TRANSACTION_onQuerySharingCodeInfoCallBack = 3;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.tsp.ITspCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ITspCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.tsp.ITspCallback");
            return iInterface0 != null && (iInterface0 instanceof ITspCallback) ? ((ITspCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.tsp.ITspCallback");
                    this.onFlowPurchaseH5Link(data.readString());
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.tsp.ITspCallback");
                    this.onGenerateSharingCodeCallBack(data.readInt(), data.readString());
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.tsp.ITspCallback");
                    this.onQuerySharingCodeInfoCallBack(data.readInt(), data.readString());
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.tsp.ITspCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onFlowPurchaseH5Link(String arg1) throws RemoteException;

    void onGenerateSharingCodeCallBack(int arg1, String arg2) throws RemoteException;

    void onQuerySharingCodeInfoCallBack(int arg1, String arg2) throws RemoteException;
}

