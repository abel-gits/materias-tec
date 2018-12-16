package Pilas;

public class Practicapila {
	public static void main(String[] args) {
		int n=0;
		System.out.println("cuantos numeros vas a escribir?");
		n=Leer.datoInt();
		pilasint pila1 = new pilasint(n);
	    pilasint pila2 = new pilasint(n);
	    pilasint pila3 = new pilasint(n);
		llenapila(pila1,pila2, pila3,n);
		//verifica(pila1,pila2, pila3,n);
	}
	
	public static boolean verifica(pilasint pila1, pilasint pila2 ,pilasint pila3,int n){
		boolean p=false;
		do{
			int a=pila1.pop(),c=0;
			
			for (int i = 0; i < n; i++) {
			int b=pila2.pop();
			if (a!=b) {
				pila3.push(b);c++;
			}
			if (c==n-1) {
				p=true;
			}
			}
			cambiar(pila2,pila3,n);
		}while(p==true);
		if(p==true) return false;
		else return true;
	}
	public static void cambiar(pilasint pila2, pilasint pila3,int n){
		do{
			int a=0;
			a=pila3.pop();
			pila2.push(a);
		}while(pila3.pila_Vacia()!=false);
			
		
	}
	
	
	
	
	
	
	public static void llenapila(pilasint pila1, pilasint pila2 ,pilasint pila3,int n){
		int a=0;
		System.out.println("escribe los datos de la pila 1");
		for (int i = 0; i < n; i++) {
		
			a=Leer.datoInt();
			pila1.push(a);
		}
		int b=0;
		System.out.println("escribe los datos de la pila 2");
				for (int i = 0; i < n; i++) {
					b=Leer.datoInt();
					pila2.push(b);
			
	}
		
		
	}
}
