/*
ClassName: AnimalFeeder
Author: Jamaine Drakes, Evan Leacock
Purpose: 
Start Date: Mar 11, 2022
Last Edit: Mar 11, 2022
*/

//========================================================================================//
//                                     LIBRARIES                                          //
//========================================================================================//
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AnimalFeeder
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//
    private ArrayList<Meal> feedingList;
    private ArrayList<Animal> cages;
    private ArrayList<Integer> deadAnimals;


    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public AnimalFeeder(ArrayList<Animal> newCages)
    {
        cages = newCages;
        feedingList = new ArrayList<Meal>();
        deadAnimals = new ArrayList<Integer>();
    }// AnimalFeeder


    //========================================================================================//
    //                                     ACCESSORS                                          //
    //========================================================================================//
    public ArrayList<Meal> getFeedingList()
    {
        return feedingList;
    } //end getFeedingList

    public ArrayList<Animal> getCages()
    {
        return cages;
    } //end getFeedingList

    public ArrayList<Integer> getDeadAnimals()
    {
        return deadAnimals;
    }

    //========================================================================================//
    //                                      MUTATORS                                          //
    //========================================================================================//
    public void addMeal(Meal newMeal)
    {
        feedingList.add(newMeal);
    }// addMeal

    //========================================================================================//
    //                                    OTHER METHODS                                       //
    //========================================================================================//
    
    
    public void printFeedingList() throws Exception
    {
        File outFile = new File("FeedingList.txt");
        FileWriter fileWriter = new FileWriter(outFile);

        fileWriter.write("Feeding List - Date\n");

        int hayAmt = 0;
        int fruitAmt = 0;
        int grainAmt = 0;
        int fishAmt = 0;
        int meatAmt = 0;

        fileWriter.write("(A) African Savanna\n");

        for (int i = 0; i < feedingList.size(); i++) 
        {
            for (int j = 0; j < cages.size(); j++) 
            {
                if((feedingList.get(i).getCageID().equals(cages.get(j).getCageID())) && (cages.get(j).getCageID().charAt(0) == 'A'))
                {
                    fileWriter.write(cages.get(j).getName() + ", " + cages.get(j).getSpecies() + "\t\t" + feedingList.get(i).getFoodAmt() + " " + feedingList.get(i).getFoodType() + "\n");

                    switch (feedingList.get(i).getFoodType()) 
                    {
                        case "Hay":
                            hayAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Fruit":
                            fruitAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Grain":
                            grainAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Fish":
                            fishAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Meat":
                            meatAmt += feedingList.get(i).getFoodAmt();
                            break;
                    }
                }
            }// end for
        }//end for

        fileWriter.write("\nFood Summary\n");

        if(hayAmt != 0)
        {
            fileWriter.write(hayAmt + " Hay\n");
        }

        if(fruitAmt != 0)
        {
            fileWriter.write(fruitAmt + " Fruit\n");
        }

        if(grainAmt != 0)
        {
            fileWriter.write(grainAmt + " Grain\n");
        }

        if(fishAmt != 0)
        {
            fileWriter.write(fishAmt + " Fish\n");
        }

        if(meatAmt != 0)
        {
            fileWriter.write(meatAmt + " Meat\n");
        }

        hayAmt = fruitAmt = grainAmt = fishAmt = meatAmt = 0;


        fileWriter.write("\n\n(B) Amazonian Jungle\n");

        for (int i = 0; i < feedingList.size(); i++) 
        {
            for (int j = 0; j < cages.size(); j++) 
            {
                if((feedingList.get(i).getCageID().equals(cages.get(j).getCageID())) && (cages.get(j).getCageID().charAt(0) == 'B'))
                {
                    fileWriter.write(cages.get(j).getName() + ", " + cages.get(j).getSpecies() + "\t\t" + feedingList.get(i).getFoodAmt() + " " + feedingList.get(i).getFoodType() + "\n");

                    switch (feedingList.get(i).getFoodType()) 
                    {
                        case "Hay":
                            hayAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Fruit":
                            fruitAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Grain":
                            grainAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Fish":
                            fishAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Meat":
                            meatAmt += feedingList.get(i).getFoodAmt();
                            break;
                    }
                }
            }// end for
        }//end for

        fileWriter.write("\nFood Summary\n");

        if(hayAmt != 0)
        {
            fileWriter.write(hayAmt + " Hay\n");
        }

        if(fruitAmt != 0)
        {
            fileWriter.write(fruitAmt + " Fruit\n");
        }

        if(grainAmt != 0)
        {
            fileWriter.write(grainAmt + " Grain\n");
        }

        if(fishAmt != 0)
        {
            fileWriter.write(fishAmt + " Fish\n");
        }

        if(meatAmt != 0)
        {
            fileWriter.write(meatAmt + " Meat\n");
        }

        hayAmt = fruitAmt = grainAmt = fishAmt = meatAmt = 0;

        
        fileWriter.write("\n\n(C) Eurasian Wild\n");

        for (int i = 0; i < feedingList.size(); i++) 
        {
            for (int j = 0; j < cages.size(); j++) 
            {
                if((feedingList.get(i).getCageID().equals(cages.get(j).getCageID())) && (cages.get(j).getCageID().charAt(0) == 'C'))
                {
                    fileWriter.write(cages.get(j).getName() + ", " + cages.get(j).getSpecies() + "\t\t" + feedingList.get(i).getFoodAmt() + " " + feedingList.get(i).getFoodType() + "\n");

                    switch (feedingList.get(i).getFoodType()) 
                    {
                        case "Hay":
                            hayAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Fruit":
                            fruitAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Grain":
                            grainAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Fish":
                            fishAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Meat":
                            meatAmt += feedingList.get(i).getFoodAmt();
                            break;
                    }
                }
            }// end for
        }//end for

        fileWriter.write("\nFood Summary\n");

        if(hayAmt != 0)
        {
            fileWriter.write(hayAmt + " Hay\n");
        }

        if(fruitAmt != 0)
        {
            fileWriter.write(fruitAmt + " Fruit\n");
        }

        if(grainAmt != 0)
        {
            fileWriter.write(grainAmt + " Grain\n");
        }

        if(fishAmt != 0)
        {
            fileWriter.write(fishAmt + " Fish\n");
        }

        if(meatAmt != 0)
        {
            fileWriter.write(meatAmt + " Meat\n");
        }

        hayAmt = fruitAmt = grainAmt = fishAmt = meatAmt = 0;


        fileWriter.write("\n\n(D) Frozen Tundra\n");

        for (int i = 0; i < feedingList.size(); i++) 
        {
            for (int j = 0; j < cages.size(); j++) 
            {
                if((feedingList.get(i).getCageID().equals(cages.get(j).getCageID())) && (cages.get(j).getCageID().charAt(0) == 'D'))
                {
                    fileWriter.write(cages.get(j).getName() + ", " + cages.get(j).getSpecies() + "\t\t" + feedingList.get(i).getFoodAmt() + " " + feedingList.get(i).getFoodType() + "\n");

                    switch (feedingList.get(i).getFoodType()) 
                    {
                        case "Hay":
                            hayAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Fruit":
                            fruitAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Grain":
                            grainAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Fish":
                            fishAmt += feedingList.get(i).getFoodAmt();
                            break;

                        case "Meat":
                            meatAmt += feedingList.get(i).getFoodAmt();
                            break;
                    }
                }
            }// end for
        }//end for

        fileWriter.write("\nFood Summary\n");

        if(hayAmt != 0)
        {
            fileWriter.write(hayAmt + " Hay\n");
        }

        if(fruitAmt != 0)
        {
            fileWriter.write(fruitAmt + " Fruit\n");
        }

        if(grainAmt != 0)
        {
            fileWriter.write(grainAmt + " Grain\n");
        }

        if(fishAmt != 0)
        {
            fileWriter.write(fishAmt + " Fish\n");
        }

        if(meatAmt != 0)
        {
            fileWriter.write(meatAmt + " Meat\n");
        }

        hayAmt = fruitAmt = grainAmt = fishAmt = meatAmt = 0;

        fileWriter.flush();
        fileWriter.close();
    }// printFeedingList

    public void printFeedingReport() throws Exception
    {
        File outFile = new File("FeedingReport.txt");
        FileWriter fileWriter = new FileWriter(outFile);

        fileWriter.write("Date\n");
        fileWriter.write("Animals Fed: " + feedingList.size() + "\n");
        fileWriter.write("OK: " + (feedingList.size() - deadAnimals.size()) + "\n");
        fileWriter.write("Deaths: " + deadAnimals.size() + "\n");
        fileWriter.write("Overfed: \n");

        for (int i = 0; i < deadAnimals.size(); i++) 
        {
            fileWriter.write(cages.get(deadAnimals.get(i)).getCageID() + " - " + cages.get(deadAnimals.get(i)).getName() + ", " + cages.get(deadAnimals.get(i)).getSpecies() + "\n");
        }

        fileWriter.flush();
        fileWriter.close();
    }

    public void simFeeding() throws Exception
    {
        //for each element i in the feeding list search the cages list for the animal that matches i's cage ID
        //when the animal has been found and if it isnt dead, feed it
        //if it is overfed, throw the exception
        for (int i = 0; i < feedingList.size(); i++) 
        {
            for (int j = 0; j < cages.size(); j++) 
            {
                if((feedingList.get(i).getCageID().equals(cages.get(j).getCageID())) && (cages.get(j).getHealthStatus() > 0) && (!cages.get(j).getFed()))
                {
                    cages.get(j).eatFood(feedingList.get(i).getFoodAmt());

                    if(cages.get(j).getOverFed())
                    {
                        deadAnimals.add(j);
                        throw new OverFeedingException();
                    }

                    break;
                }
            }// end for
        }//end for

        //printFeedingReport();
        
    }// simFeeding


}// AnimalFeeder

/*
boolean works = false;
while(!works)
{
    try
    {
        simFeeding();
        works = true;
    }
    catch(OverFeedingException e)
    {
        
    }
}
*/