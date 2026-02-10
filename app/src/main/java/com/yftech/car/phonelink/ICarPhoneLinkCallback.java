package com.yftech.car.phonelink;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface ICarPhoneLinkCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarPhoneLinkCallback {
        static class Proxy implements ICarPhoneLinkCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.phonelink.ICarPhoneLinkCallback";
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onAndroidPriorityPhoneLinkChanged(String type) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    parcel0.writeString(type);
                    this.mRemote.transact(7, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onCallStatusChanged(int status) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    parcel0.writeInt(status);
                    this.mRemote.transact(5, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onCarLinkDeviceListChanged(String type, List list0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    parcel0.writeString(type);
                    parcel0.writeTypedList(list0);
                    this.mRemote.transact(9, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onConnectedFail(String type, int reason) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    parcel0.writeString(type);
                    parcel0.writeInt(reason);
                    this.mRemote.transact(10, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onConnectedFailWithDevice(String type, int reason, CarLinkDevice device) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    parcel0.writeString(type);
                    parcel0.writeInt(reason);
                    if(device == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        device.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(11, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onConnectedStatusChanged(String status) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    parcel0.writeString(status);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onDeviceChanged(PhoneLink link) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    if(link == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        link.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onForegroundChanged(boolean isForeground) throws RemoteException {
                int v = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    if(!isForeground) {
                        v = 0;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(15, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onHicarReConnectStateChange(boolean isReconnect, String deviceName) throws RemoteException {
                int v = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    if(!isReconnect) {
                        v = 0;
                    }
                    parcel0.writeInt(v);
                    parcel0.writeString(deviceName);
                    this.mRemote.transact(13, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onIOSPriorityPhoneLinkChanged(String type) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    parcel0.writeString(type);
                    this.mRemote.transact(8, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onMicStatusChanged(boolean isWork) throws RemoteException {
                int v = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    if(!isWork) {
                        v = 0;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(16, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onMobilePhoneLowBattery(int batteryLevel) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    parcel0.writeInt(batteryLevel);
                    this.mRemote.transact(17, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onPhoneLinkEnableChanged(boolean isEnable) throws RemoteException {
                int v = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    if(!isEnable) {
                        v = 0;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(6, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onSecondDeviceAvailable(CarLinkDevice device) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    if(device == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        device.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(14, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onShowCarplayConfirmFirstConnectDialog(CarLinkDevice device) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    if(device == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        device.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(12, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onShowHuaWeiConnectedDialog() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkCallback
            public void onVRStatusChanged(int status) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    parcel0.writeInt(status);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.phonelink.ICarPhoneLinkCallback";
        static final int TRANSACTION_onAndroidPriorityPhoneLinkChanged = 7;
        static final int TRANSACTION_onCallStatusChanged = 5;
        static final int TRANSACTION_onCarLinkDeviceListChanged = 9;
        static final int TRANSACTION_onConnectedFail = 10;
        static final int TRANSACTION_onConnectedFailWithDevice = 11;
        static final int TRANSACTION_onConnectedStatusChanged = 2;
        static final int TRANSACTION_onDeviceChanged = 1;
        static final int TRANSACTION_onForegroundChanged = 15;
        static final int TRANSACTION_onHicarReConnectStateChange = 13;
        static final int TRANSACTION_onIOSPriorityPhoneLinkChanged = 8;
        static final int TRANSACTION_onMicStatusChanged = 16;
        static final int TRANSACTION_onMobilePhoneLowBattery = 17;
        static final int TRANSACTION_onPhoneLinkEnableChanged = 6;
        static final int TRANSACTION_onSecondDeviceAvailable = 14;
        static final int TRANSACTION_onShowCarplayConfirmFirstConnectDialog = 12;
        static final int TRANSACTION_onShowHuaWeiConnectedDialog = 3;
        static final int TRANSACTION_onVRStatusChanged = 4;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.phonelink.ICarPhoneLinkCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarPhoneLinkCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarPhoneLinkCallback) ? ((ICarPhoneLinkCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean _arg0 = false;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    this.onDeviceChanged((data.readInt() == 0 ? null : ((PhoneLink)PhoneLink.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    this.onConnectedStatusChanged(data.readString());
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    this.onShowHuaWeiConnectedDialog();
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    this.onVRStatusChanged(data.readInt());
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    this.onCallStatusChanged(data.readInt());
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    if(data.readInt() != 0) {
                        _arg0 = true;
                    }
                    this.onPhoneLinkEnableChanged(_arg0);
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    this.onAndroidPriorityPhoneLinkChanged(data.readString());
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    this.onIOSPriorityPhoneLinkChanged(data.readString());
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    this.onCarLinkDeviceListChanged(data.readString(), data.createTypedArrayList(CarLinkDevice.CREATOR));
                    return true;
                }
                case 10: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    this.onConnectedFail(data.readString(), data.readInt());
                    return true;
                }
                case 11: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    this.onConnectedFailWithDevice(data.readString(), data.readInt(), (data.readInt() == 0 ? null : ((CarLinkDevice)CarLinkDevice.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 12: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    this.onShowCarplayConfirmFirstConnectDialog((data.readInt() == 0 ? null : ((CarLinkDevice)CarLinkDevice.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 13: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    if(data.readInt() != 0) {
                        _arg0 = true;
                    }
                    this.onHicarReConnectStateChange(_arg0, data.readString());
                    return true;
                }
                case 14: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    this.onSecondDeviceAvailable((data.readInt() == 0 ? null : ((CarLinkDevice)CarLinkDevice.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 15: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    if(data.readInt() != 0) {
                        _arg0 = true;
                    }
                    this.onForegroundChanged(_arg0);
                    return true;
                }
                case 16: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    if(data.readInt() != 0) {
                        _arg0 = true;
                    }
                    this.onMicStatusChanged(_arg0);
                    return true;
                }
                case 17: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    this.onMobilePhoneLowBattery(data.readInt());
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.phonelink.ICarPhoneLinkCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onAndroidPriorityPhoneLinkChanged(String arg1) throws RemoteException;

    void onCallStatusChanged(int arg1) throws RemoteException;

    void onCarLinkDeviceListChanged(String arg1, List arg2) throws RemoteException;

    void onConnectedFail(String arg1, int arg2) throws RemoteException;

    void onConnectedFailWithDevice(String arg1, int arg2, CarLinkDevice arg3) throws RemoteException;

    void onConnectedStatusChanged(String arg1) throws RemoteException;

    void onDeviceChanged(PhoneLink arg1) throws RemoteException;

    void onForegroundChanged(boolean arg1) throws RemoteException;

    void onHicarReConnectStateChange(boolean arg1, String arg2) throws RemoteException;

    void onIOSPriorityPhoneLinkChanged(String arg1) throws RemoteException;

    void onMicStatusChanged(boolean arg1) throws RemoteException;

    void onMobilePhoneLowBattery(int arg1) throws RemoteException;

    void onPhoneLinkEnableChanged(boolean arg1) throws RemoteException;

    void onSecondDeviceAvailable(CarLinkDevice arg1) throws RemoteException;

    void onShowCarplayConfirmFirstConnectDialog(CarLinkDevice arg1) throws RemoteException;

    void onShowHuaWeiConnectedDialog() throws RemoteException;

    void onVRStatusChanged(int arg1) throws RemoteException;
}

