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
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NewmanYMedios 
{
	static int contador1=0;

	public static void main(String[] args) 
	{
		ArrayList<Long> vector1 = new ArrayList<Long>();
		Scanner Leer= new Scanner(System.in);
		int n,n2,opc1,opc2;
		String sigue1,sigue2;
		do
		{
			opc1=menu1();
			if(opc1==0)
			{
				System.out.println("Programa Terminado");
				System.exit(0);
			}
			switch(opc1)
			{
				case 1:	
					do
					{
						opc2=menu2();
						if(opc2==0)
						{
							main(args);
						}
							
						switch(opc2)
						{
							case 1:	
									long valor = xTecladoMediosCuadrados();
									System.out.println("MEDIOS CUADRADOS");
									System.out.println("Numero\t Semilla\t Semilla Cuadrada");
									mediosCuadrados(valor,vector1);
									contador1=0;
									vector1.clear();
									System.out.println("Oprima un enter para continuar");
									sigue1=Leer.nextLine();
									break;
							case 2:
									long valor2 = generarRandom4Dec();
									System.out.println("MEDIOS CUADRADOS");
									System.out.println("Numero\t Semilla\t Semilla Cuadrada");
									mediosCuadrados(valor2,vector1);
									contador1=0;
									vector1.clear();
									System.out.println("Oprima un enter para continuar");
									sigue1=Leer.nextLine();
									break;
						}		
					}while(true);
					
					
				case 2:
					do
					{
						opc2=menu2();
						if(opc2==0)
						{
							main(args);
						}
						switch(opc2)
						{
							case 1:	
									long valor = xTecladoNewman();
									System.out.println("NEWMAN");
									System.out.println("Numero\t Semilla\t Semilla Cuadrada");
									newman(valor,vector1);
									contador1=0;
									vector1.clear();
									System.out.println("Oprima un enter para continuar");
									sigue1=Leer.nextLine();
									break;
							case 2:
									long valor2 = generarRandom10Dec();
									System.out.println("NEWMAN");
									System.out.println("Numero\t Semilla\t Semilla Cuadrada");
									newman(valor2,vector1);
									contador1=0;
									vector1.clear();
									System.out.println("Oprima un enter para continuar");
									sigue1=Leer.nextLine();
									break;
						}		
					}while(true);
			}		
		}while(true);
	}
	
	public static void newman(long semilla,ArrayList<Long> vector)
	{
		String semillaCuadrada=String.valueOf(semilla * semilla);
		int parImpar = (int) (semillaCuadrada.length()%2);
		int nuevaSemilla=0;
		int aux2;
		String aux;
		
		contador1++;
		vector.add(semilla);
		System.out.println(Formatea.alinder("00000",contador1)+"\t  "+Formatea.alinder("00000",semilla)+"\t\t"+Formatea.alinder("0",Long.valueOf(semillaCuadrada)));
		
		if(semilla==0)
		{
			System.out.println("Se volvio cero");
			return;
		}
		
		if(seRepite(semilla,vector))
		{
			System.out.println("Se repitio el numero  "+semilla);
			return;
		}
		
		if(parImpar==0)
			semillaCuadrada='0'+semillaCuadrada;
		
		aux2=semillaCuadrada.length()/2;
		aux=semillaCuadrada.substring(0+(aux2-2),semillaCuadrada.length()-(aux2-2));
		nuevaSemilla=Integer.valueOf(aux);
		
		newman(nuevaSemilla,vector);
	}
	
	public static void mediosCuadrados(Long semilla,ArrayList<Long> vector)
	{
		String semillaCuadrada=String.valueOf(semilla * semilla);
		Long nuevaSemilla;
		String aux;
		contador1++;
		vector.add(semilla);
		System.out.println(Formatea.alinder("00000",contador1)+"\t  "+Formatea.alinder("0000",semilla)+"\t\t"+Formatea.alinder("0",Long.valueOf(semillaCuadrada)));
		
		if(semilla==0)
		{
			System.out.println("Se volvio cero");
			return;
		}
		
		if(seRepite(semilla,vector))
		{
			System.out.println("Se repitio el numero  "+semilla);
			return;
		}
		
		if(semillaCuadrada.length()<8)
			for(int i=semillaCuadrada.length(); i<8;i++)
				semillaCuadrada='0'+semillaCuadrada;
		   
		aux=semillaCuadrada.substring(2,6);
		nuevaSemilla=Long.valueOf(aux);
		
		
		mediosCuadrados(nuevaSemilla,vector);
	}
	
	private static boolean seRepite(long semilla,ArrayList<Long> vector) 
	{
		int contador=0;
		for(int x=0;x < vector.size();x++) 
			 if(semilla == vector.get(x))
				 contador++;
		
		if(contador>1)
			return true;
		
		return false;
	}
	
	public static long xTecladoMediosCuadrados()
	{
		Scanner leer = new Scanner(System.in);
		long valor=0;
		String aux;
		do
		{		     
			System.out.println("Dame un valor");
			valor= leer.nextLong();
			aux=String.valueOf(valor);
		}
		while(aux.length()!=4);
		return valor;
	}

	public static long xTecladoNewman()
	{
		Scanner leer = new Scanner(System.in);
		long valor=0;
		String aux;
		do
		{		     
			System.out.println("Dame un valor");
			valor= leer.nextLong();
			aux=String.valueOf(valor);
		}
		while(aux.length()!=10);
		return valor;
	}
	public static long generarRandom10Dec()
	{
		Random aleatorio = new Random();
		long valor=(long) ((aleatorio.nextDouble()*(9999999999L-1000000000L+1)+1000000000L));
		return valor;
	}
	
	public static long generarRandom4Dec()
	{
		Random aleatorio = new Random();
		long valor=(long) ((aleatorio.nextDouble()*(9999L-1000L+1)+1000L));
		return valor;
	}public static int menu1() 
	{
		int opc;
		Scanner Leer= new Scanner(System.in);
		do
		{
			System.out.println();
			System.out.println("0.Salir");
			System.out.println("1.Medios Cuadrados");
			System.out.println("2.Newman");
			System.out.println();
			System.out.println("Seleccione su opcion:");
			opc=Leer.nextInt();
		}while(opc<0 || opc> 2);
		return opc;
	}
	
	public static int menu2() 
	{
		int opc;
		Scanner Leer= new Scanner(System.in);
		do
		{
			System.out.println();
			System.out.println("0.Regresar");
			System.out.println("1.Por Teclado");
			System.out.println("2.Numero Aleatorio");
			System.out.println();
			System.out.println("Seleccione su opcion:");
			opc=Leer.nextInt();
		}while(opc<0 || opc> 2);
		return opc;
	}
	
	static class Formatea 
	{
		static public String local(double dato)
		{
			NumberFormat formato=NumberFormat.getCurrencyInstance();
			String salida=formato.format(dato);
			return salida;
		}
		
		static public String person(String patron, double dato)
		{
			DecimalFormat formato= new DecimalFormat(patron);
			String salida=formato.format(dato);
			return salida;
		}
		
		static public StringBuffer alinder(String patron, double dato)
		{
			FieldPosition fp=new FieldPosition(NumberFormat.FRACTION_FIELD);
			DecimalFormat formato= new DecimalFormat(patron);
			StringBuffer salida=new StringBuffer();
			formato.format(dato,salida,fp);
		
			for (int i=0; i< (patron.length()-fp.getEndIndex()); i++)
				salida.insert(0,' ');
			return salida;
		}
	}
	
}
