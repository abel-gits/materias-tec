//este programa lee el numero de horas y lo convierte en minutos y segundos
//materia:fundamentos de programacion unidad 3
//25/10/2015
//Abel Robles Montoya
//datos de entrada: la hora
//datos de salida: la conversion en minutos y segundos
import java.util.Scanner;
public class trese {
public static void main(String[]args) {
Scanner leer =new Scanner(System.in);
int a,b,c;
System.out.println("ingrese el numero de horas");
a=leer.nextInt();
b=a*60;
c=a*3600;
System.out.println(a+" horas son: "+b+" minutos");
System.out.println(a+" horas son: "+c+" segundos");
}
}