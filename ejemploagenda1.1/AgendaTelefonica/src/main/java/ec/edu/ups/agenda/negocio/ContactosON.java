package ec.edu.ups.agenda.negocio;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ec.edu.ups.agenda.dao.PersonaDAO;
import ec.edu.ups.agenda.dao.TelefonoDAO;
import ec.edu.ups.agenda.modelo.PersonaEN;
import ec.edu.ups.agenda.modelo.TelefonoEN;

@Stateless
public class ContactosON implements  ContactosONRemoto, ContactosONLocal, Serializable{
	private static final long SerialVersionUID = 1L;
	@Inject
	PersonaDAO personaDAO;
	@Inject
	TelefonoDAO telefonoDAO;
	



	public void guardarPersona(String nombre, String apellido, String cedula, String codigo, String numero, String tipo) throws Exception {
		// TODO Auto-generated method stub
		PersonaEN p = new PersonaEN();
		TelefonoEN t = new TelefonoEN();
	
			p.setCedula(cedula);
			p.setNombre(nombre);
			p.setApellido(apellido);
			
			
			t.setCodigo_operadora(codigo);
			t.setNumero(numero);
			t.setTipo(tipo);
			t.setPersona(p);
			
			telefonoDAO.insertarTelefonos(t);
			
			
			personaDAO.insertarPersona(p);
			
	
		
		
	}

	public void actualizarPersona(int cod, String cedula,String nombre, String apellido, String codigo, String numero, String tipo) throws Exception {
		PersonaEN p = new PersonaEN();
		TelefonoEN t = new TelefonoEN();
		p.setCedula(cedula);
		p.setNombre(nombre);
		p.setApellido(apellido);
		t.setCodigo(cod);
		t.setCodigo_operadora(codigo);
		t.setNumero(numero);
		t.setPersona(p);
		t.setTipo(tipo);
		personaDAO.ActualizarPersona(p, t);
		
	}
	
	public List<Object> listarContactos()  throws Exception {
		
		List<PersonaEN> personas = personaDAO.getPersonas();
		List<Object> listado = new ArrayList<Object>();
		
		for(PersonaEN persona:personas) {
			
			System.out.println("Persona" + persona);
			
			int index = persona.getTelefonos().size();
			int contador = 0;
			
			
			try {
				for(TelefonoEN tel: persona.getTelefonos()) {
					List<String> contactos = new ArrayList<String>();
					contactos.add(persona.getCedula());
					contactos.add(persona.getNombre());
					contactos.add(persona.getApellido());
					contactos.add(tel.getNumero());
					contactos.add(tel.getTipo());
					contactos.add(tel.getCodigo_operadora());
				
					listado.add(contactos);
				}
			}catch (Exception e) {
				
			}
			}

		return listado;

	}
	
	public void guardarOtroTelefono (String cedula, String codigo, String numero, String tipo) throws Exception {
		
		PersonaEN p = new PersonaEN();
		TelefonoEN t = new TelefonoEN();
		p.setCedula(cedula);
		
		t.setCodigo_operadora(codigo);
		t.setNumero(numero);
		t.setTipo(tipo);
		t.setPersona(p);
		
		telefonoDAO.insertarTelefonos(t);
		
	}
	
	public void eliminarContacto(String cedula)  {

			personaDAO.delete(cedula);
		
		
	}
	
	
	
	
	//@Override
	/*public void guardarPersona(String nombre, String apellido, String cedula, String codigo, String numero, String tipo)
			throws Exception {
		// TODO Auto-generated method stub
		PersonaEN p = new PersonaEN();
		TelefonoEN t = new TelefonoEN();
		if(validadorDeCedula(cedula)){
			p.setCedula(cedula);
			p.setNombre(nombre);
			p.setApellido(apellido);
			
			t.setCodigo_operadora(codigo);
			t.setNumero(numero);
			t.setTipo(tipo);
			t.setPersona(p);
			
			p.setTelefonos((List<TelefonoEN>) t);
			personaDAO.insertarPersona(p);
			
		}
		else
			throw new Exception("Cedula incorrecta");
		
	}

	/*public List<String> listarContactos() throws Exception {

		return telefonoDAO.listarContactos();

	}

	public List<String> listarContactosPorCedula(String cedula) throws Exception {

		return telefonoDAO.listarContactosPorCedula(cedula);

	}

	public void actualizarPersona(String nombre, String apellido, String codigo, String numero, String tipo, String cedula) throws Exception {
		p.setNombre(nombre);
		p.setApellido(apellido);
		t.setCodigo(codigo);
		t.setNumero(numero);
		t.setTipo(tipo);
		personaDAO.ActualizarPersona(p, t, cedula);
	}

	public void eliminarContacto(String cedula) throws Exception {
		personaDAO.eliminarContacto(cedula);
	}
	
	
	public boolean validadorDeCedula(String cedula) throws Exception {
        boolean cedulaCorrecta = false;

        try {

            if (cedula.length() == 10) 
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {

                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)&& (suma != 0)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                     
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception e) {
            e.printStackTrace();
        	
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
           // JOptionPane.showMessageDialog(null, "Cedula Ingresada es Incorrecta");
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        
        return cedulaCorrecta;
     
    }
	public void limpiarCampos(JTable table , JTextField txtNombre,JTextField txtApellido, JTextField txtCedula, 
			JTextField txtNumeroTelefonico){
		DefaultTableModel modeloDefault = (DefaultTableModel) table.getModel();

		for (int i = table.getRowCount() - 1; i >= 0; i--) {
			modeloDefault.removeRow(i);
		}
		txtNombre.setText("");
		txtApellido.setText("");
		txtCedula.setText("");
		txtNumeroTelefonico.setText("");
		
	}*/



}
