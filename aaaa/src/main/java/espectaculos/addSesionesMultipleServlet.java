package espectaculos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.uco.pw.data.dao.MultipleDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import es.uco.pw.business.user.EspectaculoMultiple;
import es.uco.pw.business.user.GestorEspectaculos;
import es.uco.pw.business.user.AbstractEspectaculo.categoria;
/**
 * Servlet implementation class CancelarSesiones
 */
@WebServlet("/addSesionesMultipleServlet")
public class addSesionesMultipleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addSesionesMultipleServlet() {
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
		//Recojemos los datos de la vista
		String titulo= request.getParameter("titulo");
		java.sql.Date fecha=java.sql.Date.valueOf(request.getParameter("fecha"));
		MultipleDAO MDAO=new MultipleDAO();
		boolean aux=false;
		//llamamos a la funcion para añadir la sesion a la base de datos
		if(MDAO.escribirMultipleFechaBD(titulo,fecha)){
			aux=true;
		}
		//Codigo HTML
		response.setContentType("text/html");
		PrintWriter salida= response.getWriter();
		if(aux) {
			//Codigo HTMLsi se ha añadido correctamente
			salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
			salida.println("alert('Fecha añadida con exito');");
			salida.println("location='/aaaa/mvc/view/Admin.jsp';");
			salida.println("</script></body></HTML> ");
			
		}else {
			//Codigo HTML si ha ahabido algun error
			salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
			salida.println("alert('Error al añadir la fecha');");
			salida.println("location='/aaaa/index.jsp';");
			salida.println("</script></body></HTML> ");
			

		}
	}
}
	
