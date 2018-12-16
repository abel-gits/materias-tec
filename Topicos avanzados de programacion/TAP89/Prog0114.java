// Prog0114.java
// Programa de prueba de JList

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;

public class Prog0114
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JList" );
		miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		MiPanel miPanel = new MiPanel();
		miVentana.add( miPanel );

		miVentana.setSize( 600, 200 );
		//miVentana.pack();
		miVentana.setVisible( true );
	}
}

class MiPanel extends JPanel
{
	JList<String> lstColores;

	Color[] colores;

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

		colores = new Color[] {
					Color.RED,
					Color.GREEN,
					Color.BLUE,
					Color.ORANGE,
					Color.PINK,
					Color.CYAN,
					Color.MAGENTA,
					Color.YELLOW,
					Color.BLACK,
					Color.WHITE,
					Color.GRAY,
					Color.DARK_GRAY,
					Color.LIGHT_GRAY
				};

		lstColores = new JList<String>( opciones );
		lstColores.setVisibleRowCount( 5 );
		lstColores.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		lstColores.setLayoutOrientation( JList.VERTICAL );
		lstColores.addListSelectionListener( miOyente );

		add( new JScrollPane( lstColores ) );

	}

	class MiOyente implements ListSelectionListener
	{
		public void valueChanged( ListSelectionEvent e )
		{
			int posicion = lstColores.getSelectedIndex();
			MiPanel.this.setBackground( colores[ posicion ] );
		}
	}
}





















