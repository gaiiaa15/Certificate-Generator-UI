package CertificateGeneratorApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ForgotPassword {
    private static ArrayList<HashMap<String, String>> users;

    public static void restore() {
        boolean correct = false;
        String getEmail;
        do {
            Scanner enter = new Scanner(System.in);
           // System.out.print("Please enter email first: ");
            getEmail = enter.nextLine();
            if (ExistingUser.userExistingEmail(getEmail)) {
                correct = true;
            }
        } while (!correct);

        boolean checking = false;

        do {
            ExistingUser.passwordRequirements();
            Scanner fPswd = new Scanner(System.in);
           // System.out.println("Enter new Password\n");
            String answer = fPswd.nextLine();
            if (NewUser.isValidPassword(answer)) {
                checking = true;
                resetPassword(answer, getEmail);
            }

        }while(!checking);
    }


    public static boolean resetPassword(String newPass, String userName){
        ArrayList<HashMap<String, String>> users = UserInputDatabase.readingFile();
        boolean userExists = false;

        //this will check if the username entered exists in the user DB
        for(int i = 0; i < users.size(); i++){
            if(userName.equals(users.get(i).get("email")) && !userExists){
                userExists = true;
                users.get(i).put("password", newPass );

                UserInputDatabase.updating(i, users.get(i).get("email"), newPass);
            }
        }
        return userExists;
    }

}
