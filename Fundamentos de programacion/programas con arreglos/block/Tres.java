//este programa lee nombre y horas trabajadas de 50 personas e 
//imprime el nomre del que trabajo menos horas
public class Tres {
	public static void main(String[]args) {
		String mf=" ";
		int a=100;
		int horas[] = new int[5];
		String nombre[] = new String[5];
		for (int i=0;i<=4;i++) {
			System.out.println("escribe el nombre");
			nombre[i]=Keyboard.readString();
			System.out.println("escribe las horas trabajadas");
			horas[i]=Keyboard.readInt();
			if (horas[i]<a)
				mf=nombre[i];
			a=horas[i];
		}
		System.out.println("el nombre del que trabajo menos horas es "+mf);
	}
}
