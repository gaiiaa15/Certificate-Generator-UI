package CertificateGeneratorApp;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;


public class CertificateGenerator extends JFrame {
    public void showCertificateGenerator() {
        try {
            JFrame certFrame = new JFrame();
            certFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //adding the main panel
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());

            //create and add the navigation bar
            JPanel navPanel = createNavigationBar(certFrame);
            mainPanel.add(navPanel, BorderLayout.NORTH);

            JPanel certPanel = new JPanel(new GridBagLayout()) {
                final Image backgroundImage = ImageIO.read(new File("background.png"));

                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage, 0, 0, this);
                }
            };

            //creating the grid for the panel
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;

            //page title
            certFrame.setTitle("certificate generator");
            //setting the title of the panel (actually appears on the screen)
            JLabel pageTitle = new JLabel("Certificate Generator");
            Font font = new Font("Arial Round MT", Font.BOLD, 45);
            //setting the font to the title
            pageTitle.setFont(font);
            pageTitle.setForeground(new Color(108, 149, 224));

            //creating the layout for the title
            GridBagConstraints titleGBC = new GridBagConstraints();
            titleGBC.gridx = 0;
            titleGBC.gridwidth = 2;
            titleGBC.anchor = GridBagConstraints.CENTER;
            certPanel.add(pageTitle, titleGBC);
            titleGBC.gridy++;

            mainPanel.add(certPanel, BorderLayout.CENTER);
            certFrame.add(mainPanel);
            certFrame.pack();
            certFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            certFrame.setLocationRelativeTo(null);
            certFrame.setVisible(true);


        } catch (IOException e) {
            e.printStackTrace();
        }
        ;


    }

    public static JPanel createNavigationBar(JFrame frame) {
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        navPanel.setBackground(new Color(30, 30, 31));
        navPanel.setPreferredSize(new Dimension(30,150));

        JButton homeButton = new JButton("Home");
        JButton contactButton= new JButton("Contact Us");
        JButton aboutButton = new JButton("About");
        JButton profileButton = new JButton("Profile");
        navPanel.add(Box.createHorizontalGlue());

        // creating an image icon and adding the image path
        ImageIcon originalLogoIcon = new ImageIcon("/Users/gaiiaharb/Library/CloudStorage/OneDrive-AngliaRuskinUniversity/Year 1/" +
                "TrackGenesisProject/CertificateGeneratorSwing/src/main/java/CertificateGeneratorApp/logo.png");
        //specifying the desired width and height
        int desiredWidth = 85;
        int desiredHeight = 75;
        //scaling the image
        Image scaledImage = originalLogoIcon.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon logoIcon = new ImageIcon(scaledImage);
        //set the scaled imageIcon to the JLabel
        JLabel logoLab = new JLabel(logoIcon);
        //adding the image to the nav panel so that we can make it visible on the screen
        navPanel.add(logoLab);


        //Add Action Listeners for navigation buttons
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Home clicked");
            }
        });

        contactButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                openContactUsPage();
            }

        });
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               openAboutPage();
            }
        });
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Profile Clicked");
            }
        });

        // add button to the navigation panel
        navPanel.add(homeButton);
        navPanel.add(contactButton);
        navPanel.add(aboutButton);
        navPanel.add(profileButton);
        return navPanel;
    }

public static void openAboutPage(){
        AboutPage aboutPage = new AboutPage();
        aboutPage.showAboutPage();

   }

   public static void openContactUsPage(){
        ContactUsPage contactPage = new ContactUsPage();
        contactPage.showContactUs();
   }
}
