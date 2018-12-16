//este programa lee un numero e imprime el doble 
//materia:fundamentos de programacion unidad 3
//25/10/2015
//Abel Robles Montoya
//datos de entrada: un numero
//datos de salida:el doble del numero
import java.util.Scanner;
public class tres {
public static void main(String[]args) {
System.out.println("ingrese un numero");
Scanner leer = new Scanner(System.in);
int num,doble;
num=leer.nextInt();
doble=num*2;
System.out.println(doble);
}
}
