package com.yftech.car.phonelink;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface ICarPhoneLinkService extends IInterface {
    public static abstract class Stub extends Binder implements ICarPhoneLinkService {
        static class Proxy implements ICarPhoneLinkService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void accpetPhone() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
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

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void confirmFirstConnect(String address) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(address);
                    this.mRemote.transact(39, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void connectByUsb(String type) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(type);
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void connectByWireless(String type) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(type);
                    this.mRemote.transact(8, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void connectCarLinkDevice(CarLinkDevice device) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    if(device == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        device.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(28, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void connetCarplayByAddress(String address) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(address);
                    this.mRemote.transact(34, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void disConnect(String type) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(type);
                    this.mRemote.transact(9, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void disConnectByAddress(String address) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(address);
                    this.mRemote.transact(43, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void disConnectCarLinkDevice(String type, CarLinkDevice device) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(type);
                    if(device == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        device.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(59, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void disablePhoneLink() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(19, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void enablePhoneLink() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(18, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void forgetCarLinkDevice(CarLinkDevice device) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    if(device == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        device.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(29, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public String getAndroidPriorityLink() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(24, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public List getAvailableCarLinkDeviceList(String type) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(type);
                    this.mRemote.transact(35, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createTypedArrayList(CarLinkDevice.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public List getBondedCarLinkDeviceList(String type) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(type);
                    this.mRemote.transact(52, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createTypedArrayList(CarLinkDevice.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public int getCallStatus() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(12, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public CarLinkDevice getCarLinkDeviceByBlueToothAddress(String address) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(address);
                    this.mRemote.transact(53, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((CarLinkDevice)CarLinkDevice.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public List getCarLinkDeviceList(String type) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(type);
                    this.mRemote.transact(27, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createTypedArrayList(CarLinkDevice.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public CarLinkDevice getConnectedCarLinkDevice(String type) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(type);
                    this.mRemote.transact(36, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((CarLinkDevice)CarLinkDevice.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public String getConnectedLinkStatus() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public PhoneLink getConnectedPhoneLink() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((PhoneLink)PhoneLink.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public String getIOSPriorityLink() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(25, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.phonelink.ICarPhoneLinkService";
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public int getMobilePhoneLowBattery() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(56, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public String getPhoneName() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(0x1F, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public List getSupportPhoneLinks() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createTypedArrayList(PhoneLink.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public int getVRStatus() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(17, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public boolean hadBeenConnected(String type) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(type);
                    this.mRemote.transact(49, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        _result = true;
                    }
                    return _result;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public boolean isBlueToothDeviceConnected(String address) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(address);
                    this.mRemote.transact(51, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        _result = true;
                    }
                    return _result;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public boolean isCarplayCertificate() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(38, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        _result = true;
                    }
                    return _result;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public boolean isForeground() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(44, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        _result = true;
                    }
                    return _result;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public boolean isMicWork() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(45, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        _result = true;
                    }
                    return _result;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public boolean isPhoneLinkEnable() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(20, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        _result = true;
                    }
                    return _result;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public boolean isSupportAndroidAuto(String address) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(address);
                    this.mRemote.transact(50, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        _result = true;
                    }
                    return _result;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void pickAndroidPriorityLink(String type) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(type);
                    this.mRemote.transact(21, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void pickCarLifeWhenHuaWei() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(10, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void pickHiCarWhenHuaWei() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(11, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void pickIOSPriorityLink(String type) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(type);
                    this.mRemote.transact(22, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void reConnectPreDevice(String type) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(type);
                    this.mRemote.transact(0x30, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void registerCarPhoneLinkCallback(ICarPhoneLinkCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void rejectPhone() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(15, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void requestCarPlaySiri(int action) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeInt(action);
                    this.mRemote.transact(0x20, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public boolean requestNewConnect() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(42, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        _result = true;
                    }
                    return _result;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public boolean requestReConnect(String address) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(address);
                    this.mRemote.transact(41, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        _result = true;
                    }
                    return _result;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public boolean requestShowFirstConnectDialog(String address) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(address);
                    this.mRemote.transact(57, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        _result = true;
                    }
                    return _result;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public boolean requestShowTheFirstConnectDialog(String phonelink, String address) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(phonelink);
                    parcel0.writeString(address);
                    this.mRemote.transact(58, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        _result = true;
                    }
                    return _result;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void sendLongPressKeyEvent(int keyEvent) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeInt(keyEvent);
                    this.mRemote.transact(55, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void sendShortPressKeyEvent(int keyEvent) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeInt(keyEvent);
                    this.mRemote.transact(54, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void startCallPage() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(13, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void startDiscovery() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(46, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public String startPage(int pageType) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeInt(pageType);
                    this.mRemote.transact(26, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void startPriorityLinkAction() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(23, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void startVR() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(16, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void stopDiscovery() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(0x2F, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public boolean supportWireless() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(40, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        _result = true;
                    }
                    return _result;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void tel(String phone) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeString(phone);
                    this.mRemote.transact(37, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void unregisterCarPhoneLinkCallback(ICarPhoneLinkCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void updateCarPlayMedia(int action) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeInt(action);
                    this.mRemote.transact(30, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public void updateCarPlayTelehony(int action) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    parcel0.writeInt(action);
                    this.mRemote.transact(33, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.phonelink.ICarPhoneLinkService
            public int version() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.phonelink.ICarPhoneLinkService";
        static final int TRANSACTION_accpetPhone = 14;
        static final int TRANSACTION_confirmFirstConnect = 39;
        static final int TRANSACTION_connectByUsb = 7;
        static final int TRANSACTION_connectByWireless = 8;
        static final int TRANSACTION_connectCarLinkDevice = 28;
        static final int TRANSACTION_connetCarplayByAddress = 34;
        static final int TRANSACTION_disConnect = 9;
        static final int TRANSACTION_disConnectByAddress = 43;
        static final int TRANSACTION_disConnectCarLinkDevice = 59;
        static final int TRANSACTION_disablePhoneLink = 19;
        static final int TRANSACTION_enablePhoneLink = 18;
        static final int TRANSACTION_forgetCarLinkDevice = 29;
        static final int TRANSACTION_getAndroidPriorityLink = 24;
        static final int TRANSACTION_getAvailableCarLinkDeviceList = 35;
        static final int TRANSACTION_getBondedCarLinkDeviceList = 52;
        static final int TRANSACTION_getCallStatus = 12;
        static final int TRANSACTION_getCarLinkDeviceByBlueToothAddress = 53;
        static final int TRANSACTION_getCarLinkDeviceList = 27;
        static final int TRANSACTION_getConnectedCarLinkDevice = 36;
        static final int TRANSACTION_getConnectedLinkStatus = 6;
        static final int TRANSACTION_getConnectedPhoneLink = 5;
        static final int TRANSACTION_getIOSPriorityLink = 25;
        static final int TRANSACTION_getMobilePhoneLowBattery = 56;
        static final int TRANSACTION_getPhoneName = 0x1F;
        static final int TRANSACTION_getSupportPhoneLinks = 3;
        static final int TRANSACTION_getVRStatus = 17;
        static final int TRANSACTION_hadBeenConnected = 49;
        static final int TRANSACTION_isBlueToothDeviceConnected = 51;
        static final int TRANSACTION_isCarplayCertificate = 38;
        static final int TRANSACTION_isForeground = 44;
        static final int TRANSACTION_isMicWork = 45;
        static final int TRANSACTION_isPhoneLinkEnable = 20;
        static final int TRANSACTION_isSupportAndroidAuto = 50;
        static final int TRANSACTION_pickAndroidPriorityLink = 21;
        static final int TRANSACTION_pickCarLifeWhenHuaWei = 10;
        static final int TRANSACTION_pickHiCarWhenHuaWei = 11;
        static final int TRANSACTION_pickIOSPriorityLink = 22;
        static final int TRANSACTION_reConnectPreDevice = 0x30;
        static final int TRANSACTION_registerCarPhoneLinkCallback = 1;
        static final int TRANSACTION_rejectPhone = 15;
        static final int TRANSACTION_requestCarPlaySiri = 0x20;
        static final int TRANSACTION_requestNewConnect = 42;
        static final int TRANSACTION_requestReConnect = 41;
        static final int TRANSACTION_requestShowFirstConnectDialog = 57;
        static final int TRANSACTION_requestShowTheFirstConnectDialog = 58;
        static final int TRANSACTION_sendLongPressKeyEvent = 55;
        static final int TRANSACTION_sendShortPressKeyEvent = 54;
        static final int TRANSACTION_startCallPage = 13;
        static final int TRANSACTION_startDiscovery = 46;
        static final int TRANSACTION_startPage = 26;
        static final int TRANSACTION_startPriorityLinkAction = 23;
        static final int TRANSACTION_startVR = 16;
        static final int TRANSACTION_stopDiscovery = 0x2F;
        static final int TRANSACTION_supportWireless = 40;
        static final int TRANSACTION_tel = 37;
        static final int TRANSACTION_unregisterCarPhoneLinkCallback = 2;
        static final int TRANSACTION_updateCarPlayMedia = 30;
        static final int TRANSACTION_updateCarPlayTelehony = 33;
        static final int TRANSACTION_version = 4;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.phonelink.ICarPhoneLinkService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarPhoneLinkService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
            return iInterface0 != null && (iInterface0 instanceof ICarPhoneLinkService) ? ((ICarPhoneLinkService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int v2 = 0;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.registerCarPhoneLinkCallback(com.yftech.car.phonelink.ICarPhoneLinkCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.unregisterCarPhoneLinkCallback(com.yftech.car.phonelink.ICarPhoneLinkCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    List list0 = this.getSupportPhoneLinks();
                    reply.writeNoException();
                    reply.writeTypedList(list0);
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    int v3 = this.version();
                    reply.writeNoException();
                    reply.writeInt(v3);
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    PhoneLink phoneLink0 = this.getConnectedPhoneLink();
                    reply.writeNoException();
                    if(phoneLink0 != null) {
                        reply.writeInt(1);
                        phoneLink0.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    String s = this.getConnectedLinkStatus();
                    reply.writeNoException();
                    reply.writeString(s);
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.connectByUsb(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.connectByWireless(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.disConnect(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 10: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.pickCarLifeWhenHuaWei();
                    reply.writeNoException();
                    return true;
                }
                case 11: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.pickHiCarWhenHuaWei();
                    reply.writeNoException();
                    return true;
                }
                case 12: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    int v4 = this.getCallStatus();
                    reply.writeNoException();
                    reply.writeInt(v4);
                    return true;
                }
                case 13: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.startCallPage();
                    reply.writeNoException();
                    return true;
                }
                case 14: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.accpetPhone();
                    reply.writeNoException();
                    return true;
                }
                case 15: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.rejectPhone();
                    reply.writeNoException();
                    return true;
                }
                case 16: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.startVR();
                    reply.writeNoException();
                    return true;
                }
                case 17: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    int v5 = this.getVRStatus();
                    reply.writeNoException();
                    reply.writeInt(v5);
                    return true;
                }
                case 18: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.enablePhoneLink();
                    reply.writeNoException();
                    return true;
                }
                case 19: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.disablePhoneLink();
                    reply.writeNoException();
                    return true;
                }
                case 20: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    boolean z = this.isPhoneLinkEnable();
                    reply.writeNoException();
                    if(z) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 21: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.pickAndroidPriorityLink(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 22: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.pickIOSPriorityLink(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 23: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.startPriorityLinkAction();
                    reply.writeNoException();
                    return true;
                }
                case 24: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    String s1 = this.getAndroidPriorityLink();
                    reply.writeNoException();
                    reply.writeString(s1);
                    return true;
                }
                case 25: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    String s2 = this.getIOSPriorityLink();
                    reply.writeNoException();
                    reply.writeString(s2);
                    return true;
                }
                case 26: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    String s3 = this.startPage(data.readInt());
                    reply.writeNoException();
                    reply.writeString(s3);
                    return true;
                }
                case 27: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    List list1 = this.getCarLinkDeviceList(data.readString());
                    reply.writeNoException();
                    reply.writeTypedList(list1);
                    return true;
                }
                case 28: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.connectCarLinkDevice((data.readInt() == 0 ? null : ((CarLinkDevice)CarLinkDevice.CREATOR.createFromParcel(data))));
                    reply.writeNoException();
                    return true;
                }
                case 29: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.forgetCarLinkDevice((data.readInt() == 0 ? null : ((CarLinkDevice)CarLinkDevice.CREATOR.createFromParcel(data))));
                    reply.writeNoException();
                    return true;
                }
                case 30: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.updateCarPlayMedia(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 0x1F: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    String s4 = this.getPhoneName();
                    reply.writeNoException();
                    reply.writeString(s4);
                    return true;
                }
                case 0x20: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.requestCarPlaySiri(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 33: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.updateCarPlayTelehony(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 34: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.connetCarplayByAddress(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 35: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    List list2 = this.getAvailableCarLinkDeviceList(data.readString());
                    reply.writeNoException();
                    reply.writeTypedList(list2);
                    return true;
                }
                case 36: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    CarLinkDevice carLinkDevice0 = this.getConnectedCarLinkDevice(data.readString());
                    reply.writeNoException();
                    if(carLinkDevice0 != null) {
                        reply.writeInt(1);
                        carLinkDevice0.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                }
                case 37: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.tel(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 38: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    boolean z1 = this.isCarplayCertificate();
                    reply.writeNoException();
                    if(z1) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 39: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.confirmFirstConnect(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 40: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    boolean z2 = this.supportWireless();
                    reply.writeNoException();
                    if(z2) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 41: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    boolean z3 = this.requestReConnect(data.readString());
                    reply.writeNoException();
                    if(z3) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 42: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    boolean z4 = this.requestNewConnect();
                    reply.writeNoException();
                    if(z4) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 43: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.disConnectByAddress(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 44: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    boolean z5 = this.isForeground();
                    reply.writeNoException();
                    if(z5) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 45: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    boolean z6 = this.isMicWork();
                    reply.writeNoException();
                    if(z6) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 46: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.startDiscovery();
                    return true;
                }
                case 0x2F: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.stopDiscovery();
                    return true;
                }
                case 0x30: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.reConnectPreDevice(data.readString());
                    return true;
                }
                case 49: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    boolean z7 = this.hadBeenConnected(data.readString());
                    reply.writeNoException();
                    if(z7) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 50: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    boolean z8 = this.isSupportAndroidAuto(data.readString());
                    reply.writeNoException();
                    if(z8) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 51: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    boolean z9 = this.isBlueToothDeviceConnected(data.readString());
                    reply.writeNoException();
                    if(z9) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 52: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    List list3 = this.getBondedCarLinkDeviceList(data.readString());
                    reply.writeNoException();
                    reply.writeTypedList(list3);
                    return true;
                }
                case 53: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    CarLinkDevice carLinkDevice1 = this.getCarLinkDeviceByBlueToothAddress(data.readString());
                    reply.writeNoException();
                    if(carLinkDevice1 != null) {
                        reply.writeInt(1);
                        carLinkDevice1.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                }
                case 54: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.sendShortPressKeyEvent(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 55: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.sendLongPressKeyEvent(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 56: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    int v6 = this.getMobilePhoneLowBattery();
                    reply.writeNoException();
                    reply.writeInt(v6);
                    return true;
                }
                case 57: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    boolean z10 = this.requestShowFirstConnectDialog(data.readString());
                    reply.writeNoException();
                    if(z10) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 58: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    boolean z11 = this.requestShowTheFirstConnectDialog(data.readString(), data.readString());
                    reply.writeNoException();
                    if(z11) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 59: {
                    data.enforceInterface("com.yftech.car.phonelink.ICarPhoneLinkService");
                    this.disConnectCarLinkDevice(data.readString(), (data.readInt() == 0 ? null : ((CarLinkDevice)CarLinkDevice.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.phonelink.ICarPhoneLinkService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void accpetPhone() throws RemoteException;

    void confirmFirstConnect(String arg1) throws RemoteException;

    void connectByUsb(String arg1) throws RemoteException;

    void connectByWireless(String arg1) throws RemoteException;

    void connectCarLinkDevice(CarLinkDevice arg1) throws RemoteException;

    void connetCarplayByAddress(String arg1) throws RemoteException;

    void disConnect(String arg1) throws RemoteException;

    void disConnectByAddress(String arg1) throws RemoteException;

    void disConnectCarLinkDevice(String arg1, CarLinkDevice arg2) throws RemoteException;

    void disablePhoneLink() throws RemoteException;

    void enablePhoneLink() throws RemoteException;

    void forgetCarLinkDevice(CarLinkDevice arg1) throws RemoteException;

    String getAndroidPriorityLink() throws RemoteException;

    List getAvailableCarLinkDeviceList(String arg1) throws RemoteException;

    List getBondedCarLinkDeviceList(String arg1) throws RemoteException;

    int getCallStatus() throws RemoteException;

    CarLinkDevice getCarLinkDeviceByBlueToothAddress(String arg1) throws RemoteException;

    List getCarLinkDeviceList(String arg1) throws RemoteException;

    CarLinkDevice getConnectedCarLinkDevice(String arg1) throws RemoteException;

    String getConnectedLinkStatus() throws RemoteException;

    PhoneLink getConnectedPhoneLink() throws RemoteException;

    String getIOSPriorityLink() throws RemoteException;

    int getMobilePhoneLowBattery() throws RemoteException;

    String getPhoneName() throws RemoteException;

    List getSupportPhoneLinks() throws RemoteException;

    int getVRStatus() throws RemoteException;

    boolean hadBeenConnected(String arg1) throws RemoteException;

    boolean isBlueToothDeviceConnected(String arg1) throws RemoteException;

    boolean isCarplayCertificate() throws RemoteException;

    boolean isForeground() throws RemoteException;

    boolean isMicWork() throws RemoteException;

    boolean isPhoneLinkEnable() throws RemoteException;

    boolean isSupportAndroidAuto(String arg1) throws RemoteException;

    void pickAndroidPriorityLink(String arg1) throws RemoteException;

    void pickCarLifeWhenHuaWei() throws RemoteException;

    void pickHiCarWhenHuaWei() throws RemoteException;

    void pickIOSPriorityLink(String arg1) throws RemoteException;

    void reConnectPreDevice(String arg1) throws RemoteException;

    void registerCarPhoneLinkCallback(ICarPhoneLinkCallback arg1) throws RemoteException;

    void rejectPhone() throws RemoteException;

    void requestCarPlaySiri(int arg1) throws RemoteException;

    boolean requestNewConnect() throws RemoteException;

    boolean requestReConnect(String arg1) throws RemoteException;

    boolean requestShowFirstConnectDialog(String arg1) throws RemoteException;

    boolean requestShowTheFirstConnectDialog(String arg1, String arg2) throws RemoteException;

    void sendLongPressKeyEvent(int arg1) throws RemoteException;

    void sendShortPressKeyEvent(int arg1) throws RemoteException;

    void startCallPage() throws RemoteException;

    void startDiscovery() throws RemoteException;

    String startPage(int arg1) throws RemoteException;

    void startPriorityLinkAction() throws RemoteException;

    void startVR() throws RemoteException;

    void stopDiscovery() throws RemoteException;

    boolean supportWireless() throws RemoteException;

    void tel(String arg1) throws RemoteException;

    void unregisterCarPhoneLinkCallback(ICarPhoneLinkCallback arg1) throws RemoteException;

    void updateCarPlayMedia(int arg1) throws RemoteException;

    void updateCarPlayTelehony(int arg1) throws RemoteException;

    int version() throws RemoteException;
}

