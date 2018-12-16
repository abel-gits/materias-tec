package Archivos;
import java.io.Serializable;
public class Autos implements Serializable {
	protected String Marca;
	protected String Modelo;
	protected String Color;
	protected int Precio;
	public Autos(){}
	public Autos(String marca,String modelo,String color,int precio){
		Marca=marca;
		Modelo=modelo;
		Color=color;
		Precio=precio;
		
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public int getPrecio() {
		return Precio;
	}
	public void setPrecio(int precio) {
		Precio = precio;
	}

}
