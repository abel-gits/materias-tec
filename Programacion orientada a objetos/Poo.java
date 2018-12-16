import java.util.*;
import java.util.Scanner;
public class Poo {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		Vector pvector = new Vector();
		Vector ivector = new Vector();
		System.out.println("escribe numeros enteros");
		for (int i=0;i<=4;i++) {
		int a=0;
		a=leer.nextInt();
		if (a%2==0)
			pvector.addElement(a);
		else 
			ivector.addElement(a);
		}
		for (int n=0;n<pvector.size();n++) {
			System.out.println(pvector.elementAt(n));
		}
		for (int s=0;s<ivector.size() ;s++ ) {
			System.out.println(ivector.elementAt(s));
			
		}
		

	}
}