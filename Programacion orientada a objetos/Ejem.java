import java.util.*;
import java.util.Scanner;
public class Ejem {
	public static void main(String [] args) {
		Scanner leer = new Scanner(System.in);
		Vector v = new Vector();
		int a = 0;
		a=leer.nextInt();
		v.addElement(a);
		System.out.println(v.elementAt(0));
	}

	
}