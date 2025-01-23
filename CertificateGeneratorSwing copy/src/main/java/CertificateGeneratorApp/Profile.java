package CertificateGeneratorApp;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Profile {

    public static String email;

    public static void setEmail(String emailValue){
        email = emailValue;
    }


    public int accessingProfile() {
         boolean choices = false;
        do {
            ArrayList<String> subMenu = new ArrayList<>();
            subMenu.add("a. View Profile");
            subMenu.add("b. Change Password");
            subMenu.add("c. Log Out");
            for (int i = 0; i < subMenu.size(); i++) {
                System.out.println(subMenu.get(i));
            }
            boolean correctOption = false;
            String inputOpt;
            do {
                Scanner input = new Scanner(System.in);
                System.out.println("Please select an option:");
                inputOpt = input.nextLine();
                String[] options = {"a", "b", "c"};
                for (int i = 0; i < options.length; i++) {
                    if (inputOpt.equals(options[i])) {
                        correctOption = true;
                    }
                }
            } while (!correctOption);


            String userInput;
            switch (inputOpt) {
                case "a":
                    System.out.println("This is your Profile\n");
                    System.out.println("your email: " + email);
                    choices = true;
                    break;
                case "b":
                    Scanner scan = new Scanner(System.in);
                    System.out.println("If you want to change your password press 'y'");
                    userInput = scan.nextLine().toLowerCase();
                    checkChangePassword(userInput);
                    choices = true;
                    break;

                case "c":
                    Scanner logout = new Scanner(System.in);
                    System.out.println("Press 'x' to log out: ");
                    String user = logout.nextLine().toLowerCase();

                    if (Objects.equals(user, "x")) {
                        choices = true;
                        System.out.println("You've been logged out...\n");
                    }
                    break;
            }
        }while(!choices);

        return 0;
    }

    public void checkChangePassword (String userInput){
        if(userInput.equals('y')){
            ForgotPassword.restore();
        }else{
            System.out.println("Please enter the letter 'y' to change password");
        }

    }
}