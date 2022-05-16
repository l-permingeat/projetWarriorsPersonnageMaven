package com.plateau.projetwarriorspersonnage;

import com.personnage.projetwarriorspersonnage.Personnage;

import java.util.Scanner;

public class VideCellule implements Cellule {

    Scanner scanner;

    public VideCellule() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void action(Personnage personnage) {
        System.out.println("Cette case est vide. Voulez vous continuer ? Taper 1\nSinon taper 2 ");
        if (getScanner().nextInt() == 2) {
            System.out.println("A bientôt !");
            System.exit(1);
        } else {
            System.out.println("C'est reparti pour un tour !");
        }
    }


    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

}
