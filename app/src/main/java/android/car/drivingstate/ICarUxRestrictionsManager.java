package android.car.drivingstate;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface ICarUxRestrictionsManager extends IInterface {
    public static abstract class Stub extends Binder implements ICarUxRestrictionsManager {
        static class Proxy implements ICarUxRestrictionsManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // android.car.drivingstate.ICarUxRestrictionsManager
            public CarUxRestrictions getCurrentUxRestrictions() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.drivingstate.ICarUxRestrictionsManager");
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((CarUxRestrictions)CarUxRestrictions.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "android.car.drivingstate.ICarUxRestrictionsManager";
            }

            @Override  // android.car.drivingstate.ICarUxRestrictionsManager
            public void registerUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener listener) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.drivingstate.ICarUxRestrictionsManager");
                    parcel0.writeStrongBinder((listener == null ? null : listener.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.drivingstate.ICarUxRestrictionsManager
            public void unregisterUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener listener) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.drivingstate.ICarUxRestrictionsManager");
                    parcel0.writeStrongBinder((listener == null ? null : listener.asBinder()));
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.drivingstate.ICarUxRestrictionsManager";
        static final int TRANSACTION_getCurrentUxRestrictions = 3;
        static final int TRANSACTION_registerUxRestrictionsChangeListener = 1;
        static final int TRANSACTION_unregisterUxRestrictionsChangeListener = 2;

        public Stub() {
            this.attachInterface(this, "android.car.drivingstate.ICarUxRestrictionsManager");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarUxRestrictionsManager asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.drivingstate.ICarUxRestrictionsManager");
            return iInterface0 != null && (iInterface0 instanceof ICarUxRestrictionsManager) ? ((ICarUxRestrictionsManager)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code != 0x5F4E5446) {
                switch(code) {
                    case 1: {
                        data.enforceInterface("android.car.drivingstate.ICarUxRestrictionsManager");
                        this.registerUxRestrictionsChangeListener(android.car.drivingstate.ICarUxRestrictionsChangeListener.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 2: {
                        data.enforceInterface("android.car.drivingstate.ICarUxRestrictionsManager");
                        this.unregisterUxRestrictionsChangeListener(android.car.drivingstate.ICarUxRestrictionsChangeListener.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 3: {
                        data.enforceInterface("android.car.drivingstate.ICarUxRestrictionsManager");
                        CarUxRestrictions carUxRestrictions0 = this.getCurrentUxRestrictions();
                        reply.writeNoException();
                        if(carUxRestrictions0 != null) {
                            reply.writeInt(1);
                            carUxRestrictions0.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                            return true;
                        }
                        reply.writeInt(0);
                        return true;
                    }
                    default: {
                        return super.onTransact(code, data, reply, flags);
                    }
                }
            }
            reply.writeString("android.car.drivingstate.ICarUxRestrictionsManager");
            return true;
        }
    }

    CarUxRestrictions getCurrentUxRestrictions() throws RemoteException;

    void registerUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener arg1) throws RemoteException;

    void unregisterUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener arg1) throws RemoteException;
}

