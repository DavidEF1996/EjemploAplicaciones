package ec.edu.ups.agenda.negocio;

import java.util.List;

import javax.ejb.Remote;
import javax.swing.JTable;
import javax.swing.JTextField;



@Remote
public interface ContactosONRemoto {



		
		public void guardarPersona(String nombre, String apellido, String cedula) throws Exception;
		
		public void guardarTelefono(String codigo, String numero,  String tipo, String cedula) throws Exception;
		
		public List<String> listarContactos() throws Exception;
		
		public List<String> listarContactosPorCedula(String cedula) throws Exception;
		
		public void actualizarPersona(String nombre, String apellido, String codigo, String numero, String tipo, String cedula) throws Exception;
		
		public void eliminarContacto(String cedula) throws Exception;
		
		public boolean validadorDeCedula(String cedula) throws Exception;
		
		public void limpiarCampos(JTable table , JTextField txtNombre,JTextField txtApellido, JTextField txtCedula, 
				JTextField txtNumeroTelefonico);
	

}
