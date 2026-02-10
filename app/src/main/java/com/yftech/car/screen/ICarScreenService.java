package com.yftech.car.screen;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarScreenService extends IInterface {
    public static abstract class Stub extends Binder implements ICarScreenService {
        static class Proxy implements ICarScreenService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // com.yftech.car.screen.ICarScreenService
            public boolean closeScreenBrightness(int displayId, int type) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenService");
                    parcel0.writeInt(displayId);
                    parcel0.writeInt(type);
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

            @Override  // com.yftech.car.screen.ICarScreenService
            public boolean foldScreen(int displayId) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenService");
                    parcel0.writeInt(displayId);
                    this.mRemote.transact(12, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.screen.ICarScreenService
            public int getBrightness(int displayId) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenService");
                    parcel0.writeInt(displayId);
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.screen.ICarScreenService
            public int getBrightnessMaxValue(int displayId) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenService");
                    parcel0.writeInt(displayId);
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.screen.ICarScreenService
            public int getDayNightMode(int displayId) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenService");
                    parcel0.writeInt(displayId);
                    this.mRemote.transact(10, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.screen.ICarScreenService";
            }

            @Override  // com.yftech.car.screen.ICarScreenService
            public boolean isOpenScreenBrightness(int displayId) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenService");
                    parcel0.writeInt(displayId);
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

            @Override  // com.yftech.car.screen.ICarScreenService
            public boolean isScreenFold(int displayId) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenService");
                    parcel0.writeInt(displayId);
                    this.mRemote.transact(14, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.screen.ICarScreenService
            public boolean openScreenBrightness(int displayId, int type) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenService");
                    parcel0.writeInt(displayId);
                    parcel0.writeInt(type);
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

            @Override  // com.yftech.car.screen.ICarScreenService
            public void registerCarScreenCallback(ICarScreenCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.screen.ICarScreenService
            public boolean setBrightness(int displayId, int brightness) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenService");
                    parcel0.writeInt(displayId);
                    parcel0.writeInt(brightness);
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

            @Override  // com.yftech.car.screen.ICarScreenService
            public boolean setBrightness2(int displayId, int brightness, int reason) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenService");
                    parcel0.writeInt(displayId);
                    parcel0.writeInt(brightness);
                    parcel0.writeInt(reason);
                    this.mRemote.transact(11, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.screen.ICarScreenService
            public boolean setDayNightMode(int displayId, int mode) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenService");
                    parcel0.writeInt(displayId);
                    parcel0.writeInt(mode);
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

            @Override  // com.yftech.car.screen.ICarScreenService
            public boolean unfoldScreen(int displayId) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenService");
                    parcel0.writeInt(displayId);
                    this.mRemote.transact(13, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.screen.ICarScreenService
            public void unregisterCarScreenCallback(ICarScreenCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.screen.ICarScreenService");
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

        private static final String DESCRIPTOR = "com.yftech.car.screen.ICarScreenService";
        static final int TRANSACTION_closeScreenBrightness = 6;
        static final int TRANSACTION_foldScreen = 12;
        static final int TRANSACTION_getBrightness = 5;
        static final int TRANSACTION_getBrightnessMaxValue = 3;
        static final int TRANSACTION_getDayNightMode = 10;
        static final int TRANSACTION_isOpenScreenBrightness = 8;
        static final int TRANSACTION_isScreenFold = 14;
        static final int TRANSACTION_openScreenBrightness = 7;
        static final int TRANSACTION_registerCarScreenCallback = 1;
        static final int TRANSACTION_setBrightness = 4;
        static final int TRANSACTION_setBrightness2 = 11;
        static final int TRANSACTION_setDayNightMode = 9;
        static final int TRANSACTION_unfoldScreen = 13;
        static final int TRANSACTION_unregisterCarScreenCallback = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.screen.ICarScreenService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarScreenService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.screen.ICarScreenService");
            return iInterface0 != null && (iInterface0 instanceof ICarScreenService) ? ((ICarScreenService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int v2 = 0;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenService");
                    this.registerCarScreenCallback(com.yftech.car.screen.ICarScreenCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenService");
                    this.unregisterCarScreenCallback(com.yftech.car.screen.ICarScreenCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenService");
                    int v3 = this.getBrightnessMaxValue(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(v3);
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenService");
                    boolean z = this.setBrightness(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if(z) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenService");
                    int v4 = this.getBrightness(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(v4);
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenService");
                    boolean z1 = this.closeScreenBrightness(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if(z1) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenService");
                    boolean z2 = this.openScreenBrightness(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if(z2) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenService");
                    boolean z3 = this.isOpenScreenBrightness(data.readInt());
                    reply.writeNoException();
                    if(z3) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenService");
                    boolean z4 = this.setDayNightMode(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if(z4) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 10: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenService");
                    int v5 = this.getDayNightMode(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(v5);
                    return true;
                }
                case 11: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenService");
                    boolean z5 = this.setBrightness2(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if(z5) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 12: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenService");
                    boolean z6 = this.foldScreen(data.readInt());
                    reply.writeNoException();
                    if(z6) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 13: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenService");
                    boolean z7 = this.unfoldScreen(data.readInt());
                    reply.writeNoException();
                    if(z7) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 14: {
                    data.enforceInterface("com.yftech.car.screen.ICarScreenService");
                    boolean z8 = this.isScreenFold(data.readInt());
                    reply.writeNoException();
                    if(z8) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.screen.ICarScreenService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    boolean closeScreenBrightness(int arg1, int arg2) throws RemoteException;

    boolean foldScreen(int arg1) throws RemoteException;

    int getBrightness(int arg1) throws RemoteException;

    int getBrightnessMaxValue(int arg1) throws RemoteException;

    int getDayNightMode(int arg1) throws RemoteException;

    boolean isOpenScreenBrightness(int arg1) throws RemoteException;

    boolean isScreenFold(int arg1) throws RemoteException;

    boolean openScreenBrightness(int arg1, int arg2) throws RemoteException;

    void registerCarScreenCallback(ICarScreenCallback arg1) throws RemoteException;

    boolean setBrightness(int arg1, int arg2) throws RemoteException;

    boolean setBrightness2(int arg1, int arg2, int arg3) throws RemoteException;

    boolean setDayNightMode(int arg1, int arg2) throws RemoteException;

    boolean unfoldScreen(int arg1) throws RemoteException;

    void unregisterCarScreenCallback(ICarScreenCallback arg1) throws RemoteException;
}

