//este algoritmo lee un numero e imprime si el resultado es malo,
//regular,bueno,exelente
import java.util.Scanner;
public class Diez {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
int a;
System.out.println("ingrese un numero");
a=leer.nextInt();
if ((a>=0)&(a<=5))
System.out.println("malo");
else 
if ((a>=6)&(a<=7))
System.out.println("regular");
else 
if ((a>=8)&(a<=9))
System.out.println("bueno");
else
if (a==10)
System.out.println("exelente");
else
if ((a<0)||(a>10))
System.out.println("error");
}
}