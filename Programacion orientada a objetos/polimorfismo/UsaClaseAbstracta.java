package POLIMORFISMO;
import HERENCIA.Leer;
public class UsaClaseAbstracta 
{
	public static void main(String[] args) 
	{
		int SN=0, F=0;
		CuadradoI Cua=new CuadradoI();
		CirculoI Cir=new CirculoI();
		do
		{
			
			do
			{
				System.out.print("SELECCIONE UNA FIGURA (1=CUADRADO, 2=CIRCULO ");
				F=Leer.datoInt();
			}while(F<1 || F>2);
			
			switch (F)
			{
				case 1:
					System.out.print("LONGITUD DE LADO DEL CUADRADO ");
					int Lado=Leer.datoInt();
		
					Cua=new CuadradoI("CUADRADO",1,10,Lado); // CREA OBJETO CUADRADO
					
					System.out.println();
					System.out.println("ESTOS SON LOS DATOS DE LAS FIGURAS");
					System.out.println();
					Cua.rebotar();     		 	// Interface Rebotar
					Imprime(Cua);				// Imprime Cuadrado
					Cua.aumentarTamano(0.50);	// Interface
					Cua.reducirTamano(0.50);	// Interface
					break;
					
				case 2:
					System.out.print("LONGITUD DEL RADIO PARA EL CIRCULO ");
					int Radio=Leer.datoInt();
					Cir=new CirculoI("CIRCULO",2,5,Radio); // CREA OBJETO CIRCULO
					
					System.out.println();
					System.out.println("ESTOS SON LOS DATOS DE LAS FIGURAS");
					System.out.println();
					
					Cir.rebotar();     		 	// Interface Rebotar
					ImprimeC(Cir);
					Cir.aumentarTamano(0.50);	// Interface
					Cir.reducirTamano(0.50);	// Interface
					break;
			}
			System.out.println();
			System.out.println("ESTOS SON LOS DATOS DE LAS FIGURAS");
			System.out.println();
			
						
			System.out.print("DESEA CREAR OTRO OBJETO? 1=SI, 2=NO ");
			do
			{
				SN=Leer.datoInt();
			}while(SN<1||SN>2);
			System.out.println();
		}while(SN==1);
	}
		public static void Imprime(CuadradoI Cua)
		{
			System.out.println("NOMBRE: "+Cua.getNombre()+".  COLOR NUMERO "+Cua.getColor()+".  GROSOR DEL BORDE ES "+Cua.getGrosorBorde());
			System.out.println("SU AREA ES = "+Cua.calcularArea()+" Y SU PERIMETRO = "+Cua.calcularPerimetro());
			Cua.dibujar();
		}
		public static void ImprimeC(CirculoI Cir)
		{
			System.out.println();
			System.out.println("NOMBRE: "+Cir.getNombre()+".  COLOR NUMERO "+Cir.getColor()+".  GROSOR DEL BORDE ES "+Cir.getGrosorBorde());
			System.out.println("SU AREA ES = "+Cir.calcularArea()+" Y SU PERIMETRO = "+Cir.calcularPerimetro());
			Cir.dibujar();
		}
}
