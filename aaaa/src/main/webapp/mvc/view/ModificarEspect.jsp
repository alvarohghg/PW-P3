<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import ="es.uco.pw.business.user.Criticas, es.uco.pw.data.dao.PuntualDAO, es.uco.pw.business.user.GestorEspectaculos,
   es.uco.pw.data.dao.MultipleDAO,es.uco.pw.data.dao.TemporadaDAO, es.uco.pw.business.user.EspectaculoMultiple,es.uco.pw.business.user.EspectaculoPuntual,es.uco.pw.business.user.EspectaculoTemporada,
	 java.time.LocalDate, java.util.Date, java.sql.*, java.util.* " %>
	 
	 <% GestorEspectaculos GE=new GestorEspectaculos();
		ArrayList<EspectaculoMultiple> ListaM=new ArrayList<EspectaculoMultiple>();
		ArrayList<EspectaculoPuntual> ListaP=new ArrayList<EspectaculoPuntual>();
		ArrayList<EspectaculoTemporada> ListaT=new ArrayList<EspectaculoTemporada>();
		GE.guardarBDlistas();
		ListaP=GE.getListaEspectaculosP();
		ListaT=GE.getListaEspectaculosT();
		ListaM=GE.getListaEspectaculosM();
		ArrayList<String> l= new ArrayList<String>();
	 	for(int i=0;i<ListaM.size();i++){
			l.add(ListaM.get(i).getTitulo());					
		}
		
		for(int i=0;i<ListaT.size();i++) {
			l.add(ListaT.get(i).getTitulo());					
		}
		for(int i=0;i<ListaP.size();i++) {
			l.add(ListaP.get(i).getTitulo());					
		} 
	
	%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de espectaculos a modificar</title>
		<!-- Declaración del estilo.-->
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
		<!-- Contenedor (div) para introducir la lista-->
		<!-- Tabla que usaremos como lista-->
		<div align="center">
        <table  border="0" cellpadding=5  >
		<!-- Título"LISTA DE USUARIOS"-->
            <caption><h2 style="text-align:center">Espectaculos</h2></caption>
            <tr>
                <th>Titulo</th>
            </tr>
		<!-- Traducción de la variable "tipo" de la base de datos-->
            <% for(int i=0; i< l.size();i++){ 
            	String titulo=l.get(i);

            %>
                <tr >
                    <td><%= titulo %> </td>
					<!-- Botón de "Modificar datos" junto al usuario a modificar-->
	                    <td >
	                    <form method="post" action= "FormDModEspect.jsp">
			    			<button class="button1" type=submit value="<%= titulo %>" id="titulo" name="titulo">Modificar</button>
						</form>
						
                </tr>
                
             <%} %>
           
        </table>
       
        
    </div><br>	<div style="text-align:center">
    <br>
          <a  href="/aaaa/index.jsp">
				    <button class="button1" type="button">Desconectar</button>
			</a></div>
	</body>
</html>
