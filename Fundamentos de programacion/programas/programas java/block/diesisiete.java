//este programa covierte dias a segundos
//materia:fundamentos de programacion unidad 3
//26/10/2015
//Abel Robles Montoya
//datos de entrada: los dias
//datos de salida: los segundos
import java.util.Scanner;
public class diesisiete {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
int a,b;
System.out.println("ingrese el numero de dias");
a=leer.nextInt();
b=a*24*60*60;
System.out.println(a+" dias son "+b+" segundos");
}
} 