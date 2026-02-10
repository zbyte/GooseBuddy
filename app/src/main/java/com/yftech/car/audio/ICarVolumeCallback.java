package com.yftech.car.audio;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarVolumeCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarVolumeCallback {
        static class Proxy implements ICarVolumeCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.audio.ICarVolumeCallback";
            }

            @Override  // com.yftech.car.audio.ICarVolumeCallback
            public void onCarVolumeChanged(int streamType, int index, boolean mute, int flag) throws RemoteException {
                int v3 = 1;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarVolumeCallback");
                    parcel0.writeInt(streamType);
                    parcel0.writeInt(index);
                    if(!mute) {
                        v3 = 0;
                    }
                    parcel0.writeInt(v3);
                    parcel0.writeInt(flag);
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.audio.ICarVolumeCallback";
        static final int TRANSACTION_onCarVolumeChanged = 1;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.audio.ICarVolumeCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarVolumeCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.audio.ICarVolumeCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarVolumeCallback) ? ((ICarVolumeCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.audio.ICarVolumeCallback");
                    this.onCarVolumeChanged(data.readInt(), data.readInt(), data.readInt() != 0, data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.audio.ICarVolumeCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onCarVolumeChanged(int arg1, int arg2, boolean arg3, int arg4) throws RemoteException;
}

