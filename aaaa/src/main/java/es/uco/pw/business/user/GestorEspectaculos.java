package es.uco.pw.business.user;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Properties;

import  es.uco.pw.business.user.AbstractEspectaculo.categoria;
import es.uco.pw.data.dao.PuntualDAO;
import es.uco.pw.data.dao.TemporadaDAO;
import es.uco.pw.data.dao.MultipleDAO;

/**
 * Una clase que representa al gestor de espectaculos
 * @author Alvaro Berjillos
 * @authos Alvaro Sanchez
 * @author Francisco Javier Diaz
 *
 */
public class GestorEspectaculos {
	/*Atributos*/
	PuntualDAO PDAO= new PuntualDAO();
	MultipleDAO MDAO= new MultipleDAO();
	TemporadaDAO TDAO= new TemporadaDAO();
	
	private ArrayList<EspectaculoMultiple> ListaEspectaculosM=new ArrayList<EspectaculoMultiple>();
	private ArrayList<EspectaculoPuntual> ListaEspectaculosP=new ArrayList<EspectaculoPuntual>();
	private ArrayList<EspectaculoTemporada> ListaEspectaculosT=new ArrayList<EspectaculoTemporada>();
	/*Constructor parametrizado*/
	public GestorEspectaculos(ArrayList<EspectaculoMultiple> listaEspectaculosM,
			ArrayList<EspectaculoPuntual> listaEspectaculosP,
			ArrayList<EspectaculoTemporada> listaEspectaculosT) {
		
		ListaEspectaculosM = listaEspectaculosM;
		ListaEspectaculosP = listaEspectaculosP;
		ListaEspectaculosT = listaEspectaculosT;
		
	}
	/* Constructor vacio y getters y setters */
	public GestorEspectaculos() {
		
	}
	public ArrayList<EspectaculoPuntual> getListaEspectaculosP() {
		return ListaEspectaculosP;
	}
	public void setListaEspectaculosP(ArrayList<EspectaculoPuntual> listaEspectaculosP) {
		ListaEspectaculosP = listaEspectaculosP;
	}
	public ArrayList<EspectaculoTemporada> getListaEspectaculosT() {
		return ListaEspectaculosT;
	}
	public void setListaEspectaculosT(ArrayList<EspectaculoTemporada> listaEspectaculosT) {
		ListaEspectaculosT = listaEspectaculosT;
	}
	public void setListaEspectaculosM(ArrayList<EspectaculoMultiple> listaEspectaculosM) {
		ListaEspectaculosM = listaEspectaculosM;
	}
	public ArrayList<EspectaculoMultiple> getListaEspectaculosM() {
		return ListaEspectaculosM;
	}
	
	public void guardarBDlistas() {
		ListaEspectaculosP = PDAO.obtenerPuntual();
		ListaEspectaculosT = TDAO.obtenerTemporada();
		ListaEspectaculosM = MDAO.obtenerMultiple();
	}
	
