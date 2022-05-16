package fr.ecoleNum.com.BDD.projetwarriorspersonnage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RequeteTest {

    private String requete = "SELECT * FROM Hero;";
    private Connexion connect = new Connexion();
    private ResultSet resultat = null;
    // private Connection connexion;
    Statement statement = null;


    public void faireRequete() throws SQLException, ClassNotFoundException {
        try {
            connect.connectionBDD();
            statement = connect.connectionBDD().createStatement();
            resultat = statement.executeQuery(requete);
            // resultat = statement.executeQuery("show databases;");
            // resultat = statement.executeQuery("SELECT * FROM Hero;");
            System.out.println("Connected");
            System.out.println(resultat);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afficherRequete() throws SQLException, ClassNotFoundException {
        faireRequete();
        while (resultat.next()) {
            String type = resultat.getString("Type");
            String nom = resultat.getString("Nom");
            int niveauVie = resultat.getInt("NiveauVie");
            int niveauForce = resultat.getInt("NiveauForce");
            System.out.println("Type " + type);
            System.out.println("nom " + nom);
            System.out.println("Niveau Force " + niveauForce);
            System.out.println("Niveau vie " + niveauVie);
        }
    }

    public Connexion getConnect() {
        return connect;
    }

    public void setConnect(Connexion connect) {
        this.connect = connect;
    }

}
