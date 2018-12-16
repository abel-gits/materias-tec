// Prog0103.java
// Programa de prueba de la clase adaptador de Ventana

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Prog0103
{
	public static void main( String[] args )
	{
		MiVentana miVentana = new MiVentana( "Prueba de la Clase Adaptador de Ventana" );
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

	class MiOyente extends WindowAdapter
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
	}
}














