// Fig. 25.30: Persona.java
// La clase Persona representa una entrada en una libreta de direcciones.
public class Persona
{
   private int idDireccion;
   private String primerNombre;
   private String apellidoPaterno;
   private String email;
   private String numeroTelefonico;

   // constructor sin argumentos
   public Persona()
   {
   } // fin del constructor de Persona sin argumentos

   // constructor
   public Persona( int id, String nombre, String apellido, 
      String direccionEmail, String telefono )
   {
      establecerIDDireccion( id );
      establecerPrimerNombre( nombre );
      establecerApellidoPaterno( apellido );
      establecerEmail( direccionEmail );
      establecerNumeroTelefonico( telefono );
   } // fin del constructor de Persona con cinco argumentos

   // establece el objeto idDireccion
   public void establecerIDDireccion( int id )
   {
      idDireccion = id;
   } // fin del método establecerIDDireccion

   // devuelve el valor de idDireccion 
   public int obtenerIDDireccion()
   {
      return idDireccion;
   } // fin del método obtenerIDDireccion
   
   // establece el primerNombre
   public void establecerPrimerNombre( String nombre )
   {
      primerNombre = nombre;
   } // fin del método establecerPrimerNombre

   // devuelve el primer nombre 
   public String obtenerPrimerNombre()
   {
      return primerNombre;
   } // fin del método obtenerPrimerNombre
   
   // establece el apellidoPaterno
   public void establecerApellidoPaterno( String apellido )
   {
      apellidoPaterno = apellido;
   } // fin del método establecerApellidoPaterno

   // devuelve el apellido paterno
   public String obtenerApellidoPaterno()
   {
      return apellidoPaterno;
   } // end method obtenerApellidoPaterno
   
   // establece la dirección de email
   public void establecerEmail( String direccionEmail )
   {
      email = direccionEmail;
   } // fin del método establecerEmail

   // devuelve la dirección de email
   public String obtenerEmail()
   {
      return email;
   } // fin del método obtenerEmail
   
   // establece el número telefónico
   public void establecerNumeroTelefonico( String telefono )
   {
      numeroTelefonico = telefono;
   } // fin del método establecerNumeroTelefonico

   // devuelve el número telefónico
   public String obtenerNumeroTelefonico()
   {
      return numeroTelefonico;
   } // fin del método obtenerNumeroTelefonico
} // fin de la clase Persona


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



 