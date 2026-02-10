package com.yftech.car.tts;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITtsCallback extends IInterface {
    public static abstract class Stub extends Binder implements ITtsCallback {
        static class Proxy implements ITtsCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.tts.ITtsCallback";
            }

            @Override  // com.yftech.car.tts.ITtsCallback
            public void onPlayBegin() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tts.ITtsCallback");
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tts.ITtsCallback
            public void onPlayCompleted() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tts.ITtsCallback");
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tts.ITtsCallback
            public void onPlayInterrupted() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tts.ITtsCallback");
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tts.ITtsCallback
            public void onProgressReturn(int current, int total) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tts.ITtsCallback");
                    parcel0.writeInt(current);
                    parcel0.writeInt(total);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tts.ITtsCallback
            public void onTtsInit(boolean isInit, int code) throws RemoteException {
                int v1 = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tts.ITtsCallback");
                    if(!isInit) {
                        v1 = 0;
                    }
                    parcel0.writeInt(v1);
                    parcel0.writeInt(code);
                    this.mRemote.transact(5, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.tts.ITtsCallback";
        static final int TRANSACTION_onPlayBegin = 1;
        static final int TRANSACTION_onPlayCompleted = 2;
        static final int TRANSACTION_onPlayInterrupted = 3;
        static final int TRANSACTION_onProgressReturn = 4;
        static final int TRANSACTION_onTtsInit = 5;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.tts.ITtsCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ITtsCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.tts.ITtsCallback");
            return iInterface0 != null && (iInterface0 instanceof ITtsCallback) ? ((ITtsCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.tts.ITtsCallback");
                    this.onPlayBegin();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.tts.ITtsCallback");
                    this.onPlayCompleted();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.tts.ITtsCallback");
                    this.onPlayInterrupted();
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.tts.ITtsCallback");
                    this.onProgressReturn(data.readInt(), data.readInt());
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.tts.ITtsCallback");
                    this.onTtsInit(data.readInt() != 0, data.readInt());
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.tts.ITtsCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onPlayBegin() throws RemoteException;

    void onPlayCompleted() throws RemoteException;

    void onPlayInterrupted() throws RemoteException;

    void onProgressReturn(int arg1, int arg2) throws RemoteException;

    void onTtsInit(boolean arg1, int arg2) throws RemoteException;
}

