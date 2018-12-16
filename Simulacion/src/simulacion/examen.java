package simulacion;
import java.util.*;
public class examen 
{

	public static void main(String[] args)
	{
		int  x=0, y=0;
		Random rnd=new Random();
		Scanner  leer= new Scanner(System.in);
		int sim=0;
		System.out.println("Cuantas simulaciones desea realizar? ");
		sim=leer.nextInt();
		double num=0;
		System.out.println("No. Cuadras"+"\t"+"#aleatorio"+"\t"+"Localizacion(x,y)");
		for(int i=1;i<=sim;i++)
		{
			num=rnd.nextDouble();
			if(num<=0.25)
				y++;
			else
				if(num>0.25 && num<= 0.50)
					y--;
				else
					if(num>0.50 && num<= 0.75)
						x++;
					else
						x--;
			System.out.println(num);	
				
		}
		
		int cuadrasAvanzadas;
		cuadrasAvanzadas=x+y;
		if(Math.abs(cuadrasAvanzadas)<= 2)
		{
			System.out.println("El boracho quedo a: "+Math.abs(cuadrasAvanzadas)+" cuadras");
			
		}
			
		else
			System.out.println("El borracho no quedo a menos de dos cuadras");
		
	}

}
