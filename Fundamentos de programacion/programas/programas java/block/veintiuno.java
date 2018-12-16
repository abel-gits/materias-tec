//este programa convierte dolares a pesos
//materia:fundamentos de programacion unidad 3
//26/10/2015
//Abel Robles Montoya
//datos de entrada: dolares, unidades
//datos de salida: pesos
import java.util.Scanner;
public class veintiuno {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
Double d,u,t;
System.out.println("ingrese la cantidad de dolares");
d = leer.nextDouble();
System.out.println("ingrese la unidad cambiaria");
u=leer.nextDouble();
t=d*u;
System.out.println("son "+t+" dolares");
}
}
