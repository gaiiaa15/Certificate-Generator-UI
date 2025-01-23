package CertificateGeneratorApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class ExistingUser {
    public static boolean userExistingEmail(String userName){
        ArrayList<HashMap<String, String>> users = UserInputDatabase.readingFile();
        boolean userExists = false;
        //this will check if the username entered exists in the user DB
        for(int i = 0; i < users.size(); i++){

            if(userName.equals(users.get(i).get("email")) && !userExists){
                userExists = true;
            }
        }

        return userExists;
    }
    //this will loop through the array list hash map and check if the password entered exists
    public boolean userExistingPswd( ArrayList<HashMap<String, String>> users, String pswd, String userName){
        UserInputDatabase.readingFile();
        boolean pswdcorrect = false;
        boolean userExists = false;

        //this will check if the username entered exists in the user DB
        for(int i = 0; i < users.size(); i++){
            if(userName.equals(users.get(i).get("email")) && !userExists){
                userExists = true;
                if (users.get(i).get("password").equals(pswd)) {
                    pswdcorrect = true;
                }

            }
        }

        return pswdcorrect;
    }
    //this method will loop through the array list and print it out
    public static void passwordRequirements(){
        ArrayList<String> passwordRequirements = new ArrayList<String>();
        passwordRequirements.add("1.Password should at last have 8 characters");
        passwordRequirements.add("2.Password should include at least one lower case letter and upper case letter");
        passwordRequirements.add("3.Password should contain at least one digit");
        passwordRequirements.add("4.Password should include at least one special character");
        for(int i = 0; i <passwordRequirements.size();i++){
            System.out.println(passwordRequirements.get(i));
        }
    }

}


