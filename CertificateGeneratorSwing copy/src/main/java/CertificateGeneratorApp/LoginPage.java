package CertificateGeneratorApp;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


import static CertificateGeneratorApp.ExistingUser.userExistingEmail;


public class LoginPage extends JFrame {

    public static void createAndShowGUI() {
        try {
            // the JFrame is the main window where the GUI components are going to be placed
            JFrame frame=new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // this panel will have all the sub panels that have all the components of the page
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
            // the panel is created for all the other GUI components to be placed in
            JPanel panel =new JPanel(new GridBagLayout()){
                Image backgroundImage = ImageIO.read(new File("background.png"));
                //overriding the default panel colour
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Draw the background image.
                    g.drawImage(backgroundImage, 0, 0,this);
                }

            };
            //calling the add logo function in JPanel
            JPanel logoPanel = addLogo(frame);
            logoPanel.setBackground(new Color(30,30,31));
            mainPanel.add(logoPanel, BorderLayout.NORTH);

            //by creating separate variables that have the empty border impacting the padding
            //and another for the colour neither one can affect the other.
            //empty border with padding
            Border paddingBorder = BorderFactory.createEmptyBorder(10,30,10,30);
            //line border with the desired color
            Border lineBorder = BorderFactory.createLineBorder(new Color(121, 124, 128));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 0;
            gbc.gridy  = 0;
            gbc.anchor = GridBagConstraints.WEST;
            //setting the frame size
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        //setting the frame title
            frame.setTitle("Log-In");
//        // the title of the page displayed
            JLabel title = new JLabel("Log In");
            Font font = new Font("Arial Rounded MT", Font.BOLD, 45);
            title.setFont(font);
            title.setForeground(new Color(108, 149, 224));
            //creating a seperate GridBagConsraints for the title label so that it doesn't move all the other labels to the center
            GridBagConstraints titleConstraints = new GridBagConstraints();
            titleConstraints.gridx = 0;
            titleConstraints.gridwidth = 2; //span 2 columns
            titleConstraints.anchor = GridBagConstraints.CENTER;
            panel.add(title, titleConstraints);
            gbc.gridy++;
// the label and textfield for the email
            JLabel lEmail = new JLabel("Email:");
            panel.add(lEmail, gbc);
            lEmail.setForeground(Color.WHITE);
            gbc.gridy++;
            JTextField tEmail = new JTextField(20);
            //making he textfield background transparent
            tEmail.setBackground(new Color(panel.getBackground().getRed(), panel.getBackground().getGreen(), panel.getBackground().getBlue(), 0));
            //setting the text inside the textfield box
            addBorderColour(tEmail);
            //padding for the text in the textfield to be moved to right
            tEmail.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));

            //color of the text
            tEmail.setForeground(Color.WHITE);
            //adding the textfield to the panel
            panel.add(tEmail, gbc);
            gbc.gridy++;
            //error messages
            JLabel emailError = new JLabel("Error");
            emailError.setForeground(new Color(panel.getBackground().getRed(), panel.getBackground().getGreen(), panel.getBackground().getBlue(), 0));
            //emailError.setForeground(Color.RED);
            panel.add(emailError, gbc);
            gbc.gridy++;

// this is the lable and the textfield for the password
            JLabel lPass = new JLabel("Password:");
            panel.add(lPass, gbc);
            lPass.setForeground(Color.WHITE);
            gbc.gridy++;
            JPasswordField tPass = new JPasswordField(20);
            // making the textfield background transparent
            tPass.setBackground(new Color(panel.getBackground().getRed(),
                    panel.getBackground().getGreen(), panel.getBackground().getBlue(), 0));
            addBorderColour(tPass);
            tPass.setForeground(Color.WHITE);
            tPass.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));



            panel.add(tPass, gbc);
            gbc.gridy++;
            //error message
            JLabel passwordError = new JLabel("Error");
            passwordError.setForeground(new Color(panel.getBackground().getRed(), panel.getBackground().getGreen(),
                    panel.getBackground().getBlue(), 0));
            panel.add(passwordError, gbc);
            gbc.gridy++;

            GridBagConstraints labelGrid = new GridBagConstraints();
            labelGrid.insets = new Insets(5, 5, 5, 5);
            labelGrid.gridx = 0;
            labelGrid.gridy = 4;
            labelGrid.gridheight = 0;
            labelGrid.gridwidth = 2;
            labelGrid.anchor = GridBagConstraints.EAST;
            //creating the forgot password label.
            JLabel forgotPasswordLabel = new JLabel("Forgot Password ?");
            forgotPasswordLabel.setForeground(Color.GRAY);
            panel.add(forgotPasswordLabel, labelGrid);
            labelGrid.gridy++;
            forgotPasswordLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked (MouseEvent e) {
                    // when clicked it will open the forgot password page
                    openForgotPasswordPage();
                }
                @Override
                public void mouseEntered (MouseEvent e){
                    //changing the colour of text
                    forgotPasswordLabel.setForeground(Color.WHITE);

                }
                @Override
                public void mouseExited (MouseEvent e) {
                    //changing colour of the text when mouse is out of scope
                    forgotPasswordLabel.setForeground(Color.GRAY);
                }
            });

            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.CENTER;

            // creating the login button
            JButton login=new JButton();

            //setting the colour of the buttons
            login.setBorderPainted(false);
            login.setOpaque(true);
            login.setBackground(new Color(163, 200, 247));

            // this sets the size of the log in button
            login.setPreferredSize(new Dimension(100,30));
            //this sets the text inside the button
            login.setText("Log in");
            panel.add(login, gbc);
            gbc.gridy++;

            gbc.anchor = GridBagConstraints.CENTER;
            login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //calling the method that will handle the log in
                    handleLogin(tEmail, tPass, emailError, passwordError, panel);
                }
            });
