package fr.ecoleNum.com.BDD.projetwarriorspersonnage;

import fr.ecoleNum.com.personnage.projetwarriorspersonnage.Personnage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class RequetePersonnage implements Requete {
    private Connexion connect;
    private ResultSet resultat;
    private Statement statement;
    private Map<Integer, String[]> personnageChoix;
    private Map<Integer, String[]> personnageAffectation;
    private int key;
    private String[] value;
    private Personnage personnage;

    /* ***************************** Constructeur ********************************************* */

    public RequetePersonnage() {
        this.connect = new Connexion();
        this.resultat = null;
        this.statement = null;
        this.personnageChoix = new HashMap<>();
        this.personnageAffectation = new HashMap<>();
        this.personnage = personnage;
    }

    /* ***************************** Requete de tous les personnages ********************************************* */

    /**
     * Permet de faire une requete global sur la la table HeroChoice
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void requeteGet() throws SQLException, ClassNotFoundException {
        try {
            connect.connectionBDD();
            statement = connect.connectionBDD().createStatement();
            resultat = statement.executeQuery("SELECT * FROM HeroChoice;");
            // resultat = statement.executeQuery("show databases;");
            // resultat = statement.executeQuery("SELECT * FROM Hero;");
            //  System.out.println("Connected");
            // System.out.println(resultat);
            connect.close(connect.connectionBDD());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void requetePost() throws SQLException, ClassNotFoundException {

    }


    /* ***************************** Affiche tous les personnage ********************************************* */

    /**
     * Met en forme et affiche le résulat de la méthode requeteGet
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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


    /**
     * Fait une requête sur un ID d'un personnage et instancie un nouveau personnage
     *
     * @param key
     * @throws SQLException
     * @throws NoSuchMethodException
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public void affecationPersonnageBdd(int key) throws SQLException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            connect.connectionBDD();
            statement = connect.connectionBDD().createStatement();
            resultat = statement.executeQuery("SELECT * FROM HeroChoice WHERE id=" + key + ";");
            connect.close(connect.connectionBDD());
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

    /* ***************************** Autre fonction ********************************************* */


    public void requetePostPerso(Personnage personnage) throws SQLException, ClassNotFoundException {
        try {
          //  System.out.println("methode requete " + personnage);
            connect.connectionBDD();
            PreparedStatement preparedStatement = connect.connectionBDD().prepareStatement("INSERT INTO Hero(Type,Nom, NiveauVie,NiveauForce,Equipement) VALUES(?,?,?,?,?);");
            preparedStatement.setString(1, personnage.getClass().getSimpleName());
            preparedStatement.setString(2, personnage.getName());
            preparedStatement.setInt(3, personnage.getVieActuelle());
            preparedStatement.setInt(4, personnage.getForceActuelle());
            if (personnage.getEquipement() == null) {
                preparedStatement.setString(5, "Default");
            } else {
                preparedStatement.setInt(5, personnage.getEquipement().getNiveauAttaque());
            }

            System.out.println("Votre personnage a été enregistré dans la BDD");
            preparedStatement.executeUpdate();

            connect.close(connect.connectionBDD());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void requeteDelete() throws SQLException, ClassNotFoundException {

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
