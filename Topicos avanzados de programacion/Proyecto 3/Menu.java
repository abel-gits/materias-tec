

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;



public class Menu {

	public static void main(String[] args) 
	{
		MiVentana1 miVentana = new MiVentana1( "Tópicos Avanzados de Programación - Proyecto - Unidad 4" );
		miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		miVentana.setSize( 500, 300 );
		miVentana.setVisible( true );

	}
}
	class MiVentana1 extends JFrame 
	{
		private JMenuItem actCat;
		private JMenuItem conCat;
		private JMenuItem imprimir;
		private JMenuItem salir;
		private JMenuItem acerca;
		static JFrame ventana;
			
		public MiVentana1( String titulo )
		{
			super( titulo );
			JMenuBar barra = new JMenuBar();	
			setJMenuBar( barra ); 				
					
			ManejadorArchivo manejadorA = new ManejadorArchivo();
			ManejadorAyuda manejadorAyuda = new ManejadorAyuda();
			
			JMenu archivo = new JMenu( "Archivo" );
			JMenu ayuda = new JMenu ( "Ayuda" );
					
			actCat = new JMenuItem( " Actualizar catálogo " );
			conCat = new JMenuItem( " Consultar catálogo " );
			imprimir = new JMenuItem( " Imprimir " );
			salir = new JMenuItem( " Salir " ); 
			acerca = new JMenuItem( "Acerca de..." );
		    
			actCat.addActionListener( manejadorA );
			conCat.addActionListener( manejadorA );
			salir.addActionListener( manejadorA );
			acerca.addActionListener(manejadorAyuda);
			
			archivo.add( actCat );			
			archivo.add( conCat );
			archivo.add( imprimir );
			archivo.add( salir );
			ayuda.add(acerca);
						
			barra.add( archivo );			
			barra.add( ayuda );
			
			imprimir.setEnabled(false);
		}
		 private class ManejadorArchivo implements ActionListener 
		 {
		   
			
			public void actionPerformed( ActionEvent evento )
		    {	  
				 JMenuItem seleccion = ( JMenuItem ) evento.getSource();
				 if ( seleccion == salir )
				 {
					 System.exit( 0 ); // Salir de la aplicacion
				 }
				 if ( seleccion == actCat )
				 {
					 new MostrarCatalogoPeliculas();
				 }
			 
			 
				 if ( seleccion == conCat )
				 {
					 new MostrarResultadosConsulta();
				 }
		    }
		
		 }
	 
		 private class ManejadorAyuda implements ActionListener 
		 {
			 public void actionPerformed( ActionEvent evento )
			 {	          
	    	JOptionPane.showMessageDialog( MiVentana1.this,
	                  "Autores del programa: \n\nCarlos Ignacio Rios Madrid\nAbel Robles Montoya",
	                  "Acerca de ...", JOptionPane.PLAIN_MESSAGE );
	     	 }
	     }

	}
