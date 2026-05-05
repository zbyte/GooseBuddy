package com.android.car.internal;

public class FeatureUtil {
    public static void assertFeature(boolean featureFlag) {
        if(!featureFlag) {
            throw new IllegalStateException("Feature not enabled");
        }
    }
}

