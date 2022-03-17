/*
ClassName: FoodTotalPanel
Author: Jamaine Drakes
Purpose: 
Start Date: Mar 17, 2022
Last Edit: Mar 17, 2022
*/

//========================================================================================//
//                                     LIBRARIES                                          //
//========================================================================================//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


public class FoodTotalPanel  extends JPanel implements ActionListener
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//
    //Layout Managers
    GroupLayout westPanelLayout;
    GroupLayout eastPanelLayout;
    //Panels
    JPanel topPanel;
    JPanel westPanel;
    JPanel centerPanel;
    JPanel eastPanel;
    JPanel botPanel;

    //Labels
    JLabel titleLabel;
    
    JLabel typeLabel;
    JLabel amountLabel;
    
    JLabel hayLabel;
    JLabel fruitLabel;
    JLabel grainLabel;
    JLabel fishLabel;
    JLabel meatLabel;
    
    JLabel zoneALabel;
    JLabel zoneBLabel;
    JLabel zoneCLabel;
    JLabel zoneDLabel;
    static JLabel zoneAHay;
    static JLabel zoneBHay;
    static JLabel zoneCHay;
    static JLabel zoneDHay;
    static JLabel zoneAFruit;
    static JLabel zoneBFruit;
    static JLabel zoneCFruit;
    static JLabel zoneDFruit;
    static JLabel zoneAGrain;
    static JLabel zoneBGrain;
    static JLabel zoneCGrain;
    static JLabel zoneDGrain;
    static JLabel zoneAFish;
    static JLabel zoneBFish;
    static JLabel zoneCFish;
    static JLabel zoneDFish;
    static JLabel zoneAMeat;
    static JLabel zoneBMeat;
    static JLabel zoneCMeat;
    static JLabel zoneDMeat;

    //Text Fields
    static JTextField hayTextField;
    static JTextField fruitTextField;
    static JTextField grainTextField;
    static JTextField fishTextField;
    static JTextField meatTextField;

    //Buttons
    static JButton addFoodButton;
    static JButton feeddButton;
    static JButton printListButton;

    //ArrayList
    ArrayList<JTextField> textFieldsToStyle;
    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public FoodTotalPanel()
    {
          setLayout(new BorderLayout());
          this.setPreferredSize(new Dimension(500,450));
        
        //========================================================================================//
        //                                     INSTIATION                                        //
        //========================================================================================//
        //Layout Managers
        westPanelLayout = new GroupLayout(westPanel);
        eastPanelLayout = new GroupLayout(eastPanel);
        //Panels
        topPanel = new JPanel();
        westPanel = new JPanel();
        centerPanel = new JPanel();
        eastPanel = new JPanel();
        botPanel = new JPanel();

        //Labels
        titleLabel = new JLabel("Food Totals");

        typeLabel = new JLabel("Type");
        amountLabel = new JLabel("Amount");

        hayLabel = new JLabel("Hay");
        fruitLabel = new JLabel("Fruit");
        grainLabel = new JLabel("Grain");
        fishLabel = new JLabel("Fish");
        meatLabel = new JLabel("Meat");

        zoneALabel = new JLabel("A");
        zoneBLabel = new JLabel("B");
        zoneCLabel = new JLabel("C");
        zoneDLabel = new JLabel("D");
        zoneAHay = new JLabel("0");
        zoneBHay = new JLabel("0");
        zoneCHay = new JLabel("0");
        zoneDHay = new JLabel("0");
        zoneAFruit = new JLabel("0");
        zoneBFruit = new JLabel("0");
        zoneCFruit = new JLabel("0");
        zoneDFruit = new JLabel("0");
        zoneAGrain = new JLabel("0");
        zoneBGrain = new JLabel("0");
        zoneCGrain = new JLabel("0");
        zoneDGrain = new JLabel("0");
        zoneAFish = new JLabel("0");
        zoneBFish = new JLabel("0");
        zoneCFish = new JLabel("0");
        zoneDFish = new JLabel("0");
        zoneAMeat = new JLabel("0");
        zoneBMeat = new JLabel("0");
        zoneCMeat = new JLabel("0");
        zoneDMeat = new JLabel("0");

        //Text Fields
        hayTextField = new JTextField();
        fruitTextField = new JTextField();
        grainTextField = new JTextField();
        fishTextField = new JTextField();
        meatTextField = new JTextField();
        
        //Buttons
        addFoodButton = new JButton("Add");
        feeddButton = new JButton("Feed");
        printListButton = new JButton("Print List");

        textFieldsToStyle = new ArrayList<JTextField>();

        textFieldsToStyle.add(hayTextField);
        textFieldsToStyle.add(fruitTextField);
        textFieldsToStyle.add(grainTextField);
        textFieldsToStyle.add(fishTextField);
        textFieldsToStyle.add(meatTextField);

        //Method to style components before adding them
        styleComponents();
        //========================================================================================//
        //                                  ADDING COMPONENTS                                     //
        //========================================================================================//
        //Top Panel
        topPanel.add(titleLabel);

        //WestPanel
        westPanel.add(typeLabel);
        westPanel.add(amountLabel);
        westPanel.add(hayLabel);
        westPanel.add(hayTextField);
        westPanel.add(fruitLabel);
        westPanel.add(fruitTextField);
        westPanel.add(grainLabel);
        westPanel.add(grainTextField);
        westPanel.add(fishLabel);
        westPanel.add(fishTextField);
        westPanel.add(meatLabel);
        westPanel.add(meatTextField);

        //Center Panel
        centerPanel.add(addFoodButton);

        //EastPanel
        eastPanel.add(zoneALabel);
        eastPanel.add(zoneBLabel);
        eastPanel.add(zoneCLabel);
        eastPanel.add(zoneDLabel);
        eastPanel.add(zoneAHay);
        eastPanel.add(zoneBHay);
        eastPanel.add(zoneCHay);
        eastPanel.add(zoneDHay);
        eastPanel.add(zoneAFruit);
        eastPanel.add(zoneBFruit);
        eastPanel.add(zoneCFruit);
        eastPanel.add(zoneDFruit);
        eastPanel.add(zoneAGrain);
        eastPanel.add(zoneBGrain);
        eastPanel.add(zoneCGrain);
        eastPanel.add(zoneDGrain);
        eastPanel.add(zoneAFish);
        eastPanel.add(zoneBFish);
        eastPanel.add(zoneCFish);
        eastPanel.add(zoneDFish);
        eastPanel.add(zoneAMeat);
        eastPanel.add(zoneBMeat);
        eastPanel.add(zoneCMeat);
        eastPanel.add(zoneDMeat);

        //Bot Panel
        botPanel.add(printListButton);
        botPanel.add(feeddButton);

        this.add("North",topPanel);
        this.add("West",westPanel);
        this.add("Center",centerPanel);
        this.add("East",eastPanel);
        this.add("South",botPanel);

        //========================================================================================//
        //                                ADDING ACTION LISTENERS                                 //
        //========================================================================================//
        

        setVisible(true);

    }// end FoodTotalPanel

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
    private void styleComponents()
    {
        //Top Panel
        topPanel.setLayout(new FlowLayout() );

        //West Panel
        westPanel.setLayout(westPanelLayout); 
        //westPanel.setPreferredSize(new Dimension(200,300));
        for(int i = 0; i < textFieldsToStyle.size(); i++)
        {
            textFieldsToStyle.get(i).setPreferredSize( new Dimension(100,10));
           
        }//end for
        

        //Center Panel
        centerPanel.setLayout(new FlowLayout() );


        //East Panel
        eastPanel.setLayout(eastPanelLayout);
        eastPanelLayout.setAutoCreateGaps(true);
        eastPanelLayout.setAutoCreateContainerGaps(true);

        eastPanelLayout.setHorizontalGroup(
            eastPanelLayout.createSequentialGroup()
                .addGroup(eastPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)  //Column 1
                    .addComponent(zoneALabel)
                    .addComponent(zoneAHay)
                    .addComponent(zoneAFruit)
                    .addComponent(zoneAGrain)
                    .addComponent(zoneAFish) 
                    .addComponent(zoneAMeat) )

                .addGroup(eastPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING) //Column 2
                    .addComponent(zoneBLabel)
                    .addComponent(zoneBHay)
                    .addComponent(zoneBFruit)
                    .addComponent(zoneBGrain)
                    .addComponent(zoneBFish) 
                    .addComponent(zoneBMeat) )

                .addGroup(eastPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING) //Column 3
                    .addComponent(zoneCLabel)
                    .addComponent(zoneCHay)
                    .addComponent(zoneCFruit)
                    .addComponent(zoneCGrain)
                    .addComponent(zoneCFish) 
                    .addComponent(zoneCMeat) )

                .addGroup(eastPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING) //Column 4
                    .addComponent(zoneDLabel)
                    .addComponent(zoneDHay)
                    .addComponent(zoneDFruit)
                    .addComponent(zoneDGrain)
                    .addComponent(zoneDFish) 
                    .addComponent(zoneDMeat) )
        ); //end horizontalgroup

        eastPanelLayout.setVerticalGroup(
            eastPanelLayout.createSequentialGroup()
                .addGroup(eastPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE) //Row  1
                        .addComponent(zoneALabel)
                        .addComponent(zoneBLabel)
                        .addComponent(zoneCLabel)
                        .addComponent(zoneDLabel) )

                .addGroup(eastPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE) //Row 2
                    .addComponent(zoneAHay)
                    .addComponent(zoneBHay)
                    .addComponent(zoneCHay)
                    .addComponent(zoneDHay) )

                .addGroup(eastPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE) //Row 3
                    .addComponent(zoneAFruit)
                    .addComponent(zoneBFruit)
                    .addComponent(zoneCFruit)
                    .addComponent(zoneDFruit) )
        
                .addGroup(eastPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE) //Row 4
                    .addComponent(zoneAGrain)
                    .addComponent(zoneBGrain)
                    .addComponent(zoneCGrain)
                    .addComponent(zoneDGrain) )

                .addGroup(eastPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE) //Row 5
                    .addComponent(zoneAFish)
                    .addComponent(zoneBFish)
                    .addComponent(zoneCFish)
                    .addComponent(zoneDFish) )

                    .addGroup(eastPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE) //Row 6
                    .addComponent(zoneAMeat)
                    .addComponent(zoneBMeat)
                    .addComponent(zoneCMeat)
                    .addComponent(zoneDMeat) )
        );  //end vertical group
        


        botPanel.setLayout(new FlowLayout());

    }//end Style components


    

}// end FoodTotalPanel