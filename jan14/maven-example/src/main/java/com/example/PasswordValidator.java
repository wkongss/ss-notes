package com.example;

import java.util.Arrays;
import java.util.List;

public class PasswordValidator {
    private static final List<String> SPECIALCHARS = Arrays.asList("!", "@", "#", "$", "%", "^", "&", "*", "_", "-");
    private static final List<String> RESTRICTEDCHARS = Arrays.asList("(", ")", "'", "\"", " ");

    public static boolean validate(String input) throws IllegalArgumentException {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException("Input string cannot be empty");
        }

        if (!withinRequiredLength(input)) {
            return false;
        }

        if (!hasLowercase(input)) {
            return false;
        }

        if (!hasUppercase(input)) {
            return false;
        }

        if (!hasNumber(input)) {
            return false;
        }

        if (!hasSpecialCharacter(input)) {
            return false;
        }

        if (!hasNoRestricted(input)) {
            return false;
        }

        return true;
    }

    public static boolean withinRequiredLength(String input) {
        return input.length() > 7 && input.length() < 33;
    }

    public static boolean hasLowercase(String input) {
        return !input.equals(input.toUpperCase());
    }

    public static boolean hasUppercase(String input) {
        return !input.equals(input.toLowerCase());
    }

    public static boolean hasNumber(String input) {
        return input.matches(".*\\d.*");
    }

    public static boolean hasSpecialCharacter(String input) {
        for (String special : PasswordValidator.SPECIALCHARS) {
            if (input.contains(special)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean hasNoRestricted(String input) {
        for (String restricted : PasswordValidator.RESTRICTEDCHARS) {
            if (input.contains(restricted)) {
                return false;
            }
        }
        
        return true;
    }
}
