package Proyecto1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

class Proyecto extends JFrame  {
	static JFrame ventana;
	static Panel panel;
	static Vector<Ellipse2D.Double>lapi;
	static Vector<Line2D.Double>Line;
	static Vector<Rectangle2D.Double>Rect;
	static Vector<Ellipse2D.Double> Elip;	
	public static void main(String[] args) {
		 ventana= new JFrame( );
		 ventana.setVisible(true);
		 ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		 ventana.setTitle("Tópicos Avanzados de Programación - Proyecto 2");		
		 panel = new Panel("Paint");
		 panel.setBackground(Color.WHITE);
		 ventana.repaint();
		 ventana.setBounds(300,150 , 700, 450);		
	     panel.setBorder(new EmptyBorder(5, 5, 5, 5));
	     ventana.setContentPane(panel);	    	    
	     panel.setLayout(null);	    
	     panel.setBounds(0,0,800,600);	
	     Mouse mouse = new Mouse();
	     
		 panel.addMouseListener(mouse);
		 
		 lapi=new Vector<Ellipse2D.Double>(1);
		 Line=new Vector<Line2D.Double>(1);
		 Rect=new Vector<Rectangle2D.Double>(1);
		 Elip=new Vector<Ellipse2D.Double>(1);		 
		 Proyecto.panel.addMouseMotionListener(new MouseMotionAdapter() {
			   public void mouseDragged(MouseEvent e) { 				   
				   Mouse.fin = new Point(e.getX(), e.getY());				  		           
		           if (Panel.lap==true) {
		        	   Ellipse2D.Double elipse = new Ellipse2D.Double( e.getX(), e.getY(),3,3 );
					   Proyecto.lapi.addElement(elipse);
		   		}		           
		           Proyecto.ventana.repaint();
			   }
	           
	       });
	}
	
	
	
}
class Mouse implements MouseListener{	
	public static Point comienzo;
	public static Point fin;
	 public void mouseReleased(MouseEvent a) {		
		 if (Panel.lin==true) {
			 Line2D.Double linea = new Line2D.Double( Mouse.comienzo.x, Mouse.comienzo.y, Mouse.fin.x, Mouse.fin.y );
			 Proyecto.Line.addElement(linea);
		 }
		 if (Panel.rec==true) {
			 Rectangle2D.Double Rectangulo = new Rectangle2D.Double(Math.min(Mouse.comienzo.x, Mouse.fin.x), Math.min(Mouse.comienzo.y,Mouse.fin.y),Math.abs(Mouse.comienzo.x -  Mouse.fin.x), Math.abs(Mouse.comienzo.y - Mouse.fin.y));
			 Proyecto.Rect.addElement(Rectangulo);
		 }
		 if (Panel.elip==true) {
			 Ellipse2D.Double elipse= new Ellipse2D.Double(Math.min(Mouse.comienzo.x, Mouse.fin.x), Math.min(Mouse.comienzo.y,Mouse.fin.y), Math.abs(Mouse.comienzo.x -  Mouse.fin.x), Math.abs(Mouse.comienzo.y - Mouse.fin.y));
			 Proyecto.Elip.addElement(elipse);
		 }		
		 comienzo= null;
         fin = null;        
         Proyecto.ventana.repaint();
	   }

	   public void mousePressed(MouseEvent e) {		 
		   comienzo = new Point(e.getX(), e.getY());
           fin = comienzo;
           Proyecto.ventana.repaint();
		   
	    }
	   public void mouseExited(MouseEvent arg0) {}	 
	   public void mouseEntered(MouseEvent arg0) {}	  
	   public void mouseClicked(MouseEvent arg0) {}
}
class Panel extends JPanel{		
	public static boolean nuev =false;
	public static Boolean lap=false;
	public static boolean lin=false;
	public static boolean rec=false; 
	public static boolean elip=false;
	private JMenuItem nuevo;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem imprimir;
	private JMenuItem salir;
	private JMenuItem acerca;
	private JMenuItem lapiz;
	private JMenuItem linea;
	private JMenuItem rectangulo;
	private JMenuItem elipse;
	private JMenuItem relleno;
	private JMenuItem color;
	
