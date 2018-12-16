package Pilas;

public class Pila1 
{
	private Object pila[];
	private int tope=-1;
	private Object dato;
	private int max=0;
	
	Pila1(int maximo)
	{
		max=maximo;
		pila=new Object[max];
	}
	
	public void borrarpila()
    {
	   tope=-1;
    }
	
	private boolean Pila_llena()
	{
	    boolean res=false;
		if(tope==(max-1))
		{
			 res= true;
		}
		else
		{
			res= false;
		}
		 return res;
	}
	
	
	public boolean Pila_vacia()
	{
	    boolean res=false;
		
		if(tope==-1)
		  res=true;
		
		return res;
	}
	
	public boolean Insertar(Object dato)
	{
		boolean res=false;
		if(!Pila_llena())
		 {
   			 tope++;
             pila[tope]=dato;
 			 res=true;
		 }
		 return res;
	}
	
	public Object retirar()
	{
		Object res;
		if(!Pila_vacia())
		{
			res=pila[tope];
			tope--;
		}
		else
		{
			System.out.println("pila vacia ");
			res="no se pudo retirar";
		} 
		return res;
	}
	
	public void Mostrar()
	{
		for(int i=tope; i>=0;i--)
		{
			System.out.println(pila[i]);
		}
	}
	
	public void MostrarOri()
	{
		for(int i=0; i<=tope;i++)
		{
			System.out.println(pila[i]);
		}
	}
}
