//este programa calcula el importe final de un prestamo
//materia:fundamentos de programacion unidad 3
//28/10/2015
//Abel Robles Montoya
//datos de entrada: la cantidad del prestamo y los intereses
//datos de salida: el importe final
import java.util.Scanner;
public class veintisiete {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
double p,n,i,t;
System.out.println("ingrese la cantidad del prestamo");
p=leer.nextDouble();
System.out.println("ingrese los años");
n=leer.nextDouble();
System.out.println("ingrese el interes en %");
i=leer.nextDouble();
t=p*Math.pow(1+i,n);
System.out.println("el importe final es de "+t+" pesos");
}
}