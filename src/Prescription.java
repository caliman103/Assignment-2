/*
ClassName: Prescription
Author: Jamaine Drakes, Evan Leacock
Purpose: 
Start Date: Mar 11, 2022
Last Edit: Mar 11, 2022
*/

//========================================================================================//
//                                     LIBRARIES                                          //
//========================================================================================//

public class Prescription
{
    //========================================================================================//
    //                                    DATA MEMBERS                                        //
    //========================================================================================//
    private String cageID;
    private String medType;
    private int unitsOfMed;


    //========================================================================================//
    //                                    CONSTRUCTOR                                         //
    //========================================================================================//
    public Prescription()
    {
        cageID = "";
        medType = "";
        unitsOfMed = 0;
    }// Prescription


    //========================================================================================//
    //                                     ACCESSORS                                          //
    //========================================================================================//
    public String getCageID()
    {
        return cageID;
    }// getCageID

    public String getMedType()
    {
        return medType;
    }// getmedType

    public int getUnitsOfMed()
    {
        return unitsOfMed;
    }// getunitsOfMed


    //========================================================================================//
    //                                      MUTATORS                                          //
    //========================================================================================//
    public void setCageID(String id)
    {
        cageID = id;
    }// setCageID

    public void setMedType(String type)
    {
        medType = type;
    }// setmedType

    public void setUnitsOfMed(int amt)
    {
        unitsOfMed = amt;
    }// setunitsOfMed


    //========================================================================================//
    //                                    OTHER METHODS                                       //
    //========================================================================================//


}// Prescription