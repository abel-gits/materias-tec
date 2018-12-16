//este programa covierte grados celcius en fahrenheit
//materia:fundamentos de programacion unidad 3
//26/10/2015
//Abel Robles Montoya
//datos de entrada: grados celcius
//datos de salida: grados fahrenheit
import java.util.Scanner;
public class beinte {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
System.out.println("ingrese la temperatura en grados celcius");
double a,b;
a=leer.nextDouble();
b=(1.8)*a+32;
System.out.println("son "+b+" grados Fahrenheit");
}
}