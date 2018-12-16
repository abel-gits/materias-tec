package Proyecto3;
// Fig. 25.32: MostrarLibretaDirecciones.java
// Una libreta de direcciones simple
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List; 
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class MostrarLibretaDirecciones extends JFrame
{
   private Pelicula entradaActual;
   private ConsultasPersona consultasPersona;
   private List< Pelicula > resultados;   
   private int numeroDeEntradas = 0;
   private int indiceEntradaActual;

   private JButton botonExplorar;
   private JLabel etiquetaEmail;
   private JTextField campoTextoEmail;
   private JLabel etiquetaPrimerNombre;
   private JTextField campoTextoPrimerNombre;
   private JLabel etiquetaID;
   private JTextField campoTextoID;
   private JTextField campoTextoIndice;
   private JLabel etiquetaApellidoPaterno;
   private JTextField campoTextoApellidoPaterno;
   private JTextField campoTextoMax;
   private JButton botonSiguiente;
   private JLabel etiquetaDe;
   private JLabel etiquetaTelefono;
   private JTextField campoTextoTelefono;
   private JLabel etiquetaDuracion;
   private JTextField campotextoDuracion;
   private JButton botonAnterior;
   private JButton botonConsulta;
   private JLabel etiquetaConsulta;
   private JPanel panelConsulta;
   private JPanel panelNavegar;
   private JPanel panelMostrar;
   private JTextField campoTextoConsulta;
   private JButton botonInsertar;
   
   // constructor sin argumentos
   public MostrarLibretaDirecciones()
   {
      super( "Libreta de direcciones" ); 
      
      // establece la conexión a la base de datos y las instrucciones PreparedStatement
      consultasPersona = new ConsultasPersona(); 
      
      // crea la GUI
      panelNavegar = new JPanel();
      botonAnterior = new JButton();
      campoTextoIndice = new JTextField( 2 );
      etiquetaDe = new JLabel();
      campoTextoMax = new JTextField( 2 );
      botonSiguiente = new JButton();
      panelMostrar = new JPanel();
      etiquetaID = new JLabel();
      campoTextoID = new JTextField( 10 );
      etiquetaPrimerNombre = new JLabel();
      campoTextoPrimerNombre = new JTextField( 10 );
      etiquetaApellidoPaterno = new JLabel();
      campoTextoApellidoPaterno = new JTextField( 10 );
      etiquetaEmail = new JLabel();
      campoTextoEmail = new JTextField( 10 );
      etiquetaTelefono = new JLabel();
      campoTextoTelefono = new JTextField( 10 );
      etiquetaDuracion = new JLabel();
      campotextoDuracion = new JTextField(10);
      panelConsulta = new JPanel();
      etiquetaConsulta = new JLabel();
      campoTextoConsulta = new JTextField( 10 );
      botonConsulta = new JButton();
      botonExplorar = new JButton();
      botonInsertar = new JButton();

      setLayout( new FlowLayout( FlowLayout.CENTER, 10, 10 ) );
      setSize( 500, 400 );
      setResizable( false );

      panelNavegar.setLayout(
         new BoxLayout( panelNavegar, BoxLayout.X_AXIS ) );

      botonAnterior.setText( "Anterior" );
      botonAnterior.setEnabled( false );
      botonAnterior.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               botonAnteriorActionPerformed( evt );
            } // fin del método actionPerformed
         } // fin de la clase interna anónima
      ); // fin de la llamada a addActionListener

      panelNavegar.add( botonAnterior );
      panelNavegar.add( Box.createHorizontalStrut( 10 ) );

      campoTextoIndice.setHorizontalAlignment(
         JTextField.CENTER );
      campoTextoIndice.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               campoTextoIndiceActionPerformed( evt );
            } // fin del método actionPerformed
         } // fin de la clase interna anónima
      ); // fin de la llamada a addActionListener

      panelNavegar.add( campoTextoIndice );
      panelNavegar.add( Box.createHorizontalStrut( 10 ) );

      etiquetaDe.setText( "de" );
      panelNavegar.add( etiquetaDe );
      panelNavegar.add( Box.createHorizontalStrut( 10 ) );

      campoTextoMax.setHorizontalAlignment(
         JTextField.CENTER );
      campoTextoMax.setEditable( false );
      panelNavegar.add( campoTextoMax );
      panelNavegar.add( Box.createHorizontalStrut( 10 ) );

      botonSiguiente.setText( "Siguiente" );
      botonSiguiente.setEnabled( false );
      botonSiguiente.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               botonSiguienteActionPerformed( evt );
            } // fin del método actionPerformed
         } // fin de la clase interna anónima
      ); // fin de la llamada a addActionListener

      panelNavegar.add( botonSiguiente );
      add( panelNavegar );

      panelMostrar.setLayout( new GridLayout( 6, 2, 4, 4 ) );

      etiquetaID.setText( "ID Peliculas:" );
      panelMostrar.add( etiquetaID );

      campoTextoID.setEditable( false );
      panelMostrar.add( campoTextoID );

      etiquetaPrimerNombre.setText( "Titulo:" );
      panelMostrar.add( etiquetaPrimerNombre );
      panelMostrar.add( campoTextoPrimerNombre );

      etiquetaApellidoPaterno.setText( "Genero:" );
      panelMostrar.add( etiquetaApellidoPaterno );
      panelMostrar.add( campoTextoApellidoPaterno );

      etiquetaEmail.setText( "Directores:" );
      panelMostrar.add( etiquetaEmail );
      panelMostrar.add( campoTextoEmail );

      etiquetaTelefono.setText( "Escritores:" );
      panelMostrar.add( etiquetaTelefono );
      panelMostrar.add( campoTextoTelefono );
      
      
      etiquetaDuracion.setText( "Duracion:" );
      panelMostrar.add( etiquetaDuracion );
      panelMostrar.add( campotextoDuracion );
      add( panelMostrar );

      panelConsulta.setLayout( 
         new BoxLayout( panelConsulta, BoxLayout.X_AXIS) );

      panelConsulta.setBorder( BorderFactory.createTitledBorder(
         "Buscar una entrada por Titulo" ) );
      etiquetaConsulta.setText( "Titulo de la pelicula:" );
      panelConsulta.add( Box.createHorizontalStrut( 5 ) );
      panelConsulta.add( etiquetaConsulta );
      panelConsulta.add( Box.createHorizontalStrut( 10 ) );
      panelConsulta.add( campoTextoConsulta );
      panelConsulta.add( Box.createHorizontalStrut( 10 ) );

      botonConsulta.setText( "Buscar" );
      botonConsulta.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               botonConsultaActionPerformed( evt );
            } // fin del método actionPerformed
         } // fin de la clase interna anónima
      ); // fin de la llamada a addActionListener

      panelConsulta.add( botonConsulta );
      panelConsulta.add( Box.createHorizontalStrut( 5 ) );
      add( panelConsulta );

      botonExplorar.setText( "Explorar todas las entradas" );
      botonExplorar.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               botonExplorarActionPerformed( evt );
            } // fin del método actionPerformed
         } // fin de la clase interna anónima
      ); // fin de la llamada a addActionListener

      add( botonExplorar );

      botonInsertar.setText( "Insertar nueva entrada" );
      botonInsertar.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               botonInsertarActionPerformed( evt );
            } // fin del método actionPerformed
         } // fin de la clase interna anónima
      ); // fin de la llamada a addActionListener

	   add( botonInsertar );

      addWindowListener( 
         new WindowAdapter() 
         {  
            public void windowClosing( WindowEvent evt )
            {
               consultasPersona.close(); // cierra la conexión a la base de datos
               System.exit( 0 );
            } // fin del método windowClosing
         } // fin de la clase interna anónima
      ); // fin de la llamada a addWindowListener
	
      setVisible( true );
   } // fin del constructor sin argumentos

   // maneja la llamada cuando se hace clic en botonAnterior
   private void botonAnteriorActionPerformed( ActionEvent evt )
   {
      indiceEntradaActual--;
      
      if ( indiceEntradaActual < 0 )
         indiceEntradaActual = numeroDeEntradas - 1;
      
      campoTextoIndice.setText( "" + ( indiceEntradaActual + 1 ) );
      campoTextoIndiceActionPerformed( evt );  
   } // fin del método botonAnteriorActionPerformed

   // maneja la llamada cuando se hace clic en botonSiguiente
   private void botonSiguienteActionPerformed( ActionEvent evt ) 
   {
      indiceEntradaActual++;
      
      if ( indiceEntradaActual >= numeroDeEntradas )
         indiceEntradaActual = 0;
      
      campoTextoIndice.setText( "" + ( indiceEntradaActual + 1 ) );
      campoTextoIndiceActionPerformed( evt );
   } // fin del método botonSiguienteActionPerformed

   // maneja la llamada cuando se hace clic en botonConsulta
   private void botonConsultaActionPerformed( ActionEvent evt )
   {
      resultados = 
         consultasPersona.obtenerPersonasPorApellido( campoTextoConsulta.getText() );
      numeroDeEntradas = resultados.size();
      
      if ( numeroDeEntradas != 0 )
      {
    	  indiceEntradaActual = 0;
          entradaActual = resultados.get( indiceEntradaActual );
          campoTextoID.setText("" + entradaActual.getIdPeliculas() );
          campoTextoPrimerNombre.setText( entradaActual.getTitulo() );
          campoTextoApellidoPaterno.setText( entradaActual.getGenero()) ;
          campoTextoEmail.setText( entradaActual.getDirectores() );
          campoTextoTelefono.setText( entradaActual.getEscritores() );
          campoTextoMax.setText( "" + numeroDeEntradas );
          campoTextoIndice.setText( "" + ( indiceEntradaActual + 1 ) );
          botonSiguiente.setEnabled( true );
          botonAnterior.setEnabled( true );
      } // end if
      else
         botonExplorarActionPerformed( evt );
   } // fin del método botonConsultaActionPerformed

   // maneja la llamada cuando se introduce un nuevo valor en campoTextoIndice
   private void campoTextoIndiceActionPerformed( ActionEvent evt )
   {
      indiceEntradaActual = 
         ( Integer.parseInt( campoTextoIndice.getText() ) - 1 );
      
      if ( numeroDeEntradas != 0 && indiceEntradaActual < numeroDeEntradas )
      {

          entradaActual = resultados.get( indiceEntradaActual );
          campoTextoID.setText("" + entradaActual.getIdPeliculas() );
          campoTextoPrimerNombre.setText( entradaActual.getTitulo() );
          campoTextoApellidoPaterno.setText( entradaActual.getGenero() );
          campoTextoEmail.setText( entradaActual.getDirectores() );
          campoTextoTelefono.setText( entradaActual.getEscritores() );
          campoTextoMax.setText( "" + numeroDeEntradas );
          campoTextoIndice.setText( "" + ( indiceEntradaActual + 1 ) );
      } // fin de if
    } // fin del método campoTextoIndiceActionPerformed

   // maneja la llamada cuando se hace clic en botonExplorar
   private void botonExplorarActionPerformed( ActionEvent evt )
   {
      try
      {
         resultados = consultasPersona.obtenerTodasLasPersonas();
         numeroDeEntradas = resultados.size();
      
         if ( numeroDeEntradas != 0 )
         {
        	 indiceEntradaActual = 0;
             entradaActual = resultados.get( indiceEntradaActual );
             campoTextoID.setText("" + entradaActual.getIdPeliculas() );
             campoTextoPrimerNombre.setText( entradaActual.getTitulo() );
             campoTextoApellidoPaterno.setText( entradaActual.getGenero() );
             campoTextoEmail.setText( entradaActual.getDirectores() );
             campoTextoTelefono.setText( entradaActual.getEscritores() );
             campoTextoMax.setText( "" + numeroDeEntradas );
             campoTextoIndice.setText( "" + ( indiceEntradaActual + 1 ) );
             botonSiguiente.setEnabled( true );
             botonAnterior.setEnabled( true );
         } // fin de if
      } // fin de try
      catch ( Exception e )
      {
         e.printStackTrace();
      } // fin de catch
   } // fin del método botonExplorarActionPerformed

   // maneja la llamada cuando se hace clic en botonInsertar
   private void botonInsertarActionPerformed( ActionEvent evt ) 
   {
	   int resultado = consultasPersona.agregarPersona( campoTextoPrimerNombre.getText(),
		         campoTextoApellidoPaterno.getText(), campoTextoEmail.getText(),
		         campoTextoTelefono.getText(),"grsffg",true );
      
      if ( resultado == 1 )
         JOptionPane.showMessageDialog( this, "Se agrego pelicula!",
            "Se agrego persona", JOptionPane.PLAIN_MESSAGE );
      else
         JOptionPane.showMessageDialog( this, "No se agrego pelicula!",
            "Error", JOptionPane.PLAIN_MESSAGE );
          
      botonExplorarActionPerformed( evt );
   } // fin del método botonInsertarActionPerformed
   
   // método main
   public static void main( String args[] )
   {
     new MostrarLibretaDirecciones();
   } // fin del método main
} // fin de la clase MostrarLibretaDirecciones


/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigación y prueba de las teorías y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garantía de      *
 * ningún tipo, expresa o implícita, en relación con estos programas o    *
 * con la documentación contenida en estos libros. Los autores y el       *
 * editor no serán responsables en ningún caso por los daños consecuentes *
 * en conexión con, o que surjan de, el suministro, desempeño o uso de    *
 * estos programas.                                                       *
 *************************************************************************/

 

 