	/**
	 * Añade un espectaculo multiple a la lista de espectaculos multiples y lo escribe en su fichero
	 * @param newespectaculo El espectaculo a aï¿½adir
	 */
	public void addEspectM(EspectaculoMultiple newespectaculo) {

		this.ListaEspectaculosM.add(newespectaculo);
		//escribirFicheroMultiple(newespectaculo);
		MDAO.escribirMultipleBD(newespectaculo);
		
	}
	/**
	 * Añade un espectaculo de temporada a la lista de espectaculos de temporada y lo escribe en su fichero
	 * @param newespectaculo El espectaculo a aï¿½adir
	 */
	public void addEspectT(EspectaculoTemporada newespectaculo) {

		this.ListaEspectaculosT.add(newespectaculo);	
		//escribirFicheroTemporal(newespectaculo);
		TDAO.escribirTemporadaBD(newespectaculo);
		
	}
	/**
	 * Añade un espectaculo puntual a la lista de espectaculos puntuales y lo escribe en su fichero
	 * @param newespectaculo El espectaculo a aï¿½adir
	 */
	public void addEspectP(EspectaculoPuntual newespectaculo) {

		this.ListaEspectaculosP.add(newespectaculo);
		//escribirFicheroPuntual(newespectaculo);
		PDAO.escribirPuntualBD(newespectaculo);
		
		
	}
	/**
	 * Comprueba dado un titulo si existe un espectaculo recorriendo todas las listas de espectaculos 
	 * @param titulo El titulo del espectaculo a buscar
	 * @return true si existe el espectaculo
	 */
	public boolean existeEspectaculo(String titulo) {
		ListaEspectaculosP = PDAO.obtenerPuntual();
		ListaEspectaculosT = TDAO.obtenerTemporada();
		ListaEspectaculosM = MDAO.obtenerMultiple();
		
		for(int i=0;i<ListaEspectaculosM.size();i++) {
			if(titulo.equals(ListaEspectaculosM.get(i).getTitulo())) {	
				return true;
			}
			
		}
		for(int i=0;i<ListaEspectaculosT.size();i++) {
			if(titulo.equals(ListaEspectaculosT.get(i).getTitulo())) {	
				return true;
			}
			
		}
		for(int i=0;i<ListaEspectaculosP.size();i++) {
			if(titulo.equals(ListaEspectaculosP.get(i).getTitulo())) {	
				return true;
			}
			
		}
		
		return false;
	}
	/**
	 * Devuelve una lista con los titulos de todos los espectï¿½culos
	 * @return l Lista con todos los espectaculos
	 */
	public ArrayList<String> verEspectaculos(){
		ArrayList<String> l= new ArrayList<String>();
		for(int i=0;i<ListaEspectaculosM.size();i++) {
			l.add(ListaEspectaculosM.get(i).getTitulo());
		}
		for(int i=0;i<ListaEspectaculosT.size();i++) {
			l.add(ListaEspectaculosT.get(i).getTitulo());
		}
		for(int i=0;i<ListaEspectaculosP.size();i++) {
			l.add(ListaEspectaculosP.get(i).getTitulo());
		}
		return l;
	}
	/**
	 * Funcion para registrar un espectaculo mï¿½ltiple en la lista de espectaculos mï¿½ltiples y en el fichero
	 * @param titulo El titulo del espectaculo
	 * @param descripcion La descripcion del espectaculo 
	 * @param categoria La categoria del espectaculo 
	 * @param aforolocalidades El aforo del espectaculo 
	 * @param localidadesvendidas Las ventas del espectaculo 
	 * @param listafechas El listado de fechas del espectaculo 
	 */
	public void registerEspectaculoM(String titulo,String descripcion,categoria categoria ,
	 int aforolocalidades, int localidadesvendidas, 
	 ArrayList<Date> listafechas) {
		
			EspectaculoMultiple nuevoespect=new EspectaculoMultiple( titulo,  descripcion,  
					categoria, aforolocalidades, localidadesvendidas,listafechas);
			addEspectM(nuevoespect);
		
		}
	/**
	 * Funcion para registrar un espectaculo de temporada en la lista de espectaculos de temporada y en el fichero
	 * @param titulo El titulo del espectaculo 
	 * @param descripcion La descripcion del espectaculo 
	 * @param categoria La categoria del espectaculo 
	 * @param aforolocalidades El aforo del espectaculo 
	 * @param localidadesvendidas Las ventas del espectaculo 
	 * @param dia El dia de la semana en el que se realiza el espectaculo 
	 * @param inicio La fecha de inicio de temporada del espectaculo 
	 * @param fin La fecha de fin de temporada del espectaculo 
	 */
	public void registerEspectaculoT(String titulo,String descripcion,categoria categoria ,
			 int aforolocalidades, int localidadesvendidas, String dia,Date inicio,Date fin) {
				

				EspectaculoTemporada nuevoespect=new EspectaculoTemporada( titulo,  descripcion,  
							categoria, aforolocalidades, localidadesvendidas, dia, inicio, fin);
					addEspectT(nuevoespect);
				
				}
	/**
	* Funcion para registrar un espectaculo puntual en la lista de espectaculos puntuales y en el fichero
	 * @param titulo El titulo del espectaculo 
	 * @param descripcion La descripcion del espectaculo 
	 * @param categoria La categoria del espectaculo 
	 * @param aforolocalidades El aforo del espectaculo 
	 * @param localidadesvendidas Las ventas del espectaculo 
	 * @param fechaPuntual La fecha en la que se realiza el espectaculo puntual
	 */
	public void registerEspectaculoP(String titulo,String descripcion,categoria categoria ,
			 int aforolocalidades,  int localidadesvendidas, Date fechaPuntual) {
				
					EspectaculoPuntual nuevoespect=new EspectaculoPuntual( titulo,  descripcion,  
							categoria, aforolocalidades, localidadesvendidas, fechaPuntual);
					addEspectP(nuevoespect);
				
				}
		
