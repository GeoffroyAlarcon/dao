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

		PersonneDao personneDao = new PersonneDao();

		personneDao.findAll();
	}

}// fin de la classe
