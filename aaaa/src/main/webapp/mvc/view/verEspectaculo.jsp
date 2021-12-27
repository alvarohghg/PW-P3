<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.user.AbstractEspectaculo,es.uco.pw.business.user.EspectaculoMultiple,es.uco.pw.business.user.EspectaculoPuntual,es.uco.pw.business.user.EspectaculoTemporada, es.uco.pw.data.dao.MultipleDAO, es.uco.pw.data.dao.TemporadaDAO, es.uco.pw.data.dao.PuntualDAO, es.uco.pw.business.user.GestorCriticas,
	 java.time.LocalDate, java.util.Date, java.sql.*, java.util.* " %>
	<%-- Recogemos el título y volcamos todos los espectaculos en sus listas correspondientes  --%> 
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
				<%-- Creamos un espectaculo de cada tipo auxiliar y copiamos el que coincida el título de su lista correspondiente --%>
				<%
				AbstractEspectaculo espec= new AbstractEspectaculo();
				EspectaculoPuntual especP= new EspectaculoPuntual();
				EspectaculoTemporada especT = new EspectaculoTemporada();
				EspectaculoMultiple especM = new EspectaculoMultiple();
				if(typecontrol){
					for(int i=0;i<ListaEspectaculoP.size();i++) {
						if (titulo.equals(ListaEspectaculoP.get(i).getTitulo())==true){
							espec.setTitulo(ListaEspectaculoP.get(i).getTitulo());
							espec.setCategoria(ListaEspectaculoP.get(i).getCategoria());
							espec.setAforolocalidades(ListaEspectaculoP.get(i).getAforolocalidades());
							espec.setLocalidadesvendidas(ListaEspectaculoP.get(i).getLocalidadesvendidas());
							espec.setDescripcion(ListaEspectaculoP.get(i).getDescripcion());
							especP=ListaEspectaculoP.get(i);
							tipo=1;
							typecontrol=false;
							break;
						}
						
					}
				}
				
				

				if(typecontrol){
					for(int i=0;i<ListaEspectaculoT.size();i++){
						if(titulo.equals(ListaEspectaculoT.get(i).getTitulo())==true)
						{
							espec.setTitulo(ListaEspectaculoT.get(i).getTitulo());
							espec.setCategoria(ListaEspectaculoT.get(i).getCategoria());
							espec.setAforolocalidades(ListaEspectaculoT.get(i).getAforolocalidades());
							espec.setLocalidadesvendidas(ListaEspectaculoT.get(i).getLocalidadesvendidas());
							espec.setDescripcion(ListaEspectaculoT.get(i).getDescripcion());
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
							espec.setTitulo(ListaEspectaculoM.get(i).getTitulo());
							espec.setCategoria(ListaEspectaculoM.get(i).getCategoria());
							espec.setAforolocalidades(ListaEspectaculoM.get(i).getAforolocalidades());
							espec.setLocalidadesvendidas(ListaEspectaculoM.get(i).getLocalidadesvendidas());
							espec.setDescripcion(ListaEspectaculoM.get(i).getDescripcion());
							especM.setListaFechas( ListaEspectaculoM.get(i).getListaFechas());
							tipo=3;
							typecontrol=false;
							break;
						}
						
					}
				}

				%>
				 <%-- Mostramos los datos del espectaculo en una tabla con filas y columnas oportunas según el tipo de espectáculo que sea --%>
						
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
			                <th>Localidades vendidas</th>
			                <td><%= espec.getLocalidadesvendidas() %>/<%= espec.getAforolocalidades() %> </td>
			            </tr>
			            <tr>
							<% switch(tipo){
								case 1:%>
				                	<th>Fecha</th>
				                	<td><%= especP.getFechaPuntual() %> </td>
									</tr>
								<%break;
								case 2:%>
									<th>Dia Semana</th>
									<td><%= especT.getDia()%> </td></tr>
										
									<tr><th>Fecha Inicio</th>
									<td><%= especT.getInicio()%> </td></tr>
	
									<tr><th>Fecha Final</th>
										<td><%= especT.getFin()%></td></tr>
								<%break;
								case 3:%>
								<th>Fechas</th>

								<% for(int i=0;i<especM.getListaFechas().size();i++) {%>
									<td><%= especM.getListaFechas().get(i) %> </td>

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
