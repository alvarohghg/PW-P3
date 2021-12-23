<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Iniciar sesion</title>
		<!-- Declaración del estilo-->
		<style>
			
			form,h2 {
				 text-align:center;
			}
			input[type=text], input[type=password]{

			  padding: 12px 20px;
			  margin: 8px 0;
			  box-sizing: border-box;
			  border: none;
			  background-color: #bd7df280;
			  color: black;	
			  border-radius:8px;
			}

			input{
				background-color: #bd7df280;
			}
			input[type=submit]{
			
				color:black;
				background-color: #bd7df280;
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
			<!-- Formulario que se pasará mediante el método POST a "loginController.jsp"-->
			<form method="post" action="../controller/loginController.jsp">
				<label for="email">Correo: </label>
				<input type="text" name="correo" value="" id="correo">	
				<br/>
				<label for="password">Password: </label>
				<input type="password" name="password" value="" id="password"><br/>
				<input type="submit" value="Iniciar">	
			</form>
	</body>
</html>





