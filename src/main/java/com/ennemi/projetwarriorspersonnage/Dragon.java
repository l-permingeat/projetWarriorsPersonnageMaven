package com.ennemi.projetwarriorspersonnage;

import com.personnage.projetwarriorspersonnage.Personnage;

public class Dragon extends Ennemi {
    public Dragon() {
        super(15, 4, "Dragon");
    }

    /**
     *
     * @param personnage le type de personnage (guerrier, magicien)
     *                   Déclenche le combat
     */
    @Override
    public void action(Personnage personnage) {
        System.out.println("Vous êtes face à un "+ getName() + ". Le combat va commencer.");
        System.out.println(
            "          ,  ,\n" +
                "          \\\\ \\\\           \n" +
                "          ) \\\\ \\\\    _p_ \n" +
                "          )^\\))\\))  /  *\\ \n" +
                "           \\_|| || / /^`-' \n" +
                "  __       -\\ \\\\--/ / \n" +
                "<'  \\\\___/   ___. )'\n" +
                "     `====\\ )___/\\\\ \n" +
                "          //     `\"\n" +
                "          \\\\    /  \\\n" +
                "          `\""
        );
        //Le personnage attaque l'ennemi : soustraction du nb de force du personnage au nb de vie de l'ennemi
        setPointDeVieActuelle(getPointDeVieActuelle() - calculForce(personnage));
        if (getPointDeVieActuelle() <= 0) {
            System.out.println("Suite à votre attaque "+getName() + " est mort !");
        } else {
            //L'ennemi attaque le personnage : soustraction du nb de force de l'ennemi au nb de vie du personnage
            personnage.setVieActuelle(personnage.getVieActuelle() - getPointDattaque());
            if (personnage.getVieActuelle() <= 0) {
                System.out.println("L'attaque de l'ennemi a été fatale, "+personnage.getName() + " est mort ! Fin du jeu...");
                System.out.println("  _                   _\n" +
                    " _( )                 ( )_\n" +
                    "(_, |      __ __      | ,_)\n" +
                    "   \\'\\    /  ^  \\    /'/\n" +
                    "    '\\'\\,/\\      \\,/'/'\n" +
                    "      '\\| []   [] |/'\n" +
                    "        (_  /^\\  _)\n" +
                    "          \\  ~  /\n" +
                    "          /HHHHH\\\n" +
                    "        /'/{^^^}\\'\\\n" +
                    "    _,/'/'  ^^^  '\\'\\,_\n" +
                    "   (_, |           | ,_)\n" +
                    "     (_)           (_)");
                System.exit(1);
            } else {
                System.out.println("Suite au combat " + personnage.getName() + " a maintenant " + personnage.getVieActuelle() + " vie.s ! ");
            }
        }
        System.out.println("Voulez vous continuer ? Taper 1.\n Sinon taper 2. ");
        if (getScanner().nextInt() == 2) {
            System.out.println("A bientôt !");
            System.exit(1);
        }else{
            System.out.println("C'est reparti pour un tour !");
        }
    }

    /**
     *
     * @param personnage le personnage en cours de jeu
     * @return la force disponible
     */
    private int calculForce(Personnage personnage) {
        int force = 0;
        if (personnage.getEquipement() == null) {
            //force d'attaque du personnage + force d'attaque de l'équipement
            force = personnage.getForceActuelle();
        } else if ((personnage.getForceActuelle() + personnage.getEquipement().getNiveauAttaque()) < personnage.getForceMax()) {
            force = personnage.getForceMax();
        }
        return force;
    }
}