	public Panel( String titulo )
	{ 
		
		
		OyenteV oyenteV = new OyenteV();
		Proyecto.ventana.addWindowListener(oyenteV);
		
		JMenuBar barra = new JMenuBar();
		Proyecto.ventana.setJMenuBar( barra ); 				
	
		ManejadorNU manejadorNU = new ManejadorNU();
		ManejadorArchivo manejadorA = new ManejadorArchivo();
		ManejadorAbrirGuardar manejadorAG = new ManejadorAbrirGuardar();
		ManejadorAyuda manejadorAyuda = new ManejadorAyuda();
		
		OyenteLA oyenteLA = new OyenteLA();
		OyenteL oyenteL = new OyenteL();
		OyenteRE oyenteRE = new OyenteRE();
		OyenteE oyenteE = new OyenteE();
		
		
		JMenu archivo = new JMenu( "Archivo" );
		JMenu dibujar = new JMenu( "Dibujar" );
		JMenu ayuda = new JMenu ( "Ayuda" );
		
		archivo.setMnemonic('A');
		dibujar.setMnemonic('E');
		ayuda.setMnemonic('y');
		
		nuevo = new JMenuItem(" Nuevo ");
		abrir = new JMenuItem(" Abrir ");					
		guardar = new JMenuItem( " Guardar como... " );
		imprimir = new JMenuItem( " Imprimir " );
		salir = new JMenuItem( " Salir " ); 
		acerca = new JMenuItem( "Acerca de..." );
		lapiz = new JMenuItem("Lapiz");
		linea = new JMenuItem("Linea");
		rectangulo = new JMenuItem("Rectangulo");
		elipse = new JMenuItem("Elipse");
		relleno = new JMenuItem("Relleno");
		color = new JMenuItem("Color");

		nuevo.setMnemonic('N');
		abrir.setMnemonic('A');
		guardar.setMnemonic('G');
		imprimir.setMnemonic('I');
		salir.setMnemonic('S');
		acerca.setMnemonic('c');
		lapiz.setMnemonic('a');
		linea.setMnemonic('L');
		rectangulo.setMnemonic('R');
		elipse.setMnemonic('E');
		relleno.setMnemonic('e');
		color.setMnemonic('C');
		
	   
		nuevo.addActionListener(manejadorNU);
		salir.addActionListener( manejadorA );					
		abrir.addActionListener( manejadorAG );
		guardar.addActionListener( manejadorAG );
		acerca.addActionListener(manejadorAyuda);
		//imprimir.addActionListener(oyenteI);
		lapiz.addActionListener(oyenteLA);
		linea.addActionListener(oyenteL);
		rectangulo.addActionListener(oyenteRE);
		elipse.addActionListener(oyenteE);
		
		
		archivo.add(nuevo);
		archivo.add( abrir );			
		archivo.add( guardar );
		archivo.add( imprimir );
		archivo.add( salir );
		
		dibujar.add(lapiz);
		dibujar.add(linea);
		dibujar.add(rectangulo);
		dibujar.add(elipse);
		dibujar.add(relleno);
		dibujar.add(color);
		
		ayuda.add(acerca);
		
		barra.add( archivo );			
		barra.add( dibujar );
		barra.add( ayuda );
		
		imprimir.setEnabled(false);
		
	}	
	public void paint(Graphics g){		
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		double anchoVentana = getWidth();
		double altoVentana = getHeight();		
		if (nuev==true) {		
			g2D.setColor(Color.WHITE);
			g2D.fill( new Rectangle2D.Double( 0, 0, anchoVentana, altoVentana ) );
			nuev=false;
			Proyecto.lapi.removeAllElements();
			Proyecto.Line.removeAllElements();
			Proyecto.Rect.removeAllElements();
			Proyecto.Elip.removeAllElements();					
			Proyecto.ventana.repaint();			
		}
		for(int i=0; i<Proyecto.lapi.size(); i++){
			g2D.fill(Proyecto.lapi.elementAt(i));
        }
		for(int i=0; i<Proyecto.Line.size(); i++){
			g2D.draw(Proyecto.Line.elementAt(i));
        }
		for(int i=0; i<Proyecto.Rect.size(); i++){
			g2D.draw(Proyecto.Rect.elementAt(i));
        }
		for(int i=0; i<Proyecto.Elip.size(); i++){
			g2D.draw(Proyecto.Elip.elementAt(i));
        }
		if (lap==true) {
			if(Mouse.comienzo != null && Mouse.fin != null) {
				Ellipse2D.Double elipse = new Ellipse2D.Double( Mouse.fin.x, Mouse.fin.y,3, 3 );
				g2D.fill(elipse);
	        }
		}
		if (lin==true) {
			if(Mouse.comienzo != null && Mouse.fin != null) {											
				Line2D.Double linea = new Line2D.Double( Mouse.comienzo.x, Mouse.comienzo.y, Mouse.fin.x, Mouse.fin.y );
				g2D.draw(linea);
	        }
		}
		if (rec==true) {
			if(Mouse.comienzo != null && Mouse.fin != null) {											
				Rectangle2D.Double Rectangulo = new Rectangle2D.Double(Math.min(Mouse.comienzo.x, Mouse.fin.x), Math.min(Mouse.comienzo.y,Mouse.fin.y),Math.abs(Mouse.comienzo.x -  Mouse.fin.x), Math.abs(Mouse.comienzo.y - Mouse.fin.y));
				g2D.draw(Rectangulo);			
	        }
		}
		if ((elip==true)) {
			
			if(Mouse.comienzo != null && Mouse.fin != null) {											
				Ellipse2D.Double elipse= new Ellipse2D.Double(Math.min(Mouse.comienzo.x, Mouse.fin.x), Math.min(Mouse.comienzo.y,Mouse.fin.y), Math.abs(Mouse.comienzo.x -  Mouse.fin.x), Math.abs(Mouse.comienzo.y - Mouse.fin.y));
				g2D.draw(elipse);
	        } 
			
			
		}
		
	}
	
