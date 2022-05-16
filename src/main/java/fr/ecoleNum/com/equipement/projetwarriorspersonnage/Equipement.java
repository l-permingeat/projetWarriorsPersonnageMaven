package fr.ecoleNum.com.equipement.projetwarriorspersonnage;

import fr.ecoleNum.com.personnage.projetwarriorspersonnage.Personnage;
import fr.ecoleNum.com.plateau.projetwarriorspersonnage.Cellule;

import java.util.Scanner;

public abstract class  Equipement implements Cellule {

    private String name;
    private int niveauAttaque;
    private int rendsPointDeVie;
    private Scanner scanner;

    /**
     *
     * @param name nom de l'équipement
     * @param niveauAttaque le niveau d'attaque que le joueur va avoir en ramassant l'équipement
     */
    public Equipement(String name, int niveauAttaque){
        this.name=name;
        this.niveauAttaque=niveauAttaque;
        this.scanner = new Scanner(System.in);
    }

    /**
     *
     * @param personnage le type de personnage (guerrier, magicien)
     *
     */
    @Override
    public void action(Personnage personnage) {

    }

    /* ****************** Getter et Setter ********************/

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getNiveauAttaque() {
        return niveauAttaque;
    }

    public void setNiveauAttaque(String niveauAttaque) {
        this.niveauAttaque = Integer.parseInt(niveauAttaque);
    }

    public int getRendsPointDeVie() {
        return rendsPointDeVie;
    }

    public void setRendsPointDeVie(int rendsPointDeVie) {
        this.rendsPointDeVie = rendsPointDeVie;
    }
    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }



}//fin
