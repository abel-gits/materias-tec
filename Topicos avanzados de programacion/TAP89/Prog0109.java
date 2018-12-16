// Prog0109.java
// Programa de prueba de JCheckBox

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Prog0109
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JButton" );
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
	JCheckBox cbxBarbilla;
	JCheckBox cbxLentes;
	JCheckBox cbxPelo;
	JCheckBox cbxDientes;

	JLabel dibujo;

	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();

		cbxBarbilla = new JCheckBox();
		cbxBarbilla.setText( "Barbilla" );
		cbxBarbilla.setSelected( true );
		cbxBarbilla.setMnemonic( 'B' );
		cbxBarbilla.addItemListener( miOyente );

		cbxLentes = new JCheckBox( "Lentes" );
		cbxLentes.setSelected( true );
		cbxLentes.setMnemonic( 'L' );
		cbxLentes.addItemListener( miOyente );

		cbxPelo = new JCheckBox( "Pelo", true );
		cbxPelo.setMnemonic( 'P' );
		cbxPelo.addItemListener( miOyente );

		cbxDientes = new JCheckBox( "Dientes", true );
		cbxDientes.setMnemonic( 'D' );
		cbxDientes.addItemListener( miOyente );

		dibujo = new JLabel();

		mostrarDibujo( "blpd" );

		add( cbxBarbilla );
		add( cbxLentes );
		add( cbxPelo );
		add( cbxDientes );
		add( dibujo );
	}

	private void mostrarDibujo( String opciones )
	{
		ImageIcon cual = new ImageIcon( "geek-" + opciones + ".gif" );
		dibujo.setIcon( cual );
	}

	class MiOyente implements ItemListener
	{
		public void itemStateChanged( ItemEvent e )
		{
			String opciones = "";

			if ( cbxBarbilla.isSelected() )
				opciones += "b";
			else
				opciones += "-";

			if ( cbxLentes.isSelected() )
				opciones += "l";
			else
				opciones += "-";

			if ( cbxPelo.isSelected() )
				opciones += "p";
			else
				opciones += "-";

			if ( cbxDientes.isSelected() )
				opciones += "d";
			else
				opciones += "-";

			mostrarDibujo( opciones );

		}
	}
}





















