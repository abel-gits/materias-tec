// Prog0124.java
// Prueba de GridLayout

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prog0124
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de GridLayout" );
		miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		MiPanel miPanel = new MiPanel();
		miVentana.add( miPanel );

		miVentana.pack();
		miVentana.setVisible( true );
	}
}

class MiPanel extends JPanel
{

	private JButton botones[];
	private final String nombres[] = { "uno", "dos", "tres", "cuatro", "cinco", "seis" };
	private boolean alternar = true;
	private GridLayout cuadricula1, cuadricula2;

	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();

		cuadricula1 = new GridLayout( 2, 3, 5, 5 );
		cuadricula2 = new GridLayout( 3, 2 );

		setLayout( cuadricula1 );

		// instanciar objetos botón
		botones = new JButton[ nombres.length ];

		for ( int cuenta = 0; cuenta < nombres.length; cuenta++ )
		{
			botones[ cuenta ] = new JButton( nombres[ cuenta ] );
			botones[ cuenta ].addActionListener( miOyente );
			add( botones[ cuenta ] );
		}

	}

	class MiOyente implements ActionListener
	{
		public void actionPerformed( ActionEvent evento )
		{

			if ( alternar )
				MiPanel.this.setLayout( cuadricula2 );
			else
				MiPanel.this.setLayout( cuadricula1 );

			alternar = !alternar;   // establecer alternar en el valor opuesto
			MiPanel.this.validate();
		}
	}
}