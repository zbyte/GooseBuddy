package com.yftech.car.oms;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface IOmsService extends IInterface {
    public static abstract class Stub extends Binder implements IOmsService {
        static class Proxy implements IOmsService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // com.yftech.car.oms.IOmsService
            public boolean deleteFaceData(String name) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    parcel0.writeString(name);
                    this.mRemote.transact(8, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.oms.IOmsService
            public void disableCalling() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(16, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void disableDetectChildElder() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(46, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void disableDistraction() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(34, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void disableDynamicGesture() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(25, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void disableFaceId() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(49, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void disableFatigue() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(0x1F, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void disableForgottenItem() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(43, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void disableForgotternChild() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(40, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void disableGaze() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(37, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void disableImageAnomaly() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(28, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void disableLipMoving() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(19, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void disableSmoking() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(13, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void disableStaticGesture() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(22, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void enableCalling() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(15, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void enableDetectChildElder() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(45, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void enableDistraction() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(33, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void enableDynamicGesture() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(24, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void enableFaceId() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(0x30, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void enableFatigue() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(30, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void enableForgottenItem() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(42, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void enableForgotternChild() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(39, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void enableGaze() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(36, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void enableImageAnomaly() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(27, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void enableLipMoving() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(18, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void enableSmoking() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(12, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void enableStaticGesture() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(21, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.oms.IOmsService";
            }

            @Override  // com.yftech.car.oms.IOmsService
            public List getRegisteredNameList() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(9, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createStringArrayList();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public String getVersion() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(0x2F, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public boolean isEnableCalling() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(14, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.oms.IOmsService
            public boolean isEnableDetectChildElder() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
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

            @Override  // com.yftech.car.oms.IOmsService
            public boolean isEnableDistraction() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(0x20, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.oms.IOmsService
            public boolean isEnableDynamicGesture() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(23, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.oms.IOmsService
            public boolean isEnableFaceId() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
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

            @Override  // com.yftech.car.oms.IOmsService
            public boolean isEnableFatigue() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(29, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.oms.IOmsService
            public boolean isEnableForgottenItem() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
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

            @Override  // com.yftech.car.oms.IOmsService
            public boolean isEnableForgotternChild() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
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

            @Override  // com.yftech.car.oms.IOmsService
            public boolean isEnableGaze() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(35, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.oms.IOmsService
            public boolean isEnableImageAnomaly() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(26, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.oms.IOmsService
            public boolean isEnableLipMoving() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(17, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.oms.IOmsService
            public boolean isEnableSmoking() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(11, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.oms.IOmsService
            public boolean isEnableStaticGesture() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
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

            @Override  // com.yftech.car.oms.IOmsService
            public boolean isStart() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(3, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.oms.IOmsService
            public void registerCallback(IOmsCallback callBack) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    parcel0.writeStrongBinder((callBack == null ? null : callBack.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void setImage(byte[] buff, int width, int height) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    parcel0.writeByteArray(buff);
                    parcel0.writeInt(width);
                    parcel0.writeInt(height);
                    this.mRemote.transact(10, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public boolean start() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(4, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.oms.IOmsService
            public void startFaceRecognition() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public void startFaceRegistration(String name) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    parcel0.writeString(name);
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.oms.IOmsService
            public boolean stop() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    this.mRemote.transact(5, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.oms.IOmsService
            public void unregisterCallback(IOmsCallback callBack) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.oms.IOmsService");
                    parcel0.writeStrongBinder((callBack == null ? null : callBack.asBinder()));
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.oms.IOmsService";
        static final int TRANSACTION_deleteFaceData = 8;
        static final int TRANSACTION_disableCalling = 16;
        static final int TRANSACTION_disableDetectChildElder = 46;
        static final int TRANSACTION_disableDistraction = 34;
        static final int TRANSACTION_disableDynamicGesture = 25;
        static final int TRANSACTION_disableFaceId = 49;
        static final int TRANSACTION_disableFatigue = 0x1F;
        static final int TRANSACTION_disableForgottenItem = 43;
        static final int TRANSACTION_disableForgotternChild = 40;
        static final int TRANSACTION_disableGaze = 37;
        static final int TRANSACTION_disableImageAnomaly = 28;
        static final int TRANSACTION_disableLipMoving = 19;
        static final int TRANSACTION_disableSmoking = 13;
        static final int TRANSACTION_disableStaticGesture = 22;
        static final int TRANSACTION_enableCalling = 15;
        static final int TRANSACTION_enableDetectChildElder = 45;
        static final int TRANSACTION_enableDistraction = 33;
        static final int TRANSACTION_enableDynamicGesture = 24;
        static final int TRANSACTION_enableFaceId = 0x30;
        static final int TRANSACTION_enableFatigue = 30;
        static final int TRANSACTION_enableForgottenItem = 42;
        static final int TRANSACTION_enableForgotternChild = 39;
        static final int TRANSACTION_enableGaze = 36;
        static final int TRANSACTION_enableImageAnomaly = 27;
        static final int TRANSACTION_enableLipMoving = 18;
        static final int TRANSACTION_enableSmoking = 12;
        static final int TRANSACTION_enableStaticGesture = 21;
        static final int TRANSACTION_getRegisteredNameList = 9;
        static final int TRANSACTION_getVersion = 0x2F;
        static final int TRANSACTION_isEnableCalling = 14;
        static final int TRANSACTION_isEnableDetectChildElder = 44;
        static final int TRANSACTION_isEnableDistraction = 0x20;
        static final int TRANSACTION_isEnableDynamicGesture = 23;
        static final int TRANSACTION_isEnableFaceId = 50;
        static final int TRANSACTION_isEnableFatigue = 29;
        static final int TRANSACTION_isEnableForgottenItem = 41;
        static final int TRANSACTION_isEnableForgotternChild = 38;
        static final int TRANSACTION_isEnableGaze = 35;
        static final int TRANSACTION_isEnableImageAnomaly = 26;
        static final int TRANSACTION_isEnableLipMoving = 17;
        static final int TRANSACTION_isEnableSmoking = 11;
        static final int TRANSACTION_isEnableStaticGesture = 20;
        static final int TRANSACTION_isStart = 3;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_setImage = 10;
        static final int TRANSACTION_start = 4;
        static final int TRANSACTION_startFaceRecognition = 7;
        static final int TRANSACTION_startFaceRegistration = 6;
        static final int TRANSACTION_stop = 5;
        static final int TRANSACTION_unregisterCallback = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.oms.IOmsService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IOmsService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.oms.IOmsService");
            return iInterface0 != null && (iInterface0 instanceof IOmsService) ? ((IOmsService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int v2 = 0;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.registerCallback(com.yftech.car.oms.IOmsCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.unregisterCallback(com.yftech.car.oms.IOmsCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z = this.isStart();
                    reply.writeNoException();
                    if(z) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z1 = this.start();
                    reply.writeNoException();
                    if(z1) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z2 = this.stop();
                    reply.writeNoException();
                    if(z2) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.startFaceRegistration(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.startFaceRecognition();
                    reply.writeNoException();
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z3 = this.deleteFaceData(data.readString());
                    reply.writeNoException();
                    if(z3) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    List list0 = this.getRegisteredNameList();
                    reply.writeNoException();
                    reply.writeStringList(list0);
                    return true;
                }
                case 10: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.setImage(data.createByteArray(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 11: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z4 = this.isEnableSmoking();
                    reply.writeNoException();
                    if(z4) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 12: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.enableSmoking();
                    reply.writeNoException();
                    return true;
                }
                case 13: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.disableSmoking();
                    reply.writeNoException();
                    return true;
                }
                case 14: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z5 = this.isEnableCalling();
                    reply.writeNoException();
                    if(z5) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 15: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.enableCalling();
                    reply.writeNoException();
                    return true;
                }
                case 16: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.disableCalling();
                    reply.writeNoException();
                    return true;
                }
                case 17: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z6 = this.isEnableLipMoving();
                    reply.writeNoException();
                    if(z6) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 18: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.enableLipMoving();
                    reply.writeNoException();
                    return true;
                }
                case 19: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.disableLipMoving();
                    reply.writeNoException();
                    return true;
                }
                case 20: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z7 = this.isEnableStaticGesture();
                    reply.writeNoException();
                    if(z7) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 21: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.enableStaticGesture();
                    reply.writeNoException();
                    return true;
                }
                case 22: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.disableStaticGesture();
                    reply.writeNoException();
                    return true;
                }
                case 23: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z8 = this.isEnableDynamicGesture();
                    reply.writeNoException();
                    if(z8) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 24: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.enableDynamicGesture();
                    reply.writeNoException();
                    return true;
                }
                case 25: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.disableDynamicGesture();
                    reply.writeNoException();
                    return true;
                }
                case 26: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z9 = this.isEnableImageAnomaly();
                    reply.writeNoException();
                    if(z9) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 27: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.enableImageAnomaly();
                    reply.writeNoException();
                    return true;
                }
                case 28: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.disableImageAnomaly();
                    reply.writeNoException();
                    return true;
                }
                case 29: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z10 = this.isEnableFatigue();
                    reply.writeNoException();
                    if(z10) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 30: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.enableFatigue();
                    reply.writeNoException();
                    return true;
                }
                case 0x1F: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.disableFatigue();
                    reply.writeNoException();
                    return true;
                }
                case 0x20: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z11 = this.isEnableDistraction();
                    reply.writeNoException();
                    if(z11) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 33: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.enableDistraction();
                    reply.writeNoException();
                    return true;
                }
                case 34: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.disableDistraction();
                    reply.writeNoException();
                    return true;
                }
                case 35: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z12 = this.isEnableGaze();
                    reply.writeNoException();
                    if(z12) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 36: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.enableGaze();
                    reply.writeNoException();
                    return true;
                }
                case 37: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.disableGaze();
                    reply.writeNoException();
                    return true;
                }
                case 38: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z13 = this.isEnableForgotternChild();
                    reply.writeNoException();
                    if(z13) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 39: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.enableForgotternChild();
                    reply.writeNoException();
                    return true;
                }
                case 40: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.disableForgotternChild();
                    reply.writeNoException();
                    return true;
                }
                case 41: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z14 = this.isEnableForgottenItem();
                    reply.writeNoException();
                    if(z14) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 42: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.enableForgottenItem();
                    reply.writeNoException();
                    return true;
                }
                case 43: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.disableForgottenItem();
                    reply.writeNoException();
                    return true;
                }
                case 44: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z15 = this.isEnableDetectChildElder();
                    reply.writeNoException();
                    if(z15) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 45: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.enableDetectChildElder();
                    reply.writeNoException();
                    return true;
                }
                case 46: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.disableDetectChildElder();
                    reply.writeNoException();
                    return true;
                }
                case 0x2F: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    String s = this.getVersion();
                    reply.writeNoException();
                    reply.writeString(s);
                    return true;
                }
                case 0x30: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.enableFaceId();
                    reply.writeNoException();
                    return true;
                }
                case 49: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    this.disableFaceId();
                    reply.writeNoException();
                    return true;
                }
                case 50: {
                    data.enforceInterface("com.yftech.car.oms.IOmsService");
                    boolean z16 = this.isEnableFaceId();
                    reply.writeNoException();
                    if(z16) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.oms.IOmsService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    boolean deleteFaceData(String arg1) throws RemoteException;

    void disableCalling() throws RemoteException;

    void disableDetectChildElder() throws RemoteException;

    void disableDistraction() throws RemoteException;

    void disableDynamicGesture() throws RemoteException;

    void disableFaceId() throws RemoteException;

    void disableFatigue() throws RemoteException;

    void disableForgottenItem() throws RemoteException;

    void disableForgotternChild() throws RemoteException;

    void disableGaze() throws RemoteException;

    void disableImageAnomaly() throws RemoteException;

    void disableLipMoving() throws RemoteException;

    void disableSmoking() throws RemoteException;

    void disableStaticGesture() throws RemoteException;

    void enableCalling() throws RemoteException;

    void enableDetectChildElder() throws RemoteException;

    void enableDistraction() throws RemoteException;

    void enableDynamicGesture() throws RemoteException;

    void enableFaceId() throws RemoteException;

    void enableFatigue() throws RemoteException;

    void enableForgottenItem() throws RemoteException;

    void enableForgotternChild() throws RemoteException;

    void enableGaze() throws RemoteException;

    void enableImageAnomaly() throws RemoteException;

    void enableLipMoving() throws RemoteException;

    void enableSmoking() throws RemoteException;

    void enableStaticGesture() throws RemoteException;

    List getRegisteredNameList() throws RemoteException;

    String getVersion() throws RemoteException;

    boolean isEnableCalling() throws RemoteException;

    boolean isEnableDetectChildElder() throws RemoteException;

    boolean isEnableDistraction() throws RemoteException;

    boolean isEnableDynamicGesture() throws RemoteException;

    boolean isEnableFaceId() throws RemoteException;

    boolean isEnableFatigue() throws RemoteException;

    boolean isEnableForgottenItem() throws RemoteException;

    boolean isEnableForgotternChild() throws RemoteException;

    boolean isEnableGaze() throws RemoteException;

    boolean isEnableImageAnomaly() throws RemoteException;

    boolean isEnableLipMoving() throws RemoteException;

    boolean isEnableSmoking() throws RemoteException;

    boolean isEnableStaticGesture() throws RemoteException;

    boolean isStart() throws RemoteException;

    void registerCallback(IOmsCallback arg1) throws RemoteException;

    void setImage(byte[] arg1, int arg2, int arg3) throws RemoteException;

    boolean start() throws RemoteException;

    void startFaceRecognition() throws RemoteException;

    void startFaceRegistration(String arg1) throws RemoteException;

    boolean stop() throws RemoteException;

    void unregisterCallback(IOmsCallback arg1) throws RemoteException;
}

