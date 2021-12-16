package es.uco.pw.data.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import es.uco.pw.business.user.*;
import es.uco.pw.business.user.AbstractEspectaculo.categoria;
import es.uco.pw.data.common.DBConnection;
/**
 * Clase correspondiente a las funciones de creación/eliminación/modificación de
 * espectaculos puntuales de la base de datos
 * @author Alvaro Berjillos
 * @author Francisco Javier Diaz
 * @author Alvaro Sanchez
 *
 */
public class PuntualDAO {
	/**
	 * Funcion para extraer los espectaculos puntuales de la BBDD a la lista
	 * @return listaP Una lista de espectaculos puntuales
	 * de la base de datos
	 */
	public ArrayList<EspectaculoPuntual> obtenerPuntual(){
		ArrayList<EspectaculoPuntual> listaP = new ArrayList<EspectaculoPuntual>();
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			// Important: This query is hard-coded here for illustrative purposes only
			String query = propiedades(1);
			
			// Important: We can replace this direct invocation to CRUD operations in DBConnection
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);

			while (rs.next()) {
				String titulo = rs.getString("titulo_puntual");
				String descripcion = rs.getString("descripcion_puntual");
				categoria cate =es.uco.pw.business.user.AbstractEspectaculo.categoria.valueOf(rs.getString("categoria_puntual"));
				int aforo = rs.getInt("aforolocalidades_puntual");
				int localidades = rs.getInt("localidadesvendidas_puntual");
				Date fecha = rs.getDate("fecha_puntual");
				listaP.add(new EspectaculoPuntual(titulo, descripcion, cate,aforo,localidades,fecha));
			}

			if (stmt != null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return listaP;
	}
	/**
	 * Funcion para escribir un espectaculo puntual en la base de datos
	 * pasado por argumento
	 * @param puntual Espectaculo puntual que sera añadido a la base de datos
	 */
	public void escribirPuntualBD(EspectaculoPuntual puntual ) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			String query =propiedades(2);
			PreparedStatement ps=connection.prepareStatement(query);
			// Important: This query is hard-coded here for illustrative purposes only
			ps.setString(1, puntual.getTitulo());
			ps.setString(2, puntual.getDescripcion());
			ps.setString(3, puntual.getCategoria().toString());
			ps.setInt(4, puntual.getAforolocalidades());
			ps.setInt(5,puntual.getLocalidadesvendidas());
			ps.setDate(6, puntual.getFechaPuntual());
			ps.executeUpdate();
			
			
			// Important: We can replace this direct invocation to CRUD operations in DBConnection
			
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	/**
	 * Actualiza un espectaculo puntual almacenado en la
	 * base de datos dada una opcion
	 * @param titulo Titulo del espectaculo a modificar
	 * @param nuevotitulo Nuevo titulo del espectaculo
	 * @param nuevadescripcion Nueva descripcion del espectaculo
	 * @param nuevacategoria Nueva categoria
	 * @param nuevoaforolocalidades Nuevo aforo
	 * @param localidadesvendidas Nuevas localidades vendidas
	 * @param fecha Nueva fecha del espectaculo a alterar
	 * @param opcion Entero que determina la operacion sql
	 */
	public void actualizarPuntualBD(String titulo,String nuevotitulo,String nuevadescripcion,categoria nuevacategoria,int nuevoaforolocalidades,
			int localidadesvendidas,Date fecha,int opcion) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			String query=null; 
			// Important: This query is hard-coded here for illustrative purposes only
			switch(opcion) {
				case 1:
					query = propiedades(3);
					PreparedStatement ps=connection.prepareStatement(query);
					ps.setString(1, nuevotitulo);
					ps.setString(2, titulo);
					ps.executeUpdate();
				break;
				case 2:
					query = propiedades(4);
					PreparedStatement ps1=connection.prepareStatement(query);
					ps1.setString(1, nuevadescripcion);
					ps1.setString(2, titulo);
					ps1.executeUpdate();
				break;
				case 3:
					query = propiedades(5);
					PreparedStatement ps2=connection.prepareStatement(query);
					ps2.setString(1, nuevacategoria.toString());
					ps2.setString(2, titulo);
					ps2.executeUpdate();
				break;
				case 4:
					query = propiedades(6);
					PreparedStatement ps3=connection.prepareStatement(query);
					ps3.setInt(1, nuevoaforolocalidades);
					ps3.setString(2, titulo);
					ps3.executeUpdate();
				break;
				case 5:
					query = propiedades(7);
					PreparedStatement ps4=connection.prepareStatement(query);
					ps4.setInt(1, localidadesvendidas);
					ps4.setString(2, titulo);
					ps4.executeUpdate();
				break;
				case 6:
					query = propiedades(8);
					PreparedStatement ps5=connection.prepareStatement(query);
					ps5.setDate(1, fecha);
					ps5.setString(2, titulo);
					ps5.executeUpdate();
				break;
			}
			
					
			
			// Important: We can replace this direct invocation to CRUD operations in DBConnection
			
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	/**
	 * Borra un espectaculo puntual de la base de datos dado el titulo
	 * @param titulo Titulo del espectaculo
	 */
	public void eliminarPuntualTitulo(String titulo){
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			String query=propiedades(9);
			
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, titulo);
			ps.executeUpdate();


			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	/**
	 * Elimina una sesion del espectaculo puntual
	 * @param titulo Titulo del espectaculo
	 * @param fecha Sesion a eliminar
	 */
	public void eliminarPuntualFecha(String titulo, Date fecha){
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			String query = propiedades(10);
			
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, titulo);
			ps.setDate(2, fecha);
			ps.executeUpdate();


			
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	/**
	 * Funcion para obtener las secuencias de ordenes en sql del fichero
	 * sqlP.properties 
	 * @param r Opcion correspondiente a la línea 
	 * que determinará los datos que se obtendrán
	 * @return f
	 */
	public String propiedades(int r) {
		Properties prop = new Properties();
		String filename = "sqlP.properties";
		String f=null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
			prop.load(reader);
			if(r==1) {
				f = prop.getProperty("obtenerPuntual");
			}
			else if(r==2) {
				f = prop.getProperty("escribirPuntualBD");
			}
			else if(r==3) {
				f = prop.getProperty("actualizarPuntualBD1");
			}
			else if(r==4) {
				f = prop.getProperty("actualizarPuntualBD2");
			}
			else if(r==5) {
				f = prop.getProperty("actualizarPuntualBD3");
			}
			else if(r==6) {
				f = prop.getProperty("actualizarPuntualBD4");
			}
			else if(r==7) {
				f = prop.getProperty("actualizarPuntualBD5");
			}
			else if(r==8) {
				f = prop.getProperty("actualizarPuntualBD6");
			}
			else if(r==9) {
				f = prop.getProperty("eliminarPuntualTitulo");
			}
			else {
				f = prop.getProperty("eliminarPuntualFecha");
			}
						
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return f;
	}
}

