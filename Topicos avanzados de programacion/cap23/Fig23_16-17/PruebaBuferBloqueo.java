// Fig 23.17: PruebaBuferBloqueo.java
// Muestra a dos subprocesos manipulando un bufer con bloqueo.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PruebaBuferBloqueo
{
   public static void main( String[] args )
   {
      // crea nueva reserva de subprocesos con dos subprocesos
      ExecutorService aplicacion = Executors.newCachedThreadPool();

      // crea objeto BuferBloqueo para almacenar valores int
      Bufer ubicacionCompartida = new BuferBloqueo();

      aplicacion.execute( new Productor( ubicacionCompartida ) );
      aplicacion.execute( new Consumidor( ubicacionCompartida ) );

      aplicacion.shutdown();
   } // fin de main
} // fin de la clase PruebaBuferBloqueo



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