import java.util.Scanner;
public class Trabajadores {
	public static void main(String [] args) {
		System.out.println("cuantos vendedores son?");
		Scanner leer = new Scanner(System.in);
		int v=0;
		Vector v = new Vector();
		Vector n = new Vector();
		v=leer.nextInt();
		int l=0;
		for (int i=0; i<=v-1; i++) {
			String nom=" "; int ven=0;
				System.out.println("escribe el nombre del vendeodor");
				nom=leer.nextLine();
				n.addElement(nom,i++);

			System.out.println("cuantas ventas vas a escribir");
			int s=0;
			s=leer.nextInt();
			do
			{
				
				

				System.out.println("escribe la cantidad de ventas");
				ven=leer.nextInt();
				v.addElement(ven,i++);
				l++;

			}while(l<=s);
		}
		for(int c=0;c<=v-1;c++) {
		System.out.println("ventas de "+n.elementAt(c++)+"  es  "+v.elementAt());
		}
	}
}