	/**
	 * Retorna la informacion de un espectaculo dado el titulo
	 * @param titulo Titulo del espectaculo
	 * @return rt Una cadena con la informacion del espectaculo
	 */
	public String imprimirEspectaculoTitulo(String titulo) {
		String rt=null;
		for(int i=0; i< ListaEspectaculosM.size(); i++) {
			if(titulo.equals(ListaEspectaculosM.get(i).getTitulo())) {
				rt=(ListaEspectaculosM.get(i).toString());
			}
		}
		for(int i=0; i< ListaEspectaculosT.size(); i++) {
			if(titulo.equals(ListaEspectaculosT.get(i).getTitulo())) {
				rt=(ListaEspectaculosT.get(i).toString());
			}
		}
		
		for(int i=0; i< ListaEspectaculosP.size(); i++) {
			if(titulo.equals(ListaEspectaculosP.get(i).getTitulo())) {
				rt=(ListaEspectaculosP.get(i).toString());
			}
		}
		return rt;
			
	}
	/**
	 * Retorna la informacion de uno o varios espectaculos dada la categoria
	 * @param categoria La categoria de los espectaculos a buscar
	 * @return rt La cadena con la informacion de los espectaculos de la categoria
	 */
		public String imprimirEspectaculoCategoria(categoria categoria) {
			String rt="";
			for(int i=0; i< ListaEspectaculosM.size(); i++) {
				if(categoria.equals(ListaEspectaculosM.get(i).getCategoria())) {
					rt+=(ListaEspectaculosM.get(i).toString());
				}
				
			}
			for(int i=0; i< ListaEspectaculosT.size(); i++) {
				if(categoria.equals(ListaEspectaculosT.get(i).getCategoria())) {
					rt+=(ListaEspectaculosT.get(i).toString());
				}
				
			}
			for(int i=0; i< ListaEspectaculosP.size(); i++) {
				if(categoria.equals(ListaEspectaculosP.get(i).getCategoria())) {
					rt+=(ListaEspectaculosP.get(i).toString());
				}
				
			}
			return rt;
		}
		/**
		 * Elimina un espectaculo dado el titulo
		 * @param titulo Titulo del espectaculo a eliminar
		 * @return true si encuentra el espectaculo y lo elimina de la lista
		 * @throws IOException
		 */
		public boolean eliminarEspectaculoTodas(String titulo) throws IOException {
			boolean var=false;
				for(int i=0;i<ListaEspectaculosM.size();i++) {
					if(titulo.equals(ListaEspectaculosM.get(i).getTitulo())) {
						ListaEspectaculosM.remove(i);
						MDAO.eliminarMultipleTitulo(titulo);
						var=true;
					}
				}
				
				for(int i=0;i<ListaEspectaculosT.size();i++) {
					if(titulo.equals(ListaEspectaculosT.get(i).getTitulo())) {
						ListaEspectaculosT.remove(i);
						TDAO.eliminarTemporadaTitulo(titulo);
						var=true;
					}
				}				
				
				for(int i=0;i<ListaEspectaculosP.size();i++) {
					if(titulo.equals(ListaEspectaculosP.get(i).getTitulo())) {
						ListaEspectaculosP.remove(i);
						PDAO.eliminarPuntualTitulo(titulo);
						var=true;
					}
				}
								
				return var;

		}
		/**
		 * Elimina un espectaculo multiple dado el titulo y la fecha
		 * @param titulo Titulo del espectaculo multiple a eliminar
		 * @param fecha Fecha de la sesion a eliminar
		 * @return true si se ha eliminado correctamente
		 * @throws IOException
		 */
		public boolean eliminarEspectaculoUnaM(String titulo,Date fecha) throws IOException {
			boolean var=false;
				for(int i=0;i<ListaEspectaculosM.size();i++) {
					for(int j=0;j<ListaEspectaculosM.get(i).getListaFechas().size();j++) {
						
						if(fecha.compareTo(ListaEspectaculosM.get(i).getListaFechas().get(j))==0 && titulo.equals(ListaEspectaculosM.get(i).getTitulo())) {
							
							if(ListaEspectaculosM.get(i).getListaFechas().size()==1) { //si solo queda una sesion al eliminar se elimina el espectaculo entero
								ListaEspectaculosM.remove(i);
								MDAO.eliminarMultipleTitulo(titulo);
								break;
							}else {
								ListaEspectaculosM.get(i).getListaFechas().remove(j);
								MDAO.eliminarMultipleFecha(titulo, fecha);
							}

							var=true;
						}
					}
				}
				
				
				return var;
		}
		/**
		 * Elimina un espectaculo puntual dado el titulo y la fecha
		 * @param titulo El titulo del espectaculo puntual a eliminar
		 * @param fecha La fecha del espectaculo
		 * @return true si se elimina correctamente
		 * @throws IOException
		 */
		public boolean eliminarEspectaculoUnaP(String titulo,Date fecha) throws IOException {
			boolean var=false;
				for(int i=0;i<ListaEspectaculosP.size();i++) {
					if(titulo.equals(ListaEspectaculosP.get(i).getTitulo()) && fecha.compareTo(ListaEspectaculosP.get(i).getFechaPuntual())==0) {
						ListaEspectaculosP.remove(i);
						PDAO.eliminarPuntualFecha(titulo, fecha);
						var=true;
					}
				}
				
				
				return var;
		}
		/**
		 * Elimina un espectaculo de temporada dado el titulo y la fecha
		 * @param titulo El titulo del espectaculo puntual a eliminar
		 * @param fecha La fecha del espectaculo
		 * @return true si se elimina correctamente
		 * @throws IOException
		 */
		public boolean eliminarEspectaculoUnaT(String titulo,Date fecha) throws IOException {
			boolean var=false;
			for(int i=0;i<ListaEspectaculosT.size();i++) {
				if(titulo.equals(ListaEspectaculosT.get(i).getTitulo()) && ListaEspectaculosT.get(i).getInicio().compareTo(fecha)<0
						&&ListaEspectaculosT.get(i).getFin().compareTo(fecha)>0 || ListaEspectaculosT.get(i).getFin().compareTo(fecha)==0
						||ListaEspectaculosT.get(i).getInicio().compareTo(fecha)==0) {
					ListaEspectaculosT.remove(i);
					TDAO.eliminarTemporadaFecha(titulo, fecha);
					var=true;
				}
			}
			
				return var;
		}
		
