//este programa determina el area de un triangulo
//materia:fundamentos de programacion unidad 3
//25/10/2015
//Abel Robles Montoya
//datos de entrada: base y altura
//datos de salida: el area
import java.util.Scanner;
public class nueve {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
int base,altura,area;
System.out.println("ingrese la base y la altura");
base=leer.nextInt();
altura=leer.nextInt();
area=base*altura/2;
System.out.println("area= "+area);
}
}