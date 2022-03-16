/*
ClassName: AnimalPanel.java
Author: Jamaine Drakes
Purpose: 
Start Date: Mar 13, 2022
Last Edit: Mar 13, 2022
*/

//========================================================================================//
//                                     LIBRARIES                                          //
//========================================================================================//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.util.ArrayList;



public class AnimalPanel  extends JPanel //implements ActionListener
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//
    //This int will be used to display the correct animal with its cage ID (probably)
    //int index = 0;

    //Panels
    JPanel top;
    JPanel center;
    JPanel bot;
    
    //Labels
    JLabel titleLabel;

    JLabel cageIDLabel;
    JLabel nameLabel;
    JLabel speciesLabel;
    JLabel categoryLabel;
    JLabel hungerLabel;
    JLabel healthLabel;

    static JLabel animalCageID;
    static JLabel animalName;
    static JLabel animalSpecies;
    static JLabel animalCategory;
    static JLabel animalHunger;
    static JLabel animalHealth;
   

    JLabel zoneImageJLabel;


    
    
    //Button
   static JButton nextButton;


    //ImagesIcon
    ImageIcon africanSavanna;
    ImageIcon amazonianJungle;
    ImageIcon eurasianWilds;
    ImageIcon frozenTundra;

    //Arraylists
     //This Arraylist of Images (Could be used to randomly choose an image for the zone)
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    
    ArrayList<JLabel> labelsForStyling = new ArrayList<JLabel>();

    

    


    

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
        animalHunger = new JLabel(String.valueOf(ZooManager.getZoo().getCages().get(0).getHungerStatus() ) );
        animalHealth = new JLabel(String.valueOf(ZooManager.getZoo().getCages().get(0).getHealthStatus() ) );

        zoneImageJLabel = new JLabel();

        //Button
        nextButton = new JButton("Next");
        
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
        bot.add(Box.createRigidArea(new Dimension(0,40) ) );
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
    public void styleComponents()
    {
        titleLabel.setFont(new Font("Sans Serif",Font.BOLD,20));

        for(int i = 0; i < labelsForStyling.size(); i++)
        {
            labelsForStyling.get(i).setFont(new Font("Sans Serif",Font.BOLD,16) );
        }

        nextButton.setFocusable(false);
    }//end styleComponents 

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