// Prog0115.java
// Programa de prueba de JList

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class Prog0115
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JList" );
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
	JList<String> lstOriginal;
	JList<String> lstCopia;

	JButton btnCopiar;

	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();

		String[] opciones = {
					"Rojo",
					"Verde",
					"Azul",
					"Naranja",
					"Rosa",
					"Cyan",
					"Magenta",
					"Amarillo",
					"Negro",
					"Blanco",
					"Gris",
					"Gris Oscuro",
					"Gris Claro"
			};

		lstOriginal = new JList<String>( opciones );
		lstOriginal.setVisibleRowCount( 4 );
		lstOriginal.setSelectionMode( ListSelectionModel.SINGLE_INTERVAL_SELECTION );
		lstOriginal.setLayoutOrientation( JList.HORIZONTAL_WRAP );

		btnCopiar = new JButton( "Copiar >>" );
		btnCopiar.addActionListener( miOyente );

		lstCopia = new JList<String>();
		lstCopia.setVisibleRowCount( 5 );
		lstCopia.setSelectionMode( ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
		lstCopia.setLayoutOrientation( JList.VERTICAL_WRAP );
		lstCopia.setPreferredSize( new Dimension( 200, 100 ) );

		add( new JScrollPane( lstOriginal ) );
		add( btnCopiar );
		add( new JScrollPane( lstCopia ) );


	}

	class MiOyente implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			lstCopia.setListData( lstOriginal.getSelectedValuesList().toArray( new String[ 0 ] ) );
		}
	}
}





















