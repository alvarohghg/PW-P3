<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.user.Usuario, es.uco.pw.data.dao.UsuarioDAO, es.uco.pw.business.user.GestorUsuario,
	 java.time.LocalDate, java.util.Date, java.sql.*, java.util.* " %>
	 
	 <% String correo = request.getParameter("correo");
	%>
	 
	 <%	UsuarioDAO UDAO=new UsuarioDAO();
		Usuario user = new Usuario();
		GestorUsuario GU =new GestorUsuario();
		ArrayList<Usuario> ListaUsuarios = new ArrayList<Usuario>();
		ListaUsuarios=UDAO.obtenerUsuarios();
	%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Espectador</title>
		<!-- Declaración del estilo-->
		<style>
			table {
			  border-collapse: collapse;
			  width: 50%;
			  
			}
			button {
			  background-color: #bd7df280;
			  border: none;
			  color: black;
			  padding: 4px;
			  text-align: center;
			  text-decoration: none;
			  display: inline-block;
			  font-size: 13.3px;
			  margin: 1px 1px;
			  cursor: pointer;
			}
			.button1 {
			 	padding: 5vm;
				text-align: center;
				border-radius: 8px;
			}
			
			
			body {
			  background-image: url(" https://i.imgur.com/l4nKkCG.png");
			  background-repeat: no-repeat;
			  background-attachment: fixed;  
			  background-size: cover;
			}
			

		</style>
	</head>
	<body>
		<!-- Contenedor (div) para introducir la lista-->
		<!-- Tabla que usaremos como lista-->
		<div align="center">
        
			<form method="post" action="BuscarEspect.jsp">
			    	<button class="button button1" type=submit value=<%= correo %> id="correo" name="correo">Buscar Espectaculo</button>
			</form>	<br>
			<form method="post" action="PubliCrit.jsp">
			    	<button class="button button1" type=submit value=<%= correo %> id="correo" name="correo">Publicar critica</button>
			</form>	<br>
			<form method="post" action="ConsultarCritica.jsp">
			    	<button class="button button1" type=submit value=<%= correo %> id="correo" name="correo">Consultar critica</button>
			</form>	<br>
			<form method="post" action="ValorarCritica.jsp">
			    	<button class="button button1" type=submit value=<%= correo %> id="correo" name="correo">Valorar critica</button>
			</form>	<br>
			<form method="post" action="EliminarCritica.jsp">
			    	<button class="button button1" type=submit value=<%= correo %> id="correo" name="correo">Eliminar critica</button>
			</form>	<br>
			<a  href="/aaaa/index.jsp">
				    <button class="button button1" type="button">Desconectar</button>
			</a>
		</div>
	</body>
</html>
