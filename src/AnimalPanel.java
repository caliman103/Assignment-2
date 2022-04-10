/*
ClassName: AnimalPanel.java
Author: Jamaine Drakes
Purpose: 
Start Date: Mar 13, 2022
Last Edit: Mar 17, 2022
*/

//========================================================================================//
//                                     LIBRARIES                                          //
//========================================================================================//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;



public class AnimalPanel  extends JPanel //implements ActionListener
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//
    //This int will be used to display the correct animal with its cage ID (probably)
    //int index = 0;

    //Panels
    private JPanel  top;
    private JPanel center;
    private JPanel bot;
    
    //Labels
    private JLabel titleLabel;

    private JLabel cageIDLabel;
    private JLabel nameLabel;
    private JLabel speciesLabel;
    private JLabel categoryLabel;
    private JLabel hungerLabel;
    private JLabel healthLabel;

    private JLabel animalCageID;
    private JLabel animalName;
    private JLabel animalSpecies;
    private JLabel animalCategory;
    private JLabel animalHunger;
    private JLabel animalHealth;
   
    private JLabel zoneImageJLabel;


    String test;
    
    //Button
    JButton nextButton;


    //ImagesIcon
    private ImageIcon africanSavanna;
    private ImageIcon amazonianJungle;
    private  ImageIcon eurasianWilds;
    private ImageIcon frozenTundra;

    //Arraylists
    //This Arraylist of Images (Could be used to randomly choose an image for the zone)
    private ArrayList<ImageIcon> zoneImages = new ArrayList<ImageIcon>();
    
    private ArrayList<JLabel> labelsForStyling = new ArrayList<JLabel>();


    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public AnimalPanel()
    {
        
        this.setLayout(new BorderLayout() );
        this.setPreferredSize(new Dimension(250,450));

        //========================================================================================//
        //                                     INSTANTIATION                                      //
        //========================================================================================//
        //Top Panel
        top = new JPanel();
        top.setLayout(new FlowLayout() );

        //Center Panel
        center = new JPanel();
        //center.setPreferredSize(new Dimension(150,400));
        center.setLayout(new GridLayout(6,2) ); //PLace items in a grid with 6 rows and 2 columns


        //Bot Panel
        bot = new JPanel();
        bot.setLayout(new BoxLayout(bot, BoxLayout.LINE_AXIS) );

        //Labels
        titleLabel = new JLabel("ANIMAL INFORMATION");
        
        cageIDLabel = new JLabel("Cage ID:");
        nameLabel = new JLabel("Name:");
        speciesLabel = new JLabel("Species");
        categoryLabel= new JLabel("Category:");
        hungerLabel = new JLabel("Hunger:");
        healthLabel= new JLabel("Health:");
        
        animalCageID = new JLabel(ZooManager.getZoo().getCages().get(0).getCageID() );
        animalName = new JLabel(ZooManager.getZoo().getCages().get(0).getName() );
        animalSpecies = new JLabel(ZooManager.getZoo().getCages().get(0).getSpecies() );
        animalCategory = new JLabel(ZooManager.getZoo().getCages().get(0).getCategory() );
        animalHunger = new JLabel(String.valueOf(ZooManager.getZoo().getCages().get(0).getHungerStatus() ) + "/5"); 
        if(ZooManager.getZoo().getCages().get(0).getHungerStatus() <= 2)
        {
            animalHunger.setForeground(Color.RED);
        }//endif
        else
        {
            animalHunger.setForeground(Color.BLACK);
        }
        animalHealth = new JLabel(String.valueOf(ZooManager.getZoo().getCages().get(0).getHealthStatus() ) + "/10" );
        if(ZooManager.getZoo().getCages().get(0).getHealthStatus() <= 3)
        {
            animalHunger.setForeground(Color.RED);
        }//endif
        else
        {
            animalHealth.setForeground(Color.BLACK);
        }

        zoneImageJLabel = new JLabel();

        //Button
        nextButton = new JButton("Next");

        //ImageIcons
        africanSavanna  = new ImageIcon("../Images/zoneA.png");
        amazonianJungle = new ImageIcon("../Images/zoneB.png");
        eurasianWilds = new ImageIcon("../Images/zoneC.png");
        frozenTundra = new ImageIcon("../Images/zoneD.png");
        
        //Adding labels  which will have to same styling (check styleComponents method)
        labelsForStyling.add(cageIDLabel);
        labelsForStyling.add(nameLabel);
        labelsForStyling.add(speciesLabel);
        labelsForStyling.add(categoryLabel);
        labelsForStyling.add(hungerLabel);
        labelsForStyling.add(healthLabel);
        labelsForStyling.add(animalCageID);
        labelsForStyling.add(animalName);
        labelsForStyling.add(animalSpecies);
        labelsForStyling.add(animalCategory);
        labelsForStyling.add(animalHunger);
        labelsForStyling.add(animalHealth);
        
        //Adding image icons to zoneImages array list
        zoneImages.add(africanSavanna);
        zoneImages.add(amazonianJungle);
        zoneImages.add(eurasianWilds);
        zoneImages.add(frozenTundra);
        
        //method to style the components before adding them to the panel
        styleComponents();
        //========================================================================================//
        //                                  ADDING COMPONENTS                                     //
        //========================================================================================//
        //Top Panel
        top.add(titleLabel);

        //Center Panel
        center.add(cageIDLabel);
        center.add(animalCageID);

        center.add(nameLabel);
        center.add(animalName);

        center.add(speciesLabel);
        center.add(animalSpecies);

        center.add(categoryLabel);
        center.add(animalCategory);

        center.add(hungerLabel);
        center.add(animalHunger);

        center.add(healthLabel);
        center.add(animalHealth);
        
       
        //Bottom Panel
        bot.add(Box.createRigidArea(new Dimension(10,10) ) );
        bot.add(zoneImageJLabel );
        bot.add(Box.createRigidArea(new Dimension(90,50) ) );
        bot.add(nextButton);

        this.add("North",top);
        this.add("Center",center);
        this.add("South",bot);


        //========================================================================================//
        //                                ADDING ACTION LISTENERS                                 //
        //========================================================================================//
       



       
        //this.setVisible(true);
    }// end AnimalPanel

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
    public JLabel getZoneIMageLabel()
    {
        return zoneImageJLabel;
    }

    public JButton getNextButton()
    {
        return nextButton;
    }

    public ArrayList<JLabel> getLabelList()
    {
        return labelsForStyling;
    }

    private void styleComponents()
    {
        titleLabel.setFont(new Font("Sans Serif",Font.BOLD,20));

        for(int i = 0; i < labelsForStyling.size(); i++)
        {
            labelsForStyling.get(i).setFont(new Font("Sans Serif",Font.BOLD,16) );
        }//end for

        nextButton.setFocusable(false);

        for(int i = 0; i < zoneImages.size(); i++)
        {
            ImageIcon tempImage = new ImageIcon();
            tempImage = zoneImages.get(i);
            //Change size of logo to display on frame
            Image alteredLogo = tempImage.getImage(); //get the imageicon as an image  to scale it
            Image newLogo =  alteredLogo.getScaledInstance(60, 60, Image.SCALE_SMOOTH); //transform it
            tempImage = new ImageIcon(newLogo); //convert back to imageIcon
            zoneImages.set(i, tempImage);
        }//end for

        char letter = ZooManager.getZoo().getCages().get(0).getCageID().charAt(0);
        zoneImageJLabel.setIcon(selectZoneImage(letter) );
        
    }//end styleComponents 


    public ImageIcon selectZoneImage(char zoneLetter)
    {
        ImageIcon selectedImage = new ImageIcon();
        switch (zoneLetter )
        {
            case 'A':
                selectedImage = zoneImages.get(0);
                break;

           case 'B':
                selectedImage = zoneImages.get(1);
                break;

            case 'C':
                selectedImage =  zoneImages.get(2);
                break;    

            case 'D':
                selectedImage = zoneImages.get(3);
                break;

        }//end switch
        return selectedImage;
    }

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

}// end AnimalPanel