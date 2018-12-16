public class Articulo {
	private String descripcion;
	private int cantidad;
	private int precio;

	public void Articulo (String d, int c, int p) { 
		descripcion=d;
		cantidad=c; 
		precio=p; 
	}
	

		public String getDescripcion(){
		return descripcion;
	}
		public void setDescripcion(String descripcion) {
			this.Descripcion=descripcion;
		}
	
	public int getCantidad(){
		return cantidad;
	}
		public void setCantidad(int cantidad) {
			this.Cantidad=cantidad;
	}
	public String getPrecio(){
		return precio;
	}
		public void  setPrecio(int precio) {
			Precio=precio;
		}

	
}