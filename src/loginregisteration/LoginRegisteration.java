/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginregisteration;

/**
 *
 * @author lab_services_student
 */
import java.util.Scanner;
public class LoginRegisteration {
    
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

    // Validates username formatting
    public static String validateUsername(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return "Username successfully captured.";
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
    }
    // Validates password formatting
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
    // Username rule: contains underscore and <= 5 chars
    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
     public static boolean checkPasswordComplexity(String password){
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
        boolean longEnough = password.length() >= 8;
         return hasUppercase && hasDigit && hasSpecial && longEnough;
     } 

    // Cell phone number check (e.g., +27123456789)
    public static boolean checkCellPhoneNumber(String phoneNumber) {
        String regex = "^\\+\\d{1,3}\\d{1,10}$"; // +country_code + number
        String digitsOnly = phoneNumber.replaceAll("[^\\d]", "");
        return phoneNumber.matches(regex) && digitsOnly.length() <= 13;
    }
    public static boolean loginUser(String registeredUsername, String registeredPassword, String enteredUsername, String enteredPassword) {
    return registeredUsername.equals(enteredUsername) && registeredPassword.equals(enteredPassword);
}
    public static String returnLoginStatus(String registeredUsername, String registeredPassword, String enteredUsername, String enteredPassword, String firstname, String lastname) {
    if (loginUser(registeredUsername, registeredPassword, enteredUsername, enteredPassword)) {
        return "*****Login Successful*****\nWelcome back, " + firstname + " " + lastname + "!";
    } else {
        return "Login failed: Username or password incorrect.";
    }
}

    /**
     * @param args the command line arguments 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);

System.out.println("Enter your First Name:");
String firstname = input.nextLine();

System.out.println("Enter your Last Name:");
String lastname = input.nextLine();

// --- Username input with validation ---
String username;
while (true) 
    System.out.println("\n----- Login Section -----");
    System.out.println("Enter your username: ");
    username = input.nextLine();
    if (checkUserName(username)) {
        System.out.println("Username successfully captured.");
        break;
    } else {
        System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
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
// Simulate login
       System.out.println(registerUser(username, password));
       if (loginUser(username, password) {
        System.out.println("*****Login Successful*****");
        System.out.println("Welcome back, " + firstname + " " + lastname + "!");
        } else {
        System.out.println("Login failed: Username or password incorrect.");
        }
        input.close();
        System.out.println(returnLoginStatus(username, password, firstname, lastname));
       //add comment

}
}
    
    

