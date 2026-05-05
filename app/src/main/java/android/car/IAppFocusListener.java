package android.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IAppFocusListener extends IInterface {
    public static abstract class Stub extends Binder implements IAppFocusListener {
        static class Proxy implements IAppFocusListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.IAppFocusListener";
            }

            @Override  // android.car.IAppFocusListener
            public void onAppFocusChanged(int appType, boolean active) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.IAppFocusListener");
                    parcel0.writeInt(appType);
                    parcel0.writeInt((active?1:0));
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.IAppFocusListener";
        static final int TRANSACTION_onAppFocusChanged = 1;

        public Stub() {
            this.attachInterface(this, "android.car.IAppFocusListener");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IAppFocusListener asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.IAppFocusListener");
            return iInterface0 != null && (iInterface0 instanceof IAppFocusListener) ? ((IAppFocusListener)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("android.car.IAppFocusListener");
                    this.onAppFocusChanged(data.readInt(), data.readInt() != 0);
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.car.IAppFocusListener");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onAppFocusChanged(int arg1, boolean arg2) throws RemoteException;
}