		/**
		 * Actualiza un espectaculo en la lista de espectaculos multiples
		 * @param titulo El titulo del espectaculo a cambiar
		 * @param nuevotitulo El nuevo titulo del espectaculo
		 * @param nuevadescripcion La nueva descripcion del espectaculo
		 * @param nuevacategoria La nueva categoria del espectaculo
		 * @param nuevoaforolocalidades El nuevo aforo del espectaculo
		 * @param localidadesvendidas Las ventas del espectaculo
		 * @param fecha1 La fecha de la sesion antigua 
		 * @param fecha2 La nueva fecha de la sesion que va a cambiar
		 * @param opcion La opcion que elige el usuario en el main que determina el cambio que se realizara sobre el espectaculo
		 * @throws IOException
		 */
		public void updateEspectaculoM(String titulo,String nuevotitulo,String nuevadescripcion,categoria nuevacategoria,int nuevoaforolocalidades,
				int localidadesvendidas,Date fecha1,Date fecha2,int opcion) throws IOException {
			for(int i=0;i<ListaEspectaculosM.size();i++) {
				if(titulo.equals(ListaEspectaculosM.get(i).getTitulo())) {
							switch(opcion) {
								case 1:
									this.ListaEspectaculosM.get(i).setTitulo(nuevotitulo);
								break;
								case 2:
									this.ListaEspectaculosM.get(i).setDescripcion(nuevadescripcion);
								break;
								case 3:
									this.ListaEspectaculosM.get(i).setCategoria(nuevacategoria);
								break;
								case 4:
									this.ListaEspectaculosM.get(i).setAforolocalidades(nuevoaforolocalidades);
								break;
								case 5:
									this.ListaEspectaculosM.get(i).setLocalidadesvendidas(localidadesvendidas);
								break;
								case 6:
									this.ListaEspectaculosM.get(i).actualizarFecha(fecha1,fecha2);
										
								break;
							}
				}
			}
			MDAO.actualizarMultipleBD(titulo, nuevotitulo, nuevadescripcion, nuevacategoria, nuevoaforolocalidades, localidadesvendidas, fecha1, fecha2, opcion);
			
	}
		/**
		 * Actualiza un espectaculo en la lista de espectaculos puntuales
		 * @param titulo El titulo del espectaculo a cambiar
		 * @param nuevotitulo El nuevo titulo del espectaculo
		 * @param nuevadescripcion La nueva descripcion del espectaculo
		 * @param nuevacategoria La nueva categoria del espectaculo
		 * @param nuevoaforolocalidades El nuevo aforo del espectaculo
		 * @param localidadesvendidas Las ventas del espectaculo
		 * @param fecha2 La nueva fecha de la sesion
		 * @param opcion La opcion que elige el usuario en el main que determina el cambio que se realizara sobre el espectaculo
		 * @throws IOException
		 */
		public void updateEspectaculoP(String titulo,String nuevotitulo,String nuevadescripcion,categoria nuevacategoria,int nuevoaforolocalidades,
				int localidadesvendidas,Date fecha2,int opcion) throws IOException {
			for(int i=0;i<ListaEspectaculosP.size();i++) {
				if(titulo.equals(ListaEspectaculosP.get(i).getTitulo())) {
							switch(opcion) {
								case 1:
									this.ListaEspectaculosP.get(i).setTitulo(nuevotitulo);
								break;
								case 2:
									this.ListaEspectaculosP.get(i).setDescripcion(nuevadescripcion);
								break;
								case 3:
									this.ListaEspectaculosP.get(i).setCategoria(nuevacategoria);
								break;
								case 4:
									this.ListaEspectaculosP.get(i).setAforolocalidades(nuevoaforolocalidades);
								break;
								case 5:
									this.ListaEspectaculosP.get(i).setLocalidadesvendidas(localidadesvendidas);
								break;
								case 6:
									this.ListaEspectaculosP.get(i).setFechaPuntual(fecha2);
										
								break;
							}
				}
			}
			PDAO.actualizarPuntualBD(titulo, nuevotitulo, nuevadescripcion, nuevacategoria, nuevoaforolocalidades, localidadesvendidas, fecha2, opcion);
			
			
	}
		/**
		* Actualiza un espectaculo en la lista de espectaculos de temporada
		 * @param titulo El titulo del espectaculo a cambiar
		 * @param nuevotitulo El nuevo titulo del espectaculo
		 * @param nuevadescripcion La nueva descripcion del espectaculo
		 * @param nuevacategoria La nueva categoria del espectaculo
		 * @param nuevoaforolocalidades El nuevo aforo del espectaculo
		 * @param localidadesvendidas Las ventas del espectaculo
		 * @param nuevafechafin La nueva fecha de finalizacion de temporada
		 * @param nuevafechainicio La nueva fecha de inicio de temporada
		 * @param dia El nuevo dia de la semana
		 * @param opcion La opcion que elige el usuario en el main que determina el cambio que se realizara sobre el espectaculo
		 * @throws IOException
		 */
		public void updateEspectaculoT(String titulo,String nuevotitulo,String nuevadescripcion,categoria nuevacategoria,int nuevoaforolocalidades,
				int localidadesvendidas,Date nuevafechafin,Date nuevafechainicio,String dia,int opcion) throws IOException {
			for(int i=0;i<ListaEspectaculosT.size();i++) {
				if(titulo.equals(ListaEspectaculosT.get(i).getTitulo())) {
							switch(opcion) {
								case 1:
									this.ListaEspectaculosT.get(i).setTitulo(nuevotitulo);
								break;
								case 2:
									this.ListaEspectaculosT.get(i).setDescripcion(nuevadescripcion);
								break;
								case 3:
									this.ListaEspectaculosT.get(i).setCategoria(nuevacategoria);
								break;
								case 4:
									this.ListaEspectaculosT.get(i).setAforolocalidades(nuevoaforolocalidades);
								break;
								case 5:
									this.ListaEspectaculosT.get(i).setLocalidadesvendidas(localidadesvendidas);
								break;
								case 6:
									this.ListaEspectaculosT.get(i).setDia(dia);
								break;
								case 7:
									this.ListaEspectaculosT.get(i).setInicio(nuevafechainicio);
								break;
								case 8:
									this.ListaEspectaculosT.get(i).setFin(nuevafechafin);
								break;
							}
				}
			}
			TDAO.actualizarTemporadaBD(titulo, nuevotitulo, nuevadescripcion, nuevacategoria, nuevoaforolocalidades, localidadesvendidas, nuevafechafin, nuevafechainicio, dia, opcion);
			
			
			
	}
		/**
		 * Devuelve una lista con los espectaculos con entradas disponibles
		 * @return lista La lista con los titulos de los espectaculos con entradas disponibles
		 */
		public ArrayList<String> entradasDisponibles() {
			ArrayList<String> lista=new ArrayList<String>();
			int entradas=0;
			for(int i=0; i< ListaEspectaculosT.size(); i++) {
			
					entradas=ListaEspectaculosT.get(i).entradasDisponibles();
					if(entradas>0) {
						lista.add(ListaEspectaculosT.get(i).getTitulo());
					
					
					
				}
			}
			entradas=0;
			for(int i=0; i< ListaEspectaculosP.size(); i++) {
				
					entradas=ListaEspectaculosP.get(i).entradasDisponibles();
					if(entradas>0) {
						lista.add(ListaEspectaculosP.get(i).getTitulo());
					}
					
				
			}
			entradas=0;
			for(int i=0; i< ListaEspectaculosM.size(); i++) {
					
						entradas=ListaEspectaculosM.get(i).entradasDisponibles();
						if(entradas>0) {
							lista.add(ListaEspectaculosM.get(i).getTitulo());
						}
					
			}
			return lista;
			
		}
		/**
		 * Devuelve una lista de los titulos de los espectaculos con entradas y sesiones posteriores a uan fecha
		 * @param fecha Fecha a partir de la cual se calculan los prï¿½ximos espectaculos (en el main se introduce la actual)
		 * @return lista Lista de cadenas con los titulos de los espectaculos proximos
		 */
		public ArrayList<String> proximosEspectaculos(Date fecha) {
			ArrayList<String> lista=new ArrayList<String>();
			int entradas=0;
			for(int i=0; i< ListaEspectaculosT.size(); i++) {
				if(ListaEspectaculosT.get(i).getInicio().compareTo(fecha)<0
				&& ListaEspectaculosT.get(i).getFin().compareTo(fecha)>0 ) {
					entradas=ListaEspectaculosT.get(i).entradasDisponibles();
					if(entradas>0) {
						lista.add(ListaEspectaculosT.get(i).getTitulo());
					}
					
					
				}
			}
			entradas=0;
			for(int i=0; i< ListaEspectaculosP.size(); i++) {
				if(ListaEspectaculosP.get(i).getFechaPuntual().compareTo(fecha)<0) {
					entradas=ListaEspectaculosP.get(i).entradasDisponibles();
					if(entradas>0) {
						lista.add(ListaEspectaculosP.get(i).getTitulo());
					}
					
				}
			}
			entradas=0;
			for(int i=0; i< ListaEspectaculosM.size(); i++) {
				for(int j=0;j<ListaEspectaculosM.get(i).getListaFechas().size();j++) {
					if(ListaEspectaculosM.get(i).getListaFechas().get(j).compareTo(fecha)<0) {
						entradas=ListaEspectaculosM.get(i).entradasDisponibles();
						if(entradas>0) {
							lista.add(ListaEspectaculosM.get(i).getTitulo());
						}
					}
				}
			}
			return lista;
		}
		/**
		 * Devuelve una cadena de los titulos de los espectaculos con entradas pertenecientes a una categoria dada
		 * @param fecha Sesion de los espectaculos con entradas a devolver 
		 * @param categoria Categoria que deben cumplir los espectaculos devueltos
		 * @return lista Lista con los titulos de los espectaculos
		 */
		public ArrayList<String> entradasDisponiblesCategoria(Date fecha,categoria categoria) {
			ArrayList<String> lista=new ArrayList<String>();
			int entradas=0;
			for(int i=0; i< ListaEspectaculosT.size(); i++) {
				if(ListaEspectaculosT.get(i).getInicio().compareTo(fecha)<0
				&& ListaEspectaculosT.get(i).getFin().compareTo(fecha)>0 && ListaEspectaculosT.get(i).getCategoria()==categoria) {
					entradas=ListaEspectaculosT.get(i).entradasDisponibles();
					if(entradas>0) {
						lista.add(ListaEspectaculosT.get(i).getTitulo());
					}
					
					
				}
			}
			entradas=0;
			for(int i=0; i< ListaEspectaculosP.size(); i++) {
				if(ListaEspectaculosP.get(i).getFechaPuntual().compareTo(fecha)<0&& ListaEspectaculosT.get(i).getCategoria()==categoria) {
					entradas=ListaEspectaculosP.get(i).entradasDisponibles();
					if(entradas>0) {
						lista.add(ListaEspectaculosP.get(i).getTitulo());
					}
					
				}
			}
			entradas=0;
			for(int i=0; i< ListaEspectaculosM.size(); i++) {
				for(int j=0;j<ListaEspectaculosM.get(i).getListaFechas().size();j++) {
					if(ListaEspectaculosM.get(i).getListaFechas().get(j).compareTo(fecha)<0&& ListaEspectaculosT.get(i).getCategoria()==categoria) {
						entradas=ListaEspectaculosM.get(i).entradasDisponibles();
						if(entradas>0) {
							lista.add(ListaEspectaculosM.get(i).getTitulo());
						}
					}
				}
			}
			return lista;
			
		}
		
