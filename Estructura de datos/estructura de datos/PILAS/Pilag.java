package PILAS;
class datoint
{
	int num;
}
class pilasg
  {
  	
  
    private static int max;
 	protected static Object dret;
 	private static Object p[];
 	public static int tope = -1;
 	public static datoint val;
 	
 	public pilasg()
 	 {
 	 	max=20;
 	 	p=new Object [max];
 	 }
 	
 	public pilasg(int n)
 	   { 
 	    max=n-1;
 	    p = new Object [max];
 	   } 
  	
 public static boolean pila_Llena(int tope,int max)
  {
  	 boolean llena;
  	 if (tope==max-1)
  	      llena=true;
  	    else
  	      llena=false;
  	 return llena;
  }	        
  
 public static boolean pila_Vacia( int tope)
  {
 	 boolean vacia;
 	 if (tope == -1)
 	    vacia=true;
 	   else
 	    vacia=false;
 	 return vacia;
  }

 public static  boolean push(Object dato)
 {
 	if(pila_Llena(tope,max)){
 	  System.out.println("!Cuidado!, Desbordamiento!!!!!");
 	   return false;}
 	   else
 	     {
 	     	tope++;
 	     	p[tope]=dato;
 	     	return true; // pone el nuevo dato en la pila
 	     }
 }	     	

public static boolean pop()
 {
 	if (pila_Vacia(tope)){
 	   System.out.println("!Cuidado!, Subdesbordamiento!!!!!");
 	   return false;}
 	 else {
 		  dret=p[tope];
 	      tope--;
 	  return true;}// actualiza tope y se elimina elemento en el tope 
 }
 
  public static void peek()
    {
 	 
 	if (pila_Vacia(tope))
 	   System.out.println("!Cuidado!, No hay Datos!!!!!");
 	else
 	  System.out.println(p[tope]);
    
  }  	  	
 
 
 
 public static void estado()
  {
  	int i;
       
  	System.out.println(" El estado de la pila es : ");
  	System.out.println(" --------------------------");
  	for(i=0;i<=tope;i++)
  	 {
  	 	dret=p[i];
  	 	val = (datoint) dret;
  	 	System.out.println("p["+i+"] : "+val.num);
  	 }
  }
} 