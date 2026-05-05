package android.car.hardware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface ICarSensorEventListener extends IInterface {
    public static abstract class Stub extends Binder implements ICarSensorEventListener {
        static class Proxy implements ICarSensorEventListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.hardware.ICarSensorEventListener";
            }

            @Override  // android.car.hardware.ICarSensorEventListener
            public void onSensorChanged(List list0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.ICarSensorEventListener");
                    parcel0.writeTypedList(list0);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.hardware.ICarSensorEventListener";
        static final int TRANSACTION_onSensorChanged = 1;

        public Stub() {
            this.attachInterface(this, "android.car.hardware.ICarSensorEventListener");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarSensorEventListener asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.hardware.ICarSensorEventListener");
            return iInterface0 != null && (iInterface0 instanceof ICarSensorEventListener) ? ((ICarSensorEventListener)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("android.car.hardware.ICarSensorEventListener");
                    this.onSensorChanged(data.createTypedArrayList(CarSensorEvent.CREATOR));
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.car.hardware.ICarSensorEventListener");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onSensorChanged(List arg1) throws RemoteException;
}

