// Fig. 25.23: MostrarAutores.java
// Muestra el contenido de la tabla autores.
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MostrarAutores 
{
   // nombre del controlador de JDBC y URL de la base de datos 
   // static final String CONTROLADOR = "com.mysql.jdbc.Driver";             
   static final String URL_BASEDATOS = "jdbc:derby:Libros";
   
   // inicia la aplicación
   public static void main( String args[] )
   {
      Connection conexion = null; // maneja la conexión
      Statement instruccion = null; // instrucción de consulta
      ResultSet conjuntoResultados = null; // maneja los resultados    
      // se conecta a la base de datos libros y realiza una consulta
      try 
      {
         // carga la clase controlador
         // Class.forName( CONTROLADOR );

         // establece la conexión a la base de datos 
         conexion =                                                     
            DriverManager.getConnection( URL_BASEDATOS, "jhtp7", "jhtp7" );

         // crea objeto Statement para consultar la base de datos
         instruccion = conexion.createStatement();
         
         // consulta la base de datos
         conjuntoResultados = instruccion.executeQuery(            
            "SELECT IDAutor, nombrePila, apellidoPaterno FROM autores" );
         
         // procesa los resultados de la consulta
         ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();
         int numeroDeColumnas = metaDatos.getColumnCount();     
         System.out.println( "Tabla Autores de la base de datos Libros:\n" );
         
         for ( int i = 1; i <= numeroDeColumnas; i++ )
            System.out.printf( "%-8s\t", metaDatos.getColumnName( i ) );
         System.out.println();
         
         while ( conjuntoResultados.next() ) 
         {
            for ( int i = 1; i <= numeroDeColumnas; i++ )
               System.out.printf( "%-8s\t", conjuntoResultados.getObject( i ) );
            System.out.println();
         } // fin de while
      }  // fin de try
      catch ( SQLException excepcionSql )                                
      {                                                                  
         excepcionSql.printStackTrace();
      } // fin de catch                                                     
/*
      catch ( ClassNotFoundException noEncontroClase )                     
      {                                                                  
         noEncontroClase.printStackTrace();            
      } // fin de catch                                                     
*/
      finally // asegura que conjuntoResultados, instruccion y conexion estén cerrados
      {                                                             
         try                                                        
         {                                                          
            conjuntoResultados.close();                                      
            instruccion.close();                                      
            conexion.close();                                     
         } // fin de try                                               
         catch ( Exception excepcion )                              
         {                                                          
            excepcion.printStackTrace();                            
         } // fin de catch                                             
      } // fin de finally                                              
   } // fin de main
} // fin de la clase MostrarAutores



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

 