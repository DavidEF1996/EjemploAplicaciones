package ec.edu.ups.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.agenda.modelo.PersonaEN;
import ec.edu.ups.agenda.modelo.TelefonoEN;
import ec.edu.ups.agenda.utilidades.ConexionBD;



@Stateless
public class PersonaDAO extends ConexionBD {
	
	@PersistenceContext(name="AgendaTelefonicaPersistenceUnit")
	private EntityManager en;
	

	public void insertarPersona(PersonaEN p) throws Exception {

		en.persist(p);
		
	}

	public void ActualizarPersona(PersonaEN p, TelefonoEN t) throws Exception {
		
		en.merge(p);
		en.merge(t);
	
	}

	public PersonaEN read( String cedula ) {
		return en.find(PersonaEN.class, cedula);
	}

	public void delete(String cedula) {
	
		PersonaEN p = read(cedula);
		en.remove(p);
		

	}
	public List<PersonaEN> getPersonas(){
		String jpql = "SELECT p FROM PersonaEN p";
		
		Query q = en.createQuery(jpql, PersonaEN.class);
		
		return q.getResultList();
	}
	
	

}
