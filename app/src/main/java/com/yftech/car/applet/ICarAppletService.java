package com.yftech.car.applet;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarAppletService extends IInterface {
    public static abstract class Stub extends Binder implements ICarAppletService {
        static class Proxy implements ICarAppletService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // com.yftech.car.applet.ICarAppletService
            public boolean canMossAppOpen(String platformType, String appId) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.applet.ICarAppletService");
                    parcel0.writeString(platformType);
                    parcel0.writeString(appId);
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

            public String getInterfaceDescriptor() {
                return "com.yftech.car.applet.ICarAppletService";
            }

            @Override  // com.yftech.car.applet.ICarAppletService
            public boolean isMiniProgramOpened(String platformType, String appId) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.applet.ICarAppletService");
                    parcel0.writeString(platformType);
                    parcel0.writeString(appId);
                    this.mRemote.transact(8, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.applet.ICarAppletService
            public boolean isMossAppForeground(String platformType, String appId) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.applet.ICarAppletService");
                    parcel0.writeString(platformType);
                    parcel0.writeString(appId);
                    this.mRemote.transact(9, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.applet.ICarAppletService
            public void loadAllAppletsFromCache() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.applet.ICarAppletService");
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.applet.ICarAppletService
            public void loadAllAppletsFromNet() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.applet.ICarAppletService");
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.applet.ICarAppletService
            public void loadAppletsFromCache(String platformType) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.applet.ICarAppletService");
                    parcel0.writeString(platformType);
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.applet.ICarAppletService
            public void loadAppletsFromNet(String platformType) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.applet.ICarAppletService");
                    parcel0.writeString(platformType);
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.applet.ICarAppletService
            public void openMossApp(String platformType, String appId, String pagePath, int position) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.applet.ICarAppletService");
                    parcel0.writeString(platformType);
                    parcel0.writeString(appId);
                    parcel0.writeString(pagePath);
                    parcel0.writeInt(position);
                    this.mRemote.transact(10, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.applet.ICarAppletService
            public void registerCarAppletRequestCallback(ICarAppletRequestCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.applet.ICarAppletService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.applet.ICarAppletService
            public void unregisterCarAppletRequestCallback(ICarAppletRequestCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.applet.ICarAppletService");
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

        private static final String DESCRIPTOR = "com.yftech.car.applet.ICarAppletService";
        static final int TRANSACTION_canMossAppOpen = 7;
        static final int TRANSACTION_isMiniProgramOpened = 8;
        static final int TRANSACTION_isMossAppForeground = 9;
        static final int TRANSACTION_loadAllAppletsFromCache = 5;
        static final int TRANSACTION_loadAllAppletsFromNet = 3;
        static final int TRANSACTION_loadAppletsFromCache = 6;
        static final int TRANSACTION_loadAppletsFromNet = 4;
        static final int TRANSACTION_openMossApp = 10;
        static final int TRANSACTION_registerCarAppletRequestCallback = 1;
        static final int TRANSACTION_unregisterCarAppletRequestCallback = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.applet.ICarAppletService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarAppletService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.applet.ICarAppletService");
            return iInterface0 != null && (iInterface0 instanceof ICarAppletService) ? ((ICarAppletService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int v2 = 0;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.applet.ICarAppletService");
                    this.registerCarAppletRequestCallback(com.yftech.car.applet.ICarAppletRequestCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.applet.ICarAppletService");
                    this.unregisterCarAppletRequestCallback(com.yftech.car.applet.ICarAppletRequestCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.applet.ICarAppletService");
                    this.loadAllAppletsFromNet();
                    reply.writeNoException();
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.applet.ICarAppletService");
                    this.loadAppletsFromNet(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.applet.ICarAppletService");
                    this.loadAllAppletsFromCache();
                    reply.writeNoException();
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.applet.ICarAppletService");
                    this.loadAppletsFromCache(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.applet.ICarAppletService");
                    boolean z = this.canMossAppOpen(data.readString(), data.readString());
                    reply.writeNoException();
                    if(z) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.applet.ICarAppletService");
                    boolean z1 = this.isMiniProgramOpened(data.readString(), data.readString());
                    reply.writeNoException();
                    if(z1) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.applet.ICarAppletService");
                    boolean z2 = this.isMossAppForeground(data.readString(), data.readString());
                    reply.writeNoException();
                    if(z2) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 10: {
                    data.enforceInterface("com.yftech.car.applet.ICarAppletService");
                    this.openMossApp(data.readString(), data.readString(), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.applet.ICarAppletService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    boolean canMossAppOpen(String arg1, String arg2) throws RemoteException;

    boolean isMiniProgramOpened(String arg1, String arg2) throws RemoteException;

    boolean isMossAppForeground(String arg1, String arg2) throws RemoteException;

    void loadAllAppletsFromCache() throws RemoteException;

    void loadAllAppletsFromNet() throws RemoteException;

    void loadAppletsFromCache(String arg1) throws RemoteException;

    void loadAppletsFromNet(String arg1) throws RemoteException;

    void openMossApp(String arg1, String arg2, String arg3, int arg4) throws RemoteException;

    void registerCarAppletRequestCallback(ICarAppletRequestCallback arg1) throws RemoteException;

    void unregisterCarAppletRequestCallback(ICarAppletRequestCallback arg1) throws RemoteException;
}

