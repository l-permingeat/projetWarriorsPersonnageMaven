package com.ennemi.projetwarriorspersonnage;

import com.personnage.projetwarriorspersonnage.Personnage;
import com.plateau.projetwarriorspersonnage.Cellule;

import java.util.Scanner;

public abstract class Ennemi implements Cellule {
    private int pointDeVieActuelle;
    private int pointDattaque;
    private String name;
    private Scanner scanner;
    private Ennemi ennemi;


    /**
     * @param pointDeVieActuelle les points de vie de l'ennemi
     * @param pointDattaque      les points dont il dispose pour attaquer
     * @param name               le nom de l'ennemi
     */
    public Ennemi(int pointDeVieActuelle, int pointDattaque, String name) {
        this.pointDeVieActuelle = pointDeVieActuelle;
        this.pointDattaque = pointDattaque;
        this.name = name;
        this.scanner = new Scanner(System.in);
    }

    /**
     * @param personnage le type de personnage (guerrier, magicien)
     *                   Déclenche le combat
     */
    public void action(Personnage personnage) {
    }


    /* ****************** Getter et Setter ********************/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPointDattaque() {
        return pointDattaque;
    }

    public void setPointDattaque(int pointDattaque) {
        this.pointDattaque = pointDattaque;
    }

    public int getPointDeVieActuelle() {
        return pointDeVieActuelle;
    }

    public void setPointDeVieActuelle(int pointDeVieActuelle) {
        this.pointDeVieActuelle = pointDeVieActuelle;
    }

    public Ennemi getEnnemi() {
        return ennemi;
    }

    public void setEnnemi(Ennemi ennemi) {
        this.ennemi = ennemi;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

}
