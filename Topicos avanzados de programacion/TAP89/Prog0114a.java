// Prog0114a.java
// Programa de prueba de JList

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListCellRenderer;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;

public class Prog0114a
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
	JList<Color> lstColores;

	Color[] colores;

	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();
		MiCeldaPersonalizada celdaPersonalizada = new MiCeldaPersonalizada();

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

		lstColores = new JList<Color>( colores );
		lstColores.setVisibleRowCount( 5 );
		lstColores.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		lstColores.setLayoutOrientation( JList.VERTICAL );
		lstColores.addListSelectionListener( miOyente );
		lstColores.setCellRenderer( celdaPersonalizada );

		add( new JScrollPane( lstColores ) );

	}

	class MiOyente implements ListSelectionListener
	{
		public void valueChanged( ListSelectionEvent e )
		{
			Color color = (Color) lstColores.getSelectedValue();
			MiPanel.this.setBackground( color );
		}
	}
}

class MiCeldaPersonalizada implements ListCellRenderer
{
	public Component getListCellRendererComponent( JList lista,
        	                                           Object valor,
                	                                   int indice,
                        	                           boolean estaSeleccionado,
                                	                   boolean tieneFoco )
	{
		JLabel etiqueta = new JLabel();		// Etiqueta para mostrar el color deseado
		etiqueta.setBackground( (Color) valor );
		etiqueta.setOpaque( true );
		etiqueta.setPreferredSize( new Dimension( 100, 20 ) );

		if ( estaSeleccionado )
			etiqueta.setBorder( BorderFactory.createLineBorder( Color.BLACK, 2 ) );

		return etiqueta;
	}
}



















