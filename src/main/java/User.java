package com.loginsimulator;

/**
 * Represents a user in the Login Testing Simulator.
 * Stores the user's credentials and account status.
 */
public class User {

    private String username;
    private String password;
    private boolean locked;
    private int failedAttempts;

    /**
     * Creates a new user.
     *
     * @param username The username.
     * @param password The password.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.locked = false;
        this.failedAttempts = 0;
    }

    // ===========================
    // Getters
    // ===========================

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLocked() {
        return locked;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    // ===========================
    // Setters
    // ===========================

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ===========================
    // Account Methods
    // ===========================

    /**
     * Locks the user account.
     */
    public void lockAccount() {
        locked = true;
    }

    /**
     * Unlocks the user account and resets failed attempts.
     */
    public void unlockAccount() {
        locked = false;
        failedAttempts = 0;
    }

    /**
     * Increases failed login attempts.
     * Locks account after 3 failed attempts.
     */
    public void incrementFailedAttempts() {
        failedAttempts++;

        if (failedAttempts >= 3) {
            lockAccount();
        }
    }

    /**
     * Resets failed login attempts.
     */
    public void resetFailedAttempts() {
        failedAttempts = 0;
    }

    /**
     * Returns user information.
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", locked=" + locked +
                ", failedAttempts=" + failedAttempts +
                '}';
    }
}