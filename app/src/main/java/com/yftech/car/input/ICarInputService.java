package com.yftech.car.input;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarInputService extends IInterface {
    public static abstract class Stub extends Binder implements ICarInputService {
        static class Proxy implements ICarInputService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // com.yftech.car.input.ICarInputService
            public int getCustomKeyFunction() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.input.ICarInputService");
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.input.ICarInputService
            public CarKeyCustomFunction getCustomKeyFunctions() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.input.ICarInputService");
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((CarKeyCustomFunction)CarKeyCustomFunction.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.input.ICarInputService";
            }

            @Override  // com.yftech.car.input.ICarInputService
            public void registerCarInputCallback(ICarInputCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.input.ICarInputService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.input.ICarInputService
            public void responseCarKeyAction(CarKey event) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.input.ICarInputService");
                    if(event == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        event.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.input.ICarInputService
            public void setCustomKeyFunction(int function) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.input.ICarInputService");
                    parcel0.writeInt(function);
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.input.ICarInputService
            public void setCustomKeyFunctions(CarKeyCustomFunction function) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.input.ICarInputService");
                    if(function == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        function.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.input.ICarInputService
            public void unregisterCarInputCallback(ICarInputCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.input.ICarInputService");
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

        private static final String DESCRIPTOR = "com.yftech.car.input.ICarInputService";
        static final int TRANSACTION_getCustomKeyFunction = 4;
        static final int TRANSACTION_getCustomKeyFunctions = 7;
        static final int TRANSACTION_registerCarInputCallback = 1;
        static final int TRANSACTION_responseCarKeyAction = 5;
        static final int TRANSACTION_setCustomKeyFunction = 3;
        static final int TRANSACTION_setCustomKeyFunctions = 6;
        static final int TRANSACTION_unregisterCarInputCallback = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.input.ICarInputService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarInputService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.input.ICarInputService");
            return iInterface0 != null && (iInterface0 instanceof ICarInputService) ? ((ICarInputService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.input.ICarInputService");
                    this.registerCarInputCallback(com.yftech.car.input.ICarInputCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.input.ICarInputService");
                    this.unregisterCarInputCallback(com.yftech.car.input.ICarInputCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.input.ICarInputService");
                    this.setCustomKeyFunction(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.input.ICarInputService");
                    int v2 = this.getCustomKeyFunction();
                    reply.writeNoException();
                    reply.writeInt(v2);
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.input.ICarInputService");
                    this.responseCarKeyAction((data.readInt() == 0 ? null : ((CarKey)CarKey.CREATOR.createFromParcel(data))));
                    reply.writeNoException();
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.input.ICarInputService");
                    this.setCustomKeyFunctions((data.readInt() == 0 ? null : ((CarKeyCustomFunction)CarKeyCustomFunction.CREATOR.createFromParcel(data))));
                    reply.writeNoException();
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.input.ICarInputService");
                    CarKeyCustomFunction carKeyCustomFunction0 = this.getCustomKeyFunctions();
                    reply.writeNoException();
                    if(carKeyCustomFunction0 != null) {
                        reply.writeInt(1);
                        carKeyCustomFunction0.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.input.ICarInputService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    int getCustomKeyFunction() throws RemoteException;

    CarKeyCustomFunction getCustomKeyFunctions() throws RemoteException;

    void registerCarInputCallback(ICarInputCallback arg1) throws RemoteException;

    void responseCarKeyAction(CarKey arg1) throws RemoteException;

    void setCustomKeyFunction(int arg1) throws RemoteException;

    void setCustomKeyFunctions(CarKeyCustomFunction arg1) throws RemoteException;

    void unregisterCarInputCallback(ICarInputCallback arg1) throws RemoteException;
}

