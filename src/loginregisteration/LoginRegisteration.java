/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginregisteration;

import java.util.Scanner;

public class LoginRegisteration {

    /**
     * Registers a user by validating both username and password.
     * Returns success or error messages based on validity.
     */
    public static String registerUser(String username, String password) {
        boolean isUsernameValid = checkUserName(username);
        boolean isPasswordValid = checkPasswordComplexity(password);

        if (isUsernameValid && isPasswordValid) {
            return "Registration successful.";
        } else if (!isUsernameValid && !isPasswordValid) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.\n"
                 + "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        } else if (!isUsernameValid) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        } else {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
    }

    /**
     * Validates username format.
     * Username must contain an underscore and be no more than 5 characters.
     */
    public static String validateUsername(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return "Username successfully captured.";
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
    }

    /**
     * Validates password complexity.
     * Password must be at least 8 characters and contain a capital letter, a digit, and a special character.
     */
    public static String validatePassword(String password) {
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
        boolean longEnough = password.length() >= 8;

        if (hasUppercase && hasDigit && hasSpecial && longEnough) {
            return "Password successfully captured.";
        } else {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
    }

    /**
     * Checks if the username follows the rules.
     * Returns true if it contains an underscore and is 5 characters or fewer.
     */
    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    /**
     * Checks password for complexity requirements.
     * Returns true if all conditions are met.
     */
    public static boolean checkPasswordComplexity(String password) {
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
        boolean longEnough = password.length() >= 8;
        return hasUppercase && hasDigit && hasSpecial && longEnough;
    }

    /**
     * Validates a phone number with international format.
     * Returns true if it starts with + and has correct length.
     */
    public static boolean checkCellPhoneNumber(String phoneNumber) {
        String regex = "^\\+\\d{1,3}\\d{1,10}$"; // +country_code + number
        String digitsOnly = phoneNumber.replaceAll("[^\\d]", "");
        return phoneNumber.matches(regex) && digitsOnly.length() <= 13;
    }

    /**
     * Compares entered login credentials with registered ones.
     * Returns true if they match.
     */
    public static boolean loginUser(String registeredUsername, String registeredPassword, String enteredUsername, String enteredPassword) {
        return registeredUsername.equals(enteredUsername) && registeredPassword.equals(enteredPassword);
    }

    /**
     * Returns login status message based on login credentials match.
     */
    public static String returnLoginStatus(String registeredUsername, String registeredPassword, String enteredUsername, String enteredPassword, String firstname, String lastname) {
        if (loginUser(registeredUsername, registeredPassword, enteredUsername, enteredPassword)) {
            return "*****Login Successful*****\nWelcome back, " + firstname + " " + lastname + "!";
        } else {
            return "Login failed: Username or password incorrect.";
        }
    }

    /**
     * Main method: handles user input for registration and login process.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your First Name:");
        String firstname = input.nextLine();

        System.out.println("Enter your Last Name:");
        String lastname = input.nextLine();

        // --- Username input with validation ---
        String username;
        while (true) {
            System.out.print("Enter your username: ");
            username = input.nextLine();
            if (checkUserName(username)) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }

        // --- Password input with validation ---
        String password;
        while (true) {
            System.out.print("Enter your password: ");
            password = input.nextLine();
            if (checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        // --- Cell phone number input with validation ---
        String phoneNumber;
        while (true) {
            System.out.print("Enter your cell phone number with international code (e.g., +27123456789): ");
            phoneNumber = input.nextLine();
            if (checkCellPhoneNumber(phoneNumber)) {
                System.out.println("Cell phone number successfully added.");
                break;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }
        }

        // Registration confirmation
        System.out.println(registerUser(username, password));

        System.out.println("\n----- Login Section -----");

        while (true) {
            System.out.print("Enter your username to login: ");
            String enteredUsername = input.nextLine();

            System.out.print("Enter your password to login: ");
            String enteredPassword = input.nextLine();

            if (loginUser(username, password, enteredUsername, enteredPassword)) {
                System.out.println("*****Login Successful*****");
                System.out.println("Welcome back, " + firstname + " " + lastname + "! , it nice to see you again!!");
                break; // Exit the login loop
            } else {
                System.out.println("Login failed: Username or password incorrect.");
                System.out.println("Please try again.\n");
            }
        }

        input.close();
    }
}
