// Prog0106.java
// Programa de prueba de la clase Font y FontMetrics

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.util.Hashtable;

public class Prog0106
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de la clase Font y FontMetrics" );
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
		Font f1 = new Font( "Serif", Font.PLAIN, 10 );
		Font f2 = new Font( "Monospaced", Font.BOLD, 20 );
		Font f3 = new Font( "SansSerif", Font.ITALIC, 40 );
		Font f4 = new Font( "Dialog", Font.BOLD + Font.ITALIC , 60 );
		Font f5 = new Font( "DialogInput", Font.PLAIN , 40 );
		Font f6 = new Font( "Kunstler Script", Font.PLAIN , 20 );
		Font f7 = new Font( "xYz10", Font.PLAIN , 20 );

		FontMetrics fm = g.getFontMetrics();
		int y = fm.getHeight();
		g.drawString( "Tipo de letra original", 20, y );

		g.setFont( f1 );
		fm = g.getFontMetrics();
		y += fm.getHeight();
		g.drawString( "Tipo de letra Serif, NORMAL, 10", 20, y );

		g.setFont( f2 );
		fm = g.getFontMetrics();
		y += fm.getHeight();
		g.drawString( "Tipo de letra Monospaced, BOLD, 20", 20, y );

		g.setFont( f3 );
		fm = g.getFontMetrics();
		y += fm.getHeight();
		g.drawString( "Tipo de letra SansSerif, ITALIC, 40", 20, y );

		g.setFont( f4 );
		fm = g.getFontMetrics();
		y += fm.getHeight();
		g.drawString( "Tipo de letra Dialog, BOLD + ITALIC , 60", 20, y );

		g.setFont( f5 );
		fm = g.getFontMetrics();
		y += fm.getHeight();
		g.drawString( "Tipo de letra DialogInput, NORMAL , 40", 20, y );

		g.setFont( f6 );
		fm = g.getFontMetrics();
		y += fm.getHeight();
		g.drawString( "Tipo de letra Kunstler Script, NORMAL , 20", 20, y );

		//g.setFont( f7 );
		//g.drawString( "Tipo de letra xYz10, NORMAL , 20", 20, y );
		g.setColor( Color.RED );

		Hashtable<TextAttribute, Object> mapa = new Hashtable<TextAttribute, Object>();
		mapa.put( TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON );
		f7 = f7.deriveFont( mapa );


		g.setFont( f7 );
		fm = g.getFontMetrics();
		y += fm.getHeight();
		g.drawString( f7.getFontName(), 20, y );
		int x = 20 + 5 + fm.stringWidth( f7.getFontName() );
		g.drawString( "Queriamos xYz10.", x, y );

	}
}





















