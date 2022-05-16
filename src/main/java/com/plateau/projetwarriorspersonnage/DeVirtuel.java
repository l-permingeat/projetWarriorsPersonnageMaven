package com.plateau.projetwarriorspersonnage;
import java.util.Random;

public class DeVirtuel {
    private int nbFaces;

    /**
     *
     * @param nbFaces pour choisir combien de face à notre dé
     */
    public DeVirtuel(int nbFaces){
        this.nbFaces = nbFaces;
    }

    /**
     *
     * @return un résultat random qui correspond à la valeur du dé
     */
    public int lancerDe() {
        Random random = new Random();
        return random.nextInt(this.nbFaces + 1) + 1;
    }
}

