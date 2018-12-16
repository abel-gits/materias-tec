package VARIOS;

public class NumString 
{
	/* LEE UN NUMERO COMO STRING Y USANDO SUBSTRING HACE LO SIGUIENTE:
		Determina cuantos digitos tiene el numero
		Valida el Rango 
		Imprime la SUMA de sus Digitos
		Imprime el Numero Invertido
	 */
	public static void main(String[] args) 
	{
		String Num="",  NumI="";
		String Cifra, NumS;
		int Suma=0, N=0;

		do				// VALIDA EL RANGO DE NUMEROS A INGRESAR
		{
			System.out.print("ESCRIBE UN NUMERO (1000-50000) ");
			Num=Leer.dato();			// LEE EL DATO COMO STRING
			N=Integer.parseInt(Num);	// CONVIERTE EL STRING EN NUMERO
		}while(N<1000 || N >50000);
		int Lon=Num.length();			// DETERMINA CUANTOS DIGITOS TIENE EL NUMERO

		N=0;
		NumS=Num+" ";
		System.out.println("Lon="+Lon);
		for(int i = Lon; i >0; i--)		// RECORRE LA CADENA EN FORMA INVERTIDA
		{	
			Cifra=NumS.substring(i-1,i); //  CADENA.substring (int Posicion Inicial, int Posicion Final)
			System.out.println("Cifra("+(i-1)+","+i+")="+Cifra);//  La Posicion Final Queda Excluida del Substring
			N=(Integer.parseInt(Cifra));	// CONVIERTE EL SUBSTRING EN NUMERO PARA SUMARLO
			Suma=Suma+N; // REALIZA LA SUMA
			System.out.println("SUMA="+Suma);
			NumI=NumI+Cifra;			// CONCATENA LOS DIGITOS INVIRTIENDOLOS
			System.out.println("NumI="+NumI);
		}
		System.out.println();
		System.out.println("El Numero "+Num+" Tiene "+Lon+" Cifras");
		System.out.println("LA SUMA ES = "+Suma);
		System.out.println("EL NUMERO INVERTIDO ES "+NumI);
	}
}
