package Colas;
import java.*;
public class Colas 
{
	private int Fre;
    private int Fin;
    private int Max;
    private Object C [];
    public Object DR;

    public Colas() 
    {  
    	Fre = -1; 
    	Fin= -1; 
        Max=10;
        C = new Object[Max];
    }
    
    public Colas (int N)  
    {   
    	Fre= -1; 
    	Fin= -1;
        Max=N;
        C=new Object[Max];
    }

    public boolean llena()
    {   
    	if (Fin==Max-1)
             return true;
         return false;
    }

    public boolean vacia()
    {   
    	if (Fre== -1)
            return true;
         return false;
    }

    public boolean Inserta(Object Dato)
    {  
    	if (llena())
           return false;
       Fin=Fin+1; 
       C[Fin]=Dato;
       if (Fre== -1)
           Fre=0;
       return true;   
    }

    public boolean Retira()
    {   
    	if (vacia())
            return false;
         DR=C[Fre];
         if (Fre==Fin) //único dato
         { Fre= -1; Fin= -1;
          }
          else
              Fre=Fre+1;
        return true;
    }
}

