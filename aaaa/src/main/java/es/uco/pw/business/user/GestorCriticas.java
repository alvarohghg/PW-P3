package es.uco.pw.business.user;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import es.uco.pw.data.dao.CriticasDAO;
import es.uco.pw.data.dao.UsuarioDAO;

/**
 * Una clase que representa al gestor de criticas
 * @author Alvaro Berjillos
 * @author Alvaro Sanchez
 * @author Francisco Javier D�az
 * @version 1.0
 * */

public class GestorCriticas {
	/* Atributos */
	CriticasDAO CDAO=new CriticasDAO();
	UsuarioDAO UDAO=new UsuarioDAO();
	private ArrayList<Criticas> ListaCriticas = new ArrayList<Criticas>();
	Scanner entrada = new Scanner(System.in);
	private ArrayList<Usuario> ListaUsuario  = new ArrayList<Usuario>();
	GestorEspectaculos GE=new GestorEspectaculos();
	//GestorUsuario GU=new GestorUsuario();
	
	/* Patron de diseno singlenton */
	private static GestorCriticas instancia;
	
	//private GestorCriticas(){}
	public GestorCriticas(){}
	public static GestorCriticas getInstancia(){
		if(instancia==null) {
			instancia=new GestorCriticas();
		}
		return instancia;
	}
	
	/**
	 * Comprueba si existe el titulo dado 
	 * @param titulo El titulo a buscar
	 * @return true o false segun si exite o no existe el titulo
	 * */
	
	public boolean existeTitulo(String titulo) {
		ListaCriticas = CDAO.obtenerCriticas();
		boolean existe=false;
		for(int i=0;i<ListaCriticas.size();i++) {
			if(titulo.equals(ListaCriticas.get(i).getTitulo())) {	
				return true;
			}
		} 
		return existe;
	}
	
	public void guardarBDC() {
		ListaCriticas = CDAO.obtenerCriticas();
	}
	
	/**
	 * 
	 * @param titulo El titulo de la critica
	 * @param espectaculo El espectaculo al que hace la critica
	 * @param puntuacion La puntuacion que le da al espectaculo
	 * @param review Su opinion sobre el espectaculo
	 * @param autor El autor de la critica
	 * @param valoraciones La puntuacion que le dan los usuario a esa critica
	 * @throws IOException
	 */
	public boolean crearCritica(String titulo,String espectaculo,String puntuacion,String review, String correo, String valoraciones)throws IOException{
		ListaUsuario = UDAO.obtenerUsuarios();
		ListaCriticas= CDAO.obtenerCriticas();
		boolean correcto=false;
		for(int i=0; i< ListaUsuario.size(); i++){
			if(correo.equals(ListaUsuario.get(i).getCorreo())){
					Criticas C1 = new Criticas(titulo,espectaculo,puntuacion,review,correo,valoraciones,"0","");
					correcto=true;				
					subirCritica(C1);
					System.out.println("Crear");
			}
		}
		
		return correcto;
	}	
	
	
	/**
	 * Guarda la critica que le pasamos en la lista de critica y en el fichero
	 * @param c Critca que queremos guardar
	 * @throws IOException
	 */
	public void subirCritica(Criticas c)throws IOException {
		this.ListaCriticas.add(c);
		CDAO.escribirCriticasBD(c);
		System.out.println("subir");

	}
	/**
	 * Devolvemos la lista de criticas para poder interactuar con ella en el main
	 * @return Devuelve la lista de criticas entera
	 * @throws IOException
	 */
	public ArrayList<Criticas> verCriticas() throws IOException {
		ListaCriticas=CDAO.obtenerCriticas();
		return ListaCriticas;
	}
	
	/**
	 * Borramos la critica que nos dan, comprobando que sea el autor
	 * @param titulo Titulo de la critica a borrar
	 * @param correo Correo del usuario que ha iniciado sesion, que tiene que coincidir con el del autor de la critica a borrar
	 * @throws IOException
	 */
	public void borraCritica(String titulo, String correo) throws IOException {
		
		//String titulo;
		for(int i=0; i< ListaCriticas.size(); i++) {
			if(correo.equals(ListaCriticas.get(i).getAutor()) && titulo.equals(ListaCriticas.get(i).getTitulo())){
				ListaCriticas.remove(i);
				CDAO.borraCriticaBD(titulo,correo);
			}
		}
		
		
	}
	/**
	 * Actualizamos el valor de la critica haciendo la media entre el valor que ya teniamos y el nuevo que nos dan
	 * @param correo Correo del que ha iniciado sesion, que tiene que ser diferente al del autor de la critica
	 * @param puntuacion Puntuacion que le da a la critica
	 * @param titulo titulo de la critica a votar
	 * @throws IOException
	 */
	public int votarCritica(String correo, float puntuacion, String titulo) throws IOException {
		

		ListaCriticas= CDAO.obtenerCriticas();
		//System.out.println(ListaCriticas);

		if(titulo.equals(null)) {
			//System.out.println("Ha ocurrido un fallo");
			
		}else {
			ArrayList<String> listaVotantes= new ArrayList<String>();
			String vot=null;
			for(int i=0; i< ListaCriticas.size(); i++) {
				if(titulo.equals(ListaCriticas.get(i).getTitulo())){
					 vot=ListaCriticas.get(i).getVotantes();
				}
			}
			
			String[] parts = vot.split(",");
			for(int i=0;i<parts.length;i++) {
				listaVotantes.add(parts[i]);
			}
			
			boolean yaVoto=false;
			for(int j=0; j< listaVotantes.size(); j++) {	
				if(listaVotantes.get(j).equals(correo)) {
					yaVoto=true;
				}
			}

			if(yaVoto==false) {
				for(int i=0; i< ListaCriticas.size(); i++) {			
					if(titulo.equals(ListaCriticas.get(i).getTitulo())) {
						float estrellas= Float.parseFloat(ListaCriticas.get(i).getValoraciones());
						if(ListaCriticas.get(i).getcontrolarPrimeraVez().equals("0")) {
							puntuacion=puntuacion*2;
							ListaCriticas.get(i).setcontrolarPrimeraVez("1");
							CDAO.primeraVez(titulo);
						}
						String op=Float.toString((puntuacion+estrellas)/2);
						ListaCriticas.get(i).setValoraciones(op);
						CDAO.actualizarCriticaBDpuntuacion(titulo, op);
						ListaCriticas.get(i).setVotantes(ListaCriticas.get(i).getVotantes()+correo+",");
						CDAO.actualizarCriticaBDvotantes(titulo,ListaCriticas.get(i).getVotantes()+correo+"," );
					}
				}
			}
			else {
				//System.out.println("No puede votar 2 veces la misma critica\n");
				return 1;
			}
			
			
		}
		
		return 0;
	}
	
	
	/**
	 * Actualizamos las criticas de autor cuando este se cambia el correo
	 * @param correoNuevo Correo nuevo
	 * @param correoViejo Correo viejo
	 * @throws IOException
	 */
	
	public void actualizarAutor(String correoNuevo, String correoViejo) throws IOException {
		for(int i=0;i<ListaCriticas.size();i++) {
			if(correoViejo.equals(ListaCriticas.get(i).getAutor())) {
				ListaCriticas.get(i).setAutor(correoNuevo);
			}
		}

		
				
			CDAO.actualizarAutorBD(correoNuevo, correoViejo);
		
	}
	
}