//            login.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    //opens the certificate generator page
//                    openCertificateGenerator();
//                }
//            });
            //the Signup Label
            JLabel Lsignup = new JLabel("Sign Up now...");
            Lsignup.setForeground(Color.WHITE);
            Lsignup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            panel.add(Lsignup, gbc);
            gbc.gridy++;

            Lsignup.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    //the user clicks on the label

                    openSignupPage();
                }

              @Override
              public void mouseEntered(MouseEvent e) {
                    // the mouse has entered the label
                  Lsignup.setForeground(new Color(80, 138, 230));
              }

              @Override
                public void mouseExited (MouseEvent e) {
                    // the mouse has exited the label
                  Lsignup.setForeground(Color.WHITE);
              }
            });

            //adding the panel to the frame
            frame.add(mainPanel);
            mainPanel.add(panel);
            //making the frame visible
            panel.setSize(screenSize.width, screenSize.height);
            frame.pack();
            frame.setSize(screenSize.width, screenSize.height);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);



        }catch (IOException e) {
            e.printStackTrace();
           }
    }

    //Display/disappear of default text in the textfields
    static void addBorderColour(JTextField textField){
        Border defaultPadding = BorderFactory.createEmptyBorder(10,30,10,30);
        Border defaultColour = BorderFactory.createLineBorder(Color.GRAY);


        textField.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                //change the border color when focused
                textField.setBorder(BorderFactory.createLineBorder(new Color(69, 146, 247)));

            }
            @Override
            public void focusLost(FocusEvent e) {
                //change color to the default color gray
                textField.setBorder(BorderFactory.createCompoundBorder(defaultColour, defaultPadding));

            }
        });
    }
public static boolean handleLogin(JTextField tEmail, JTextField tPass, JLabel emailError, JLabel passwordError, JPanel panel ) {
        ExistingUser existingUser = new ExistingUser();
        ArrayList<HashMap<String, String>> users = UserInputDatabase.readingFile();
        boolean existingEmail = userExistingEmail(tEmail.getText());
        boolean existingPassword = existingUser.userExistingPswd(users, tPass.getText(), tEmail.getText());
        boolean passedValidation = true;

        String emailErrorText = "";
        boolean emailPassedValidation = true;
        if (!NewUser.isValidEmail(tEmail.getText())) {
            emailPassedValidation = false;
            emailErrorText = "This email is invalid.";
        } else {
            if (!existingEmail) {
                emailPassedValidation = false;
                emailErrorText = "This account does not exist. Please sign up.";
            }
        }

        emailError.setText(emailErrorText);
        //setting the colours of the error message for it to disappear and reappear when needed in red.
       if (emailPassedValidation) {
           emailError.setForeground(new Color(panel.getBackground().getRed(), panel.getBackground().getGreen(),
                   panel.getBackground().getBlue(), 0));
       } else {
           emailError.setForeground(Color.RED);
           emailError.setPreferredSize(new Dimension(300,10));
       }

       String passwordErrorText = "";
       boolean passwordPassedValidation = true;
       //if the password and the email exist then it will let the user in to the certificate generator
       if(existingPassword && existingEmail){
           openCertificateGenerator();
       }
       System.out.println("logged in");

       if(!NewUser.isValidPassword(tPass.getText())) {
           passwordPassedValidation = false;
           passwordErrorText = "Invalid password !";
       } else {
           if(!existingPassword){
               passwordPassedValidation = false;
               passwordErrorText = "This account doesnt exist... Try again";

           }
       }
       passwordError.setText(passwordErrorText);
       if (passwordPassedValidation) {
           passwordError.setForeground(new Color(panel.getBackground().getRed(), panel.getBackground().getGreen(),
                   panel.getBackground().getBlue(), 0));
       } else {
           passwordError.setForeground(Color.RED);
           passwordError.setPreferredSize(new Dimension(300,10));
       }
    return false;

}


    private static void openSignupPage() {
        SignupPage signupPage = new SignupPage();
        signupPage.showSignupPage();

}

    private static void openForgotPasswordPage() {
        ForgotPasswordPage forgotPassword = new ForgotPasswordPage();
        forgotPassword.showForgotPasswordPage();
    }

    private static void openCertificateGenerator() {
        CertificateGenerator cg = new CertificateGenerator();
        cg.showCertificateGenerator();
    }

    public static JPanel addLogo(JFrame frame ) {
         JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
         logoPanel.setBackground(new Color(30,30,31));
         logoPanel.setBackground(new Color(logoPanel.getBackground().getRed(), logoPanel.getBackground().getGreen(),logoPanel.getBackground().getBlue(),0));
        //creating an image icon for the logo image
        ImageIcon logoIcon = new ImageIcon("/Users/gaiiaharb/Library/CloudStorage/OneDrive-AngliaRuskinUniversity/Year 1/" +
                "TrackGenesisProject/CertificateGeneratorSwing/src/main/java/CertificateGeneratorApp/logo.png");
        //specifying the desired width and height of the image
        int desiredWidth = 90;
        int desiredHeight = 85;
        //scaling the image
        Image scaledImage = logoIcon.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon logo = new ImageIcon(scaledImage);
        //set the scaled image in a label
        JLabel logoLabel = new JLabel(logo);


        //adding the image to the panel to  make it visible
        logoPanel.add(logoLabel);
        JLabel programmeName = new JLabel("Certificator");
        programmeName.setForeground(new Color(69, 127, 222));
        Font labelFont = new Font("American Typewriter", Font.PLAIN, 25);
        programmeName.setFont(labelFont);
        logoPanel.add(programmeName);
        return logoPanel;

      }

    }

