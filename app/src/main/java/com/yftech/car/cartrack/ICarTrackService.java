package com.yftech.car.cartrack;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

public interface ICarTrackService extends IInterface {
    public static abstract class Stub extends Binder implements ICarTrackService {
        static class Proxy implements ICarTrackService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.cartrack.ICarTrackService";
            }

            @Override  // com.yftech.car.cartrack.ICarTrackService
            public void tracking(String pkgName, String action, Map evetValue) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.cartrack.ICarTrackService");
                    parcel0.writeString(pkgName);
                    parcel0.writeString(action);
                    parcel0.writeMap(evetValue);
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.cartrack.ICarTrackService";
        static final int TRANSACTION_tracking = 1;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.cartrack.ICarTrackService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarTrackService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.cartrack.ICarTrackService");
            return iInterface0 != null && (iInterface0 instanceof ICarTrackService) ? ((ICarTrackService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.cartrack.ICarTrackService");
                    this.tracking(data.readString(), data.readString(), data.readHashMap(this.getClass().getClassLoader()));
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.cartrack.ICarTrackService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void tracking(String arg1, String arg2, Map arg3) throws RemoteException;
}

