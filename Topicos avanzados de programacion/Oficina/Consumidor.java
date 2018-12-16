package Oficina;

// Fig. 23.13: Consumidor.java
// Consumidor con un método run que itera y lee 10 valores del búfer.
import java.util.Random;


public class Consumidor implements Runnable
{ 
   private final static Random generador = new Random();
   private final Bufer ubicacionCompartida; // referencia al objeto compartido
 
   private int Ndocumentos;
   
   // constructor
   public Consumidor( Bufer compartido, int NDocum )
   {
	Ndocumentos = NDocum;   
      ubicacionCompartida = compartido;
   } // fin del constructor de Consumidor

   // lee el valor de ubicacionCompartida 10 veces y suma los valores
   public void run()                             
   {
	int altas = 0;
	int RenovacionVigencia = 0;
	int SolicitudCredencial = 0;

	
	int Actual = 0;
	//sin tiempo porque durara hasta que terminen todos los turnos dados
	while (  Actual  < Ndocumentos  )	
	{

		try // permanece inactivo de 0 a 10 segundos, después coloca valor en Bufer
		{
			Thread.sleep(1000 + generador.nextInt( 1000 ) ); // entre 10 y 20 minutos 
			
			int tipo = ubicacionCompartida.obtener(); // establece el tipo de servicio

			if ( tipo == 1 )
				altas ++;
			else if ( tipo == 2 )
				RenovacionVigencia ++;
			else
				SolicitudCredencial ++;
		} // fin de try
		catch ( InterruptedException excepcion ) 
		{
			excepcion.printStackTrace();
		} // fin de catch

		// Actualizar el tiempo
		
		Actual++;
	}

	

	System.out.println( "\nOficina cerrada\nTotales de documentos:\n" );

	System.out.print("Altas: "+altas +"\n" );
	System.out.print( "Renovacion de vigencia: "+ RenovacionVigencia  +"\n" );
	System.out.print( "Solicitud de credencial: "+ SolicitudCredencial  +"\n" );

	System.out.printf( "Totales: "+ (altas + RenovacionVigencia + SolicitudCredencial) +"\n" );

   } // fin del método run
} // fin de la clase Productor



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