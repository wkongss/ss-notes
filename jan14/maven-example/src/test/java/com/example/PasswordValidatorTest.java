package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;

public class PasswordValidatorTest {
    /**
     * Password validator:
     * Contains between 8 to 32 characters
     * Contains at least one lowercase (a-z) and one uppercase (A-Z) character
     * Contains at least one number (0-9)
     * Contains at least one special character (!@#$%^&*-_)
     * Contains none of the following disallowed characters (", ', (, ), )
     */


    @Test
    @DisplayName("Password length constraints")
    public void testPasswordWithinLength() {
        assertTrue(PasswordValidator.withinRequiredLength("123456789"));
        assertFalse(PasswordValidator.withinRequiredLength("12345"));
        assertFalse(PasswordValidator.withinRequiredLength("1".repeat(33)));
    }

    @Test
    @DisplayName("Password contains lowercase letter")
    public void testPasswordHasLowercaseLetter() {
        assertTrue(PasswordValidator.hasLowercase("abc"));
        assertFalse(PasswordValidator.hasLowercase("ABC"));
    }

    @Test
    @DisplayName("Password contains uppercase letter")
    public void testPasswordHasUppercaseLetter() {
        assertTrue(PasswordValidator.hasUppercase("ABC"));
        assertFalse(PasswordValidator.hasUppercase("abc"));
    }

    @Test
    @DisplayName("Password contains number")
    public void testPasswordHasNumber() {
        assertTrue(PasswordValidator.hasNumber("abc123"));
        assertFalse(PasswordValidator.hasNumber("ABC"));
    }
    
    @Test
    @DisplayName("Password contains special character")
    public void testPasswordHasSpecialCharacter() {
        assertTrue(PasswordValidator.hasSpecialCharacter("!"));
        assertTrue(PasswordValidator.hasSpecialCharacter("@"));
        assertTrue(PasswordValidator.hasSpecialCharacter("#"));
        assertTrue(PasswordValidator.hasSpecialCharacter("$"));
        assertTrue(PasswordValidator.hasSpecialCharacter("%"));
        assertTrue(PasswordValidator.hasSpecialCharacter("^"));
        assertTrue(PasswordValidator.hasSpecialCharacter("&"));
        assertTrue(PasswordValidator.hasSpecialCharacter("*"));
        assertTrue(PasswordValidator.hasSpecialCharacter("-"));
        assertTrue(PasswordValidator.hasSpecialCharacter("_"));
        assertFalse(PasswordValidator.hasSpecialCharacter("ABC"));
    }
    
    @Test
    @DisplayName("Password does not contain restricted characters")
    public void testHasNoRestricted() {
        assertTrue(PasswordValidator.hasNoRestricted("abc"));
        assertFalse(PasswordValidator.hasNoRestricted("'"));
        assertFalse(PasswordValidator.hasNoRestricted("\""));
        assertFalse(PasswordValidator.hasNoRestricted("("));
        assertFalse(PasswordValidator.hasNoRestricted(")"));
        assertFalse(PasswordValidator.hasNoRestricted(" "));
    }
    
    @Test
    @DisplayName("Illegal arguments")
    public void testEmptyStringException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate(null);
        });
    }

    @Test
    @DisplayName("Test validate")
    public void testCompleteValidate() {
        assertTrue(PasswordValidator.validate("aBcD1234%"));
    }
}
