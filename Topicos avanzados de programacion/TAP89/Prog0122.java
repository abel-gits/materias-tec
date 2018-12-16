// Prog0122.java
// Prueba de FlowLayout

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prog0122
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de FlowLayout" );
		miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		MiPanel miPanel = new MiPanel();
		miVentana.add( miPanel );

		miVentana.pack();
		miVentana.setVisible( true );
	}
}

class MiPanel extends JPanel
{

	private JButton botonIzquierda, botonCentro, botonDerecha;
	private FlowLayout esquema;

	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();

		esquema = new FlowLayout();
		setLayout( esquema );

		botonIzquierda = new JButton( "Izquierda" );
		botonIzquierda.addActionListener( miOyente );

		botonCentro = new JButton( "Centro" );
		botonCentro.addActionListener( miOyente );

		botonDerecha = new JButton( "Derecha" );
		botonDerecha.addActionListener( miOyente );

		add( botonIzquierda );
		add( botonCentro );
		add( botonDerecha );

	}

	class MiOyente implements ActionListener
	{
		public void actionPerformed( ActionEvent evento )
		{
			JButton cual = (JButton) evento.getSource();

			if ( cual == botonIzquierda )
				esquema.setAlignment( FlowLayout.LEFT );
			else if ( cual == botonCentro )
				esquema.setAlignment( FlowLayout.CENTER );
			else
				esquema.setAlignment( FlowLayout.RIGHT );

			esquema.layoutContainer( MiPanel.this );
		}
	}
}