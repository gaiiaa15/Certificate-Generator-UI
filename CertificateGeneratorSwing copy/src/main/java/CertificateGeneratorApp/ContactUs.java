package CertificateGeneratorApp;
import java.util.Scanner;

import static CertificateGeneratorApp.ExistingUser.userExistingEmail;

public class ContactUs {
    public void contactUs(){
        System.out.println("----How To Contact Us ?----\n");

        Scanner userName = new Scanner(System.in);
        System.out.println("Name: ");
        String userNameEntry = userName.nextLine();

        Scanner email = new Scanner (System.in);
        System.out.println("Email: ");
        String userEmailEntry = email.nextLine();
        if(userExistingEmail(userEmailEntry)){
            System.out.println("Hello " + userNameEntry);
            Scanner phoneNum = new Scanner(System.in);
            boolean correct = false;
            do {
                System.out.println("Please enter your phone number: ");
                String numberEntry = phoneNum.nextLine();
                if (checkPhoneNumber(numberEntry)) {
                    System.out.println("Phone number is in the correct format.");
                    correct = true;
                } else {
                    System.out.println("Invalid phone number format example : '7869827174'");
                    System.out.println("-----TRY AGAIN-----");
                }
            }while(!correct);


        }else{
            System.out.println("Please make sure you have an account");
            //LogIn.log();
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Query: ");
        String userQuery = scan.nextLine();
        System.out.println("Your query has been sent, someone should contact you soon !");
        menu goBack = new menu();
        goBack.accessMenu();




    }

    public boolean checkPhoneNumber(String numberEntry){
        //accepts exactly 10 digits
        String regex = "^\\d{10}$";

        //checks if the phone number matches the regex pattern
        return numberEntry.matches(regex);
    }
}

