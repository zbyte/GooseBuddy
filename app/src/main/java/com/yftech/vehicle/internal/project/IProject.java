package com.yftech.vehicle.internal.project;

import com.yftech.vehicle.internal.adapter.IBaseCmd;

public interface IProject extends IBaseCmd {
    public static enum AccountCfg {
        ACCOUNT_1(1),
        ACCOUNT_2(2),
        ACCOUNT_3(3),
        ACCOUNT_4(4),
        ACCOUNT_5(5),
        ACCOUNT_6(6),
        ACCOUNT_7(7),
        ACCOUNT_8(8),
        __UNKNOWN__(-1);

        public final int value;

        private AccountCfg(int v1) {
            this.value = v1;
        }

        public static AccountCfg valueOf(int v) {
            if(v == AccountCfg.ACCOUNT_1.value) {
                return AccountCfg.ACCOUNT_1;
            }
            if(v == AccountCfg.ACCOUNT_2.value) {
                return AccountCfg.ACCOUNT_2;
            }
            if(v == AccountCfg.ACCOUNT_3.value) {
                return AccountCfg.ACCOUNT_3;
            }
            if(v == AccountCfg.ACCOUNT_4.value) {
                return AccountCfg.ACCOUNT_4;
            }
            if(v == AccountCfg.ACCOUNT_5.value) {
                return AccountCfg.ACCOUNT_5;
            }
            if(v == AccountCfg.ACCOUNT_6.value) {
                return AccountCfg.ACCOUNT_6;
            }
            if(v == AccountCfg.ACCOUNT_7.value) {
                return AccountCfg.ACCOUNT_7;
            }
            return v == AccountCfg.ACCOUNT_8.value ? AccountCfg.ACCOUNT_8 : AccountCfg.__UNKNOWN__;
        }
    }

    public static class CarSeartMemoryInfo {
        public AccountCfg accountCfg;
        public DriverSeatPostionCmd cmd;
        public byte puid;

        public CarSeartMemoryInfo(DriverSeatPostionCmd iProject$DriverSeatPostionCmd0, AccountCfg iProject$AccountCfg0) {
            this.cmd = DriverSeatPostionCmd.__UNKNOWN__;
            this.accountCfg = AccountCfg.__UNKNOWN__;
            this.cmd = iProject$DriverSeatPostionCmd0;
            this.accountCfg = iProject$AccountCfg0;
            this.puid = this.puid;
        }

        public CarSeartMemoryInfo(DriverSeatPostionCmd iProject$DriverSeatPostionCmd0, AccountCfg iProject$AccountCfg0, byte b) {
            this.cmd = DriverSeatPostionCmd.__UNKNOWN__;
            this.accountCfg = AccountCfg.__UNKNOWN__;
            this.cmd = iProject$DriverSeatPostionCmd0;
            this.accountCfg = iProject$AccountCfg0;
            this.puid = b;
        }

        public byte[] parseByte(CarSeartMemoryInfo iProject$CarSeartMemoryInfo0) {
            byte[] arr_b = {(byte)0x86, 25, 1, 0, 0, 0};
            arr_b[3] = iProject$CarSeartMemoryInfo0.cmd == DriverSeatPostionCmd.__UNKNOWN__ ? 0 : ((byte)iProject$CarSeartMemoryInfo0.cmd.value);
            arr_b[4] = (byte)iProject$CarSeartMemoryInfo0.accountCfg.value;
            arr_b[5] = 0;
            return arr_b;
        }
    }

    public static enum DriverSeatPostionCmd {
        SAVE(1),
        RECALL(2),
        __UNKNOWN__(-1);

        public final int value;

        private DriverSeatPostionCmd(int v1) {
            this.value = v1;
        }

        public static DriverSeatPostionCmd valueOf(int v) {
            if(v == DriverSeatPostionCmd.SAVE.value) {
                return DriverSeatPostionCmd.SAVE;
            }
            return v == DriverSeatPostionCmd.RECALL.value ? DriverSeatPostionCmd.RECALL : DriverSeatPostionCmd.__UNKNOWN__;
        }
    }

    public static enum OpertionObject {
        SEAT_POSITION(1),
        __UNKNOWN__(-1);

        public final int value;

        private OpertionObject(int v1) {
            this.value = v1;
        }

        public static OpertionObject valueOf(int v) {
            return v == OpertionObject.SEAT_POSITION.value ? OpertionObject.SEAT_POSITION : OpertionObject.__UNKNOWN__;
        }
    }

    public static enum OpertionType {
        MEMORY(0),
        SEARCH(1),
        DELETE(2),
        __UNKNOWN__(-1);

        public final int value;

        private OpertionType(int v1) {
            this.value = v1;
        }

        public static OpertionType valueOf(int v) {
            if(v == OpertionType.MEMORY.value) {
                return OpertionType.MEMORY;
            }
            if(v == OpertionType.SEARCH.value) {
                return OpertionType.SEARCH;
            }
            return v == OpertionType.DELETE.value ? OpertionType.DELETE : OpertionType.__UNKNOWN__;
        }
    }

    public static class PersonalMemoryInfo {
        public AccountCfg accountCfg;
        public byte currentPuid;
        public OpertionObject opObj;
        public OpertionType opType;
        public byte puid;

        public PersonalMemoryInfo(OpertionType iProject$OpertionType0, AccountCfg iProject$AccountCfg0) {
            this.opObj = OpertionObject.SEAT_POSITION;
            this.opType = OpertionType.__UNKNOWN__;
            this.accountCfg = AccountCfg.__UNKNOWN__;
            this.puid = 0;
            this.currentPuid = 0;
            this.opType = iProject$OpertionType0;
            this.accountCfg = iProject$AccountCfg0;
            this.puid = this.puid;
        }

        public PersonalMemoryInfo(OpertionType iProject$OpertionType0, AccountCfg iProject$AccountCfg0, byte b) {
            this.opObj = OpertionObject.SEAT_POSITION;
            this.opType = OpertionType.__UNKNOWN__;
            this.accountCfg = AccountCfg.__UNKNOWN__;
            this.puid = 0;
            this.currentPuid = 0;
            this.opType = iProject$OpertionType0;
            this.accountCfg = iProject$AccountCfg0;
            this.puid = b;
        }

        public PersonalMemoryInfo(OpertionType iProject$OpertionType0, AccountCfg iProject$AccountCfg0, byte b, byte b1) {
            this.opObj = OpertionObject.SEAT_POSITION;
            this.opType = OpertionType.__UNKNOWN__;
            this.accountCfg = AccountCfg.__UNKNOWN__;
            this.puid = 0;
            this.currentPuid = 0;
            this.opType = iProject$OpertionType0;
            this.accountCfg = iProject$AccountCfg0;
            this.puid = b;
            this.currentPuid = b1;
        }

        public byte[] parseByte(PersonalMemoryInfo iProject$PersonalMemoryInfo0) {
            return new byte[]{(byte)0x86, 24, ((byte)iProject$PersonalMemoryInfo0.opObj.value), ((byte)iProject$PersonalMemoryInfo0.opType.value), ((byte)iProject$PersonalMemoryInfo0.accountCfg.value)};
        }

        public static PersonalMemoryInfo valueOf(byte[] arr_b) {
            int v = arr_b[0];
            return new PersonalMemoryInfo(OpertionType.valueOf(arr_b[1] & 0xFF), AccountCfg.valueOf(arr_b[2] & 0xFF), ((byte)(arr_b[3] & 0xFF)), ((byte)(arr_b[4] & 0xFF)));
        }
    }

}

