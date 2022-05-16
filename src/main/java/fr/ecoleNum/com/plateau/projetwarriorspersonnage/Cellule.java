package fr.ecoleNum.com.plateau.projetwarriorspersonnage;


import fr.ecoleNum.com.personnage.projetwarriorspersonnage.Personnage;

public interface Cellule {


    /**
     * déclenche le combat ou la ramasse de la surprise
     * @param personnage le type de personnage (guerrier, magicien)
     */

    void action(Personnage personnage);
}
