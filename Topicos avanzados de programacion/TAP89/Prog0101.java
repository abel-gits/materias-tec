// Prog0101.java
// Programa de prueba de un boton

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prog0101
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de un botón" );
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
		MiOyente2 miOyente2 = new MiOyente2();
		MiOyente3 miOyente3 = new MiOyente3();

		JButton miBoton = new JButton( "Ok" );
		miBoton.addActionListener( miOyente );
		miBoton.addActionListener( miOyente2 );
		miBoton.addActionListener( miOyente3 );

		JButton miBoton2 = new JButton( "Boton 2" );
		miBoton2.addActionListener( miOyente );

		JButton miBoton3 = new JButton( "Boton 3" );
		miBoton3.addActionListener( miOyente );

		add( miBoton );
		add( miBoton2 );
		add( miBoton3 );

	}

	class MiOyente implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			String cual = e.getActionCommand();
			JOptionPane.showMessageDialog( null, "Pulsaste el Botón " + cual );
		}
	}

	class MiOyente2 implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			JOptionPane.showMessageDialog( null, "Pulsaste el Botón Ok 2" );
		}
	}

	class MiOyente3 implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			JOptionPane.showMessageDialog( null, "Pulsaste el Botón Ok 3" );
		}
	}

}





















