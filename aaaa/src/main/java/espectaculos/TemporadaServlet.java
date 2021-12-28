package espectaculos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.uco.pw.business.user.Usuario ;
import es.uco.pw.data.dao.UsuarioDAO;
import es.uco.pw.data.dao.TemporadaDAO;
import es.uco.pw.business.user.GestorUsuario;
import java.time.LocalDate;
import java.util.Date;
import java.sql.*;
import java.util.*;
import es.uco.pw.business.user.EspectaculoTemporada;
import es.uco.pw.business.user.GestorEspectaculos;
import es.uco.pw.business.user.AbstractEspectaculo;
import es.uco.pw.business.user.AbstractEspectaculo.categoria;
import es.uco.pw.business.user.AbstractFactoryEspectaculo;
/**
 * Servlet implementation class RegistroUsuarios
 */
@WebServlet("/TemporadaServlet")
public class TemporadaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @return 
     * @see HttpServlet#HttpServlet()
     */
    public TemporadaServlet() {
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
		String titulo_temp = request.getParameter("titulo_temp"); 
		String desc_temp = request.getParameter("desc_temp");
		categoria categoria_temp = Enum.valueOf(categoria.class ,request.getParameter("categoria_temp"));
		int aforo_temp = Integer.parseInt(request.getParameter("aforo_temp"));
		int loc_temp = Integer.parseInt(request.getParameter("loc_temp"));
		String dia_temp = request.getParameter("dia_temp");
		java.sql.Date inicio_temp =java.sql.Date.valueOf(request.getParameter("inicio_temp"));
		java.sql.Date fin_temp =java.sql.Date.valueOf(request.getParameter("fin_temp"));

		TemporadaDAO TDAO=new TemporadaDAO();
		EspectaculoTemporada temporada = new EspectaculoTemporada(); 
		GestorEspectaculos GE =new GestorEspectaculos(); 
		response.setContentType("text/html");
		PrintWriter salida= response.getWriter();
		//si el titulo existe ya mandamos un mensaje de error
		if(GE.existeEspectaculo(titulo_temp)) {
			salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
			salida.println("alert('Error al crear el espectaculo de temporada');");
			salida.println("location='/aaaa/index.jsp';");			
			salida.println("</script></body></HTML> ");
			
		}else {
			//Introducimos lo valores en la base de datos
			temporada.setTitulo(titulo_temp);
			temporada.setDescripcion(desc_temp);
			temporada.setCategoria(categoria_temp);
			temporada.setAforolocalidades(aforo_temp);
			temporada.setLocalidadesvendidas(loc_temp);
			temporada.setDia(dia_temp);
			temporada.setInicio(inicio_temp);
			temporada.setFin(fin_temp);
			TDAO.escribirTemporadaBD(temporada);
			//Codigo HTML de confirmacion de la creacion del espectaculo
			salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
			salida.println("alert('Espectaculo de temporada creado correctamente');");
			salida.println("location='/aaaa/index.jsp';");
			salida.println("</script></body></HTML> ");
			
		}
	
	}
	
	

}
