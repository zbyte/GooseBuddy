package com.yftech.vehicle.internal.adapter;

public interface ICarInfo extends IBaseApi {
    public static enum CarReadyIndicator {
        LIGHTS_OUT(0),
        BLINKING(1),
        LIGHTING(2),
        __UNKNOWN__(-1);

        public final int value;

        private CarReadyIndicator(int value) {
            this.value = value;
        }

        public static CarReadyIndicator valueOf(int value) {
            if(value == CarReadyIndicator.LIGHTS_OUT.value) {
                return CarReadyIndicator.LIGHTS_OUT;
            }
            if(value == CarReadyIndicator.BLINKING.value) {
                return CarReadyIndicator.BLINKING;
            }
            return value == CarReadyIndicator.LIGHTING.value ? CarReadyIndicator.LIGHTING : CarReadyIndicator.__UNKNOWN__;
        }
    }

    public static enum DayNightMode {
        DAY(0),
        TWILIGHT(1),
        NIGHT(2),
        __UNKNOWN__(-1);

        public final int value;

        private DayNightMode(int value) {
            this.value = value;
        }

        public static DayNightMode valueOf(int value) {
            if(value == DayNightMode.DAY.value) {
                return DayNightMode.DAY;
            }
            if(value == DayNightMode.TWILIGHT.value) {
                return DayNightMode.TWILIGHT;
            }
            return value == DayNightMode.NIGHT.value ? DayNightMode.NIGHT : DayNightMode.__UNKNOWN__;
        }
    }

    public static enum EngineCrankState {
        NOT_ON_CRANK(0),
        CRANK(1),
        __UNKNOWN__(-1);

        public final int value;

        private EngineCrankState(int value) {
            this.value = value;
        }

        public static EngineCrankState valueOf(int value) {
            if(value == EngineCrankState.NOT_ON_CRANK.value) {
                return EngineCrankState.NOT_ON_CRANK;
            }
            return value == EngineCrankState.CRANK.value ? EngineCrankState.CRANK : EngineCrankState.__UNKNOWN__;
        }
    }

    public static enum GearPosition {
        GEAR_FIRST(1),
        GEAR_TOW(2),
        GEAR_THIRD(3),
        GEAR_FOUR(4),
        GEAR_FIVE(5),
        GEAR_SIX(6),
        GEAR_SEVEN(7),
        GEAR_EIGHT(8),
        GEAR_NINE(9),
        SPORT(11),
        DRIVE(12),
        PARKING(13),
        REVERSE(14),
        NEUTRAL(15),
        __UNKNOWN__(-1);

        public final int value;

        private GearPosition(int value) {
            this.value = value;
        }

        public static GearPosition valueOf(int value) {
            if(value == GearPosition.GEAR_FIRST.value) {
                return GearPosition.GEAR_FIRST;
            }
            if(value == GearPosition.GEAR_TOW.value) {
                return GearPosition.GEAR_TOW;
            }
            if(value == GearPosition.GEAR_THIRD.value) {
                return GearPosition.GEAR_THIRD;
            }
            if(value == GearPosition.GEAR_FOUR.value) {
                return GearPosition.GEAR_FOUR;
            }
            if(value == GearPosition.GEAR_FIVE.value) {
                return GearPosition.GEAR_FIVE;
            }
            if(value == GearPosition.GEAR_SIX.value) {
                return GearPosition.GEAR_SIX;
            }
            if(value == GearPosition.GEAR_SEVEN.value) {
                return GearPosition.GEAR_SEVEN;
            }
            if(value == GearPosition.GEAR_EIGHT.value) {
                return GearPosition.GEAR_EIGHT;
            }
            if(value == GearPosition.GEAR_NINE.value) {
                return GearPosition.GEAR_NINE;
            }
            if(value == GearPosition.SPORT.value) {
                return GearPosition.SPORT;
            }
            if(value == GearPosition.DRIVE.value) {
                return GearPosition.DRIVE;
            }
            if(value == GearPosition.PARKING.value) {
                return GearPosition.PARKING;
            }
            if(value == GearPosition.REVERSE.value) {
                return GearPosition.REVERSE;
            }
            return value == GearPosition.NEUTRAL.value ? GearPosition.NEUTRAL : GearPosition.__UNKNOWN__;
        }
    }

    public static enum GearPositionA9E {
        INVALID(0),
        DRIVE(1),
        NEUTRAL(2),
        REVERSE(3),
        PARKING(4),
        __UNKNOWN__(-1);

        public final int value;

        private GearPositionA9E(int value) {
            this.value = value;
        }

        public static GearPositionA9E valueOf(int value) {
            if(value == GearPositionA9E.INVALID.value) {
                return GearPositionA9E.INVALID;
            }
            if(value == GearPositionA9E.DRIVE.value) {
                return GearPositionA9E.DRIVE;
            }
            if(value == GearPositionA9E.NEUTRAL.value) {
                return GearPositionA9E.NEUTRAL;
            }
            if(value == GearPositionA9E.REVERSE.value) {
                return GearPositionA9E.REVERSE;
            }
            return value == GearPositionA9E.PARKING.value ? GearPositionA9E.PARKING : GearPositionA9E.__UNKNOWN__;
        }
    }

