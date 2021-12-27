<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.user.Criticas, es.uco.pw.data.dao.CriticasDAO, es.uco.pw.business.user.GestorCriticas,
	 java.time.LocalDate, java.util.Date, java.sql.*, java.util.* " %>
	
	<%
	String titulo = request.getParameter("titulo");
	CriticasDAO CDAO=new CriticasDAO();
	ArrayList<Criticas> ListaCriticas = CDAO.obtenerCriticas();
	%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Ver Critica</title>
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
			 	
				text-align: center;
				border-radius: 8px;
			}
			th, td {
			  text-align: left;
			  padding: 8px;
			 border-bottom: 1px solid #ddd;
			}
			
			
			body {
			  background-image: url(" https://i.imgur.com/l4nKkCG.png");
			  background-repeat: no-repeat;
			  background-attachment: fixed;  
			  background-size: cover;
			}
			tr:hover {background-color: pink;}
			tr:nth-child(odd) {background-color: #cc6699;}
			tr:nth-child(even) {background-color: #993366;}

		</style>
	</head>
	<body>
	<h1><%= titulo %>  </h1>
			<div align="center">
		        <table  border="0" cellpadding=5  >
				<!-- Título"LISTA DE USUARIOS".-->
				 <%for(int i=0; i< ListaCriticas.size();i++){ 
    					if(titulo.equals(ListaCriticas.get(i).getTitulo())==true) {%>

			            <tr >
			                <th>Titulo</th>
			                <td><%= ListaCriticas.get(i).getTitulo() %> </td>
			            </tr>
			            <tr>
			                <th>Espectaculo</th>
			                <td><%=  ListaCriticas.get(i).getEspectaculo() %> </td>
			            </tr>
			            <tr>
			                <th>Puntuacion</th>
			                <td><%= ListaCriticas.get(i).getPuntuacion()  %> </td>
			            </tr>
			            <tr>
			                <th>Autor</th>
			                <td><%=ListaCriticas.get(i).getAutor() %> </td>
			            </tr>
			            <tr>
			                <th>Review</th>
			                <td><%= ListaCriticas.get(i).getReview() %> </td>
			            </tr>
			            <tr>
			                <th>Valoraciones</th>
			                <td><%= ListaCriticas.get(i).getValoraciones() %> </td>
			            </tr>

		                    <%}
    					}%>
		           
		        </table>
  
		    </div><br>	<div style="text-align:center"><br>
		        <a  href="/aaaa/index.jsp">
				    <button class="button1" type="button">Desconectar</button>
				</a></div>
	
	
	</body>
</html>