	public class ManejadorNU implements ActionListener 
	{
		public void actionPerformed( ActionEvent evento )
	    {				
			if (nuev==false) 
				nuev=true;				
			Proyecto.panel.removeAll();
			Proyecto.panel.repaint();				
	    }
	

	}

	 private class ManejadorArchivo implements ActionListener 
	 {
	    public void actionPerformed( ActionEvent evento )
	    {	          
	      	  System.exit( 0 ); 
	    }
	 }
	 
	 private class ManejadorAbrirGuardar implements ActionListener 
	 {	
		 
		 
	      public void actionPerformed( ActionEvent evento )
	      {
	    	 
	    	  JMenuItem seleccion = ( JMenuItem ) evento.getSource();

	          if ( seleccion == abrir )
	          {
	        	  JFileChooser chooser = new JFileChooser();         				
	        	  chooser.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES ); 
	              FileNameExtensionFilter filtro = new FileNameExtensionFilter( "*.png", "png" ); 
	              chooser.setFileFilter( filtro );
	              int estado=chooser.showSaveDialog(null);
	             
	              if(estado==JFileChooser.APPROVE_OPTION)
	              {	            	  	            	 
	            	  if (nuev==false) 
	            		  nuev=true;	            	  
	            	  try
	                  { 	            		 
	                      File archivoelegido=chooser.getSelectedFile();
	                      String ruta=archivoelegido.getPath();          
	            		  ImageIcon imagen = new ImageIcon(ruta);                		  
	            		  JLabel etiqueta = new JLabel(imagen);                		  
	            		  etiqueta.setSize(etiqueta.getMaximumSize());	                	  
	                	  Proyecto.panel.add(etiqueta);                     	 
	                	  etiqueta.setLocation( 0, 0 );
	                	  Proyecto.panel.repaint();
	                	  Proyecto.ventana.repaint();
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
	        		  BufferedImage imagen = new BufferedImage(Proyecto.ventana.getContentPane().getWidth(),Proyecto.ventana.getContentPane().getHeight(), BufferedImage.TYPE_INT_RGB);
	        		  Graphics g = imagen.getGraphics();
	        		  Proyecto.ventana.getContentPane().paint(g);
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
	    	JOptionPane.showMessageDialog( Proyecto.ventana,
	                  "Autores del programa: \n\nCarlos Ignacio Rios Madrid\nAbel Robles Montoya",
	                  "Acerca de ...", JOptionPane.PLAIN_MESSAGE );
	    }
	 }
	 class OyenteLA implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (lap==true) {
				lap=false;			
			}else {
				lap=true;
				lin=false;
				rec=false;
				elip=false;
			}
		}
		 
	 }
	 class OyenteL implements ActionListener{		
		public void actionPerformed(ActionEvent e) {			
			if (lin==true) {
				lin=false;			
			}else {
				lin=true;
				elip=false;
				rec=false;
				lap=false;
			}
		}
		 
	 }
	 class OyenteRE implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
				if (rec==true) {
					rec=false;			
				}else {					
					rec=true;
					elip=false;
					lin=false;	
					lap=false;
				}
			 
		 }
	 }
	 class OyenteE implements ActionListener{		
			public void actionPerformed(ActionEvent e) {
				if (elip==true) {
					elip=false;			
				}else {
					elip=true;
					lin=false;
					rec=false;
				}		
				
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
	    	  int seleccionar = chooser.showSaveDialog(Proyecto.panel);
	      	  
	    	  if (seleccionar == JFileChooser.APPROVE_OPTION)
		       	  {
		    	     File fichero = chooser.getSelectedFile();
		    	     PrintWriter writer = null;
					try 
					{
						writer = new PrintWriter( fichero +".txt");   
					} catch ( FileNotFoundException e1 ) {
						
						e1.printStackTrace();
					}
		    	     writer.print( Proyecto.panel.getComponentCount() );
			    	 writer.close();
			    	 System.exit(0);
		    	  }break;
		    	  
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
