public class ProbarConsola
{
	public static void main( String[] args )
	{
		Consola.limpiarPantalla();
		Consola.posicionarCursor( 10, 20 );
		System.out.print( "Estoy en el renglon 10 y columna 20" );
	}
}