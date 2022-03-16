/*
ClassName: Zoo
Author: Jamaine Drakes, Evan Leacock
Purpose: 
Start Date: Mar 11, 2022
Last Edit: Mar 11, 2022
*/

//========================================================================================//
//                                     LIBRARIES                                          //
//========================================================================================//
import java.util.ArrayList;

public class Zoo
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//
    ArrayList<Animal> cages;


    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public Zoo()
    {
        cages = new ArrayList<Animal>();
    }// Zoo


    //========================================================================================//
    //                                     ACCESSORS                                          //
    //========================================================================================//
    public String showAnimals()
    {
        //temporarily holds the information of a single animal
        String information = "";

        //stores information of all the animals
        String allInformation = "";
        for(int i = 0; i < cages.size(); i++)
        {
             String cageID = cages.get(i).getCageID() + "  ";
             String name = cages.get(i).getName();
             String species = cages.get(i).getSpecies();
             String age = String.valueOf(cages.get(i).getAge() );
             String hunger = String.valueOf(cages.get(i).getHungerStatus() );
             String health = String.valueOf(cages.get(i).getHealthStatus() );
             String category = cages.get(i).getCategory();

             information = (i + 1) + ". CageID: " + cageID +  "\tSpecies: " + species + "\tName: " + name +  "\tAge: " + age  + 
             "\tHunger Status: " + hunger + "\tHealth Status: " + health + "\tCategory: " + category + "\n\n";

             allInformation = allInformation.concat(information);
        }//end for

        return allInformation;
        
    }// showAnimals
    

    public Animal getAnimal(String cageID)
    {
        Animal returnAnimal = new Animal();

        for(int i = 0; i < cages.size(); i++)
        {
            //checks for matching cageID in Zoo
            if(cages.get(i).getCageID().equals(cageID))
            {
                returnAnimal = cages.get(i);
            }
        }

        return returnAnimal;
    }// getAnimal


    public ArrayList<Animal> getCages()
    {
        return cages;
    }// getCages


    //========================================================================================//
    //                                      MUTATORS                                          //
    //========================================================================================//
    public void addAnimal(Animal newAnimal)
    {
        cages.add(newAnimal);
    }// addAnimal


    public void removeAnimal(String cageID)
    {
        for(int i = 0; i < cages.size(); i++)
        {
            if(cages.get(i).getCageID().equals(cageID))
            {
                cages.remove(i);
            }
        }
    }// removeAnimal


    //========================================================================================//
    //                                    OTHER METHODS                                       //
    //========================================================================================//
    public void printHungerReport()
    {
        
    }// getAnimal


    public void printHealthReport()
    {
        
    }// printHealthReport


}// Zoo