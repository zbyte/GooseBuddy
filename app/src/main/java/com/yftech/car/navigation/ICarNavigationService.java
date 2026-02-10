package com.yftech.car.navigation;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarNavigationService extends IInterface {
    public static abstract class Stub extends Binder implements ICarNavigationService {
        static class Proxy implements ICarNavigationService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.navigation.ICarNavigationService";
            }

            @Override  // com.yftech.car.navigation.ICarNavigationService
            public void goCompany() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationService");
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationService
            public void goHome() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationService");
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationService
            public void goPoiDetailPage(String name, String address, double lat, double lon) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationService");
                    parcel0.writeString(name);
                    parcel0.writeString(address);
                    parcel0.writeDouble(lat);
                    parcel0.writeDouble(lon);
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationService
            public void openNaviApp() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationService");
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationService
            public void registerCarNavigationCallback(ICarNavigationCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationService
            public void searchKeyword(String str) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationService");
                    parcel0.writeString(str);
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationService
            public void setMuteMode(boolean isOpen) throws RemoteException {
                int v = 0;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationService");
                    if(isOpen) {
                        v = 1;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(9, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationService
            public void setRoadCondition(boolean isOpen) throws RemoteException {
                int v = 0;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationService");
                    if(isOpen) {
                        v = 1;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(8, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationService
            public void unregisterCarNavigationCallback(ICarNavigationCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationService");
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

        private static final String DESCRIPTOR = "com.yftech.car.navigation.ICarNavigationService";
        static final int TRANSACTION_goCompany = 5;
        static final int TRANSACTION_goHome = 4;
        static final int TRANSACTION_goPoiDetailPage = 7;
        static final int TRANSACTION_openNaviApp = 3;
        static final int TRANSACTION_registerCarNavigationCallback = 1;
        static final int TRANSACTION_searchKeyword = 6;
        static final int TRANSACTION_setMuteMode = 9;
        static final int TRANSACTION_setRoadCondition = 8;
        static final int TRANSACTION_unregisterCarNavigationCallback = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.navigation.ICarNavigationService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarNavigationService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.navigation.ICarNavigationService");
            return iInterface0 != null && (iInterface0 instanceof ICarNavigationService) ? ((ICarNavigationService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean _arg0 = false;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationService");
                    this.registerCarNavigationCallback(com.yftech.car.navigation.ICarNavigationCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationService");
                    this.unregisterCarNavigationCallback(com.yftech.car.navigation.ICarNavigationCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationService");
                    this.openNaviApp();
                    reply.writeNoException();
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationService");
                    this.goHome();
                    reply.writeNoException();
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationService");
                    this.goCompany();
                    reply.writeNoException();
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationService");
                    this.searchKeyword(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationService");
                    this.goPoiDetailPage(data.readString(), data.readString(), data.readDouble(), data.readDouble());
                    reply.writeNoException();
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationService");
                    if(data.readInt() != 0) {
                        _arg0 = true;
                    }
                    this.setRoadCondition(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationService");
                    if(data.readInt() != 0) {
                        _arg0 = true;
                    }
                    this.setMuteMode(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.navigation.ICarNavigationService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void goCompany() throws RemoteException;

    void goHome() throws RemoteException;

    void goPoiDetailPage(String arg1, String arg2, double arg3, double arg4) throws RemoteException;

    void openNaviApp() throws RemoteException;

    void registerCarNavigationCallback(ICarNavigationCallback arg1) throws RemoteException;

    void searchKeyword(String arg1) throws RemoteException;

    void setMuteMode(boolean arg1) throws RemoteException;

    void setRoadCondition(boolean arg1) throws RemoteException;

    void unregisterCarNavigationCallback(ICarNavigationCallback arg1) throws RemoteException;
}

