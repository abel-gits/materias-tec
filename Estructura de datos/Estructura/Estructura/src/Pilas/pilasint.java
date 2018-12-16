package Pilas;
class pilasint
{
  	
    public static int dret;
 
    public static int max;
 	
    public static int pila[];
 
    public static int tope = -1;
 
    
    public pilasint()
    {
 		max=20;
 		pila=new int [max];
    }
 	
    public pilasint(int n)
    { 
 	 	max=n;
 	 	pila = new int [max];
    } 	 	
 
  	
 public boolean pila_Llena()
  {
  	 boolean llena;
  	 if (tope==max)
  	      llena=true;
  	    else
  	      llena=false;
  	 return llena;
  }	        
  
 public boolean pila_Vacia()
  {
 	 boolean vacia;
 	 if (tope == -1)
 	    vacia=true;
 	   else
 	    vacia=false;
 	 return vacia;
  }

 public void push(int dato)
 {
 	if(pila_Llena())
 	  System.out.println("!Cuidado!, Desbordamiento!!!!!");
 	   else
 	     {
 	     	tope++;
 	     	pila[tope]=dato;// pone el nuevo dato en la pila
 	     }
 	 
 }	     	

public int pop()
 {
 	
 	   
 		  dret=pila[tope];
 	      tope--;
 	      return dret;
 	
 }
  	     
public static boolean compara(int dret,int ch)
 {
	if (dret=='(' && ch==')' || dret=='{' && ch=='}' || dret=='[' && ch==']')
	  return true;
	  else 
	  return false;
 }
 
 public static void estado()
  {
  	int i;
  	System.out.println(" El estado de la pila es : ");
  	System.out.println(" --------------------------");
  	for(i=0;i<=tope;i++)
  	 {
  	 	System.out.println("pila["+i+"] : "+pila[i]);
  	 }
  }
  
 	  
}