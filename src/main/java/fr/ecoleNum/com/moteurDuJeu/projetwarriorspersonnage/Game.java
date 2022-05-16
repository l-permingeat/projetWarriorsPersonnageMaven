package fr.ecoleNum.com.moteurDuJeu.projetwarriorspersonnage;

//import fr.ecoleNum.com.BDD.projetwarriorspersonnage.Requete;
import fr.ecoleNum.com.BDD.projetwarriorspersonnage.RequeteTest;
import fr.ecoleNum.com.exception.PersonnageHorsPlateauException;
import fr.ecoleNum.com.personnage.projetwarriorspersonnage.Guerrier;
import fr.ecoleNum.com.personnage.projetwarriorspersonnage.Magicien;
import fr.ecoleNum.com.personnage.projetwarriorspersonnage.Personnage;
import fr.ecoleNum.com.plateau.projetwarriorspersonnage.Cellule;
import fr.ecoleNum.com.plateau.projetwarriorspersonnage.DeVirtuel;
import fr.ecoleNum.com.plateau.projetwarriorspersonnage.Plateau;

import java.util.Scanner;

public class Game {
    private DeVirtuel de;
    private Plateau plateau;
    private int positionActuelle = 0;
    Scanner scanner;
    private fr.ecoleNum.com.exception.PersonnageHorsPlateauException PersonnageHorsPlateauException;
    Personnage personnage;
   // Connexion essai;
    RequeteTest essai;


    /* ***************************** Constructeur de main ********************************************* */

    /**
     *
     */
    public Game() {
        this.de = new DeVirtuel(6);
        this.plateau = new Plateau();
        this.scanner = new Scanner(System.in);
        this.PersonnageHorsPlateauException = new PersonnageHorsPlateauException();
        this.essai=new RequeteTest();
    }

    /* ***************************** Fonction de départ ********************************************* */

    /**
     * Pose les questions de base pour orienter le joueur
     * Suivant les choix : renvoie vers la méthode créerPerso, calculerPosition ou quitte le jeux
     * Pas de parametre attendu
     */
    public void start() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Hello, go pour une super partie ! ");
            System.out.println("Commençons par créer le personnage : Taper 1 \nPersonnage déja créé ? Commencer à jouer en tapant 2 \nQuitter ?  Taper 3");
            essai.afficherRequete();


            int reponseChoix = scanner.nextInt();

            if (reponseChoix == 1) {
                //envoi vers la fonction création de personnage
                creerPersonnage();
            } else if (reponseChoix == 2) {
                calculerPosition();

            } else if (reponseChoix == 3) {
                // met fin au jeux
                System.out.print("A bientôt ! ^-^ ");
            } else {
                System.out.println("Mauvaise saisie \n Vous devez taper 1, 2 ou 3");
                start();
            }
        } catch (Exception e) {
            System.out.println("Il y a une erreur - fonction Start");
            start();
        }
    }

    /* ***************************** Fonction création du personnage ********************************************* */

    /**
     * Permet de créer le personnage, guerrier ou magicien
     * A la fin appelle de la méthode questionConfirmationPersonnage
     */
    public void creerPersonnage() {
        //j'initialise une variable de type objet issue de la class Personnage
        try {
            System.out.print("Souhaitez vous créer un magicien ou un guerrier ? ");
            String reponseTypePersonnage = scanner.nextLine();
            System.out.print("Comment voulez vous le nommer ? ");
            String reponseNomPersonnage = scanner.nextLine();

            if (reponseTypePersonnage.equals("guerrier")) {
                this.personnage = new Guerrier(reponseNomPersonnage);
                //personnage.setEquipement(new MassueGuerrier());

            } else if (reponseTypePersonnage.equals("magicien")) {
                this.personnage = new Magicien((reponseNomPersonnage));
            }
        } catch (Exception e) {
            System.out.print(" Mauvaise saisie, vous devez taper guerrier ou magicien ");
        }

        System.out.println("Votre personnage est un.e " + personnage);

        //appelle de la fonction pour demander au joueur s'il souhaite modifier le nom de son personnage
        questionConfirmationPersonnage();

    }

    /* ***************************** Fonction est ce que le personnage convient ? ********************************************* */

    /**
     * Demande au joueur s'il veut modifier le nom du personnage
     * Quand le joueur est satisfait du nom, appelle de la méthode calculerPosition
     */
    public void questionConfirmationPersonnage() {
        System.out.println("Votre personnage vous convient ? Taper 1 \n Sinon, taper 2 ");
        int reponseChoix = scanner.nextInt();

        if (reponseChoix == 1) {
            System.out.println(" \nSuper, nous pouvons passer à la suite !  ");
            //appel de la fonction qui calcule la position puis qui fais avancer le personnage
            calculerPosition();
        } else if (reponseChoix == 2) {
            modifierNomPersonnage();
        }
    }

    /* ***************************** Fonction modifier le nom du personnage  ********************************************* */

    /**
     * Modifie le nom du personnage si le joueur le souhaite
     * Si le joueur modifie le nom de son personnage, appelle de la méthode questionConfirmationPersonnage
     */
    public void modifierNomPersonnage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Comment voulez vous renommer votre personnage ? ");
        String reponseModifNomPersonnage = scanner.nextLine();
        personnage.setName(reponseModifNomPersonnage);
        System.out.println("Votre personnage est un.e" + personnage);
        questionConfirmationPersonnage();
    }

    /* ***************************** Calculer position  ********************************************* */

    /**
     * Lance le dé et calcul la position du joueur
     * Tant que la boucle est vraie, la position du joueur est incrémenter du résultat du dé
     * puis appelle de la méthode avancerPersonnage
     */
    public void calculerPosition() {
        try {
            while (true) {
                positionActuelle = positionActuelle + this.de.lancerDe();
                avancerPersonnage(positionActuelle);
            }
            //écoute si une exception se produit, traitement de l'exception executé
        } catch (PersonnageHorsPlateauException e) {
            System.out.print(e);
            System.exit(1);
        }
    }

    /* ***************************** Faire avancer le personnage  ********************************************* */

    /**
     * Fait avancer le personnage sur le plateau et indique ce qu'il y a sur la case
     * @param position attends en paramètre la position du joueur
     * Appelle de la méthode decisionPersonnage
     */
    public void avancerPersonnage(int position) throws PersonnageHorsPlateauException {
        System.out.println("Vous avez lancé les dés. " + personnage.getName() + " est sur la case " + position + " du plateau");
        decisionPersonnage(this.plateau.contenuTabIndiceI(position));
    }

    /* ***************************** Décision du personnage  ********************************************* */

    /**
     * Propose aux joueurs des choix en fonction de ce qu'il rencontre sur la case
     * @param cellule, c'est l'objet qu'il y a dans la cellule (ennemi, vide, surprise...)
     * Appelle de la méthode open pour indiquer ce qu'il y a dans ennemi, surprise ou vide
     * Puis appelle de la méthode action qui déclenchera un combat si case ennemi ou une récupération d'arme/potion si surprise
     * Enfin appelle la méthode calculerPosition pour relancer une boucle
     */
    public void decisionPersonnage(Cellule cellule) {
        //action déclenche le combat ou la ramasse de surpise
        cellule.action(personnage);
        //fait avancer le personnage
        calculerPosition();
    }

} // fin class fr.ecoleNum.com.Main




