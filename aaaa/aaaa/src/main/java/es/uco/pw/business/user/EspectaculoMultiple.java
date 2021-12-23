package es.uco.pw.business.user;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Clase para representar los espectaculos m�ltiples herededada de la clase AbstractEspectaculo
 * @author Alvaro Berjillos
 * @author Alvaro S�nchez
 * @author Francisco Javier D�az
 * @version 1.0
 *
 */
public class EspectaculoMultiple extends AbstractEspectaculo{
	/* A */
	
	/**
	 *  Constructor parametrizado
	 * @param titulo El t�tulo del espectaculo (clave principal)
	 * @param descripcion Descripci�n del espect�culo
	 * @param categoria Categor�a del espect�culo
	 * @param aforolocalidades Cantidad de aforo m�ximo
	 * @param localidadesvendidas Cantidad de localidades vendidas
	 * @param listaFechas Lista con las distintas fechas del espect�culo
	 */
	
	public EspectaculoMultiple(String titulo, String descripcion, categoria categoria,int aforolocalidades,
			int localidadesvendidas,ArrayList<Date> listaFechas) {
		super(titulo, descripcion,categoria, aforolocalidades, localidadesvendidas);
		// TODO Auto-generated constructor stub
		this.listaFechas = listaFechas;

	}
	/* Atributos */

	private ArrayList<Date> listaFechas;
	
	/* Getters y setters */
	public ArrayList<Date> getListaFechas() {
		return listaFechas;
	}

	public void setListaFechas(ArrayList<Date> listaFechas) {
		this.listaFechas = listaFechas;
	}
	
	/**
	 * Funci�n para modificar una fecha listaFechas
	 * @param fecha Fecha a modificar
	 * @param fechanueva Nueva fecha
	 */
	public void actualizarFecha(Date fecha,Date fechanueva) {
		this.listaFechas.remove(fecha);
		this.listaFechas.add(fechanueva);
	}
	
	/**
	 * Funci�n para eliminar una fecha de listaFechas
	 * @param fecha
	 */
	
	public void eliminarFecha(Date fecha) {
		for(int i=0;i<listaFechas.size();i++) {
			if(fecha.compareTo(listaFechas.get(i))==0) {
				listaFechas.remove(i);
			}
		}
	}
	
	/**
	 * Funci�n que devuelve todos los datos del espect�culo en una cadena
	 * @return string 
	 */
	public String toString() {
		String fecha=listaFechas.get(0).toString()+"\n";
		for(int i=1;i<listaFechas.size();i++) {
			fecha+=listaFechas.get(i).toString()+"\n";
		}
		return "-------------------\nTitulo:" + titulo +"\n"+ "Descripcion:" + descripcion +"\n"+ "Categoria:"+getCategoria()+"\n"+ "Aforolocalidades:"
				+ aforolocalidades  +"\n"+ "Localidadesvendidas:"
				+ localidadesvendidas +"\n"+"Fechas:\n"+fecha+"-------------------\n";
	}
}