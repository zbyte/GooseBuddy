package com.yftech.vehicle.internal.adapter;

public interface ICarInfo extends IBaseApi {
    public static enum CarReadyIndicator {
        LIGHTS_OUT(0),
        BLINKING(1),
        LIGHTING(2),
        __UNKNOWN__(-1);

        public final int value;

        private CarReadyIndicator(int v1) {
            this.value = v1;
        }

        public static CarReadyIndicator valueOf(int v) {
            if(v == CarReadyIndicator.LIGHTS_OUT.value) {
                return CarReadyIndicator.LIGHTS_OUT;
            }
            if(v == CarReadyIndicator.BLINKING.value) {
                return CarReadyIndicator.BLINKING;
            }
            return v == CarReadyIndicator.LIGHTING.value ? CarReadyIndicator.LIGHTING : CarReadyIndicator.__UNKNOWN__;
        }
    }

    public static enum DayNightMode {
        DAY(0),
        TWILIGHT(1),
        NIGHT(2),
        __UNKNOWN__(-1);

        public final int value;

        private DayNightMode(int v1) {
            this.value = v1;
        }

        public static DayNightMode valueOf(int v) {
            if(v == DayNightMode.DAY.value) {
                return DayNightMode.DAY;
            }
            if(v == DayNightMode.TWILIGHT.value) {
                return DayNightMode.TWILIGHT;
            }
            return v == DayNightMode.NIGHT.value ? DayNightMode.NIGHT : DayNightMode.__UNKNOWN__;
        }
    }

    public static enum EngineCrankState {
        NOT_ON_CRANK(0),
        CRANK(1),
        __UNKNOWN__(-1);

        public final int value;

        private EngineCrankState(int v1) {
            this.value = v1;
        }

