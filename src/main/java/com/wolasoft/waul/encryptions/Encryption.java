package com.wolasoft.waul.encryptions;

import android.util.Base64;

public class Encryption {
    public static String toBase64(String data) {
        return Base64.encodeToString(data.getBytes(), Base64.DEFAULT);
    }

    public static String fromBase64(String data) {
         return new String(Base64.decode(data, Base64.DEFAULT));
    }
}
