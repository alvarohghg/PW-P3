package es.uco.pw.business.user;

//import java.util.ArrayList;

/**
 * Una clase que representa a las criticas
 * @author Alvaro Sanchez
 * @version 1.0
 * */

public class Criticas {
	/* Atributos */

	private String titulo;
	private String puntuacion;
	private String espectaculo;
	private String review;
	private String valoraciones;
	private String autor;
	private String controlarPrimeraVez;
	private String votantes;
	
	/* Constructors */
	
	/**
	 * Constructor vacío (por defecto)
	 * */
	
	public Criticas(){}
	
	/**
	 * Constructor parametrizado
	 * @param titulo El titulo de la critica
	 * @param espectaculo El espectaculo al que hace la critica
	 * @param puntuacion La puntuacion que le da al espectaculo
	 * @param review Su opinion sobre el espectaculo
	 * @param autor El autor de la critica
	 * @param valoraciones La puntuacion que le dan los usuario a esa critica
	 * @param controlarPrimeraVez Esta a 0 si es la primera vez que alguien vota esa critica o a 1 si no es la primera
	 * */
	
	public Criticas(String titulo,String espectaculo , String puntuacion ,String review, String autor, String valoraciones, String controlarPrimeraVez, String votantes) {
		this.titulo=titulo;
		this.espectaculo=espectaculo;
		this.puntuacion=puntuacion;
		this.review=review;	
		this.autor=autor;
		this.valoraciones = valoraciones;
		this.controlarPrimeraVez=controlarPrimeraVez;
		this.votantes=votantes;
	}
	
	
	/* Getters y setters */

	public String getAutor(){
		return autor;
	}
	
	public void setAutor(String autor){
		this.autor=autor;
	}
	
	public String getcontrolarPrimeraVez() {
		return controlarPrimeraVez;
	}
	
	public void setcontrolarPrimeraVez(String controlarPrimeraVez) {
		this.controlarPrimeraVez=controlarPrimeraVez;
	}
	
	
	public String getTitulo(){
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo=titulo;
	}
	
	public String getPuntuacion() {
		return puntuacion;
	}
	
	public String getEspectaculo() {
		return espectaculo;
	}
	
	public void setEspectaculo(String espectaculo) {
		this.espectaculo=espectaculo;
	}
	
	public void setPuntuacion(String puntuacion) {
		this.puntuacion=puntuacion;
	}
	
	public String getReview(){
		return review;
	}
	
	public void setReview(String review) {
		this.review=review;
	}
	
	public String getValoraciones() {
		return valoraciones;
	}
	
	public void setValoraciones(String valoraciones) {
		this.valoraciones=valoraciones;
	}

	public String getVotantes() {
		return votantes;
	}


	public void setVotantes(String votantes) {
		this.votantes = votantes;
	}
	
}