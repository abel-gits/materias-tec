//este programa lee los datos de 25 alumnos e imprime el promedio de cada alumno, el promedio del grupo, 
//el total de alumnos aprobados, el porcentaje de hombres aprobados, el total de alumnos reprobados, 
//el porcentaje de mujeres reprobados, una lista con los nombres y resultado final.
public class Examen2 {
	public static void main(String[]args) {
		//declaracion de arreglos y variables
		String nombre[] = new String[25] ;
		char sexo[] = new char[25];
		int edad[] = new int[25];
		double calif[] = new double[10];
		String a=" ",b=" ",g=" ";
		int aprobados=0,reprobados=0,h=0,m=0;
		double ha=0,mr=0;
		double promg[] = new double[10];

		for (int i=0;i<=24;i++) {
			double prom=0;
			//lee datos
			System.out.println("escribe el nombre");
			nombre[i]=Keyboard.readString();
			System.out.println("escribe el sexo");
			sexo[i]=Keyboard.readChar();
			System.out.println("escribe la edad");
			edad[i]=Keyboard.readInt();
			System.out.println("escribe las diez calificaciones");
			for (int o=0;o<=9;o++) {
			calif[o]=Keyboard.readDouble();
			//calculos	
			prom=prom+calif[o];		 
		    }
		    if ((prom/10)<70) 
		    	g=g+nombre[i]+"     Na \n";
		    else 
		    g=g+nombre[i]+"     "+prom/10+"\n";
		       
		    a=a+nombre[i]+"     "+prom/10+"\n";
		    if (prom/10>=70)
		    	aprobados++;
		    if (sexo[i]=='h')
		    	h++;
		    if ((sexo[i]=='h')&(prom>=70))
		    	ha++;
		  for (int s=0;s<=9;s++)
		  	promg[s]=promg[s]+calif[s];
		  if (prom/10<70)
		  	reprobados++;
		  if (sexo[i]=='m')
		  	m++;
		  if ((sexo[i]=='m')&(prom/10<70))
		  	mr++;
		 
		}
		//imprimir resultados
		System.out.println(a);
		int n=1;
		for (int i=0;i<=9;i++) {
		b=b+n+"     "+promg[i]/25+"\n"+" ";
		n++;
	                        }
		System.out.println(b);
		System.out.println("el total de alumnos aprobados es de "+aprobados);
		System.out.println("el porcentaje de alumnos hombres aprobados es "+(ha/h)*100);
		System.out.println("el total de alumnos reprobados es "+reprobados);
		System.out.println("el porcentaje de alumnos mujeres reprobadas es "+(mr/m)*100);
		System.out.println(g);
        
	}
}