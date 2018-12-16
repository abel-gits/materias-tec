package POLIMORFISMO;

public class Triangulo extends Figura2D implements Rebotable, Redimensionable
{
	private int Base;
	private int Altura;
	
	public Triangulo()
	{ }

	public Triangulo(String N, int C, int G, int base, int altura) 
	{
		super(N, C, G);
		Base = base;
		Altura = altura;
	}

	public int getBase() {
		return Base;
	}

	public void setBase(int base) {
		Base = base;
	}

	public int getAltura() {
		return Altura;
	}

	public void setAltura(int altura) {
		Altura = altura;
	}

	// METODOS ABSTRACTOS
	public void dibujar() 
    {
        System.out.println("El método para dibujar este TRIANGULO aún está por definirse.");
    }
	public int calcularArea() 
    {
        int area = (Base*Altura)/2;
        return area;
    }
    public int calcularPerimetro() 
    {
        int perimetro = Base+(Altura*2);
        return perimetro;
    }
	// INTERFACES
    public void rebotar() 
    {
        System.out.println("El TRIANGULO ha dado un rebote.");
    }
	public void aumentarTamano(double porcentaje) 
    {
       System.out.println("BASE ACTUAL "+Base);
    	Base = (int) (Base+(Base*porcentaje));
    	 System.out.println("BASE AUMENTADA "+porcentaje+"% = "+Base);
    }

  
	public void reducirTamano(double porcentaje) 
    {
    	System.out.println("ALTURA ACTUAL "+Altura);
    	Altura = (int) (Altura-(Altura*porcentaje));
    	 System.out.println("ALTURA REDUCIDA "+porcentaje+"% = "+Altura);
    }
}
