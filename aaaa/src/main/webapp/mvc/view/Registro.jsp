<%@ page import ="es.uco.pw.business.user.Usuario, es.uco.pw.data.dao.UsuarioDAO, es.uco.pw.business.user.GestorUsuario" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Registro</title>
		<!-- Declaración del estilo.-->
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

		<!-- Formulario que se pasará mediante el método POST a "comprobarUsuario.jsp"-->
		<form method="post" action= "/aaaa/RegistroUsuarios" >
			<label for="nombre">Nombre</label><br>
			<input type="text" name="nombre" value="" id="nombre" required><br/><br/>
			<label for="apellidos">Apellidos</label><br>
			<input type="text" name="apellidos" value="" id="apellidos" required><br/><br/>
			<label for="nick">Nick</label><br>
			<input type="text" name="nick" value="" id="nick" required><br/><br/>	
			<label for="correo">Correo</label><br>
			<input type="text" name="correo" value="" id="correo" required><br/><br/>
			<label for="password">Password</label><br>
			<input type="password" name="password" value="" id="password" required><br/><br/>
			<input type="radio" id="tipo" name="tipo" value="1">
 			<label for="Admin">Admin</label><br>
 			<input type="radio"  id="tipo" name="tipo" value="0" checked>
 			<label for="Espectador">Espectador</label><br><br>
			<input type="submit" value="Registrarse">
		</form>

	</body>
</html>
