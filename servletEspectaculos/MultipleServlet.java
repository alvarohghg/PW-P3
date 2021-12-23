package MultipleServlet;

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
import es.uco.pw.business.user.EspectaculoMultiple;
import es.uco.pw.business.user.GestorEspectaculos;
import es.uco.pw.business.user.AbstractEspectaculo;
import es.uco.pw.business.user.AbstractFactoryEspectaculo;
import es.uco.pw.business.user.ConcreteFactoryEspectaculo;
/**
 * Servlet implementation class RegistroUsuarios
 */
@WebServlet("/MultipleServlet")
public class MultipleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultipleServlet() {
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
		String titulo_mult = request.getParameter("titulo_mult"); 
		String desc_mult = request.getParameter("desc_mult");
		categoria categoria_mult = Enum.valueOf(categoria.class ,request.getParameter("categoria_mult"));
		int aforo_mult = request.getParameter("aforo_mult");
		int loc_mult = request.getParameter("loc_mult");
		int num_fechas = request.getParameter("nfechas");
		ArrayList<Date> fechas_mult=new ArrayList<Date>;
		for(int i=1;i<num_fechas;i++) {
			fechas[i]=request.getParameter("Fecha"+i);
		}

		MultipleDAO MDAO=new MultipleDAO();
		EspectaculoMultiple multiple = new EspectaculoMultiple(); 
		GestorEspectaculos GE =new GestorEspectaculos();
		
		//Introducimos lo valores en la base de datos
		GE.guardarBDListas();
		response.setContentType("text/html");
		PrintWriter salida= response.getWriter();
		if(GE.existeEspectaculo(titulo_mult)) {
			salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
			salida.println("alert('Error al crear el espectaculo multiple');");
			/*TO DO
			salida.println("location='';");
			*/
			salida.println("</script></body></HTML> ");
			
		}else {
			multiple.setTitulo(titulo_mult);
			multiple.setDescripcion(desc_mult);
			multiple.setCategoria(categoria_mult);
			multiple.setAforolocalidades(aforo_mult);
			multiple.setLocalidadesvendidas(loc_mult);
			multiple.setListaFechas(fechas_mult);
			MDAO.escribirMultipleBD(multiple);
			salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
			salida.println("alert('Espectaculo multiple creado correctamente');");
			//TO DO la location
			salida.println("location='';");
			salida.println("</script></body></HTML> ");
			
		}
	
	}
	
	

}
