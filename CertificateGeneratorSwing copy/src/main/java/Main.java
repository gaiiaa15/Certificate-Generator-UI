import javax.swing.*;
import static CertificateGeneratorApp.LoginPage.createAndShowGUI;


public class Main {
    public static void main(String[] args){

       SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               createAndShowGUI();
               //showCertificateGenerator();

           }
       });




    }
}