/*
ClassName: Welcome.java
Author: Jamaine Drakes & Evan Leacock
Purpose: 
Start Date: Mar 12, 2022
Last Edit: Mar 12, 2022
*/

//========================================================================================//
//                                     LIBRARIES                                          //
//========================================================================================//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.ImageIcon;
import java.awt.Image;



public class Welcome  extends JFrame implements ActionListener
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//
    //This will hold the name that the user entered
    static  String username = "Jack";

    
    //Labels
    private JLabel apptitle;
    private JLabel welcomeMessage;
    private JLabel imageLabel;
    private JLabel questionLabel; 

    //Panels
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel buttonPanel;

    //TextField
    private JTextField nameTextField; 

    //Buttons
    private JButton confirmButton;
    private JButton cancelButton;

    //ImageIcon
    private ImageIcon logo;

    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public Welcome()
    {
        //========================================================================================//
        //                                    SETTING UP GUI                                      //
        //========================================================================================//
        this.setLayout(new BorderLayout());
        this.setSize(800, 600);
        this.setTitle("Welcome Screen");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        

        //========================================================================================//
        //                                     INSTANTIATION                                      //
        //========================================================================================//
        //Top Panel
        topPanel = new JPanel();
     

        //CenterPanel
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS) );
      
        
        //Button Panel (Sub Panel for center panel)
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS) );
        
        //Labels
        //These will be dealt with in the display message method 
        apptitle = new JLabel();
        welcomeMessage = new JLabel();
        imageLabel = new JLabel();
        questionLabel = new JLabel();

        //TextFields
        nameTextField = new JTextField();

        //Buttons
        confirmButton = new JButton();
        cancelButton = new JButton();

         //Logo of for ZooKeeper 2.0
         logo = new ImageIcon("../Images/logo.png");
         
         //Change size of logo to display on frame
         Image alteredLogo = logo.getImage(); //get the imageicon as an image  to scale it
         Image newLogo =  alteredLogo.getScaledInstance(180, 180, Image.SCALE_SMOOTH); //transform it
         logo = new ImageIcon(newLogo); //convert back to imageIcon

        
        //========================================================================================//
        //                                  ADDING COMPONENTS                                     //
        //========================================================================================//
        //Method to display content on Frame
        displayMessage();
        
        //Adding components to the topPanel
        topPanel.add(apptitle);
        

        //Adding components to the sub panel, buttonPanel
        buttonPanel.add(confirmButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(70,0) ) );
        buttonPanel.add(cancelButton);

        //Adding components to the centerPanel
        
        centerPanel.add(welcomeMessage);
        centerPanel.add(Box.createRigidArea(new Dimension(0,30) ) );
        centerPanel.add(imageLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0,30) ) );
        centerPanel.add(questionLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0,30) ) );
        centerPanel.add(nameTextField);
        centerPanel.add(Box.createRigidArea(new Dimension(0,40) ) );
        centerPanel.add(buttonPanel);
        

        //Adding components to the main Welcome Frame
        this.add("North",topPanel);
        this.add("Center",centerPanel);


        //========================================================================================//
        //                                ADDING ACTION LISTENERS                                 //
        //========================================================================================//
        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);




        maximiseFrame(this);
        this.setVisible(true);

    }// end Welcome

    //========================================================================================//
    //                                ACTION PERFORMED METHOD                                 //
    //========================================================================================//
    public void actionPerformed(ActionEvent e)
    {
        //cancelButton (User wants to quit application)
        if(e.getSource() == cancelButton)
        {
            this.dispose();
            System.exit(0); 
        } //end cancelButton action performed


        //confirmButton (User has entered a name wishes to start application)
        if(e.getSource() == confirmButton)
        {
            setUsername(nameTextField.getText() );
            ZooManager.zooKeeper.setName(username);
            new MainTester();
            this.dispose();
            
        }// end confirm button
        
    }// actionPerformed


    //========================================================================================//
    //                                    OTHER METHODS                                       //
    //========================================================================================//
    //Method for Styling and Displaying Components on the Frame 
    public void displayMessage()
    {
        //apptitle Label
        apptitle.setText("ZooKeeper 2.0");
        apptitle.setFont(new Font("Courier",Font.ITALIC,120));
       
        //welcomMessage 
        welcomeMessage.setText("Welcome to Your Zoo!!");
        welcomeMessage.setFont(new Font(null,Font.ITALIC,60));
        welcomeMessage.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        //imageLabel
        imageLabel.setIcon(logo);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //questionLabel
        questionLabel.setText("Please enter your name below:");
        questionLabel.setFont(new Font(null,Font.PLAIN,35) );
        questionLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);


        //nameTextField
        nameTextField.setPreferredSize(new Dimension(270, 40));
        nameTextField.setMaximumSize(nameTextField.getPreferredSize() );
        //nameTextField.setText("Enter name Here");
        nameTextField.setFont(new Font("SansSerif",Font.ITALIC,20));
        nameTextField.setHorizontalAlignment(JTextField.CENTER);
        nameTextField.setAlignmentX(JTextArea.CENTER_ALIGNMENT);

        //buttonPanel
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //confirm button
        confirmButton.setText("Confirm Name and Start");
        confirmButton.setFont(new Font("SansSerif",Font.PLAIN,17));
        confirmButton.setFocusable(false);

        //cancel button
        cancelButton.setText("Cancel and Quit");
        cancelButton.setFont(new Font("SansSerif",Font.PLAIN,17));
        cancelButton.setFocusable(false);
       
    } // end displayMessage

    //Accessor for username
    public static String getUsername()
    {
        return username;
    }

    public static void setUsername(String newUsername)
    {
        username = newUsername;
    }


    //This function will maximise the frame
    private static void maximiseFrame(JFrame fr)
    {

        //Get the size of the screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        //Determine the size of the screen
        int w = dimension.width;
        int h = dimension.height;

        //Make the frame the same size as the screen
        fr.setSize(w,h);

        //Ensure the window is in the top-left hand corner
        fr.setLocation(0,0);
    }//end maximiseFrame

    /*
    // This method will center the frame on the screen
    private static void centerFrame(JFrame fr)
    {
        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = fr.getSize().width;
        int h = fr.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        // Move the window
        fr.setLocation(x, y);

    }// end centerFrame
    */

}// end Welcome