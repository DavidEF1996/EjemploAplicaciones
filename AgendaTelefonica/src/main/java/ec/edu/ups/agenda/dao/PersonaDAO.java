package ec.edu.ups.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import ec.edu.ups.agenda.modelo.PersonaEN;
import ec.edu.ups.agenda.modelo.TelefonoEN;
import ec.edu.ups.agenda.utilidades.ConexionBD;


public class PersonaDAO extends ConexionBD {

	Connection con;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement st = null;

	public void insertarPersona(PersonaEN p) throws Exception {

		con = getConnection();

		String sql = "INSERT INTO persona ( cedulaP, nombreP, apellidoP)" + "VALUES (?,?,?);";

		try {

			ps = con.prepareStatement(sql);

			ps.setString(1, p.getCedula());
			ps.setString(2, p.getNombre());
			ps.setString(3, p.getApellido());
			ps.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			throw new SQLException("SQL STATE: " + se.getSQLState() + "\n" + "ERROR CODE: " + se.getErrorCode() + "\n"
					+ "MESSAGE: " + se.getMessage());
		}

	}

	public void ActualizarPersona(PersonaEN p, TelefonoEN t, String cedula) throws Exception {

		con = getConnection();

		String sql = "update  persona  set nombrep=?, apellidop=? where cedulap = " + cedula;
		String sql2 = "update  telefonos  set codigo=?, numero=?, tipo=? where cedulap = " + cedula;
		System.out.println(sql2);

		try {

			ps = con.prepareStatement(sql);
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApellido());
			ps.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			throw new SQLException("SQL STATE: " + se.getSQLState() + "\n" + "ERROR CODE: " + se.getErrorCode() + "\n"
					+ "MESSAGE: " + se.getMessage());
		}

		try {

			ps = con.prepareStatement(sql2);
			ps.setString(1, t.getCodigo());
			ps.setString(2, t.getNumero());
			ps.setString(3, t.getTipo());
			ps.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			throw new SQLException("SQL STATE: " + se.getSQLState() + "\n" + "ERROR CODE: " + se.getErrorCode() + "\n"
					+ "MESSAGE: " + se.getMessage());
		}

	}

	public void eliminarContacto(String cedula) throws Exception {
		con = getConnection();
		int res = 0;

		String sql = "delete from persona where cedulap =" + cedula;
		String sql2 = "delete from telefonos where cedulap = " + cedula;
		try {
			ps = con.prepareStatement(sql2);
			ps.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			throw new SQLException("SQL STATE: " + se.getSQLState() + "\n" + "ERROR CODE: " + se.getErrorCode() + "\n"
					+ "MESSAGE: " + se.getMessage());
		}

		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			throw new SQLException("SQL STATE: " + se.getSQLState() + "\n" + "ERROR CODE: " + se.getErrorCode() + "\n"
					+ "MESSAGE: " + se.getMessage());
		}

	}

}
