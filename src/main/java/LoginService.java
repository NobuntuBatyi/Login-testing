package com.loginsimulator;

/**
 * Handles user authentication and login business logic.
 */
public class LoginService {

    private final UserRepository repository;
    private User loggedInUser;

    /**
     * Creates a LoginService.
     *
     * @param repository Repository containing users.
     */
    public LoginService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Attempts to log a user into the system.
     *
     * @param username Username entered.
     * @param password Password entered.
     * @throws LoginException If login fails.
     */
    public void login(String username, String password) throws LoginException {

        // Validate username
        String usernameError = Validator.validateUsername(username);

        if (usernameError != null) {
            throw new LoginException(usernameError);
        }

        // Validate password
        String passwordError = Validator.validatePassword(password);

        if (passwordError != null) {
            throw new LoginException(passwordError);
        }

        // Find user
        User user = repository.findUser(username);

        if (user == null) {
            throw new LoginException("User not found.");
        }

        // Check if account is locked
        if (user.isLocked()) {
            throw new LoginException(
                    "Account locked. Please contact administrator.");
        }

        // Check password
        if (!user.getPassword().equals(password)) {

            user.incrementFailedAttempts();

            if (user.isLocked()) {
                throw new LoginException(
                        "Account locked after 3 failed login attempts.");
            }

            throw new LoginException("Incorrect password.");
        }

        // Successful login
        user.resetFailedAttempts();
        loggedInUser = user;
    }

    /**
     * Logs out the current user.
     */
    public void logout() {

        if (loggedInUser != null) {

            System.out.println(
                    loggedInUser.getUsername() + " logged out successfully.");

            loggedInUser = null;
        }
    }

    /**
     * Returns the currently logged-in user.
     *
     * @return Logged-in user or null.
     */
    public User getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * Checks whether someone is logged in.
     *
     * @return true if a user is logged in.
     */
    public boolean isLoggedIn() {
        return loggedInUser != null;
    }

}