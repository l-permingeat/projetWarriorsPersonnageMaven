package fr.ecoleNum.com.BDD.projetwarriorspersonnage;

import fr.ecoleNum.com.personnage.projetwarriorspersonnage.Personnage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Requete {
    private Connexion connect;
    private ResultSet resultat;
    private Statement statement;
    private Map<Integer, String[]> personnageChoix;
    private Map<Integer, String[]> personnageAffectation;
    private int key;
    private String[] value;
    private Personnage personnage;

    /* ***************************** Constructeur ********************************************* */

    public Requete() {
        this.connect = new Connexion();
        this.resultat = null;
        this.statement = null;
        this.personnageChoix = new HashMap<>();
        this.personnageAffectation = new HashMap<>();
        this.personnage = personnage;
    }


    /* ***************************** Requete de tous les personnages ********************************************* */

    public void requeteGet() throws SQLException, ClassNotFoundException {
        try {
            connect.connectionBDD();
            statement = connect.connectionBDD().createStatement();
            resultat = statement.executeQuery("SELECT * FROM HeroChoice;");
            // resultat = statement.executeQuery("show databases;");
            // resultat = statement.executeQuery("SELECT * FROM Hero;");
            //  System.out.println("Connected");
            // System.out.println(resultat);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /* ***************************** Affiche tous les personnage ********************************************* */

    public void afficherRequete() throws SQLException, ClassNotFoundException {
        requeteGet();

        while (resultat.next()) {
            String type = resultat.getString("Type");
            String nom = resultat.getString("Nom");
            String[] infoPersonnage = {nom, type};
            int id = resultat.getInt("id");
            personnageChoix.put(id, infoPersonnage);
        }

        for (Map.Entry<Integer, String[]> entry : personnageChoix.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            System.out.println(" id : " + key + ", name : " + value[0] + ", type :" + value[1]);
        }
    }

    /* ***************************** Retourne un nouveau personnage ********************************************* */



    public void affecationPersonnageBdd(int key) throws SQLException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            connect.connectionBDD();
            statement = connect.connectionBDD().createStatement();
            resultat = statement.executeQuery("SELECT * FROM HeroChoice WHERE id=" + key + ";");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        while (resultat.next()) {
            String type = resultat.getString("Type");
            String nom = resultat.getString("Nom");
            String[] infoPersonnage = {nom, type};
            int id = resultat.getInt("id");
            personnageAffectation.put(id, infoPersonnage);
        }

        for (Map.Entry<Integer, String[]> entry : personnageAffectation.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            System.out.println(" id : " + key + ", name : " + value[0] + ", type :" + value[1]);
        }
        Class classe = Class.forName("fr.ecoleNum.com.personnage.projetwarriorspersonnage." + value[1]);
        Constructor cons = classe.getConstructor(String.class);
        personnage = (Personnage) cons.newInstance(value[0]);
    }



    /* ***************************** Getter et Setter ********************************************* */

    public ResultSet getResultat() {
        return resultat;
    }

    public void setResultat(ResultSet resultat) {
        this.resultat = resultat;
    }

    public Connexion getConnect() {
        return connect;
    }

    public void setConnect(Connexion connect) {
        this.connect = connect;
    }

    public String[] getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Map<Integer, String[]> getPersonnageChoix() {
        return personnageChoix;
    }

    public void setPersonnageChoix(Map<Integer, String[]> personnageChoix) {
        this.personnageChoix = personnageChoix;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }


}
