package com.wolasoft.waul.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    private static String validEmailAddressRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static Pattern pattern = Pattern.compile(validEmailAddressRegex, Pattern.CASE_INSENSITIVE);

    public static boolean isValid(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
