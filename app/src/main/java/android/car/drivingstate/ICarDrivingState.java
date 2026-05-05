package android.car.drivingstate;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface ICarDrivingState extends IInterface {
    public static abstract class Stub extends Binder implements ICarDrivingState {
        static class Proxy implements ICarDrivingState {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // android.car.drivingstate.ICarDrivingState
            public CarDrivingStateEvent getCurrentDrivingState() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.drivingstate.ICarDrivingState");
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((CarDrivingStateEvent)CarDrivingStateEvent.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "android.car.drivingstate.ICarDrivingState";
            }

            @Override  // android.car.drivingstate.ICarDrivingState
            public void registerDrivingStateChangeListener(ICarDrivingStateChangeListener listener) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.drivingstate.ICarDrivingState");
                    parcel0.writeStrongBinder((listener == null ? null : listener.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.drivingstate.ICarDrivingState
            public void unregisterDrivingStateChangeListener(ICarDrivingStateChangeListener listener) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.drivingstate.ICarDrivingState");
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

        private static final String DESCRIPTOR = "android.car.drivingstate.ICarDrivingState";
        static final int TRANSACTION_getCurrentDrivingState = 3;
        static final int TRANSACTION_registerDrivingStateChangeListener = 1;
        static final int TRANSACTION_unregisterDrivingStateChangeListener = 2;

        public Stub() {
            this.attachInterface(this, "android.car.drivingstate.ICarDrivingState");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarDrivingState asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.drivingstate.ICarDrivingState");
            return iInterface0 != null && (iInterface0 instanceof ICarDrivingState) ? ((ICarDrivingState)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code != 0x5F4E5446) {
                switch(code) {
                    case 1: {
                        data.enforceInterface("android.car.drivingstate.ICarDrivingState");
                        this.registerDrivingStateChangeListener(android.car.drivingstate.ICarDrivingStateChangeListener.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 2: {
                        data.enforceInterface("android.car.drivingstate.ICarDrivingState");
                        this.unregisterDrivingStateChangeListener(android.car.drivingstate.ICarDrivingStateChangeListener.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 3: {
                        data.enforceInterface("android.car.drivingstate.ICarDrivingState");
                        CarDrivingStateEvent carDrivingStateEvent0 = this.getCurrentDrivingState();
                        reply.writeNoException();
                        if(carDrivingStateEvent0 != null) {
                            reply.writeInt(1);
                            carDrivingStateEvent0.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
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
            reply.writeString("android.car.drivingstate.ICarDrivingState");
            return true;
        }
    }

    CarDrivingStateEvent getCurrentDrivingState() throws RemoteException;

    void registerDrivingStateChangeListener(ICarDrivingStateChangeListener arg1) throws RemoteException;

    void unregisterDrivingStateChangeListener(ICarDrivingStateChangeListener arg1) throws RemoteException;
}

