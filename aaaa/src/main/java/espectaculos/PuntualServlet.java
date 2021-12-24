package espectaculos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.uco.pw.business.user.Usuario ;
import es.uco.pw.data.dao.PuntualDAO;
import es.uco.pw.data.dao.UsuarioDAO;
import es.uco.pw.business.user.GestorUsuario;
import java.time.LocalDate;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import es.uco.pw.business.user.EspectaculoPuntual;
import es.uco.pw.business.user.GestorEspectaculos;
import es.uco.pw.business.user.AbstractEspectaculo;
import es.uco.pw.business.user.AbstractEspectaculo.categoria;
import es.uco.pw.business.user.AbstractFactoryEspectaculo;
/**
 * Servlet implementation class RegistroUsuarios
 */
@WebServlet("/PuntualServlet")
public class PuntualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PuntualServlet() {
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
		/*NO SE COMO VAN LOS TIPOS DE FECHA Y CATEGORIA*/
		String titulo_punt = request.getParameter("titulo_punt"); 
		String desc_punt = request.getParameter("desc_punt");
		categoria categoria_punt = Enum.valueOf(categoria.class ,request.getParameter("categoria_punt"));
		int aforo_punt = Integer.parseInt(request.getParameter("aforo_punt"));
		int loc_punt = Integer.parseInt(request.getParameter("loc_punt"));
		java.sql.Date fecha_punt=java.sql.Date.valueOf(request.getParameter("fecha_punt"));
		
		PuntualDAO PDAO=new PuntualDAO();
		EspectaculoPuntual puntual = new EspectaculoPuntual(); 
		GestorEspectaculos GE =new GestorEspectaculos(); 
		//Introducimos lo valores en la base de datos
		//GU.guardarBDU();
		response.setContentType("text/html");
		PrintWriter salida= response.getWriter();
		if(GE.existeEspectaculo(titulo_punt)) {
			salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
			salida.println("alert('Error al crear el espectaculo puntual');");
			salida.println("location='/aaaa/index.jsp';");
			salida.println("</script></body></HTML> ");
			
		}else {
			puntual.setTitulo(titulo_punt);
			puntual.setDescripcion(desc_punt);
			puntual.setCategoria(categoria_punt);
			puntual.setAforolocalidades(aforo_punt);
			puntual.setLocalidadesvendidas(loc_punt);
			puntual.setFechaPuntual((java.sql.Date) fecha_punt);
			PDAO.escribirPuntualBD(puntual);
			salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
			salida.println("alert('Espectaculo puntual creado correctamente');");
			salida.println("location='/aaaa/index.jsp';");
			salida.println("</script></body></HTML> ");
			
		}
	
	}
	
	

}