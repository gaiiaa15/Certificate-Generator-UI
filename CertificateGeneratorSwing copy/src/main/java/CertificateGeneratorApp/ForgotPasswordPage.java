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
import static CertificateGeneratorApp.LoginPage.addLogo;

public class ForgotPasswordPage {
    boolean userHasEnteredEmail = false;
    public void showForgotPasswordPage() {
        try {
            JFrame fPasswordFrame = new JFrame();
            fPasswordFrame.setDefaultCloseOperation(fPasswordFrame.EXIT_ON_CLOSE);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
            //adding the logo to the top right of the page
            JPanel logoPanel = addLogo(fPasswordFrame);
            logoPanel.setBackground(new Color(30,30,31));
            mainPanel.add(logoPanel, BorderLayout.NORTH);


            //panel for all the other components on the page
            JPanel forgotPasswordPanel = new JPanel(new GridBagLayout()) {
                Image backgroundImage = ImageIO.read(new File("background.png"));

                //overriding the panel background colour
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    //drawing the background image
                    g.drawImage(backgroundImage, 0, 0, this);

                }
            };

            Border textFieldBorderPadding = BorderFactory.createEmptyBorder(10, 30, 10, 30);
            Border borderColour = BorderFactory.createLineBorder(new Color(121, 124, 128));


            GridBagConstraints forgotPasswordGBC = new GridBagConstraints();
            forgotPasswordGBC.insets = new Insets(5, 5, 5, 5);
            forgotPasswordGBC.gridx = 0;
            forgotPasswordGBC.gridy = 0;
            forgotPasswordGBC.anchor = GridBagConstraints.WEST;

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            //title of the page
            JLabel forgotPasswordPageTitle = new JLabel("Reset your password");
            //creating the font for the title
            Font titleFont = new Font("Arial Rounded MT", Font.BOLD, 45);
            //setting the title font
            forgotPasswordPageTitle.setFont(titleFont);
            //setting the new colour for the text
            forgotPasswordPageTitle.setForeground(new Color(108, 149, 224));
            //creating a new grid for the title
            GridBagConstraints titleLayout = new GridBagConstraints();
            titleLayout.insets = new Insets(5, 5, 20, 5);
            titleLayout.gridx = 0;
            titleLayout.gridwidth = 3;
            titleLayout.anchor = GridBagConstraints.CENTER;
            forgotPasswordPanel.add(forgotPasswordPageTitle, titleLayout);
            forgotPasswordGBC.gridy++;

            //email label
            JLabel emailLabel = new JLabel("Email:");
            //setting the colour of the text
            emailLabel.setForeground(Color.WHITE);
            //new layout for the labels
            GridBagConstraints labelLayouts = new GridBagConstraints();
            labelLayouts.gridx = 0;
            labelLayouts.gridwidth = 3;
            labelLayouts.anchor = GridBagConstraints.CENTER;
            forgotPasswordPanel.add(emailLabel, labelLayouts);
            forgotPasswordGBC.gridy++;

            //email textfield
            JTextField email = new JTextField(20);
            //setting the colour of the text field to be transparent
            email.setBackground(new Color(forgotPasswordPanel.getBackground().getRed(), forgotPasswordPanel.getBackground().getGreen(),
                    forgotPasswordPanel.getBackground().getBlue(), 0));
            borderColourChange(email);
            //setting the colour of the text colour inside the textfield
            email.setForeground(Color.WHITE);
            email.setBorder(BorderFactory.createCompoundBorder(borderColour, textFieldBorderPadding));
            GridBagConstraints textFieldsLayout = new GridBagConstraints();
            textFieldsLayout.insets = new Insets(5, 5, 20, 5);
            textFieldsLayout.gridx = 0;
            textFieldsLayout.gridwidth = 3;
            textFieldsLayout.anchor = GridBagConstraints.CENTER;
            forgotPasswordPanel.add(email, textFieldsLayout);
            forgotPasswordGBC.gridy++;
            //email error
            JLabel emailErrorMessage = new JLabel("Error");
            emailErrorMessage.setForeground(new Color(forgotPasswordPanel.getBackground().getRed(), forgotPasswordPanel.getBackground().getGreen(),
                   forgotPasswordPanel.getBackground().getBlue(),0));
            //emailErrorMessage.setForeground(Color.RED);
            forgotPasswordPanel.add(emailErrorMessage, labelLayouts);
            forgotPasswordGBC.gridy++;

            //label above the textfield
            JLabel newPasswordLabel = new JLabel("Enter new password:");
            //setting the colour of the text
            newPasswordLabel.setForeground(new Color(forgotPasswordPanel.getBackground().getRed(),
                    forgotPasswordPanel.getBackground().getGreen(), forgotPasswordPanel.getBackground().getBlue(),0));
            forgotPasswordPanel.add(newPasswordLabel, labelLayouts);
            forgotPasswordGBC.gridy++;


            // new password textfield
            JTextField newPasswordTextField = new JTextField(20);
            forgotPasswordPanel.add(newPasswordTextField, forgotPasswordGBC);
            //setting the background colour of the text field to transparent
            newPasswordTextField.setBackground(new Color(forgotPasswordPanel.getBackground().getRed(), forgotPasswordPanel.getBackground().getGreen(),
                    forgotPasswordPanel.getBackground().getBlue(), 0));
            //adding the change of border colour when you press on the textfield
            Border defaultPadding = BorderFactory.createEmptyBorder(10, 30, 10, 30);
            Border defaultColour = BorderFactory.createLineBorder(new Color(forgotPasswordPanel.getBackground().getRed(),
                    forgotPasswordPanel.getBackground().getGreen(), forgotPasswordPanel.getBackground().getBlue(),0));
            //colour change for the text field
            newPasswordTextField.setBorder(BorderFactory.createCompoundBorder(defaultColour, defaultPadding));
            //setting the colour of the text in the  text field
            newPasswordTextField.setForeground(Color.WHITE);
            //newPasswordTextField.setBorder(BorderFactory.createCompoundBorder(borderColour, textFieldBorderPadding));
            forgotPasswordPanel.add(newPasswordTextField, textFieldsLayout);
            forgotPasswordGBC.gridy++;

            //label for the password errors
            JLabel passwordErrors = new JLabel("Error");
            passwordErrors.setForeground(new Color(forgotPasswordPanel.getBackground().getRed(), forgotPasswordPanel.getBackground().getGreen(),
                    forgotPasswordPanel.getBackground().getBlue(), 0));
            forgotPasswordPanel.add(passwordErrors, labelLayouts);
            forgotPasswordGBC.gridy++;


            // button that they can press to take them back to the login page fate they have reset their password
            JButton resetButton = new JButton();
            //setting the colour of the button
            resetButton.setBorderPainted(false);
            resetButton.setOpaque(true);
            resetButton.setBackground(new Color(163, 200, 247));
            //setting the size of the reset password button
            resetButton.setPreferredSize(new Dimension(200, 30));
            GridBagConstraints buttonLayout = new GridBagConstraints();
            buttonLayout.gridx = 0;
            buttonLayout.gridwidth = 3;
            buttonLayout.anchor = GridBagConstraints.CENTER;
            //adding text inside the button
            resetButton.setText("Reset Password");
            forgotPasswordPanel.add(resetButton, buttonLayout);
            forgotPasswordGBC.gridy++;

            resetButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //when the button is clicked it will open the login page for the user to log in again
                    //openLogInPage();
                    System.out.println("Click");
                    emailAndPasswordChecks(email, emailErrorMessage, newPasswordLabel,passwordErrors, newPasswordTextField, forgotPasswordPanel);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    //when the mouse is inside the button will change colour
                    resetButton.setBackground(Color.GRAY);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    //when the mouse exists the colour of the button goes back to blue
                    resetButton.setBackground(new Color(163, 200, 247));
                }

            });
            //adding the panel to the frame
            fPasswordFrame.add(mainPanel);
            mainPanel.add(forgotPasswordPanel);
            forgotPasswordPanel.setSize(screenSize.width, screenSize.height);
            fPasswordFrame.pack();
            fPasswordFrame.setSize(screenSize.width, screenSize.height);
            fPasswordFrame.setLocationRelativeTo(null);
            fPasswordFrame.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public static void borderColourChange(JTextField textField) {
        Border defaultPadding = BorderFactory.createEmptyBorder(10, 30, 10, 30);
        Border defaultColour = BorderFactory.createLineBorder(Color.GRAY);

        textField.addFocusListener(new FocusListener() {
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


    public void emailAndPasswordChecks(JTextField email, JLabel emailErrorMessage, JLabel password,
                                       JLabel passwordErrors,
                                       JTextField passwordField,
                                       JPanel forgotPasswordPanel){
        ExistingUser existingUser = new ExistingUser();
        ForgotPassword newPass = new ForgotPassword();
        ArrayList<HashMap<String, String>> users = UserInputDatabase.readingFile();


        boolean existingEmail = userExistingEmail(email.getText());
       ;
       // boolean changingPass = ForgotPassword.resetPassword(passwordField.getText(), email.getText());

        if (!this.userHasEnteredEmail) {
            String emailErrorText = null;
            //boolean to check of the email has been verified to make the password field disappear
            boolean emailVerified = true;
            //checks if the email field is empty and if it is it will show the error message in red
            boolean emailEntered = true;
            if(email.getText().isEmpty()){
                emailEntered = false;
                emailVerified = false;
                emailErrorText = "Field Required!";
            }
            emailErrorMessage.setText(emailErrorText);

            if(emailEntered){
                //error message transparent if the checks are all correct
                emailErrorMessage.setForeground(new Color (forgotPasswordPanel.getBackground().getRed(),
                        forgotPasswordPanel.getBackground().getGreen(),
                        forgotPasswordPanel.getBackground().getBlue(),0));

                //boolean to check if the email exists in the user database
                boolean emailExists = true;


                if (!userExistingEmail(email.getText())) {
                    emailExists = false;
                    emailErrorText = "Your Email does not exist";
                }
                emailErrorMessage.setText(emailErrorText);
                if (emailExists) {
                    emailErrorMessage.setForeground(new Color (forgotPasswordPanel.getBackground().getRed(),
                            forgotPasswordPanel.getBackground().getGreen(), forgotPasswordPanel.getBackground().getBlue(), 0));

                    Border changeBorderColour = BorderFactory.createLineBorder(Color.GRAY);
                    Border defaultPadding = BorderFactory.createEmptyBorder(10, 30, 10, 30);
                    //changing the colour of the text field
                    passwordField.setBorder(BorderFactory.createCompoundBorder(changeBorderColour, defaultPadding));
                    //changing the colour of the label
                    password.setForeground(Color.WHITE);
                    borderColourChange(passwordField);

                    this.userHasEnteredEmail = true;


                } else {
                    //error message red if thr checks are false
                    emailErrorMessage.setForeground(Color.RED);
                }

            } else{
                emailErrorMessage.setForeground(Color.RED);

            }
        } else {
            String passwordErrorMessage = null;
            boolean emptyPasswordField = false;
            if(passwordField.getText().isEmpty()){
                emptyPasswordField = true;
                passwordErrorMessage = "Required Field!";

            }
            passwordErrors.setText(passwordErrorMessage);
            if(emptyPasswordField){
                passwordErrors.setForeground(Color.RED);
            } else {
                passwordErrors.setForeground(new Color (forgotPasswordPanel.getBackground().getRed(), forgotPasswordPanel.getBackground().getGreen(),
                        forgotPasswordPanel.getBackground().getBlue(),0));
                boolean passwordExist = false;
                boolean existingPassword = existingUser.userExistingPswd(users, passwordField.getText(),email.getText());
                if(existingPassword){
                    passwordExist = true;
                    passwordErrorMessage = "use different password";

                }
                passwordErrors.setText(passwordErrorMessage);
                if(passwordExist){
                    passwordErrors.setForeground(Color.RED);
                } else {
                    passwordErrors.setForeground(new Color (forgotPasswordPanel.getBackground().getRed(), forgotPasswordPanel.getBackground().getGreen(),
                            forgotPasswordPanel.getBackground().getBlue(),0));
                    ForgotPassword.resetPassword(passwordField.getText(), email.getText());
                }
            }


        }







    }



    public static void openLogInPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.createAndShowGUI();
    }
}


