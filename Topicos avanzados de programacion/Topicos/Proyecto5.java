package Proyecto1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Proyecto5 {
	static PanelD panelD;
	static MiVentana miVentana; 
	public static void main( String[] args )
	{
		miVentana = new MiVentana( "Tópicos Avanzados de Programación - Proyecto" );
		miVentana.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
		panelD = new PanelD();
		miVentana.setBackground(Color.WHITE);			
		miVentana.setSize(800,550  );
		miVentana.setVisible( true );		
		miVentana.add(panelD);
	    		    
		
	}
	
}	
class PanelD extends JPanel{
	public void paintComponent( Graphics g )
	{		
		setLayout( null );
		
		
	}
	public void paint(Graphics g){
		super.paintComponent( g );
		Graphics2D g2D = (Graphics2D) g;		
		GeneralPath v1 = new GeneralPath();
		v1.moveTo( 100, 200 );
		v1.lineTo( 200 + 300, 250 );
		g2D.setColor( Color.BLACK );
		BasicStroke tipoLinea = new BasicStroke( 3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND );
		g2D.setStroke( tipoLinea );
		g2D.draw( v1 );
	}
}
class MiVentana extends JFrame 
{	
	private JMenuItem nuevo;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem imprimir;
	private JMenuItem salir;
	private JMenuItem acerca;
	private JMenuItem linea;
	private JMenuItem rectangulo;
	private JMenuItem elipce;
	private JMenuItem relleno;
	private JMenuItem color;
	

	public MiVentana( String titulo )
	{ 
		super( titulo );
		
		
		OyenteV oyenteV = new OyenteV();
		addWindowListener(oyenteV);
		
		JMenuBar barra = new JMenuBar();	// crea la barra de menús
		setJMenuBar( barra ); 				// agrega la barra de menús a la aplicación
	
		ManejadorNU manejadorNU = new ManejadorNU();
		ManejadorArchivo manejadorA = new ManejadorArchivo();
		ManejadorAbrirGuardar manejadorAG = new ManejadorAbrirGuardar();
		ManejadorAyuda manejadorAyuda = new ManejadorAyuda();
		
		OyenteI oyenteI = new OyenteI();
		
		OyenteE oyenteE = new OyenteE();
		OyenteR oyenteR = new OyenteR();
		OyenteC oyenteC = new OyenteC();
		
		JMenu archivo = new JMenu( "Archivo" );
		JMenu dibujar = new JMenu( "Dibujar" );
		JMenu ayuda = new JMenu ( "Ayuda" );
		
		archivo.setMnemonic('A');
		dibujar.setMnemonic('E');
		ayuda.setMnemonic('y');
		
		nuevo = new JMenuItem(" Nuevo ");
		abrir = new JMenuItem(" Abrir ");					// Se crean los elementos
		guardar = new JMenuItem( " Guardar como... " );
		imprimir = new JMenuItem( " Imprimir " );
		salir = new JMenuItem( " Salir " ); 
		acerca = new JMenuItem( "Acerca de..." );
		linea = new JMenuItem("Linea");
		rectangulo = new JMenuItem("Rectangulo");
		elipce = new JMenuItem("Elipce");
		relleno = new JMenuItem("Relleno");
		color = new JMenuItem("Color");

		nuevo.setMnemonic('N');
		abrir.setMnemonic('A');
		guardar.setMnemonic('G');
		imprimir.setMnemonic('I');
		salir.setMnemonic('S');
		acerca.setMnemonic('c');
		linea.setMnemonic('L');
		rectangulo.setMnemonic('R');
		elipce.setMnemonic('E');
		relleno.setMnemonic('e');
		color.setMnemonic('C');
		
	   
		nuevo.addActionListener(manejadorNU);
		salir.addActionListener( manejadorA );					
		abrir.addActionListener( manejadorAG );
		guardar.addActionListener( manejadorAG );
		acerca.addActionListener(manejadorAyuda);
		imprimir.addActionListener(oyenteI);
		//linea.addActionListener(l);
		//rectangulo.addActionListener(l);
		elipce.addActionListener(oyenteE);
		relleno.addActionListener(oyenteR);
		color.addActionListener(oyenteC);
		
		archivo.add(nuevo);
		archivo.add( abrir );			// Se agregan los elementos al Menú archivo
		archivo.add( guardar );
		archivo.add( imprimir );
		archivo.add( salir );
		
		dibujar.add(linea);
		dibujar.add(rectangulo);
		dibujar.add(elipce);
		dibujar.add(relleno);
		dibujar.add(color);
		
		ayuda.add(acerca);
		
		barra.add( archivo );			// Se agregan los Menús archivo a la barra
		barra.add( dibujar );
		barra.add( ayuda );
		
		imprimir.setEnabled(false);
		
	}
	
