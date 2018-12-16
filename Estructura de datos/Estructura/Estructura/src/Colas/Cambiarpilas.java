package Colas;

import java.util.*;


public class Cambiarpilas {
	public static void main(String[] args) {
		int n=0;
		System.out.println("cuantos nombres vas a escribir?");
		n=Leer.datoInt();
		Stack<String> pila1=new Stack<String>();
		Stack<String> pila2=new Stack<String>();
		Stack<String> pila3=new Stack<String>();
		String a="";
		System.out.println("escribe los  "+n+"  nombres");
		for (int i = 0; i < n; i++) {
			a=Leer.dato();
			pila1.push(a);
			
		}
		
		for (int i = 0; i < n; i++) {
			a=pila1.pop();
			pila2.push(a);
		}
		for (int i = 0; i < n; i++) {
			a=pila2.pop();
			pila3.push(a);
		}
		
			System.out.print("pila 3  "+pila3);
		
		
		
	}

}


