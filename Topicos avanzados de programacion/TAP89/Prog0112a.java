// Prog0112a.java
// Programa de prueba de JComboBox No Editable con Iconos

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prog0112a
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JComboBox con Iconos" );
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
	JComboBox<ImageIcon> cmbMascotas;

	public MiPanel()
	{
		ImageIcon[] opciones = {
					new ImageIcon( "Pajaro.gif" ),
					new ImageIcon( "Gato.gif" ),
					new ImageIcon( "Perro.gif" ),
					new ImageIcon( "Conejo.gif" ),
					new ImageIcon( "Cerdo.gif" )
			};

		cmbMascotas = new JComboBox<ImageIcon>( opciones );
		add( cmbMascotas );

	}

}





















