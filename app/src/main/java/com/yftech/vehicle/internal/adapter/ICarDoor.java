package com.yftech.vehicle.internal.adapter;

public interface ICarDoor extends IBaseApi {
    public static enum AutoUnlockState {
        NOT_ACTIVE(0, 1),
        ACTIVE(1, 2),
        NOT_USED(2, 3),
        NO_COMMAND(3, 0),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private AutoUnlockState(int rx, int tx) {
            this.rx = rx;
            this.tx = tx;
            this.value = this.tx;
        }

        public static AutoUnlockState valueOf(int value) {
            if(value == AutoUnlockState.NOT_ACTIVE.rx) {
                return AutoUnlockState.NOT_ACTIVE;
            }
            if(value == AutoUnlockState.ACTIVE.rx) {
                return AutoUnlockState.ACTIVE;
            }
            if(value == AutoUnlockState.NOT_USED.rx) {
                return AutoUnlockState.NOT_USED;
            }
            return value == AutoUnlockState.NO_COMMAND.rx ? AutoUnlockState.NO_COMMAND : AutoUnlockState.__UNKNOWN__;
        }
    }

    public static enum DoorLockBuzzerRequest {
        TERMINATE(0),
        BUZZER_TYPE1(1),
        BUZZER_TYPE2(2),
        BUZZER_TYPE3(3),
        BUZZER_TYPE4(4),
        BUZZER_TYPE5(5),
        __UNKNOWN__(-1);

        public final int value;

        private DoorLockBuzzerRequest(int value) {
            this.value = value;
        }

        public static DoorLockBuzzerRequest valueOf(int value) {
            if(value == DoorLockBuzzerRequest.TERMINATE.value) {
                return DoorLockBuzzerRequest.TERMINATE;
            }
            if(value == DoorLockBuzzerRequest.BUZZER_TYPE1.value) {
                return DoorLockBuzzerRequest.BUZZER_TYPE1;
            }
            if(value == DoorLockBuzzerRequest.BUZZER_TYPE2.value) {
                return DoorLockBuzzerRequest.BUZZER_TYPE2;
            }
            if(value == DoorLockBuzzerRequest.BUZZER_TYPE3.value) {
                return DoorLockBuzzerRequest.BUZZER_TYPE3;
            }
            if(value == DoorLockBuzzerRequest.BUZZER_TYPE4.value) {
                return DoorLockBuzzerRequest.BUZZER_TYPE4;
            }
            return value == DoorLockBuzzerRequest.BUZZER_TYPE5.value ? DoorLockBuzzerRequest.BUZZER_TYPE5 : DoorLockBuzzerRequest.__UNKNOWN__;
        }
    }

    public static enum DoorLockState {
        UNLOCK(0),
        LOCK(1),
        __UNKNOWN__(-1);

        public final int value;

        private DoorLockState(int value) {
            this.value = value;
        }

        public static DoorLockState valueOf(int value) {
            if(value == DoorLockState.UNLOCK.value) {
                return DoorLockState.UNLOCK;
            }
            return value == DoorLockState.LOCK.value ? DoorLockState.LOCK : DoorLockState.__UNKNOWN__;
        }
    }

    public static enum DoorState {
        CLOSED(0),
        OPEN(1),
        __UNKNOWN__(-1);

        public final int value;

        private DoorState(int value) {
            this.value = value;
        }

        public static DoorState valueOf(int value) {
            if(value == DoorState.CLOSED.value) {
                return DoorState.CLOSED;
            }
            return value == DoorState.OPEN.value ? DoorState.OPEN : DoorState.__UNKNOWN__;
        }
    }

    public static enum EngineHoodState {
        CLOSED(2),
        OPEN(1),
        __UNKNOWN__(-1);

        public final int value;

        private EngineHoodState(int value) {
            this.value = value;
        }

        public static EngineHoodState valueOf(int value) {
            if(value == EngineHoodState.CLOSED.value) {
                return EngineHoodState.CLOSED;
            }
            return value == EngineHoodState.OPEN.value ? EngineHoodState.OPEN : EngineHoodState.__UNKNOWN__;
        }
    }

