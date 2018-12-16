// Fig. 23.22: BuferSincronizado.java
// Sincroniza el acceso a un entero compartido, usando las interfaces
// Lock y Condition
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class BuferSincronizado implements Bufer
{
   // Bloqueo para controlar la sincronización con este búfer
   private final Lock bloqueoAcceso = new ReentrantLock();

   // condiciones para controlar la lectura y escritura
   private final Condition puedeEscribir = bloqueoAcceso.newCondition();
   private final Condition puedeLeer = bloqueoAcceso.newCondition();

   private int bufer = -1; // compartido por los subprocesos productor y consumidor
   private boolean ocupado = false; // indica si el búfer está ocupado
   
   // coloca un valor int en el búfer
   public void establecer( int valor ) throws InterruptedException
   {
      bloqueoAcceso.lock(); // bloquea este objeto
               
      // imprime información del subproceso y del búfer, después espera
      try
      {
         // mientras bufer no esté vacío, coloca el subproceso en espera
         while ( ocupado ) 
         {
            System.out.println( "Productor trata de escribir." );
            mostrarEstado( "Bufer lleno. Productor espera." );
            puedeEscribir.await();// espera hasta que bufer esté vacío
         } // fin de while

         bufer = valor; // establece el nuevo valor de bufer

         // indica que el productor no puede almacenar otro valor
         // hasta que el consumidor obtenga el valor actual del búfer
         ocupado = true;
        
         mostrarEstado( "Productor escribe " + bufer );

         // indica al subproceso en espera que lea del búfer
         puedeLeer.signal(); 
      } // fin de try
      finally
      {
         bloqueoAcceso.unlock(); // desbloquea este objeto
      } // fin de finally
   } // fin del método establecer
    
   // devuelve el valor del búfer
   public int obtener() throws InterruptedException
   {
      int valorLeido = 0; // inicializa el valor que se leyó del búfer
      bloqueoAcceso.lock(); // bloquea este objeto

      // imprime información del subproceso y del búfer, después espera
      try
      {
         // mientras no haya datos qué leer, coloca el subproceso en espera
         while ( !ocupado ) 
         {
            System.out.println( "Consumidor trata de leer." );
            mostrarEstado( "Bufer vacio. Consumidor espera." );
            puedeLeer.await(); // espera hasta que bufer esté lleno
         } // fin de while

         // indica que el productor puede almacenar otro valor
         // porque el consumidor acaba de obtener el valor del búfer
         ocupado = false;

         valorLeido = bufer; // obtiene el valor del búfer
         mostrarEstado( "Consumidor lee " + valorLeido );

         // indica al subproceso que espera a que el búfer esté vacío
         puedeEscribir.signal();
      } // fin de try
      finally
      {
         bloqueoAcceso.unlock(); // desbloquea este objeto
      } // fin de finally

      return valorLeido;
   } // fin del método obtener
    
   // muestra la operación actual y el estado del búfer
   public void mostrarEstado( String operacion )
   {
      System.out.printf( "%-40s%d\t\t%b\n\n", operacion, bufer, 
         ocupado );
   } // fin del método mostrarEstado
} // fin de la clase BuferSincronizado


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