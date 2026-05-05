package android.car.trust;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarTrustAgentEnrolmentCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarTrustAgentEnrolmentCallback {
        static class Proxy implements ICarTrustAgentEnrolmentCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.trust.ICarTrustAgentEnrolmentCallback";
            }

            @Override  // android.car.trust.ICarTrustAgentEnrolmentCallback
            public void onEnrolmentDataReceived(byte[] token) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentEnrolmentCallback");
                    parcel0.writeByteArray(token);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.trust.ICarTrustAgentEnrolmentCallback";
        static final int TRANSACTION_onEnrolmentDataReceived = 1;

        public Stub() {
            this.attachInterface(this, "android.car.trust.ICarTrustAgentEnrolmentCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarTrustAgentEnrolmentCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.trust.ICarTrustAgentEnrolmentCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarTrustAgentEnrolmentCallback) ? ((ICarTrustAgentEnrolmentCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("android.car.trust.ICarTrustAgentEnrolmentCallback");
                    this.onEnrolmentDataReceived(data.createByteArray());
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.car.trust.ICarTrustAgentEnrolmentCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onEnrolmentDataReceived(byte[] arg1) throws RemoteException;
}

