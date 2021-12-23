package es.uco.pw.business.user;

import java.sql.Date;

/**
 * Clase para representar los espectaculos de temporada herededada de la clase AbstractEspectaculo
 * @author Alvaro Berjillos
 * @author Alvaro Sánchez
 * @author Francisco Javier Díaz
 * @version 1.0
 *
 */
public class EspectaculoTemporada extends AbstractEspectaculo {
	/**
	 * Constructor parametrizado
	 * @param titulo El título del espectaculo (clave principal).
	 * @param descripcion Descripción del espectáculo.
	 * @param categoria Categoría del espectáculo.
	 * @param aforolocalidades Cantidad de aforo máximo.
	 * @param localidadesvendidas Cantidad de localidades vendidas.
	 * @param dia Día de la semana que se realiza el espectáculo.
	 * @param inicio Día de inicio de las sesiones.
	 * @param fin Último día de las sesiones.
	 */
	public EspectaculoTemporada(String titulo, String descripcion, categoria categoria,int aforolocalidades,
			int localidadesvendidas,String dia,Date inicio,Date fin) {
		super(titulo, descripcion,categoria, aforolocalidades, localidadesvendidas);
		// TODO Auto-generated constructor stub
		this.dia = dia;
		this.inicio = inicio;
		this.fin = fin;
	}
	public EspectaculoTemporada() {}
	/* Atributos */
	
	private String dia;
	private Date inicio;
	private Date fin;
	
	
	/* Getters y setters */
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	/**
	 * Devuelve los datos del espectáculo en una cadena
	 * @return string
	 */
	public String toString() {
		return "-------------------\nTitulo:" + titulo +"\n"+ "Descripcion:" + descripcion +"\n"+ "Categoria:"+getCategoria()+"\n"+ "Aforolocalidades:"
				+ aforolocalidades  +"\n"+ "Localidadesvendidas:"
				+ localidadesvendidas +"\n"+"Dia:"+dia+"\n"+"Inicio:"+inicio+"\n"+"Fin:"+fin+"\n-------------------\n";
	}
}