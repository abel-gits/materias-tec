

// Instrucciones PreparedStatement utilizadas por la aplicación Libreta de direcciones
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.derby.iapi.store.access.conglomerate.Conglomerate;

import java.util.ArrayList;

public class ConsultasPelicula 
{	
	 public static Connection sql;
   private static final String URL = "jdbc:derby:CatalogoPeliculas";
   private static final String NOMBREUSUARIO = "usuario1";
   private static final String CONTRASENIA = "123";

   private Connection conexion = null; // maneja la conexión
   private PreparedStatement seleccionarTodasLasPeliculas = null; 
   private PreparedStatement seleccionarPeliculasPorTitulo = null; 
   private PreparedStatement insertarNuevaPelicula = null; 
   private PreparedStatement modificarPelicula= null;
   // constructor
   public ConsultasPelicula()
   {
      try 
      {
         conexion = 
            DriverManager.getConnection( URL, NOMBREUSUARIO, CONTRASENIA );

         // crea una consulta que selecciona todas las entradas en la LibretaDirecciones
         seleccionarTodasLasPeliculas = 
            conexion.prepareStatement( "SELECT * FROM CatalogoPeliculas" );
         
         // crea una consulta que selecciona las entradas con un apellido específico
         seleccionarPeliculasPorTitulo = conexion.prepareStatement( 
            "SELECT * FROM CatalogoPeliculas WHERE Titulo = ?" );
         
         // crea instrucción insert para agregar una nueva entrada en la base de datos
         insertarNuevaPelicula = conexion.prepareStatement( 
            "INSERT INTO CatalogoPeliculas " + 
            "( Titulo, Genero, Directores, Escritores,Duracion,Activo ) " + 
            "VALUES ( ?, ?, ?, ?,?,? )" );
         modificarPelicula = conexion.prepareStatement( 
                 "UPDATE CatalogoPeliculas SET Titulo=?,Genero=? ,Directores=?,Escritores=?,Duracion=?, Activo=? WHERE IDPeliculas =?" );
      } // fin de try
      catch ( SQLException excepcionSql )
      {  
         excepcionSql.printStackTrace();
         System.exit( 1 );
      } // fin de catch
   } // fin del constructor de ConsultasPersona
   
   // selecciona todas las direcciones en la base de datos
   public List< Pelicula > obtenerTodasLasPeliculas()
   {
      List< Pelicula > resultados = null;
      ResultSet conjuntoResultados = null;
      
      try 
      {
         // executeQuery devuelve ResultSet que contiene las entradas que coinciden
         conjuntoResultados = seleccionarTodasLasPeliculas.executeQuery(); 
         resultados = new ArrayList< Pelicula >();
         
         while ( conjuntoResultados.next() )
         {
            resultados.add( new Pelicula(
               conjuntoResultados.getInt( "idPeliculas" ),
               conjuntoResultados.getString( "Titulo" ),
               conjuntoResultados.getString( "Genero" ),
               conjuntoResultados.getString( "Directores" ),
               conjuntoResultados.getString( "Escritores" ),
               conjuntoResultados.getString( "Duracion" ),
               conjuntoResultados.getBoolean("Activo")));
         } // fin de while
      } // fin de try
      catch ( SQLException excepcionSql )
      {
         excepcionSql.printStackTrace();         
      } // fin de catch
      finally
      {
         try 
         {
            conjuntoResultados.close();
         } // fin de try
         catch ( SQLException excepcionSql )
         {
            excepcionSql.printStackTrace();         
            close();
         } // fin de catch
      } // fin de finally
      
      return resultados;
   } // fin del método obtenerTodasLasPersonaas
   
   // selecciona persona por apellido paterno
   
