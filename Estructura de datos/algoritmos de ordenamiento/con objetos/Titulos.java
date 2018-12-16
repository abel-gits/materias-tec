package prueba;

public class Titulos 
{
	public String Titulo;
	
	public String Autor;
	
	public String Precio;
	public Titulos() {
	}

	public Titulos(String titulo, String autor, String precio) {
		Titulo = titulo;
		Autor = autor;
		Precio = precio;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public String getPrecio() {
		return Precio;
	}

	public void setPrecio(String precio) {
		Precio = precio;
	}
	
	
	

	
}
