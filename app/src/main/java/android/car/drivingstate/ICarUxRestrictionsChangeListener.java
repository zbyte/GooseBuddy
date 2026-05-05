package android.car.drivingstate;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarUxRestrictionsChangeListener extends IInterface {
    public static abstract class Stub extends Binder implements ICarUxRestrictionsChangeListener {
        static class Proxy implements ICarUxRestrictionsChangeListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.drivingstate.ICarUxRestrictionsChangeListener";
            }

            @Override  // android.car.drivingstate.ICarUxRestrictionsChangeListener
            public void onUxRestrictionsChanged(CarUxRestrictions event) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.drivingstate.ICarUxRestrictionsChangeListener");
                    if(event == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        event.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.drivingstate.ICarUxRestrictionsChangeListener";
        static final int TRANSACTION_onUxRestrictionsChanged = 1;

        public Stub() {
            this.attachInterface(this, "android.car.drivingstate.ICarUxRestrictionsChangeListener");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarUxRestrictionsChangeListener asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.drivingstate.ICarUxRestrictionsChangeListener");
            return iInterface0 != null && (iInterface0 instanceof ICarUxRestrictionsChangeListener) ? ((ICarUxRestrictionsChangeListener)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("android.car.drivingstate.ICarUxRestrictionsChangeListener");
                    this.onUxRestrictionsChanged((data.readInt() == 0 ? null : ((CarUxRestrictions)CarUxRestrictions.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.car.drivingstate.ICarUxRestrictionsChangeListener");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onUxRestrictionsChanged(CarUxRestrictions arg1) throws RemoteException;
}

