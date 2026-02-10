package com.yftech.car.oms;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOmsCallback extends IInterface {
    public static abstract class Stub extends Binder implements IOmsCallback {
        static class Proxy implements IOmsCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.oms.IOmsCallback";
            }

            @Override  // com.yftech.car.oms.IOmsCallback
            public void onDetectEnableChanged() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsCallback");
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsCallback
            public void onInfo(String json) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsCallback");
                    parcel0.writeString(json);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsCallback
            public void onSwitchChanged(boolean isStart, boolean isEnableSmoking, boolean isEnableCalling, boolean isEnableLipMoving, boolean isEnableStaticGesture, boolean isEnableDynamicGesture, boolean isEnableImageAnomaly) throws RemoteException {
                int v = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsCallback");
                    parcel0.writeInt((isStart ? 1 : 0));
                    parcel0.writeInt((isEnableSmoking ? 1 : 0));
                    parcel0.writeInt((isEnableCalling ? 1 : 0));
                    parcel0.writeInt((isEnableLipMoving ? 1 : 0));
                    parcel0.writeInt((isEnableStaticGesture ? 1 : 0));
                    parcel0.writeInt((isEnableDynamicGesture ? 1 : 0));
                    if(!isEnableImageAnomaly) {
                        v = 0;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.oms.IOmsCallback";
        static final int TRANSACTION_onDetectEnableChanged = 3;
        static final int TRANSACTION_onInfo = 1;
        static final int TRANSACTION_onSwitchChanged = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.oms.IOmsCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IOmsCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.oms.IOmsCallback");
            return iInterface0 != null && (iInterface0 instanceof IOmsCallback) ? ((IOmsCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.oms.IOmsCallback");
                    this.onInfo(data.readString());
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.oms.IOmsCallback");
                    this.onSwitchChanged(data.readInt() != 0, data.readInt() != 0, data.readInt() != 0, data.readInt() != 0, data.readInt() != 0, data.readInt() != 0, data.readInt() != 0);
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.oms.IOmsCallback");
                    this.onDetectEnableChanged();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.oms.IOmsCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onDetectEnableChanged() throws RemoteException;

    void onInfo(String arg1) throws RemoteException;

    void onSwitchChanged(boolean arg1, boolean arg2, boolean arg3, boolean arg4, boolean arg5, boolean arg6, boolean arg7) throws RemoteException;
}

