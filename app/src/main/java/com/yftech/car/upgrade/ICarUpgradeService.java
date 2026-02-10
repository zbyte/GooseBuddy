package com.yftech.car.upgrade;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarUpgradeService extends IInterface {
    public static abstract class Stub extends Binder implements ICarUpgradeService {
        static class Proxy implements ICarUpgradeService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // com.yftech.car.upgrade.ICarUpgradeService
            public int addUpgradeModule(int module, String[] pathList) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.upgrade.ICarUpgradeService");
                    parcel0.writeInt(module);
                    parcel0.writeStringArray(pathList);
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // com.yftech.car.upgrade.ICarUpgradeService
            public boolean checkUpgradeFile(int module, String[] pathList) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.upgrade.ICarUpgradeService");
                    parcel0.writeInt(module);
                    parcel0.writeStringArray(pathList);
                    this.mRemote.transact(3, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.upgrade.ICarUpgradeService
            public CarUpgradeInfo getCurUpgradeingInfo() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.upgrade.ICarUpgradeService");
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((CarUpgradeInfo)CarUpgradeInfo.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.upgrade.ICarUpgradeService
            public int[] getHasAddUpgradeModule() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.upgrade.ICarUpgradeService");
                    this.mRemote.transact(8, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createIntArray();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.upgrade.ICarUpgradeService";
            }

            @Override  // com.yftech.car.upgrade.ICarUpgradeService
            public String getVersion(int module) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.upgrade.ICarUpgradeService");
                    parcel0.writeInt(module);
                    this.mRemote.transact(9, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.upgrade.ICarUpgradeService
            public void registerListener(ICarUpgradeCallback listener) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.upgrade.ICarUpgradeService");
                    parcel0.writeStrongBinder((listener == null ? null : listener.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.upgrade.ICarUpgradeService
            public int removeUpgradeModule(int module) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.upgrade.ICarUpgradeService");
                    parcel0.writeInt(module);
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.upgrade.ICarUpgradeService
            public boolean startUpgrade() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.upgrade.ICarUpgradeService");
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

            @Override  // com.yftech.car.upgrade.ICarUpgradeService
            public void unregisterListener(ICarUpgradeCallback listener) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.upgrade.ICarUpgradeService");
                    parcel0.writeStrongBinder((listener == null ? null : listener.asBinder()));
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.upgrade.ICarUpgradeService";
        static final int TRANSACTION_addUpgradeModule = 4;
        static final int TRANSACTION_checkUpgradeFile = 3;
        static final int TRANSACTION_getCurUpgradeingInfo = 7;
        static final int TRANSACTION_getHasAddUpgradeModule = 8;
        static final int TRANSACTION_getVersion = 9;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_removeUpgradeModule = 5;
        static final int TRANSACTION_startUpgrade = 6;
        static final int TRANSACTION_unregisterListener = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.upgrade.ICarUpgradeService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarUpgradeService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.upgrade.ICarUpgradeService");
            return iInterface0 != null && (iInterface0 instanceof ICarUpgradeService) ? ((ICarUpgradeService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int v2 = 0;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.upgrade.ICarUpgradeService");
                    this.registerListener(com.yftech.car.upgrade.ICarUpgradeCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.upgrade.ICarUpgradeService");
                    this.unregisterListener(com.yftech.car.upgrade.ICarUpgradeCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.upgrade.ICarUpgradeService");
                    boolean z = this.checkUpgradeFile(data.readInt(), data.createStringArray());
                    reply.writeNoException();
                    if(z) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.upgrade.ICarUpgradeService");
                    int v3 = this.addUpgradeModule(data.readInt(), data.createStringArray());
                    reply.writeNoException();
                    reply.writeInt(v3);
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.upgrade.ICarUpgradeService");
                    int v4 = this.removeUpgradeModule(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(v4);
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.upgrade.ICarUpgradeService");
                    boolean z1 = this.startUpgrade();
                    reply.writeNoException();
                    if(z1) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.upgrade.ICarUpgradeService");
                    CarUpgradeInfo carUpgradeInfo0 = this.getCurUpgradeingInfo();
                    reply.writeNoException();
                    if(carUpgradeInfo0 != null) {
                        reply.writeInt(1);
                        carUpgradeInfo0.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.upgrade.ICarUpgradeService");
                    int[] arr_v = this.getHasAddUpgradeModule();
                    reply.writeNoException();
                    reply.writeIntArray(arr_v);
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.upgrade.ICarUpgradeService");
                    String s = this.getVersion(data.readInt());
                    reply.writeNoException();
                    reply.writeString(s);
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.upgrade.ICarUpgradeService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    int addUpgradeModule(int arg1, String[] arg2) throws RemoteException;

    boolean checkUpgradeFile(int arg1, String[] arg2) throws RemoteException;

    CarUpgradeInfo getCurUpgradeingInfo() throws RemoteException;

    int[] getHasAddUpgradeModule() throws RemoteException;

    String getVersion(int arg1) throws RemoteException;

    void registerListener(ICarUpgradeCallback arg1) throws RemoteException;

    int removeUpgradeModule(int arg1) throws RemoteException;

    boolean startUpgrade() throws RemoteException;

    void unregisterListener(ICarUpgradeCallback arg1) throws RemoteException;
}

