public class Consola
{
	public native static void limpiarPantalla();
	public native static void posicionarCursor( int renglon, int columna );
	public native static void cambiarTitulo(String titulo);
	public native static void cambiarColor(int x);
	static
	{
		System.loadLibrary("Consola");
	}
}
