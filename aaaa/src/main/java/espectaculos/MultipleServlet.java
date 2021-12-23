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
		int aforo_mult = Integer.parseInt(request.getParameter("aforo_mult"));
		int loc_mult = Integer.parseInt(request.getParameter("loc_mult"));
		int num_fechas = Integer.parseInt(request.getParameter("nfechas"));
		ArrayList<java.sql.Date> fechas_mult=new ArrayList<java.sql.Date>();
		for(int i=1;i<=num_fechas;i++) {
				String pasando="Fecha" + i;
				
				String sfecha=request.getParameter(pasando);
				
				java.sql.Date ufecha= java.sql.Date.valueOf(sfecha);
				
				fechas_mult.add(ufecha);
		}

		
		EspectaculoMultiple multiple = new EspectaculoMultiple(); 
		GestorEspectaculos GE =new GestorEspectaculos();
		
		//Introducimos lo valores en la base de datos
		response.setContentType("text/html");
		PrintWriter salida= response.getWriter();
		if(GE.existeEspectaculo(titulo_mult)) {
			salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
			salida.println("alert('Error al crear el espectaculo multiple');");
			salida.println("location='/aaaa/index.jsp';");
			salida.println("</script></body></HTML> ");
			
		}else {
			
			
			GE.registerEspectaculoM(titulo_mult, desc_mult, categoria_mult, aforo_mult, loc_mult, fechas_mult);
			if(GE.existeEspectaculo(titulo_mult)){
				salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
				salida.println("alert('Espectaculo multiple creado correctamente');");
				salida.println("location='/aaaa/index.jsp';");
				salida.println("</script></body></HTML> ");
			}
			else {
				salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
				salida.println("alert('Espectaculo multiple no creado');");
				salida.println("location='/aaaa/index.jsp';");
				salida.println("</script></body></HTML> ");
			}
			
			
			
			
		}
	
	}
	
	

}
