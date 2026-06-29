package com.loginsimulator;

import java.util.Scanner;

/**
 * Entry point for the Login Testing Simulator.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserRepository repository = new UserRepository();
    private static final LoginService loginService = new LoginService(repository);

    public static void main(String[] args) {

        boolean running = true;

        System.out.println("=================================");
        System.out.println("   LOGIN TESTING SIMULATOR");
        System.out.println("=================================");

        while (running) {

            displayMenu();

            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    login();
                    break;

                case "2":
                    repository.displayUsers();
                    break;

                case "3":
                    logout();
                    break;

                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

            System.out.println();
        }

        scanner.close();
    }

    /**
     * Displays the main menu.
     */
    private static void displayMenu() {

        System.out.println("1. Login");
        System.out.println("2. Show Users");
        System.out.println("3. Logout");
        System.out.println("4. Exit");
    }

    /**
     * Handles user login.
     */
    private static void login() {

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        try {

            loginService.login(username, password);

            System.out.println();
            System.out.println("Login Successful!");
            System.out.println("Welcome " +
                    loginService.getLoggedInUser().getUsername());

        } catch (LoginException e) {

            System.out.println();
            System.out.println("Login Failed");
            System.out.println("Reason: " + e.getMessage());

        }

    }

    /**
     * Handles logout.
     */
    private static void logout() {

        if (!loginService.isLoggedIn()) {

            System.out.println("No user is currently logged in.");
            return;
        }

        loginService.logout();
    }

}