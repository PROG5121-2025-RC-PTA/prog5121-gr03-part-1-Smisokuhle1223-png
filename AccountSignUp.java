/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accountsignup;
import javax.swing.JOptionPane;


/**
 *
 * @author USER
 */
public class AccountSignUp {

    // From OpenAI. (2023). ChatGPT (Mar 14 version)
      // Store only one user's details
    static String firstName, lastName, username, password, phone;
    static boolean userRegistered = false;
    static boolean userLoggedIn = false;

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Register", "Login", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option", "User Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                if (!userRegistered) {
                    registerUser();
                } else {
                    JOptionPane.showMessageDialog(null, "A user has already been registered.");
                }
            } else if (choice == 1) {
                if (userRegistered && !userLoggedIn) {
                    loginUser();
                } else if (!userRegistered) {
                    JOptionPane.showMessageDialog(null, "No user registered yet. Please register first.");
                } else {
                    JOptionPane.showMessageDialog(null, "User already logged in. Only one login is allowed.");
                }
            } else {
                break;
            }
        }
    }
    // User's First and Last name
    static void registerUser() {
        firstName = JOptionPane.showInputDialog("Please enter your First Name:");
        lastName = JOptionPane.showInputDialog("Please enter your Last Name:");
      
        // Username validation
        username = JOptionPane.showInputDialog("Please enter username (must contain _ and be max 5 characters):");
        if (!isValidUsername(username)) {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted. It must contain an underscore and be no more than five characters.");
            return;
        }
        
        // Password validation
        password = JOptionPane.showInputDialog("Please enter password (min 8 chars, uppercase, number, special char):");
        if (!isValidPassword(password)) {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted. It must contain at least eight characters, a capital letter, a number, and a special character.");
            return;
        }

        // Cell Phone Number validation
        phone = JOptionPane.showInputDialog("Please enter phone number (must start with +27 and max 10 digits):");
        if (!isValidPhone(phone)) {
            JOptionPane.showMessageDialog(null, "Cell phone number incorrectly formatted or does not contain international code.");
            return;
        }
        // Registration validation
        userRegistered = true;
        JOptionPane.showMessageDialog(null, "Registration successful! You may now log in.");
    }

    // Authentication
    static void loginUser() {
        String inputUsername = JOptionPane.showInputDialog("Please enter your username:");
        String inputPassword = JOptionPane.showInputDialog("Please enter your password:");

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            userLoggedIn = true;
            JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName + ", it is great to see you again.");
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again.");
        }
    }

    // Validation methods
    static boolean isValidUsername(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    static boolean isValidPassword(String password) {
        // From OpenAI. (2023). ChatGPT (Mar 14 version)
        return password != null && password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }

    static boolean isValidPhone(String phone) {
        // From OpenAI. (2023). ChatGPT (Mar 14 version)
        return phone != null && phone.matches("^\\+27\\d{1,10}$");
    }
}
