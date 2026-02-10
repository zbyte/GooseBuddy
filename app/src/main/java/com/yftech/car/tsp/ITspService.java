package com.yftech.car.tsp;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITspService extends IInterface {
    public static abstract class Stub extends Binder implements ITspService {
        static class Proxy implements ITspService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // com.yftech.car.tsp.ITspService
            public void generateSharingCode(String data, String vin, String userId) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tsp.ITspService");
                    parcel0.writeString(data);
                    parcel0.writeString(vin);
                    parcel0.writeString(userId);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tsp.ITspService
            public void getFlowPurchaseH5Link() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tsp.ITspService");
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.tsp.ITspService";
            }

            @Override  // com.yftech.car.tsp.ITspService
            public void querySharingCodeInfo(String sharingCode) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tsp.ITspService");
                    parcel0.writeString(sharingCode);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tsp.ITspService
            public void registerCallBack(ITspCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tsp.ITspService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tsp.ITspService
            public void unregisterCallBack(ITspCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tsp.ITspService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.tsp.ITspService";
        static final int TRANSACTION_generateSharingCode = 2;
        static final int TRANSACTION_getFlowPurchaseH5Link = 1;
        static final int TRANSACTION_querySharingCodeInfo = 3;
        static final int TRANSACTION_registerCallBack = 4;
        static final int TRANSACTION_unregisterCallBack = 5;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.tsp.ITspService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ITspService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.tsp.ITspService");
            return iInterface0 != null && (iInterface0 instanceof ITspService) ? ((ITspService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.tsp.ITspService");
                    this.getFlowPurchaseH5Link();
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.tsp.ITspService");
                    this.generateSharingCode(data.readString(), data.readString(), data.readString());
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.tsp.ITspService");
                    this.querySharingCodeInfo(data.readString());
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.tsp.ITspService");
                    this.registerCallBack(com.yftech.car.tsp.ITspCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.tsp.ITspService");
                    this.unregisterCallBack(com.yftech.car.tsp.ITspCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.tsp.ITspService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void generateSharingCode(String arg1, String arg2, String arg3) throws RemoteException;

    void getFlowPurchaseH5Link() throws RemoteException;

    void querySharingCodeInfo(String arg1) throws RemoteException;

    void registerCallBack(ITspCallback arg1) throws RemoteException;

    void unregisterCallBack(ITspCallback arg1) throws RemoteException;
}

