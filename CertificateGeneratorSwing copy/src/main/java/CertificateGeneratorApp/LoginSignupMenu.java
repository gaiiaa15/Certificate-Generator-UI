package CertificateGeneratorApp;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginSignupMenu {
    public void firstMenu(){
        ArrayList<String> content = new ArrayList<String>();
        content.add("a. Log in");
        content.add("b. Sign up");

        for(int i = 0; i < content.size(); i++){
            System.out.println(content.get(i));
        }

        String selection;
        boolean choice = false;
        do {
            Scanner user = new Scanner(System.in);
            System.out.println("Choose (a) and (b)\n");
            selection = user.nextLine().trim();
            String options[] ={"a","b"};
            for(int i = 0; i < options.length; i++){
                if(selection.equals(options[i])){
                    choice = true;
                }
            }

        }while(!choice);

        switch(selection){
            case "a":
               /* LogIn log = new LogIn();
                String email = log.log();

                Profile.setEmail(email);*/
                break;
            case "b":
//                NewUser signup = new NewUser();
//                String userEmail = signup.signup();
//                Profile.setEmail(userEmail);
        }

    }



}
