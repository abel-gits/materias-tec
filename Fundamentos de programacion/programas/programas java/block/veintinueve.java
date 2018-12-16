//este programa calcula el precio final de un producto
//materia:fundamentos de programacion unidad 3
//29/10/2015
//Abel Robles Montoya
//datos de entrada: precio original y descuento
//datos de salida: precio final
import java.util.Scanner;
public class veintinueve {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
double x,y,z;
System.out.println("ingrese el precio original");
x=leer.nextDouble();
System.out.println("ingrese el descuento en %");
y=leer.nextDouble();
z=x-((y/100)*x);
System.out.println("el precio final es "+z);
}
}