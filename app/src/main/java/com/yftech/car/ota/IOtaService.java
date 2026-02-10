package com.yftech.car.ota;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOtaService extends IInterface {
    public static abstract class Stub extends Binder implements IOtaService {
        static class Proxy implements IOtaService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // com.yftech.car.ota.IOtaService
            public void exitOtaMode() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.ota.IOtaService");
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.ota.IOtaService";
            }

            @Override  // com.yftech.car.ota.IOtaService
            public ScheduleField getScheduleField() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.ota.IOtaService");
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((ScheduleField)ScheduleField.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.ota.IOtaService
            public boolean isOtaMode() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.ota.IOtaService");
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

            @Override  // com.yftech.car.ota.IOtaService
            public void openOtaMode() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.ota.IOtaService");
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.ota.IOtaService
            public void registerOtaStateChangeListener(IOtaStateChangeListener listener) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.ota.IOtaService");
                    parcel0.writeStrongBinder((listener == null ? null : listener.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.ota.IOtaService
            public void setScheduleField(ScheduleField field) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.ota.IOtaService");
                    if(field == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        field.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.ota.IOtaService
            public void unregisterOtaStateChangeListener(IOtaStateChangeListener listener) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.ota.IOtaService");
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

        private static final String DESCRIPTOR = "com.yftech.car.ota.IOtaService";
        static final int TRANSACTION_exitOtaMode = 5;
        static final int TRANSACTION_getScheduleField = 6;
        static final int TRANSACTION_isOtaMode = 4;
        static final int TRANSACTION_openOtaMode = 3;
        static final int TRANSACTION_registerOtaStateChangeListener = 1;
        static final int TRANSACTION_setScheduleField = 7;
        static final int TRANSACTION_unregisterOtaStateChangeListener = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.ota.IOtaService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IOtaService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.ota.IOtaService");
            return iInterface0 != null && (iInterface0 instanceof IOtaService) ? ((IOtaService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int v2 = 0;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.ota.IOtaService");
                    this.registerOtaStateChangeListener(com.yftech.car.ota.IOtaStateChangeListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.ota.IOtaService");
                    this.unregisterOtaStateChangeListener(com.yftech.car.ota.IOtaStateChangeListener.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.ota.IOtaService");
                    this.openOtaMode();
                    reply.writeNoException();
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.ota.IOtaService");
                    boolean z = this.isOtaMode();
                    reply.writeNoException();
                    if(z) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.ota.IOtaService");
                    this.exitOtaMode();
                    reply.writeNoException();
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.ota.IOtaService");
                    ScheduleField scheduleField0 = this.getScheduleField();
                    reply.writeNoException();
                    if(scheduleField0 != null) {
                        reply.writeInt(1);
                        scheduleField0.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.ota.IOtaService");
                    this.setScheduleField((data.readInt() == 0 ? null : ((ScheduleField)ScheduleField.CREATOR.createFromParcel(data))));
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.ota.IOtaService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void exitOtaMode() throws RemoteException;

    ScheduleField getScheduleField() throws RemoteException;

    boolean isOtaMode() throws RemoteException;

    void openOtaMode() throws RemoteException;

    void registerOtaStateChangeListener(IOtaStateChangeListener arg1) throws RemoteException;

    void setScheduleField(ScheduleField arg1) throws RemoteException;

    void unregisterOtaStateChangeListener(IOtaStateChangeListener arg1) throws RemoteException;
}

