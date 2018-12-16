package HERENCIA;

public class UsaCuentas 
{
	public static void main(String[] args) 
	{
		System.out.print("Nombre: ");
		String N = Leer.dato();
		System.out.print("Cuenta: ");
		String C = Leer.dato();
		System.out.print("Saldo: ");
		double S = Leer.datoDouble();
		System.out.print("Tipo ( 2.5, 4.0, etc.): "); // Porcentaje 
		double T = Leer.datoDouble();
		System.out.print("Cuota (0.40, 0.60, etc.): ");// Porcentaje 
		double M = Leer.datoDouble();

		CCuentaAhorro cuenta0l=new CCuentaAhorro(N,C,S,T,M); 
		//  Cobrar cuota  de mantenimiento
		cuenta0l.reintegro(cuenta0l.obtenerCuotaManten()); //   Ingreso
		System.out.print("Importe Ingreso: ");// cantidad ( 5000, 8000, etc.)
		double I = Leer.datoDouble();
		cuenta0l.ingreso(I);
		//  Reintegro
		System.out.print("Cantidad Reintegrada: ");// cantidad ( 3000, 2000, etc.)
		double R = Leer.datoDouble();
		cuenta0l.reintegro(R); //   ...
	System.out.println(cuenta0l.obtenerNombre()); 
	System.out.println(cuenta0l.obtenerCuenta());
	 System.out.println(cuenta0l.estado()); 
	System.out.println(cuenta0l.obtenerTipoDelnteres());
	}
}
