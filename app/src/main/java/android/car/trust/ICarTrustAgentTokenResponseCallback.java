package android.car.trust;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarTrustAgentTokenResponseCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarTrustAgentTokenResponseCallback {
        static class Proxy implements ICarTrustAgentTokenResponseCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.trust.ICarTrustAgentTokenResponseCallback";
            }

            @Override  // android.car.trust.ICarTrustAgentTokenResponseCallback
            public void onEscrowTokenActiveStateChanged(long handle, boolean active) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenResponseCallback");
                    parcel0.writeLong(handle);
                    parcel0.writeInt((active?1:0));
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentTokenResponseCallback
            public void onEscrowTokenAdded(byte[] token, long handle, int uid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenResponseCallback");
                    if(token == null) {
                        parcel0.writeInt(-1);
                    }
                    else {
                        parcel0.writeInt(token.length);
                    }
                    parcel0.writeLong(handle);
                    parcel0.writeInt(uid);
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                    parcel1.readByteArray(token);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentTokenResponseCallback
            public void onEscrowTokenRemoved(long handle, boolean successful) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenResponseCallback");
                    parcel0.writeLong(handle);
                    parcel0.writeInt((successful?1:0));
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.trust.ICarTrustAgentTokenResponseCallback";
        static final int TRANSACTION_onEscrowTokenActiveStateChanged = 3;
        static final int TRANSACTION_onEscrowTokenAdded = 1;
        static final int TRANSACTION_onEscrowTokenRemoved = 2;

        public Stub() {
            this.attachInterface(this, "android.car.trust.ICarTrustAgentTokenResponseCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarTrustAgentTokenResponseCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.trust.ICarTrustAgentTokenResponseCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarTrustAgentTokenResponseCallback) ? ((ICarTrustAgentTokenResponseCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code != 0x5F4E5446) {
                boolean z = false;
                switch(code) {
                    case 1: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentTokenResponseCallback");
                        int v2 = data.readInt();
                        byte[] _arg0 = v2 >= 0 ? new byte[v2] : null;
                        this.onEscrowTokenAdded(_arg0, data.readLong(), data.readInt());
                        reply.writeNoException();
                        reply.writeByteArray(_arg0);
                        return true;
                    }
                    case 2: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentTokenResponseCallback");
                        long v3 = data.readLong();
                        if(data.readInt() != 0) {
                            z = true;
                        }
                        this.onEscrowTokenRemoved(v3, z);
                        reply.writeNoException();
                        return true;
                    }
                    case 3: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentTokenResponseCallback");
                        long v4 = data.readLong();
                        if(data.readInt() != 0) {
                            z = true;
                        }
                        this.onEscrowTokenActiveStateChanged(v4, z);
                        reply.writeNoException();
                        return true;
                    }
                    default: {
                        return super.onTransact(code, data, reply, flags);
                    }
                }
            }
            reply.writeString("android.car.trust.ICarTrustAgentTokenResponseCallback");
            return true;
        }
    }

    void onEscrowTokenActiveStateChanged(long arg1, boolean arg2) throws RemoteException;

    void onEscrowTokenAdded(byte[] arg1, long arg2, int arg3) throws RemoteException;

    void onEscrowTokenRemoved(long arg1, boolean arg2) throws RemoteException;
}

