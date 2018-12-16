// Prog0118.java
// Programa de prueba de JSpinner

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Prog0118
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JSpinner" );
		miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		MiPanel miPanel = new MiPanel();
		miVentana.add( miPanel );

		//miVentana.setSize( 600, 200 );
		miVentana.pack();
		miVentana.setVisible( true );
	}
}

class MiPanel extends JPanel
{

	JSpinner spnLista;
	JSpinner spnNumero;
	JSpinner spnFecha;
	JLabel etiqueta;

	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();

		// JSpinner con lista de valores
		String[] estaciones = {
					"Primavera",
					"Verano",
					"Otoño",
					"Invierno"
				};

		SpinnerListModel modeloLista = new SpinnerListModel( estaciones );
		spnLista = new JSpinner( modeloLista );
		spnLista.addChangeListener( miOyente );

		// JSpinner con números
		SpinnerNumberModel modeloNumero = new SpinnerNumberModel( 5, 0, 10, 1 );
		spnNumero = new JSpinner( modeloNumero );
		spnNumero.addChangeListener( miOyente );

		// JSpinner con fechas
		Calendar calendario = new GregorianCalendar();
		Date fechaActual = calendario.getTime();
		calendario.add(Calendar.YEAR, -100);
		Date fechaInicial = calendario.getTime();
		calendario.add(Calendar.YEAR, 200);
		Date fechaFinal = calendario.getTime();
		SpinnerDateModel modeloFecha = new SpinnerDateModel( fechaActual,
					                             fechaInicial,
					                             fechaFinal,
					                             Calendar.YEAR);
		spnFecha = new JSpinner( modeloFecha );
		spnFecha.setEditor(new JSpinner.DateEditor( spnFecha, "dd/MM/yyyy") );
		spnFecha.addChangeListener( miOyente );

		etiqueta = new JLabel();

		add( spnLista );
		add( spnNumero );
		add( spnFecha );
		add( etiqueta );
	}

	class MiOyente implements ChangeListener
	{
		public void stateChanged( ChangeEvent e )
		{
			JSpinner cual = (JSpinner)e.getSource();

			if ( cual == spnLista )
				etiqueta.setText( (String) spnLista.getValue() );
			else if ( cual == spnNumero )
				etiqueta.setText( ((Integer) spnNumero.getValue()).toString() );
			else
			{
				SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
				String texto = sdf.format( (Date) spnFecha.getValue() );
				etiqueta.setText( texto );
			}
		}
	}


}





















