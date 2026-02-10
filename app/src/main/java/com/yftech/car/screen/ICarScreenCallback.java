package com.yftech.car.screen;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarScreenCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarScreenCallback {
        static class Proxy implements ICarScreenCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.screen.ICarScreenCallback";
            }

            @Override  // com.yftech.car.screen.ICarScreenCallback
            public void onChangedDayNightMode(int displayId, int mode) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenCallback");
                    parcel0.writeInt(displayId);
                    parcel0.writeInt(mode);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.screen.ICarScreenCallback
            public void onChangedScreenBrightness(int displayId, boolean open, int brightness) throws RemoteException {
                int v2 = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenCallback");
                    parcel0.writeInt(displayId);
                    if(!open) {
                        v2 = 0;
                    }
                    parcel0.writeInt(v2);
                    parcel0.writeInt(brightness);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.screen.ICarScreenCallback
            public void onChangedScreenBrightness2(int displayId, boolean open, int brightness, int reason) throws RemoteException {
                int v3 = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenCallback");
                    parcel0.writeInt(displayId);
                    if(!open) {
                        v3 = 0;
                    }
                    parcel0.writeInt(v3);
                    parcel0.writeInt(brightness);
                    parcel0.writeInt(reason);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.screen.ICarScreenCallback
            public void onChangedScreenFold(int displayId, boolean isFold) throws RemoteException {
                int v1 = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenCallback");
                    parcel0.writeInt(displayId);
                    if(!isFold) {
                        v1 = 0;
                    }
                    parcel0.writeInt(v1);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.screen.ICarScreenCallback";
        static final int TRANSACTION_onChangedDayNightMode = 2;
        static final int TRANSACTION_onChangedScreenBrightness = 1;
        static final int TRANSACTION_onChangedScreenBrightness2 = 3;
        static final int TRANSACTION_onChangedScreenFold = 4;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.screen.ICarScreenCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarScreenCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.screen.ICarScreenCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarScreenCallback) ? ((ICarScreenCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean _arg1 = false;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenCallback");
                    int v2 = data.readInt();
                    if(data.readInt() != 0) {
                        _arg1 = true;
                    }
                    this.onChangedScreenBrightness(v2, _arg1, data.readInt());
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenCallback");
                    this.onChangedDayNightMode(data.readInt(), data.readInt());
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenCallback");
                    int v3 = data.readInt();
                    if(data.readInt() != 0) {
                        _arg1 = true;
                    }
                    this.onChangedScreenBrightness2(v3, _arg1, data.readInt(), data.readInt());
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenCallback");
                    int v4 = data.readInt();
                    if(data.readInt() != 0) {
                        _arg1 = true;
                    }
                    this.onChangedScreenFold(v4, _arg1);
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.screen.ICarScreenCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onChangedDayNightMode(int arg1, int arg2) throws RemoteException;

    void onChangedScreenBrightness(int arg1, boolean arg2, int arg3) throws RemoteException;

    void onChangedScreenBrightness2(int arg1, boolean arg2, int arg3, int arg4) throws RemoteException;

    void onChangedScreenFold(int arg1, boolean arg2) throws RemoteException;
}

