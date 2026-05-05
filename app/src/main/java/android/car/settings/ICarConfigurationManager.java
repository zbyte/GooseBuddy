package android.car.settings;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface ICarConfigurationManager extends IInterface {
    public static abstract class Stub extends Binder implements ICarConfigurationManager {
        static class Proxy implements ICarConfigurationManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.settings.ICarConfigurationManager";
            }

            @Override  // android.car.settings.ICarConfigurationManager
            public SpeedBumpConfiguration getSpeedBumpConfiguration() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.settings.ICarConfigurationManager");
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((SpeedBumpConfiguration)SpeedBumpConfiguration.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.settings.ICarConfigurationManager";
        static final int TRANSACTION_getSpeedBumpConfiguration = 1;

        public Stub() {
            this.attachInterface(this, "android.car.settings.ICarConfigurationManager");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarConfigurationManager asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.settings.ICarConfigurationManager");
            return iInterface0 != null && (iInterface0 instanceof ICarConfigurationManager) ? ((ICarConfigurationManager)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("android.car.settings.ICarConfigurationManager");
                    SpeedBumpConfiguration speedBumpConfiguration0 = this.getSpeedBumpConfiguration();
                    reply.writeNoException();
                    if(speedBumpConfiguration0 != null) {
                        reply.writeInt(1);
                        speedBumpConfiguration0.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.car.settings.ICarConfigurationManager");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    SpeedBumpConfiguration getSpeedBumpConfiguration() throws RemoteException;
}

