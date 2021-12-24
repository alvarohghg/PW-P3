package espectaculos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.business.user.GestorEspectaculos;
import es.uco.pw.business.user.AbstractEspectaculo.categoria;

/**
 * Servlet implementation class ModTemp
 */
@WebServlet("/ModTemp")
public class ModTemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModTemp() {
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
		String titulo_viejo = request.getParameter("titulo_viejo"); 
		String descripcion = request.getParameter("descripcion");
		categoria categoria=null;
		if(request.getParameter("categoria").equals("")) {
			categoria=categoria.cualquiera;
		}
		else {
			categoria = Enum.valueOf(categoria.class ,request.getParameter("categoria"));
		}
		int aforo;
		if(request.getParameter("aforo").equals("")) {
			aforo=0;
		}
		else {
			aforo = Integer.parseInt(request.getParameter("aforo"));
		}
		int entradas;
		if(request.getParameter("entradas").equals("")) {
			entradas=0;
		}
		else {
			entradas = Integer.parseInt(request.getParameter("entradas"));
		}
		String dia = request.getParameter("dia");

		java.sql.Date inicio=null;
		String sinicio=request.getParameter("inicio");
		if(sinicio.equals("")==false) {
			inicio= java.sql.Date.valueOf(sinicio);
		}
		java.sql.Date fin=null;
		String sfin=request.getParameter("fin");
		if(sfin.equals("")==false) {
			fin= java.sql.Date.valueOf(sfin);
		}
		
		GestorEspectaculos GE = new GestorEspectaculos();
		
		if(descripcion.equals("")==false){
			GE.updateEspectaculoT(titulo_viejo, null, descripcion, null, 0, 0, null, null, null, 2);
		}
		if(categoria.equals(categoria.cualquiera)==false){
			GE.updateEspectaculoT(titulo_viejo, null, null, categoria, 0, 0, null, null, null, 3);
		}
		if(aforo!=0){
			GE.updateEspectaculoT(titulo_viejo, null, null, null, aforo, 0, null, null, null, 4);
		}
		if(entradas!=0){
			GE.updateEspectaculoT(titulo_viejo, null, null, null, 0, entradas, null, null, null, 5);
		}
		if(dia.equals("")==false){
			GE.updateEspectaculoT(titulo_viejo, null, null, null, 0, 0, null, null, dia, 6);
		}
		if(sinicio.equals("")==false){
			GE.updateEspectaculoT(titulo_viejo, null, null, null, 0, 0, null, inicio, null, 7);
		}
		if(sfin.equals("")==false){
			GE.updateEspectaculoT(titulo_viejo, null, null, null, 0, 0, fin, null, null, 8);
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
