package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	static final String url = "jdbc:postgresql://localhost:5432/carro";
	static final String user = "postgres";
	static final String password = "admin";

	public static Connection conectar() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;

	}
	
}
