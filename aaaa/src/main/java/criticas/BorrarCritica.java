package criticas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.uco.pw.data.dao.CriticasDAO; 

/**
 * Servlet implementation class EliminarCritca
 */
@WebServlet("/BorrarCritica")
public class BorrarCritica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarCritica() {
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
		String titulo = request.getParameter("titulo");
		String correo = request.getParameter("correo");
		CriticasDAO CDAO=new CriticasDAO();
		CDAO.borraCriticaBD(titulo, correo);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			  out.println("<!DOCTYPE html>");
			  out.println("<html>");
			  out.println("<head>");
			  out.println("<meta charset=\"utf-8\">");  
			  out.println("<title>Critica Eliminada</title>");
			  out.println("<style>");     
			  out.println("body {");
			  out.println("background-image: url(' https://i.imgur.com/l4nKkCG.png');");
			  out.println("background-repeat: no-repeat;");
			  out.println("background-attachment: fixed;  ");
			  out.println("background-size: cover;");
			  out.println("}");   
			  out.println("</style>");  
			  out.println("</head>");
			  out.println("<body>");
				  out.println("<script defer type=\"text/javascript\">");
				  out.println("location='/aaaa/mvc/view/Espectador.jsp';");
				  out.println("alert('Critica eliminada con exito');");
				  out.println("</script>");
			  out.println("<form>");
			  out.println("<input type='hidden' value='<%= correo %>' id='correo' name='correo'> ");
			  out.println("</form>");
			  out.println("</body>");
			  out.println("</html>");

	}
		/*
		 * 	salida.println("<script defer type=\"text/javascript\">");
			salida.println("alert('Usuario creado correctamente');");
			salida.println("location='/aaaa/index.jsp';");
			salida.println("</script></body></HTML> ");
		 */
}
