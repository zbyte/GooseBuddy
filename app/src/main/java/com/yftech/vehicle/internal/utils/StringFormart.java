package com.yftech.vehicle.internal.utils;

public class StringFormart {
    public static String byte2hex(byte[] arr_b) {
        if(arr_b == null) {
            return "byte[] null";
        }
        String s = "";
        for(int v = 0; v < arr_b.length; ++v) {
            String s1 = Integer.toHexString(arr_b[v] & 0xFF);
            if(s1.length() == 1) {
                s1 = "0" + s1;
            }
            s = s + " " + s1;
        }
        return s;
    }
}

