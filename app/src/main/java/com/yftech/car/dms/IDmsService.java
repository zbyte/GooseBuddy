package com.yftech.car.dms;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

public interface IDmsService extends IInterface {
    public static abstract class Stub extends Binder implements IDmsService {
        static class Proxy implements IDmsService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void cancelFaceRecognition() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(34, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void cancelFaceRegistration() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(33, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void cancelFaceSession(long sessionId) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    parcel0.writeLong(sessionId);
                    this.mRemote.transact(9, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void confirmFaceRegister(long faceId) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    parcel0.writeLong(faceId);
                    this.mRemote.transact(8, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void deleteAllFace() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(11, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void deleteFace(long faceId) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    parcel0.writeLong(faceId);
                    this.mRemote.transact(10, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public boolean deleteFaceData(String name) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    parcel0.writeString(name);
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

            @Override  // com.yftech.car.dms.IDmsService
            public void disable() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void disableCalling() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(41, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void disableDistraction() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(21, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void disableFaceID() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(30, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void disableFatigue() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(18, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void disableGaze() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(24, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void disableImageAnomaly() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(27, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void disableSmoking() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(39, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void enable() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void enableCalling() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(40, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void enableDistraction() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(20, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void enableFaceID() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(29, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void enableFatigue() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(17, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void enableGaze() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(23, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void enableImageAnomaly() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(26, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void enableSmoking() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(38, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public long[] getAllFaceIdList() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(12, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createLongArray();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public int getDmsErrorCode() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(37, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.dms.IDmsService";
            }

            @Override  // com.yftech.car.dms.IDmsService
            public List getRegisteredNameList() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(0x1F, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createStringArrayList();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public boolean isEnable() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
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

            @Override  // com.yftech.car.dms.IDmsService
            public boolean isEnableDistraction() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(19, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.dms.IDmsService
            public boolean isEnableFaceID() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(28, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.dms.IDmsService
            public boolean isEnableFatigue() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(16, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.dms.IDmsService
            public boolean isEnableGaze() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(22, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.dms.IDmsService
            public boolean isEnableImageAnomaly() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(25, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.dms.IDmsService
            public DmsResult processDmsImage(byte[] imageData, long timestamp) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    parcel0.writeByteArray(imageData);
                    parcel0.writeLong(timestamp);
                    this.mRemote.transact(13, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((DmsResult)DmsResult.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void processFrImage(byte[] imageData, long timestamp) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    parcel0.writeByteArray(imageData);
                    parcel0.writeLong(timestamp);
                    this.mRemote.transact(14, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void registerCallBack(IDmsCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void setAlarmOff() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(36, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void setAlarmOn() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    this.mRemote.transact(35, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public long startFaceRecognition(long timeout) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    parcel0.writeLong(timeout);
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readLong();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public long startFaceRegister(long timeout) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    parcel0.writeLong(timeout);
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readLong();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void startFaceRegistration(String name) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    parcel0.writeString(name);
                    this.mRemote.transact(15, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.dms.IDmsService
            public void unregisterCallBack(IDmsCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.dms.IDmsService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.dms.IDmsService";
        static final int TRANSACTION_cancelFaceRecognition = 34;
        static final int TRANSACTION_cancelFaceRegistration = 33;
        static final int TRANSACTION_cancelFaceSession = 9;
        static final int TRANSACTION_confirmFaceRegister = 8;
        static final int TRANSACTION_deleteAllFace = 11;
        static final int TRANSACTION_deleteFace = 10;
        static final int TRANSACTION_deleteFaceData = 0x20;
        static final int TRANSACTION_disable = 5;
        static final int TRANSACTION_disableCalling = 41;
        static final int TRANSACTION_disableDistraction = 21;
        static final int TRANSACTION_disableFaceID = 30;
        static final int TRANSACTION_disableFatigue = 18;
        static final int TRANSACTION_disableGaze = 24;
        static final int TRANSACTION_disableImageAnomaly = 27;
        static final int TRANSACTION_disableSmoking = 39;
        static final int TRANSACTION_enable = 4;
        static final int TRANSACTION_enableCalling = 40;
        static final int TRANSACTION_enableDistraction = 20;
        static final int TRANSACTION_enableFaceID = 29;
        static final int TRANSACTION_enableFatigue = 17;
        static final int TRANSACTION_enableGaze = 23;
        static final int TRANSACTION_enableImageAnomaly = 26;
        static final int TRANSACTION_enableSmoking = 38;
        static final int TRANSACTION_getAllFaceIdList = 12;
        static final int TRANSACTION_getDmsErrorCode = 37;
        static final int TRANSACTION_getRegisteredNameList = 0x1F;
        static final int TRANSACTION_isEnable = 3;
        static final int TRANSACTION_isEnableDistraction = 19;
        static final int TRANSACTION_isEnableFaceID = 28;
        static final int TRANSACTION_isEnableFatigue = 16;
        static final int TRANSACTION_isEnableGaze = 22;
        static final int TRANSACTION_isEnableImageAnomaly = 25;
        static final int TRANSACTION_processDmsImage = 13;
        static final int TRANSACTION_processFrImage = 14;
        static final int TRANSACTION_registerCallBack = 1;
        static final int TRANSACTION_setAlarmOff = 36;
        static final int TRANSACTION_setAlarmOn = 35;
        static final int TRANSACTION_startFaceRecognition = 6;
        static final int TRANSACTION_startFaceRegister = 7;
        static final int TRANSACTION_startFaceRegistration = 15;
        static final int TRANSACTION_unregisterCallBack = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.dms.IDmsService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IDmsService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.dms.IDmsService");
            return iInterface0 != null && (iInterface0 instanceof IDmsService) ? ((IDmsService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int v2 = 0;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.registerCallBack(com.yftech.car.dms.IDmsCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.unregisterCallBack(com.yftech.car.dms.IDmsCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    boolean z = this.isEnable();
                    reply.writeNoException();
                    if(z) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.enable();
                    reply.writeNoException();
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.disable();
                    reply.writeNoException();
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    long v3 = this.startFaceRecognition(data.readLong());
                    reply.writeNoException();
                    reply.writeLong(v3);
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    long v4 = this.startFaceRegister(data.readLong());
                    reply.writeNoException();
                    reply.writeLong(v4);
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.confirmFaceRegister(data.readLong());
                    reply.writeNoException();
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.cancelFaceSession(data.readLong());
                    reply.writeNoException();
                    return true;
                }
                case 10: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.deleteFace(data.readLong());
                    reply.writeNoException();
                    return true;
                }
                case 11: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.deleteAllFace();
                    reply.writeNoException();
                    return true;
                }
                case 12: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    long[] arr_v = this.getAllFaceIdList();
                    reply.writeNoException();
                    reply.writeLongArray(arr_v);
                    return true;
                }
                case 13: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    DmsResult dmsResult0 = this.processDmsImage(data.createByteArray(), data.readLong());
                    reply.writeNoException();
                    if(dmsResult0 != null) {
                        reply.writeInt(1);
                        dmsResult0.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                }
                case 14: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.processFrImage(data.createByteArray(), data.readLong());
                    reply.writeNoException();
                    return true;
                }
                case 15: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.startFaceRegistration(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 16: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    boolean z1 = this.isEnableFatigue();
                    reply.writeNoException();
                    if(z1) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 17: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.enableFatigue();
                    reply.writeNoException();
                    return true;
                }
                case 18: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.disableFatigue();
                    reply.writeNoException();
                    return true;
                }
                case 19: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    boolean z2 = this.isEnableDistraction();
                    reply.writeNoException();
                    if(z2) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 20: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.enableDistraction();
                    reply.writeNoException();
                    return true;
                }
                case 21: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.disableDistraction();
                    reply.writeNoException();
                    return true;
                }
                case 22: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    boolean z3 = this.isEnableGaze();
                    reply.writeNoException();
                    if(z3) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 23: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.enableGaze();
                    reply.writeNoException();
                    return true;
                }
                case 24: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.disableGaze();
                    reply.writeNoException();
                    return true;
                }
                case 25: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    boolean z4 = this.isEnableImageAnomaly();
                    reply.writeNoException();
                    if(z4) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 26: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.enableImageAnomaly();
                    reply.writeNoException();
                    return true;
                }
                case 27: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.disableImageAnomaly();
                    reply.writeNoException();
                    return true;
                }
                case 28: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    boolean z5 = this.isEnableFaceID();
                    reply.writeNoException();
                    if(z5) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 29: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.enableFaceID();
                    reply.writeNoException();
                    return true;
                }
                case 30: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.disableFaceID();
                    reply.writeNoException();
                    return true;
                }
                case 0x1F: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    List list0 = this.getRegisteredNameList();
                    reply.writeNoException();
                    reply.writeStringList(list0);
                    return true;
                }
                case 0x20: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    boolean z6 = this.deleteFaceData(data.readString());
                    reply.writeNoException();
                    if(z6) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 33: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.cancelFaceRegistration();
                    reply.writeNoException();
                    return true;
                }
                case 34: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.cancelFaceRecognition();
                    reply.writeNoException();
                    return true;
                }
                case 35: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.setAlarmOn();
                    reply.writeNoException();
                    return true;
                }
                case 36: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.setAlarmOff();
                    reply.writeNoException();
                    return true;
                }
                case 37: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    int v5 = this.getDmsErrorCode();
                    reply.writeNoException();
                    reply.writeInt(v5);
                    return true;
                }
                case 38: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.enableSmoking();
                    reply.writeNoException();
                    return true;
                }
                case 39: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.disableSmoking();
                    reply.writeNoException();
                    return true;
                }
                case 40: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.enableCalling();
                    reply.writeNoException();
                    return true;
                }
                case 41: {
                    data.enforceInterface("com.yftech.car.dms.IDmsService");
                    this.disableCalling();
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.dms.IDmsService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void cancelFaceRecognition() throws RemoteException;

    void cancelFaceRegistration() throws RemoteException;

    void cancelFaceSession(long arg1) throws RemoteException;

    void confirmFaceRegister(long arg1) throws RemoteException;

    void deleteAllFace() throws RemoteException;

    void deleteFace(long arg1) throws RemoteException;

    boolean deleteFaceData(String arg1) throws RemoteException;

    void disable() throws RemoteException;

    void disableCalling() throws RemoteException;

    void disableDistraction() throws RemoteException;

    void disableFaceID() throws RemoteException;

    void disableFatigue() throws RemoteException;

    void disableGaze() throws RemoteException;

    void disableImageAnomaly() throws RemoteException;

    void disableSmoking() throws RemoteException;

    void enable() throws RemoteException;

    void enableCalling() throws RemoteException;

    void enableDistraction() throws RemoteException;

    void enableFaceID() throws RemoteException;

    void enableFatigue() throws RemoteException;

    void enableGaze() throws RemoteException;

    void enableImageAnomaly() throws RemoteException;

    void enableSmoking() throws RemoteException;

    long[] getAllFaceIdList() throws RemoteException;

    int getDmsErrorCode() throws RemoteException;

    List getRegisteredNameList() throws RemoteException;

    boolean isEnable() throws RemoteException;

    boolean isEnableDistraction() throws RemoteException;

    boolean isEnableFaceID() throws RemoteException;

    boolean isEnableFatigue() throws RemoteException;

    boolean isEnableGaze() throws RemoteException;

    boolean isEnableImageAnomaly() throws RemoteException;

    DmsResult processDmsImage(byte[] arg1, long arg2) throws RemoteException;

    void processFrImage(byte[] arg1, long arg2) throws RemoteException;

    void registerCallBack(IDmsCallback arg1) throws RemoteException;

    void setAlarmOff() throws RemoteException;

    void setAlarmOn() throws RemoteException;

    long startFaceRecognition(long arg1) throws RemoteException;

    long startFaceRegister(long arg1) throws RemoteException;

    void startFaceRegistration(String arg1) throws RemoteException;

    void unregisterCallBack(IDmsCallback arg1) throws RemoteException;
}

