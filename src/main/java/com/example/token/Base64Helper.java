package com.example.token;

import java.util.Base64;

/**
 * @author
 * @create 2021 - 03 - 03 下午 12:01
 **/
public class Base64Helper {
    public static String encode(byte[] arr){
        return new String(Base64.getEncoder().encode(arr));
    }

    public static byte[] decode(byte[] str){
        return Base64.getDecoder().decode(str);
    }
}

