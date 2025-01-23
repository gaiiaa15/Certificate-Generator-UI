package CertificateGeneratorApp;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static CertificateGeneratorApp.ExistingUser.userExistingEmail;
import static CertificateGeneratorApp.LoginPage.addLogo;
import static CertificateGeneratorApp.NewUser.*;


public class SignupPage extends JFrame {

    public void showSignupPage() {
        // Create GUI components for signup page
        try {
            JFrame signupFrame = new JFrame();
            signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());

            JPanel logoPanel  =  addLogo(signupFrame);
            logoPanel.setBackground(new Color(30,30,31));
            mainPanel.add(logoPanel, BorderLayout.NORTH);


            //add the panel
            JPanel signupPanel = new JPanel(new GridBagLayout()) {
                Image backgroundImage = ImageIO.read(new File("background.png"));

                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage, 0, 0, this);
                }

            };
            //empty border with padding
            Border paddingBorder = BorderFactory.createEmptyBorder(10, 30, 10, 30);
            //line border with the desired color
            Border lineBorder = BorderFactory.createLineBorder(new Color(121, 124, 128));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            //dimensions of the screen to be able to set the frame and the panel to the screen size
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            //setting the title of the frame
            signupFrame.setTitle("Sign-up");
            //setting the title of the page
            JLabel pageTitle = new JLabel("Sign up");
            Font font = new Font("Arial Rounded MT", Font.BOLD, 45);
            pageTitle.setFont(font);
            pageTitle.setForeground(new Color(108, 149, 224));
            //creating a new grid bag contraints to be able to positionn the title in the middle
            //nothing else will be affected
            GridBagConstraints titleConstraints = new GridBagConstraints();
            titleConstraints.gridx = 0;
            titleConstraints.gridwidth = 2;
            titleConstraints.anchor = GridBagConstraints.CENTER;
            signupPanel.add(pageTitle, titleConstraints);
            //this adds the label vertically
            gbc.gridy++;

            //email label
            JLabel emailLabel = new JLabel("Email:");
            signupPanel.add(emailLabel, gbc);
            emailLabel.setForeground(Color.WHITE);
            gbc.gridy++;

            //email textfield
            JTextField signupEmail = new JTextField(20);
            //setting the colour of the text field to transparent
            signupEmail.setBackground(new Color(signupPanel.getBackground().getRed(), signupPanel.getBackground().getGreen(), signupPanel.getBackground().getBlue(), 0));
            //text inside the text field to twll the user what to do
            //addDefaultText(signupEmail,"Enter your Email");
            //creating the padding and the line border of the text field.
            signupEmail.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
            //setting the colour of the text
            signupEmail.setForeground(Color.WHITE);
            addBorder(signupEmail);
            //adding the text field to the panel
            signupPanel.add(signupEmail, gbc);
            gbc.gridy++;

            //email exists error
            JLabel emailErrorMessage = new JLabel("Error");
            emailErrorMessage.setForeground(new Color(signupPanel.getBackground().getRed(), signupPanel.getBackground().getGreen(),
                    signupPanel.getBackground().getBlue(), 0));
            signupPanel.add(emailErrorMessage, gbc);
            gbc.gridy++;

            //password label
            JLabel passLabel = new JLabel("Password:");
            signupPanel.add(passLabel, gbc);
            passLabel.setForeground(Color.WHITE);
            gbc.gridy++;

            JPasswordField signupPassword = new JPasswordField(20);
            //setting the colour of the text field to transparent
            signupPassword.setBackground(new Color(signupPanel.getBackground().getRed(), signupPanel.getBackground().getGreen(),
                    signupPanel.getBackground().getBlue(), 0));
            //text inside the text field to tell the user what to do
            //addDefaultText(signupPassword,"Enter your Password");
            //creating the padding and the line border of the text field.
            signupPassword.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
            //setting the colour of the text
            signupPassword.setForeground(Color.WHITE);
            //adding the text field to the panel
            signupPanel.add(signupPassword, gbc);
            addBorder(signupPassword);
            gbc.gridy++;

            //error message if the password exists or is incorrect
            JLabel passError = new JLabel();
            signupPanel.add(passError, gbc);
            gbc.gridy++;

            JLabel pass2Label = new JLabel("Re-enter password");
            signupPanel.add(pass2Label, gbc);
            pass2Label.setForeground(Color.WHITE);
            gbc.gridy++;

            JPasswordField pass2 = new JPasswordField(20);
            //setting the colour of the textfield to transparent
            pass2.setBackground(new Color(signupPanel.getBackground().getRed(), signupPanel.getBackground().getGreen(),
                    signupPanel.getBackground().getBlue(), 0));
            //text inside the text field box to tell the user what to do
            //addDefaultText(pass2, "Enter password again");
            //creating the padding and the line border of the textfield
            pass2.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
            //setting the colour of the text
            pass2.setForeground(Color.WHITE);
            //adding it to the panel
            signupPanel.add(pass2, gbc);
            //adding the changing text field colour
            addBorder(pass2);
            gbc.gridy++;

            JLabel passError2 = new JLabel();
            signupPanel.add(passError2, gbc);
            gbc.gridy++;

            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.CENTER;

            JButton signupButton = new JButton("Sign up");
            signupButton.setBorderPainted(false);
            signupButton.setOpaque(true);
            signupButton.setBackground(new Color(163, 200, 247));
            signupPanel.add(signupButton, gbc);
            //setting the size of the button
            signupButton.setPreferredSize(new Dimension(100, 30));

            //action to call the handle signup method
            signupButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //calling the method needed to be performed when pressed on the button
                    handleSignup(signupPassword, signupEmail, pass2,  emailErrorMessage, passError,passError2,signupButton,  signupPanel);
                }
            });
            gbc.gridy++;

            signupFrame.add(mainPanel);
            mainPanel.add(signupPanel);
            //signupFrame.add(signupPanel);
            signupFrame.pack();
            signupFrame.setSize(screenSize.width, screenSize.height);
            signupFrame.setLocationRelativeTo(null);
            signupFrame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static void addBorder(JTextField textField) {
        Border defaultPadding = BorderFactory.createEmptyBorder(10, 30, 10, 30);
        Border defaultColour = BorderFactory.createLineBorder(Color.GRAY);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //change the border colour of the text box
                textField.setBorder(BorderFactory.createLineBorder(new Color(69, 146, 247)));
            }

            @Override
            public void focusLost(FocusEvent e) {

                //change the colour to default grey when not focused
                textField.setBorder(BorderFactory.createCompoundBorder(defaultColour, defaultPadding));

            }

        });
    }

    public static boolean handleSignup(JTextField signupPassword, JTextField signupEmail, JTextField pass2, JLabel emailError, JLabel passError, JLabel passError2,JButton signupButton,
                                       JPanel signupPanel) {
        NewUser newUser = new NewUser();
        ArrayList<HashMap<String, String>> users = UserInputDatabase.readingFile();

        //get the text from the email text field
        String emailText = signupEmail.getText().trim(); // trim removes leading and trailing whitespace
        String passwordText = signupPassword.getText().trim();
        String passwordText2 = pass2.getText().trim();


        //check if the email text field is empty
        boolean validEmail = true;
        String emailErrorMessage = null;
        if (emailText.isEmpty()) {
            validEmail = false;
            //if it's empty, set an error message
            emailErrorMessage = "Email is required";
        }


        if (userExistingEmail(signupEmail.getText())) {
            validEmail = false;
            emailErrorMessage = "Email already exists";
        } else {
            if (!isValidEmail(signupEmail.getText())) {
                validEmail = false;
                emailErrorMessage = "Invalid email";
            }
        }

        setErrorText(validEmail, emailError, emailErrorMessage, signupPanel);

        boolean validPassword1 = newUser.isValidPassword(signupPassword.getText());
        String firstPassErrorMessage = null;
        String secondPassErrorMessage = null;
        boolean passValid = true;
        // checking if the password fields are empty
        if (passwordText.isEmpty()) {
            passValid = false;
            firstPassErrorMessage = "Required Field";
            if (validPassword1) {
                passValid = false;
                firstPassErrorMessage = "Invalid password";
            }
        }

        setErrorText(passValid, passError, firstPassErrorMessage, signupPanel);
        boolean validPassword2 = newUser.isValidPassword(pass2.getText());
        boolean passwordValidation = true;
        if (passwordText2.isEmpty()) {
            passwordValidation = false;
            secondPassErrorMessage = "Required Field";
        } else {
            if (!isValidPassword(passwordText2)) {
                passwordValidation = false;
                secondPassErrorMessage = "Invalid password";
            } else
                // if both fields are not empty, check if they match
                if (passwordText.equals(passwordText2)) {
                        passwordValidation = true;
                        //secondPassErrorMessage = "Password already exists";
                    } else {
                        passwordValidation = false;
                        secondPassErrorMessage = "The password entered does not match the requirements";
                    }
                }

        setErrorText(passwordValidation, passError2, secondPassErrorMessage,signupPanel);

        if (validEmail && passValid && passwordValidation) {
            UserInputDatabase.store(signupEmail.getText(), pass2.getText());
            signupButton.setBackground(Color.GREEN);
            signupButton.setText("Account Created");
            signupButton.setPreferredSize(new Dimension(200,30));
            
        }

return false;

    }
    public static void setErrorText( boolean validation, JLabel errorLabel, String errorMessage, JPanel signupPanel)
    {
        errorLabel.setText(errorMessage);
        if (validation) {
            errorLabel.setForeground(new Color(signupPanel.getBackground().getRed(), signupPanel.getBackground().getGreen(),
                    signupPanel.getBackground().getBlue(), 0));
        } else {
            errorLabel.setForeground(Color.RED);
            errorLabel.setPreferredSize(new Dimension(300, 15));

        }
    }
}



