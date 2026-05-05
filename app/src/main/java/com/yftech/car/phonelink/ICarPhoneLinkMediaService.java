package com.yftech.car.phonelink;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface ICarPhoneLinkMediaService extends IInterface {
    public static abstract class Stub extends Binder implements ICarPhoneLinkMediaService {
        static class Proxy implements ICarPhoneLinkMediaService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkMediaService
            public PhoneLinkMediaInfo getCurPhoneLinkMediaInfo() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((PhoneLinkMediaInfo)PhoneLinkMediaInfo.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.phonelink.ICarPhoneLinkMediaService";
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkMediaService
            public boolean next() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
                    this.mRemote.transact(5, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkMediaService
            public boolean play() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
                    this.mRemote.transact(6, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkMediaService
            public boolean previous() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
                    this.mRemote.transact(4, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkMediaService
            public void registerCarPhoneLinkMediaCallback(ICarPhoneLinkMediaCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkMediaService
            public boolean stop() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
                    this.mRemote.transact(7, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkMediaService
            public void unregisterCarPhoneLinkMediaCallback(ICarPhoneLinkMediaCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.phonelink.ICarPhoneLinkMediaService";
        static final int TRANSACTION_getCurPhoneLinkMediaInfo = 3;
        static final int TRANSACTION_next = 5;
        static final int TRANSACTION_play = 6;
        static final int TRANSACTION_previous = 4;
        static final int TRANSACTION_registerCarPhoneLinkMediaCallback = 1;
        static final int TRANSACTION_stop = 7;
        static final int TRANSACTION_unregisterCarPhoneLinkMediaCallback = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.phonelink.ICarPhoneLinkMediaService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarPhoneLinkMediaService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
            return iInterface0 != null && (iInterface0 instanceof ICarPhoneLinkMediaService) ? ((ICarPhoneLinkMediaService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int v2 = 0;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
                    this.registerCarPhoneLinkMediaCallback(com.yftech.car.phonelink.ICarPhoneLinkMediaCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
                    this.unregisterCarPhoneLinkMediaCallback(com.yftech.car.phonelink.ICarPhoneLinkMediaCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
                    PhoneLinkMediaInfo phoneLinkMediaInfo0 = this.getCurPhoneLinkMediaInfo();
                    reply.writeNoException();
                    if(phoneLinkMediaInfo0 != null) {
                        reply.writeInt(1);
                        phoneLinkMediaInfo0.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
                    boolean z = this.previous();
                    reply.writeNoException();
                    if(z) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
                    boolean z1 = this.next();
                    reply.writeNoException();
                    if(z1) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
                    boolean z2 = this.play();
                    reply.writeNoException();
                    if(z2) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
                    boolean z3 = this.stop();
                    reply.writeNoException();
                    if(z3) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.phonelink.ICarPhoneLinkMediaService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    PhoneLinkMediaInfo getCurPhoneLinkMediaInfo() throws RemoteException;

    boolean next() throws RemoteException;

    boolean play() throws RemoteException;

    boolean previous() throws RemoteException;

    void registerCarPhoneLinkMediaCallback(ICarPhoneLinkMediaCallback arg1) throws RemoteException;

    boolean stop() throws RemoteException;

    void unregisterCarPhoneLinkMediaCallback(ICarPhoneLinkMediaCallback arg1) throws RemoteException;
}

