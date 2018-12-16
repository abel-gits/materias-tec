package FUNCIONES;
import HERENCIA.Leer;
public class Cadenas 
{
	public static void main(String[] args) 
	{
		String S="";
		int D=0, L=0, P=0;
		System.out.print("ESCRIBE UN TEXTO ");
		S=Leer.dato();
		
		P=Palabras("este es un ejemplo de parametros");
		D=Numeros(S);
		Letrass(S);
		
		//System.out.println("SE ENCONTRARON "+L+" LETRAS");
		System.out.println("SE ENCONTRARON "+D+" NUMEROS");
		System.out.println("SE ENCONTRARON "+(P+1)+" PALABRAS");
	}
	public static int Palabras(String S)
	{
		int Palabra=0;
		for(int k=0;k<S.length();k++)
		{
			if(S.charAt(k)==32)
				Palabra++;
		}
		return Palabra;
	}
	public static void Letrass(String S)
	{
		int Letra=0;
		for(int k=0;k<S.length();k++)
		{
			if((S.charAt(k)>=65 && S.charAt(k)<=90) || (S.charAt(k)>=97 && S.charAt(k)<=122))
				Letra++;
		}
		System.out.println("SE ENCONTRARON "+Letra+" LETRAS");
	}
	public static int Numeros(String C)
	{
		int Digitos=0;
		for(int k=0;k<C.length();k++)
		{
			if((C.charAt(k)>47&& C.charAt(k)<58))
				Digitos ++;
		}
		return Digitos;
	}

}
