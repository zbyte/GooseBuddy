package com.yftech.vehicle.internal.utils;

import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isContainChinese(String str) {
        return str == null ? false : Pattern.compile("[?-?]").matcher(str).find();
    }

    public static boolean isNumeric(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }
}

