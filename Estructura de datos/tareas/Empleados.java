
public class Empleados {
	public static void main(String[]args){
		int a[]=new int[5];
		double sum=0;
		int c=0;
		for (int i=0;i<5;i++){
			System.out.println("escribe el nombre del empleado "+(i+1));
			a[i]=Leer.datoInt();
			sum=sum+a[i];
			if (a[i]>=1250&&a[i]<=2500)
				c++;
		}
		double prom=sum/5;
		System.out.println("el salario promedio es "+prom+"\n"+c+" personas ganan entre 1250 y 2500");
	}

}
