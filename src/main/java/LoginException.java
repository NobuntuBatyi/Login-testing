package com.loginsimulator;

/**
 * Custom exception used for login-related errors.
 */
public class LoginException extends Exception {

    /**
     * Creates a new LoginException with a custom message.
     *
     * @param message The error message.
     */
    public LoginException(String message) {
        super(message);
    }
}