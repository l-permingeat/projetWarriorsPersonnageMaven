package com.exception;

public class PersonnageHorsPlateauException extends Exception{

    /**
     * Exception si le personnage sort du plateau
     */
   public PersonnageHorsPlateauException(){
        super("Vous avez gagné ! ^.^");

    }
}
