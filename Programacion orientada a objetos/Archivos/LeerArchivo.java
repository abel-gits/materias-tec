package Archivos;
import java.io.*;
public class LeerArchivo 
{
	public static void mostrarFichero(String nombreFichero, Profesor [] VP)  throws IOException
  {
    PrintStream flujoS = System.out; // salida estándar
    ObjectInputStream ois = null;// entrada de datos desde el fichero
    File fichero = null;       // objeto que identifica el fichero
    
    try
    {
      // Crear un objeto File que identifique al fichero
      fichero = new File(nombreFichero);

      // Verificar si el fichero existe
      if (fichero.exists())
      {
        // Si existe, abrir un flujo desde el mismo (Output Input Stream)
        ois = new ObjectInputStream(new FileInputStream(fichero));
        
        // Declarar los datos a leer desde el fichero
        	Profesor Pro; // DECLARA UN OBJETO TIPO Profesor
        	String nombre, sexo;
        	int edad, sueldo, tipo, espe, C=0;
        	
        // IMPRIME ENCABEZADOS
       System.out.println("NOMBRE"+"\t\t\t"+"EDAD"+"\t\t"+"SEXO"+"\t\t"+"SUELDO"+"\t\t"+"NOMBRAMIENTO"+"\t\t"+"ESPECIALIDAD");
       System.out.println(); 
       do
        {
          // Leer un objeto Profesor desde el fichero. Cuando se
          // alcance el final del fichero Java lanzará una
          // excepción del tipo EOFException.
          Pro = (Profesor)ois.readObject();
          VP[C]=Pro;
          C++;
          String TIPO=null, ESPEC=null;
          nombre = Pro.getNombre();
          edad=Pro.getEdad();
          sexo=Pro.getSexo();
          sueldo=Pro.getSueldo();
          
          tipo=Pro.getTipo(); // LEE EL TIPO
          if(tipo==1) {	TIPO="COMPLETO"; }
          if(tipo==2) {	TIPO="MEDIO   "; }
          if(tipo==3) {	TIPO="PARCIAL "; }
          
          espe=Pro.getEspecialidad(); // LEE ESPECIALIDAD
          if(espe==1) {	ESPEC="LICENCIATURA"; }
          if(espe==2) {	ESPEC="MAESTRIA"; }
          if(espe==3) {	ESPEC="DOCTORADO"; }
          
          if(nombre.length()<8) nombre=nombre+"    ";
          
          // IMPRIME LOS DATOS LEIDOS DEL ARCHIVO
          flujoS.println(nombre+"\t\t"+edad+"\t\t"+sexo+"\t\t"+"$ "+sueldo+"\t\t"+TIPO+"\t\t"+ESPEC);
          
        }
        while (true);
      }
      else
        flujoS.println("El fichero no existe");
    }
    catch(EOFException e)
    {
    	System.out.println();
    	flujoS.println("Fin del listado");
    }
    catch(ClassNotFoundException e)
    {
      flujoS.println("Error: " + e.getMessage());
    }
    finally
    {
      // Cerrar el flujo
      if (ois != null) ois.close();
    }
  }
  
  public static void main(String[] args)  // METODO MAIN()
  {
    PrintStream flujoS = System.out; // salida estándar
    String nombreFichero = null;     // nombre del fichero
    File fichero = null; // objeto que identifica el fichero  	 	
    	
      try
      {
      // Enviar a una variable String el nombre del fichero
      flujoS.print("Nombre del fichero de datos a leer: ");
      nombreFichero = Leer.dato();
      	Profesor [] VP=new Profesor[20];
      	mostrarFichero(nombreFichero, VP);
    
      }
      catch(IOException e)
      {
        System.out.println("Error: " + e.getMessage());
      }
    
  }
  public static void CLS()
  {
	  for(int k=1;k<40;k++)
	  {
		  System.out.println();
	  }
  }
}
