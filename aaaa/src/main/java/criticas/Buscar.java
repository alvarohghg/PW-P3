package criticas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.business.user.AbstractEspectaculo.categoria;
import es.uco.pw.business.user.EspectaculoMultiple;
import es.uco.pw.business.user.EspectaculoPuntual;
import es.uco.pw.business.user.EspectaculoTemporada;
import es.uco.pw.business.user.GestorEspectaculos;


/**
 * Servlet implementation class Buscar
 */
@WebServlet("/Buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buscar() {
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
		String titulo = request.getParameter("titulo");
		categoria cate = Enum.valueOf(categoria.class ,request.getParameter("cate"));
		String correo = request.getParameter("correo");
		GestorEspectaculos GE=new GestorEspectaculos();
		ArrayList<EspectaculoMultiple> ListaM=new ArrayList<EspectaculoMultiple>();
		ArrayList<EspectaculoPuntual> ListaP=new ArrayList<EspectaculoPuntual>();
		ArrayList<EspectaculoTemporada> ListaT=new ArrayList<EspectaculoTemporada>();
		ListaP=GE.getListaEspectaculosP();
		ListaT=GE.getListaEspectaculosT();
		ListaM=GE.getListaEspectaculosM();
		ArrayList<String> l= new ArrayList<String>();
		if(cate.equals(categoria.cualquiera)==false ) {
			for(int i=0;i<ListaM.size();i++){
				if(cate.equals(ListaM.get(i).getCategoria())==true && (ListaM.get(i).getTitulo().equals(titulo)==true || titulo.equals("")==true )){
					l.add(ListaM.get(i).getTitulo());
				}
			}
			for(int i=0;i<ListaT.size();i++) {
				if(cate.equals(ListaT.get(i).getCategoria())==true && (ListaT.get(i).getTitulo().equals(titulo)==true || titulo.equals("")==true )) {
					l.add(ListaT.get(i).getTitulo());
				}
			}
			for(int i=0;i<ListaP.size();i++) {
				if(cate.equals(ListaP.get(i).getCategoria())==true && (ListaP.get(i).getTitulo().equals(titulo)==true || titulo.equals("")==true )){
					l.add(ListaP.get(i).getTitulo());
				}
			}
		}
		else {
			for(int i=0;i<ListaM.size();i++){
				if(ListaM.get(i).getTitulo().equals(titulo)==true || titulo.equals("")==true ){
					l.add(ListaM.get(i).getTitulo());
				}
			}
			for(int i=0;i<ListaT.size();i++) {
				if(ListaT.get(i).getTitulo().equals(titulo)==true || titulo.equals("")==true ) {
					l.add(ListaT.get(i).getTitulo());
				}
			}
			for(int i=0;i<ListaP.size();i++) {
				if(ListaP.get(i).getTitulo().equals(titulo)==true || titulo.equals("")==true ){
					l.add(ListaP.get(i).getTitulo());
				}
			}
		}
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Buscar Critica</title>");
			out.println("<script type='text/javascript'		src='https://gc.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js?attr=3LlJ-wB58tFgtSAd3VGusyaoDA75PD3oC6tP-KCmBRacoky2HPsLTm9A-jNH3xwoIKj97_Zv5Y736K8Bo1sY4xcrjLNNZW3XwKHI6fy-dgCRB_b02vc-6WAXI-VMKSe-0_mm-pX8-QaOyunbvKNbJg'charset='UTF-8'></script>");
			out.println("<style>");
				out.println("table {");
				out.println("border-collapse: collapse;");
				out.println("width: 50%;");
				out.println("}");
				out.println("button {");
				out.println("background-color: #bd7df280;");
				out.println("border: none;");
				out.println("color: black;");
				out.println("padding: 4px;");
				out.println("text-align: center;");
				out.println("text-decoration: none;");
				out.println("display: inline-block;");
				out.println("font-size: 13.3px;");
				out.println(" margin: 1px 1px;");
				out.println("cursor: pointer;");
				out.println("}");
				out.println(".button1 {");
				out.println("text-align: center;");
				out.println("border-radius: 8px;");
				out.println("}");
				out.println("th, td {");
				out.println(" text-align: left;");
				out.println(" padding: 8px;");
				out.println(" border-bottom: 1px solid #ddd;");
				out.println("}");
				out.println("body {");
				out.println("  background-image: url('https: //i.imgur.com/l4nKkCG.png');");
				out.println("  background-repeat: no-repeat;");
				out.println("  background-attachment: fixed;");
				out.println("  background-size: cover;");
				out.println("}");
				out.println("tr:hover {background-color: pink;}");
				out.println("tr:nth-child(odd) {background-color: #cc6699;}");
				out.println("tr:nth-child(even) {background-color: #993366;}");
				out.println("</style>");    
			out.println("</head>");
			out.println("<body>");
			if(titulo.equals("")==true || GE.existeEspectaculo(titulo)) {
				out.println("<div align='center'>");
			    out.println("<table  border='0' cellpadding=5  >");
		        out.println("<tr>");
	            out.println(" <th>Titulo</th>");
	            out.println("<th>Categoria</th>");
	            out.println(" </tr>");
	            for(int i=0; i< l.size();i++){ 
		            out.println("<tr >");
		                out.println("<td>"+ l.get(i) +" </td>");
		                out.println("<td>"+ GE.queCate(titulo) +"</td>");
		            out.println("<td >");
	                out.println("<form method='post' action= 'verEspectaculo.jsp'>");
	                    out.println("<button class='button1' type=submit value="+ titulo +" id='titulo' name='titulo'>Ver Espectaculo</button>");
	                out.println("</form>");
	                out.println("</tr>");
				 } 
		        out.println("</table>");
		        out.println("</div>");
			}
			else {
				out.println("<script defer type=\"text/javascript\">");
				out.println("alert('No existe un espectaculo con ese titulo');");
				out.println("</script>");
			}
			out.println("<div style='text-align:center'><br>");
			out.println("<a  href='/aaaa/index.jsp'>");
			out.println("<button class='button1' type='button'>Desconectar</button></a>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
	}

}
