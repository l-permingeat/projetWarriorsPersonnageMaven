package fr.ecoleNum.com.BDD.projetwarriorspersonnage;

import java.sql.*;

public class Connexion {
    //$dbh = new PDO('mysql:host=localhost;dbname=boutique_BDD', $username, $password);
    private String userName = "iteration3";
    private String password = "iteration3";
    private String typeBDD = "jdbc:mysql://localhost/projetWarriors";
    private Connection connexionClassConnection;

    /**
     * Permet de se connecter à la BDD
     *
     * @return l'accés à la BDD
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Connection connectionBDD() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connexionClassConnection = DriverManager.getConnection(typeBDD, userName, password);
        return connexionClassConnection;
    }

    /**
     * Deconnexion de la BDD
     * @param connection connection à la BDD
     */

    public void close(Connection connection) {
        if (connection != null) {
            try {
                //Déconnexion de la connexion DB
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
