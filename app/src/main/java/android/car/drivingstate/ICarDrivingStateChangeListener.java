package android.car.drivingstate;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarDrivingStateChangeListener extends IInterface {
    public static abstract class Stub extends Binder implements ICarDrivingStateChangeListener {
        static class Proxy implements ICarDrivingStateChangeListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.drivingstate.ICarDrivingStateChangeListener";
            }

            @Override  // android.car.drivingstate.ICarDrivingStateChangeListener
            public void onDrivingStateChanged(CarDrivingStateEvent event) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.drivingstate.ICarDrivingStateChangeListener");
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

        private static final String DESCRIPTOR = "android.car.drivingstate.ICarDrivingStateChangeListener";
        static final int TRANSACTION_onDrivingStateChanged = 1;

        public Stub() {
            this.attachInterface(this, "android.car.drivingstate.ICarDrivingStateChangeListener");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarDrivingStateChangeListener asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.drivingstate.ICarDrivingStateChangeListener");
            return iInterface0 != null && (iInterface0 instanceof ICarDrivingStateChangeListener) ? ((ICarDrivingStateChangeListener)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("android.car.drivingstate.ICarDrivingStateChangeListener");
                    this.onDrivingStateChanged((data.readInt() == 0 ? null : ((CarDrivingStateEvent)CarDrivingStateEvent.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.car.drivingstate.ICarDrivingStateChangeListener");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onDrivingStateChanged(CarDrivingStateEvent arg1) throws RemoteException;
}

