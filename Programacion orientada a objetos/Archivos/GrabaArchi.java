package Archivos;
import java.io.*;
public class GrabaArchi 
{
	public static void main(String[] args) 
	{
	 	String nombreArchivo = null;     // nombre del fichero
	    File Archivo = null; // objeto que identifica el fichero
	    try
	    {
	      // Crear un objeto File que identifique al fichero
	      System.out.print("Nombre del ARCHIVO de datos a escribir: ");
	      nombreArchivo = Leer.dato();
	      Archivo = new File(nombreArchivo);
	      // Verificar si el fichero existe
	      char resp = 's';
	      if (Archivo.exists())
	      {
	        System.out.print("El fichero existe, desea sobreescribirlo? (s/n) ");
	        resp = Leer.carácter();
	        Leer.limpiar();
	      } 
	      if (resp == 's')
	      {
	        CreaArchivo(Archivo);
	      }
	    }
	    catch(IOException e)
	    {
	      System.out.println("Error: " + e.getMessage());
	    }
	}
	public static void CreaArchivo(File Archivo) throws IOException
	{
		 ObjectOutputStream oos = null;// salida de datos hacia el ARCHIVO
		    char resp;
		    try
		    {
		      // Crear un flujo hacia el ARCHIVO que permita escribir
		      // objetos y datos de tipos primitivos.
		      oos = new ObjectOutputStream(new FileOutputStream(Archivo));
		      // Declarar los datos a escribir en el ARCHIVO
		      String nombre, sexo;
		      int edad, sueldo, tipo, especialidad;
		      // Leer datos de la entrada estándar y escribirlos
		      // en el ARCHIVO
		      do
		      {
		    	System.out.print("Nombre: "); nombre=Leer.dato();
		    	System.out.print("Edad: "); edad=Leer.datoInt();
		    	System.out.print("Sexo (M/F): "); sexo=Leer.dato();
		    	System.out.print("Sueldo: "); sueldo=Leer.datoInt();
		        do
		        {
		        	System.out.print("Tipo de nombramiento (1=completo, 2= medio ó 3=parcial): ");
		        	tipo=Leer.datoInt();
		        }while(tipo<1 || tipo>3);
		        
		        do
		        {
		        	System.out.print("Especialidad (1=licenciatura, 2=maestria ó 3=doctorado): ");
		        	especialidad=Leer.datoInt();
		        }while(especialidad<1 || especialidad>3);
		     // Crear un objeto Profesor y almacenarlo en el ARCHIVO
		        oos.writeObject(new Profesor(nombre, edad, sexo, sueldo, tipo, especialidad));
		        System.out.print("Desea escribir otro registro? (s/n) ");
		        resp = Leer.carácter();
		        Leer.limpiar();
		      }while (resp == 's' || resp=='S');
		    }
		    finally
		    {
		      // Cerrar el flujo
		      if (oos != null) oos.close();
		    }
	}

}