   public List< Pelicula > obtenerPeliculaPorTitulo( String Titulo )
   {
      List< Pelicula > resultados = null;
      ResultSet conjuntoResultados = null;

      try 
      {
         seleccionarPeliculasPorTitulo.setString( 1, Titulo ); // especifica el apellido paterno

         // executeQuery devuelve ResultSet que contiene las entradas que coinciden
         conjuntoResultados = seleccionarPeliculasPorTitulo.executeQuery(); 

         resultados = new ArrayList< Pelicula >();

         while ( conjuntoResultados.next() )
         {
            resultados.add( new Pelicula(
               conjuntoResultados.getInt( "idPeliculas" ),
               conjuntoResultados.getString( "Titulo" ),
               conjuntoResultados.getString( "Genero" ),
               conjuntoResultados.getString( "Directores" ),
               conjuntoResultados.getString( "Escritores" ),
               conjuntoResultados.getString( "Duracion" ),
               conjuntoResultados.getBoolean("Activo")
            		) );
         } // fin de while
      } // fin de try
      catch ( SQLException excepcionSql )
      {
         excepcionSql.printStackTrace();
      } // fin de catch
      finally
      {
         try 
         {
            conjuntoResultados.close();
         } // fin de try
         catch ( SQLException excepcionSql )
         {
            excepcionSql.printStackTrace();         
            close();
         } // fin de catch
      } // fin de finally
      
      return resultados;
   } // fin del método obtenerPersonasPorApellido
   
   // agrega una entrada
   public  int agregarPelicula( 
      String Titulo, String Genero, String Directores, String Escritores,String Duracion,Boolean Activo )
   {
      int resultado = 0;
      
      // establece los parámetros, después ejecuta insertarNuevaPersona
      try 
      {
         insertarNuevaPelicula.setString( 1, Titulo );
         insertarNuevaPelicula.setString( 2, Genero );
         insertarNuevaPelicula.setString( 3, Directores );
         insertarNuevaPelicula.setString( 4, Escritores );           
         insertarNuevaPelicula.setString( 5, Duracion );
         insertarNuevaPelicula.setBoolean(6, Activo);

         // inserta la nueva entrada; devuelve # de filas actualizadas
         resultado = insertarNuevaPelicula.executeUpdate(); 
      } // fin de try
      catch ( SQLException excepcionSql )
      {
         excepcionSql.printStackTrace();
         close();
      } // fin de catch
      
      return resultado;
   } // fin del método agregarPersona 
   public int modificar(String Titulo, String Genero, String Directores, String Escritores,String Duracion,Boolean Activo,int idpeliculas){
	   	int resultado = 0;
	      
	      // establece los parámetros, después ejecuta insertarNuevaPersona
	      try 
	      {
	    	 
	         modificarPelicula.setString( 1, Titulo );
	         modificarPelicula.setString( 2, Genero );
	         modificarPelicula.setString( 3, Directores );
	         modificarPelicula.setString( 4, Escritores );           
	         modificarPelicula.setString( 5, Duracion );
	         modificarPelicula.setBoolean(6, Activo);
	         modificarPelicula.setInt( 7, idpeliculas );
		  
	
	         // inserta la nueva entrada; devuelve # de filas actualizadas
	         resultado = modificarPelicula.executeUpdate(); 
	      } // fin de try
	      catch ( SQLException excepcionSql )
	      {
	         excepcionSql.printStackTrace();
	         close();
	      } // fin de catch
	      
	      return resultado;
   }
   
   public void close()
   {
      try 
      {
         conexion.close();
      } // fin de try
      catch ( SQLException excepcionSql )
      {
         excepcionSql.printStackTrace();
      } // fin de catch
   } // fin del método close
} // fin de la interfaz ConsultasPersona


/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigación y prueba de las teorías y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garantía de      *
 * ningún tipo, expresa o implícita, en relación con estos programas o    *
 * con la documentación contenida en estos libros. Los autores y el       *
 * editor no serán responsables en ningún caso por los daños consecuentes *
 * en conexión con, o que surjan de, el suministro, desempeño o uso de    *
 * estos programas.                                                       *
 *************************************************************************/

 