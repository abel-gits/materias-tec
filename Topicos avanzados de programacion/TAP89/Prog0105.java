// Prog0105.java
// Programa de prueba de un JColorChooser

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Prog0105
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JColorChooser" );
		miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		MiPanel miPanel = new MiPanel();
		miVentana.add( miPanel );

		miVentana.setSize( 300, 200 );
		miVentana.setVisible( true );
	}
}

class MiPanel extends JPanel
{
	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();

		JButton miBoton = new JButton( "Seleccione un color..." );
		miBoton.addActionListener( miOyente );

		add( miBoton );

	}

	class MiOyente implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			Color color = MiPanel.this.getBackground();;

			color = JColorChooser.showDialog( null, "Seleccione un color de fondo", color );

			if ( color != null )
				MiPanel.this.setBackground( color );
		}
	}

}





















