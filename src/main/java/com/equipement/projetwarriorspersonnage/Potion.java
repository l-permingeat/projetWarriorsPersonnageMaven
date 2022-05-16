package com.equipement.projetwarriorspersonnage;

import com.personnage.projetwarriorspersonnage.Personnage;
import com.plateau.projetwarriorspersonnage.Cellule;

public class Potion extends Equipement implements Cellule {
    public Potion(String name, int level) {
        super(name, level);
    }

    /**
     *
     * @param personnage le type de personnage (guerrier, magicien)
     * Peut importe le personnage, tout le monde à le droit de prendre les potions
     */
    @Override
    public void action(Personnage personnage) {
        System.out.println("Une " + getName() + " !  Pour la ramasser taper 1 \nSinon taper 2 ");

        if (getScanner().nextInt() == 2) {
            System.out.println("A bientôt !");
            System.exit(1);
        } else {
            if ((personnage.getVieActuelle() + getNiveauAttaque()) > personnage.getVieMax()) {
                personnage.setVieActuelle(personnage.getVieMax());
                System.out.println("Vous avez maintenant " + personnage.getVieActuelle() + " vie.s");
            } else {
                personnage.setVieActuelle(personnage.getVieActuelle() + getNiveauAttaque());
                System.out.println("Vous avez maintenant " + personnage.getVieActuelle() + " vie.s");
            }
        }

        System.out.println("Voulez vous continuer ? Taper 1\nPartir taper 2 ");
        if (getScanner().nextInt() == 2) {
            System.out.println("A bientôt !");
            System.exit(1);
        } else {
            System.out.println("C'est reparti pour un tour !\n");
        }
    }

}
