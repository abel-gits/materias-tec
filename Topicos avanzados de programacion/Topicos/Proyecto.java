package Proyecto1;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Proyecto {

	public static void main( String[] args )
	{
		MiVentana miVentana = new MiVentana( "Tópicos Avanzados de Programación - Proyecto" );
		miVentana.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );

		miVentana.setSize( 1150, 480 );
		miVentana.setVisible( true );
		
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
	private JMenuItem tipoLetra;
	private JMenuItem copiar;
	private JMenuItem pegar;
	private JMenuItem cortar;
	
	static JTextArea area;
	static JFrame ventana;
	
	static boolean neg=false;
	static boolean cur=false;
	
	static Color color;
	static JButton negrita;
	static JButton cursiva;

	public MiVentana( String titulo )
	{ 
		super( titulo );
		
		
		OyenteV oyenteV = new OyenteV();
		addWindowListener(oyenteV);
		
		JMenuBar barra = new JMenuBar();	// crea la barra de menús
		setJMenuBar( barra ); 				// agrega la barra de menús a la aplicación
		
		
		
		area = new JTextArea();
		area.setLineWrap( true );
		area.setWrapStyleWord( true );
		
		add( new JScrollPane( area ) );
		ManejadorNU manejadorNU = new ManejadorNU();
		ManejadorArchivo manejadorA = new ManejadorArchivo();
		ManejadorAbrirGuardar manejadorAG = new ManejadorAbrirGuardar();
		ManejadorAyuda manejadorAyuda = new ManejadorAyuda();
		ManejadorTipo manejadorTipo = new ManejadorTipo();
		OyenteCopiar oyenteCopiar = new OyenteCopiar();
		OyentePegar oyentePegar = new OyentePegar();
		OyenteCortar oyenteCortar = new OyenteCortar();
		OyenteI oyenteI = new OyenteI();
		
		JMenu archivo = new JMenu( "Archivo" );
		JMenu edicion = new JMenu( "Edición" );
		JMenu ayuda = new JMenu ( "Ayuda" );
		
		archivo.setMnemonic('A');
		edicion.setMnemonic('E');
		ayuda.setMnemonic('y');
		
		nuevo = new JMenuItem(" Nuevo ");
		abrir = new JMenuItem(" Abrir ");					// Se crean los elementos
		guardar = new JMenuItem( " Guardar como... " );
		imprimir = new JMenuItem( " Imprimir " );
		salir = new JMenuItem( " Salir " ); 
		acerca = new JMenuItem( "Acerca de..." );
		tipoLetra = new JMenuItem( "Tipo de Letra" );
	    copiar = new JMenuItem("Copiar");
	    pegar = new JMenuItem("Pegar");
	    cortar = new JMenuItem("Cortar");

		nuevo.setMnemonic('N');
		abrir.setMnemonic('A');
		guardar.setMnemonic('G');
		imprimir.setMnemonic('I');
		salir.setMnemonic('S');
		acerca.setMnemonic('c');
		tipoLetra.setMnemonic('L');;
		copiar.setMnemonic('c');
		pegar.setMnemonic('P');
		cortar.setMnemonic('o');
	   
		nuevo.addActionListener(manejadorNU);
		salir.addActionListener( manejadorA );					
		abrir.addActionListener( manejadorAG );
		guardar.addActionListener( manejadorAG );
		acerca.addActionListener(manejadorAyuda);
		tipoLetra.addActionListener(manejadorTipo);
		copiar.addActionListener(oyenteCopiar);
		pegar.addActionListener(oyentePegar);
		cortar.addActionListener(oyenteCortar);
		imprimir.addActionListener(oyenteI);
		
		archivo.add(nuevo);
		archivo.add( abrir );			// Se agregan los elementos al Menú archivo
		archivo.add( guardar );
		archivo.add( imprimir );
		archivo.add( salir );
		
		edicion.add(tipoLetra);
	    edicion.add(copiar);
	    edicion.add(pegar);
	    edicion.add(cortar);
		
		
		ayuda.add(acerca);
		
		barra.add( archivo );			// Se agregan los Menús archivo a la barra
		barra.add( edicion );
		barra.add( ayuda );
		
		JButton n =  new JButton();
		negrita =  new JButton("N");
		cursiva = new JButton("K");
		color= n.getBackground();
		OyenteN oyenteN = new OyenteN();
		OyenteC oyenteC = new OyenteC();
		cursiva.addActionListener(oyenteC);
		negrita.addActionListener(oyenteN);
		
	}
	class Impresora{
		PrintJob pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
		public void imprimir(String Cadena)
		    {
		        try
		        {
		            Graphics pagina = pj.getGraphics();
		            Font fuente = area.getFont();
					pagina.setFont(fuente);
		            pagina.setColor(Color.black);
		            pagina.drawString(Cadena, 60, 60);
		            pagina.dispose();
		            pj.end();
		        }catch(Exception e)
		        {
		            System.out.println("LA IMPRESION HA SIDO CANCELADA...");
		        }
		    }
		}
	
	class OyenteI implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			 String cadena = "";
			cadena = String.valueOf(MiVentana.area.getText());
             if (!cadena.equals(""))
             {
                 Impresora imp = new Impresora();
                 imp.imprimir(cadena);
             }
             else System.out.println("NO SE IMPRIME NADA EN BLANCO...");
             area.requestFocus();
             area.select(0, cadena.length());
         }
		}
		
	
   
	private class ManejadorNU implements ActionListener 
	{
		public void actionPerformed( ActionEvent evento )
	    {	 
			area.setText("");
	    }
		
	}
	class ManejadorTipo implements ActionListener 
	{	
		
		public void actionPerformed( ActionEvent evento )
	    {	
			
			JButton aceptar = new JButton("Aceptar");
			JButton cancelar = new JButton("Cancelar");
			
			
			
			
			aceptar.setMnemonic('A');
			cancelar.setMnemonic('C');
			
			ventana = new JFrame();
			ventana.setTitle("Tipo de letra");
		    ventana.setResizable(false);
		    ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventana.setSize( 400, 200 );
			ventana.setVisible( true );
			
			Panel panel = new Panel();
			ventana.add(panel);
			
			
			OyenteAceptar oyenteaceptar = new OyenteAceptar();
			OyenteCancelar oyenteCancelar = new OyenteCancelar();
			
			
			aceptar.addActionListener(oyenteaceptar);
			cancelar.addActionListener(oyenteCancelar);
			
			panel.add(negrita);
			panel.add(cursiva);
			panel.add(aceptar);
			panel.add(cancelar);
	    }
		
	}
	class OyenteAceptar implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			String nombre = (String) Panel.letra.getSelectedItem();
			String tamaño =  (String) Panel.tamaño.getSelectedItem();
			int x=Integer.parseInt(tamaño);
			int estilo = 0;
			if (neg==false&&cur==false) {
				estilo=Font.PLAIN;
			}else 
				if (neg==false&&cur==true) {
					estilo=Font.ITALIC;
				}else {
					if (neg==true&&cur==false) {
						estilo=Font.BOLD;
					}else
						if (neg==true&&cur==true) {
							estilo=Font.BOLD+Font.ITALIC;
						}
				}
			Font f = new Font(nombre,estilo,x);
			area.setFont(f); 
			ventana.dispose();
		}
	}
	class OyenteCancelar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			ventana.dispose();
		}
		
	}
  class OyenteN implements ActionListener
	{
	    
		public void actionPerformed(ActionEvent e) {
			if (neg==true) {
				neg=false;
				negrita.setBackground(color);
			}else {
				neg=true;
				negrita.setBackground(Color.GRAY);
			}
		
			
			
			}
		
	}
	class OyenteC implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (cur==true) {
				cur=false;
				cursiva.setBackground(color);
			}else {
				cur=true;
				cursiva.setBackground(Color.GRAY);
			} 
		}
		
	}
	class OyenteCopiar implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (area.getSelectedText()!=null) {
				area.copy();
			}
			
		}
		
	}
	class OyentePegar implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			area.paste();
		}
	}
	class OyenteCortar implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) {
			area.cut();
			
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

	              FileNameExtensionFilter filtro = new FileNameExtensionFilter( "*.TXT", "txt" ); // Se crea el filtro
	              chooser.setFileFilter( filtro );
		    	  
	              int seleccionar = chooser.showOpenDialog(area); 		// Se abre la ventana
		    	  
		    	  if (seleccionar == JFileChooser.APPROVE_OPTION)
		    	  {
		    	     File fichero = chooser.getSelectedFile();
		    	     area.setText( fichero.getAbsolutePath() );  			// Escribe la ruta del fichero
		    	     
		    	     try( FileReader linea = new FileReader(fichero) ){
		    	    	 
		    	    	 String cadena = "";
		                 int valor = linea.read();
		                 while( valor != -1 ){
		                     cadena = cadena + ( char )valor;
		                     valor = linea.read();
		                 }
		                 area.setText( cadena );
		             } catch ( IOException e1 ) {
		                 e1.printStackTrace();
		             }
		    	  }
	          }
	          if ( seleccion == guardar )
	          {
	        	  JFileChooser chooser = new JFileChooser();
	        	  int seleccionar = chooser.showSaveDialog(area);
	        	  
	        	  if (seleccionar == JFileChooser.APPROVE_OPTION)
		    	  {
		    	     File fichero = chooser.getSelectedFile();
		    	     PrintWriter writer = null;
					try 
					{
						writer = new PrintWriter( fichero +".txt");   // Se guarda el archivo de texto
					} catch ( FileNotFoundException e ) {
						
						e.printStackTrace();
					}
		    	     writer.print( area.getText() );
			    	 writer.close();
		    	  }
	        	 
		    	  
	          }
		 
	    	  
	      }
	 }
	 
	 private class ManejadorAyuda implements ActionListener 
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
				switch (JOptionPane.showConfirmDialog( null, "¿Desea cambiar los cambios hechos?" )) 
				{
				case JOptionPane.YES_OPTION:
				JFileChooser chooser = new JFileChooser();
		    	  int seleccionar = chooser.showSaveDialog(MiVentana.area);
		      	  
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
			    	     writer.print( MiVentana.area.getText() );
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
class Panel extends JPanel
{


	static JComboBox<String> letra;
	static JComboBox<String> tamaño;
	public Panel()
	{
		
		 String[] nombreFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		
		String[] opciones = {
				"8",
				"9",
				"10",
				"11",
				"12",
				"14",
				"16",
				"18",
				"20",
				"22",
				"24",
				"26",
				"28",
				"36",
				"48",
				"72"
				
		};

	letra = new JComboBox<String>( nombreFuentes );
	tamaño = new JComboBox<String>( opciones );
	Font f = new Font(null,0,12);
	f=MiVentana.area.getFont();
	letra.setSelectedItem(f.getName());
	String  tam;
	tam=String.valueOf(f.getSize());
	tamaño.setSelectedItem(tam);
	add(letra);
	add(tamaño);
	
	}
	
}


