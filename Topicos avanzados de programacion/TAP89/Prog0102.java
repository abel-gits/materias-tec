// Prog0102.java
// Programa de prueba de la interfaz de Ventana

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class Prog0102
{
	public static void main( String[] args )
	{
		MiVentana miVentana = new MiVentana( "Prueba de la Interfaz de Ventana" );
		miVentana.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );

		miVentana.setSize( 300, 200 );
		miVentana.setVisible( true );
	}
}

class MiVentana extends JFrame
{
	public MiVentana( String titulo )
	{
		super( titulo );

		MiOyente miOyente = new MiOyente();

		addWindowListener( miOyente );
	}

	class MiOyente implements WindowListener
	{
		public void windowClosing( WindowEvent e )
		{
			//System.out.println( "windowClosing" );
			if ( JOptionPane.showConfirmDialog( null, "¿Deseas salir del programa?" ) == JOptionPane.YES_OPTION )
			{
				JFrame temporal = (JFrame) e.getSource();
				temporal.dispose();
			}
		}

		public void windowDeactivated( WindowEvent e )
		{
			System.out.println( "windowDeactivated" );
		}

		public void windowActivated( WindowEvent e )
		{
			System.out.println( "windowActivated" );
		}

		public void windowDeiconified( WindowEvent e )
		{
			System.out.println( "windowDeiconified" );
		}

		public void windowIconified( WindowEvent e )
		{
			System.out.println( "windowIconified" );
		}

		public void windowClosed( WindowEvent e )
		{
			System.out.println( "windowClosed" );
		}

		public void windowOpened( WindowEvent e )
		{
			System.out.println( "windowOpened" );
		}

	}
}