        public static EngineCrankState valueOf(int v) {
            if(v == EngineCrankState.NOT_ON_CRANK.value) {
                return EngineCrankState.NOT_ON_CRANK;
            }
            return v == EngineCrankState.CRANK.value ? EngineCrankState.CRANK : EngineCrankState.__UNKNOWN__;
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
        PARKING(12),
        REVERSE(13),
        NEUTRAL(14),
        DRIVE(15),
        MANUAL_MODE(16),
        L(17),
        DS(18),
        CONFIRMED(19),
        BRAKE(20),
        NOT_AVAILABLE(21),
        __UNKNOWN__(-1);

        public final int value;

        private GearPosition(int v1) {
            this.value = v1;
        }

        public static GearPosition valueOf(int v) {
            if(v == GearPosition.GEAR_FIRST.value) {
                return GearPosition.GEAR_FIRST;
            }
            if(v == GearPosition.GEAR_TOW.value) {
                return GearPosition.GEAR_TOW;
            }
            if(v == GearPosition.GEAR_THIRD.value) {
                return GearPosition.GEAR_THIRD;
            }
            if(v == GearPosition.GEAR_FOUR.value) {
                return GearPosition.GEAR_FOUR;
            }
            if(v == GearPosition.GEAR_FIVE.value) {
                return GearPosition.GEAR_FIVE;
            }
            if(v == GearPosition.GEAR_SIX.value) {
                return GearPosition.GEAR_SIX;
            }
            if(v == GearPosition.GEAR_SEVEN.value) {
                return GearPosition.GEAR_SEVEN;
            }
            if(v == GearPosition.GEAR_EIGHT.value) {
                return GearPosition.GEAR_EIGHT;
            }
            if(v == GearPosition.GEAR_NINE.value) {
                return GearPosition.GEAR_NINE;
            }
            if(v == GearPosition.SPORT.value) {
                return GearPosition.SPORT;
            }
            if(v == GearPosition.PARKING.value) {
                return GearPosition.PARKING;
            }
            if(v == GearPosition.REVERSE.value) {
                return GearPosition.REVERSE;
            }
            if(v == GearPosition.NEUTRAL.value) {
                return GearPosition.NEUTRAL;
            }
            if(v == GearPosition.DRIVE.value) {
                return GearPosition.DRIVE;
            }
            if(v == GearPosition.MANUAL_MODE.value) {
                return GearPosition.MANUAL_MODE;
            }
            if(v == GearPosition.L.value) {
                return GearPosition.L;
            }
            if(v == GearPosition.DS.value) {
                return GearPosition.DS;
            }
            if(v == GearPosition.CONFIRMED.value) {
                return GearPosition.CONFIRMED;
            }
            if(v == GearPosition.BRAKE.value) {
                return GearPosition.BRAKE;
            }
            return v == GearPosition.NOT_AVAILABLE.value ? GearPosition.NOT_AVAILABLE : GearPosition.__UNKNOWN__;
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

        private GearPositionA9E(int v1) {
            this.value = v1;
        }

        public static GearPositionA9E valueOf(int v) {
            if(v == GearPositionA9E.INVALID.value) {
                return GearPositionA9E.INVALID;
            }
            if(v == GearPositionA9E.DRIVE.value) {
                return GearPositionA9E.DRIVE;
            }
            if(v == GearPositionA9E.NEUTRAL.value) {
                return GearPositionA9E.NEUTRAL;
            }
            if(v == GearPositionA9E.REVERSE.value) {
                return GearPositionA9E.REVERSE;
            }
            return v == GearPositionA9E.PARKING.value ? GearPositionA9E.PARKING : GearPositionA9E.__UNKNOWN__;
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

        private GearPositionHEV(int v1) {
            this.value = v1;
        }

        public static GearPositionHEV valueOf(int v) {
            if(v == GearPositionHEV.INVALID.value) {
                return GearPositionHEV.INVALID;
            }
            if(v == GearPositionHEV.PARKING.value) {
                return GearPositionHEV.PARKING;
            }
            if(v == GearPositionHEV.REVERSE.value) {
                return GearPositionHEV.REVERSE;
            }
            if(v == GearPositionHEV.NEUTRAL.value) {
                return GearPositionHEV.NEUTRAL;
            }
            if(v == GearPositionHEV.DRIVE.value) {
                return GearPositionHEV.DRIVE;
            }
            if(v == GearPositionHEV.DRIVE_INCREASE.value) {
                return GearPositionHEV.DRIVE_INCREASE;
            }
            if(v == GearPositionHEV.DRIVE_REDUCE.value) {
                return GearPositionHEV.DRIVE_REDUCE;
            }
            if(v == GearPositionHEV.SPORT.value) {
                return GearPositionHEV.SPORT;
            }
            if(v == GearPositionHEV.MANUAL.value) {
                return GearPositionHEV.MANUAL;
            }
            if(v == GearPositionHEV.MANUAL_INCREASE.value) {
                return GearPositionHEV.MANUAL_INCREASE;
            }
            return v == GearPositionHEV.MANUAL_REDUCE.value ? GearPositionHEV.MANUAL_REDUCE : GearPositionHEV.__UNKNOWN__;
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

        private LowBatteryWarningLevel(int v1) {
            this.value = v1;
        }

        public static LowBatteryWarningLevel valueOf(int v) {
            if(v == LowBatteryWarningLevel.LEVEL_1.value) {
                return LowBatteryWarningLevel.LEVEL_1;
            }
            if(v == LowBatteryWarningLevel.LEVEL_2.value) {
                return LowBatteryWarningLevel.LEVEL_2;
            }
            if(v == LowBatteryWarningLevel.LEVEL_3.value) {
                return LowBatteryWarningLevel.LEVEL_3;
            }
            if(v == LowBatteryWarningLevel.LEVEL_4.value) {
                return LowBatteryWarningLevel.LEVEL_4;
            }
            if(v == LowBatteryWarningLevel.LEVEL_5.value) {
                return LowBatteryWarningLevel.LEVEL_5;
            }
            return v == LowBatteryWarningLevel.OFF.value ? LowBatteryWarningLevel.OFF : LowBatteryWarningLevel.__UNKNOWN__;
        }
    }

    public static enum ParkingBrakeState {
        PARKING_BRAKE_NOT_APPLIED(1),
        PARKING_BRAKE_APPLIED(2),
        UNAVAILABLE(3),
        __UNKNOWN__(-1);

        public final int value;

        private ParkingBrakeState(int v1) {
            this.value = v1;
        }

        public static ParkingBrakeState valueOf(int v) {
            if(v == ParkingBrakeState.PARKING_BRAKE_NOT_APPLIED.value) {
                return ParkingBrakeState.PARKING_BRAKE_NOT_APPLIED;
            }
            if(v == ParkingBrakeState.PARKING_BRAKE_APPLIED.value) {
                return ParkingBrakeState.PARKING_BRAKE_APPLIED;
            }
            return v == ParkingBrakeState.UNAVAILABLE.value ? ParkingBrakeState.UNAVAILABLE : ParkingBrakeState.__UNKNOWN__;
        }
    }

    public static enum PowerMode {
        ACC(1),
        ON(2),
        CRANK(3),
        OFF(0),
        __UNKNOWN__(-1);

        public final int value;

        private PowerMode(int v1) {
            this.value = v1;
        }

        public static PowerMode valueOf(int v) {
            if(v == PowerMode.ACC.value) {
                return PowerMode.ACC;
            }
            if(v == PowerMode.ON.value) {
                return PowerMode.ON;
            }
            if(v == PowerMode.CRANK.value) {
                return PowerMode.CRANK;
            }
            return v == PowerMode.OFF.value ? PowerMode.OFF : PowerMode.__UNKNOWN__;
        }
    }

    public static enum RearGearState {
        NOT_ENGAGED(1),
        ENGAGED(2),
        __UNKNOWN__(-1);

        public final int value;

        private RearGearState(int v1) {
            this.value = v1;
        }

        public static RearGearState valueOf(int v) {
            if(v == RearGearState.NOT_ENGAGED.value) {
                return RearGearState.NOT_ENGAGED;
            }
            return v == RearGearState.ENGAGED.value ? RearGearState.ENGAGED : RearGearState.__UNKNOWN__;
        }
    }

    public static enum SleepWakeUpCommand {
        GO_TO_SLEEP(0),
        WAKEUP(3),
        __UNKNOWN__(-1);

        public final int value;

        private SleepWakeUpCommand(int v1) {
            this.value = v1;
        }

        public static SleepWakeUpCommand valueOf(int v) {
            if(v == SleepWakeUpCommand.GO_TO_SLEEP.value) {
                return SleepWakeUpCommand.GO_TO_SLEEP;
            }
            return v == SleepWakeUpCommand.WAKEUP.value ? SleepWakeUpCommand.WAKEUP : SleepWakeUpCommand.__UNKNOWN__;
        }
    }

    public static enum VehicleModeBroadcast {
        NORMAL(0),
        OTA(1),
        __UNKNOWN__(-1);

        public final int value;

        private VehicleModeBroadcast(int v1) {
            this.value = v1;
        }

        public static VehicleModeBroadcast valueOf(int v) {
            if(v == VehicleModeBroadcast.NORMAL.value) {
                return VehicleModeBroadcast.NORMAL;
            }
            return v == VehicleModeBroadcast.OTA.value ? VehicleModeBroadcast.OTA : VehicleModeBroadcast.__UNKNOWN__;
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

        private VehicleState(int v1) {
            this.value = v1;
        }

        public static VehicleState valueOf(int v) {
            if(v == VehicleState.SLEEPING.value) {
                return VehicleState.SLEEPING;
            }
            if(v == VehicleState.CUTOFF_PENDING.value) {
                return VehicleState.CUTOFF_PENDING;
            }
            if(v == VehicleState.AUTO_ACC.value) {
                return VehicleState.AUTO_ACC;
            }
            if(v == VehicleState.IGNITION_LEVEL.value) {
                return VehicleState.IGNITION_LEVEL;
            }
            if(v == VehicleState.STARTING_IN_PROGRESS.value) {
                return VehicleState.STARTING_IN_PROGRESS;
            }
            if(v == VehicleState.POWER_TRAIN_RUNNING.value) {
                return VehicleState.POWER_TRAIN_RUNNING;
            }
            if(v == VehicleState.AUTO_START.value) {
                return VehicleState.AUTO_START;
            }
            if(v == VehicleState.ENGINE_SYSTEM_STOP.value) {
                return VehicleState.ENGINE_SYSTEM_STOP;
            }
            return v == VehicleState.UNAVAILABLE.value ? VehicleState.UNAVAILABLE : VehicleState.__UNKNOWN__;
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

