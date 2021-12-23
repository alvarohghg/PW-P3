package es.uco.pw.business.user;

import java.sql.Date;



/**
 * Clase para representar los espectaculos puntuales herededada de la clase AbstractEspectaculo
 * @author Alvaro Berjillos
 * @author Alvaro Sánchez
 * @author Francisco Javier Díaz
 * @version 1.0
 *
 */
public class EspectaculoPuntual extends AbstractEspectaculo {
	
	/**
	 * Constructor parametrizado
	 * @param titulo Titulo del espectáculo (clave principal)
	 * @param descripcion Descripción del espectáculo 
	 * @param categoria Categoría del espectáculo
	 * @param aforolocalidades Cantidad de aforo máximo
	 * @param localidadesvendidas Cantidad de localidades vendidas
	 * @param fechaPuntual Fecha del espectáculo
	 */
	public EspectaculoPuntual(String titulo, String descripcion, categoria categoria,int aforolocalidades,
			int localidadesvendidas,Date fechaPuntual) {
		super(titulo, descripcion,categoria, aforolocalidades, localidadesvendidas);
		// TODO Auto-generated constructor stub
		this.fechaPuntual = fechaPuntual;

	}
	public EspectaculoPuntual() {}
	/* Atributos */

	private Date fechaPuntual;
	
	
	/* Getters y setters */

	public Date getFechaPuntual() {
		return fechaPuntual;
	}

	public void setFechaPuntual(Date fechaPuntual) {
		this.fechaPuntual = fechaPuntual;
	}
	
	/**
	 * Función que devuelve los datos del espectáculo en una cadena
	 * @return string
	 */
	public String toString() {
		return "-------------------\nTitulo:" + titulo +"\n"+ "Descripcion:" + descripcion +"\n"+ "Categoria:"+getCategoria()+"\n"+ "Aforolocalidades:"
				+ aforolocalidades  +"\n"+ "Localidadesvendidas:"
				+ localidadesvendidas +"\n"+"fecha:"+fechaPuntual+"\n-------------------\n";
	}
}