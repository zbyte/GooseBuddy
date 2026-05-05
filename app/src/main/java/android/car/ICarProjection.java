package android.car;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarProjection extends IInterface {
    public static abstract class Stub extends Binder implements ICarProjection {
        static class Proxy implements ICarProjection {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.ICarProjection";
            }

            @Override  // android.car.ICarProjection
            public void registerProjectionListener(ICarProjectionCallback callback, int filter) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.ICarProjection");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    parcel0.writeInt(filter);
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.ICarProjection
            public void registerProjectionRunner(Intent serviceIntent) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.ICarProjection");
                    if(serviceIntent == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        serviceIntent.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.ICarProjection
            public void unregisterProjectionListener(ICarProjectionCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.ICarProjection");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.ICarProjection
            public void unregisterProjectionRunner(Intent serviceIntent) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.ICarProjection");
                    if(serviceIntent == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        serviceIntent.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.ICarProjection";
        static final int TRANSACTION_registerProjectionListener = 3;
        static final int TRANSACTION_registerProjectionRunner = 1;
        static final int TRANSACTION_unregisterProjectionListener = 4;
        static final int TRANSACTION_unregisterProjectionRunner = 2;

        public Stub() {
            this.attachInterface(this, "android.car.ICarProjection");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarProjection asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.ICarProjection");
            return iInterface0 != null && (iInterface0 instanceof ICarProjection) ? ((ICarProjection)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code != 0x5F4E5446) {
                Intent _arg0 = null;
                switch(code) {
                    case 1: {
                        data.enforceInterface("android.car.ICarProjection");
                        if(data.readInt() != 0) {
                            _arg0 = (Intent)Intent.CREATOR.createFromParcel(data);
                        }
                        this.registerProjectionRunner(_arg0);
                        reply.writeNoException();
                        return true;
                    }
                    case 2: {
                        data.enforceInterface("android.car.ICarProjection");
                        if(data.readInt() != 0) {
                            _arg0 = (Intent)Intent.CREATOR.createFromParcel(data);
                        }
                        this.unregisterProjectionRunner(_arg0);
                        reply.writeNoException();
                        return true;
                    }
                    case 3: {
                        data.enforceInterface("android.car.ICarProjection");
                        this.registerProjectionListener(android.car.ICarProjectionCallback.Stub.asInterface(data.readStrongBinder()), data.readInt());
                        reply.writeNoException();
                        return true;
                    }
                    case 4: {
                        data.enforceInterface("android.car.ICarProjection");
                        this.unregisterProjectionListener(android.car.ICarProjectionCallback.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    default: {
                        return super.onTransact(code, data, reply, flags);
                    }
                }
            }
            reply.writeString("android.car.ICarProjection");
            return true;
        }
    }

    void registerProjectionListener(ICarProjectionCallback arg1, int arg2) throws RemoteException;

    void registerProjectionRunner(Intent arg1) throws RemoteException;

    void unregisterProjectionListener(ICarProjectionCallback arg1) throws RemoteException;

    void unregisterProjectionRunner(Intent arg1) throws RemoteException;
}