    public static enum GearPositionHEV {
        INVALID(0),
        PARKING(1),
        REVERSE(2),
        NEUTRAL(3),
        DRIVE(4),
        DRIVE_INCREASE(5),
        DRIVE_REDUCE(6),
        SPORT(7),
        MANUAL(8),
        MANUAL_INCREASE(9),
        MANUAL_REDUCE(10),
        __UNKNOWN__(-1);

        public final int value;

        private GearPositionHEV(int value) {
            this.value = value;
        }

        public static GearPositionHEV valueOf(int value) {
            if(value == GearPositionHEV.INVALID.value) {
                return GearPositionHEV.INVALID;
            }
            if(value == GearPositionHEV.PARKING.value) {
                return GearPositionHEV.PARKING;
            }
            if(value == GearPositionHEV.REVERSE.value) {
                return GearPositionHEV.REVERSE;
            }
            if(value == GearPositionHEV.NEUTRAL.value) {
                return GearPositionHEV.NEUTRAL;
            }
            if(value == GearPositionHEV.DRIVE.value) {
                return GearPositionHEV.DRIVE;
            }
            if(value == GearPositionHEV.DRIVE_INCREASE.value) {
                return GearPositionHEV.DRIVE_INCREASE;
            }
            if(value == GearPositionHEV.DRIVE_REDUCE.value) {
                return GearPositionHEV.DRIVE_REDUCE;
            }
            if(value == GearPositionHEV.SPORT.value) {
                return GearPositionHEV.SPORT;
            }
            if(value == GearPositionHEV.MANUAL.value) {
                return GearPositionHEV.MANUAL;
            }
            if(value == GearPositionHEV.MANUAL_INCREASE.value) {
                return GearPositionHEV.MANUAL_INCREASE;
            }
            return value == GearPositionHEV.MANUAL_REDUCE.value ? GearPositionHEV.MANUAL_REDUCE : GearPositionHEV.__UNKNOWN__;
        }
    }

    public static enum LowBatteryWarningLevel {
        LEVEL_1(1),
        LEVEL_2(2),
        LEVEL_3(3),
        LEVEL_4(4),
        LEVEL_5(5),
        OFF(0),
        __UNKNOWN__(-1);

        public final int value;

        private LowBatteryWarningLevel(int value) {
            this.value = value;
        }

        public static LowBatteryWarningLevel valueOf(int value) {
            if(value == LowBatteryWarningLevel.LEVEL_1.value) {
                return LowBatteryWarningLevel.LEVEL_1;
            }
            if(value == LowBatteryWarningLevel.LEVEL_2.value) {
                return LowBatteryWarningLevel.LEVEL_2;
            }
            if(value == LowBatteryWarningLevel.LEVEL_3.value) {
                return LowBatteryWarningLevel.LEVEL_3;
            }
            if(value == LowBatteryWarningLevel.LEVEL_4.value) {
                return LowBatteryWarningLevel.LEVEL_4;
            }
            if(value == LowBatteryWarningLevel.LEVEL_5.value) {
                return LowBatteryWarningLevel.LEVEL_5;
            }
            return value == LowBatteryWarningLevel.OFF.value ? LowBatteryWarningLevel.OFF : LowBatteryWarningLevel.__UNKNOWN__;
        }
    }

    public static enum ParkingBrakeState {
        PARKING_BRAKE_NOT_APPLIED(1),
        PARKING_BRAKE_APPLIED(2),
        UNAVAILABLE(3),
        __UNKNOWN__(-1);

        public final int value;

        private ParkingBrakeState(int value) {
            this.value = value;
        }

        public static ParkingBrakeState valueOf(int value) {
            if(value == ParkingBrakeState.PARKING_BRAKE_NOT_APPLIED.value) {
                return ParkingBrakeState.PARKING_BRAKE_NOT_APPLIED;
            }
            if(value == ParkingBrakeState.PARKING_BRAKE_APPLIED.value) {
                return ParkingBrakeState.PARKING_BRAKE_APPLIED;
            }
            return value == ParkingBrakeState.UNAVAILABLE.value ? ParkingBrakeState.UNAVAILABLE : ParkingBrakeState.__UNKNOWN__;
        }
    }

    public static enum PowerMode {
        ACC(1),
        ON(2),
        CRANK(3),
        OFF(0),
        __UNKNOWN__(-1);

        public final int value;

        private PowerMode(int value) {
            this.value = value;
        }

        public static PowerMode valueOf(int value) {
            if(value == PowerMode.ACC.value) {
                return PowerMode.ACC;
            }
            if(value == PowerMode.ON.value) {
                return PowerMode.ON;
            }
            if(value == PowerMode.CRANK.value) {
                return PowerMode.CRANK;
            }
            return value == PowerMode.OFF.value ? PowerMode.OFF : PowerMode.__UNKNOWN__;
        }
    }

    public static enum RearGearState {
        NOT_ENGAGED(1),
        ENGAGED(2),
        __UNKNOWN__(-1);

