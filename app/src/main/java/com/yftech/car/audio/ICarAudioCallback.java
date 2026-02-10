package com.yftech.car.audio;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarAudioCallback extends IInterface {
    public static abstract class Stub extends Binder implements ICarAudioCallback {
        static class Proxy implements ICarAudioCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.audio.ICarAudioCallback";
            }

            @Override  // com.yftech.car.audio.ICarAudioCallback
            public void onAudioFocusAbandon(String packageName, int streamType, String clientId, Bundle data) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioCallback");
                    parcel0.writeString(packageName);
                    parcel0.writeInt(streamType);
                    parcel0.writeString(clientId);
                    if(data == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        data.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(10, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioCallback
            public void onAudioFocusGrant(String packageName, int streamType, String clientId, Bundle data) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioCallback");
                    parcel0.writeString(packageName);
                    parcel0.writeInt(streamType);
                    parcel0.writeString(clientId);
                    if(data == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        data.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(7, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioCallback
            public void onAudioFocusLoss(String packageName, int streamType, String clientId, Bundle data, int lossState) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioCallback");
                    parcel0.writeString(packageName);
                    parcel0.writeInt(streamType);
                    parcel0.writeString(clientId);
                    if(data == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        data.writeToParcel(parcel0, 0);
                    }
                    parcel0.writeInt(lossState);
                    this.mRemote.transact(8, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioCallback
            public void onAudioFocusRequest(String packageName, int streamType, String clientId, Bundle data, int requestResult) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioCallback");
                    parcel0.writeString(packageName);
                    parcel0.writeInt(streamType);
                    parcel0.writeString(clientId);
                    if(data == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        data.writeToParcel(parcel0, 0);
                    }
                    parcel0.writeInt(requestResult);
                    this.mRemote.transact(9, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioCallback
            public void onChangedBootVolumeType(int type) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioCallback");
                    parcel0.writeInt(type);
                    this.mRemote.transact(5, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioCallback
            public void onChangedMediaSource(int streamType, String packageName, String clientId) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioCallback");
                    parcel0.writeInt(streamType);
                    parcel0.writeString(packageName);
                    parcel0.writeString(clientId);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioCallback
            public void onChangedNaviMixLevel(int level) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioCallback");
                    parcel0.writeInt(level);
                    this.mRemote.transact(6, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioCallback
            public void onChangedScreenSaver(boolean on) throws RemoteException {
                int v = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioCallback");
                    if(!on) {
                        v = 0;
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioCallback
            public void onChangedSpeedGainLevel(int level) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioCallback");
                    parcel0.writeInt(level);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioCallback
            public void onChangedVolume(int[] streamTypes, int curValue, int tolValue, boolean mute, int flag) throws RemoteException {
                int v3 = 1;
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioCallback");
                    parcel0.writeIntArray(streamTypes);
                    parcel0.writeInt(curValue);
                    parcel0.writeInt(tolValue);
                    if(!mute) {
                        v3 = 0;
                    }
                    parcel0.writeInt(v3);
                    parcel0.writeInt(flag);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.audio.ICarAudioCallback";
        static final int TRANSACTION_onAudioFocusAbandon = 10;
        static final int TRANSACTION_onAudioFocusGrant = 7;
        static final int TRANSACTION_onAudioFocusLoss = 8;
        static final int TRANSACTION_onAudioFocusRequest = 9;
        static final int TRANSACTION_onChangedBootVolumeType = 5;
        static final int TRANSACTION_onChangedMediaSource = 3;
        static final int TRANSACTION_onChangedNaviMixLevel = 6;
        static final int TRANSACTION_onChangedScreenSaver = 4;
        static final int TRANSACTION_onChangedSpeedGainLevel = 2;
        static final int TRANSACTION_onChangedVolume = 1;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.audio.ICarAudioCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarAudioCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.audio.ICarAudioCallback");
            return iInterface0 != null && (iInterface0 instanceof ICarAudioCallback) ? ((ICarAudioCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean _arg3 = false;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioCallback");
                    int[] arr_v = data.createIntArray();
                    int v2 = data.readInt();
                    int v3 = data.readInt();
                    if(data.readInt() != 0) {
                        _arg3 = true;
                    }
                    this.onChangedVolume(arr_v, v2, v3, _arg3, data.readInt());
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioCallback");
                    this.onChangedSpeedGainLevel(data.readInt());
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioCallback");
                    this.onChangedMediaSource(data.readInt(), data.readString(), data.readString());
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioCallback");
                    this.onChangedScreenSaver(data.readInt() != 0);
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioCallback");
                    this.onChangedBootVolumeType(data.readInt());
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioCallback");
                    this.onChangedNaviMixLevel(data.readInt());
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioCallback");
                    this.onAudioFocusGrant(data.readString(), data.readInt(), data.readString(), (data.readInt() == 0 ? null : ((Bundle)Bundle.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioCallback");
                    this.onAudioFocusLoss(data.readString(), data.readInt(), data.readString(), (data.readInt() == 0 ? null : ((Bundle)Bundle.CREATOR.createFromParcel(data))), data.readInt());
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioCallback");
                    this.onAudioFocusRequest(data.readString(), data.readInt(), data.readString(), (data.readInt() == 0 ? null : ((Bundle)Bundle.CREATOR.createFromParcel(data))), data.readInt());
                    return true;
                }
                case 10: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioCallback");
                    this.onAudioFocusAbandon(data.readString(), data.readInt(), data.readString(), (data.readInt() == 0 ? null : ((Bundle)Bundle.CREATOR.createFromParcel(data))));
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.audio.ICarAudioCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    void onAudioFocusAbandon(String arg1, int arg2, String arg3, Bundle arg4) throws RemoteException;

    void onAudioFocusGrant(String arg1, int arg2, String arg3, Bundle arg4) throws RemoteException;

    void onAudioFocusLoss(String arg1, int arg2, String arg3, Bundle arg4, int arg5) throws RemoteException;

    void onAudioFocusRequest(String arg1, int arg2, String arg3, Bundle arg4, int arg5) throws RemoteException;

    void onChangedBootVolumeType(int arg1) throws RemoteException;

    void onChangedMediaSource(int arg1, String arg2, String arg3) throws RemoteException;

    void onChangedNaviMixLevel(int arg1) throws RemoteException;

    void onChangedScreenSaver(boolean arg1) throws RemoteException;

    void onChangedSpeedGainLevel(int arg1) throws RemoteException;

    void onChangedVolume(int[] arg1, int arg2, int arg3, boolean arg4, int arg5) throws RemoteException;
}

