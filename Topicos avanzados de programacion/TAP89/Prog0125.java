// Prog0125.java
// Prueba de BorderLayout

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prog0125
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de Barra de Herramientas" );
		miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		MiPanel miPanel = new MiPanel();
		miVentana.add( miPanel );

		//miVentana.pack();
		miVentana.setSize( 300, 200 );
		miVentana.setVisible( true );
	}
}

class MiPanel extends JPanel
{

	JButton b1, b2, b3, b4;
	JTextArea area;

	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();
		setLayout( new BorderLayout() );

		ImageIcon i1 = new ImageIcon( "Back24.gif" );
		ImageIcon i2 = new ImageIcon( "Forward24.gif" );
		ImageIcon i3 = new ImageIcon( "Up24.gif" );
		ImageIcon i4 = new ImageIcon( "Down24.gif" );

		b1 = new JButton( i1 );
		b1.setActionCommand( "Izquierda" );
		b1.addActionListener( miOyente );

		b2 = new JButton( i2 );
		b2.setActionCommand( "Derecha" );
		b2.addActionListener( miOyente );

		b3 = new JButton( i3 );
		b3.setActionCommand( "Arriba" );
		b3.addActionListener( miOyente );

		b4 = new JButton( i4 );
		b4.setActionCommand( "Abajo" );
		b4.addActionListener( miOyente );

		JToolBar barraHerramientas = new JToolBar( "Movimiento" );
		barraHerramientas.setFloatable( false );
		barraHerramientas.add( b1 );
		barraHerramientas.add( b2 );
		barraHerramientas.addSeparator();
		barraHerramientas.add( b3 );
		barraHerramientas.add( b4 );

		area = new JTextArea( 20, 100 );
		area.setEditable( false );

		add( new JScrollPane( area ) );
		add( barraHerramientas, BorderLayout.NORTH );

	}

	class MiOyente implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			String cual = e.getActionCommand();
			area.append( "Pulsaste el botón " + cual + "\n" );
		}
	}
}