<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.user.AbstractEspectaculo,es.uco.pw.business.user.EspectaculoMultiple,es.uco.pw.business.user.EspectaculoPuntual,es.uco.pw.business.user.EspectaculoTemporada, es.uco.pw.data.dao.MultipleDAO, es.uco.pw.data.dao.TemporadaDAO, es.uco.pw.data.dao.PuntualDAO, es.uco.pw.business.user.GestorCriticas,
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
	%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Ver Espectaculo</title>
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
		        <table  border="0" cellpadding=5>
				<%
				AbstractEspectaculo espec= new AbstractEspectaculo();
				if(typecontrol){
					for(int i=0;i<ListaEspectaculoP.size();i++) {
						if (titulo.equals(ListaEspectaculoP.get(i).getTitulo())==true){
							espec=ListaEspectaculoP.get(i);
							tipo=1;
							typecontrol=false;
						}
						break;
					}
				}
				
				

				if(typecontrol){
					for(int i=0;i<ListaEspectaculoT.size();i++){
						if(titulo.equals(ListaEspectaculoT.get(i).getTitulo())==true)
						{
							espec=ListaEspectaculoT.get(i);
							tipo=2;
							typecontrol=false;
						}
						break;
					}
				}

				if(typecontrol){
					for(int i=0;i<ListaEspectaculoM.size();i++){
						if(titulo.equals(ListaEspectaculoM.get(i).getTitulo())==true){
							espec=ListaEspectaculoM.get(i);
							tipo=3;
							typecontrol=false;
						}
						break;
					}
				}

				%>
				
				 

			            <tr >
			                <th>Titulo</th>
			                <td><%= espec.getTitulo() %> </td>
			            </tr>
			            <tr>
			                <th>Categoría</th>
			                <td><%=  espec.getCategoria() %> </td>
			            </tr>
			            <tr>
			                <th>Descripción</th>
			                <td><%= espec.getDescripcion()  %> </td>
			            </tr>
			            <tr>
			                <th>Localidades disponibles</th>
			                <td><%= espec.entradasDisponibles() %> </td>
			            </tr>
			            <tr>
							<% switch(tipo){
								case 1:%>
				                	<th>Fecha</th>
				                	<td><%= espec.getFechaPuntual() %> </td>
									</tr>
							<% case 2:%>
									<th>Fecha Inicio</th>
									<td><%= espec.getInicio()%> </td></tr>
	
									<tr><th>Fecha Final</th>
										<td><%= espec.getFin()%></td></tr>
							
							<% case 3:%>
								<th>Fechas</th>

								<% for(int i=0;i<espec.getListaFechas().size();i++) {%>
									<td><%= espec.getListaFechas().get(i) %> </td>

								<%}%></tr>
							

							<%}%>
			            


		           
		        </table>
  
		    </div><br>	<div style="text-align:center"><br>
		        <a  href="/aaaa/index.jsp">
				    <button class="button1" type="button">Desconectar</button>
				</a></div>
	
	
	</body>
</html>