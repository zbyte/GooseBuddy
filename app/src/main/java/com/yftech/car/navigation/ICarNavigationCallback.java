package com.yftech.car.navigation;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarNavigationCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarNavigationCallback {
        static class Proxy implements ICarNavigationCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.navigation.ICarNavigationCallback";
            }

            @Override  // com.yftech.car.navigation.ICarNavigationCallback
            public void onArriveDestination() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationCallback");
                    this.mRemote.transact(7, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationCallback
            public void onDayNightChanged(int dayNightMode) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationCallback");
                    parcel0.writeInt(dayNightMode);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationCallback
            public void onManeuverChanged(CarNavigationManeuver maneuver) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationCallback");
                    if(maneuver == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        maneuver.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationCallback
            public void onQuitNavigation() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationCallback");
                    this.mRemote.transact(6, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationCallback
            public void onRoadConditionChanged(boolean isOpen) throws RemoteException {
                int v = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationCallback");
                    if(!isOpen) {
                        v = 0;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationCallback
            public void onServiceStart() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationCallback");
                    this.mRemote.transact(8, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationCallback
            public void onServiceStop() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationCallback");
                    this.mRemote.transact(9, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationCallback
            public void onStartNavigation() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationCallback");
                    this.mRemote.transact(5, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.navigation.ICarNavigationCallback
            public void onVoiceChanged(boolean isOpen) throws RemoteException {
                int v = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.navigation.ICarNavigationCallback");
                    if(!isOpen) {
                        v = 0;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.navigation.ICarNavigationCallback";
        static final int TRANSACTION_onArriveDestination = 7;
        static final int TRANSACTION_onDayNightChanged = 2;
        static final int TRANSACTION_onManeuverChanged = 1;
        static final int TRANSACTION_onQuitNavigation = 6;
        static final int TRANSACTION_onRoadConditionChanged = 3;
        static final int TRANSACTION_onServiceStart = 8;
        static final int TRANSACTION_onServiceStop = 9;
        static final int TRANSACTION_onStartNavigation = 5;
        static final int TRANSACTION_onVoiceChanged = 4;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.navigation.ICarNavigationCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarNavigationCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.navigation.ICarNavigationCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarNavigationCallback) ? ((ICarNavigationCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean _arg0 = false;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationCallback");
                    this.onManeuverChanged((data.readInt() == 0 ? null : ((CarNavigationManeuver)CarNavigationManeuver.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationCallback");
                    this.onDayNightChanged(data.readInt());
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationCallback");
                    if(data.readInt() != 0) {
                        _arg0 = true;
                    }
                    this.onRoadConditionChanged(_arg0);
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationCallback");
                    if(data.readInt() != 0) {
                        _arg0 = true;
                    }
                    this.onVoiceChanged(_arg0);
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationCallback");
                    this.onStartNavigation();
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationCallback");
                    this.onQuitNavigation();
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationCallback");
                    this.onArriveDestination();
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationCallback");
                    this.onServiceStart();
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.navigation.ICarNavigationCallback");
                    this.onServiceStop();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.navigation.ICarNavigationCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onArriveDestination() throws RemoteException;

    void onDayNightChanged(int arg1) throws RemoteException;

    void onManeuverChanged(CarNavigationManeuver arg1) throws RemoteException;

    void onQuitNavigation() throws RemoteException;

    void onRoadConditionChanged(boolean arg1) throws RemoteException;

    void onServiceStart() throws RemoteException;

    void onServiceStop() throws RemoteException;

    void onStartNavigation() throws RemoteException;

    void onVoiceChanged(boolean arg1) throws RemoteException;
}

