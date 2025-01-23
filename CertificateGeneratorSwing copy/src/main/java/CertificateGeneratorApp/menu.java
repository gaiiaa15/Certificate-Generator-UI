package CertificateGeneratorApp;
import java.util.ArrayList;
import java.util.Scanner;


public class menu {
    public void accessMenu() {
        //menu
        ArrayList<String> menuContent = new ArrayList<String>();
        menuContent.add("a. Certificate Generator");
        menuContent.add("b. Profile");
        menuContent.add("c. Contact us");
        menuContent.add("d. About us");
        menuContent.add("e. Help Page");
        for (int i = 0; i < menuContent.size(); i++) {
            System.out.println(menuContent.get(i));
        }
        String menuChoice;
        boolean correctOption = false;
        do {


            //user input
            Scanner scanInput = new Scanner(System.in);
            System.out.println("Select one of the pages:");
            menuChoice = scanInput.nextLine().trim();
            String[] options = {"a","b","c","d","e"};
            for(int i = 0; i < options.length; i++){
                if(menuChoice.equals(options[i])){
                    correctOption = true;
                }
            }


        }while(!correctOption);


        switch (menuChoice) {
            case "a":
                Generator CG = new Generator();
                CG.specificationForm();
                break;
            case "b":
                Profile accessingProfile = new Profile();
                accessingProfile.accessingProfile();
                break;
            case "c":
                ContactUs contactUs = new ContactUs();
                contactUs.contactUs();
                break;
            case "d":
                AboutUs aboutUs = new AboutUs();
                aboutUs.aboutUs();
                break;
            case "e":
                Help help = new Help();
                help.help();
                break;


        }
    }



}
