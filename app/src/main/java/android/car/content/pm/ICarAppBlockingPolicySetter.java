package android.car.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarAppBlockingPolicySetter extends IInterface {
    public static abstract class Stub extends Binder implements ICarAppBlockingPolicySetter {
        static class Proxy implements ICarAppBlockingPolicySetter {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.content.pm.ICarAppBlockingPolicySetter";
            }

            @Override  // android.car.content.pm.ICarAppBlockingPolicySetter
            public void setAppBlockingPolicy(CarAppBlockingPolicy policy) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.content.pm.ICarAppBlockingPolicySetter");
                    if(policy == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        policy.writeToParcel(parcel0, 0);
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

        private static final String DESCRIPTOR = "android.car.content.pm.ICarAppBlockingPolicySetter";
        static final int TRANSACTION_setAppBlockingPolicy = 1;

        public Stub() {
            this.attachInterface(this, "android.car.content.pm.ICarAppBlockingPolicySetter");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarAppBlockingPolicySetter asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.content.pm.ICarAppBlockingPolicySetter");
            return iInterface0 != null && (iInterface0 instanceof ICarAppBlockingPolicySetter) ? ((ICarAppBlockingPolicySetter)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("android.car.content.pm.ICarAppBlockingPolicySetter");
                    this.setAppBlockingPolicy((data.readInt() == 0 ? null : ((CarAppBlockingPolicy)CarAppBlockingPolicy.CREATOR.createFromParcel(data))));
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.car.content.pm.ICarAppBlockingPolicySetter");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void setAppBlockingPolicy(CarAppBlockingPolicy arg1) throws RemoteException;
}

