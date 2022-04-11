/*
ClassName: ZooManager
Author: Jamaine Drakes & Evan Leacock
Purpose: To test smth
Start Date: Mar 12, 2022
Last Edit: Mar 16, 2022
*/

//========================================================================================//
//                                     LIBRARIES                                          //
//========================================================================================//
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ZooManager extends JFrame implements ActionListener, FocusListener
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//   
    //Panels
    JPanel westPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel eastPanel = new JPanel();
    

    AnimalPanel animalPanel;
    FoodTotalPanel foodTotals = new FoodTotalPanel();
    FeedingReportPanel reportPanel = new FeedingReportPanel();
    WelcomePanel welcomePanel = new WelcomePanel();
    MedicineTotalPanel medicineTotals = new MedicineTotalPanel();
    JPanel healingReportsFiller = new JPanel();

    
    //C0mponents from FoodTotals
    ArrayList<JButton> foodTotalsButtons = foodTotals.getButtonList();
    ArrayList<JTable> foodTotalTable = foodTotals.getTableList();
    ArrayList<JTextField> foodTotalsTextFields = foodTotals.getTextFieldList();

    //Components from medicine Totals
    ArrayList<JButton> medicineTotalsButtons = medicineTotals.getButtonList();
    ArrayList<JTable> medicineTotalTable = medicineTotals.getTableList();
    ArrayList<JTextField> medicineTotalsTextFields = medicineTotals.getTextFieldList();

    //=================Images=====================//
    ImageIcon zooLogo = new ImageIcon("../Images/Logo.png");


    private int index;
    private int editedFoodTextField;
    private int editedMedTextField; 
    private boolean isfed;
    private boolean isHealed;
    


    //Object for zookeeper
    static private ZooKeeper zooKeeper;

    //Object for Zoo
    static private Zoo zoo;

    //Object for animalhealer and animalfeeder
    static private AnimalFeeder animalFeeder;
    static private AnimalHealer animalHealer;


    public static void main(String[] args) throws Exception
    {
        //========================================================================================//
        //                                    ORGANISING ZOO                                      //
        //========================================================================================//
        //Instatting Zoo object
        zoo = new Zoo();

        //Oject used for file reading and updating zoo
        File animalFile = new File("Animals.txt");
        Scanner animalFileReader = new Scanner(animalFile);
        Animal animalToAdd;

        //This variable will hold the animal species and remove any "-"" 
        String animalSpecies = "";
    
        //========================================================================================//
        //                           READING FROM FILE AND UPDATING ZOO                           //
        //========================================================================================//
        while(animalFileReader.hasNextLine() )
        {
            animalToAdd = new Animal();

            //Getting animal information from the file
            animalToAdd.setCageID(animalFileReader.next() );
            animalToAdd.setName( animalFileReader.next() );
            animalSpecies = animalFileReader.next();              //This piece will remove any 
            String newSpecies = animalSpecies.replace("-", " ");  //"-" from the animal spcies
            animalToAdd.setSpecies(newSpecies);
            animalToAdd.setAge(animalFileReader.nextInt());
            animalToAdd.setHungerStatus(animalFileReader.nextInt() );
            animalToAdd.setHealthStatus(animalFileReader.nextInt() );
            animalToAdd.setCategory(animalFileReader.next());

            //Adding animal to file after all of its information has been gathered
            zoo.addAnimal(animalToAdd);
        }//end while

        //Remember to change show Animals back to void and not string
        //System.out.println(zoo.showAnimals());

        animalFileReader.close();
        // System.out.println("Name of keeper: " + zooKeeper.getName() );



        //=========================================================================================//
        //                                         ZOOKEEPER                                       //
        //=========================================================================================//
        zooKeeper = new ZooKeeper();


         new Welcome();

    }// main


    public ZooManager() 
    {
        animalFeeder = new AnimalFeeder(getZoo().getCages());
        animalHealer = new AnimalHealer(getZoo().getCages());

        animalPanel = new AnimalPanel();
        
        index = animalPanel.getIndex();
        editedFoodTextField = -1;
        editedMedTextField = -1;

        isfed = false;
        isHealed= false;

        medicineTotals.setPreferredSize(new Dimension(500,450));
       
        //setSize(150,400 );
        this.setTitle("Main Screen");
        this.setIconImage(zooLogo.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
       
        //foodTotalPanel.setBackground(Color.BLACK);
        //feedingReportsFiller.setBackground(Color.BLUE);
        
        healingReportsFiller.setBackground(Color.GREEN);
        
        westPanel.setPreferredSize(new Dimension(320,100) );
        //welcomePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE,6));

        //animalPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE,6));

        eastPanel.setPreferredSize(new Dimension(300,100));
        
        
        //========================================================================================//
        //                                  ADDING COMPONENTS                                     //
        //========================================================================================//
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS) );
        centerPanel.add(foodTotals);
        centerPanel.add(medicineTotals);
        
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.PAGE_AXIS) );
        westPanel.add(animalPanel);
        westPanel.add(welcomePanel);

        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.PAGE_AXIS) );
        eastPanel.add(reportPanel);
        eastPanel.add(healingReportsFiller);
        
        this.add("West",westPanel);
        this.add("Center",centerPanel);
        this.add("East",eastPanel);
       



        
        //========================================================================================//
        //                                ADDING ACTION LISTENERS                                 //
        //========================================================================================//
        animalPanel.getNextButton().addActionListener(this);
        for(int i = 0; i < foodTotalsButtons.size(); i++)
        {
            foodTotalsButtons.get(i).addActionListener(this);
        }

        for(int i = 0; i < medicineTotalsButtons.size(); i++)
        {
            medicineTotalsButtons.get(i).addActionListener(this);
        }
        

        //========================================================================================//
        //                                ADDING Focus LISTENERS                                  //
        //========================================================================================//
        for(int i = 0; i < foodTotalsTextFields.size(); i++)
        {
            foodTotalsTextFields.get(i).addFocusListener(this);
            
        }

        for(int i = 0; i < medicineTotalsTextFields.size(); i++)
        {
            medicineTotalsTextFields.get(i).addFocusListener(this);
            
        }

        
        disableFoodTextFields();
        disableMedTextFields();

        for(int i = 0; i < foodTotalsButtons.size(); i++)
        {
            foodTotalsButtons.get(i).setEnabled(false);
        }

        for(int i = 0; i < medicineTotalsButtons.size(); i++)
        {
            medicineTotalsButtons.get(i).setEnabled(false);
        }
        animalPanel.getNextButton().setEnabled(false);


        maximiseFrame(this);
        
        
        //centerFrame(this);
        //this.pack();
        setVisible(true);
        

    }// end Main constructor

    //========================================================================================//
    //                                ACTION PERFORMED METHOD                                 //
    //========================================================================================//
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == animalPanel.getNextButton() )
        {
            int currentIndex = index;
            while( (getZoo().getCages().get(index).getHungerStatus() == 5 || getZoo().getCages().get(index).getHealthStatus() == 10) )
            {
                index++;
            }//end while

            if(index < (ZooManager.getZoo().getCages().size() - 1) )
            {
                if(currentIndex == index)
                {
                    index++;
                }
                animalPanel.getLabelList().get(6).setText(getZoo().getCages().get(index).getCageID() );
                animalPanel.getLabelList().get(7).setText(getZoo().getCages().get(index).getName() );
                animalPanel.getLabelList().get(8).setText(getZoo().getCages().get(index).getSpecies() );
                animalPanel.getLabelList().get(9).setText(getZoo().getCages().get(index).getCategory() );
                animalPanel.getLabelList().get(10).setText(String.valueOf(getZoo().getCages().get(index).getHungerStatus() ) + "/5" );
                animalPanel.getLabelList().get(11).setText(String.valueOf(getZoo().getCages().get(index).getHealthStatus() ) +"/10"  );
                if(ZooManager.getZoo().getCages().get(index).getHealthStatus() < 8)
                {
                    animalPanel.getLabelList().get(11).setForeground(Color.RED);
                }//endif
                else
                {
                    animalPanel.getLabelList().get(11).setForeground(Color.BLACK);
                }

                char letter = getZoo().getCages().get(index).getCageID().charAt(0); 
                animalPanel.getZoneIMageLabel().setIcon(animalPanel.selectZoneImage(letter) ); 

                enableTextFields(); 

                disableMedTextFields();
                disableFoodTextFields();

                editedFoodTextField = -1;
                editedMedTextField = -1;
                
                isfed = false;
                isHealed = false;
                
                //Disble add and next button until condition are satisfied to make then enabled again
                foodTotalsButtons.get(0).setEnabled(false);
                medicineTotalsButtons.get(0).setEnabled(false);
                animalPanel.getNextButton().setEnabled(false);

                for(int i = 0; i < foodTotalsTextFields.size(); i++)
                {
                    foodTotalsTextFields.get(i).setText("0");
                }

                for(int i = 0; i < medicineTotalsTextFields.size(); i++)
                {
                    medicineTotalsTextFields.get(i).setText("0");
                }
                
                
            }//end if
            

        }//end next button action
        


        if(e.getSource() == foodTotalsButtons.get(0) )  //add button from foodtotal panel
        {
            Meal animalMeal = new Meal();
            switch (getZoo().getCages().get(index).getCageID().charAt(0) )
            {
                case 'A':
                    switch (editedFoodTextField)
                    {
                        case 0:
                            int hayAddAmountA = Integer.valueOf(foodTotalsTextFields.get(0).getText()); 
                            int hayCurrentAmountA = (Integer) foodTotalTable.get(0).getValueAt(0, 0);
                            int hayTotalA = hayAddAmountA + hayCurrentAmountA;
                            foodTotalTable.get(0).setValueAt(hayTotalA,0, 0);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Hay");
                            animalMeal.setFoodAmt(hayAddAmountA);

                            //==================Add meal to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal); //LOOK AT CONSTRUCTOR FOR ANIMAL FEEDER   
                            break;

                        case 1:
                            int fruitAddAmountA = Integer.valueOf(foodTotalsTextFields.get(1).getText()); 
                            int fruitCurrentAmountA = (Integer) foodTotalTable.get(0).getValueAt(1, 0);
                            int fruitTotalA = fruitAddAmountA + fruitCurrentAmountA;
                            foodTotalTable.get(0).setValueAt(fruitTotalA,1, 0);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Fruit");
                            animalMeal.setFoodAmt(fruitAddAmountA);

                                //==================Add meal to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;

                        case 2:
                            int grainAddAmountA = Integer.valueOf(foodTotalsTextFields.get(2).getText()); 
                            int grainCurrentAmountA = (Integer) foodTotalTable.get(0).getValueAt(2, 0);
                            int grainTotalA = grainAddAmountA + grainCurrentAmountA;
                            foodTotalTable.get(0).setValueAt(grainTotalA,2, 0);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Grain");
                            animalMeal.setFoodAmt(grainAddAmountA);

                                //==================Add meal to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;

                        case 3:
                            int fishAddAmountA = Integer.valueOf(foodTotalsTextFields.get(3).getText()); 
                            int fishCurrentAmountA = (Integer) foodTotalTable.get(0).getValueAt(3, 0);
                            int fishTotalA = fishAddAmountA + fishCurrentAmountA;
                            foodTotalTable.get(0).setValueAt(fishTotalA,3, 0);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Fish");
                            animalMeal.setFoodAmt(fishAddAmountA);

                                //==================Add meal to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;

                        case 4:
                            int meatAddAmountA = Integer.valueOf(foodTotalsTextFields.get(4).getText()); 
                            int meatCurrentAmountA = (Integer) foodTotalTable.get(0).getValueAt(4, 0);
                            int meatTotalA = meatAddAmountA + meatCurrentAmountA;
                            foodTotalTable.get(0).setValueAt(meatTotalA,4, 0);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Meat");
                            animalMeal.setFoodAmt(meatAddAmountA);

                                //==================Add meal to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;
                        }//end switch for zone A
                    break;

                case 'B':
                    switch (editedFoodTextField)
                    {
                        case 0:
                            int hayAddAmountB = Integer.valueOf(foodTotalsTextFields.get(0).getText()); 
                            int hayCurrentAmountB = (Integer) foodTotalTable.get(0).getValueAt(0, 1);
                            int hayTotalB = hayAddAmountB + hayCurrentAmountB;
                            foodTotalTable.get(0).setValueAt(hayTotalB,0, 1);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Hay");
                            animalMeal.setFoodAmt(hayAddAmountB);

                            //==================Add meal to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;

                        case 1:
                            int fruitAddAmountB = Integer.valueOf(foodTotalsTextFields.get(1).getText()); 
                            int fruitCurrentAmountB = (Integer) foodTotalTable.get(0).getValueAt(1, 1);
                            int fruitTotalB = fruitAddAmountB + fruitCurrentAmountB;
                            foodTotalTable.get(0).setValueAt(fruitTotalB,1, 1);
                            
                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Fruit");
                            animalMeal.setFoodAmt(fruitAddAmountB);

                            //==================Add mean to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;

                        case 2:
                            int grainAddAmountB = Integer.valueOf(foodTotalsTextFields.get(2).getText()); 
                            int grainCurrentAmountB = (Integer) foodTotalTable.get(0).getValueAt(2, 1);
                            int grainTotalB = grainAddAmountB + grainCurrentAmountB;
                            foodTotalTable.get(0).setValueAt(grainTotalB,2, 1);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Grain");
                            animalMeal.setFoodAmt(grainAddAmountB);

                            //==================Add mean to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;

                        case 3:
                            int fishAddAmountB = Integer.valueOf(foodTotalsTextFields.get(3).getText()); 
                            int fishCurrentAmountB = (Integer) foodTotalTable.get(0).getValueAt(3, 1);
                            int fishTotalB = fishAddAmountB + fishCurrentAmountB;
                            foodTotalTable.get(0).setValueAt(fishTotalB,3, 1);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Fish");
                            animalMeal.setFoodAmt(fishAddAmountB);

                            //==================Add mean to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;

                        case 4:
                            int meatAddAmountB = Integer.valueOf(foodTotalsTextFields.get(4).getText()); 
                            int meatCurrentAmountB = (Integer) foodTotalTable.get(0).getValueAt(4, 1);
                            int meatTotalB = meatAddAmountB + meatCurrentAmountB;
                            foodTotalTable.get(0).setValueAt(meatTotalB,4, 1);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Meat");
                            animalMeal.setFoodAmt(meatAddAmountB);

                            //==================Add mean to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;
                    }//end switch for zone B
                    break;

                case 'C':
                    switch (editedFoodTextField)
                    {
                        case 0:
                            int hayAddAmountC = Integer.valueOf(foodTotalsTextFields.get(0).getText()); 
                            int hayCurrentAmountC = (Integer) foodTotalTable.get(0).getValueAt(0, 2);
                            int hayTotalC = hayAddAmountC + hayCurrentAmountC;
                            foodTotalTable.get(0).setValueAt(hayTotalC,0, 2);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Hay");
                            animalMeal.setFoodAmt(hayAddAmountC);

                            //==================Add mean to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;

                        case 1:
                            int fruitAddAmountC = Integer.valueOf(foodTotalsTextFields.get(1).getText()); 
                            int fruitCurrentAmountC = (Integer) foodTotalTable.get(0).getValueAt(1, 2);
                            int fruitTotalC = fruitAddAmountC + fruitCurrentAmountC;
                            foodTotalTable.get(0).setValueAt(fruitTotalC,1, 2);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Fruit");
                            animalMeal.setFoodAmt(fruitAddAmountC);

                            //==================Add mean to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;

                        case 2:
                            int grainAddAmountC = Integer.valueOf(foodTotalsTextFields.get(2).getText()); 
                            int grainCurrentAmountC = (Integer) foodTotalTable.get(0).getValueAt(2, 2);
                            int grainTotalC = grainAddAmountC + grainCurrentAmountC;
                            foodTotalTable.get(0).setValueAt(grainTotalC,2, 2);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Grain");
                            animalMeal.setFoodAmt(grainAddAmountC);

                            //==================Add mean to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;

                        case 3:
                            int fishAddAmountC = Integer.valueOf(foodTotalsTextFields.get(3).getText()); 
                            int fishCurrentAmountC = (Integer) foodTotalTable.get(0).getValueAt(3, 2);
                            int fishTotalC = fishAddAmountC + fishCurrentAmountC;
                            foodTotalTable.get(0).setValueAt(fishTotalC,3, 2);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Fish");
                            animalMeal.setFoodAmt(fishAddAmountC);

                            //==================Add mean to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;

                        case 4:
                            int meatAddAmountC = Integer.valueOf(foodTotalsTextFields.get(4).getText()); 
                            int meatCurrentAmountC = (Integer) foodTotalTable.get(0).getValueAt(4, 2);
                            int meatTotalC = meatAddAmountC + meatCurrentAmountC;
                            foodTotalTable.get(0).setValueAt(meatTotalC,4, 2);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Meat");
                            animalMeal.setFoodAmt(meatAddAmountC);

                            //==================Add mean to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;
                    }//end switch for zone C
                break;

                case 'D':
                    switch (editedFoodTextField)
                    {
                        case 0:
                            int hayAddAmountD = Integer.valueOf(foodTotalsTextFields.get(0).getText()); 
                            int hayCurrentAmountD = (Integer) foodTotalTable.get(0).getValueAt(0, 3);
                            int hayTotalD = hayAddAmountD + hayCurrentAmountD;
                            foodTotalTable.get(0).setValueAt(hayTotalD,0, 3);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Hay");
                            animalMeal.setFoodAmt(hayAddAmountD);

                            //==================Add mean to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;

                        case 1:
                            int fruitAddAmountD = Integer.valueOf(foodTotalsTextFields.get(1).getText()); 
                            int fruitCurrentAmountD = (Integer) foodTotalTable.get(0).getValueAt(1, 3);
                            int fruitTotalD = fruitAddAmountD + fruitCurrentAmountD;
                            foodTotalTable.get(0).setValueAt(fruitTotalD,1, 3);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Fruit");
                            animalMeal.setFoodAmt(fruitAddAmountD);

                            //==================Add mean to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;

                        case 2:
                            int grainAddAmountD = Integer.valueOf(foodTotalsTextFields.get(2).getText()); 
                            int grainCurrentAmountD = (Integer) foodTotalTable.get(0).getValueAt(2, 3);
                            int grainTotalD = grainAddAmountD + grainCurrentAmountD;
                            foodTotalTable.get(0).setValueAt(grainTotalD,2, 3);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Grain");
                            animalMeal.setFoodAmt(grainAddAmountD);

                            //==================Add mean to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;

                        case 3:
                            int fishAddAmountD = Integer.valueOf(foodTotalsTextFields.get(3).getText()); 
                            int fishCurrentAmountD = (Integer) foodTotalTable.get(0).getValueAt(3, 3);
                            int fishTotalD = fishAddAmountD + fishCurrentAmountD;
                            foodTotalTable.get(0).setValueAt(fishTotalD,3, 3);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Fish");
                            animalMeal.setFoodAmt(fishAddAmountD);

                            //==================Add mean to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;

                        case 4:
                            int meatAddAmountD = Integer.valueOf(foodTotalsTextFields.get(4).getText()); 
                            int meatCurrentAmountD = (Integer) foodTotalTable.get(0).getValueAt(4, 3);
                            int meatTotalD = meatAddAmountD + meatCurrentAmountD;
                            foodTotalTable.get(0).setValueAt(meatTotalD,4, 3);

                            //====================Set Meal Information ===================//
                            animalMeal.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalMeal.setFoodType("Meat");
                            animalMeal.setFoodAmt(meatAddAmountD);

                            //==================Add mean to animal Feeder=================//
                            animalFeeder.addMeal(animalMeal);
                            break;
                    }//end switch for zone D
                break;
            }//end switch
            
            //============== Checking conditions to see which buttons to enable =================//
            isfed = true;

            
            if(index == getZoo().getCages().size() -1)
            {
                foodTotalsButtons.get(1).setEnabled(true); //endable printlist button
                animalPanel.getNextButton().setEnabled(false); //disable next button for the rest of program since all animals have been fed
                
                foodTotalsButtons.get(2).setEnabled(true); //enable feed button
            }
            else
            {
                foodTotalsButtons.get(0).setEnabled(false);
            }//end else
            if(isfed == true && isHealed == true)
            {
                animalPanel.getNextButton().setEnabled(true);
            }

            editedFoodTextField = -1;
            
        } //end foodTotals add button

        if(e.getSource() == foodTotalsButtons.get(1))// printList button from foodtotal panel
        {
            try 
            {
                animalFeeder.printFeedingList();
            }
            catch (Exception f) 
            {

            }
            
        }

        if(e.getSource() == foodTotalsButtons.get(2)) //feed button form foodtotal panel
        {
            boolean works = false;
            while(!works)
            {
                try
                {
                    animalFeeder.simFeeding();
                    works = true;
                }
                catch(OverFeedingException f)
                {
                    System.out.print(f.toString() + " " + works + "\n");
                }
                catch(Exception f)
                {

                }
            }
        }

        if(e.getSource() == medicineTotalsButtons.get(0))
        {
            Prescription animalPrescription = new Prescription();
            switch (getZoo().getCages().get(index).getCageID().charAt(0) )
            {
                case 'A':
                    switch (editedMedTextField)
                    {
                        case 0:
                            int herbAddAmountA = Integer.valueOf(medicineTotalsTextFields.get(0).getText()); 
                            int herbCurrentAmountA = (Integer) medicineTotalTable.get(0).getValueAt(0, 0);
                            int herbTotalA = herbAddAmountA + herbCurrentAmountA;
                            medicineTotalTable.get(0).setValueAt(herbTotalA,0, 0);

                            //====================Set Meal Information ===================//
                            animalPrescription.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalPrescription.setMedType("Herbicine");
                            animalPrescription.setUnitsOfMed(herbAddAmountA);

                            //==================Add meal to animal Feeder=================//
                            animalHealer.addPrescription(animalPrescription); //LOOK AT CONSTRUCTOR FOR ANIMAL FEEDER   
                            break;

                        case 1:
                            int omniAddAmountA = Integer.valueOf(medicineTotalsTextFields.get(1).getText()); 
                            int omniCurrentAmountA = (Integer) medicineTotalTable.get(0).getValueAt(1, 0);
                            int omniTotalA = omniAddAmountA + omniCurrentAmountA;
                            medicineTotalTable.get(0).setValueAt(omniTotalA,1, 0);

                            //====================Set Meal Information ===================//
                            animalPrescription.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalPrescription.setMedType("Omnicine");
                            animalPrescription.setUnitsOfMed(omniAddAmountA);

                            //==================Add meal to animal Feeder=================//
                            animalHealer.addPrescription(animalPrescription); //LOOK AT CONSTRUCTOR FOR ANIMAL FEEDER   
                            break;

                        case 2:
                            int carniAddAmountA = Integer.valueOf(medicineTotalsTextFields.get(2).getText()); 
                            int carniCurrentAmountA = (Integer) medicineTotalTable.get(0).getValueAt(2, 0);
                            int carniTotalA = carniAddAmountA + carniCurrentAmountA;
                            medicineTotalTable.get(0).setValueAt(carniTotalA,2, 0);

                            //====================Set Meal Information ===================//
                            animalPrescription.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalPrescription.setMedType("Carnicine");
                            animalPrescription.setUnitsOfMed(carniAddAmountA);

                            //==================Add meal to animal Feeder=================//
                            animalHealer.addPrescription(animalPrescription); //LOOK AT CONSTRUCTOR FOR ANIMAL FEEDER   
                            break;
                    }//end switch for zone A
                    break;
                case 'B':
                    switch (editedMedTextField)
                    {
                        case 0:
                            int herbAddAmountB = Integer.valueOf(medicineTotalsTextFields.get(0).getText()); 
                            int herbCurrentAmountB = (Integer) medicineTotalTable.get(0).getValueAt(0, 1);
                            int herbTotalB = herbAddAmountB + herbCurrentAmountB;
                            medicineTotalTable.get(0).setValueAt(herbTotalB,0, 1);

                            //====================Set Meal Information ===================//
                            animalPrescription.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalPrescription.setMedType("Herbicine");
                            animalPrescription.setUnitsOfMed(herbAddAmountB);

                            //==================Add meal to animal Feeder=================//
                            animalHealer.addPrescription(animalPrescription); //LOOK AT CONSTRUCTOR FOR ANIMAL FEEDER   
                            break;

                        case 1:
                            int omniAddAmountB = Integer.valueOf(medicineTotalsTextFields.get(1).getText()); 
                            int omniCurrentAmountB = (Integer) medicineTotalTable.get(0).getValueAt(1, 1);
                            int omniTotalB = omniAddAmountB + omniCurrentAmountB;
                            medicineTotalTable.get(0).setValueAt(omniTotalB,1, 1);

                            //====================Set Meal Information ===================//
                            animalPrescription.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalPrescription.setMedType("Omnicine");
                            animalPrescription.setUnitsOfMed(omniAddAmountB);

                            //==================Add meal to animal Feeder=================//
                            animalHealer.addPrescription(animalPrescription); //LOOK AT CONSTRUCTOR FOR ANIMAL FEEDER   
                            break;

                        case 2:
                            int carniAddAmountB = Integer.valueOf(medicineTotalsTextFields.get(2).getText()); 
                            int carniCurrentAmountB = (Integer) medicineTotalTable.get(0).getValueAt(2, 1);
                            int carniTotalB = carniAddAmountB + carniCurrentAmountB;
                            medicineTotalTable.get(0).setValueAt(carniTotalB,2, 1);

                            //====================Set Meal Information ===================//
                            animalPrescription.setCageID(getZoo().getCages().get(index).getCageID() );
                            animalPrescription.setMedType("Carnicine");
                            animalPrescription.setUnitsOfMed(carniAddAmountB);

                            //==================Add meal to animal Feeder=================//
                            animalHealer.addPrescription(animalPrescription); //LOOK AT CONSTRUCTOR FOR ANIMAL FEEDER   
                            break;
                    }//end switch for zone B
                    break;

                    case 'C':
                        switch (editedMedTextField)
                        {
                            case 0:
                                int herbAddAmountC = Integer.valueOf(medicineTotalsTextFields.get(0).getText()); 
                                int herbCurrentAmountC = (Integer) medicineTotalTable.get(0).getValueAt(0, 2);
                                int herbTotalC = herbAddAmountC + herbCurrentAmountC;
                                medicineTotalTable.get(0).setValueAt(herbTotalC,0, 2);

                                //====================Set Meal Information ===================//
                                animalPrescription.setCageID(getZoo().getCages().get(index).getCageID() );
                                animalPrescription.setMedType("Herbicine");
                                animalPrescription.setUnitsOfMed(herbAddAmountC);

                                //==================Add meal to animal Feeder=================//
                                animalHealer.addPrescription(animalPrescription); //LOOK AT CONSTRUCTOR FOR ANIMAL FEEDER   
                                break;

                            case 1:
                                int omniAddAmountC = Integer.valueOf(medicineTotalsTextFields.get(1).getText()); 
                                int omniCurrentAmountC = (Integer) medicineTotalTable.get(0).getValueAt(1, 2);
                                int omniTotalC = omniAddAmountC + omniCurrentAmountC;
                                medicineTotalTable.get(0).setValueAt(omniTotalC,1, 2);

                                //====================Set Meal Information ===================//
                                animalPrescription.setCageID(getZoo().getCages().get(index).getCageID() );
                                animalPrescription.setMedType("Omnicine");
                                animalPrescription.setUnitsOfMed(omniAddAmountC);

                                //==================Add meal to animal Feeder=================//
                                animalHealer.addPrescription(animalPrescription); //LOOK AT CONSTRUCTOR FOR ANIMAL FEEDER   
                                break;

                            case 2:
                                int carniAddAmountC = Integer.valueOf(medicineTotalsTextFields.get(2).getText()); 
                                int carniCurrentAmountC = (Integer) medicineTotalTable.get(0).getValueAt(2, 2);
                                int carniTotalC = carniAddAmountC + carniCurrentAmountC;
                                medicineTotalTable.get(0).setValueAt(carniTotalC,2, 2);

                                //====================Set Meal Information ===================//
                                animalPrescription.setCageID(getZoo().getCages().get(index).getCageID() );
                                animalPrescription.setMedType("Carnicine");
                                animalPrescription.setUnitsOfMed(carniAddAmountC);

                                //==================Add meal to animal Feeder=================//
                                animalHealer.addPrescription(animalPrescription); //LOOK AT CONSTRUCTOR FOR ANIMAL FEEDER   
                                break;
                        }//end switch for zone C
                        break;

                        case 'D':
                            switch (editedMedTextField)
                            {
                                case 0:
                                    int herbAddAmountD = Integer.valueOf(medicineTotalsTextFields.get(0).getText()); 
                                    int herbCurrentAmountD = (Integer) medicineTotalTable.get(0).getValueAt(0, 3);
                                    int herbTotalD = herbAddAmountD + herbCurrentAmountD;
                                    medicineTotalTable.get(0).setValueAt(herbTotalD,0, 3);

                                    //====================Set Meal Information ===================//
                                    animalPrescription.setCageID(getZoo().getCages().get(index).getCageID() );
                                    animalPrescription.setMedType("Herbicine");
                                    animalPrescription.setUnitsOfMed(herbAddAmountD);

                                    //==================Add meal to animal Feeder=================//
                                    animalHealer.addPrescription(animalPrescription); //LOOK AT CONSTRUCTOR FOR ANIMAL FEEDER   
                                    break;

                                case 1:
                                    int omniAddAmountD = Integer.valueOf(medicineTotalsTextFields.get(1).getText()); 
                                    int omniCurrentAmountD = (Integer) medicineTotalTable.get(0).getValueAt(1, 3);
                                    int omniTotalD = omniAddAmountD + omniCurrentAmountD;
                                    medicineTotalTable.get(0).setValueAt(omniTotalD,1, 3);

                                    //====================Set Meal Information ===================//
                                    animalPrescription.setCageID(getZoo().getCages().get(index).getCageID() );
                                    animalPrescription.setMedType("Omnicine");
                                    animalPrescription.setUnitsOfMed(omniAddAmountD);

                                    //==================Add meal to animal Feeder=================//
                                    animalHealer.addPrescription(animalPrescription); //LOOK AT CONSTRUCTOR FOR ANIMAL FEEDER   
                                    break;

                                case 2:
                                    int carniAddAmountD = Integer.valueOf(medicineTotalsTextFields.get(2).getText()); 
                                    int carniCurrentAmountD = (Integer) medicineTotalTable.get(0).getValueAt(2, 3);
                                    int carniTotalD = carniAddAmountD + carniCurrentAmountD;
                                    medicineTotalTable.get(0).setValueAt(carniTotalD,2, 3);

                                    //====================Set Meal Information ===================//
                                    animalPrescription.setCageID(getZoo().getCages().get(index).getCageID() );
                                    animalPrescription.setMedType("Carnicine");
                                    animalPrescription.setUnitsOfMed(carniAddAmountD);

                                    //==================Add meal to animal Feeder=================//
                                    animalHealer.addPrescription(animalPrescription); //LOOK AT CONSTRUCTOR FOR ANIMAL FEEDER   
                                    break;
                            }//end switch for zone D
                        break;
            }//end switch
            isHealed = true;

            if(index == getZoo().getCages().size() -1)
            {
                medicineTotalsButtons.get(1).setEnabled(true); //enable printlist button
                animalPanel.getNextButton().setEnabled(false); //disable next button for the rest of program since all animals have been fed
                
                medicineTotalsButtons.get(2).setEnabled(true); //enable feed button
            }
            else
            {
                medicineTotalsButtons.get(0).setEnabled(false);
            }//end else

            if(isfed == true && isHealed == true)
            {
                animalPanel.getNextButton().setEnabled(true);
            }
        }//end if
    
        if(e.getSource() == medicineTotalsButtons.get(1))
        {
            try 
            {
                animalHealer.printHealingList();
            }
            catch (Exception f) 
            {

            }
        }

        if(e.getSource() == medicineTotalsButtons.get(2))
        {
            boolean works = false;
            while(!works)
            {
                try
                {
                    animalHealer.simHealing();
                    works = true;
                }
                catch(OverdosingException f)
                {
                    System.out.print(f.toString() + " " + works + "\n");
                }
                catch(Exception f)
                {

                }
            }
        }
    }// actionPerformed


    //========================================================================================//
    //                                Focus Listsner METHODS                                  //
    //========================================================================================//
    public void focusGained(FocusEvent e)
    {
        
    }//end focusGained

    public void focusLost(FocusEvent e)
    {
        //=====================Food Text fields==================//
        if(e.getSource() == foodTotalsTextFields.get(0) )
        {
            try
            {
                if(Integer.valueOf( foodTotalsTextFields.get(0).getText() ) > 0 )
                {
                    for(int i = 0; i < foodTotalsTextFields.size(); i++)
                    {
                        if(i != 0)
                        {
                            foodTotalsTextFields.get(i).setEditable(false);
                        }
                    }//end for
                    editedFoodTextField = 0;
                    foodTotalsButtons.get(0).setEnabled(true);
                }//end if
            }
            catch(NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null, "Value must be a number", "WARNING", JOptionPane.WARNING_MESSAGE);
                foodTotalsTextFields.get(0).setText("0");
                foodTotalsButtons.get(0).setEnabled(false);
            }
        }//and hay textfleid

        if(e.getSource() == foodTotalsTextFields.get(1) )
        {
            try
            {
                if(Integer.valueOf( foodTotalsTextFields.get(1).getText() ) > 0 )
                {
                    for(int i = 0; i < foodTotalsTextFields.size(); i++)
                    {
                        if(i != 1)
                        {
                            foodTotalsTextFields.get(i).setEditable(false);
                        }
                    }//end for
                    editedFoodTextField = 1;
                    foodTotalsButtons.get(0).setEnabled(true);
                }//end if
            }
            catch(NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null, "Value must be a number", "WARNING", JOptionPane.WARNING_MESSAGE);
                foodTotalsTextFields.get(1).setText("0");
                foodTotalsButtons.get(0).setEnabled(false);
            }
          
        }//end fruit textfleid

        if(e.getSource() == foodTotalsTextFields.get(2) )
        {
            try
            {
                if(Integer.valueOf( foodTotalsTextFields.get(2).getText() ) > 0 )
                {
                    for(int i = 0; i < foodTotalsTextFields.size(); i++)
                    {
                        if(i != 2)
                        {
                            foodTotalsTextFields.get(i).setEditable(false);
                        }
                    }//end for
                    editedFoodTextField = 2;
                    foodTotalsButtons.get(0).setEnabled(true);
                }//end if
            }
            catch(NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null, "Value must be a number", "WARNING", JOptionPane.WARNING_MESSAGE);
                foodTotalsTextFields.get(2).setText("0");
                foodTotalsButtons.get(0).setEnabled(false);
            }
        }//end grain textfleid

        if(e.getSource() == foodTotalsTextFields.get(3) )
        {
            try
            {
                if(Integer.valueOf( foodTotalsTextFields.get(3).getText() ) > 0 )
                {
                    for(int i = 0; i < foodTotalsTextFields.size(); i++)
                    {
                        if(i != 3)
                        {
                            foodTotalsTextFields.get(i).setEditable(false);
                        }
                    }//end for
                    editedFoodTextField = 3;
                    foodTotalsButtons.get(0).setEnabled(true);
                }//end if
            }
            catch(NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null, "Value must be a number", "WARNING", JOptionPane.WARNING_MESSAGE);
                foodTotalsTextFields.get(3).setText("0");
                foodTotalsButtons.get(0).setEnabled(false);
            }
           
        }//end fish textfleid
        
        if(e.getSource() == foodTotalsTextFields.get(4) )
        {
            try
            {
                if(Integer.valueOf( foodTotalsTextFields.get(4).getText() ) > 0 )
                {
                    for(int i = 0; i < foodTotalsTextFields.size(); i++)
                    {
                        if(i != 4)
                        {
                            foodTotalsTextFields.get(i).setEditable(false);
                        }
                    }//end for
                    editedFoodTextField = 4;
                    foodTotalsButtons.get(0).setEnabled(true);
                }//end if
            }
            catch(NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null, "Value must be a number", "WARNING", JOptionPane.WARNING_MESSAGE);
                foodTotalsTextFields.get(4).setText("0");
                foodTotalsButtons.get(0).setEnabled(false); 
            }
           
        }//and meat textfleid

        //=====================Medicine Text Fields ====================//
        if(e.getSource() == medicineTotalsTextFields.get(0))
        {
            
            try
            {
                if(Integer.valueOf(medicineTotalsTextFields.get(0).getText() ) > 0 )
                {
                    for(int i = 0; i < medicineTotalsTextFields.size(); i++)
                    {
                        if(i != 0)
                        {
                            medicineTotalsTextFields.get(i).setEditable(false);
                        }
                    }//end for
                    editedMedTextField = 0;
                    medicineTotalsButtons.get(0).setEnabled(true);
                }//end if
            }
            catch(NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null, "Value must be a number", "WARNING", JOptionPane.WARNING_MESSAGE);
                medicineTotalsTextFields.get(0).setText("0");
                medicineTotalsButtons.get(0).setEnabled(false);
            }
        }//end herbicine text field

        if(e.getSource() == medicineTotalsTextFields.get(1))
        {
            try
            {
                if(Integer.valueOf(medicineTotalsTextFields.get(1).getText() ) > 0 )
                {
                    for(int i = 0; i < medicineTotalsTextFields.size(); i++)
                    {
                        if(i != 2)
                        {
                            medicineTotalsTextFields.get(i).setEditable(false);
                        }
                    }//end for
                    editedMedTextField = 1;
                    medicineTotalsButtons.get(0).setEnabled(true);
                }//end if

            }
            catch(NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null, "Value must be a number", "WARNING", JOptionPane.WARNING_MESSAGE);
                medicineTotalsTextFields.get(2).setText("0");
                medicineTotalsButtons.get(0).setEnabled(false);
            }
        }//end omnicine text field

        if(e.getSource() == medicineTotalsTextFields.get(2))
        {
            try
            {
                if(Integer.valueOf(medicineTotalsTextFields.get(2).getText() ) > 0 )
                {
                    for(int i = 0; i < medicineTotalsTextFields.size(); i++)
                    {
                        if(i != 0)
                        {
                            medicineTotalsTextFields.get(i).setEditable(false);
                        }
                    }//end for
                    editedMedTextField = 2;
                    medicineTotalsButtons.get(0).setEnabled(true);
                }//end if
            }
            catch(NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null, "Value must be a number", "WARNING", JOptionPane.WARNING_MESSAGE);
                medicineTotalsTextFields.get(1).setText("0");
                medicineTotalsButtons.get(0).setEnabled(false);
            }
        }//end carnicine text field
    }//end FocusLost

    //========================================================================================//
    //                                    OTHER METHODS                                       //
    //========================================================================================//
    private void disableFoodTextFields()
    {
        switch (getZoo().getCages().get(index).getCategory() )
        {
            case "Herbivore":
                foodTotalsTextFields.get(3).setEditable(false);
                foodTotalsTextFields.get(4).setEditable(false);
                break;
            
            case "Carnivore":
                foodTotalsTextFields.get(0).setEditable(false);
                foodTotalsTextFields.get(1).setEditable(false);
                foodTotalsTextFields.get(2).setEditable(false);
                break;
            default:
                foodTotalsTextFields.get(2).setEditable(false);
                foodTotalsTextFields.get(4).setEditable(false);
                break;
        }//end switch
    }//end disableFoodTextFelds

    
    private void disableMedTextFields()
    {
        switch (getZoo().getCages().get(index).getCategory() )
        {
            case "Herbivore":
                medicineTotalsTextFields.get(1).setEditable(false);
                medicineTotalsTextFields.get(2).setEditable(false);
                break;

            case "Carnivore":
                medicineTotalsTextFields.get(0).setEditable(false);
                medicineTotalsTextFields.get(1).setEditable(false);
                break;

            default:
                medicineTotalsTextFields.get(0).setEditable(false);
                medicineTotalsTextFields.get(2).setEditable(false);
                break;

            
        }//end switch
    }//end disable med textfields

    
    private void enableTextFields()
    {
        for(int i = 0; i < foodTotalsTextFields.size(); i++)
        {
            foodTotalsTextFields.get(i).setEditable(true);
            
        }

        for(int i = 0; i < 3; i++)
        {
            medicineTotalsTextFields.get(i).setEditable(true);
        }
    }//end enable text fields
    

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
     
        
   

    //========================================================================================//
    //                                     ACCESSORS                                          //
    //========================================================================================//
    public static Zoo getZoo()
    {
        return zoo; 
    }

    public static ZooKeeper getZooKeeper()
    {
        return zooKeeper;
    }
    

}// ZooManager