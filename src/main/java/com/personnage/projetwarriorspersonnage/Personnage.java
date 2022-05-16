package com.personnage.projetwarriorspersonnage;

import com.equipement.projetwarriorspersonnage.Equipement;

public abstract class Personnage { //todo mettre en abstract puis faire un overide dans les enfants. A creuser.
    private String name;
    private String defense;
    private int forceActuelle;
    private int forceMax;
    private int vieActuelle;
    private int vieMax;
    private String image;
    private Equipement equipement;


    /**
     * @param name:         nom du personnage
     * @param forceActuelle :
     * @param forceMax      : force maximum
     * @param vieActuelle   : initialisé en dur
     * @param vieMax        : vie maximum
     * @param image         :
     */
    public Personnage(String name, int forceActuelle, int forceMax, int vieActuelle, int vieMax, String image) {
        this.name = name;
        this.forceActuelle = forceActuelle;
        this.forceMax = forceMax;
        this.vieActuelle = vieActuelle;
        this.vieMax = vieMax;
        this.image = image;
    }


    /* ****************** Getter et Setter ********************/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public int getForceActuelle() {
        return forceActuelle;
    }

    public void setForceActuelle(int forceActuelle) {
        this.forceActuelle = forceActuelle;
    }

    public int getForceMax() {
        return forceMax;
    }

    public void setForceMax(int forceMax) {
        this.forceMax = forceMax;
    }

    public int getVieActuelle() {
        return vieActuelle;
    }

    public void setVieActuelle(int newVieActuelle) {
        this.vieActuelle = newVieActuelle;
    }

    public int getVieMax() {
        return vieMax;
    }

    public void setVieMax(int vieMax) {
        this.vieMax = vieMax;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    /* ****************** return ********************/

    public String toString() {
       // return getContenu();
        return this.getClass().getSimpleName() + "\nSon nom : "+name+" \nSa force actuelle : "+forceActuelle+" \nSa force max : "+forceMax+" \nSa vie actuelle : "+vieActuelle+" \nSa vie max : "+vieMax;
    }
}//fin class Personnage
