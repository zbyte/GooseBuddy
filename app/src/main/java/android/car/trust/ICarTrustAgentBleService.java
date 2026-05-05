package android.car.trust;

import android.bluetooth.BluetoothDevice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarTrustAgentBleService extends IInterface {
    public static abstract class Stub extends Binder implements ICarTrustAgentBleService {
        static class Proxy implements ICarTrustAgentBleService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void addEscrowToken(byte[] token, int uid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    parcel0.writeByteArray(token);
                    parcel0.writeInt(uid);
                    this.mRemote.transact(14, parcel0, parcel1, 0);
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
                return "android.car.trust.ICarTrustAgentBleService";
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void isEscrowTokenActive(long handle, int uid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    parcel0.writeLong(handle);
                    parcel0.writeInt(uid);
                    this.mRemote.transact(16, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void onEscrowTokenActiveStateChanged(long handle, boolean active) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    parcel0.writeLong(handle);
                    parcel0.writeInt((active?1:0));
                    this.mRemote.transact(20, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void onEscrowTokenAdded(byte[] token, long handle, int uid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    parcel0.writeByteArray(token);
                    parcel0.writeLong(handle);
                    parcel0.writeInt(uid);
                    this.mRemote.transact(18, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void onEscrowTokenRemoved(long handle, boolean successful) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    parcel0.writeLong(handle);
                    parcel0.writeInt((successful?1:0));
                    this.mRemote.transact(19, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void registerBleCallback(ICarTrustAgentBleCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void registerEnrolmentCallback(ICarTrustAgentEnrolmentCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void registerUnlockCallback(ICarTrustAgentUnlockCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(10, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void removeEscrowToken(long handle, int uid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    parcel0.writeLong(handle);
                    parcel0.writeInt(uid);
                    this.mRemote.transact(15, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void revokeTrust() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    this.mRemote.transact(13, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void sendEnrolmentHandle(BluetoothDevice device, long handle) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    if(device == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        device.writeToParcel(parcel0, 0);
                    }
                    parcel0.writeLong(handle);
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void setTokenRequestDelegate(ICarTrustAgentTokenRequestDelegate delegate) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    parcel0.writeStrongBinder((delegate == null ? null : delegate.asBinder()));
                    this.mRemote.transact(12, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void setTokenResponseCallback(ICarTrustAgentTokenResponseCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(17, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void startEnrolmentAdvertising() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void startUnlockAdvertising() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    this.mRemote.transact(8, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void stopEnrolmentAdvertising() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void stopUnlockAdvertising() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    this.mRemote.transact(9, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void unregisterBleCallback(ICarTrustAgentBleCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void unregisterEnrolmentCallback(ICarTrustAgentEnrolmentCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleService
            public void unregisterUnlockCallback(ICarTrustAgentUnlockCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(11, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.trust.ICarTrustAgentBleService";
        static final int TRANSACTION_addEscrowToken = 14;
        static final int TRANSACTION_isEscrowTokenActive = 16;
        static final int TRANSACTION_onEscrowTokenActiveStateChanged = 20;
        static final int TRANSACTION_onEscrowTokenAdded = 18;
        static final int TRANSACTION_onEscrowTokenRemoved = 19;
        static final int TRANSACTION_registerBleCallback = 1;
        static final int TRANSACTION_registerEnrolmentCallback = 6;
        static final int TRANSACTION_registerUnlockCallback = 10;
        static final int TRANSACTION_removeEscrowToken = 15;
        static final int TRANSACTION_revokeTrust = 13;
        static final int TRANSACTION_sendEnrolmentHandle = 5;
        static final int TRANSACTION_setTokenRequestDelegate = 12;
        static final int TRANSACTION_setTokenResponseCallback = 17;
        static final int TRANSACTION_startEnrolmentAdvertising = 3;
        static final int TRANSACTION_startUnlockAdvertising = 8;
        static final int TRANSACTION_stopEnrolmentAdvertising = 4;
        static final int TRANSACTION_stopUnlockAdvertising = 9;
        static final int TRANSACTION_unregisterBleCallback = 2;
        static final int TRANSACTION_unregisterEnrolmentCallback = 7;
        static final int TRANSACTION_unregisterUnlockCallback = 11;

        public Stub() {
            this.attachInterface(this, "android.car.trust.ICarTrustAgentBleService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarTrustAgentBleService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.trust.ICarTrustAgentBleService");
            return iInterface0 != null && (iInterface0 instanceof ICarTrustAgentBleService) ? ((ICarTrustAgentBleService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code != 0x5F4E5446) {
                boolean z = false;
                switch(code) {
                    case 1: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.registerBleCallback(android.car.trust.ICarTrustAgentBleCallback.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 2: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.unregisterBleCallback(android.car.trust.ICarTrustAgentBleCallback.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 3: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.startEnrolmentAdvertising();
                        reply.writeNoException();
                        return true;
                    }
                    case 4: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.stopEnrolmentAdvertising();
                        reply.writeNoException();
                        return true;
                    }
                    case 5: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.sendEnrolmentHandle((data.readInt() == 0 ? null : ((BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(data))), data.readLong());
                        reply.writeNoException();
                        return true;
                    }
                    case 6: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.registerEnrolmentCallback(android.car.trust.ICarTrustAgentEnrolmentCallback.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 7: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.unregisterEnrolmentCallback(android.car.trust.ICarTrustAgentEnrolmentCallback.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 8: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.startUnlockAdvertising();
                        reply.writeNoException();
                        return true;
                    }
                    case 9: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.stopUnlockAdvertising();
                        reply.writeNoException();
                        return true;
                    }
                    case 10: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.registerUnlockCallback(android.car.trust.ICarTrustAgentUnlockCallback.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 11: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.unregisterUnlockCallback(android.car.trust.ICarTrustAgentUnlockCallback.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 12: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.setTokenRequestDelegate(android.car.trust.ICarTrustAgentTokenRequestDelegate.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 13: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.revokeTrust();
                        reply.writeNoException();
                        return true;
                    }
                    case 14: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.addEscrowToken(data.createByteArray(), data.readInt());
                        reply.writeNoException();
                        return true;
                    }
                    case 15: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.removeEscrowToken(data.readLong(), data.readInt());
                        reply.writeNoException();
                        return true;
                    }
                    case 16: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.isEscrowTokenActive(data.readLong(), data.readInt());
                        reply.writeNoException();
                        return true;
                    }
                    case 17: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.setTokenResponseCallback(android.car.trust.ICarTrustAgentTokenResponseCallback.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    }
                    case 18: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        this.onEscrowTokenAdded(data.createByteArray(), data.readLong(), data.readInt());
                        reply.writeNoException();
                        return true;
                    }
                    case 19: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        long v2 = data.readLong();
                        if(data.readInt() != 0) {
                            z = true;
                        }
                        this.onEscrowTokenRemoved(v2, z);
                        reply.writeNoException();
                        return true;
                    }
                    case 20: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleService");
                        long v3 = data.readLong();
                        if(data.readInt() != 0) {
                            z = true;
                        }
                        this.onEscrowTokenActiveStateChanged(v3, z);
                        reply.writeNoException();
                        return true;
                    }
                    default: {
                        return super.onTransact(code, data, reply, flags);
                    }
                }
            }
            reply.writeString("android.car.trust.ICarTrustAgentBleService");
            return true;
        }
    }

    void addEscrowToken(byte[] arg1, int arg2) throws RemoteException;

    void isEscrowTokenActive(long arg1, int arg2) throws RemoteException;

    void onEscrowTokenActiveStateChanged(long arg1, boolean arg2) throws RemoteException;

    void onEscrowTokenAdded(byte[] arg1, long arg2, int arg3) throws RemoteException;

    void onEscrowTokenRemoved(long arg1, boolean arg2) throws RemoteException;

    void registerBleCallback(ICarTrustAgentBleCallback arg1) throws RemoteException;

    void registerEnrolmentCallback(ICarTrustAgentEnrolmentCallback arg1) throws RemoteException;

    void registerUnlockCallback(ICarTrustAgentUnlockCallback arg1) throws RemoteException;

    void removeEscrowToken(long arg1, int arg2) throws RemoteException;

    void revokeTrust() throws RemoteException;

    void sendEnrolmentHandle(BluetoothDevice arg1, long arg2) throws RemoteException;

    void setTokenRequestDelegate(ICarTrustAgentTokenRequestDelegate arg1) throws RemoteException;

    void setTokenResponseCallback(ICarTrustAgentTokenResponseCallback arg1) throws RemoteException;

    void startEnrolmentAdvertising() throws RemoteException;

    void startUnlockAdvertising() throws RemoteException;

    void stopEnrolmentAdvertising() throws RemoteException;

    void stopUnlockAdvertising() throws RemoteException;

    void unregisterBleCallback(ICarTrustAgentBleCallback arg1) throws RemoteException;

    void unregisterEnrolmentCallback(ICarTrustAgentEnrolmentCallback arg1) throws RemoteException;

    void unregisterUnlockCallback(ICarTrustAgentUnlockCallback arg1) throws RemoteException;
}

