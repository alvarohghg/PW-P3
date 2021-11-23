<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import ="es.uco.pw.business.user.Usuario, es.uco.pw.data.dao.UsuarioDAO, es.uco.pw.business.user.GestorUsuario,
 java.time.LocalDate, java.util.Date, java.sql.*, java.util.* " %>
 <% String correo = request.getParameter("correo"); %>   
    
    
 <!DOCTYPE html>
<html>
	<head>
	<title>Modificar datos</title>
	<!-- Declaración del estilo-->
	<style>
			form,h2,p {
				 text-align:center;
			}
			input[type=text]{

			  padding: 12px 20px;
			  margin: 8px 0;
			  box-sizing: border-box;
			  border: none;
			  background-color: #bd7df280;
			  color: black;
			  border-radius: 8px;
			}
			input{
				background-color: #bd7df280;
			}
			input[type=submit]{
			  background-color: #bd7df280;
			  border-radius: 8px;
			  color: black;
			  padding: 4px;
			  text-align: center;
			  text-decoration: none;
			  display: inline-block;
			  font-size: 13.3px;
			  margin: 1px 1px;
			  cursor: pointer;
			 
				
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
		<!-- Mostrar al usuario su identificador(invariable)-->
		<h2>Modifique sus datos</h2>
		<p >Su correo actual es: <p style="font-family:Monospace, Times, serif"><%=correo%></p>
		
		<!-- Formulario que se pasará mediante el método POST a "guardarDatos.jsp"-->
		
		<form method="post" action="../controller/guardarDatos.jsp">
		  <input type="hidden" id="correo" name="correo" value=<%=correo %>><br>		 
		  <label for="nick" >Nuevo nick</label><br>
		  <input type="text" id="nick" name="nick" value=""><br>
		  <label for="nombre">Nuevo nombre</label><br>
		  <input type="text" id="nombre" name="nombre" value=""><br>
		  <label for="apellidos">Nuevos apellidos</label><br>
		  <input type="text" id="apellidos" name="apellidos" value=""><br>
		  <div style="text-align:center ">
		      <input type="submit" value="Modificar" >
		      
		  </div>
		</form>
	
	</body>
</html> 
