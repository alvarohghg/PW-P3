<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.user.Criticas, es.uco.pw.data.dao.CriticasDAO, es.uco.pw.business.user.GestorCriticas,
	 java.time.LocalDate, java.util.Date, java.sql.*, java.util.* " %>
	 
	 <% String correo = request.getParameter("correo");
	%>
	 
	 <%	CriticasDAO CDAO=new CriticasDAO();
		Criticas critica = new Criticas();
		GestorCriticas GC = GestorCriticas.getInstancia();
		ArrayList<Criticas> ListaCriticas = CDAO.obtenerCriticas();
	%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Buscar Critica</title>
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
		</style>
	</head>
	<body>
		<form method="post" action= "/aaaa/Buscar" >
			<label for="Titulo">Titulo</label><br>
			<input type="text" name="Titulo" id="Titulo" ><br/>
			<select id="cate" name="cate" required>
		        <option value="cualquiera">Cualquiera</option>
		        <option value="monologo">Monologo</option>
		        <option value="obra">Obra</option>
		        <option value="concierto">Concierto</option>  
	      	</select>
 			<input type="submit" value="Buscar">
		</form>
        
    
    <br>
          <a  href="/aaaa/index.jsp">
				    <button class="button1" type="button">Desconectar</button>
			</a>
	</body>
</html>