    public static enum PEPSAutoTrunkOpenState {
        NOT_ACTIVE(0, 1),
        SATO_ACTIVE(1, 2),
        SATO_AND_SOUNDREMINDER_ACTIVE(2, 3),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private PEPSAutoTrunkOpenState(int rx, int tx) {
            this.rx = rx;
            this.tx = tx;
            this.value = this.tx;
        }

        public static PEPSAutoTrunkOpenState valueOf(int value) {
            if(value == PEPSAutoTrunkOpenState.NOT_ACTIVE.rx) {
                return PEPSAutoTrunkOpenState.NOT_ACTIVE;
            }
            if(value == PEPSAutoTrunkOpenState.SATO_ACTIVE.rx) {
                return PEPSAutoTrunkOpenState.SATO_ACTIVE;
            }
            return value == PEPSAutoTrunkOpenState.SATO_AND_SOUNDREMINDER_ACTIVE.rx ? PEPSAutoTrunkOpenState.SATO_AND_SOUNDREMINDER_ACTIVE : PEPSAutoTrunkOpenState.__UNKNOWN__;
        }
    }

    public static enum PLGMControl {
        CONTROL_1(0),
        __UNKNOWN__(-1);

        public final int value;

        private PLGMControl(int value) {
            this.value = value;
        }

        public static PLGMControl valueOf(int value) {
            return value == PLGMControl.CONTROL_1.value ? PLGMControl.CONTROL_1 : PLGMControl.__UNKNOWN__;
        }
    }

    public static enum PLGMFunction {
        FUNCTION_1(0),
        ENABLE(2),
        DISABLE(1),
        __UNKNOWN__(-1);

        public final int value;

        private PLGMFunction(int value) {
            this.value = value;
        }

        public static PLGMFunction valueOf(int value) {
            if(value == PLGMFunction.FUNCTION_1.value) {
                return PLGMFunction.FUNCTION_1;
            }
            if(value == PLGMFunction.ENABLE.value) {
                return PLGMFunction.ENABLE;
            }
            return value == PLGMFunction.DISABLE.value ? PLGMFunction.DISABLE : PLGMFunction.__UNKNOWN__;
        }
    }

    public static enum PLGMMaxLevel {
        LEVEL_1(0),
        __UNKNOWN__(-1);

        public final int value;

        private PLGMMaxLevel(int value) {
            this.value = value;
        }

        public static PLGMMaxLevel valueOf(int value) {
            return value == PLGMMaxLevel.LEVEL_1.value ? PLGMMaxLevel.LEVEL_1 : PLGMMaxLevel.__UNKNOWN__;
        }
    }

    public static enum PSDDoorSpeed {
        LOW_SPEED(1),
        HIGH_SPEED(2),
        __UNKNOWN__(-1);

        public final int value;

        private PSDDoorSpeed(int value) {
            this.value = value;
        }

        public static PSDDoorSpeed valueOf(int value) {
            if(value == PSDDoorSpeed.LOW_SPEED.value) {
                return PSDDoorSpeed.LOW_SPEED;
            }
            return value == PSDDoorSpeed.HIGH_SPEED.value ? PSDDoorSpeed.HIGH_SPEED : PSDDoorSpeed.__UNKNOWN__;
        }
    }

    public static enum RemoteUnlockMode {
        ALL_DOORS(0, 1),
        DRIVER_DOOR(1, 2),
        __UNKNOWN__(-1, -1);

        private final int rx;
        private final int tx;
        public final int value;

        private RemoteUnlockMode(int rx, int tx) {
            this.rx = rx;
            this.tx = tx;
            this.value = this.tx;
        }

        public static RemoteUnlockMode valueOf(int value) {
            if(value == RemoteUnlockMode.ALL_DOORS.rx) {
                return RemoteUnlockMode.ALL_DOORS;
            }
            return value == RemoteUnlockMode.DRIVER_DOOR.rx ? RemoteUnlockMode.DRIVER_DOOR : RemoteUnlockMode.__UNKNOWN__;
        }
    }

    public static enum SlidingDoorCmd {
        STOP(1),
        OPEN(2),
        CLOSE(3),
        __UNKNOWN__(-1);

        public final int value;

        private SlidingDoorCmd(int value) {
            this.value = value;
        }

