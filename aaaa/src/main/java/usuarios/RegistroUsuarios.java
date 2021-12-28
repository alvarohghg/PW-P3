package usuarios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.uco.pw.business.user.Usuario ;
import es.uco.pw.data.dao.UsuarioDAO;
import es.uco.pw.business.user.GestorUsuario;
import java.time.LocalDate;
import java.util.Date;
import java.sql.*;
import java.util.*;

/**
 * Servlet implementation class RegistroUsuarios
 */
@WebServlet("/RegistroUsuarios")
public class RegistroUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre"); 
		String apellidos = request.getParameter("apellidos");
		String nick = request.getParameter("nick");
		String correo = request.getParameter("correo");
		String tipo = request.getParameter("tipo");
		String pass = request.getParameter("password");
		//Conseguimos la fecha actual 
	 	Date date = new Date();
   		long timeInMilliSeconds = date.getTime();
		java.sql.Date fecha = new java.sql.Date(timeInMilliSeconds) ; 
	
		UsuarioDAO UDAO=new UsuarioDAO();
		Usuario user = new Usuario(); 
		GestorUsuario GU =new GestorUsuario(); 
		//Introducimos lo valores en la base de datos
		GU.guardarBDU();
		response.setContentType("text/html");
		PrintWriter salida= response.getWriter();
		//Mostramos el aviso de error si existe un usuario en la base de datos con el mismo correo
		if(GU.existeUsuario(correo)) {
			salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
			salida.println("alert('Error al crear el usuario');");
			salida.println("location='/aaaa/mvc/view/Registro.jsp';");
			salida.println("</script></body></HTML> ");
		}else { //mostramos un mensaje cuando se realice el registro de forma correcta
			user.setNombre(nombre);
			user.setApellidos(apellidos);
			user.setNick(nick);
			user.setCorreo(correo);
			user.setTipo(tipo);
			user.setPass(pass);
			user.setRegistro(fecha);
			user.setUltima(null);
			UDAO.escribirUsuarioBD(user);
			salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
			salida.println("alert('Usuario creado correctamente');");
			salida.println("location='/aaaa/index.jsp';");
			salida.println("</script></body></HTML> ");
			
		}
	
	}
	
	

}
