package proyectosoldado;

public class ClaseListaI 
{
	  static ClaseNodoI inicial;
	  
	  public static void Inicializar() 
	  {
	   inicial=new ClaseNodoI();
	   inicial=null;
	  }
	  
	  public static int Eliminar(int d)
	  {
	   ClaseNodoI i=inicial, anterior=i;
	   if(i==null) {
		   System.out.println("Lista vacia !!!");
	    return 1;
	   }
	   while(i!=null) 
	   {
	    if(d==i.num) 
	    {
	     if(i==inicial) 
	     {
	      inicial=i.sn;
	      System.out.println("\nBaja al principio..."+d);
	      return 1;
	     }
	     anterior.sn=i.sn;
	     System.out.println("\nBaja intermedia o al final ..."+d);
	     return 1;
	    }
	    anterior=i;
	    i=i.sn;
	   }
	   
	   return 0;
	  }
	  
	  public static int Insertar(int d) 
	  {
	   ClaseNodoI i=inicial, nuevo_nodo, anterior=i;
	   
	   if(i==null) 
	   {
	     nuevo_nodo=new ClaseNodoI();
	     nuevo_nodo.num=d;
	     nuevo_nodo.sn=null;
	     inicial=nuevo_nodo;
	     return 1;
	   }
	   while(i!=null) 
	   {
	    if(d==i.num) 
	    {
	     System.out.println("\nDuplicado !!!");
	     return 0;
	    }
	    if(d<i.num) 
	    {
	     if(i==inicial) 
	     {
	      nuevo_nodo=new ClaseNodoI();
	      nuevo_nodo.num=d;
	      nuevo_nodo.sn=inicial;
	      inicial=nuevo_nodo;
	      //System.out.println("\nAlta al principio...");
	      return 1;
	     }
	     nuevo_nodo=new ClaseNodoI();
	     nuevo_nodo.num=d;
	     nuevo_nodo.sn=anterior.sn;
	     anterior.sn=nuevo_nodo;
	     //System.out.println("\nAlta intermedia...");
	     return 1;
	    }
	    anterior=i;
	    i=i.sn;
	   }
	   nuevo_nodo=new ClaseNodoI();
	   nuevo_nodo.num=d;
	   nuevo_nodo.sn=null;
	   anterior.sn=nuevo_nodo;
	   //System.out.println("\nAlta al final...");
	   return 1;
	  }
	  
	  public static void Recorrido()
	  {
	   ClaseNodoI i=inicial;
	  // System.out.println("\n<<< RECORRIDO DE LA LISTA DE SOLDADOS VOLNTARIOS >>>\n\n");
	   if(i==null) 
	   {
	    //System.out.println("\nLista vacia");
	   }
	   while(i!=null) 
	   {
	    System.out.print(i.num+" ->");
	    i = i.sn;
	   }
	   //System.out.println("null");
	}
	 
}
