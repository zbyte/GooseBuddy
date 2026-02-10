package com.yftech.car.dms;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IDmsCallback extends IInterface {
    public static abstract class Stub extends Binder implements IDmsCallback {
        static class Proxy implements IDmsCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.dms.IDmsCallback";
            }

            @Override  // com.yftech.car.dms.IDmsCallback
            public void onAlarmStateChanged(boolean isOn) throws RemoteException {
                int v = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsCallback");
                    if(!isOn) {
                        v = 0;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsCallback
            public void onDmsErrorState(int code, String reason) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsCallback");
                    parcel0.writeInt(code);
                    parcel0.writeString(reason);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsCallback
            public void onRecognitionResult(DmsRecognitionResult result) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsCallback");
                    if(result == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        result.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsCallback
            public void onRegisterResult(DmsRegisterResult result) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsCallback");
                    if(result == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        result.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.dms.IDmsCallback";
        static final int TRANSACTION_onAlarmStateChanged = 3;
        static final int TRANSACTION_onDmsErrorState = 4;
        static final int TRANSACTION_onRecognitionResult = 1;
        static final int TRANSACTION_onRegisterResult = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.dms.IDmsCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IDmsCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.dms.IDmsCallback");
            return iInterface0 != null && (iInterface0 instanceof IDmsCallback) ? ((IDmsCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.dms.IDmsCallback");
                    this.onRecognitionResult((data.readInt() == 0 ? null : ((DmsRecognitionResult)DmsRecognitionResult.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.dms.IDmsCallback");
                    this.onRegisterResult((data.readInt() == 0 ? null : ((DmsRegisterResult)DmsRegisterResult.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.dms.IDmsCallback");
                    this.onAlarmStateChanged(data.readInt() != 0);
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.dms.IDmsCallback");
                    this.onDmsErrorState(data.readInt(), data.readString());
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.dms.IDmsCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onAlarmStateChanged(boolean arg1) throws RemoteException;

    void onDmsErrorState(int arg1, String arg2) throws RemoteException;

    void onRecognitionResult(DmsRecognitionResult arg1) throws RemoteException;

    void onRegisterResult(DmsRegisterResult arg1) throws RemoteException;
}

