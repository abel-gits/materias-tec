package Restaurante;

// Fig. 23.13: Consumidor.java
// Consumidor con un método run que itera y lee 10 valores del búfer.

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Consumidor implements Runnable
{ 
   
   private final Bufer ubicacionCompartida; // referencia al objeto compartido
   private Calendar tiempo;

   // constructor
   public Consumidor( Bufer compartido )
   {
      ubicacionCompartida = compartido;
   } 

   
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
						//simulando 12 minutos en vez de 12 horas
	while ( ( ( horaActual - horaInicial ) <= 720000 ) || !ubicacionCompartida.estaVacio() )	
	{

		try 
		{
			
			int tipo = ubicacionCompartida.obtener(); 
			if ( tipo == 1 ){
				Thread.sleep( 10000 ); 
				basico ++;
			}else if ( tipo == 2 ){
				Thread.sleep( 12000 );
				normal ++;
			}else{
				Thread.sleep( 13000 );
				extra ++;
				}
			
			
		} // fin de try
		catch ( InterruptedException excepcion ) 
		{
			excepcion.printStackTrace();
		} // fin de catch

		// Actualizar el tiempo
		tiempo = new GregorianCalendar();
		horaActual = tiempo.getTimeInMillis();
	}

	double impNormal = basico * 50.0;
	double impDoble = normal * 60.0;
	double impExtra = extra * 70.0;

	System.out.println( "Trabajadores Terminaron\nTotales de servicio:" );

	System.out.printf( "Tipo\tCantidad\tImporte\n" );
	System.out.printf( "Basico\t%d\t%7.2f\n", basico, impNormal );
	System.out.printf( "Normal\t%d\t%7.2f\n", normal, impDoble );
	System.out.printf( "Extra\t%d\t%7.2f\n", extra, impExtra );

	System.out.printf( "Totales\t%d\t%7.2f\n", basico + normal + extra, impNormal + impDoble + impExtra );

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