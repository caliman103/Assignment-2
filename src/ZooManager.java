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
    JPanel feedingReportsFiller = new JPanel();
    WelcomePanel welcomePanel = new WelcomePanel();
    JPanel medicineTotalsFiller = new JPanel();
    JPanel healingReportsFiller = new JPanel();

    
    //C0mponents from FoodTotals
    ArrayList<JButton> foodTotalsButtons = foodTotals.getButtonList();
    ArrayList<JTable> foodTotalTable = foodTotals.getTableList();
    ArrayList<JTextField> foodTotalsTextFields = foodTotals.getTextFieldList();

    //=================Images=====================//
    ImageIcon zooLogo = new ImageIcon("../Images/Logo.png");


    int index;
   


    //Object for zookeeper
    static private ZooKeeper zooKeeper;

    //Object for Zoo
    static private Zoo zoo;

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
        animalPanel = new AnimalPanel();
        
        index = 0;
        
        medicineTotalsFiller.setPreferredSize(new Dimension(500,450));
       
        //setSize(150,400 );
        this.setTitle("Main Screen");
        this.setIconImage(zooLogo.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
       
        //foodTotalPanel.setBackground(Color.BLACK);
        feedingReportsFiller.setBackground(Color.BLUE);
        medicineTotalsFiller.setBackground(Color.CYAN);
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
        animalPanel.getNextButton().addActionListener(this);
        for(int i = 0; i < foodTotalsButtons.size(); i++)
        {
            foodTotalsButtons.get(i).addActionListener(this);
        }
        

        //========================================================================================//
        //                                ADDING Focus LISTENERS                                  //
        //========================================================================================//
        for(int i = 0; i < foodTotalsTextFields.size(); i++)
        {
            foodTotalsTextFields.get(i).addFocusListener(this);
        }

        //foodTotalsTextFields.get(0).setFocusable(false);
        disableFoodTextFields();

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
            if(index < (ZooManager.getZoo().getCages().size() - 1) )
            {
                index++;
                
                animalPanel.getLabelList().get(6).setText(getZoo().getCages().get(index).getCageID() );
                animalPanel.getLabelList().get(7).setText(getZoo().getCages().get(index).getName() );
                animalPanel.getLabelList().get(8).setText(getZoo().getCages().get(index).getSpecies() );
                animalPanel.getLabelList().get(9).setText(getZoo().getCages().get(index).getCategory() );
                animalPanel.getLabelList().get(10).setText(String.valueOf(getZoo().getCages().get(index).getHungerStatus() ) + "/5" );
                if(ZooManager.getZoo().getCages().get(index).getHungerStatus() <= 2)
                {
                    animalPanel.getLabelList().get(10).setForeground(Color.RED);
                }//endif
                else
                {
                    animalPanel.getLabelList().get(10).setForeground(Color.BLACK);
                }
                animalPanel.getLabelList().get(11).setText(String.valueOf(getZoo().getCages().get(index).getHealthStatus() ) +"/10"  );
                if(ZooManager.getZoo().getCages().get(index).getHealthStatus() <= 3)
                {
                    animalPanel.getLabelList().get(11).setForeground(Color.RED);
                }//endif
                else
                {
                    animalPanel.getLabelList().get(11).setForeground(Color.BLACK);
                }

                char letter = getZoo().getCages().get(index).getCageID().charAt(0); 
                animalPanel.getZoneIMageLabel().setIcon(animalPanel.selectZoneImage(letter) ); 

                enebleAllTextFields();
                disableFoodTextFields();
            }//end if


        }//end next button action
        


        if(e.getSource() == foodTotalsButtons.get(0) )  //next button from foodtotal panel
        {
            //foodTotalTable.get(0).setValueAt(2, 0, 0);

        }
    }// actionPerformed


    //========================================================================================//
    //                                Focus Listsner METHODS                                  //
    //========================================================================================//
    public void focusGained(FocusEvent e)
    {
        if(e.getSource() == foodTotalsTextFields.get(0) )
        {
           for(int i = 0; i < foodTotalsTextFields.size(); i++)
           {
                
                foodTotalsTextFields.get(1).setEditable(false);
                foodTotalsTextFields.get(2).setEditable(false);
                foodTotalsTextFields.get(3).setEditable(false);
                foodTotalsTextFields.get(4).setEditable(false);
                
                
           }//end for
        }//and hay textfleid
    }//end focusGained

    public void focusLost(FocusEvent e)
    {
        if(e.getSource() == foodTotalsTextFields.get(0) )
        {
           if(foodTotalsTextFields.get(0).getText().equals("0"))
           {
                disableFoodTextFields();
           }
        }//and hay textfleid
        
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
    }//end enableFoodTextFelds

    private void enebleAllTextFields()
    {
        for(int i = 0; i < foodTotalsTextFields.size(); i++)
        {
            foodTotalsTextFields.get(i).setEditable(true);;
        }
    }

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