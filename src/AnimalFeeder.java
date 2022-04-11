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

public class AnimalFeeder
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//
    private ArrayList<Meal> feedingList;
    private ArrayList<Animal> cages;


    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public AnimalFeeder(ArrayList<Animal> newCages)
    {
        feedingList = new ArrayList<Meal>();
        cages = new ArrayList<Animal>();
        cages = newCages;
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
    
    
    public void printFeedingList()
    {
        
    }// printFeedingList

    public void simFeeding()
    {
        
    }// simFeeding


}// AnimalFeeder