        public static SlidingDoorCmd valueOf(int value) {
            if(value == SlidingDoorCmd.STOP.value) {
                return SlidingDoorCmd.STOP;
            }
            if(value == SlidingDoorCmd.OPEN.value) {
                return SlidingDoorCmd.OPEN;
            }
            return value == SlidingDoorCmd.CLOSE.value ? SlidingDoorCmd.CLOSE : SlidingDoorCmd.__UNKNOWN__;
        }
    }

    public static enum SlidingDoorOperation {
        INITIAL_MODE(0),
        STOP(1),
        OPENNING(2),
        CLOSING(3),
        __UNKNOWN__(-1);

        public final int value;

        private SlidingDoorOperation(int value) {
            this.value = value;
        }

        public static SlidingDoorOperation valueOf(int value) {
            if(value == SlidingDoorOperation.INITIAL_MODE.value) {
                return SlidingDoorOperation.INITIAL_MODE;
            }
            if(value == SlidingDoorOperation.STOP.value) {
                return SlidingDoorOperation.STOP;
            }
            if(value == SlidingDoorOperation.OPENNING.value) {
                return SlidingDoorOperation.OPENNING;
            }
            return value == SlidingDoorOperation.CLOSING.value ? SlidingDoorOperation.CLOSING : SlidingDoorOperation.__UNKNOWN__;
        }
    }

    public static enum SlidingDoorState {
        FULL_LATCH(0),
        HALF_LATCH(1),
        LATCH_OPEN(2),
        FULL_OPEN(3),
        __UNKNOWN__(-1);

        public final int value;

        private SlidingDoorState(int value) {
            this.value = value;
        }

        public static SlidingDoorState valueOf(int value) {
            if(value == SlidingDoorState.FULL_LATCH.value) {
                return SlidingDoorState.FULL_LATCH;
            }
            if(value == SlidingDoorState.HALF_LATCH.value) {
                return SlidingDoorState.HALF_LATCH;
            }
            if(value == SlidingDoorState.LATCH_OPEN.value) {
                return SlidingDoorState.LATCH_OPEN;
            }
            return value == SlidingDoorState.FULL_OPEN.value ? SlidingDoorState.FULL_OPEN : SlidingDoorState.__UNKNOWN__;
        }
    }

    public static enum TailDoorCmd {
        STOP(1),
        FULLY_OPEN(2),
        FULLY_CLOSE(3),
        OPEN_TWENTY_PERCENT(4),
        OPEN_FORTY_PERCENT(5),
        OPEN_SIXTY_PERCENT(6),
        OPEN_EIGHTY_PERCENT(7),
        __UNKNOWN__(-1);

        public final int value;

        private TailDoorCmd(int value) {
            this.value = value;
        }

        public static TailDoorCmd valueOf(int value) {
            if(value == TailDoorCmd.STOP.value) {
                return TailDoorCmd.STOP;
            }
            if(value == TailDoorCmd.FULLY_OPEN.value) {
                return TailDoorCmd.FULLY_OPEN;
            }
            if(value == TailDoorCmd.FULLY_CLOSE.value) {
                return TailDoorCmd.FULLY_CLOSE;
            }
            if(value == TailDoorCmd.OPEN_TWENTY_PERCENT.value) {
                return TailDoorCmd.OPEN_TWENTY_PERCENT;
            }
            if(value == TailDoorCmd.OPEN_FORTY_PERCENT.value) {
                return TailDoorCmd.OPEN_FORTY_PERCENT;
            }
            if(value == TailDoorCmd.OPEN_SIXTY_PERCENT.value) {
                return TailDoorCmd.OPEN_SIXTY_PERCENT;
            }
            return value == TailDoorCmd.OPEN_EIGHTY_PERCENT.value ? TailDoorCmd.OPEN_EIGHTY_PERCENT : TailDoorCmd.__UNKNOWN__;
        }
    }

    public static enum TailDoorState {
        FULLY_OPENED(1),
        FULLY_CLOSED(2),
        OPENING(3),
        CLOSING(4),
        HOLD(5),
        TG_BRAKE(6),
        __UNKNOWN__(-1);

        public final int value;

        private TailDoorState(int value) {
            this.value = value;
        }

