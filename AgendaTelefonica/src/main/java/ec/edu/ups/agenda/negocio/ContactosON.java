package ec.edu.ups.agenda.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ec.edu.ups.agenda.dao.PersonaDAO;
import ec.edu.ups.agenda.dao.TelefonoDAO;
import ec.edu.ups.agenda.modelo.PersonaEN;
import ec.edu.ups.agenda.modelo.TelefonoEN;

@Stateless
public class ContactosON implements  ContactosONRemoto {

	PersonaDAO personaDAO = new PersonaDAO();
	TelefonoDAO telefonoDAO = new TelefonoDAO();

	PersonaEN p = new PersonaEN();
	TelefonoEN t = new TelefonoEN();
	public void guardarPersona(String nombre, String apellido, String cedula) throws Exception {

		if(validadorDeCedula(cedula)){
			p.setCedula(cedula);
			p.setNombre(nombre);
			p.setApellido(apellido);
			personaDAO.insertarPersona(p);
			
		}
		else
			throw new Exception("Cedula incorrecta");
	}
	

	public void guardarTelefono(String codigo, String numero, String tipo, String cedula) throws Exception {
		t.setCodigo(codigo);
		t.setNumero(numero);
		t.setTipo(tipo);
		t.setCedulap(cedula);
		telefonoDAO.insertarTelefonos(t);
	}

	public List<String> listarContactos() throws Exception {

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
		
	}
}
