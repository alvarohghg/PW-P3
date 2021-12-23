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
		int aux=0;
		 for(int i=0; i< ListaCriticas.size();i++){ 
        	if(correo.equals(ListaCriticas.get(i).getAutor())==true){
        		aux++;
        	}
		 }	
        %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Eliminar Critica</title>
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
			td:nth-child(2n){background-color:#48465d;

		</style>
	</head>
	<body>
		<!-- Contenedor (div) para introducir la lista-->
		<!-- Tabla que usaremos como lista-->
		<div align="center">
		<%
		if(aux==0){%>
			 <p >No has escrito ninguna crtica </p>
		<%}
		else{
		%>
        <table  border="0" cellpadding=5  >
		<!-- Título"LISTA DE USUARIOS"-->
            <caption><h2 style="text-align:center">Criticas</h2></caption>
            <tr>
                <th>Titulo</th>
            </tr>
		<!-- Traducción de la variable "tipo" de la base de datos-->
            <% for(int i=0; i< ListaCriticas.size();i++){ 
	            	if(correo.equals(ListaCriticas.get(i).getAutor())==true){
	            	String titulo=ListaCriticas.get(i).getTitulo();
	            %>
	                <tr >
	                    <td><%= titulo %> </td>
						<!-- Botón de "Modificar datos" junto al usuario a modificar-->
	                    
		                    <td >
						 <!-- Formulario para enviar mediante el método POST el usuario a modificar a "modificarDatos.jsp"-->
		                    <form method="post" action= "/aaaa/BorrarCritica" >
		                    	<input type="hidden" value="<%= correo %>" id="correo" name="correo"> 
				    			<button class="button1" type=submit value="<%= titulo %>" id="titulo" name="titulo">Eliminar</button>
							</form>
	                </tr>
                
             		<%}
            	}
            }%>
           
        </table>
       
        
    </div><br>	<div style="text-align:center">
    <br>
          <a  href="/aaaa/index.jsp">
				    <button class="button1" type="button">Desconectar</button>
			</a></div>
	</body>
</html>
