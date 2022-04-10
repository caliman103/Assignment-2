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
import javax.swing.plaf.PanelUI;
import javax.swing.table.AbstractTableModel;

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
    private JLabel grainLabel;
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
    private ArrayList<JButton> buttonList;
    private ArrayList<JTextField> textFieldList;
    private ArrayList<JTable> tableList;

    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public FoodTotalPanel()
    {
        setLayout(new BorderLayout());
        setVisible(true);

        //Initializing components
        westPanel = new JPanel();
        eastPanel = new JPanel(new FlowLayout());
        centerPanel = new JPanel(new FlowLayout());
        southPanel = new JPanel(new FlowLayout());

        typeLabel = new JLabel("Type");
        amountLabel = new JLabel("Amount");

        hayLabel = new JLabel("Hay");
        fruitLabel = new JLabel("Fruit");
        grainLabel = new JLabel("Grain");
        fishLabel = new JLabel("Fish");
        meatLabel = new JLabel("Meat");

        hayTextField = new JTextField("0");
        fruitTextField = new JTextField("0");
        grainTextField = new JTextField("0");
        fishTextField = new JTextField("0");
        meatTextField = new JTextField("0");

        addButton = new JButton("Add->");
        printListButton = new JButton("Print List");
        feedButton = new JButton("Feed");

        foodBorder = BorderFactory.createTitledBorder("Food");
        totalsBorder = BorderFactory.createTitledBorder("Totals");

        this.setBorder(BorderFactory.createLineBorder(Color.gray));

        GroupLayout layout = new GroupLayout(westPanel);
        westPanel.setLayout(layout);
        westPanel.setBorder(foodBorder);

        eastPanel.setBorder(totalsBorder);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        foodTotalsTableHeaders = new String[] {"A","B","C","D"};
        foodTotalsTableContent = new Integer[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};

        foodTotalsTable = new JTable(foodTotalsTableContent, foodTotalsTableHeaders)
        {
            public boolean isCellEditable(int row, int column)
            {  
                return false;  
            }// isCellEditable
        };

        //foodTotalsTable.setValueAt(value, row, column);

        buttonList = new ArrayList<JButton>();
        textFieldList = new ArrayList<JTextField>();
        tableList = new ArrayList<JTable>();
        
        //========================================================================================//
        //                                  ADDING COMPONENTS                                     //
        //========================================================================================//

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(typeLabel)
                    .addComponent(hayLabel)
                    .addComponent(fruitLabel)
                    .addComponent(grainLabel)
                    .addComponent(fishLabel)
                    .addComponent(meatLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(amountLabel)
                    .addComponent(hayTextField)
                    .addComponent(fruitTextField)
                    .addComponent(grainTextField)
                    .addComponent(fishTextField)
                    .addComponent(meatTextField))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(amountLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(hayLabel)
                    .addComponent(hayTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fruitLabel)
                    .addComponent(fruitTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(grainLabel)
                    .addComponent(grainTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fishLabel)
                    .addComponent(fishTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(meatLabel)
                    .addComponent(meatTextField))
        );

        JScrollPane scrollPane = new JScrollPane(foodTotalsTable);
        scrollPane.setSize(scrollPane.getWidth(), 100);
        eastPanel.add(scrollPane);

        centerPanel.add(addButton);

        southPanel.add(printListButton);
        southPanel.add(feedButton);
               
        this.add("West", westPanel);
        this.add("East", eastPanel);
        this.add("Center", centerPanel);
        this.add("South", southPanel);


        buttonList.add(addButton);
        buttonList.add(printListButton);
        buttonList.add(feedButton);

        textFieldList.add(hayTextField);
        textFieldList.add(fruitTextField);
        textFieldList.add(grainTextField);
        textFieldList.add(fishTextField);
        textFieldList.add(meatTextField);

        tableList.add(foodTotalsTable);
    
        //========================================================================================//
        //                                ADDING ACTION LISTENERS                                 //
        //========================================================================================//
    
    
    }// FoodTotalPanel


    //========================================================================================//
    //                                    OTHER METHODS                                       //
    //========================================================================================//

    public ArrayList<JButton> getButtonList()
    {
        return buttonList;
    }// getButtonList

    public ArrayList<JTextField> getTextFieldList()
    {
        return textFieldList;
    }// getTextFieldList

    public ArrayList<JTable> getTableList()
    {
        return tableList;
    } //getJTable
    
    

}// FoodTotalPanel