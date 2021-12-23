package es.uco.pw.data.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import es.uco.pw.business.user.*;
import es.uco.pw.data.common.DBConnection;

/**
 * Clase correspondiente a las funciones de creación/eliminación/modificación de
 * criticas de la base de datos
 * @author Alvaro Berjillos
 * @author Francisco Javier Diaz
 * @author Alvaro Sanchez
 *
 */
public class CriticasDAO {
	/**
	 * Funcion para extraer las criticas de la BBDD a la lista
	 * @return listOfCriticas Una lista de criticas con las criticas
	 * de la base de datos
	 */
	public ArrayList<Criticas> obtenerCriticas(){
		ArrayList<Criticas> listOfCriticas = new ArrayList<Criticas>();
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			//String query = propiedades(1);
			String query = "select * from criticas";
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);

			while (rs.next()) {
				String titulo = rs.getString("titulo");
				String puntuacion = rs.getString("puntuacion");
				String espectaculo = rs.getString("espectaculo");
				String review = rs.getString("review");
				String valoraciones = rs.getString("valoraciones");
				String controlarPrimeraVez=rs.getString("controlarPrimeraVez");
				String autor = rs.getString("autor");
				String votantes = rs.getString("votantes");
				listOfCriticas.add(new Criticas(titulo, espectaculo, puntuacion,review,autor,valoraciones,controlarPrimeraVez,votantes));
			}

			if (stmt != null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return listOfCriticas;
	}
	/**
	 * Escribe una nueva critica en la base de datos a partir de los
	 * atributos de una critica pasada por argumento
	 * @param critica La critica cuyos datos escribimos en la base de datos
	 */
	public void escribirCriticasBD(Criticas critica) {
		
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			// Important: This query is hard-coded here for illustrative purposes only
			//String query = propiedades(2);
			String query = "INSERT INTO  criticas (titulo, puntuacion, espectaculo , review, valoraciones,controlarPrimeraVez,autor,votantes) VALUES ( ?,?,?,?,?,?,?,?)";
			PreparedStatement ps=connection.prepareStatement(query);
			
			String titulo=critica.getTitulo();
			String puntuacion=critica.getPuntuacion();
			String espectaculo=critica.getEspectaculo();
			String review=critica.getReview();
			String valoraciones=critica.getValoraciones();
			String controlarPrimeraVez=critica.getcontrolarPrimeraVez();
			String autor=critica.getAutor();
			String votantes=critica.getVotantes();
			
			ps.setString(1,titulo);
			ps.setString(2,puntuacion);
			ps.setString(3,espectaculo);
			ps.setString(4,review);
			ps.setString(5,valoraciones);
			ps.setString(6,controlarPrimeraVez);
			ps.setString(7,autor);
			ps.setString(8,votantes);
			ps.executeUpdate();
			
			
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	/**
	 * Cambia el autor de una critica existente en la base de datos a partir del autor
	 * de la critica pasado por argumento
	 * @param correonuevo Correo del autor nuevo de la critica
	 * @param correoviejo Correo del autor de la critica a cambiar
	 */
	public void actualizarAutorBD(String correonuevo,String correoviejo){
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			//String query=propiedades(3); 
			String query= "UPDATE criticas SET autor =? WHERE [Last autor] = ?";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1,correonuevo);
			ps.setString(2,correoviejo);
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	/**
	 * Elimina una critica de la base de datos dato el titulo y el autor
	 * @param titulo Titulo de la critica a eliminar
	 * @param correo Autor de la critica a eliminar
	 */
	public void borraCriticaBD(String titulo, String correo){
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			//String query=propiedades(4);
			String query="DELETE FROM criticas WHERE titulo = ? AND autor =?";
			// Important: We can replace this direct invocation to CRUD operations in DBConnection
			PreparedStatement ps=connection.prepareStatement(query);

			ps.setString(1,titulo);
			ps.setString(2,correo);
			ps.executeUpdate();

			
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	/**
	 * Altera los votantes de una critica de la base de datos
	 * dado el titulo de ésta
	 * @param titulo Titulo de la critica alterar
	 * @param votantes Cadena de votantes de la critica
	 */
	public void actualizarCriticaBDvotantes(String titulo,String votantes) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			//String query = propiedades(5);
			String query="UPDATE criticas SET votantes = ? WHERE titulo = ?";

			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1,votantes);
			ps.setString(2,titulo);
			ps.executeUpdate();
			
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	/**
	 * Altera la puntuación de una critica de la base de datos
	 * dado el titulo de ésta
	 * @param titulo Titulo de la critica alterar
	 * @param puntuacion Cadena de puntuacion de la critica
	 */
	public void actualizarCriticaBDpuntuacion(String titulo,String puntuacion) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			//String query = propiedades(6);
			String query = "UPDATE criticas SET puntuacion = ? WHERE titulo = ?";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1,puntuacion);
			ps.setString(2,titulo);
			ps.executeUpdate();
			
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	/**
	 * Funcion para alterar el valor que indica si una critica 
	 * ha sido votada más de una vez 
	 * @param titulo Titulo de la critica
	 */
	public void primeraVez(String titulo) {
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			//String query = propiedades(7);
			String query = "UPDATE criticas SET controlarPrimeraVez = 1 WHERE titulo = ?";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1,titulo);
			ps.executeUpdate();
			
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	/**
	 * Funcion para obtener las secuencias de ordenes en sql del fichero
	 * sqlC.properties 
	 * @param r Opcion correspondiente a la línea 
	 * que determinará los datos que se obtendrán
	 * @return f
	 */
	public String propiedades(int r) {
        Properties prop = new Properties();
        String filename = "sqlC.properties";
        String f=null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            prop.load(reader);
            if(r==1) {
                f = prop.getProperty("obtenerCriticas");
            }
            else if(r==2) {
                f = prop.getProperty("escribirCriticasBD");
            }
            else if(r==3) {
                f = prop.getProperty("actualizarAutor");
            }
            else if(r==4) {
                f = prop.getProperty("borrarCriticaBD");
            }
            else if(r==5) {
                f = prop.getProperty("actualizarCriticaBDvotantes");
            }
            else if (r==6){
                f = prop.getProperty("actualizarCriticaBDpuntuacion");
            }
            else {
                f = prop.getProperty("primeraVez");
            }
                       
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
           
            e.printStackTrace();
        }
        return f;
    }
	
}
