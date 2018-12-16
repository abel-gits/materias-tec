// Prog0123.java
// Prueba de BorderLayout

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prog0123
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de BorderLayout" );
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
	private final String nombres[] = { "Ocultar norte", "Ocultar sur", 
						"Ocultar este", "Ocultar oeste", "Ocultar centro" };
	private BorderLayout esquema;

	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();

		esquema = new BorderLayout( 5, 5 );
		setLayout( esquema );

		// instanciar objetos botón
		botones = new JButton[ nombres.length ];

		for ( int cuenta = 0; cuenta < nombres.length; cuenta++ )
		{
			botones[ cuenta ] = new JButton( nombres[ cuenta ] );
			botones[ cuenta ].addActionListener( miOyente );
		}

		// colocar botones en BorderLayout; no importa el orden
		add( botones[ 0 ], BorderLayout.NORTH ); 
		add( botones[ 1 ], BorderLayout.SOUTH ); 
		add( botones[ 2 ], BorderLayout.EAST );  
		add( botones[ 3 ], BorderLayout.WEST );  
		add( botones[ 4 ], BorderLayout.CENTER );
	}

	class MiOyente implements ActionListener
	{
		public void actionPerformed( ActionEvent evento )
		{
			for ( int cuenta = 0; cuenta < botones.length; cuenta++ )
				if ( evento.getSource() == botones[ cuenta ] )
					botones[ cuenta ].setVisible( false );
				else
					botones[ cuenta ].setVisible( true );

			esquema.layoutContainer( MiPanel.this );
		}
	}
}