package com.yftech.car.data;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarDataCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarDataCallback {
        static class Proxy implements ICarDataCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.data.ICarDataCallback";
            }

            @Override  // com.yftech.car.data.ICarDataCallback
            public void onCarDataChanged(CarData data) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.data.ICarDataCallback");
                    if(data == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        data.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.data.ICarDataCallback";
        static final int TRANSACTION_onCarDataChanged = 1;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.data.ICarDataCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarDataCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.data.ICarDataCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarDataCallback) ? ((ICarDataCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.data.ICarDataCallback");
                    this.onCarDataChanged((data.readInt() == 0 ? null : ((CarData)CarData.CREATOR.createFromParcel(data))));
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.data.ICarDataCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onCarDataChanged(CarData arg1) throws RemoteException;
}

