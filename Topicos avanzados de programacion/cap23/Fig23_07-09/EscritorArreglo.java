// Fig. 23.8: EscritorArreglo.java
// Agrega enteros a un arreglo compartido con otros objetos Runnable
import java.lang.Runnable;

public class EscritorArreglo implements Runnable
{
   private final ArregloSimple arregloSimpleCompartido;
   private final int valorInicial;

   public EscritorArreglo( int valor, ArregloSimple arreglo )
   {
      valorInicial = valor;
      arregloSimpleCompartido= arreglo;
   } // fin del constructor

   public void run()
   {
      for ( int i = valorInicial; i < valorInicial + 3; i++ )
      {
         arregloSimpleCompartido.agregar( i ); // agrega un elemento al arreglo compartido
      } // fin de for
   } // fin del método run
} // fin de la clase EscritorArreglo





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