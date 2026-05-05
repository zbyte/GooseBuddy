package android.car.hardware.property;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface ICarPropertyEventListener extends IInterface {
    public static abstract class Stub extends Binder implements ICarPropertyEventListener {
        static class Proxy implements ICarPropertyEventListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.hardware.property.ICarPropertyEventListener";
            }

            @Override  // android.car.hardware.property.ICarPropertyEventListener
            public void onEvent(List list0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.property.ICarPropertyEventListener");
                    parcel0.writeTypedList(list0);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.hardware.property.ICarPropertyEventListener";
        static final int TRANSACTION_onEvent = 1;

        public Stub() {
            this.attachInterface(this, "android.car.hardware.property.ICarPropertyEventListener");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarPropertyEventListener asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.hardware.property.ICarPropertyEventListener");
            return iInterface0 != null && (iInterface0 instanceof ICarPropertyEventListener) ? ((ICarPropertyEventListener)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("android.car.hardware.property.ICarPropertyEventListener");
                    this.onEvent(data.createTypedArrayList(CarPropertyEvent.CREATOR));
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.car.hardware.property.ICarPropertyEventListener");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onEvent(List arg1) throws RemoteException;
}

