public class Sueldo {
	public static void main(String[]args) {
		double tsueldos=0;
		double sbruto=0,sneto=0;
		String empleado[] = {"eduardo","juan","pedro","luis","maria"};
		int horas[] = {28,43,12,54,21};
		double impuesto[] = new double[5];
		int sueldo[] = new int[5];
		for (int i=0;i<=4;i++) {
			if (horas[i]<=40)
				sueldo[i]=40*15;
			if (horas[i]>40)
				sueldo[i]=sueldo[i]+((horas[i]-40)*20);
			sbruto=sueldo[i];
			impuesto[i]=sueldo[i]*0.06;
			sneto=sbruto-impuesto[i];
			System.out.println(empleado[i]+"  "+horas[i]+"  "+sbruto+"  "+impuesto[i]+"  "+sneto);
		}
	}
}