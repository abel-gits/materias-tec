package Proyecto3;
import java.sql.CallableStatement;
// Fig. 25.31: ConsultasPersona.java
// Instrucciones PreparedStatement utilizadas por la aplicación Libreta de direcciones
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class ConsultasPelicula 
{	
	 public static Connection sql;
   private static final String URL = "jdbc:derby:Peliculas";
   private static final String NOMBREUSUARIO = "usuario1";
   private static final String CONTRASENIA = "123";

   private Connection conexion = null; // maneja la conexión
   private PreparedStatement seleccionarTodasLasPersonas = null; 
   private PreparedStatement seleccionarPersonasPorApellido = null; 
   private PreparedStatement insertarNuevaPersona = null; 
   private PreparedStatement modificarPelicula= null;
   // constructor
   public ConsultasPelicula()
   {
      try 
      {
         conexion = 
            DriverManager.getConnection( URL, NOMBREUSUARIO, CONTRASENIA );

         // crea una consulta que selecciona todas las entradas en la LibretaDirecciones
         seleccionarTodasLasPersonas = 
            conexion.prepareStatement( "SELECT * FROM Direcciones" );
         
         // crea una consulta que selecciona las entradas con un apellido específico
         seleccionarPersonasPorApellido = conexion.prepareStatement( 
            "SELECT * FROM Direcciones WHERE Titulo = ?" );
         
         // crea instrucción insert para agregar una nueva entrada en la base de datos
         insertarNuevaPersona = conexion.prepareStatement( 
            "INSERT INTO Direcciones " + 
            "( Titulo, Genero, Directores, Escritores,Duracion,Activo ) " + 
            "VALUES ( ?, ?, ?, ?,?,? )" );
      } // fin de try
      catch ( SQLException excepcionSql )
      {
         excepcionSql.printStackTrace();
         System.exit( 1 );
      } // fin de catch
   } // fin del constructor de ConsultasPersona
   
   // selecciona todas las direcciones en la base de datos
   public List< Pelicula > obtenerTodasLasPersonas()
   {
      List< Pelicula > resultados = null;
      ResultSet conjuntoResultados = null;
      
      try 
      {
         // executeQuery devuelve ResultSet que contiene las entradas que coinciden
         conjuntoResultados = seleccionarTodasLasPersonas.executeQuery(); 
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
   
   public List< Pelicula > obtenerPersonasPorApellido( String Titulo )
   {
      List< Pelicula > resultados = null;
      ResultSet conjuntoResultados = null;

      try 
      {
         seleccionarPersonasPorApellido.setString( 1, Titulo ); // especifica el apellido paterno

         // executeQuery devuelve ResultSet que contiene las entradas que coinciden
         conjuntoResultados = seleccionarPersonasPorApellido.executeQuery(); 

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
   public  int agregarPersona( 
      String Titulo, String Genero, String Directores, String Escritores,String Duracion,Boolean Activo )
   {
      int resultado = 0;
      
      // establece los parámetros, después ejecuta insertarNuevaPersona
      try 
      {
         insertarNuevaPersona.setString( 1, Titulo );
         insertarNuevaPersona.setString( 2, Genero );
         insertarNuevaPersona.setString( 3, Directores );
         insertarNuevaPersona.setString( 4, Escritores );           
         insertarNuevaPersona.setString( 5, Duracion );
         insertarNuevaPersona.setBoolean(6, Activo);

         // inserta la nueva entrada; devuelve # de filas actualizadas
         resultado = insertarNuevaPersona.executeUpdate(); 
      } // fin de try
      catch ( SQLException excepcionSql )
      {
         excepcionSql.printStackTrace();
         close();
      } // fin de catch
      
      return resultado;
   } // fin del método agregarPersona 
   public void modificar(String Titulo, String Genero, String Directores, String Escritores,String Duracion,Boolean Activo){
	  

	   }
	
   // cierra la conexión a la base de datos
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

 