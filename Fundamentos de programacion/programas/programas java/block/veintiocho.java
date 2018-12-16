//este programa calcula el total de un prestamo
//materia:fundamentos de programacion unidad 3
//28/10/2015
//Abel Robles Montoya
//datos de entrada: credito, anualidad,la tasa de interes
//datos de salida: pago anual, monto total
import java.util.Scanner;
public class veintiocho {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
double p,n,i,pa,ti;
System.out.println("ingrese el credito en pesos");
p=leer.nextDouble();
System.out.println("ingrese la anualidad");
n=leer.nextDouble();
System.out.println("ingrese la tasa de interes anual");
i=leer.nextDouble();
pa=p*i*Math.pow(1+i,n)/Math.pow(1+i,n)+1;
ti=n*pa-p;
System.out.println("el pago anual es "+pa);
System.out.println("el monto total es "+ti);
}
}