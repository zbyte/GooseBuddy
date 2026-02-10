package com.yftech.car.phonelink;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarPhoneLinkMediaCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarPhoneLinkMediaCallback {
        static class Proxy implements ICarPhoneLinkMediaCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.phonelink.ICarPhoneLinkMediaCallback";
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkMediaCallback
            public void onMediaInfoChanged(PhoneLinkMediaInfo info) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkMediaCallback");
                    if(info == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        info.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.phonelink.ICarPhoneLinkMediaCallback";
        static final int TRANSACTION_onMediaInfoChanged = 1;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.phonelink.ICarPhoneLinkMediaCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarPhoneLinkMediaCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.phonelink.ICarPhoneLinkMediaCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarPhoneLinkMediaCallback) ? ((ICarPhoneLinkMediaCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkMediaCallback");
                    this.onMediaInfoChanged((data.readInt() == 0 ? null : ((PhoneLinkMediaInfo)PhoneLinkMediaInfo.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.phonelink.ICarPhoneLinkMediaCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onMediaInfoChanged(PhoneLinkMediaInfo arg1) throws RemoteException;
}

