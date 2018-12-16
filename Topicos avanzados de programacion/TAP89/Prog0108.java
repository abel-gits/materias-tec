// Prog0108.java
// Programa de prueba de JButton

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prog0108
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JButton" );
		miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		MiPanel miPanel = new MiPanel();
		miVentana.add( miPanel );

		miVentana.setSize( 600, 200 );
		miVentana.setVisible( true );
	}
}

class MiPanel extends JPanel
{
	JButton botonIzq;
	JButton botonMed;
	JButton botonDer;

	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();

		ImageIcon iconoDer = new ImageIcon( "right.gif" );
		ImageIcon iconoMed = new ImageIcon( "middle.gif" );
		ImageIcon iconoIzq = new ImageIcon( "left.gif" );

		botonIzq = new JButton();
		botonIzq.setText( "Habilita Botón del Medio" );
		botonIzq.setIcon( iconoDer );
		botonIzq.setHorizontalTextPosition( SwingConstants.LEFT );
		botonIzq.setActionCommand( "habilita" );
		botonIzq.addActionListener( miOyente );
		botonIzq.setMnemonic( 'H' );

		botonMed = new JButton( "Botón del Medio" );
		botonMed.setIcon( iconoMed );
		botonMed.setEnabled( false );
		botonMed.setMnemonic( 'M' );

		botonDer = new JButton( iconoIzq );
		botonDer.setText( "Deshabilita Botón del Medio" );
		botonDer.setEnabled( false );
		botonDer.setActionCommand( "deshabilita" );
		botonDer.addActionListener( miOyente );
		botonDer.setMnemonic( 'D' );

		add( botonIzq );
		add( botonMed );
		add( botonDer );
	}

	class MiOyente implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			String cual = e.getActionCommand();

			if ( cual.equals( "habilita" ) )
			{
				botonIzq.setEnabled( false );
				botonMed.setEnabled( true );
				botonDer.setEnabled( true );
			}
			else
			{
				botonIzq.setEnabled( true );
				botonMed.setEnabled( false );
				botonDer.setEnabled( false );
			}

		}
	}

}





















