package CertificateGeneratorApp;
import javax.imageio.ImageIO;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.interent.MimeMessage;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.IOException;
//import java.util.Properties;



import static CertificateGeneratorApp.CertificateGenerator.createNavigationBar;
import static CertificateGeneratorApp.LoginPage.addBorderColour;
import static CertificateGeneratorApp.LoginPage.handleLogin;

public class ContactUsPage {
    public void showContactUs(){
        try{
            //creating the frame that will have all the panels with the different components of the page
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //create the main panel
            JPanel mainPanel  = new JPanel();
            mainPanel.setLayout(new BorderLayout());

            //adding the navigation bar and the logo by calling the method from the certificate generator page
            JPanel navigationPanel = createNavigationBar(frame);
            mainPanel.add(navigationPanel, BorderLayout.NORTH);

            //adding the panel with the background image
            JPanel backgroundPanel  = new JPanel(new GridBagLayout()){
                Image backgroundImage = ImageIO.read(new File("background.png"));
                @Override
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
                    //draw the image
                    g.drawImage(backgroundImage, 0, 0,this);

                }
            };

            //creating the gridbag constraints for the panel
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5,5,5,5);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;

            //creating a label to add the title of the page
            JLabel pageTitle = new JLabel("Contact Us");
            //adding the fon t of the text
            Font font = new Font("Arial Round MT", Font.BOLD, 45);
            pageTitle.setFont(font);
            //adding the colour of the text
            pageTitle.setForeground(new Color(108, 149,224));
            // grid bag constraints for the title
            GridBagConstraints titleGBC = new GridBagConstraints();
            titleGBC.insets = new Insets(0,15,15,0);
            titleGBC.gridx = 0;
            titleGBC.gridwidth = 2;
            //setting the title to the left side of the page
            titleGBC.anchor = GridBagConstraints.WEST;
            //adding the title and the constraints to the background panel
            backgroundPanel.add(pageTitle, titleGBC);
            gbc.gridy++;
            //adding the query or  and label
            JLabel feedback = new JLabel("Feedback:");
            feedback.setForeground(Color.WHITE);
            //creating the font and the size of text
            Font feedbackFont = new Font("Arial Round MT", Font.PLAIN,18);
            //using the font method that was used for the title
            feedback.setFont(feedbackFont);
            //adding the label to the panel to make it visible on the screen
            backgroundPanel.add(feedback, gbc);
            gbc.gridy++;

            // the textfield for the feedback
            JTextField feedbackText = new JTextField();
            //setting the new dimensions for the textfield
            feedbackText.setPreferredSize(new Dimension(500,150));
            //making the background color of the text field transparent
            feedbackText.setBackground(new Color(backgroundPanel.getBackground().getRed(), backgroundPanel.getBackground().getGreen(), backgroundPanel.getBackground().getBlue(),0));
            //adding the border colour so when the user clicks on the text field it changes colour
            addBorderColour(feedbackText);
            //empty border with padding
            Border paddingBorder = BorderFactory.createEmptyBorder(0,0,0,0);
            //line border with the desired color
            Border lineBorder = BorderFactory.createLineBorder(new Color(121, 124, 128));
            //adding the padding for the border
            feedbackText.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
            //setting the text colour inside the textfield
            feedbackText.setForeground(Color.WHITE);
            //adding the textfield to the background panel with all the other components
            backgroundPanel.add(feedbackText, gbc);
            gbc.gridy++;

            //create a label for the query text field
            JLabel query  = new JLabel("Query:");
            //setting the colour for the label
            query.setForeground(Color.WHITE);
            //setting the font and the size of the label
            query.setFont(feedbackFont);
            //add the label to the panel
            backgroundPanel.add(query, gbc);
            gbc.gridy++;

            //adding the textField for the questions
            JTextField queryText = new JTextField();
            //setting the dimension for the text field
            queryText.setPreferredSize(new Dimension(500, 150));
            //making the background color to transparent
            queryText.setBackground(new Color(backgroundPanel.getBackground().getRed(), backgroundPanel.getBackground().getGreen(), backgroundPanel.getBackground().getBlue(),0));
            //adding the border colour when the user clicks the text field
            addBorderColour(queryText);
            //adding the padding and the border for the text field
            queryText.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
            //setting the text colour inside the text field
            queryText.setForeground(Color.WHITE);
            //adding teh text field to the background panel with all the other components
            backgroundPanel.add(queryText, gbc);
            gbc.gridy++;


             GridBagConstraints buttonLayout = new GridBagConstraints();
             buttonLayout.gridx = 0;
             buttonLayout.anchor = GridBagConstraints.CENTER;
            JButton sendButton = new JButton();
            //setting the text
            sendButton.setText("Send");
            sendButton.setBorderPainted(false);
            sendButton.setOpaque(true);
            sendButton.setBackground(new Color(163,200,247));
            backgroundPanel.add(sendButton, buttonLayout);
            gbc.gridy++;




            //adding the main panel to the frame
            frame.add(mainPanel);
            mainPanel.add(backgroundPanel,BorderLayout.CENTER);
            frame.pack();
            frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);


        }catch(IOException e){
            e.printStackTrace();
        }




    }
}
