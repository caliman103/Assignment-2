/*
ClassName: ReadAnimal
Author: Jamaine Drakes
Purpose:  
Start Date: Mar 11, 2022
Last Edit: Mar 11, 2022
*/

//========================================================================================//
//                                     LIBRARIES                                          //
//========================================================================================//
import java.io.File;
import java.util.Scanner;
public class ReadAnimal
{
    public static void main(String[] args) throws Exception
    {
        //========================================================================================//
        //                                 VARIABLES AND OBJECTS                                  //
        //========================================================================================//
         File ListAFile = new File("Animals.txt");
         Scanner animalFileReader = new Scanner(ListAFile);

         
         String animlaCageID = "";
         String animalName = ""; 
         String animalSpecies = "";  
         int animalAge = 0; 
         int animalHungerStatus = 0; 
         int animalHeathStatus = 0; 
         String animalCategory = "";

        while(animalFileReader.hasNextLine() )
        {
            animlaCageID = animalFileReader.next();
            animalName = animalFileReader.next();
            animalSpecies = animalFileReader.next();
            animalAge = animalFileReader.nextInt();
            animalHungerStatus = animalFileReader.nextInt();
            animalHeathStatus = animalFileReader.nextInt();
            animalCategory = animalFileReader.next();

            String newAnimalSpecies = animalSpecies.replace("-", " ");

            System.out.println(animlaCageID + "\t" + animalName + "\t" + newAnimalSpecies + "\t" + animalAge + "\t" + animalHungerStatus + "\t" + animalHeathStatus + "\t" + animalCategory);
        }

        animalFileReader.close();


    }// end main


}// end ReadAnimal