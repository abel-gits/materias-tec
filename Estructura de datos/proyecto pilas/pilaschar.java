package Pilas;
class operapilaschar
  {
  	
    public static char dret;
 
    public static int max;
 	
    public static char pila[];
 
    public static int tope = -1;
 
    
    public operapilaschar()
    {
 		max=20;
 		pila=new char [max];
    }
 	
    public operapilaschar(int n)
    { 
 	 	max=n-1;
 		 pila = new char [max];
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

 	public static void push(char dato)
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
 	   		
 		else 
 		{
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