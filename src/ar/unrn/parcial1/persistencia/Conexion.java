package ar.unrn.parcial1.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/parcial1ob2";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";

	public static Connection conexion() throws ClassNotFoundException, SQLException {

		Connection conexion = null;

		try {

			Class.forName(CONTROLADOR);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("Error al cargar el controlador");

		} catch (SQLException e) {
			throw new SQLException("Error en la conexion");
		}

		return conexion;
	}
}
