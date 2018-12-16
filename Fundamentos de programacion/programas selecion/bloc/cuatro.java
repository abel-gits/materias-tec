//este programa lee dos numeros y si son diferentes de 0 
//calcula el residuo de su division
import java.util.Scanner;
public class Cuatro {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
int Dividendo,divisor;
System.out.println("escriba dos numeros");
Dividendo=leer.nextInt();
divisor=leer.nextInt();
 int r=Dividendo%divisor;
if (Dividendo==0||divisor==0)
System.out.println("error");
else 
if (Dividendo!=0&divisor!=0) 
System.out.println("el residuo es "+r);
}
}
 