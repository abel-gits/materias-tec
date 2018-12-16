//este programa lee nombre y horas trabajadas de 50 personas e
//imprime el salario para cada uno
public class Dos {
	public static void main(String[]args) {
	String nom[] = new String [5];
	int horas[] = new int [5];
	int salario[] = new int [5];
	for (int i=0;i<=5-1;i++) {
	   System.out.println("escribe el nombre");
	   nom[i]=Keyboard.readString();
 	   System.out.println("escribe las horas trabajadas");
 	   horas[i]=Keyboard.readInt();
 	   salario[i]=15*horas[i];
	  }
	  for (int d=0;d<=4;d++)
	  System.out.println("el salario de "+nom[d]+"= "+salario[d]+" pesos\n");

	}
}