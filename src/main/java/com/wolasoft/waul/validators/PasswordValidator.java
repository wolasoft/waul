package com.wolasoft.waul.validators;

import java.util.regex.Pattern;

public class PasswordValidator {
    private static String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private static Pattern pattern = Pattern.compile(regex);

    public static boolean isValid(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (password.length() > 50) {
            return false;
        }

        return pattern.matcher(password).find();
    }
}
