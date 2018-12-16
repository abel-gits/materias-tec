//este programa imprime la tabla de multriplicar de un numero
import java.util.Scanner;
public class Dos {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
int a=leer.nextInt();
for (int i=1;i<=10;i++)
System.out.println(a+" * "+i+ "= "+a*i);
}
}