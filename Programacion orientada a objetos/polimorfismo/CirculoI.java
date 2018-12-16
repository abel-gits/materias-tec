package POLIMORFISMO;

public class CirculoI extends Figura2D implements Rebotable, Redimensionable
{
     private int radio;
     
     public CirculoI()
     {  }

    public CirculoI(String N,int C, int G,int radio) 
    {
        super(N,C,G);
    	this.radio = radio;
    }
    public int getRadio() 
    {
        return radio;
    }
    public void setRadio(int radio) 
    {
        this.radio = radio;
    }
 // METODOS ABSTRACTOS
    public int calcularArea() 
    {
        double area = Math.pow(Math.PI * radio, 2);
        return (int) area; //Se castea el area a int
    }
    public int calcularPerimetro() 
    {
        double perimetro = (2*radio)*Math.PI;
        return (int) perimetro;//Se castea el area a int
    }
    public void dibujar() 
    {
        System.out.println("El método para dibujar este CIRCULO aún está por definirse.");
    }
 // INTERFACES
    public void rebotar() 
    {
        System.out.println("El CIRCULO ha dado un rebote.");
    }
    public void aumentarTamano(double porcentaje) 
    {
    	System.out.println("RADIO ACTUAL "+radio);
    	radio = (int) (radio+(radio*porcentaje));
        System.out.println("RADIO AUMENTADO "+porcentaje+"% = "+radio);
    }

    public void reducirTamano(double porcentaje) 
    {
    	System.out.println("RADIO ACTUAL "+radio);
    	radio = (int) (radio-(radio*porcentaje));
    	 System.out.println("RADIO REDUCIDO "+porcentaje+"% = "+radio);
    }
    
}
