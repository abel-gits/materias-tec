//este programa lee datos en pies y los transforma en centimetros metros pies y yardas
//materia:fundamentos de programacion unidad 3
//26/10/2015
//Abel Robles Montoya
//datos de entrada: datos en pies
//datos de salida: datos en centimetros metros pies y yardas
import java.util.Scanner;
public class veintidos {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
double p,c,m,y;
System.out.println("ingrese los datos en pies");
p=leer.nextDouble();
c=p*12*2.54;
m=c/100;
y=p*3;
System.out.println("son "+c+" centimetros "+m+" metros "+y+" yardas");
}
}
