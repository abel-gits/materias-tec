// Fig. 23.16: BuferBloqueo.java
// Crea un búfer sincronizado, usando la clase ArrayBlockingQueue.
import java.util.concurrent.ArrayBlockingQueue;

public class BuferBloqueo implements Bufer
{
   private final ArrayBlockingQueue<Integer> bufer; // bufer compartido

   public BuferBloqueo()
   {
      bufer = new ArrayBlockingQueue<Integer>( 1 );
   } // fin del constructor de BuferBloqueo
   
   // coloca un valor en el búfer
   public void establecer( int valor ) throws InterruptedException
   {
      bufer.put( valor ); // coloca el valor en el búfer
      System.out.printf( "%s%2d\t%s%d\n", "Productor escribe ", valor,
         "Celdas de Bufer ocupadas: ", bufer.size() );
   } // fin del método establecer

   // devuelve el valor del búfer
   public int obtener() throws InterruptedException
   {
      int valorLeido = 0; // inicializa el valor leído del búfer

      valorLeido = bufer.take(); // elimina el valor del búfer
      System.out.printf( "%s   %2d\t%s%d\n", "Consumidor lee ", 
         valorLeido, "Celdas de Bufer ocupadas: ", bufer.size() );

      return valorLeido;
   } // fin del método obtener
} // fin de la clase BuferBloqueo


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