package com.yftech.car.audio;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarSoundEffectCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarSoundEffectCallback {
        static class Proxy implements ICarSoundEffectCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.audio.ICarSoundEffectCallback";
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectCallback
            public void onChangedBalanceValue(float fl, float fr, float rl, float rr) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectCallback");
                    parcel0.writeFloat(fl);
                    parcel0.writeFloat(fr);
                    parcel0.writeFloat(rl);
                    parcel0.writeFloat(rr);
                    this.mRemote.transact(8, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectCallback
            public void onChangedBalanceXY(float lr, float fr) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectCallback");
                    parcel0.writeFloat(lr);
                    parcel0.writeFloat(fr);
                    this.mRemote.transact(10, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectCallback
            public void onChangedBandValue(float[] values, float[] qs) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectCallback");
                    parcel0.writeFloatArray(values);
                    parcel0.writeFloatArray(qs);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectCallback
            public void onChangedDTSEnable(boolean enable) throws RemoteException {
                int v = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectCallback");
                    if(!enable) {
                        v = 0;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(5, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectCallback
            public void onChangedDTSSoundPosition(int position) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectCallback");
                    parcel0.writeInt(position);
                    this.mRemote.transact(7, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectCallback
            public void onChangedDTSType(int type) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectCallback");
                    parcel0.writeInt(type);
                    this.mRemote.transact(6, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectCallback
            public void onChangedDelayValue(float fl, float fr, float rl, float rr) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectCallback");
                    parcel0.writeFloat(fl);
                    parcel0.writeFloat(fr);
                    parcel0.writeFloat(rl);
                    parcel0.writeFloat(rr);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectCallback
            public void onChangedEQType(int type, float[] values, float[] qs) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectCallback");
                    parcel0.writeInt(type);
                    parcel0.writeFloatArray(values);
                    parcel0.writeFloatArray(qs);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectCallback
            public void onChangedEnable(boolean enable) throws RemoteException {
                int v = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectCallback");
                    if(!enable) {
                        v = 0;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectCallback
            public void onChangedLoudnessEnable(boolean enable) throws RemoteException {
                int v = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectCallback");
                    if(!enable) {
                        v = 0;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(9, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarSoundEffectCallback
            public void onChangedSceneSoundEffectType(int type) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarSoundEffectCallback");
                    parcel0.writeInt(type);
                    this.mRemote.transact(11, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.audio.ICarSoundEffectCallback";
        static final int TRANSACTION_onChangedBalanceValue = 8;
        static final int TRANSACTION_onChangedBalanceXY = 10;
        static final int TRANSACTION_onChangedBandValue = 2;
        static final int TRANSACTION_onChangedDTSEnable = 5;
        static final int TRANSACTION_onChangedDTSSoundPosition = 7;
        static final int TRANSACTION_onChangedDTSType = 6;
        static final int TRANSACTION_onChangedDelayValue = 3;
        static final int TRANSACTION_onChangedEQType = 4;
        static final int TRANSACTION_onChangedEnable = 1;
        static final int TRANSACTION_onChangedLoudnessEnable = 9;
        static final int TRANSACTION_onChangedSceneSoundEffectType = 11;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.audio.ICarSoundEffectCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarSoundEffectCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.audio.ICarSoundEffectCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarSoundEffectCallback) ? ((ICarSoundEffectCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean _arg0 = false;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectCallback");
                    if(data.readInt() != 0) {
                        _arg0 = true;
                    }
                    this.onChangedEnable(_arg0);
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectCallback");
                    this.onChangedBandValue(data.createFloatArray(), data.createFloatArray());
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectCallback");
                    this.onChangedDelayValue(data.readFloat(), data.readFloat(), data.readFloat(), data.readFloat());
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectCallback");
                    this.onChangedEQType(data.readInt(), data.createFloatArray(), data.createFloatArray());
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectCallback");
                    if(data.readInt() != 0) {
                        _arg0 = true;
                    }
                    this.onChangedDTSEnable(_arg0);
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectCallback");
                    this.onChangedDTSType(data.readInt());
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectCallback");
                    this.onChangedDTSSoundPosition(data.readInt());
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectCallback");
                    this.onChangedBalanceValue(data.readFloat(), data.readFloat(), data.readFloat(), data.readFloat());
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectCallback");
                    if(data.readInt() != 0) {
                        _arg0 = true;
                    }
                    this.onChangedLoudnessEnable(_arg0);
                    return true;
                }
                case 10: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectCallback");
                    this.onChangedBalanceXY(data.readFloat(), data.readFloat());
                    return true;
                }
                case 11: {
                    data.enforceInterface("com.yftech.car.audio.ICarSoundEffectCallback");
                    this.onChangedSceneSoundEffectType(data.readInt());
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.audio.ICarSoundEffectCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onChangedBalanceValue(float arg1, float arg2, float arg3, float arg4) throws RemoteException;

    void onChangedBalanceXY(float arg1, float arg2) throws RemoteException;

    void onChangedBandValue(float[] arg1, float[] arg2) throws RemoteException;

    void onChangedDTSEnable(boolean arg1) throws RemoteException;

    void onChangedDTSSoundPosition(int arg1) throws RemoteException;

    void onChangedDTSType(int arg1) throws RemoteException;

    void onChangedDelayValue(float arg1, float arg2, float arg3, float arg4) throws RemoteException;

    void onChangedEQType(int arg1, float[] arg2, float[] arg3) throws RemoteException;

    void onChangedEnable(boolean arg1) throws RemoteException;

    void onChangedLoudnessEnable(boolean arg1) throws RemoteException;

    void onChangedSceneSoundEffectType(int arg1) throws RemoteException;
}

