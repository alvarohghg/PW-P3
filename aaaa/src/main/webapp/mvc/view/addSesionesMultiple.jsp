<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.user.AbstractEspectaculo,es.uco.pw.business.user.EspectaculoMultiple,es.uco.pw.business.user.EspectaculoPuntual,es.uco.pw.business.user.EspectaculoTemporada, es.uco.pw.data.dao.MultipleDAO, es.uco.pw.data.dao.TemporadaDAO, es.uco.pw.data.dao.PuntualDAO, es.uco.pw.business.user.GestorCriticas,
	 java.time.LocalDate, java.util.Date, java.sql.*, java.util.* " %>
   
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

    option:hover {
      color: black;
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



  <div class="container">
    <form id="formulario" method="post" action="/aaaa/addSesionesMultipleServlet">
        <div class="row">
              <div class="col-25">
                <label for="nueva_fecha">Fecha de la sesion</label>
              </div>
              <div class="col-75">
                <input type="date" id="nueva_fecha" name="nueva_fecha" placeholder="Nueva fecha del espectaculo">
              </div>
            </div>
          <br>
          <div class="row">
            <button class="button1" type=submit value="<%= l.get(i).getTitulo() %>" id="titulo" name="titulo">Añadir sesiones</button>
          </div>
    </form>

    <div>

    </div>
  </div>



</body>

</html>