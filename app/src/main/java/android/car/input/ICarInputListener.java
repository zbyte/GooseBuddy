package android.car.input;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.KeyEvent;

public interface ICarInputListener extends IInterface {
    public static abstract class Stub extends Binder implements ICarInputListener {
        static class Proxy implements ICarInputListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.input.ICarInputListener";
            }

            @Override  // android.car.input.ICarInputListener
            public void onKeyEvent(KeyEvent keyEvent, int targetDisplay) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.input.ICarInputListener");
                    if(keyEvent == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        keyEvent.writeToParcel(parcel0, 0);
                    }
                    parcel0.writeInt(targetDisplay);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.input.ICarInputListener";
        static final int TRANSACTION_onKeyEvent = 2;

        public Stub() {
            this.attachInterface(this, "android.car.input.ICarInputListener");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarInputListener asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.input.ICarInputListener");
            return iInterface0 != null && (iInterface0 instanceof ICarInputListener) ? ((ICarInputListener)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 2: {
                    data.enforceInterface("android.car.input.ICarInputListener");
                    this.onKeyEvent((data.readInt() == 0 ? null : ((KeyEvent)KeyEvent.CREATOR.createFromParcel(data))), data.readInt());
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.car.input.ICarInputListener");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onKeyEvent(KeyEvent arg1, int arg2) throws RemoteException;
}

