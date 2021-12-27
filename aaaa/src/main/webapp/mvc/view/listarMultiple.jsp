<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.user.AbstractEspectaculo,es.uco.pw.business.user.EspectaculoMultiple,es.uco.pw.business.user.EspectaculoPuntual,es.uco.pw.business.user.EspectaculoTemporada, es.uco.pw.data.dao.MultipleDAO, es.uco.pw.data.dao.TemporadaDAO, es.uco.pw.data.dao.PuntualDAO, es.uco.pw.business.user.GestorCriticas,
	 java.time.LocalDate, java.util.Date, java.sql.*, java.util.* " %>


<%
	MultipleDAO MDAO=new MultipleDAO();
	ArrayList<String> l=new ArrayList<String>();
	ArrayList<EspectaculoMultiple> ListaMultiple = MDAO.obtenerMultiple();
	
	for(int i=0;i<ListaMultiple.size();i++){
		l.add(ListaMultiple.get(i).getTitulo());					
	}
	
	
	%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Ver Espectaculos Multiples</title>
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
			<div align="center">
		        <table  border="0" cellpadding=5  >
		<!-- Título"LISTA DE USUARIOS".-->
            <tr>
                <th>Titulo</th> 
            </tr>
            	<% for(int i=0; i< l.size();i++){ 
	            	
	            %>
               <tr >
                   <td><%= l.get(i) %> </td>
                   
                <td style="text-align:center" >
				 <!-- Formulario para enviar mediante el método POST el espect a modificar a "cancelarEspectaculoServlet.jsp"-->
                    <form method="post" action= "addSesionesMultiple.jsp" > 
		    			<button class="button1" type=submit value="<%= l.get(i) %>" id="titulo" name="titulo">Añadir sesiones</button>
					</form>
				</td>
               </tr>
                
             		<%
            	}
	            
            %>
           
        </table>
  
		    </div><br>	<div style="text-align:center"><br>
		        <a  href="/aaaa/index.jsp">
				    <button class="button1" type="button">Desconectar</button>
				</a></div>
	
	
	</body>
</html>
