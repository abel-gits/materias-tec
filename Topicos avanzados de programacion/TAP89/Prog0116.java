// Prog0116.java
// Programa de prueba de JProgressBar

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Prog0116
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JProgressBar" );
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
	JProgressBar bpBarra;
	JButton btnIniciar;
	Timer tiempo;
	int contador;

	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();
		MiOyente2 miOyente2 = new MiOyente2();

		tiempo = new Timer( 1000, miOyente2 );		

		btnIniciar = new JButton( "Iniciar" );
		btnIniciar.addActionListener( miOyente );

		bpBarra = new JProgressBar();
		bpBarra.setMinimum( 0 );
		bpBarra.setMaximum( 100 );
		bpBarra.setStringPainted( true );
		bpBarra.setForeground( Color.GREEN );
		bpBarra.setBackground( Color.BLACK );
		bpBarra.setOrientation( JProgressBar.VERTICAL );

		add( btnIniciar );
		add( bpBarra );

	}

	class MiOyente implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			bpBarra.setValue( 0 );
			contador = 0;
			tiempo.start();
			btnIniciar.setEnabled( false );
		}
	}

	class MiOyente2 implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			if ( bpBarra.getValue() == 50 )
			{
				if ( contador == 0 )
					bpBarra.setIndeterminate( true );
				else if ( contador == 10 )
				{
					bpBarra.setIndeterminate( false );
					bpBarra.setValue( bpBarra.getValue() + 1 );
				}
				contador ++;
				return;
			}

			bpBarra.setValue( bpBarra.getValue() + 1 );

			if ( bpBarra.getValue() == 100 )
			{
				tiempo.stop();
				btnIniciar.setEnabled( true );
			}
		}
	}

}





















