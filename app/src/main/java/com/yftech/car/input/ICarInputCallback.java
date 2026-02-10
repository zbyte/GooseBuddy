package com.yftech.car.input;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarInputCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarInputCallback {
        static class Proxy implements ICarInputCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.input.ICarInputCallback";
            }

            @Override  // com.yftech.car.input.ICarInputCallback
            public void onChangedCustomKeyFunction(int function) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.input.ICarInputCallback");
                    parcel0.writeInt(function);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.input.ICarInputCallback
            public void onChangedCustomKeyFunctions(CarKeyCustomFunction function) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.input.ICarInputCallback");
                    if(function == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        function.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(5, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.input.ICarInputCallback
            public void onInputKeyCustomFunction(CarKeyCustomFunction function) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.input.ICarInputCallback");
                    if(function == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        function.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.input.ICarInputCallback
            public void onInputKeyEvent(CarKey key) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.input.ICarInputCallback");
                    if(key == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        key.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.input.ICarInputCallback
            public void onInputKnobEvent(CarKnob knob) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.input.ICarInputCallback");
                    if(knob == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        knob.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.input.ICarInputCallback";
        static final int TRANSACTION_onChangedCustomKeyFunction = 4;
        static final int TRANSACTION_onChangedCustomKeyFunctions = 5;
        static final int TRANSACTION_onInputKeyCustomFunction = 3;
        static final int TRANSACTION_onInputKeyEvent = 1;
        static final int TRANSACTION_onInputKnobEvent = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.input.ICarInputCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarInputCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.input.ICarInputCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarInputCallback) ? ((ICarInputCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.input.ICarInputCallback");
                    this.onInputKeyEvent((data.readInt() == 0 ? null : ((CarKey)CarKey.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.input.ICarInputCallback");
                    this.onInputKnobEvent((data.readInt() == 0 ? null : ((CarKnob)CarKnob.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.input.ICarInputCallback");
                    this.onInputKeyCustomFunction((data.readInt() == 0 ? null : ((CarKeyCustomFunction)CarKeyCustomFunction.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.input.ICarInputCallback");
                    this.onChangedCustomKeyFunction(data.readInt());
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.input.ICarInputCallback");
                    this.onChangedCustomKeyFunctions((data.readInt() == 0 ? null : ((CarKeyCustomFunction)CarKeyCustomFunction.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.input.ICarInputCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onChangedCustomKeyFunction(int arg1) throws RemoteException;

    void onChangedCustomKeyFunctions(CarKeyCustomFunction arg1) throws RemoteException;

    void onInputKeyCustomFunction(CarKeyCustomFunction arg1) throws RemoteException;

    void onInputKeyEvent(CarKey arg1) throws RemoteException;

    void onInputKnobEvent(CarKnob arg1) throws RemoteException;
}

