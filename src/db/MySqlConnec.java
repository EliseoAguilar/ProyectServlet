package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnec {

	private Connection connec = null;
	private String server = "localhost:3306";
	private String database = "db_contacs";
	private String user = "root";
	private String password = "";
	private String url = "";

	public MySqlConnec() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://" + server + "/" + database + "?useTimezone=true&serverTimezone=UTC";
			connec = DriverManager.getConnection(url, user, password);
			System.out.println("Conexion a Base de Datos " + url + " . . . . . . Ok");

		} catch (SQLException ex) {
			System.out.println(ex);
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		}
	}

	public Connection getConexion() {
		return connec;
	}

	public void closeConexion() {
		try {
			connec.close();
			connec = null;
			System.out.println("Cerrando conexion a " + url + " . . . . . . Ok");
		} catch (SQLException ex) {
			System.out.println(ex);
		}

	}

}
