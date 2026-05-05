package android.car.trust;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarTrustAgentUnlockCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarTrustAgentUnlockCallback {
        static class Proxy implements ICarTrustAgentUnlockCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.trust.ICarTrustAgentUnlockCallback";
            }

            @Override  // android.car.trust.ICarTrustAgentUnlockCallback
            public void onUnlockDataReceived(byte[] token, long handle) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentUnlockCallback");
                    parcel0.writeByteArray(token);
                    parcel0.writeLong(handle);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.trust.ICarTrustAgentUnlockCallback";
        static final int TRANSACTION_onUnlockDataReceived = 1;

        public Stub() {
            this.attachInterface(this, "android.car.trust.ICarTrustAgentUnlockCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarTrustAgentUnlockCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.trust.ICarTrustAgentUnlockCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarTrustAgentUnlockCallback) ? ((ICarTrustAgentUnlockCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("android.car.trust.ICarTrustAgentUnlockCallback");
                    this.onUnlockDataReceived(data.createByteArray(), data.readLong());
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.car.trust.ICarTrustAgentUnlockCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onUnlockDataReceived(byte[] arg1, long arg2) throws RemoteException;
}

