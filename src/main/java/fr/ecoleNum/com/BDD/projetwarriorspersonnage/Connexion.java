package fr.ecoleNum.com.BDD.projetwarriorspersonnage;

import java.sql.*;

public class Connexion {
    //$dbh = new PDO('mysql:host=localhost;dbname=boutique_BDD', $username, $password);
    private String userName = "iteration3";
    private String password = "iteration3";
    private String typeBDD = "jdbc:mysql://localhost/projetWarriors";
    private Connection connexionClassConnection;
    Statement statement = null;
    String requete = "SELECT * FROM Hero;";
    ResultSet resultat = null;
   // List<Personnage> personnage=new ArrayList<>();

    public Connection connectionBDD() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connexionClassConnection = DriverManager.getConnection(typeBDD, userName, password);
        return connexionClassConnection;
    }

//    public void faireRequete() throws SQLException, ClassNotFoundException {
//
//        try {
//            connectionBDD();
//            statement = connexionClassConnection.createStatement();
//            // resultat=statement.executeQuery(requete);
//            resultat = statement.executeQuery("show databases;");
//            resultat = statement.executeQuery("SELECT * FROM Hero;");
//            System.out.println("Connected");
//            System.out.println(resultat);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void afficherRequete() throws SQLException, ClassNotFoundException {
//        faireRequete();
//        while (resultat.next()){
//            String type=resultat.getString("Type");
//            String nom=resultat.getString("Nom");
//            int niveauVie=resultat.getInt("NiveauVie");
//            int niveauForce=resultat.getInt("NiveauForce");
//            System.out.println("Type "+ type);
//            System.out.println("nom " + nom);
//            System.out.println("Niveau Force " + niveauForce);
//            System.out.println("Niveau vie " + niveauVie);
//        }
//    }




}
