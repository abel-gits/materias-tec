//este programa determina la suma y el promedio de tres numeros
//materia:fundamentos de programacion unidad 3
//25/10/2015
//Abel Robles Montoya
//datos de entrada: tres numeros
//datos de salida: la suma y el promedio
import java.util.Scanner;
public class siete {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
System.out.println("ingrese tres numeros");
int num1,num2,num3,promedio,suma;
num1=leer.nextInt();
num2=leer.nextInt();
num3=leer.nextInt();
suma=num1+num2+num3;
promedio=suma/3;
System.out.println("suma= "+suma+" promedio= "+promedio);
}
}