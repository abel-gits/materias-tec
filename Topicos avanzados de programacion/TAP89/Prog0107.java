// Prog0107.java
// Programa de prueba de JLabel

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Prog0107
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JLabel" );
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
		setLayout( null );

		ImageIcon dibujo = new ImageIcon( "middle.gif" );
		Font f1 = new Font( "Kunstler Script", Font.PLAIN , 40 );

		JLabel et1 = new JLabel();
		et1.setText( "Etiqueta 1" );
		et1.setIcon( dibujo );
		et1.setToolTipText( "Etiqueta 1" );
		et1.setHorizontalTextPosition( SwingConstants.CENTER );
		et1.setVerticalTextPosition( SwingConstants.BOTTOM );
		et1.setFont( f1 );
		et1.setForeground( Color.RED );
		et1.setBackground( Color.BLUE );
		et1.setOpaque( true );
		et1.setSize( 120, 80 );
		et1.setLocation( 20, 10 );

		JLabel et2 = new JLabel( "Etiqueta 2" );
		et2.setToolTipText( "Etiqueta 2" );
		
		JLabel et3 = new JLabel( dibujo );
		et3.setToolTipText( "Etiqueta 3" );

		add( et1 );
		add( et2 );
		add( et3 );
	}

}





















