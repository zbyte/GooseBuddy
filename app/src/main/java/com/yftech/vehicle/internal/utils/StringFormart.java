package com.yftech.vehicle.internal.utils;

public class StringFormart {
    public static String byte2hex(byte[] buffer) {
        if(buffer == null) {
            return "byte[] null";
        }
        String h = "";
        for(int i = 0; i < buffer.length; ++i) {
            String temp = Integer.toHexString(buffer[i] & 0xFF);
            if(temp.length() == 1) {
                temp = "0" + temp;
            }
            h = h + " " + temp;
        }
        return h;
    }
}

