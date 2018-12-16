package POLIMORFISMO;
public abstract class Figura 
{
    protected String nombre;
    protected int color;
    protected int grosorBorde;
    
    public Figura()
    {}
    public Figura(String nombre, int color, int grosorBorde)
    {
    	this.nombre=nombre;
    	this.color=color;
    	this.grosorBorde=grosorBorde;
    }
    public String getNombre() 
    {
        return this.nombre;
    }
    public void setNombre(String n) 
    {
        this.nombre = n;
    }
    public int getColor() 
    {
        return this.color;
    }
    public void setColor(int c) 
    {
        this.color = c;
    }
    public int getGrosorBorde() 
    {
        return this.grosorBorde;
    }
    public void setGrosorBorde(int g) 
    {
        this.grosorBorde = g;
    }
    public abstract void dibujar();
    
    public abstract int calcularArea();

	public abstract int calcularPerimetro();

}
