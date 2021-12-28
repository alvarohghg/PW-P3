package criticas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.business.user.Criticas;
import es.uco.pw.business.user.GestorCriticas;
import es.uco.pw.data.dao.CriticasDAO; 

/**
 * Servlet implementation class EliminarCritca
 */
@WebServlet("/ValorarCritica")
public class ValorarCritica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValorarCritica() {
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
		//Recojemos los datos de la vista y llamamos a la funcion votar crittica
		String titulo = request.getParameter("titulo");
		String correo = request.getParameter("correo");
		String valoracion = request.getParameter("valoracion");
		Float puntuacion= Float.parseFloat(valoracion);
		GestorCriticas C= GestorCriticas.getInstancia();
		int result=C.votarCritica(correo, puntuacion, titulo);
		
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
			  out.println("button {");
			  out.println("background-color: #bd7df280;");
			  out.println("border: none;");
			  out.println("color: black;");
			  out.println("padding: 4px;");
			  out.println("text-align: center;");
			  out.println(" text-decoration: none;");
			  out.println(" display: inline-block;");
			  out.println(" font-size: 13.3px;");
			  out.println(" margin: 1px 1px;");
			  out.println(" cursor: pointer;");
			  out.println("}");
			  out.println(".button1 {");
			  out.println("	text-align: center;");
			  out.println("	border-radius: 8px;");
	  		  out.println("}");
			  out.println("</style>");  
			  out.println("</head>");
			  out.println("<body>");
			  //dependiendo de valor de result si es 0 es que no hay error, si es otro valor es que hemos intentado votar la misma critica varias veces desde el mismo usuario
			  if(result==0) {
				  out.println("<script defer type=\"text/javascript\">");
				  out.println("alert('Critica votada con exito');");
				  out.println("</script>");
				 
				  out.println("<form method='post' action='/aaaa/mvc/view/Espectador.jsp'>");
				  out.println("<button class='button1' type='submit' value='"+correo+"' id='correo' name='correo'>Ir a menu</button>");
				  out.println("</form>");
				  
			  }
			  else {
				  
				  out.println("<script defer type=\"text/javascript\">");
				  out.println("alert('No puede valorar 2 veces la misma critica');");
				  out.println("</script>");
				
				  out.println("<form method='post' action='/aaaa/mvc/view/ValorarCritica.jsp'>");
				  out.println("<button class='button1' type='submit' value='"+correo+"' id='correo' name='correo'>Reintentar</button>");
				  out.println("</form>");
				  
			  }
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
