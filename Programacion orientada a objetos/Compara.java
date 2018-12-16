package FUNCIONES;

import HERENCIA.Leer;

public class Compara 
{

	public static void main(String[] args) 
	{
		String S1="MUJERES QUE CURAN";
		String S2="MUJERES ASESINAS";
		String S3="MUJERCITAS";
		String S4="MEJORES PRACTICAS";
		String S5="MIS CLAIROL";
		
		String F="";
		System.out.println(S1);
		System.out.println(S2);
		System.out.println(S3);
		System.out.println(S4);
		System.out.println(S5);
		 
			System.out.print("ESCRIBE LA FRASE A BUSCAR ");
			F=Leer.dato();
			if(F.regionMatches( 0,S1,0,F.length()))
				System.out.println("LOS PRIMEROS "+F.length()+" CARACTERES SON IGUALES de "+S1);
			else
				System.out.println("NO FUERON IGUALES");
			if(F.regionMatches(true,0,S2,0,F.length()))
				System.out.println("LOS PRIMEROS "+F.length()+" CARACTERES SON IGUALES de "+S2);
			else
				System.out.println("NO FUERON IGUALES");
			if(F.regionMatches(true,0,S3,0,F.length()))
				System.out.println("LOS PRIMEROS "+F.length()+" CARACTERES SON IGUALES de "+S3);
			else
				System.out.println("LOS CARACTERES  NO FUERON IGUALES");
			if(F.regionMatches(true,0,S4,0,F.length()))
				System.out.println("LOS PRIMEROS "+F.length()+" CARACTERES SON IGUALES de "+S4);
			else
				System.out.println("LOS CARACTERES  NO FUERON IGUALES");
			if(F.regionMatches(true,0,S5,0,F.length()))
				System.out.println("LOS PRIMEROS "+F.length()+" CARACTERES SON IGUALES de "+S5);
			else
				System.out.println("LOS CARACTERES  NO FUERON IGUALES");
			System.out.println();
				
		  
	}

}