        public static TailDoorState valueOf(int value) {
            if(value == TailDoorState.FULLY_OPENED.value) {
                return TailDoorState.FULLY_OPENED;
            }
            if(value == TailDoorState.FULLY_CLOSED.value) {
                return TailDoorState.FULLY_CLOSED;
            }
            if(value == TailDoorState.OPENING.value) {
                return TailDoorState.OPENING;
            }
            if(value == TailDoorState.CLOSING.value) {
                return TailDoorState.CLOSING;
            }
            if(value == TailDoorState.HOLD.value) {
                return TailDoorState.HOLD;
            }
            return value == TailDoorState.TG_BRAKE.value ? TailDoorState.TG_BRAKE : TailDoorState.__UNKNOWN__;
        }
    }

    public static final int AUTO_UNLOCK_SETTING = 53;
    public static final int AUTO_UNLOCK_STATE = 0x94;
    public static final int DOOR_LOCK_BUZZER_STATE = 694;
    public static final int DOOR_RIGHT_LOCK_BUZZER_STATE = 697;
    public static final int DRIVER_DOOR_LOCK_STATE = 402;
    public static final int DRIVER_DOOR_STATE = 0xBC;
    public static final int ENGINE_HOOD_STATE = 283;
    public static final int HOOD_DOOR_STATE = 210;
    public static final int LOCK_UNLOCK_SOUND_SETTING = 55;
    public static final int LOCK_UNLOCK_SOUND_STATE = 150;
    public static final int PASSENGER_DOOR_LOCK_STATE = 403;
    public static final int PASSENGER_DOOR_STATE = 0xD3;
    public static final int PEPS_AUTO_TRUNK_OPEN_SETTING = 58;
    public static final int PEPS_AUTO_TRUNK_OPEN_STATE = 0x99;
    public static final int PEPS_UNLOCK_SETTING = 56;
    public static final int PEPS_UNLOCK_STATE = 0x97;
    public static final int PEPS_WALK_AWAY_LOCK_SETTING = 57;
    public static final int PEPS_WALK_AWAY_LOCK_STATE = 0x98;
    public static final int PLGM_CONTROL = -1;
    public static final int PLGM_FUNCTION_SETTING = 61;
    public static final int PLGM_MAX_LEVEL_SETTING = 60;
    public static final int PSD_DOOR_SPEED_L = 0x9E;
    public static final int PSD_DOOR_SPEED_L_SETTING = 0xE5;
    public static final int PSD_DOOR_SPEED_R = 0x9F;
    public static final int PSD_DOOR_SPEED_R_SETTING = 230;
    public static final int REAR_LEFT_DOOR_STATE = 0xD4;
    public static final int REAR_RIGHT_DOOR_STATE = 0xD5;
    public static final int REMOTE_UNLOCK_SETTING = 52;
    public static final int REMOTE_UNLOCK_STATE = 0x93;
    public static final int SLIDING_DOOR_CMD_L_SETTING = 0xF1;
    public static final int SLIDING_DOOR_CMD_R_SETTING = 0xF0;
    public static final int SLIDING_DOOR_MODE = 0xE3;
    public static final int SLIDING_DOOR_MODE_SETTING = 0xE4;
    public static final int SLIDING_DOOR_MODE_STATUS = 0x2A0;
    public static final int SLIDING_DOOR_OPERATION_L = 0xF3;
    public static final int SLIDING_DOOR_OPERATION_R = 0xF5;
    public static final int SLIDING_DOOR_STATE_L = 0xF2;
    public static final int SLIDING_DOOR_STATE_R = 0xF4;
    public static final int SPEED_AUTO_LOCK_SETTING = 54;
    public static final int SPEED_AUTO_LOCK_STATE = 0x95;
    public static final int TAIL_DOOR_CMD_SETTING = 59;
    public static final int TAIL_DOOR_MAX_POSITION_MEMORY_SETTING = 289;
    public static final int TAIL_DOOR_MODE = 0x9D;
    public static final int TAIL_DOOR_PERCENT = 0x9A;
    public static final int TAIL_DOOR_POSITION_MEMORY_CLEAR_SETTING = 286;
    public static final int TAIL_DOOR_STATE = 0x9C;
    public static final int TAIL_DOOR_TRAVEL_PERCENT = 0x9B;
    public static final int TRUNK_DOOR_STATE = 0xD6;

}

