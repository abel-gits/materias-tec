// Prog0110.java
// Programa de prueba de JRadioButton

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prog0110
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JRadioButton" );
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
	JRadioButton rbPajaro;
	JRadioButton rbGato;
	JRadioButton rbPerro;
	JRadioButton rbConejo;
	JRadioButton rbCerdo;
	JLabel dibujo;

	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();

		rbPajaro = new JRadioButton();
		rbPajaro.setText( "Pajaro" );
		rbPajaro.setSelected( true );
		rbPajaro.setMnemonic( 'P' );
		rbPajaro.addActionListener( miOyente );

		rbGato = new JRadioButton( "Gato" );
		rbGato.setMnemonic( 'G' );
		rbGato.addActionListener( miOyente );

		rbPerro = new JRadioButton( "Perro" );
		rbPerro.setMnemonic( 'e' );
		rbPerro.addActionListener( miOyente );

		rbConejo = new JRadioButton( "Conejo" );
		rbConejo.setMnemonic( 'C' );
		rbConejo.addActionListener( miOyente );

		rbCerdo = new JRadioButton( "Cerdo" );
		rbCerdo.setMnemonic( 'r' );
		rbCerdo.addActionListener( miOyente );

		dibujo = new JLabel();

		mostrarDibujo( "Pajaro" );

		// Crear un objeto ButtonGroup para hacerlos mutuamente excluyentes
		ButtonGroup bg = new ButtonGroup();
		bg.add( rbPajaro );
		bg.add( rbGato );
		bg.add( rbPerro );
		bg.add( rbConejo );
		bg.add( rbCerdo );

		// Crear un panel para agrupar los botones de radio en un mismo borde
		JPanel panelBotones = new JPanel();
		panelBotones.setBorder( BorderFactory.createTitledBorder( "Seleccione:" ) );

		panelBotones.add( rbPajaro );
		panelBotones.add( rbGato );
		panelBotones.add( rbPerro );
		panelBotones.add( rbConejo );
		panelBotones.add( rbCerdo );

		add( panelBotones );
		add( dibujo );
	}

	private void mostrarDibujo( String nombre )
	{
		ImageIcon cual = new ImageIcon( nombre + ".gif" );
		dibujo.setIcon( cual );
	}

	class MiOyente implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			String nombre = e.getActionCommand();
			mostrarDibujo( nombre );
		}
	}
}





















