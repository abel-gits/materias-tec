// Fig. 23.5: CreadorSubproceso.java
// Creación e inicio de tres subprocesos para ejecutar objetos Runnable.
import java.lang.Thread;

public class CreadorSubproceso
{
   public static void main( String[] args )
   {
      System.out.println( "Creacion de subprocesos" );

      // crea cada subproceso con un nuevo objeto Runnable
      Thread subproceso1 = new Thread( new TareaImprimir( "tarea1" ) );
      Thread subproceso2 = new Thread( new TareaImprimir( "tarea2" ) );
      Thread subproceso3 = new Thread( new TareaImprimir( "tarea3" ) );

      System.out.println( "Subprocesos creados, iniciando tareas." );

      // inicia los subprocesos y los coloca en el estado "en ejecución"
      subproceso1.start(); // invoca al método run de tarea1
      subproceso2.start(); // invoca al método run de tarea2
      subproceso3.start(); // invoca al método run de tarea3

      System.out.println( "Tareas iniciadas, main termina.\n" );
   } // fin de main
} // fin de la clase CreadorSubproceso   
     


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