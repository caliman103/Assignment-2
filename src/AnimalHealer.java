/*
ClassName: AnimalHealer
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

public class AnimalHealer
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//
    private ArrayList<Prescription> healingList;
    private ArrayList<Animal> cages;
    private ArrayList<Integer> deadAnimals;


    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public AnimalHealer(ArrayList<Animal> newCages)
    {
        cages = newCages;
        healingList = new ArrayList<Prescription>();
        deadAnimals = new ArrayList<Integer>();
    }// AnimalHealer


    //========================================================================================//
    //                                     ACCESSORS                                          //
    //========================================================================================//
    public ArrayList<Prescription> getHealingList()
    {
        return healingList;
    } //end getHealingList

    public ArrayList<Animal> getCages()
    {
        return cages;
    } //end getHealingList

    public ArrayList<Integer> getDeadAnimals()
    {
        return deadAnimals;
    }

    //========================================================================================//
    //                                      MUTATORS                                          //
    //========================================================================================//
    public void addPrescription(Prescription newPrescription)
    {
        healingList.add(newPrescription);
    }// addPrescription

    //========================================================================================//
    //                                    OTHER METHODS                                       //
    //========================================================================================//
    
    
    public void printHealingList() throws Exception
    {
        File outFile = new File("HealingList.txt");
        FileWriter fileWriter = new FileWriter(outFile);

        fileWriter.write("Healing List - Date\n");

        int herbicineAmt = 0;
        int omnicineAmt = 0;
        int carnicineAmt = 0;

        fileWriter.write("(A) African Savanna\n");

        for (int i = 0; i < healingList.size(); i++) 
        {
            for (int j = 0; j < cages.size(); j++) 
            {
                if((healingList.get(i).getCageID().equals(cages.get(j).getCageID())) && (cages.get(j).getCageID().charAt(0) == 'A'))
                {
                    fileWriter.write(cages.get(j).getName() + ", " + cages.get(j).getSpecies() + "\t\t" + healingList.get(i).getUnitsOfMed() + " " + healingList.get(i).getMedType() + "\n");

                    switch (healingList.get(i).getMedType()) 
                    {
                        case "Herbicine":
                            herbicineAmt += healingList.get(i).getUnitsOfMed();
                            break;

                        case "Omnicine":
                            omnicineAmt += healingList.get(i).getUnitsOfMed();
                            break;

                        case "Carnicine":
                            carnicineAmt += healingList.get(i).getUnitsOfMed();
                            break;
                    }
                }
            }// end for
        }//end for

        fileWriter.write("\nMedicine Summary\n");

        if(herbicineAmt != 0)
        {
            fileWriter.write(herbicineAmt + " Herbicine\n");
        }

        if(omnicineAmt != 0)
        {
            fileWriter.write(omnicineAmt + " Omnicine\n");
        }

        if(carnicineAmt != 0)
        {
            fileWriter.write(carnicineAmt + " Carnicine\n");
        }

        herbicineAmt = omnicineAmt = carnicineAmt = 0;


        fileWriter.write("\n\n(B) Amazonian Jungle\n");

        for (int i = 0; i < healingList.size(); i++) 
        {
            for (int j = 0; j < cages.size(); j++) 
            {
                if((healingList.get(i).getCageID().equals(cages.get(j).getCageID())) && (cages.get(j).getCageID().charAt(0) == 'B'))
                {
                    fileWriter.write(cages.get(j).getName() + ", " + cages.get(j).getSpecies() + "\t\t" + healingList.get(i).getUnitsOfMed() + " " + healingList.get(i).getMedType() + "\n");

                    switch (healingList.get(i).getMedType()) 
                    {
                        case "Herbicine":
                            herbicineAmt += healingList.get(i).getUnitsOfMed();
                            break;

                        case "Omnicine":
                            omnicineAmt += healingList.get(i).getUnitsOfMed();
                            break;

                        case "Carnicine":
                            carnicineAmt += healingList.get(i).getUnitsOfMed();
                            break;
                    }
                }
            }// end for
        }//end for

        fileWriter.write("\nMedicine Summary\n");

        if(herbicineAmt != 0)
        {
            fileWriter.write(herbicineAmt + " Herbicine\n");
        }

        if(omnicineAmt != 0)
        {
            fileWriter.write(omnicineAmt + " Omnicine\n");
        }

        if(carnicineAmt != 0)
        {
            fileWriter.write(carnicineAmt + " Carnicine\n");
        }

        herbicineAmt = omnicineAmt = carnicineAmt = 0;

        
        fileWriter.write("\n\n(C) Eurasian Wild\n");

        for (int i = 0; i < healingList.size(); i++) 
        {
            for (int j = 0; j < cages.size(); j++) 
            {
                if((healingList.get(i).getCageID().equals(cages.get(j).getCageID())) && (cages.get(j).getCageID().charAt(0) == 'C'))
                {
                    fileWriter.write(cages.get(j).getName() + ", " + cages.get(j).getSpecies() + "\t\t" + healingList.get(i).getUnitsOfMed() + " " + healingList.get(i).getMedType() + "\n");

                    switch (healingList.get(i).getMedType()) 
                    {
                        case "Herbicine":
                            herbicineAmt += healingList.get(i).getUnitsOfMed();
                            break;

                        case "Omnicine":
                            omnicineAmt += healingList.get(i).getUnitsOfMed();
                            break;

                        case "Carnicine":
                            carnicineAmt += healingList.get(i).getUnitsOfMed();
                            break;
                    }
                }
            }// end for
        }//end for

        fileWriter.write("\nMedicine Summary\n");

        if(herbicineAmt != 0)
        {
            fileWriter.write(herbicineAmt + " Herbicine\n");
        }

        if(omnicineAmt != 0)
        {
            fileWriter.write(omnicineAmt + " Omnicine\n");
        }

        if(carnicineAmt != 0)
        {
            fileWriter.write(carnicineAmt + " Carnicine\n");
        }

        herbicineAmt = omnicineAmt = carnicineAmt = 0;


        fileWriter.write("\n\n(D) Frozen Tundra\n");

        for (int i = 0; i < healingList.size(); i++) 
        {
            for (int j = 0; j < cages.size(); j++) 
            {
                if((healingList.get(i).getCageID().equals(cages.get(j).getCageID())) && (cages.get(j).getCageID().charAt(0) == 'D'))
                {
                    fileWriter.write(cages.get(j).getName() + ", " + cages.get(j).getSpecies() + "\t\t" + healingList.get(i).getUnitsOfMed() + " " + healingList.get(i).getMedType() + "\n");

                    switch (healingList.get(i).getMedType()) 
                    {
                        case "Herbicine":
                            herbicineAmt += healingList.get(i).getUnitsOfMed();
                            break;

                        case "Omnicine":
                            omnicineAmt += healingList.get(i).getUnitsOfMed();
                            break;

                        case "Carnicine":
                            carnicineAmt += healingList.get(i).getUnitsOfMed();
                            break;
                    }
                }
            }// end for
        }//end for

        fileWriter.write("\nMedicine Summary\n");

        if(herbicineAmt != 0)
        {
            fileWriter.write(herbicineAmt + " Herbicine\n");
        }

        if(omnicineAmt != 0)
        {
            fileWriter.write(omnicineAmt + " Omnicine\n");
        }

        if(carnicineAmt != 0)
        {
            fileWriter.write(carnicineAmt + " Carnicine\n");
        }

        herbicineAmt = omnicineAmt = carnicineAmt = 0;

        fileWriter.flush();
        fileWriter.close();
    }// printHealingList

    private void printHealingReport() throws Exception
    {
        File outFile = new File("HealingReport.txt");
        FileWriter fileWriter = new FileWriter(outFile);

        fileWriter.write("Date\n");
        fileWriter.write("Animals Healed: " + healingList.size() + "\n");
        fileWriter.write("OK: " + (healingList.size() - deadAnimals.size()) + "\n");
        fileWriter.write("Deaths: " + deadAnimals.size() + "\n");
        fileWriter.write("Overdosed: \n");

        for (int i = 0; i < deadAnimals.size(); i++) 
        {
            fileWriter.write(cages.get(deadAnimals.get(i)).getCageID() + " - " + cages.get(deadAnimals.get(i)).getName() + ", " + cages.get(deadAnimals.get(i)).getSpecies() + "\n");
        }

        fileWriter.flush();
        fileWriter.close();
    }

    public void simHealing() throws Exception
    {
        //for each element i in the healing list search the cages list for the animal that matches i's cage ID
        //when the animal has been found and if it isnt dead, heal it
        //if it is overdosed, throw the exception
        for (int i = 0; i < healingList.size(); i++) 
        {
            for (int j = 0; j < cages.size(); j++) 
            {
                if((healingList.get(i).getCageID().equals(cages.get(j).getCageID())) && ((cages.get(j).getHealthStatus()) > 0) &&(!cages.get(j).getHealed()))
                {
                    cages.get(j).takeMedicine(healingList.get(i).getUnitsOfMed());

                    if(cages.get(j).getOverDosed())
                    {
                        deadAnimals.add(j);
                        throw new OverdosingException();
                    }

                    break;
                }
            }// end for
        }//end for

        //printHealingReport();
        
    }// simHealing


}// AnimalHealer
