package es.uco.pw.business.user;
/**
 * La definicion de una abstract factory de Espectaculo
 * @author Alvaro Berjillos
 * @author Alvaro Sanchez
 * @author Francisco Javier Díaz
 * */


public abstract class AbstractFactoryEspectaculo {
	public abstract EspectaculoPuntual createEspectaculoPuntual();
	public abstract EspectaculoMultiple createEspectaculoMultiple();
	public abstract EspectaculoTemporada createEspectaculoTemporada();
}
