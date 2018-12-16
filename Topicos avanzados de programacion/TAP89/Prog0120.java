// Prog0120.java
// Programa de prueba de JTabbedPane

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

// Panel Mascota
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Panel Geek
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

// Panel Dibujo
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Dimension;
import java.util.Hashtable;

import javax.swing.JButton;
import java.awt.FlowLayout;

public class Prog0120
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JTabbedPane" );
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

	public MiPanel()
	{
		setLayout( new BorderLayout() );

		JTabbedPane panelFichas = new JTabbedPane();

		ImageIcon medio = new ImageIcon( "middle.gif"  );

		MiPanelMascota mpm = new MiPanelMascota();
		MiPanelGeek mpg = new MiPanelGeek();
		MiPanelDibujo mpd = new MiPanelDibujo();

		panelFichas.addTab( "Mascotas", medio, mpm, "Este es el panel de mascotas" );
		panelFichas.addTab( "Geek", medio, mpg );
		panelFichas.addTab( "Circulo", mpd );

		panelFichas.setTabLayoutPolicy( JTabbedPane.SCROLL_TAB_LAYOUT );
		panelFichas.setTabPlacement( JTabbedPane.TOP );

		// Panel de Botones
		JPanel panelBotones = new JPanel();
		FlowLayout esquema = new FlowLayout();
		esquema.setAlignment( FlowLayout.RIGHT );
		panelBotones.setLayout( esquema );

		JButton btnAceptar = new JButton( "Aceptar" );
		JButton btnCancelar = new JButton( "Cancelar" );
		JButton btnAplicar = new JButton( "Aplicar" );

		panelBotones.add( btnAceptar );
		panelBotones.add( btnCancelar );
		panelBotones.add( btnAplicar );

		add( panelFichas );
		add( panelBotones, BorderLayout.SOUTH );
	}

}


class MiPanelMascota extends JPanel
{
	JRadioButton rbPajaro;
	JRadioButton rbGato;
	JRadioButton rbPerro;
	JRadioButton rbConejo;
	JRadioButton rbCerdo;
	JLabel dibujo;

	public MiPanelMascota()
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



class MiPanelGeek extends JPanel
{
	JCheckBox cbxBarbilla;
	JCheckBox cbxLentes;
	JCheckBox cbxPelo;
	JCheckBox cbxDientes;

	JLabel dibujo;

	public MiPanelGeek()
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

class MiPanelDibujo extends JPanel
{
	JSlider sldDiametro;
	MiPanelCirculo mpc;
	int porcentajeDiametro;

	public MiPanelDibujo()
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





































