// Prog0119.java
// Programa de prueba de JTextArea

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Prog0119
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JTextArea" );
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

	JTextArea taOrigen;
	JTextArea taDestino;
	JButton btnCopiar;

	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();

		taOrigen = new JTextArea( 5, 20 );
		taOrigen.setLineWrap( true );
		taOrigen.setWrapStyleWord( true );

		btnCopiar = new JButton( "Copiar >>" );
		btnCopiar.addActionListener( miOyente );

		taDestino = new JTextArea( 5, 20 );
		taDestino.setEditable( false );

		add( new JScrollPane( taOrigen ) );
		add( btnCopiar );
		add( new JScrollPane( taDestino ) );
	}

	class MiOyente implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			taDestino.append( taOrigen.getSelectedText() + "\n" );
		}
	}


}





















