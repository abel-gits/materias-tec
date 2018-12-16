// Prog0112.java
// Programa de prueba de JComboBox No Editable

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prog0112
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JComboBox" );
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
	JComboBox<String> cmbMascotas;

	JLabel dibujo;

	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();

		String[] opciones = {
					"Pajaro",
					"Gato",
					"Perro",
					"Conejo",
					"Cerdo"
			};

		cmbMascotas = new JComboBox<String>( opciones );
		cmbMascotas.addActionListener( miOyente );

		dibujo = new JLabel();

		mostrarDibujo( "Pajaro" );

		add( cmbMascotas );
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
			String nombre = (String) cmbMascotas.getSelectedItem();
			mostrarDibujo( nombre );
		}
	}
}





















