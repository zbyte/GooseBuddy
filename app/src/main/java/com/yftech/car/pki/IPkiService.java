package com.yftech.car.pki;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPkiService extends IInterface {
    public static abstract class Stub extends Binder implements IPkiService {
        static class Proxy implements IPkiService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // com.yftech.car.pki.IPkiService
            public int did() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    this.mRemote.transact(19, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public String getCertFilePath() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    this.mRemote.transact(18, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public int getCertStatus() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    this.mRemote.transact(17, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.yftech.car.pki.IPkiService";
            }

            @Override  // com.yftech.car.pki.IPkiService
            public int getSymmProgress() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    this.mRemote.transact(16, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public String getVersion() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    this.mRemote.transact(13, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public int symmDecryptFile(String path, String key, String iv, int symmType, int symmMode, String desPath) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    parcel0.writeString(path);
                    parcel0.writeString(key);
                    parcel0.writeString(iv);
                    parcel0.writeInt(symmType);
                    parcel0.writeInt(symmMode);
                    parcel0.writeString(desPath);
                    this.mRemote.transact(15, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public String szitrusCertParse() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    this.mRemote.transact(12, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public int szitrusCertPass(String pwd) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    parcel0.writeString(pwd);
                    this.mRemote.transact(11, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public int szitrusCertStatus() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    this.mRemote.transact(10, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public int szitrusDid() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    this.mRemote.transact(9, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public int szitrusSignature() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public void szitrusSync(String vin, String sn) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    parcel0.writeString(vin);
                    parcel0.writeString(sn);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public int szitrusSyncCert() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    this.mRemote.transact(5, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public int szitrusSyncDevice(String vin, String sn) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    parcel0.writeString(vin);
                    parcel0.writeString(sn);
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public int szitrusSyncDomain(String ip, int port) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    parcel0.writeString(ip);
                    parcel0.writeInt(port);
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public int szitrusSyncPolicy(int cycleDay, int cycleHour, int cycleMin, int did) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    parcel0.writeInt(cycleDay);
                    parcel0.writeInt(cycleHour);
                    parcel0.writeInt(cycleMin);
                    parcel0.writeInt(did);
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public int szitrusVerify() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    this.mRemote.transact(8, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public String szitrusgetVersion() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // com.yftech.car.pki.IPkiService
            public int verify(String type, String sign, String src, String dataType, String encode) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("com.yftech.car.pki.IPkiService");
                    parcel0.writeString(type);
                    parcel0.writeString(sign);
                    parcel0.writeString(src);
                    parcel0.writeString(dataType);
                    parcel0.writeString(encode);
                    this.mRemote.transact(14, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "com.yftech.car.pki.IPkiService";
        static final int TRANSACTION_did = 19;
        static final int TRANSACTION_getCertFilePath = 18;
        static final int TRANSACTION_getCertStatus = 17;
        static final int TRANSACTION_getSymmProgress = 16;
        static final int TRANSACTION_getVersion = 13;
        static final int TRANSACTION_symmDecryptFile = 15;
        static final int TRANSACTION_szitrusCertParse = 12;
        static final int TRANSACTION_szitrusCertPass = 11;
        static final int TRANSACTION_szitrusCertStatus = 10;
        static final int TRANSACTION_szitrusDid = 9;
        static final int TRANSACTION_szitrusSignature = 7;
        static final int TRANSACTION_szitrusSync = 2;
        static final int TRANSACTION_szitrusSyncCert = 5;
        static final int TRANSACTION_szitrusSyncDevice = 3;
        static final int TRANSACTION_szitrusSyncDomain = 4;
        static final int TRANSACTION_szitrusSyncPolicy = 6;
        static final int TRANSACTION_szitrusVerify = 8;
        static final int TRANSACTION_szitrusgetVersion = 1;
        static final int TRANSACTION_verify = 14;

        public Stub() {
            this.attachInterface(this, "com.yftech.car.pki.IPkiService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IPkiService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("com.yftech.car.pki.IPkiService");
            return iInterface0 != null && (iInterface0 instanceof IPkiService) ? ((IPkiService)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    String s = this.szitrusgetVersion();
                    reply.writeNoException();
                    reply.writeString(s);
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    this.szitrusSync(data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    int v2 = this.szitrusSyncDevice(data.readString(), data.readString());
                    reply.writeNoException();
                    reply.writeInt(v2);
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    int v3 = this.szitrusSyncDomain(data.readString(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(v3);
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    int v4 = this.szitrusSyncCert();
                    reply.writeNoException();
                    reply.writeInt(v4);
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    int v5 = this.szitrusSyncPolicy(data.readInt(), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(v5);
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    int v6 = this.szitrusSignature();
                    reply.writeNoException();
                    reply.writeInt(v6);
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    int v7 = this.szitrusVerify();
                    reply.writeNoException();
                    reply.writeInt(v7);
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    int v8 = this.szitrusDid();
                    reply.writeNoException();
                    reply.writeInt(v8);
                    return true;
                }
                case 10: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    int v9 = this.szitrusCertStatus();
                    reply.writeNoException();
                    reply.writeInt(v9);
                    return true;
                }
                case 11: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    int v10 = this.szitrusCertPass(data.readString());
                    reply.writeNoException();
                    reply.writeInt(v10);
                    return true;
                }
                case 12: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    String s1 = this.szitrusCertParse();
                    reply.writeNoException();
                    reply.writeString(s1);
                    return true;
                }
                case 13: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    String s2 = this.getVersion();
                    reply.writeNoException();
                    reply.writeString(s2);
                    return true;
                }
                case 14: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    int v11 = this.verify(data.readString(), data.readString(), data.readString(), data.readString(), data.readString());
                    reply.writeNoException();
                    reply.writeInt(v11);
                    return true;
                }
                case 15: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    int v12 = this.symmDecryptFile(data.readString(), data.readString(), data.readString(), data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    reply.writeInt(v12);
                    return true;
                }
                case 16: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    int v13 = this.getSymmProgress();
                    reply.writeNoException();
                    reply.writeInt(v13);
                    return true;
                }
                case 17: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    int v14 = this.getCertStatus();
                    reply.writeNoException();
                    reply.writeInt(v14);
                    return true;
                }
                case 18: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    String s3 = this.getCertFilePath();
                    reply.writeNoException();
                    reply.writeString(s3);
                    return true;
                }
                case 19: {
                    data.enforceInterface("com.yftech.car.pki.IPkiService");
                    int v15 = this.did();
                    reply.writeNoException();
                    reply.writeInt(v15);
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("com.yftech.car.pki.IPkiService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
    }

    int did() throws RemoteException;

    String getCertFilePath() throws RemoteException;

    int getCertStatus() throws RemoteException;

    int getSymmProgress() throws RemoteException;

    String getVersion() throws RemoteException;

    int symmDecryptFile(String arg1, String arg2, String arg3, int arg4, int arg5, String arg6) throws RemoteException;

    String szitrusCertParse() throws RemoteException;

    int szitrusCertPass(String arg1) throws RemoteException;

    int szitrusCertStatus() throws RemoteException;

    int szitrusDid() throws RemoteException;

    int szitrusSignature() throws RemoteException;

    void szitrusSync(String arg1, String arg2) throws RemoteException;

    int szitrusSyncCert() throws RemoteException;

    int szitrusSyncDevice(String arg1, String arg2) throws RemoteException;

    int szitrusSyncDomain(String arg1, int arg2) throws RemoteException;

    int szitrusSyncPolicy(int arg1, int arg2, int arg3, int arg4) throws RemoteException;

    int szitrusVerify() throws RemoteException;

    String szitrusgetVersion() throws RemoteException;

    int verify(String arg1, String arg2, String arg3, String arg4, String arg5) throws RemoteException;
}

