//este programa determina el area de rectangulo 
//materia:fundamentos de programacion unidad 3
//25/10/2015
//Abel Robles Montoya
//datos de entrada: base, altura
//datos de salida: el area del triangulo
import java.util.Scanner;
public class ocho {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
int lado1,lado2,area;
System.out.println("ingrese el lado uno y dos");
lado1=leer.nextInt();
lado2=leer.nextInt();
area=lado1*lado2;
System.out.println("area= "+area);
}
}
