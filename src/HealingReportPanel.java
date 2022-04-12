/*
ClassName: HealingReportPanel.java
Author: Jamaine Drakes
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


public class HealingReportPanel extends JPanel 
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//
    private JLabel titleLabel;
    private JTextArea textArea;

    private JScrollPane scrollPane;

    private JButton printReportButton;

    private JPanel top = new JPanel();
    private JPanel bot = new JPanel();


    //Object for animal Feeder
    AnimalHealer animalHealer;

    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public HealingReportPanel(AnimalHealer healer)
    {
        this.setLayout(new BorderLayout() );

        animalHealer = healer;
        titleLabel = new JLabel("Healing Report");
        textArea = new JTextArea();

        printReportButton = new JButton("Print Healing Report");

        //========================================================================================//
        //                                  ADDING COMPONENTS                                     //
        //========================================================================================//

        scrollPane = new JScrollPane(textArea);

        top.add(titleLabel);
        bot.add(printReportButton);
        

        this.add("North",top);
          
        this.add("Center",scrollPane);
         
        this.add("South",bot);



        //========================================================================================//
        //                                ADDING ACTION LISTENERS                                 //
        //========================================================================================//



    }// end HealingReportPanel

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
        textArea.append("Animals Fed: " + animalHealer.getHealingList().size() + "\n");
        textArea.append("OK: " + (animalHealer.getHealingList().size() - animalHealer.getDeadAnimals().size()) + "\n");
        textArea.append("Deaths: " + animalHealer.getDeadAnimals().size() + "\n");
        textArea.append("Overfed: \n");

        for (int i = 0; i < animalHealer.getDeadAnimals().size(); i++) 
        {
            textArea.append(animalHealer.getCages().get(animalHealer.getDeadAnimals().get(i)).getCageID() + " - " + animalHealer.getCages().get(animalHealer.getDeadAnimals().get(i)).getName() + ", " + animalHealer.getCages().get(animalHealer.getDeadAnimals().get(i)).getSpecies() + "\n");
        }

    }//end appendReport

    public JButton getHealReportButton()
    {
        return printReportButton;
    }//end getHealReportButton

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

}// end HealingReportPanel