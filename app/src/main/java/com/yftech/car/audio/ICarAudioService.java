package com.yftech.car.audio;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICarAudioService extends IInterface {
    public static abstract class Stub extends Binder implements ICarAudioService {
        static class Proxy implements ICarAudioService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // com.yftech.car.audio.ICarAudioService
            public int getBootVolumeType() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
                    this.mRemote.transact(8, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioService
            public String getCurrentMediaSource() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.audio.ICarAudioService";
            }

            @Override  // com.yftech.car.audio.ICarAudioService
            public String getMediaSourceWhenShutdown() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
                    this.mRemote.transact(13, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioService
            public int getNaviMixLevel() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
                    this.mRemote.transact(15, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioService
            public int getSpeedGainLevel() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioService
            public int getSuggestedVolumeStreamType(int displayId) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
                    parcel0.writeInt(displayId);
                    this.mRemote.transact(16, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioService
            public int getSuggestedVolumeStreamTypeWithFilter(int displayId, int[] filterChannelList) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
                    parcel0.writeInt(displayId);
                    parcel0.writeIntArray(filterChannelList);
                    this.mRemote.transact(17, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioService
            public int[] getVolumeForVolumeCurveTest(int streamType) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
                    parcel0.writeInt(streamType);
                    this.mRemote.transact(9, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createIntArray();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioService
            public boolean isOnlyOneStreamMute(int streamType) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
                    parcel0.writeInt(streamType);
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

            @Override  // com.yftech.car.audio.ICarAudioService
            public boolean isScreenSaver() throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
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

            @Override  // com.yftech.car.audio.ICarAudioService
            public boolean onlyMuteOneStream(int streamType, boolean mute, int flag) throws RemoteException {
                boolean z1 = true;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
                    parcel0.writeInt(streamType);
                    parcel0.writeInt((mute ? 1 : 0));
                    parcel0.writeInt(flag);
                    this.mRemote.transact(11, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.audio.ICarAudioService
            public void registerCarAudioCallback(ICarAudioCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioService
            public boolean setBootVolumeType(int type) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
                    parcel0.writeInt(type);
                    this.mRemote.transact(7, parcel0, parcel1, 0);
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

            @Override  // com.yftech.car.audio.ICarAudioService
            public boolean setNaviMixLevel(int level) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
                    parcel0.writeInt(level);
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

            @Override  // com.yftech.car.audio.ICarAudioService
            public boolean setSpeedGainLevel(int level) throws RemoteException {
                boolean _result = false;
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
                    parcel0.writeInt(level);
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

            @Override  // com.yftech.car.audio.ICarAudioService
            public void setVolumeForVolumeCurveTest(int streamType, int index, int gain) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
                    parcel0.writeInt(streamType);
                    parcel0.writeInt(index);
                    parcel0.writeInt(gain);
                    this.mRemote.transact(10, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.audio.ICarAudioService
            public void unregisterCarAudioCallback(ICarAudioCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.audio.ICarAudioService");
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

        private static final String DESCRIPTOR = "com.yftech.car.audio.ICarAudioService";
        static final int TRANSACTION_getBootVolumeType = 8;
        static final int TRANSACTION_getCurrentMediaSource = 5;
        static final int TRANSACTION_getMediaSourceWhenShutdown = 13;
        static final int TRANSACTION_getNaviMixLevel = 15;
        static final int TRANSACTION_getSpeedGainLevel = 4;
        static final int TRANSACTION_getSuggestedVolumeStreamType = 16;
        static final int TRANSACTION_getSuggestedVolumeStreamTypeWithFilter = 17;
        static final int TRANSACTION_getVolumeForVolumeCurveTest = 9;
        static final int TRANSACTION_isOnlyOneStreamMute = 12;
        static final int TRANSACTION_isScreenSaver = 6;
        static final int TRANSACTION_onlyMuteOneStream = 11;
        static final int TRANSACTION_registerCarAudioCallback = 1;
        static final int TRANSACTION_setBootVolumeType = 7;
        static final int TRANSACTION_setNaviMixLevel = 14;
        static final int TRANSACTION_setSpeedGainLevel = 3;
        static final int TRANSACTION_setVolumeForVolumeCurveTest = 10;
        static final int TRANSACTION_unregisterCarAudioCallback = 2;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.audio.ICarAudioService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICarAudioService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.audio.ICarAudioService");
            return iInterface0 != null && (iInterface0 instanceof ICarAudioService) ? ((ICarAudioService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int v2 = 0;
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    this.registerCarAudioCallback(com.yftech.car.audio.ICarAudioCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    this.unregisterCarAudioCallback(com.yftech.car.audio.ICarAudioCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    boolean z = this.setSpeedGainLevel(data.readInt());
                    reply.writeNoException();
                    if(z) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    int v3 = this.getSpeedGainLevel();
                    reply.writeNoException();
                    reply.writeInt(v3);
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    String s = this.getCurrentMediaSource();
                    reply.writeNoException();
                    reply.writeString(s);
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    boolean z1 = this.isScreenSaver();
                    reply.writeNoException();
                    if(z1) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    boolean z2 = this.setBootVolumeType(data.readInt());
                    reply.writeNoException();
                    if(z2) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    int v4 = this.getBootVolumeType();
                    reply.writeNoException();
                    reply.writeInt(v4);
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    int[] arr_v = this.getVolumeForVolumeCurveTest(data.readInt());
                    reply.writeNoException();
                    reply.writeIntArray(arr_v);
                    return true;
                }
                case 10: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    this.setVolumeForVolumeCurveTest(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                }
                case 11: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    boolean z3 = this.onlyMuteOneStream(data.readInt(), data.readInt() != 0, data.readInt());
                    reply.writeNoException();
                    if(z3) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 12: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    boolean z4 = this.isOnlyOneStreamMute(data.readInt());
                    reply.writeNoException();
                    if(z4) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 13: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    String s1 = this.getMediaSourceWhenShutdown();
                    reply.writeNoException();
                    reply.writeString(s1);
                    return true;
                }
                case 14: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    boolean z5 = this.setNaviMixLevel(data.readInt());
                    reply.writeNoException();
                    if(z5) {
                        v2 = 1;
                    }
                    reply.writeInt(v2);
                    return true;
                }
                case 15: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    int v5 = this.getNaviMixLevel();
                    reply.writeNoException();
                    reply.writeInt(v5);
                    return true;
                }
                case 16: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    int v6 = this.getSuggestedVolumeStreamType(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(v6);
                    return true;
                }
                case 17: {
                    data.enforceInterface("com.yftech.car.audio.ICarAudioService");
                    int v7 = this.getSuggestedVolumeStreamTypeWithFilter(data.readInt(), data.createIntArray());
                    reply.writeNoException();
                    reply.writeInt(v7);
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.audio.ICarAudioService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    int getBootVolumeType() throws RemoteException;

    String getCurrentMediaSource() throws RemoteException;

    String getMediaSourceWhenShutdown() throws RemoteException;

    int getNaviMixLevel() throws RemoteException;

    int getSpeedGainLevel() throws RemoteException;

    int getSuggestedVolumeStreamType(int arg1) throws RemoteException;

    int getSuggestedVolumeStreamTypeWithFilter(int arg1, int[] arg2) throws RemoteException;

    int[] getVolumeForVolumeCurveTest(int arg1) throws RemoteException;

    boolean isOnlyOneStreamMute(int arg1) throws RemoteException;

    boolean isScreenSaver() throws RemoteException;

    boolean onlyMuteOneStream(int arg1, boolean arg2, int arg3) throws RemoteException;

    void registerCarAudioCallback(ICarAudioCallback arg1) throws RemoteException;

    boolean setBootVolumeType(int arg1) throws RemoteException;

    boolean setNaviMixLevel(int arg1) throws RemoteException;

    boolean setSpeedGainLevel(int arg1) throws RemoteException;

    void setVolumeForVolumeCurveTest(int arg1, int arg2, int arg3) throws RemoteException;

    void unregisterCarAudioCallback(ICarAudioCallback arg1) throws RemoteException;
}

