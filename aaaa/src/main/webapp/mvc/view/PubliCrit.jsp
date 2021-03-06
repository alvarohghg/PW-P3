<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.user.Criticas, es.uco.pw.data.dao.CriticasDAO, es.uco.pw.business.user.GestorCriticas,
	 java.time.LocalDate, java.util.Date, java.sql.*, java.util.* " %>
	 
	 <% String correo = request.getParameter("correo");
		CriticasDAO CDAO=new CriticasDAO();
		Criticas critica = new Criticas();
		GestorCriticas GC = GestorCriticas.getInstancia();
		ArrayList<Criticas> ListaCriticas = CDAO.obtenerCriticas();
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

    .col-25 {
      float: center;
      width: 25%;
      margin-top: 6px;


    }

    .col-75 {

      float: left;
      width: 75%;
      margin-top: 6px;

    }

    body {
      background-image: url("https://i.imgur.com/l4nKkCG.png");
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-size: cover;
    }

    /* Clear floats after the columns */
    .row:after {

      content: "";
      display: table;
      clear: both;
    }

    /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
    @media screen and (max-width: 600px) {

      .col-25,
      .col-75,
      input[type=submit] {

        width: 100%;
        margin-top: 0;
      }
    }
  </style>
</head>

<body>

<%-- Se crea el formulario para rellenar con los parametros de la cr??tica --%>
	
  <div class="container">
    <form method="post" action= "/aaaa/PublicCritica">
      <div class="row">
        <div class="col-25">
          <label for="titulo" >Titulo</label>
        </div>
        <div class="col-75">
          <input type="text" id="titulo" name="titulo" placeholder="Titulo de la critica" required>
        </div>
      </div>
      <div class="row">
        <div class="col-25">
          <label for="espectaculo">Espectaculo</label>
        </div>
        <div class="col-75">
          <input type="text" id="espectaculo" name="espectaculo" placeholder="Espectaculo de la critica" required>
        </div>
      </div>
      <div class="row">
        <div class="col-25">
          <label for="puntuacion">Puntuacion</label>
        </div>
        <div class="col-75">
          <select id="puntuacion" name="puntuacion">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>

          </select>
        </div>
      </div>
      <div class="row">
        <div class="col-25">
          <label for="review">Review</label>
        </div>
        <div class="col-75">
          <textarea id="review" name="review" placeholder="Escriba su review" style="height:200px" required></textarea>
        </div>
      </div>
      <br>
      <div class="row">
      	<input type='hidden' value= "<%=correo %>" id="correo" name="correo">
        <input type="submit" value="Publicar">
      </div>
    </form>
  </div>

</body>

</html>
