package HERENCIA;

public abstract class  CCuenta 
{
		private String nombre;
		private String cuenta;
		private double saldo;
		private double tipoDeinteres; 
		public CCuenta() {}
		public CCuenta(String nom, String cue, double sal, double tipo)
		{
			asignarNombre(nom);
			asignarCuenta(cue);
			ingreso(sal);
			asignarTipoDeinteres(tipo);
		}
		public  void asignarNombre(String nom) 
		{ 
		     if (nom.length()== 0)
		     {
		          System.out.println("Error:  cadena vacia");
		          return; 
		      }
		        nombre = nom; 
		}
		public String obtenerNombre()
		{
			return nombre;
		}
		public void asignarCuenta(String cue) 
		{ 
			if (cue.length() == 0) 
			{
				System.out.println("Error: cuenta no válida"); 
				return;
			}
			cuenta = cue;
		 }
		public String obtenerCuenta() 
		{
			return cuenta;
		}
		public double estado()
		{
			return  saldo;
		}
		public void ingreso(double cantidad) 
		{
		 if (cantidad < 0)
		 	{ 
			 System.out.println("Error: Cantidad negativa"); 
			 return; 
		 	}
		 	saldo = saldo + cantidad; 
		}
		public void reintegro(double cantidad)
		{
			if(saldo - cantidad < 0)
			{
				System.out.println("Error: Saldo no disponible");
				return;
			}
			saldo=saldo - cantidad;
		}
		public void asignarTipoDeinteres(double tipo)
		 { 
			if (tipo < 0)
			{ 
				System.out.println("Error: tipo Interes no válido");
				return;
			}
			tipoDeinteres = tipo;
		}
		public double obtenerTipoDelnteres()
		 {
			return  tipoDeinteres;
		 }
}
