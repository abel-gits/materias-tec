package CHIVO;
import java.io.*;
/*
 * Lee un archivo de TEXTO separado por comas que se encuentra dentro
 * del proyecto en la carpeta archivo con el nombre TITUSS.cvs
 * Contiene 4 DATOS:  Titulo del LIBRO, AUTOR, PRECIO DE COMPRA y PRECIO DE VENTA.
 */

public class lecturaF 
{
    public static void main(String[] args) 
    {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = null;
        try 
        {
            //Cargamos el archivo de la ruta relativa
            archivo = new File("archivo\\TITUSS.csv");
            //Cargamos el objeto FileReader
            fr = new FileReader(archivo);
            //Creamos un buffer de lectura
            br = new BufferedReader(fr);

            String[] datos = new String[33000];
            String [] Tit=null;
          
            int tot = 0;
            String titulo=" ";
            String sub=" ";
            System.out.println("escribe el titulo a buscar");
            titulo=Leer.dato();
            int a=0;
            a=titulo.length();
            while ((linea = br.readLine()) != null) 
            {
            	//Utilizamos el separador para los datos
                Tit = linea.split(";");
                datos[tot]=Tit[0];
               
            if(titulo.length()<=Tit[0].length()){
            	sub=Tit[0].substring(0,a );
            	if(sub.equalsIgnoreCase(titulo)){
            	System.out.println(" TITULO -> " + Tit[0] +"\t"+ " COSTO -> " + Tit[2]+"\t"+ " VENTA -> " + Tit[3] );
            	tot++;
            	}
            }
                
                
            }
            if(tot!=0)
            System.out.println("TOTAL: "+tot);
            else System.out.println("no se encontro nada");
            

            //Capturamos las posibles excepciones
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
    
}
