package android.car.hardware.power;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarPowerStateListener extends IInterface {
    public static abstract class Stub extends Binder implements ICarPowerStateListener {
        static class Proxy implements ICarPowerStateListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.hardware.power.ICarPowerStateListener";
            }

            @Override  // android.car.hardware.power.ICarPowerStateListener
            public void onStateChanged(int state, int token) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.power.ICarPowerStateListener");
                    parcel0.writeInt(state);
                    parcel0.writeInt(token);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.hardware.power.ICarPowerStateListener";
        static final int TRANSACTION_onStateChanged = 1;

        public Stub() {
            this.attachInterface(this, "android.car.hardware.power.ICarPowerStateListener");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarPowerStateListener asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.hardware.power.ICarPowerStateListener");
            return iInterface0 != null && (iInterface0 instanceof ICarPowerStateListener) ? ((ICarPowerStateListener)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("android.car.hardware.power.ICarPowerStateListener");
                    this.onStateChanged(data.readInt(), data.readInt());
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.car.hardware.power.ICarPowerStateListener");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onStateChanged(int arg1, int arg2) throws RemoteException;
}

