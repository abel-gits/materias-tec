package POLIMORFISMO;

public abstract class Figura2D extends Figura 
{
	public Figura2D(String N, int C, int G)
	{
		super(N,C,G);
	}
	public Figura2D()
	{ }
	public abstract int calcularArea();

	public abstract int calcularPerimetro();
}
