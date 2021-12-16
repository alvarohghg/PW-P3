package es.uco.pw.data.dao;
import java.io.*;
import java.io.BufferedReader;
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
 * espectaculos de temporada de la base de datos
 * @author Alvaro Berjillos
 * @author Francisco Javier Diaz
 * @author Alvaro Sanchez
 *
 */
public class TemporadaDAO {
	/**
	 * Funcion para obtener las secuencias de ordenes en sql del fichero
	 * sqlT.properties 
	 * @param r Opcion correspondiente a la línea 
	 * que determinará los datos que se obtendrán
	 * @return f
	 */
	public String propiedades(int r) {
        Properties prop = new Properties();
        String filename = "sqlT.properties";
        String f=null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            prop.load(reader);
            if(r==1) {
                f = prop.getProperty("obtenerTemporada");
            }
            else if(r==2) {
                f = prop.getProperty("escribirTemporadaBD");
            }
            else if(r==3) {
                f = prop.getProperty("actualizarTemporadaBD1");
            }
            else if(r==4) {
                f = prop.getProperty("actualizarTemporadaBD2");
            }
            else if(r==5) {
                f = prop.getProperty("actualizarTemporadaBD3");
            }
            else if(r==6) {
                f = prop.getProperty("actualizarTemporadaBD4");
            }
            else if(r==7) {
                f = prop.getProperty("actualizarTemporadaBD5");
            }
            else if(r==8) {
                f = prop.getProperty("actualizarTemporadaBD6");
            }
            else if(r==9) {
            	 f = prop.getProperty("actualizarTemporadaBD7");
            }
            else if(r==10) {
           	 f = prop.getProperty("actualizarTemporadaBD8");
            }
            else if(r==11) {
           	 f = prop.getProperty("eliminarTemporadaTitulo");
           }
            else {
                f = prop.getProperty("eliminarTemporadaFecha");
            }
            //System.out.println(f);            
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return f;
    }
	/**
	 * Funcion para extraer los espectaculos de temporada de la BBDD a la lista
	 * @return listaT Una lista de espectaculos de temporada
	 * de la base de datos
	 */
	public ArrayList<EspectaculoTemporada> obtenerTemporada(){
		ArrayList<EspectaculoTemporada> listaT = new ArrayList<EspectaculoTemporada>();
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			// Important: This query is hard-coded here for illustrative purposes only
			String query = propiedades(1);
			
			// Important: We can replace this direct invocation to CRUD operations in DBConnection
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);

			while (rs.next()) {
				String titulo = rs.getString("titulo_temp");
				String descripcion = rs.getString("descripcion_temp");
				categoria cate =es.uco.pw.business.user.AbstractEspectaculo.categoria.valueOf(rs.getString("categoria_temp"));
				int aforo = rs.getInt("aforolocalidades_temp");
				int localidades = rs.getInt("localidadesvendidas_temp");
				String dia= rs.getString("dia_temp");
				Date inicio = rs.getDate("inicio_temp");
				Date fin = rs.getDate("fin_temp");
				listaT.add(new EspectaculoTemporada(titulo, descripcion, cate,aforo,localidades,dia,inicio,fin));
			}

