package ec.edu.ups.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import ec.edu.ups.agenda.modelo.PersonaEN;
import ec.edu.ups.agenda.modelo.TelefonoEN;
import ec.edu.ups.agenda.utilidades.ConexionBD;

@Stateless
public class TelefonoDAO extends ConexionBD {
	Connection con;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement st = null;

	public void insertarTelefonos(TelefonoEN t) throws Exception{

		con = getConnection();

		String sql = "INSERT INTO telefonos ( codigo,numero, tipo, cedulap)" + "VALUES (?,?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, t.getCodigo());
			ps.setString(2, t.getNumero());
			ps.setString(3, t.getTipo());
			ps.setString(4, t.getCedulap());

			ps.executeUpdate();

		} catch (SQLException se) {
				se.printStackTrace();
	            throw new SQLException("SQL STATE: " + se.getSQLState()+"\n"+"ERROR CODE: " + se.getErrorCode()
	            +"\n" + "MESSAGE: " + se.getMessage());
	      
	
		}
	}

	public List<String> listarContactos() throws Exception {
		ArrayList<TelefonoEN> datosContacto = new ArrayList<TelefonoEN>();
		ArrayList<PersonaEN> datosPersona = new ArrayList<PersonaEN>();
		List<String> miLista = new ArrayList<String>();

		int cont = 0;
		con = getConnection();

		String sql = "select p.cedulap, p.nombrep, p.apellidop, t.numero, t.tipo, t.codigo from persona p, telefonos t where p.cedulap = t.cedulap";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				TelefonoEN t = new TelefonoEN();
				PersonaEN p = new PersonaEN();
				p.setCedula(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setApellido(rs.getString(3));
				System.out.println("test: "+rs.getString(3));
				t.setNumero(rs.getString(4));
				t.setTipo(rs.getString(5));
				t.setCodigo(rs.getString(6));
				datosPersona.add(p);
				datosContacto.add(t);

			}
			for (int i = 0; i < datosPersona.size(); i++) {
				cont++;
				miLista.add(datosPersona.get(i).getCedula());
				miLista.add(datosPersona.get(i).getNombre());
				miLista.add(datosPersona.get(i).getApellido());
				miLista.add(datosContacto.get(i).getNumero());
				miLista.add(datosContacto.get(i).getTipo());
				miLista.add(datosContacto.get(i).getCodigo());
			}

		} catch (SQLException se) {
			se.printStackTrace();
			throw new SQLException("SQL STATE: " + se.getSQLState()+"\n"+"ERROR CODE: " + se.getErrorCode()
            +"\n" + "MESSAGE: " + se.getMessage());
		}
		return miLista;
	}
	
	public List<String> listarContactosPorCedula(String cedula) throws Exception {
		ArrayList<TelefonoEN> datosContacto = new ArrayList<TelefonoEN>();
		ArrayList<PersonaEN> datosPersona = new ArrayList<PersonaEN>();
		List<String> miLista = new ArrayList<String>();

		int cont = 0;
		con = getConnection();

		String sql = "select p.cedulap, p.nombrep, p.apellidop, t.numero, t.tipo, t.codigo from persona p, telefonos t where "
				+ "p.cedulap = t.cedulap and p.cedulap = '" +cedula+"'";
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				TelefonoEN t = new TelefonoEN();
				PersonaEN p = new PersonaEN();
				p.setCedula(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setApellido(rs.getString(3));
				t.setNumero(rs.getString(4));
				t.setTipo(rs.getString(5));
				t.setCodigo(rs.getString(6));
				datosPersona.add(p);
				datosContacto.add(t);

			}
			for (int i = 0; i < datosPersona.size(); i++) {
				cont++;
				miLista.add(datosPersona.get(i).getCedula());
				miLista.add(datosPersona.get(i).getNombre());
				miLista.add(datosPersona.get(i).getApellido());
				miLista.add(datosContacto.get(i).getNumero());
				miLista.add(datosContacto.get(i).getTipo());
				miLista.add(datosContacto.get(i).getCodigo());
			}

		} catch (SQLException se) {
			se.printStackTrace();
			throw new SQLException("SQL STATE: " + se.getSQLState()+"\n"+"ERROR CODE: " + se.getErrorCode()
            +"\n" + "MESSAGE: " + se.getMessage());
		}
		return miLista;
	}
	
	
	
	
}
