package android.car.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarAppBlockingPolicy extends IInterface {
    public static abstract class Stub extends Binder implements ICarAppBlockingPolicy {
        static class Proxy implements ICarAppBlockingPolicy {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.content.pm.ICarAppBlockingPolicy";
            }

            @Override  // android.car.content.pm.ICarAppBlockingPolicy
            public void setAppBlockingPolicySetter(ICarAppBlockingPolicySetter setter) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.content.pm.ICarAppBlockingPolicy");
                    parcel0.writeStrongBinder((setter == null ? null : setter.asBinder()));
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.content.pm.ICarAppBlockingPolicy";
        static final int TRANSACTION_setAppBlockingPolicySetter = 1;

        public Stub() {
            this.attachInterface(this, "android.car.content.pm.ICarAppBlockingPolicy");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarAppBlockingPolicy asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.content.pm.ICarAppBlockingPolicy");
            return iInterface0 != null && (iInterface0 instanceof ICarAppBlockingPolicy) ? ((ICarAppBlockingPolicy)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("android.car.content.pm.ICarAppBlockingPolicy");
                    this.setAppBlockingPolicySetter(android.car.content.pm.ICarAppBlockingPolicySetter.Stub.asInterface(data.readStrongBinder()));
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.car.content.pm.ICarAppBlockingPolicy");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void setAppBlockingPolicySetter(ICarAppBlockingPolicySetter arg1) throws RemoteException;
}

