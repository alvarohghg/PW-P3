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
/**
 * Servlet implementation class modDatosAdm
 */
@WebServlet("/modDatosAdm")
public class modDatosAdm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modDatosAdm() {
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
		String correo = request.getParameter("correo"); 
		String nombre = request.getParameter("nombre"); 
		String apellidos = request.getParameter("apellidos"); 
		String nick = request.getParameter("nick");
		String pass = request.getParameter("password");

		UsuarioDAO UDAO=new UsuarioDAO();
		Usuario user = new Usuario();
		GestorUsuario GU =new GestorUsuario();
		/*
		LLamamos las funciones de modificar los datos, dentro de ellas ya se cambia en la base de datos
		*/
		
		if(nombre.equals("")==false){
			GU.updateUser(correo, nombre, null, null, null,null, 2);
		}
		if(apellidos.equals("")==false){
			GU.updateUser(correo, null, apellidos, null, null,null, 3);
		}
		if(nick.equals("")==false){
			GU.updateUser(correo, null, null, nick, null,null, 1);
		}
		if(pass.equals("")==false){
			GU.updateUser(correo, null, null, null, null,pass, 5);
		}
		
		response.setContentType("text/html");
		PrintWriter salida= response.getWriter();
		salida.println("<!DOCTYPE html>");
		salida.println("<html>");
		salida.println("<head>");
		salida.println("<meta charset='UTF-8'>");
		salida.println("<title>Guardando datos</title>");
				
		salida.println("<style>");
		salida.println("button {");
	    salida.println("background-color: #bd7df280;");
	    salida.println("border: none;");
	    salida.println("color: black;");
	    salida.println("padding: 20px;");
	    salida.println("text-align: center;");
	    salida.println("text-decoration: none;");
	    salida.println("display: inline-block;");
	    salida.println("font-size: 16px;");
	    salida.println(" margin: 4px 2px;");
	    salida.println("cursor: pointer;");
	    salida.println("}");
	
	    salida.println(".button1 {");
	    salida.println("border-radius: 8px;");
	    salida.println("}");
	    salida.println("body {");
	    salida.println("background-image: url(' https://i.imgur.com/l4nKkCG.png ');");
	    salida.println("background-repeat: no-repeat;");
	    salida.println("background-attachment: fixed; ");
	    salida.println("background-size: cover;");
	    salida.println("}");
					
		salida.println("</style>");
		salida.println("</head>");
		salida.println("<body>");
		salida.println("<caption><h2 style='text-align:left'>Datos modificados correctamente</h2></caption>");
		salida.println("<a style='text-align:left' href='/aaaa/index.jsp'>");
	    salida.println("<button class='button1' type='button'>Desconectar</button>");
		salida.println("</a>");
		salida.println("</body>");
		salida.println("</html>");
	}

}
