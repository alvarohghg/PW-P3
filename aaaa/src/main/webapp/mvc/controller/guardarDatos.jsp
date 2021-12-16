<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.user.Usuario, es.uco.pw.data.dao.UsuarioDAO, es.uco.pw.business.user.GestorUsuario,
 java.time.LocalDate, java.util.Date, java.sql.*, java.util.* " %>

<% //Declaracion de las variables de recepcion de los datos 
   String correo = request.getParameter("correo"); 
   String nombre = request.getParameter("nombre"); 
   String apellidos = request.getParameter("apellidos"); 
   String nick = request.getParameter("nick");
   String pass = request.getParameter("password");%>

<%	UsuarioDAO UDAO=new UsuarioDAO();
	Usuario user = new Usuario();
	GestorUsuario GU =new GestorUsuario();
	/*
	LLamamos las funciones de modificar los datos, dentro de ellas ya se cambia en la base de datos
	*/
	
	if(nombre.equals("")==false){
		GU.updateUser(correo, nombre, null, null, null,null, 2);
	}
	if(apellidos.equals("")==false){
		GU.updateUser(correo, null, apellidos, null, null,null, 3);
	}
	if(nick.equals("")==false){
		GU.updateUser(correo, null, null, nick, null,null, 1);
	}
	if(pass.equals("")==false){
		GU.updateUser(correo, null, null, null, null,pass, 5);
	}
%>
   
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Guardando datos</title>
		<!--Declaracion del estilo -->
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
		<!--Redireccionamos al inicio -->
		<caption><h2 style="text-align:left">Datos guardados correctamente</h2></caption>
		<a style="text-align:left" href="/aaaa/index.jsp">
				    <button class="button1" type="button">Desconectar</button>
		</a>
	</body>
</html>
