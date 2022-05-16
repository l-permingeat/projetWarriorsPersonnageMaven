//package fr.ecoleNum.com.BDD.projetwarriorspersonnage;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class Requete {
//    private Connexion connect;
//    private ResultSet resultat;
//    Statement statement;
//
//    public Requete() {
//        this.connect = new Connexion();
//        this.resultat = null;
//        this.statement = null;
//    }
//
//    public void requeteGet() throws SQLException, ClassNotFoundException {
//        try {
//            connect.connectionBDD();
//            statement = connect.connectionBDD().createStatement();
//            resultat = statement.executeQuery("SELECT * FROM Hero;");
//            // resultat = statement.executeQuery("show databases;");
//            // resultat = statement.executeQuery("SELECT * FROM Hero;");
//            System.out.println("Connected");
//            System.out.println(resultat);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void afficherRequete() throws SQLException, ClassNotFoundException {
//        requeteGet();
//        while (resultat.next()) {
//            String type = resultat.getString("Type");
//            String nom = resultat.getString("Nom");
//            int niveauVie = resultat.getInt("NiveauVie");
//            int niveauForce = resultat.getInt("NiveauForce");
//            System.out.println("Type " + type);
//            System.out.println("nom " + nom);
//            System.out.println("Niveau Force " + niveauForce);
//            System.out.println("Niveau vie " + niveauVie);
//        }
//    }
//
//
//
//
//
//    public Connexion getConnect() {
//        return connect;
//    }
//
//    public void setConnect(Connexion connect) {
//        this.connect = connect;
//    }
//
//
//}
