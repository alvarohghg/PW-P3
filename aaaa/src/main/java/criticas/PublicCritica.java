package criticas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.business.user.Criticas;
import es.uco.pw.business.user.GestorCriticas;
import es.uco.pw.business.user.GestorEspectaculos;
import es.uco.pw.data.dao.CriticasDAO; 


/**
 * Servlet implementation class PublicCritica
 */
@WebServlet("/PublicCritica")
public class PublicCritica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicCritica() {
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
		//Recojemos los datos desde la vista
		String titulo = request.getParameter("titulo");
		String espectaculo = request.getParameter("espectaculo");
		String puntuacion = request.getParameter("puntuacion");
		String review = request.getParameter("review");
		String correo = request.getParameter("correo");
		CriticasDAO CDAO=new CriticasDAO();
		Criticas critica = new Criticas(); 
		GestorCriticas GC = new GestorCriticas();
		GestorEspectaculos GE = new GestorEspectaculos();
		GC.guardarBDC();
		response.setContentType("text/html");
		PrintWriter salida= response.getWriter();
		//codigo HTML
		if(GC.existeTitulo(titulo)  ) {
			//Mensaje de cuando el titulo que utilizamos para la critica ya esta en uso
			salida.println("<HTML> <body style='background-color: black'><script defer type=\"text/javascript\">");
			salida.println("alert('El titulo de la critica ya esta en uso');");
			salida.println("location='/aaaa/mvc/view/PubliCrit.jsp';");
			salida.println("</script></body></HTML> ");
		}else {
			if(GE.existeEspectaculo(espectaculo)) {
				if(GC.crearCritica(titulo, espectaculo, puntuacion, review, correo, "0")) {
					//Mensaje de alerta cuando hay no fallo al crear la critica					
					salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
					salida.println("alert('Critica creada correctamente');");
					salida.println("location='/aaaa/index.jsp';");
					salida.println("</script></body></HTML> ");
				}else {
					//Mensaje de alerta cuando hay fallo al crear la critica
					salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
					salida.println("alert('Critica no creada');");
					salida.println("location='/aaaa/index.jsp';");
					salida.println("</script></body></HTML> ");
				}
				
			}
			else {
				salida.println("<HTML> <body style='background-color: black'><script defer type=\"text/javascript\">");
				salida.println("alert('El espectaculo no existe');");
				salida.println("location='/aaaa/index.jsp';");
				salida.println("</script></body></HTML> ");
			}
			
		}
	}

}
