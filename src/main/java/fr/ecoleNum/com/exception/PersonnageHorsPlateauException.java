package fr.ecoleNum.com.exception;

public class PersonnageHorsPlateauException extends Exception{

    /**
     * Exception si le personnage sort du plateau
     */
   public PersonnageHorsPlateauException(){
        super("Vous avez gagné ! ^.^\n  |       |\n" +
            "(|       |)\n" +
            " |       |\n" +
            "  \\     /\n" +
            "   `---'\n" +
            "   _|_|_\n");

    }
}
