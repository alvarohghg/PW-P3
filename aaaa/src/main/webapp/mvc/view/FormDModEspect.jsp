<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import ="es.uco.pw.business.user.Criticas, es.uco.pw.data.dao.PuntualDAO, es.uco.pw.business.user.GestorEspectaculos,
   es.uco.pw.data.dao.MultipleDAO,es.uco.pw.data.dao.TemporadaDAO, es.uco.pw.business.user.EspectaculoMultiple,es.uco.pw.business.user.EspectaculoPuntual,es.uco.pw.business.user.EspectaculoTemporada,
	 java.time.LocalDate, java.util.Date, java.sql.*, java.util.*, es.uco.pw.business.user.AbstractEspectaculo.categoria " %>
    <%
    	GestorEspectaculos GE =new GestorEspectaculos();
    	String titulo=request.getParameter("titulo");
    	int tipo= GE.tipoEvento(titulo);
    %>
    
 <!DOCTYPE html>
<html>
	<head>
	<title>Modificar espectaculos</title>
	<!-- Declaración del estilo-->
	<style>
			form,h2,p {
				 text-align:center;
			}
			input[type=text]{

			  padding: 12px 20px;
			  margin: 8px 0;
			  box-sizing: border-box;
			  border: none;
			  background-color: #bd7df280;
			  color: black;
			  border-radius: 8px;
			}
			input{
				background-color: #bd7df280;
			}
			input[type=submit]{
			  background-color: #bd7df280;
			  border-radius: 8px;
			  color: black;
			  padding: 4px;
			  text-align: center;
			  text-decoration: none;
			  display: inline-block;
			  font-size: 13.3px;
			  margin: 1px 1px;
			  cursor: pointer;
			 
				
			}

			 
			body {
			  background-image: url(" https://i.imgur.com/l4nKkCG.png");
			  background-repeat: no-repeat;
			  background-attachment: fixed;  
			  background-size: cover;
			} 
	
	</style>
	</head>
	<body>
		<!-- Mostrar al usuario su identificador(invariable)-->
		
		<h2>Modifique los datos del espectaculo</h2>
		
		<!-- Formulario que se pasará mediante el método POST a "guardarDatos.jsp"-->
		<%if(tipo==1){ %>
			<form method="post" action="/aaaa/ModMult">
			  
			  <label for="descripcion">Nueva descripcion</label><br>
			  <input type="text" id="descripcion" name="descripcion" value=""><br>
			  <label for="categoria">Categoria</label>
	          <select id="categoria" name="categoria" >
	          	<option value=""></option>
	            <option value="obra">obra</option>
	            <option value="concierto">concierto</option>
	            <option value="monologo">monologo</option>
	          </select><br><br>
			  <label for="aforo">Nuevo aforo</label><br>
			  <input type="text" id="aforo" name="aforo" value=""><br>
			  <label for="entradas">Nuevas entradas vendidas</label><br>
			  <input type="text" id="entradas" name="entradas" value=""><br>
			  <label for="fecha">Fecha a cambiar</label><br>
			  <input type="date" id="fecha_vieja" name="fecha_vieja" value=""><br><br>
			  <label for="fecha">Fecha nueva</label><br>
			  <input type="date" id="fecha_nueva" name="fecha_nueva" value=""><br><br>
			  <input type="hidden" id="titulo_viejo" name="titulo_viejo" value='<%=titulo %>'><br>		 
			  
			  <div style="text-align:center ">
			     	<input type="submit" value="Modificar" >
			  </div>
			</form>
		<%} 
		else if(tipo==2){ %>
			<form method="post" action="/aaaa/ModTemp">
			  
			  <label for="descripcion">Nueva descripcion</label><br>
			  <input type="text" id="descripcion" name="descripcion" value=""><br>
			  <label for="categoria">Categoria</label>
	          <select id="categoria" name="categoria" >
	          	<option value=""></option>
	            <option value="obra">obra</option>
	            <option value="concierto">concierto</option>
	            <option value="monologo">monologo</option>
	          </select><br><br>
			  <label for="aforo">Nuevo aforo</label><br>
			  <input type="text" id="aforo" name="aforo" value=""><br>
			  <label for="entradas">Nuevas entradas vendidas</label><br>
			  <input type="text" id="entradas" name="entradas" value=""><br>
			  <label for="dia">Nuevo dia: </label>
			  <select id="dia" name="dia">
			  	  <option value=""></option>
	              <option value="Lunes">Lunes</option>
	              <option value="Martes">Martes</option>
	              <option value="Miercoles">Miercoles</option>
	              <option value="Jueves">Jueves</option>
	              <option value="Viernes">Viernes</option>
	              <option value="Sabado">Sabado</option>
	              <option value="Domingo">Domingo</option>
              </select><br><br>
			  <label for="inicio">Nuevo inicio</label><br>
			  <input type="date" id="inicio" name="inicio" value=""><br><br>
			  <label for="fin">Nuevo fin</label><br>
			  <input type="date" id="fin" name="fin" value=""><br><br>
			  <input type="hidden" id="titulo_viejo" name="titulo_viejo" value='<%=titulo %>'><br>		 
			  <div style="text-align:center ">
			     	<input type="submit" value="Modificar" >
			  </div>
			</form>
		<%}
		else if(tipo==3){%>
			<form method="post" action="/aaaa/ModPun">
			  
			  <label for="descripcion">Nueva descripcion</label><br>
			  <input type="text" id="descripcion" name="descripcion" value=""><br>
			  <label for="categoria">Categoria</label>
	          <select id="categoria" name="categoria" >
	          	 <option value=""></option>
	            <option value="obra">obra</option>
	            <option value="concierto">concierto</option>
	            <option value="monologo">monologo</option>
	          </select><br><br>
			  <label for="aforo">Nuevo aforo</label><br>
			  <input type="text" id="aforo" name="aforo" value=""><br>
			  <label for="entradas">Nuevas entradas vendidas</label><br>
			  <input type="text" id="entradas" name="entradas" value=""><br>
			  <label for="fecha">Nueva fecha</label><br>
			  <input type="date" id="fecha" name="fecha" value=""><br><br>
			  <input type="hidden" id="titulo_viejo" name="titulo_viejo" value='<%=titulo %>'><br>		 
			  <div style="text-align:center ">
			     	<input type="submit" value="Modificar" >
			  </div>
			</form>
		<%} %>
	</body>
</html> 
