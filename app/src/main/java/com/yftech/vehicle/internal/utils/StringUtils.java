package com.yftech.vehicle.internal.utils;

import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isContainChinese(String s) {
        return s == null ? false : Pattern.compile("[?-?]").matcher(s).find();
    }

    public static boolean isNumeric(String s) {
        return Pattern.compile("[0-9]*").matcher(s).matches();
    }
}

