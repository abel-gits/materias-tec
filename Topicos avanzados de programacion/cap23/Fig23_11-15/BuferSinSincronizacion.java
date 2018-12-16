// Fig. 23.14: BuferSinSincronizacion.java
// BuferSinSincronizacion mantiene el entero compartido que utilizan los 
// subprocesos productor y consumidor mediante los métodos establecer y obtener.
public class BuferSinSincronizacion implements Bufer
{
   private int bufer = -1; // compartido por los subprocesos productor y consumidor

   // coloca el valor en el búfer
   public void establecer( int valor ) throws InterruptedException
   {
      System.out.printf( "Productor escribe\t%2d", valor );
      bufer = valor;
   } // fin del método establecer

   // devuelve el valor del búfer
   public int obtener() throws InterruptedException
   {
      System.out.printf( "Consumidor lee\t\t%2d", bufer );
      return bufer;
   } // fin del método obtener
} // fin de la clase BuferSinSincronizacion




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