        public final int value;

        private RearGearState(int value) {
            this.value = value;
        }

        public static RearGearState valueOf(int value) {
            if(value == RearGearState.NOT_ENGAGED.value) {
                return RearGearState.NOT_ENGAGED;
            }
            return value == RearGearState.ENGAGED.value ? RearGearState.ENGAGED : RearGearState.__UNKNOWN__;
        }
    }

    public static enum SleepWakeUpCommand {
        GO_TO_SLEEP(0),
        WAKEUP(3),
        __UNKNOWN__(-1);

        public final int value;

        private SleepWakeUpCommand(int value) {
            this.value = value;
        }

        public static SleepWakeUpCommand valueOf(int value) {
            if(value == SleepWakeUpCommand.GO_TO_SLEEP.value) {
                return SleepWakeUpCommand.GO_TO_SLEEP;
            }
            return value == SleepWakeUpCommand.WAKEUP.value ? SleepWakeUpCommand.WAKEUP : SleepWakeUpCommand.__UNKNOWN__;
        }
    }

    public static enum VehicleModeBroadcast {
        NORMAL(0),
        OTA(1),
        __UNKNOWN__(-1);

        public final int value;

        private VehicleModeBroadcast(int value) {
            this.value = value;
        }

        public static VehicleModeBroadcast valueOf(int value) {
            if(value == VehicleModeBroadcast.NORMAL.value) {
                return VehicleModeBroadcast.NORMAL;
            }
            return value == VehicleModeBroadcast.OTA.value ? VehicleModeBroadcast.OTA : VehicleModeBroadcast.__UNKNOWN__;
        }
    }

    public static enum VehicleState {
        SLEEPING(0),
        CUTOFF_PENDING(2),
        AUTO_ACC(3),
        IGNITION_LEVEL(5),
        STARTING_IN_PROGRESS(6),
        POWER_TRAIN_RUNNING(7),
        AUTO_START(8),
        ENGINE_SYSTEM_STOP(9),
        UNAVAILABLE(15),
        __UNKNOWN__(-1);

        public final int value;

        private VehicleState(int value) {
            this.value = value;
        }

        public static VehicleState valueOf(int value) {
            if(value == VehicleState.SLEEPING.value) {
                return VehicleState.SLEEPING;
            }
            if(value == VehicleState.CUTOFF_PENDING.value) {
                return VehicleState.CUTOFF_PENDING;
            }
            if(value == VehicleState.AUTO_ACC.value) {
                return VehicleState.AUTO_ACC;
            }
            if(value == VehicleState.IGNITION_LEVEL.value) {
                return VehicleState.IGNITION_LEVEL;
            }
            if(value == VehicleState.STARTING_IN_PROGRESS.value) {
                return VehicleState.STARTING_IN_PROGRESS;
            }
            if(value == VehicleState.POWER_TRAIN_RUNNING.value) {
                return VehicleState.POWER_TRAIN_RUNNING;
            }
            if(value == VehicleState.AUTO_START.value) {
                return VehicleState.AUTO_START;
            }
            if(value == VehicleState.ENGINE_SYSTEM_STOP.value) {
                return VehicleState.ENGINE_SYSTEM_STOP;
            }
            return value == VehicleState.UNAVAILABLE.value ? VehicleState.UNAVAILABLE : VehicleState.__UNKNOWN__;
        }
    }

    public static final int BATTERY_VOLTAGE = 0x7C;
    public static final int CAR_READY_INDICATOR_STATE = 705;
    public static final int DAY_NIGHT_MODE = 0xBB;
    public static final int ENGINE_CRANK_STATE = 407;
    public static final int ENGINE_IGN_ANGLE_STATE = 443;
    public static final int ENGINE_SPEED = 0x79;
    public static final int GEAR_POSITION = 0xB9;
    public static final int GEAR_POSITION_A9E = 0x19F;
    public static final int GEAR_POSITION_HEV = 664;
    public static final int LOW_BATTERY_WARNING_LEVEL = 0x7D;
    public static final int PARKING_BRAKE_STATE = 201;
    public static final int POWER_MODE = 0xB6;
    public static final int PRESSURE_ATMOSPHERIC_STATE = 437;
    public static final int PRESSURE_OIL_STATE = 438;
    public static final int PRESSURE_TURBINE_STATE = 436;
    public static final int REAR_GEAR_STATE = 0xB8;
    public static final int SLEEP_WAKEUP_COMMAND = -1;
    public static final int TEMP_ENGINE_WATER_STATE = 439;
    public static final int TEMP_EXHAUST_STATE = 440;
    public static final int TEMP_INTAKE_AIR_STATE = 441;
    public static final int TEMP_TRANSMISSION_OIL_STATE = 442;
    public static final int TOTAL_ODOMETER = 0x7B;
    public static final int TRANSPORTATION_MODE = 369;
    public static final int VEHICLE_MODE_BROADCAST = 0x170;
    public static final int VEHICLE_SPEED = 0x7A;
    public static final int VEHICLE_STATE = 0xBA;

}

