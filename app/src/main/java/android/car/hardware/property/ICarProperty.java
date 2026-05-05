package android.car.hardware.property;

import android.car.hardware.CarPropertyConfig;
import android.car.hardware.CarPropertyValue;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

public interface ICarProperty extends IInterface {
    public static abstract class Stub extends Binder implements ICarProperty {
        static class Proxy implements ICarProperty {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.hardware.property.ICarProperty";
            }

            @Override  // android.car.hardware.property.ICarProperty
            public CarPropertyValue getProperty(int prop, int zone) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.property.ICarProperty");
                    parcel0.writeInt(prop);
                    parcel0.writeInt(zone);
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((CarPropertyValue)CarPropertyValue.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.hardware.property.ICarProperty
            public List getPropertyList() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.property.ICarProperty");
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createTypedArrayList(CarPropertyConfig.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.hardware.property.ICarProperty
            public void registerListener(int propId, float rate, ICarPropertyEventListener callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.property.ICarProperty");
                    parcel0.writeInt(propId);
                    parcel0.writeFloat(rate);
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.hardware.property.ICarProperty
            public void setProperty(CarPropertyValue prop) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.property.ICarProperty");
                    if(prop == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        prop.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.hardware.property.ICarProperty
            public void unregisterListener(int propId, ICarPropertyEventListener callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.hardware.property.ICarProperty");
                    parcel0.writeInt(propId);
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.hardware.property.ICarProperty";
        static final int TRANSACTION_getProperty = 4;
        static final int TRANSACTION_getPropertyList = 3;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_setProperty = 5;
        static final int TRANSACTION_unregisterListener = 2;

        public Stub() {
            this.attachInterface(this, "android.car.hardware.property.ICarProperty");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarProperty asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.hardware.property.ICarProperty");
            return iInterface0 != null && (iInterface0 instanceof ICarProperty) ? ((ICarProperty)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code != 0x5F4E5446) {
                switch(code) {
                    case 1: {
                        data.enforceInterface("android.car.hardware.property.ICarProperty");
                        this.registerListener(data.readInt(), data.readFloat(), android.car.hardware.property.ICarPropertyEventListener.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 2: {
                        data.enforceInterface("android.car.hardware.property.ICarProperty");
                        this.unregisterListener(data.readInt(), android.car.hardware.property.ICarPropertyEventListener.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 3: {
                        data.enforceInterface("android.car.hardware.property.ICarProperty");
                        List list0 = this.getPropertyList();
                        reply.writeNoException();
                        reply.writeTypedList(list0);
                        return true;
                    }
                    case 4: {
                        data.enforceInterface("android.car.hardware.property.ICarProperty");
                        CarPropertyValue carPropertyValue0 = this.getProperty(data.readInt(), data.readInt());
                        reply.writeNoException();
                        if(carPropertyValue0 != null) {
                            reply.writeInt(1);
                            carPropertyValue0.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                            return true;
                        }
                        reply.writeInt(0);
                        return true;
                    }
                    case 5: {
                        data.enforceInterface("android.car.hardware.property.ICarProperty");
                        this.setProperty((data.readInt() == 0 ? null : ((CarPropertyValue)CarPropertyValue.CREATOR.createFromParcel(data))));
                        reply.writeNoException();
                        return true;
                    }
                    default: {
                        return super.onTransact(code, data, reply, flags);
                    }
                }
            }
            reply.writeString("android.car.hardware.property.ICarProperty");
            return true;
        }
    }

    CarPropertyValue getProperty(int arg1, int arg2) throws RemoteException;

    List getPropertyList() throws RemoteException;

    void registerListener(int arg1, float arg2, ICarPropertyEventListener arg3) throws RemoteException;

    void setProperty(CarPropertyValue arg1) throws RemoteException;

    void unregisterListener(int arg1, ICarPropertyEventListener arg2) throws RemoteException;
}

