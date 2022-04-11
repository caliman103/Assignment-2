/*
ClassName: MedicineTotalPanel
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


public class MedicineTotalPanel extends JPanel
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//

    //==============PANELS==============//
    // Panels for the borderLayout of MedicineTotalPanel 
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel centerPanel;
    private JPanel southPanel;

    //

    //==============LABELS==============//
    private JLabel typeLabel;
    private JLabel amountLabel;

    // Labels for the food types
    private JLabel herbicineLabel;
    private JLabel omnicineLabel;
    private JLabel carnicineLabel;


    //=============BUTTONS==============//
    private JButton addButton;
    private JButton printListButton;
    private JButton healButton;


    //============TEXT FIELDS===========//
    // Text Fields to enter the amount of food
    private JTextField herbicineTextField;
    private JTextField omnicineTextField;
    private JTextField carnicineTextField;


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
    public MedicineTotalPanel()
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

        herbicineLabel = new JLabel("Herbicine");
        omnicineLabel = new JLabel("Omnicine");
        carnicineLabel = new JLabel("Carnicine");

        herbicineTextField = new JTextField("0");
        omnicineTextField = new JTextField("0");
        carnicineTextField = new JTextField("0");

        addButton = new JButton("Add->");
        printListButton = new JButton("Print List");
        healButton = new JButton("Heal");

        foodBorder = BorderFactory.createTitledBorder("Medicine");
        totalsBorder = BorderFactory.createTitledBorder("Totals");

        this.setBorder(BorderFactory.createLineBorder(Color.gray));

        GroupLayout layout = new GroupLayout(westPanel);
        westPanel.setLayout(layout);
        westPanel.setBorder(foodBorder);

        eastPanel.setBorder(totalsBorder);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        foodTotalsTableHeaders = new String[] {"A","B","C","D"};
        foodTotalsTableContent = new Integer[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0}};

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
                    .addComponent(herbicineLabel)
                    .addComponent(omnicineLabel)
                    .addComponent(carnicineLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(amountLabel)
                    .addComponent(herbicineTextField)
                    .addComponent(omnicineTextField)
                    .addComponent(carnicineTextField))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(amountLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(herbicineLabel)
                    .addComponent(herbicineTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(omnicineLabel)
                    .addComponent(omnicineTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(carnicineLabel)
                    .addComponent(carnicineTextField))
        );

        JScrollPane scrollPane = new JScrollPane(foodTotalsTable);
        scrollPane.setSize(scrollPane.getWidth(), 100);
        eastPanel.add(scrollPane);

        centerPanel.add(addButton);

        southPanel.add(printListButton);
        southPanel.add(healButton);
               
        this.add("West", westPanel);
        this.add("East", eastPanel);
        this.add("Center", centerPanel);
        this.add("South", southPanel);


        buttonList.add(addButton);
        buttonList.add(printListButton);
        buttonList.add(healButton);

        textFieldList.add(herbicineTextField);
        textFieldList.add(omnicineTextField);
        textFieldList.add(carnicineTextField);

        tableList.add(foodTotalsTable);
    
        //========================================================================================//
        //                                ADDING ACTION LISTENERS                                 //
        //========================================================================================//
    
    
    }// MedicineTotalPanel


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
    
    

}// MedicineTotalPanel