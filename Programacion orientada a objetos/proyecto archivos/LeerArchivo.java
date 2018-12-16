package Archivos;
import java.io.*;
public class LeerArchivo
{ 
  public static void main(String[] args) throws ClassNotFoundException  // METODO MAIN()
  {
    PrintStream flujoS = System.out; // salida estándar
    String nombreFichero = null;     // nombre del fichero
    File fichero = null; // objeto que identifica el fichero

      try
      {
      // Enviar a una variable String el nombre del fichero
      flujoS.print("Nombre del fichero de datos a leer: ");
      nombreFichero = Leer.dato();
      	Autos [] VP=new Autos[31];
        System.out.println("escribe la marca a buscar:");
        String m=null;
        m =Leer.dato();
        
      int l=0;
      l=mostrarFichero(nombreFichero,VP,m);
     
      System.out.println("hay "+l+" autos de la marca "+m);
      CLS();
     System.out.println("la lista completa es :"+"\n");
     for(int i=0;i<=30;i++){
    	 System.out.println(VP[i].getMarca()+"\t\t\t"+VP[i].getModelo()+"\t\t\t"+VP[i].getColor()+"\t\t\t"+VP[i].getPrecio());
     }
      int x=0;
      x=costoso(VP,m);
      System.out.println("\n\n"+"el auto mas costoso es :");
      System.out.println(VP[x].getMarca()+"\t\t\t\t"+VP[x].getModelo()+"\t\t\t\t"+VP[x].getColor()+"\t\t\t\t"+VP[x].getPrecio());
      	
      }
      catch(IOException e)
      {
        System.out.println("Error: " + e.getMessage());
      } 
    
      
  }
  
  public static void CLS()
  {
	  for(int k=1;k<10;k++)
	  {
		  System.out.println();
	  }
  }
 
  public static int mostrarFichero(String nombreFichero, Autos [] VP,String m)  throws IOException
  {
    PrintStream flujoS = System.out; // salida estándar
    ObjectInputStream ois = null;// entrada de datos desde el fichero
    File fichero = null;       // objeto que identifica el fichero
    int n=0;
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
        	Autos a; // DECLARA UN OBJETO TIPO autos
        	String marca, modelo,color;
        	int precio, C=0;
        	
        	
        	 
       int i=0;
       boolean p=true;
       do
        {
          // Leer un objeto autos desde el fichero. Cuando se
          // alcance el final del fichero Java lanzará una
          // excepción del tipo EOFException.
          a = (Autos)ois.readObject();
          VP[C]=a;
          C++;
          
          marca = a.getMarca();
          modelo=a.getModelo();
          color=a.getColor();
          precio=a.getPrecio();
          
          
          if(marca.length()<15) marca=marca+"     ";
          
    		  if(VP[i].getMarca().equals(m)){
    			  if(p==true){
    		      	  System.out.println("marca"+"\t\t\t\t"+"modelo"+"\t\t\t\t"+"color"+"\t\t\t\t"+"precio");
    		            System.out.println();
    		           p=false;
    		        }
    			  System.out.println(VP[i].getMarca()+"\t\t\t\t"+VP[i].getModelo()+"\t\t\t\t"+VP[i].getColor()+"\t\t\t\t"+VP[i].getPrecio());
    			  n++;
    			  
    		  }
    		  i++;
    	 

        }
        while (true);
       
      
            }
      else
        flujoS.println("El fichero no existe");
    }
    catch(EOFException e)
    {
    	System.out.println();
    	flujoS.println();
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
	return n;
    
  }
  
  
  
  
  
  public static int costoso(Autos VP[],String m) {
	  int may=0;
	  int b=0,k=1;
	  int y=0;
	  int num=0;
	  do{
	num++;
		  
	  
			 if(VP[b].getPrecio()>VP[k].getPrecio()&&VP[b].getPrecio()>may){ 
				 
				 
				 may=VP[b].getPrecio();
				 y=b;
				 
			 }
			 else
				 if(VP[b].getPrecio()<VP[k].getPrecio()&&VP[k].getPrecio()>may){
					 may=VP[k].getPrecio();
					 y=k;
				 }
			 			  
	b++;k++;
	
	  }while(num!=30);
	  
	 return y;
	  
	   
	    
	  
  }
 
  
}
