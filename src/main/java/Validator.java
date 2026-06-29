package com.loginsimulator;

/**
 * Utility class for validating login credentials.
 */
public class Validator {

    /**
     * Validates the username.
     *
     * @param username Username entered by the user.
     * @return Validation message or null if valid.
     */
    public static String validateUsername(String username) {

        if (username == null || username.isBlank()) {
            return "Username cannot be empty.";
        }

        if (username.contains(" ")) {
            return "Username cannot contain spaces.";
        }

        return null;
    }

    /**
     * Validates the password.
     *
     * @param password Password entered by the user.
     * @return Validation message or null if valid.
     */
    public static String validatePassword(String password) {

        if (password == null || password.isBlank()) {
            return "Password cannot be empty.";
        }

        if (password.length() < 8) {
            return "Password must contain at least 8 characters.";
        }

        return null;
    }

}