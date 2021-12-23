<!DOCTYPE html>
<html>
<head>
<style>
* {
  box-sizing: border-box;
  
}

input[type=text], select, textarea {

  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
  background-color:#d9acfa;
  
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
  .col-25, .col-75, input[type=submit] {
  
    width: 100%;
    margin-top: 0;
  }
}
</style>
</head>
<body>



<div class="container">
  <form method="post" action="/aaaa/TemporadaServlet">
  <div class="row">
    <div class="col-25">
      <label for="titulo_temp">Titulo</label>
    </div>
    <div class="col-75">
      <input type="text" id="titulo_temp" name="titulo_temp" placeholder="Titulo del espectaculo de temporada" required>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="desc_temp">Descripcion</label>
    </div>
    <div class="col-75">
      <textarea id="desc_temp" name="desc_temp" placeholder="Descripcion del espectaculo de temporada" style="height:100px" required></textarea>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="categoria_temp">Categoria</label>
       <select id="categoria_temp" name="categoria_temp">
        <option value="obra">obra</option>
        <option value="concierto">concierto</option>
        <option value="monologo">monologo</option>
      </select>
    </div>
  <div class="row">
    <div class="col-25">
      <label for="aforo_temp">Aforo</label>
    </div>
    <div class="col-75">
      <input type="text" id="aforo_temp" name="aforo_temp" placeholder="Aforo del espectaculo de temporada" required>
    </div>
  </div>
   <div class="row">
    <div class="col-25">
      <label for="loc_temp">Localidades vendidas</label>
    </div>
    <div class="col-75">
      <input type="text" id="loc_temp" name="loc_temp" placeholder="Localidades vendidas del espectaculo de temporada" required>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="dia_temp">Dia de la semana</label>
       <select id="dia_temp" name="dia_temp">
        <option value="Lunes">Lunes</option>
        <option value="Martes">Martes</option>
        <option value="Miercoles">Miercoles</option>
        <option value="Jueves">Jueves</option>
        <option value="Viernes">Viernes</option>
        <option value="Sabado">Sabado</option>
        <option value="Domingo">Domingo</option>
      </select>
    </div>
  <div class="row">
    <div class="col-25">
      <label for="inicio_temp">Inicio de temporada</label>
    </div>
    <div class="col-75">
      <input type="date" id="inicio_temp" name="inicio_temp" placeholder="Fecha de inicio de temporada" required>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="fin_temp">Fin de temporada</label>
    </div>
    <div class="col-75">
      <input type="date" id="fin_temp" name="fin_temp" placeholder="Fecha de fin de temporada" required>
    </div>
  </div>
  <br>
  <div class="row">
    <input type="submit" value="Crear espectaculo de temporada" required>
  </div>
  </form>
</div>

</body>
</html>


