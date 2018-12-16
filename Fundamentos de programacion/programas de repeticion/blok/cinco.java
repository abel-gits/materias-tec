//este programa lee 50 numeros e imprime cuales
//de ellos son pares
import java.util.Scanner;
public class cinco {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
System.out.println("escribe 50 numeros");
for (int i=1;i<=50;i++) { 
int a=leer.nextInt();
if (a%2==0) 
System.out.println("el numero "+a+ " es par");
}
}
}
