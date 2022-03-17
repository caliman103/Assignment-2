/*
ClassName: FoodTotalPanel
Author: Jamaine Drakes
Purpose: 
Start Date: Mar 16, 2022
Last Edit: Mar 16, 2022
*/

//========================================================================================//
//                                     LIBRARIES                                          //
//========================================================================================//
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class FoodTotalPanel extends JPanel
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//

    //==============PANELS==============//
    // Panels for the borderLayout of FoodTotalPanel 
    JPanel westPanel;
    JPanel eastPanel;
    JPanel centerPanel;
    JPanel southPanel;

    //

    //==============LABELS==============//
    JLabel typeLabel;
    JLabel amountLabel;

    // Labels for the food types
    JLabel hayLabel;
    JLabel fruitLabel;
    JLabel grainlabel;
    JLabel fishLabel;
    JLabel meatLabel;


    //=============BUTTONS==============//
    static JButton addButton;
    static JButton printListButton;
    static JButton feedButton;


    //============TEXT FIELDS===========//
    // Text Fields to enter the amount of food
    static JTextField hayTextField;
    static JTextField fruitTextField;
    static JTextField grainTextField;
    static JTextField fishTextField;
    static JTextField meatTextField;


    //=============BORDERS==============//
    // Border for the food section
    TitledBorder foodBorder;
    TitledBorder totalsBorder;


    //==============TABLES==============//
    // Table for the totals
    JTable foodTotalsTable;
    String[] foodTotalsTableHeaders;
    Integer[][] foodTotalsTableContent;

    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public FoodTotalPanel()
    {
        setLayout(new BorderLayout());
        setSize(500, 400);
        setVisible(true);
        

        
        //========================================================================================//
        //                                  ADDING COMPONENTS                                     //
        //========================================================================================//
    
    
        //========================================================================================//
        //                                ADDING ACTION LISTENERS                                 //
        //========================================================================================//
    
    
    }// FoodTotalPanel


    //========================================================================================//
    //                                    OTHER METHODS                                       //
    //========================================================================================//
    
    

}// FoodTotalPanel