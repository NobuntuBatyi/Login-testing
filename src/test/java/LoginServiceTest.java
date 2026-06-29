package com.loginsimulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    private UserRepository repository;
    private LoginService loginService;

    @BeforeEach
    void setUp() {
        repository = new UserRepository();
        loginService = new LoginService(repository);
    }

    @Test
    void shouldLoginSuccessfully() throws LoginException {

        loginService.login("admin", "admin123");

        assertTrue(loginService.isLoggedIn());
        assertEquals("admin",
                loginService.getLoggedInUser().getUsername());
    }

    @Test
    void shouldRejectWrongPassword() {

        LoginException exception = assertThrows(
                LoginException.class,
                () -> loginService.login("admin", "wrongpass")
        );

        assertEquals("Incorrect password.", exception.getMessage());
    }

    @Test
    void shouldRejectUnknownUser() {

        LoginException exception = assertThrows(
                LoginException.class,
                () -> loginService.login("john", "password123")
        );

        assertEquals("User not found.", exception.getMessage());
    }

    @Test
    void shouldRejectEmptyUsername() {

        LoginException exception = assertThrows(
                LoginException.class,
                () -> loginService.login("", "admin123")
        );

        assertEquals(
                "Username cannot be empty.",
                exception.getMessage()
        );
    }

    @Test
    void shouldRejectEmptyPassword() {

        LoginException exception = assertThrows(
                LoginException.class,
                () -> loginService.login("admin", "")
        );

        assertEquals(
                "Password cannot be empty.",
                exception.getMessage()
        );
    }

    @Test
    void shouldRejectShortPassword() {

        LoginException exception = assertThrows(
                LoginException.class,
                () -> loginService.login("admin", "abc")
        );

        assertEquals(
                "Password must contain at least 8 characters.",
                exception.getMessage()
        );
    }

    @Test
    void shouldRejectUsernameWithSpaces() {

        LoginException exception = assertThrows(
                LoginException.class,
                () -> loginService.login("john doe", "password123")
        );

        assertEquals(
                "Username cannot contain spaces.",
                exception.getMessage()
        );
    }

    @Test
    void shouldLockAccountAfterThreeFailedAttempts() {

        User user = repository.findUser("admin");

        for (int i = 0; i < 3; i++) {
            try {
                loginService.login("admin", "wrongpass");
            } catch (LoginException ignored) {
            }
        }

        assertTrue(user.isLocked());
        assertEquals(3, user.getFailedAttempts());
    }

    @Test
    void shouldRejectLockedAccount() {

        User user = repository.findUser("admin");

        user.lockAccount();

        LoginException exception = assertThrows(
                LoginException.class,
                () -> loginService.login("admin", "admin123")
        );

        assertEquals(
                "Account locked. Please contact administrator.",
                exception.getMessage()
        );
    }

    @Test
    void shouldLogoutSuccessfully() throws LoginException {

        loginService.login("admin", "admin123");

        loginService.logout();

        assertFalse(loginService.isLoggedIn());
        assertNull(loginService.getLoggedInUser());
    }

}