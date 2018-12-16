//este programa lee un numero entero 
//y determina si es primo
import java.util.Scanner;
public class e3 {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
int num=0;
int div=0;
System.out.println("escribe un numero");
num=leer.nextInt();
for (int i=1;i<=num;i++) 
if (num%i==0)
div++;
if (div==2)
System.out.println("el numero "+num+" es primo");
else
System.out.println("el numero "+num+" no es primo");
}
}
