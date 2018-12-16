package Listas;

public class ClaseLista 
{
	  static ClaseNodo inicial;
	  
	  public static void Inicializar() {
	   inicial=new ClaseNodo();
	   inicial=null;
	  }
	  
	  public static void Eliminar(String dato)
	  {
	   ClaseNodo i=inicial, anterior=i;
	   if(i==null) {
		   System.out.println("Lista vacia !!!");
	    return;
	   }
	   while(i!=null) 
	   {
	    if(dato.equals(i.dato)) 
	    {
	     if(i==inicial) 
	     {
	      inicial=i.sn;
	      System.out.println("\nBaja al principio...");
	      return;
	     }
	     anterior.sn=i.sn;
	     System.out.println("\nBaja intermedia o al final ...");
	     return;
	    }
	    anterior=i;
	    i=i.sn;
	   }
	   System.out.println("\nNo existe ese dato !!!");
	   return;
	  }
	  
	  public static void Insertar(String d
			  ) 
	  {
	   ClaseNodo i=inicial, nuevo_nodo, anterior=i;
	   
	   if(i==null) 
	   {
	     nuevo_nodo=new ClaseNodo();
	     nuevo_nodo.dato=d;
	     nuevo_nodo.sn=null;
	     inicial=nuevo_nodo;
	     System.out.println("\nAlta a lista vacia...");
	     return;
	   }
	   while(i!=null) 
	   {
	    if(d==i.dato) 
	    {
	     System.out.println("\nDuplicado !!!");
	     return;
	    }
	    if(d.charAt(0)<i.dato.charAt(0)) 
	    {
	     if(i==inicial) 
	     {
	      nuevo_nodo=new ClaseNodo();
	      nuevo_nodo.dato=d;
	      nuevo_nodo.sn=inicial;
	      inicial=nuevo_nodo;
	      System.out.println("\nAlta al principio...");
	      return;
	     }
	     nuevo_nodo=new ClaseNodo();
	     nuevo_nodo.dato=d;
	     nuevo_nodo.sn=anterior.sn;
	     anterior.sn=nuevo_nodo;
	     System.out.println("\nAlta intermedia...");
	     return;
	    }
	    anterior=i;
	    i=i.sn;
	   }
	   nuevo_nodo=new ClaseNodo();
	   nuevo_nodo.dato=d;
	   nuevo_nodo.sn=null;
	   anterior.sn=nuevo_nodo;
	   System.out.println("\nAlta al final...");
	   return;
	  }
	  
	  public static void Recorrido()
	  {
	   ClaseNodo i=inicial;
	   System.out.println("\n<<< RECORRIDO DE UNA LISTA ENCADENADA >>>\n\n");
	   if(i==null) 
	   {
	    System.out.println("\nLista vacia");
	   }
	   while(i!=null) 
	   {
	    System.out.print(i.dato+"->");
	    i = i.sn;
	   }
	   System.out.println("null");
	}
}
