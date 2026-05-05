package android.car.trust;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarTrustAgentTokenRequestDelegate extends IInterface {
    public static abstract class Stub extends Binder implements ICarTrustAgentTokenRequestDelegate {
        static class Proxy implements ICarTrustAgentTokenRequestDelegate {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.car.trust.ICarTrustAgentTokenRequestDelegate
            public void addEscrowToken(byte[] token, int uid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenRequestDelegate");
                    parcel0.writeByteArray(token);
                    parcel0.writeInt(uid);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
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

            public String getInterfaceDescriptor() {
                return "android.car.trust.ICarTrustAgentTokenRequestDelegate";
            }

            @Override  // android.car.trust.ICarTrustAgentTokenRequestDelegate
            public void isEscrowTokenActive(long handle, int uid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenRequestDelegate");
                    parcel0.writeLong(handle);
                    parcel0.writeInt(uid);
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentTokenRequestDelegate
            public void removeEscrowToken(long handle, int uid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenRequestDelegate");
                    parcel0.writeLong(handle);
                    parcel0.writeInt(uid);
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentTokenRequestDelegate
            public void revokeTrust() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenRequestDelegate");
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.trust.ICarTrustAgentTokenRequestDelegate";
        static final int TRANSACTION_addEscrowToken = 2;
        static final int TRANSACTION_isEscrowTokenActive = 4;
        static final int TRANSACTION_removeEscrowToken = 3;
        static final int TRANSACTION_revokeTrust = 1;

        public Stub() {
            this.attachInterface(this, "android.car.trust.ICarTrustAgentTokenRequestDelegate");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarTrustAgentTokenRequestDelegate asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.trust.ICarTrustAgentTokenRequestDelegate");
            return iInterface0 != null && (iInterface0 instanceof ICarTrustAgentTokenRequestDelegate) ? ((ICarTrustAgentTokenRequestDelegate)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code != 0x5F4E5446) {
                switch(code) {
                    case 1: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentTokenRequestDelegate");
                        this.revokeTrust();
                        reply.writeNoException();
                        return true;
                    }
                    case 2: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentTokenRequestDelegate");
                        this.addEscrowToken(data.createByteArray(), data.readInt());
                        reply.writeNoException();
                        return true;
                    }
                    case 3: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentTokenRequestDelegate");
                        this.removeEscrowToken(data.readLong(), data.readInt());
                        reply.writeNoException();
                        return true;
                    }
                    case 4: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentTokenRequestDelegate");
                        this.isEscrowTokenActive(data.readLong(), data.readInt());
                        reply.writeNoException();
                        return true;
                    }
                    default: {
                        return super.onTransact(code, data, reply, flags);
                    }
                }
            }
            reply.writeString("android.car.trust.ICarTrustAgentTokenRequestDelegate");
            return true;
        }
    }

    void addEscrowToken(byte[] arg1, int arg2) throws RemoteException;

    void isEscrowTokenActive(long arg1, int arg2) throws RemoteException;

    void removeEscrowToken(long arg1, int arg2) throws RemoteException;

    void revokeTrust() throws RemoteException;
}

