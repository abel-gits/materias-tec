public class Consola
{
	public native static void limpiarPantalla();
	public native static void posicionarCursor( int renglon, int columna );
	public native static void cambiarTitulo(String titulo);
	static
	{
		System.loadLibrary("Consola");
	}
}
