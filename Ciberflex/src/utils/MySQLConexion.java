package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	public static Connection getConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//Carga el Driver MySql
			String url = "jdbc:mysql://localhost/CIBERFLEX";//El nombre de la BD despues del Localhost
			String usr = "root";//El usuario root del mysql
			String psw = "";//La contraseña del usuario root
			con = DriverManager.getConnection(url, usr, psw);//Conexion con la base de datos
		} catch (ClassNotFoundException ex) {
			System.out.println("Error >> Driver no Instalado!!");
		} catch (SQLException ex) {
			System.out.println("Error >> de conexión con la BD");
		}
		return con;
	}

}
