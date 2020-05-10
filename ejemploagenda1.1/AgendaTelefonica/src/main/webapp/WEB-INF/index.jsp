<%@page import="javax.swing.JOptionPane"%>
<%@page import="ec.edu.ups.agenda.negocio.ContactosON"%>
<%@page import="ec.edu.ups.agenda.modelo.PersonaEN"%>
<%@page import="ec.edu.ups.agenda.negocio.ContactosON"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="ec.edu.ups.agenda.utilidades.ConexionBD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contactos</title>
</head>
<body>

	<form action="VistaAgenda" method="POST">


		<table>

			<tr>
				<td>ID Persona:</td>
				<td><input type="text" placheholder="Nombre" name="idpersona" /></td>




			</tr>

			<tr>
				<td>Nombre:</td>
				<td><input type="text" placheholder="Nombre" name="nombre" /></td>
			</tr>

			<tr>
				<td>Apellido:</td>
				<td><input type="text" placheholder="Nombre" name="apellido" /></td>
			</tr>

			<tr>
				<td>Cedula:</td>
				<td><input type="text" placheholder="Nombre" name="cedula" /></td>
			</tr>

			<tr>
				<td>
					<button type="submit">Crear Persona</button>


				</td>
			</tr>

			<tr>
				<td>
					<button type="submit">Actualizar Persona</button>
				</td>
			</tr>

			<tr>
				<td>
					<button type="submit">Limpiar</button>
				</td>
			</tr>



			<tr>
				<td>Buscar Persona:</td>
				<td><input type="text" placheholder="Ingrese Cedula"
					name="buscarpersona" /></td>
			</tr>

			<tr>
				<td>
					<button type="submit">Buscar por Cedula</button>
				</td>

			</tr>

		</table>
	</form>
</body>
</html>