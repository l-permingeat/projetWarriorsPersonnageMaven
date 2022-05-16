package fr.ecoleNum.com.plateau.projetwarriorspersonnage;

import fr.ecoleNum.com.ennemi.projetwarriorspersonnage.Dragon;
import fr.ecoleNum.com.ennemi.projetwarriorspersonnage.Gobelin;
import fr.ecoleNum.com.ennemi.projetwarriorspersonnage.Sorcier;
import fr.ecoleNum.com.equipement.projetwarriorspersonnage.Arme;
import fr.ecoleNum.com.equipement.projetwarriorspersonnage.Potion;
import fr.ecoleNum.com.equipement.projetwarriorspersonnage.Spell;
import fr.ecoleNum.com.exception.PersonnageHorsPlateauException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plateau {
    public List<Cellule> cells = new ArrayList<>(64);

    /**
     * fonction qui affecte une cellule à un indice i du tableau, puis lui affecte aléatoirement une surprise, du vide ou un ennemi
     */
    public Plateau() {
        /*cells.add(45, new Dragon())
        cells.add(52, new Dragon())
        cells.add(56, new Dragon())
        cells.add(62, new Dragon())*/


        for (int i = 0; i < 4; i++) {
            cells.add(new Dragon());
        }
        for (int i = 0; i < 10; i++) {
            cells.add(new Gobelin());
        }
        for (int i = 0; i < 10; i++) {
            cells.add(new Sorcier());
        }
        for (int i = 0; i < 5; i++) {
            cells.add(new Arme("Massue",3));
        }
        for (int i = 0; i < 4; i++) {
            cells.add(new Arme("Epee",5));
        }
        for (int i = 0; i < 5; i++) {
            cells.add(new Spell("Eclair", 2));
        }
        for (int i = 0; i < 2; i++) {
            cells.add(new Spell("Boule de feu", 7));
        }
        for (int i = 0; i < 6; i++) {
            cells.add(new Potion("Potion de vie",2));
        }
        for (int i = 0; i < 2; i++) {
            cells.add(new Potion("Grande potion de vie",5));
        }
        for (int i = 0; i < 16; i++) {
            cells.add(new VideCellule());
        }
        Collections.shuffle(cells);

    }

    /**
     * @param indice un entier qui permettra d'indiquer l'indice du tableau que l'on veut consulter
     * @return le contenu du tableau à l'indice donné
     * @throws PersonnageHorsPlateauException indique que cette méthode peut déclencher une exception
     */
    public Cellule contenuTabIndiceI(int indice) throws PersonnageHorsPlateauException {
        if (indice < cells.size()) {
            return cells.get(indice);
        }
        //si la condition au dessus est fausse, alors une excepetion est levée
        throw new PersonnageHorsPlateauException();
    }

    /**
     * @return la longeur de mon tableau
     */
    public int getSize() {
        return cells.size();
    }

    /* ****************** Getter et Setter ********************/


}
