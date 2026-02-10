package com.yftech.car.config;

public class CarConfigManager {
    private static volatile CarConfigManager mInstance;

    public static CarConfigManager getInstance() {
        if(CarConfigManager.mInstance == null) {
            Class class0 = CarConfigManager.class;
            synchronized(class0) {
                if(CarConfigManager.mInstance == null) {
                    CarConfigManager.mInstance = new CarConfigManager();
                }
            }
        }
        return CarConfigManager.mInstance;
    }
}

