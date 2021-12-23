<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

  <script>
    function myFunction(a1) {
      document.getElementById("formulario").appendChild(document.createElement("br"));
      for (let i = 1; i <= parseInt(a1); i++) {
        document.getElementById("formulario").appendChild(document.createElement("br"));
        var para = document.createElement("input");

        para.id ="Fecha" + i;
        para.name ="Fecha" + i;
        para.type = "date";
        para.required = true;
        para.pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}";
        document.getElementById("formulario").appendChild(para);
        document.getElementById("formulario").appendChild(document.createElement("br"));
      }
      var botoncito = document.getElementById("Botoncito")
      botoncito.style.visibility = 'hidden';
      botoncito.style.display = 'none';
    }
  </script>

</head>

<body>



  <div class="container">
    <form id="formulario" method="post" action="/aaaa/MultipleServlet">
      <div class="row">
        <div class="col-25">
          <label for="titulo_mult">Titulo</label>
        </div>
        <div class="col-75">
          <input type="text" id="titulo_mult" name="titulo_mult" placeholder="Titulo del espectaculo multiple" required>
        </div>
      </div>
      <div class="row">
        <div class="col-25">
          <label for="desc_mult">Descripcion</label>
        </div>
        <div class="col-75">
          <textarea id="desc_mult" name="desc_mult" placeholder="Descripcion del espectaculo multiple"
            style="height:100px"></textarea>
        </div>
      </div>
      <div class="row">
        <div class="col-25">
          <label for="categoria_mult">Categoria</label>
          <select id="categoria_mult" name="categoria_mult" required>
            <option value="obra">obra</option>
            <option value="concierto">concierto</option>
            <option value="monologo">monologo</option>
          </select>
        </div></div>
        <div class="row">
          <div class="col-25">
            <label for="aforo_mult">Aforo</label>
          </div>
          <div class="col-75">
            <input type="text" id="aforo_mult" name="aforo_mult" placeholder="Aforo del espectaculo multiple" required>
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="loc_mult">Localidades vendidas</label>
          </div>
          <div class="col-75">
            <input type="text" id="loc_mult" name="loc_mult" placeholder="Localidades vendidas del espectaculo multiple"
              required>
          </div>
        </div>

        <div class="row">
          <div class="col-25">
            <label for="nfechas">Numero de fechas</label>
          </div>
          <div class="col-75">
            <input type="text" id="nfechas" name="nfechas" required> <input id="Botoncito" type="button" value="Seleccionar fechas"
              onclick="myFunction(document.getElementById('nfechas').value)" required>
          </div>
		</div>
          <br>
          <div class="row">
            <input type="submit" value="Crear espectaculo multiple">
          </div>
    </form>

    <div>

    </div>
  </div>



</body>

</html>
