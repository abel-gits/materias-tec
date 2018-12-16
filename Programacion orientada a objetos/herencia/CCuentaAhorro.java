package HERENCIA;
class CCuentaAhorro extends CCuenta   
{
	// Atributos
	private double  cuotaMantenimiento;
	//  Métodos
	public CCuentaAhorro()  { }     // Constructor sin parámetros

	public CCuentaAhorro (String nom, String cue, double sal, double tipo, double mant)
	{
	   super(nom, cue, sal, tipo); // invoca al constructor CCuenta            
	   asignarCuotaManten(mant);  // inicia cuotaMantenimiento
	}
	public  void  asignarCuotaManten(double  cantidad)
	{
		if (cantidad  <  0)  //  Valida la Cantidad
		{
			System.out.println("Error:   cantidad negativa");
			return;
		}
		cuotaMantenimiento = cantidad;
	}
	public double obtenerCuotaManten( )
	{
		return  cuotaMantenimiento; 
	}
	public void reintegro(double cantidad)
	{
		double saldo = estado();
		double tipoDeInteres = obtenerTipoDelnteres();
		if(tipoDeInteres >= 3.5)
		{
			if(saldo - cantidad < 1500) // Valida el Saldo
			{
				System.out.println("Error: Cantidad no dispone");
				return;
			}
		}
		super.reintegro(cantidad);
	}
}
