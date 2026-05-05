package android.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarProjectionCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarProjectionCallback {
        static class Proxy implements ICarProjectionCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.ICarProjectionCallback";
            }

            @Override  // android.car.ICarProjectionCallback
            public void onVoiceAssistantRequest(boolean fromLongPress) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.ICarProjectionCallback");
                    parcel0.writeInt((fromLongPress?1:0));
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.ICarProjectionCallback";
        static final int TRANSACTION_onVoiceAssistantRequest = 1;

        public Stub() {
            this.attachInterface(this, "android.car.ICarProjectionCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarProjectionCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.ICarProjectionCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarProjectionCallback) ? ((ICarProjectionCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("android.car.ICarProjectionCallback");
                    this.onVoiceAssistantRequest(data.readInt() != 0);
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.car.ICarProjectionCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onVoiceAssistantRequest(boolean arg1) throws RemoteException;
}

