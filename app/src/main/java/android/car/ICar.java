package android.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICar extends IInterface {
    public static abstract class Stub extends Binder implements ICar {
        static class Proxy implements ICar {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // android.car.ICar
            public int getCarConnectionType() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.ICar");
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.ICar
            public IBinder getCarService(String serviceName) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.ICar");
                    parcel0.writeString(serviceName);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readStrongBinder();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "android.car.ICar";
            }

            @Override  // android.car.ICar
            public void setCarServiceHelper(IBinder helper) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.ICar");
                    parcel0.writeStrongBinder(helper);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.ICar";
        static final int TRANSACTION_getCarConnectionType = 3;
        static final int TRANSACTION_getCarService = 2;
        static final int TRANSACTION_setCarServiceHelper = 1;

        public Stub() {
            this.attachInterface(this, "android.car.ICar");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICar asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.ICar");
            return iInterface0 != null && (iInterface0 instanceof ICar) ? ((ICar)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code != 0x5F4E5446) {
                switch(code) {
                    case 1: {
                        data.enforceInterface("android.car.ICar");
                        this.setCarServiceHelper(data.readStrongBinder());
                        return true;
                    }
                    case 2: {
                        data.enforceInterface("android.car.ICar");
                        IBinder iBinder0 = this.getCarService(data.readString());
                        reply.writeNoException();
                        reply.writeStrongBinder(iBinder0);
                        return true;
                    }
                    case 3: {
                        data.enforceInterface("android.car.ICar");
                        int v2 = this.getCarConnectionType();
                        reply.writeNoException();
                        reply.writeInt(v2);
                        return true;
                    }
                    default: {
                        return super.onTransact(code, data, reply, flags);
                    }
                }
            }
            reply.writeString("android.car.ICar");
            return true;
        }
    }

    int getCarConnectionType() throws RemoteException;

    IBinder getCarService(String arg1) throws RemoteException;

    void setCarServiceHelper(IBinder arg1) throws RemoteException;
}

