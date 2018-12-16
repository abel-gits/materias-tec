package Pilas;
class operapilasint
{
  	
    public static int dret;
 
    public static int max;
 	
    public static int pila[];
 
    public static int tope = -1;
 
    
    public operapilasint()
    {
 		max=20;
 		pila=new int [max];
    }
 	
    public operapilasint(int n)
    { 
 	 	max=n-1;
 	 	pila = new int [max];
    } 	 	
 
  	
 public static boolean pila_Llena(int tope,int max)
  {
  	 boolean llena;
  	 if (tope==max)
  	      llena=true;
  	    else
  	      llena=false;
  	 return llena;
  }	        
  
 public static boolean pila_Vacia(int tope)
  {
 	 boolean vacia;
 	 if (tope == -1)
 	    vacia=true;
 	   else
 	    vacia=false;
 	 return vacia;
  }

 public static void push(int dato)
 {
 	if(pila_Llena(tope,max)){}
 	   else
 	     {
 	     	tope++;
 	     	pila[tope]=dato;// pone el nuevo dato en la pila
 	     }
 	 
 }	     	

public static void pop()
 {
 	if (pila_Vacia(tope)){}
 	else {
 		  dret=pila[tope];
 	      tope--;
 	      }// actualiza tope y se elimina elemento en el tope
 	
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
  	for(i=0;i<=tope;i++)
  	 {
  	 	System.out.println("pila["+i+"] : "+pila[i]);
  	 }
  }
  
 	  
}