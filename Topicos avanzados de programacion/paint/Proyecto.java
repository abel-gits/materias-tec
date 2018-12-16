

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
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
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
	static Vector<Rectangle2D.Double>RectSinRelleno;
	static Vector<Ellipse2D.Double> Elip;
	static Vector<Ellipse2D.Double>ElipSinRelleno;
	static Vector<Color>colorLin;
	static Vector<Color>colorRec;
	static Vector<Color>colorRecSR;
	static Vector<Color>colorEli;
	static Vector<Color>colorEliSR;
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
		 RectSinRelleno=new Vector<Rectangle2D.Double>(1);
		 Elip=new Vector<Ellipse2D.Double>(1);
		 ElipSinRelleno=new Vector<Ellipse2D.Double>(1);
		 colorLin=new Vector<Color>(1);
		 colorRec=new Vector<Color>(1);
		 colorRecSR=new Vector<Color>(1);
		 colorEli=new Vector<Color>(1);
		 colorEliSR=new Vector<Color>(1);
		 Proyecto.panel.addMouseMotionListener(new MouseMotionAdapter() {
			   public void mouseDragged(MouseEvent e) { 				   
				   Mouse.fin = new Point(e.getX(), e.getY());				  		           		           	          
		           Proyecto.ventana.repaint();
			   }
	           
	       });
	}
	
	
	
}

