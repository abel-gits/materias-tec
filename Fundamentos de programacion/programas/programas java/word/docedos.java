//este programa lee dos numeros e intercambia sus valores
//materia:fundamentos de programacion unidad 3
//25/10/2015
//Abel Robles Montoya
//datos de entrada: dos numeros 
//datos de salida: los valores de los numeros intercambiados
import java.util.Scanner;
public class docedos {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
int a,b,x;
System.out.println("ingresa el valor de a");
a=leer.nextInt();
System.out.println("ingresa el valor de b");
b=leer.nextInt();
x=b;
b=a;
a=x;
System.out.println("a= "+a+" b= "+b);
}
}