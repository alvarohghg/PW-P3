package es.uco.pw.business.user;

import java.sql.Date;

/**
 * Una clase que representa al usuario
 * @author Alvaro Berjillos
 * @version 1.0
 * */
public class Usuario {
	/* Atributos */
	private String nombre;
	private String apellidos;
	private String nick;
	private String correo;
	private String tipo;
	private Date fechaRegistro;
	private Date ultimaConexion;
	private String pass;
	/* Constructors */
	
	/**
	 * Constructor vac�o (por defecto)
	 * */
	public Usuario() {
		
	}

	/**
	 * Constructor parametrizado
	 * @param nombre El nombre del usuario
	 * @param apellidos Los apellidos del usuario
	 * @param nick El nick del usuario
	 * @param correo El correo del usuario
	 * @param tipo El tipo de usuario
	 * */
	public Usuario(String nombre,String apellidos,
			String nick,String correo,String tipo,Date fechaRegistro, Date ultimaConexion,
			String pass) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.nick=nick;
		this.correo=correo;
		this.tipo=tipo;
		this.fechaRegistro=fechaRegistro;
		this.ultimaConexion=ultimaConexion;
		this.pass=pass;
		
	}
	/* Getters y setters */
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	public String getNick() {
		return nick;
	}
	public String getCorreo() {
		return correo;
	}
	public String getTipo() {
		return tipo;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public Date getUltimaConexion() {
		return ultimaConexion;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass= pass;
	}
	public void setRegistro(Date registro) {
		this.fechaRegistro=registro;
	}
	public void setUltima(Date ultima) {
		this.ultimaConexion=ultima;
	}
	public void setNombre(String nuevonombre) {
		this.nombre=nuevonombre;
	}
	public void setApellidos(String nuevosapellidos) {
		this.apellidos=nuevosapellidos;
	}
	public void setNick(String nuevonick) {
		this.nick=nuevonick;
	}
	public void setCorreo(String nuevocorreo) {
		this.correo=nuevocorreo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/* Otros m�todos */
	/**
	 * Devuelve los datos de un usuario en una cadena
	 * @return infoUsuario Una frase con los datos del usuario
	 */
	/*public String toString() {
		//String infoUsuario= "Soy puto, Mi nick es "+this.nick+", mi nombre y apellidos "+
		//this.nombre+" "+this.apellidos+",  mi correo es "+this.correo+ " soy un usuario "+this.tipo+ " fecha: "+ this.fecha;
		//return infoUsuario;
				
	}*/

	
	
}