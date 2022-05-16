package com.BDD.projetwarriorspersonnage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    //$dbh = new PDO('mysql:host=localhost;dbname=boutique_BDD', $username, $password);
    private String userName="iteration3";
    private String password="iteration3";
    private String typeBDD="mysql:host=localhost;dnname=projetWarriors";
    private Connection connexion;

    public Connection connectionBDD()throws SQLException{
     //   Class.forName("com.mysql.jdbc.Driver");
        connexion= DriverManager.getConnection(typeBDD, userName, password);
        return connexion;
    }

//    public void connexion(String typeBDD, String userName, String password) {
//        try {
//            DriverManager.getConnection(typeBDD, userName, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


}
