package Listas;
// Clase Listas con Arreglos
public class Listas 
{
	 static String dato[]=new String[100]; //Declaracion del arreglo para los datos de tipo char
	  static int sn[]=new int[100]; //Declaracion del arreglo para el indicador del sig. nodo
	  static int apui, top; // Apuntador inicial y Cantidad de datos en la Lista
	  Listas() // Constructor de la Clase Listas
	  { 
	    apui=-1;
	    top=0;
	    System.out.println("Lista enlazada inicializada !!!");
	    System.out.println("apui="+apui);
	    System.out.println("top  ="+top);
	  }
	  public static void Mostrar() 
	  {
	    int i=0;
	    System.out.println("\n\n<<< MOSTRAR ESTRUCTURA >>>");
	    if(apui==-1) 
	    	System.out.println("\nLista enlazada vacia !!!\n");
	    System.out.println("posicion  dato       sn");
	    System.out.println("---------------------------");
	    for(i=0;i<top;i++) 
	    {
	      System.out.println(i+"       |   "+dato[i]+"      |   "+sn[i]);
	    }
	    System.out.println("\napui="+apui);
	    System.out.println("top="+top);
	  }
	   public static void Insertar(String elemento) 
	   {
		   int i=0, ant=0;
		   if(apui==-1) //Alta en Lista vacia
		   { 
			   System.out.println("Insertar dato en lista vacia ...");
			   apui=top;
			   dato[top]=elemento;
			   sn[top]=-1;
			   top++;
			   return;
		   }
	       i=apui;
	       do 
	       {
	    	   if(dato[i]==elemento) 
	    	   {
	    		   System.out.println("Duplicado !!!");
	    		   return;
	    	   }
	    	   if(elemento.length()<dato[i].length()) 
	    	   {
	    		   if(i==apui) //Alta al principio
	    		   { 
	    			   System.out.println("Insertando el dato menor de todos ...");
	    			   dato[top]=elemento;
	    			   sn[top]=apui;
	    			   apui=top;
	    			   top++;
	    			   return;
	    		   } 
	    		   else 
	    		   {
	    			   System.out.println("Alta intermedia ...");
	    			   dato[top]=elemento;
	    			   sn[top]=sn[ant];
	    			   sn[ant]=top;
	    			   top++;
	    			   return;
	    		   }
	    	   }
	    	   ant=i;
	    	   i=sn[i];
	       }while(i!=-1);
	       System.out.println("Alta al final ...");
	       dato[top]=elemento;
	       sn[top]=-1;
	       sn[ant]=top;
	       top++;
	       return; 
	   }
}
