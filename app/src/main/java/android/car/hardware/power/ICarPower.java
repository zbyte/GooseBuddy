package android.car.hardware.power;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarPower extends IInterface {
    public static abstract class Stub extends Binder implements ICarPower {
        static class Proxy implements ICarPower {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // android.car.hardware.power.ICarPower
            public void finished(ICarPowerStateListener listener, int token) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.power.ICarPower");
                    parcel0.writeStrongBinder((listener == null ? null : listener.asBinder()));
                    parcel0.writeInt(token);
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.hardware.power.ICarPower
            public int getBootReason() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.power.ICarPower");
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "android.car.hardware.power.ICarPower";
            }

            @Override  // android.car.hardware.power.ICarPower
            public void registerListener(ICarPowerStateListener listener) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.power.ICarPower");
                    parcel0.writeStrongBinder((listener == null ? null : listener.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.hardware.power.ICarPower
            public void requestShutdownOnNextSuspend() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.power.ICarPower");
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.hardware.power.ICarPower
            public void unregisterListener(ICarPowerStateListener listener) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.power.ICarPower");
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

        private static final String DESCRIPTOR = "android.car.hardware.power.ICarPower";
        static final int TRANSACTION_finished = 5;
        static final int TRANSACTION_getBootReason = 4;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_requestShutdownOnNextSuspend = 3;
        static final int TRANSACTION_unregisterListener = 2;

        public Stub() {
            this.attachInterface(this, "android.car.hardware.power.ICarPower");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarPower asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.hardware.power.ICarPower");
            return iInterface0 != null && (iInterface0 instanceof ICarPower) ? ((ICarPower)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code != 0x5F4E5446) {
                switch(code) {
                    case 1: {
                        data.enforceInterface("android.car.hardware.power.ICarPower");
                        this.registerListener(android.car.hardware.power.ICarPowerStateListener.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 2: {
                        data.enforceInterface("android.car.hardware.power.ICarPower");
                        this.unregisterListener(android.car.hardware.power.ICarPowerStateListener.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 3: {
                        data.enforceInterface("android.car.hardware.power.ICarPower");
                        this.requestShutdownOnNextSuspend();
                        reply.writeNoException();
                        return true;
                    }
                    case 4: {
                        data.enforceInterface("android.car.hardware.power.ICarPower");
                        int v2 = this.getBootReason();
                        reply.writeNoException();
                        reply.writeInt(v2);
                        return true;
                    }
                    case 5: {
                        data.enforceInterface("android.car.hardware.power.ICarPower");
                        this.finished(android.car.hardware.power.ICarPowerStateListener.Stub.asInterface(data.readStrongBinder()), data.readInt());
                        reply.writeNoException();
                        return true;
                    }
                    default: {
                        return super.onTransact(code, data, reply, flags);
                    }
                }
            }
            reply.writeString("android.car.hardware.power.ICarPower");
            return true;
        }
    }

    void finished(ICarPowerStateListener arg1, int arg2) throws RemoteException;

    int getBootReason() throws RemoteException;

    void registerListener(ICarPowerStateListener arg1) throws RemoteException;

    void requestShutdownOnNextSuspend() throws RemoteException;

    void unregisterListener(ICarPowerStateListener arg1) throws RemoteException;
}

