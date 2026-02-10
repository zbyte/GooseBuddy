package com.yftech.car.tbox;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarTBoxService extends IInterface {
    public static abstract class Stub extends Binder implements ICarTBoxService {
        static class Proxy implements ICarTBoxService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int callWithFlag(long pid, byte operatorId, String phoneNumber) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    parcel0.writeByte(operatorId);
                    parcel0.writeString(phoneNumber);
                    this.mRemote.transact(11, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int ctrlCharge(long pid, byte cmd) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    parcel0.writeByte(cmd);
                    this.mRemote.transact(21, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int getChargeParams(long pid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(20, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean getCurrentOperator(long pid) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(24, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean getCurrentSignalRSSI(long pid) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean getCurrentSignalStrength(long pid) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean getCurrentSystem(long pid) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean getFiveCodeInfo(long pid) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(33, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int getIccid(long pid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int getImei(long pid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(23, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int getImsi(long pid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.tbox.ICarTBoxService";
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int getMoney(long pid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(16, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int getMoneyNumber(long pid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(17, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int getNetOperatorList(long pid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(8, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean getNetworkStatus(long pid) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int getPublicKey(long pid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int getRadioState(long pid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(10, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean getTboxLog(long pid, String getLogPath, String saveLogPath) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    parcel0.writeString(getLogPath);
                    parcel0.writeString(saveLogPath);
                    this.mRemote.transact(13, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int getTboxRebootLog(long pid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(12, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean getTboxVersion(long pid) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean getWifiName(long pid) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(34, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean getWifiPassword(long pid) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean getWifiSwitchStatus(long pid) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int intrChargeConfig(long pid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(22, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean isConnectedTbox(long pid) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int rebootTbox(long pid) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public void registerCallback(long lKey, ICarTBoxCallback cb) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(lKey);
                    parcel0.writeStrongBinder((cb == null ? null : cb.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean requestDownLoadSpaJsonFile(long pid) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int requestUpgrade(long pid, String upgradePath) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    parcel0.writeString(upgradePath);
                    this.mRemote.transact(18, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean resetTbox(long pid) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(30, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean resetTboxNetwork(long pid) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(27, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int sendDtmf(long pid, byte dtmf) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    parcel0.writeByte(dtmf);
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int sendTsp(long pid, String data) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    parcel0.writeString(data);
                    this.mRemote.transact(15, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int setChargeParams(long pid, byte current, byte soc, byte mode, float startTime, float endTime, byte dayVaild, int[] goTime) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    parcel0.writeByte(current);
                    parcel0.writeByte(soc);
                    parcel0.writeByte(mode);
                    parcel0.writeFloat(startTime);
                    parcel0.writeFloat(endTime);
                    parcel0.writeByte(dayVaild);
                    parcel0.writeIntArray(goTime);
                    this.mRemote.transact(19, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public int setNetOperator(long pid, byte index) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    parcel0.writeByte(index);
                    this.mRemote.transact(9, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean setWifiSwitch(long pid, boolean open) throws RemoteException {
                boolean z1 = true;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    parcel0.writeInt((open ? 1 : 0));
                    this.mRemote.transact(39, parcel0, parcel1, 0);
                    parcel1.readException();
                    if(parcel1.readInt() == 0) {
                        z1 = false;
                    }
                    return z1;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean shutdownTbox(long pid) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    this.mRemote.transact(0x1F, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public void unregisterCallback(long lKey) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(lKey);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean updateWifiName(long pid, String name) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    parcel0.writeString(name);
                    this.mRemote.transact(36, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.tbox.ICarTBoxService
            public boolean updateWifiPassword(long pid, String password) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxService");
                    parcel0.writeLong(pid);
                    parcel0.writeString(password);
                    this.mRemote.transact(37, parcel0, parcel1, 0);
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
        }

        private static final String DESCRIPTOR = "com.yftech.car.tbox.ICarTBoxService";
        static final int TRANSACTION_callWithFlag = 11;
        static final int TRANSACTION_ctrlCharge = 21;
        static final int TRANSACTION_getChargeParams = 20;
        static final int TRANSACTION_getCurrentOperator = 24;
        static final int TRANSACTION_getCurrentSignalRSSI = 28;
        static final int TRANSACTION_getCurrentSignalStrength = 26;
        static final int TRANSACTION_getCurrentSystem = 25;
        static final int TRANSACTION_getFiveCodeInfo = 33;
        static final int TRANSACTION_getIccid = 7;
        static final int TRANSACTION_getImei = 23;
        static final int TRANSACTION_getImsi = 5;
        static final int TRANSACTION_getMoney = 16;
        static final int TRANSACTION_getMoneyNumber = 17;
        static final int TRANSACTION_getNetOperatorList = 8;
        static final int TRANSACTION_getNetworkStatus = 29;
        static final int TRANSACTION_getPublicKey = 6;
        static final int TRANSACTION_getRadioState = 10;
        static final int TRANSACTION_getTboxLog = 13;
        static final int TRANSACTION_getTboxRebootLog = 12;
        static final int TRANSACTION_getTboxVersion = 0x20;
        static final int TRANSACTION_getWifiName = 34;
        static final int TRANSACTION_getWifiPassword = 35;
        static final int TRANSACTION_getWifiSwitchStatus = 38;
        static final int TRANSACTION_intrChargeConfig = 22;
        static final int TRANSACTION_isConnectedTbox = 14;
        static final int TRANSACTION_rebootTbox = 4;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_requestDownLoadSpaJsonFile = 40;
        static final int TRANSACTION_requestUpgrade = 18;
        static final int TRANSACTION_resetTbox = 30;
        static final int TRANSACTION_resetTboxNetwork = 27;
        static final int TRANSACTION_sendDtmf = 3;
        static final int TRANSACTION_sendTsp = 15;
        static final int TRANSACTION_setChargeParams = 19;
        static final int TRANSACTION_setNetOperator = 9;
        static final int TRANSACTION_setWifiSwitch = 39;
        static final int TRANSACTION_shutdownTbox = 0x1F;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_updateWifiName = 36;
        static final int TRANSACTION_updateWifiPassword = 37;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.tbox.ICarTBoxService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarTBoxService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.tbox.ICarTBoxService");
            return iInterface0 != null && (iInterface0 instanceof ICarTBoxService) ? ((ICarTBoxService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    this.registerCallback(data.readLong(), com.yftech.car.tbox.ICarTBoxCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    this.unregisterCallback(data.readLong());
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v2 = this.sendDtmf(data.readLong(), data.readByte());
                    reply.writeNoException();
                    reply.writeInt(v2);
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v3 = this.rebootTbox(data.readLong());
                    reply.writeNoException();
                    reply.writeInt(v3);
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v4 = this.getImsi(data.readLong());
                    reply.writeNoException();
                    reply.writeInt(v4);
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v5 = this.getPublicKey(data.readLong());
                    reply.writeNoException();
                    reply.writeInt(v5);
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v6 = this.getIccid(data.readLong());
                    reply.writeNoException();
                    reply.writeInt(v6);
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v7 = this.getNetOperatorList(data.readLong());
                    reply.writeNoException();
                    reply.writeInt(v7);
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v8 = this.setNetOperator(data.readLong(), data.readByte());
                    reply.writeNoException();
                    reply.writeInt(v8);
                    return true;
                }
                case 10: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v9 = this.getRadioState(data.readLong());
                    reply.writeNoException();
                    reply.writeInt(v9);
                    return true;
                }
                case 11: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v10 = this.callWithFlag(data.readLong(), data.readByte(), data.readString());
                    reply.writeNoException();
                    reply.writeInt(v10);
                    return true;
                }
                case 12: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v11 = this.getTboxRebootLog(data.readLong());
                    reply.writeNoException();
                    reply.writeInt(v11);
                    return true;
                }
                case 13: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z = this.getTboxLog(data.readLong(), data.readString(), data.readString());
                    reply.writeNoException();
                    reply.writeInt((z ? 1 : 0));
                    return true;
                }
                case 14: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z1 = this.isConnectedTbox(data.readLong());
                    reply.writeNoException();
                    reply.writeInt((z1 ? 1 : 0));
                    return true;
                }
                case 15: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v12 = this.sendTsp(data.readLong(), data.readString());
                    reply.writeNoException();
                    reply.writeInt(v12);
                    return true;
                }
                case 16: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v13 = this.getMoney(data.readLong());
                    reply.writeNoException();
                    reply.writeInt(v13);
                    return true;
                }
                case 17: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v14 = this.getMoneyNumber(data.readLong());
                    reply.writeNoException();
                    reply.writeInt(v14);
                    return true;
                }
                case 18: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v15 = this.requestUpgrade(data.readLong(), data.readString());
                    reply.writeNoException();
                    reply.writeInt(v15);
                    return true;
                }
                case 19: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v16 = this.setChargeParams(data.readLong(), data.readByte(), data.readByte(), data.readByte(), data.readFloat(), data.readFloat(), data.readByte(), data.createIntArray());
                    reply.writeNoException();
                    reply.writeInt(v16);
                    return true;
                }
                case 20: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v17 = this.getChargeParams(data.readLong());
                    reply.writeNoException();
                    reply.writeInt(v17);
                    return true;
                }
                case 21: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v18 = this.ctrlCharge(data.readLong(), data.readByte());
                    reply.writeNoException();
                    reply.writeInt(v18);
                    return true;
                }
                case 22: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v19 = this.intrChargeConfig(data.readLong());
                    reply.writeNoException();
                    reply.writeInt(v19);
                    return true;
                }
                case 23: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    int v20 = this.getImei(data.readLong());
                    reply.writeNoException();
                    reply.writeInt(v20);
                    return true;
                }
                case 24: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z2 = this.getCurrentOperator(data.readLong());
                    reply.writeNoException();
                    reply.writeInt((z2 ? 1 : 0));
                    return true;
                }
                case 25: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z3 = this.getCurrentSystem(data.readLong());
                    reply.writeNoException();
                    reply.writeInt((z3 ? 1 : 0));
                    return true;
                }
                case 26: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z4 = this.getCurrentSignalStrength(data.readLong());
                    reply.writeNoException();
                    reply.writeInt((z4 ? 1 : 0));
                    return true;
                }
                case 27: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z5 = this.resetTboxNetwork(data.readLong());
                    reply.writeNoException();
                    reply.writeInt((z5 ? 1 : 0));
                    return true;
                }
                case 28: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z6 = this.getCurrentSignalRSSI(data.readLong());
                    reply.writeNoException();
                    reply.writeInt((z6 ? 1 : 0));
                    return true;
                }
                case 29: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z7 = this.getNetworkStatus(data.readLong());
                    reply.writeNoException();
                    reply.writeInt((z7 ? 1 : 0));
                    return true;
                }
                case 30: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z8 = this.resetTbox(data.readLong());
                    reply.writeNoException();
                    reply.writeInt((z8 ? 1 : 0));
                    return true;
                }
                case 0x1F: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z9 = this.shutdownTbox(data.readLong());
                    reply.writeNoException();
                    reply.writeInt((z9 ? 1 : 0));
                    return true;
                }
                case 0x20: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z10 = this.getTboxVersion(data.readLong());
                    reply.writeNoException();
                    reply.writeInt((z10 ? 1 : 0));
                    return true;
                }
                case 33: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z11 = this.getFiveCodeInfo(data.readLong());
                    reply.writeNoException();
                    reply.writeInt((z11 ? 1 : 0));
                    return true;
                }
                case 34: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z12 = this.getWifiName(data.readLong());
                    reply.writeNoException();
                    reply.writeInt((z12 ? 1 : 0));
                    return true;
                }
                case 35: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z13 = this.getWifiPassword(data.readLong());
                    reply.writeNoException();
                    reply.writeInt((z13 ? 1 : 0));
                    return true;
                }
                case 36: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z14 = this.updateWifiName(data.readLong(), data.readString());
                    reply.writeNoException();
                    reply.writeInt((z14 ? 1 : 0));
                    return true;
                }
                case 37: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z15 = this.updateWifiPassword(data.readLong(), data.readString());
                    reply.writeNoException();
                    reply.writeInt((z15 ? 1 : 0));
                    return true;
                }
                case 38: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z16 = this.getWifiSwitchStatus(data.readLong());
                    reply.writeNoException();
                    reply.writeInt((z16 ? 1 : 0));
                    return true;
                }
                case 39: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z17 = this.setWifiSwitch(data.readLong(), data.readInt() != 0);
                    reply.writeNoException();
                    reply.writeInt((z17 ? 1 : 0));
                    return true;
                }
                case 40: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxService");
                    boolean z18 = this.requestDownLoadSpaJsonFile(data.readLong());
                    reply.writeNoException();
                    reply.writeInt((z18 ? 1 : 0));
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.tbox.ICarTBoxService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    int callWithFlag(long arg1, byte arg2, String arg3) throws RemoteException;

    int ctrlCharge(long arg1, byte arg2) throws RemoteException;

    int getChargeParams(long arg1) throws RemoteException;

    boolean getCurrentOperator(long arg1) throws RemoteException;

    boolean getCurrentSignalRSSI(long arg1) throws RemoteException;

    boolean getCurrentSignalStrength(long arg1) throws RemoteException;

    boolean getCurrentSystem(long arg1) throws RemoteException;

    boolean getFiveCodeInfo(long arg1) throws RemoteException;

    int getIccid(long arg1) throws RemoteException;

    int getImei(long arg1) throws RemoteException;

    int getImsi(long arg1) throws RemoteException;

    int getMoney(long arg1) throws RemoteException;

    int getMoneyNumber(long arg1) throws RemoteException;

    int getNetOperatorList(long arg1) throws RemoteException;

    boolean getNetworkStatus(long arg1) throws RemoteException;

    int getPublicKey(long arg1) throws RemoteException;

    int getRadioState(long arg1) throws RemoteException;

    boolean getTboxLog(long arg1, String arg2, String arg3) throws RemoteException;

    int getTboxRebootLog(long arg1) throws RemoteException;

    boolean getTboxVersion(long arg1) throws RemoteException;

    boolean getWifiName(long arg1) throws RemoteException;

    boolean getWifiPassword(long arg1) throws RemoteException;

    boolean getWifiSwitchStatus(long arg1) throws RemoteException;

    int intrChargeConfig(long arg1) throws RemoteException;

    boolean isConnectedTbox(long arg1) throws RemoteException;

    int rebootTbox(long arg1) throws RemoteException;

    void registerCallback(long arg1, ICarTBoxCallback arg2) throws RemoteException;

    boolean requestDownLoadSpaJsonFile(long arg1) throws RemoteException;

    int requestUpgrade(long arg1, String arg2) throws RemoteException;

    boolean resetTbox(long arg1) throws RemoteException;

    boolean resetTboxNetwork(long arg1) throws RemoteException;

    int sendDtmf(long arg1, byte arg2) throws RemoteException;

    int sendTsp(long arg1, String arg2) throws RemoteException;

    int setChargeParams(long arg1, byte arg2, byte arg3, byte arg4, float arg5, float arg6, byte arg7, int[] arg8) throws RemoteException;

    int setNetOperator(long arg1, byte arg2) throws RemoteException;

    boolean setWifiSwitch(long arg1, boolean arg2) throws RemoteException;

    boolean shutdownTbox(long arg1) throws RemoteException;

    void unregisterCallback(long arg1) throws RemoteException;

    boolean updateWifiName(long arg1, String arg2) throws RemoteException;

    boolean updateWifiPassword(long arg1, String arg2) throws RemoteException;
}