	class OyenteI implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			 
         }
		}
		
	
   
	private class ManejadorNU implements ActionListener 
	{
		public void actionPerformed( ActionEvent evento )
	    {					
			Proyecto.panelD.removeAll();	
			
			Proyecto.panelD.repaint();
			
			
	    }
		
	}
	
	 private class ManejadorArchivo implements ActionListener 
	 {
	    public void actionPerformed( ActionEvent evento )
	    {	          
	      	  System.exit( 0 ); // Salir de la aplicacion
	    }
	 }
	 
	 private class ManejadorAbrirGuardar implements ActionListener 
	 {	
		 
		 
	      public void actionPerformed( ActionEvent evento )
	      {
	    	 
	    	  JMenuItem seleccion = ( JMenuItem ) evento.getSource();

	          if ( seleccion == abrir )
	          {
	        	  JFileChooser chooser = new JFileChooser();         				// Se crea el objeto JFileChooser
	        	  chooser.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES ); // Se indica lo que se Seleccionará

	              FileNameExtensionFilter filtro = new FileNameExtensionFilter( "*.png", "png" ); // Se crea el filtro
	              chooser.setFileFilter( filtro );
	              int estado=chooser.showOpenDialog(null);
                 
                  if(estado==JFileChooser.APPROVE_OPTION);
                  {
                	  try
                      {   
                		  Proyecto.panelD.removeAll();
              			  Proyecto.panelD.repaint();
                		  
                          File archivoelegido=chooser.getSelectedFile();
                          String ruta=archivoelegido.getPath();          
                		  ImageIcon imagen = new ImageIcon(ruta);                		  
                		  JLabel etiqueta = new JLabel(imagen);                		  
                		  etiqueta.setSize(etiqueta.getMaximumSize());
                    	  Proyecto.miVentana.repaint();
                    	  Proyecto.panelD.add(etiqueta);                     	 
                    	  etiqueta.setLocation( 5, 5 );                   	                     
                    	
                      }
                      catch(Exception es)
                      {
                             
                      }
                	  
                	  
                	  
                  }
	          }
	          
	         
	          if ( seleccion == guardar )
	          {
	        	  JFileChooser chooser = new JFileChooser();
	        	  chooser.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES );
	        	  int seleccionar = chooser.showSaveDialog(null);
	        	  	        	 	 
	        	 
	        	  if (seleccionar == JFileChooser.APPROVE_OPTION)
		    	  {	        		  	        		 
	        		  String nom=chooser.getSelectedFile()+".png";
	        		  File file = new File(nom);
	        		  chooser.setSelectedFile(file);	        		  
	        		  File fichero =chooser.getSelectedFile() ;	        		  
	        		  BufferedImage imagen = new BufferedImage(Proyecto.miVentana.getContentPane().getWidth(),Proyecto.miVentana.getContentPane().getHeight(), BufferedImage.TYPE_INT_RGB);
	        		  Graphics g = imagen.getGraphics();
	        		  Proyecto.miVentana.getContentPane().paint(g);
						try 
						{
							ImageIO.write(imagen,"png", fichero);							

						}catch (IOException e) {													
						}
						
							       				   
	        		  	       
		    	  }
		    	  
		    	  
	        	 
		    	  
	          }
		 
	    	  
	      }
	    

	 }
	 
	 public class ManejadorAyuda implements ActionListener 
	 {
	    public void actionPerformed( ActionEvent evento )
	    {	          
	    	JOptionPane.showMessageDialog( MiVentana.this,
	                  "Autores del programa: \n\nCarlos Ignacio Rios Madrid\nAbel Robles Montoya",
	                  "Acerca de ...", JOptionPane.PLAIN_MESSAGE );
	    }
	 }
}	 
class OyenteV implements WindowListener
{
	public void windowClosing(WindowEvent e)
	{
				switch (JOptionPane.showConfirmDialog( null, "¿Desea guardar los cambios hechos?" )) 
				{
				case JOptionPane.YES_OPTION:
				JFileChooser chooser = new JFileChooser();
		    	  int seleccionar = chooser.showSaveDialog(Proyecto.panelD);
		      	  
		    	  if (seleccionar == JFileChooser.APPROVE_OPTION)
			       	  {
			    	     File fichero = chooser.getSelectedFile();
			    	     PrintWriter writer = null;
						try 
						{
							writer = new PrintWriter( fichero +".txt");   // Se guarda el archivo de texto
						} catch ( FileNotFoundException e1 ) {
							
							e1.printStackTrace();
						}
			    	     writer.print( Proyecto.panelD.getComponentCount() );
				    	 writer.close();
			    	  }System.exit(0);break;
			    	  
				  case JOptionPane.NO_OPTION:
					JFrame temporal = (JFrame) e.getSource();
				    temporal.dispose();break;
				  default: break;
				}
		}
		
	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
}
class OyenteE implements ActionListener{
	public void actionPerformed(ActionEvent e) {	
		
		
	}
	
}

class OyenteR implements ActionListener{
	public void actionPerformed(ActionEvent e) {
	
		
	}
	
}

class OyenteC implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}


