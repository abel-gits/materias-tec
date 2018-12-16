// Fig. 23.18: BuferSincronizado.java
// Sincronización del acceso a datos compartidos, usando los  
// métodos wait y notify de Object.
public class BuferSincronizado implements Bufer
{
   private int bufer = -1; // compartido por los subprocesos productor y consumidor
   private boolean ocupado = false;// indica si el búfer está ocupado o no
   
   // coloca el valor en el búfer
   public synchronized void establecer( int valor ) throws InterruptedException
   {
      // mientras no haya ubicaciones vacías, coloca el subproceso en espera
      while ( ocupado ) 
      {
         // imprime información del subproceso e información del búfer, después espera
         System.out.println( "Productor trata de escribir." );
         mostrarEstado( "Bufer lleno. Productor espera." );
         wait();
      } // fin de while
        
      bufer = valor; // establece el nuevo valor del búfer
        
      // indica que el productor no puede almacenar otro valor
      // hasta que el consumidor obtenga el valor actual del búfer
      ocupado = true;
        
      mostrarEstado( "Productor escribe " + bufer );
      
      notifyAll(); // indica al (los) subproceso(s) en espera que entren al estado runnable
   } // fin del método establecer; libera el bloqueo sobre BuferSincronizado 
    
   // devuelve el valor del búfer
   public synchronized int obtener() throws InterruptedException
   {
      // mientras no haya datos para leer, coloca el subproceso en el estado en espera
      while ( !ocupado )
      {
         // imprime la información del subproceso y la información del búfer, después espera
         System.out.println( "Consumidor trata de leer." );
         mostrarEstado( "Bufer vacio. Consumidor espera." );
         wait();
      } // fin de while

      // indica que el productor puede almacenar otro valor
      // debido a que el consumidor acaba de obtener el valor del búfer
      ocupado = false;

      mostrarEstado( "Consumidor lee " + bufer );
      
      notifyAll(); // indica al (los) subproceso(s) en espera que entren al estado runnable

      return bufer;
   } // fin del método obtener; libera el bloqueo sobre BuferSincronizado 
    
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