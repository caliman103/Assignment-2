/*
ClassName: FeedingReportPanel.java
Author: Jamaine Drakes & Evan Leacock
Purpose: 
Start Date: Apr 11, 2022
Last Edit: Apr 11, 2022
*/

//========================================================================================//
//                                     LIBRARIES                                          //
//========================================================================================//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FeedingReportPanel extends JPanel 
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//
    private JLabel titleLabel;
    private JTextArea textArea;

    private JScrollPane scrollPane;

    private JButton printReportButton;

    //Object for animal Feeder
    AnimalFeeder animalFeeder;

    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public FeedingReportPanel()
    {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS) );

        animalFeeder = new AnimalFeeder(ZooManager.getZoo().getCages() );
        titleLabel = new JLabel("Feeding Report");
        textArea = new JTextArea();

        

        /*
        textArea.setText("Date\n");
        textArea.append("Animals Fed: " + animalFeeder.getFeedingList().size() + "\n");
        textArea.append("OK: " + (animalFeeder.getFeedingList().size() - animalFeeder.getDeadAnimals().size()) + "\n");
        textArea.append("Deaths: " + animalFeeder.getDeadAnimals().size() + "\n");
        textArea.append("Overfed: \n");

        for (int i = 0; i < animalFeeder.getDeadAnimals().size(); i++) 
        {
            textArea.append(animalFeeder.getCages().get(animalFeeder.getDeadAnimals().get(i)).getCageID() + " - " + animalFeeder.getCages().get(animalFeeder.getDeadAnimals().get(i)).getName() + ", " + animalFeeder.getCages().get(animalFeeder.getDeadAnimals().get(i)).getSpecies() + "\n");
        }
        */
        printReportButton = new JButton();
        
        
        
        
        //========================================================================================//
        //                                  ADDING COMPONENTS                                     //
        //========================================================================================//
        scrollPane = new JScrollPane(textArea);

        this.add(titleLabel);
        this.add(Box.createRigidArea(new Dimension(0,20) ) );  
        this.add(scrollPane);
        this.add(Box.createRigidArea(new Dimension(0,20) ) ); 
        this.add(printReportButton);
        this.add(Box.createRigidArea(new Dimension(0,20) ) ); 


        //========================================================================================//
        //                                ADDING ACTION LISTENERS                                 //
        //========================================================================================//



    }// end FeedingReportPanel

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
    public void appendReport()
    {
        textArea.setText("Date\n");
        textArea.append("Animals Fed: " + animalFeeder.getFeedingList().size() + "\n");
        textArea.append("OK: " + (animalFeeder.getFeedingList().size() - animalFeeder.getDeadAnimals().size()) + "\n");
        textArea.append("Deaths: " + animalFeeder.getDeadAnimals().size() + "\n");
        textArea.append("Overfed: \n");

        for (int i = 0; i < animalFeeder.getDeadAnimals().size(); i++) 
        {
            textArea.append(animalFeeder.getCages().get(animalFeeder.getDeadAnimals().get(i)).getCageID() + " - " + animalFeeder.getCages().get(animalFeeder.getDeadAnimals().get(i)).getName() + ", " + animalFeeder.getCages().get(animalFeeder.getDeadAnimals().get(i)).getSpecies() + "\n");
        }

    }


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

}// end FeedingReportPanel