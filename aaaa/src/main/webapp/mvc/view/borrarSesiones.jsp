<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import ="es.uco.pw.business.user.Criticas, es.uco.pw.data.dao.PuntualDAO, es.uco.pw.business.user.GestorEspectaculos,
   es.uco.pw.data.dao.MultipleDAO,es.uco.pw.data.dao.TemporadaDAO, es.uco.pw.business.user.EspectaculoMultiple,es.uco.pw.business.user.EspectaculoPuntual,es.uco.pw.business.user.EspectaculoTemporada,
	 java.time.LocalDate, java.util.Date, java.sql.*, java.util.* " %>
 
 <%
	String titulo = request.getParameter("titulo");
 	MultipleDAO  MDAO=new MultipleDAO();
	PuntualDAO   PDAO=new PuntualDAO();
	TemporadaDAO TDAO=new TemporadaDAO();
	ArrayList<EspectaculoPuntual>  ListaEspectaculoP = PDAO.obtenerPuntual();
	ArrayList<EspectaculoMultiple> ListaEspectaculoM = MDAO.obtenerMultiple();
	ArrayList<EspectaculoTemporada>ListaEspectaculoT = TDAO.obtenerTemporada();
	int tipo=0;
	Boolean typecontrol=true;
	
	EspectaculoPuntual especP= new EspectaculoPuntual();
	EspectaculoTemporada especT = new EspectaculoTemporada();
	EspectaculoMultiple especM = new EspectaculoMultiple(); 
	
	if(typecontrol){
		for(int i=0;i<ListaEspectaculoP.size();i++) {
			if (titulo.equals(ListaEspectaculoP.get(i).getTitulo())==true){
				especP=ListaEspectaculoP.get(i);
				tipo=1;
				typecontrol=false;
				break;
			}
		}
	}
	if(typecontrol){
		for(int i=0;i<ListaEspectaculoT.size();i++){
			if(titulo.equals(ListaEspectaculoT.get(i).getTitulo())==true){
				especT=ListaEspectaculoT.get(i);
				tipo=2;
				typecontrol=false;
				break;

			}
		}
	}

	if(typecontrol){
		for(int i=0;i<ListaEspectaculoM.size();i++){
			if(titulo.equals(ListaEspectaculoM.get(i).getTitulo())==true){
				especM=ListaEspectaculoM.get(i);
				especM.setListaFechas(ListaEspectaculoM.get(i).getListaFechas());
				tipo=3;
				break;
			}
		}
	}
 %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Borrar Sesiones</title>
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
			td:nth-child(3n){background-color:#48465d;}
			td:nth-child(5n){background-color:#48465d;}
		</style>
	</head>
	<body>
	<h1><%=  titulo   %></h1>
			<div align="center">
		        <table  border="0" cellpadding=5  >
				
				<tr>
							<% switch(tipo){
								case 1:%>
				                	<th>FechaPuntual</th>
				                	<td><%= especP.getFechaPuntual() %> </td>
				                	<td><form method="post" action= "/aaaa/BorrarEspect" > 
						    			<button class="button1" type=submit value="<%= especP.getTitulo() %>" id="titulo" name="titulo">Eliminar</button>
									</form></td>
									</tr>
								<%break;
								case 2:%>
									<th>Fecha inicio:</th>
				                	<td><%= especT.getInicio() %> </td>
				                	<th>Fecha final:</th>
				                	<td><%= especT.getInicio() %> </td>
				                	<td><form method="post" action= "/aaaa/BorrarEspect" > 
						    			<button class="button1" type=submit value="<%= especT.getTitulo() %>" id="titulo" name="titulo">Eliminar</button>
									</form></td>
									</tr>
								<%break;
								case 3:%>
								<% for(int i=0;i<especM.getListaFechas().size();i++) {%>
									<tr >
					                   <td style="text-align:center"><%= especM.getListaFechas().get(i) %> </td>
					                   
					                <td style="text-align:center; background-color:#48465d" >
					                    <form method="post" action= "/aaaa/BorrarFechaMultiple" > 
							    			<input type="hidden" value="<%= especM.getTitulo() %>" id="titulo" name="titulo"> 
							    			<button class="button1" type=submit value="<%= especM.getListaFechas().get(i) %>" id="fecha" name="fecha">Eliminar</button>
							    			
										</form>
									</td>

								<%}%></tr>
							
								<%break;
							}%>
    				
		           
		        </table>
  
		    </div><br>	<div style="text-align:center"><br>
		        <a  href="/aaaa/index.jsp">
				    <button class="button1" type="button">Desconectar</button>
				</a></div>
	
	</body>
</html>


				