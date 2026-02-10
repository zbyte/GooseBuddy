package com.yftech.car.applet;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface ICarAppletRequestCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarAppletRequestCallback {
        static class Proxy implements ICarAppletRequestCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.applet.ICarAppletRequestCallback";
            }

            @Override  // com.yftech.car.applet.ICarAppletRequestCallback
            public void onFailed(String platformType, String s) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.applet.ICarAppletRequestCallback");
                    parcel0.writeString(platformType);
                    parcel0.writeString(s);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.applet.ICarAppletRequestCallback
            public void onSucceeded(String platformType, List list0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.applet.ICarAppletRequestCallback");
                    parcel0.writeString(platformType);
                    parcel0.writeTypedList(list0);
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.applet.ICarAppletRequestCallback";
        static final int TRANSACTION_onFailed = 2;
        static final int TRANSACTION_onSucceeded = 1;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.applet.ICarAppletRequestCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarAppletRequestCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.applet.ICarAppletRequestCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarAppletRequestCallback) ? ((ICarAppletRequestCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.applet.ICarAppletRequestCallback");
                    this.onSucceeded(data.readString(), data.createTypedArrayList(AppletInfo.CREATOR));
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.applet.ICarAppletRequestCallback");
                    this.onFailed(data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.applet.ICarAppletRequestCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onFailed(String arg1, String arg2) throws RemoteException;

    void onSucceeded(String arg1, List arg2) throws RemoteException;
}

