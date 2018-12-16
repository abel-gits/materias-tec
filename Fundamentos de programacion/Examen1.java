//este programa lee la cantidad de usuarios, telefonos y llamadas y calcula el costo, iva y el total a pagar 
import java.util.Arrays;
public class Examen1 {
	public static void main(String[]args) {
		String r="Nombre          Telefono          llamadas          Costo          Iva          Total \n";
		//crea los arreglos nesesarios para el programa
		System.out.println("escribe la cantidad de usuarios");
		int u=Keyboard.readInt();
		String nombres[] = new String[u]; 
		String numero[] = new String[u];
		int nllamadas[] = new int[u];
		double costo[] = new double[u];
		double iva[] = new double[u];
		double total[] = new double[u];
		String onombres[] = new String[u];
		//leer los datos (nombre,telefono,llamadas)
		for (int i=0;i<=u-1;i++ ) {
			System.out.println("escribe el nombre");
			nombres[i]=Keyboard.readString();
			System.out.println("escribe el numero de telefono");
			numero[i]=Keyboard.readString();
			System.out.println("escribe el total de llamadas");
			nllamadas[i]=Keyboard.readInt();
		}
		//calcula el costo, iva y total
		for (int i=0;i<=u-1;i++) {
			if (nllamadas[i]<=100) {
				costo[i]=150;
				iva[i]=150*0.16;
				total[i]=iva[i]+costo[i];
			}
			else {
				costo[i]= ((nllamadas[i]-100)*1.50)+150;
				iva[i]=costo[i]*0.16;
				total[i]=iva[i]+costo[i];
         
			}

		}
		//crea una copia del arreglo donde se almacenaron los nombres
		for (int i=0;i<=u-1;i++) {
			System.arraycopy(nombres,0,onombres,0,u);
		}
		//ordena los nombres alabeticamente
		Arrays.sort(nombres);
		//guarda los datos de costo, iva y total en el nombre que le corresponde
		for (int i=0;i<=u-1;i++) {
			for (int a=0;a<=u-1;a++) {
				if(nombres[i].equals(onombres[a])) {
					r=r+nombres[i]+"          "+numero[a]+"          "+nllamadas[a]+"          $"+costo[a]+"          $"+iva[a]+"          $"+total[a]+"\n";
					
				}
			}
		}
		//imprime los resultados
		System.out.println(r);
		
	}
}