package ec.edu.ups.agenda.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConexionBD {

	static Connection con = null;

	static final String URL = "jdbc:postgresql://localhost:5432/tareaunoaplicaciones";
	static final String USER = "postgres";
	static final String PASS = "cuenca";
	public ConexionBD() {

		try {
			Class.forName("org.postgresql.Driver").newInstance();
			con = DriverManager.getConnection(URL, USER, PASS);
			
			System.out.println("conexion exitosa");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de conexion" + e);
		}

	}

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return con;
	}

	public static void close(Connection c) {
		// TODO Auto-generated method stub
		
	}



}
