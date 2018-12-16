// Fig. 23.15: PruebaBuferCompartido.java
// Aplicación con dos subprocesos que manipulan un búfer sin sincronización.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class PruebaBuferCompartido
{
   public static void main( String[] args )
   {
      // crea nueva reserva de subprocesos con dos subprocesos
      ExecutorService aplicacion = Executors.newCachedThreadPool();

      // crea objeto BuferSinSincronizacion para almacenar valores int       
      Bufer ubicacionCompartida = new BuferSinSincronizacion();

      System.out.println( 
         "Accion\t\t\tValor\tSuma producidos\tSuma consumidos" );
      System.out.println( 
         "------\t\t\t-----\t---------------\t---------------\n" );

      // ejecuta el Productor y el Consumidor; a cada uno de ellos
      // le proporciona acceso a ubicacionCompartida
      aplicacion.execute( new Productor( ubicacionCompartida ) );
      aplicacion.execute( new Consumidor( ubicacionCompartida ) );

      aplicacion.shutdown(); // termina la aplicación cuando se completan las tareas
   } // fin de main
} // fin de la clase PruebaBuferCompartido




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