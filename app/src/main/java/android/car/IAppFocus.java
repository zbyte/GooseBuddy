package android.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IAppFocus extends IInterface {
    public static abstract class Stub extends Binder implements IAppFocus {
        static class Proxy implements IAppFocus {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.car.IAppFocus
            public void abandonAppFocus(IAppFocusOwnershipCallback callback, int appType) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.IAppFocus");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    parcel0.writeInt(appType);
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // android.car.IAppFocus
            public int[] getActiveAppTypes() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.IAppFocus");
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createIntArray();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "android.car.IAppFocus";
            }

            @Override  // android.car.IAppFocus
            public boolean isOwningFocus(IAppFocusOwnershipCallback callback, int appType) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.IAppFocus");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    parcel0.writeInt(appType);
                    boolean z = false;
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        z = true;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.IAppFocus
            public void registerFocusListener(IAppFocusListener callback, int appType) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.IAppFocus");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    parcel0.writeInt(appType);
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.IAppFocus
            public int requestAppFocus(IAppFocusOwnershipCallback callback, int appType) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.IAppFocus");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    parcel0.writeInt(appType);
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.IAppFocus
            public void unregisterFocusListener(IAppFocusListener callback, int appType) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.IAppFocus");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    parcel0.writeInt(appType);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.IAppFocus";
        static final int TRANSACTION_abandonAppFocus = 6;
        static final int TRANSACTION_getActiveAppTypes = 3;
        static final int TRANSACTION_isOwningFocus = 4;
        static final int TRANSACTION_registerFocusListener = 1;
        static final int TRANSACTION_requestAppFocus = 5;
        static final int TRANSACTION_unregisterFocusListener = 2;

        public Stub() {
            this.attachInterface(this, "android.car.IAppFocus");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IAppFocus asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.IAppFocus");
            return iInterface0 != null && (iInterface0 instanceof IAppFocus) ? ((IAppFocus)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code != 0x5F4E5446) {
                switch(code) {
                    case 1: {
                        data.enforceInterface("android.car.IAppFocus");
                        this.registerFocusListener(android.car.IAppFocusListener.Stub.asInterface(data.readStrongBinder()), data.readInt());
                        reply.writeNoException();
                        return true;
                    }
                    case 2: {
                        data.enforceInterface("android.car.IAppFocus");
                        this.unregisterFocusListener(android.car.IAppFocusListener.Stub.asInterface(data.readStrongBinder()), data.readInt());
                        reply.writeNoException();
                        return true;
                    }
                    case 3: {
                        data.enforceInterface("android.car.IAppFocus");
                        int[] arr_v = this.getActiveAppTypes();
                        reply.writeNoException();
                        reply.writeIntArray(arr_v);
                        return true;
                    }
                    case 4: {
                        data.enforceInterface("android.car.IAppFocus");
                        boolean z = this.isOwningFocus(android.car.IAppFocusOwnershipCallback.Stub.asInterface(data.readStrongBinder()), data.readInt());
                        reply.writeNoException();
                        reply.writeInt(z?1:0);
                        return true;
                    }
                    case 5: {
                        data.enforceInterface("android.car.IAppFocus");
                        int v2 = this.requestAppFocus(android.car.IAppFocusOwnershipCallback.Stub.asInterface(data.readStrongBinder()), data.readInt());
                        reply.writeNoException();
                        reply.writeInt(v2);
                        return true;
                    }
                    case 6: {
                        data.enforceInterface("android.car.IAppFocus");
                        this.abandonAppFocus(android.car.IAppFocusOwnershipCallback.Stub.asInterface(data.readStrongBinder()), data.readInt());
                        reply.writeNoException();
                        return true;
                    }
                    default: {
                        return super.onTransact(code, data, reply, flags);
                    }
                }
            }
            reply.writeString("android.car.IAppFocus");
            return true;
        }
    }

    void abandonAppFocus(IAppFocusOwnershipCallback arg1, int arg2) throws RemoteException;

    int[] getActiveAppTypes() throws RemoteException;

    boolean isOwningFocus(IAppFocusOwnershipCallback arg1, int arg2) throws RemoteException;

    void registerFocusListener(IAppFocusListener arg1, int arg2) throws RemoteException;

    int requestAppFocus(IAppFocusOwnershipCallback arg1, int arg2) throws RemoteException;

    void unregisterFocusListener(IAppFocusListener arg1, int arg2) throws RemoteException;
}