		/**
		 * Devuelve las entradas disponibles dado un titulo y una fecha
		 * @param titulo Titulo del espectaculo a buscar
		 * @param fecha Fecha de la sesion 
		 * @return
		 */
		public int localidadesDisponibles(String titulo,Date fecha) {
			int entradas=0;
			for(int i=0; i< ListaEspectaculosP.size(); i++) {
				if(titulo.equals(ListaEspectaculosP.get(i).getTitulo()) && ListaEspectaculosP.get(i).getFechaPuntual().compareTo(fecha)==0) {
					entradas=ListaEspectaculosP.get(i).entradasDisponibles();
					if(entradas>0) {
						
						return entradas;
					}
				}
				
			}
			
			for(int i=0; i< ListaEspectaculosT.size(); i++) {
				if(titulo.equals(ListaEspectaculosT.get(i).getTitulo()) && ListaEspectaculosT.get(i).getInicio().compareTo(fecha)<0
						&&ListaEspectaculosT.get(i).getFin().compareTo(fecha)>0 || ListaEspectaculosT.get(i).getFin().compareTo(fecha)==0
						||ListaEspectaculosT.get(i).getInicio().compareTo(fecha)==0) {
					entradas=ListaEspectaculosT.get(i).entradasDisponibles();
					if(entradas>0) {
						return entradas;
					}
				}
			}
			for(int i=0; i< ListaEspectaculosM.size(); i++) {
				if(titulo.equals(ListaEspectaculosM.get(i).getTitulo())){
					for(int j=0;j<ListaEspectaculosM.get(i).getListaFechas().size();j++) {
						if(fecha.compareTo(ListaEspectaculosM.get(i).getListaFechas().get(j))==0) {
							entradas=ListaEspectaculosM.get(i).entradasDisponibles();
							if(entradas>0) {
								return entradas;
							}
							
							
						}
					
					}
				}
				
			}
			
			
			return entradas;
		}
		/**
		 * Indica de que tipo es el espectaculo dado el titulo
		 * @param titulo El titulo del espectaculo
		 * @return tipo Retorna un entero distinto asociado a cada tipo
		 */
		public int tipoEvento(String titulo) {
			int tipo=0;
			for(int i=0;i<ListaEspectaculosM.size();i++) {
				if(titulo.equals(ListaEspectaculosM.get(i).getTitulo())) {
					tipo=1; //Espectaculo Multiple
				}
			}
			for(int i=0;i<ListaEspectaculosT.size();i++) {
				if(titulo.equals(ListaEspectaculosT.get(i).getTitulo())) {
					tipo=2; //Espectaculo de temporada
				}
			}
			for(int i=0;i<ListaEspectaculosP.size();i++) {
				if(titulo.equals(ListaEspectaculosP.get(i).getTitulo())) {
					tipo=3; //Espectaculo puntual
				}
			}
			return tipo;
		}
		
		public categoria queCate(String titulo) {
			for(int i=0;i<ListaEspectaculosM.size();i++) {
				if(titulo.equals(ListaEspectaculosM.get(i).getTitulo())) {
					return ListaEspectaculosM.get(i).getCategoria();
				}
			}
			for(int i=0;i<ListaEspectaculosT.size();i++) {
				if(titulo.equals(ListaEspectaculosT.get(i).getTitulo())) {
					return ListaEspectaculosT.get(i).getCategoria();
				}
			}
			for(int i=0;i<ListaEspectaculosP.size();i++) {
				if(titulo.equals(ListaEspectaculosP.get(i).getTitulo())) {
					return ListaEspectaculosP.get(i).getCategoria();
				}
			}
			return null;
		}
		
		public String propiedades(int elec) {
			
			Properties prop = new Properties();
			String filename = "conf.propierties";
			String f=null;
			try {
				BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
				prop.load(reader);
				if(elec==1) {
					f = prop.getProperty("puntual");
				}
				else if(elec==2) {
					f = prop.getProperty("temporal");
				}else {
					f = prop.getProperty("multiple");
				}
						
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return f;
		}
}
