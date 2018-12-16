//este programa convierte horas y minutos a minutos
//materia:fundamentos de programacion unidad 3
//25/10/2015
//Abel Robles Montoya
//datos de entrada: horas y minutos
//datos de salida: minutos
import java.util.Scanner;
public class quince {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
int a,b,c;
System.out.println("ingrese las horas");
a=leer.nextInt();
System.out.println("ingrese los minutos");
b=leer.nextInt();
c=a*60+b;
System.out.println(a+" horas y "+b+" minutos son: "+c+" minutos");
}
}
