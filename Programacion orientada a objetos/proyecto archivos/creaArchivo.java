package Archivos;
import java.io.*;
import java.io.Serializable;
// Se utiliza también la clase Leer modificada en este Paquete

public class creaArchivo 
{
	public static void crearFichero(File fichero) throws IOException
	{
	    PrintStream flujoS = System.out; // salida estándar
	    ObjectOutputStream oos = null;// salida de datos hacia el fichero
	    char resp;
	    try
	    {
	      // Crear un flujo hacia el fichero que permita escribir
	      // objetos y datos de tipos primitivos.
	      oos = new ObjectOutputStream(new FileOutputStream(fichero));
	      // Declarar los datos a escribir en el fichero
	      String marca, modelo, color;
	      int precio;
	      // Leer datos de la entrada estándar y escribirlos
	      // en el fichero
	      do
	      {
	        CLS();
	    	flujoS.print("marca: "); marca=Leer.dato();
	        flujoS.print("modelo: "); modelo=Leer.dato();
	        flujoS.print("color: "); color=Leer.dato();
	        flujoS.print("precio: "); precio=Leer.datoInt();
	       	        
	        // Crear un objeto Profesor y almacenarlo en el fichero
	        oos.writeObject(new Autos(marca,modelo,color,precio));
	        flujoS.print("Desea escribir otro registro? (s/n) ");
	        resp = Leer.carácter();
	        Leer.limpiar();
	      }while (resp == 's');
	    }
	    finally
	    {
	      // Cerrar el flujo
	      if (oos != null) oos.close();
	    }
	  }


	  public static void main(String[] args)
	  {
	    PrintStream flujoS = System.out; // salida estándar
	    String nombreFichero = null;     // nombre del fichero
	    File fichero = null; // objeto que identifica el fichero
	    
	    try
	    {
	      // Crear un objeto File que identifique al fichero
	      flujoS.print("Nombre del fichero de datos a escribir: ");
	      nombreFichero = Leer.dato();
	      fichero = new File(nombreFichero);
	      
	      // Verificar si el fichero existe
	      char resp = 's';
	      if (fichero.exists())
	      {
	        flujoS.print("El fichero existe, desea sobreescribirlo? (s/n) ");
	        resp = Leer.carácter();
	        Leer.limpiar();
	      }
	      if (resp == 's')
	      {
	        crearFichero(fichero);
	      }
	    }
	    catch(IOException e)
	    {
	      flujoS.println("Error: " + e.getMessage());
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
