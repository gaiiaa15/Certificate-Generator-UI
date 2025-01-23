package CertificateGeneratorApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewUser {


    public static boolean isValidEmail(String email) {
        //regular expression pattern for a valid email address
        String emailRegex = "^[a-zA-Z0-9_+.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        //compile the pattern
        Pattern pattern = Pattern.compile(emailRegex);

        //create a Matcher object
        Matcher matcher = pattern.matcher(email);

        //return true if the email matches the patter, false otherwise
        return matcher.matches();
    }


    public static boolean isValidPassword( String password) {
        //check the length of the password
        if(password.length() < 8){
            return false;

        }

        //check for at least on uppercase letter
        if(!password.matches(".*[A-Z].*")) {
            System.out.println("Please make sure you include an upper case letter in your password!\n");
            System.out.println("---TRY AGAIN---");
            return false;
        }

        //checks if the user included lowe case letters
        if(!password.matches(".*[a-z].*")){
            System.out.println("Please make sure you have at least 1 lower case letter in your password!\n");
            System.out.println("---TRY AGAIN---");
            return false;
        }
        //checks for at least one digit
        if(!password.matches(".*\\d.*")){
            System.out.println("Please make sure that you have at least one digit included");
            System.out.println("---TRY AGAIN---");
            return false;
        }
        //checks for the least one special character
        if(!password.matches(".*[!@#$%^&*()-+=?].*")) {
            System.out.println("Please make sure you have at least one special character");
            System.out.println("---TRY AGAIN---");
            return false;
        }
        //if all the criteria is met
        return true;

    }
}




