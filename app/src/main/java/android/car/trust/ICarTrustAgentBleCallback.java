package android.car.trust;

import android.bluetooth.BluetoothDevice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarTrustAgentBleCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarTrustAgentBleCallback {
        static class Proxy implements ICarTrustAgentBleCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.car.trust.ICarTrustAgentBleCallback";
            }

            @Override  // android.car.trust.ICarTrustAgentBleCallback
            public void onBleDeviceConnected(BluetoothDevice device) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleCallback");
                    if(device == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        device.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleCallback
            public void onBleDeviceDisconnected(BluetoothDevice device) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleCallback");
                    if(device == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        device.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleCallback
            public void onBleServerStartFailure(int errorCode) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleCallback");
                    parcel0.writeInt(errorCode);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.car.trust.ICarTrustAgentBleCallback
            public void onBleServerStartSuccess() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.car.trust.ICarTrustAgentBleCallback");
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.car.trust.ICarTrustAgentBleCallback";
        static final int TRANSACTION_onBleDeviceConnected = 3;
        static final int TRANSACTION_onBleDeviceDisconnected = 4;
        static final int TRANSACTION_onBleServerStartFailure = 2;
        static final int TRANSACTION_onBleServerStartSuccess = 1;

        public Stub() {
            this.attachInterface(this, "android.car.trust.ICarTrustAgentBleCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarTrustAgentBleCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.car.trust.ICarTrustAgentBleCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarTrustAgentBleCallback) ? ((ICarTrustAgentBleCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code != 0x5F4E5446) {
                BluetoothDevice _arg0 = null;
                switch(code) {
                    case 1: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleCallback");
                        this.onBleServerStartSuccess();
                        return true;
                    }
                    case 2: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleCallback");
                        this.onBleServerStartFailure(data.readInt());
                        return true;
                    }
                    case 3: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleCallback");
                        if(data.readInt() != 0) {
                            _arg0 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(data);
                        }
                        this.onBleDeviceConnected(_arg0);
                        return true;
                    }
                    case 4: {
                        data.enforceInterface("android.car.trust.ICarTrustAgentBleCallback");
                        if(data.readInt() != 0) {
                            _arg0 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(data);
                        }
                        this.onBleDeviceDisconnected(_arg0);
                        return true;
                    }
                    default: {
                        return super.onTransact(code, data, reply, flags);
                    }
                }
            }
            reply.writeString("android.car.trust.ICarTrustAgentBleCallback");
            return true;
        }
    }

    void onBleDeviceConnected(BluetoothDevice arg1) throws RemoteException;

    void onBleDeviceDisconnected(BluetoothDevice arg1) throws RemoteException;

    void onBleServerStartFailure(int arg1) throws RemoteException;

    void onBleServerStartSuccess() throws RemoteException;
}

