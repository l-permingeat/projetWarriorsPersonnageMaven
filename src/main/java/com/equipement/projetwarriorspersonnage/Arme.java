package com.equipement.projetwarriorspersonnage;

import com.personnage.projetwarriorspersonnage.Guerrier;
import com.personnage.projetwarriorspersonnage.Personnage;
import com.plateau.projetwarriorspersonnage.Cellule;

public class Arme extends Equipement implements Cellule {

    public Arme(String name, int level) {
        super(name, level);
    }

    /**
     *
      * @param personnage le type de personnage (guerrier, magicien)
     *   Si guerrier, il peut ramasser l'équipement (épée ou massue)
     *   Si magicien, ne peut pas ramasser l'équipement
     */
    @Override
    public void action(Personnage personnage) {
        if (personnage instanceof Guerrier) {
            System.out.println("Une " + getName() + " !  Pour la ramasser taper 1 \nPartir ? 2 ");

            if (getScanner().nextInt() == 2) {
                System.out.println("A bientôt !");
                System.exit(1);
            } else {
                personnage.setEquipement(this);
                System.out.println("Vous avez récupéré un.e " + personnage.getEquipement().getName() + ". Il vous apporte " + personnage.getEquipement().getNiveauAttaque() + " points de force.");
            }
        } else {
            System.out.println("Vous n'êtes pas un guerrier, vous ne pouvez pas ramasser l'arme " + getName() +".");
        }

        System.out.println("Voulez vous continuer ? Taper 1.\nPartir taper 2 ");
        if (getScanner().nextInt() == 2) {
            System.out.println("A bientôt !");
            System.exit(1);
        } else {
            System.out.println("C'est reparti pour un tour !");
        }
    }
}


