package android.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IAppFocusOwnershipCallback extends IInterface {
    public static abstract class Stub extends Binder implements IAppFocusOwnershipCallback {
        static class Proxy implements IAppFocusOwnershipCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.IAppFocusOwnershipCallback";
            }

            @Override  // android.car.IAppFocusOwnershipCallback
            public void onAppFocusOwnershipGranted(int appType) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.IAppFocusOwnershipCallback");
                    parcel0.writeInt(appType);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.car.IAppFocusOwnershipCallback
            public void onAppFocusOwnershipLost(int appType) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.IAppFocusOwnershipCallback");
                    parcel0.writeInt(appType);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.IAppFocusOwnershipCallback";
        static final int TRANSACTION_onAppFocusOwnershipGranted = 2;
        static final int TRANSACTION_onAppFocusOwnershipLost = 1;

        public Stub() {
            this.attachInterface(this, "android.car.IAppFocusOwnershipCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IAppFocusOwnershipCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.IAppFocusOwnershipCallback");
            return iInterface0 != null && (iInterface0 instanceof IAppFocusOwnershipCallback) ? ((IAppFocusOwnershipCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code != 0x5F4E5446) {
                switch(code) {
                    case 1: {
                        data.enforceInterface("android.car.IAppFocusOwnershipCallback");
                        this.onAppFocusOwnershipLost(data.readInt());
                        return true;
                    }
                    case 2: {
                        data.enforceInterface("android.car.IAppFocusOwnershipCallback");
                        this.onAppFocusOwnershipGranted(data.readInt());
                        return true;
                    }
                    default: {
                        return super.onTransact(code, data, reply, flags);
                    }
                }
            }
            reply.writeString("android.car.IAppFocusOwnershipCallback");
            return true;
        }
    }

    void onAppFocusOwnershipGranted(int arg1) throws RemoteException;

    void onAppFocusOwnershipLost(int arg1) throws RemoteException;
}

