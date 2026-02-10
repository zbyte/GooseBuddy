package com.yftech.car.tts;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITtsService extends IInterface {
    public static abstract class Stub extends Binder implements ITtsService {
        static class Proxy implements ITtsService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.tts.ITtsService";
            }

            @Override  // com.yftech.car.tts.ITtsService
            public void registerCallBack(ITtsCallback callback) throws RemoteException {
                IBinder iBinder0 = null;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tts.ITtsService");
                    if(callback != null) {
                        iBinder0 = callback.asBinder();
                    }
                    parcel0.writeStrongBinder(iBinder0);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tts.ITtsService
            public void speak(String msg) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tts.ITtsService");
                    parcel0.writeString(msg);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tts.ITtsService
            public void stopSpeaking() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tts.ITtsService");
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tts.ITtsService
            public void unregisterCallBack(ITtsCallback callback) throws RemoteException {
                IBinder iBinder0 = null;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tts.ITtsService");
                    if(callback != null) {
                        iBinder0 = callback.asBinder();
                    }
                    parcel0.writeStrongBinder(iBinder0);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.tts.ITtsService";
        static final int TRANSACTION_registerCallBack = 3;
        static final int TRANSACTION_speak = 1;
        static final int TRANSACTION_stopSpeaking = 2;
        static final int TRANSACTION_unregisterCallBack = 4;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.tts.ITtsService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ITtsService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.tts.ITtsService");
            return iInterface0 != null && (iInterface0 instanceof ITtsService) ? ((ITtsService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.tts.ITtsService");
                    this.speak(data.readString());
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.tts.ITtsService");
                    this.stopSpeaking();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.tts.ITtsService");
                    this.registerCallBack(com.yftech.car.tts.ITtsCallback.Stub.asInterface(data.readStrongBinder()));
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.tts.ITtsService");
                    this.unregisterCallBack(com.yftech.car.tts.ITtsCallback.Stub.asInterface(data.readStrongBinder()));
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.tts.ITtsService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void registerCallBack(ITtsCallback arg1) throws RemoteException;

    void speak(String arg1) throws RemoteException;

    void stopSpeaking() throws RemoteException;

    void unregisterCallBack(ITtsCallback arg1) throws RemoteException;
}

