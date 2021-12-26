<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.user.AbstractEspectaculo,es.uco.pw.business.user.EspectaculoMultiple,es.uco.pw.business.user.EspectaculoPuntual,es.uco.pw.business.user.EspectaculoTemporada, es.uco.pw.data.dao.MultipleDAO, es.uco.pw.data.dao.TemporadaDAO, es.uco.pw.data.dao.PuntualDAO, es.uco.pw.business.user.GestorCriticas,
	 java.time.LocalDate, java.util.Date, java.sql.*, java.util.* " %>
   
   <%
	 String titulo = request.getParameter("titulo");
 	
 %>
<!DOCTYPE html>
<html>
<head>
  <style>
    * {
      box-sizing: border-box;

    }

    input[type=text],
    select,
    textarea {

      width: 100%;
      padding: 12px;
      border: 1px solid #ccc;
      border-radius: 4px;
      resize: vertical;
      background-color: #d9acfa;

    }

    label {

      padding: 12px 12px 12px 0;
      display: inline-block;
    }

    input[type=submit] {

      background-color: #bd7df280;
      color: black;
      padding: 12px 20px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      float: right;

    }

    input[type=submit]:hover {
      background-color: #bd7df280;

    }

    .container {

      color: black;
      border-radius: 5px;
      background-color: #bd7df280;
      padding: 20px;

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

    body {
      background-image: url("https://i.imgur.com/l4nKkCG.png");
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-size: cover;
    }


   
  </style>
</head>

<body>



  <div class="container">
    <form id="formulario" method="post" action="/aaaa/addSesionesMultipleServlet">
                <input type="hidden" id="titulo" name="titulo" value='<%=titulo %>'><br>		 
                <label for="fecha_punt">Fecha: </label>
                <input type="date" id="fecha" name="fecha" required>
             	<input type="submit" value="Añadir fecha">
    </form>

  </div>

  <div style="text-align:center"><br>
       <a  href="/aaaa/index.jsp">
	    <button class="button1" type="button">Desconectar</button>
		</a>
</div>

</body>

</html>