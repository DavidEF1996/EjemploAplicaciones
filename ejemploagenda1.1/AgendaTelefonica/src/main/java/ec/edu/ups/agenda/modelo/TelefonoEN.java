package ec.edu.ups.agenda.modelo;

import java.awt.Window.Type;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import javassist.SerialVersionUID;

@Entity
public class TelefonoEN implements Serializable {
	
	private static final long SerialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_telefono")
	private int codigo;
	
	@Column(name = "cod_operadora_telefono")
	private String codigo_operadora;
	
	@Column(name = "numero_telefono")
	private String numero;
	
	@Column(name = "tipo_telefono")
	private String tipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_persona")
	private PersonaEN persona;
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCodigo_operadora() {
		return codigo_operadora;
	}

	public void setCodigo_operadora(String codigo_operadora) {
		this.codigo_operadora = codigo_operadora;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public PersonaEN getPersona() {
		return persona;
	}

	public void setPersona(PersonaEN persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "TelefonoEN [codigo=" + codigo + ", codigo_operadora=" + codigo_operadora + ", numero=" + numero
				+ ", tipo=" + tipo + "]";
	}

	
	
	
	
	
	
}
