package Colas;

public class Cola1 
{
	private Object Cola1[];
	private int fre=-1;
	private int fin=-1;
	private int max=0;
	private Object dato;
	
	Cola1(int maximo)
	{
		max=maximo;
		Cola1=new Object[max];
		fre=-1;
		fin=-1;
	}
	
	
	public boolean Cola_vacia()
	{
	    boolean res=false;
		if((fre==-1) &&(fin==-1))
		  res=true;
		return res;
	}
	
	
	private boolean Cola_llena()
	{
	    boolean res=false;
		
		if(fin==(max-1))
		{
			 res= true;
		}
		else
		{
			res= false;
		}
		 return res;
	}
	
	public boolean Insertar_Cola(int dato)
	{
		boolean res=false;
		if(!Cola_llena())
		 {
   			 fin++;
             Cola1[fin]=dato;
 			 res=true;
 			 
 			 if(fin==0)
 			   fre=0;
         }
		 return res;
	}
	
	public Object retirar_Cola()
	{
		String res="si se pudo";
		if(fre>fin)
		{
			fre=-1;
			fin=-1;
			res="no se pudo";
		}
		if(!Cola_vacia())
		{
		   dato=Cola1[fre];
		   Cola1[fre]="";
		 		   
		   for(int i=0;i<fin;i++)
		   {
		   	 Cola1[i]=Cola1[i+1];
		   }
		   fin--;
		}
		
	    if(res.compareTo("si se pudo")==0)
	    	return dato;
	    else
	    	return res;
	}
   public int Mostrar()
   {
	  int ret= 0;
    	ret=(int) Cola1[fre];
   	  fre++;
return ret;
		
   }	
	
	public void Mostrar1()
	{
		for(int i=0; i<=max;i++)
		{
		
			System.out.print(Cola1[i]);
		}
	}	
}
