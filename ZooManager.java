/*
ClassName: ZooManager
Author: Jamaine Drakes & Evan Leacock
Purpose: To test smth
Start Date: Mar 12, 2022
Last Edit: Mar 12, 2022
*/

//========================================================================================//
//                                     LIBRARIES                                          //
//========================================================================================//
import java.io.File;

import java.util.Scanner;

public class ZooManager
{
    //Object for zookeeper
    static private ZooKeeper zooKeeper;

    //Object for Zoo
    static private Zoo zoo;


    //Oject used for file reading and updating zoo
    private File animalFile = new File("Animals.txt");
    private Scanner animalFileReader = new Scanner(animalFile);
    private Animal animalToAdd;

    //This variable will hold the animal species and remove any "-"" 
    private String animalSpecies = "";

    public static void main(String[] args) throws Exception
    {

        new ZooManager();
        
        //========================================================================================//
        //                                 VARIABLES AND OBJECTS                                  //
        //========================================================================================//
        /*

       //Logo of for ZooKeeper 2.0
        ImageIcon logo = new ImageIcon("../Images/logo.png");
        Image alteredLogo = logo.getImage(); //get the imageicon as an image  to scale it
        Image newLogo =  alteredLogo.getScaledInstance(60, 60, Image.SCALE_SMOOTH); //transform it
        logo = new ImageIcon(newLogo); //convertit back to imageIcon

        String[] options = {"Yes I am!! ", "No, I would like to quit"};

       int start = JOptionPane.showOptionDialog(null,
                                                "Welcome to Your Zoo Program!!\n Are you ready to start", 
                                                "Welcome", 
                                                JOptionPane.YES_NO_OPTION, 
                                                JOptionPane.INFORMATION_MESSAGE,
                                                logo,
                                                options, 
                                                0);

        if(start == 1)
        {
            System.exit(0);
        }

    
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

         String keeperName;
         //Get the name of the zookeeper from the user, using an input dialogbox
        // keeperName = JOptionPane.showInputDialog("Before we begin, please enter your name.", "John Doe");
         
         //Try catch doesnt work
         try 
         {
            //Get the name of the zookeeper from the user, using an input dialogbox
            keeperName = JOptionPane.showInputDialog("Before we begin, please enter your name.", "John Doe");

            //Set the name of the zookeeper to what the usr entered
            zooKeeper.setName(keeperName );
            
 
         }
          catch (NullPointerException e) 
          {
             keeperName = JOptionPane.showInputDialog("Please enter your name in the text box below","John Doe");
             
             //TODO: handle exception
          }
 
         //Set the name of the zookeeper to what the usr entered
         zooKeeper.setName(keeperName );
          
         

         System.out.println("Name of keeper: " + keeperName);

         new MainTester();

         */

    }// end main


    public ZooManager() throws Exception
    {
        
         //========================================================================================//
        //                                    ORGANISING ZOO                                      //
        //========================================================================================//
        //Instatting Zoo object
        zoo = new Zoo();
            
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
        
    }// end ZooManager constructor

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