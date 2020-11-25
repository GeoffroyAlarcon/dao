package fr.demos.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import fr.demos.model.Personne;
import fr.demos.model.PersonneDao;

public class Main {
	public static void main(String[] args) {
		Personne zlatan = new Personne(2, "Ibrahimovic", "Zlatan");

		PersonneDao personneDao = new PersonneDao();
		personneDao.findById(5);
	}

}// fin de la classe
