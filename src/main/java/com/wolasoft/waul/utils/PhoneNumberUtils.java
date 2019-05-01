package com.wolasoft.waul.utils;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class PhoneNumberUtils {
    private static final String DIALLING_CODE_TOGO =  "TG";
    private static PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

    public static boolean isValidNumber(String phoneNumber) {
        boolean isvalid = false;

        try {
            Phonenumber.PhoneNumber number = phoneNumberUtil.parse(phoneNumber, DIALLING_CODE_TOGO);
            isvalid = phoneNumberUtil.isValidNumber(number);
        } catch (NumberParseException e) {
            e.printStackTrace();
        }

        return isvalid;
    }
}
