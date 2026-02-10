package com.yftech.car.tbox;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface ICarTBoxCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarTBoxCallback {
        static class Proxy implements ICarTBoxCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.tbox.ICarTBoxCallback";
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onCallFlagOperatorConfirm(int id, int callFlag, byte result, byte operatorId, boolean closeActivity) throws RemoteException {
                int v2 = 0;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeInt(id);
                    parcel0.writeInt(callFlag);
                    parcel0.writeByte(result);
                    parcel0.writeByte(operatorId);
                    if(closeActivity) {
                        v2 = 1;
                    }
                    parcel0.writeInt(v2);
                    this.mRemote.transact(14, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onCallInfo(int callFlag, String phoneNumber, byte callType, byte callState, boolean closeActivity) throws RemoteException {
                int v1 = 1;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeInt(callFlag);
                    parcel0.writeString(phoneNumber);
                    parcel0.writeByte(callType);
                    parcel0.writeByte(callState);
                    if(!closeActivity) {
                        v1 = 0;
                    }
                    parcel0.writeInt(v1);
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onCallWithFlagFail(byte operateId, String phoneNumber) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeByte(operateId);
                    parcel0.writeString(phoneNumber);
                    this.mRemote.transact(0x1F, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onChargeParams(byte current, byte soc, byte mode, float startTime, float endTime, byte dayVaild, int[] goTime) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeByte(current);
                    parcel0.writeByte(soc);
                    parcel0.writeByte(mode);
                    parcel0.writeFloat(startTime);
                    parcel0.writeFloat(endTime);
                    parcel0.writeByte(dayVaild);
                    parcel0.writeIntArray(goTime);
                    this.mRemote.transact(39, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onChargeParamsUpdate(byte state, byte result, long utc) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeByte(state);
                    parcel0.writeByte(result);
                    parcel0.writeLong(utc);
                    this.mRemote.transact(40, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onChargeState(byte state, String time) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeByte(state);
                    parcel0.writeString(time);
                    this.mRemote.transact(41, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onConnectedTboxState(boolean state) throws RemoteException {
                int v = 0;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    if(state) {
                        v = 1;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(20, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onCtrlChargeFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(45, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onCurrentCell(int cell) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeInt(cell);
                    this.mRemote.transact(0x30, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onCurrentOperator(int operator) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeInt(operator);
                    this.mRemote.transact(49, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onCurrentSignalRSSI(int rssi) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeInt(rssi);
                    this.mRemote.transact(52, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onCurrentSignalStrength(int signal) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeInt(signal);
                    this.mRemote.transact(51, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onCurrentSystem(int system) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeInt(system);
                    this.mRemote.transact(50, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onFiveCodeInfo(String info) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeString(info);
                    this.mRemote.transact(54, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onGetChargeParamsFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(44, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onGetIccidFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(27, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onGetImeiFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(0x2F, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onGetMoneyFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(35, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onGetMoneyNumberFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(36, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onGetMoneySmsNumRet(String number) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeString(number);
                    this.mRemote.transact(22, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onGetNetOperatorListFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(28, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onGetPublicKeyFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(26, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onGetRadioStateFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(30, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onGetTboxLogFail(String message) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeString(message);
                    this.mRemote.transact(18, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onGetTboxLogSuccess() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(19, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onGetTboxRebootLogFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(33, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onGetTboxVersionFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(0x20, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onIccid(String iccidInfo) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeString(iccidInfo);
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onImei(String imei) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeString(imei);
                    this.mRemote.transact(42, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onImsi(String imsi) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeString(imsi);
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onIntrChargeConfigFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(46, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onLogin(byte type, byte state) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeByte(type);
                    parcel0.writeByte(state);
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onNetOperator(NetOperator netOperaor) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    if(netOperaor == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        netOperaor.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(9, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onNetOperatorList(List list0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeTypedList(list0);
                    this.mRemote.transact(10, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onNetworkStatus(int status) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeInt(status);
                    this.mRemote.transact(53, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onPublicKey(String keyInfo) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeString(keyInfo);
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onRebootTboxFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(24, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onRebootTboxLog(String log) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeString(log);
                    this.mRemote.transact(17, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onRecvConfigFile() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onResetCallId(int callId) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeInt(callId);
                    this.mRemote.transact(16, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onResetFailReasonChanged(int value) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeInt(value);
                    this.mRemote.transact(62, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onResetStatusChanged(int status) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeInt(status);
                    this.mRemote.transact(61, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onResetTboxNetworkDone() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(60, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onSendDtmfFail(byte dtmf) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeByte(dtmf);
                    this.mRemote.transact(23, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onSendTspFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(34, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onServiceState(byte state) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeByte(state);
                    this.mRemote.transact(13, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onSetChargeParamsFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(43, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onSetNetOperatorFail(byte index) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeByte(index);
                    this.mRemote.transact(29, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onSetNetOperatorRet(byte index, byte result) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeByte(index);
                    parcel0.writeByte(result);
                    this.mRemote.transact(12, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onSignalIntensity(byte type, int intensity) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeByte(type);
                    parcel0.writeInt(intensity);
                    this.mRemote.transact(8, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onSimState(byte simState) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeByte(simState);
                    this.mRemote.transact(11, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onSms(String message, String phoneNumber) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeString(message);
                    parcel0.writeString(phoneNumber);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onSpaFileDownloadCompleted(String filePath) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeString(filePath);
                    this.mRemote.transact(0x3F, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onTboxVersion(String tboxVersion) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeString(tboxVersion);
                    this.mRemote.transact(15, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onTsp(byte type, String flag, String content) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeByte(type);
                    parcel0.writeString(flag);
                    parcel0.writeString(content);
                    this.mRemote.transact(21, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onUpdateWifiName(String name) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeString(name);
                    this.mRemote.transact(57, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onUpdateWifiPassword(String password) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeString(password);
                    this.mRemote.transact(58, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onUpgradeProgress(int progress) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeInt(progress);
                    this.mRemote.transact(38, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onUpgradeState(int stage, int state) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeInt(stage);
                    parcel0.writeInt(state);
                    this.mRemote.transact(37, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onWifiName(String name) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeString(name);
                    this.mRemote.transact(55, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onWifiPassword(String password) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    parcel0.writeString(password);
                    this.mRemote.transact(56, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void onWifiSwitchStatus(boolean open) throws RemoteException {
                int v = 0;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    if(open) {
                        v = 1;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(59, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.tbox.ICarTBoxCallback
            public void ongetImsiFail() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.tbox.ICarTBoxCallback");
                    this.mRemote.transact(25, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.tbox.ICarTBoxCallback";
        static final int TRANSACTION_onCallFlagOperatorConfirm = 14;
        static final int TRANSACTION_onCallInfo = 1;
        static final int TRANSACTION_onCallWithFlagFail = 0x1F;
        static final int TRANSACTION_onChargeParams = 39;
        static final int TRANSACTION_onChargeParamsUpdate = 40;
        static final int TRANSACTION_onChargeState = 41;
        static final int TRANSACTION_onConnectedTboxState = 20;
        static final int TRANSACTION_onCtrlChargeFail = 45;
        static final int TRANSACTION_onCurrentCell = 0x30;
        static final int TRANSACTION_onCurrentOperator = 49;
        static final int TRANSACTION_onCurrentSignalRSSI = 52;
        static final int TRANSACTION_onCurrentSignalStrength = 51;
        static final int TRANSACTION_onCurrentSystem = 50;
        static final int TRANSACTION_onFiveCodeInfo = 54;
        static final int TRANSACTION_onGetChargeParamsFail = 44;
        static final int TRANSACTION_onGetIccidFail = 27;
        static final int TRANSACTION_onGetImeiFail = 0x2F;
        static final int TRANSACTION_onGetMoneyFail = 35;
        static final int TRANSACTION_onGetMoneyNumberFail = 36;
        static final int TRANSACTION_onGetMoneySmsNumRet = 22;
        static final int TRANSACTION_onGetNetOperatorListFail = 28;
        static final int TRANSACTION_onGetPublicKeyFail = 26;
        static final int TRANSACTION_onGetRadioStateFail = 30;
        static final int TRANSACTION_onGetTboxLogFail = 18;
        static final int TRANSACTION_onGetTboxLogSuccess = 19;
        static final int TRANSACTION_onGetTboxRebootLogFail = 33;
        static final int TRANSACTION_onGetTboxVersionFail = 0x20;
        static final int TRANSACTION_onIccid = 6;
        static final int TRANSACTION_onImei = 42;
        static final int TRANSACTION_onImsi = 4;
        static final int TRANSACTION_onIntrChargeConfigFail = 46;
        static final int TRANSACTION_onLogin = 3;
        static final int TRANSACTION_onNetOperator = 9;
        static final int TRANSACTION_onNetOperatorList = 10;
        static final int TRANSACTION_onNetworkStatus = 53;
        static final int TRANSACTION_onPublicKey = 5;
        static final int TRANSACTION_onRebootTboxFail = 24;
        static final int TRANSACTION_onRebootTboxLog = 17;
        static final int TRANSACTION_onRecvConfigFile = 7;
        static final int TRANSACTION_onResetCallId = 16;
        static final int TRANSACTION_onResetFailReasonChanged = 62;
        static final int TRANSACTION_onResetStatusChanged = 61;
        static final int TRANSACTION_onResetTboxNetworkDone = 60;
        static final int TRANSACTION_onSendDtmfFail = 23;
        static final int TRANSACTION_onSendTspFail = 34;
        static final int TRANSACTION_onServiceState = 13;
        static final int TRANSACTION_onSetChargeParamsFail = 43;
        static final int TRANSACTION_onSetNetOperatorFail = 29;
        static final int TRANSACTION_onSetNetOperatorRet = 12;
        static final int TRANSACTION_onSignalIntensity = 8;
        static final int TRANSACTION_onSimState = 11;
        static final int TRANSACTION_onSms = 2;
        static final int TRANSACTION_onSpaFileDownloadCompleted = 0x3F;
        static final int TRANSACTION_onTboxVersion = 15;
        static final int TRANSACTION_onTsp = 21;
        static final int TRANSACTION_onUpdateWifiName = 57;
        static final int TRANSACTION_onUpdateWifiPassword = 58;
        static final int TRANSACTION_onUpgradeProgress = 38;
        static final int TRANSACTION_onUpgradeState = 37;
        static final int TRANSACTION_onWifiName = 55;
        static final int TRANSACTION_onWifiPassword = 56;
        static final int TRANSACTION_onWifiSwitchStatus = 59;
        static final int TRANSACTION_ongetImsiFail = 25;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.tbox.ICarTBoxCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarTBoxCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.tbox.ICarTBoxCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarTBoxCallback) ? ((ICarTBoxCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onCallInfo(data.readInt(), data.readString(), data.readByte(), data.readByte(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onSms(data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onLogin(data.readByte(), data.readByte());
                    reply.writeNoException();
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onImsi(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onPublicKey(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onIccid(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onRecvConfigFile();
                    reply.writeNoException();
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onSignalIntensity(data.readByte(), data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onNetOperator((data.readInt() == 0 ? null : ((NetOperator)NetOperator.CREATOR.createFromParcel(data))));
                    reply.writeNoException();
                    return true;
                }
                case 10: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onNetOperatorList(data.createTypedArrayList(NetOperator.CREATOR));
                    reply.writeNoException();
                    return true;
                }
                case 11: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onSimState(data.readByte());
                    reply.writeNoException();
                    return true;
                }
                case 12: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onSetNetOperatorRet(data.readByte(), data.readByte());
                    reply.writeNoException();
                    return true;
                }
                case 13: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onServiceState(data.readByte());
                    reply.writeNoException();
                    return true;
                }
                case 14: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onCallFlagOperatorConfirm(data.readInt(), data.readInt(), data.readByte(), data.readByte(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case 15: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onTboxVersion(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 16: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onResetCallId(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 17: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onRebootTboxLog(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 18: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onGetTboxLogFail(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 19: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onGetTboxLogSuccess();
                    reply.writeNoException();
                    return true;
                }
                case 20: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onConnectedTboxState(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case 21: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onTsp(data.readByte(), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 22: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onGetMoneySmsNumRet(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 23: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onSendDtmfFail(data.readByte());
                    reply.writeNoException();
                    return true;
                }
                case 24: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onRebootTboxFail();
                    reply.writeNoException();
                    return true;
                }
                case 25: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.ongetImsiFail();
                    reply.writeNoException();
                    return true;
                }
                case 26: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onGetPublicKeyFail();
                    reply.writeNoException();
                    return true;
                }
                case 27: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onGetIccidFail();
                    reply.writeNoException();
                    return true;
                }
                case 28: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onGetNetOperatorListFail();
                    reply.writeNoException();
                    return true;
                }
                case 29: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onSetNetOperatorFail(data.readByte());
                    reply.writeNoException();
                    return true;
                }
                case 30: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onGetRadioStateFail();
                    reply.writeNoException();
                    return true;
                }
                case 0x1F: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onCallWithFlagFail(data.readByte(), data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 0x20: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onGetTboxVersionFail();
                    reply.writeNoException();
                    return true;
                }
                case 33: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onGetTboxRebootLogFail();
                    reply.writeNoException();
                    return true;
                }
                case 34: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onSendTspFail();
                    reply.writeNoException();
                    return true;
                }
                case 35: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onGetMoneyFail();
                    reply.writeNoException();
                    return true;
                }
                case 36: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onGetMoneyNumberFail();
                    reply.writeNoException();
                    return true;
                }
                case 37: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onUpgradeState(data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 38: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onUpgradeProgress(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 39: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onChargeParams(data.readByte(), data.readByte(), data.readByte(), data.readFloat(), data.readFloat(), data.readByte(), data.createIntArray());
                    reply.writeNoException();
                    return true;
                }
                case 40: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onChargeParamsUpdate(data.readByte(), data.readByte(), data.readLong());
                    reply.writeNoException();
                    return true;
                }
                case 41: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onChargeState(data.readByte(), data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 42: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onImei(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 43: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onSetChargeParamsFail();
                    reply.writeNoException();
                    return true;
                }
                case 44: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onGetChargeParamsFail();
                    reply.writeNoException();
                    return true;
                }
                case 45: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onCtrlChargeFail();
                    reply.writeNoException();
                    return true;
                }
                case 46: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onIntrChargeConfigFail();
                    reply.writeNoException();
                    return true;
                }
                case 0x2F: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onGetImeiFail();
                    reply.writeNoException();
                    return true;
                }
                case 0x30: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onCurrentCell(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 49: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onCurrentOperator(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 50: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onCurrentSystem(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 51: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onCurrentSignalStrength(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 52: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onCurrentSignalRSSI(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 53: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onNetworkStatus(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 54: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onFiveCodeInfo(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 55: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onWifiName(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 56: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onWifiPassword(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 57: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onUpdateWifiName(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 58: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onUpdateWifiPassword(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 59: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onWifiSwitchStatus(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                }
                case 60: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onResetTboxNetworkDone();
                    reply.writeNoException();
                    return true;
                }
                case 61: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onResetStatusChanged(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 62: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onResetFailReasonChanged(data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 0x3F: {
                    data.enforceInterface("com.yftech.car.tbox.ICarTBoxCallback");
                    this.onSpaFileDownloadCompleted(data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.tbox.ICarTBoxCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onCallFlagOperatorConfirm(int arg1, int arg2, byte arg3, byte arg4, boolean arg5) throws RemoteException;

    void onCallInfo(int arg1, String arg2, byte arg3, byte arg4, boolean arg5) throws RemoteException;

    void onCallWithFlagFail(byte arg1, String arg2) throws RemoteException;

    void onChargeParams(byte arg1, byte arg2, byte arg3, float arg4, float arg5, byte arg6, int[] arg7) throws RemoteException;

    void onChargeParamsUpdate(byte arg1, byte arg2, long arg3) throws RemoteException;

    void onChargeState(byte arg1, String arg2) throws RemoteException;

    void onConnectedTboxState(boolean arg1) throws RemoteException;

    void onCtrlChargeFail() throws RemoteException;

    void onCurrentCell(int arg1) throws RemoteException;

    void onCurrentOperator(int arg1) throws RemoteException;

    void onCurrentSignalRSSI(int arg1) throws RemoteException;

    void onCurrentSignalStrength(int arg1) throws RemoteException;

    void onCurrentSystem(int arg1) throws RemoteException;

    void onFiveCodeInfo(String arg1) throws RemoteException;

    void onGetChargeParamsFail() throws RemoteException;

    void onGetIccidFail() throws RemoteException;

    void onGetImeiFail() throws RemoteException;

    void onGetMoneyFail() throws RemoteException;

    void onGetMoneyNumberFail() throws RemoteException;

    void onGetMoneySmsNumRet(String arg1) throws RemoteException;

    void onGetNetOperatorListFail() throws RemoteException;

    void onGetPublicKeyFail() throws RemoteException;

    void onGetRadioStateFail() throws RemoteException;

    void onGetTboxLogFail(String arg1) throws RemoteException;

    void onGetTboxLogSuccess() throws RemoteException;

    void onGetTboxRebootLogFail() throws RemoteException;

    void onGetTboxVersionFail() throws RemoteException;

    void onIccid(String arg1) throws RemoteException;

    void onImei(String arg1) throws RemoteException;

    void onImsi(String arg1) throws RemoteException;

    void onIntrChargeConfigFail() throws RemoteException;

    void onLogin(byte arg1, byte arg2) throws RemoteException;

    void onNetOperator(NetOperator arg1) throws RemoteException;

    void onNetOperatorList(List arg1) throws RemoteException;

    void onNetworkStatus(int arg1) throws RemoteException;

    void onPublicKey(String arg1) throws RemoteException;

    void onRebootTboxFail() throws RemoteException;

    void onRebootTboxLog(String arg1) throws RemoteException;

    void onRecvConfigFile() throws RemoteException;

    void onResetCallId(int arg1) throws RemoteException;

    void onResetFailReasonChanged(int arg1) throws RemoteException;

    void onResetStatusChanged(int arg1) throws RemoteException;

    void onResetTboxNetworkDone() throws RemoteException;

    void onSendDtmfFail(byte arg1) throws RemoteException;

    void onSendTspFail() throws RemoteException;

    void onServiceState(byte arg1) throws RemoteException;

    void onSetChargeParamsFail() throws RemoteException;

    void onSetNetOperatorFail(byte arg1) throws RemoteException;

    void onSetNetOperatorRet(byte arg1, byte arg2) throws RemoteException;

    void onSignalIntensity(byte arg1, int arg2) throws RemoteException;

    void onSimState(byte arg1) throws RemoteException;

    void onSms(String arg1, String arg2) throws RemoteException;

    void onSpaFileDownloadCompleted(String arg1) throws RemoteException;

    void onTboxVersion(String arg1) throws RemoteException;

    void onTsp(byte arg1, String arg2, String arg3) throws RemoteException;

    void onUpdateWifiName(String arg1) throws RemoteException;

    void onUpdateWifiPassword(String arg1) throws RemoteException;

    void onUpgradeProgress(int arg1) throws RemoteException;

    void onUpgradeState(int arg1, int arg2) throws RemoteException;

    void onWifiName(String arg1) throws RemoteException;

    void onWifiPassword(String arg1) throws RemoteException;

    void onWifiSwitchStatus(boolean arg1) throws RemoteException;

    void ongetImsiFail() throws RemoteException;
}

