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
import javax.swing.plaf.InsetsUIResource;


public class Main extends JFrame implements ActionListener
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//
    AnimalPanel animalPanel;

    //JButton testButton = new JButton("button");
    JButton testbButton1 = new JButton("food totals");
    JButton testbButton2 = new JButton("feeding report");
    JButton testbButton3 = new JButton("medicine totals");
    JButton testbButton4 = new JButton("healing reports");


    //Layout Manager
    GridBagConstraints animalPanelConstraints ;
    GridBagConstraints foodTotalsConstraints; 
    GridBagConstraints feedingReportsConstraints; 
    GridBagConstraints medicineTotalsConstraints; 
    GridBagConstraints healingReportsConstraints;

    int counter;

    

    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public Main()
    {
        animalPanel = new AnimalPanel();
        
        counter = 0;
        
        
        setLayout(new GridBagLayout() );
        animalPanelConstraints = new GridBagConstraints();
        foodTotalsConstraints = new GridBagConstraints();
        feedingReportsConstraints = new GridBagConstraints();
        medicineTotalsConstraints = new GridBagConstraints();
        healingReportsConstraints = new GridBagConstraints();
        

        //setSize(150,400 );
        setTitle("Animal Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Animal panel section of Frame
        animalPanelConstraints.fill = GridBagConstraints.HORIZONTAL;
        animalPanelConstraints.gridx = 0;
        animalPanelConstraints.gridy = 0;
        animalPanelConstraints.weightx= 0.1;
        animalPanelConstraints.weighty = 1;
        animalPanelConstraints.insets = new InsetsUIResource(0, 10, 0,0);
        animalPanelConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(animalPanel,animalPanelConstraints);

        //food totals panel section of Frame
        foodTotalsConstraints.fill = GridBagConstraints.HORIZONTAL;
        foodTotalsConstraints.gridx = 1;
        foodTotalsConstraints.gridy = 0;
        foodTotalsConstraints.weightx= 0.5;
        foodTotalsConstraints.gridwidth = 2;
        foodTotalsConstraints.anchor = GridBagConstraints.PAGE_START;
        this.add(testbButton1,foodTotalsConstraints);

        //feeding reports panel section of Frame
        feedingReportsConstraints.fill = GridBagConstraints.HORIZONTAL;
        feedingReportsConstraints.gridx = 3;
        feedingReportsConstraints.gridy = 0;
        feedingReportsConstraints.weightx= 0.1;
        feedingReportsConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        this.add(testbButton2,feedingReportsConstraints);

        //medicine totals panel section of Frame
        medicineTotalsConstraints.fill = GridBagConstraints.HORIZONTAL;
        medicineTotalsConstraints.gridx = 1;
        medicineTotalsConstraints.gridy = 1;
        medicineTotalsConstraints.weightx= 0.5;
        medicineTotalsConstraints.gridwidth = 2;
        medicineTotalsConstraints.anchor = GridBagConstraints.PAGE_END;
        this.add(testbButton3,medicineTotalsConstraints);


        //healing reports panel section of Frame
        healingReportsConstraints.fill = GridBagConstraints.HORIZONTAL;
        healingReportsConstraints.gridx = 3;
        healingReportsConstraints.gridy = 1;
        healingReportsConstraints.weightx= 0.1;
        healingReportsConstraints.anchor = GridBagConstraints.LAST_LINE_END;
        this.add(testbButton4,healingReportsConstraints);
       
        
        
        
        
        
        //========================================================================================//
        //                                  ADDING COMPONENTS                                     //
        //========================================================================================//



        //========================================================================================//
        //                                ADDING ACTION LISTENERS                                 //
        //========================================================================================//
        AnimalPanel.nextButton.addActionListener(this);

        this.pack();
        //maximiseFrame(this);
        
        
        centerFrame(this);
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