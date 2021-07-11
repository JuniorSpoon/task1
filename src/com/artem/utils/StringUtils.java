package com.artem.utils;

public class StringUtils {

    public static boolean isStringNotNullOrNotEmpty(String str){
        return str != null && !str.trim().isEmpty();
    }

    public static boolean isStringNullOrEmpty(String str){
        return !isStringNotNullOrNotEmpty(str);
    }
}
