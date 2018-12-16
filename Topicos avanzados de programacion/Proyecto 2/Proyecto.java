import java.util.*;
class Proyecto{
	public static void main(String []args){
		Scanner leer = new Scanner(System.in);
		System.out.print("Escribe el tutulo:");
		String titulo=leer.next();
		Consola.limpiarPantalla();
		Consola.cambiarTitulo(titulo);
		int color=1;
		Consola.cambiarColor(color);
		System.out.print("Nombre de los integrantes:");
		Consola.posicionarCursor( 2, 26 );
		color=2;
		Consola.cambiarColor(color);		
		System.out.print("Abel ");
		color=3;
		Consola.cambiarColor(color);
		Consola.posicionarCursor( 5, 32 );
		System.out.print("Robles ");
		color=4;
		Consola.cambiarColor(color);
		Consola.posicionarCursor( 8, 39 );
		System.out.print("Montoya");
		Consola.posicionarCursor( 11, 46 );
		color=9;
		Consola.cambiarColor(color);
		System.out.print(",");
		color=5;
		Consola.cambiarColor(color);
		Consola.posicionarCursor( 14, 47 );
		System.out.print("Carlos ");
		color=6;
		Consola.cambiarColor(color);
		Consola.posicionarCursor( 17, 55 );
		System.out.print("Ignacio ");
		color=7;
		Consola.cambiarColor(color);
		Consola.posicionarCursor( 20, 64 );
		System.out.print("Rios ");
		color=8;
		Consola.cambiarColor(color);
		Consola.posicionarCursor( 23, 70 );
		System.out.print("Madrid");
		Consola.posicionarCursor( 26, 62 );
		color=9;
		Consola.cambiarColor(color);
		System.out.print("Horario:");
		Consola.posicionarCursor( 29, 59 );
		color=1;
		Consola.cambiarColor(color);
		System.out.print("8-9");
		Consola.posicionarCursor( 32,1 );
		System.out.print("Escribe exit para salir");
		String g=" ";
		do{
	 		g=leer.next();
		}while(!(g.equals("exit")));	    
		

		
		
	}


}