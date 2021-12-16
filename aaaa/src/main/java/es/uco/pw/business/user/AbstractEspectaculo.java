package es.uco.pw.business.user;



/**
 * La clase abstracta que representa un espectaculo general
 * @author Alvaro Berjillos
 * @author Alvaro Sanchez
 * @author Francisco Javier Diaz
 * */
public class AbstractEspectaculo {
	
	// Propiedades comunes a todos los espectaculos
	protected String titulo;
	protected String descripcion;
	public enum categoria{
		concierto,obra,Concierto,Obra,Monologo,monologo;
	}
	protected int aforolocalidades;
	
	protected int localidadesvendidas;
	
	private categoria categoria;
	
	public AbstractEspectaculo(String titulo, String descripcion, categoria categoria,int aforolocalidades,
			int localidadesvendidas) {
		
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.aforolocalidades = aforolocalidades;
		this.localidadesvendidas = localidadesvendidas;
		this.categoria=categoria;
	}
	/* Setters y getters */
	public String getTitulo() {
		return titulo;
	}
	public categoria getCategoria() {
		return  categoria;
	}
	public void setCategoria(categoria categoria) {
		this.categoria=categoria;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getAforolocalidades() {
		return aforolocalidades;
	}
	public void setAforolocalidades(int aforolocalidades) {
		this.aforolocalidades = aforolocalidades;
	}
	
	public int getLocalidadesvendidas() {
		return localidadesvendidas;
	}
	public void setLocalidadesvendidas(int localidadesvendidas) {
		this.localidadesvendidas = localidadesvendidas;
	}
	
	/*Otros metodos*/
	
	public int entradasDisponibles() {
		return aforolocalidades-localidadesvendidas;
	}
	
	
}
