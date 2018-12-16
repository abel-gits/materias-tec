package Clinica;

// Fig. 23.13: Consumidor.java
// Consumidor con un método run que itera y lee 10 valores del búfer.
import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Consumidor implements Runnable
{ 
   private final static Random generador = new Random();
   private final Bufer ubicacionCompartida; // referencia al objeto compartido
   private Calendar tiempo;

   // constructor
   public Consumidor( Bufer compartido )
   {
      ubicacionCompartida = compartido;
   } // fin del constructor de Consumidor

   // lee el valor de ubicacionCompartida 10 veces y suma los valores
   public void run()                                           
   {

	int PacienteParticular = 0;
	int PacienteSeguimiento = 0;
	int PacienteBanco = 0;

	long horaInicial = 0;
	long horaActual = 0;

	tiempo = new GregorianCalendar();
	horaInicial = tiempo.getTimeInMillis();
	horaActual = horaInicial;
												//2minutos
	while ( ( ( horaActual - horaInicial ) <= 120000 ) || !ubicacionCompartida.estaVacio() )	// 10 minutos y que este vacio
	{

		try // permanece inactivo de 5 a 15 segundos, después lee valor del Bufer
		{
			Thread.sleep( 5000 + generador.nextInt( 10000 ) ); // periodo de inactividad aleatorio
			int tipo = ubicacionCompartida.obtener(); // lee el tipo de servicio

			if ( tipo == 1 )
				PacienteParticular ++;
			else if ( tipo == 2 )
				PacienteSeguimiento ++;
			else
				PacienteBanco ++;
		} // fin de try
		catch ( InterruptedException excepcion ) 
		{
			excepcion.printStackTrace();
		} // fin de catch

		// Actualizar el tiempo
		tiempo = new GregorianCalendar();
		horaActual = tiempo.getTimeInMillis();
	}

	double impParticular = PacienteParticular * 300.0;
	double impSeguimiento = PacienteSeguimiento * 100.0;
	double impBanco = PacienteBanco * 0.0;

	System.out.println( "Doctores Terminaron\n Total de pacientes:" );

	System.out.printf( "Tipo\tCantidad\tImporte\n" );
	System.out.printf( "Paciente Particular\t%d\t%7.2f\n", PacienteParticular, impParticular );
	System.out.printf( "Paciente Seguimiento\t%d\t%7.2f\n", PacienteSeguimiento, impSeguimiento );
	System.out.printf( "Paciente Banco\t%d\t%7.2f\n", PacienteBanco, impBanco );

	System.out.printf( "Totales\t%d\t%7.2f\n", PacienteParticular + PacienteSeguimiento + PacienteBanco, impParticular + impSeguimiento + impBanco );

   } // fin del método run

} // fin de la clase Consumidor


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