//este programa calcula la velocidad de un proyectil 
//materia:fundamentos de programacion unidad 3
//27/10/2015
//Abel Robles Montoya
//datos de entrada: la distancia y la velocidad
//datos de salida: la velocidad
import java.util.Scanner;
public class veinticuatro {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
double v,d,m,s;
System.out.println("ingrese la distancia en kilometros");
d=leer.nextDouble();
System.out.println("ingrese la velocidad en minutos");
v=leer.nextDouble();
m=d*1000;
s=v*60;
System.out.println("la velocidad es de "+m/s);
}
}
