/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

/**
 *
 * @author Diego Mendez
 */

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Congruencias {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		Random rn = new Random();
                int opcs=0;
                int x=0;
		do {
			System.out.println("X(0)");
			System.out.println("Opc 1: Al azar");			
			System.out.println("Opc 2: Numero por teclado");
			opcs=leer.nextInt();
			if (opcs==1) {
				
                                x=rn.nextInt(10)+1;            
                                System.out.println("X(0)= "+x);
			}else 
				if (opcs==2) 
					x=leer.nextInt();
					System.out.println("X(0) = "+x);
				
		} while (opcs!=1&&opcs!=2);
		
		int a=0;
		do {
			do {
				System.out.println("Teclea -a-\nDeber ser un numero entero impar no divisible entre 3 o 5:");
				a=leer.nextInt();
			} while (a%2==0);			
		} while (a%3==0||a%5==0);
		int c=0;
		do {
			do {
				System.out.println("Teclea C \nDebe ser un numero entero impar donde C Mod 8 = 5:");
				c=leer.nextInt();				
			} while (c%2==0);
		} while (c%8!=5);
		int opc=0,m=0;
		do {
			System.out.println("Seleccion del Modulo M:");
			System.out.println("Opc 1: Al azar");			
			System.out.println("Opc 2: Numero primo mas grande < p^d-1\np=base del sistema(binario)\nd=numero de bits que contiene una palabra de computadora(16 bits)");
			opc=leer.nextInt();
			if (opc==1) {
				m=rn.nextInt(100)+1;
				System.out.println("M = "+m);
			}else 
				if (opc==2) {
					m=NumPrimoMax();
					System.out.println("M = "+m);
				}
		} while (opc!=1&&opc!=2);
		
		int i=0;
		Vector xn = new Vector();
		xn.addElement(x);
		int num=0,n1=0,n2=0;
		boolean p=true;
		System.out.println("N"+"\t\t"+"XN"+"\t\t"+"axn+c"+"\t\t"+"(axn+c)/m"+"\t\t"+"xn+1");
		do {
			num=(int) xn.elementAt(i);
			n1=(a*num)+c;
			n2=n1%m;
			System.out.println(i+"\t\t"+num+"\t\t"+(a*num+c)+"\t\t"+n1+"/"+m+"\t\t\t"+n2);			
			for (int j = 0; j < xn.size(); j++) {
				if (n2==(int)xn.elementAt(j)) {					
					p=false;
				}
			}
			xn.addElement(n2);
			i++;
			
		} while (p);
		System.out.println("X(0)= "+x);
		
		
		
	}
	public static int NumPrimoMax(){
		int p=(int)Math.pow(2,15);
		int div=0;
		int x=p;
		for (int i = 0; i < p; i++) {
			div=divisores(x);
			if (div==2) {
				break;
			}else {
				x--;
			}
			
		}
		return x;
	}
	public static int divisores(int x){
		int div=0;
		for (int i = 0; i < x; i++) {
			if (x%(i+1)==0) {
				div++;
			}
		}
		return div;
	}


}
