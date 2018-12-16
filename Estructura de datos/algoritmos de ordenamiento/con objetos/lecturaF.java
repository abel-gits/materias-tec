package prueba;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
public class lecturaF {
	public static void main(String[] args) {
    	int a=0;
    	int b=0;
    	Titulos[] datos = new Titulos[32954];    	
    	archivo(datos);
    	do{
    		a=menu();
    		switch (a){
    		case 1: mostrar(datos);break;
    		case 2: buscar(datos);break;
    		case 3: ordenarb(datos);break;
    		case 4: ordenarq(datos);break;
    		case 0: b++;break;
    		}
    	}while(b==0);
    }
	public static void archivo(Titulos datos[]){
		File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = null;
        try {            	
            	archivo = new File("TITUSS.csv");            	
            	fr = new FileReader(archivo);            	
            	br = new BufferedReader(fr);
            	String [] Tit=null;
            	int tot = 0;
            	String x,y,z;
            	while ((linea = br.readLine()) != null) 
            	{
            		Tit = linea.split(";");
            		x=Tit[0];
            		y=Tit[1];
            		z=Tit[3];
            		datos[tot]= new Titulos(x,y,z);
            		tot++;
            	}    	
            	
        	} catch (Exception e) {
        		e.printStackTrace();
        	} finally {
        		try {
        			if (fr != null) {
        				fr.close();
        			}
        		} catch (Exception e2) {
        			e2.printStackTrace();
        		}
        	}
		}
	public static int menu() {
			int opc;
			System.out.println();
			System.out.println("1.- Mostar lista desordenada");
			System.out.println("2.- Busqueda binaria");
			System.out.println("3.- Ordenar por burbuja y desplagar");
			System.out.println("4.- Ordenar por quicksort y desplegar");
			System.out.println("0.- Salir");
			System.out.print("\nSeleccione su opcion: ");
			opc=Leer.datoInt();
			return opc;
		}
	public static void mostrar(Titulos datos[]){
		for (int i = 0; i < 32954; i++) {
			System.out.println(" TITULO ->  "+ datos[i].getTitulo()+"\t\t"+"Autor ->  "+datos[i].getAutor()+"\t\t"+"Precio -> "+datos[i].getPrecio() );
			}
		}
	public static void buscar(Titulos datos[]){
		int izq=0;
		int der=32953;
		archivo(datos);
		quicksort(datos,izq,der);
		System.out.println("escribe el titulo a buscar");
		String x=Leer.dato();	
		int medio=0,inicio=0,fin=datos.length-1;
		boolean flag = false;
		while((inicio <= fin) && (!flag)){
			medio = (inicio + fin) / 2;
			if(x.compareToIgnoreCase(datos[medio].getTitulo()) > 0){ inicio = medio + 1;}
			else if(x.compareToIgnoreCase(datos[medio].getTitulo()) < 0) {fin = medio - 1;}
			else flag = true;
		}
		if(flag){System.out.println("elemento encontrado en la posicion  "+medio);
		System.out.println(" TITULO ->  "+ datos[medio].getTitulo()+"\t\t"+"Autor ->  "+datos[medio].getAutor()+"\t\t"+"Precio -> "+datos[medio].getPrecio() );
			}
		else System.out.println("El elemento no esta en la lista"); 
	}
	
	public static void ordenarb(Titulos datos[]){
		String aux,aux2,aux3;   
		for(int i=0;i<=32954;i++){
			for(int j=0;j<32954-i-1;j++){
				if(datos[j+1].getTitulo().compareTo(datos[j].getTitulo())<0 ){
					aux=datos[j+1].getTitulo();aux2=datos[j+1].getAutor();aux3=datos[j+1].getPrecio();
					datos[j+1].setTitulo(datos[j].getTitulo());    datos[j+1].setAutor(datos[j].getAutor());   datos[j+1].setPrecio(datos[j].getPrecio());
					datos[j].setTitulo(aux);datos[j].setAutor(aux2);datos[j].setPrecio(aux3);
				}
			}	
		}
		for (int i = 0; i < 32954; i++) {
			System.out.println(" TITULO ->  "+ datos[i].getTitulo()+"\t\t"+"Autor ->  "+datos[i].getAutor()+"\t\t"+"Precio -> "+datos[i].getPrecio() );
		}										
	}
		public static void ordenarq(Titulos datos[]) {
			archivo(datos);
			int izq=0;
			int der=32953;
			quicksort(datos,izq,der);
			for (int i = 0; i < 32954; i++) {
				System.out.println(" TITULO ->  "+ datos[i].getTitulo()+"\t\t"+"Autor ->  "+datos[i].getAutor()+"\t\t"+"Precio -> "+datos[i].getPrecio() );
					}
			 
				}
		public static void quicksort(Titulos datos[],int izq,int der){
			 Titulos pivote=datos[izq]; // tomamos primer elemento como pivote
		  	  int i=izq; // i realiza la búsqueda de izquierda a derecha
		  	  int j=der; // j realiza la búsqueda de derecha a izquierda
		  	  Titulos aux;
		  	 
		  	  while(i<j)
		  	  {            // mientras no se crucen las búsquedas
		  	     while((datos[i].getTitulo()).compareTo(pivote.getTitulo())<=0 && i<j) i++; // busca elemento mayor que pivote
		  	     while((datos[j].getTitulo()).compareTo(pivote.getTitulo())>0) j--;         // busca elemento menor que pivote
		  	     if (i<j) 
		  	     {                      // si no se han cruzado                      
		  	         aux= datos[i];                  // los intercambia
		  	         datos[i]=datos[j];
		  	         datos[j]=aux;
		  	     }
		  	   }
		  	   datos[izq]=datos[j]; // se coloca el pivote en su lugar de forma que tendremos
		  	   datos[j]=pivote; // los menores a su izquierda y los mayores a su derecha
		  	   if(izq<j-1)
		  	      quicksort(datos,izq,j-1); // ordenamos subarray izquierdo
		  	   if(j+1 <der)
		  	      quicksort(datos,j+1,der); // ordenamos subarray derecho
		}    
}
