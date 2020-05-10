package ec.edu.ups.agenda.vista;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import ec.edu.ups.agenda.modelo.PersonaEN;
import ec.edu.ups.agenda.negocio.ContactosON;
import ec.edu.ups.agenda.negocio.ContactosONLocal;

/**
 * Servlet implementation class ClienteWeb
 */
@WebServlet("/ClienteWeb")
public class ClienteWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContactosONLocal on;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteWeb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		try {
			
			String nombre="Gladys";
			String apellido="Feijoo";
			String cedula="1710301001";
			String codigo="222";
			String numero="222222";
			String tipo= "fijo";
			on.guardarPersona(nombre, apellido, cedula, codigo, numero, tipo);
			


			//List<String> lista=  on.listarContactos();
			//response.getWriter().append(lista.toString());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String cedula = "0104568001";
			String nombre="Fercho";
			String apellido="Feijo";
		
			int cod=1;
			String codigo="414";
			String numero="111111111111111";
			String tipo= "movil";

			on.actualizarPersona(cod, cedula ,nombre, apellido, codigo, numero, tipo);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		/*try {
			List<PersonaEN> lista = on.listarContactos();
			response.getWriter().append(lista.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
