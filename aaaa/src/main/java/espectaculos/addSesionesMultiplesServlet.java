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
		// TODO Auto-generated method stub
			PrintWriter salida= response.getWriter();
			String titulo = request.getParameter("titulo");
			Date nueva_fecha = request.getParameter("nueva_fecha");
		 	MultipleDAO MDAO=new MultipleDAO();
			
			MDAO.escribirMultipleFechaBD(titulo,nueva_fecha);
				
			salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
			salida.println("alert('Sesion añadida correctamente');");
			salida.println("location='/aaaa/index.jsp';");
			salida.println("</script></body></HTML> ");
			}
			
			
		 
	}

}
