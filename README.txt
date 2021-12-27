Cuando ejecutas el programa ya sea desde eclipse o con desde consola con el .jar, lo primero que nos sale es un menú donde
podemos hacer 2 cosas: registrarse o iniciar sesión.
Si decidimos registrarnos, vamos a tener que introducir por consola el correo (que debe ser único), el nombre, los apellidos, el nick y el tipo de usuario que eres.
Si iniciamos sesión deberemos introducir el correo y la contraseña. El programa indicará cúando se ha iniciado sesión correctamente y cuándo no.
Usuarios:
Administrador: Usuario: admin Password: admin
Espectador: Usuario: josecama@uco.es Password: 1234
Una vez iniciado sesión aparecerá el menu de las operaciones que podemos realizar dependiendo del tipo de usuario.

El usuario administrador puede:
Ver lista de usuarios: Es la misma función que se realizó en la práctica 2. Redirige a una página donde se listan en forma de tabla todos 
los usuarios de la base de datos, donde puedes modificar tus datos en un boton que te sale al lado de tu usuario.

Dar de alta un espectáculo: Al seleccionar está opción será conducido a otra página donde elegirá qué tipo de espectáculo dará de 
alta (Múltiple, Puntual o de Temporada) y desde ahí se ramifica en 3 opciones diferentes, donde se le requerirá el ingreso de los 
datos del espectáculo que variarán en función de su tipo escogido. En el caso de los espectáculos puntuales, se selecciona
una única fecha mediante un calendario interactivo; en los de temporada se selecciona mediante un desplegable el día de
la semana y dos fechas (inicio y fin); en los espectáculos múltiples se selecciona, en primer lugar, el número de sesiones
a añadir, para seguidamente seleccionar, en los n calendarios que se despliegarán, las sesiones. Independientemente del tipo,
se deberá seleccionar el título, categoría, descripción, aforo y localidades vendidas.

Añadir un espectáculo: Redirige a una segunda página en la que se listan los espectáculos múltiples, donde el usuario deberá 
elegir el espectáculo múltiple al que añadirá una sesión. Una vez elegido, se le conducirá a una última página donde seleccionará 
la fecha de la nueva sesión a añadir. Cuando finalice el proceso se mostrará un mensaje.

Modificar un espectáculo: Se muestra un listado de todos los espectáculos de la base de datos y una vez seleccionado se dirigirá 
al usuario a una tercera página donde modificar los datos, que dependerá como siempre del tipo de espectáculo.

Cancelar un espectáculo: Se muestra un listado de los espectáculos y se presentan dos opciones, eliminar el espectáculo de la base 
de datos o bien una sesión en concreto. Si elige eliminar al completo, se muestra un mensaje y si no, se elegirá una fecha para eliminar.


El espectador puede:
Buscar espectáculo: Se introducen los datos que se deseen tomar en consideración en la búsqueda y se muestran los datos del espectáculo.

Publicar crítica: Se dirige a un formulario para rellenar los datos de la nueva crítica, donde al final te saltara un mensaje si se ha creado correctamente o no.

Consultar una crítica: En primer lugar muestra las críticas existentes en la base de datos, mostrando también sus autores. Una vez 
seleccionada la crítica se dirige a una tercera página donde todos los datos pertinentes de la crítica son mostrados.

Valorar una crítica: Se muestran todas las críticas que no pertenezcan al usuario conectado y se valora con una puntuación de 1-5. Si 
ha realizado una valoraciona esa critica, se mostrará un mensaje de error.

Eliminar una crítica: Si existen críticas del usuario con el que se ha iniciado sesión, se mostrarán junto con una opción que al ser 
seleccionada serán eliminadas. En caso contrario, se notifica con un mensaje que no existen críticas.
