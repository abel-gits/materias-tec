package POLIMORFISMO;

public class CuadradoI extends Figura2D implements Rebotable, Redimensionable
{
    private int lado;

    public CuadradoI()
    { }
    public CuadradoI(String N, int C, int G, int lado) 
    {
        super(N,C,G);
    	this.lado = lado;
    }
    public int getLado() 
    {
        return lado;
    }
    public void setLado(int lado) 
    {
        this.lado = lado;
    }
    // METODOS ABSTRACTOS
    public int calcularArea() 
    {
        int area = lado*lado;
        return area;
    }
    public int calcularPerimetro() 
    {
        int perimetro = lado*4;
        return perimetro;
    }
    public void dibujar() 
    {
        System.out.println("El método para dibujar este CUADRADO aún está por definirse.");
    }
    // INTERFACES
    public void rebotar() 
    {
        System.out.println("El CUADRADO ha dado un rebote.");
    }

    public void aumentarTamano(double porcentaje) 
    {
       System.out.println("LADO ACTUAL "+lado);
    	lado = (int) (lado+(lado*porcentaje));
    	 System.out.println("LADO AUMENTADO "+porcentaje+"% = "+lado);
    }

    public void reducirTamano(double porcentaje) 
    {
    	System.out.println("LADO ACTUAL "+lado);
    	lado = (int) (lado-(lado*porcentaje));
    	 System.out.println("LADO REDUCIDO "+porcentaje+"% = "+lado);
    }

}
