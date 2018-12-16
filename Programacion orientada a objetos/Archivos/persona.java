package Archivos;

import java.io.Serializable;

public class Persona implements Serializable
{
	protected String nombre;
	protected int edad;
	protected String sexo;
	
	public persona()
	{ }
		
	public persona(String nombre,int edad, String sex) 
	{
		this.edad = edad;
		this.nombre = nombre;
		sexo=sex;
	}
	
	public String getSexo() 
	{
		return sexo;
	}

	public void setSexo(String sexo) 
	{
		this.sexo = sexo;
	}

	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	public int getEdad() 
	{
		return edad;
	}
	public void setEdad(int edad) 
	{
		this.edad = edad;
	}
	public void quienSoy()
	{
		System.out.println("Soy "+nombre+" y tengo "+edad+" Años");
	}
	
	
}


