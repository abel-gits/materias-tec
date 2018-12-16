public class Alumno {
	public static void main(String[]args) {
		String nombre[] = new String [5];
		char sexo=' ';
		int cm=0,s=-1,pmujeres=0,m=0,ma=0,h=0,ha=0,pha=0;
		double prom=0;
		String nm=" ",lh="Lista de los hombres \n ",lm="Lista de las mujeres \n  ",laa="Listado de alumnos aprobados \n";
		int calif=0;
		for (int i=0;i<5;i++) {
			System.out.println("escibe el nombre");
			nombre[i]=Keyboard.readString();
			System.out.println("escribe el sexo");
			sexo=Keyboard.readChar();
			System.out.println("escribe la calificacion");
			calif=Keyboard.readInt();
			prom=prom+calif;
			if (calif>s) {
				nm=nombre[i];
				s=calif;
			}
			if (sexo=='m') {
				pmujeres=pmujeres+calif;
				m++;
				lm=lm+nombre[i]+"  ";
			}
			if ((sexo=='m')&(calif>=70)) {
				ma++;
			}
			if (sexo=='h') {
				h++;
				lh=lh+nombre[i]+"  ";
			}
				
			if ((sexo=='h')&(calif>=70))
				ha++;
			if (calif>=70)
				laa=laa+nombre[i]+"  ";

		}
		prom=prom/5;
		if (m>0) {
		pmujeres=pmujeres/m;
				}
		else
			pmujeres=0;	
        if (h>0)
		 pha=(ha/h)*100;
	    else
	    	pha=0;
		System.out.println("el alumno con calificacion mayor es "+nm+"\n"+"el promedio del grupo es "+prom+"\n"+"el promedio de las mujeres es "+pmujeres);
		System.out.println("el numero de mujeres con calificacion aprobada es "+ma+"\n"+"el porcentaje de los hombres aprobados es "+pha);
		System.out.println(lh+"\n"+lm+"\n"+laa);
	}
}