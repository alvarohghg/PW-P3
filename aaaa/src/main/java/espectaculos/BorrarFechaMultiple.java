package espectaculos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.business.user.GestorEspectaculos;
import es.uco.pw.data.dao.MultipleDAO;
import es.uco.pw.data.dao.PuntualDAO;
import es.uco.pw.data.dao.TemporadaDAO;

/**
 * Servlet implementation class BorrarFechaMultiple
 */
@WebServlet("/BorrarFechaMultiple")
public class BorrarFechaMultiple extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarFechaMultiple() {
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
		//Recogemos el titulo y la fecha y llamamos a la funcion correspondiente del DAO para eliminar la 
		//sesión dada una fecha y un titulo
		String titulo=request.getParameter("titulo");
		java.sql.Date fecha=java.sql.Date.valueOf(request.getParameter("fecha"));
		MultipleDAO MDAO=new MultipleDAO();
		MDAO.eliminarMultipleFecha(titulo, fecha);
		
		response.setContentType("text/html");
		PrintWriter salida= response.getWriter();
		salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
		salida.println("alert('Fecha eliminada correctamente');");
		salida.println("location='/aaaa/mvc/view/Admin.jsp';");
		salida.println("</script></body></HTML> ");
	}

}
