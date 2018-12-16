public class Grupo {
	public static void main(String[]args) {
		int prom=0;
		String r=" ";
		String alumnos[] ={"juan","pedro","angel","luis","jorge","maria","arturo","lesli","ana","carlos"};
		int calificaciones[] ={90,78,100,67,80,90,90,100,56,77};
		for (int i=0;i<=9;i++) {
			prom=prom+calificaciones[i];
		}
		prom=prom/10;
		for (int i=0;i<=9;i++) {
			if (calificaciones[i]>prom)
				r=r+alumnos[i]+"\n";
		}
		System.out.println(r);
	}
}