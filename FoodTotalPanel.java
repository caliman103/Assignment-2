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
import java.util.ArrayList;


public class FoodTotalPanel extends JPanel
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//

    //==============PANELS==============//
    // Panels for the borderLayout of FoodTotalPanel 
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel centerPanel;
    private JPanel southPanel;

    //

    //==============LABELS==============//
    private JLabel typeLabel;
    private JLabel amountLabel;

    // Labels for the food types
    private JLabel hayLabel;
    private JLabel fruitLabel;
    private JLabel grainlabel;
    private JLabel fishLabel;
    private JLabel meatLabel;


    //=============BUTTONS==============//
    private JButton addButton;
    private JButton printListButton;
    private JButton feedButton;


    //============TEXT FIELDS===========//
    // Text Fields to enter the amount of food
    private JTextField hayTextField;
    private JTextField fruitTextField;
    private JTextField grainTextField;
    private JTextField fishTextField;
    private JTextField meatTextField;


    //=============BORDERS==============//
    // Border for the food section
    private TitledBorder foodBorder;
    private TitledBorder totalsBorder;


    //==============TABLES==============//
    // Table for the totals
    private JTable foodTotalsTable;
    private String[] foodTotalsTableHeaders;
    private Integer[][] foodTotalsTableContent;


    //============ARRAYLISTS============//

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