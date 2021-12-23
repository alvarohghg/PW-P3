package es.uco.pw.business.user;

import java.sql.Date;



/**
 * Clase para representar los espectaculos puntuales herededada de la clase AbstractEspectaculo
 * @author Alvaro Berjillos
 * @author Alvaro S�nchez
 * @author Francisco Javier D�az
 * @version 1.0
 *
 */
public class EspectaculoPuntual extends AbstractEspectaculo {
	
	/**
	 * Constructor parametrizado
	 * @param titulo Titulo del espect�culo (clave principal)
	 * @param descripcion Descripci�n del espect�culo 
	 * @param categoria Categor�a del espect�culo
	 * @param aforolocalidades Cantidad de aforo m�ximo
	 * @param localidadesvendidas Cantidad de localidades vendidas
	 * @param fechaPuntual Fecha del espect�culo
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
	 * Funci�n que devuelve los datos del espect�culo en una cadena
	 * @return string
	 */
	public String toString() {
		return "-------------------\nTitulo:" + titulo +"\n"+ "Descripcion:" + descripcion +"\n"+ "Categoria:"+getCategoria()+"\n"+ "Aforolocalidades:"
				+ aforolocalidades  +"\n"+ "Localidadesvendidas:"
				+ localidadesvendidas +"\n"+"fecha:"+fechaPuntual+"\n-------------------\n";
	}
}