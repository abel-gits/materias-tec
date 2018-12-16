package Archivos;
import java.io.*;
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
	      String nombre, sexo;
	      int edad, sueldo, tipo, especialidad;
	      // Leer datos de la entrada estándar y escribirlos
	      // en el fichero
	      do
	      {
	        CLS();
	    	flujoS.print("Nombre: "); nombre=Leer.dato();
	        flujoS.print("Edad: "); edad=Leer.datoInt();
	        flujoS.print("Sexo (M/F): "); sexo=Leer.dato();
	        flujoS.print("Sueldo: "); sueldo=Leer.datoInt();
	        do
	        {
	        	flujoS.print("Tipo de nombramiento (1=completo, 2= medio ó 3=parcial): ");
	        	tipo=Leer.datoInt();
	        }while(tipo<1 || tipo>3);
	        
	        do
	        {
	        	flujoS.print("Especialidad (1=licenciatura, 2=maestria ó 3=doctorado): ");
	        	especialidad=Leer.datoInt();
	        }while(especialidad<1 || especialidad>3);
	        
	        // Crear un objeto Profesor y almacenarlo en el fichero
	        oos.writeObject(new Profesor(nombre, edad, sexo, sueldo, tipo, especialidad));
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
