// Prog0117.java
// Programa de prueba de JSlider

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Dimension;
import java.util.Hashtable;

public class Prog0117
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JSlider" );
		miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		MiPanel miPanel = new MiPanel();
		miVentana.add( miPanel );

		//miVentana.setSize( 600, 200 );
		miVentana.pack();
		miVentana.setVisible( true );
	}
}

class MiPanel extends JPanel
{
	JSlider sldDiametro;
	MiPanelCirculo mpc;
	int porcentajeDiametro;

	public MiPanel()
	{
		setLayout( new BorderLayout() );

		MiOyente miOyente = new MiOyente();

		porcentajeDiametro = 10;

		Hashtable<Integer, JLabel> tablaEtiquetas = new Hashtable<Integer,JLabel>();
		tablaEtiquetas.put( new Integer( 0 ), new JLabel( "Ninguno" ) );
		tablaEtiquetas.put( new Integer( 10 ), new JLabel( "Pequeño" ) );
		tablaEtiquetas.put( new Integer( 100 ), new JLabel( "Grandote" ) );

		sldDiametro = new JSlider();
		sldDiametro.setMinimum( 0 );
		sldDiametro.setMaximum( 100 );
		sldDiametro.setValue( porcentajeDiametro );
		sldDiametro.setMinorTickSpacing( 5 );
		sldDiametro.setMajorTickSpacing( 10 );
		sldDiametro.setPaintTicks( true );
		sldDiametro.setLabelTable( tablaEtiquetas );
		sldDiametro.setPaintLabels( true );
		sldDiametro.setOrientation( JSlider.VERTICAL );
		sldDiametro.setInverted( true );
		sldDiametro.addChangeListener( miOyente );

		mpc = new MiPanelCirculo();

		add( mpc );
		add( sldDiametro, BorderLayout.WEST );

	}

	class MiOyente implements ChangeListener
	{
		public void stateChanged( ChangeEvent e )
		{
			porcentajeDiametro = sldDiametro.getValue();
			mpc.repaint();
		}
	}


	class MiPanelCirculo extends JPanel
	{
		public void paintComponent( Graphics g )
		{
			super.paintComponent( g );

			int diametro = 0;

			if ( getWidth() < getHeight() )
				diametro = (int) ( getWidth() * porcentajeDiametro / 100.0 );
			else
				diametro = (int) ( getHeight() * porcentajeDiametro / 100.0 );

			g.fillOval( 0, 0, diametro, diametro );
		}

		public Dimension getPreferredSize()
		{
			return new Dimension( 500, 500 );
		}
	}
}





















