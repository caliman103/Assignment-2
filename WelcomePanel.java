/*
ClassName: WelcomePanel
Author: Jamaine Drakes
Purpose: 
Start Date: Mar 15, 2022
Last Edit: Mar 15, 2022
*/

//========================================================================================//
//                                     LIBRARIES                                          //
//========================================================================================//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class WelcomePanel  extends JPanel //implements ActionListener
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//
    //Labels
    JLabel titleLabel;
    JLabel messageLabel;
    JLabel imageLabel;

    //Imageicon
    ImageIcon logo;

    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public WelcomePanel()
    {
         
       //this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS) );
       this.setPreferredSize(new Dimension(500,450));
       
        //========================================================================================//
        //                                    INSTATIATION                                        //
        //========================================================================================//
        titleLabel = new JLabel("ZOOKEEPER 2.0");
        titleLabel.setFont(new Font("Courier",Font.BOLD,22));

        messageLabel = new JLabel("Wecome " + ZooManager.getZooKeeper().getName() + "!");
        messageLabel.setFont(new Font("Sans Serif",Font.ITALIC,18));

        imageLabel = new JLabel();

        logo = new ImageIcon("../Images/logo.png");
        Image alteredLogo = logo.getImage(); //get the imageicon as an image  to scale it
        Image newLogo =  alteredLogo.getScaledInstance(60, 60, Image.SCALE_SMOOTH); //transform it
        logo = new ImageIcon(newLogo); //convertit back to imageIcon
        
        imageLabel.setIcon(logo);
        //========================================================================================//
        //                                  ADDING COMPONENTS                                     //
        //========================================================================================//
        
        
        titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0,20) ) );
        this.add(titleLabel);
        this.add(Box.createRigidArea(new Dimension(0,30) ) );

        messageLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        this.add(messageLabel);
        this.add(Box.createRigidArea(new Dimension(80,30) ) );

        imageLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        this.add(imageLabel);
        this.add(Box.createRigidArea(new Dimension(0,30) ) );

        //========================================================================================//
        //                                ADDING ACTION LISTENERS                                 //
        //========================================================================================//



    }// end WelcomePanel

    //========================================================================================//
    //                                ACTION PERFORMED METHOD                                 //
    //========================================================================================//
    public void actionPerformed(ActionEvent e)
    {
        // Event Handlers
        
    }// actionPerformed


    //========================================================================================//
    //                                    OTHER METHODS                                       //
    //========================================================================================//



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

}// end WelcomePanel