			if (stmt != null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return listaT;
	}
	/**
	 * Funcion para escribir un espectaculo de temporada en la base de datos
	 * pasado por argumento
	 * @param temporada Espectaculo de temporada que sera añadido a la base de datos
	 */
public void escribirTemporadaBD(EspectaculoTemporada temporada) {
	try {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		String query =propiedades(2);
		PreparedStatement ps=connection.prepareStatement(query);
		// Important: This query is hard-coded here for illustrative purposes only
		String titulo_temp=temporada.getTitulo();
		String descripcion_temp=temporada.getDescripcion();
		String categoria_temp=temporada.getCategoria().toString();
		String aforolocalidades_temp=String.valueOf(temporada.getAforolocalidades());
		String localidadesvendidas_temp=String.valueOf(temporada.getLocalidadesvendidas());
		String dia_temp=temporada.getDia();
		String inicio_temp=String.valueOf(temporada.getInicio());
		String fin_temp=String.valueOf(temporada.getFin());
		ps.setString(1, titulo_temp);
		ps.setString(2, descripcion_temp);
		ps.setString(3, categoria_temp);
		ps.setString(4, aforolocalidades_temp);
		ps.setString(5, localidadesvendidas_temp);
		ps.setString(6, dia_temp);
		ps.setString(7, inicio_temp);
		ps.setString(8, fin_temp);
		ps.executeUpdate();
		
				
		
		dbConnection.closeConnection();
	} catch (Exception e){
		System.err.println(e);
		e.printStackTrace();
	}
	}
/**
 * Actualiza un espectaculo de temporada almacenado en la
 * base de datos dada una opcion
 * @param titulo Titulo del espectaculo a modificar
 * @param nuevotitulo Nuevo titulo del espectaculo
 * @param nuevadescripcion Nueva descripcion del espectaculo
 * @param nuevacategoria Nueva categoria
 * @param nuevoaforolocalidades Nuevo aforo
 * @param localidadesvendidas Nuevas localidades vendidas
 * @param nuevafechafin Nueva fecha de fin de temporada del espectaculo a alterar
 * @param nuevafechainicio Nueva fecha de inicio de temporada del espectaculo a alterar
 * @param dia Nuevo dia de la semana del espectaculo a alterar
 * @param opcion Entero que determina la operacion sql
 */
public void actualizarTemporadaBD(String titulo,String nuevotitulo,String nuevadescripcion,categoria nuevacategoria,int nuevoaforolocalidades,
		int nuevalocalidadesvendidas,Date nuevafechafin,Date nuevafechainicio,String dia,int opcion) {
	try {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		String query=null; 
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
			ps4.setInt(1, nuevalocalidadesvendidas);
			ps4.setString(2, titulo);
			ps4.executeUpdate();
		break;
		case 6:
			query = propiedades(8);
			PreparedStatement ps5=connection.prepareStatement(query);
			ps5.setString(1, dia);
			ps5.setString(2, titulo);
			ps5.executeUpdate();
			break;
		case 7:
			query = propiedades(9);	
			PreparedStatement ps6=connection.prepareStatement(query);
			ps6.setDate(1, nuevafechainicio);
			ps6.setString(2, titulo);
			ps6.executeUpdate();
			break;
		case 8:
			query = propiedades(10);
			PreparedStatement ps7=connection.prepareStatement(query);
			ps7.setDate(1, nuevafechafin);
			ps7.setString(2, titulo);
			ps7.executeUpdate();
			break;
		}
		
				
			
		dbConnection.closeConnection();
	} catch (Exception e){
		System.err.println(e);
		e.printStackTrace();
	}
}
/**
 * Borra un espectaculo de temporada de la base de datos dado el titulo
 * @param titulo Titulo del espectaculo
 */
public void eliminarTemporadaTitulo(String titulo){
	try {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		String query= propiedades(11);		
		
		
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1, titulo);
		ps.executeUpdate();

	} catch (Exception e){
		System.err.println(e);
		e.printStackTrace();
	}
}
/**
 * Elimina un espectaculo de temporada dado el titulo y la fecha
 * @param titulo Titulo del espectaculo
 * @param fecha Sesion a eliminar
 */
public void eliminarTemporadaFecha(String titulo, Date fecha){
	try {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		String query = propiedades(12);
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1, titulo);
		ps.setDate(2, fecha);
		ps.setDate(3, fecha);
		ps.setDate(4, fecha);
		ps.setDate(5, fecha);
		ps.executeUpdate();
		
	} catch (Exception e){
		System.err.println(e);
		e.printStackTrace();
	}
}
}
