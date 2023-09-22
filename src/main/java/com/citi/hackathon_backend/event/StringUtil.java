package com.citi.hackathon_backend.event;

public class StringUtil {

    public static boolean isNull(String s) {
        if (s == null || s.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
