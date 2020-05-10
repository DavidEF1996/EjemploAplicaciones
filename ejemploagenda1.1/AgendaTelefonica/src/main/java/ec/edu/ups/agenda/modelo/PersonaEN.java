package ec.edu.ups.agenda.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PersonaEN  implements Serializable{

	private static final long SerialVersionUID = 1L;
	
	@Id
	@Column(name = "cedula_persona")
	private String cedula;
	
	@Column(name = "nombre_persona")
	private String nombre;
	
	@Column(name = "apellido_persona")
	private String apellido;
	

	@OneToMany(mappedBy = "persona", fetch = FetchType.EAGER, orphanRemoval=true)
	private List<TelefonoEN> telefonos;
	
	
	
	

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<TelefonoEN> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<TelefonoEN> telefonos) {
		this.telefonos = telefonos;
	}

	@Override
	public String toString() {
		return "PersonaEN [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", telefonos="
				+ telefonos + "]";
	}


	
}