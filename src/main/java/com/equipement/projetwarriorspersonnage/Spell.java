package com.equipement.projetwarriorspersonnage;

import com.personnage.projetwarriorspersonnage.Magicien;
import com.personnage.projetwarriorspersonnage.Personnage;
import com.plateau.projetwarriorspersonnage.Cellule;

public class Spell extends Equipement implements Cellule {
    public Spell(String name, int level) {
        super(name, level);
    }

    /**
     *
     * @param personnage le type de personnage (guerrier, magicien)
     * si magicien, il peut ramasser l'équipement (boule de feu ou eclair)
     * si guerrier ne peut pas rammasser l'équipement
     */
    @Override
    public void action(Personnage personnage) {
        if (personnage instanceof Magicien) {
            System.out.println("Une " + getName() + " ! Pour la ramasser taper 1 \nPartir taper 2 ");

            if (getScanner().nextInt() == 2) {
                System.out.println("A bientôt !");
                System.exit(1);
            } else {
                personnage.setEquipement(this);
                System.out.println("Vous avez récupéré un.e " + personnage.getEquipement().getName() + ". Vous gagner " + personnage.getEquipement().getNiveauAttaque() + " points de force.");
            }
        } else {
            System.out.println("Vous n'êtes pas un magicien, vous ne pouvez pas ramasser le sort " + getName()+" .");
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

