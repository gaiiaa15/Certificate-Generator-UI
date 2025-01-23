package CertificateGeneratorApp;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import static CertificateGeneratorApp.CertificateGenerator.createNavigationBar;
public class AboutPage {
    public void showAboutPage (){
        try{
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //create a panel that will have the nav bar, as well as the image panel
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
            //create and add the navigation bar
            JPanel navBar = createNavigationBar(frame);//calls the method createNavigationBar from another file
            mainPanel.add(navBar, BorderLayout.NORTH);

            //adding the panel
            JPanel backgroundPanel = new JPanel( new GridBagLayout()){
                Image backgroundImage = ImageIO.read(new File("background.png"));
                @Override
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
                    //draw the background image
                    g.drawImage(backgroundImage, 0, 0,this);
                }
            };

            //creating the grid for the panel
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets (5,5,5,5);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;

            //created a label for the title of the page
            JLabel title = new JLabel("About Us");
            //adding the font for the title
            Font font = new Font("Arial Round MT", Font.BOLD, 45);
            //setting the font to the title
            title.setFont(font);
            //adding the colour of the text
            title.setForeground(new Color(108, 149,224));

            //creating a string for the text
            String aboutText =
                    "My name is Gaia, im a Software Engineer student that has designed and coded this programme.\n"
                    + "It was one of my first year final projects that i decided to play around with and get more creative with it. "
                    +"This programme has been designed to allow you to create multiple certificates of the same or different type"
                    + "at once. My goal is to have an easy and simple programme for everyone to use.\n"
                    + "However, if you find any difficulties or some bugs, please do not hesitate to contact me via the Contact Us"
                    + "page, it would be much appreciated if you give me your feedback so i can use it ot improve my skill and this\n"
                    +"programme."
                    ;
            //creating the text area that will store the text String
            JTextArea textPar = new JTextArea(aboutText);
            textPar.setEditable(false); // make it non-editable
            textPar.setLineWrap(true); // enable line wrapping to make it a paragraph
            textPar.setWrapStyleWord(true); // Wrap at word boundaries
            textPar.setFont(new Font ("Arial", Font.PLAIN, 17));
            //making the background colour transparent
            textPar.setBackground(new Color(0,0,0,0));// alpha value 0 = transparent
            //changing the text colour
            textPar.setForeground(Color.WHITE);
            //change size of the text area
            //textPar.setPreferredSize(new Dimension(500,500));
            textPar.setBounds(0,0,700,700);
            //title layout
            GridBagConstraints titleGBC = new GridBagConstraints();
            // the insets are for the location of the title on the screen
            titleGBC.insets = new Insets (0, 15,15,0);
            titleGBC.gridx = 0;
            titleGBC.gridwidth = 2;
            // this sets the title to the left side of the panel
            titleGBC.anchor = GridBagConstraints.WEST;
            //adding the title and the constraints to the panel so that we can see it on the screen
            backgroundPanel.add(title, titleGBC);
            //adding the components vertically
            titleGBC.gridy++;

            //layout for paragraph
            GridBagConstraints textGBC = new GridBagConstraints();
            textGBC.insets = new Insets(0,20,20,0);
            textGBC.gridx = 0;
            textGBC.gridwidth = 10;
            textGBC.anchor = GridBagConstraints.WEST;
            backgroundPanel.add(textPar, textGBC);
            textGBC.gridy++;

            // adding the main panel to the frame so we can see all the components on the screen
            frame.add(mainPanel);
            //adding all the sub-panels that have different components and anchoring them in the center
            mainPanel.add(backgroundPanel, BorderLayout.CENTER);
            frame.pack();
            //this gets the screen size and sets the frame to that size
            frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frame.setLocationRelativeTo(null);
            //setting the frame to be visible to be able to have everything appear on the screen
            frame.setVisible(true);

        }catch(IOException e){
            e.printStackTrace();
        }


    }

}
