package com.BDD.projetwarriorspersonnage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Requete {
    String requete="SELECT * FROM Hero;";
    Connexion connect=new Connexion();
    Statement statement=null;



    ResultSet resultat=null;


    public void faireRequete() throws SQLException {
        connect.connectionBDD();
        try{
            statement =connect.createStatement();
            resultat=statement.executeQuery(requete);
            System.out.println(resultat);
        }catch (SQLException e){

        }
    }

    public ResultSet getResultat() {
        return resultat;
    }

    public void setResultat(ResultSet resultat) {
        this.resultat = resultat;
    }
}
