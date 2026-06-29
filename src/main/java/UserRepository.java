package com.loginsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class responsible for storing and managing users.
 */
public class UserRepository {

    private final List<User> users;

    /**
     * Creates a repository and preloads sample users.
     */
    public UserRepository() {
        users = new ArrayList<>();

        // Sample users
        addUser(new User("admin", "admin123"));
        addUser(new User("tester", "tester123"));
        addUser(new User("guest", "guest1234"));
    }

    /**
     * Adds a user to the repository.
     *
     * @param user User to add.
     * @return true if added successfully, false if username already exists.
     */
    public boolean addUser(User user) {

        if (findUser(user.getUsername()) != null) {
            return false;
        }

        users.add(user);
        return true;
    }

    /**
     * Finds a user by username.
     *
     * @param username Username to search.
     * @return User if found, otherwise null.
     */
    public User findUser(String username) {

        for (User user : users) {

            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }

        }

        return null;
    }

    /**
     * Removes a user by username.
     *
     * @param username Username to remove.
     * @return true if removed successfully.
     */
    public boolean removeUser(String username) {

        User user = findUser(username);

        if (user == null) {
            return false;
        }

        users.remove(user);
        return true;
    }

    /**
     * Returns all users.
     *
     * @return List of users.
     */
    public List<User> getAllUsers() {
        return users;
    }

    /**
     * Returns the total number of users.
     *
     * @return user count.
     */
    public int getUserCount() {
        return users.size();
    }

    /**
     * Displays all registered users.
     */
    public void displayUsers() {

        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        System.out.println("\n===== Registered Users =====");

        for (User user : users) {
            System.out.println(user);
        }

    }

}