//este programa lee dos numeros y los imprime de menor a mayor
import java.util.Scanner;
public class Dos {
public static void main(String[]args) {
Scanner leer =new Scanner(System.in);
int a,b;
System.out.println("ingrese dos numeros");
a=leer.nextInt();
b=leer.nextInt();
if (a==b) 
System.out.println("error");
else 
if (a<b) 
System.out.println(a+" "+b);
else 
if (b<a) 
System.out.println(b+" "+a);

}
}