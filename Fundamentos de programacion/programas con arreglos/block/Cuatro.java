//este programa lee el nombre y horas trabajadas de 50personas e imprime
//la posicion de la persona que trabajo mas horas
public class Cuatro {
	public static void main(String[]args) {
		int may=0,p=0;
	int horas[] = new int [50];
	String nombre[] = new String[50];
	for (int i=0;i<=49;i++) {
			System.out.println("escribe el nombre");
			nombre[i]=Keyboard.readString();
			System.out.println("escribe las horas trabajadas");
			horas[i]=Keyboard.readInt();
			if (horas[i]>may) {  
				may=horas[i];
				p=i;
			}
				

	    
	}
	System.out.println("la posision del trabajador con mayor numero de horas es "+p);
	}
	
}