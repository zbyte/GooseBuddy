package com.yftech.car.audio;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarSoundEffectService extends IInterface {
    public static abstract class Stub extends Binder implements ICarSoundEffectService {
        static class Proxy implements ICarSoundEffectService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float getBalanceMaxValue() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(26, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readFloat();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float getBalanceMinValue() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(27, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readFloat();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float getBalanceValueFL() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(28, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readFloat();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float getBalanceValueFR() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(29, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readFloat();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float getBalanceValueRL() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(30, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readFloat();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float getBalanceValueRR() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(0x1F, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readFloat();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float[] getBalanceXY() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(38, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createFloatArray();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float[] getBandCurQ() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(36, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createFloatArray();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float[] getBandCurValue() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createFloatArray();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float[] getBandMaxQ() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(35, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createFloatArray();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float[] getBandMaxValue() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(8, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createFloatArray();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float[] getBandMinQ() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(34, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createFloatArray();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float[] getBandMinValue() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(9, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createFloatArray();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public int[] getBandsHz() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createIntArray();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public int getDTSSoundPosition() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(24, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public int getDTSType() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(22, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float getDelayMaxValue() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(10, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readFloat();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float getDelayMinValue() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(11, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readFloat();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float getDelayValueFL() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(13, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readFloat();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float getDelayValueFR() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(14, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readFloat();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float getDelayValueRL() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(15, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readFloat();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public float getDelayValueRR() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(16, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readFloat();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public int getEQType() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(18, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.audio.ICarSoundEffectService";
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public int getSceneSoundEffectType() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    this.mRemote.transact(40, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public boolean isDTSEnable() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
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

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public boolean isEQEnable() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
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

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public boolean isLoudnessEnable() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
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

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public void registerCarSoundEffectCallback(ICarSoundEffectCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public boolean setBalance(float fl, float fr, float rl, float rr) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    parcel0.writeFloat(fl);
                    parcel0.writeFloat(fr);
                    parcel0.writeFloat(rl);
                    parcel0.writeFloat(rr);
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

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public boolean setBalanceXY(float lr, float fr) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    parcel0.writeFloat(lr);
                    parcel0.writeFloat(fr);
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

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public boolean setBandValue(float[] values, float[] qs) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    parcel0.writeFloatArray(values);
                    parcel0.writeFloatArray(qs);
                    this.mRemote.transact(6, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public boolean setDTSEnable(boolean enable) throws RemoteException {
                boolean z1 = true;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    parcel0.writeInt((enable ? 1 : 0));
                    this.mRemote.transact(19, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public boolean setDTSSoundPosition(int position) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    parcel0.writeInt(position);
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

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public boolean setDTSType(int type) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    parcel0.writeInt(type);
                    this.mRemote.transact(21, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public boolean setDelayValue(float fl, float fr, float rl, float rr) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    parcel0.writeFloat(fl);
                    parcel0.writeFloat(fr);
                    parcel0.writeFloat(rl);
                    parcel0.writeFloat(rr);
                    this.mRemote.transact(12, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public boolean setEQEnable(boolean enable) throws RemoteException {
                boolean z1 = true;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    parcel0.writeInt((enable ? 1 : 0));
                    this.mRemote.transact(3, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public boolean setEQType(int type) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    parcel0.writeInt(type);
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

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public boolean setLoudnessEnable(boolean enable) throws RemoteException {
                boolean z1 = true;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    parcel0.writeInt((enable ? 1 : 0));
                    this.mRemote.transact(0x20, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public boolean setSceneSoundEffectType(int type) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
                    parcel0.writeInt(type);
                    this.mRemote.transact(39, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.audio.ICarSoundEffectService
            public void unregisterCarSoundEffectCallback(ICarSoundEffectCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectService");
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

        private static final String DESCRIPTOR = "com.yftech.car.audio.ICarSoundEffectService";
        static final int TRANSACTION_getBalanceMaxValue = 26;
        static final int TRANSACTION_getBalanceMinValue = 27;
        static final int TRANSACTION_getBalanceValueFL = 28;
        static final int TRANSACTION_getBalanceValueFR = 29;
        static final int TRANSACTION_getBalanceValueRL = 30;
        static final int TRANSACTION_getBalanceValueRR = 0x1F;
        static final int TRANSACTION_getBalanceXY = 38;
        static final int TRANSACTION_getBandCurQ = 36;
        static final int TRANSACTION_getBandCurValue = 7;
        static final int TRANSACTION_getBandMaxQ = 35;
        static final int TRANSACTION_getBandMaxValue = 8;
        static final int TRANSACTION_getBandMinQ = 34;
        static final int TRANSACTION_getBandMinValue = 9;
        static final int TRANSACTION_getBandsHz = 5;
        static final int TRANSACTION_getDTSSoundPosition = 24;
        static final int TRANSACTION_getDTSType = 22;
        static final int TRANSACTION_getDelayMaxValue = 10;
        static final int TRANSACTION_getDelayMinValue = 11;
        static final int TRANSACTION_getDelayValueFL = 13;
        static final int TRANSACTION_getDelayValueFR = 14;
        static final int TRANSACTION_getDelayValueRL = 15;
        static final int TRANSACTION_getDelayValueRR = 16;
        static final int TRANSACTION_getEQType = 18;
        static final int TRANSACTION_getSceneSoundEffectType = 40;
        static final int TRANSACTION_isDTSEnable = 20;
        static final int TRANSACTION_isEQEnable = 4;
        static final int TRANSACTION_isLoudnessEnable = 33;
        static final int TRANSACTION_registerCarSoundEffectCallback = 1;
        static final int TRANSACTION_setBalance = 25;
        static final int TRANSACTION_setBalanceXY = 37;
        static final int TRANSACTION_setBandValue = 6;
        static final int TRANSACTION_setDTSEnable = 19;
        static final int TRANSACTION_setDTSSoundPosition = 23;
        static final int TRANSACTION_setDTSType = 21;
        static final int TRANSACTION_setDelayValue = 12;
        static final int TRANSACTION_setEQEnable = 3;
        static final int TRANSACTION_setEQType = 17;
        static final int TRANSACTION_setLoudnessEnable = 0x20;
        static final int TRANSACTION_setSceneSoundEffectType = 39;
        static final int TRANSACTION_unregisterCarSoundEffectCallback = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.audio.ICarSoundEffectService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarSoundEffectService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.audio.ICarSoundEffectService");
            return iInterface0 != null && (iInterface0 instanceof ICarSoundEffectService) ? ((ICarSoundEffectService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int v2 = 0;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    this.registerCarSoundEffectCallback(com.yftech.car.audio.ICarSoundEffectCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    this.unregisterCarSoundEffectCallback(com.yftech.car.audio.ICarSoundEffectCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    boolean z = this.setEQEnable(data.readInt() != 0);
                    reply.writeNoException();
                    if(z) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    boolean z1 = this.isEQEnable();
                    reply.writeNoException();
                    if(z1) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    int[] arr_v = this.getBandsHz();
                    reply.writeNoException();
                    reply.writeIntArray(arr_v);
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    boolean z2 = this.setBandValue(data.createFloatArray(), data.createFloatArray());
                    reply.writeNoException();
                    if(z2) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float[] arr_f = this.getBandCurValue();
                    reply.writeNoException();
                    reply.writeFloatArray(arr_f);
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float[] arr_f1 = this.getBandMaxValue();
                    reply.writeNoException();
                    reply.writeFloatArray(arr_f1);
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float[] arr_f2 = this.getBandMinValue();
                    reply.writeNoException();
                    reply.writeFloatArray(arr_f2);
                    return true;
                }
                case 10: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float f = this.getDelayMaxValue();
                    reply.writeNoException();
                    reply.writeFloat(f);
                    return true;
                }
                case 11: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float f1 = this.getDelayMinValue();
                    reply.writeNoException();
                    reply.writeFloat(f1);
                    return true;
                }
                case 12: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    boolean z3 = this.setDelayValue(data.readFloat(), data.readFloat(), data.readFloat(), data.readFloat());
                    reply.writeNoException();
                    if(z3) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 13: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float f2 = this.getDelayValueFL();
                    reply.writeNoException();
                    reply.writeFloat(f2);
                    return true;
                }
                case 14: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float f3 = this.getDelayValueFR();
                    reply.writeNoException();
                    reply.writeFloat(f3);
                    return true;
                }
                case 15: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float f4 = this.getDelayValueRL();
                    reply.writeNoException();
                    reply.writeFloat(f4);
                    return true;
                }
                case 16: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float f5 = this.getDelayValueRR();
                    reply.writeNoException();
                    reply.writeFloat(f5);
                    return true;
                }
                case 17: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    boolean z4 = this.setEQType(data.readInt());
                    reply.writeNoException();
                    if(z4) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 18: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    int v3 = this.getEQType();
                    reply.writeNoException();
                    reply.writeInt(v3);
                    return true;
                }
                case 19: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    boolean z5 = this.setDTSEnable(data.readInt() != 0);
                    reply.writeNoException();
                    if(z5) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 20: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    boolean z6 = this.isDTSEnable();
                    reply.writeNoException();
                    if(z6) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 21: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    boolean z7 = this.setDTSType(data.readInt());
                    reply.writeNoException();
                    if(z7) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 22: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    int v4 = this.getDTSType();
                    reply.writeNoException();
                    reply.writeInt(v4);
                    return true;
                }
                case 23: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    boolean z8 = this.setDTSSoundPosition(data.readInt());
                    reply.writeNoException();
                    if(z8) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 24: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    int v5 = this.getDTSSoundPosition();
                    reply.writeNoException();
                    reply.writeInt(v5);
                    return true;
                }
                case 25: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    boolean z9 = this.setBalance(data.readFloat(), data.readFloat(), data.readFloat(), data.readFloat());
                    reply.writeNoException();
                    if(z9) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 26: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float f6 = this.getBalanceMaxValue();
                    reply.writeNoException();
                    reply.writeFloat(f6);
                    return true;
                }
                case 27: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float f7 = this.getBalanceMinValue();
                    reply.writeNoException();
                    reply.writeFloat(f7);
                    return true;
                }
                case 28: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float f8 = this.getBalanceValueFL();
                    reply.writeNoException();
                    reply.writeFloat(f8);
                    return true;
                }
                case 29: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float f9 = this.getBalanceValueFR();
                    reply.writeNoException();
                    reply.writeFloat(f9);
                    return true;
                }
                case 30: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float f10 = this.getBalanceValueRL();
                    reply.writeNoException();
                    reply.writeFloat(f10);
                    return true;
                }
                case 0x1F: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float f11 = this.getBalanceValueRR();
                    reply.writeNoException();
                    reply.writeFloat(f11);
                    return true;
                }
                case 0x20: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    boolean z10 = this.setLoudnessEnable(data.readInt() != 0);
                    reply.writeNoException();
                    if(z10) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 33: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    boolean z11 = this.isLoudnessEnable();
                    reply.writeNoException();
                    if(z11) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 34: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float[] arr_f3 = this.getBandMinQ();
                    reply.writeNoException();
                    reply.writeFloatArray(arr_f3);
                    return true;
                }
                case 35: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float[] arr_f4 = this.getBandMaxQ();
                    reply.writeNoException();
                    reply.writeFloatArray(arr_f4);
                    return true;
                }
                case 36: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float[] arr_f5 = this.getBandCurQ();
                    reply.writeNoException();
                    reply.writeFloatArray(arr_f5);
                    return true;
                }
                case 37: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    boolean z12 = this.setBalanceXY(data.readFloat(), data.readFloat());
                    reply.writeNoException();
                    if(z12) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 38: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    float[] arr_f6 = this.getBalanceXY();
                    reply.writeNoException();
                    reply.writeFloatArray(arr_f6);
                    return true;
                }
                case 39: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    boolean z13 = this.setSceneSoundEffectType(data.readInt());
                    reply.writeNoException();
                    if(z13) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 40: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectService");
                    int v6 = this.getSceneSoundEffectType();
                    reply.writeNoException();
                    reply.writeInt(v6);
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.audio.ICarSoundEffectService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    float getBalanceMaxValue() throws RemoteException;

    float getBalanceMinValue() throws RemoteException;

    float getBalanceValueFL() throws RemoteException;

    float getBalanceValueFR() throws RemoteException;

    float getBalanceValueRL() throws RemoteException;

    float getBalanceValueRR() throws RemoteException;

    float[] getBalanceXY() throws RemoteException;

    float[] getBandCurQ() throws RemoteException;

    float[] getBandCurValue() throws RemoteException;

    float[] getBandMaxQ() throws RemoteException;

    float[] getBandMaxValue() throws RemoteException;

    float[] getBandMinQ() throws RemoteException;

    float[] getBandMinValue() throws RemoteException;

    int[] getBandsHz() throws RemoteException;

    int getDTSSoundPosition() throws RemoteException;

    int getDTSType() throws RemoteException;

    float getDelayMaxValue() throws RemoteException;

    float getDelayMinValue() throws RemoteException;

    float getDelayValueFL() throws RemoteException;

    float getDelayValueFR() throws RemoteException;

    float getDelayValueRL() throws RemoteException;

    float getDelayValueRR() throws RemoteException;

    int getEQType() throws RemoteException;

    int getSceneSoundEffectType() throws RemoteException;

    boolean isDTSEnable() throws RemoteException;

    boolean isEQEnable() throws RemoteException;

    boolean isLoudnessEnable() throws RemoteException;

    void registerCarSoundEffectCallback(ICarSoundEffectCallback arg1) throws RemoteException;

    boolean setBalance(float arg1, float arg2, float arg3, float arg4) throws RemoteException;

    boolean setBalanceXY(float arg1, float arg2) throws RemoteException;

    boolean setBandValue(float[] arg1, float[] arg2) throws RemoteException;

    boolean setDTSEnable(boolean arg1) throws RemoteException;

    boolean setDTSSoundPosition(int arg1) throws RemoteException;

    boolean setDTSType(int arg1) throws RemoteException;

    boolean setDelayValue(float arg1, float arg2, float arg3, float arg4) throws RemoteException;

    boolean setEQEnable(boolean arg1) throws RemoteException;

    boolean setEQType(int arg1) throws RemoteException;

    boolean setLoudnessEnable(boolean arg1) throws RemoteException;

    boolean setSceneSoundEffectType(int arg1) throws RemoteException;

    void unregisterCarSoundEffectCallback(ICarSoundEffectCallback arg1) throws RemoteException;
}

