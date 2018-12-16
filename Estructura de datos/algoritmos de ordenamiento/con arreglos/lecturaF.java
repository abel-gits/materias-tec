package Algoritmos;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
public class lecturaF 
{
	public static void main(String[] args) {
    	int a=0;
    	int b=0;
    	String[] datos = new String[32954];
    	String[] precio = new String[32954];
    	archivo(datos,precio);
    	do{
    		a=menu();
    		switch (a){
    		case 1: mostrar(datos,precio);break;
    		case 2: buscar(datos,precio);break;
    		case 3: ordenarb(datos,precio);break;
    		case 4: ordenarq(datos,precio);break;
    		case 0: b++;break;
    		}
    	}while(b==0);
    }
	public static void archivo(String datos[],String precio[]){
		File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = null;
        try {
            	//Cargamos el archivo de la ruta relativa
            	archivo = new File("TITUSS.csv");
            	//	Cargamos el objeto FileReader
            	fr = new FileReader(archivo);
            	//Creamos un buffer de lectura
            	br = new BufferedReader(fr);
            	String [] Tit=null;
            	int tot = 0;
            	//Leemos hasta que se termine el archivo
            	while ((linea = br.readLine()) != null) 
            	{
            		//Utilizamos el separador para los datos
            		Tit = linea.split(";");
            		datos[tot]=Tit[0];
            		precio[tot]=Tit[3];
            		//Presentamos los datos
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
	public static void mostrar(String datos[],String precio[]){
		for (int i = 0; i < 32954; i++) {
			System.out.println("NOMBRE DEL LIBRO   =>   "+datos[i]+"   PRECIO   =>  "+precio[i]);
			}
		}
	public static void buscar(String datos[],String precio[]){
		            Arrays.sort(datos);
		            System.out.println("escribe el titulo a buscar");
		            String x=Leer.dato();	
		            int medio=0,inicio=0,fin=datos.length-1;
				    boolean flag = false;
				     while((inicio <= fin) && (!flag)){
				        medio = (inicio + fin) / 2;
				        //para comparar usamos compare() de string
				        if(x.compareToIgnoreCase(datos[medio]) > 0){ inicio = medio + 1;}
				        else if(x.compareToIgnoreCase(datos[medio]) < 0) {fin = medio - 1;}
				        else flag = true;
				     }
				     if(flag)System.out.println("elemento encontrado en la posicion  "+medio+"\n"+"NOMBRE DEL LIBRO: "+datos[medio]); 
				     else System.out.println("El elemento no esta en la lista"); 
		    }
	public static void ordenarb(String datos[],String precio[]){
		String aux,aux2;   
		for(int i=0;i<=32954;i++){
			for(int j=0;j<32954-i-1;j++){
				if(datos[j+1].compareTo(datos[j])<0 ){
					aux=datos[j+1];aux2=precio[j+1];
					datos[j+1]=datos[j];precio[j+1]=precio[j];
					datos[j]=aux;precio[j]=aux2;
				}
			}	
		}
		for (int i = 0; i < 32954; i++) {
			System.out.println("NOMBRE DEL LIBRO   =>   "+datos[i]+"   PRECIO   =>  "+precio[i]);
		}										
	}
		public static void ordenarq(String datos[],String precio[]) {
			archivo(datos,precio);
			int izq=0;
			int der=32953;
			quicksort(datos,izq,der);
			for (int i = 0; i < 32954; i++) {
				System.out.println("NOMBRE DEL LIBRO   =>   "+datos[i]+"   PRECIO   =>  "+precio[i]);
					}
			 
				}
		public static void quicksort(String datos[],int izq,int der){
            	String pivote=datos[izq]; // tomamos primer elemento como pivote
            	int i=izq; // i realiza la búsqueda de izquierda a derecha
            	int j=der; // j realiza la búsqueda de derecha a izquierda
            	String aux;
            	while(i<j){            // mientras no se crucen las búsquedas
            	while(datos[i].compareTo(pivote)<=0 && i<j) i++; // busca elemento mayor que pivote
            	while(datos[j].compareTo(pivote)>0) j--;         // busca elemento menor que pivote
            		if (i<j) {                      // si no se han cruzado                      
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
