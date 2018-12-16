package Oficina;

// Fig. 23.12: Productor.java
// Productor con un método run que inserta los valores del 1 al 10 en el búfer.
import java.util.Random;

public class Productor implements Runnable
{
   private final static Random generador = new Random();
   private final Bufer ubicacionCompartida; // referencia al objeto compartido
   private int NDocumentos;
   
   int[] numeros;
   // constructor
   public Productor( Bufer compartido, int NDocum )
   {
       ubicacionCompartida = compartido;
       NDocumentos = NDocum;
       numeros =new int[NDocumentos];
       
       for (int i = 0; i < numeros.length; i++) {
		numeros[i] = generador.nextInt(3);
	}
       
   } // fin del constructor de Productor

   // almacena valores del 1 al 10 en ubicacionCompartida
   public void run()                             
   {
	int altas = 0;
	int RenovacionVigencia = 0;
	int SolicitudCredencial = 0;


	int Actual = 0;
			//sin tiempo porque durara hasta que terminen todos los turnos dados
	while (  Actual  < NDocumentos )	
	{

		try // permanece inactivo de 0 a 10 segundos, después coloca valor en Bufer
		{
			int tipo = (numeros[Actual])+1;
			ubicacionCompartida.establecer( tipo ); // establece el tipo de servicio

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

	

	System.out.println( "\nFila cerrada - Totales :\n" );

	System.out.print("Altas: "+altas +"\n" );
	System.out.print( "Renovacion de vigencia: "+ RenovacionVigencia  +"\n" );
	System.out.print( "Solicitud de credencial: "+ SolicitudCredencial  +"\n" );

	System.out.printf( "Totales: "+ (altas + RenovacionVigencia + SolicitudCredencial) +"\n\n\n" );

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