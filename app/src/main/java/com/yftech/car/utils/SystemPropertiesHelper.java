package com.yftech.car.utils;

import java.lang.reflect.Method;

public class SystemPropertiesHelper {
    private static final Class<?> sSystemPropertiesClass;

    static {
        try {
            sSystemPropertiesClass = Class.forName("android.os.SystemProperties");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return get(key, "");
    }

    public static String get(String key, String def) {
        if (sSystemPropertiesClass == null) return def;

        try {
            Method getMethod = sSystemPropertiesClass.getMethod("get", String.class, String.class);
            return (String) getMethod.invoke(null, key, def);
        } catch (Exception e) {
            return def;
        }
    }

    public static String get(String key, int def) {
        if (sSystemPropertiesClass == null) return String.valueOf(def);

        try {
            Method getIntMethod = sSystemPropertiesClass.getMethod("getInt", String.class, int.class);
            return String.valueOf(getIntMethod.invoke(null, key, def));
        } catch (Exception e) {
            return String.valueOf(def);
        }
    }

    public static int getInt(String key, int def) {
        if (sSystemPropertiesClass == null) return def;

        try {
            Method getIntMethod = sSystemPropertiesClass.getMethod("getInt", String.class, int.class);
            return (Integer) getIntMethod.invoke(null, key, def);
        } catch (Exception e) {
            return def;
        }
    }

    public static boolean getBoolean(String key, boolean def) {
        if (sSystemPropertiesClass == null) return def;

        try {
            Method getBooleanMethod = sSystemPropertiesClass.getMethod("getBoolean", String.class, boolean.class);
            return (Boolean) getBooleanMethod.invoke(null, key, def);
        } catch (Exception e) {
            return def;
        }
    }
}

