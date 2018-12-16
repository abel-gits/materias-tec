package Colas;
import java.*;
import java.util.Random;
public class Bicolas {

	public static void main(String[] args) {
		int n;
		int m;
		System.out.println("Inserte N");
		n=Leer.datoInt();
		do {
		System.out.println("Inserte M(tiene que ser menor que n)");
		m=Leer.datoInt();
		}while(n<m);
		Cola1 cola1 = new Cola1(n);
		Cola1 cola2 = new Cola1(m);
		Cola1 cola3 = new Cola1(n);
		int k=1;
		Llena_cola1(cola1,n,k);
		k++;
		Llena_cola1(cola2,m,k);
		
		suma(cola1,cola2,cola3,n,m);
		System.out.print("cola "+3+"          ");
		for (int i = 0; i < n; i++) {
			System.out.print(cola3.Mostrar()+"   ");
		}
		

		
	}
	
	public static void Llena_cola1(Cola1 c, int n,int k)
	{
	 int a=0;
	 System.out.print("cola "+k+"          ");
		for (int i = 0; i < n; i++) {
			a=(int) (Math.random()*9+0);
			c.Insertar_Cola(a);
			System.out.print(a+"   ");
		}
		System.out.println();
		
	}
	public static void suma(Cola1 cola1,Cola1 cola2,Cola1 cola3,int n,int m){
		int b=0,d=0;
		for (int i = 0; i <m ; i++) {
			int a=cola1.Mostrar()+cola2.Mostrar();
			d=verifica(a,cola3,d);
			}
		
		for (int i = 0; i < n-m; i++) {
			cola3.Insertar_Cola(cola1.Mostrar()+d);
			d=0;

		}
		
		}

	public static int verifica(int a,Cola1 cola3,int d){
		int b;
		a=a+d;
		if (a>9) {
			String cad="";
			cad=String.valueOf(a);
			String f=cad.substring(1);
			b=Integer.parseInt(f);
			cola3.Insertar_Cola(b);
			d=1;
			return d;
		}
		else{
			cola3.Insertar_Cola(a);
			d=0;
			return d;
			}
		
	}

}

	