package Oficina;

// Fig 23.21: PruebaBuferCircular.java
// Muestra dos subprocesos que manipulan un b�fer circular.
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PruebaBuferCircular
{	
	 private final static Random generador = new Random();
     
     
   public static void main( String[] args )
   {
      // crea nueva reserva con dos subprocesos
      ExecutorService aplicacion = Executors.newCachedThreadPool();

      // crea objeto BuferCircular para almacenar valores int
      BuferCircular ubicacionCompartida = new BuferCircular();

      // muestra el estado inicial del objeto BuferCircular
      int NDocumentos = generador.nextInt(50);
      ubicacionCompartida.mostrarEstado( "La oficina abre las puertas : Se atenderan un total de  "+NDocumentos+" Documentos el dia de hoy " );
      	
       
       //System.out.println("Abra un total de "+NDocumentos +" de Tramites el dia de hoy");
       
      // ejecuta las tareas Productor y Consumidor
      aplicacion.execute( new Productor( ubicacionCompartida, NDocumentos ) );
      aplicacion.execute( new Consumidor( ubicacionCompartida, NDocumentos ) );

      aplicacion.shutdown();
   } // fin de main
} // fin de la clase PruebaBuferCircular



/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigaci�n y prueba de las teor�as y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garant�a de      *
 * ning�n tipo, expresa o impl�cita, en relaci�n con estos programas o    *
 * con la documentaci�n contenida en estos libros. Los autores y el       *
 * editor no ser�n responsables en ning�n caso por los da�os consecuentes *
 * en conexi�n con, o que surjan de, el suministro, desempe�o o uso de    *
 * estos programas.                                                       *
 *************************************************************************/