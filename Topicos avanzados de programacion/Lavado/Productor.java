package Lavado;

// Fig. 23.12: Productor.java
// Productor con un método run que inserta los valores del 1 al 10 en el búfer.
import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Productor implements Runnable
{
   private final static Random generador = new Random();
   private final Bufer ubicacionCompartida; // referencia al objeto compartido
   private Calendar tiempo;

   // constructor
   public Productor( Bufer compartido )
   {
       ubicacionCompartida = compartido;
   } // fin del constructor de Productor

   // almacena valores del 1 al 10 en ubicacionCompartida
   public void run()                             
   {
	int basico = 0;
	int normal = 0;
	int extra = 0;

	long horaInicial = 0;
	long horaActual = 0;

	tiempo = new GregorianCalendar();
	horaInicial = tiempo.getTimeInMillis();
	horaActual = horaInicial;
									//2minutos
	while ( ( horaActual - horaInicial ) <= 120000 )	// 2 minutos
	{

		try // permanece inactivo de 0 a 10 segundos, después coloca valor en Bufer
		{
			Thread.sleep( generador.nextInt( 10000 ) ); // periodo de inactividad aleatorio
			int tipo = generador.nextInt( 3 ) + 1;
			ubicacionCompartida.establecer( tipo ); // establece el tipo de servicio

			if ( tipo == 1 )
				basico ++;
			else if ( tipo == 2 )
				normal ++;
			else
				extra ++;
		} // fin de try
		catch ( InterruptedException excepcion ) 
		{
			excepcion.printStackTrace();
		} // fin de catch

		// Actualizar el tiempo
		tiempo = new GregorianCalendar();
		horaActual = tiempo.getTimeInMillis();
	}

	double impBasico = basico * 80.0;
	double impNormal = normal * 100.0;
	double impExtra = extra * 120.0;

	System.out.println( "AutoLavado Cerrado\nTotales de servicio:" );

	System.out.printf( "Tipo\tCantidad\tImporte\n" );
	System.out.printf( "Basico\t%d\t%7.2f\n", basico, impBasico );
	System.out.printf( "Normal\t%d\t%7.2f\n", normal, impNormal );
	System.out.printf( "Extra\t%d\t%7.2f\n", extra, impExtra );

	System.out.printf( "Totales\t%d\t%7.2f\n", basico + normal + extra, impBasico + impNormal + impExtra );

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