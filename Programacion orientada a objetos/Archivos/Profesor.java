package Archivos;
import java.io.Serializable;

public class Profesor extends persona implements Serializable
{
	private int sueldo;
	private int tipo;
	private int especialidad;
	
	public Profesor() 
	{
		
	}
	public Profesor(String nombre, int edad, String Sexo, int Sdo, int tipo, int esp) 
	{
		super(nombre, edad, Sexo);
		sueldo=Sdo;
		this.tipo=tipo;
		especialidad=esp;
	}
	public int getSueldo() 
	{
		return sueldo;
	}
	public void setSueldo(int sueldo) 
	{
		this.sueldo = sueldo;
	}
	public int getTipo() 
	{
		return tipo;
	}
	public void setTipo(int tipo) 
	{
		this.tipo = tipo;
	}
	public int getEspecialidad() 
	{
		return especialidad;
	}
	public void setEspecialidad(int especialidad) 
	{
		this.especialidad = especialidad;
	}
	
	
}
