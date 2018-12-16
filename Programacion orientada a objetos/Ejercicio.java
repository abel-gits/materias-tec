import java.util.Scanner;
public class Ejercicio {
	public static void main(String[]args) {
		System.out.println("escribe un nombre");
		Scanner leer = new Scanner(System.in);
		String [] nombre = new String[10];
		String nom=leer.nextString();
		int a=nom.length();
		Char let=' ';
		for (int s=0;s<a;s++) {
		let=nom.charAt(s);
		nombre[s]=let;
	}

		for (int i=a-1;i>=0;i--)
			System.out.println(nombre[i]);

	}
	
}