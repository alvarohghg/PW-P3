<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <%@ page import="es.uco.pw.business.user.Usuario, es.uco.pw.data.dao.UsuarioDAO,
 es.uco.pw.business.user.GestorUsuario, es.uco.pw.business.user.EspectaculoPuntual,es.uco.pw.business.user.GestorEspectaculos,
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


<!-- Creamos el formulario con los datos del espectaculo deseados. -->
      <div class="container">
        <form method="post" action="/aaaa/PuntualServlet">
          <div class="row">
            <div class="col-25">
              <label for="titulo_punt">Titulo</label>
            </div>
            <div class="col-75">
              <input type="text" id="titulo_punt" name="titulo_punt" placeholder="Titulo del espectaculo puntual">
            </div>
          </div>
          <div class="row">
            <div class="col-25">
              <label for="desc_punt">Descripcion</label>
            </div>
            <div class="col-75">
              <textarea id="desc_punt" name="desc_punt" placeholder="Descripcion del espectaculo puntual"
                style="height:100px"></textarea>
            </div>
          </div>
          <div class="row">
            <div class="col-25">
              <label for="categoria_punt">Categoria</label>
              <select id="categoria_punt" name="categoria_punt">
                <option value="obra">obra</option>
                <option value="concierto">concierto</option>
                <option value="monologo">monologo</option>
              </select>
            </div></div>
            <div class="row">
              <div class="col-25">
                <label for="aforo_punt">Aforo</label>
              </div>
              <div class="col-75">
                <input type="text" id="aforo_punt" name="aforo_punt" placeholder="Aforo del espectaculo puntual">
              </div>
            </div>
            <div class="row">
              <div class="col-25">
                <label for="loc_punt">Localidades vendidas</label>
              </div>
              <div class="col-75">
                <input type="text" id="loc_punt" name="loc_punt"
                  placeholder="Localidades vendidas del espectaculo puntual">
              </div>
            </div>
            <div class="row">
              <div class="col-25">
                <label for="fecha_punt">Fecha de la sesion</label>
              </div>
              <div class="col-75">
                <input type="date" id="fecha_punt" name="fecha_punt" placeholder="Fecha del espectaculo puntual">
              </div>
            </div>

            <br>
            <div class="row">
              <input type="submit" value="Crear espectaculo puntual">
            </div>
        </form>
      </div>

    </body>

    </html>
