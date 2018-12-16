package Colas;

public class ColaCircular 
{
	static int max; // Tamano maximo de la Cola Circular
    static int colacirc[]=new int[max]; // Declaracion del arreglo para almacenar la Cola Circular
    static int frente, fin; // Inidicadores del inicio y final de la Cola Circular

    ColaCircular(int n) { // Constructor que inicializa el frente y el final de la Cola Circular
     frente=-1;    fin=-1; 

    }
    
    public int  Mostrar() { 
    	int ret= 0;
    	    	ret=colacirc[frente];
    	    	frente++;
    	return ret;
    }
        
    public void Insertar(int dato) {
     if((fin==max-1 && frente==0) || (fin+1==frente)) {
     // System.out.println("Cola Circular llena !!!");
      return;
     }
     if(fin==max-1 && frente!=0) fin=0; else fin++;
     colacirc[fin]=dato;
     if(frente==-1) frente=0;
    }
    
    public void Eliminar() {
  
     
     if(frente==-1) {
      System.out.println("Cola Circular vacia !!!");
      return;
     }
     System.out.println("Dato eliminado = "+colacirc[frente]);//elimina en el vector
     if(frente==fin) {                                    //el primer fuente
      frente=-1;   fin=-1; //si frente igual a fin vacios mostrar -1
      return;
     }
     if(frente==max) frente=0; else frente++;
    }
}
