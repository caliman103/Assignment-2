/*
ClassName: Animal
Author: Jamaine, Evan Leacock
Purpose: The puspose of this class is to manage information about each animal in the Zoo
Start Date: Mar 10, 2022
Last Edit: Mar 11, 2022
*/

//========================================================================================//
//                                     LIBRARIES                                          //
//========================================================================================//

public class Animal
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//
    

    private boolean overFed;
    private boolean overDosed;

    //Jamaine changed them change them back if you want
    private final int MAX_HUNGER = 5;
    private final int MAX_HEALTH = 10;

    protected String species;
    protected String name;
    protected String category;
    protected String cageID; 
    protected int age;
    protected int hungerStatus;
    protected int healthStatus;

    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public Animal()
    {
        //MAX_HUNGER = 5;
        //MAX_HEALTH = 10;
        

        //Set variables to their default values
        species = "";
        name = "";
        age = 0;
        category = "";
        cageID = "";
        hungerStatus = 0;
        healthStatus = 0;
        overFed = false;
        overDosed = false;

    }// consructor

    //========================================================================================//
    //                                     ACCESSORS                                          //
    //========================================================================================//
    //Accessor for species
    public String getSpecies()
    {
        return species;
    }// getSpecies


    //Accessor for name
    public String getName()
    {
        return name;
    }// getName


    //Accessor for name
    public String getCategory()
    {
        return category;
    }// getName

    //Accessor for name
    public String getCageID()
    {
        return cageID;
    }// getName

    //Accessor for age
    public int getAge()
    {
        return age;
    }// getAge

    //Accessor for hungerStatus
    public int getHungerStatus()
    {
        return hungerStatus;
    }// getHungerStatus


    //Accessor for healthStatus
    public int getHealthStatus()
    {
        return healthStatus;
    }// getHealthStatus

    public boolean getOverFed()
    {
        return overFed;
    }

    public boolean getOverDosed()
    {
        return overDosed;
    }

    //========================================================================================//
    //                                      MUTATORS                                          //
    //========================================================================================//
    //Mutator for species
    public void setSpecies(String newSpecies)
    {
        species = newSpecies;
    }// setSpecies

     //Mutator for name
     public void setName(String newName)
     {
         name = newName;
     }// setName


     //Mutator for category
     public void setCategory(String newCategory)
     {
         category = newCategory;
     }// setName


     //Mutator for cage ID
     public void setCageID(String newCageID)
     {
         cageID = newCageID;
     }// setName


     //Mutator for age
    public void setAge(int newAge)
    {
        age = newAge;
    }// setAge

    //Mutator for hunger status
    public void setHungerStatus(int newHungerStatus)
    {
        hungerStatus = newHungerStatus;
    }// setHungerStatus

    //Mutator for health status
    public void setHealthStatus(int newHealthStatus)
    {
        healthStatus = newHealthStatus;
    }// setHealthStatus

    //========================================================================================//
    //                                    OTHER METHODS                                       //
    //========================================================================================//
    //eat food method
    public void eatFood(int amountOfFood)
    {
        if(healthStatus != 0)
        {
            setHungerStatus(hungerStatus + amountOfFood);

            if(hungerStatus > MAX_HUNGER)
            {
                overFed = true;
                setHealthStatus(0);
                setHungerStatus(0);
            }
        }
    }// eatFood

    
    //take medecine method
    public void takeMedicine(int amountOfMedicine)
    {
        if(healthStatus != 0)
        {
            setHealthStatus(hungerStatus + amountOfMedicine);

            if(healthStatus > MAX_HEALTH)
            {
                overDosed = true;
                setHealthStatus(0);
                setHungerStatus(0);
            }
        }
    }// takeMedicine

}//  Animal Class