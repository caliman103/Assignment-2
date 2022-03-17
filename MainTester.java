/*
ClassName: Main.java
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


public class MainTester extends JFrame implements ActionListener
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//
    //LayoutManager
    
    
    //Panels
    JPanel westPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel eastPanel = new JPanel();
    

    AnimalPanel animalPanel;
    FoodTotalPanel foodTotals = new FoodTotalPanel();
    JPanel feedingReportsFiller = new JPanel();
    WelcomePanel welcomePanel = new WelcomePanel();
    JPanel medicineTotalsFiller = new JPanel();
    JPanel healingReportsFiller = new JPanel();

    

    int counter;

    

    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public MainTester()
    {
        animalPanel = new AnimalPanel();
        
        counter = 0;
        
       
        //setSize(150,400 );
        this.setTitle("Animal Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
       
        foodTotals.setBackground(Color.BLACK);
        feedingReportsFiller.setBackground(Color.BLUE);
        medicineTotalsFiller.setBackground(Color.CYAN);
        healingReportsFiller.setBackground(Color.GREEN);
        
        westPanel.setPreferredSize(new Dimension(320,100) );
        welcomePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE,6));

        animalPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE,6));

        eastPanel.setPreferredSize(new Dimension(300,100));
        
        
        //========================================================================================//
        //                                  ADDING COMPONENTS                                     //
        //========================================================================================//
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS) );
        centerPanel.add(foodTotals);
        centerPanel.add(medicineTotalsFiller);
        
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.PAGE_AXIS) );
        westPanel.add(animalPanel);
        westPanel.add(welcomePanel);

        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.PAGE_AXIS) );
        eastPanel.add(feedingReportsFiller);
        eastPanel.add(healingReportsFiller);
        
        this.add("West",westPanel);
        this.add("Center",centerPanel);
        this.add("East",eastPanel);
       




        //========================================================================================//
        //                                ADDING ACTION LISTENERS                                 //
        //========================================================================================//
        AnimalPanel.nextButton.addActionListener(this);

        
        maximiseFrame(this);
        
        
        //centerFrame(this);
        setVisible(true);
        

    }// end Main constructor

    //========================================================================================//
    //                                ACTION PERFORMED METHOD                                 //
    //========================================================================================//
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == AnimalPanel.nextButton)
        {
            if(counter < (ZooManager.getZoo().getCages().size() - 1) )
            {
                counter++;
                
                AnimalPanel.animalCageID.setText(ZooManager.getZoo().getCages().get(counter).getCageID() );
                AnimalPanel.animalName.setText(ZooManager.getZoo().getCages().get(counter).getName() );
                AnimalPanel.animalSpecies.setText(ZooManager.getZoo().getCages().get(counter).getSpecies() );
                AnimalPanel.animalCategory.setText(ZooManager.getZoo().getCages().get(counter).getCategory() );
                AnimalPanel.animalHunger.setText(String.valueOf(ZooManager.getZoo().getCages().get(counter).getHungerStatus() ) );
                AnimalPanel.animalHealth.setText(String.valueOf(ZooManager.getZoo().getCages().get(counter).getHealthStatus() ) );
            }
        }
        
    }// actionPerformed


    //========================================================================================//
    //                                    OTHER METHODS                                       //
    //========================================================================================//


    
     //This function will maximise the frame
    private static void maximiseFrame(JFrame fr)
    {

        //Get the size of the screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        //Determine the size of the screen
        int w = dimension.width;
        int h = dimension.height-40;

        //Make the frame the same size as the screen
        fr.setSize(w,h);

        //Ensure the window is in the top-left hand corner
        fr.setLocation(0,0);
    }//end maximiseFrame
     
     
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
     
     

}// end Main