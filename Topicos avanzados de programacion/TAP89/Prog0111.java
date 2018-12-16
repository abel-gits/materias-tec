// Prog0111.java
// Programa de prueba de JTextField y JPasswordField

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prog0111
{
	public static void main( String[] args )
	{
		JFrame miVentana = new JFrame( "Prueba de JTextField" );
		miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		MiPanel miPanel = new MiPanel();
		miVentana.add( miPanel );

		miVentana.setSize( 550, 200 );
		miVentana.setVisible( true );
	}
}

class MiPanel extends JPanel
{
	JTextField txtPrimero;
	JTextField txtSegundo;
	JTextField txtTercero;
	JPasswordField txtPassword;

	char original;

	public MiPanel()
	{
		MiOyente miOyente = new MiOyente();

		JLabel et1 = new JLabel( "Campo de Texto 1:" );

		txtPrimero = new JTextField( "Campo de Texto 1" );
		txtPrimero.addActionListener( miOyente );

		JLabel et2 = new JLabel( "Campo de Texto 2:" );

		txtSegundo = new JTextField( 10 );
		txtSegundo.addActionListener( miOyente );

		JLabel et3 = new JLabel( "Campo de Texto 3:" );

		txtTercero = new JTextField( "Este campo no es editable", 10 );
		txtTercero.setEditable( false );
		txtTercero.addActionListener( miOyente );

		JLabel et4 = new JLabel( "Proporcione la contraseña:" );
		txtPassword = new JPasswordField( 10 );
		txtPassword.addActionListener( miOyente );
		original = txtPassword.getEchoChar();

		JCheckBox cbxVer = new JCheckBox( "Mostrar caracteres" );
		cbxVer.addActionListener( new MiOyente2() );

		add( et1 );
		add( txtPrimero );
		add( et2 );
		add( txtSegundo );
		add( et3 );
		add( txtTercero);
		add( et4 );
		add( txtPassword );
		add( cbxVer );
	}

	class MiOyente implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			JTextField cual = (JTextField) e.getSource();

			if ( cual == txtPassword )
				JOptionPane.showMessageDialog( null, "El password No es: " + new String( txtPassword.getPassword() ) );
			else
				JOptionPane.showMessageDialog( null, "El texto es: " + cual.getText() );
		}
	}

	class MiOyente2 implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			JCheckBox cual = (JCheckBox) e.getSource();

			if ( cual.isSelected() )
				txtPassword.setEchoChar( (char)0 );
			else
				txtPassword.setEchoChar( original );
		}
	}

}





