class Mouse implements MouseListener{	
	public static Point comienzo;
	public static Point fin;
	 public void mouseReleased(MouseEvent a) {		
		 if (Panel.linea.isSelected()) {
			 Line2D.Double linea = new Line2D.Double( Mouse.comienzo.x, Mouse.comienzo.y, Mouse.fin.x, Mouse.fin.y );
			 Proyecto.Line.addElement(linea);
			 Proyecto.colorLin.addElement(Panel.col);
		 }
		 if (Panel.rectangulo.isSelected()==true && Panel.relleno.isSelected()==true) {
			 Rectangle2D.Double Rectangulo = new Rectangle2D.Double(Math.min(Mouse.comienzo.x, Mouse.fin.x), Math.min(Mouse.comienzo.y,Mouse.fin.y),Math.abs(Mouse.comienzo.x -  Mouse.fin.x), Math.abs(Mouse.comienzo.y - Mouse.fin.y));
			 Proyecto.Rect.addElement(Rectangulo);
			 Proyecto.colorRec.addElement(Panel.col);
			
			
		 }
		 if (Panel.rectangulo.isSelected()==true && Panel.relleno.isSelected()==false) {
			 Rectangle2D.Double Rectangulo = new Rectangle2D.Double(Math.min(Mouse.comienzo.x, Mouse.fin.x), Math.min(Mouse.comienzo.y,Mouse.fin.y),Math.abs(Mouse.comienzo.x -  Mouse.fin.x), Math.abs(Mouse.comienzo.y - Mouse.fin.y));
			 Proyecto.RectSinRelleno.addElement(Rectangulo);
			 Proyecto.colorRecSR.addElement(Panel.col);
		 }
		 
		 if (Panel.elipse.isSelected()==true && Panel.relleno.isSelected()==true) {
			 Ellipse2D.Double elipse= new Ellipse2D.Double(Math.min(Mouse.comienzo.x, Mouse.fin.x), Math.min(Mouse.comienzo.y,Mouse.fin.y), Math.abs(Mouse.comienzo.x -  Mouse.fin.x), Math.abs(Mouse.comienzo.y - Mouse.fin.y));
			 Proyecto.Elip.addElement(elipse);
			 Proyecto.colorEli.addElement(Panel.col);
		 }	
		 if (Panel.elipse.isSelected()==true && Panel.relleno.isSelected() == false) {
			 Ellipse2D.Double elipse= new Ellipse2D.Double(Math.min(Mouse.comienzo.x, Mouse.fin.x), Math.min(Mouse.comienzo.y,Mouse.fin.y), Math.abs(Mouse.comienzo.x -  Mouse.fin.x), Math.abs(Mouse.comienzo.y - Mouse.fin.y));
			 Proyecto.ElipSinRelleno.addElement(elipse);
			 Proyecto.colorEliSR.addElement(Panel.col);
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
	private JMenuItem nuevo;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem imprimir;
	private JMenuItem salir;
	private JMenuItem acerca;
	public static JCheckBox linea;
	public static JCheckBox rectangulo;
	public static JCheckBox elipse;
	public static JCheckBox relleno;
	private JMenuItem color;
	static Color col=Color.BLACK;
	static Color colt=Color.BLACK;
	
	public Panel( String titulo )
	{ 
		
		
		OyenteV oyenteV = new OyenteV();
		Proyecto.ventana.addWindowListener(oyenteV);
		
		JMenuBar barra = new JMenuBar();
		Proyecto.ventana.setJMenuBar( barra ); 				
	
		ManejadorEd manejadorEd = new ManejadorEd();
		ManejadorNU manejadorNU = new ManejadorNU();
		ManejadorArchivo manejadorA = new ManejadorArchivo();
		ManejadorAbrirGuardar manejadorAG = new ManejadorAbrirGuardar();
		ManejadorAyuda manejadorAyuda = new ManejadorAyuda();
				
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
		linea = new JCheckBox("Linea");
		rectangulo = new JCheckBox("Rectangulo");
		elipse = new JCheckBox("Elipse");
		relleno = new JCheckBox("Relleno");
		color = new JMenuItem("Color");

		nuevo.setMnemonic('N');
		abrir.setMnemonic('A');
		guardar.setMnemonic('G');
		imprimir.setMnemonic('I');
		salir.setMnemonic('S');
		acerca.setMnemonic('c');		
		linea.setMnemonic('L');
		rectangulo.setMnemonic('R');
		elipse.setMnemonic('E');
		relleno.setMnemonic('e');
		color.setMnemonic('C');
				
		color.addActionListener(manejadorEd);
		nuevo.addActionListener(manejadorNU);
		salir.addActionListener( manejadorA );					
		abrir.addActionListener( manejadorAG );
		guardar.addActionListener( manejadorAG );
		acerca.addActionListener(manejadorAyuda);
		//imprimir.addActionListener(oyenteI);		
		linea.addActionListener(oyenteL);
		rectangulo.addActionListener(oyenteRE);
		elipse.addActionListener(oyenteE);
		
		
		archivo.add(nuevo);
		archivo.add( abrir );			
		archivo.add( guardar );
		archivo.add( imprimir );
		archivo.add( salir );
				
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
		
		if (nuev==true) 
		{		
			g2D.setColor(Color.WHITE);
			g2D.fill( new Rectangle2D.Double( 0, 0, anchoVentana, altoVentana ) );
			nuev=false;			
			Proyecto.Line.removeAllElements();
			Proyecto.Rect.removeAllElements();
			Proyecto.RectSinRelleno.removeAllElements();
			Proyecto.Elip.removeAllElements();
			Proyecto.ElipSinRelleno.removeAllElements();
			Proyecto.colorEli.removeAllElements();
			Proyecto.colorEliSR.removeAllElements();
			Proyecto.colorLin.removeAllElements();
			Proyecto.colorRec.removeAllElements();
			Proyecto.colorRecSR.removeAllElements();
			Proyecto.ventana.repaint();			
		}			

		for(int i=0; i<Proyecto.Line.size(); i++)
		{
			
			g2D.setColor(Proyecto.colorLin.elementAt(i));
			g2D.draw(Proyecto.Line.elementAt(i));
			
						
        }

		for(int i=0; i<Proyecto.Rect.size(); i++)
		{
			g2D.setColor(Proyecto.colorRec.elementAt(i));
			g2D.fill(Proyecto.Rect.elementAt(i));
			
       	}
		
		for(int i=0; i<Proyecto.RectSinRelleno.size(); i++)
		{
			g2D.setColor(Proyecto.colorRecSR.elementAt(i));
			g2D.draw(Proyecto.RectSinRelleno.elementAt(i));	
			
        }
		
		for(int i=0; i<Proyecto.Elip.size(); i++)
		{
			g2D.setColor(Proyecto.colorEli.elementAt(i));
			g2D.fill(Proyecto.Elip.elementAt(i));	
			
        }
		
		for(int i=0; i<Proyecto.ElipSinRelleno.size(); i++)
		{
			g2D.setColor(Proyecto.colorEliSR.elementAt(i));
			g2D.draw(Proyecto.ElipSinRelleno.elementAt(i));	
					
        }
		
				
		if (linea.isSelected()==true) {
			if(Mouse.comienzo != null && Mouse.fin != null) {											
				Line2D.Double linea = new Line2D.Double( Mouse.comienzo.x, Mouse.comienzo.y, Mouse.fin.x, Mouse.fin.y );
				g2D.setColor(colt);
				g2D.draw(linea);
	        }
		}
		if (rectangulo.isSelected()==true && relleno.isSelected()==false) {
			if(Mouse.comienzo != null && Mouse.fin != null) {											
				Rectangle2D.Double Rectangulo = new Rectangle2D.Double(Math.min(Mouse.comienzo.x, Mouse.fin.x), Math.min(Mouse.comienzo.y,Mouse.fin.y),Math.abs(Mouse.comienzo.x -  Mouse.fin.x), Math.abs(Mouse.comienzo.y - Mouse.fin.y));
				g2D.setColor(colt);
				g2D.draw(Rectangulo);
	        }
		}
		if (rectangulo.isSelected()==true && relleno.isSelected()==true) {
			if(Mouse.comienzo != null && Mouse.fin != null) {											
				Rectangle2D.Double Rectangulo = new Rectangle2D.Double(Math.min(Mouse.comienzo.x, Mouse.fin.x), Math.min(Mouse.comienzo.y,Mouse.fin.y),Math.abs(Mouse.comienzo.x -  Mouse.fin.x), Math.abs(Mouse.comienzo.y - Mouse.fin.y));				
				g2D.setColor(colt);
				g2D.fill(Rectangulo);	
	        }
		}
		
		if ((elipse.isSelected()==true && relleno.isSelected()==false)) {
			
			if(Mouse.comienzo != null && Mouse.fin != null) {											
				Ellipse2D.Double elipse= new Ellipse2D.Double(Math.min(Mouse.comienzo.x, Mouse.fin.x), Math.min(Mouse.comienzo.y,Mouse.fin.y), Math.abs(Mouse.comienzo.x -  Mouse.fin.x), Math.abs(Mouse.comienzo.y - Mouse.fin.y));
				g2D.setColor(colt);
				g2D.draw(elipse);
	        } 
			
			
		}
		if ((elipse.isSelected()==true && relleno.isSelected()==true)) {
			
			if(Mouse.comienzo != null && Mouse.fin != null) {											
				Ellipse2D.Double elipse= new Ellipse2D.Double(Math.min(Mouse.comienzo.x, Mouse.fin.x), Math.min(Mouse.comienzo.y,Mouse.fin.y), Math.abs(Mouse.comienzo.x -  Mouse.fin.x), Math.abs(Mouse.comienzo.y - Mouse.fin.y));							
				g2D.setColor(colt);
				g2D.fill(elipse);
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
	 
	 private class ManejadorEd implements ActionListener 
	 {	
		 public void actionPerformed( ActionEvent evento )
		    {	          
			 try {
				 Color color1 = JColorChooser.showDialog(null, "Seleccione un Color", Color.BLACK);
		            Panel.col=color1;
		            Panel.colt=color1.darker();	
				
			} catch (Exception e) {			
			}
	                        	         
	        	  
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
	 
	 class OyenteL implements ActionListener{		
		public void actionPerformed(ActionEvent e) {			
			if (linea.isSelected()) {				
				elipse.setSelected(false);
				rectangulo.setSelected(false);		
			}
		}
		 
	 }
	 class OyenteRE implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
				if (rectangulo.isSelected()) {
					linea.setSelected(false);
					elipse.setSelected(false);					
				}
			 
		 }
	 }
	 class OyenteE implements ActionListener{		
			public void actionPerformed(ActionEvent e) {
				if (elipse.isSelected()) {
					linea.setSelected(false);					
					rectangulo.setSelected(false);			
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
