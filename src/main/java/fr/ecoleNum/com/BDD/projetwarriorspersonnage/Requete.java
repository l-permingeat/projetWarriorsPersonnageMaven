package fr.ecoleNum.com.BDD.projetwarriorspersonnage;

import com.sun.jdi.connect.Connector;

import java.sql.SQLException;

public interface Requete  {

    void requeteGet() throws SQLException, ClassNotFoundException;

    void requetePost()throws SQLException, ClassNotFoundException;

    void requeteDelete()throws SQLException, ClassNotFoundException;


}
