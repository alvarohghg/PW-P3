 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.user.Usuario, es.uco.pw.data.dao.UsuarioDAO, es.uco.pw.business.user.GestorUsuario,
	 java.time.LocalDate, java.util.Date, java.sql.*, java.util.* " %>

<% //Declaracion de las variables de recepcion de los datos %>

<% 	String pass = request.getParameter("password");
	String correo = request.getParameter("correo"); 
	UsuarioDAO UDAO=new UsuarioDAO();
	Usuario user = new Usuario();
	GestorUsuario GU =new GestorUsuario();
	int op;
	GU.guardarBDU();
	/*
	Cambiamos el valor de op para controlar si ha iniciado sesion correctamete y el tipo de usuario que es
	*/
	if(GU.existePass(correo, pass)==true){
		GU.ponerFecha(correo);
		if(GU.esAdmim(correo)==true){
			op=0;
		}else{
			op=1;
		}
	}
	else{
		op=2;
	}
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Comprobar inicio sesion</title>
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
			  background-image: url(" https://i.imgur.com/l4nKkCG.png");
			  background-repeat: no-repeat;
			  background-attachment: fixed;  
			  background-size: cover;
			}
			
		</style>
	</head>
	<body>
		<!--Mostramos una pagina diferente segun el tipo de usuario y redireccionamos -->
		<% if(op==0){%>
			 	<h1>Sesion inicida correctamente</h1>
				
				<form method="post" action="../view/Admin.jsp">
			    	<button class="button button1" type=submit value=<%= correo %> id="correo" name="correo">Continuar</button>
				</form>	
		<%}
		else if(op==1){%>
			<h1>Sesion inicida correctamente</h1>
			<form method="post" action="../view/Espectador.jsp">
			    	<button class="button button1" type=submit value=<%= correo %> id="correo" name="correo">Continuar</button>

			</form>
		<%}
		else{%>
			 <h1>Usuario no registrado</h1>
				
				<a href="../view/loginView.jsp">
				    <button class="button1" type="button">Reintentar</button>
				</a>
				<a href="/aaaa/index.jsp">
				    <button class="button1" type="button">Salir</button>
				</a>
		<%}
		
		%>
		
		
	</body>
</html>
