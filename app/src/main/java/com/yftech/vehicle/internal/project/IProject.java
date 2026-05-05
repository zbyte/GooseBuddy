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

        private AccountCfg(int value) {
            this.value = value;
        }

        public static AccountCfg valueOf(int value) {
            if(value == AccountCfg.ACCOUNT_1.value) {
                return AccountCfg.ACCOUNT_1;
            }
            if(value == AccountCfg.ACCOUNT_2.value) {
                return AccountCfg.ACCOUNT_2;
            }
            if(value == AccountCfg.ACCOUNT_3.value) {
                return AccountCfg.ACCOUNT_3;
            }
            if(value == AccountCfg.ACCOUNT_4.value) {
                return AccountCfg.ACCOUNT_4;
            }
            if(value == AccountCfg.ACCOUNT_5.value) {
                return AccountCfg.ACCOUNT_5;
            }
            if(value == AccountCfg.ACCOUNT_6.value) {
                return AccountCfg.ACCOUNT_6;
            }
            if(value == AccountCfg.ACCOUNT_7.value) {
                return AccountCfg.ACCOUNT_7;
            }
            return value == AccountCfg.ACCOUNT_8.value ? AccountCfg.ACCOUNT_8 : AccountCfg.__UNKNOWN__;
        }
    }

    public static class CarSeartMemoryInfo {
        public AccountCfg accountCfg;
        public DriverSeatPostionCmd cmd;
        public byte puid;

        public CarSeartMemoryInfo(DriverSeatPostionCmd cmd, AccountCfg accountCfg) {
            this.cmd = DriverSeatPostionCmd.__UNKNOWN__;
            this.accountCfg = AccountCfg.__UNKNOWN__;
            this.cmd = cmd;
            this.accountCfg = accountCfg;
            this.puid = this.puid;
        }

        public CarSeartMemoryInfo(DriverSeatPostionCmd cmd, AccountCfg accountCfg, byte puid) {
            this.cmd = DriverSeatPostionCmd.__UNKNOWN__;
            this.accountCfg = AccountCfg.__UNKNOWN__;
            this.cmd = cmd;
            this.accountCfg = accountCfg;
            this.puid = puid;
        }

        public byte[] parseByte(CarSeartMemoryInfo info) {
            byte[] arr = {(byte)0x86, 25, 1, 0, 0, 0};
            arr[3] = info.cmd == DriverSeatPostionCmd.__UNKNOWN__ ? 0 : ((byte)info.cmd.value);
            arr[4] = (byte)info.accountCfg.value;
            arr[5] = 0;
            return arr;
        }
    }

    public static enum DriverSeatPostionCmd {
        SAVE(1),
        RECALL(2),
        __UNKNOWN__(-1);

        public final int value;

        private DriverSeatPostionCmd(int value) {
            this.value = value;
        }

        public static DriverSeatPostionCmd valueOf(int value) {
            if(value == DriverSeatPostionCmd.SAVE.value) {
                return DriverSeatPostionCmd.SAVE;
            }
            return value == DriverSeatPostionCmd.RECALL.value ? DriverSeatPostionCmd.RECALL : DriverSeatPostionCmd.__UNKNOWN__;
        }
    }

    public static enum OpertionObject {
        SEAT_POSITION(1),
        __UNKNOWN__(-1);

        public final int value;

        private OpertionObject(int value) {
            this.value = value;
        }

        public static OpertionObject valueOf(int value) {
            return value == OpertionObject.SEAT_POSITION.value ? OpertionObject.SEAT_POSITION : OpertionObject.__UNKNOWN__;
        }
    }

    public static enum OpertionType {
        MEMORY(0),
        SEARCH(1),
        DELETE(2),
        __UNKNOWN__(-1);

        public final int value;

        private OpertionType(int value) {
            this.value = value;
        }

        public static OpertionType valueOf(int value) {
            if(value == OpertionType.MEMORY.value) {
                return OpertionType.MEMORY;
            }
            if(value == OpertionType.SEARCH.value) {
                return OpertionType.SEARCH;
            }
            return value == OpertionType.DELETE.value ? OpertionType.DELETE : OpertionType.__UNKNOWN__;
        }
    }

    public static class PersonalMemoryInfo {
        public AccountCfg accountCfg;
        public byte currentPuid;
        public OpertionObject opObj;
        public OpertionType opType;
        public byte puid;

        public PersonalMemoryInfo(OpertionType opType, AccountCfg accountCfg) {
            this.opObj = OpertionObject.SEAT_POSITION;
            this.opType = OpertionType.__UNKNOWN__;
            this.accountCfg = AccountCfg.__UNKNOWN__;
            this.puid = 0;
            this.currentPuid = 0;
            this.opType = opType;
            this.accountCfg = accountCfg;
            this.puid = this.puid;
        }

        public PersonalMemoryInfo(OpertionType opType, AccountCfg accountCfg, byte puid) {
            this.opObj = OpertionObject.SEAT_POSITION;
            this.opType = OpertionType.__UNKNOWN__;
            this.accountCfg = AccountCfg.__UNKNOWN__;
            this.puid = 0;
            this.currentPuid = 0;
            this.opType = opType;
            this.accountCfg = accountCfg;
            this.puid = puid;
        }

        public PersonalMemoryInfo(OpertionType opType, AccountCfg accountCfg, byte puid, byte currentPuid) {
            this.opObj = OpertionObject.SEAT_POSITION;
            this.opType = OpertionType.__UNKNOWN__;
            this.accountCfg = AccountCfg.__UNKNOWN__;
            this.puid = 0;
            this.currentPuid = 0;
            this.opType = opType;
            this.accountCfg = accountCfg;
            this.puid = puid;
            this.currentPuid = currentPuid;
        }

        public byte[] parseByte(PersonalMemoryInfo info) {
            return new byte[]{(byte)0x86, 24, ((byte)info.opObj.value), ((byte)info.opType.value), ((byte)info.accountCfg.value)};
        }

        public static PersonalMemoryInfo valueOf(byte[] value) {
            int v = value[0];
            return new PersonalMemoryInfo(OpertionType.valueOf(value[1] & 0xFF), AccountCfg.valueOf(value[2] & 0xFF), ((byte)(value[3] & 0xFF)), ((byte)(value[4] & 0xFF)));
        }
    }

}

