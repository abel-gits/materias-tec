import java.util.*;
public class Trapecios
{
	public static void main(String[]args)
	{
		System.out.println("Escribe el intervalo");
		Scanner leer = new Scanner(System.in);
		System.out.println("Escribe el limite a");
		double a=leer.nextDouble();
		System.out.println("Escribe el limite b");
		double b=leer.nextDouble();
		System.out.println("Escribe el numero de trapecios");
		int n=leer.nextInt();
		System.out.println("Escribe el valor de la integral");
		double vr=leer.nextDouble();
		System.out.println("Escribe el error tolerado");
		double error =leer.nextDouble();
		System.out.println("Escribe el total de calculos");
		int tc =leer.nextInt();
		int nc=1;
		do
		{
			System.out.println("Instituto tecnologico de culiacan"+"\n"+"Ingenieria en sistemas computacionales"+"\n"+"Abel Robles Montoya"+"\n"+"metodo de los trapecios"+"\n"+"horario:11-12");
			double h=(b-a)/n;
			double vc=0;
			for (int c=0;c<n ;c++ ) {
				double ah =a+h;
				double fa=3+((a*a*a)/a);
				double fah=3+((ah*ah*ah)/ah);
				double area =(h/2)*(fa+fah);
				vc=vc+area;

				System.out.println(c+"\t\t"+a+"\t\t"+fa+"\t\t"+fah+"\t\t"+area+"\t\t"+vc);
				a=ah;
			}

			System.out.println("________________________________________________________________________");
			double errorc=Math.abs(vr-vc);
			if (errorc<=error) {
				System.out.println("El area = "+vc);
				break;
			}else
			{
				if (nc==tc) {
					System.out.println("No hay aproximacion");
					break;
				}else
				{
					nc=nc+1;
					n=n*2;
				}


			}


		}while(true);
	}
}