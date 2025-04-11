/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accountcreation;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;
/**
 *
 * @author RC_Student_lab
 */
public class AccountCreation {

  // Validate username: must contain "_" and be 5 characters or less
    public static boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Validate password: 8+ characters, capital letter, number, special character
    public static boolean checkPasswordComplexity(String password) {
        // From OpenAI. (2023). ChatGPT (Mar 14 version)
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return password.matches(regex);
    }

    // Validate South African phone number with international code (+27)
    public static boolean checkCellPhoneNumber(String number) {
        // From OpenAI. (2023). ChatGPT (Mar 14 version)
        String regex = "^\\+27\\d{1,10}$";
        return number.matches(regex);
    }

    public static void main(String[] args) {
        // User's first and last name
        String firstName = JOptionPane.showInputDialog("Please enter your first name:");
        String lastName = JOptionPane.showInputDialog("Please enter your last name:");

        // Username validation
        String username;
        while (true) {
            username = JOptionPane.showInputDialog("Create a username:");
            if (checkUsername(username)) {
                JOptionPane.showMessageDialog(null, "Username is successfully captured.");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }

        // Password validation
        String password;
        while (true) {
            password = JOptionPane.showInputDialog("Create a password:");
            if (checkPasswordComplexity(password)) {
                JOptionPane.showMessageDialog(null, "Password is successfully captured.");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        // Phone number validation
        while (true) {
            String cellNumber = JOptionPane.showInputDialog("Please enter South African cell phone number (with +27):");
            if (checkCellPhoneNumber(cellNumber)) {
                JOptionPane.showMessageDialog(null, "Cell phone number is successfully added.");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Cell phone number is incorrectly formatted or does not contain international code.");
            }
        }

        // Login Authentication
        String loginUsername = JOptionPane.showInputDialog(" Please enter your username to log in:");
        String loginPassword = JOptionPane.showInputDialog("Please enter your password to log in:");

        if (loginUsername.equals(username) && loginPassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName + ", it is great to see you again.");
        } else {
            JOptionPane.showMessageDialog(null, "Username or password is incorrect, please try again.");
        }
    }
}