// Prog0104.java
// Programa de prueba de la clase Color

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Prog0104
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de la clase Color" );
		miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		MiPanel miPanel = new MiPanel();
		miVentana.add( miPanel );

		miVentana.setSize( 600, 400 );
		miVentana.setVisible( true );
	}
}

class MiPanel extends JPanel
{
	public void paintComponent( Graphics g )
	{
		Color c1 = Color.RED;
		Color c2 = new Color( 0, 0, 255 );
		Color c3 = new Color( 0.0f, 1.0f, 0.0f, 0.0f );
		Color c4 = new Color( 128, 55, 14, 128 );

		// Usando el color por omision
		g.fillRect( 20, 20, 200, 50 );

		// Usando los colores personalizados
		g.setColor( c1 );
		g.fillRect( 20, 80, 200, 50 );

		g.setColor( c2 );
		g.fillRect( 20, 140, 200, 50 );

		g.setColor( c3 );
		g.fillRect( 20, 200, 200, 50 );

		g.setColor( c4 );
		g.fillRect( 20, 260, 200, 50 );

	}
}





















