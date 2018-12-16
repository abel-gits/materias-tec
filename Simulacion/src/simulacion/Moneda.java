package Simulacion;

import java.util.Random; 
import java.util.Scanner;
import java.text.DecimalFormat;

public class Moneda 
{
    public static void main(String args[])
    {
    	Random r = new Random();
    	Scanner leer = new Scanner(System.in);
    	DecimalFormat d = new DecimalFormat("0.00");
    	
    	System.out.println("Ingresa el numero de lanzamientos");
    		int n = leer.nextInt();
    	
    	double[ ] numeros = new double[n];
    	String[ ] tipo = new String[n];
    	
    	int cara = 0;
    	int cruz = 0;
    	
    	for (int i = 0; i < n; i++) 
    	{
    		double a = r.nextDouble();
    		numeros[i] = a;
    		
    		if( a>=0 && a<=0.5 ) {
    			cara++;
    			tipo[i] = "Cara";
    		}else {
    			cruz ++;
    			tipo[i] = "Cruz";
    		}
    		
		}
    	
    	System.out.println("N\tNumero\t"+"Tipo");
    	System.out.println("____________________");
    	for (int i = 0; i < n; i++) 
    	{
			System.out.println((i+1)+"\t"+d.format(numeros[i])+"\t"+tipo[i]);
		}
    	
    	grafica g = new grafica( cara, cruz );
    	
    }
}