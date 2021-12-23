<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.user.Usuario, es.uco.pw.data.dao.UsuarioDAO, es.uco.pw.business.user.GestorUsuario,
	 java.time.LocalDate, java.util.Date, java.sql.*, java.util.* " %>
	 
	 <% String correo = request.getParameter("correo");%>
	 <%	UsuarioDAO UDAO=new UsuarioDAO();
		Usuario user = new Usuario();
		GestorUsuario GU =new GestorUsuario();
		GU.guardarBDU();
		Date registro = GU.fechaRegistro(correo);
		
		Date date = new Date(System.currentTimeMillis()) ;
		long timeInMilliSeconds = date.getTime();
		java.sql.Date fecha = new java.sql.Date(timeInMilliSeconds) ;
		%>
	 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Eres espectador</title>
		<!-- Declaración del estilo-->
		<style>
			button {
			  background-color: #bd7df280;
			  border: none;
			  color: black;
			  padding: 20px;
			  text-align: center;
			  text-decoration: none;
			  display: inline-block;
			  font-size: 16px;
			  margin: 4px 2px;
			  cursor: pointer;
			}
			
			.button1 {
				border-radius: 8px;
			}
			body {
			  background-image: url(" https://i.imgur.com/l4nKkCG.png ");
			  background-repeat: no-repeat;
			  background-attachment: fixed;  
			  background-size: cover;
			}
			
		</style>
	</head>
	<body>
		<!-- Contenedor (div) que muestra la informacion-->
		<div style="text-align:center" >
			<h2>Actividad:</h2>
			<p>Fecha actual: <%=fecha%> </p>
			<p>Te registrastes un: <%=registro%></p>
		</div>
		<br>
		<!-- Formulario para enviar mediante el método POST el usuario a modificar a "modificarDatos.jsp"-->
		<div style="text-align:center">
	      <form methon="post" action= "modificarDatos.jsp">
	 		 <button class="button1" type=submit value=<%=correo%> id="correo" name="correo">Modificar datos</button>
			</form>
			<!-- Botón para volver al index -->
          	 	<a  href="/aaaa/index.jsp">
		    	<button class="button button1" type="button">Desconectar</button>
			</a>      
		</div>
		
		
          
	</body>
</html>






