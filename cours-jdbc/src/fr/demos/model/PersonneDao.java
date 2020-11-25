package fr.demos.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.demos.config.MyConnection;
import fr.demos.dao.Dao;

public class PersonneDao implements Dao<Personne> {
	@Override
	public Personne save(Personne personne) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into personne (nom,prenom) values (?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, personne.getNom());
				ps.setString(2, personne.getPrenom());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					personne.setNum(resultat.getInt(1));
					return personne;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void remove(Personne personne) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				String request = "DELETE FROM  Personne WHERE num = ?;";
				PreparedStatement ps = c.prepareStatement(request);
				ps.setInt(1, personne.getNum());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Personne update(Personne personne) {
		// TODO Auto-generated method stub
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				String request = "UPDATE personne SET nom= ?, prenom= ?  WHERE num = ?;";
				PreparedStatement ps = c.prepareStatement(request);
				ps.setString(1, personne.getNom());
				ps.setString(2, personne.getPrenom());
				ps.setInt(3, personne.getNum());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Personne findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				String request = "select * from personne where num = ?; ";
				PreparedStatement ps = c.prepareStatement(request);
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();

				if (result.next()) {
					int num = result.getInt(1);
					String nom = result.getString(2);
					String prenom = result.getString(3);
					System.out.println(num + " " + nom + " " + prenom);
				}
				else {
					System.err.println("personne non trouvée ! ");
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public List<Personne> findAll() {
		// TODO Auto-generated method stub
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				Statement statement = c.createStatement();
				String request = "SELECT * FROM Personne;";
				ResultSet result = statement.executeQuery(request);
				while (result.next()) {
					int num = result.getInt(1);
					String nom = result.getString(2);
					String prenom = result.getString(3);
					System.out.println(num + " " + nom + " " + prenom);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
