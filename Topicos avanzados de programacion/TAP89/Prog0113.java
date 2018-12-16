// Prog0113.java
// Programa de prueba de JComboBox Editable

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Prog0113
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JComboBox" );
		miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		MiPanel miPanel = new MiPanel();
		miVentana.add( miPanel );

		miVentana.setSize( 300, 200 );
		//miVentana.pack();
		miVentana.setVisible( true );
	}
}

class MiPanel extends JPanel
{
	JComboBox<String> cmbFechas;

	JLabel etFecha;

	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();

		String[] opciones = {
					"yyyy.MM.dd G 'a las' HH:mm:ss z",
					"EEE, MMM d, ''yy",
					"h:mm a",
					"hh ' en punto' a, zzzz",
					"K:mm a, z",
					"yyyyy.MMMMM.dd GGG hh:mm aaa",
					"EEE, d MMM yyyy HH:mm:ss Z",
					"yyMMddHHmmssZ",
					"yyyy-MM-dd'T'HH:mm:ss.SSSZ"
			};

		cmbFechas = new JComboBox<String>( opciones );
		cmbFechas.setEditable( true );
		cmbFechas.addActionListener( miOyente );

		JLabel et1 = new JLabel( "Introduzca un formato de Fecha/Hora" );
		JLabel et2 = new JLabel( "o seleccione uno de la lista:" );
		JLabel et3 = new JLabel( "La fecha/hora actual es:" );

		etFecha = new JLabel();

		mostrarFechaHora( opciones[ 0 ] );

		add( et1 );
		add( et2 );
		add( cmbFechas );
		add( et3 );
		add( etFecha );

	}

	private void mostrarFechaHora( String cual )
	{
		Date hoy = new Date();
		String mostrar;

		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat( cual );
			mostrar = sdf.format( hoy );
			etFecha.setText( mostrar );
			etFecha.setForeground( Color.BLUE );
		}
		catch ( IllegalArgumentException iae )
		{
			mostrar = "Error: " + iae.getMessage();
			etFecha.setText( mostrar );
			etFecha.setForeground( Color.RED );
		}
	}

	class MiOyente implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			String cual = (String) cmbFechas.getSelectedItem();
			mostrarFechaHora( cual );
		}
	}
}





















