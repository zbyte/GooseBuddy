package com.yftech.car.carinfoloader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarInfoLoaderCallBack extends IInterface {
    public static abstract class Stub extends Binder implements ICarInfoLoaderCallBack {
        static class Proxy implements ICarInfoLoaderCallBack {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.carinfoloader.ICarInfoLoaderCallBack";
            }

            @Override  // com.yftech.car.carinfoloader.ICarInfoLoaderCallBack
            public void onInfo(String cpuId, String uuid, String sn, String vin) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.carinfoloader.ICarInfoLoaderCallBack");
                    parcel0.writeString(cpuId);
                    parcel0.writeString(uuid);
                    parcel0.writeString(sn);
                    parcel0.writeString(vin);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.carinfoloader.ICarInfoLoaderCallBack";
        static final int TRANSACTION_onInfo = 1;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.carinfoloader.ICarInfoLoaderCallBack");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarInfoLoaderCallBack asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.carinfoloader.ICarInfoLoaderCallBack");
            return iInterface0 != null && (iInterface0 instanceof ICarInfoLoaderCallBack) ? ((ICarInfoLoaderCallBack)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.carinfoloader.ICarInfoLoaderCallBack");
                    this.onInfo(data.readString(), data.readString(), data.readString(), data.readString());
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.carinfoloader.ICarInfoLoaderCallBack");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onInfo(String arg1, String arg2, String arg3, String arg4) throws RemoteException;
}

