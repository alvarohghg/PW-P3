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
import es.uco.pw.data.dao.MultipleDAO;
import es.uco.pw.data.dao.TemporadaDAO;

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
 * Servlet implementation class BorrarEspect
 */
@WebServlet("/BorrarEspect")
public class BorrarEspect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarEspect() {
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
		String titulo=request.getParameter("titulo");
		GestorEspectaculos GE=new GestorEspectaculos();
		MultipleDAO MDAO=new MultipleDAO();
		TemporadaDAO TDAO=new TemporadaDAO();
		PuntualDAO PDAO=new PuntualDAO();

		int tipo=GE.tipoEvento(titulo);
		if(tipo==1) {
			MDAO.eliminarMultipleTitulo(titulo);
		}
		else if(tipo==2) {
			TDAO.eliminarTemporadaTitulo(titulo);
		}
		else if(tipo==3) {
			PDAO.eliminarPuntualTitulo(titulo);
		}
		response.setContentType("text/html");
		PrintWriter salida= response.getWriter();
		salida.println("<HTML> <body style='background-color: black' ><script defer type=\"text/javascript\">");
		salida.println("alert('Espectaculo eliminado');");
		salida.println("location='/aaaa/mvc/view/Admin.jsp';");
		salida.println("</script></body></HTML> ");
	}

}
