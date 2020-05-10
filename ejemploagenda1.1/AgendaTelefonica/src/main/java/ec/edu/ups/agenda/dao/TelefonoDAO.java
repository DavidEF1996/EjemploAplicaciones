package ec.edu.ups.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.agenda.modelo.PersonaEN;
import ec.edu.ups.agenda.modelo.TelefonoEN;
import ec.edu.ups.agenda.utilidades.ConexionBD;


@Stateless
public class TelefonoDAO extends ConexionBD {
	Connection con;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement st = null;

	
	@PersistenceContext(name="AgendaTelefonicaPersistenceUnit")
	private EntityManager tn;
	
	public void insertarTelefonos(TelefonoEN t) throws Exception{
		
		tn.persist(t);

	}
	public TelefonoEN read( int codigo ) {
		return tn.find(TelefonoEN.class, codigo);
	}

	public void delete(int codigo) {
		String jpql = "SELECT p FROM PersonaEN p";
		//TelefonoEN t = new TelefonoEN();
		TelefonoEN t = read(codigo);
		tn.remove(t);
		

	}
	
	/*public List<TelefonoEN> getTelefonos(String cedula ){
		String jpql = "SELECT p FROM TelefonoEN p where p.cedula_fk";
		
		Query q = en.createQuery(jpql, PersonaEN.class);
		
		return q.getResultList();
	}

	/*public List<String> listarContactos(String filtro) throws Exception {
		PersonaEN p = new PersonaEN();
		TelefonoEN t = new TelefonoEN();
		String jpql = "SELECT p, t FROM PersonaEN p, TelefonoEN t"
				+ "WHERE p.cedula = t.persona and p.cedula LIKE :filtro";
		Query q= tn.createQuery(jpql, PersonaEN.class);
		q.setParameter("filtro", filtro + "%");
		return q.getResultList();
		
	
	}

	
	/*public List<String> listarContactosPorCedula(String cedula) throws Exception {
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
	}*/
	
	
	
	
}
